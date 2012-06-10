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
}

@lexer::header
{
    package grammar;
}

@members{
		private static String programName = "";
		private int counter;
		
		protected NamesTable names = new NamesTable();
		protected ArrayList<String> errors = new ArrayList<String>();
		protected ArrayList<String> tmpVarNamesList = new ArrayList<String>();
		
		public static StringTemplateGroup templateGroup;
		public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";	//testing line
		//public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";	//line for jar file
		
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
	counter = 1;
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
	$functions::returnVariable = "";
	$functions::funcArgNames = new ArrayList<String>();
	$functions::funcArgTypes = new ArrayList<String>();
}
	:	type_func {$functions::funcType = $type_func.text;} ID{$program::curBlock = $ID.text; $functions::funcName=$ID.text;}
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
		return_stmt
		{
			boolean result = names.checkReturnType($ID.text, $functions::returnVariable, $return_stmt.type, $program::curBlock, $ID.line);
			if(result==false)
			{
				errors.add(names.getLastError());
			}
		} 
	'}'
	
	->functions(type={$type_func.st}, ident={$ID.text}, args={$arg_list.stList}, returnType={$return_stmt.type}, block={$block.stList})
	;

arg_list returns[List<StringTemplate> stList]
@init{
	$stList = new ArrayList<StringTemplate>();
	counter = 0;
}
@after{
	counter = 0;
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
	:	(statements {$stList.add($statements.st);})*
	;
	
statements
	:	assign_stmt ';' -> {$assign_stmt.st}
	|	decl_stmt ';' -> {$decl_stmt.st}
	|	write_stmt ';' -> {$write_stmt.st}
	|	read_strm ';' -> {$read_strm.st}
	|	if_stmt -> {$if_stmt.st}
	|	for_stmt -> {$for_stmt.st}
	|	while_stmt ->{$while_stmt.st}
	| 	call_func_stmt ';' -> {$call_func_stmt.st}
	;
	
assign_stmt
	:	ID '=' firstAssign=atom
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName var_type = names.getVariable($program::curBlock+"."+$ID.text);
			String varType = var_type.getType();
			if(!TypesChecker.checkTypes(varType, $firstAssign.type))
			{
				errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+varType+" to "+$firstAssign.type);
			}
			if(TypesChecker.isInteger(varType))
			{
				if(names.isGlobal($ID.text)){
					$st = %assign_field_int(expression={$firstAssign.st}, programName={programName}, fieldName={$ID.text});
				} 
				else{
					$st = %assign_var_int(expression={$firstAssign.st}, counter={var_type.getNumber()});
				}
			}
			if(TypesChecker.isString(varType) || TypesChecker.isChar(varType))
			{
				if(names.isGlobal($ID.text)){
					$st = %assign_field_string(expression={$firstAssign.st}, programName={programName}, fieldName={$ID.text});
				} 
				else{
					$st = %assign_var_string(expression={$firstAssign.st}, counter={var_type.getNumber()});
				}
			}
			
		}
	} 
	(('+'|'-') secondAssign=atom
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName var_type = names.getVariable($program::curBlock+"."+$ID.text);
			String varType = var_type.getType();
			if(!TypesChecker.checkTypes(varType, $secondAssign.type))
			{
				errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+varType+" to "+$secondAssign.type);
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
		if(TypesChecker.isString($type.text) || TypesChecker.isChar($type.text))
		{
			$st = %declaration_string(counter={counter});
		}
		
		counter++;
	}
	;
	
write_stmt
	:	'write' '(' write_param ')' 
	{
		if(TypesChecker.isInteger($write_param.type))
		{
			$st = %write_int(expression={$write_param.st});
		}
		if(TypesChecker.isString($write_param.type) || TypesChecker.isChar($write_param.type))
		{
			$st = %write_string(string={$write_param.st});
		}
	}
	;
	
write_param returns[String text, String type]
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
					$st = %referenceField_int(programName={programName}, fieldName={v_type.getNumber()});
				}
				else{
					$st = %referenceVariable_int(counter={v_type.getNumber()});
				}
			}
			
			if(TypesChecker.isString($type) || TypesChecker.isChar($type))
			{
				if(names.isGlobal($type))
				{
					$st = %referenceField_string(programName={programName}, fieldName={v_type.getNumber()});
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
	|	INT {$text = $INT.text; $type = "int";}				-> const_int(value={$INT.text})
	|	STRING {$text = $STRING.text; $type = "string";}	-> const_string(value = {$STRING.text})
	|	CHAR {$text = $CHAR.text; $type = "char";}			-> const_string(value = {$CHAR.text})
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
			if(TypesChecker.isString(varType) || TypesChecker.isChar(varType))
			{
				if(names.isGlobal($ID.text)){
					$st = %read_field_string(programName={programName}, fieldName={$ID.text});
				} else
					$st = %read_var_string(counter={var_type.getNumber()});
			}
		}
	}
	;
	
if_stmt	:	'if' '(' expression ')' '{' block '}' ('else' '{' block '}')?
	;
	
for_stmt:	'for' '(' assign_stmt? ';' expression ';' assign_stmt ')' '{' block '}'
	;
	
while_stmt
	:	'while' '(' expression ')' '{' block '}'
	;
	
return_stmt returns[String type]
	:	('return' atom ';' {$functions::returnVariable=$atom.value; $type=$atom.type;})?
	;
	
length_stmt
	:	'length' '(' (a=ID|STRING) ')'
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$a.text))
			errors.add("line "+$a.line+": unknown variable "+$a.text);
	}
	;
	
elem_stmt
	:	'elem' '('(a=ID|STRING)','(INT|b=ID) ')'
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$a.text))
			errors.add("line "+$a.line+": unknown variable "+$a.text);
		if(!names.isDeclaredVariable($program::curBlock+"."+$b.text))
			errors.add("line "+$b.line+": unknown variable "+$b.text);
	}
	;
	
to_string_stmt
	:	'ToString' '(' (b=CHAR|a=ID) ')'
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$a.text))
			errors.add("line "+$a.line+": unknown variable "+$a.text);
	}
	;
	
call_func_stmt
	:	call_func
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
			if(TypesChecker.isVoid(arg_type))
			{
				argTypes.add(%type_void());
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
		if(TypesChecker.isVoid($type))
		{
			returnType = %type_void();
		}
		if(TypesChecker.isChar($type))
		{
			returnType = %type_char();
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
	
expression:	and_expression ('|'  expression)? 
	;
	
and_expression
	:	not_expression ('&' and_expression)?
	;
	
not_expression
	:	'!' not_expression|comparison
	;

comparison
	:	a=atom c=('<'|'>'|'=='|'!=') b=atom
	{
		if(!TypesChecker.checkTypes($a.type, $b.type))
		{
			errors.add("line "+$c.line+": Incompatible types "+$a.type+" and "+$b.type);
		}
	}
	;
	
atom returns [String value, String type]
	:	ID 
		{
			$value = $ID.text;
			if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
			{
				NamesTable.VariableName v_type = names.getVariable($program::curBlock+"."+$ID.text);
				$type = v_type.getType();
			}
			else
			{
				errors.add("line "+$ID.line+": unknown variable "+$ID.text);
			}
		}
	|	INT {$type="int"; $value=$INT.text;}	-> const_int(value={$INT.text})
	|	CHAR{$type="char"; $value=$CHAR.text;}	-> const_string(value = {$CHAR.text})
	|	STRING{$type="string"; $value=$STRING.text;}	-> const_string(value = {$STRING.text})
	|	call_func {$type=$call_func.type;}		-> {$call_func.st}
	|	length_stmt{$type="int";}
	|	elem_stmt{$type="char";}
	|	to_string_stmt{$type="string";}
	;
	
type returns[StringTemplate returnType]	
	:	'int' {$returnType = %return_int();} -> type_int()
	| 	'string' {$returnType = %return_string();} ->type_string()
	| 	'char' {$returnType = %return_string();} ->type_string()
	;
	
type_func returns[StringTemplate returnType]
	:	type {$returnType = $type.returnType;}
	|	'void' {$returnType = %return_void();} -> type_void()
	;
	
ID  	
	: 	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;
	
INT	:	('0'..'9')+
	;
	
CHAR	:	'"' ('a'..'z' | 'A'..'Z' | '0'..'9'|'\\n' ) '"'
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

