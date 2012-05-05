grammar StrLang;

options {
  language = Java;
}

@header{
	package grammar;
	import java.io.*;
	import namestable.*;
	import java.util.ArrayList;
	import org.antlr.runtime.*;
	import namestable.*;
}

@lexer::header{
	package grammar;
}

@members{
	protected NamesTable names = new NamesTable();
	protected ArrayList<String> errors = new ArrayList<String>();
	protected ArrayList<String> tmpVarNamesList = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		StrLangLexer lexer = new StrLangLexer(new ANTLRFileStream(args[0]));
		StrLangParser parser = new StrLangParser(new CommonTokenStream(lexer));
		parser.program();
		if(!parser.errors.isEmpty())
		{
			System.out.println("Found "+parser.errors.size()+" errors:");
			for(String m: parser.errors)
				System.out.println(m);
			System.out.println("Compiled not successfully");
		}
		else
			System.out.println("Compiled successfully");
		
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
	;
	
mainBlock:
		'main' '{' body* '}'
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

variables
scope{
	String varType;
}
@init{
	$variables::varType = "";
}
	:decl_var
	|init_var
	;
	
decl_var
	: type
	{
		$variables::varType = $type.text;
	}
	variableDeclarators
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
	;
	
assign_inside_func returns[String type]
	: elem {$type = "char";}
	| length {$type = "int";}
	| read_op {$type = "string";}
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
	: spec_type (DOUBLE_MINUS|DOUBLE_PLUS|ASSIGN_OP spec_type (PLUS_OP|MINUS_OP) spec_type )
	;		
	
spec_type returns[String value] 
	: INT {$value = "int";}
	| LINE {$value = "string";}
	| SYMBOL {$value = "char";}
	| idLiteral {$value = $idLiteral.idType;}
	| assign_inside_func {$value = $assign_inside_func.type;}
	| call_func {$value = $call_func.type;}
	;
	
returnType returns[String value, String type]
	: INT	{$value = $INT.text; $type = "int";}
	| LINE	{$value = $LINE.text; $type = "string";}
	| SYMBOL {$value = $SYMBOL.text; $type = "char";}
	| idLiteral	{$value = $idLiteral.text; $type = $idLiteral.idType;}
	;
	
idLiteral returns[String idType, int curLine]
	:	ID
	{
		$curLine = $ID.line;
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
	:	'string'
	| 	'int'
	|	'char'
	|	'void'
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
	  		body*
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
		argumentTypeList = new ArrayList<String>();
	}  
	a=returnType {argumentTypeList.add($a.type);} (',' b=returnType {argumentTypeList.add($b.type);} )*
	{
		
	}
	;
	
body
	:
	variables
	| func
	| if_op
	| for_op
	| while_op 
	;

write_op
	: 'WriteToFile' '('  path ','  ID  ')'
	;

read_op
	: 'ReadFile' '(' path ')'
	;

while_op
	: 'while' '(' logic ')' '{' body* '}'   
	;
for_op	
	: 'for' '(' variables? ';' logic? ';' action? ')' '{' body* '}'
	;

print_op
	: 'print' '(' returnType (',' returnType)*  ')'
	;
	
length	
	: 'length' '(' returnType ')'
	;

elem	
	:'elem' '(' returnType ',' returnType ')'
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

if_op
	: 'if' '(' logic ')' '{' body* '}' ('else' '{' body* '}')?
	;

expr
	: EQUALLY_EQL_OP
	| MORE_EQL_OP
	| LESS_EQL_OP
	| MORE_OP
	| LESS_OP
	| NO_EQUALLY
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
	: logic_atom (expr logic_atom)?
	| '(' logic ')'
	;

logic_atom
	: LINE
	| SYMBOL
	| INT
	| ID
	| assign_inside_func
	| END_LINE
	;
	 		
specialType
	:INT
	|ID
	;
	
path:	ID|LINE
	;

LINE_TYPE : 'string';
INT_TYPE : 'int';
SYMBOL_TYPE :'char';
VOID_TYPE :'void';


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


