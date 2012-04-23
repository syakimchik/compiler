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
		}
		System.out.println("Compiled successfully");
		
	}
	
	public String getErrorHeader(RecognitionException e)
	{
		return "line"+e.line+":";
	}
	
	public void emitErrorMessage(String msg)
	{
		errors.add(msg);
	}
}

program
	: global_decl
	;

global_decl
scope{
	String name;
	String nameOfFunc;
	String idType;
}
@init{
	$global_decl::name = "";
	$global_decl::nameOfFunc="";
}
	: ({$global_decl::name = "";}variables
	| {$global_decl::nameOfFunc = "";}global_func
	| func)+
	;

func
	: inside_func
	| call_func
	;

variables
	:decl_var
	|init_var
	;
	
decl_var
	: type ID
	{
		if(names.isExist($global_decl::name+"."+$ID.text))
			errors.add("line "+$ID.line+": name "+$ID.text+" duplicated");
		else
			names.add(names.new Name($global_decl::name+"."+$ID.text, $type.idType, $ID.line));
	}
	( ASSIGN_OP spec_type
	{
		if(names.isExist($global_decl::name+"."+$ID.text))
			names.get($global_decl::name+"."+$ID.text).addLineUses($ID.line);
		else
			errors.add("line "+$ID.line+": name "+$ID.text+" cannot be resolved");
	}
	)? ((PLUS_OP|MINUS_OP) spec_type)* 
	;
	
init_var
	: ID  ASSIGN_OP spec_type
	{
		if(names.isExist($global_decl::name+"."+$ID.text))
			names.get($global_decl::name+"."+$ID.text).addLineUses($ID.line);
		else
			errors.add("line "+$ID.line+": name "+$ID.text+" cannot be resolved");
	} 
	((PLUS_OP|MINUS_OP) spec_type)*
	;
	

inside_func
	: elem 
	| length
	| print_op  
	| break_op
	| read_op 
	| write_op
	;
	
call_func
	: ID '(' param? ')'
	;
	
action	
	: spec_type (DOUBLE_MINUS|DOUBLE_PLUS|ASSIGN_OP spec_type (PLUS_OP|MINUS_OP) spec_type )
	;		
	
spec_type returns[String value]
	: INT {$value = $INT.getText();}
	| LINE{$value = $LINE.text;}
	| SYMBOL
	| ID
	| inside_func
	| call_func
	;

/*type	
	: LINE_TYPE | INT_TYPE | VOID_TYPE | SYMBOL_TYPE
	;*/

type returns[String idType]
	:	'string' {$idType = "string";}
	| 	'int'	{$idType="int";}
	|	'char' {$idType = "char";}
	|	'void' {$idType = "void";}
	;		
	
global_func
	: type ID
	{
		$global_decl::name = $ID.text;
	}
	 '(' param* ')' '{' body? return_op? '}' 	
	;
		
param
	: ( type)? ID ('=' type? (INT|ID) )?  ( ',' ( type)? ID ('=' type? (INT|ID) )? )*
	;
	
body
	:(variables
	| func
	| if_op
	| for_op
	| while_op  )+
	;

write_op
	: 'WriteToFile' '('  ID ','  ID  ')'
	;

read_op
	: 'ReadFile' '('  ID   ')'
	;

while_op
	: 'while' '(' logic ')' '{' body? '}'   
	;
for_op	
	: 'for' '(' variables? ';' logic? ';' action? ')' '{' body? '}'
	;

print_op
	: 'print' '(' spec_type (',' spec_type)*  ')'
	;
	
length	
	: 'length' '(' spec_type ')' 
	;

elem	
	:'elem' '('spec_type ',' specialType ')'
	;

break_op	
	: 'break' 
	;	
	

return_op
 	: 'return' spec_type
 	;

if_op
	: 'if' '(' logic ')' '{' body? '}' ('else' '{' body? '}')?
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
	| inside_func
	| END_LINE
	;
	 		
specialType
	:INT
	|ID
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
	: ( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '"' | ':' | '\\' | '.'  )+
	;

SYMBOL
	: '\'' ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | ' ' | '.' ) '\'' 
	;    	

LINE
	:'"' ( 'a'..'z' | 'A'..'Z' | '0'..'9' | ' ' | '_' )* '"'
	
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


