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
		private static String programName = "";
		private int counter;
		private int labelCounter;
		private String _funcName = "";
		private String _funcType = "";
		
		protected NamesTable names = new NamesTable();
		protected ArrayList<String> errors = new ArrayList<String>();
		protected ArrayList<String> tmpVarNamesList = new ArrayList<String>();
		
		public static StringTemplateGroup templateGroup;
		public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";	//testing line
		//public static final String templateFileName = "template/ByteCode.stg";	//line for jar file
		
		/**
		* @param args
		*/
		public static void main(String[] args) throws Exception {
			templateGroup = new StringTemplateGroup(new FileReader(templateFileName), AngleBracketTemplateLexer.class);
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
				//parser.program();
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


program
scope{
	String curBlock;
	List global_variables;
	List functions;
}
@init{
	$program::curBlock = "";
	$program::global_variables = new ArrayList();
	$program::functions = new ArrayList();
}
	:	global_variables* (functions {$program::functions.add($functions.st);})* {$program::curBlock="main";} mainBlock EOF
		-> program(global_variables={$program::global_variables}, functions={$program::functions}, program={$mainBlock.st}, programName={programName})
	;
	
mainBlock
@init{
	counter = 0;
	labelCounter = 0;
}
	:	'main' '{' block '}'
		-> mainBlock(block={$block.stList})
	;
	
global_variables
	:	{ $program::curBlock = "global";} (global_declaration {$program::global_variables.add($global_declaration.st);})* ';'
	;
	
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
				errors.add("line "+$ID.line+": Duplicated variable name "+$ID.text);
		}
	}
	
	-> global_declaration(ident={$ID.text}, type={$type.st})
	;
	
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
	counter=0;
}
	:	type_func {$functions::funcType = $type_func.text; _funcType = $type_func.text; } 
		ID {$program::curBlock = $ID.text; $functions::funcName=$ID.text; _funcName = $ID.text;}
	'(' arg_list ')'
	//if fuction is not exists in nametable then add her
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

arg_list returns[List<StringTemplate> stList]
@init{
	$stList = new ArrayList<StringTemplate>();
	//counter = 0;
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
	
block returns[List<StringTemplate> stList]
@init{
	$stList = new ArrayList<StringTemplate>();
}
	:	(statements {$stList.add($statements.st);})* (return_stmt {$stList.add($return_stmt.st);})
	{		
		if($program::curBlock!="main"){
			String name = $program::curBlock;
			NamesTable.FunctionName func = names.getFunction(name);
			String type = func.getReturnType();
			if($return_stmt.value==null)
			{
				if(!type.equals("void"))
					errors.add("line "+$return_stmt.line+": Not found the keyword return in function with name "+name);
			}
		}
	}
	;
	
statements
	:	assign_stmt ';' -> {$assign_stmt.st}
	|	decl_stmt ';' -> {$decl_stmt.st}
	|	write_stmt ';' -> {$write_stmt.st}
	|	read_strm ';' -> {$read_strm.st}
	|	if_stmt -> {$if_stmt.st}
	|	for_stmt -> {$for_stmt.st}
	|	while_stmt -> {$while_stmt.st}
	| 	call_func_stmt ';' -> {$call_func_stmt.st}
	;
	
assign_stmt
	:	ID '=' expr
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
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
	}
	;
	
expr returns [String type]
	:	
		firstAssign=atom
		{
			$type = $firstAssign.type;
			$st = $firstAssign.st;
		}
		(
			(op='+'|op='-') secondAssign=atom
			{
				$type = $firstAssign.type;
				String t_1 = $secondAssign.type;
				if(TypesChecker.isChar($secondAssign.type))
				{
					errors.add("line "+$op.line+": impossibly addition type of char to char");
				}
				if(!TypesChecker.checkTypes($firstAssign.type, $secondAssign.type))
				{
					errors.add("line "+$op.line+": mismatch in math operation. Found "+$firstAssign.type+"and"+$secondAssign.type);
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
	
decl_stmt
	:	type ID
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName var = names.new VariableName($program::curBlock+"."+$ID.text, $type.text, $ID.line);
			var.setNumber(counter);
			names.addVariable(var);	
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
		
		counter++;
	}
	;
	
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
	
atom returns[String text, String type]
	:	ID {
		$text = $ID.text;
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
	|	INT {$text = $INT.text; $type = "int";}				-> const_int(value={$INT.text})
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
	
if_stmt	
	:	'if' '(' expression ')' '{' ifBlock=block '}' ('else' '{' elseBlock=block '}')?
	{
		$st = %if_operation(expression={$expression.st}, ifBlock={$ifBlock.stList}, elseBlock={$elseBlock.stList}, 
							trueLabel={labelCounter}, falseLabel={labelCounter+1});
		labelCounter = labelCounter+2;
	}
	;
	
for_stmt
	:	'for' '(' begin=assign_stmt? ';' check=expression ';' end=assign_stmt ')' '{' forBlock=block '}'
	{
		$st = %for_operator(beginExpr={$begin.st}, checkExpr={$check.st}, endExpr={$end.st}, 
			forBlock={$forBlock.stList}, firstLabel={labelCounter}, secondLabel={labelCounter+1}, thirdLabel={labelCounter+2});
		labelCounter = labelCounter+3;
	}
	;
	
while_stmt
	:	'while' '(' check=expression ')' '{' whileBlock=block '}'
	{
		$st = %while_operator(checkExpr={$check.st}, whileBlock={$whileBlock.stList}, firstLabel={labelCounter}, secondLabel={labelCounter+1}, thirdLabel={labelCounter+2});
		labelCounter = labelCounter+3;
	}
	;
	
return_stmt returns[String value, int line]
	:
	(a='return' atom ';' 
	{	
		if($program::curBlock=="main")
			errors.add("line "+$a.line+": function main may not contain keyword return");
		$value = $atom.text;
		$line = $a.line;
		
		String name = $functions::funcName;
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
	)?
	-> {$atom.st}
	;
	
length_stmt
	:	'length' '(' param ')'
	{
		$st = %length_string(string={$param.st});
	}
	;
	
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
	
elem_stmt
	:	'elem' '('f_el ',' s_el ')'
	{
		$st = %elem_in_string(fValue={$f_el.st}, sValue={$s_el.st});
	}
	;
	
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
	
arg_call returns[ArrayList<String> argumentTypeList, List<StringTemplate> stList]
	:
	{
		$argumentTypeList = new ArrayList<String>();
		$stList = new ArrayList<StringTemplate>();
	}	
	(a=atom {$argumentTypeList.add($a.type); $stList.add($a.st);} (',' b=atom {$argumentTypeList.add($b.type); $stList.add($b.st);})*)?
	;
	
expression
	:	first=and_expression {$st = $first.st;} ('||'  second=expression
		{
			$st = %logical_or(firstExpr={$first.st}, secondExpr={$second.st}, firstLabel={labelCounter},
								secondLabel={labelCounter+1}, thirdLabel={labelCounter+2});
			labelCounter = labelCounter+3;
		}
	)? 
	;
	
and_expression
	:	first=not_expression {$st = $first.st;} ('&&' second=and_expression
		{
			$st = %logical_and(firstExpr={$first.st}, secondExpr={$second.st}, firstLabel={labelCounter},
								secondLabel={labelCounter+1}, thirdLabel={labelCounter+2});
			labelCounter = labelCounter+3;
		}
	)?
	;
	
not_expression
	:	'!' first=not_expression
			{
				$st = %logical_not(expression={$first.st}, firstLabel={labelCounter}, secondLabel={labelCounter+1});
				labelCounter = labelCounter+2;
			}
	|	second=comparison {$st = $second.st;}
	;

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
	
equal_op
	:	'equals' '(' first=f_el ',' second=f_el ')'
	{
		$st = %equal_operation(fValue={$first.st}, sValue={$second.st});
	}
	;
	
contain_op
	:	'contains' '(' first=f_el ',' second=f_el ')'
	{
		$st = %contain_operation(fValue={$first.st}, sValue={$second.st});
	}
	;
	
indexOf_stmt
	:	'indexOf' '(' first=f_el ',' second=f_el')'
	{
		$st = %indexOf_int(fValue={$first.st}, sValue={$second.st});
	}
	;
	
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
	
replace_firstElem
	:	'replaceFirst' '(' first=f_el ',' second=f_el ',' third=f_el ')'
	{
		$st = %replaceFirst_op(fValue={$first.st}, sValue={$second.st}, thValue={$third.st});
	}
	;
	
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
	
type returns[StringTemplate returnType]	
	:	'int' {$returnType = %return_int();} -> type_int()
	| 	'string' {$returnType = %return_string();} ->type_string()
	| 	'char' {$returnType = %return_string();} ->type_char()
	;
	
type_func returns[StringTemplate returnType]
	:	
	|	'int' {$returnType = %return_int();} -> type_int()
	| 	'string' {$returnType = %return_string();} ->type_string()
	| 	'char' {$returnType = %return_string();} ->type_char()
	|	'void' {$returnType = %return_void();} -> type_void()
	;
	
ID  	
	: 	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;
	
INT	:	('0'..'9')+
	;
	
CHAR	:	'\'' ('a'..'z' | 'A'..'Z' | '0'..'9'|'\\n' ) '\''
	;
	
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

