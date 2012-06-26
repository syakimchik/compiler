grammar MyStrLang;

options{
	  language = Java;
    output=template;
}

@header
{
    package grammar;
    import java.io.*;
    import namestable.*;
    import org.antlr.stringtemplate.StringTemplateGroup;
    import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;
    import java.io.UnsupportedEncodingException;
}

@lexer::header
{
    package grammar;
}

@members{
    /** name of file */
		private static String programName = "";
		/** counter of variables */
		private int counter;
		/** counter of label for contlor structure */
		private int labelCounter;
		/** name of function*/
		private String _funcName = "";
		/** type of function */
		private String _funcType = "";
		
		/** NamesTable contains declaration variables, functions and delegations */
		protected NamesTable names = new NamesTable();
		/** list of errors */
		protected ArrayList<String> errors = new ArrayList<String>();
		
		public static StringTemplateGroup templateGroup;
		/** path to file, where contain template */
		public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";	//testing line
		//public static final String templateFileName = "template/ByteCode.stg";	//line for jar file
		
		/**
		* @param args of command line
		*/
		public static void main(String[] args) throws Exception {
			templateGroup = new StringTemplateGroup(new FileReader(templateFileName), AngleBracketTemplateLexer.class);
			/** error checking of input file */
			if(args.length != 1)
			{
				System.out.println("Argument error. Please specify input file name");
				return;
			}
			
			String codeFile = args[0];
			if(codeFile.lastIndexOf(".")<0)
			{
				System.out.println("Error in file name. Please input valid file name");
				return;
			}

			programName = codeFile.substring(0, codeFile.lastIndexOf("."));

			try{
				MyStrLangLexer lexer = new MyStrLangLexer(new ANTLRFileStream(codeFile));
				MyStrLangParser parser = new MyStrLangParser(new CommonTokenStream(lexer));
				parser.setTemplateLib(templateGroup);
				RuleReturnScope returnScope = parser.program();
				if(!parser.errors.isEmpty())
				{
					System.out.println("Found "+parser.errors.size()+" errors:");
					for(String m: parser.errors)
						System.out.println(m);
					System.out.println("Compiled not successfully");
				}
				else
				{
					System.out.println("Compiled successfully");
					FileWriter out = new FileWriter(programName + ".j");
					out.write(returnScope.getTemplate().toString());
					out.close();
				}
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File not found. Please input valid file name.");
			}
		}

		public String getErrorHeader(RecognitionException e)
		{
			return "line "+e.line+":";
		}
		
		public void emitErrorMessage(String msg)
		{
			errors.add(msg);
		}
}

/** beginning rule for parsing grammar */
program
scope{
	String curBlock;               /** variable to store the name of current block*/
	List global_variables;         /** list of globals variables */
	List functions;                /** list of function */
}
@init{
	$program::curBlock = "";
	$program::global_variables = new ArrayList();
	$program::functions = new ArrayList();
	counter = 0;
}
	:	global_variables* (functions {$program::functions.add($functions.st);})* 
	  (delegates {$program::functions.add($delegates.st);})*
	  {$program::curBlock="main";} mainBlock EOF
		-> program(global_variables={$program::global_variables}, functions={$program::functions}, program={$mainBlock.st}, programName={programName})
	;

/** rule describes main block */	
mainBlock
@init{
	//counter = 0;
	labelCounter = 0;
}
	:	'main' '{' block '}'
		-> mainBlock(block={$block.stList})
	;

/*
* rule describes global variables
* global variables are added to the names table 
*/	
global_variables
	:	{ $program::curBlock = "global";} (global_declaration {$program::global_variables.add($global_declaration.st);})* ';'
	;

/*
* description global variables
*/	
global_declaration
	:	type ID
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName var = names.new VariableName($program::curBlock+"."+$ID.text, $type.text, $ID.line);
			var.setNumber(counter);
			names.addVariable(var);
			counter++;
		}
		else
		{
			if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
				errors.add("line "+$ID.line+": Duplicate variable name "+$ID.text);
		}
	}
	
	-> global_declaration(ident={$ID.text}, type={$type.st})
	;

/*
* rule describes functions
* functions are added to the names table
*/	
functions
scope{
	String funcName;
	String funcType;
	ArrayList<String> funcArgNames;
	ArrayList<String> funcArgTypes;
	String returnVariable;
	boolean isReturnUsed;
}
@init{
	$functions::funcName = "";
	$functions::funcType = "";
	$functions::funcArgNames = new ArrayList<String>();
	$functions::funcArgTypes = new ArrayList<String>();
	labelCounter = 0;
	//counter=0;
}
	:	type_func {$functions::funcType = $type_func.text; _funcType = $type_func.text; } 
		ID {$program::curBlock = $ID.text; $functions::funcName=$ID.text; _funcName = $ID.text;}
	'(' arg_list ')'
	//if fuction is not exists in nametable then add her, else we add her in list errors
	{
		if(!names.isExistFunction($ID.text))
		{
			names.addFunction(names.new FunctionName($ID.text, $type_func.text, $functions::funcArgTypes, $functions::funcArgNames, $ID.line));
		}
		else
		{
			errors.add("line "+$ID.line+": Duplicated declaration function "+$ID.text);
		}
	}
	'{' 
		block
	'}'
	-> functions(type={$type_func.st}, ident={$ID.text}, args={$arg_list.stList}, returnType={$type_func.returnType}, block={$block.stList})
	;

/*
* rule describes argument list of functions
* all arguments are added to names table and visible within function 
*/
arg_list returns[List<StringTemplate> stList]
@init{
	$stList = new ArrayList<StringTemplate>();
}
	:	(
		firstType=type firstId=ID
		{
			$functions::funcArgTypes.add($firstType.text);
			$functions::funcArgNames.add($firstId.text);
			if(!names.isDeclaredVariable($program::curBlock+"."+$firstId.text))
			{
				NamesTable.VariableName var = names.new VariableName($program::curBlock+"."+$firstId.text, $firstType.text, $firstId.line);
				var.setNumber(counter);
				names.addVariable(var);
				$stList.add(%parameter(type={$firstType.st}, ident={$firstId.text}));
				counter++;
			}
			else
			{
				errors.add("line "+$firstId.line+": Duplicated variable name "+$firstId.text);
			}
		}
 		(',' secondType=type secondId=ID
 		{
 			$functions::funcArgTypes.add($secondType.text);
			$functions::funcArgNames.add($secondId.text);
			if(!names.isDeclaredVariable($program::curBlock+"."+$secondId.text))
			{
				NamesTable.VariableName var = names.new VariableName($program::curBlock+"."+$secondId.text, $secondType.text, $secondId.line);
				var.setNumber(counter); 
				names.addVariable(var);
				counter++;
				$stList.add(%parameter(type={$secondType.st}, ident={$secondId.text}));
			}
			else
			{
				errors.add("line "+$secondId.line+": Duplicated variable name "+$secondId.text);
			}
		}
 		)* 
 		)?
	;

/*
* rule describes delegates
* rule contain declaration and determination delegates
*/
delegates
scope{
  String delName;
  String delType;
  ArrayList<String> delArgNames;
  ArrayList<String> delArgTypes;
  String returnVariable;
  boolean isReturnUsed;
}
@init{
  $delegates::delName = "";
  $delegates::delType = "";
  $delegates::delArgNames = new ArrayList<String>();
  $delegates::delArgTypes = new ArrayList<String>();
  labelCounter = 0;
}
	:	'delegate' nameDelegate=ID '{'  type_func {$delegates::delType = $type_func.text; _funcType = $type_func.text; } 
	                   nameFunc=ID {$program::curBlock = $nameDelegate.text; $delegates::delName=$nameFunc.text; }
	  '(' {$program::curBlock=$nameDelegate.text;} arg_del ')' ';'
	  //if delegate is not exists in nametable then add her
	  {
	    if(!names.isExistDelegate($nameDelegate.text))
	    {
	      names.addDelegate(names.new DelegateName($nameDelegate.text, $nameDelegate.text+$nameFunc.text, $type_func.text, $delegates::delArgTypes, $delegates::delArgNames, $nameDelegate.line));
	      names.addFunction(names.new FunctionName($nameDelegate.text+$nameFunc.text, $type_func.text, $delegates::delArgTypes, $delegates::delArgNames, $nameDelegate.line));
	    }
	    else
	    {
	      errors.add("line "+$nameDelegate.line+": Duplicated declaration delegate "+$nameDelegate.text);
	    }
	  }
	  '}'
	;

/*
* rule describes argument list of delegate functions
* all arguments are added to names table and visible within delegate function 
*/	
arg_del returns[List<StringTemplate> stList]
@init{
  $stList = new ArrayList<StringTemplate>();
}
  : (
    firstType=type firstId=ID
    {
      $delegates::delArgTypes.add($firstType.text);
      $delegates::delArgNames.add($firstId.text);
      if(!names.isDeclaredVariable($program::curBlock+"."+$firstId.text))
      {
        NamesTable.VariableName var = names.new VariableName($program::curBlock+"."+$firstId.text, $firstType.text, $firstId.line);
        var.setNumber(counter);
        names.addVariable(var);
        $stList.add(%parameter(type={$firstType.st}, ident={$firstId.text}));
        counter++;
      }
      else
      {
        errors.add("line "+$firstId.line+": Duplicated variable name "+$firstId.text);
      }
    }
    (',' secondType=type secondId=ID
    {
      $delegates::delArgTypes.add($secondType.text);
      $delegates::delArgNames.add($secondId.text);
      if(!names.isDeclaredVariable($program::curBlock+"."+$secondId.text))
      {
        NamesTable.VariableName var = names.new VariableName($program::curBlock+"."+$secondId.text, $secondType.text, $secondId.line);
        var.setNumber(counter); 
        names.addVariable(var);
        counter++;
        $stList.add(%parameter(type={$secondType.st}, ident={$secondId.text}));
      }
      else
      {
        errors.add("line "+$secondId.line+": Duplicated variable name "+$secondId.text);
      }
    }
    )* 
    )?
  ;
  

/*
* rule describes content of functions
*/	
block returns[List<StringTemplate> stList, String type]
@init{
	$stList = new ArrayList<StringTemplate>();
	$type = "void";
}
	:	(statements {$stList.add($statements.st);})* (return_stmt {$stList.add($return_stmt.st); $type=$return_stmt.type;})
	{		
			if($program::curBlock!="main"){
			  String name = $program::curBlock;
			  if(names.isExistFunction(name)){
					NamesTable.FunctionName func = names.getFunction(name);
					String _type = func.getReturnType();
					if($return_stmt.value==null)
					{
						if(!_type.equals("void"))
							errors.add("line "+$return_stmt.line+": Not found the keyword return in function with name "+name);
					}
				}
		}
	}
	;

/*
* rule describes elements of functions
*/	
statements
	:	 assign_stmt ';' -> {$assign_stmt.st}
	|	 decl_stmt ';' -> {$decl_stmt.st}
	|	 write_stmt ';' -> {$write_stmt.st}
	|	 read_strm ';' -> {$read_strm.st}
	|	 if_stmt -> {$if_stmt.st}
	|	 for_stmt -> {$for_stmt.st}
	|	 while_stmt -> {$while_stmt.st}
	|  call_func_stmt ';' -> {$call_func_stmt.st}    
	|  call_delegate ';'           -> {$call_delegate.st}
	;

/*
* rule describes assignment operation
*/	
assign_stmt
	:	ID '=' (expr
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName var_type = names.getVariable($program::curBlock+"."+$ID.text);
			//get type of variable
			String varType = var_type.getType();
			//check for match types
			if(!TypesChecker.checkTypes(varType, $expr.type))
			{
				  errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+varType+" to "+$expr.type);
			}
			if(TypesChecker.isInteger(varType))
			{
				if(names.isGlobal($ID.text)){
					$st = %assign_field_int(expression={$expr.st}, programName={programName}, fieldName={$ID.text});
				} 
				else{
					$st = %assign_var_int(expression={$expr.st}, counter={var_type.getNumber()});
				}
			}
			if(TypesChecker.isString(varType))
			{
				if(names.isGlobal($ID.text)){
					$st = %assign_field_string(expression={$expr.st}, programName={programName}, fieldName={$ID.text});
				} 
				else{
					$st = %assign_var_string(expression={$expr.st}, counter={var_type.getNumber()});
				}
			}
			if(TypesChecker.isChar(varType))
			{
				if(names.isGlobal($ID.text)){
					$st = %assign_field_char(expression={$expr.st}, programName={programName}, fieldName={$ID.text});
				} 
				else{
					$st = %assign_var_char(expression={$expr.st}, counter={var_type.getNumber()});
				}
			}
			
		}
		else{
        errors.add("line "+$ID.line+": unknown variable "+$ID.text);
		}
	}
	| call_delegate
	{
	  NamesTable.VariableName var_type = names.getVariable($program::curBlock+"."+$ID.text);
    String varType = var_type.getType();
    if(!TypesChecker.checkTypes(varType, $call_delegate.type))
      errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+varType+" to "+$call_delegate.type);
    if(TypesChecker.isInteger(varType))
    {
      if(names.isGlobal($ID.text)){
        $st = %assign_field_int(expression={$call_delegate.stList}, programName={programName}, fieldName={$ID.text});
      } 
      else{
        $st = %assign_var_int(expression={$call_delegate.stList}, counter={var_type.getNumber()});
      }
    }
    if(TypesChecker.isString(varType))
    {
      if(names.isGlobal($ID.text)){
        $st = %assign_field_string(expression={$call_delegate.stList}, programName={programName}, fieldName={$ID.text});
      } 
      else{
        $st = %assign_var_string(expression={$call_delegate.stList}, counter={var_type.getNumber()});
      }
    }
    if(TypesChecker.isChar(varType))
    {
      if(names.isGlobal($ID.text)){
        $st = %assign_field_char(expression={$call_delegate.stList}, programName={programName}, fieldName={$ID.text});
      } 
      else{
        $st = %assign_var_char(expression={$call_delegate.stList}, counter={var_type.getNumber()});
      }
    }
	})
	;
	
/*
* rule describes assignment expression
* assigning either a variable or expression
*/
expr returns [String type]
	:	
		firstAssign=mult
		{
			$type = $firstAssign.type;
			$st = $firstAssign.st;
		}
		(
			(op='+'|op='-') secondAssign=expr
			{
				$type = $firstAssign.type;
				String t_1 = $secondAssign.type;
				if(TypesChecker.isChar($secondAssign.type))
				{
					errors.add("line "+$op.line+": impossibly addition type of char to char");
				}
				if(!TypesChecker.checkTypes($firstAssign.type, $secondAssign.type))
				{
					errors.add("line "+$op.line+": mismatch in math operation. Found "+$firstAssign.type+" and "+$secondAssign.type);
				}
				if($op.text.equals("+"))
		 		{
				 	if(TypesChecker.isInteger($firstAssign.type) && TypesChecker.isInteger($secondAssign.type)){
				 		$st = %add_int(firstValue={$firstAssign.st}, secondValue={$secondAssign.st});
				 	}
				 	if(TypesChecker.isString($firstAssign.type) && TypesChecker.isString($secondAssign.type)){
				 		$st = %add_string(firstValue={$firstAssign.st}, secondValue={$secondAssign.st});
				 	}
		 		}
		 		if($op.text.equals("-")){
		 			if(TypesChecker.isInteger($firstAssign.type) && TypesChecker.isInteger($secondAssign.type)){
		 				$st = %sub_int(firstValue={$firstAssign.st}, secondValue={$secondAssign.st});
		 			}
		 			if(TypesChecker.isString($firstAssign.type) && TypesChecker.isString($secondAssign.type)){
				 		errors.add("line "+$op.line+": operation '-' is not available in type string");
				 	}
		 		}
					
			}
		)?
	
	;

/*
* rule describes composition or division
*/	
mult returns[String type]
  :   first=power {$type=$first.type; $st = $first.st;} 
      ((op='*'| op='/') second=mult
        {
          $type = $first.type;
	        String t_1 = $second.type;
	        if(TypesChecker.isChar($second.type))
	        {
	          errors.add("line "+$op.line+": this operation is not available for type char");
	        }
	        if(TypesChecker.isString($second.type))
          {
            errors.add("line "+$op.line+": this operation is not available for type string");
          }
	        if(!TypesChecker.checkTypes($first.type, $second.type))
	        {
	          errors.add("line "+$op.line+": mismatch in math operation. Found "+$first.type+" and "+$second.type);
	        }
	        if($op.text.equals("*"))
	        {
	          if(TypesChecker.isInteger($first.type) && TypesChecker.isInteger($second.type)){
	            $st = %condition_int(firstValue={$first.st}, secondValue={$second.st});
	          }
	        }
	        if($op.text.equals("/")){
	          if(TypesChecker.isInteger($first.type) && TypesChecker.isInteger($second.type)){
	            $st = %division_int(firstValue={$first.st}, secondValue={$second.st});
	          }
	        }
        }
      )?
  ;
  
/*
* rule describes involution
*/
power returns[String type]
  :   first=cast_stmt {$type=$first.type; $st =$first.st;}
      (op='^' second=power
      {
        $type = $first.type;
          String t_1 = $second.type;
          if(TypesChecker.isChar($second.type))
          {
            errors.add("line "+$op.line+": this operation is not available for type char");
          }
          if(TypesChecker.isString($second.type))
          {
            errors.add("line "+$op.line+": this operation is not available for type string");
          }
          if(!TypesChecker.checkTypes($first.type, $second.type))
          {
            errors.add("line "+$op.line+": mismatch in math operation. Found "+$first.type+" and "+$second.type);
          }
          if($op.text.equals("^")){
            if(TypesChecker.isInteger($first.type) && TypesChecker.isInteger($second.type)){
              $st = %power_int(firstValue={$first.st}, secondValue={$second.st});
            }
          }
      }
      )?
  ;
  
cast_stmt returns[String type]
  :   atom  {$type = $atom.type; $st = $atom.st;}
  ;
  
/*
* rule describes declaration local variables
* local variable are added to names table depending on current function
* when your declaration variable can perform assignment operation expression or delegate
*/	
decl_stmt
	:	type ID
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName var = names.new VariableName($program::curBlock+"."+$ID.text, $type.text, $ID.line);
			var.setNumber(counter);
			names.addVariable(var);
			counter++;
		}
		else
		{
			if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
				errors.add("line "+$ID.line+": Duplicated variable name "+$ID.text);
		}
		
		if(TypesChecker.isInteger($type.text))
		{
			$st = %declaration_int(counter={counter});
		}
		if(TypesChecker.isString($type.text))
		{
			$st = %declaration_string(counter={counter});
		}
		
		if(TypesChecker.isChar($type.text))
		{
			$st = %declaration_char(counter={counter});
		}
		
	}
	('=' (expr
	{
		NamesTable.VariableName var_type = names.getVariable($program::curBlock+"."+$ID.text);
		String varType = var_type.getType();
		if(!TypesChecker.checkTypes(varType, $expr.type))
		{
			errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+varType+" to "+$expr.type);
		}
		if(TypesChecker.isInteger(varType))
		{
			if(names.isGlobal($ID.text)){
				$st = %assign_field_int(expression={$expr.st}, programName={programName}, fieldName={$ID.text});
			} 
			else{
				$st = %assign_var_int(expression={$expr.st}, counter={var_type.getNumber()});
			}
		}
		if(TypesChecker.isString(varType))
		{
			if(names.isGlobal($ID.text)){
				$st = %assign_field_string(expression={$expr.st}, programName={programName}, fieldName={$ID.text});
			} 
			else{
				$st = %assign_var_string(expression={$expr.st}, counter={var_type.getNumber()});
			}
		}
		if(TypesChecker.isChar(varType))
		{
			if(names.isGlobal($ID.text)){
				$st = %assign_field_char(expression={$expr.st}, programName={programName}, fieldName={$ID.text});
			} 
			else{
				$st = %assign_var_char(expression={$expr.st}, counter={var_type.getNumber()});
			}
		}
			
	}
	| call_delegate
	{
	  NamesTable.VariableName var_type = names.getVariable($program::curBlock+"."+$ID.text);
    String varType = var_type.getType();
	  if(!TypesChecker.checkTypes($type.text, $call_delegate.type))
	    errors.add("line "+$ID.line+" : Type mismatch: cannot convert from "+$type.text+" to "+$call_delegate.type);
	  if(TypesChecker.isInteger(varType))
    {
      if(names.isGlobal($ID.text)){
        $st = %assign_field_int(expression={$call_delegate.stList}, programName={programName}, fieldName={$ID.text});
      } 
      else{
        $st = %assign_var_int(expression={$call_delegate.stList}, counter={var_type.getNumber()});
      }
    }
    if(TypesChecker.isString(varType))
    {
      if(names.isGlobal($ID.text)){
        $st = %assign_field_string(expression={$call_delegate.stList}, programName={programName}, fieldName={$ID.text});
      } 
      else{
        $st = %assign_var_string(expression={$call_delegate.stList}, counter={var_type.getNumber()});
      }
    }
    if(TypesChecker.isChar(varType))
    {
      if(names.isGlobal($ID.text)){
        $st = %assign_field_char(expression={$call_delegate.stList}, programName={programName}, fieldName={$ID.text});
      } 
      else{
        $st = %assign_var_char(expression={$call_delegate.stList}, counter={var_type.getNumber()});
      }
    }
	}
	))?
	;

/** rule describes print variable in screen */	
write_stmt
	:	'write' '(' atom ')' 
	{
		if(TypesChecker.isInteger($atom.type))
		{
			$st = %write_int(expression={$atom.st});
		}
		if(TypesChecker.isString($atom.type))
		{
			$st = %write_string(string={$atom.st});
		}
		if(TypesChecker.isChar($atom.type))
		{
			$st = %write_char(string={$atom.st});
		}
	}
	;

/*
* rule describes elements, which you can use in different rules
*/	
atom returns[String text, String type]
	:	ID {
		$text = $ID.text;
		//System.out.println($program::curBlock);
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName v_type = names.getVariable($program::curBlock+"."+$ID.text);
			$type = v_type.getType();
			if(TypesChecker.isInteger($type))
			{
				if(names.isGlobal($text))
				{
					$st = %referenceField_int(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_int(counter={v_type.getNumber()});
				}
			}
			
			if(TypesChecker.isString($type))
			{
				if(names.isGlobal($text))
				{
					$st = %referenceField_string(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_string(counter={v_type.getNumber()});
				}
			}
			
			if(TypesChecker.isChar($type))
			{
				if(names.isGlobal($text))
				{
					$st = %referenceField_char(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_char(counter={v_type.getNumber()});
				}
			}
			
		}
		else
		{
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
		}
	}
	|	INT {$text = $INT.text; $type = "int"; 
	  if($text.length()>10)
	    errors.add("line "+$INT.line+": type int is out of range.");
	  else
	  {
		  try{
			  Integer numb = new Integer($text);
			}
			catch(NumberFormatException e)
			{
			  errors.add("line "+$INT.line+": type int is out of range.");
			}
		}
	  }				-> const_int(value={$INT.text})
	|	STRING {$text = $STRING.text; $type = "string";}	-> const_string(value = {$STRING.text})
	|	char_c {$type = "char";}					-> {$char_c.st}
	|	call_func {$type=$call_func.type;}		-> {$call_func.st}
	|	length_stmt{$type="int";}				-> {$length_stmt.st}
	|	elem_stmt{$type="char";}				-> {$elem_stmt.st}
	|	to_string_stmt{$type="string";}			-> {$to_string_stmt.st}
	|	indexOf_stmt{$type="int";}				-> {$indexOf_stmt.st}
	|	replace_op{$type="string";}				-> {$replace_op.st}
	|	replace_firstElem{$type="string";}		-> {$replace_firstElem.st}
	|	substring_op{$type="string";}			-> {$substring_op.st}
	;

/*
* rule describes const char
* converts a character in the cod of computer
*/	
char_c returns[int numb]
	:	CHAR
	{	
			String str = $CHAR.text;
			char el = str.charAt(1);
			try{
				$numb = Character.toString(el).getBytes("cp1251")[0];
			}
			catch(UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
	}
		-> const_char(cod={$numb})
	;
	
/** 
* rule describes read variable from screen
* reads types: string and int
*/	
read_strm
	:	'read' '(' ID ')'
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$ID.text))
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
		else{
			NamesTable.VariableName var_type = names.getVariable($program::curBlock+"."+$ID.text);
			String varType = var_type.getType();
			if(TypesChecker.isInteger(varType))
			{
				if(names.isGlobal($ID.text)){
					$st = %read_field_int(programName={programName}, fieldName={$ID.text});
				} else
					$st = %read_var_int(counter={var_type.getNumber()});
			}
			if(TypesChecker.isString(varType))
			{
				if(names.isGlobal($ID.text)){
					$st = %read_field_string(programName={programName}, fieldName={$ID.text});
				} else
					$st = %read_var_string(counter={var_type.getNumber()});
			}
		}
	}
	;

/*
* rule describes operator if..else
*/	
if_stmt	
	:	'if' '(' expression ')' '{' ifBlock=block '}' ('else' '{' elseBlock=block '}')?
	{
		$st = %if_operation(expression={$expression.st}, ifBlock={$ifBlock.stList}, elseBlock={$elseBlock.stList}, 
							trueLabel={labelCounter}, falseLabel={labelCounter+1});
		labelCounter = labelCounter+2;
	}
	;

/*
* rule describes operator for
*/	
for_stmt
	:	'for' '(' begin=assign_stmt ';' check=expression ';' end=assign_stmt ')' '{' forBlock=block '}'
	{
		$st = %for_operator(beginExpr={$begin.st}, checkExpr={$check.st}, endExpr={$end.st}, 
			forBlock={$forBlock.stList}, firstLabel={labelCounter}, secondLabel={labelCounter+1}, thirdLabel={labelCounter+2});
		labelCounter = labelCounter+3;
	}
	;

/*
* rule describes operator while
*/	
while_stmt
	:	'while' '(' check=expression ')' '{' whileBlock=block '}'
	{
		$st = %while_operator(checkExpr={$check.st}, whileBlock={$whileBlock.stList}, firstLabel={labelCounter}, secondLabel={labelCounter+1}, thirdLabel={labelCounter+2});
		labelCounter = labelCounter+3;
	}
	;

/*
* rule describes return variable
*/	
return_stmt returns[String value, int line, String type]
	:
	(a='return' atom ';' 
	{	
	  $type = $atom.type;
		if($program::curBlock=="main")
			errors.add("line "+$a.line+": function main may not contain keyword return");
		$value = $atom.text;
		$line = $a.line;
		
		try{
			String name = $program::curBlock;
			NamesTable.FunctionName func = names.getFunction(name);
			String type = func.getReturnType();
			
			if(type.equals("void")){
				errors.add("line "+$a.line+": type of void may not contain keyword return");
			}
			
			String rType = $atom.type;
			if(!TypesChecker.checkTypes(type,rType)){
				errors.add("line "+$a.line+": Type mismatch: cannot convert from "+type+" to "+rType);
			}
		}
		catch(NullPointerException e)
		{
		}
	}
	)?
	-> {$atom.st}
	;

/*
* rule describes built-in function length
* function return length of string
*/	
length_stmt
	:	'length' '(' param ')'
	{
		$st = %length_string(string={$param.st});
	}
	;

/** rule describes parametrs of function length */	
param returns[String text, String type]
	:	ID {
		$text = $ID.text;
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName v_type = names.getVariable($program::curBlock+"."+$ID.text);
			$type = v_type.getType();
			if(TypesChecker.isInteger($type))
			{
				if(names.isGlobal($type))
				{
					$st = %referenceField_int(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_int(counter={v_type.getNumber()});
				}
			}
			
			if(TypesChecker.isString($type))
			{
				if(names.isGlobal($text))
				{
					$st = %referenceField_string(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_string(counter={v_type.getNumber()});
				}
			}
			
		}
		else
		{
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
		}
		}
	|	STRING {$text = $STRING.text; $type = "string";}	-> const_string(value = {$STRING.text})
	;

/*
* rule describes built-in function elem
* function return character of string
*/	
elem_stmt
	:	'elem' '('f_el ',' s_el ')'
	{
		$st = %elem_in_string(fValue={$f_el.st}, sValue={$s_el.st});
	}
	;

/** rule describes parametrs of different functions */
f_el
	:	ID
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName v_type = names.getVariable($program::curBlock+"."+$ID.text);
			String type = v_type.getType();
			if(TypesChecker.isString(type))
			{
				if(names.isGlobal($ID.text))
				{
					$st = %referenceField_string(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_string(counter={v_type.getNumber()});
				}
			}
		}
		else
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
	}
	|	STRING		-> const_string(value={$STRING.text})
	;

/** rule describes parametrs of different functions */  	
s_el
	:	ID
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName v_type = names.getVariable($program::curBlock+"."+$ID.text);
			String type = v_type.getType();
			if(TypesChecker.isInteger(type))
			{
				if(names.isGlobal($ID.text))
				{
					$st = %referenceField_int(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_int(counter={v_type.getNumber()});
				}
			}
		}
		else
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
	}
	|	INT		-> const_int(value={$INT.text})
	;

/*
* rule describes built-in function ToString
* function return string
*/	
to_string_stmt
	:	'ToString' '(' param_str ')'
	{
		if(TypesChecker.isInteger($param_str.t)){
			$st = %int_to_string(value={$param_str.st});
		}
		if(TypesChecker.isChar($param_str.t)){
			$st = %char_to_string(value={$param_str.st});
		}
	}
	;

/** rule describes parametrs of function ToString */	
param_str returns[String t]
	:	ID
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName v_type = names.getVariable($program::curBlock+"."+$ID.text);
			String type = v_type.getType();
			$t = type;
			if(TypesChecker.isInteger(type))
			{
				if(names.isGlobal($ID.text))
				{
					$st = %referenceField_int(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_int(counter={v_type.getNumber()});
				}
			}
			
			if(TypesChecker.isChar(type))
			{
				if(names.isGlobal($ID.text))
				{
					$st = %referenceField_char(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_char(counter={v_type.getNumber()});
				}
			}
		}
		else
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
	}
	|	INT	{$t="int";}			-> const_int(value={$INT.text})
	|	char_c {$t="char";}		-> {$char_c.st}
	;
	
call_func_stmt
	:	call_func
		-> {$call_func.st}
	;

/** 
* rule describes call functions 
*/	
call_func returns[String type, int line]
scope{
	String methodName;
}
@init{
	$call_func::methodName = "";
	List<StringTemplate> argTypes = new ArrayList<StringTemplate>();
}
	:	ID{$call_func::methodName=$ID.text;} '(' arg_call ')'
	{
		$line = $ID.line;
		ArrayList<String> list = null;
		if($arg_call.argumentTypeList==null)
			list = new ArrayList<String>();
		else
			list = $arg_call.argumentTypeList;
		if(!names.checkCallFunction($ID.text, list, $ID.line))
		{
			names.getAllErrors(errors);
		}
		if(!names.isExistFunction($ID.text))
		{
			errors.add("line "+$ID.line+": function "+$ID.text+" is not exist");
		}
		else
		{
			NamesTable.FunctionName func = names.getFunction($ID.text);
			$type = func.getReturnType();
		}
		
		for(String arg_type: $arg_call.argumentTypeList)
		{
			if(TypesChecker.isInteger(arg_type))
			{
				argTypes.add(%type_int());
			}
			if(TypesChecker.isString(arg_type))
			{
				argTypes.add(%type_string());
			}
			if(TypesChecker.isChar(arg_type))
			{
				argTypes.add(%type_char());
			}
			  
		}
		
		StringTemplate returnType = new StringTemplate();
		
		if(TypesChecker.isInteger($type))
		{
			returnType = %type_int();
		}
		if(TypesChecker.isString($type))
		{
			returnType = %type_string();
		}
		if(TypesChecker.isChar($type))
		{
			returnType = %type_char();
		}
		if(TypesChecker.isVoid($type))
		{
			returnType = %type_void();
		}
		
		$st = %function_call(programName={programName}, funcName={$ID.text}, argTemplates={$arg_call.stList}, argTypes={argTypes}, returnType={returnType});
	}
	;

/** rule describes arguments of call functions */	
arg_call returns[ArrayList<String> argumentTypeList, List<StringTemplate> stList]
	:
	{
		$argumentTypeList = new ArrayList<String>();
		$stList = new ArrayList<StringTemplate>();
	}	
	(a=atom {$argumentTypeList.add($a.type); $stList.add($a.st);} (',' b=atom {$argumentTypeList.add($b.type); $stList.add($b.st);})*)?
	;

/*
* rule describes terms of control structures
* || - logic operation OR
*/ 	
expression
	:	first=and_expression {$st = $first.st;} ('||'  second=expression
		{
			$st = %logical_or(firstExpr={$first.st}, secondExpr={$second.st}, firstLabel={labelCounter},
								secondLabel={labelCounter+1}, thirdLabel={labelCounter+2});
			labelCounter = labelCounter+3;
		}
	)? 
	;

/*
* rule describes terms of control structures
* && - logic operation AND
*/	
and_expression
	:	first=not_expression {$st = $first.st;} ('&&' second=and_expression
		{
			$st = %logical_and(firstExpr={$first.st}, secondExpr={$second.st}, firstLabel={labelCounter},
								secondLabel={labelCounter+1}, thirdLabel={labelCounter+2});
			labelCounter = labelCounter+3;
		}
	)?
	;

/*
* rule describes terms of control structures
* ! - logic operation NO
*/	
not_expression
	:	'!' first=not_expression
			{
				$st = %logical_not(expression={$first.st}, firstLabel={labelCounter}, secondLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
	|	second=comparison {$st = $second.st;}
	;

/*
* rule describes terms of control structures
* comparison operators
*/
comparison
	:	first=atom op=('<'|'>'|'=='|'!='|'>='|'<=') second=atom
	{
		if(!TypesChecker.checkTypes($first.type, $second.type))
		{
			errors.add("line "+$op.line+": Incompatible types "+$first.type+" and "+$second.type);
		}
		
		if(TypesChecker.isInteger($first.type))
		{
			if($op.text.equals("<")){
				$st = %integer_less(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals(">")){
				$st = %integer_greater(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals("==")){
				$st = %integer_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals("!=")){
				$st = %integer_not_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals("<=")){
				$st = %integer_less_or_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals(">=")){
				$st = %integer_greater_or_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
		}
		
		if(TypesChecker.isChar($first.type))
		{
			if($op.text.equals("<")){
				$st = %char_less(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			
			if($op.text.equals(">")){
				$st = %char_greater(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals("==")){
				$st = %char_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals("!=")){
				$st = %char_not_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals("<=")){
				$st = %char_less_or_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals(">=")){
				$st = %char_greater_or_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
		}
		
		if(TypesChecker.isString($first.type))
		{
			if($op.text.equals("<") || $op.text.equals(">") || $op.text.equals("<=") || $op.text.equals(">=")){
				errors.add("line "+$op.line+": The operator "+$op.text+" for type string not applicable ");
			}
			
			if($op.text.equals("==")){
				$st = %string_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
			if($op.text.equals("!=")){
				$st = %string_not_equal(firstExpression={$first.st}, secondExpression={$second.st}, trueLabel={labelCounter}, falseLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
		}
	}
	|	equal_op		-> {$equal_op.st}
	|	contain_op		-> {$contain_op.st}
	;

/*
* rule describes built-in function equals
* function return bool
*/	
equal_op
	:	'equals' '(' first=f_el ',' second=f_el ')'
	{
		$st = %equal_operation(fValue={$first.st}, sValue={$second.st});
	}
	;

/*
* rule describes built-in function contains
* function return bool
*/  	
contain_op
	:	'contains' '(' first=f_el ',' second=f_el ')'
	{
		$st = %contain_operation(fValue={$first.st}, sValue={$second.st});
	}
	;

/*
* rule describes built-in function indexOf
* function return int
*/  	
indexOf_stmt
	:	'indexOf' '(' first=f_el ',' second=f_el')'
	{
		$st = %indexOf_int(fValue={$first.st}, sValue={$second.st});
	}
	;

/*
* rule describes built-in function replace
* function return string
*/  	
replace_op
	:	'replace' '(' f_el ',' first=char_param ',' second=char_param ')'
	{
		$st = %replace_operation(fValue={$f_el.st}, sValue={$first.st}, thValue={$second.st});
	}
	;
	
char_param
	:	ID
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName v_type = names.getVariable($program::curBlock+"."+$ID.text);
			String type = v_type.getType();
			if(TypesChecker.isChar(type))
			{
				if(names.isGlobal($ID.text))
				{
					$st = %referenceField_char(programName={programName}, fieldName={v_type.getName()});
				}
				else{
					$st = %referenceVariable_char(counter={v_type.getNumber()});
				}
			}
		}
		else
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
	}
	|	char_c		->{$char_c.st}
	;
	
/*
* rule describes built-in function replaceFirst
* function return string
*/  
replace_firstElem
	:	'replaceFirst' '(' first=f_el ',' second=f_el ',' third=f_el ')'
	{
		$st = %replaceFirst_op(fValue={$first.st}, sValue={$second.st}, thValue={$third.st});
	}
	;
	
/*
* rule describes built-in function subString
* function return string
*/  	
substring_op
	:	'subString' '(' first=f_el ',' second=s_el')'
	{
		$st = %substring_op_one(fValue={$first.st}, sValue={$second.st});
	}
	|	'subString' '(' first=f_el ',' second=s_el ',' third=s_el ')'
	{
		$st = %substring_op_two(fValue={$first.st}, sValue={$second.st}, thValue={$third.st});
	}
	;
	
/** rule describes type of variables */	
type returns[StringTemplate returnType]	
	:	'int' {$returnType = %return_int();} -> type_int()
	| 	'string' {$returnType = %return_string();} ->type_string()
	| 	'char' {$returnType = %return_string();} ->type_char()
	;

/** rule describes type of functions */	
type_func returns[StringTemplate returnType]
	:	
	|	'int' {$returnType = %return_int();} -> type_int()
	| 	'string' {$returnType = %return_string();} ->type_string()
	| 	'char' {$returnType = %return_string();} ->type_char()
	|	'void' {$returnType = %return_void();} -> type_void()
	;

/** 
* rule describes call delegates 
*/	  
call_delegate returns[String type, int line, List<StringTemplate> stList]
scope{
  String methodName;
}
@init{
  List<StringTemplate> argTypes = new ArrayList<StringTemplate>();
  $stList = new ArrayList<StringTemplate>();
}
  : 
    '[' delegatename=ID {$program::curBlock=$delegatename.text;} ':' expr ']' '(' {$program::curBlock="main";} arg_call ')'
    {
      if(names.isExistDelegate($delegatename.text))
      {
        NamesTable.DelegateName delName = names.getDelegate($delegatename.text);
        String functionName = delName.getNameFunction();
        NamesTable.FunctionName funcName = names.getFunction(functionName);
        $line = $delegatename.line;
        $type = $expr.type;
        if(!names.checkCallFunction(functionName, $arg_call.argumentTypeList, $line))
	      {
	        names.getAllErrors(errors);
	      }
	      ArrayList<String> argNames = new ArrayList<String>();
        argNames = funcName.getArgumentNames();
        List<StringTemplate> assign_list = $arg_call.stList;
        for(String arg_name: argNames)
        {
            NamesTable.VariableName varName = names.getVariable($delegatename.text+"."+arg_name);
            int _counter = varName.getNumber();
            if(TypesChecker.isString(varName.getType())){
              StringTemplate t = %declaration_string(counter={_counter});
              $stList.add(t);
              for(StringTemplate _t: assign_list)
              {
                StringTemplate t_assign= %assign_var_string(expression={_t}, counter={_counter});
                $stList.add(t_assign);
                assign_list.remove(_t);
                break;
              }
            }
            if(TypesChecker.isInteger(varName.getType())){
	            StringTemplate t = %declaration_int(counter={_counter});
	            $stList.add(t);
	            for(StringTemplate _t: assign_list)
			        {
			          StringTemplate t_assign= %assign_var_int(expression={_t}, counter={_counter});
			          $stList.add(t_assign);
			          assign_list.remove(_t);
			          break;
			        }
			      }
			      
        }
        $stList.add($expr.st);        
      }
      else
        errors.add("line "+$delegatename.line+" unknown variable "+$delegatename.text);
      $program::curBlock="main";
    }
  | '[' delegatename=ID {$program::curBlock=$delegatename.text;} ':' '{' block '}' ']' '(' {$program::curBlock="main";} arg_call ')'
  {
    if(names.isExistDelegate($delegatename.text))
    {
        NamesTable.DelegateName delName = names.getDelegate($delegatename.text);
        String functionName = delName.getNameFunction();
        NamesTable.FunctionName funcName = names.getFunction(functionName);
        $line = $delegatename.line;
        $type = funcName.getReturnType();
        if(!TypesChecker.checkTypes($type, $block.type))
        {
          errors.add("line "+$line+": delegate return "+$block.type+", but search type "+$type);
        }
        if(!names.checkCallFunction(functionName, $arg_call.argumentTypeList, $line))
        {
          names.getAllErrors(errors);
        }
        ArrayList<String> argNames = new ArrayList<String>();
        argNames = funcName.getArgumentNames();
        List<StringTemplate> assign_list = $arg_call.stList;
        for(String arg_name: argNames)
        {
            NamesTable.VariableName varName = names.getVariable($delegatename.text+"."+arg_name);
            int _counter = varName.getNumber();
            if(TypesChecker.isString(varName.getType())){
              StringTemplate t = %declaration_string(counter={_counter});
              $stList.add(t);
              for(StringTemplate _t: assign_list)
              {
                StringTemplate t_assign= %assign_var_string(expression={_t}, counter={_counter});
                $stList.add(t_assign);
                assign_list.remove(_t);
                break;
              }
            }
            if(TypesChecker.isInteger(varName.getType())){
              StringTemplate t = %declaration_int(counter={_counter});
              $stList.add(t);
              for(StringTemplate _t: assign_list)
              {
                StringTemplate t_assign= %assign_var_int(expression={_t}, counter={_counter});
                $stList.add(t_assign);
                assign_list.remove(_t);
                break;
              }
            }
            
            if(TypesChecker.isChar(varName.getType())){
              StringTemplate t = %declaration_char(counter={_counter});
              $stList.add(t);
              for(StringTemplate _t: assign_list)
              {
                StringTemplate t_assign= %assign_var_char(expression={_t}, counter={_counter});
                $stList.add(t_assign);
                assign_list.remove(_t);
                break;
              }
            }
            
        }
        for(StringTemplate t: $block.stList)
          $stList.add(t);
    }
    else
        errors.add("line "+$delegatename.line+" unknown variable "+$delegatename.text);
    $program::curBlock="main";
  }
  ;

/** 
* rule describes name of variables 
*/	  
ID  	
	: 	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;

/** 
* rule describes type int 
*/
INT	:	'-'? ('0'..'9')+
	;

/** 
* rule describes type char 
*/	
CHAR	:	'\'' ('a'..'z' | 'A'..'Z' | '0'..'9'|'\\n' ) '\''
	;
	
/** 
* rule describes type string 
*/
STRING	:	'"' ~'"'* '"'
	;


COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

