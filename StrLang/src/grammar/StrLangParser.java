// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g 2012-05-05 00:35:33

	package grammar;
	import java.io.*;
	import namestable.*;
	import java.util.ArrayList;
	import org.antlr.runtime.*;
	import namestable.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StrLangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "ASSIGN_OP", "PLUS_OP", "MINUS_OP", "DOUBLE_MINUS", "DOUBLE_PLUS", "INT", "LINE", "SYMBOL", "EQUALLY_EQL_OP", "MORE_EQL_OP", "LESS_EQL_OP", "MORE_OP", "LESS_OP", "NO_EQUALLY", "END_LINE", "LINE_TYPE", "INT_TYPE", "SYMBOL_TYPE", "VOID_TYPE", "COMMENT", "WS", "'main'", "'{'", "'}'", "','", "'('", "')'", "'WriteToFile'", "'ReadFile'", "'while'", "'for'", "';'", "'print'", "'length'", "'elem'", "'break'", "'return'", "'if'", "'else'", "'and'", "'or'"
    };
    public static final int EOF=-1;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int ID=4;
    public static final int ASSIGN_OP=5;
    public static final int PLUS_OP=6;
    public static final int MINUS_OP=7;
    public static final int DOUBLE_MINUS=8;
    public static final int DOUBLE_PLUS=9;
    public static final int INT=10;
    public static final int LINE=11;
    public static final int SYMBOL=12;
    public static final int EQUALLY_EQL_OP=13;
    public static final int MORE_EQL_OP=14;
    public static final int LESS_EQL_OP=15;
    public static final int MORE_OP=16;
    public static final int LESS_OP=17;
    public static final int NO_EQUALLY=18;
    public static final int END_LINE=19;
    public static final int LINE_TYPE=20;
    public static final int INT_TYPE=21;
    public static final int SYMBOL_TYPE=22;
    public static final int VOID_TYPE=23;
    public static final int COMMENT=24;
    public static final int WS=25;

    // delegates
    // delegators


        public StrLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public StrLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return StrLangParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g"; }


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
    		return "line "+e.line+":";
    	}
    	
    	public void emitErrorMessage(String msg)
    	{
    		errors.add(msg);
    	}


    protected static class program_scope {
        String curBlock;
    }
    protected Stack program_stack = new Stack();


    // $ANTLR start "program"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:55:1: program : ( global_decl )? mainBlock ;
    public final void program() throws RecognitionException {
        program_stack.push(new program_scope());

        	((program_scope)program_stack.peek()).curBlock = "";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:62:2: ( ( global_decl )? mainBlock )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:62:4: ( global_decl )? mainBlock
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:62:4: ( global_decl )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID||(LA1_0>=LINE_TYPE && LA1_0<=VOID_TYPE)||(LA1_0>=32 && LA1_0<=33)||(LA1_0>=37 && LA1_0<=40)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:62:4: global_decl
                    {
                    pushFollow(FOLLOW_global_decl_in_program50);
                    global_decl();

                    state._fsp--;


                    }
                    break;

            }

            ((program_scope)program_stack.peek()).curBlock ="main";
            pushFollow(FOLLOW_mainBlock_in_program55);
            mainBlock();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            program_stack.pop();
        }
        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "mainBlock"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:65:1: mainBlock : 'main' '{' ( body )? '}' ;
    public final void mainBlock() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:65:10: ( 'main' '{' ( body )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:66:3: 'main' '{' ( body )? '}'
            {
            match(input,26,FOLLOW_26_in_mainBlock68); 
            match(input,27,FOLLOW_27_in_mainBlock70); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:66:14: ( body )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID||(LA2_0>=LINE_TYPE && LA2_0<=VOID_TYPE)||(LA2_0>=32 && LA2_0<=35)||(LA2_0>=37 && LA2_0<=40)||LA2_0==42) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:66:14: body
                    {
                    pushFollow(FOLLOW_body_in_mainBlock72);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_mainBlock75); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "mainBlock"


    // $ANTLR start "global_decl"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:69:1: global_decl : ( variables | global_func | func )+ ;
    public final void global_decl() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:70:2: ( ( variables | global_func | func )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:71:2: ( variables | global_func | func )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:71:2: ( variables | global_func | func )+
            int cnt3=0;
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case LINE_TYPE:
                case INT_TYPE:
                case SYMBOL_TYPE:
                case VOID_TYPE:
                    {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==ID) ) {
                        int LA3_5 = input.LA(3);

                        if ( ((LA3_5>=ID && LA3_5<=MINUS_OP)||(LA3_5>=LINE_TYPE && LA3_5<=VOID_TYPE)||LA3_5==26||LA3_5==29||(LA3_5>=32 && LA3_5<=33)||(LA3_5>=37 && LA3_5<=40)) ) {
                            alt3=1;
                        }
                        else if ( (LA3_5==30) ) {
                            alt3=2;
                        }


                    }


                    }
                    break;
                case ID:
                    {
                    int LA3_3 = input.LA(2);

                    if ( (LA3_3==ASSIGN_OP) ) {
                        alt3=1;
                    }
                    else if ( (LA3_3==30) ) {
                        alt3=3;
                    }


                    }
                    break;
                case 32:
                case 33:
                case 37:
                case 38:
                case 39:
                case 40:
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:71:3: variables
            	    {
            	    pushFollow(FOLLOW_variables_in_global_decl90);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:72:4: global_func
            	    {
            	    pushFollow(FOLLOW_global_func_in_global_decl95);
            	    global_func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:73:4: func
            	    {
            	    pushFollow(FOLLOW_func_in_global_decl100);
            	    func();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "global_decl"


    // $ANTLR start "func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:76:1: func : ( inside_func | call_func );
    public final void func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:77:2: ( inside_func | call_func )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=32 && LA4_0<=33)||(LA4_0>=37 && LA4_0<=40)) ) {
                alt4=1;
            }
            else if ( (LA4_0==ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:77:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_func113);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:78:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_func118);
                    call_func();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "func"

    protected static class variables_scope {
        String varType;
    }
    protected Stack variables_stack = new Stack();


    // $ANTLR start "variables"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:81:1: variables : ( decl_var | init_var );
    public final void variables() throws RecognitionException {
        variables_stack.push(new variables_scope());

        	((variables_scope)variables_stack.peek()).varType = "";
        	{((program_scope)program_stack.peek()).curBlock = "global";}

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:89:2: ( decl_var | init_var )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=LINE_TYPE && LA5_0<=VOID_TYPE)) ) {
                alt5=1;
            }
            else if ( (LA5_0==ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:89:3: decl_var
                    {
                    pushFollow(FOLLOW_decl_var_in_variables135);
                    decl_var();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:90:3: init_var
                    {
                    pushFollow(FOLLOW_init_var_in_variables139);
                    init_var();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            variables_stack.pop();
        }
        return ;
    }
    // $ANTLR end "variables"


    // $ANTLR start "decl_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:93:1: decl_var : type variableDeclarators ;
    public final void decl_var() throws RecognitionException {
        StrLangParser.type_return type1 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:94:2: ( type variableDeclarators )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:94:4: type variableDeclarators
            {
            pushFollow(FOLLOW_type_in_decl_var151);
            type1=type();

            state._fsp--;


            		((variables_scope)variables_stack.peek()).varType = (type1!=null?input.toString(type1.start,type1.stop):null);
            	
            pushFollow(FOLLOW_variableDeclarators_in_decl_var157);
            variableDeclarators();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "decl_var"


    // $ANTLR start "variableDeclarators"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:101:1: variableDeclarators : variableDeclarator ( ',' variableDeclarator )* ;
    public final void variableDeclarators() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:102:2: ( variableDeclarator ( ',' variableDeclarator )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:102:4: variableDeclarator ( ',' variableDeclarator )*
            {
            pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators169);
            variableDeclarator();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:102:23: ( ',' variableDeclarator )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==29) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:102:24: ',' variableDeclarator
            	    {
            	    match(input,29,FOLLOW_29_in_variableDeclarators172); 
            	    pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators174);
            	    variableDeclarator();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "variableDeclarators"

    protected static class variableDeclarator_scope {
        ArrayList<String> varList;
    }
    protected Stack variableDeclarator_stack = new Stack();


    // $ANTLR start "variableDeclarator"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:105:1: variableDeclarator : ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* ;
    public final void variableDeclarator() throws RecognitionException {
        variableDeclarator_stack.push(new variableDeclarator_scope());
        Token ID2=null;
        String firstAssign = null;

        String secondAssign = null;



        	((variableDeclarator_scope)variableDeclarator_stack.peek()).varList = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:112:2: ( ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:112:4: ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            {
            ID2=(Token)match(input,ID,FOLLOW_ID_in_variableDeclarator195); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID2!=null?ID2.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID2!=null?ID2.getText():null), ((variables_scope)variables_stack.peek()).varType, (ID2!=null?ID2.getLine():0)));
            		}
            		else
            		{
            			if(names.isDeclaredVariable("global"+"."+(ID2!=null?ID2.getText():null)))
            				errors.add("line "+(ID2!=null?ID2.getLine():0)+": duplicated variable name "+(ID2!=null?ID2.getText():null));
            		}
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:125:2: ( ASSIGN_OP firstAssign= spec_type )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ASSIGN_OP) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:126:3: ASSIGN_OP firstAssign= spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_variableDeclarator207); 
                    pushFollow(FOLLOW_spec_type_in_variableDeclarator211);
                    firstAssign=spec_type();

                    state._fsp--;


                    			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, firstAssign))
                    			{
                    				errors.add("line "+(ID2!=null?ID2.getLine():0)+": mismatch - variable name "+(ID2!=null?ID2.getText():null));
                    			}
                    		

                    }
                    break;

            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:134:2: ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=PLUS_OP && LA8_0<=MINUS_OP)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:134:3: ( PLUS_OP | MINUS_OP ) secondAssign= spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_variableDeclarator231);
            	    secondAssign=spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            variableDeclarator_stack.pop();
        }
        return ;
    }
    // $ANTLR end "variableDeclarator"


    // $ANTLR start "init_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:138:1: init_var : ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* ;
    public final void init_var() throws RecognitionException {
        Token ID3=null;
        String firstAssign = null;

        String secondAssign = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:139:2: ( ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:139:4: ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            {
            ID3=(Token)match(input,ID,FOLLOW_ID_in_init_var247); 

            		if(!names.isDeclaredVariable("global"+"."+(ID3!=null?ID3.getText():null)))
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID3!=null?ID3.getText():null)))
            			{
            				errors.add("line "+(ID3!=null?ID3.getLine():0)+": mismatch - variable name "+(ID3!=null?ID3.getText():null));
            			}
            		}
            	
            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_init_var253); 
            pushFollow(FOLLOW_spec_type_in_init_var257);
            firstAssign=spec_type();

            state._fsp--;


            		if(names.isExistVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID3!=null?ID3.getText():null)))
            		{
            			NamesTable.VariableName var_type = names.getVariable((ID3!=null?ID3.getText():null));
            			String type = var_type.getType();
            			if(!TypesChecker.checkTypes(type, firstAssign))
            			{
            				errors.add("line "+(ID3!=null?ID3.getLine():0)+": mismatch - variable name "+(ID3!=null?ID3.getText():null));
            			}
            		}
            		else
            		{
            			errors.add("line "+(ID3!=null?ID3.getLine():0)+": variable name "+(ID3!=null?ID3.getText():null)+" is not exist");
            		}
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:165:2: ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=PLUS_OP && LA9_0<=MINUS_OP)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:165:3: ( PLUS_OP | MINUS_OP ) secondAssign= spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_init_var272);
            	    secondAssign=spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "init_var"


    // $ANTLR start "inside_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:169:1: inside_func : ( elem | length | print_op | break_op | read_op | write_op );
    public final void inside_func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:170:2: ( elem | length | print_op | break_op | read_op | write_op )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt10=1;
                }
                break;
            case 38:
                {
                alt10=2;
                }
                break;
            case 37:
                {
                alt10=3;
                }
                break;
            case 40:
                {
                alt10=4;
                }
                break;
            case 33:
                {
                alt10=5;
                }
                break;
            case 32:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:170:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_inside_func287);
                    elem();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:171:4: length
                    {
                    pushFollow(FOLLOW_length_in_inside_func292);
                    length();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:172:4: print_op
                    {
                    pushFollow(FOLLOW_print_op_in_inside_func297);
                    print_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:173:4: break_op
                    {
                    pushFollow(FOLLOW_break_op_in_inside_func304);
                    break_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:174:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_inside_func309);
                    read_op();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:175:4: write_op
                    {
                    pushFollow(FOLLOW_write_op_in_inside_func315);
                    write_op();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "inside_func"


    // $ANTLR start "assign_inside_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:178:1: assign_inside_func returns [String type] : ( elem | length | read_op );
    public final String assign_inside_func() throws RecognitionException {
        String type = null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:179:2: ( elem | length | read_op )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt11=1;
                }
                break;
            case 38:
                {
                alt11=2;
                }
                break;
            case 33:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:179:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_assign_inside_func330);
                    elem();

                    state._fsp--;

                    type = "char";

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:180:4: length
                    {
                    pushFollow(FOLLOW_length_in_assign_inside_func337);
                    length();

                    state._fsp--;

                    type = "int";

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:181:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_assign_inside_func344);
                    read_op();

                    state._fsp--;

                    type = "string";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "assign_inside_func"

    protected static class call_func_scope {
        String methodName;
    }
    protected Stack call_func_stack = new Stack();

    public static class call_func_return extends ParserRuleReturnScope {
        public String type;
        public int curLine;
    };

    // $ANTLR start "call_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:184:1: call_func returns [String type, int curLine] : ID '(' ( param )? ')' ;
    public final StrLangParser.call_func_return call_func() throws RecognitionException {
        call_func_stack.push(new call_func_scope());
        StrLangParser.call_func_return retval = new StrLangParser.call_func_return();
        retval.start = input.LT(1);

        Token ID4=null;
        ArrayList<String> param5 = null;



        	((call_func_scope)call_func_stack.peek()).methodName ="";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:191:2: ( ID '(' ( param )? ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:191:4: ID '(' ( param )? ')'
            {
            ID4=(Token)match(input,ID,FOLLOW_ID_in_call_func368); 
            ((call_func_scope)call_func_stack.peek()).methodName =(ID4!=null?ID4.getText():null);
            match(input,30,FOLLOW_30_in_call_func372); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:191:46: ( param )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID||(LA12_0>=INT && LA12_0<=SYMBOL)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:191:46: param
                    {
                    pushFollow(FOLLOW_param_in_call_func374);
                    param5=param();

                    state._fsp--;


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_call_func377); 

            		retval.curLine = (ID4!=null?ID4.getLine():0);
            		ArrayList<String> list = null;
            		if(param5==null)
            			list = new ArrayList<String>();
            		else
            			list = param5;
            		if(!names.checkCallFunction((ID4!=null?ID4.getText():null), list, (ID4!=null?ID4.getLine():0)))
            		{
            			names.getAllErrors(errors);
            		}
            		if(!names.isExistFunction((ID4!=null?ID4.getText():null)))
            		{
            			errors.add("line "+(ID4!=null?ID4.getLine():0)+": function "+(ID4!=null?ID4.getText():null)+" is not exist");
            		}
            		else
            		{
            			NamesTable.FunctionName func = names.getFunction((ID4!=null?ID4.getText():null));
            			retval.type = func.getReturnType();
            		}
            	

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            call_func_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "call_func"


    // $ANTLR start "action"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:215:1: action : spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) ;
    public final void action() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:216:2: ( spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:216:4: spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            {
            pushFollow(FOLLOW_spec_type_in_action393);
            spec_type();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:216:14: ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            int alt13=3;
            switch ( input.LA(1) ) {
            case DOUBLE_MINUS:
                {
                alt13=1;
                }
                break;
            case DOUBLE_PLUS:
                {
                alt13=2;
                }
                break;
            case ASSIGN_OP:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:216:15: DOUBLE_MINUS
                    {
                    match(input,DOUBLE_MINUS,FOLLOW_DOUBLE_MINUS_in_action396); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:216:28: DOUBLE_PLUS
                    {
                    match(input,DOUBLE_PLUS,FOLLOW_DOUBLE_PLUS_in_action398); 

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:216:40: ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_action400); 
                    pushFollow(FOLLOW_spec_type_in_action402);
                    spec_type();

                    state._fsp--;

                    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_spec_type_in_action410);
                    spec_type();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "action"


    // $ANTLR start "spec_type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:219:1: spec_type returns [String value] : ( INT | LINE | SYMBOL | idLiteral | assign_inside_func | call_func );
    public final String spec_type() throws RecognitionException {
        String value = null;

        StrLangParser.idLiteral_return idLiteral6 = null;

        String assign_inside_func7 = null;

        StrLangParser.call_func_return call_func8 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:220:2: ( INT | LINE | SYMBOL | idLiteral | assign_inside_func | call_func )
            int alt14=6;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt14=1;
                }
                break;
            case LINE:
                {
                alt14=2;
                }
                break;
            case SYMBOL:
                {
                alt14=3;
                }
                break;
            case ID:
                {
                int LA14_4 = input.LA(2);

                if ( ((LA14_4>=ID && LA14_4<=DOUBLE_PLUS)||(LA14_4>=LINE_TYPE && LA14_4<=VOID_TYPE)||LA14_4==26||(LA14_4>=28 && LA14_4<=29)||(LA14_4>=31 && LA14_4<=42)) ) {
                    alt14=4;
                }
                else if ( (LA14_4==30) ) {
                    alt14=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 4, input);

                    throw nvae;
                }
                }
                break;
            case 33:
            case 38:
            case 39:
                {
                alt14=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:220:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_spec_type430); 
                    value = "int";

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:221:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_spec_type437); 
                    value = "string";

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:222:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_spec_type444); 
                    value = "char";

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:223:4: idLiteral
                    {
                    pushFollow(FOLLOW_idLiteral_in_spec_type451);
                    idLiteral6=idLiteral();

                    state._fsp--;

                    value = (idLiteral6!=null?idLiteral6.idType:null);

                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:224:4: assign_inside_func
                    {
                    pushFollow(FOLLOW_assign_inside_func_in_spec_type458);
                    assign_inside_func7=assign_inside_func();

                    state._fsp--;

                    value = assign_inside_func7;

                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:225:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_spec_type465);
                    call_func8=call_func();

                    state._fsp--;

                    value = (call_func8!=null?call_func8.type:null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "spec_type"

    public static class returnType_return extends ParserRuleReturnScope {
        public String value;
        public String type;
    };

    // $ANTLR start "returnType"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:228:1: returnType returns [String value, String type] : ( INT | LINE | SYMBOL | idLiteral );
    public final StrLangParser.returnType_return returnType() throws RecognitionException {
        StrLangParser.returnType_return retval = new StrLangParser.returnType_return();
        retval.start = input.LT(1);

        Token INT9=null;
        Token LINE10=null;
        Token SYMBOL11=null;
        StrLangParser.idLiteral_return idLiteral12 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:229:2: ( INT | LINE | SYMBOL | idLiteral )
            int alt15=4;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt15=1;
                }
                break;
            case LINE:
                {
                alt15=2;
                }
                break;
            case SYMBOL:
                {
                alt15=3;
                }
                break;
            case ID:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:229:4: INT
                    {
                    INT9=(Token)match(input,INT,FOLLOW_INT_in_returnType482); 
                    retval.value = (INT9!=null?INT9.getText():null); retval.type = "int";

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:230:4: LINE
                    {
                    LINE10=(Token)match(input,LINE,FOLLOW_LINE_in_returnType489); 
                    retval.value = (LINE10!=null?LINE10.getText():null); retval.type = "string";

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:231:4: SYMBOL
                    {
                    SYMBOL11=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_returnType496); 
                    retval.value = (SYMBOL11!=null?SYMBOL11.getText():null); retval.type = "char";

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:232:4: idLiteral
                    {
                    pushFollow(FOLLOW_idLiteral_in_returnType503);
                    idLiteral12=idLiteral();

                    state._fsp--;

                    retval.value = (idLiteral12!=null?input.toString(idLiteral12.start,idLiteral12.stop):null); retval.type = (idLiteral12!=null?idLiteral12.idType:null);

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "returnType"

    public static class idLiteral_return extends ParserRuleReturnScope {
        public String idType;
        public int curLine;
    };

    // $ANTLR start "idLiteral"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:235:1: idLiteral returns [String idType, int curLine] : ID ;
    public final StrLangParser.idLiteral_return idLiteral() throws RecognitionException {
        StrLangParser.idLiteral_return retval = new StrLangParser.idLiteral_return();
        retval.start = input.LT(1);

        Token ID13=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:236:2: ( ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:236:4: ID
            {
            ID13=(Token)match(input,ID,FOLLOW_ID_in_idLiteral520); 

            		retval.curLine = (ID13!=null?ID13.getLine():0);
            		if(!names.isExistVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID13!=null?ID13.getText():null)))
            		{
            			errors.add("line "+(ID13!=null?ID13.getLine():0)+": unknown variable "+(ID13!=null?ID13.getText():null));
            			retval.idType = "";
            		}
            		else
            		{
            			names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID13!=null?ID13.getText():null)).addLineUses((ID13!=null?ID13.getLine():0));
            			retval.idType = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID13!=null?ID13.getText():null)).getType();
            		}
            	

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "idLiteral"

    public static class type_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:252:1: type : ( 'string' | 'int' | 'char' | 'void' );
    public final StrLangParser.type_return type() throws RecognitionException {
        StrLangParser.type_return retval = new StrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:253:2: ( 'string' | 'int' | 'char' | 'void' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:
            {
            if ( (input.LA(1)>=LINE_TYPE && input.LA(1)<=VOID_TYPE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    protected static class global_func_scope {
        String funcName;
        String funcType;
        ArrayList<String> funcArgNames;
        ArrayList<String> funcArgTypes;
        String returnVariable;
        boolean isReturnUsed;
    }
    protected Stack global_func_stack = new Stack();


    // $ANTLR start "global_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:259:1: global_func : type ID '(' ( functionArgumentList )? ')' '{' ( body )? ( return_op )? '}' ;
    public final void global_func() throws RecognitionException {
        global_func_stack.push(new global_func_scope());
        Token ID15=null;
        StrLangParser.type_return type14 = null;



        	((global_func_scope)global_func_stack.peek()).funcName = "";
        	((global_func_scope)global_func_stack.peek()).funcType = "";
        	((global_func_scope)global_func_stack.peek()).returnVariable = "";
        	((global_func_scope)global_func_stack.peek()).isReturnUsed = false;
        	((global_func_scope)global_func_stack.peek()).funcArgNames = new ArrayList<String>();
        	((global_func_scope)global_func_stack.peek()).funcArgTypes = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:276:2: ( type ID '(' ( functionArgumentList )? ')' '{' ( body )? ( return_op )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:276:4: type ID '(' ( functionArgumentList )? ')' '{' ( body )? ( return_op )? '}'
            {
            pushFollow(FOLLOW_type_in_global_func571);
            type14=type();

            state._fsp--;

            ((global_func_scope)global_func_stack.peek()).funcType = (type14!=null?input.toString(type14.start,type14.stop):null);
            ID15=(Token)match(input,ID,FOLLOW_ID_in_global_func575); 
            ((program_scope)program_stack.peek()).curBlock = (ID15!=null?ID15.getText():null);
            match(input,30,FOLLOW_30_in_global_func580); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:277:7: ( functionArgumentList )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=LINE_TYPE && LA16_0<=VOID_TYPE)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:277:7: functionArgumentList
                    {
                    pushFollow(FOLLOW_functionArgumentList_in_global_func582);
                    functionArgumentList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_global_func585); 

            	 	if(!names.isExistFunction((ID15!=null?ID15.getText():null)))
            	 	{
            	 		names.addFunction(names.new FunctionName((ID15!=null?ID15.getText():null), (type14!=null?input.toString(type14.start,type14.stop):null), ((global_func_scope)global_func_stack.peek()).funcArgTypes, ((global_func_scope)global_func_stack.peek()).funcArgNames, (ID15!=null?ID15.getLine():0)));
            	 	}
            	 	else
            	 	{
            	 		errors.add("line "+(ID15!=null?ID15.getLine():0)+": duplicated declaration function "+(ID15!=null?ID15.getText():null));
            	 	}
            	 
            match(input,27,FOLLOW_27_in_global_func597); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:290:6: ( body )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ID||(LA17_0>=LINE_TYPE && LA17_0<=VOID_TYPE)||(LA17_0>=32 && LA17_0<=35)||(LA17_0>=37 && LA17_0<=40)||LA17_0==42) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:290:6: body
                    {
                    pushFollow(FOLLOW_body_in_global_func605);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:291:6: ( return_op )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==41) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:292:7: return_op
                    {
                    pushFollow(FOLLOW_return_op_in_global_func622);
                    return_op();

                    state._fsp--;


                    				  	boolean result = names.checkReturnType((ID15!=null?ID15.getText():null), ((global_func_scope)global_func_stack.peek()).returnVariable, ((program_scope)program_stack.peek()).curBlock, (ID15!=null?ID15.getLine():0));
                    				  	if(result==false)
                    				  	{
                    				  		errors.add(names.getLastError());
                    				  	}
                    			  	

                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_global_func643); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            global_func_stack.pop();
        }
        return ;
    }
    // $ANTLR end "global_func"


    // $ANTLR start "functionArgumentList"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:304:1: functionArgumentList : functionArgumentDeclarator ( ',' functionArgumentDeclarator )* ;
    public final void functionArgumentList() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:305:2: ( functionArgumentDeclarator ( ',' functionArgumentDeclarator )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:305:4: functionArgumentDeclarator ( ',' functionArgumentDeclarator )*
            {
            pushFollow(FOLLOW_functionArgumentDeclarator_in_functionArgumentList657);
            functionArgumentDeclarator();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:305:31: ( ',' functionArgumentDeclarator )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:305:32: ',' functionArgumentDeclarator
            	    {
            	    match(input,29,FOLLOW_29_in_functionArgumentList660); 
            	    pushFollow(FOLLOW_functionArgumentDeclarator_in_functionArgumentList662);
            	    functionArgumentDeclarator();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "functionArgumentList"


    // $ANTLR start "functionArgumentDeclarator"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:308:1: functionArgumentDeclarator : type ID ;
    public final void functionArgumentDeclarator() throws RecognitionException {
        Token ID17=null;
        StrLangParser.type_return type16 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:2: ( type ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:4: type ID
            {
            pushFollow(FOLLOW_type_in_functionArgumentDeclarator676);
            type16=type();

            state._fsp--;

            ID17=(Token)match(input,ID,FOLLOW_ID_in_functionArgumentDeclarator678); 

            		((global_func_scope)global_func_stack.peek()).funcArgTypes.add((type16!=null?input.toString(type16.start,type16.stop):null));
            		((global_func_scope)global_func_stack.peek()).funcArgNames.add((ID17!=null?ID17.getText():null));
            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID17!=null?ID17.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID17!=null?ID17.getText():null), (type16!=null?input.toString(type16.start,type16.stop):null), (ID17!=null?ID17.getLine():0)));
            		}
            		else
            		{
            			errors.add("line "+(ID17!=null?ID17.getLine():0)+": duplicated variable name "+(ID17!=null?ID17.getText():null));
            		}
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "functionArgumentDeclarator"


    // $ANTLR start "param"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:324:1: param returns [ArrayList<String> argumentTypeList] : a= returnType ( ',' b= returnType )* ;
    public final ArrayList<String> param() throws RecognitionException {
        ArrayList<String> argumentTypeList = null;

        StrLangParser.returnType_return a = null;

        StrLangParser.returnType_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:325:2: (a= returnType ( ',' b= returnType )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:326:2: a= returnType ( ',' b= returnType )*
            {

            		argumentTypeList = new ArrayList<String>();
            	
            pushFollow(FOLLOW_returnType_in_param705);
            a=returnType();

            state._fsp--;

            argumentTypeList.add((a!=null?a.type:null));
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:329:48: ( ',' b= returnType )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==29) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:329:49: ',' b= returnType
            	    {
            	    match(input,29,FOLLOW_29_in_param710); 
            	    pushFollow(FOLLOW_returnType_in_param714);
            	    b=returnType();

            	    state._fsp--;

            	    argumentTypeList.add((b!=null?b.type:null));

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            		
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return argumentTypeList;
    }
    // $ANTLR end "param"


    // $ANTLR start "body"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:335:1: body : ( variables | func | if_op | for_op | while_op )+ ;
    public final void body() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:336:2: ( ( variables | func | if_op | for_op | while_op )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:336:3: ( variables | func | if_op | for_op | while_op )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:336:3: ( variables | func | if_op | for_op | while_op )+
            int cnt21=0;
            loop21:
            do {
                int alt21=6;
                switch ( input.LA(1) ) {
                case LINE_TYPE:
                case INT_TYPE:
                case SYMBOL_TYPE:
                case VOID_TYPE:
                    {
                    alt21=1;
                    }
                    break;
                case ID:
                    {
                    int LA21_3 = input.LA(2);

                    if ( (LA21_3==ASSIGN_OP) ) {
                        alt21=1;
                    }
                    else if ( (LA21_3==30) ) {
                        alt21=2;
                    }


                    }
                    break;
                case 32:
                case 33:
                case 37:
                case 38:
                case 39:
                case 40:
                    {
                    alt21=2;
                    }
                    break;
                case 42:
                    {
                    alt21=3;
                    }
                    break;
                case 35:
                    {
                    alt21=4;
                    }
                    break;
                case 34:
                    {
                    alt21=5;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:336:4: variables
            	    {
            	    pushFollow(FOLLOW_variables_in_body734);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:337:4: func
            	    {
            	    pushFollow(FOLLOW_func_in_body739);
            	    func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:338:4: if_op
            	    {
            	    pushFollow(FOLLOW_if_op_in_body744);
            	    if_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:339:4: for_op
            	    {
            	    pushFollow(FOLLOW_for_op_in_body749);
            	    for_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:340:4: while_op
            	    {
            	    pushFollow(FOLLOW_while_op_in_body754);
            	    while_op();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "body"


    // $ANTLR start "write_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:343:1: write_op : 'WriteToFile' '(' ID ',' ID ')' ;
    public final void write_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:344:2: ( 'WriteToFile' '(' ID ',' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:344:4: 'WriteToFile' '(' ID ',' ID ')'
            {
            match(input,32,FOLLOW_32_in_write_op769); 
            match(input,30,FOLLOW_30_in_write_op771); 
            match(input,ID,FOLLOW_ID_in_write_op774); 
            match(input,29,FOLLOW_29_in_write_op776); 
            match(input,ID,FOLLOW_ID_in_write_op779); 
            match(input,31,FOLLOW_31_in_write_op782); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "write_op"


    // $ANTLR start "read_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:347:1: read_op : 'ReadFile' '(' ID ')' ;
    public final void read_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:348:2: ( 'ReadFile' '(' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:348:4: 'ReadFile' '(' ID ')'
            {
            match(input,33,FOLLOW_33_in_read_op793); 
            match(input,30,FOLLOW_30_in_read_op795); 
            match(input,ID,FOLLOW_ID_in_read_op798); 
            match(input,31,FOLLOW_31_in_read_op802); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "read_op"


    // $ANTLR start "while_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:351:1: while_op : 'while' '(' logic ')' '{' ( body )? '}' ;
    public final void while_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:352:2: ( 'while' '(' logic ')' '{' ( body )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:352:4: 'while' '(' logic ')' '{' ( body )? '}'
            {
            match(input,34,FOLLOW_34_in_while_op813); 
            match(input,30,FOLLOW_30_in_while_op815); 
            pushFollow(FOLLOW_logic_in_while_op817);
            logic();

            state._fsp--;

            match(input,31,FOLLOW_31_in_while_op819); 
            match(input,27,FOLLOW_27_in_while_op821); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:352:30: ( body )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ID||(LA22_0>=LINE_TYPE && LA22_0<=VOID_TYPE)||(LA22_0>=32 && LA22_0<=35)||(LA22_0>=37 && LA22_0<=40)||LA22_0==42) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:352:30: body
                    {
                    pushFollow(FOLLOW_body_in_while_op823);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_while_op826); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "while_op"


    // $ANTLR start "for_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:354:1: for_op : 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' ;
    public final void for_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:2: ( 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:4: 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}'
            {
            match(input,35,FOLLOW_35_in_for_op840); 
            match(input,30,FOLLOW_30_in_for_op842); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:14: ( variables )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID||(LA23_0>=LINE_TYPE && LA23_0<=VOID_TYPE)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:14: variables
                    {
                    pushFollow(FOLLOW_variables_in_for_op844);
                    variables();

                    state._fsp--;


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_for_op847); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:29: ( logic )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID||(LA24_0>=INT && LA24_0<=SYMBOL)||LA24_0==END_LINE||LA24_0==30||LA24_0==33||(LA24_0>=38 && LA24_0<=39)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:29: logic
                    {
                    pushFollow(FOLLOW_logic_in_for_op849);
                    logic();

                    state._fsp--;


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_for_op852); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:40: ( action )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ID||(LA25_0>=INT && LA25_0<=SYMBOL)||LA25_0==33||(LA25_0>=38 && LA25_0<=39)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:40: action
                    {
                    pushFollow(FOLLOW_action_in_for_op854);
                    action();

                    state._fsp--;


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_for_op857); 
            match(input,27,FOLLOW_27_in_for_op859); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:56: ( body )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ID||(LA26_0>=LINE_TYPE && LA26_0<=VOID_TYPE)||(LA26_0>=32 && LA26_0<=35)||(LA26_0>=37 && LA26_0<=40)||LA26_0==42) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:355:56: body
                    {
                    pushFollow(FOLLOW_body_in_for_op861);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_for_op864); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "for_op"


    // $ANTLR start "print_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:358:1: print_op : 'print' '(' spec_type ( ',' spec_type )* ')' ;
    public final void print_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:359:2: ( 'print' '(' spec_type ( ',' spec_type )* ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:359:4: 'print' '(' spec_type ( ',' spec_type )* ')'
            {
            match(input,37,FOLLOW_37_in_print_op875); 
            match(input,30,FOLLOW_30_in_print_op877); 
            pushFollow(FOLLOW_spec_type_in_print_op879);
            spec_type();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:359:26: ( ',' spec_type )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==29) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:359:27: ',' spec_type
            	    {
            	    match(input,29,FOLLOW_29_in_print_op882); 
            	    pushFollow(FOLLOW_spec_type_in_print_op884);
            	    spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            match(input,31,FOLLOW_31_in_print_op889); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "print_op"


    // $ANTLR start "length"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:362:1: length : 'length' '(' spec_type ')' ;
    public final void length() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:363:2: ( 'length' '(' spec_type ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:363:4: 'length' '(' spec_type ')'
            {
            match(input,38,FOLLOW_38_in_length902); 
            match(input,30,FOLLOW_30_in_length904); 
            pushFollow(FOLLOW_spec_type_in_length906);
            spec_type();

            state._fsp--;

            match(input,31,FOLLOW_31_in_length908); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "length"


    // $ANTLR start "elem"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:366:1: elem : 'elem' '(' spec_type ',' specialType ')' ;
    public final void elem() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:367:2: ( 'elem' '(' spec_type ',' specialType ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:367:3: 'elem' '(' spec_type ',' specialType ')'
            {
            match(input,39,FOLLOW_39_in_elem919); 
            match(input,30,FOLLOW_30_in_elem921); 
            pushFollow(FOLLOW_spec_type_in_elem923);
            spec_type();

            state._fsp--;

            match(input,29,FOLLOW_29_in_elem925); 
            pushFollow(FOLLOW_specialType_in_elem927);
            specialType();

            state._fsp--;

            match(input,31,FOLLOW_31_in_elem929); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "elem"


    // $ANTLR start "break_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:370:1: break_op : 'break' ;
    public final void break_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:371:2: ( 'break' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:371:4: 'break'
            {
            match(input,40,FOLLOW_40_in_break_op941); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "break_op"


    // $ANTLR start "return_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:375:1: return_op : 'return' returnType ;
    public final void return_op() throws RecognitionException {
        StrLangParser.returnType_return returnType18 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:376:3: ( 'return' returnType )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:376:5: 'return' returnType
            {
            match(input,41,FOLLOW_41_in_return_op956); 
            pushFollow(FOLLOW_returnType_in_return_op958);
            returnType18=returnType();

            state._fsp--;


             		((global_func_scope)global_func_stack.peek()).returnVariable = (returnType18!=null?returnType18.value:null);
             	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "return_op"


    // $ANTLR start "if_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:382:1: if_op : 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? ;
    public final void if_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:383:2: ( 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:383:4: 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )?
            {
            match(input,42,FOLLOW_42_in_if_op974); 
            match(input,30,FOLLOW_30_in_if_op976); 
            pushFollow(FOLLOW_logic_in_if_op978);
            logic();

            state._fsp--;

            match(input,31,FOLLOW_31_in_if_op980); 
            match(input,27,FOLLOW_27_in_if_op982); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:383:27: ( body )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==ID||(LA28_0>=LINE_TYPE && LA28_0<=VOID_TYPE)||(LA28_0>=32 && LA28_0<=35)||(LA28_0>=37 && LA28_0<=40)||LA28_0==42) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:383:27: body
                    {
                    pushFollow(FOLLOW_body_in_if_op984);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_if_op987); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:383:37: ( 'else' '{' ( body )? '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==43) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:383:38: 'else' '{' ( body )? '}'
                    {
                    match(input,43,FOLLOW_43_in_if_op990); 
                    match(input,27,FOLLOW_27_in_if_op992); 
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:383:49: ( body )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==ID||(LA29_0>=LINE_TYPE && LA29_0<=VOID_TYPE)||(LA29_0>=32 && LA29_0<=35)||(LA29_0>=37 && LA29_0<=40)||LA29_0==42) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:383:49: body
                            {
                            pushFollow(FOLLOW_body_in_if_op994);
                            body();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,28,FOLLOW_28_in_if_op997); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "if_op"


    // $ANTLR start "expr"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:386:1: expr : ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY );
    public final void expr() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:387:2: ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:
            {
            if ( (input.LA(1)>=EQUALLY_EQL_OP && input.LA(1)<=NO_EQUALLY) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expr"


    // $ANTLR start "logic"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:395:1: logic : logic_and ;
    public final void logic() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:396:2: ( logic_and )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:396:4: logic_and
            {
            pushFollow(FOLLOW_logic_and_in_logic1047);
            logic_and();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logic"


    // $ANTLR start "logic_and"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:399:1: logic_and : logic_or ( 'and' logic_or )* ;
    public final void logic_and() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:400:2: ( logic_or ( 'and' logic_or )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:400:4: logic_or ( 'and' logic_or )*
            {
            pushFollow(FOLLOW_logic_or_in_logic_and1060);
            logic_or();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:400:13: ( 'and' logic_or )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==44) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:400:14: 'and' logic_or
            	    {
            	    match(input,44,FOLLOW_44_in_logic_and1063); 
            	    pushFollow(FOLLOW_logic_or_in_logic_and1065);
            	    logic_or();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logic_and"


    // $ANTLR start "logic_or"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:402:1: logic_or : logic_expr ( 'or' logic_expr )* ;
    public final void logic_or() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:403:2: ( logic_expr ( 'or' logic_expr )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:403:4: logic_expr ( 'or' logic_expr )*
            {
            pushFollow(FOLLOW_logic_expr_in_logic_or1078);
            logic_expr();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:403:15: ( 'or' logic_expr )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==45) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:403:16: 'or' logic_expr
            	    {
            	    match(input,45,FOLLOW_45_in_logic_or1081); 
            	    pushFollow(FOLLOW_logic_expr_in_logic_or1083);
            	    logic_expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logic_or"


    // $ANTLR start "logic_expr"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:407:1: logic_expr : ( logic_atom ( expr logic_atom )? | '(' logic ')' );
    public final void logic_expr() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:408:2: ( logic_atom ( expr logic_atom )? | '(' logic ')' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ID||(LA34_0>=INT && LA34_0<=SYMBOL)||LA34_0==END_LINE||LA34_0==33||(LA34_0>=38 && LA34_0<=39)) ) {
                alt34=1;
            }
            else if ( (LA34_0==30) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:408:4: logic_atom ( expr logic_atom )?
                    {
                    pushFollow(FOLLOW_logic_atom_in_logic_expr1097);
                    logic_atom();

                    state._fsp--;

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:408:15: ( expr logic_atom )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=EQUALLY_EQL_OP && LA33_0<=NO_EQUALLY)) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:408:16: expr logic_atom
                            {
                            pushFollow(FOLLOW_expr_in_logic_expr1100);
                            expr();

                            state._fsp--;

                            pushFollow(FOLLOW_logic_atom_in_logic_expr1102);
                            logic_atom();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:409:4: '(' logic ')'
                    {
                    match(input,30,FOLLOW_30_in_logic_expr1109); 
                    pushFollow(FOLLOW_logic_in_logic_expr1111);
                    logic();

                    state._fsp--;

                    match(input,31,FOLLOW_31_in_logic_expr1113); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logic_expr"


    // $ANTLR start "logic_atom"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:412:1: logic_atom : ( LINE | SYMBOL | INT | ID | assign_inside_func | END_LINE );
    public final void logic_atom() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:413:2: ( LINE | SYMBOL | INT | ID | assign_inside_func | END_LINE )
            int alt35=6;
            switch ( input.LA(1) ) {
            case LINE:
                {
                alt35=1;
                }
                break;
            case SYMBOL:
                {
                alt35=2;
                }
                break;
            case INT:
                {
                alt35=3;
                }
                break;
            case ID:
                {
                alt35=4;
                }
                break;
            case 33:
            case 38:
            case 39:
                {
                alt35=5;
                }
                break;
            case END_LINE:
                {
                alt35=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:413:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_logic_atom1124); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:414:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_logic_atom1129); 

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_logic_atom1134); 

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:416:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_logic_atom1139); 

                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:417:4: assign_inside_func
                    {
                    pushFollow(FOLLOW_assign_inside_func_in_logic_atom1144);
                    assign_inside_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:418:4: END_LINE
                    {
                    match(input,END_LINE,FOLLOW_END_LINE_in_logic_atom1149); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logic_atom"


    // $ANTLR start "specialType"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:421:1: specialType : ( INT | ID );
    public final void specialType() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:422:2: ( INT | ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:
            {
            if ( input.LA(1)==ID||input.LA(1)==INT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "specialType"

    // Delegated rules


 

    public static final BitSet FOLLOW_global_decl_in_program50 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_mainBlock_in_program55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_mainBlock68 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_mainBlock70 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_mainBlock72 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_mainBlock75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variables_in_global_decl90 = new BitSet(new long[]{0x000001E300F00012L});
    public static final BitSet FOLLOW_global_func_in_global_decl95 = new BitSet(new long[]{0x000001E300F00012L});
    public static final BitSet FOLLOW_func_in_global_decl100 = new BitSet(new long[]{0x000001E300F00012L});
    public static final BitSet FOLLOW_inside_func_in_func113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_func118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_var_in_variables135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_var_in_variables139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_var151 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarators_in_decl_var157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators169 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_variableDeclarators172 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators174 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ID_in_variableDeclarator195 = new BitSet(new long[]{0x00000000000000E2L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_variableDeclarator207 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_variableDeclarator211 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_variableDeclarator223 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_variableDeclarator231 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_ID_in_init_var247 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_init_var253 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_init_var257 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_init_var264 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_init_var272 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_elem_in_inside_func287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_inside_func292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_op_in_inside_func297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_op_in_inside_func304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_inside_func309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_op_in_inside_func315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elem_in_assign_inside_func330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_assign_inside_func337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_assign_inside_func344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func368 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_call_func372 = new BitSet(new long[]{0x0000000080001C10L});
    public static final BitSet FOLLOW_param_in_call_func374 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_call_func377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action393 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_DOUBLE_MINUS_in_action396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_PLUS_in_action398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_action400 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_action402 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_action404 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_action410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_spec_type430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_spec_type437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_spec_type444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idLiteral_in_spec_type451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_inside_func_in_spec_type458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_spec_type465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_returnType482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_returnType489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_returnType496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idLiteral_in_returnType503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_idLiteral520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_func571 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_func575 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_global_func580 = new BitSet(new long[]{0x0000000080F00000L});
    public static final BitSet FOLLOW_functionArgumentList_in_global_func582 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_global_func585 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_global_func597 = new BitSet(new long[]{0x000007EF10F00010L});
    public static final BitSet FOLLOW_body_in_global_func605 = new BitSet(new long[]{0x0000020010000000L});
    public static final BitSet FOLLOW_return_op_in_global_func622 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_global_func643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionArgumentDeclarator_in_functionArgumentList657 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_functionArgumentList660 = new BitSet(new long[]{0x0000000000F00000L});
    public static final BitSet FOLLOW_functionArgumentDeclarator_in_functionArgumentList662 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_type_in_functionArgumentDeclarator676 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functionArgumentDeclarator678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnType_in_param705 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_param710 = new BitSet(new long[]{0x0000000000001C10L});
    public static final BitSet FOLLOW_returnType_in_param714 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_variables_in_body734 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_func_in_body739 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_if_op_in_body744 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_for_op_in_body749 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_while_op_in_body754 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_32_in_write_op769 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_write_op771 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_write_op774 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_write_op776 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_write_op779 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_write_op782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_read_op793 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_read_op795 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_read_op798 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_read_op802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_while_op813 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_while_op815 = new BitSet(new long[]{0x000000C240081C10L});
    public static final BitSet FOLLOW_logic_in_while_op817 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_while_op819 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_while_op821 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_while_op823 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_while_op826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_for_op840 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_for_op842 = new BitSet(new long[]{0x0000001000F00010L});
    public static final BitSet FOLLOW_variables_in_for_op844 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_for_op847 = new BitSet(new long[]{0x000000D240081C10L});
    public static final BitSet FOLLOW_logic_in_for_op849 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_for_op852 = new BitSet(new long[]{0x000001E380001C10L});
    public static final BitSet FOLLOW_action_in_for_op854 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_for_op857 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_for_op859 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_for_op861 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_for_op864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_print_op875 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_print_op877 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_print_op879 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_29_in_print_op882 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_print_op884 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_31_in_print_op889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_length902 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_length904 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_length906 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_length908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_elem919 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_elem921 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_elem923 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_elem925 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_specialType_in_elem927 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_elem929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_break_op941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_op956 = new BitSet(new long[]{0x0000000000001C10L});
    public static final BitSet FOLLOW_returnType_in_return_op958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_if_op974 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_if_op976 = new BitSet(new long[]{0x000000C240081C10L});
    public static final BitSet FOLLOW_logic_in_if_op978 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_if_op980 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op982 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_if_op984 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_if_op987 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_if_op990 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op992 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_if_op994 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_if_op997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expr0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_and_in_logic1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_or_in_logic_and1060 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_logic_and1063 = new BitSet(new long[]{0x000000C240081C10L});
    public static final BitSet FOLLOW_logic_or_in_logic_and1065 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or1078 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_logic_or1081 = new BitSet(new long[]{0x000000C240081C10L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or1083 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr1097 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_expr_in_logic_expr1100 = new BitSet(new long[]{0x000000C200081C10L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_logic_expr1109 = new BitSet(new long[]{0x000000C240081C10L});
    public static final BitSet FOLLOW_logic_in_logic_expr1111 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_logic_expr1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_logic_atom1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_logic_atom1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_logic_atom1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_logic_atom1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_inside_func_in_logic_atom1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_LINE_in_logic_atom1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_specialType0 = new BitSet(new long[]{0x0000000000000002L});

}