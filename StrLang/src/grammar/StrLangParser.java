// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g 2012-05-03 21:04:50

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
            ((program_scope)program_stack.peek()).curBlock = "global";
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:72:2: ( variables | global_func | func )+
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

                        if ( ((LA3_5>=ID && LA3_5<=ASSIGN_OP)||(LA3_5>=LINE_TYPE && LA3_5<=VOID_TYPE)||LA3_5==26||LA3_5==29||(LA3_5>=32 && LA3_5<=33)||(LA3_5>=37 && LA3_5<=40)) ) {
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
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:72:3: variables
            	    {
            	    pushFollow(FOLLOW_variables_in_global_decl93);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:73:4: global_func
            	    {
            	    pushFollow(FOLLOW_global_func_in_global_decl98);
            	    global_func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:74:4: func
            	    {
            	    pushFollow(FOLLOW_func_in_global_decl103);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:77:1: func : ( inside_func | call_func );
    public final void func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:78:2: ( inside_func | call_func )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:78:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_func116);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:79:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_func121);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:82:1: variables : ( decl_var | init_var );
    public final void variables() throws RecognitionException {
        variables_stack.push(new variables_scope());

        	((variables_scope)variables_stack.peek()).varType = "";

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
                    pushFollow(FOLLOW_decl_var_in_variables138);
                    decl_var();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:90:3: init_var
                    {
                    pushFollow(FOLLOW_init_var_in_variables142);
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
            pushFollow(FOLLOW_type_in_decl_var154);
            type1=type();

            state._fsp--;


            		((variables_scope)variables_stack.peek()).varType = (type1!=null?input.toString(type1.start,type1.stop):null);
            	
            pushFollow(FOLLOW_variableDeclarators_in_decl_var160);
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
            pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators172);
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
            	    match(input,29,FOLLOW_29_in_variableDeclarators175); 
            	    pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators177);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:105:1: variableDeclarator : ID ( ASSIGN_OP spec_type )? ;
    public final void variableDeclarator() throws RecognitionException {
        variableDeclarator_stack.push(new variableDeclarator_scope());
        Token ID2=null;
        String spec_type3 = null;



        	((variableDeclarator_scope)variableDeclarator_stack.peek()).varList = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:112:2: ( ID ( ASSIGN_OP spec_type )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:112:4: ID ( ASSIGN_OP spec_type )?
            {
            ID2=(Token)match(input,ID,FOLLOW_ID_in_variableDeclarator198); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID2!=null?ID2.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID2!=null?ID2.getText():null), ((variables_scope)variables_stack.peek()).varType, (ID2!=null?ID2.getLine():0)));
            		}
            		else
            		{
            			if(names.isDeclaredVariable("global"+"."+(ID2!=null?ID2.getText():null)))
            				errors.add("line "+(ID2!=null?ID2.getLine():0)+": duplicated variable name "+(ID2!=null?ID2.getText():null));
            		}
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:125:2: ( ASSIGN_OP spec_type )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ASSIGN_OP) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:126:3: ASSIGN_OP spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_variableDeclarator210); 
                    pushFollow(FOLLOW_spec_type_in_variableDeclarator212);
                    spec_type3=spec_type();

                    state._fsp--;


                    			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, spec_type3))
                    			{
                    				errors.add("line "+(ID2!=null?ID2.getLine():0)+": mismatch - variable name "+(ID2!=null?ID2.getText():null));
                    			}
                    		

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
            variableDeclarator_stack.pop();
        }
        return ;
    }
    // $ANTLR end "variableDeclarator"


    // $ANTLR start "init_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:138:1: init_var : ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )* ;
    public final void init_var() throws RecognitionException {
        Token ID4=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:139:2: ( ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:139:4: ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )*
            {
            ID4=(Token)match(input,ID,FOLLOW_ID_in_init_var236); 
            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_init_var238); 
            pushFollow(FOLLOW_spec_type_in_init_var240);
            spec_type();

            state._fsp--;


            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID4!=null?ID4.getText():null)))
            		{
            			if(!names.isDeclaredVariable("global"+"."+(ID4!=null?ID4.getText():null)))
            				errors.add("line "+(ID4!=null?ID4.getLine():0)+": mismatch - variable name "+(ID4!=null?ID4.getText():null));
            		}
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:147:2: ( ( PLUS_OP | MINUS_OP ) spec_type )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=PLUS_OP && LA8_0<=MINUS_OP)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:147:3: ( PLUS_OP | MINUS_OP ) spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_init_var253);
            	    spec_type();

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
        }
        return ;
    }
    // $ANTLR end "init_var"


    // $ANTLR start "inside_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:151:1: inside_func : ( elem | length | print_op | break_op | read_op | write_op );
    public final void inside_func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:152:2: ( elem | length | print_op | break_op | read_op | write_op )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt9=1;
                }
                break;
            case 38:
                {
                alt9=2;
                }
                break;
            case 37:
                {
                alt9=3;
                }
                break;
            case 40:
                {
                alt9=4;
                }
                break;
            case 33:
                {
                alt9=5;
                }
                break;
            case 32:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:152:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_inside_func268);
                    elem();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:153:4: length
                    {
                    pushFollow(FOLLOW_length_in_inside_func274);
                    length();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:154:4: print_op
                    {
                    pushFollow(FOLLOW_print_op_in_inside_func279);
                    print_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:155:4: break_op
                    {
                    pushFollow(FOLLOW_break_op_in_inside_func286);
                    break_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:156:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_inside_func291);
                    read_op();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:157:4: write_op
                    {
                    pushFollow(FOLLOW_write_op_in_inside_func297);
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


    // $ANTLR start "call_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:1: call_func : ID '(' ( param )? ')' ;
    public final void call_func() throws RecognitionException {
        Token ID5=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:161:2: ( ID '(' ( param )? ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:161:4: ID '(' ( param )? ')'
            {
            ID5=(Token)match(input,ID,FOLLOW_ID_in_call_func309); 
            match(input,30,FOLLOW_30_in_call_func311); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:161:11: ( param )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID||(LA10_0>=INT && LA10_0<=SYMBOL)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:161:11: param
                    {
                    pushFollow(FOLLOW_param_in_call_func313);
                    param();

                    state._fsp--;


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_call_func316); 

            		if(!names.isExistFunction((ID5!=null?ID5.getText():null)))
            		{
            			errors.add("line "+(ID5!=null?ID5.getLine():0)+": function "+(ID5!=null?ID5.getText():null)+" is not exist");
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
    // $ANTLR end "call_func"


    // $ANTLR start "action"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:170:1: action : spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) ;
    public final void action() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:171:2: ( spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:171:4: spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            {
            pushFollow(FOLLOW_spec_type_in_action332);
            spec_type();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:171:14: ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            int alt11=3;
            switch ( input.LA(1) ) {
            case DOUBLE_MINUS:
                {
                alt11=1;
                }
                break;
            case DOUBLE_PLUS:
                {
                alt11=2;
                }
                break;
            case ASSIGN_OP:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:171:15: DOUBLE_MINUS
                    {
                    match(input,DOUBLE_MINUS,FOLLOW_DOUBLE_MINUS_in_action335); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:171:28: DOUBLE_PLUS
                    {
                    match(input,DOUBLE_PLUS,FOLLOW_DOUBLE_PLUS_in_action337); 

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:171:40: ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_action339); 
                    pushFollow(FOLLOW_spec_type_in_action341);
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

                    pushFollow(FOLLOW_spec_type_in_action349);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:174:1: spec_type returns [String value] : ( INT | LINE | SYMBOL | inside_func | call_func );
    public final String spec_type() throws RecognitionException {
        String value = null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:175:2: ( INT | LINE | SYMBOL | inside_func | call_func )
            int alt12=5;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt12=1;
                }
                break;
            case LINE:
                {
                alt12=2;
                }
                break;
            case SYMBOL:
                {
                alt12=3;
                }
                break;
            case 32:
            case 33:
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt12=4;
                }
                break;
            case ID:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:175:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_spec_type369); 
                    value = "int";

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:176:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_spec_type376); 
                    value = "string";

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:177:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_spec_type383); 
                    value = "char";

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:179:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_spec_type392);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:180:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_spec_type397);
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
        return value;
    }
    // $ANTLR end "spec_type"


    // $ANTLR start "returnType"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:1: returnType returns [String value] : ( INT | LINE | SYMBOL | ID );
    public final String returnType() throws RecognitionException {
        String value = null;

        Token INT6=null;
        Token LINE7=null;
        Token SYMBOL8=null;
        Token ID9=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:184:2: ( INT | LINE | SYMBOL | ID )
            int alt13=4;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt13=1;
                }
                break;
            case LINE:
                {
                alt13=2;
                }
                break;
            case SYMBOL:
                {
                alt13=3;
                }
                break;
            case ID:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:184:4: INT
                    {
                    INT6=(Token)match(input,INT,FOLLOW_INT_in_returnType412); 
                    value = (INT6!=null?INT6.getText():null);

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:185:4: LINE
                    {
                    LINE7=(Token)match(input,LINE,FOLLOW_LINE_in_returnType419); 
                    value = (LINE7!=null?LINE7.getText():null);

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:186:4: SYMBOL
                    {
                    SYMBOL8=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_returnType426); 
                    value = (SYMBOL8!=null?SYMBOL8.getText():null);

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:187:4: ID
                    {
                    ID9=(Token)match(input,ID,FOLLOW_ID_in_returnType433); 
                    value = (ID9!=null?ID9.getText():null);

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
    // $ANTLR end "returnType"

    public static class type_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:190:1: type : ( 'string' | 'int' | 'char' | 'void' );
    public final StrLangParser.type_return type() throws RecognitionException {
        StrLangParser.type_return retval = new StrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:191:2: ( 'string' | 'int' | 'char' | 'void' )
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:197:1: global_func : type ID '(' ( functionArgumentList )? ')' '{' ( body )? ( return_op )? '}' ;
    public final void global_func() throws RecognitionException {
        global_func_stack.push(new global_func_scope());
        Token ID11=null;
        StrLangParser.type_return type10 = null;



        	((global_func_scope)global_func_stack.peek()).funcName = "";
        	((global_func_scope)global_func_stack.peek()).funcType = "";
        	((global_func_scope)global_func_stack.peek()).returnVariable = "";
        	((global_func_scope)global_func_stack.peek()).isReturnUsed = false;
        	((global_func_scope)global_func_stack.peek()).funcArgNames = new ArrayList<String>();
        	((global_func_scope)global_func_stack.peek()).funcArgTypes = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:214:2: ( type ID '(' ( functionArgumentList )? ')' '{' ( body )? ( return_op )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:214:4: type ID '(' ( functionArgumentList )? ')' '{' ( body )? ( return_op )? '}'
            {
            pushFollow(FOLLOW_type_in_global_func483);
            type10=type();

            state._fsp--;

            ((global_func_scope)global_func_stack.peek()).funcType = (type10!=null?input.toString(type10.start,type10.stop):null);
            ID11=(Token)match(input,ID,FOLLOW_ID_in_global_func486); 
            ((program_scope)program_stack.peek()).curBlock = (ID11!=null?ID11.getText():null);
            match(input,30,FOLLOW_30_in_global_func491); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:215:7: ( functionArgumentList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=LINE_TYPE && LA14_0<=VOID_TYPE)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:215:7: functionArgumentList
                    {
                    pushFollow(FOLLOW_functionArgumentList_in_global_func493);
                    functionArgumentList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_global_func496); 

            	 	if(!names.isExistFunction((ID11!=null?ID11.getText():null)))
            	 	{
            	 		names.addFunction(names.new FunctionName((ID11!=null?ID11.getText():null), (type10!=null?input.toString(type10.start,type10.stop):null), ((global_func_scope)global_func_stack.peek()).funcArgTypes, ((global_func_scope)global_func_stack.peek()).funcArgNames, (ID11!=null?ID11.getLine():0)));
            	 	}
            	 	else
            	 	{
            	 		errors.add("line "+(ID11!=null?ID11.getLine():0)+": duplicated declaration function "+(ID11!=null?ID11.getText():null));
            	 	}
            	 
            match(input,27,FOLLOW_27_in_global_func508); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:227:8: ( body )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ID||(LA15_0>=LINE_TYPE && LA15_0<=VOID_TYPE)||(LA15_0>=32 && LA15_0<=35)||(LA15_0>=37 && LA15_0<=40)||LA15_0==42) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:227:8: body
                    {
                    pushFollow(FOLLOW_body_in_global_func510);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:227:14: ( return_op )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==41) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:227:14: return_op
                    {
                    pushFollow(FOLLOW_return_op_in_global_func513);
                    return_op();

                    state._fsp--;


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_global_func516); 

            	  	boolean result = names.checkReturnType((ID11!=null?ID11.getText():null), ((global_func_scope)global_func_stack.peek()).returnVariable, ((program_scope)program_stack.peek()).curBlock, (ID11!=null?ID11.getLine():0));
            	  	if(result==false)
            	  	{
            	  		errors.add(names.getLastError());
            	  	}
            	  

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:237:1: functionArgumentList : functionArgumentDeclarator ( ',' functionArgumentDeclarator )* ;
    public final void functionArgumentList() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:238:2: ( functionArgumentDeclarator ( ',' functionArgumentDeclarator )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:238:4: functionArgumentDeclarator ( ',' functionArgumentDeclarator )*
            {
            pushFollow(FOLLOW_functionArgumentDeclarator_in_functionArgumentList535);
            functionArgumentDeclarator();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:238:31: ( ',' functionArgumentDeclarator )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==29) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:238:32: ',' functionArgumentDeclarator
            	    {
            	    match(input,29,FOLLOW_29_in_functionArgumentList538); 
            	    pushFollow(FOLLOW_functionArgumentDeclarator_in_functionArgumentList540);
            	    functionArgumentDeclarator();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:241:1: functionArgumentDeclarator : type ID ;
    public final void functionArgumentDeclarator() throws RecognitionException {
        Token ID13=null;
        StrLangParser.type_return type12 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:242:2: ( type ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:242:4: type ID
            {
            pushFollow(FOLLOW_type_in_functionArgumentDeclarator554);
            type12=type();

            state._fsp--;

            ID13=(Token)match(input,ID,FOLLOW_ID_in_functionArgumentDeclarator556); 

            		((global_func_scope)global_func_stack.peek()).funcArgTypes.add((type12!=null?input.toString(type12.start,type12.stop):null));
            		((global_func_scope)global_func_stack.peek()).funcArgNames.add((ID13!=null?ID13.getText():null));
            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID13!=null?ID13.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID13!=null?ID13.getText():null), (type12!=null?input.toString(type12.start,type12.stop):null), (ID13!=null?ID13.getLine():0)));
            		}
            		else
            		{
            			errors.add("line "+(ID13!=null?ID13.getLine():0)+": duplicated variable name "+(ID13!=null?ID13.getText():null));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:257:1: param : ( ID | INT | SYMBOL | LINE ) ( ',' ( ID | INT | SYMBOL | LINE ) )* ;
    public final void param() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:258:2: ( ( ID | INT | SYMBOL | LINE ) ( ',' ( ID | INT | SYMBOL | LINE ) )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:258:5: ( ID | INT | SYMBOL | LINE ) ( ',' ( ID | INT | SYMBOL | LINE ) )*
            {
            if ( input.LA(1)==ID||(input.LA(1)>=INT && input.LA(1)<=SYMBOL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:258:26: ( ',' ( ID | INT | SYMBOL | LINE ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:258:28: ',' ( ID | INT | SYMBOL | LINE )
            	    {
            	    match(input,29,FOLLOW_29_in_param585); 
            	    if ( input.LA(1)==ID||(input.LA(1)>=INT && input.LA(1)<=SYMBOL) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // $ANTLR end "param"


    // $ANTLR start "body"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:261:1: body : ( variables | func | if_op | for_op | while_op )+ ;
    public final void body() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:262:2: ( ( variables | func | if_op | for_op | while_op )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:262:3: ( variables | func | if_op | for_op | while_op )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:262:3: ( variables | func | if_op | for_op | while_op )+
            int cnt19=0;
            loop19:
            do {
                int alt19=6;
                switch ( input.LA(1) ) {
                case LINE_TYPE:
                case INT_TYPE:
                case SYMBOL_TYPE:
                case VOID_TYPE:
                    {
                    alt19=1;
                    }
                    break;
                case ID:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (LA19_3==ASSIGN_OP) ) {
                        alt19=1;
                    }
                    else if ( (LA19_3==30) ) {
                        alt19=2;
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
                    alt19=2;
                    }
                    break;
                case 42:
                    {
                    alt19=3;
                    }
                    break;
                case 35:
                    {
                    alt19=4;
                    }
                    break;
                case 34:
                    {
                    alt19=5;
                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:262:4: variables
            	    {
            	    pushFollow(FOLLOW_variables_in_body610);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:263:4: func
            	    {
            	    pushFollow(FOLLOW_func_in_body615);
            	    func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:264:4: if_op
            	    {
            	    pushFollow(FOLLOW_if_op_in_body620);
            	    if_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:265:4: for_op
            	    {
            	    pushFollow(FOLLOW_for_op_in_body625);
            	    for_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:266:4: while_op
            	    {
            	    pushFollow(FOLLOW_while_op_in_body630);
            	    while_op();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:269:1: write_op : 'WriteToFile' '(' ID ',' ID ')' ;
    public final void write_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:270:2: ( 'WriteToFile' '(' ID ',' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:270:4: 'WriteToFile' '(' ID ',' ID ')'
            {
            match(input,32,FOLLOW_32_in_write_op645); 
            match(input,30,FOLLOW_30_in_write_op647); 
            match(input,ID,FOLLOW_ID_in_write_op650); 
            match(input,29,FOLLOW_29_in_write_op652); 
            match(input,ID,FOLLOW_ID_in_write_op655); 
            match(input,31,FOLLOW_31_in_write_op658); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:273:1: read_op : 'ReadFile' '(' ID ')' ;
    public final void read_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:274:2: ( 'ReadFile' '(' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:274:4: 'ReadFile' '(' ID ')'
            {
            match(input,33,FOLLOW_33_in_read_op669); 
            match(input,30,FOLLOW_30_in_read_op671); 
            match(input,ID,FOLLOW_ID_in_read_op674); 
            match(input,31,FOLLOW_31_in_read_op678); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:277:1: while_op : 'while' '(' logic ')' '{' ( body )? '}' ;
    public final void while_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:278:2: ( 'while' '(' logic ')' '{' ( body )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:278:4: 'while' '(' logic ')' '{' ( body )? '}'
            {
            match(input,34,FOLLOW_34_in_while_op689); 
            match(input,30,FOLLOW_30_in_while_op691); 
            pushFollow(FOLLOW_logic_in_while_op693);
            logic();

            state._fsp--;

            match(input,31,FOLLOW_31_in_while_op695); 
            match(input,27,FOLLOW_27_in_while_op697); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:278:30: ( body )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==ID||(LA20_0>=LINE_TYPE && LA20_0<=VOID_TYPE)||(LA20_0>=32 && LA20_0<=35)||(LA20_0>=37 && LA20_0<=40)||LA20_0==42) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:278:30: body
                    {
                    pushFollow(FOLLOW_body_in_while_op699);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_while_op702); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:280:1: for_op : 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' ;
    public final void for_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:2: ( 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:4: 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}'
            {
            match(input,35,FOLLOW_35_in_for_op716); 
            match(input,30,FOLLOW_30_in_for_op718); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:14: ( variables )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ID||(LA21_0>=LINE_TYPE && LA21_0<=VOID_TYPE)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:14: variables
                    {
                    pushFollow(FOLLOW_variables_in_for_op720);
                    variables();

                    state._fsp--;


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_for_op723); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:29: ( logic )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ID||(LA22_0>=INT && LA22_0<=SYMBOL)||LA22_0==END_LINE||LA22_0==30||(LA22_0>=32 && LA22_0<=33)||(LA22_0>=37 && LA22_0<=40)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:29: logic
                    {
                    pushFollow(FOLLOW_logic_in_for_op725);
                    logic();

                    state._fsp--;


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_for_op728); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:40: ( action )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID||(LA23_0>=INT && LA23_0<=SYMBOL)||(LA23_0>=32 && LA23_0<=33)||(LA23_0>=37 && LA23_0<=40)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:40: action
                    {
                    pushFollow(FOLLOW_action_in_for_op730);
                    action();

                    state._fsp--;


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_for_op733); 
            match(input,27,FOLLOW_27_in_for_op735); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:56: ( body )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID||(LA24_0>=LINE_TYPE && LA24_0<=VOID_TYPE)||(LA24_0>=32 && LA24_0<=35)||(LA24_0>=37 && LA24_0<=40)||LA24_0==42) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:281:56: body
                    {
                    pushFollow(FOLLOW_body_in_for_op737);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_for_op740); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:284:1: print_op : 'print' '(' spec_type ( ',' spec_type )* ')' ;
    public final void print_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:285:2: ( 'print' '(' spec_type ( ',' spec_type )* ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:285:4: 'print' '(' spec_type ( ',' spec_type )* ')'
            {
            match(input,37,FOLLOW_37_in_print_op751); 
            match(input,30,FOLLOW_30_in_print_op753); 
            pushFollow(FOLLOW_spec_type_in_print_op755);
            spec_type();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:285:26: ( ',' spec_type )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==29) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:285:27: ',' spec_type
            	    {
            	    match(input,29,FOLLOW_29_in_print_op758); 
            	    pushFollow(FOLLOW_spec_type_in_print_op760);
            	    spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            match(input,31,FOLLOW_31_in_print_op765); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:288:1: length : 'length' '(' spec_type ')' ;
    public final void length() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:289:2: ( 'length' '(' spec_type ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:289:4: 'length' '(' spec_type ')'
            {
            match(input,38,FOLLOW_38_in_length778); 
            match(input,30,FOLLOW_30_in_length780); 
            pushFollow(FOLLOW_spec_type_in_length782);
            spec_type();

            state._fsp--;

            match(input,31,FOLLOW_31_in_length784); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:292:1: elem : 'elem' '(' spec_type ',' specialType ')' ;
    public final void elem() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:293:2: ( 'elem' '(' spec_type ',' specialType ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:293:3: 'elem' '(' spec_type ',' specialType ')'
            {
            match(input,39,FOLLOW_39_in_elem795); 
            match(input,30,FOLLOW_30_in_elem797); 
            pushFollow(FOLLOW_spec_type_in_elem798);
            spec_type();

            state._fsp--;

            match(input,29,FOLLOW_29_in_elem800); 
            pushFollow(FOLLOW_specialType_in_elem802);
            specialType();

            state._fsp--;

            match(input,31,FOLLOW_31_in_elem804); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:296:1: break_op : 'break' ;
    public final void break_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:297:2: ( 'break' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:297:4: 'break'
            {
            match(input,40,FOLLOW_40_in_break_op816); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:301:1: return_op : 'return' returnType ;
    public final void return_op() throws RecognitionException {
        String returnType14 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:302:3: ( 'return' returnType )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:302:5: 'return' returnType
            {
            match(input,41,FOLLOW_41_in_return_op831); 
            pushFollow(FOLLOW_returnType_in_return_op833);
            returnType14=returnType();

            state._fsp--;


             		((global_func_scope)global_func_stack.peek()).returnVariable = returnType14;
             	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:308:1: if_op : 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? ;
    public final void if_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:2: ( 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:4: 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )?
            {
            match(input,42,FOLLOW_42_in_if_op849); 
            match(input,30,FOLLOW_30_in_if_op851); 
            pushFollow(FOLLOW_logic_in_if_op853);
            logic();

            state._fsp--;

            match(input,31,FOLLOW_31_in_if_op855); 
            match(input,27,FOLLOW_27_in_if_op857); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:27: ( body )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ID||(LA26_0>=LINE_TYPE && LA26_0<=VOID_TYPE)||(LA26_0>=32 && LA26_0<=35)||(LA26_0>=37 && LA26_0<=40)||LA26_0==42) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:27: body
                    {
                    pushFollow(FOLLOW_body_in_if_op859);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_if_op862); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:37: ( 'else' '{' ( body )? '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==43) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:38: 'else' '{' ( body )? '}'
                    {
                    match(input,43,FOLLOW_43_in_if_op865); 
                    match(input,27,FOLLOW_27_in_if_op867); 
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:49: ( body )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==ID||(LA27_0>=LINE_TYPE && LA27_0<=VOID_TYPE)||(LA27_0>=32 && LA27_0<=35)||(LA27_0>=37 && LA27_0<=40)||LA27_0==42) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:309:49: body
                            {
                            pushFollow(FOLLOW_body_in_if_op869);
                            body();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,28,FOLLOW_28_in_if_op872); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:312:1: expr : ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY );
    public final void expr() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:313:2: ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY )
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:321:1: logic : logic_and ;
    public final void logic() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:322:2: ( logic_and )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:322:4: logic_and
            {
            pushFollow(FOLLOW_logic_and_in_logic922);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:325:1: logic_and : logic_or ( 'and' logic_or )* ;
    public final void logic_and() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:326:2: ( logic_or ( 'and' logic_or )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:326:4: logic_or ( 'and' logic_or )*
            {
            pushFollow(FOLLOW_logic_or_in_logic_and935);
            logic_or();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:326:13: ( 'and' logic_or )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==44) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:326:14: 'and' logic_or
            	    {
            	    match(input,44,FOLLOW_44_in_logic_and938); 
            	    pushFollow(FOLLOW_logic_or_in_logic_and940);
            	    logic_or();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:328:1: logic_or : logic_expr ( 'or' logic_expr )* ;
    public final void logic_or() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:329:2: ( logic_expr ( 'or' logic_expr )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:329:4: logic_expr ( 'or' logic_expr )*
            {
            pushFollow(FOLLOW_logic_expr_in_logic_or953);
            logic_expr();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:329:15: ( 'or' logic_expr )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==45) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:329:16: 'or' logic_expr
            	    {
            	    match(input,45,FOLLOW_45_in_logic_or956); 
            	    pushFollow(FOLLOW_logic_expr_in_logic_or958);
            	    logic_expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:333:1: logic_expr : ( logic_atom ( expr logic_atom )? | '(' logic ')' );
    public final void logic_expr() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:334:2: ( logic_atom ( expr logic_atom )? | '(' logic ')' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==ID||(LA32_0>=INT && LA32_0<=SYMBOL)||LA32_0==END_LINE||(LA32_0>=32 && LA32_0<=33)||(LA32_0>=37 && LA32_0<=40)) ) {
                alt32=1;
            }
            else if ( (LA32_0==30) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:334:4: logic_atom ( expr logic_atom )?
                    {
                    pushFollow(FOLLOW_logic_atom_in_logic_expr972);
                    logic_atom();

                    state._fsp--;

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:334:15: ( expr logic_atom )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=EQUALLY_EQL_OP && LA31_0<=NO_EQUALLY)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:334:16: expr logic_atom
                            {
                            pushFollow(FOLLOW_expr_in_logic_expr975);
                            expr();

                            state._fsp--;

                            pushFollow(FOLLOW_logic_atom_in_logic_expr977);
                            logic_atom();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:335:4: '(' logic ')'
                    {
                    match(input,30,FOLLOW_30_in_logic_expr984); 
                    pushFollow(FOLLOW_logic_in_logic_expr986);
                    logic();

                    state._fsp--;

                    match(input,31,FOLLOW_31_in_logic_expr988); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:338:1: logic_atom : ( LINE | SYMBOL | INT | ID | inside_func | END_LINE );
    public final void logic_atom() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:339:2: ( LINE | SYMBOL | INT | ID | inside_func | END_LINE )
            int alt33=6;
            switch ( input.LA(1) ) {
            case LINE:
                {
                alt33=1;
                }
                break;
            case SYMBOL:
                {
                alt33=2;
                }
                break;
            case INT:
                {
                alt33=3;
                }
                break;
            case ID:
                {
                alt33=4;
                }
                break;
            case 32:
            case 33:
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt33=5;
                }
                break;
            case END_LINE:
                {
                alt33=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:339:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_logic_atom999); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:340:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_logic_atom1004); 

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:341:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_logic_atom1009); 

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:342:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_logic_atom1014); 

                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:343:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_logic_atom1019);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:344:4: END_LINE
                    {
                    match(input,END_LINE,FOLLOW_END_LINE_in_logic_atom1024); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:347:1: specialType : ( INT | ID );
    public final void specialType() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:348:2: ( INT | ID )
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
    public static final BitSet FOLLOW_variables_in_global_decl93 = new BitSet(new long[]{0x000001E300F00012L});
    public static final BitSet FOLLOW_global_func_in_global_decl98 = new BitSet(new long[]{0x000001E300F00012L});
    public static final BitSet FOLLOW_func_in_global_decl103 = new BitSet(new long[]{0x000001E300F00012L});
    public static final BitSet FOLLOW_inside_func_in_func116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_func121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_var_in_variables138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_var_in_variables142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_var154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarators_in_decl_var160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators172 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_variableDeclarators175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators177 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ID_in_variableDeclarator198 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_variableDeclarator210 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_variableDeclarator212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_init_var236 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_init_var238 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_init_var240 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_init_var247 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_init_var253 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_elem_in_inside_func268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_inside_func274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_op_in_inside_func279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_op_in_inside_func286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_inside_func291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_op_in_inside_func297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func309 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_call_func311 = new BitSet(new long[]{0x0000000080001C10L});
    public static final BitSet FOLLOW_param_in_call_func313 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_call_func316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action332 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_DOUBLE_MINUS_in_action335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_PLUS_in_action337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_action339 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_action341 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_action343 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_action349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_spec_type369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_spec_type376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_spec_type383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_spec_type392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_spec_type397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_returnType412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_returnType419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_returnType426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_returnType433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_func483 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_func486 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_global_func491 = new BitSet(new long[]{0x0000000080F00000L});
    public static final BitSet FOLLOW_functionArgumentList_in_global_func493 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_global_func496 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_global_func508 = new BitSet(new long[]{0x000007EF10F00010L});
    public static final BitSet FOLLOW_body_in_global_func510 = new BitSet(new long[]{0x0000020010000000L});
    public static final BitSet FOLLOW_return_op_in_global_func513 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_global_func516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionArgumentDeclarator_in_functionArgumentList535 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_functionArgumentList538 = new BitSet(new long[]{0x0000000000F00000L});
    public static final BitSet FOLLOW_functionArgumentDeclarator_in_functionArgumentList540 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_type_in_functionArgumentDeclarator554 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functionArgumentDeclarator556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_param573 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_param585 = new BitSet(new long[]{0x0000000000001C10L});
    public static final BitSet FOLLOW_set_in_param587 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_variables_in_body610 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_func_in_body615 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_if_op_in_body620 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_for_op_in_body625 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_while_op_in_body630 = new BitSet(new long[]{0x000005EF00F00012L});
    public static final BitSet FOLLOW_32_in_write_op645 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_write_op647 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_write_op650 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_write_op652 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_write_op655 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_write_op658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_read_op669 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_read_op671 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_read_op674 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_read_op678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_while_op689 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_while_op691 = new BitSet(new long[]{0x000001E340081C10L});
    public static final BitSet FOLLOW_logic_in_while_op693 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_while_op695 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_while_op697 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_while_op699 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_while_op702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_for_op716 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_for_op718 = new BitSet(new long[]{0x0000001000F00010L});
    public static final BitSet FOLLOW_variables_in_for_op720 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_for_op723 = new BitSet(new long[]{0x000001F340081C10L});
    public static final BitSet FOLLOW_logic_in_for_op725 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_for_op728 = new BitSet(new long[]{0x000001E380001C10L});
    public static final BitSet FOLLOW_action_in_for_op730 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_for_op733 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_for_op735 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_for_op737 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_for_op740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_print_op751 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_print_op753 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_print_op755 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_29_in_print_op758 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_print_op760 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_31_in_print_op765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_length778 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_length780 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_length782 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_length784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_elem795 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_elem797 = new BitSet(new long[]{0x000001E300001C10L});
    public static final BitSet FOLLOW_spec_type_in_elem798 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_elem800 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_specialType_in_elem802 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_elem804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_break_op816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_op831 = new BitSet(new long[]{0x0000000000001C10L});
    public static final BitSet FOLLOW_returnType_in_return_op833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_if_op849 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_if_op851 = new BitSet(new long[]{0x000001E340081C10L});
    public static final BitSet FOLLOW_logic_in_if_op853 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_if_op855 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op857 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_if_op859 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_if_op862 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_if_op865 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op867 = new BitSet(new long[]{0x000005EF10F00010L});
    public static final BitSet FOLLOW_body_in_if_op869 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_if_op872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expr0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_and_in_logic922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_or_in_logic_and935 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_logic_and938 = new BitSet(new long[]{0x000001E340081C10L});
    public static final BitSet FOLLOW_logic_or_in_logic_and940 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or953 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_logic_or956 = new BitSet(new long[]{0x000001E340081C10L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or958 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr972 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_expr_in_logic_expr975 = new BitSet(new long[]{0x000001E300081C10L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_logic_expr984 = new BitSet(new long[]{0x000001E340081C10L});
    public static final BitSet FOLLOW_logic_in_logic_expr986 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_logic_expr988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_logic_atom999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_logic_atom1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_logic_atom1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_logic_atom1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_logic_atom1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_LINE_in_logic_atom1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_specialType0 = new BitSet(new long[]{0x0000000000000002L});

}