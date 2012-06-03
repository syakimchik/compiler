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
		private int labelNumber=0;
		
		protected NamesTable names = new NamesTable();
		protected ArrayList<String> errors = new ArrayList<String>();
		protected ArrayList<String> tmpVarNamesList = new ArrayList<String>();
		
		public static StringTemplateGroup templateGroup;
		//public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";
		
		/**
		* @param args
		*/
		public static void main(String[] args) throws Exception {
		//templateGroup = new StringTemplateGroup(new FileReader(templateFileName), AngleBracketTemplateLexer.class);
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

			//programName = codeFile.substring(0, codeFile.lastIndexOf("."));

			try{
				MyStrLangLexer lexer = new MyStrLangLexer(new ANTLRFileStream(codeFile));
				MyStrLangParser parser = new MyStrLangParser(new CommonTokenStream(lexer));
				parser.program();
				//parser.setTemplateLib(templateGroup);
				//RuleReturnScope returnScope = parser.program();
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
					//FileWriter out = new FileWriter(programName + ".txt.j");
					//out.write(returnScope.getTemplate().toString());
					//out.close();
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
}
@init{
	$program::curBlock = "";
}
	:	global_decl_var* (functions)* {$program::curBlock="main";} mainBlock EOF
	;
	
mainBlock
	:	'main' '{' block '}'
	;
	
global_decl_var
	:	{ $program::curBlock = "global";} (global_declaration)* ';'
	;
	
global_declaration
	:	type ID
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			names.addVariable(names.new VariableName($program::curBlock+"."+$ID.text, $type.text, $ID.line));
		}
		else
		{
			if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
				errors.add("line "+$ID.line+": Duplicated variable name "+$ID.text);
		}
	}
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
	;

arg_list
	:	(
		firstType=type firstId=ID
		{
			$functions::funcArgTypes.add($firstType.text);
			$functions::funcArgNames.add($firstId.text);
			if(!names.isDeclaredVariable($program::curBlock+"."+$firstId.text))
			{
				names.addVariable(names.new VariableName($program::curBlock+"."+$firstId.text, $firstType.text, $firstId.line));
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
				names.addVariable(names.new VariableName($program::curBlock+"."+$secondId.text, $secondType.text, $secondId.line));
			}
			else
			{
				errors.add("line "+$secondId.line+": Duplicated variable name "+$secondId.text);
			}
		}
 		)* 
 		)?
	;
	
block	:	(statements)*
	;
	
statements
	:	assign_stmt ';'
	|	decl_stmt ';'
	|	write_stmt ';'
	|	read_strm ';'
	|	if_stmt
	|	for_stmt
	|	while_stmt
	| 	call_func_stmt ';'
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
			names.addVariable(names.new VariableName($program::curBlock+"."+$ID.text, $type.text, $ID.line));
		}
		else
		{
			if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
				errors.add("line "+$ID.line+": Duplicated variable name "+$ID.text);
		}
	}
	;
	
write_stmt
	:	'write' '(' atom ')' 
	;
	
read_strm
	:	'read' '(' ID ')'
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$ID.text))
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
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
	}
	;
	
arg_call returns[ArrayList<String> argumentTypeList]
	:
	{
		$argumentTypeList = new ArrayList<String>();
	}	
	(a=atom {$argumentTypeList.add($a.type);} (',' b=atom {$argumentTypeList.add($b.type);})*)?
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
	:	ID {$value = $ID.text;
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
	|	INT {$type="int"; $value=$INT.text;}
	|	CHAR{$type="char"; $value=$CHAR.text;}
	|	STRING{$type="string"; $value=$STRING.text;}
	|	call_func {$type=$call_func.type;}
	|	length_stmt{$type="int";}
	|	elem_stmt{$type="char";}
	|	to_string_stmt{$type="string";}
	;
	
type	:	'int'| 'string'| 'char'
	;
	
type_func
	:	type|'void'
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

