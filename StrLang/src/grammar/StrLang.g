grammar StrLang;

options {
  language = Java;
  output = template;
}

@header{
	package grammar;
	import java.io.*;
	import namestable.*;
	import org.antlr.stringtemplate.StringTemplateGroup;
	import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;
}

@lexer::header{
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
			StrLangLexer lexer = new StrLangLexer(new ANTLRFileStream(codeFile));
			StrLangParser parser = new StrLangParser(new CommonTokenStream(lexer));
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
	: global_decl? {$program::curBlock="main";} mainBlock
		//-> program(program={$program.st}, programName={programName})
	;
	
mainBlock:
		'main' '{' body '}'
			//-> mainBlock(body={$body.stList})
		;

global_decl
	: 
	(global_var | global_func)+
	;
	
global_var
	: { $program::curBlock = "global";} variables
	;

func
	: inside_func
	| call_func
	;
	
body
returns [ArrayList<StringTemplate> stList]
@init{
	$stList = new ArrayList<StringTemplate>(); 
}
	: (stmt { $stList.add($stmt.st); })*
	;
	
stmt:
	variables //-> {$variables.st}
	| func
	| if_op //-> {$if_op.st}
	| for_op
	| while_op 
	;

variables
scope{
	String varType;
}
@init{
	$variables::varType = "";
}
	:decl_var //-> {$st = $decl_var.st}
	|init_var //-> {$st = $init_var.st}
	;
	
decl_var
	: type
	{
		$variables::varType = $type.text;
	}
	variableDeclarators //-> {$st = $variableDeclarators.st}
	;
	
variableDeclarators
	:	variableDeclarator (',' variableDeclarator)*
	;
	
variableDeclarator
scope{
	ArrayList<String> varList;
}
@init{
	$variableDeclarator::varList = new ArrayList<String>();
}
	: ID
	{
		if(!names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			names.addVariable(names.new VariableName($program::curBlock+"."+$ID.text, $variables::varType, $ID.line));
		}
		else
		{
			if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
				errors.add("line "+$ID.line+": Duplicated variable name "+$ID.text);
			else
			{
				int variableNumber;
				if(TypesChecker.isInteger($variables::varType)){
					$st = %declaration_int(variableNumber={$ID.text});
				}
				if(TypesChecker.isString($variables::varType)){
					$st = %declaration_string(variableNumber={$ID.text});
				}
				if(TypesChecker.isChar($variables::varType)){
					$st = %declaration_char(variableNumber={$ID.text});
				}
			}
		}
	}
	
	(
		ASSIGN_OP firstAssign=spec_type
		{
			if(!TypesChecker.checkTypes($variables::varType, $firstAssign.value))
			{
				errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+$variables::varType+" to "+$firstAssign.value);
			}
		}
	)?
	((PLUS_OP|MINUS_OP) secondAssign=spec_type
		{
			if(!TypesChecker.checkTypes($variables::varType, $secondAssign.value))
			{
				errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+$variables::varType+" to "+$secondAssign.value);
			}
		}
	)*
	;
	
	
init_var
	: ID ASSIGN_OP firstAssign=spec_type
	{
		if(names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			NamesTable.VariableName var_type = names.getVariable($program::curBlock+"."+$ID.text);
			$variables::varType = var_type.getType();
			if(!TypesChecker.checkTypes($variables::varType, $firstAssign.value))
			{
				errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+$variables::varType+" to "+$firstAssign.value);
			}
		}
		else
		{
			errors.add("line "+$ID.line+": "+$ID.text+" cannot be resolved to a variable");
		}
	}
	(
		(PLUS_OP|MINUS_OP) secondAssign=spec_type
		{
			if(!TypesChecker.checkTypes($variables::varType, $secondAssign.value))
			{
				errors.add("line "+$ID.line+": Type mismatch: cannot convert from "+$variables::varType+" to "+$secondAssign.value);
			}
		}
	)*
	;
	

inside_func
	: elem
	| length
	| print_op  
	| break_op
	| read_op 
	| write_op
	| to_string_op
	;
	
assign_inside_func returns[String type, int line]
	: elem {$type = "char"; $line = $elem.line;}
	| length {$type = "int"; $line = $length.line;}
	| read_op {$type = "string"; $line = $read_op.line;}
	| to_string_op {$type = "string"; $line = $to_string_op.line;}
	;
	
call_func returns[String type, int curLine]
scope{
	String methodName;
}
@init{
	$call_func::methodName="";
}
	: ID {$call_func::methodName=$ID.text;} '(' param? ')'
	{
		$curLine = $ID.line;
		ArrayList<String> list = null;
		if($param.argumentTypeList==null)
			list = new ArrayList<String>();
		else
			list = $param.argumentTypeList;
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
	
action	
	: a=spec_type prefix
	{
		String s_type = "int";
		if(!TypesChecker.checkTypes($a.value, s_type))
		{
			errors.add("line "+$a.curLine+": incomparable types in variable "+$a.text+": "+$a.value+" and "+s_type);
		}
	}
	| b=spec_type ASSIGN_OP c=spec_type (PLUS_OP|MINUS_OP) d=spec_type
	{
		String s_type = "int", type="";
		if($b.value=="")
			type = "none";
		else
			type = $b.value;
		if(!TypesChecker.checkTypes($b.value, s_type))
		{
			errors.add("line "+$b.curLine+": incomparable types in variable "+$b.text+": "+type+" and "+s_type);
		}
		if($c.value=="")
			type = "none";
		else
			type = $c.value;
		if(!TypesChecker.checkTypes($c.value, s_type))
		{
			errors.add("line "+$c.curLine+": incomparable types in variable "+$c.text+": "+type+" and "+s_type);
		}
		if($d.value=="")
			type = "none";
		else
			type = $d.value;
		if(!TypesChecker.checkTypes($d.value, s_type))
		{
			errors.add("line "+$d.curLine+": incomparable types in variable "+$d.text+": "+type+" and "+s_type);
		}
	}
	//spec_type (DOUBLE_MINUS|DOUBLE_PLUS|ASSIGN_OP spec_type (PLUS_OP|MINUS_OP) spec_type )
	;		
	
spec_type returns[String value, int curLine, String text] 
	: INT {$value = "int"; $curLine = $INT.line;} //-> iconst(id={$INT.text})
	| LINE {$value = "string"; $curLine=$LINE.line;} //-> iline(line={$LINE.text})
	| SYMBOL {$value = "char"; $curLine = $SYMBOL.line;} //->isysmol(symbol={$SYMBOL.text})
	| idLiteral {$value = $idLiteral.idType; $curLine = $idLiteral.curLine; $text = $idLiteral.text;} //-> refVar(id={$idLiteral.st})
	| assign_inside_func {$value = $assign_inside_func.type; $curLine = $assign_inside_func.line;}
	| call_func {$value = $call_func.type; $curLine = $call_func.curLine;}
	| END_LINE {$value = "char"; $curLine = $END_LINE.line; }
	;
	
returnType returns[String value, String type]
	: INT	{$value = $INT.text; $type = "int";}
	| LINE	{$value = $LINE.text; $type = "string";}
	| SYMBOL {$value = $SYMBOL.text; $type = "char";}
	| idLiteral	{$value = $idLiteral.text; $type = $idLiteral.idType;}
	;
	
idLiteral returns[String idType, int curLine, String text]
	:	ID
	{
		$curLine = $ID.line;
		$text = $ID.text;
		if(!names.isExistVariable($program::curBlock+"."+$ID.text))
		{
			errors.add("line "+$ID.line+": unknown variable "+$ID.text);
			$idType = "";
		}
		else
		{
			names.getVariable($program::curBlock+"."+$ID.text).addLineUses($ID.line);
			$idType = names.getVariable($program::curBlock+"."+$ID.text).getType();
		}
	}
	;

type
	:	'string' //-> type_string()
	| 	'int' //-> type_int()
	|	'char' //-> type_char()
	|	'void' //-> type_void()
	;		
	
global_func
scope{
	String funcName;
	String funcType;
	ArrayList<String> funcArgNames;
	ArrayList<String> funcArgTypes;
	String returnVariable;
	boolean isReturnUsed;
}
@init{
	$global_func::funcName = "";
	$global_func::funcType = "";
	$global_func::returnVariable = "";
	$global_func::funcArgNames = new ArrayList<String>();
	$global_func::funcArgTypes = new ArrayList<String>();
}
	: type {$global_func::funcType = $type.text;} ID{$program::curBlock = $ID.text; $global_func::funcName=$ID.text;}
	 '(' functionArgumentList? ')'
	 //if fuction is not exists in nametable then add her
	 {
	 	if(!names.isExistFunction($ID.text))
	 	{
	 		names.addFunction(names.new FunctionName($ID.text, $type.text, $global_func::funcArgTypes, $global_func::funcArgNames, $ID.line));
	 	}
	 	else
	 	{
	 		errors.add("line "+$ID.line+": Duplicated declaration function "+$ID.text);
	 	}
	 }
	  '{' 
	  		body
	  		(
	  			return_op
	  			{
				  	boolean result = names.checkReturnType($ID.text, $global_func::returnVariable, $program::curBlock, $ID.line);
				  	if(result==false)
				  	{
				  		errors.add(names.getLastError());
				  	}
			  	}
	  		)?
	  '}' 	
	;
	
functionArgumentList
	: functionArgumentDeclarator (',' functionArgumentDeclarator)*
	;
	
functionArgumentDeclarator
	:	type ID
	{
		$global_func::funcArgTypes.add($type.text);
		$global_func::funcArgNames.add($ID.text);
		if(!names.isDeclaredVariable($program::curBlock+"."+$ID.text))
		{
			names.addVariable(names.new VariableName($program::curBlock+"."+$ID.text, $type.text, $ID.line));
		}
		else
		{
			errors.add("line "+$ID.line+": Duplicated variable name "+$ID.text);
		}
	}
	;
		
param returns[ArrayList<String> argumentTypeList]
	:
	{
		$argumentTypeList = new ArrayList<String>();
	}  
	a=returnType {$argumentTypeList.add($a.type);} (',' b=returnType {$argumentTypeList.add($b.type);} )*
	;

write_op
	: c='WriteToFile' '('  a=string_and_var ','  b=string_and_var  ')'
	{
		String s_type = "string";
		if(!TypesChecker.checkTypes($a.type, s_type))
		{
			errors.add("line "+$c.line+": incorrect first argument type for function WriteToFile. Need type string, found "+$a.type);
		}
		if(!TypesChecker.checkTypes($b.type, s_type))
		{
			errors.add("line "+$c.line+": incorrect second argument type for function WriteToFile. Need type string, found "+$b.type);
		}
	}
	;

read_op returns[int line]
	: c='ReadFile' '(' a=string_and_var ')' {$line = $c.line;}
	{
		String s_type = "string";
		if(!TypesChecker.checkTypes($a.type, s_type))
		{
			errors.add("line "+$c.line+": incorrect argument type for function ReadFile. Need type string, found "+$a.type);
		}
	}
	;

while_op
	: 'while' '(' logic ')' '{' body '}'   
	;
for_op	
	: 'for' '(' e1=variables? ';' logic? ';' action? ')' '{' body '}'
	;

print_op
	: 'print' '(' a=returnType ')'
	/*{
		if(TypesChecker.isInteger($a.type)){
			$st = %print_int(returnType={$a.st});
		}
		if(TypesChecker.isString($a.type)){
			$st = %print_string(string={$a.st});
		}
		if(TypesChecker.isChar($a.type)){
			$st = %print_string(string={$a.st});
		}
	}*/
	;
	
length returns[int line]
	: c='length' '(' a=string_and_var ')' {$line = $c.line;}
	{
		String s_type = "string";
		if(!TypesChecker.checkTypes($a.type, s_type))
		{
			errors.add("line "+$c.line+": incorrect argument type for function length. Need type string, found "+$a.type);
		}
	}
	;

elem returns[int line]	
	:a='elem' '(' returnType ',' returnType ')' {$line = $a.line;}
	;

break_op	
	: 'break'
	;	
	

return_op
 	: 'return' returnType
 	{
 		$global_func::returnVariable = $returnType.value;
 	}
 	;
 	
 to_string_op returns[int line]
 	:	a='ToString' '(' returnType ')'
 	{
 		$line = $a.line; 
 	}
 	;

if_op
	: 'if' '(' logic ')' '{' ifblock=body '}' ('else' '{' elseblock=body '}')?
	//{ 
		//$st = %if_operator(logic={$logic.st}, ifBlock={$ifblock.stList}, elseBlock={$elseblock.stList}, firstLabel={labelNumber}, secondLabel={labelNumber+1});
		//labelNumber = labelNumber+2;
	//}
	;

expr
	: EQUALLY_EQL_OP
	| MORE_EQL_OP
	| LESS_EQL_OP
	| MORE_OP
	| LESS_OP
	| NO_EQUALLY
	;
	
prefix
	: DOUBLE_MINUS
	| DOUBLE_PLUS
	;
	
logic
	: logic_and	
	;

logic_and 
	: logic_or ('and' logic_or)*
	;
logic_or 
	: logic_expr ('or' logic_expr)*
	;


logic_expr
	: a=logic_atom expr b=logic_atom 
	{
		if(!TypesChecker.checkTypes($a.type,$b.type))
		{
			errors.add("line "+$a.curLine+": incomparable types: "+$a.type+" and "+$b.type);
		}
	} 
	| '(' logic ')'
	;

logic_atom returns[String type, int curLine]
	: spec_type {$type = $spec_type.value; $curLine = $spec_type.curLine;}
	;
	
string_and_var returns[String value, String type]
	: idLiteral {$value = $idLiteral.text; $type = $idLiteral.idType;}
	| LINE {$value = $LINE.text; $type = "string";}
	;

INT 
	: ('0'..'9')+
    	;

END_LINE
	:  '\'~\''
	;

ID  	
	: ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;

SYMBOL
	: '\'' ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | ' ' | '.' ) '\'' 
	;    	

LINE
	: '"' ~'"'* '"'
	;
	
DOUBLE_PLUS
	:	'++'
	;
	
ASSIGN_OP
	:	'='
	;
	
DOUBLE_MINUS
	:	'--'
	;
	
PLUS_OP
	:	'+'
	;

MINUS_OP:	'-'
	;
	
LESS_OP	:	'<'
;
	
MORE_OP	:	'>'
	;
	
LESS_EQL_OP
	:	'<='
	;
	
MORE_EQL_OP
	:	'>='
	;

EQUALLY_EQL_OP
	:	'=='
	;
	
NO_EQUALLY
	:	'!='
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


