// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g 2012-04-23 15:41:36

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "ASSIGN_OP", "PLUS_OP", "MINUS_OP", "DOUBLE_MINUS", "DOUBLE_PLUS", "INT", "LINE", "SYMBOL", "EQUALLY_EQL_OP", "MORE_EQL_OP", "LESS_EQL_OP", "MORE_OP", "LESS_OP", "NO_EQUALLY", "END_LINE", "LINE_TYPE", "INT_TYPE", "SYMBOL_TYPE", "VOID_TYPE", "COMMENT", "WS", "'('", "')'", "'{'", "'}'", "','", "'WriteToFile'", "'ReadFile'", "'while'", "'for'", "';'", "'print'", "'length'", "'elem'", "'break'", "'return'", "'if'", "'else'", "'and'", "'or'"
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
    		return "line"+e.line+":";
    	}
    	
    	public void emitErrorMessage(String msg)
    	{
    		errors.add(msg);
    	}



    // $ANTLR start "program"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:55:1: program : global_decl ;
    public final void program() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:56:2: ( global_decl )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:56:4: global_decl
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:59:1: global_decl : ( variables | global_func | func )+ ;
    public final void global_decl() throws RecognitionException {
        global_decl_stack.push(new global_decl_scope());

        	((global_decl_scope)global_decl_stack.peek()).name = "";
        	((global_decl_scope)global_decl_stack.peek()).nameOfFunc ="";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:69:2: ( ( variables | global_func | func )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:69:4: ( variables | global_func | func )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:69:4: ( variables | global_func | func )+
            int cnt1=0;
            loop1:
            do {
                int alt1=4;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:69:5: variables
            	    {
            	    ((global_decl_scope)global_decl_stack.peek()).name = "";
            	    pushFollow(FOLLOW_variables_in_global_decl63);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:70:4: global_func
            	    {
            	    ((global_decl_scope)global_decl_stack.peek()).nameOfFunc = "";
            	    pushFollow(FOLLOW_global_func_in_global_decl69);
            	    global_func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:71:4: func
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
            global_decl_stack.pop();
        }
        return ;
    }
    // $ANTLR end "global_decl"


    // $ANTLR start "func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:74:1: func : ( inside_func | call_func );
    public final void func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:75:2: ( inside_func | call_func )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=31 && LA2_0<=32)||(LA2_0>=36 && LA2_0<=39)) ) {
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:75:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_func87);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:76:4: call_func
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
        }
        return ;
    }
    // $ANTLR end "func"


    // $ANTLR start "variables"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:79:1: variables : ( decl_var | init_var );
    public final void variables() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:80:2: ( decl_var | init_var )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=LINE_TYPE && LA3_0<=VOID_TYPE)) ) {
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:80:3: decl_var
                    {
                    pushFollow(FOLLOW_decl_var_in_variables102);
                    decl_var();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:81:3: init_var
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
        }
        return ;
    }
    // $ANTLR end "variables"


    // $ANTLR start "decl_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:84:1: decl_var : type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )* ;
    public final void decl_var() throws RecognitionException {
        Token ID1=null;
        String type2 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:85:2: ( type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:85:4: type ID ( ASSIGN_OP spec_type )? ( ( PLUS_OP | MINUS_OP ) spec_type )*
            {
            pushFollow(FOLLOW_type_in_decl_var118);
            type2=type();

            state._fsp--;

            ID1=(Token)match(input,ID,FOLLOW_ID_in_decl_var120); 

            		if(names.isExist(((global_decl_scope)global_decl_stack.peek()).name+"."+(ID1!=null?ID1.getText():null)))
            			errors.add("line "+(ID1!=null?ID1.getLine():0)+": name "+(ID1!=null?ID1.getText():null)+" duplicated");
            		else
            			names.add(names.new Name(((global_decl_scope)global_decl_stack.peek()).name+"."+(ID1!=null?ID1.getText():null), type2, (ID1!=null?ID1.getLine():0)));
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:92:2: ( ASSIGN_OP spec_type )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ASSIGN_OP) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:92:4: ASSIGN_OP spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_decl_var128); 
                    pushFollow(FOLLOW_spec_type_in_decl_var130);
                    spec_type();

                    state._fsp--;


                    		if(names.isExist(((global_decl_scope)global_decl_stack.peek()).name+"."+(ID1!=null?ID1.getText():null)))
                    			names.get(((global_decl_scope)global_decl_stack.peek()).name+"."+(ID1!=null?ID1.getText():null)).addLineUses((ID1!=null?ID1.getLine():0));
                    		else
                    			errors.add("line "+(ID1!=null?ID1.getLine():0)+": name "+(ID1!=null?ID1.getText():null)+" cannot be resolved");
                    	

                    }
                    break;

            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:99:5: ( ( PLUS_OP | MINUS_OP ) spec_type )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=PLUS_OP && LA5_0<=MINUS_OP)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:99:6: ( PLUS_OP | MINUS_OP ) spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_decl_var146);
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
        }
        return ;
    }
    // $ANTLR end "decl_var"


    // $ANTLR start "init_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:102:1: init_var : ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )* ;
    public final void init_var() throws RecognitionException {
        Token ID3=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:103:2: ( ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:103:4: ID ASSIGN_OP spec_type ( ( PLUS_OP | MINUS_OP ) spec_type )*
            {
            ID3=(Token)match(input,ID,FOLLOW_ID_in_init_var161); 
            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_init_var164); 
            pushFollow(FOLLOW_spec_type_in_init_var166);
            spec_type();

            state._fsp--;


            		if(names.isExist(((global_decl_scope)global_decl_stack.peek()).name+"."+(ID3!=null?ID3.getText():null)))
            			names.get(((global_decl_scope)global_decl_stack.peek()).name+"."+(ID3!=null?ID3.getText():null)).addLineUses((ID3!=null?ID3.getLine():0));
            		else
            			errors.add("line "+(ID3!=null?ID3.getLine():0)+": name "+(ID3!=null?ID3.getText():null)+" cannot be resolved");
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:110:2: ( ( PLUS_OP | MINUS_OP ) spec_type )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=PLUS_OP && LA6_0<=MINUS_OP)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:110:3: ( PLUS_OP | MINUS_OP ) spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_init_var180);
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
        }
        return ;
    }
    // $ANTLR end "init_var"


    // $ANTLR start "inside_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:114:1: inside_func : ( elem | length | print_op | break_op | read_op | write_op );
    public final void inside_func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:115:2: ( elem | length | print_op | break_op | read_op | write_op )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt7=1;
                }
                break;
            case 37:
                {
                alt7=2;
                }
                break;
            case 36:
                {
                alt7=3;
                }
                break;
            case 39:
                {
                alt7=4;
                }
                break;
            case 32:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:115:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_inside_func195);
                    elem();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:116:4: length
                    {
                    pushFollow(FOLLOW_length_in_inside_func201);
                    length();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:117:4: print_op
                    {
                    pushFollow(FOLLOW_print_op_in_inside_func206);
                    print_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:118:4: break_op
                    {
                    pushFollow(FOLLOW_break_op_in_inside_func213);
                    break_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:119:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_inside_func218);
                    read_op();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:120:4: write_op
                    {
                    pushFollow(FOLLOW_write_op_in_inside_func224);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:123:1: call_func : ID '(' ( param )? ')' ;
    public final void call_func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:124:2: ( ID '(' ( param )? ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:124:4: ID '(' ( param )? ')'
            {
            match(input,ID,FOLLOW_ID_in_call_func236); 
            match(input,26,FOLLOW_26_in_call_func238); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:124:11: ( param )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID||(LA8_0>=LINE_TYPE && LA8_0<=VOID_TYPE)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:124:11: param
                    {
                    pushFollow(FOLLOW_param_in_call_func240);
                    param();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_call_func243); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:127:1: action : spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) ;
    public final void action() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:128:2: ( spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:128:4: spec_type ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
            {
            pushFollow(FOLLOW_spec_type_in_action256);
            spec_type();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:128:14: ( DOUBLE_MINUS | DOUBLE_PLUS | ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:128:15: DOUBLE_MINUS
                    {
                    match(input,DOUBLE_MINUS,FOLLOW_DOUBLE_MINUS_in_action259); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:128:28: DOUBLE_PLUS
                    {
                    match(input,DOUBLE_PLUS,FOLLOW_DOUBLE_PLUS_in_action261); 

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:128:40: ASSIGN_OP spec_type ( PLUS_OP | MINUS_OP ) spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_action263); 
                    pushFollow(FOLLOW_spec_type_in_action265);
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

                    pushFollow(FOLLOW_spec_type_in_action273);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:131:1: spec_type returns [String value] : ( INT | LINE | SYMBOL | ID | inside_func | call_func );
    public final String spec_type() throws RecognitionException {
        String value = null;

        Token INT4=null;
        Token LINE5=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:132:2: ( INT | LINE | SYMBOL | ID | inside_func | call_func )
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
                else if ( (LA10_4==EOF||(LA10_4>=ID && LA10_4<=DOUBLE_PLUS)||(LA10_4>=LINE_TYPE && LA10_4<=VOID_TYPE)||LA10_4==27||(LA10_4>=29 && LA10_4<=41)) ) {
                    alt10=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 4, input);

                    throw nvae;
                }
                }
                break;
            case 31:
            case 32:
            case 36:
            case 37:
            case 38:
            case 39:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:132:4: INT
                    {
                    INT4=(Token)match(input,INT,FOLLOW_INT_in_spec_type292); 
                    value = INT4.getText();

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:133:4: LINE
                    {
                    LINE5=(Token)match(input,LINE,FOLLOW_LINE_in_spec_type299); 
                    value = (LINE5!=null?LINE5.getText():null);

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:134:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_spec_type305); 

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:135:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_spec_type310); 

                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:136:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_spec_type315);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:137:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_spec_type320);
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


    // $ANTLR start "type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:144:1: type returns [String idType] : ( 'string' | 'int' | 'char' | 'void' );
    public final String type() throws RecognitionException {
        String idType = null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:145:2: ( 'string' | 'int' | 'char' | 'void' )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:145:4: 'string'
                    {
                    match(input,LINE_TYPE,FOLLOW_LINE_TYPE_in_type337); 
                    idType = "string";

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:146:5: 'int'
                    {
                    match(input,INT_TYPE,FOLLOW_INT_TYPE_in_type345); 
                    idType ="int";

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:147:4: 'char'
                    {
                    match(input,SYMBOL_TYPE,FOLLOW_SYMBOL_TYPE_in_type352); 
                    idType = "char";

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:148:4: 'void'
                    {
                    match(input,VOID_TYPE,FOLLOW_VOID_TYPE_in_type359); 
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
        }
        return idType;
    }
    // $ANTLR end "type"


    // $ANTLR start "global_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:151:1: global_func : type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}' ;
    public final void global_func() throws RecognitionException {
        Token ID6=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:152:2: ( type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:152:4: type ID '(' ( param )* ')' '{' ( body )? ( return_op )? '}'
            {
            pushFollow(FOLLOW_type_in_global_func375);
            type();

            state._fsp--;

            ID6=(Token)match(input,ID,FOLLOW_ID_in_global_func377); 

            		((global_decl_scope)global_decl_stack.peek()).name = (ID6!=null?ID6.getText():null);
            	
            match(input,26,FOLLOW_26_in_global_func384); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:156:7: ( param )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==ID||(LA12_0>=LINE_TYPE && LA12_0<=VOID_TYPE)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:156:7: param
            	    {
            	    pushFollow(FOLLOW_param_in_global_func386);
            	    param();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match(input,27,FOLLOW_27_in_global_func389); 
            match(input,28,FOLLOW_28_in_global_func391); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:156:22: ( body )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID||(LA13_0>=LINE_TYPE && LA13_0<=VOID_TYPE)||(LA13_0>=31 && LA13_0<=34)||(LA13_0>=36 && LA13_0<=39)||LA13_0==41) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:156:22: body
                    {
                    pushFollow(FOLLOW_body_in_global_func393);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:156:28: ( return_op )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==40) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:156:28: return_op
                    {
                    pushFollow(FOLLOW_return_op_in_global_func396);
                    return_op();

                    state._fsp--;


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_global_func399); 

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
    // $ANTLR end "global_func"


    // $ANTLR start "param"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:159:1: param : ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )* ;
    public final void param() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:2: ( ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:4: ( type )? ID ( '=' ( type )? ( INT | ID ) )? ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )*
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:4: ( type )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=LINE_TYPE && LA15_0<=VOID_TYPE)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:6: type
                    {
                    pushFollow(FOLLOW_type_in_param416);
                    type();

                    state._fsp--;


                    }
                    break;

            }

            match(input,ID,FOLLOW_ID_in_param420); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:16: ( '=' ( type )? ( INT | ID ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ASSIGN_OP) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:17: '=' ( type )? ( INT | ID )
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_param423); 
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:21: ( type )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=LINE_TYPE && LA16_0<=VOID_TYPE)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:21: type
                            {
                            pushFollow(FOLLOW_type_in_param425);
                            type();

                            state._fsp--;


                            }
                            break;

                    }

                    if ( input.LA(1)==ID||input.LA(1)==INT ) {
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

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:40: ( ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )? )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==30) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:42: ',' ( type )? ID ( '=' ( type )? ( INT | ID ) )?
            	    {
            	    match(input,30,FOLLOW_30_in_param440); 
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:46: ( type )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( ((LA18_0>=LINE_TYPE && LA18_0<=VOID_TYPE)) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:48: type
            	            {
            	            pushFollow(FOLLOW_type_in_param444);
            	            type();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    match(input,ID,FOLLOW_ID_in_param448); 
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:58: ( '=' ( type )? ( INT | ID ) )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==ASSIGN_OP) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:59: '=' ( type )? ( INT | ID )
            	            {
            	            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_param451); 
            	            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:63: ( type )?
            	            int alt19=2;
            	            int LA19_0 = input.LA(1);

            	            if ( ((LA19_0>=LINE_TYPE && LA19_0<=VOID_TYPE)) ) {
            	                alt19=1;
            	            }
            	            switch (alt19) {
            	                case 1 :
            	                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:160:63: type
            	                    {
            	                    pushFollow(FOLLOW_type_in_param453);
            	                    type();

            	                    state._fsp--;


            	                    }
            	                    break;

            	            }

            	            if ( input.LA(1)==ID||input.LA(1)==INT ) {
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
        }
        return ;
    }
    // $ANTLR end "param"


    // $ANTLR start "body"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:163:1: body : ( variables | func | if_op | for_op | while_op )+ ;
    public final void body() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:164:2: ( ( variables | func | if_op | for_op | while_op )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:164:3: ( variables | func | if_op | for_op | while_op )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:164:3: ( variables | func | if_op | for_op | while_op )+
            int cnt22=0;
            loop22:
            do {
                int alt22=6;
                switch ( input.LA(1) ) {
                case LINE_TYPE:
                case INT_TYPE:
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
                case 31:
                case 32:
                case 36:
                case 37:
                case 38:
                case 39:
                    {
                    alt22=2;
                    }
                    break;
                case 41:
                    {
                    alt22=3;
                    }
                    break;
                case 34:
                    {
                    alt22=4;
                    }
                    break;
                case 33:
                    {
                    alt22=5;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:164:4: variables
            	    {
            	    pushFollow(FOLLOW_variables_in_body478);
            	    variables();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:165:4: func
            	    {
            	    pushFollow(FOLLOW_func_in_body483);
            	    func();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:166:4: if_op
            	    {
            	    pushFollow(FOLLOW_if_op_in_body488);
            	    if_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:167:4: for_op
            	    {
            	    pushFollow(FOLLOW_for_op_in_body493);
            	    for_op();

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:168:4: while_op
            	    {
            	    pushFollow(FOLLOW_while_op_in_body498);
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
        }
        return ;
    }
    // $ANTLR end "body"


    // $ANTLR start "write_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:171:1: write_op : 'WriteToFile' '(' ID ',' ID ')' ;
    public final void write_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:172:2: ( 'WriteToFile' '(' ID ',' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:172:4: 'WriteToFile' '(' ID ',' ID ')'
            {
            match(input,31,FOLLOW_31_in_write_op513); 
            match(input,26,FOLLOW_26_in_write_op515); 
            match(input,ID,FOLLOW_ID_in_write_op518); 
            match(input,30,FOLLOW_30_in_write_op520); 
            match(input,ID,FOLLOW_ID_in_write_op523); 
            match(input,27,FOLLOW_27_in_write_op526); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:175:1: read_op : 'ReadFile' '(' ID ')' ;
    public final void read_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:176:2: ( 'ReadFile' '(' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:176:4: 'ReadFile' '(' ID ')'
            {
            match(input,32,FOLLOW_32_in_read_op537); 
            match(input,26,FOLLOW_26_in_read_op539); 
            match(input,ID,FOLLOW_ID_in_read_op542); 
            match(input,27,FOLLOW_27_in_read_op546); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:179:1: while_op : 'while' '(' logic ')' '{' ( body )? '}' ;
    public final void while_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:180:2: ( 'while' '(' logic ')' '{' ( body )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:180:4: 'while' '(' logic ')' '{' ( body )? '}'
            {
            match(input,33,FOLLOW_33_in_while_op557); 
            match(input,26,FOLLOW_26_in_while_op559); 
            pushFollow(FOLLOW_logic_in_while_op561);
            logic();

            state._fsp--;

            match(input,27,FOLLOW_27_in_while_op563); 
            match(input,28,FOLLOW_28_in_while_op565); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:180:30: ( body )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID||(LA23_0>=LINE_TYPE && LA23_0<=VOID_TYPE)||(LA23_0>=31 && LA23_0<=34)||(LA23_0>=36 && LA23_0<=39)||LA23_0==41) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:180:30: body
                    {
                    pushFollow(FOLLOW_body_in_while_op567);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_while_op570); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:182:1: for_op : 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' ;
    public final void for_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:2: ( 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:4: 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )? '}'
            {
            match(input,34,FOLLOW_34_in_for_op584); 
            match(input,26,FOLLOW_26_in_for_op586); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:14: ( variables )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID||(LA24_0>=LINE_TYPE && LA24_0<=VOID_TYPE)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:14: variables
                    {
                    pushFollow(FOLLOW_variables_in_for_op588);
                    variables();

                    state._fsp--;


                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_for_op591); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:29: ( logic )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ID||(LA25_0>=INT && LA25_0<=SYMBOL)||LA25_0==END_LINE||LA25_0==26||(LA25_0>=31 && LA25_0<=32)||(LA25_0>=36 && LA25_0<=39)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:29: logic
                    {
                    pushFollow(FOLLOW_logic_in_for_op593);
                    logic();

                    state._fsp--;


                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_for_op596); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:40: ( action )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ID||(LA26_0>=INT && LA26_0<=SYMBOL)||(LA26_0>=31 && LA26_0<=32)||(LA26_0>=36 && LA26_0<=39)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:40: action
                    {
                    pushFollow(FOLLOW_action_in_for_op598);
                    action();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_for_op601); 
            match(input,28,FOLLOW_28_in_for_op603); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:56: ( body )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ID||(LA27_0>=LINE_TYPE && LA27_0<=VOID_TYPE)||(LA27_0>=31 && LA27_0<=34)||(LA27_0>=36 && LA27_0<=39)||LA27_0==41) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:56: body
                    {
                    pushFollow(FOLLOW_body_in_for_op605);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_for_op608); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:186:1: print_op : 'print' '(' spec_type ( ',' spec_type )* ')' ;
    public final void print_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:187:2: ( 'print' '(' spec_type ( ',' spec_type )* ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:187:4: 'print' '(' spec_type ( ',' spec_type )* ')'
            {
            match(input,36,FOLLOW_36_in_print_op619); 
            match(input,26,FOLLOW_26_in_print_op621); 
            pushFollow(FOLLOW_spec_type_in_print_op623);
            spec_type();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:187:26: ( ',' spec_type )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==30) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:187:27: ',' spec_type
            	    {
            	    match(input,30,FOLLOW_30_in_print_op626); 
            	    pushFollow(FOLLOW_spec_type_in_print_op628);
            	    spec_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            match(input,27,FOLLOW_27_in_print_op633); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:190:1: length : 'length' '(' spec_type ')' ;
    public final void length() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:191:2: ( 'length' '(' spec_type ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:191:4: 'length' '(' spec_type ')'
            {
            match(input,37,FOLLOW_37_in_length646); 
            match(input,26,FOLLOW_26_in_length648); 
            pushFollow(FOLLOW_spec_type_in_length650);
            spec_type();

            state._fsp--;

            match(input,27,FOLLOW_27_in_length652); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:194:1: elem : 'elem' '(' spec_type ',' specialType ')' ;
    public final void elem() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:195:2: ( 'elem' '(' spec_type ',' specialType ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:195:3: 'elem' '(' spec_type ',' specialType ')'
            {
            match(input,38,FOLLOW_38_in_elem664); 
            match(input,26,FOLLOW_26_in_elem666); 
            pushFollow(FOLLOW_spec_type_in_elem667);
            spec_type();

            state._fsp--;

            match(input,30,FOLLOW_30_in_elem669); 
            pushFollow(FOLLOW_specialType_in_elem671);
            specialType();

            state._fsp--;

            match(input,27,FOLLOW_27_in_elem673); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:198:1: break_op : 'break' ;
    public final void break_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:199:2: ( 'break' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:199:4: 'break'
            {
            match(input,39,FOLLOW_39_in_break_op685); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:203:1: return_op : 'return' spec_type ;
    public final void return_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:204:3: ( 'return' spec_type )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:204:5: 'return' spec_type
            {
            match(input,40,FOLLOW_40_in_return_op701); 
            pushFollow(FOLLOW_spec_type_in_return_op703);
            spec_type();

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
    // $ANTLR end "return_op"


    // $ANTLR start "if_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:207:1: if_op : 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? ;
    public final void if_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:208:2: ( 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:208:4: 'if' '(' logic ')' '{' ( body )? '}' ( 'else' '{' ( body )? '}' )?
            {
            match(input,41,FOLLOW_41_in_if_op715); 
            match(input,26,FOLLOW_26_in_if_op717); 
            pushFollow(FOLLOW_logic_in_if_op719);
            logic();

            state._fsp--;

            match(input,27,FOLLOW_27_in_if_op721); 
            match(input,28,FOLLOW_28_in_if_op723); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:208:27: ( body )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==ID||(LA29_0>=LINE_TYPE && LA29_0<=VOID_TYPE)||(LA29_0>=31 && LA29_0<=34)||(LA29_0>=36 && LA29_0<=39)||LA29_0==41) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:208:27: body
                    {
                    pushFollow(FOLLOW_body_in_if_op725);
                    body();

                    state._fsp--;


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_if_op728); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:208:37: ( 'else' '{' ( body )? '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==42) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:208:38: 'else' '{' ( body )? '}'
                    {
                    match(input,42,FOLLOW_42_in_if_op731); 
                    match(input,28,FOLLOW_28_in_if_op733); 
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:208:49: ( body )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==ID||(LA30_0>=LINE_TYPE && LA30_0<=VOID_TYPE)||(LA30_0>=31 && LA30_0<=34)||(LA30_0>=36 && LA30_0<=39)||LA30_0==41) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:208:49: body
                            {
                            pushFollow(FOLLOW_body_in_if_op735);
                            body();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,29,FOLLOW_29_in_if_op738); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:211:1: expr : ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY );
    public final void expr() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:212:2: ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY )
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:220:1: logic : logic_and ;
    public final void logic() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:221:2: ( logic_and )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:221:4: logic_and
            {
            pushFollow(FOLLOW_logic_and_in_logic788);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:224:1: logic_and : logic_or ( 'and' logic_or )* ;
    public final void logic_and() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:225:2: ( logic_or ( 'and' logic_or )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:225:4: logic_or ( 'and' logic_or )*
            {
            pushFollow(FOLLOW_logic_or_in_logic_and801);
            logic_or();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:225:13: ( 'and' logic_or )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==43) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:225:14: 'and' logic_or
            	    {
            	    match(input,43,FOLLOW_43_in_logic_and804); 
            	    pushFollow(FOLLOW_logic_or_in_logic_and806);
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
        }
        return ;
    }
    // $ANTLR end "logic_and"


    // $ANTLR start "logic_or"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:227:1: logic_or : logic_expr ( 'or' logic_expr )* ;
    public final void logic_or() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:228:2: ( logic_expr ( 'or' logic_expr )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:228:4: logic_expr ( 'or' logic_expr )*
            {
            pushFollow(FOLLOW_logic_expr_in_logic_or819);
            logic_expr();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:228:15: ( 'or' logic_expr )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==44) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:228:16: 'or' logic_expr
            	    {
            	    match(input,44,FOLLOW_44_in_logic_or822); 
            	    pushFollow(FOLLOW_logic_expr_in_logic_or824);
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
        }
        return ;
    }
    // $ANTLR end "logic_or"


    // $ANTLR start "logic_expr"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:232:1: logic_expr : ( logic_atom ( expr logic_atom )? | '(' logic ')' );
    public final void logic_expr() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:233:2: ( logic_atom ( expr logic_atom )? | '(' logic ')' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ID||(LA35_0>=INT && LA35_0<=SYMBOL)||LA35_0==END_LINE||(LA35_0>=31 && LA35_0<=32)||(LA35_0>=36 && LA35_0<=39)) ) {
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:233:4: logic_atom ( expr logic_atom )?
                    {
                    pushFollow(FOLLOW_logic_atom_in_logic_expr838);
                    logic_atom();

                    state._fsp--;

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:233:15: ( expr logic_atom )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( ((LA34_0>=EQUALLY_EQL_OP && LA34_0<=NO_EQUALLY)) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:233:16: expr logic_atom
                            {
                            pushFollow(FOLLOW_expr_in_logic_expr841);
                            expr();

                            state._fsp--;

                            pushFollow(FOLLOW_logic_atom_in_logic_expr843);
                            logic_atom();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:234:4: '(' logic ')'
                    {
                    match(input,26,FOLLOW_26_in_logic_expr850); 
                    pushFollow(FOLLOW_logic_in_logic_expr852);
                    logic();

                    state._fsp--;

                    match(input,27,FOLLOW_27_in_logic_expr854); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:237:1: logic_atom : ( LINE | SYMBOL | INT | ID | inside_func | END_LINE );
    public final void logic_atom() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:238:2: ( LINE | SYMBOL | INT | ID | inside_func | END_LINE )
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
            case 31:
            case 32:
            case 36:
            case 37:
            case 38:
            case 39:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:238:4: LINE
                    {
                    match(input,LINE,FOLLOW_LINE_in_logic_atom865); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:239:4: SYMBOL
                    {
                    match(input,SYMBOL,FOLLOW_SYMBOL_in_logic_atom870); 

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:240:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_logic_atom875); 

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:241:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_logic_atom880); 

                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:242:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_logic_atom885);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:243:4: END_LINE
                    {
                    match(input,END_LINE,FOLLOW_END_LINE_in_logic_atom890); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:246:1: specialType : ( INT | ID );
    public final void specialType() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:247:2: ( INT | ID )
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


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\13\uffff";
    static final String DFA1_eofS =
        "\1\1\7\uffff\1\11\2\uffff";
    static final String DFA1_minS =
        "\1\4\1\uffff\4\4\1\5\1\uffff\1\4\2\uffff";
    static final String DFA1_maxS =
        "\1\47\1\uffff\4\4\1\32\1\uffff\1\47\2\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\4\5\uffff\1\3\1\uffff\1\1\1\2";
    static final String DFA1_specialS =
        "\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\6\17\uffff\1\2\1\3\1\4\1\5\7\uffff\2\7\3\uffff\4\7",
            "",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\11\24\uffff\1\7",
            "",
            "\4\11\14\uffff\4\11\2\uffff\1\12\4\uffff\2\11\3\uffff\4\11",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()+ loopback of 69:4: ( variables | global_func | func )+";
        }
    }
 

    public static final BitSet FOLLOW_global_decl_in_program43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variables_in_global_decl63 = new BitSet(new long[]{0x000000F180F00012L});
    public static final BitSet FOLLOW_global_func_in_global_decl69 = new BitSet(new long[]{0x000000F180F00012L});
    public static final BitSet FOLLOW_func_in_global_decl74 = new BitSet(new long[]{0x000000F180F00012L});
    public static final BitSet FOLLOW_inside_func_in_func87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_func92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_var_in_variables102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_var_in_variables106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_var118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_decl_var120 = new BitSet(new long[]{0x00000000000000E2L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_decl_var128 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_decl_var130 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_decl_var140 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_decl_var146 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_ID_in_init_var161 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_init_var164 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_init_var166 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_init_var174 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_init_var180 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_elem_in_inside_func195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_inside_func201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_op_in_inside_func206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_op_in_inside_func213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_inside_func218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_op_in_inside_func224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func236 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_call_func238 = new BitSet(new long[]{0x0000000008F00010L});
    public static final BitSet FOLLOW_param_in_call_func240 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_call_func243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action256 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_DOUBLE_MINUS_in_action259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_PLUS_in_action261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_action263 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_action265 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_action267 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_action273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_spec_type292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_spec_type299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_spec_type305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_spec_type310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_spec_type315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_spec_type320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_TYPE_in_type337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_TYPE_in_type345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_TYPE_in_type352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_TYPE_in_type359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_func375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_func377 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_global_func384 = new BitSet(new long[]{0x0000000008F00010L});
    public static final BitSet FOLLOW_param_in_global_func386 = new BitSet(new long[]{0x0000000008F00010L});
    public static final BitSet FOLLOW_27_in_global_func389 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_global_func391 = new BitSet(new long[]{0x000003F7A0F00010L});
    public static final BitSet FOLLOW_body_in_global_func393 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_return_op_in_global_func396 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_global_func399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_param416 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_param420 = new BitSet(new long[]{0x0000000040000022L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_param423 = new BitSet(new long[]{0x0000000000F00410L});
    public static final BitSet FOLLOW_type_in_param425 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_set_in_param428 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_param440 = new BitSet(new long[]{0x0000000000F00010L});
    public static final BitSet FOLLOW_type_in_param444 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_param448 = new BitSet(new long[]{0x0000000040000022L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_param451 = new BitSet(new long[]{0x0000000000F00410L});
    public static final BitSet FOLLOW_type_in_param453 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_set_in_param456 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_variables_in_body478 = new BitSet(new long[]{0x000002F780F00012L});
    public static final BitSet FOLLOW_func_in_body483 = new BitSet(new long[]{0x000002F780F00012L});
    public static final BitSet FOLLOW_if_op_in_body488 = new BitSet(new long[]{0x000002F780F00012L});
    public static final BitSet FOLLOW_for_op_in_body493 = new BitSet(new long[]{0x000002F780F00012L});
    public static final BitSet FOLLOW_while_op_in_body498 = new BitSet(new long[]{0x000002F780F00012L});
    public static final BitSet FOLLOW_31_in_write_op513 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_write_op515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_write_op518 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_write_op520 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_write_op523 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_write_op526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_read_op537 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_read_op539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_read_op542 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_read_op546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_while_op557 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_while_op559 = new BitSet(new long[]{0x000000F184081C10L});
    public static final BitSet FOLLOW_logic_in_while_op561 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_while_op563 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_while_op565 = new BitSet(new long[]{0x000002F7A0F00010L});
    public static final BitSet FOLLOW_body_in_while_op567 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_while_op570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_for_op584 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_for_op586 = new BitSet(new long[]{0x0000000800F00010L});
    public static final BitSet FOLLOW_variables_in_for_op588 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_for_op591 = new BitSet(new long[]{0x000000F984081C10L});
    public static final BitSet FOLLOW_logic_in_for_op593 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_for_op596 = new BitSet(new long[]{0x000000F188F01C10L});
    public static final BitSet FOLLOW_action_in_for_op598 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_for_op601 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_for_op603 = new BitSet(new long[]{0x000002F7A0F00010L});
    public static final BitSet FOLLOW_body_in_for_op605 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_for_op608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_print_op619 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_print_op621 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_print_op623 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_30_in_print_op626 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_print_op628 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_27_in_print_op633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_length646 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_length648 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_length650 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_length652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_elem664 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_elem666 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_elem667 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_elem669 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_specialType_in_elem671 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_elem673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_break_op685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_return_op701 = new BitSet(new long[]{0x000000F180F01C10L});
    public static final BitSet FOLLOW_spec_type_in_return_op703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_if_op715 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_if_op717 = new BitSet(new long[]{0x000000F184081C10L});
    public static final BitSet FOLLOW_logic_in_if_op719 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op721 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_if_op723 = new BitSet(new long[]{0x000002F7A0F00010L});
    public static final BitSet FOLLOW_body_in_if_op725 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_if_op728 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_if_op731 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_if_op733 = new BitSet(new long[]{0x000002F7A0F00010L});
    public static final BitSet FOLLOW_body_in_if_op735 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_if_op738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expr0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_and_in_logic788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_or_in_logic_and801 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_logic_and804 = new BitSet(new long[]{0x000000F184081C10L});
    public static final BitSet FOLLOW_logic_or_in_logic_and806 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or819 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_logic_or822 = new BitSet(new long[]{0x000000F184081C10L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or824 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr838 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_expr_in_logic_expr841 = new BitSet(new long[]{0x000000F180081C10L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_logic_expr850 = new BitSet(new long[]{0x000000F184081C10L});
    public static final BitSet FOLLOW_logic_in_logic_expr852 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_logic_expr854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_logic_atom865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_logic_atom870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_logic_atom875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_logic_atom880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_logic_atom885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_LINE_in_logic_atom890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_specialType0 = new BitSet(new long[]{0x0000000000000002L});

}