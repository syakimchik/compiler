// $ANTLR 3.4 src\\grammar\\StrLang.g 2012-04-06 16:22:50

	package grammar;


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



    // $ANTLR start "program"
    // src\\grammar\\StrLang.g:15:1: program : ( global_decl )+ ;
    public final void program() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:16:2: ( ( global_decl )+ )
            // src\\grammar\\StrLang.g:16:4: ( global_decl )+
            {
            // src\\grammar\\StrLang.g:16:4: ( global_decl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==INT_TYPE||LA1_0==LINE_TYPE||(LA1_0 >= SYMBOL_TYPE && LA1_0 <= VOID_TYPE)||(LA1_0 >= 30 && LA1_0 <= 31)||(LA1_0 >= 33 && LA1_0 <= 34)||LA1_0==38||LA1_0==40) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:16:4: global_decl
            	    {
            	    pushFollow(FOLLOW_global_decl_in_program38);
            	    global_decl();

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
        }
        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "global_decl"
    // src\\grammar\\StrLang.g:19:1: global_decl : ( variables | global_func | func );
    public final void global_decl() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:20:2: ( variables | global_func | func )
            int alt2=3;
            switch ( input.LA(1) ) {
            case INT_TYPE:
            case LINE_TYPE:
            case SYMBOL_TYPE:
            case VOID_TYPE:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==ID) ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4==26) ) {
                        alt2=2;
                    }
                    else if ( (LA2_4==EOF||LA2_4==ASSIGN_OP||LA2_4==ID||LA2_4==INT_TYPE||(LA2_4 >= LINE_TYPE && LA2_4 <= MINUS_OP)||LA2_4==PLUS_OP||(LA2_4 >= SYMBOL_TYPE && LA2_4 <= VOID_TYPE)||(LA2_4 >= 30 && LA2_4 <= 31)||(LA2_4 >= 33 && LA2_4 <= 34)||LA2_4==38||LA2_4==40) ) {
                        alt2=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==ASSIGN_OP) ) {
                    alt2=1;
                }
                else if ( (LA2_2==26) ) {
                    alt2=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

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
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // src\\grammar\\StrLang.g:20:4: variables
                    {
                    pushFollow(FOLLOW_variables_in_global_decl50);
                    variables();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:21:4: global_func
                    {
                    pushFollow(FOLLOW_global_func_in_global_decl55);
                    global_func();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:22:4: func
                    {
                    pushFollow(FOLLOW_func_in_global_decl60);
                    func();

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
    // $ANTLR end "global_decl"



    // $ANTLR start "func"
    // src\\grammar\\StrLang.g:25:1: func : ( inside_func | call_func );
    public final void func() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:26:2: ( inside_func | call_func )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= 30 && LA3_0 <= 31)||(LA3_0 >= 33 && LA3_0 <= 34)||LA3_0==38||LA3_0==40) ) {
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
                    // src\\grammar\\StrLang.g:26:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_func71);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:27:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_func76);
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
    // src\\grammar\\StrLang.g:30:1: variables : ( decl_var | init_var );
    public final void variables() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:31:2: ( decl_var | init_var )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==INT_TYPE||LA4_0==LINE_TYPE||(LA4_0 >= SYMBOL_TYPE && LA4_0 <= VOID_TYPE)) ) {
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
                    // src\\grammar\\StrLang.g:31:3: decl_var
                    {
                    pushFollow(FOLLOW_decl_var_in_variables86);
                    decl_var();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:32:3: init_var
                    {
                    pushFollow(FOLLOW_init_var_in_variables90);
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
    // src\\grammar\\StrLang.g:35:1: decl_var : type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )* ;
    public final void decl_var() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:36:2: ( type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )* )
            // src\\grammar\\StrLang.g:36:4: type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )*
            {
            pushFollow(FOLLOW_type_in_decl_var102);
            type();

            state._fsp--;


            match(input,ID,FOLLOW_ID_in_decl_var104); 

            // src\\grammar\\StrLang.g:36:12: ( ASSIGN_OP spec_type )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==ASSIGN_OP) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src\\grammar\\StrLang.g:36:14: ASSIGN_OP spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_decl_var108); 

                    pushFollow(FOLLOW_spec_type_in_decl_var110);
                    spec_type();

                    state._fsp--;


                    }
                    break;

            }


            // src\\grammar\\StrLang.g:36:36: ( ( PLUS_OP | MINUS_OP ) spec_type )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==MINUS_OP||LA6_0==PLUS_OP) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:36:37: ( PLUS_OP | MINUS_OP ) spec_type
            	    {
            	    if ( input.LA(1)==MINUS_OP||input.LA(1)==PLUS_OP ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_spec_type_in_decl_var121);
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
    // $ANTLR end "decl_var"



    // $ANTLR start "init_var"
    // src\\grammar\\StrLang.g:39:1: init_var : ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )* ;
    public final void init_var() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:40:2: ( ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )* )
            // src\\grammar\\StrLang.g:40:4: ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )*
            {
            match(input,ID,FOLLOW_ID_in_init_var137); 

            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_init_var140); 

            pushFollow(FOLLOW_spec_type_in_init_var142);
            spec_type();

            state._fsp--;


            // src\\grammar\\StrLang.g:40:28: ( ( PLUS_OP | MINUS_OP ) spec_type )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==MINUS_OP||LA7_0==PLUS_OP) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:40:29: ( PLUS_OP | MINUS_OP ) spec_type
            	    {
            	    if ( input.LA(1)==MINUS_OP||input.LA(1)==PLUS_OP ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_spec_type_in_init_var151);
            	    spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // src\\grammar\\StrLang.g:44:1: inside_func : ( elem | length | print_op | break_op | read_op | write_op );
    public final void inside_func() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:45:2: ( elem | length | print_op | break_op | read_op | write_op )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt8=1;
                }
                break;
            case 38:
                {
                alt8=2;
                }
                break;
            case 40:
                {
                alt8=3;
                }
                break;
            case 33:
                {
                alt8=4;
                }
                break;
            case 30:
                {
                alt8=5;
                }
                break;
            case 31:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // src\\grammar\\StrLang.g:45:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_inside_func166);
                    elem();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:46:4: length
                    {
                    pushFollow(FOLLOW_length_in_inside_func172);
                    length();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:47:4: print_op
                    {
                    pushFollow(FOLLOW_print_op_in_inside_func177);
                    print_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // src\\grammar\\StrLang.g:48:4: break_op
                    {
                    pushFollow(FOLLOW_break_op_in_inside_func184);
                    break_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // src\\grammar\\StrLang.g:49:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_inside_func189);
                    read_op();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // src\\grammar\\StrLang.g:50:4: write_op
                    {
                    pushFollow(FOLLOW_write_op_in_inside_func195);
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
    // src\\grammar\\StrLang.g:53:1: call_func : ID '(' ( param )? ')' ;
    public final void call_func() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:54:2: ( ID '(' ( param )? ')' )
            // src\\grammar\\StrLang.g:54:4: ID '(' ( param )? ')'
            {
            match(input,ID,FOLLOW_ID_in_call_func207); 

            match(input,26,FOLLOW_26_in_call_func209); 

            // src\\grammar\\StrLang.g:54:11: ( param )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ID||LA9_0==INT_TYPE||LA9_0==LINE_TYPE||(LA9_0 >= SYMBOL_TYPE && LA9_0 <= VOID_TYPE)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // src\\grammar\\StrLang.g:54:11: param
                    {
                    pushFollow(FOLLOW_param_in_call_func211);
                    param();

                    state._fsp--;


                    }
                    break;

            }


            match(input,27,FOLLOW_27_in_call_func214); 

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
    // src\\grammar\\StrLang.g:57:1: action : spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) ;
    public final void action() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:58:2: ( spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) )
            // src\\grammar\\StrLang.g:58:4: spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            {
            pushFollow(FOLLOW_spec_type_in_action227);
            spec_type();

            state._fsp--;


            // src\\grammar\\StrLang.g:58:14: ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            int alt10=3;
            switch ( input.LA(1) ) {
            case DOUBLE_MINUS:
                {
                alt10=1;
                }
                break;
            case DOUBLE_PLUS:
                {
                alt10=2;
                }
                break;
            case ASSIGN_OP:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // src\\grammar\\StrLang.g:58:15: DOUBLE_MINUS
                    {
                    match(input,DOUBLE_MINUS,FOLLOW_DOUBLE_MINUS_in_action230); 

                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:58:28: DOUBLE_PLUS
                    {
                    match(input,DOUBLE_PLUS,FOLLOW_DOUBLE_PLUS_in_action232); 

                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:58:40: ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_action234); 

                    pushFollow(FOLLOW_spec_type_in_action236);
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


                    pushFollow(FOLLOW_spec_type_in_action244);
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
    // src\\grammar\\StrLang.g:61:1: spec_type : ( INT | LINE | SYMBOL | ID | inside_func | call_func );
    public final void spec_type() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:62:2: ( INT | LINE | SYMBOL | ID | inside_func | call_func )
            int alt11=6;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt11=1;
                }
                break;
            case LINE:
                {
                alt11=2;
                }
                break;
            case SYMBOL:
                {
                alt11=3;
                }
                break;
            case ID:
                {
                int LA11_4 = input.LA(2);

                if ( (LA11_4==26) ) {
                    alt11=6;
                }
                else if ( (LA11_4==EOF||LA11_4==ASSIGN_OP||(LA11_4 >= DOUBLE_MINUS && LA11_4 <= DOUBLE_PLUS)||LA11_4==ID||LA11_4==INT_TYPE||(LA11_4 >= LINE_TYPE && LA11_4 <= MINUS_OP)||LA11_4==PLUS_OP||(LA11_4 >= SYMBOL_TYPE && LA11_4 <= VOID_TYPE)||(LA11_4 >= 27 && LA11_4 <= 31)||(LA11_4 >= 33 && LA11_4 <= 34)||(LA11_4 >= 36 && LA11_4 <= 38)||(LA11_4 >= 40 && LA11_4 <= 42)||LA11_4==44) ) {
                    alt11=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

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
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // src\\grammar\\StrLang.g:62:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_spec_type261); 

                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:63:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_spec_type267); 

                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:64:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_spec_type272); 

                    }
                    break;
                case 4 :
                    // src\\grammar\\StrLang.g:65:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_spec_type278); 

                    }
                    break;
                case 5 :
                    // src\\grammar\\StrLang.g:66:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_spec_type284);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // src\\grammar\\StrLang.g:67:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_spec_type289);
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
    // src\\grammar\\StrLang.g:70:1: type : ( LINE_TYPE | INT_TYPE | VOID_TYPE | SYMBOL_TYPE );
    public final void type() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:71:2: ( LINE_TYPE | INT_TYPE | VOID_TYPE | SYMBOL_TYPE )
            // src\\grammar\\StrLang.g:
            {
            if ( input.LA(1)==INT_TYPE||input.LA(1)==LINE_TYPE||(input.LA(1) >= SYMBOL_TYPE && input.LA(1) <= VOID_TYPE) ) {
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
    // $ANTLR end "type"



    // $ANTLR start "global_func"
    // src\\grammar\\StrLang.g:74:1: global_func : type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}' ;
    public final void global_func() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:75:2: ( type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}' )
            // src\\grammar\\StrLang.g:75:4: type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}'
            {
            pushFollow(FOLLOW_type_in_global_func326);
            type();

            state._fsp--;


            match(input,ID,FOLLOW_ID_in_global_func328); 

            match(input,26,FOLLOW_26_in_global_func330); 

            // src\\grammar\\StrLang.g:75:16: ( param )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==ID||LA12_0==INT_TYPE||LA12_0==LINE_TYPE||(LA12_0 >= SYMBOL_TYPE && LA12_0 <= VOID_TYPE)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:75:16: param
            	    {
            	    pushFollow(FOLLOW_param_in_global_func332);
            	    param();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match(input,27,FOLLOW_27_in_global_func335); 

            match(input,43,FOLLOW_43_in_global_func337); 

            // src\\grammar\\StrLang.g:75:31: ( body )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID||LA13_0==INT_TYPE||LA13_0==LINE_TYPE||(LA13_0 >= SYMBOL_TYPE && LA13_0 <= VOID_TYPE)||(LA13_0 >= 30 && LA13_0 <= 31)||(LA13_0 >= 33 && LA13_0 <= 34)||(LA13_0 >= 36 && LA13_0 <= 38)||LA13_0==40||LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // src\\grammar\\StrLang.g:75:31: body
                    {
                    pushFollow(FOLLOW_body_in_global_func339);
                    body();

                    state._fsp--;


                    }
                    break;

            }


            // src\\grammar\\StrLang.g:75:37: ( return_op )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==41) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src\\grammar\\StrLang.g:75:37: return_op
                    {
                    pushFollow(FOLLOW_return_op_in_global_func342);
                    return_op();

                    state._fsp--;


                    }
                    break;

            }


            match(input,44,FOLLOW_44_in_global_func345); 

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
    // src\\grammar\\StrLang.g:78:1: param : ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )* ;
    public final void param() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:79:2: ( ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )* )
            // src\\grammar\\StrLang.g:79:4: ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )*
            {
            // src\\grammar\\StrLang.g:79:4: ( type )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==INT_TYPE||LA15_0==LINE_TYPE||(LA15_0 >= SYMBOL_TYPE && LA15_0 <= VOID_TYPE)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src\\grammar\\StrLang.g:79:6: type
                    {
                    pushFollow(FOLLOW_type_in_param361);
                    type();

                    state._fsp--;


                    }
                    break;

            }


            match(input,ID,FOLLOW_ID_in_param365); 

            // src\\grammar\\StrLang.g:79:16: ( '=' ( type )? ( INT | ID ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ASSIGN_OP) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // src\\grammar\\StrLang.g:79:17: '=' ( type )? ( INT | ID )
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_param368); 

                    // src\\grammar\\StrLang.g:79:21: ( type )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==INT_TYPE||LA16_0==LINE_TYPE||(LA16_0 >= SYMBOL_TYPE && LA16_0 <= VOID_TYPE)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // src\\grammar\\StrLang.g:79:21: type
                            {
                            pushFollow(FOLLOW_type_in_param370);
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


            // src\\grammar\\StrLang.g:79:40: ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==28) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:79:42: ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )?
            	    {
            	    match(input,28,FOLLOW_28_in_param385); 

            	    // src\\grammar\\StrLang.g:79:46: ( type )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==INT_TYPE||LA18_0==LINE_TYPE||(LA18_0 >= SYMBOL_TYPE && LA18_0 <= VOID_TYPE)) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // src\\grammar\\StrLang.g:79:48: type
            	            {
            	            pushFollow(FOLLOW_type_in_param389);
            	            type();

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    match(input,ID,FOLLOW_ID_in_param393); 

            	    // src\\grammar\\StrLang.g:79:58: ( '=' ( type )? ( INT | ID ) )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==ASSIGN_OP) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // src\\grammar\\StrLang.g:79:59: '=' ( type )? ( INT | ID )
            	            {
            	            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_param396); 

            	            // src\\grammar\\StrLang.g:79:63: ( type )?
            	            int alt19=2;
            	            int LA19_0 = input.LA(1);

            	            if ( (LA19_0==INT_TYPE||LA19_0==LINE_TYPE||(LA19_0 >= SYMBOL_TYPE && LA19_0 <= VOID_TYPE)) ) {
            	                alt19=1;
            	            }
            	            switch (alt19) {
            	                case 1 :
            	                    // src\\grammar\\StrLang.g:79:63: type
            	                    {
            	                    pushFollow(FOLLOW_type_in_param398);
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
    // src\\grammar\\StrLang.g:82:1: body : ( variables | func | if_op | for_op | while_op )+ ;
    public final void body() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:83:2: ( ( variables | func | if_op | for_op | while_op )+ )
            // src\\grammar\\StrLang.g:83:3: ( variables | func | if_op | for_op | while_op )+
            {
            // src\\grammar\\StrLang.g:83:3: ( variables | func | if_op | for_op | while_op )+
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
            	    // src\\grammar\\StrLang.g:83:4: variables
            	    {
            	    pushFollow(FOLLOW_variables_in_body423);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // src\\grammar\\StrLang.g:84:4: func
            	    {
            	    pushFollow(FOLLOW_func_in_body428);
            	    func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // src\\grammar\\StrLang.g:85:4: if_op
            	    {
            	    pushFollow(FOLLOW_if_op_in_body433);
            	    if_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // src\\grammar\\StrLang.g:86:4: for_op
            	    {
            	    pushFollow(FOLLOW_for_op_in_body438);
            	    for_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // src\\grammar\\StrLang.g:87:4: while_op
            	    {
            	    pushFollow(FOLLOW_while_op_in_body443);
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
    // src\\grammar\\StrLang.g:90:1: write_op : 'WriteToFile' '(' ID ',' ID ')' ;
    public final void write_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:91:2: ( 'WriteToFile' '(' ID ',' ID ')' )
            // src\\grammar\\StrLang.g:91:4: 'WriteToFile' '(' ID ',' ID ')'
            {
            match(input,31,FOLLOW_31_in_write_op458); 

            match(input,26,FOLLOW_26_in_write_op460); 

            match(input,ID,FOLLOW_ID_in_write_op463); 

            match(input,28,FOLLOW_28_in_write_op465); 

            match(input,ID,FOLLOW_ID_in_write_op468); 

            match(input,27,FOLLOW_27_in_write_op471); 

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
    // src\\grammar\\StrLang.g:94:1: read_op : 'ReadFile' '(' ID ')' ;
    public final void read_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:95:2: ( 'ReadFile' '(' ID ')' )
            // src\\grammar\\StrLang.g:95:4: 'ReadFile' '(' ID ')'
            {
            match(input,30,FOLLOW_30_in_read_op482); 

            match(input,26,FOLLOW_26_in_read_op484); 

            match(input,ID,FOLLOW_ID_in_read_op487); 

            match(input,27,FOLLOW_27_in_read_op491); 

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
    // src\\grammar\\StrLang.g:98:1: while_op : 'while' '(' logic ')' '{' ( body )? '}' ;
    public final void while_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:99:2: ( 'while' '(' logic ')' '{' ( body )? '}' )
            // src\\grammar\\StrLang.g:99:4: 'while' '(' logic ')' '{' ( body )? '}'
            {
            match(input,42,FOLLOW_42_in_while_op502); 

            match(input,26,FOLLOW_26_in_while_op504); 

            pushFollow(FOLLOW_logic_in_while_op506);
            logic();

            state._fsp--;


            match(input,27,FOLLOW_27_in_while_op508); 

            match(input,43,FOLLOW_43_in_while_op510); 

            // src\\grammar\\StrLang.g:99:30: ( body )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID||LA23_0==INT_TYPE||LA23_0==LINE_TYPE||(LA23_0 >= SYMBOL_TYPE && LA23_0 <= VOID_TYPE)||(LA23_0 >= 30 && LA23_0 <= 31)||(LA23_0 >= 33 && LA23_0 <= 34)||(LA23_0 >= 36 && LA23_0 <= 38)||LA23_0==40||LA23_0==42) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // src\\grammar\\StrLang.g:99:30: body
                    {
                    pushFollow(FOLLOW_body_in_while_op512);
                    body();

                    state._fsp--;


                    }
                    break;

            }


            match(input,44,FOLLOW_44_in_while_op515); 

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
    // src\\grammar\\StrLang.g:101:1: for_op : 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' ;
    public final void for_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:102:2: ( 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' )
            // src\\grammar\\StrLang.g:102:4: 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}'
            {
            match(input,36,FOLLOW_36_in_for_op529); 

            match(input,26,FOLLOW_26_in_for_op531); 

            // src\\grammar\\StrLang.g:102:14: ( variables )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID||LA24_0==INT_TYPE||LA24_0==LINE_TYPE||(LA24_0 >= SYMBOL_TYPE && LA24_0 <= VOID_TYPE)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // src\\grammar\\StrLang.g:102:14: variables
                    {
                    pushFollow(FOLLOW_variables_in_for_op533);
                    variables();

                    state._fsp--;


                    }
                    break;

            }


            match(input,29,FOLLOW_29_in_for_op536); 

            // src\\grammar\\StrLang.g:102:29: ( logic )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==END_LINE||(LA25_0 >= ID && LA25_0 <= INT)||LA25_0==LINE||LA25_0==SYMBOL||LA25_0==26||(LA25_0 >= 30 && LA25_0 <= 31)||(LA25_0 >= 33 && LA25_0 <= 34)||LA25_0==38||LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // src\\grammar\\StrLang.g:102:29: logic
                    {
                    pushFollow(FOLLOW_logic_in_for_op538);
                    logic();

                    state._fsp--;


                    }
                    break;

            }


            match(input,29,FOLLOW_29_in_for_op541); 

            // src\\grammar\\StrLang.g:102:40: ( action )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0 >= ID && LA26_0 <= INT)||LA26_0==LINE||LA26_0==SYMBOL||(LA26_0 >= 30 && LA26_0 <= 31)||(LA26_0 >= 33 && LA26_0 <= 34)||LA26_0==38||LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // src\\grammar\\StrLang.g:102:40: action
                    {
                    pushFollow(FOLLOW_action_in_for_op543);
                    action();

                    state._fsp--;


                    }
                    break;

            }


            match(input,27,FOLLOW_27_in_for_op546); 

            match(input,43,FOLLOW_43_in_for_op548); 

            // src\\grammar\\StrLang.g:102:56: ( body )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ID||LA27_0==INT_TYPE||LA27_0==LINE_TYPE||(LA27_0 >= SYMBOL_TYPE && LA27_0 <= VOID_TYPE)||(LA27_0 >= 30 && LA27_0 <= 31)||(LA27_0 >= 33 && LA27_0 <= 34)||(LA27_0 >= 36 && LA27_0 <= 38)||LA27_0==40||LA27_0==42) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src\\grammar\\StrLang.g:102:56: body
                    {
                    pushFollow(FOLLOW_body_in_for_op550);
                    body();

                    state._fsp--;


                    }
                    break;

            }


            match(input,44,FOLLOW_44_in_for_op553); 

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
    // src\\grammar\\StrLang.g:105:1: print_op : 'print' '(' spec_type ( ',' spec_type )* ')' ;
    public final void print_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:106:2: ( 'print' '(' spec_type ( ',' spec_type )* ')' )
            // src\\grammar\\StrLang.g:106:4: 'print' '(' spec_type ( ',' spec_type )* ')'
            {
            match(input,40,FOLLOW_40_in_print_op564); 

            match(input,26,FOLLOW_26_in_print_op566); 

            pushFollow(FOLLOW_spec_type_in_print_op568);
            spec_type();

            state._fsp--;


            // src\\grammar\\StrLang.g:106:26: ( ',' spec_type )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==28) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:106:27: ',' spec_type
            	    {
            	    match(input,28,FOLLOW_28_in_print_op571); 

            	    pushFollow(FOLLOW_spec_type_in_print_op573);
            	    spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            match(input,27,FOLLOW_27_in_print_op578); 

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
    // src\\grammar\\StrLang.g:109:1: length : 'length' '(' spec_type ')' ;
    public final void length() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:110:2: ( 'length' '(' spec_type ')' )
            // src\\grammar\\StrLang.g:110:4: 'length' '(' spec_type ')'
            {
            match(input,38,FOLLOW_38_in_length591); 

            match(input,26,FOLLOW_26_in_length593); 

            pushFollow(FOLLOW_spec_type_in_length595);
            spec_type();

            state._fsp--;


            match(input,27,FOLLOW_27_in_length597); 

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
    // src\\grammar\\StrLang.g:113:1: elem : 'elem' '(' spec_type ',' specialType ')' ;
    public final void elem() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:114:2: ( 'elem' '(' spec_type ',' specialType ')' )
            // src\\grammar\\StrLang.g:114:3: 'elem' '(' spec_type ',' specialType ')'
            {
            match(input,34,FOLLOW_34_in_elem609); 

            match(input,26,FOLLOW_26_in_elem611); 

            pushFollow(FOLLOW_spec_type_in_elem612);
            spec_type();

            state._fsp--;


            match(input,28,FOLLOW_28_in_elem614); 

            pushFollow(FOLLOW_specialType_in_elem616);
            specialType();

            state._fsp--;


            match(input,27,FOLLOW_27_in_elem618); 

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
    // src\\grammar\\StrLang.g:117:1: break_op : 'break' ;
    public final void break_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:118:2: ( 'break' )
            // src\\grammar\\StrLang.g:118:4: 'break'
            {
            match(input,33,FOLLOW_33_in_break_op630); 

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
    // src\\grammar\\StrLang.g:122:1: return_op : 'return' spec_type ;
    public final void return_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:123:3: ( 'return' spec_type )
            // src\\grammar\\StrLang.g:123:5: 'return' spec_type
            {
            match(input,41,FOLLOW_41_in_return_op646); 

            pushFollow(FOLLOW_spec_type_in_return_op648);
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
    // src\\grammar\\StrLang.g:126:1: if_op : 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? ;
    public final void if_op() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:127:2: ( 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? )
            // src\\grammar\\StrLang.g:127:4: 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )?
            {
            match(input,37,FOLLOW_37_in_if_op660); 

            match(input,26,FOLLOW_26_in_if_op662); 

            pushFollow(FOLLOW_logic_in_if_op664);
            logic();

            state._fsp--;


            match(input,27,FOLLOW_27_in_if_op666); 

            match(input,43,FOLLOW_43_in_if_op668); 

            // src\\grammar\\StrLang.g:127:27: ( body )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==ID||LA29_0==INT_TYPE||LA29_0==LINE_TYPE||(LA29_0 >= SYMBOL_TYPE && LA29_0 <= VOID_TYPE)||(LA29_0 >= 30 && LA29_0 <= 31)||(LA29_0 >= 33 && LA29_0 <= 34)||(LA29_0 >= 36 && LA29_0 <= 38)||LA29_0==40||LA29_0==42) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // src\\grammar\\StrLang.g:127:27: body
                    {
                    pushFollow(FOLLOW_body_in_if_op670);
                    body();

                    state._fsp--;


                    }
                    break;

            }


            match(input,44,FOLLOW_44_in_if_op673); 

            // src\\grammar\\StrLang.g:127:37: ( 'else' '{' ( body )? '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // src\\grammar\\StrLang.g:127:38: 'else' '{' ( body )? '}'
                    {
                    match(input,35,FOLLOW_35_in_if_op676); 

                    match(input,43,FOLLOW_43_in_if_op678); 

                    // src\\grammar\\StrLang.g:127:49: ( body )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==ID||LA30_0==INT_TYPE||LA30_0==LINE_TYPE||(LA30_0 >= SYMBOL_TYPE && LA30_0 <= VOID_TYPE)||(LA30_0 >= 30 && LA30_0 <= 31)||(LA30_0 >= 33 && LA30_0 <= 34)||(LA30_0 >= 36 && LA30_0 <= 38)||LA30_0==40||LA30_0==42) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // src\\grammar\\StrLang.g:127:49: body
                            {
                            pushFollow(FOLLOW_body_in_if_op680);
                            body();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,44,FOLLOW_44_in_if_op683); 

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
    // src\\grammar\\StrLang.g:130:1: expr : ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY );
    public final void expr() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:131:2: ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY )
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
    // src\\grammar\\StrLang.g:139:1: logic : logic_and ;
    public final void logic() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:140:2: ( logic_and )
            // src\\grammar\\StrLang.g:140:4: logic_and
            {
            pushFollow(FOLLOW_logic_and_in_logic733);
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
    // src\\grammar\\StrLang.g:143:1: logic_and : logic_or ( 'and' logic_or )* ;
    public final void logic_and() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:144:2: ( logic_or ( 'and' logic_or )* )
            // src\\grammar\\StrLang.g:144:4: logic_or ( 'and' logic_or )*
            {
            pushFollow(FOLLOW_logic_or_in_logic_and746);
            logic_or();

            state._fsp--;


            // src\\grammar\\StrLang.g:144:13: ( 'and' logic_or )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==32) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:144:14: 'and' logic_or
            	    {
            	    match(input,32,FOLLOW_32_in_logic_and749); 

            	    pushFollow(FOLLOW_logic_or_in_logic_and751);
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
    // src\\grammar\\StrLang.g:146:1: logic_or : logic_expr ( 'or' logic_expr )* ;
    public final void logic_or() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:147:2: ( logic_expr ( 'or' logic_expr )* )
            // src\\grammar\\StrLang.g:147:4: logic_expr ( 'or' logic_expr )*
            {
            pushFollow(FOLLOW_logic_expr_in_logic_or764);
            logic_expr();

            state._fsp--;


            // src\\grammar\\StrLang.g:147:15: ( 'or' logic_expr )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==39) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:147:16: 'or' logic_expr
            	    {
            	    match(input,39,FOLLOW_39_in_logic_or767); 

            	    pushFollow(FOLLOW_logic_expr_in_logic_or769);
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
    // src\\grammar\\StrLang.g:151:1: logic_expr : ( logic_atom ( expr logic_atom )? | '(' logic ')' );
    public final void logic_expr() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:152:2: ( logic_atom ( expr logic_atom )? | '(' logic ')' )
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
                    // src\\grammar\\StrLang.g:152:4: logic_atom ( expr logic_atom )?
                    {
                    pushFollow(FOLLOW_logic_atom_in_logic_expr783);
                    logic_atom();

                    state._fsp--;


                    // src\\grammar\\StrLang.g:152:15: ( expr logic_atom )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==EQUALLY_EQL_OP||(LA34_0 >= LESS_EQL_OP && LA34_0 <= LESS_OP)||(LA34_0 >= MORE_EQL_OP && LA34_0 <= NO_EQUALLY)) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // src\\grammar\\StrLang.g:152:16: expr logic_atom
                            {
                            pushFollow(FOLLOW_expr_in_logic_expr786);
                            expr();

                            state._fsp--;


                            pushFollow(FOLLOW_logic_atom_in_logic_expr788);
                            logic_atom();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:153:4: '(' logic ')'
                    {
                    match(input,26,FOLLOW_26_in_logic_expr795); 

                    pushFollow(FOLLOW_logic_in_logic_expr797);
                    logic();

                    state._fsp--;


                    match(input,27,FOLLOW_27_in_logic_expr799); 

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
    // src\\grammar\\StrLang.g:156:1: logic_atom : ( LINE | SYMBOL | INT | ID | inside_func | END_LINE );
    public final void logic_atom() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:157:2: ( LINE | SYMBOL | INT | ID | inside_func | END_LINE )
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
                    // src\\grammar\\StrLang.g:157:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_logic_atom810); 

                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:158:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_logic_atom815); 

                    }
                    break;
                case 3 :
                    // src\\grammar\\StrLang.g:159:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_logic_atom820); 

                    }
                    break;
                case 4 :
                    // src\\grammar\\StrLang.g:160:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_logic_atom825); 

                    }
                    break;
                case 5 :
                    // src\\grammar\\StrLang.g:161:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_logic_atom830);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // src\\grammar\\StrLang.g:162:4: END_LINE
                    {
                    match(input,END_LINE,FOLLOW_END_LINE_in_logic_atom835); 

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
    // src\\grammar\\StrLang.g:165:1: specialType : ( INT | ID );
    public final void specialType() throws RecognitionException {
        try {
            // src\\grammar\\StrLang.g:166:2: ( INT | ID )
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


 

    public static final BitSet FOLLOW_global_decl_in_program38 = new BitSet(new long[]{0x00000146C1811402L});
    public static final BitSet FOLLOW_variables_in_global_decl50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_func_in_global_decl55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_in_global_decl60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_func71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_func76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_var_in_variables86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_var_in_variables90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_var102 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_decl_var104 = new BitSet(new long[]{0x0000000000220012L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_decl_var108 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_decl_var110 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_set_in_decl_var115 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_decl_var121 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_ID_in_init_var137 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_init_var140 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_init_var142 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_set_in_init_var145 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_init_var151 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_elem_in_inside_func166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_inside_func172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_op_in_inside_func177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_op_in_inside_func184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_inside_func189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_op_in_inside_func195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func207 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_call_func209 = new BitSet(new long[]{0x0000000009811400L});
    public static final BitSet FOLLOW_param_in_call_func211 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_call_func214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action227 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_DOUBLE_MINUS_in_action230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_PLUS_in_action232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_action234 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_action236 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_set_in_action238 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_action244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_spec_type261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_spec_type267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_spec_type272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_spec_type278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_spec_type284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_spec_type289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_func326 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_global_func328 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_global_func330 = new BitSet(new long[]{0x0000000009811400L});
    public static final BitSet FOLLOW_param_in_global_func332 = new BitSet(new long[]{0x0000000009811400L});
    public static final BitSet FOLLOW_27_in_global_func335 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_global_func337 = new BitSet(new long[]{0x00001776C1811400L});
    public static final BitSet FOLLOW_body_in_global_func339 = new BitSet(new long[]{0x0000120000000000L});
    public static final BitSet FOLLOW_return_op_in_global_func342 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_global_func345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_param361 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_param365 = new BitSet(new long[]{0x0000000010000012L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_param368 = new BitSet(new long[]{0x0000000001811C00L});
    public static final BitSet FOLLOW_type_in_param370 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_param373 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_param385 = new BitSet(new long[]{0x0000000001811400L});
    public static final BitSet FOLLOW_type_in_param389 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_param393 = new BitSet(new long[]{0x0000000010000012L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_param396 = new BitSet(new long[]{0x0000000001811C00L});
    public static final BitSet FOLLOW_type_in_param398 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_param401 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_variables_in_body423 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_func_in_body428 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_if_op_in_body433 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_for_op_in_body438 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_while_op_in_body443 = new BitSet(new long[]{0x00000576C1811402L});
    public static final BitSet FOLLOW_31_in_write_op458 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_write_op460 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_write_op463 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_write_op465 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_write_op468 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_write_op471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_read_op482 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_read_op484 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_read_op487 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_read_op491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_while_op502 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_while_op504 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_in_while_op506 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_while_op508 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_while_op510 = new BitSet(new long[]{0x00001576C1811400L});
    public static final BitSet FOLLOW_body_in_while_op512 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_while_op515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_for_op529 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_for_op531 = new BitSet(new long[]{0x0000000021811400L});
    public static final BitSet FOLLOW_variables_in_for_op533 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_for_op536 = new BitSet(new long[]{0x00000146E4408D00L});
    public static final BitSet FOLLOW_logic_in_for_op538 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_for_op541 = new BitSet(new long[]{0x00000146C8408C00L});
    public static final BitSet FOLLOW_action_in_for_op543 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_for_op546 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_for_op548 = new BitSet(new long[]{0x00001576C1811400L});
    public static final BitSet FOLLOW_body_in_for_op550 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_for_op553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_print_op564 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_print_op566 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_print_op568 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_print_op571 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_print_op573 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_print_op578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_length591 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_length593 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_length595 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_length597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_elem609 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_elem611 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_elem612 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_elem614 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_specialType_in_elem616 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_elem618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_break_op630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_op646 = new BitSet(new long[]{0x00000146C0408C00L});
    public static final BitSet FOLLOW_spec_type_in_return_op648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_if_op660 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_if_op662 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_in_if_op664 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op666 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_if_op668 = new BitSet(new long[]{0x00001576C1811400L});
    public static final BitSet FOLLOW_body_in_if_op670 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_if_op673 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_if_op676 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_if_op678 = new BitSet(new long[]{0x00001576C1811400L});
    public static final BitSet FOLLOW_body_in_if_op680 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_if_op683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_and_in_logic733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_or_in_logic_and746 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_logic_and749 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_or_in_logic_and751 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or764 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_logic_or767 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or769 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr783 = new BitSet(new long[]{0x00000000001C6202L});
    public static final BitSet FOLLOW_expr_in_logic_expr786 = new BitSet(new long[]{0x00000146C0408D00L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_logic_expr795 = new BitSet(new long[]{0x00000146C4408D00L});
    public static final BitSet FOLLOW_logic_in_logic_expr797 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_logic_expr799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_logic_atom810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_logic_atom815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_logic_atom820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_logic_atom825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_logic_atom830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_LINE_in_logic_atom835 = new BitSet(new long[]{0x0000000000000002L});

}