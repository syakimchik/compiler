// $ANTLR 3.4 src\\grammar\\StrLang.g 2012-04-17 00:40:44

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

@SuppressWarnings({"all", "warnings", "unchecked"})
public class StrLangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN_OP", "COMMENT", "DOUBLE_MINUS", "DOUBLE_PLUS", "END_LINE", "EQUALLY_EQL_OP", "ID", "INT", "INT_TYPE", "LESS_EQL_OP", "LESS_OP", "LINE", "LINE_TYPE", "MINUS_OP", "MORE_EQL_OP", "MORE_OP", "NO_EQUALLY", "PLUS_OP", "SYMBOL", "SYMBOL_TYPE", "VOID_TYPE", "WS", "'('", "')'", "','", "';'", "'ReadFile'", "'WriteToFile'", "'and'", "'break'", "'elem'", "'else'", "'for'", "'if'", "'length'", "'or'", "'print'", "'return'", "'while'", "'{'", "'}'"
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
    public static final int ASSIGN_OP=4;
    public static final int COMMENT=5;
    public static final int DOUBLE_MINUS=6;
    public static final int DOUBLE_PLUS=7;
    public static final int END_LINE=8;
    public static final int EQUALLY_EQL_OP=9;
    public static final int ID=10;
    public static final int INT=11;
    public static final int INT_TYPE=12;
    public static final int LESS_EQL_OP=13;
    public static final int LESS_OP=14;
    public static final int LINE=15;
    public static final int LINE_TYPE=16;
    public static final int MINUS_OP=17;
    public static final int MORE_EQL_OP=18;
    public static final int MORE_OP=19;
    public static final int NO_EQUALLY=20;
    public static final int PLUS_OP=21;
    public static final int SYMBOL=22;
    public static final int SYMBOL_TYPE=23;
    public static final int VOID_TYPE=24;
    public static final int WS=25;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public StrLangParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public StrLangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return StrLangParser.tokenNames; }
    public String getGrammarFileName() { return "src\\grammar\\StrLang.g"; }


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



    // $ANTLR start "program"
    // src\\grammar\\StrLang.g:55:1: program : global_decl ;
    public final void program() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:56:2: ( global_decl )
            // src\\grammar\\StrLang.g:56:4: global_decl
            {
            pushFollow(FOLLOW_global_decl_in_program43);
            global_decl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "program"


    protected static class global_decl_scope {
        String name;
        String nameOfFunc;
        String idType;
    }
    protected Stack global_decl_stack = new Stack();



    // $ANTLR start "global_decl"
    // src\\grammar\\StrLang.g:59:1: global_decl : ( variables | global_func | func )+ ;
    public final void global_decl() throws RecognitionException {
        global_decl_stack.push(new global_decl_scope());

        	((global_decl_scope)global_decl_stack.peek()).name = "";
        	((global_decl_scope)global_decl_stack.peek()).nameOfFunc ="";

        try {
            // src\\grammar\\StrLang.g:69:2: ( ( variables | global_func | func )+ )
            // src\\grammar\\StrLang.g:69:4: ( variables | global_func | func )+
            {
            // src\\grammar\\StrLang.g:69:4: ( variables | global_func | func )+
            int cnt1=0;
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case LINE_TYPE:
                    {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==ID) ) {
                        int LA1_8 = input.LA(3);

                        if ( (LA1_8==26) ) {
                            alt1=2;
                        }
                        else if ( (LA1_8==EOF||LA1_8==ASSIGN_OP||LA1_8==ID||LA1_8==INT_TYPE||(LA1_8 >= LINE_TYPE && LA1_8 <= MINUS_OP)||LA1_8==PLUS_OP||(LA1_8 >= SYMBOL_TYPE && LA1_8 <= VOID_TYPE)||(LA1_8 >= 30 && LA1_8 <= 31)||(LA1_8 >= 33 && LA1_8 <= 34)||LA1_8==38||LA1_8==40) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case INT_TYPE:
                    {
                    int LA1_3 = input.LA(2);

                    if ( (LA1_3==ID) ) {
                        int LA1_8 = input.LA(3);

                        if ( (LA1_8==26) ) {
                            alt1=2;
                        }
                        else if ( (LA1_8==EOF||LA1_8==ASSIGN_OP||LA1_8==ID||LA1_8==INT_TYPE||(LA1_8 >= LINE_TYPE && LA1_8 <= MINUS_OP)||LA1_8==PLUS_OP||(LA1_8 >= SYMBOL_TYPE && LA1_8 <= VOID_TYPE)||(LA1_8 >= 30 && LA1_8 <= 31)||(LA1_8 >= 33 && LA1_8 <= 34)||LA1_8==38||LA1_8==40) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case SYMBOL_TYPE:
                    {
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4==ID) ) {
                        int LA1_8 = input.LA(3);

                        if ( (LA1_8==26) ) {
                            alt1=2;
                        }
                        else if ( (LA1_8==EOF||LA1_8==ASSIGN_OP||LA1_8==ID||LA1_8==INT_TYPE||(LA1_8 >= LINE_TYPE && LA1_8 <= MINUS_OP)||LA1_8==PLUS_OP||(LA1_8 >= SYMBOL_TYPE && LA1_8 <= VOID_TYPE)||(LA1_8 >= 30 && LA1_8 <= 31)||(LA1_8 >= 33 && LA1_8 <= 34)||LA1_8==38||LA1_8==40) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case VOID_TYPE:
                    {
                    int LA1_5 = input.LA(2);

                    if ( (LA1_5==ID) ) {
                        int LA1_8 = input.LA(3);

                        if ( (LA1_8==26) ) {
                            alt1=2;
                        }
                        else if ( (LA1_8==EOF||LA1_8==ASSIGN_OP||LA1_8==ID||LA1_8==INT_TYPE||(LA1_8 >= LINE_TYPE && LA1_8 <= MINUS_OP)||LA1_8==PLUS_OP||(LA1_8 >= SYMBOL_TYPE && LA1_8 <= VOID_TYPE)||(LA1_8 >= 30 && LA1_8 <= 31)||(LA1_8 >= 33 && LA1_8 <= 34)||LA1_8==38||LA1_8==40) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case ID:
                    {
                    int LA1_6 = input.LA(2);

                    if ( (LA1_6==ASSIGN_OP) ) {
                        alt1=1;
                    }
                    else if ( (LA1_6==26) ) {
                        alt1=3;
                    }


                    }
                    break;
                case 30:
                case 31:
                case 33:
                case 34:
                case 38:
                case 40:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:69:5: variables
            	    {
            	    ((global_decl_scope)global_decl_stack.peek()).name = "";

            	    pushFollow(FOLLOW_variables_in_global_decl63);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // src\\grammar\\StrLang.g:70:4: global_func
            	    {
            	    ((global_decl_scope)global_decl_stack.peek()).nameOfFunc = "";

            	    pushFollow(FOLLOW_global_func_in_global_decl69);
            	    global_func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // src\\grammar\\StrLang.g:71:4: func
            	    {
            	    pushFollow(FOLLOW_func_in_global_decl74);
            	    func();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            global_decl_stack.pop();
        }
        return ;
    }
    // $ANTLR end "global_decl"



    // $ANTLR start "func"
    // src\\grammar\\StrLang.g:74:1: func : ( inside_func | call_func );
    public final void func() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:75:2: ( inside_func | call_func )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= 30 && LA2_0 <= 31)||(LA2_0 >= 33 && LA2_0 <= 34)||LA2_0==38||LA2_0==40) ) {
                alt2=1;
            }
            else if ( (LA2_0==ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // src\\grammar\\StrLang.g:75:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_func87);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:76:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_func92);
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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "func"



    // $ANTLR start "variables"
    // src\\grammar\\StrLang.g:79:1: variables : ( decl_var | init_var );
    public final void variables() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:80:2: ( decl_var | init_var )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==INT_TYPE||LA3_0==LINE_TYPE||(LA3_0 >= SYMBOL_TYPE && LA3_0 <= VOID_TYPE)) ) {
                alt3=1;
            }
            else if ( (LA3_0==ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // src\\grammar\\StrLang.g:80:3: decl_var
                    {
                    pushFollow(FOLLOW_decl_var_in_variables102);
                    decl_var();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:81:3: init_var
                    {
                    pushFollow(FOLLOW_init_var_in_variables106);
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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "variables"



    // $ANTLR start "decl_var"
    // src\\grammar\\StrLang.g:84:1: decl_var : type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )* ;
    public final void decl_var() throws RecognitionException {
        Token ID1=null;
        String type2 =null;


        try {
            // src\\grammar\\StrLang.g:85:2: ( type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )* )
            // src\\grammar\\StrLang.g:85:4: type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )*
            {
            pushFollow(FOLLOW_type_in_decl_var118);
            type2=type();

            state._fsp--;


            ID1=(Token)match(input,ID,FOLLOW_ID_in_decl_var120); 


            		if(names.isExist(((global_decl_scope)global_decl_stack.peek()).name+"."+(ID1!=null?ID1.getText():null)))
            			errors.add("line "+(ID1!=null?ID1.getLine():0)+": name "+(ID1!=null?ID1.getText():null)+" duplicated");
            		else
            			names.add(names.new Name(((global_decl_scope)global_decl_stack.peek()).name+"."+(ID1!=null?ID1.getText():null), type2, (ID1!=null?ID1.getLine():0)));
            	

            // src\\grammar\\StrLang.g:92:2: ( ASSIGN_OP spec_type )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ASSIGN_OP) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src\\grammar\\StrLang.g:92:4: ASSIGN_OP spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_decl_var128); 

                    pushFollow(FOLLOW_spec_type_in_decl_var130);
                    spec_type();

                    state._fsp--;


                    }
                    break;

            }


            // src\\grammar\\StrLang.g:92:26: ( ( PLUS_OP | MINUS_OP ) spec_type )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==MINUS_OP||LA5_0==PLUS_OP) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:92:27: ( PLUS_OP | MINUS_OP ) spec_type
            	    {
            	    if ( input.LA(1)==MINUS_OP||input.LA(1)==PLUS_OP ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_spec_type_in_decl_var141);
            	    spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "decl_var"



    // $ANTLR start "init_var"
    // src\\grammar\\StrLang.g:95:1: init_var : ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )* ;
    public final void init_var() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:96:2: ( ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )* )
            // src\\grammar\\StrLang.g:96:4: ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )*
            {
            match(input,ID,FOLLOW_ID_in_init_var156); 

            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_init_var159); 

            pushFollow(FOLLOW_spec_type_in_init_var161);
            spec_type();

            state._fsp--;


            // src\\grammar\\StrLang.g:96:28: ( ( PLUS_OP | MINUS_OP ) spec_type )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==MINUS_OP||LA6_0==PLUS_OP) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:96:29: ( PLUS_OP | MINUS_OP ) spec_type
            	    {
            	    if ( input.LA(1)==MINUS_OP||input.LA(1)==PLUS_OP ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_spec_type_in_init_var170);
            	    spec_type();

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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "init_var"



    // $ANTLR start "inside_func"
    // src\\grammar\\StrLang.g:100:1: inside_func : ( elem | length | print_op | break_op | read_op | write_op );
    public final void inside_func() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:101:2: ( elem | length | print_op | break_op | read_op | write_op )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt7=1;
                }
                break;
            case 38:
                {
                alt7=2;
                }
                break;
            case 40:
                {
                alt7=3;
                }
                break;
            case 33:
                {
                alt7=4;
                }
                break;
            case 30:
                {
                alt7=5;
                }
                break;
            case 31:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // src\\grammar\\StrLang.g:101:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_inside_func185);
                    elem();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:102:4: length
                    {
                    pushFollow(FOLLOW_length_in_inside_func191);
                    length();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:103:4: print_op
                    {
                    pushFollow(FOLLOW_print_op_in_inside_func196);
                    print_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // src\\grammar\\StrLang.g:104:4: break_op
                    {
                    pushFollow(FOLLOW_break_op_in_inside_func203);
                    break_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // src\\grammar\\StrLang.g:105:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_inside_func208);
                    read_op();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // src\\grammar\\StrLang.g:106:4: write_op
                    {
                    pushFollow(FOLLOW_write_op_in_inside_func214);
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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "inside_func"



    // $ANTLR start "call_func"
    // src\\grammar\\StrLang.g:109:1: call_func : ID '(' ( param )? ')' ;
    public final void call_func() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:110:2: ( ID '(' ( param )? ')' )
            // src\\grammar\\StrLang.g:110:4: ID '(' ( param )? ')'
            {
            match(input,ID,FOLLOW_ID_in_call_func226); 

            match(input,26,FOLLOW_26_in_call_func228); 

            // src\\grammar\\StrLang.g:110:11: ( param )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID||LA8_0==INT_TYPE||LA8_0==LINE_TYPE||(LA8_0 >= SYMBOL_TYPE && LA8_0 <= VOID_TYPE)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // src\\grammar\\StrLang.g:110:11: param
                    {
                    pushFollow(FOLLOW_param_in_call_func230);
                    param();

                    state._fsp--;


                    }
                    break;

            }


            match(input,27,FOLLOW_27_in_call_func233); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "call_func"



    // $ANTLR start "action"
    // src\\grammar\\StrLang.g:113:1: action : spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) ;
    public final void action() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:114:2: ( spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) )
            // src\\grammar\\StrLang.g:114:4: spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            {
            pushFollow(FOLLOW_spec_type_in_action246);
            spec_type();

            state._fsp--;


            // src\\grammar\\StrLang.g:114:14: ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            int alt9=3;
            switch ( input.LA(1) ) {
            case DOUBLE_MINUS:
                {
                alt9=1;
                }
                break;
            case DOUBLE_PLUS:
                {
                alt9=2;
                }
                break;
            case ASSIGN_OP:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // src\\grammar\\StrLang.g:114:15: DOUBLE_MINUS
                    {
                    match(input,DOUBLE_MINUS,FOLLOW_DOUBLE_MINUS_in_action249); 

                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:114:28: DOUBLE_PLUS
                    {
                    match(input,DOUBLE_PLUS,FOLLOW_DOUBLE_PLUS_in_action251); 

                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:114:40: ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_action253); 

                    pushFollow(FOLLOW_spec_type_in_action255);
                    spec_type();

                    state._fsp--;


                    if ( input.LA(1)==MINUS_OP||input.LA(1)==PLUS_OP ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_spec_type_in_action263);
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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "action"



    // $ANTLR start "spec_type"
    // src\\grammar\\StrLang.g:117:1: spec_type : ( INT | LINE | SYMBOL | ID | inside_func | call_func );
    public final void spec_type() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:118:2: ( INT | LINE | SYMBOL | ID | inside_func | call_func )
            int alt10=6;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt10=1;
                }
                break;
            case LINE:
                {
                alt10=2;
                }
                break;
            case SYMBOL:
                {
                alt10=3;
                }
                break;
            case ID:
                {
                int LA10_4 = input.LA(2);

                if ( (LA10_4==26) ) {
                    alt10=6;
                }
                else if ( (LA10_4==EOF||LA10_4==ASSIGN_OP||(LA10_4 >= DOUBLE_MINUS && LA10_4 <= DOUBLE_PLUS)||LA10_4==ID||LA10_4==INT_TYPE||(LA10_4 >= LINE_TYPE && LA10_4 <= MINUS_OP)||LA10_4==PLUS_OP||(LA10_4 >= SYMBOL_TYPE && LA10_4 <= VOID_TYPE)||(LA10_4 >= 27 && LA10_4 <= 31)||(LA10_4 >= 33 && LA10_4 <= 34)||(LA10_4 >= 36 && LA10_4 <= 38)||(LA10_4 >= 40 && LA10_4 <= 42)||LA10_4==44) ) {
                    alt10=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 4, input);

                    throw nvae;

                }
                }
                break;
            case 30:
            case 31:
            case 33:
            case 34:
            case 38:
            case 40:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // src\\grammar\\StrLang.g:118:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_spec_type279); 

                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:119:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_spec_type285); 

                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:120:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_spec_type290); 

                    }
                    break;
                case 4 :
                    // src\\grammar\\StrLang.g:121:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_spec_type296); 

                    }
                    break;
                case 5 :
                    // src\\grammar\\StrLang.g:122:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_spec_type302);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // src\\grammar\\StrLang.g:123:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_spec_type307);
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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "spec_type"



    // $ANTLR start "type"
    // src\\grammar\\StrLang.g:130:1: type returns [String idType] : ( 'string' | 'int' | 'char' | 'void' );
    public final String type() throws RecognitionException {
        String idType = null;


        try {
            // src\\grammar\\StrLang.g:131:2: ( 'string' | 'int' | 'char' | 'void' )
            int alt11=4;
            switch ( input.LA(1) ) {
            case LINE_TYPE:
                {
                alt11=1;
                }
                break;
            case INT_TYPE:
                {
                alt11=2;
                }
                break;
            case SYMBOL_TYPE:
                {
                alt11=3;
                }
                break;
            case VOID_TYPE:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // src\\grammar\\StrLang.g:131:4: 'string'
                    {
                    match(input,LINE_TYPE,FOLLOW_LINE_TYPE_in_type324); 

                    idType = "string";

                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:132:5: 'int'
                    {
                    match(input,INT_TYPE,FOLLOW_INT_TYPE_in_type332); 

                    idType ="int";

                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:133:4: 'char'
                    {
                    match(input,SYMBOL_TYPE,FOLLOW_SYMBOL_TYPE_in_type339); 

                    idType = "char";

                    }
                    break;
                case 4 :
                    // src\\grammar\\StrLang.g:134:4: 'void'
                    {
                    match(input,VOID_TYPE,FOLLOW_VOID_TYPE_in_type346); 

                    idType = "void";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return idType;
    }
    // $ANTLR end "type"



    // $ANTLR start "global_func"
    // src\\grammar\\StrLang.g:137:1: global_func : type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}' ;
    public final void global_func() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:138:2: ( type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}' )
            // src\\grammar\\StrLang.g:138:4: type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}'
            {
            pushFollow(FOLLOW_type_in_global_func362);
            type();

            state._fsp--;


            match(input,ID,FOLLOW_ID_in_global_func364); 

            match(input,26,FOLLOW_26_in_global_func366); 

            // src\\grammar\\StrLang.g:138:16: ( param )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==ID||LA12_0==INT_TYPE||LA12_0==LINE_TYPE||(LA12_0 >= SYMBOL_TYPE && LA12_0 <= VOID_TYPE)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:138:16: param
            	    {
            	    pushFollow(FOLLOW_param_in_global_func368);
            	    param();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match(input,27,FOLLOW_27_in_global_func371); 

            match(input,43,FOLLOW_43_in_global_func373); 

            // src\\grammar\\StrLang.g:138:31: ( body )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID||LA13_0==INT_TYPE||LA13_0==LINE_TYPE||(LA13_0 >= SYMBOL_TYPE && LA13_0 <= VOID_TYPE)||(LA13_0 >= 30 && LA13_0 <= 31)||(LA13_0 >= 33 && LA13_0 <= 34)||(LA13_0 >= 36 && LA13_0 <= 38)||LA13_0==40||LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // src\\grammar\\StrLang.g:138:31: body
                    {
                    pushFollow(FOLLOW_body_in_global_func375);
                    body();

                    state._fsp--;


                    }
                    break;

            }


            // src\\grammar\\StrLang.g:138:37: ( return_op )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==41) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src\\grammar\\StrLang.g:138:37: return_op
                    {
                    pushFollow(FOLLOW_return_op_in_global_func378);
                    return_op();

                    state._fsp--;


                    }
                    break;

            }


            match(input,44,FOLLOW_44_in_global_func381); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "global_func"



    // $ANTLR start "param"
    // src\\grammar\\StrLang.g:141:1: param : ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )* ;
    public final void param() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:142:2: ( ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )* )
            // src\\grammar\\StrLang.g:142:4: ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )*
            {
            // src\\grammar\\StrLang.g:142:4: ( type )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==INT_TYPE||LA15_0==LINE_TYPE||(LA15_0 >= SYMBOL_TYPE && LA15_0 <= VOID_TYPE)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src\\grammar\\StrLang.g:142:6: type
                    {
                    pushFollow(FOLLOW_type_in_param397);
                    type();

                    state._fsp--;


                    }
                    break;

            }


            match(input,ID,FOLLOW_ID_in_param401); 

            // src\\grammar\\StrLang.g:142:16: ( '=' ( type )? ( INT | ID ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ASSIGN_OP) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // src\\grammar\\StrLang.g:142:17: '=' ( type )? ( INT | ID )
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_param404); 

                    // src\\grammar\\StrLang.g:142:21: ( type )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==INT_TYPE||LA16_0==LINE_TYPE||(LA16_0 >= SYMBOL_TYPE && LA16_0 <= VOID_TYPE)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // src\\grammar\\StrLang.g:142:21: type
                            {
                            pushFollow(FOLLOW_type_in_param406);
                            type();

                            state._fsp--;


                            }
                            break;

                    }


                    if ( (input.LA(1) >= ID && input.LA(1) <= INT) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            // src\\grammar\\StrLang.g:142:40: ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==28) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:142:42: ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )?
            	    {
            	    match(input,28,FOLLOW_28_in_param421); 

            	    // src\\grammar\\StrLang.g:142:46: ( type )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==INT_TYPE||LA18_0==LINE_TYPE||(LA18_0 >= SYMBOL_TYPE && LA18_0 <= VOID_TYPE)) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // src\\grammar\\StrLang.g:142:48: type
            	            {
            	            pushFollow(FOLLOW_type_in_param425);
            	            type();

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    match(input,ID,FOLLOW_ID_in_param429); 

            	    // src\\grammar\\StrLang.g:142:58: ( '=' ( type )? ( INT | ID ) )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==ASSIGN_OP) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // src\\grammar\\StrLang.g:142:59: '=' ( type )? ( INT | ID )
            	            {
            	            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_param432); 

            	            // src\\grammar\\StrLang.g:142:63: ( type )?
            	            int alt19=2;
            	            int LA19_0 = input.LA(1);

            	            if ( (LA19_0==INT_TYPE||LA19_0==LINE_TYPE||(LA19_0 >= SYMBOL_TYPE && LA19_0 <= VOID_TYPE)) ) {
            	                alt19=1;
            	            }
            	            switch (alt19) {
            	                case 1 :
            	                    // src\\grammar\\StrLang.g:142:63: type
            	                    {
            	                    pushFollow(FOLLOW_type_in_param434);
            	                    type();

            	                    state._fsp--;


            	                    }
            	                    break;

            	            }


            	            if ( (input.LA(1) >= ID && input.LA(1) <= INT) ) {
            	                input.consume();
            	                state.errorRecovery=false;
            	            }
            	            else {
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                throw mse;
            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "param"



    // $ANTLR start "body"
    // src\\grammar\\StrLang.g:145:1: body : ( variables | func | if_op | for_op | while_op )+ ;
    public final void body() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:146:2: ( ( variables | func | if_op | for_op | while_op )+ )
            // src\\grammar\\StrLang.g:146:3: ( variables | func | if_op | for_op | while_op )+
            {
            // src\\grammar\\StrLang.g:146:3: ( variables | func | if_op | for_op | while_op )+
            int cnt22=0;
            loop22:
            do {
                int alt22=6;
                switch ( input.LA(1) ) {
                case INT_TYPE:
                case LINE_TYPE:
                case SYMBOL_TYPE:
                case VOID_TYPE:
                    {
                    alt22=1;
                    }
                    break;
                case ID:
                    {
                    int LA22_3 = input.LA(2);

                    if ( (LA22_3==ASSIGN_OP) ) {
                        alt22=1;
                    }
                    else if ( (LA22_3==26) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 30:
                case 31:
                case 33:
                case 34:
                case 38:
                case 40:
                    {
                    alt22=2;
                    }
                    break;
                case 37:
                    {
                    alt22=3;
                    }
                    break;
                case 36:
                    {
                    alt22=4;
                    }
                    break;
                case 42:
                    {
                    alt22=5;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:146:4: variables
            	    {
            	    pushFollow(FOLLOW_variables_in_body459);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // src\\grammar\\StrLang.g:147:4: func
            	    {
            	    pushFollow(FOLLOW_func_in_body464);
            	    func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // src\\grammar\\StrLang.g:148:4: if_op
            	    {
            	    pushFollow(FOLLOW_if_op_in_body469);
            	    if_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // src\\grammar\\StrLang.g:149:4: for_op
            	    {
            	    pushFollow(FOLLOW_for_op_in_body474);
            	    for_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // src\\grammar\\StrLang.g:150:4: while_op
            	    {
            	    pushFollow(FOLLOW_while_op_in_body479);
            	    while_op();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "body"



    // $ANTLR start "write_op"
    // src\\grammar\\StrLang.g:153:1: write_op : 'WriteToFile' '(' ID ',' ID ')' ;
    public final void write_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:154:2: ( 'WriteToFile' '(' ID ',' ID ')' )
            // src\\grammar\\StrLang.g:154:4: 'WriteToFile' '(' ID ',' ID ')'
            {
            match(input,31,FOLLOW_31_in_write_op494); 

            match(input,26,FOLLOW_26_in_write_op496); 

            match(input,ID,FOLLOW_ID_in_write_op499); 

            match(input,28,FOLLOW_28_in_write_op501); 

            match(input,ID,FOLLOW_ID_in_write_op504); 

            match(input,27,FOLLOW_27_in_write_op507); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "write_op"



    // $ANTLR start "read_op"
    // src\\grammar\\StrLang.g:157:1: read_op : 'ReadFile' '(' ID ')' ;
    public final void read_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:158:2: ( 'ReadFile' '(' ID ')' )
            // src\\grammar\\StrLang.g:158:4: 'ReadFile' '(' ID ')'
            {
            match(input,30,FOLLOW_30_in_read_op518); 

            match(input,26,FOLLOW_26_in_read_op520); 

            match(input,ID,FOLLOW_ID_in_read_op523); 

            match(input,27,FOLLOW_27_in_read_op527); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "read_op"



    // $ANTLR start "while_op"
    // src\\grammar\\StrLang.g:161:1: while_op : 'while' '(' logic ')' '{' ( body )? '}' ;
    public final void while_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:162:2: ( 'while' '(' logic ')' '{' ( body )? '}' )
            // src\\grammar\\StrLang.g:162:4: 'while' '(' logic ')' '{' ( body )? '}'
            {
            match(input,42,FOLLOW_42_in_while_op538); 

            match(input,26,FOLLOW_26_in_while_op540); 

            pushFollow(FOLLOW_logic_in_while_op542);
            logic();

            state._fsp--;


            match(input,27,FOLLOW_27_in_while_op544); 

            match(input,43,FOLLOW_43_in_while_op546); 

            // src\\grammar\\StrLang.g:162:30: ( body )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID||LA23_0==INT_TYPE||LA23_0==LINE_TYPE||(LA23_0 >= SYMBOL_TYPE && LA23_0 <= VOID_TYPE)||(LA23_0 >= 30 && LA23_0 <= 31)||(LA23_0 >= 33 && LA23_0 <= 34)||(LA23_0 >= 36 && LA23_0 <= 38)||LA23_0==40||LA23_0==42) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // src\\grammar\\StrLang.g:162:30: body
                    {
                    pushFollow(FOLLOW_body_in_while_op548);
                    body();

                    state._fsp--;


                    }
                    break;

            }


            match(input,44,FOLLOW_44_in_while_op551); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "while_op"



    // $ANTLR start "for_op"
    // src\\grammar\\StrLang.g:164:1: for_op : 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' ;
    public final void for_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:165:2: ( 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' )
            // src\\grammar\\StrLang.g:165:4: 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}'
            {
            match(input,36,FOLLOW_36_in_for_op565); 

            match(input,26,FOLLOW_26_in_for_op567); 

            // src\\grammar\\StrLang.g:165:14: ( variables )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID||LA24_0==INT_TYPE||LA24_0==LINE_TYPE||(LA24_0 >= SYMBOL_TYPE && LA24_0 <= VOID_TYPE)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // src\\grammar\\StrLang.g:165:14: variables
                    {
                    pushFollow(FOLLOW_variables_in_for_op569);
                    variables();

                    state._fsp--;


                    }
                    break;

            }


            match(input,29,FOLLOW_29_in_for_op572); 

            // src\\grammar\\StrLang.g:165:29: ( logic )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==END_LINE||(LA25_0 >= ID && LA25_0 <= INT)||LA25_0==LINE||LA25_0==SYMBOL||LA25_0==26||(LA25_0 >= 30 && LA25_0 <= 31)||(LA25_0 >= 33 && LA25_0 <= 34)||LA25_0==38||LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // src\\grammar\\StrLang.g:165:29: logic
                    {
                    pushFollow(FOLLOW_logic_in_for_op574);
                    logic();

                    state._fsp--;


                    }
                    break;

            }


            match(input,29,FOLLOW_29_in_for_op577); 

            // src\\grammar\\StrLang.g:165:40: ( action )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0 >= ID && LA26_0 <= INT)||LA26_0==LINE||LA26_0==SYMBOL||(LA26_0 >= 30 && LA26_0 <= 31)||(LA26_0 >= 33 && LA26_0 <= 34)||LA26_0==38||LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // src\\grammar\\StrLang.g:165:40: action
                    {
                    pushFollow(FOLLOW_action_in_for_op579);
                    action();

                    state._fsp--;


                    }
                    break;

            }


            match(input,27,FOLLOW_27_in_for_op582); 

            match(input,43,FOLLOW_43_in_for_op584); 

            // src\\grammar\\StrLang.g:165:56: ( body )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ID||LA27_0==INT_TYPE||LA27_0==LINE_TYPE||(LA27_0 >= SYMBOL_TYPE && LA27_0 <= VOID_TYPE)||(LA27_0 >= 30 && LA27_0 <= 31)||(LA27_0 >= 33 && LA27_0 <= 34)||(LA27_0 >= 36 && LA27_0 <= 38)||LA27_0==40||LA27_0==42) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src\\grammar\\StrLang.g:165:56: body
                    {
                    pushFollow(FOLLOW_body_in_for_op586);
                    body();

                    state._fsp--;


                    }
                    break;

            }


            match(input,44,FOLLOW_44_in_for_op589); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "for_op"



    // $ANTLR start "print_op"
    // src\\grammar\\StrLang.g:168:1: print_op : 'print' '(' spec_type ( ',' spec_type )* ')' ;
    public final void print_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:169:2: ( 'print' '(' spec_type ( ',' spec_type )* ')' )
            // src\\grammar\\StrLang.g:169:4: 'print' '(' spec_type ( ',' spec_type )* ')'
            {
            match(input,40,FOLLOW_40_in_print_op600); 

            match(input,26,FOLLOW_26_in_print_op602); 

            pushFollow(FOLLOW_spec_type_in_print_op604);
            spec_type();

            state._fsp--;


            // src\\grammar\\StrLang.g:169:26: ( ',' spec_type )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==28) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:169:27: ',' spec_type
            	    {
            	    match(input,28,FOLLOW_28_in_print_op607); 

            	    pushFollow(FOLLOW_spec_type_in_print_op609);
            	    spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            match(input,27,FOLLOW_27_in_print_op614); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "print_op"



    // $ANTLR start "length"
    // src\\grammar\\StrLang.g:172:1: length : 'length' '(' spec_type ')' ;
    public final void length() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:173:2: ( 'length' '(' spec_type ')' )
            // src\\grammar\\StrLang.g:173:4: 'length' '(' spec_type ')'
            {
            match(input,38,FOLLOW_38_in_length627); 

            match(input,26,FOLLOW_26_in_length629); 

            pushFollow(FOLLOW_spec_type_in_length631);
            spec_type();

            state._fsp--;


            match(input,27,FOLLOW_27_in_length633); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "length"



    // $ANTLR start "elem"
    // src\\grammar\\StrLang.g:176:1: elem : 'elem' '(' spec_type ',' specialType ')' ;
    public final void elem() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:177:2: ( 'elem' '(' spec_type ',' specialType ')' )
            // src\\grammar\\StrLang.g:177:3: 'elem' '(' spec_type ',' specialType ')'
            {
            match(input,34,FOLLOW_34_in_elem645); 

            match(input,26,FOLLOW_26_in_elem647); 

            pushFollow(FOLLOW_spec_type_in_elem648);
            spec_type();

            state._fsp--;


            match(input,28,FOLLOW_28_in_elem650); 

            pushFollow(FOLLOW_specialType_in_elem652);
            specialType();

            state._fsp--;


            match(input,27,FOLLOW_27_in_elem654); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "elem"



    // $ANTLR start "break_op"
    // src\\grammar\\StrLang.g:180:1: break_op : 'break' ;
    public final void break_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:181:2: ( 'break' )
            // src\\grammar\\StrLang.g:181:4: 'break'
            {
            match(input,33,FOLLOW_33_in_break_op666); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "break_op"



    // $ANTLR start "return_op"
    // src\\grammar\\StrLang.g:185:1: return_op : 'return' spec_type ;
    public final void return_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:186:3: ( 'return' spec_type )
            // src\\grammar\\StrLang.g:186:5: 'return' spec_type
            {
            match(input,41,FOLLOW_41_in_return_op682); 

            pushFollow(FOLLOW_spec_type_in_return_op684);
            spec_type();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "return_op"



    // $ANTLR start "if_op"
    // src\\grammar\\StrLang.g:189:1: if_op : 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? ;
    public final void if_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:190:2: ( 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? )
            // src\\grammar\\StrLang.g:190:4: 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )?
            {
            match(input,37,FOLLOW_37_in_if_op696); 

            match(input,26,FOLLOW_26_in_if_op698); 

            pushFollow(FOLLOW_logic_in_if_op700);
            logic();

            state._fsp--;


            match(input,27,FOLLOW_27_in_if_op702); 

            match(input,43,FOLLOW_43_in_if_op704); 

            // src\\grammar\\StrLang.g:190:27: ( body )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==ID||LA29_0==INT_TYPE||LA29_0==LINE_TYPE||(LA29_0 >= SYMBOL_TYPE && LA29_0 <= VOID_TYPE)||(LA29_0 >= 30 && LA29_0 <= 31)||(LA29_0 >= 33 && LA29_0 <= 34)||(LA29_0 >= 36 && LA29_0 <= 38)||LA29_0==40||LA29_0==42) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // src\\grammar\\StrLang.g:190:27: body
                    {
                    pushFollow(FOLLOW_body_in_if_op706);
                    body();

                    state._fsp--;


                    }
                    break;

            }


            match(input,44,FOLLOW_44_in_if_op709); 

            // src\\grammar\\StrLang.g:190:37: ( 'else' '{' ( body )? '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // src\\grammar\\StrLang.g:190:38: 'else' '{' ( body )? '}'
                    {
                    match(input,35,FOLLOW_35_in_if_op712); 

                    match(input,43,FOLLOW_43_in_if_op714); 

                    // src\\grammar\\StrLang.g:190:49: ( body )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==ID||LA30_0==INT_TYPE||LA30_0==LINE_TYPE||(LA30_0 >= SYMBOL_TYPE && LA30_0 <= VOID_TYPE)||(LA30_0 >= 30 && LA30_0 <= 31)||(LA30_0 >= 33 && LA30_0 <= 34)||(LA30_0 >= 36 && LA30_0 <= 38)||LA30_0==40||LA30_0==42) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // src\\grammar\\StrLang.g:190:49: body
                            {
                            pushFollow(FOLLOW_body_in_if_op716);
                            body();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,44,FOLLOW_44_in_if_op719); 

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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "if_op"



    // $ANTLR start "expr"
    // src\\grammar\\StrLang.g:193:1: expr : ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY );
    public final void expr() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:194:2: ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY )
            // src\\grammar\\StrLang.g:
            {
            if ( input.LA(1)==EQUALLY_EQL_OP||(input.LA(1) >= LESS_EQL_OP && input.LA(1) <= LESS_OP)||(input.LA(1) >= MORE_EQL_OP && input.LA(1) <= NO_EQUALLY) ) {
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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "expr"



    // $ANTLR start "logic"
    // src\\grammar\\StrLang.g:202:1: logic : logic_and ;
    public final void logic() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:203:2: ( logic_and )
            // src\\grammar\\StrLang.g:203:4: logic_and
            {
            pushFollow(FOLLOW_logic_and_in_logic769);
            logic_and();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "logic"



    // $ANTLR start "logic_and"
    // src\\grammar\\StrLang.g:206:1: logic_and : logic_or ( 'and' logic_or )* ;
    public final void logic_and() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:207:2: ( logic_or ( 'and' logic_or )* )
            // src\\grammar\\StrLang.g:207:4: logic_or ( 'and' logic_or )*
            {
            pushFollow(FOLLOW_logic_or_in_logic_and782);
            logic_or();

            state._fsp--;


            // src\\grammar\\StrLang.g:207:13: ( 'and' logic_or )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==32) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:207:14: 'and' logic_or
            	    {
            	    match(input,32,FOLLOW_32_in_logic_and785); 

            	    pushFollow(FOLLOW_logic_or_in_logic_and787);
            	    logic_or();

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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "logic_and"



    // $ANTLR start "logic_or"
    // src\\grammar\\StrLang.g:209:1: logic_or : logic_expr ( 'or' logic_expr )* ;
    public final void logic_or() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:210:2: ( logic_expr ( 'or' logic_expr )* )
            // src\\grammar\\StrLang.g:210:4: logic_expr ( 'or' logic_expr )*
            {
            pushFollow(FOLLOW_logic_expr_in_logic_or800);
            logic_expr();

            state._fsp--;


            // src\\grammar\\StrLang.g:210:15: ( 'or' logic_expr )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==39) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:210:16: 'or' logic_expr
            	    {
            	    match(input,39,FOLLOW_39_in_logic_or803); 

            	    pushFollow(FOLLOW_logic_expr_in_logic_or805);
            	    logic_expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "logic_or"



    // $ANTLR start "logic_expr"
    // src\\grammar\\StrLang.g:214:1: logic_expr : ( logic_atom ( expr logic_atom )? | '(' logic ')' );
    public final void logic_expr() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:215:2: ( logic_atom ( expr logic_atom )? | '(' logic ')' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==END_LINE||(LA35_0 >= ID && LA35_0 <= INT)||LA35_0==LINE||LA35_0==SYMBOL||(LA35_0 >= 30 && LA35_0 <= 31)||(LA35_0 >= 33 && LA35_0 <= 34)||LA35_0==38||LA35_0==40) ) {
                alt35=1;
            }
            else if ( (LA35_0==26) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // src\\grammar\\StrLang.g:215:4: logic_atom ( expr logic_atom )?
                    {
                    pushFollow(FOLLOW_logic_atom_in_logic_expr819);
                    logic_atom();

                    state._fsp--;


                    // src\\grammar\\StrLang.g:215:15: ( expr logic_atom )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==EQUALLY_EQL_OP||(LA34_0 >= LESS_EQL_OP && LA34_0 <= LESS_OP)||(LA34_0 >= MORE_EQL_OP && LA34_0 <= NO_EQUALLY)) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // src\\grammar\\StrLang.g:215:16: expr logic_atom
                            {
                            pushFollow(FOLLOW_expr_in_logic_expr822);
                            expr();

                            state._fsp--;


                            pushFollow(FOLLOW_logic_atom_in_logic_expr824);
                            logic_atom();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:216:4: '(' logic ')'
                    {
                    match(input,26,FOLLOW_26_in_logic_expr831); 

                    pushFollow(FOLLOW_logic_in_logic_expr833);
                    logic();

                    state._fsp--;


                    match(input,27,FOLLOW_27_in_logic_expr835); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "logic_expr"



    // $ANTLR start "logic_atom"
    // src\\grammar\\StrLang.g:219:1: logic_atom : ( LINE | SYMBOL | INT | ID | inside_func | END_LINE );
    public final void logic_atom() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:220:2: ( LINE | SYMBOL | INT | ID | inside_func | END_LINE )
            int alt36=6;
            switch ( input.LA(1) ) {
            case LINE:
                {
                alt36=1;
                }
                break;
            case SYMBOL:
                {
                alt36=2;
                }
                break;
            case INT:
                {
                alt36=3;
                }
                break;
            case ID:
                {
                alt36=4;
                }
                break;
            case 30:
            case 31:
            case 33:
            case 34:
            case 38:
            case 40:
                {
                alt36=5;
                }
                break;
            case END_LINE:
                {
                alt36=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }

            switch (alt36) {
                case 1 :
                    // src\\grammar\\StrLang.g:220:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_logic_atom846); 

                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:221:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_logic_atom851); 

                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:222:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_logic_atom856); 

                    }
                    break;
                case 4 :
                    // src\\grammar\\StrLang.g:223:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_logic_atom861); 

                    }
                    break;
                case 5 :
                    // src\\grammar\\StrLang.g:224:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_logic_atom866);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // src\\grammar\\StrLang.g:225:4: END_LINE
                    {
                    match(input,END_LINE,FOLLOW_END_LINE_in_logic_atom871); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "logic_atom"



    // $ANTLR start "specialType"
    // src\\grammar\\StrLang.g:228:1: specialType : ( INT | ID );
    public final void specialType() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:229:2: ( INT | ID )
            // src\\grammar\\StrLang.g:
            {
            if ( (input.LA(1) >= ID && input.LA(1) <= INT) ) {
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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "specialType"

    // Delegated rules


 

    public static final BitSet FOLLOW_global_decl_in_program43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variables_in_global_decl63 = new BitSet(new long[]{0x00000146C1811402L});
    public static final BitSet FOLLOW_global_func_in_global_decl69 = new BitSet(new long[]{0x00000146C1811402L});
    public static final BitSet FOLLOW_func_in_global_decl74 = new BitSet(new long[]{0x00000146C1811402L});
    public static final BitSet FOLLOW_inside_func_in_func87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_func92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_var_in_variables102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_var_in_variables106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_var118 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_decl_var120 = new BitSet(new long[]{0x0000000000220012L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_decl_var128 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_decl_var130 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_set_in_decl_var135 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_decl_var141 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_ID_in_init_var156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_init_var159 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_init_var161 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_set_in_init_var164 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_init_var170 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_elem_in_inside_func185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_inside_func191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_op_in_inside_func196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_op_in_inside_func203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_inside_func208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_op_in_inside_func214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func226 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_call_func228 = new BitSet(new long[]{0x0000000009811400L});
    public static final BitSet FOLLOW_param_in_call_func230 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_call_func233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action246 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_DOUBLE_MINUS_in_action249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_PLUS_in_action251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_action253 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_action255 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_set_in_action257 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_action263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_spec_type279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_spec_type285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_spec_type290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_spec_type296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_spec_type302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_spec_type307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_TYPE_in_type324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_TYPE_in_type332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_TYPE_in_type339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_TYPE_in_type346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_func362 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_global_func364 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_global_func366 = new BitSet(new long[]{0x0000000009811400L});
    public static final BitSet FOLLOW_param_in_global_func368 = new BitSet(new long[]{0x0000000009811400L});
    public static final BitSet FOLLOW_27_in_global_func371 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_global_func373 = new BitSet(new long[]{0x00001776C1811400L});
    public static final BitSet FOLLOW_body_in_global_func375 = new BitSet(new long[]{0x0000120000000000L});
    public static final BitSet FOLLOW_return_op_in_global_func378 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_global_func381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_param397 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_param401 = new BitSet(new long[]{0x0000000010000012L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_param404 = new BitSet(new long[]{0x0000000001811C00L});
    public static final BitSet FOLLOW_type_in_param406 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_param409 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_param421 = new BitSet(new long[]{0x0000000001811400L});
    public static final BitSet FOLLOW_type_in_param425 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_param429 = new BitSet(new long[]{0x0000000010000012L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_param432 = new BitSet(new long[]{0x0000000001811C00L});
    public static final BitSet FOLLOW_type_in_param434 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_param437 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_variables_in_body459 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_func_in_body464 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_if_op_in_body469 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_for_op_in_body474 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_while_op_in_body479 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_31_in_write_op494 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_write_op496 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_write_op499 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_write_op501 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_write_op504 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_write_op507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_read_op518 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_read_op520 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_read_op523 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_read_op527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_while_op538 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_while_op540 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_in_while_op542 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_while_op544 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_while_op546 = new BitSet(new long[]{0x00001576C1811400L});
    public static final BitSet FOLLOW_body_in_while_op548 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_while_op551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_for_op565 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_for_op567 = new BitSet(new long[]{0x0000000021811400L});
    public static final BitSet FOLLOW_variables_in_for_op569 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_for_op572 = new BitSet(new long[]{0x00000146E4408D00L});
    public static final BitSet FOLLOW_logic_in_for_op574 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_for_op577 = new BitSet(new long[]{0x00000146C8408C00L});
    public static final BitSet FOLLOW_action_in_for_op579 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_for_op582 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_for_op584 = new BitSet(new long[]{0x00001576C1811400L});
    public static final BitSet FOLLOW_body_in_for_op586 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_for_op589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_print_op600 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_print_op602 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_print_op604 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_print_op607 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_print_op609 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_print_op614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_length627 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_length629 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_length631 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_length633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_elem645 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_elem647 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_elem648 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_elem650 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_specialType_in_elem652 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_elem654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_break_op666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_op682 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_return_op684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_if_op696 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_if_op698 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_in_if_op700 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op702 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_if_op704 = new BitSet(new long[]{0x00001576C1811400L});
    public static final BitSet FOLLOW_body_in_if_op706 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_if_op709 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_if_op712 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_if_op714 = new BitSet(new long[]{0x00001576C1811400L});
    public static final BitSet FOLLOW_body_in_if_op716 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_if_op719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_and_in_logic769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_or_in_logic_and782 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_logic_and785 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_or_in_logic_and787 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or800 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_logic_or803 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or805 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr819 = new BitSet(new long[]{0x00000000001C6202L});
    public static final BitSet FOLLOW_expr_in_logic_expr822 = new BitSet(new long[]{0x00000146C0408D00L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_logic_expr831 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_in_logic_expr833 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_logic_expr835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_logic_atom846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_logic_atom851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_logic_atom856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_logic_atom861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_logic_atom866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_LINE_in_logic_atom871 = new BitSet(new long[]{0x0000000000000002L});

}