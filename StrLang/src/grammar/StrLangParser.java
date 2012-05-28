// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g 2012-05-28 21:07:37

	package grammar;
	import java.io.*;
	import namestable.*;
	import org.antlr.stringtemplate.StringTemplateGroup;
	import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class StrLangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "ASSIGN_OP", "PLUS_OP", "MINUS_OP", "INT", "LINE", "SYMBOL", "END_LINE", "EQUALLY_EQL_OP", "MORE_EQL_OP", "LESS_EQL_OP", "MORE_OP", "LESS_OP", "NO_EQUALLY", "DOUBLE_MINUS", "DOUBLE_PLUS", "COMMENT", "WS", "'main'", "'{'", "'}'", "','", "'('", "')'", "'string'", "'int'", "'char'", "'void'", "'WriteToFile'", "'ReadFile'", "'while'", "'for'", "';'", "'print'", "'length'", "'elem'", "'break'", "'return'", "'ToString'", "'if'", "'else'", "'and'", "'or'"
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
    public static final int T__46=46;
    public static final int ID=4;
    public static final int ASSIGN_OP=5;
    public static final int PLUS_OP=6;
    public static final int MINUS_OP=7;
    public static final int INT=8;
    public static final int LINE=9;
    public static final int SYMBOL=10;
    public static final int END_LINE=11;
    public static final int EQUALLY_EQL_OP=12;
    public static final int MORE_EQL_OP=13;
    public static final int LESS_EQL_OP=14;
    public static final int MORE_OP=15;
    public static final int LESS_OP=16;
    public static final int NO_EQUALLY=17;
    public static final int DOUBLE_MINUS=18;
    public static final int DOUBLE_PLUS=19;
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
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("StrLangParserTemplates", AngleBracketTemplateLexer.class);

    public void setTemplateLib(StringTemplateGroup templateLib) {
      this.templateLib = templateLib;
    }
    public StringTemplateGroup getTemplateLib() {
      return templateLib;
    }
    /** allows convenient multi-value initialization:
     *  "new STAttrMap().put(...).put(...)"
     */
    public static class STAttrMap extends HashMap {
      public STAttrMap put(String attrName, Object value) {
        super.put(attrName, value);
        return this;
      }
      public STAttrMap put(String attrName, int value) {
        super.put(attrName, new Integer(value));
        return this;
      }
    }

    public String[] getTokenNames() { return StrLangParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g"; }


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


    protected static class program_scope {
        String curBlock;
    }
    protected Stack program_stack = new Stack();

    public static class program_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "program"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:89:1: program : ( global_decl )? mainBlock ;
    public final StrLangParser.program_return program() throws RecognitionException {
        program_stack.push(new program_scope());
        StrLangParser.program_return retval = new StrLangParser.program_return();
        retval.start = input.LT(1);


        	((program_scope)program_stack.peek()).curBlock = "";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:96:2: ( ( global_decl )? mainBlock )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:96:4: ( global_decl )? mainBlock
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:96:4: ( global_decl )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID||(LA1_0>=28 && LA1_0<=31)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:96:4: global_decl
                    {
                    pushFollow(FOLLOW_global_decl_in_program59);
                    global_decl();

                    state._fsp--;


                    }
                    break;

            }

            ((program_scope)program_stack.peek()).curBlock ="main";
            pushFollow(FOLLOW_mainBlock_in_program64);
            mainBlock();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            program_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class mainBlock_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "mainBlock"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:100:1: mainBlock : 'main' '{' body '}' ;
    public final StrLangParser.mainBlock_return mainBlock() throws RecognitionException {
        StrLangParser.mainBlock_return retval = new StrLangParser.mainBlock_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:100:10: ( 'main' '{' body '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:101:3: 'main' '{' body '}'
            {
            match(input,22,FOLLOW_22_in_mainBlock79); 
            match(input,23,FOLLOW_23_in_mainBlock81); 
            pushFollow(FOLLOW_body_in_mainBlock83);
            body();

            state._fsp--;

            match(input,24,FOLLOW_24_in_mainBlock85); 

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
    // $ANTLR end "mainBlock"

    public static class global_decl_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "global_decl"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:105:1: global_decl : ( global_var | global_func )+ ;
    public final StrLangParser.global_decl_return global_decl() throws RecognitionException {
        StrLangParser.global_decl_return retval = new StrLangParser.global_decl_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:106:2: ( ( global_var | global_func )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:107:2: ( global_var | global_func )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:107:2: ( global_var | global_func )+
            int cnt2=0;
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=28 && LA2_0<=31)) ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2==ID) ) {
                        int LA2_4 = input.LA(3);

                        if ( ((LA2_4>=ID && LA2_4<=MINUS_OP)||LA2_4==22||LA2_4==25||(LA2_4>=28 && LA2_4<=31)) ) {
                            alt2=1;
                        }
                        else if ( (LA2_4==26) ) {
                            alt2=2;
                        }


                    }


                }
                else if ( (LA2_0==ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:107:3: global_var
            	    {
            	    pushFollow(FOLLOW_global_var_in_global_decl104);
            	    global_var();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:107:16: global_func
            	    {
            	    pushFollow(FOLLOW_global_func_in_global_decl108);
            	    global_func();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


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
    // $ANTLR end "global_decl"

    public static class global_var_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "global_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:110:1: global_var : variables ;
    public final StrLangParser.global_var_return global_var() throws RecognitionException {
        StrLangParser.global_var_return retval = new StrLangParser.global_var_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:111:2: ( variables )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:111:4: variables
            {
             ((program_scope)program_stack.peek()).curBlock = "global";
            pushFollow(FOLLOW_variables_in_global_var124);
            variables();

            state._fsp--;


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
    // $ANTLR end "global_var"

    public static class func_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:114:1: func : ( inside_func | call_func );
    public final StrLangParser.func_return func() throws RecognitionException {
        StrLangParser.func_return retval = new StrLangParser.func_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:115:2: ( inside_func | call_func )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=32 && LA3_0<=33)||(LA3_0>=37 && LA3_0<=40)||LA3_0==42) ) {
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:115:4: inside_func
                    {
                    pushFollow(FOLLOW_inside_func_in_func135);
                    inside_func();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:116:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_func140);
                    call_func();

                    state._fsp--;


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
    // $ANTLR end "func"

    public static class body_return extends ParserRuleReturnScope {
        public ArrayList<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "body"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:119:1: body returns [ArrayList<StringTemplate> stList] : ( stmt )* ;
    public final StrLangParser.body_return body() throws RecognitionException {
        StrLangParser.body_return retval = new StrLangParser.body_return();
        retval.start = input.LT(1);

        StrLangParser.stmt_return stmt1 = null;



        	retval.stList = new ArrayList<StringTemplate>(); 

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:124:2: ( ( stmt )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:124:4: ( stmt )*
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:124:4: ( stmt )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ID||(LA4_0>=28 && LA4_0<=35)||(LA4_0>=37 && LA4_0<=40)||(LA4_0>=42 && LA4_0<=43)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:124:5: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_body161);
            	    stmt1=stmt();

            	    state._fsp--;

            	     retval.stList.add((stmt1!=null?stmt1.st:null)); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


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
    // $ANTLR end "body"

    public static class stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:127:1: stmt : ( variables | func | if_op | for_op | while_op );
    public final StrLangParser.stmt_return stmt() throws RecognitionException {
        StrLangParser.stmt_return retval = new StrLangParser.stmt_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:127:5: ( variables | func | if_op | for_op | while_op )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt5=1;
                }
                break;
            case ID:
                {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==ASSIGN_OP) ) {
                    alt5=1;
                }
                else if ( (LA5_2==26) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

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
            case 42:
                {
                alt5=2;
                }
                break;
            case 43:
                {
                alt5=3;
                }
                break;
            case 35:
                {
                alt5=4;
                }
                break;
            case 34:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:128:2: variables
                    {
                    pushFollow(FOLLOW_variables_in_stmt176);
                    variables();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:129:4: func
                    {
                    pushFollow(FOLLOW_func_in_stmt182);
                    func();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:130:4: if_op
                    {
                    pushFollow(FOLLOW_if_op_in_stmt187);
                    if_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:131:4: for_op
                    {
                    pushFollow(FOLLOW_for_op_in_stmt193);
                    for_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:132:4: while_op
                    {
                    pushFollow(FOLLOW_while_op_in_stmt198);
                    while_op();

                    state._fsp--;


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
    // $ANTLR end "stmt"

    protected static class variables_scope {
        String varType;
    }
    protected Stack variables_stack = new Stack();

    public static class variables_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "variables"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:135:1: variables : ( decl_var | init_var );
    public final StrLangParser.variables_return variables() throws RecognitionException {
        variables_stack.push(new variables_scope());
        StrLangParser.variables_return retval = new StrLangParser.variables_return();
        retval.start = input.LT(1);


        	((variables_scope)variables_stack.peek()).varType = "";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:142:2: ( decl_var | init_var )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=28 && LA6_0<=31)) ) {
                alt6=1;
            }
            else if ( (LA6_0==ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:142:3: decl_var
                    {
                    pushFollow(FOLLOW_decl_var_in_variables216);
                    decl_var();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:143:3: init_var
                    {
                    pushFollow(FOLLOW_init_var_in_variables221);
                    init_var();

                    state._fsp--;


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
            variables_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "variables"

    public static class decl_var_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "decl_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:146:1: decl_var : type variableDeclarators ;
    public final StrLangParser.decl_var_return decl_var() throws RecognitionException {
        StrLangParser.decl_var_return retval = new StrLangParser.decl_var_return();
        retval.start = input.LT(1);

        StrLangParser.type_return type2 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:147:2: ( type variableDeclarators )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:147:4: type variableDeclarators
            {
            pushFollow(FOLLOW_type_in_decl_var234);
            type2=type();

            state._fsp--;


            		((variables_scope)variables_stack.peek()).varType = (type2!=null?input.toString(type2.start,type2.stop):null);
            	
            pushFollow(FOLLOW_variableDeclarators_in_decl_var240);
            variableDeclarators();

            state._fsp--;


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
    // $ANTLR end "decl_var"

    public static class variableDeclarators_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "variableDeclarators"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:154:1: variableDeclarators : variableDeclarator ( ',' variableDeclarator )* ;
    public final StrLangParser.variableDeclarators_return variableDeclarators() throws RecognitionException {
        StrLangParser.variableDeclarators_return retval = new StrLangParser.variableDeclarators_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:155:2: ( variableDeclarator ( ',' variableDeclarator )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:155:4: variableDeclarator ( ',' variableDeclarator )*
            {
            pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators253);
            variableDeclarator();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:155:23: ( ',' variableDeclarator )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:155:24: ',' variableDeclarator
            	    {
            	    match(input,25,FOLLOW_25_in_variableDeclarators256); 
            	    pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators258);
            	    variableDeclarator();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


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
    // $ANTLR end "variableDeclarators"

    protected static class variableDeclarator_scope {
        ArrayList<String> varList;
    }
    protected Stack variableDeclarator_stack = new Stack();

    public static class variableDeclarator_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "variableDeclarator"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:158:1: variableDeclarator : ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* ;
    public final StrLangParser.variableDeclarator_return variableDeclarator() throws RecognitionException {
        variableDeclarator_stack.push(new variableDeclarator_scope());
        StrLangParser.variableDeclarator_return retval = new StrLangParser.variableDeclarator_return();
        retval.start = input.LT(1);

        Token ID3=null;
        StrLangParser.spec_type_return firstAssign = null;

        StrLangParser.spec_type_return secondAssign = null;



        	((variableDeclarator_scope)variableDeclarator_stack.peek()).varList = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:165:2: ( ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:165:4: ID ( ASSIGN_OP firstAssign= spec_type )? ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            {
            ID3=(Token)match(input,ID,FOLLOW_ID_in_variableDeclarator279); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID3!=null?ID3.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID3!=null?ID3.getText():null), ((variables_scope)variables_stack.peek()).varType, (ID3!=null?ID3.getLine():0)));
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID3!=null?ID3.getText():null)))
            				errors.add("line "+(ID3!=null?ID3.getLine():0)+": Duplicated variable name "+(ID3!=null?ID3.getText():null));
            			else
            			{
            				int variableNumber;
            				if(TypesChecker.isInteger(((variables_scope)variables_stack.peek()).varType)){
            					retval.st = templateLib.getInstanceOf("declaration_int",
              new STAttrMap().put("variableNumber", (ID3!=null?ID3.getText():null)));
            				}
            				if(TypesChecker.isString(((variables_scope)variables_stack.peek()).varType)){
            					retval.st = templateLib.getInstanceOf("declaration_string",
              new STAttrMap().put("variableNumber", (ID3!=null?ID3.getText():null)));
            				}
            				if(TypesChecker.isChar(((variables_scope)variables_stack.peek()).varType)){
            					retval.st = templateLib.getInstanceOf("declaration_char",
              new STAttrMap().put("variableNumber", (ID3!=null?ID3.getText():null)));
            				}
            			}
            		}
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:191:2: ( ASSIGN_OP firstAssign= spec_type )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ASSIGN_OP) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:192:3: ASSIGN_OP firstAssign= spec_type
                    {
                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_variableDeclarator291); 
                    pushFollow(FOLLOW_spec_type_in_variableDeclarator295);
                    firstAssign=spec_type();

                    state._fsp--;


                    			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, (firstAssign!=null?firstAssign.value:null)))
                    			{
                    				errors.add("line "+(ID3!=null?ID3.getLine():0)+": Type mismatch: cannot convert from "+((variables_scope)variables_stack.peek()).varType+" to "+(firstAssign!=null?firstAssign.value:null));
                    			}
                    		

                    }
                    break;

            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:200:2: ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=PLUS_OP && LA9_0<=MINUS_OP)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:200:3: ( PLUS_OP | MINUS_OP ) secondAssign= spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_variableDeclarator315);
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

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            variableDeclarator_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "variableDeclarator"

    public static class init_var_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "init_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:211:1: init_var : ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* ;
    public final StrLangParser.init_var_return init_var() throws RecognitionException {
        StrLangParser.init_var_return retval = new StrLangParser.init_var_return();
        retval.start = input.LT(1);

        Token ID4=null;
        StrLangParser.spec_type_return firstAssign = null;

        StrLangParser.spec_type_return secondAssign = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:212:2: ( ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:212:4: ID ASSIGN_OP firstAssign= spec_type ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            {
            ID4=(Token)match(input,ID,FOLLOW_ID_in_init_var337); 
            match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_init_var339); 
            pushFollow(FOLLOW_spec_type_in_init_var343);
            firstAssign=spec_type();

            state._fsp--;


            		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID4!=null?ID4.getText():null)))
            		{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID4!=null?ID4.getText():null));
            			((variables_scope)variables_stack.peek()).varType = var_type.getType();
            			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, (firstAssign!=null?firstAssign.value:null)))
            			{
            				errors.add("line "+(ID4!=null?ID4.getLine():0)+": Type mismatch: cannot convert from "+((variables_scope)variables_stack.peek()).varType+" to "+(firstAssign!=null?firstAssign.value:null));
            			}
            		}
            		else
            		{
            			errors.add("line "+(ID4!=null?ID4.getLine():0)+": "+(ID4!=null?ID4.getText():null)+" cannot be resolved to a variable");
            		}
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:228:2: ( ( PLUS_OP | MINUS_OP ) secondAssign= spec_type )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=PLUS_OP && LA10_0<=MINUS_OP)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:229:3: ( PLUS_OP | MINUS_OP ) secondAssign= spec_type
            	    {
            	    if ( (input.LA(1)>=PLUS_OP && input.LA(1)<=MINUS_OP) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_spec_type_in_init_var361);
            	    secondAssign=spec_type();

            	    state._fsp--;


            	    			if(!TypesChecker.checkTypes(((variables_scope)variables_stack.peek()).varType, (secondAssign!=null?secondAssign.value:null)))
            	    			{
            	    				errors.add("line "+(ID4!=null?ID4.getLine():0)+": Type mismatch: cannot convert from "+((variables_scope)variables_stack.peek()).varType+" to "+(secondAssign!=null?secondAssign.value:null));
            	    			}
            	    		

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


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
    // $ANTLR end "init_var"

    public static class inside_func_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "inside_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:240:1: inside_func : ( elem | length | print_op | break_op | read_op | write_op | to_string_op );
    public final StrLangParser.inside_func_return inside_func() throws RecognitionException {
        StrLangParser.inside_func_return retval = new StrLangParser.inside_func_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:241:2: ( elem | length | print_op | break_op | read_op | write_op | to_string_op )
            int alt11=7;
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
            case 37:
                {
                alt11=3;
                }
                break;
            case 40:
                {
                alt11=4;
                }
                break;
            case 33:
                {
                alt11=5;
                }
                break;
            case 32:
                {
                alt11=6;
                }
                break;
            case 42:
                {
                alt11=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:241:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_inside_func382);
                    elem();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:242:4: length
                    {
                    pushFollow(FOLLOW_length_in_inside_func387);
                    length();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:243:4: print_op
                    {
                    pushFollow(FOLLOW_print_op_in_inside_func392);
                    print_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:244:4: break_op
                    {
                    pushFollow(FOLLOW_break_op_in_inside_func399);
                    break_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:245:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_inside_func404);
                    read_op();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:246:4: write_op
                    {
                    pushFollow(FOLLOW_write_op_in_inside_func410);
                    write_op();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:247:4: to_string_op
                    {
                    pushFollow(FOLLOW_to_string_op_in_inside_func415);
                    to_string_op();

                    state._fsp--;


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
    // $ANTLR end "inside_func"

    public static class assign_inside_func_return extends ParserRuleReturnScope {
        public String type;
        public int line;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "assign_inside_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:250:1: assign_inside_func returns [String type, int line] : ( elem | length | read_op | to_string_op );
    public final StrLangParser.assign_inside_func_return assign_inside_func() throws RecognitionException {
        StrLangParser.assign_inside_func_return retval = new StrLangParser.assign_inside_func_return();
        retval.start = input.LT(1);

        StrLangParser.elem_return elem5 = null;

        StrLangParser.length_return length6 = null;

        StrLangParser.read_op_return read_op7 = null;

        StrLangParser.to_string_op_return to_string_op8 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:251:2: ( elem | length | read_op | to_string_op )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt12=1;
                }
                break;
            case 38:
                {
                alt12=2;
                }
                break;
            case 33:
                {
                alt12=3;
                }
                break;
            case 42:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:251:4: elem
                    {
                    pushFollow(FOLLOW_elem_in_assign_inside_func430);
                    elem5=elem();

                    state._fsp--;

                    retval.type = "char"; retval.line = (elem5!=null?elem5.line:0);

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:252:4: length
                    {
                    pushFollow(FOLLOW_length_in_assign_inside_func437);
                    length6=length();

                    state._fsp--;

                    retval.type = "int"; retval.line = (length6!=null?length6.line:0);

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:253:4: read_op
                    {
                    pushFollow(FOLLOW_read_op_in_assign_inside_func444);
                    read_op7=read_op();

                    state._fsp--;

                    retval.type = "string"; retval.line = (read_op7!=null?read_op7.line:0);

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:254:4: to_string_op
                    {
                    pushFollow(FOLLOW_to_string_op_in_assign_inside_func451);
                    to_string_op8=to_string_op();

                    state._fsp--;

                    retval.type = "string"; retval.line = (to_string_op8!=null?to_string_op8.line:0);

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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "call_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:257:1: call_func returns [String type, int curLine] : ID '(' ( param )? ')' ;
    public final StrLangParser.call_func_return call_func() throws RecognitionException {
        call_func_stack.push(new call_func_scope());
        StrLangParser.call_func_return retval = new StrLangParser.call_func_return();
        retval.start = input.LT(1);

        Token ID9=null;
        StrLangParser.param_return param10 = null;



        	((call_func_scope)call_func_stack.peek()).methodName ="";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:264:2: ( ID '(' ( param )? ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:264:4: ID '(' ( param )? ')'
            {
            ID9=(Token)match(input,ID,FOLLOW_ID_in_call_func475); 
            ((call_func_scope)call_func_stack.peek()).methodName =(ID9!=null?ID9.getText():null);
            match(input,26,FOLLOW_26_in_call_func479); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:264:46: ( param )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID||(LA13_0>=INT && LA13_0<=SYMBOL)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:264:46: param
                    {
                    pushFollow(FOLLOW_param_in_call_func481);
                    param10=param();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_call_func484); 

            		retval.curLine = (ID9!=null?ID9.getLine():0);
            		ArrayList<String> list = null;
            		if((param10!=null?param10.argumentTypeList:null)==null)
            			list = new ArrayList<String>();
            		else
            			list = (param10!=null?param10.argumentTypeList:null);
            		if(!names.checkCallFunction((ID9!=null?ID9.getText():null), list, (ID9!=null?ID9.getLine():0)))
            		{
            			names.getAllErrors(errors);
            		}
            		if(!names.isExistFunction((ID9!=null?ID9.getText():null)))
            		{
            			errors.add("line "+(ID9!=null?ID9.getLine():0)+": function "+(ID9!=null?ID9.getText():null)+" is not exist");
            		}
            		else
            		{
            			NamesTable.FunctionName func = names.getFunction((ID9!=null?ID9.getText():null));
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

    public static class action_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "action"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:288:1: action : (a= spec_type prefix | b= spec_type ASSIGN_OP c= spec_type ( PLUS_OP | MINUS_OP ) d= spec_type );
    public final StrLangParser.action_return action() throws RecognitionException {
        StrLangParser.action_return retval = new StrLangParser.action_return();
        retval.start = input.LT(1);

        StrLangParser.spec_type_return a = null;

        StrLangParser.spec_type_return b = null;

        StrLangParser.spec_type_return c = null;

        StrLangParser.spec_type_return d = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:289:2: (a= spec_type prefix | b= spec_type ASSIGN_OP c= spec_type ( PLUS_OP | MINUS_OP ) d= spec_type )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:289:4: a= spec_type prefix
                    {
                    pushFollow(FOLLOW_spec_type_in_action502);
                    a=spec_type();

                    state._fsp--;

                    pushFollow(FOLLOW_prefix_in_action504);
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:297:4: b= spec_type ASSIGN_OP c= spec_type ( PLUS_OP | MINUS_OP ) d= spec_type
                    {
                    pushFollow(FOLLOW_spec_type_in_action514);
                    b=spec_type();

                    state._fsp--;

                    match(input,ASSIGN_OP,FOLLOW_ASSIGN_OP_in_action516); 
                    pushFollow(FOLLOW_spec_type_in_action520);
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

                    pushFollow(FOLLOW_spec_type_in_action530);
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
    // $ANTLR end "action"

    public static class spec_type_return extends ParserRuleReturnScope {
        public String value;
        public int curLine;
        public String text;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "spec_type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:328:1: spec_type returns [String value, int curLine, String text] : ( INT | LINE | SYMBOL | idLiteral | assign_inside_func | call_func | END_LINE );
    public final StrLangParser.spec_type_return spec_type() throws RecognitionException {
        StrLangParser.spec_type_return retval = new StrLangParser.spec_type_return();
        retval.start = input.LT(1);

        Token INT11=null;
        Token LINE12=null;
        Token SYMBOL13=null;
        Token END_LINE17=null;
        StrLangParser.idLiteral_return idLiteral14 = null;

        StrLangParser.assign_inside_func_return assign_inside_func15 = null;

        StrLangParser.call_func_return call_func16 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:329:2: ( INT | LINE | SYMBOL | idLiteral | assign_inside_func | call_func | END_LINE )
            int alt15=7;
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
                int LA15_4 = input.LA(2);

                if ( ((LA15_4>=ID && LA15_4<=MINUS_OP)||(LA15_4>=EQUALLY_EQL_OP && LA15_4<=DOUBLE_PLUS)||LA15_4==22||(LA15_4>=24 && LA15_4<=25)||(LA15_4>=27 && LA15_4<=43)||(LA15_4>=45 && LA15_4<=46)) ) {
                    alt15=4;
                }
                else if ( (LA15_4==26) ) {
                    alt15=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 4, input);

                    throw nvae;
                }
                }
                break;
            case 33:
            case 38:
            case 39:
            case 42:
                {
                alt15=5;
                }
                break;
            case END_LINE:
                {
                alt15=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:329:4: INT
                    {
                    INT11=(Token)match(input,INT,FOLLOW_INT_in_spec_type553); 
                    retval.value = "int"; retval.curLine = (INT11!=null?INT11.getLine():0);

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:330:4: LINE
                    {
                    LINE12=(Token)match(input,LINE,FOLLOW_LINE_in_spec_type561); 
                    retval.value = "string"; retval.curLine =(LINE12!=null?LINE12.getLine():0);

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:331:4: SYMBOL
                    {
                    SYMBOL13=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_spec_type569); 
                    retval.value = "char"; retval.curLine = (SYMBOL13!=null?SYMBOL13.getLine():0);

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:332:4: idLiteral
                    {
                    pushFollow(FOLLOW_idLiteral_in_spec_type577);
                    idLiteral14=idLiteral();

                    state._fsp--;

                    retval.value = (idLiteral14!=null?idLiteral14.idType:null); retval.curLine = (idLiteral14!=null?idLiteral14.curLine:0); retval.text = (idLiteral14!=null?idLiteral14.text:null);

                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:333:4: assign_inside_func
                    {
                    pushFollow(FOLLOW_assign_inside_func_in_spec_type585);
                    assign_inside_func15=assign_inside_func();

                    state._fsp--;

                    retval.value = (assign_inside_func15!=null?assign_inside_func15.type:null); retval.curLine = (assign_inside_func15!=null?assign_inside_func15.line:0);

                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:334:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_spec_type592);
                    call_func16=call_func();

                    state._fsp--;

                    retval.value = (call_func16!=null?call_func16.type:null); retval.curLine = (call_func16!=null?call_func16.curLine:0);

                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:335:4: END_LINE
                    {
                    END_LINE17=(Token)match(input,END_LINE,FOLLOW_END_LINE_in_spec_type599); 
                    retval.value = "char"; retval.curLine = (END_LINE17!=null?END_LINE17.getLine():0); 

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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "returnType"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:338:1: returnType returns [String value, String type] : ( INT | LINE | SYMBOL | idLiteral );
    public final StrLangParser.returnType_return returnType() throws RecognitionException {
        StrLangParser.returnType_return retval = new StrLangParser.returnType_return();
        retval.start = input.LT(1);

        Token INT18=null;
        Token LINE19=null;
        Token SYMBOL20=null;
        StrLangParser.idLiteral_return idLiteral21 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:339:2: ( INT | LINE | SYMBOL | idLiteral )
            int alt16=4;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt16=1;
                }
                break;
            case LINE:
                {
                alt16=2;
                }
                break;
            case SYMBOL:
                {
                alt16=3;
                }
                break;
            case ID:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:339:4: INT
                    {
                    INT18=(Token)match(input,INT,FOLLOW_INT_in_returnType616); 
                    retval.value = (INT18!=null?INT18.getText():null); retval.type = "int";

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:340:4: LINE
                    {
                    LINE19=(Token)match(input,LINE,FOLLOW_LINE_in_returnType623); 
                    retval.value = (LINE19!=null?LINE19.getText():null); retval.type = "string";

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:341:4: SYMBOL
                    {
                    SYMBOL20=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_returnType630); 
                    retval.value = (SYMBOL20!=null?SYMBOL20.getText():null); retval.type = "char";

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:342:4: idLiteral
                    {
                    pushFollow(FOLLOW_idLiteral_in_returnType637);
                    idLiteral21=idLiteral();

                    state._fsp--;

                    retval.value = (idLiteral21!=null?idLiteral21.text:null); retval.type = (idLiteral21!=null?idLiteral21.idType:null);

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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "idLiteral"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:345:1: idLiteral returns [String idType, int curLine, String text] : ID ;
    public final StrLangParser.idLiteral_return idLiteral() throws RecognitionException {
        StrLangParser.idLiteral_return retval = new StrLangParser.idLiteral_return();
        retval.start = input.LT(1);

        Token ID22=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:346:2: ( ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:346:4: ID
            {
            ID22=(Token)match(input,ID,FOLLOW_ID_in_idLiteral654); 

            		retval.curLine = (ID22!=null?ID22.getLine():0);
            		retval.text = (ID22!=null?ID22.getText():null);
            		if(!names.isExistVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID22!=null?ID22.getText():null)))
            		{
            			errors.add("line "+(ID22!=null?ID22.getLine():0)+": unknown variable "+(ID22!=null?ID22.getText():null));
            			retval.idType = "";
            		}
            		else
            		{
            			names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID22!=null?ID22.getText():null)).addLineUses((ID22!=null?ID22.getLine():0));
            			retval.idType = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID22!=null?ID22.getText():null)).getType();
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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:363:1: type : ( 'string' | 'int' | 'char' | 'void' );
    public final StrLangParser.type_return type() throws RecognitionException {
        StrLangParser.type_return retval = new StrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:364:2: ( 'string' | 'int' | 'char' | 'void' )
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

    public static class global_func_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "global_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:370:1: global_func : type ID '(' ( functionArgumentList )? ')' '{' body ( return_op )? '}' ;
    public final StrLangParser.global_func_return global_func() throws RecognitionException {
        global_func_stack.push(new global_func_scope());
        StrLangParser.global_func_return retval = new StrLangParser.global_func_return();
        retval.start = input.LT(1);

        Token ID24=null;
        StrLangParser.type_return type23 = null;



        	((global_func_scope)global_func_stack.peek()).funcName = "";
        	((global_func_scope)global_func_stack.peek()).funcType = "";
        	((global_func_scope)global_func_stack.peek()).returnVariable = "";
        	((global_func_scope)global_func_stack.peek()).funcArgNames = new ArrayList<String>();
        	((global_func_scope)global_func_stack.peek()).funcArgTypes = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:386:2: ( type ID '(' ( functionArgumentList )? ')' '{' body ( return_op )? '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:386:4: type ID '(' ( functionArgumentList )? ')' '{' body ( return_op )? '}'
            {
            pushFollow(FOLLOW_type_in_global_func709);
            type23=type();

            state._fsp--;

            ((global_func_scope)global_func_stack.peek()).funcType = (type23!=null?input.toString(type23.start,type23.stop):null);
            ID24=(Token)match(input,ID,FOLLOW_ID_in_global_func713); 
            ((program_scope)program_stack.peek()).curBlock = (ID24!=null?ID24.getText():null); ((global_func_scope)global_func_stack.peek()).funcName =(ID24!=null?ID24.getText():null);
            match(input,26,FOLLOW_26_in_global_func718); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:387:7: ( functionArgumentList )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=28 && LA17_0<=31)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:387:7: functionArgumentList
                    {
                    pushFollow(FOLLOW_functionArgumentList_in_global_func720);
                    functionArgumentList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_global_func723); 

            	 	if(!names.isExistFunction((ID24!=null?ID24.getText():null)))
            	 	{
            	 		names.addFunction(names.new FunctionName((ID24!=null?ID24.getText():null), (type23!=null?input.toString(type23.start,type23.stop):null), ((global_func_scope)global_func_stack.peek()).funcArgTypes, ((global_func_scope)global_func_stack.peek()).funcArgNames, (ID24!=null?ID24.getLine():0)));
            	 	}
            	 	else
            	 	{
            	 		errors.add("line "+(ID24!=null?ID24.getLine():0)+": Duplicated declaration function "+(ID24!=null?ID24.getText():null));
            	 	}
            	 
            match(input,23,FOLLOW_23_in_global_func735); 
            pushFollow(FOLLOW_body_in_global_func743);
            body();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:401:6: ( return_op )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==41) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:402:7: return_op
                    {
                    pushFollow(FOLLOW_return_op_in_global_func758);
                    return_op();

                    state._fsp--;


                    				  	boolean result = names.checkReturnType((ID24!=null?ID24.getText():null), ((global_func_scope)global_func_stack.peek()).returnVariable, ((program_scope)program_stack.peek()).curBlock, (ID24!=null?ID24.getLine():0));
                    				  	if(result==false)
                    				  	{
                    				  		errors.add(names.getLastError());
                    				  	}
                    			  	

                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_global_func779); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            global_func_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "global_func"

    public static class functionArgumentList_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "functionArgumentList"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:414:1: functionArgumentList : functionArgumentDeclarator ( ',' functionArgumentDeclarator )* ;
    public final StrLangParser.functionArgumentList_return functionArgumentList() throws RecognitionException {
        StrLangParser.functionArgumentList_return retval = new StrLangParser.functionArgumentList_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:2: ( functionArgumentDeclarator ( ',' functionArgumentDeclarator )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:4: functionArgumentDeclarator ( ',' functionArgumentDeclarator )*
            {
            pushFollow(FOLLOW_functionArgumentDeclarator_in_functionArgumentList793);
            functionArgumentDeclarator();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:31: ( ',' functionArgumentDeclarator )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==25) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:415:32: ',' functionArgumentDeclarator
            	    {
            	    match(input,25,FOLLOW_25_in_functionArgumentList796); 
            	    pushFollow(FOLLOW_functionArgumentDeclarator_in_functionArgumentList798);
            	    functionArgumentDeclarator();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


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
    // $ANTLR end "functionArgumentList"

    public static class functionArgumentDeclarator_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "functionArgumentDeclarator"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:418:1: functionArgumentDeclarator : type ID ;
    public final StrLangParser.functionArgumentDeclarator_return functionArgumentDeclarator() throws RecognitionException {
        StrLangParser.functionArgumentDeclarator_return retval = new StrLangParser.functionArgumentDeclarator_return();
        retval.start = input.LT(1);

        Token ID26=null;
        StrLangParser.type_return type25 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:419:2: ( type ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:419:4: type ID
            {
            pushFollow(FOLLOW_type_in_functionArgumentDeclarator812);
            type25=type();

            state._fsp--;

            ID26=(Token)match(input,ID,FOLLOW_ID_in_functionArgumentDeclarator814); 

            		((global_func_scope)global_func_stack.peek()).funcArgTypes.add((type25!=null?input.toString(type25.start,type25.stop):null));
            		((global_func_scope)global_func_stack.peek()).funcArgNames.add((ID26!=null?ID26.getText():null));
            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID26!=null?ID26.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID26!=null?ID26.getText():null), (type25!=null?input.toString(type25.start,type25.stop):null), (ID26!=null?ID26.getLine():0)));
            		}
            		else
            		{
            			errors.add("line "+(ID26!=null?ID26.getLine():0)+": Duplicated variable name "+(ID26!=null?ID26.getText():null));
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
    // $ANTLR end "functionArgumentDeclarator"

    public static class param_return extends ParserRuleReturnScope {
        public ArrayList<String> argumentTypeList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "param"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:434:1: param returns [ArrayList<String> argumentTypeList] : a= returnType ( ',' b= returnType )* ;
    public final StrLangParser.param_return param() throws RecognitionException {
        StrLangParser.param_return retval = new StrLangParser.param_return();
        retval.start = input.LT(1);

        StrLangParser.returnType_return a = null;

        StrLangParser.returnType_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:435:2: (a= returnType ( ',' b= returnType )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:436:2: a= returnType ( ',' b= returnType )*
            {

            		retval.argumentTypeList = new ArrayList<String>();
            	
            pushFollow(FOLLOW_returnType_in_param841);
            a=returnType();

            state._fsp--;

            retval.argumentTypeList.add((a!=null?a.type:null));
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:439:49: ( ',' b= returnType )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==25) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:439:50: ',' b= returnType
            	    {
            	    match(input,25,FOLLOW_25_in_param846); 
            	    pushFollow(FOLLOW_returnType_in_param850);
            	    b=returnType();

            	    state._fsp--;

            	    retval.argumentTypeList.add((b!=null?b.type:null));

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


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
    // $ANTLR end "param"

    public static class write_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "write_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:442:1: write_op : c= 'WriteToFile' '(' a= string_and_var ',' b= string_and_var ')' ;
    public final StrLangParser.write_op_return write_op() throws RecognitionException {
        StrLangParser.write_op_return retval = new StrLangParser.write_op_return();
        retval.start = input.LT(1);

        Token c=null;
        StrLangParser.string_and_var_return a = null;

        StrLangParser.string_and_var_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:443:2: (c= 'WriteToFile' '(' a= string_and_var ',' b= string_and_var ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:443:4: c= 'WriteToFile' '(' a= string_and_var ',' b= string_and_var ')'
            {
            c=(Token)match(input,32,FOLLOW_32_in_write_op868); 
            match(input,26,FOLLOW_26_in_write_op870); 
            pushFollow(FOLLOW_string_and_var_in_write_op875);
            a=string_and_var();

            state._fsp--;

            match(input,25,FOLLOW_25_in_write_op877); 
            pushFollow(FOLLOW_string_and_var_in_write_op882);
            b=string_and_var();

            state._fsp--;

            match(input,27,FOLLOW_27_in_write_op885); 

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
    // $ANTLR end "write_op"

    public static class read_op_return extends ParserRuleReturnScope {
        public int line;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "read_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:457:1: read_op returns [int line] : c= 'ReadFile' '(' a= string_and_var ')' ;
    public final StrLangParser.read_op_return read_op() throws RecognitionException {
        StrLangParser.read_op_return retval = new StrLangParser.read_op_return();
        retval.start = input.LT(1);

        Token c=null;
        StrLangParser.string_and_var_return a = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:458:2: (c= 'ReadFile' '(' a= string_and_var ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:458:4: c= 'ReadFile' '(' a= string_and_var ')'
            {
            c=(Token)match(input,33,FOLLOW_33_in_read_op904); 
            match(input,26,FOLLOW_26_in_read_op906); 
            pushFollow(FOLLOW_string_and_var_in_read_op910);
            a=string_and_var();

            state._fsp--;

            match(input,27,FOLLOW_27_in_read_op912); 
            retval.line = (c!=null?c.getLine():0);

            		String s_type = "string";
            		if(!TypesChecker.checkTypes((a!=null?a.type:null), s_type))
            		{
            			errors.add("line "+(c!=null?c.getLine():0)+": incorrect argument type for function ReadFile. Need type string, found "+(a!=null?a.type:null));
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
    // $ANTLR end "read_op"

    public static class while_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "while_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:468:1: while_op : 'while' '(' logic ')' '{' body '}' ;
    public final StrLangParser.while_op_return while_op() throws RecognitionException {
        StrLangParser.while_op_return retval = new StrLangParser.while_op_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:469:2: ( 'while' '(' logic ')' '{' body '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:469:4: 'while' '(' logic ')' '{' body '}'
            {
            match(input,34,FOLLOW_34_in_while_op928); 
            match(input,26,FOLLOW_26_in_while_op930); 
            pushFollow(FOLLOW_logic_in_while_op932);
            logic();

            state._fsp--;

            match(input,27,FOLLOW_27_in_while_op934); 
            match(input,23,FOLLOW_23_in_while_op936); 
            pushFollow(FOLLOW_body_in_while_op938);
            body();

            state._fsp--;

            match(input,24,FOLLOW_24_in_while_op940); 

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
    // $ANTLR end "while_op"

    public static class for_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "for_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:471:1: for_op : 'for' '(' (e1= variables )? ';' ( logic )? ';' ( action )? ')' '{' body '}' ;
    public final StrLangParser.for_op_return for_op() throws RecognitionException {
        StrLangParser.for_op_return retval = new StrLangParser.for_op_return();
        retval.start = input.LT(1);

        StrLangParser.variables_return e1 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:2: ( 'for' '(' (e1= variables )? ';' ( logic )? ';' ( action )? ')' '{' body '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:4: 'for' '(' (e1= variables )? ';' ( logic )? ';' ( action )? ')' '{' body '}'
            {
            match(input,35,FOLLOW_35_in_for_op954); 
            match(input,26,FOLLOW_26_in_for_op956); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:16: (e1= variables )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ID||(LA21_0>=28 && LA21_0<=31)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:16: e1= variables
                    {
                    pushFollow(FOLLOW_variables_in_for_op960);
                    e1=variables();

                    state._fsp--;


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_for_op963); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:32: ( logic )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ID||(LA22_0>=INT && LA22_0<=END_LINE)||LA22_0==26||LA22_0==33||(LA22_0>=38 && LA22_0<=39)||LA22_0==42) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:32: logic
                    {
                    pushFollow(FOLLOW_logic_in_for_op965);
                    logic();

                    state._fsp--;


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_for_op968); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:43: ( action )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID||(LA23_0>=INT && LA23_0<=END_LINE)||LA23_0==33||(LA23_0>=38 && LA23_0<=39)||LA23_0==42) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:472:43: action
                    {
                    pushFollow(FOLLOW_action_in_for_op970);
                    action();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_for_op973); 
            match(input,23,FOLLOW_23_in_for_op975); 
            pushFollow(FOLLOW_body_in_for_op977);
            body();

            state._fsp--;

            match(input,24,FOLLOW_24_in_for_op979); 

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
    // $ANTLR end "for_op"

    public static class print_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "print_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:475:1: print_op : 'print' '(' a= returnType ')' ;
    public final StrLangParser.print_op_return print_op() throws RecognitionException {
        StrLangParser.print_op_return retval = new StrLangParser.print_op_return();
        retval.start = input.LT(1);

        StrLangParser.returnType_return a = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:476:2: ( 'print' '(' a= returnType ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:476:4: 'print' '(' a= returnType ')'
            {
            match(input,37,FOLLOW_37_in_print_op990); 
            match(input,26,FOLLOW_26_in_print_op992); 
            pushFollow(FOLLOW_returnType_in_print_op996);
            a=returnType();

            state._fsp--;

            match(input,27,FOLLOW_27_in_print_op998); 

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
    // $ANTLR end "print_op"

    public static class length_return extends ParserRuleReturnScope {
        public int line;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "length"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:490:1: length returns [int line] : c= 'length' '(' a= string_and_var ')' ;
    public final StrLangParser.length_return length() throws RecognitionException {
        StrLangParser.length_return retval = new StrLangParser.length_return();
        retval.start = input.LT(1);

        Token c=null;
        StrLangParser.string_and_var_return a = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:491:2: (c= 'length' '(' a= string_and_var ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:491:4: c= 'length' '(' a= string_and_var ')'
            {
            c=(Token)match(input,38,FOLLOW_38_in_length1018); 
            match(input,26,FOLLOW_26_in_length1020); 
            pushFollow(FOLLOW_string_and_var_in_length1024);
            a=string_and_var();

            state._fsp--;

            match(input,27,FOLLOW_27_in_length1026); 
            retval.line = (c!=null?c.getLine():0);

            		String s_type = "string";
            		if(!TypesChecker.checkTypes((a!=null?a.type:null), s_type))
            		{
            			errors.add("line "+(c!=null?c.getLine():0)+": incorrect argument type for function length. Need type string, found "+(a!=null?a.type:null));
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
    // $ANTLR end "length"

    public static class elem_return extends ParserRuleReturnScope {
        public int line;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "elem"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:501:1: elem returns [int line] : a= 'elem' '(' returnType ',' returnType ')' ;
    public final StrLangParser.elem_return elem() throws RecognitionException {
        StrLangParser.elem_return retval = new StrLangParser.elem_return();
        retval.start = input.LT(1);

        Token a=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:502:2: (a= 'elem' '(' returnType ',' returnType ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:502:3: a= 'elem' '(' returnType ',' returnType ')'
            {
            a=(Token)match(input,39,FOLLOW_39_in_elem1047); 
            match(input,26,FOLLOW_26_in_elem1049); 
            pushFollow(FOLLOW_returnType_in_elem1051);
            returnType();

            state._fsp--;

            match(input,25,FOLLOW_25_in_elem1053); 
            pushFollow(FOLLOW_returnType_in_elem1055);
            returnType();

            state._fsp--;

            match(input,27,FOLLOW_27_in_elem1057); 
            retval.line = (a!=null?a.getLine():0);

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
    // $ANTLR end "elem"

    public static class break_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "break_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:505:1: break_op : 'break' ;
    public final StrLangParser.break_op_return break_op() throws RecognitionException {
        StrLangParser.break_op_return retval = new StrLangParser.break_op_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:506:2: ( 'break' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:506:4: 'break'
            {
            match(input,40,FOLLOW_40_in_break_op1071); 

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
    // $ANTLR end "break_op"

    public static class return_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "return_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:510:1: return_op : 'return' returnType ;
    public final StrLangParser.return_op_return return_op() throws RecognitionException {
        StrLangParser.return_op_return retval = new StrLangParser.return_op_return();
        retval.start = input.LT(1);

        StrLangParser.returnType_return returnType27 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:511:3: ( 'return' returnType )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:511:5: 'return' returnType
            {
            match(input,41,FOLLOW_41_in_return_op1086); 
            pushFollow(FOLLOW_returnType_in_return_op1088);
            returnType27=returnType();

            state._fsp--;


             		((global_func_scope)global_func_stack.peek()).returnVariable = (returnType27!=null?returnType27.value:null);
             	

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
    // $ANTLR end "return_op"

    public static class to_string_op_return extends ParserRuleReturnScope {
        public int line;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "to_string_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:517:2: to_string_op returns [int line] : a= 'ToString' '(' returnType ')' ;
    public final StrLangParser.to_string_op_return to_string_op() throws RecognitionException {
        StrLangParser.to_string_op_return retval = new StrLangParser.to_string_op_return();
        retval.start = input.LT(1);

        Token a=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:518:3: (a= 'ToString' '(' returnType ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:518:5: a= 'ToString' '(' returnType ')'
            {
            a=(Token)match(input,42,FOLLOW_42_in_to_string_op1113); 
            match(input,26,FOLLOW_26_in_to_string_op1115); 
            pushFollow(FOLLOW_returnType_in_to_string_op1117);
            returnType();

            state._fsp--;

            match(input,27,FOLLOW_27_in_to_string_op1119); 

             		retval.line = (a!=null?a.getLine():0); 
             	

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
    // $ANTLR end "to_string_op"

    public static class if_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "if_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:524:1: if_op : 'if' '(' logic ')' '{' ifblock= body '}' ( 'else' '{' elseblock= body '}' )? ;
    public final StrLangParser.if_op_return if_op() throws RecognitionException {
        StrLangParser.if_op_return retval = new StrLangParser.if_op_return();
        retval.start = input.LT(1);

        StrLangParser.body_return ifblock = null;

        StrLangParser.body_return elseblock = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:525:2: ( 'if' '(' logic ')' '{' ifblock= body '}' ( 'else' '{' elseblock= body '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:525:4: 'if' '(' logic ')' '{' ifblock= body '}' ( 'else' '{' elseblock= body '}' )?
            {
            match(input,43,FOLLOW_43_in_if_op1135); 
            match(input,26,FOLLOW_26_in_if_op1137); 
            pushFollow(FOLLOW_logic_in_if_op1139);
            logic();

            state._fsp--;

            match(input,27,FOLLOW_27_in_if_op1141); 
            match(input,23,FOLLOW_23_in_if_op1143); 
            pushFollow(FOLLOW_body_in_if_op1147);
            ifblock=body();

            state._fsp--;

            match(input,24,FOLLOW_24_in_if_op1149); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:525:44: ( 'else' '{' elseblock= body '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==44) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:525:45: 'else' '{' elseblock= body '}'
                    {
                    match(input,44,FOLLOW_44_in_if_op1152); 
                    match(input,23,FOLLOW_23_in_if_op1154); 
                    pushFollow(FOLLOW_body_in_if_op1158);
                    elseblock=body();

                    state._fsp--;

                    match(input,24,FOLLOW_24_in_if_op1160); 

                    }
                    break;

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
    // $ANTLR end "if_op"

    public static class expr_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "expr"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:532:1: expr : ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY );
    public final StrLangParser.expr_return expr() throws RecognitionException {
        StrLangParser.expr_return retval = new StrLangParser.expr_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:533:2: ( EQUALLY_EQL_OP | MORE_EQL_OP | LESS_EQL_OP | MORE_OP | LESS_OP | NO_EQUALLY )
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
    // $ANTLR end "expr"

    public static class prefix_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "prefix"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:541:1: prefix : ( DOUBLE_MINUS | DOUBLE_PLUS );
    public final StrLangParser.prefix_return prefix() throws RecognitionException {
        StrLangParser.prefix_return retval = new StrLangParser.prefix_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:542:2: ( DOUBLE_MINUS | DOUBLE_PLUS )
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
    // $ANTLR end "prefix"

    public static class logic_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "logic"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:546:1: logic : logic_and ;
    public final StrLangParser.logic_return logic() throws RecognitionException {
        StrLangParser.logic_return retval = new StrLangParser.logic_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:547:2: ( logic_and )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:547:4: logic_and
            {
            pushFollow(FOLLOW_logic_and_in_logic1237);
            logic_and();

            state._fsp--;


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
    // $ANTLR end "logic"

    public static class logic_and_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "logic_and"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:550:1: logic_and : logic_or ( 'and' logic_or )* ;
    public final StrLangParser.logic_and_return logic_and() throws RecognitionException {
        StrLangParser.logic_and_return retval = new StrLangParser.logic_and_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:551:2: ( logic_or ( 'and' logic_or )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:551:4: logic_or ( 'and' logic_or )*
            {
            pushFollow(FOLLOW_logic_or_in_logic_and1250);
            logic_or();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:551:13: ( 'and' logic_or )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==45) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:551:14: 'and' logic_or
            	    {
            	    match(input,45,FOLLOW_45_in_logic_and1253); 
            	    pushFollow(FOLLOW_logic_or_in_logic_and1255);
            	    logic_or();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


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
    // $ANTLR end "logic_and"

    public static class logic_or_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "logic_or"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:553:1: logic_or : logic_expr ( 'or' logic_expr )* ;
    public final StrLangParser.logic_or_return logic_or() throws RecognitionException {
        StrLangParser.logic_or_return retval = new StrLangParser.logic_or_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:554:2: ( logic_expr ( 'or' logic_expr )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:554:4: logic_expr ( 'or' logic_expr )*
            {
            pushFollow(FOLLOW_logic_expr_in_logic_or1268);
            logic_expr();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:554:15: ( 'or' logic_expr )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==46) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:554:16: 'or' logic_expr
            	    {
            	    match(input,46,FOLLOW_46_in_logic_or1271); 
            	    pushFollow(FOLLOW_logic_expr_in_logic_or1273);
            	    logic_expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


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
    // $ANTLR end "logic_or"

    public static class logic_expr_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "logic_expr"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:558:1: logic_expr : (a= logic_atom expr b= logic_atom | '(' logic ')' );
    public final StrLangParser.logic_expr_return logic_expr() throws RecognitionException {
        StrLangParser.logic_expr_return retval = new StrLangParser.logic_expr_return();
        retval.start = input.LT(1);

        StrLangParser.logic_atom_return a = null;

        StrLangParser.logic_atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:559:2: (a= logic_atom expr b= logic_atom | '(' logic ')' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ID||(LA27_0>=INT && LA27_0<=END_LINE)||LA27_0==33||(LA27_0>=38 && LA27_0<=39)||LA27_0==42) ) {
                alt27=1;
            }
            else if ( (LA27_0==26) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:559:4: a= logic_atom expr b= logic_atom
                    {
                    pushFollow(FOLLOW_logic_atom_in_logic_expr1289);
                    a=logic_atom();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_logic_expr1291);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_logic_atom_in_logic_expr1295);
                    b=logic_atom();

                    state._fsp--;


                    		if(!TypesChecker.checkTypes((a!=null?a.type:null),(b!=null?b.type:null)))
                    		{
                    			errors.add("line "+(a!=null?a.curLine:0)+": incomparable types: "+(a!=null?a.type:null)+" and "+(b!=null?b.type:null));
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:566:4: '(' logic ')'
                    {
                    match(input,26,FOLLOW_26_in_logic_expr1305); 
                    pushFollow(FOLLOW_logic_in_logic_expr1307);
                    logic();

                    state._fsp--;

                    match(input,27,FOLLOW_27_in_logic_expr1309); 

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
    // $ANTLR end "logic_expr"

    public static class logic_atom_return extends ParserRuleReturnScope {
        public String type;
        public int curLine;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "logic_atom"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:569:1: logic_atom returns [String type, int curLine] : spec_type ;
    public final StrLangParser.logic_atom_return logic_atom() throws RecognitionException {
        StrLangParser.logic_atom_return retval = new StrLangParser.logic_atom_return();
        retval.start = input.LT(1);

        StrLangParser.spec_type_return spec_type28 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:570:2: ( spec_type )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:570:4: spec_type
            {
            pushFollow(FOLLOW_spec_type_in_logic_atom1323);
            spec_type28=spec_type();

            state._fsp--;

            retval.type = (spec_type28!=null?spec_type28.value:null); retval.curLine = (spec_type28!=null?spec_type28.curLine:0);

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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "string_and_var"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:573:1: string_and_var returns [String value, String type] : ( idLiteral | LINE );
    public final StrLangParser.string_and_var_return string_and_var() throws RecognitionException {
        StrLangParser.string_and_var_return retval = new StrLangParser.string_and_var_return();
        retval.start = input.LT(1);

        Token LINE30=null;
        StrLangParser.idLiteral_return idLiteral29 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:574:2: ( idLiteral | LINE )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==ID) ) {
                alt28=1;
            }
            else if ( (LA28_0==LINE) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:574:4: idLiteral
                    {
                    pushFollow(FOLLOW_idLiteral_in_string_and_var1340);
                    idLiteral29=idLiteral();

                    state._fsp--;

                    retval.value = (idLiteral29!=null?idLiteral29.text:null); retval.type = (idLiteral29!=null?idLiteral29.idType:null);

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:575:4: LINE
                    {
                    LINE30=(Token)match(input,LINE,FOLLOW_LINE_in_string_and_var1347); 
                    retval.value = (LINE30!=null?LINE30.getText():null); retval.type = "string";

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


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\60\uffff";
    static final String DFA14_eofS =
        "\60\uffff";
    static final String DFA14_minS =
        "\1\4\4\5\4\32\1\5\2\uffff\5\4\4\31\1\5\4\31\10\33\2\4\3\5\4\31"+
        "\4\33\1\5";
    static final String DFA14_maxS =
        "\1\52\3\23\5\32\1\23\2\uffff\1\33\1\12\2\11\1\12\4\33\1\23\4\31"+
        "\10\33\2\12\3\23\10\33\1\23";
    static final String DFA14_acceptS =
        "\12\uffff\1\1\1\2\44\uffff";
    static final String DFA14_specialS =
        "\60\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\4\3\uffff\1\1\1\2\1\3\1\11\25\uffff\1\7\4\uffff\1\6\1\5"+
            "\2\uffff\1\10",
            "\1\13\14\uffff\2\12",
            "\1\13\14\uffff\2\12",
            "\1\13\14\uffff\2\12",
            "\1\13\14\uffff\2\12\6\uffff\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\13\14\uffff\2\12",
            "",
            "",
            "\1\24\3\uffff\1\21\1\22\1\23\20\uffff\1\25",
            "\1\31\3\uffff\1\26\1\27\1\30",
            "\1\32\4\uffff\1\33",
            "\1\34\4\uffff\1\35",
            "\1\41\3\uffff\1\36\1\37\1\40",
            "\1\42\1\uffff\1\25",
            "\1\42\1\uffff\1\25",
            "\1\42\1\uffff\1\25",
            "\1\42\1\uffff\1\25",
            "\1\13\14\uffff\2\12",
            "\1\43",
            "\1\43",
            "\1\43",
            "\1\43",
            "\1\44",
            "\1\44",
            "\1\45",
            "\1\45",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\52\3\uffff\1\47\1\50\1\51",
            "\1\56\3\uffff\1\53\1\54\1\55",
            "\1\13\14\uffff\2\12",
            "\1\13\14\uffff\2\12",
            "\1\13\14\uffff\2\12",
            "\1\42\1\uffff\1\25",
            "\1\42\1\uffff\1\25",
            "\1\42\1\uffff\1\25",
            "\1\42\1\uffff\1\25",
            "\1\57",
            "\1\57",
            "\1\57",
            "\1\57",
            "\1\13\14\uffff\2\12"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "288:1: action : (a= spec_type prefix | b= spec_type ASSIGN_OP c= spec_type ( PLUS_OP | MINUS_OP ) d= spec_type );";
        }
    }
 

    public static final BitSet FOLLOW_global_decl_in_program59 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_mainBlock_in_program64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_mainBlock79 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_mainBlock81 = new BitSet(new long[]{0x00000DEFF1000010L});
    public static final BitSet FOLLOW_body_in_mainBlock83 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_mainBlock85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_var_in_global_decl104 = new BitSet(new long[]{0x00000000F0000012L});
    public static final BitSet FOLLOW_global_func_in_global_decl108 = new BitSet(new long[]{0x00000000F0000012L});
    public static final BitSet FOLLOW_variables_in_global_var124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inside_func_in_func135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_func140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stmt_in_body161 = new BitSet(new long[]{0x00000DEFF0000012L});
    public static final BitSet FOLLOW_variables_in_stmt176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_in_stmt182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_op_in_stmt187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_op_in_stmt193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_op_in_stmt198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_var_in_variables216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_var_in_variables221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_var234 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarators_in_decl_var240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators253 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_variableDeclarators256 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators258 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ID_in_variableDeclarator279 = new BitSet(new long[]{0x00000000000000E2L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_variableDeclarator291 = new BitSet(new long[]{0x000005E300000F10L});
    public static final BitSet FOLLOW_spec_type_in_variableDeclarator295 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_variableDeclarator307 = new BitSet(new long[]{0x000005E300000F10L});
    public static final BitSet FOLLOW_spec_type_in_variableDeclarator315 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_ID_in_init_var337 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_init_var339 = new BitSet(new long[]{0x000005E300000F10L});
    public static final BitSet FOLLOW_spec_type_in_init_var343 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_init_var353 = new BitSet(new long[]{0x000005E300000F10L});
    public static final BitSet FOLLOW_spec_type_in_init_var361 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_elem_in_inside_func382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_inside_func387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_op_in_inside_func392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_op_in_inside_func399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_inside_func404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_op_in_inside_func410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_string_op_in_inside_func415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elem_in_assign_inside_func430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_in_assign_inside_func437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_op_in_assign_inside_func444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_string_op_in_assign_inside_func451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func475 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_call_func479 = new BitSet(new long[]{0x0000000008000710L});
    public static final BitSet FOLLOW_param_in_call_func481 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_call_func484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action502 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_prefix_in_action504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_action514 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_OP_in_action516 = new BitSet(new long[]{0x000005E300000F10L});
    public static final BitSet FOLLOW_spec_type_in_action520 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_action522 = new BitSet(new long[]{0x000005E300000F10L});
    public static final BitSet FOLLOW_spec_type_in_action530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_spec_type553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_spec_type561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_spec_type569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idLiteral_in_spec_type577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_inside_func_in_spec_type585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_spec_type592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_LINE_in_spec_type599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_returnType616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_returnType623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOL_in_returnType630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idLiteral_in_returnType637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_idLiteral654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_func709 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_func713 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_global_func718 = new BitSet(new long[]{0x00000000F8000000L});
    public static final BitSet FOLLOW_functionArgumentList_in_global_func720 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_global_func723 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_global_func735 = new BitSet(new long[]{0x00000FEFF1000010L});
    public static final BitSet FOLLOW_body_in_global_func743 = new BitSet(new long[]{0x0000020001000000L});
    public static final BitSet FOLLOW_return_op_in_global_func758 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_global_func779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionArgumentDeclarator_in_functionArgumentList793 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_functionArgumentList796 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_functionArgumentDeclarator_in_functionArgumentList798 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_type_in_functionArgumentDeclarator812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functionArgumentDeclarator814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnType_in_param841 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_param846 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_param850 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_32_in_write_op868 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_write_op870 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_string_and_var_in_write_op875 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_write_op877 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_string_and_var_in_write_op882 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_write_op885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_read_op904 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_read_op906 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_string_and_var_in_read_op910 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_read_op912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_while_op928 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_while_op930 = new BitSet(new long[]{0x000005E304000F10L});
    public static final BitSet FOLLOW_logic_in_while_op932 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_while_op934 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_while_op936 = new BitSet(new long[]{0x00000DEFF1000010L});
    public static final BitSet FOLLOW_body_in_while_op938 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_while_op940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_for_op954 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_for_op956 = new BitSet(new long[]{0x00000010F0000010L});
    public static final BitSet FOLLOW_variables_in_for_op960 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_for_op963 = new BitSet(new long[]{0x000005F304000F10L});
    public static final BitSet FOLLOW_logic_in_for_op965 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_for_op968 = new BitSet(new long[]{0x000005E308000F10L});
    public static final BitSet FOLLOW_action_in_for_op970 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_for_op973 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_for_op975 = new BitSet(new long[]{0x00000DEFF1000010L});
    public static final BitSet FOLLOW_body_in_for_op977 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_for_op979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_print_op990 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_print_op992 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_print_op996 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_print_op998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_length1018 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_length1020 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_string_and_var_in_length1024 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_length1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_elem1047 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_elem1049 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_elem1051 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elem1053 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_elem1055 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_elem1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_break_op1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_op1086 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_return_op1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_to_string_op1113 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_to_string_op1115 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_returnType_in_to_string_op1117 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_to_string_op1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_if_op1135 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_if_op1137 = new BitSet(new long[]{0x000005E304000F10L});
    public static final BitSet FOLLOW_logic_in_if_op1139 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_if_op1141 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_if_op1143 = new BitSet(new long[]{0x00000DEFF1000010L});
    public static final BitSet FOLLOW_body_in_if_op1147 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_if_op1149 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_if_op1152 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_if_op1154 = new BitSet(new long[]{0x00000DEFF1000010L});
    public static final BitSet FOLLOW_body_in_if_op1158 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_if_op1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expr0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_prefix0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_and_in_logic1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_or_in_logic_and1250 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_logic_and1253 = new BitSet(new long[]{0x000005E304000F10L});
    public static final BitSet FOLLOW_logic_or_in_logic_and1255 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or1268 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_logic_or1271 = new BitSet(new long[]{0x000005E304000F10L});
    public static final BitSet FOLLOW_logic_expr_in_logic_or1273 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr1289 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_expr_in_logic_expr1291 = new BitSet(new long[]{0x000005E300000F10L});
    public static final BitSet FOLLOW_logic_atom_in_logic_expr1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_logic_expr1305 = new BitSet(new long[]{0x000005E304000F10L});
    public static final BitSet FOLLOW_logic_in_logic_expr1307 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_logic_expr1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_type_in_logic_atom1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idLiteral_in_string_and_var1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_string_and_var1347 = new BitSet(new long[]{0x0000000000000002L});

}