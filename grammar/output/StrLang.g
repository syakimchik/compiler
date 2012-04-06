grammar StrLang;

options {
  language = Java;
}

@header{
	package grammar;
}

@lexer::header{
	package grammar;
}

program
	: global_decl+
	;

global_decl
	: variables
	| global_func
	| func
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
	: type ID ( ASSIGN_OP spec_type)? ((PLUS_OP|MINUS_OP) spec_type)*  
	;
	
init_var
	: ID  ASSIGN_OP spec_type ((PLUS_OP|MINUS_OP) spec_type)*
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
	
spec_type	
	: INT 
	| LINE
	| SYMBOL 
	| ID 
	| inside_func
	| call_func
	;

type	
	: LINE_TYPE | INT_TYPE | VOID_TYPE | SYMBOL_TYPE
	;	
	
global_func
	: type ID '(' param* ')' '{' body? return_op? '}' 
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

LINE_TYPE	:'string';
INT_TYPE	:'int';
SYMBOL_TYPE	:'char';
VOID_TYPE	:'void';


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


