// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g 2012-05-11 03:14:37

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "ASSIGN_OP", "PLUS_OP", "MINUS_OP", "INT", "LINE", "SYMBOL", "EQUALLY_EQL_OP", "MORE_EQL_OP", "LESS_EQL_OP", "MORE_OP", "LESS_OP", "NO_EQUALLY", "DOUBLE_MINUS", "DOUBLE_PLUS", "END_LINE", "COMMENT", "WS", "'main'", "'{'", "'}'", "','", "'('", "')'", "'string'", "'int'", "'char'", "'void'", "'WriteToFile'", "'ReadFile'", "'while'", "'for'", "';'", "'print'", "'length'", "'elem'", "'break'", "'return'", "'if'", "'else'", "'and'", "'or'"
    };
    public static final int EOF=-1;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
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
    public static final int INT=8;
    public static final int LINE=9;
    public static final int SYMBOL=10;
    public static final int EQUALLY_EQL_OP=11;
    public static final int MORE_EQL_OP=12;
    public static final int LESS_EQL_OP=13;
    public static final int MORE_OP=14;
    public static final int LESS_OP=15;
    public static final int NO_EQUALLY=16;
    public static final int DOUBLE_MINUS=17;
    public static final int DOUBLE_PLUS=18;
    public static final int END_LINE=19;
    public static final int COMMENT=20;
    public static final int WS=21;

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


    protected static class program_scope {
        String curBlock;
    }
    protected Stack program_stack = new Stack();


    // $ANTLR start "program"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:57:1: program : ( global_decl )? mainBlock ;
    public final void program() throws RecognitionException {
        program_stack.push(new program_scope());

        	((program_scope)program_stack.peek()).curBlock = "";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:64:2: ( ( global_decl )? mainBlock )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:64:4: ( global_decl )? mainBlock
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:64:4: ( global_decl )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID||(LA1_0>=28 && LA1_0<=31)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:64:4: global_decl
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:67:1: mainBlock : 'main' '{' ( body )* '}' ;
    public final void mainBlock() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:67:10: ( 'main' '{' ( body )* '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:68:3: 'main' '{' ( body )* '}'
            {
            match(input,22,FOLLOW_22_in_mainBlock68); 
            match(input,23,FOLLOW_23_in_mainBlock70); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:68:14: ( body )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||(LA2_0>=28 && LA2_0<=35)||(LA2_0>=37 && LA2_0<=40)||LA2_0==42) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:68:14: body
            	    {
            	    pushFollow(FOLLOW_body_in_mainBlock72);
            	    body();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_mainBlock75); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:71:1: global_decl : ( global_var | global_func )+ ;
    public final void global_decl() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:72:2: ( ( global_var | global_func )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:73:2: ( global_var | global_func )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:73:2: ( global_var | global_func )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=28 && LA3_0<=31)) ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==ID) ) {
                        int LA3_4 = input.LA(3);

                        if ( ((LA3_4>=ID && LA3_4<=MINUS_OP)||LA3_4==22||LA3_4==25||(LA3_4>=28 && LA3_4<=31)) ) {
                            alt3=1;
                        }
                        else if ( (LA3_4==26) ) {
                            alt3=2;
                        }


                    }


                }
                else if ( (LA3_0==ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:73:3: global_var
            	    {
            	    pushFollow(FOLLOW_global_var_in_global_decl90);
            	    global_var();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:73:16: global_func
            	    {
            	    pushFollow(FOLLOW_global_func_in_global_decl94);
            	    global_func();

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


    // $ANTLR start "global_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:76:1: global_var : variables ;
    public final void global_var() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:77:2: ( variables )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:77:4: variables
            {
             ((program_scope)program_stack.peek()).curBlock = "global";
            pushFollow(FOLLOW_variables_in_global_var110);
            variables();

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
    // $ANTLR end "global_var"


    // $ANTLR start "func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:80:1: func : ( inside_func | call_func );
    public final void func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:81:2: ( inside_func | call_func )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:81:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_func121);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:82:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_func126);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:85:1: variables : ( decl_var | init_var );
    public final void variables() throws RecognitionException {
        variables_stack.push(new variables_scope());

        	((variables_scope)variables_stack.peek()).varType = "";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:92:2: ( decl_var | init_var )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=28 && LA5_0<=31)) ) {
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:92:3: decl_var
                    {
                    pushFollow(FOLLOW_decl_var_in_variables143);
                    decl_var();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:93:3: init_var
                    {
                    pushFollow(FOLLOW_init_var_in_variables147);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:96:1: decl_var : type variableDeclarators ;
    public final void decl_var() throws RecognitionException {
        StrLangParser.type_return type1 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:97:2: ( type variableDeclarators )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:97:4: type variableDeclarators
            {
            pushFollow(FOLLOW_type_in_decl_var159);
            type1=type();

            state._fsp--;


            		((variables_scope)variables_stack.peek()).varType = (type1!=null?input.toString(type1.start,type1.stop):null);
            	
            pushFollow(FOLLOW_variableDeclarators_in_decl_var165);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:104:1: variableDeclarators : variableDeclarator ( ',' variableDeclarator )* ;
    public final void variableDeclarators() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:105:2: ( variableDeclarator ( ',' variableDeclarator )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:105:4: variableDeclarator ( ',' variableDeclarator )*
            {
            pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators177);
            variableDeclarator();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:105:23: ( ',' variableDeclarator )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:105:24: ',' variableDeclarator
            	    {
            	    match(input,25,FOLLOW_25_in_variableDeclarators180); 
            	    pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators182);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:108:1: variableDeclarator : ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* ;
    public final void variableDeclarator() throws RecognitionException {
        variableDeclarator_stack.push(new variableDeclarator_scope());
        Token ID2=null;
        StrLangParser.spec_type_return firstAssign = null;

        StrLangParser.spec_type_return secondAssign = null;



        	((variableDeclarator_scope)variableDeclarator_stack.peek()).varList = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:115:2: ( ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:115:4: ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            {
            ID2=(Token)match(input,ID,FOLLOW_ID_in_variableDeclarator203); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID2!=null?ID2.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID2!=null?ID2.getText():null), ((variables_scope)variables_stack.peek()).varType, (ID2!=null?ID2.getLine():0)));
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID2!=null?ID2.getText():null)))
            				errors.add("line "+(ID2!=null?ID2.getLine():0)+": Duplicated variable name "+(ID2!=null?ID2.getText():null));
            		}
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:128:2: ( ASSIGN_OP firstAssign= spec_type )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ASSIGN_OP) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:129:3: ASSIGN_OP firstAssign= spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_variableDeclarator215); 
                    pushFollow(FOLLOW_spec_type_in_variableDeclarator219);
                    firstAssign=spec_type();

                    state._fsp--;


                    			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, (firstAssign!=null?firstAssign.value:null)))
                    			{
                    				errors.add("line "+(ID2!=null?ID2.getLine():0)+": Type mismatch: cannot convert from "+((variables_scope)variables_stack.peek()).varType+" to "+(firstAssign!=null?firstAssign.value:null));
                    			}
                    		

                    }
                    break;

            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:137:2: ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=PLUS_OP && LA8_0<=MINUS_OP)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:137:3: ( PLUS_OP | MINUS_OP ) secondAssign= spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_variableDeclarator239);
            	    secondAssign=spec_type();

            	    state._fsp--;


            	    			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, (secondAssign!=null?secondAssign.value:null)))
            	    			{
            	    				errors.add("line "+(ID2!=null?ID2.getLine():0)+": Type mismatch: cannot convert from "+((variables_scope)variables_stack.peek()).varType+" to "+(secondAssign!=null?secondAssign.value:null));
            	    			}
            	    		

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:148:1: init_var : ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* ;
    public final void init_var() throws RecognitionException {
        Token ID3=null;
        StrLangParser.spec_type_return firstAssign = null;

        StrLangParser.spec_type_return secondAssign = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:149:2: ( ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:149:4: ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            {
            ID3=(Token)match(input,ID,FOLLOW_ID_in_init_var261); 
            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_init_var263); 
            pushFollow(FOLLOW_spec_type_in_init_var267);
            firstAssign=spec_type();

            state._fsp--;


            		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID3!=null?ID3.getText():null)))
            		{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID3!=null?ID3.getText():null));
            			((variables_scope)variables_stack.peek()).varType = var_type.getType();
            			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, (firstAssign!=null?firstAssign.value:null)))
            			{
            				errors.add("line "+(ID3!=null?ID3.getLine():0)+": Type mismatch: cannot convert from "+((variables_scope)variables_stack.peek()).varType+" to "+(firstAssign!=null?firstAssign.value:null));
            			}
            		}
            		else
            		{
            			errors.add("line "+(ID3!=null?ID3.getLine():0)+": "+(ID3!=null?ID3.getText():null)+" cannot be resolved to a variable");
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
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:166:3: ( PLUS_OP | MINUS_OP ) secondAssign= spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_init_var285);
            	    secondAssign=spec_type();

            	    state._fsp--;


            	    			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, (secondAssign!=null?secondAssign.value:null)))
            	    			{
            	    				errors.add("line "+(ID3!=null?ID3.getLine():0)+": Type mismatch: cannot convert from "+((variables_scope)variables_stack.peek()).varType+" to "+(secondAssign!=null?secondAssign.value:null));
            	    			}
            	    		

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:177:1: inside_func : ( elem | length | print_op | break_op | read_op | write_op );
    public final void inside_func() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:178:2: ( elem | length | print_op | break_op | read_op | write_op )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:178:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_inside_func306);
                    elem();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:179:4: length
                    {
                    pushFollow(FOLLOW_length_in_inside_func311);
                    length();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:180:4: print_op
                    {
                    pushFollow(FOLLOW_print_op_in_inside_func316);
                    print_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:181:4: break_op
                    {
                    pushFollow(FOLLOW_break_op_in_inside_func323);
                    break_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:182:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_inside_func328);
                    read_op();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:183:4: write_op
                    {
                    pushFollow(FOLLOW_write_op_in_inside_func334);
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

    public static class assign_inside_func_return extends ParserRuleReturnScope {
        public String type;
        public int line;
    };

    // $ANTLR start "assign_inside_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:186:1: assign_inside_func returns [String type, int line] : ( elem | length | read_op );
    public final StrLangParser.assign_inside_func_return assign_inside_func() throws RecognitionException {
        StrLangParser.assign_inside_func_return retval = new StrLangParser.assign_inside_func_return();
        retval.start = input.LT(1);

        int elem4 = 0;

        int length5 = 0;

        int read_op6 = 0;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:187:2: ( elem | length | read_op )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:187:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_assign_inside_func349);
                    elem4=elem();

                    state._fsp--;

                    retval.type = "char"; retval.line = elem4;

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:188:4: length
                    {
                    pushFollow(FOLLOW_length_in_assign_inside_func356);
                    length5=length();

                    state._fsp--;

                    retval.type = "int"; retval.line = length5;

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:189:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_assign_inside_func363);
                    read_op6=read_op();

                    state._fsp--;

                    retval.type = "string"; retval.line = read_op6;

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:192:1: call_func returns [String type, int curLine] : ID '(' ( param )? ')' ;
    public final StrLangParser.call_func_return call_func() throws RecognitionException {
        call_func_stack.push(new call_func_scope());
        StrLangParser.call_func_return retval = new StrLangParser.call_func_return();
        retval.start = input.LT(1);

        Token ID7=null;
        ArrayList<String> param8 = null;



        	((call_func_scope)call_func_stack.peek()).methodName ="";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:199:2: ( ID '(' ( param )? ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:199:4: ID '(' ( param )? ')'
            {
            ID7=(Token)match(input,ID,FOLLOW_ID_in_call_func387); 
            ((call_func_scope)call_func_stack.peek()).methodName =(ID7!=null?ID7.getText():null);
            match(input,26,FOLLOW_26_in_call_func391); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:199:46: ( param )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID||(LA12_0>=INT && LA12_0<=SYMBOL)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:199:46: param
                    {
                    pushFollow(FOLLOW_param_in_call_func393);
                    param8=param();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_call_func396); 

            		retval.curLine = (ID7!=null?ID7.getLine():0);
            		ArrayList<String> list = null;
            		if(param8==null)
            			list = new ArrayList<String>();
            		else
            			list = param8;
            		if(!names.checkCallFunction((ID7!=null?ID7.getText():null), list, (ID7!=null?ID7.getLine():0)))
            		{
            			names.getAllErrors(errors);
            		}
            		if(!names.isExistFunction((ID7!=null?ID7.getText():null)))
            		{
            			errors.add("line "+(ID7!=null?ID7.getLine():0)+": function "+(ID7!=null?ID7.getText():null)+" is not exist");
            		}
            		else
            		{
            			NamesTable.FunctionName func = names.getFunction((ID7!=null?ID7.getText():null));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:223:1: action : (a= spec_type prefix | b= spec_type ASSIGN_OP c= spec_type ( PLUS_OP | MINUS_OP ) d= spec_type );
    public final void action() throws RecognitionException {
        StrLangParser.spec_type_return a = null;

        StrLangParser.spec_type_return b = null;

        StrLangParser.spec_type_return c = null;

        StrLangParser.spec_type_return d = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:224:2: (a= spec_type prefix | b= spec_type ASSIGN_OP c= spec_type ( PLUS_OP | MINUS_OP ) d= spec_type )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:224:4: a= spec_type prefix
                    {
                    pushFollow(FOLLOW_spec_type_in_action414);
                    a=spec_type();

                    state._fsp--;

                    pushFollow(FOLLOW_prefix_in_action416);
                    prefix();

                    state._fsp--;


                    		String s_type = "int";
                    		if(!TypesChecker.checkTypes((a!=null?a.value:null), s_type))
                    		{
                    			errors.add("line "+(a!=null?a.curLine:0)+": incomparable types in variable "+(a!=null?a.text:null)+": "+(a!=null?a.value:null)+" and "+s_type);
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:232:4: b= spec_type ASSIGN_OP c= spec_type ( PLUS_OP | MINUS_OP ) d= spec_type
                    {
                    pushFollow(FOLLOW_spec_type_in_action426);
                    b=spec_type();

                    state._fsp--;

                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_action428); 
                    pushFollow(FOLLOW_spec_type_in_action432);
                    c=spec_type();

                    state._fsp--;

                    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_spec_type_in_action442);
                    d=spec_type();

                    state._fsp--;


                    		String s_type = "int", type="";
                    		if((b!=null?b.value:null)=="")
                    			type = "none";
                    		else
                    			type = (b!=null?b.value:null);
                    		if(!TypesChecker.checkTypes((b!=null?b.value:null), s_type))
                    		{
                    			errors.add("line "+(b!=null?b.curLine:0)+": incomparable types in variable "+(b!=null?b.text:null)+": "+type+" and "+s_type);
                    		}
                    		if((c!=null?c.value:null)=="")
                    			type = "none";
                    		else
                    			type = (c!=null?c.value:null);
                    		if(!TypesChecker.checkTypes((c!=null?c.value:null), s_type))
                    		{
                    			errors.add("line "+(c!=null?c.curLine:0)+": incomparable types in variable "+(c!=null?c.text:null)+": "+type+" and "+s_type);
                    		}
                    		if((d!=null?d.value:null)=="")
                    			type = "none";
                    		else
                    			type = (d!=null?d.value:null);
                    		if(!TypesChecker.checkTypes((d!=null?d.value:null), s_type))
                    		{
                    			errors.add("line "+(d!=null?d.curLine:0)+": incomparable types in variable "+(d!=null?d.text:null)+": "+type+" and "+s_type);
                    		}
                    	

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
    // $ANTLR end "action"

    public static class spec_type_return extends ParserRuleReturnScope {
        public String value;
        public int curLine;
        public String text;
    };

    // $ANTLR start "spec_type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:263:1: spec_type returns [String value, int curLine, String text] : ( INT | LINE | SYMBOL | idLiteral | assign_inside_func | call_func );
    public final StrLangParser.spec_type_return spec_type() throws RecognitionException {
        StrLangParser.spec_type_return retval = new StrLangParser.spec_type_return();
        retval.start = input.LT(1);

        Token INT9=null;
        Token LINE10=null;
        Token SYMBOL11=null;
        StrLangParser.idLiteral_return idLiteral12 = null;

        StrLangParser.assign_inside_func_return assign_inside_func13 = null;

        StrLangParser.call_func_return call_func14 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:264:2: ( INT | LINE | SYMBOL | idLiteral | assign_inside_func | call_func )
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

                if ( ((LA14_4>=ID && LA14_4<=MINUS_OP)||(LA14_4>=EQUALLY_EQL_OP && LA14_4<=DOUBLE_PLUS)||LA14_4==22||(LA14_4>=24 && LA14_4<=25)||(LA14_4>=27 && LA14_4<=42)||(LA14_4>=44 && LA14_4<=45)) ) {
                    alt14=4;
                }
                else if ( (LA14_4==26) ) {
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:264:4: INT
                    {
                    INT9=(Token)match(input,INT,FOLLOW_INT_in_spec_type465); 
                    retval.value = "int"; retval.curLine = (INT9!=null?INT9.getLine():0);

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:265:4: LINE
                    {
                    LINE10=(Token)match(input,LINE,FOLLOW_LINE_in_spec_type472); 
                    retval.value = "string"; retval.curLine =(LINE10!=null?LINE10.getLine():0);

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:266:4: SYMBOL
                    {
                    SYMBOL11=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_spec_type479); 
                    retval.value = "char"; retval.curLine = (SYMBOL11!=null?SYMBOL11.getLine():0);

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:267:4: idLiteral
                    {
                    pushFollow(FOLLOW_idLiteral_in_spec_type486);
                    idLiteral12=idLiteral();

                    state._fsp--;

                    retval.value = (idLiteral12!=null?idLiteral12.idType:null); retval.curLine = (idLiteral12!=null?idLiteral12.curLine:0); retval.text = (idLiteral12!=null?idLiteral12.text:null);

                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:268:4: assign_inside_func
                    {
                    pushFollow(FOLLOW_assign_inside_func_in_spec_type493);
                    assign_inside_func13=assign_inside_func();

                    state._fsp--;

                    retval.value = (assign_inside_func13!=null?assign_inside_func13.type:null); retval.curLine = (assign_inside_func13!=null?assign_inside_func13.line:0);

                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:269:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_spec_type500);
                    call_func14=call_func();

                    state._fsp--;

                    retval.value = (call_func14!=null?call_func14.type:null); retval.curLine = (call_func14!=null?call_func14.curLine:0);

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
    // $ANTLR end "spec_type"

    public static class returnType_return extends ParserRuleReturnScope {
        public String value;
        public String type;
    };

    // $ANTLR start "returnType"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:272:1: returnType returns [String value, String type] : ( INT | LINE | SYMBOL | idLiteral );
    public final StrLangParser.returnType_return returnType() throws RecognitionException {
        StrLangParser.returnType_return retval = new StrLangParser.returnType_return();
        retval.start = input.LT(1);

        Token INT15=null;
        Token LINE16=null;
        Token SYMBOL17=null;
        StrLangParser.idLiteral_return idLiteral18 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:273:2: ( INT | LINE | SYMBOL | idLiteral )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:273:4: INT
                    {
                    INT15=(Token)match(input,INT,FOLLOW_INT_in_returnType517); 
                    retval.value = (INT15!=null?INT15.getText():null); retval.type = "int";

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:274:4: LINE
                    {
                    LINE16=(Token)match(input,LINE,FOLLOW_LINE_in_returnType524); 
                    retval.value = (LINE16!=null?LINE16.getText():null); retval.type = "string";

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:275:4: SYMBOL
                    {
                    SYMBOL17=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_returnType531); 
                    retval.value = (SYMBOL17!=null?SYMBOL17.getText():null); retval.type = "char";

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:276:4: idLiteral
                    {
                    pushFollow(FOLLOW_idLiteral_in_returnType538);
                    idLiteral18=idLiteral();

                    state._fsp--;

                    retval.value = (idLiteral18!=null?idLiteral18.text:null); retval.type = (idLiteral18!=null?idLiteral18.idType:null);

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
        public String text;
    };

    // $ANTLR start "idLiteral"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:279:1: idLiteral returns [String idType, int curLine, String text] : ID ;
    public final StrLangParser.idLiteral_return idLiteral() throws RecognitionException {
        StrLangParser.idLiteral_return retval = new StrLangParser.idLiteral_return();
        retval.start = input.LT(1);

        Token ID19=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:280:2: ( ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:280:4: ID
            {
            ID19=(Token)match(input,ID,FOLLOW_ID_in_idLiteral555); 

            		retval.curLine = (ID19!=null?ID19.getLine():0);
            		retval.text = (ID19!=null?ID19.getText():null);
            		if(!names.isExistVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID19!=null?ID19.getText():null)))
            		{
            			errors.add("line "+(ID19!=null?ID19.getLine():0)+": unknown variable "+(ID19!=null?ID19.getText():null));
            			retval.idType = "";
            		}
            		else
            		{
            			names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID19!=null?ID19.getText():null)).addLineUses((ID19!=null?ID19.getLine():0));
            			retval.idType = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID19!=null?ID19.getText():null)).getType();
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:297:1: type : ( 'string' | 'int' | 'char' | 'void' );
    public final StrLangParser.type_return type() throws RecognitionException {
        StrLangParser.type_return retval = new StrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:298:2: ( 'string' | 'int' | 'char' | 'void' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:
            {
            if ( (input.LA(1)>=28 && input.LA(1)<=31) ) {
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:304:1: global_func : type ID '(' ( functionArgumentList )? ')' '{' ( body )* ( return_op )? '}' ;
    public final void global_func() throws RecognitionException {
        global_func_stack.push(new global_func_scope());
        Token ID21=null;
        StrLangParser.type_return type20 = null;



        	((global_func_scope)global_func_stack.peek()).funcName = "";
        	((global_func_scope)global_func_stack.peek()).funcType = "";
        	((global_func_scope)global_func_stack.peek()).returnVariable = "";
        	((global_func_scope)global_func_stack.peek()).funcArgNames = new ArrayList<String>();
        	((global_func_scope)global_func_stack.peek()).funcArgTypes = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:320:2: ( type ID '(' ( functionArgumentList )? ')' '{' ( body )* ( return_op )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:320:4: type ID '(' ( functionArgumentList )? ')' '{' ( body )* ( return_op )? '}'
            {
            pushFollow(FOLLOW_type_in_global_func606);
            type20=type();

            state._fsp--;

            ((global_func_scope)global_func_stack.peek()).funcType = (type20!=null?input.toString(type20.start,type20.stop):null);
            ID21=(Token)match(input,ID,FOLLOW_ID_in_global_func610); 
            ((program_scope)program_stack.peek()).curBlock = (ID21!=null?ID21.getText():null); ((global_func_scope)global_func_stack.peek()).funcName =(ID21!=null?ID21.getText():null);
            match(input,26,FOLLOW_26_in_global_func615); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:321:7: ( functionArgumentList )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=28 && LA16_0<=31)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:321:7: functionArgumentList
                    {
                    pushFollow(FOLLOW_functionArgumentList_in_global_func617);
                    functionArgumentList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_global_func620); 

            	 	if(!names.isExistFunction((ID21!=null?ID21.getText():null)))
            	 	{
            	 		names.addFunction(names.new FunctionName((ID21!=null?ID21.getText():null), (type20!=null?input.toString(type20.start,type20.stop):null), ((global_func_scope)global_func_stack.peek()).funcArgTypes, ((global_func_scope)global_func_stack.peek()).funcArgNames, (ID21!=null?ID21.getLine():0)));
            	 	}
            	 	else
            	 	{
            	 		errors.add("line "+(ID21!=null?ID21.getLine():0)+": Duplicated declaration function "+(ID21!=null?ID21.getText():null));
            	 	}
            	 
            match(input,23,FOLLOW_23_in_global_func632); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:334:6: ( body )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==ID||(LA17_0>=28 && LA17_0<=35)||(LA17_0>=37 && LA17_0<=40)||LA17_0==42) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:334:6: body
            	    {
            	    pushFollow(FOLLOW_body_in_global_func640);
            	    body();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:335:6: ( return_op )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==41) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:336:7: return_op
                    {
                    pushFollow(FOLLOW_return_op_in_global_func656);
                    return_op();

                    state._fsp--;


                    				  	boolean result = names.checkReturnType((ID21!=null?ID21.getText():null), ((global_func_scope)global_func_stack.peek()).returnVariable, ((program_scope)program_stack.peek()).curBlock, (ID21!=null?ID21.getLine():0));
                    				  	if(result==false)
                    				  	{
                    				  		errors.add(names.getLastError());
                    				  	}
                    			  	

                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_global_func677); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:348:1: functionArgumentList : functionArgumentDeclarator ( ',' functionArgumentDeclarator )* ;
    public final void functionArgumentList() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:349:2: ( functionArgumentDeclarator ( ',' functionArgumentDeclarator )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:349:4: functionArgumentDeclarator ( ',' functionArgumentDeclarator )*
            {
            pushFollow(FOLLOW_functionArgumentDeclarator_in_functionArgumentList691);
            functionArgumentDeclarator();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:349:31: ( ',' functionArgumentDeclarator )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==25) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:349:32: ',' functionArgumentDeclarator
            	    {
            	    match(input,25,FOLLOW_25_in_functionArgumentList694); 
            	    pushFollow(FOLLOW_functionArgumentDeclarator_in_functionArgumentList696);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:352:1: functionArgumentDeclarator : type ID ;
    public final void functionArgumentDeclarator() throws RecognitionException {
        Token ID23=null;
        StrLangParser.type_return type22 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:353:2: ( type ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:353:4: type ID
            {
            pushFollow(FOLLOW_type_in_functionArgumentDeclarator710);
            type22=type();

            state._fsp--;

            ID23=(Token)match(input,ID,FOLLOW_ID_in_functionArgumentDeclarator712); 

            		((global_func_scope)global_func_stack.peek()).funcArgTypes.add((type22!=null?input.toString(type22.start,type22.stop):null));
            		((global_func_scope)global_func_stack.peek()).funcArgNames.add((ID23!=null?ID23.getText():null));
            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID23!=null?ID23.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID23!=null?ID23.getText():null), (type22!=null?input.toString(type22.start,type22.stop):null), (ID23!=null?ID23.getLine():0)));
            		}
            		else
            		{
            			errors.add("line "+(ID23!=null?ID23.getLine():0)+": Duplicated variable name "+(ID23!=null?ID23.getText():null));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:368:1: param returns [ArrayList<String> argumentTypeList] : a= returnType ( ',' b= returnType )* ;
    public final ArrayList<String> param() throws RecognitionException {
        ArrayList<String> argumentTypeList = null;

        StrLangParser.returnType_return a = null;

        StrLangParser.returnType_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:369:2: (a= returnType ( ',' b= returnType )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:370:2: a= returnType ( ',' b= returnType )*
            {

            		argumentTypeList = new ArrayList<String>();
            	
            pushFollow(FOLLOW_returnType_in_param739);
            a=returnType();

            state._fsp--;

            argumentTypeList.add((a!=null?a.type:null));
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:373:48: ( ',' b= returnType )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==25) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:373:49: ',' b= returnType
            	    {
            	    match(input,25,FOLLOW_25_in_param744); 
            	    pushFollow(FOLLOW_returnType_in_param748);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:376:1: body : ( variables | func | if_op | for_op | while_op );
    public final void body() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:377:2: ( variables | func | if_op | for_op | while_op )
            int alt21=5;
            switch ( input.LA(1) ) {
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt21=1;
                }
                break;
            case ID:
                {
                int LA21_2 = input.LA(2);

                if ( (LA21_2==ASSIGN_OP) ) {
                    alt21=1;
                }
                else if ( (LA21_2==26) ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 2, input);

                    throw nvae;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:378:2: variables
                    {
                    pushFollow(FOLLOW_variables_in_body766);
                    variables();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:379:4: func
                    {
                    pushFollow(FOLLOW_func_in_body771);
                    func();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:380:4: if_op
                    {
                    pushFollow(FOLLOW_if_op_in_body776);
                    if_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:381:4: for_op
                    {
                    pushFollow(FOLLOW_for_op_in_body781);
                    for_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:382:4: while_op
                    {
                    pushFollow(FOLLOW_while_op_in_body786);
                    while_op();

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
    // $ANTLR end "body"


    // $ANTLR start "write_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:385:1: write_op : c= 'WriteToFile' '(' a= string_and_var ',' b= string_and_var ')' ;
    public final void write_op() throws RecognitionException {
        Token c=null;
        StrLangParser.string_and_var_return a = null;

        StrLangParser.string_and_var_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:386:2: (c= 'WriteToFile' '(' a= string_and_var ',' b= string_and_var ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:386:4: c= 'WriteToFile' '(' a= string_and_var ',' b= string_and_var ')'
            {
            c=(Token)match(input,32,FOLLOW_32_in_write_op800); 
            match(input,26,FOLLOW_26_in_write_op802); 
            pushFollow(FOLLOW_string_and_var_in_write_op807);
            a=string_and_var();

            state._fsp--;

            match(input,25,FOLLOW_25_in_write_op809); 
            pushFollow(FOLLOW_string_and_var_in_write_op814);
            b=string_and_var();

            state._fsp--;

            match(input,27,FOLLOW_27_in_write_op817); 

            		String s_type = "string";
            		if(!TypesChecker.checkTypes((a!=null?a.type:null), s_type))
            		{
            			errors.add("line "+(c!=null?c.getLine():0)+": incorrect first argument type for function WriteToFile. Need type string, found "+(a!=null?a.type:null));
            		}
            		if(!TypesChecker.checkTypes((b!=null?b.type:null), s_type))
            		{
            			errors.add("line "+(c!=null?c.getLine():0)+": incorrect second argument type for function WriteToFile. Need type string, found "+(b!=null?b.type:null));
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
    // $ANTLR end "write_op"


    // $ANTLR start "read_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:400:1: read_op returns [int line] : c= 'ReadFile' '(' a= string_and_var ')' ;
    public final int read_op() throws RecognitionException {
        int line = 0;

        Token c=null;
        StrLangParser.string_and_var_return a = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:401:2: (c= 'ReadFile' '(' a= string_and_var ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:401:4: c= 'ReadFile' '(' a= string_and_var ')'
            {
            c=(Token)match(input,33,FOLLOW_33_in_read_op836); 
            match(input,26,FOLLOW_26_in_read_op838); 
            pushFollow(FOLLOW_string_and_var_in_read_op842);
            a=string_and_var();

            state._fsp--;

            match(input,27,FOLLOW_27_in_read_op844); 
            line = (c!=null?c.getLine():0);

            		String s_type = "string";
            		if(!TypesChecker.checkTypes((a!=null?a.type:null), s_type))
            		{
            			errors.add("line "+(c!=null?c.getLine():0)+": incorrect argument type for function ReadFile. Need type string, found "+(a!=null?a.type:null));
            		}
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return line;
    }
    // $ANTLR end "read_op"


    // $ANTLR start "while_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:411:1: while_op : 'while' '(' logic ')' '{' ( body )* '}' ;
    public final void while_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:412:2: ( 'while' '(' logic ')' '{' ( body )* '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:412:4: 'while' '(' logic ')' '{' ( body )* '}'
            {
            match(input,34,FOLLOW_34_in_while_op860); 
            match(input,26,FOLLOW_26_in_while_op862); 
            pushFollow(FOLLOW_logic_in_while_op864);
            logic();

            state._fsp--;

            match(input,27,FOLLOW_27_in_while_op866); 
            match(input,23,FOLLOW_23_in_while_op868); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:412:30: ( body )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==ID||(LA22_0>=28 && LA22_0<=35)||(LA22_0>=37 && LA22_0<=40)||LA22_0==42) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:412:30: body
            	    {
            	    pushFollow(FOLLOW_body_in_while_op870);
            	    body();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_while_op873); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:414:1: for_op : 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )* '}' ;
    public final void for_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:2: ( 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )* '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:4: 'for' '(' ( variables )? ';' ( logic )? ';' ( action )? ')' '{' ( body )* '}'
            {
            match(input,35,FOLLOW_35_in_for_op887); 
            match(input,26,FOLLOW_26_in_for_op889); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:14: ( variables )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID||(LA23_0>=28 && LA23_0<=31)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:14: variables
                    {
                    pushFollow(FOLLOW_variables_in_for_op891);
                    variables();

                    state._fsp--;


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_for_op894); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:29: ( logic )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID||(LA24_0>=INT && LA24_0<=SYMBOL)||LA24_0==END_LINE||LA24_0==26||LA24_0==33||(LA24_0>=38 && LA24_0<=39)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:29: logic
                    {
                    pushFollow(FOLLOW_logic_in_for_op896);
                    logic();

                    state._fsp--;


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_for_op899); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:40: ( action )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ID||(LA25_0>=INT && LA25_0<=SYMBOL)||LA25_0==33||(LA25_0>=38 && LA25_0<=39)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:40: action
                    {
                    pushFollow(FOLLOW_action_in_for_op901);
                    action();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_for_op904); 
            match(input,23,FOLLOW_23_in_for_op906); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:56: ( body )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==ID||(LA26_0>=28 && LA26_0<=35)||(LA26_0>=37 && LA26_0<=40)||LA26_0==42) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:56: body
            	    {
            	    pushFollow(FOLLOW_body_in_for_op908);
            	    body();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_for_op911); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:418:1: print_op : 'print' '(' a= returnType ( ',' b= returnType )* ')' ;
    public final void print_op() throws RecognitionException {
        StrLangParser.returnType_return a = null;

        StrLangParser.returnType_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:419:2: ( 'print' '(' a= returnType ( ',' b= returnType )* ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:419:4: 'print' '(' a= returnType ( ',' b= returnType )* ')'
            {
            match(input,37,FOLLOW_37_in_print_op922); 
            match(input,26,FOLLOW_26_in_print_op924); 
            pushFollow(FOLLOW_returnType_in_print_op928);
            a=returnType();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:419:29: ( ',' b= returnType )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==25) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:419:30: ',' b= returnType
            	    {
            	    match(input,25,FOLLOW_25_in_print_op931); 
            	    pushFollow(FOLLOW_returnType_in_print_op935);
            	    b=returnType();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            match(input,27,FOLLOW_27_in_print_op940); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:422:1: length returns [int line] : c= 'length' '(' a= string_and_var ')' ;
    public final int length() throws RecognitionException {
        int line = 0;

        Token c=null;
        StrLangParser.string_and_var_return a = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:423:2: (c= 'length' '(' a= string_and_var ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:423:4: c= 'length' '(' a= string_and_var ')'
            {
            c=(Token)match(input,38,FOLLOW_38_in_length957); 
            match(input,26,FOLLOW_26_in_length959); 
            pushFollow(FOLLOW_string_and_var_in_length963);
            a=string_and_var();

            state._fsp--;

            match(input,27,FOLLOW_27_in_length965); 
            line = (c!=null?c.getLine():0);

            		String s_type = "string";
            		if(!TypesChecker.checkTypes((a!=null?a.type:null), s_type))
            		{
            			errors.add("line "+(c!=null?c.getLine():0)+": incorrect argument type for function length. Need type string, found "+(a!=null?a.type:null));
            		}
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return line;
    }
    // $ANTLR end "length"


    // $ANTLR start "elem"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:433:1: elem returns [int line] : a= 'elem' '(' returnType ',' returnType ')' ;
    public final int elem() throws RecognitionException {
        int line = 0;

        Token a=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:434:2: (a= 'elem' '(' returnType ',' returnType ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:434:3: a= 'elem' '(' returnType ',' returnType ')'
            {
            a=(Token)match(input,39,FOLLOW_39_in_elem986); 
            match(input,26,FOLLOW_26_in_elem988); 
            pushFollow(FOLLOW_returnType_in_elem990);
            returnType();

            state._fsp--;

            match(input,25,FOLLOW_25_in_elem992); 
            pushFollow(FOLLOW_returnType_in_elem994);
            returnType();

            state._fsp--;

            match(input,27,FOLLOW_27_in_elem996); 
            line = (a!=null?a.getLine():0);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return line;
    }
    // $ANTLR end "elem"


    // $ANTLR start "break_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:437:1: break_op : 'break' ;
    public final void break_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:438:2: ( 'break' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:438:4: 'break'
            {
            match(input,40,FOLLOW_40_in_break_op1010); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:442:1: return_op : 'return' returnType ;
    public final void return_op() throws RecognitionException {
        StrLangParser.returnType_return returnType24 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:443:3: ( 'return' returnType )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:443:5: 'return' returnType
            {
            match(input,41,FOLLOW_41_in_return_op1025); 
            pushFollow(FOLLOW_returnType_in_return_op1027);
            returnType24=returnType();

            state._fsp--;


             		((global_func_scope)global_func_stack.peek()).returnVariable = (returnType24!=null?returnType24.value:null);
             	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:449:1: if_op : 'if' '(' logic ')' '{' ( body )* '}' ( 'else' '{' ( body )* '}' )? ;
    public final void if_op() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:450:2: ( 'if' '(' logic ')' '{' ( body )* '}' ( 'else' '{' ( body )* '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:450:4: 'if' '(' logic ')' '{' ( body )* '}' ( 'else' '{' ( body )* '}' )?
            {
            match(input,42,FOLLOW_42_in_if_op1043); 
            match(input,26,FOLLOW_26_in_if_op1045); 
            pushFollow(FOLLOW_logic_in_if_op1047);
            logic();

            state._fsp--;

            match(input,27,FOLLOW_27_in_if_op1049); 
            match(input,23,FOLLOW_23_in_if_op1051); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:450:27: ( body )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==ID||(LA28_0>=28 && LA28_0<=35)||(LA28_0>=37 && LA28_0<=40)||LA28_0==42) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:450:27: body
            	    {
            	    pushFollow(FOLLOW_body_in_if_op1053);
            	    body();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_if_op1056); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:450:37: ( 'else' '{' ( body )* '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==43) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:450:38: 'else' '{' ( body )* '}'
                    {
                    match(input,43,FOLLOW_43_in_if_op1059); 
                    match(input,23,FOLLOW_23_in_if_op1061); 
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:450:49: ( body )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==ID||(LA29_0>=28 && LA29_0<=35)||(LA29_0>=37 && LA29_0<=40)||LA29_0==42) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:450:49: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_if_op1063);
                    	    body();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_if_op1066); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:453:1: expr : ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY );
    public final void expr() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:454:2: ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY )
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


    // $ANTLR start "prefix"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:462:1: prefix : ( DOUBLE_MINUS | DOUBLE_PLUS );
    public final void prefix() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:463:2: ( DOUBLE_MINUS | DOUBLE_PLUS )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:
            {
            if ( (input.LA(1)>=DOUBLE_MINUS && input.LA(1)<=DOUBLE_PLUS) ) {
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
    // $ANTLR end "prefix"


    // $ANTLR start "logic"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:467:1: logic : logic_and ;
    public final void logic() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:468:2: ( logic_and )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:468:4: logic_and
            {
            pushFollow(FOLLOW_logic_and_in_logic1133);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:471:1: logic_and : logic_or ( 'and' logic_or )* ;
    public final void logic_and() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:2: ( logic_or ( 'and' logic_or )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:4: logic_or ( 'and' logic_or )*
            {
            pushFollow(FOLLOW_logic_or_in_logic_and1146);
            logic_or();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:13: ( 'and' logic_or )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==44) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:14: 'and' logic_or
            	    {
            	    match(input,44,FOLLOW_44_in_logic_and1149); 
            	    pushFollow(FOLLOW_logic_or_in_logic_and1151);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:474:1: logic_or : logic_expr ( 'or' logic_expr )* ;
    public final void logic_or() throws RecognitionException {
        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:475:2: ( logic_expr ( 'or' logic_expr )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:475:4: logic_expr ( 'or' logic_expr )*
            {
            pushFollow(FOLLOW_logic_expr_in_logic_or1164);
            logic_expr();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:475:15: ( 'or' logic_expr )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==45) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:475:16: 'or' logic_expr
            	    {
            	    match(input,45,FOLLOW_45_in_logic_or1167); 
            	    pushFollow(FOLLOW_logic_expr_in_logic_or1169);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:479:1: logic_expr : (a= logic_atom expr b= logic_atom | '(' logic ')' );
    public final void logic_expr() throws RecognitionException {
        StrLangParser.logic_atom_return a = null;

        StrLangParser.logic_atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:480:2: (a= logic_atom expr b= logic_atom | '(' logic ')' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==ID||(LA33_0>=INT && LA33_0<=SYMBOL)||LA33_0==END_LINE||LA33_0==33||(LA33_0>=38 && LA33_0<=39)) ) {
                alt33=1;
            }
            else if ( (LA33_0==26) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:480:4: a= logic_atom expr b= logic_atom
                    {
                    pushFollow(FOLLOW_logic_atom_in_logic_expr1185);
                    a=logic_atom();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_logic_expr1187);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_logic_atom_in_logic_expr1191);
                    b=logic_atom();

                    state._fsp--;


                    		if(!TypesChecker.checkTypes((a!=null?a.type:null),(b!=null?b.type:null)))
                    		{
                    			errors.add("line "+(a!=null?a.curLine:0)+": incomparable types: "+(a!=null?a.type:null)+" and "+(b!=null?b.type:null));
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:487:4: '(' logic ')'
                    {
                    match(input,26,FOLLOW_26_in_logic_expr1201); 
                    pushFollow(FOLLOW_logic_in_logic_expr1203);
                    logic();

                    state._fsp--;

                    match(input,27,FOLLOW_27_in_logic_expr1205); 

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

    public static class logic_atom_return extends ParserRuleReturnScope {
        public String type;
        public int curLine;
    };

    // $ANTLR start "logic_atom"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:490:1: logic_atom returns [String type, int curLine] : ( spec_type | END_LINE );
    public final StrLangParser.logic_atom_return logic_atom() throws RecognitionException {
        StrLangParser.logic_atom_return retval = new StrLangParser.logic_atom_return();
        retval.start = input.LT(1);

        Token END_LINE26=null;
        StrLangParser.spec_type_return spec_type25 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:491:2: ( spec_type | END_LINE )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ID||(LA34_0>=INT && LA34_0<=SYMBOL)||LA34_0==33||(LA34_0>=38 && LA34_0<=39)) ) {
                alt34=1;
            }
            else if ( (LA34_0==END_LINE) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:491:4: spec_type
                    {
                    pushFollow(FOLLOW_spec_type_in_logic_atom1219);
                    spec_type25=spec_type();

                    state._fsp--;

                    retval.type = (spec_type25!=null?spec_type25.value:null); retval.curLine = (spec_type25!=null?spec_type25.curLine:0);

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:492:4: END_LINE
                    {
                    END_LINE26=(Token)match(input,END_LINE,FOLLOW_END_LINE_in_logic_atom1226); 
                    retval.type = "char"; retval.curLine = (END_LINE26!=null?END_LINE26.getLine():0); 

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
    // $ANTLR end "logic_atom"

    public static class string_and_var_return extends ParserRuleReturnScope {
        public String value;
        public String type;
    };

    // $ANTLR start "string_and_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:495:1: string_and_var returns [String value, String type] : ( idLiteral | LINE );
    public final StrLangParser.string_and_var_return string_and_var() throws RecognitionException {
        StrLangParser.string_and_var_return retval = new StrLangParser.string_and_var_return();
        retval.start = input.LT(1);

        Token LINE28=null;
        StrLangParser.idLiteral_return idLiteral27 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:496:2: ( idLiteral | LINE )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ID) ) {
                alt35=1;
            }
            else if ( (LA35_0==LINE) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:496:4: idLiteral
                    {
                    pushFollow(FOLLOW_idLiteral_in_string_and_var1243);
                    idLiteral27=idLiteral();

                    state._fsp--;

                    retval.value = (idLiteral27!=null?idLiteral27.text:null); retval.type = (idLiteral27!=null?idLiteral27.idType:null);

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:497:4: LINE
                    {
                    LINE28=(Token)match(input,LINE,FOLLOW_LINE_in_string_and_var1250); 
                    retval.value = (LINE28!=null?LINE28.getText():null); retval.type = "string";

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
    // $ANTLR end "string_and_var"

    // Delegated rules


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\50\uffff";
    static final String DFA13_eofS =
        "\50\uffff";
    static final String DFA13_minS =
        "\1\4\4\5\3\32\2\uffff\4\4\4\31\1\5\4\31\4\33\2\4\2\5\4\31\4\33"+
        "\1\5";
    static final String DFA13_maxS =
        "\1\47\3\22\4\32\2\uffff\1\33\1\12\2\11\4\33\1\22\4\31\4\33\2\12"+
        "\2\22\10\33\1\22";
    static final String DFA13_acceptS =
        "\10\uffff\1\1\1\2\36\uffff";
    static final String DFA13_specialS =
        "\50\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\4\3\uffff\1\1\1\2\1\3\26\uffff\1\7\4\uffff\1\6\1\5",
            "\1\11\13\uffff\2\10",
            "\1\11\13\uffff\2\10",
            "\1\11\13\uffff\2\10",
            "\1\11\13\uffff\2\10\7\uffff\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "",
            "",
            "\1\21\3\uffff\1\16\1\17\1\20\20\uffff\1\22",
            "\1\26\3\uffff\1\23\1\24\1\25",
            "\1\27\4\uffff\1\30",
            "\1\31\4\uffff\1\32",
            "\1\33\1\uffff\1\22",
            "\1\33\1\uffff\1\22",
            "\1\33\1\uffff\1\22",
            "\1\33\1\uffff\1\22",
            "\1\11\13\uffff\2\10",
            "\1\34",
            "\1\34",
            "\1\34",
            "\1\34",
            "\1\35",
            "\1\35",
            "\1\36",
            "\1\36",
            "\1\42\3\uffff\1\37\1\40\1\41",
            "\1\46\3\uffff\1\43\1\44\1\45",
            "\1\11\13\uffff\2\10",
            "\1\11\13\uffff\2\10",
            "\1\33\1\uffff\1\22",
            "\1\33\1\uffff\1\22",
            "\1\33\1\uffff\1\22",
            "\1\33\1\uffff\1\22",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\11\13\uffff\2\10"
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "223:1: action : (a= spec_type prefix | b= spec_type ASSIGN_OP c= spec_type ( PLUS_OP | MINUS_OP ) d= spec_type );";
        }
    }
 

    public static final BitSet FOLLOW_global_decl_in_program50 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_mainBlock_in_program55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_mainBlock68 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_mainBlock70 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_body_in_mainBlock72 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_24_in_mainBlock75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_var_in_global_decl90 = new BitSet(new long[]{0x00000000F0000012L});
    public static final BitSet FOLLOW_global_func_in_global_decl94 = new BitSet(new long[]{0x00000000F0000012L});
    public static final BitSet FOLLOW_variables_in_global_var110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_func121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_func126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_var_in_variables143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_var_in_variables147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_var159 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarators_in_decl_var165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators177 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_variableDeclarators180 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators182 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ID_in_variableDeclarator203 = new BitSet(new long[]{0x00000000000000E2L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_variableDeclarator215 = new BitSet(new long[]{0x000001E300000710L});
    public static final BitSet FOLLOW_spec_type_in_variableDeclarator219 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_variableDeclarator231 = new BitSet(new long[]{0x000001E300000710L});
    public static final BitSet FOLLOW_spec_type_in_variableDeclarator239 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_ID_in_init_var261 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_init_var263 = new BitSet(new long[]{0x000001E300000710L});
    public static final BitSet FOLLOW_spec_type_in_init_var267 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_init_var277 = new BitSet(new long[]{0x000001E300000710L});
    public static final BitSet FOLLOW_spec_type_in_init_var285 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_elem_in_inside_func306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_inside_func311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_op_in_inside_func316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_op_in_inside_func323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_inside_func328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_op_in_inside_func334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elem_in_assign_inside_func349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_assign_inside_func356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_assign_inside_func363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func387 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_call_func391 = new BitSet(new long[]{0x0000000008000710L});
    public static final BitSet FOLLOW_param_in_call_func393 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_call_func396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action414 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_prefix_in_action416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action426 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_action428 = new BitSet(new long[]{0x000001E300000710L});
    public static final BitSet FOLLOW_spec_type_in_action432 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_action434 = new BitSet(new long[]{0x000001E300000710L});
    public static final BitSet FOLLOW_spec_type_in_action442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_spec_type465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_spec_type472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_spec_type479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idLiteral_in_spec_type486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_inside_func_in_spec_type493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_spec_type500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_returnType517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_returnType524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_returnType531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idLiteral_in_returnType538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_idLiteral555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_func606 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_func610 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_global_func615 = new BitSet(new long[]{0x00000000F8000000L});
    public static final BitSet FOLLOW_functionArgumentList_in_global_func617 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_global_func620 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_global_func632 = new BitSet(new long[]{0x000007EFF1000010L});
    public static final BitSet FOLLOW_body_in_global_func640 = new BitSet(new long[]{0x000007EFF1000010L});
    public static final BitSet FOLLOW_return_op_in_global_func656 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_global_func677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionArgumentDeclarator_in_functionArgumentList691 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_functionArgumentList694 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_functionArgumentDeclarator_in_functionArgumentList696 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_type_in_functionArgumentDeclarator710 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functionArgumentDeclarator712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnType_in_param739 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_param744 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_param748 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_variables_in_body766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_in_body771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_op_in_body776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_op_in_body781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_op_in_body786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_write_op800 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_write_op802 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_string_and_var_in_write_op807 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_write_op809 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_string_and_var_in_write_op814 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_write_op817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_read_op836 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_read_op838 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_string_and_var_in_read_op842 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_read_op844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_while_op860 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_while_op862 = new BitSet(new long[]{0x000001E304080710L});
    public static final BitSet FOLLOW_logic_in_while_op864 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_while_op866 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_while_op868 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_body_in_while_op870 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_24_in_while_op873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_for_op887 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_for_op889 = new BitSet(new long[]{0x00000010F0000010L});
    public static final BitSet FOLLOW_variables_in_for_op891 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_for_op894 = new BitSet(new long[]{0x000001F304080710L});
    public static final BitSet FOLLOW_logic_in_for_op896 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_for_op899 = new BitSet(new long[]{0x000001E308000710L});
    public static final BitSet FOLLOW_action_in_for_op901 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_for_op904 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_for_op906 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_body_in_for_op908 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_24_in_for_op911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_print_op922 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_print_op924 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_print_op928 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_25_in_print_op931 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_print_op935 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_27_in_print_op940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_length957 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_length959 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_string_and_var_in_length963 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_length965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_elem986 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_elem988 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_elem990 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elem992 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_elem994 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_elem996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_break_op1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_op1025 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_return_op1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_if_op1043 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_if_op1045 = new BitSet(new long[]{0x000001E304080710L});
    public static final BitSet FOLLOW_logic_in_if_op1047 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op1049 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_if_op1051 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_body_in_if_op1053 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_24_in_if_op1056 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_if_op1059 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_if_op1061 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_body_in_if_op1063 = new BitSet(new long[]{0x000005EFF1000010L});
    public static final BitSet FOLLOW_24_in_if_op1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expr0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_prefix0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_and_in_logic1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_or_in_logic_and1146 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_logic_and1149 = new BitSet(new long[]{0x000001E304080710L});
    public static final BitSet FOLLOW_logic_or_in_logic_and1151 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or1164 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_logic_or1167 = new BitSet(new long[]{0x000001E304080710L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or1169 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr1185 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_expr_in_logic_expr1187 = new BitSet(new long[]{0x000001E300080710L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_logic_expr1201 = new BitSet(new long[]{0x000001E304080710L});
    public static final BitSet FOLLOW_logic_in_logic_expr1203 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_logic_expr1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_logic_atom1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_LINE_in_logic_atom1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idLiteral_in_string_and_var1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_string_and_var1250 = new BitSet(new long[]{0x0000000000000002L});

}