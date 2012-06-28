// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g 2012-06-27 03:02:52

    package grammar;
    import java.io.*;
    import namestable.*;
    import org.antlr.stringtemplate.StringTemplateGroup;
    import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;
    import java.io.UnsupportedEncodingException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class MyStrLangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "STRING", "CHAR", "COMMENT", "WS", "'main'", "'{'", "'}'", "';'", "'('", "')'", "','", "'delegate'", "'='", "'+'", "'-'", "'*'", "'/'", "'^'", "'write'", "'read'", "'if'", "'else'", "'for'", "'while'", "'return'", "'length'", "'elem'", "'ToString'", "'||'", "'&&'", "'!'", "'<'", "'>'", "'=='", "'!='", "'>='", "'<='", "'equals'", "'contains'", "'indexOf'", "'replace'", "'replaceFirst'", "'subString'", "'int'", "'string'", "'char'", "'void'", "'['", "':'", "']'"
    };
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
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
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int ID=4;
    public static final int INT=5;
    public static final int STRING=6;
    public static final int CHAR=7;
    public static final int COMMENT=8;
    public static final int WS=9;

    // delegates
    // delegators


        public MyStrLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MyStrLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("MyStrLangParserTemplates", AngleBracketTemplateLexer.class);

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

    public String[] getTokenNames() { return MyStrLangParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g"; }


        /** name of file */
    		private static String programName = "";
    		/** counter of variables */
    		private int counter;
    		/** counter of label for contlor structure */
    		private int labelCounter;
    		/** name of function*/
    		private String _funcName = "";
    		/** type of function */
    		private String _funcType = "";
    		
    		/** NamesTable contains declaration variables, functions and delegations */
    		protected NamesTable names = new NamesTable();
    		/** list of errors */
    		protected ArrayList<String> errors = new ArrayList<String>();
    		
    		public static StringTemplateGroup templateGroup;
    		/** path to file, where contain template */
    		public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";	//testing line
    		//public static final String templateFileName = "template/ByteCode.stg";	//line for jar file
    		
    		/**
    		* @param args of command line
    		*/
    		public static void main(String[] args) throws Exception {
    			templateGroup = new StringTemplateGroup(new FileReader(templateFileName), AngleBracketTemplateLexer.class);
    			/** error checking of input file */
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

    			programName = codeFile.substring(0, codeFile.lastIndexOf("."));

    			try{
    				MyStrLangLexer lexer = new MyStrLangLexer(new ANTLRFileStream(codeFile));
    				MyStrLangParser parser = new MyStrLangParser(new CommonTokenStream(lexer));
    				parser.setTemplateLib(templateGroup);
    				RuleReturnScope returnScope = parser.program();
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
    					FileWriter out = new FileWriter(programName + ".j");
    					out.write(returnScope.getTemplate().toString());
    					out.close();
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
        /** variable to store the name of current block*/
        	List global_variables;
        /** list of globals variables */
        	List functions;
        /** list of function */;
    }
    protected Stack program_stack = new Stack();

    public static class program_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "program"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:103:1: program : ( global_variables )* ( delegates )* ( functions )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName);
    public final MyStrLangParser.program_return program() throws RecognitionException {
        program_stack.push(new program_scope());
        MyStrLangParser.program_return retval = new MyStrLangParser.program_return();
        retval.start = input.LT(1);

        MyStrLangParser.delegates_return delegates1 = null;

        MyStrLangParser.functions_return functions2 = null;

        MyStrLangParser.mainBlock_return mainBlock3 = null;



        	((program_scope)program_stack.peek()).curBlock = "";
        	((program_scope)program_stack.peek()).global_variables = new ArrayList();
        	((program_scope)program_stack.peek()).functions = new ArrayList();
        	counter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:2: ( ( global_variables )* ( delegates )* ( functions )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:4: ( global_variables )* ( delegates )* ( functions )* mainBlock EOF
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:4: ( global_variables )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 49:
                    {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=49 && LA1_6<=51)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 50:
                    {
                    int LA1_3 = input.LA(2);

                    if ( (LA1_3==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=49 && LA1_6<=51)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 51:
                    {
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=49 && LA1_6<=51)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 13:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:4: global_variables
            	    {
            	    pushFollow(FOLLOW_global_variables_in_program64);
            	    global_variables();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:22: ( delegates )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:23: delegates
            	    {
            	    pushFollow(FOLLOW_delegates_in_program68);
            	    delegates1=delegates();

            	    state._fsp--;

            	    ((program_scope)program_stack.peek()).functions.add((delegates1!=null?delegates1.st:null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:77: ( functions )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID||(LA3_0>=49 && LA3_0<=52)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:78: functions
            	    {
            	    pushFollow(FOLLOW_functions_in_program75);
            	    functions2=functions();

            	    state._fsp--;

            	    ((program_scope)program_stack.peek()).functions.add((functions2!=null?functions2.st:null));

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            ((program_scope)program_stack.peek()).curBlock ="main";
            pushFollow(FOLLOW_mainBlock_in_program87);
            mainBlock3=mainBlock();

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_program89); 


            // TEMPLATE REWRITE
            // 118:3: -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName)
            {
                retval.st = templateLib.getInstanceOf("program",
              new STAttrMap().put("global_variables", ((program_scope)program_stack.peek()).global_variables).put("functions", ((program_scope)program_stack.peek()).functions).put("program", (mainBlock3!=null?mainBlock3.st:null)).put("programName", programName));
            }


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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:121:1: mainBlock : 'main' '{' block '}' -> mainBlock(block=$block.stList);
    public final MyStrLangParser.mainBlock_return mainBlock() throws RecognitionException {
        MyStrLangParser.mainBlock_return retval = new MyStrLangParser.mainBlock_return();
        retval.start = input.LT(1);

        MyStrLangParser.block_return block4 = null;



        	//counter = 0;
        	labelCounter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:127:2: ( 'main' '{' block '}' -> mainBlock(block=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:127:4: 'main' '{' block '}'
            {
            match(input,10,FOLLOW_10_in_mainBlock133); 
            match(input,11,FOLLOW_11_in_mainBlock135); 
            pushFollow(FOLLOW_block_in_mainBlock137);
            block4=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_mainBlock139); 


            // TEMPLATE REWRITE
            // 128:3: -> mainBlock(block=$block.stList)
            {
                retval.st = templateLib.getInstanceOf("mainBlock",
              new STAttrMap().put("block", (block4!=null?block4.stList:null)));
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
    // $ANTLR end "mainBlock"

    public static class global_variables_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "global_variables"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:135:1: global_variables : ( global_declaration )* ';' ;
    public final MyStrLangParser.global_variables_return global_variables() throws RecognitionException {
        MyStrLangParser.global_variables_return retval = new MyStrLangParser.global_variables_return();
        retval.start = input.LT(1);

        MyStrLangParser.global_declaration_return global_declaration5 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:136:2: ( ( global_declaration )* ';' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:136:4: ( global_declaration )* ';'
            {
             ((program_scope)program_stack.peek()).curBlock = "global";
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:136:38: ( global_declaration )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=49 && LA4_0<=51)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:136:39: global_declaration
            	    {
            	    pushFollow(FOLLOW_global_declaration_in_global_variables167);
            	    global_declaration5=global_declaration();

            	    state._fsp--;

            	    ((program_scope)program_stack.peek()).global_variables.add((global_declaration5!=null?global_declaration5.st:null));

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_global_variables173); 

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
    // $ANTLR end "global_variables"

    public static class global_declaration_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "global_declaration"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:142:1: global_declaration : type ID -> global_declaration(ident=$ID.texttype=$type.st);
    public final MyStrLangParser.global_declaration_return global_declaration() throws RecognitionException {
        MyStrLangParser.global_declaration_return retval = new MyStrLangParser.global_declaration_return();
        retval.start = input.LT(1);

        Token ID6=null;
        MyStrLangParser.type_return type7 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:143:2: ( type ID -> global_declaration(ident=$ID.texttype=$type.st))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:143:4: type ID
            {
            pushFollow(FOLLOW_type_in_global_declaration187);
            type7=type();

            state._fsp--;

            ID6=(Token)match(input,ID,FOLLOW_ID_in_global_declaration189); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID6!=null?ID6.getText():null)))
            		{
            			NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID6!=null?ID6.getText():null), (type7!=null?input.toString(type7.start,type7.stop):null), (ID6!=null?ID6.getLine():0));
            			var.setNumber(counter);
            			names.addVariable(var);
            			counter++;
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID6!=null?ID6.getText():null)))
            				errors.add("line "+(ID6!=null?ID6.getLine():0)+": Duplicate variable name "+(ID6!=null?ID6.getText():null));
            		}
            	


            // TEMPLATE REWRITE
            // 159:2: -> global_declaration(ident=$ID.texttype=$type.st)
            {
                retval.st = templateLib.getInstanceOf("global_declaration",
              new STAttrMap().put("ident", (ID6!=null?ID6.getText():null)).put("type", (type7!=null?type7.st:null)));
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
    // $ANTLR end "global_declaration"

    protected static class functions_scope {
        String funcName;
        String funcType;
        ArrayList<String> funcArgNames;
        ArrayList<String> funcArgTypes;
        String returnVariable;
        boolean isReturnUsed;
    }
    protected Stack functions_stack = new Stack();

    public static class functions_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "functions"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:166:1: functions : type_func ID '(' arg_list ')' '{' block '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList);
    public final MyStrLangParser.functions_return functions() throws RecognitionException {
        functions_stack.push(new functions_scope());
        MyStrLangParser.functions_return retval = new MyStrLangParser.functions_return();
        retval.start = input.LT(1);

        Token ID9=null;
        MyStrLangParser.type_func_return type_func8 = null;

        MyStrLangParser.arg_list_return arg_list10 = null;

        MyStrLangParser.block_return block11 = null;



        	((functions_scope)functions_stack.peek()).funcName = "";
        	((functions_scope)functions_stack.peek()).funcType = "";
        	((functions_scope)functions_stack.peek()).funcArgNames = new ArrayList<String>();
        	((functions_scope)functions_stack.peek()).funcArgTypes = new ArrayList<String>();
        	labelCounter = 0;
        	//counter=0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:183:2: ( type_func ID '(' arg_list ')' '{' block '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:183:4: type_func ID '(' arg_list ')' '{' block '}'
            {
            pushFollow(FOLLOW_type_func_in_functions230);
            type_func8=type_func();

            state._fsp--;

            ((functions_scope)functions_stack.peek()).funcType = (type_func8!=null?input.toString(type_func8.start,type_func8.stop):null); _funcType = (type_func8!=null?input.toString(type_func8.start,type_func8.stop):null); 
            ID9=(Token)match(input,ID,FOLLOW_ID_in_functions237); 
            ((program_scope)program_stack.peek()).curBlock = (ID9!=null?ID9.getText():null); ((functions_scope)functions_stack.peek()).funcName =(ID9!=null?ID9.getText():null); _funcName = (ID9!=null?ID9.getText():null);
            match(input,14,FOLLOW_14_in_functions242); 
            pushFollow(FOLLOW_arg_list_in_functions244);
            arg_list10=arg_list();

            state._fsp--;

            match(input,15,FOLLOW_15_in_functions246); 

            		if(!names.isExistFunction((ID9!=null?ID9.getText():null)))
            		{
            			names.addFunction(names.new FunctionName((ID9!=null?ID9.getText():null), (type_func8!=null?input.toString(type_func8.start,type_func8.stop):null), ((functions_scope)functions_stack.peek()).funcArgTypes, ((functions_scope)functions_stack.peek()).funcArgNames, (ID9!=null?ID9.getLine():0)));
            		}
            		else
            		{
            			errors.add("line "+(ID9!=null?ID9.getLine():0)+": Duplicated declaration function "+(ID9!=null?ID9.getText():null));
            		}
            	
            match(input,11,FOLLOW_11_in_functions254); 
            pushFollow(FOLLOW_block_in_functions259);
            block11=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_functions262); 


            // TEMPLATE REWRITE
            // 200:2: -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList)
            {
                retval.st = templateLib.getInstanceOf("functions",
              new STAttrMap().put("type", (type_func8!=null?type_func8.st:null)).put("ident", (ID9!=null?ID9.getText():null)).put("args", (arg_list10!=null?arg_list10.stList:null)).put("returnType", (type_func8!=null?type_func8.returnType:null)).put("block", (block11!=null?block11.stList:null)));
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            functions_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "functions"

    public static class arg_list_return extends ParserRuleReturnScope {
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "arg_list"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:207:1: arg_list returns [List<StringTemplate> stList] : (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? ;
    public final MyStrLangParser.arg_list_return arg_list() throws RecognitionException {
        MyStrLangParser.arg_list_return retval = new MyStrLangParser.arg_list_return();
        retval.start = input.LT(1);

        Token firstId=null;
        Token secondId=null;
        MyStrLangParser.type_return firstType = null;

        MyStrLangParser.type_return secondType = null;



        	retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:211:2: ( (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:211:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:211:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=49 && LA6_0<=51)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:212:3: firstType= type firstId= ID ( ',' secondType= type secondId= ID )*
                    {
                    pushFollow(FOLLOW_type_in_arg_list318);
                    firstType=type();

                    state._fsp--;

                    firstId=(Token)match(input,ID,FOLLOW_ID_in_arg_list322); 

                    			((functions_scope)functions_stack.peek()).funcArgTypes.add((firstType!=null?input.toString(firstType.start,firstType.stop):null));
                    			((functions_scope)functions_stack.peek()).funcArgNames.add((firstId!=null?firstId.getText():null));
                    			if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(firstId!=null?firstId.getText():null)))
                    			{
                    				NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(firstId!=null?firstId.getText():null), (firstType!=null?input.toString(firstType.start,firstType.stop):null), (firstId!=null?firstId.getLine():0));
                    				var.setNumber(counter);
                    				names.addVariable(var);
                    				retval.stList.add(templateLib.getInstanceOf("parameter",
                      new STAttrMap().put("type", (firstType!=null?firstType.st:null)).put("ident", (firstId!=null?firstId.getText():null))));
                    				counter++;
                    			}
                    			else
                    			{
                    				errors.add("line "+(firstId!=null?firstId.getLine():0)+": Duplicated variable name "+(firstId!=null?firstId.getText():null));
                    			}
                    		
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:229:4: ( ',' secondType= type secondId= ID )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:229:5: ',' secondType= type secondId= ID
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_list332); 
                    	    pushFollow(FOLLOW_type_in_arg_list336);
                    	    secondType=type();

                    	    state._fsp--;

                    	    secondId=(Token)match(input,ID,FOLLOW_ID_in_arg_list340); 

                    	     			((functions_scope)functions_stack.peek()).funcArgTypes.add((secondType!=null?input.toString(secondType.start,secondType.stop):null));
                    	    			((functions_scope)functions_stack.peek()).funcArgNames.add((secondId!=null?secondId.getText():null));
                    	    			if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(secondId!=null?secondId.getText():null)))
                    	    			{
                    	    				NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(secondId!=null?secondId.getText():null), (secondType!=null?input.toString(secondType.start,secondType.stop):null), (secondId!=null?secondId.getLine():0));
                    	    				var.setNumber(counter); 
                    	    				names.addVariable(var);
                    	    				counter++;
                    	    				retval.stList.add(templateLib.getInstanceOf("parameter",
                    	      new STAttrMap().put("type", (secondType!=null?secondType.st:null)).put("ident", (secondId!=null?secondId.getText():null))));
                    	    			}
                    	    			else
                    	    			{
                    	    				errors.add("line "+(secondId!=null?secondId.getLine():0)+": Duplicated variable name "+(secondId!=null?secondId.getText():null));
                    	    			}
                    	    		

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


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
    // $ANTLR end "arg_list"

    protected static class delegates_scope {
        String delName;
        String delType;
        ArrayList<String> delArgNames;
        ArrayList<String> delArgTypes;
        String returnVariable;
        boolean isReturnUsed;
    }
    protected Stack delegates_stack = new Stack();

    public static class delegates_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "delegates"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:254:1: delegates : 'delegate' nameDelegate= ID '{' type_func nameFunc= ID '(' arg_del ')' ';' '}' ;
    public final MyStrLangParser.delegates_return delegates() throws RecognitionException {
        delegates_stack.push(new delegates_scope());
        MyStrLangParser.delegates_return retval = new MyStrLangParser.delegates_return();
        retval.start = input.LT(1);

        Token nameDelegate=null;
        Token nameFunc=null;
        MyStrLangParser.type_func_return type_func12 = null;



          ((delegates_scope)delegates_stack.peek()).delName = "";
          ((delegates_scope)delegates_stack.peek()).delType = "";
          ((delegates_scope)delegates_stack.peek()).delArgNames = new ArrayList<String>();
          ((delegates_scope)delegates_stack.peek()).delArgTypes = new ArrayList<String>();
          labelCounter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:270:2: ( 'delegate' nameDelegate= ID '{' type_func nameFunc= ID '(' arg_del ')' ';' '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:270:4: 'delegate' nameDelegate= ID '{' type_func nameFunc= ID '(' arg_del ')' ';' '}'
            {
            match(input,17,FOLLOW_17_in_delegates378); 
            nameDelegate=(Token)match(input,ID,FOLLOW_ID_in_delegates382); 
            match(input,11,FOLLOW_11_in_delegates384); 
            pushFollow(FOLLOW_type_func_in_delegates387);
            type_func12=type_func();

            state._fsp--;

            ((delegates_scope)delegates_stack.peek()).delType = (type_func12!=null?input.toString(type_func12.start,type_func12.stop):null); _funcType = (type_func12!=null?input.toString(type_func12.start,type_func12.stop):null); 
            nameFunc=(Token)match(input,ID,FOLLOW_ID_in_delegates414); 
            ((program_scope)program_stack.peek()).curBlock = (nameDelegate!=null?nameDelegate.getText():null); ((delegates_scope)delegates_stack.peek()).delName =(nameFunc!=null?nameFunc.getText():null); 
            match(input,14,FOLLOW_14_in_delegates421); 
            ((program_scope)program_stack.peek()).curBlock =(nameDelegate!=null?nameDelegate.getText():null);
            pushFollow(FOLLOW_arg_del_in_delegates425);
            arg_del();

            state._fsp--;

            match(input,15,FOLLOW_15_in_delegates427); 
            match(input,13,FOLLOW_13_in_delegates429); 

            	    if(!names.isExistDelegate((nameDelegate!=null?nameDelegate.getText():null)))
            	    {
            	      names.addDelegate(names.new DelegateName((nameDelegate!=null?nameDelegate.getText():null), (nameDelegate!=null?nameDelegate.getText():null)+(nameFunc!=null?nameFunc.getText():null), (type_func12!=null?input.toString(type_func12.start,type_func12.stop):null), ((delegates_scope)delegates_stack.peek()).delArgTypes, ((delegates_scope)delegates_stack.peek()).delArgNames, (nameDelegate!=null?nameDelegate.getLine():0)));
            	      names.addFunction(names.new FunctionName((nameDelegate!=null?nameDelegate.getText():null)+(nameFunc!=null?nameFunc.getText():null), (type_func12!=null?input.toString(type_func12.start,type_func12.stop):null), ((delegates_scope)delegates_stack.peek()).delArgTypes, ((delegates_scope)delegates_stack.peek()).delArgNames, (nameDelegate!=null?nameDelegate.getLine():0)));
            	    }
            	    else
            	    {
            	      errors.add("line "+(nameDelegate!=null?nameDelegate.getLine():0)+": Duplicated declaration delegate "+(nameDelegate!=null?nameDelegate.getText():null));
            	    }
            	  
            match(input,12,FOLLOW_12_in_delegates443); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            delegates_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "delegates"

    public static class arg_del_return extends ParserRuleReturnScope {
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "arg_del"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:292:1: arg_del returns [List<StringTemplate> stList] : (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? ;
    public final MyStrLangParser.arg_del_return arg_del() throws RecognitionException {
        MyStrLangParser.arg_del_return retval = new MyStrLangParser.arg_del_return();
        retval.start = input.LT(1);

        Token firstId=null;
        Token secondId=null;
        MyStrLangParser.type_return firstType = null;

        MyStrLangParser.type_return secondType = null;



          retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:296:3: ( (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:296:5: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:296:5: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=49 && LA8_0<=51)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:297:5: firstType= type firstId= ID ( ',' secondType= type secondId= ID )*
                    {
                    pushFollow(FOLLOW_type_in_arg_del473);
                    firstType=type();

                    state._fsp--;

                    firstId=(Token)match(input,ID,FOLLOW_ID_in_arg_del477); 

                          ((delegates_scope)delegates_stack.peek()).delArgTypes.add((firstType!=null?input.toString(firstType.start,firstType.stop):null));
                          ((delegates_scope)delegates_stack.peek()).delArgNames.add((firstId!=null?firstId.getText():null));
                          if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(firstId!=null?firstId.getText():null)))
                          {
                            NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(firstId!=null?firstId.getText():null), (firstType!=null?input.toString(firstType.start,firstType.stop):null), (firstId!=null?firstId.getLine():0));
                            var.setNumber(counter);
                            names.addVariable(var);
                            retval.stList.add(templateLib.getInstanceOf("parameter",
                      new STAttrMap().put("type", (firstType!=null?firstType.st:null)).put("ident", (firstId!=null?firstId.getText():null))));
                            counter++;
                          }
                          else
                          {
                            errors.add("line "+(firstId!=null?firstId.getLine():0)+": Duplicated variable name "+(firstId!=null?firstId.getText():null));
                          }
                        
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:314:5: ( ',' secondType= type secondId= ID )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:314:6: ',' secondType= type secondId= ID
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_del490); 
                    	    pushFollow(FOLLOW_type_in_arg_del494);
                    	    secondType=type();

                    	    state._fsp--;

                    	    secondId=(Token)match(input,ID,FOLLOW_ID_in_arg_del498); 

                    	          ((delegates_scope)delegates_stack.peek()).delArgTypes.add((secondType!=null?input.toString(secondType.start,secondType.stop):null));
                    	          ((delegates_scope)delegates_stack.peek()).delArgNames.add((secondId!=null?secondId.getText():null));
                    	          if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(secondId!=null?secondId.getText():null)))
                    	          {
                    	            NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(secondId!=null?secondId.getText():null), (secondType!=null?input.toString(secondType.start,secondType.stop):null), (secondId!=null?secondId.getLine():0));
                    	            var.setNumber(counter); 
                    	            names.addVariable(var);
                    	            counter++;
                    	            retval.stList.add(templateLib.getInstanceOf("parameter",
                    	      new STAttrMap().put("type", (secondType!=null?secondType.st:null)).put("ident", (secondId!=null?secondId.getText():null))));
                    	          }
                    	          else
                    	          {
                    	            errors.add("line "+(secondId!=null?secondId.getLine():0)+": Duplicated variable name "+(secondId!=null?secondId.getText():null));
                    	          }
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


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
    // $ANTLR end "arg_del"

    public static class block_return extends ParserRuleReturnScope {
        public List<StringTemplate> stList;
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "block"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:339:1: block returns [List<StringTemplate> stList, String type] : ( statements )* ( return_stmt ) ;
    public final MyStrLangParser.block_return block() throws RecognitionException {
        MyStrLangParser.block_return retval = new MyStrLangParser.block_return();
        retval.start = input.LT(1);

        MyStrLangParser.statements_return statements13 = null;

        MyStrLangParser.return_stmt_return return_stmt14 = null;



        	retval.stList = new ArrayList<StringTemplate>();
        	retval.type = "void";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:344:2: ( ( statements )* ( return_stmt ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:344:4: ( statements )* ( return_stmt )
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:344:4: ( statements )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ID||(LA9_0>=24 && LA9_0<=26)||(LA9_0>=28 && LA9_0<=29)||(LA9_0>=49 && LA9_0<=51)||LA9_0==53) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:344:5: statements
            	    {
            	    pushFollow(FOLLOW_statements_in_block545);
            	    statements13=statements();

            	    state._fsp--;

            	    retval.stList.add((statements13!=null?statements13.st:null));

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:344:49: ( return_stmt )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:344:50: return_stmt
            {
            pushFollow(FOLLOW_return_stmt_in_block552);
            return_stmt14=return_stmt();

            state._fsp--;

            retval.stList.add((return_stmt14!=null?return_stmt14.st:null)); retval.type =(return_stmt14!=null?return_stmt14.type:null);

            }

            		
            			if(((program_scope)program_stack.peek()).curBlock!="main"){
            			  String name = ((program_scope)program_stack.peek()).curBlock;
            			  if(names.isExistFunction(name)){
            					NamesTable.FunctionName func = names.getFunction(name);
            					String _type = func.getReturnType();
            					if((return_stmt14!=null?return_stmt14.value:null)==null)
            					{
            						if(!_type.equals("void"))
            							errors.add("line "+(return_stmt14!=null?return_stmt14.line:0)+": Not found the keyword return in function with name "+name);
            					}
            				}
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
    // $ANTLR end "block"

    public static class statements_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "statements"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:364:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st} | call_delegate ';' -> {$call_delegate.st});
    public final MyStrLangParser.statements_return statements() throws RecognitionException {
        MyStrLangParser.statements_return retval = new MyStrLangParser.statements_return();
        retval.start = input.LT(1);

        MyStrLangParser.assign_stmt_return assign_stmt15 = null;

        MyStrLangParser.decl_stmt_return decl_stmt16 = null;

        MyStrLangParser.write_stmt_return write_stmt17 = null;

        MyStrLangParser.read_strm_return read_strm18 = null;

        MyStrLangParser.if_stmt_return if_stmt19 = null;

        MyStrLangParser.for_stmt_return for_stmt20 = null;

        MyStrLangParser.while_stmt_return while_stmt21 = null;

        MyStrLangParser.call_func_stmt_return call_func_stmt22 = null;

        MyStrLangParser.call_delegate_return call_delegate23 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:365:2: ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st} | call_delegate ';' -> {$call_delegate.st})
            int alt10=9;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:365:5: assign_stmt ';'
                    {
                    pushFollow(FOLLOW_assign_stmt_in_statements573);
                    assign_stmt15=assign_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements575); 


                    // TEMPLATE REWRITE
                    // 365:21: -> {$assign_stmt.st}
                    {
                        retval.st = (assign_stmt15!=null?assign_stmt15.st:null);
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:366:5: decl_stmt ';'
                    {
                    pushFollow(FOLLOW_decl_stmt_in_statements585);
                    decl_stmt16=decl_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements587); 


                    // TEMPLATE REWRITE
                    // 366:19: -> {$decl_stmt.st}
                    {
                        retval.st = (decl_stmt16!=null?decl_stmt16.st:null);
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:367:5: write_stmt ';'
                    {
                    pushFollow(FOLLOW_write_stmt_in_statements597);
                    write_stmt17=write_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements599); 


                    // TEMPLATE REWRITE
                    // 367:20: -> {$write_stmt.st}
                    {
                        retval.st = (write_stmt17!=null?write_stmt17.st:null);
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:368:5: read_strm ';'
                    {
                    pushFollow(FOLLOW_read_strm_in_statements609);
                    read_strm18=read_strm();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements611); 


                    // TEMPLATE REWRITE
                    // 368:19: -> {$read_strm.st}
                    {
                        retval.st = (read_strm18!=null?read_strm18.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:369:5: if_stmt
                    {
                    pushFollow(FOLLOW_if_stmt_in_statements621);
                    if_stmt19=if_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 369:13: -> {$if_stmt.st}
                    {
                        retval.st = (if_stmt19!=null?if_stmt19.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:370:5: for_stmt
                    {
                    pushFollow(FOLLOW_for_stmt_in_statements631);
                    for_stmt20=for_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 370:14: -> {$for_stmt.st}
                    {
                        retval.st = (for_stmt20!=null?for_stmt20.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:371:5: while_stmt
                    {
                    pushFollow(FOLLOW_while_stmt_in_statements641);
                    while_stmt21=while_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 371:16: -> {$while_stmt.st}
                    {
                        retval.st = (while_stmt21!=null?while_stmt21.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:372:5: call_func_stmt ';'
                    {
                    pushFollow(FOLLOW_call_func_stmt_in_statements651);
                    call_func_stmt22=call_func_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements653); 


                    // TEMPLATE REWRITE
                    // 372:24: -> {$call_func_stmt.st}
                    {
                        retval.st = (call_func_stmt22!=null?call_func_stmt22.st:null);
                    }


                    }
                    break;
                case 9 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:373:5: call_delegate ';'
                    {
                    pushFollow(FOLLOW_call_delegate_in_statements667);
                    call_delegate23=call_delegate();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements669); 


                    // TEMPLATE REWRITE
                    // 373:33: -> {$call_delegate.st}
                    {
                        retval.st = (call_delegate23!=null?call_delegate23.st:null);
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
    // $ANTLR end "statements"

    public static class assign_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "assign_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:379:1: assign_stmt : ID '=' ( expr | call_delegate ) ;
    public final MyStrLangParser.assign_stmt_return assign_stmt() throws RecognitionException {
        MyStrLangParser.assign_stmt_return retval = new MyStrLangParser.assign_stmt_return();
        retval.start = input.LT(1);

        Token ID24=null;
        MyStrLangParser.expr_return expr25 = null;

        MyStrLangParser.call_delegate_return call_delegate26 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:380:2: ( ID '=' ( expr | call_delegate ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:380:4: ID '=' ( expr | call_delegate )
            {
            ID24=(Token)match(input,ID,FOLLOW_ID_in_assign_stmt697); 
            match(input,18,FOLLOW_18_in_assign_stmt699); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:380:11: ( expr | call_delegate )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=ID && LA11_0<=CHAR)||(LA11_0>=31 && LA11_0<=33)||(LA11_0>=45 && LA11_0<=48)) ) {
                alt11=1;
            }
            else if ( (LA11_0==53) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:380:12: expr
                    {
                    pushFollow(FOLLOW_expr_in_assign_stmt702);
                    expr25=expr();

                    state._fsp--;


                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID24!=null?ID24.getText():null)))
                    		{
                    			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID24!=null?ID24.getText():null));
                    			//get type of variable
                    			String varType = var_type.getType();
                    			//check for match types
                    			if(!TypesChecker.checkTypes(varType, (expr25!=null?expr25.type:null)))
                    			{
                    				  errors.add("line "+(ID24!=null?ID24.getLine():0)+": Type mismatch: cannot convert from "+varType+" to "+(expr25!=null?expr25.type:null));
                    			}
                    			if(TypesChecker.isInteger(varType))
                    			{
                    				if(names.isGlobal((ID24!=null?ID24.getText():null))){
                    					retval.st = templateLib.getInstanceOf("assign_field_int",
                      new STAttrMap().put("expression", (expr25!=null?expr25.st:null)).put("programName", programName).put("fieldName", (ID24!=null?ID24.getText():null)));
                    				} 
                    				else{
                    					retval.st = templateLib.getInstanceOf("assign_var_int",
                      new STAttrMap().put("expression", (expr25!=null?expr25.st:null)).put("counter", var_type.getNumber()));
                    				}
                    			}
                    			if(TypesChecker.isString(varType))
                    			{
                    				if(names.isGlobal((ID24!=null?ID24.getText():null))){
                    					retval.st = templateLib.getInstanceOf("assign_field_string",
                      new STAttrMap().put("expression", (expr25!=null?expr25.st:null)).put("programName", programName).put("fieldName", (ID24!=null?ID24.getText():null)));
                    				} 
                    				else{
                    					retval.st = templateLib.getInstanceOf("assign_var_string",
                      new STAttrMap().put("expression", (expr25!=null?expr25.st:null)).put("counter", var_type.getNumber()));
                    				}
                    			}
                    			if(TypesChecker.isChar(varType))
                    			{
                    				if(names.isGlobal((ID24!=null?ID24.getText():null))){
                    					retval.st = templateLib.getInstanceOf("assign_field_char",
                      new STAttrMap().put("expression", (expr25!=null?expr25.st:null)).put("programName", programName).put("fieldName", (ID24!=null?ID24.getText():null)));
                    				} 
                    				else{
                    					retval.st = templateLib.getInstanceOf("assign_var_char",
                      new STAttrMap().put("expression", (expr25!=null?expr25.st:null)).put("counter", var_type.getNumber()));
                    				}
                    			}
                    			
                    		}
                    		else{
                            errors.add("line "+(ID24!=null?ID24.getLine():0)+": unknown variable "+(ID24!=null?ID24.getText():null));
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:425:4: call_delegate
                    {
                    pushFollow(FOLLOW_call_delegate_in_assign_stmt710);
                    call_delegate26=call_delegate();

                    state._fsp--;


                    	  NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID24!=null?ID24.getText():null));
                        String varType = var_type.getType();
                        if(!TypesChecker.checkTypes(varType, (call_delegate26!=null?call_delegate26.type:null)))
                          errors.add("line "+(ID24!=null?ID24.getLine():0)+": Type mismatch: cannot convert from "+varType+" to "+(call_delegate26!=null?call_delegate26.type:null));
                        if(TypesChecker.isInteger(varType))
                        {
                          if(names.isGlobal((ID24!=null?ID24.getText():null))){
                            retval.st = templateLib.getInstanceOf("assign_field_int",
                      new STAttrMap().put("expression", (call_delegate26!=null?call_delegate26.stList:null)).put("programName", programName).put("fieldName", (ID24!=null?ID24.getText():null)));
                          } 
                          else{
                            retval.st = templateLib.getInstanceOf("assign_var_int",
                      new STAttrMap().put("expression", (call_delegate26!=null?call_delegate26.stList:null)).put("counter", var_type.getNumber()));
                          }
                        }
                        if(TypesChecker.isString(varType))
                        {
                          if(names.isGlobal((ID24!=null?ID24.getText():null))){
                            retval.st = templateLib.getInstanceOf("assign_field_string",
                      new STAttrMap().put("expression", (call_delegate26!=null?call_delegate26.stList:null)).put("programName", programName).put("fieldName", (ID24!=null?ID24.getText():null)));
                          } 
                          else{
                            retval.st = templateLib.getInstanceOf("assign_var_string",
                      new STAttrMap().put("expression", (call_delegate26!=null?call_delegate26.stList:null)).put("counter", var_type.getNumber()));
                          }
                        }
                        if(TypesChecker.isChar(varType))
                        {
                          if(names.isGlobal((ID24!=null?ID24.getText():null))){
                            retval.st = templateLib.getInstanceOf("assign_field_char",
                      new STAttrMap().put("expression", (call_delegate26!=null?call_delegate26.stList:null)).put("programName", programName).put("fieldName", (ID24!=null?ID24.getText():null)));
                          } 
                          else{
                            retval.st = templateLib.getInstanceOf("assign_var_char",
                      new STAttrMap().put("expression", (call_delegate26!=null?call_delegate26.stList:null)).put("counter", var_type.getNumber()));
                          }
                        }
                    	

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
    // $ANTLR end "assign_stmt"

    public static class expr_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "expr"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:465:1: expr returns [String type] : firstAssign= mult ( (op= '+' | op= '-' ) secondAssign= expr )? ;
    public final MyStrLangParser.expr_return expr() throws RecognitionException {
        MyStrLangParser.expr_return retval = new MyStrLangParser.expr_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.mult_return firstAssign = null;

        MyStrLangParser.expr_return secondAssign = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:466:2: (firstAssign= mult ( (op= '+' | op= '-' ) secondAssign= expr )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:467:3: firstAssign= mult ( (op= '+' | op= '-' ) secondAssign= expr )?
            {
            pushFollow(FOLLOW_mult_in_expr737);
            firstAssign=mult();

            state._fsp--;


            			retval.type = (firstAssign!=null?firstAssign.type:null);
            			retval.st = (firstAssign!=null?firstAssign.st:null);
            		
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:472:3: ( (op= '+' | op= '-' ) secondAssign= expr )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=19 && LA13_0<=20)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:473:4: (op= '+' | op= '-' ) secondAssign= expr
                    {
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:473:4: (op= '+' | op= '-' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==19) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==20) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:473:5: op= '+'
                            {
                            op=(Token)match(input,19,FOLLOW_19_in_expr753); 

                            }
                            break;
                        case 2 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:473:12: op= '-'
                            {
                            op=(Token)match(input,20,FOLLOW_20_in_expr757); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expr_in_expr762);
                    secondAssign=expr();

                    state._fsp--;


                    				retval.type = (firstAssign!=null?firstAssign.type:null);
                    				String t_1 = (secondAssign!=null?secondAssign.type:null);
                    				if(TypesChecker.isChar((secondAssign!=null?secondAssign.type:null)))
                    				{
                    					errors.add("line "+(op!=null?op.getLine():0)+": impossibly addition type of char to char");
                    				}
                    				if(!TypesChecker.checkTypes((firstAssign!=null?firstAssign.type:null), (secondAssign!=null?secondAssign.type:null)))
                    				{
                    					errors.add("line "+(op!=null?op.getLine():0)+": mismatch in math operation. Found "+(firstAssign!=null?firstAssign.type:null)+" and "+(secondAssign!=null?secondAssign.type:null));
                    				}
                    				if((op!=null?op.getText():null).equals("+"))
                    		 		{
                    				 	if(TypesChecker.isInteger((firstAssign!=null?firstAssign.type:null)) && TypesChecker.isInteger((secondAssign!=null?secondAssign.type:null))){
                    				 		retval.st = templateLib.getInstanceOf("add_int",
                      new STAttrMap().put("firstValue", (firstAssign!=null?firstAssign.st:null)).put("secondValue", (secondAssign!=null?secondAssign.st:null)));
                    				 	}
                    				 	if(TypesChecker.isString((firstAssign!=null?firstAssign.type:null)) && TypesChecker.isString((secondAssign!=null?secondAssign.type:null))){
                    				 		retval.st = templateLib.getInstanceOf("add_string",
                      new STAttrMap().put("firstValue", (firstAssign!=null?firstAssign.st:null)).put("secondValue", (secondAssign!=null?secondAssign.st:null)));
                    				 	}
                    		 		}
                    		 		if((op!=null?op.getText():null).equals("-")){
                    		 			if(TypesChecker.isInteger((firstAssign!=null?firstAssign.type:null)) && TypesChecker.isInteger((secondAssign!=null?secondAssign.type:null))){
                    		 				retval.st = templateLib.getInstanceOf("sub_int",
                      new STAttrMap().put("firstValue", (firstAssign!=null?firstAssign.st:null)).put("secondValue", (secondAssign!=null?secondAssign.st:null)));
                    		 			}
                    		 			if(TypesChecker.isString((firstAssign!=null?firstAssign.type:null)) && TypesChecker.isString((secondAssign!=null?secondAssign.type:null))){
                    				 		errors.add("line "+(op!=null?op.getLine():0)+": operation '-' is not available in type string");
                    				 	}
                    		 		}
                    					
                    			

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
    // $ANTLR end "expr"

    public static class mult_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "mult"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:511:1: mult returns [String type] : first= power ( (op= '*' | op= '/' ) second= mult )? ;
    public final MyStrLangParser.mult_return mult() throws RecognitionException {
        MyStrLangParser.mult_return retval = new MyStrLangParser.mult_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.power_return first = null;

        MyStrLangParser.mult_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:512:3: (first= power ( (op= '*' | op= '/' ) second= mult )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:512:7: first= power ( (op= '*' | op= '/' ) second= mult )?
            {
            pushFollow(FOLLOW_power_in_mult796);
            first=power();

            state._fsp--;

            retval.type =(first!=null?first.type:null); retval.st = (first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:513:7: ( (op= '*' | op= '/' ) second= mult )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=21 && LA15_0<=22)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:513:8: (op= '*' | op= '/' ) second= mult
                    {
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:513:8: (op= '*' | op= '/' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==21) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==22) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:513:9: op= '*'
                            {
                            op=(Token)match(input,21,FOLLOW_21_in_mult811); 

                            }
                            break;
                        case 2 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:513:17: op= '/'
                            {
                            op=(Token)match(input,22,FOLLOW_22_in_mult816); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_mult_in_mult821);
                    second=mult();

                    state._fsp--;


                              retval.type = (first!=null?first.type:null);
                    	        String t_1 = (second!=null?second.type:null);
                    	        if(TypesChecker.isChar((second!=null?second.type:null)))
                    	        {
                    	          errors.add("line "+(op!=null?op.getLine():0)+": this operation is not available for type char");
                    	        }
                    	        if(TypesChecker.isString((second!=null?second.type:null)))
                              {
                                errors.add("line "+(op!=null?op.getLine():0)+": this operation is not available for type string");
                              }
                    	        if(!TypesChecker.checkTypes((first!=null?first.type:null), (second!=null?second.type:null)))
                    	        {
                    	          errors.add("line "+(op!=null?op.getLine():0)+": mismatch in math operation. Found "+(first!=null?first.type:null)+" and "+(second!=null?second.type:null));
                    	        }
                    	        if((op!=null?op.getText():null).equals("*"))
                    	        {
                    	          if(TypesChecker.isInteger((first!=null?first.type:null)) && TypesChecker.isInteger((second!=null?second.type:null))){
                    	            retval.st = templateLib.getInstanceOf("condition_int",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                    	          }
                    	        }
                    	        if((op!=null?op.getText():null).equals("/")){
                    	          if(TypesChecker.isInteger((first!=null?first.type:null)) && TypesChecker.isInteger((second!=null?second.type:null))){
                    	            retval.st = templateLib.getInstanceOf("division_int",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                    	          }
                    	        }
                            

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
    // $ANTLR end "mult"

    public static class power_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "power"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:547:1: power returns [String type] : first= cast_stmt (op= '^' second= power )? ;
    public final MyStrLangParser.power_return power() throws RecognitionException {
        MyStrLangParser.power_return retval = new MyStrLangParser.power_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.cast_stmt_return first = null;

        MyStrLangParser.power_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:548:3: (first= cast_stmt (op= '^' second= power )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:548:7: first= cast_stmt (op= '^' second= power )?
            {
            pushFollow(FOLLOW_cast_stmt_in_power864);
            first=cast_stmt();

            state._fsp--;

            retval.type =(first!=null?first.type:null); retval.st =(first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:549:7: (op= '^' second= power )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==23) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:549:8: op= '^' second= power
                    {
                    op=(Token)match(input,23,FOLLOW_23_in_power877); 
                    pushFollow(FOLLOW_power_in_power881);
                    second=power();

                    state._fsp--;


                            retval.type = (first!=null?first.type:null);
                              String t_1 = (second!=null?second.type:null);
                              if(TypesChecker.isChar((second!=null?second.type:null)))
                              {
                                errors.add("line "+(op!=null?op.getLine():0)+": this operation is not available for type char");
                              }
                              if(TypesChecker.isString((second!=null?second.type:null)))
                              {
                                errors.add("line "+(op!=null?op.getLine():0)+": this operation is not available for type string");
                              }
                              if(!TypesChecker.checkTypes((first!=null?first.type:null), (second!=null?second.type:null)))
                              {
                                errors.add("line "+(op!=null?op.getLine():0)+": mismatch in math operation. Found "+(first!=null?first.type:null)+" and "+(second!=null?second.type:null));
                              }
                              if((op!=null?op.getText():null).equals("^")){
                                if(TypesChecker.isInteger((first!=null?first.type:null)) && TypesChecker.isInteger((second!=null?second.type:null))){
                                  retval.st = templateLib.getInstanceOf("power_int",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                }
                              }
                          

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
    // $ANTLR end "power"

    public static class cast_stmt_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "cast_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:574:1: cast_stmt returns [String type] : atom ;
    public final MyStrLangParser.cast_stmt_return cast_stmt() throws RecognitionException {
        MyStrLangParser.cast_stmt_return retval = new MyStrLangParser.cast_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return atom27 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:575:3: ( atom )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:575:7: atom
            {
            pushFollow(FOLLOW_atom_in_cast_stmt918);
            atom27=atom();

            state._fsp--;

            retval.type = (atom27!=null?atom27.type:null); retval.st = (atom27!=null?atom27.st:null);

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
    // $ANTLR end "cast_stmt"

    public static class decl_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "decl_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:583:1: decl_stmt : type ID ( '=' ( expr | call_delegate ) )? ;
    public final MyStrLangParser.decl_stmt_return decl_stmt() throws RecognitionException {
        MyStrLangParser.decl_stmt_return retval = new MyStrLangParser.decl_stmt_return();
        retval.start = input.LT(1);

        Token ID28=null;
        MyStrLangParser.type_return type29 = null;

        MyStrLangParser.expr_return expr30 = null;

        MyStrLangParser.call_delegate_return call_delegate31 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:584:2: ( type ID ( '=' ( expr | call_delegate ) )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:584:4: type ID ( '=' ( expr | call_delegate ) )?
            {
            pushFollow(FOLLOW_type_in_decl_stmt938);
            type29=type();

            state._fsp--;

            ID28=(Token)match(input,ID,FOLLOW_ID_in_decl_stmt940); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID28!=null?ID28.getText():null)))
            		{
            			NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID28!=null?ID28.getText():null), (type29!=null?input.toString(type29.start,type29.stop):null), (ID28!=null?ID28.getLine():0));
            			var.setNumber(counter);
            			names.addVariable(var);
            			counter++;
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID28!=null?ID28.getText():null)))
            				errors.add("line "+(ID28!=null?ID28.getLine():0)+": Duplicated variable name "+(ID28!=null?ID28.getText():null));
            		}
            		
            		if(TypesChecker.isInteger((type29!=null?input.toString(type29.start,type29.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_int",
              new STAttrMap().put("counter", counter));
            		}
            		if(TypesChecker.isString((type29!=null?input.toString(type29.start,type29.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_string",
              new STAttrMap().put("counter", counter));
            		}
            		
            		if(TypesChecker.isChar((type29!=null?input.toString(type29.start,type29.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_char",
              new STAttrMap().put("counter", counter));
            		}
            		
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:614:2: ( '=' ( expr | call_delegate ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:614:3: '=' ( expr | call_delegate )
                    {
                    match(input,18,FOLLOW_18_in_decl_stmt947); 
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:614:7: ( expr | call_delegate )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=ID && LA17_0<=CHAR)||(LA17_0>=31 && LA17_0<=33)||(LA17_0>=45 && LA17_0<=48)) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==53) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:614:8: expr
                            {
                            pushFollow(FOLLOW_expr_in_decl_stmt950);
                            expr30=expr();

                            state._fsp--;


                            		NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID28!=null?ID28.getText():null));
                            		String varType = var_type.getType();
                            		if(!TypesChecker.checkTypes(varType, (expr30!=null?expr30.type:null)))
                            		{
                            			errors.add("line "+(ID28!=null?ID28.getLine():0)+": Type mismatch: cannot convert from "+varType+" to "+(expr30!=null?expr30.type:null));
                            		}
                            		if(TypesChecker.isInteger(varType))
                            		{
                            			if(names.isGlobal((ID28!=null?ID28.getText():null))){
                            				retval.st = templateLib.getInstanceOf("assign_field_int",
                              new STAttrMap().put("expression", (expr30!=null?expr30.st:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
                            			} 
                            			else{
                            				retval.st = templateLib.getInstanceOf("assign_var_int",
                              new STAttrMap().put("expression", (expr30!=null?expr30.st:null)).put("counter", var_type.getNumber()));
                            			}
                            		}
                            		if(TypesChecker.isString(varType))
                            		{
                            			if(names.isGlobal((ID28!=null?ID28.getText():null))){
                            				retval.st = templateLib.getInstanceOf("assign_field_string",
                              new STAttrMap().put("expression", (expr30!=null?expr30.st:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
                            			} 
                            			else{
                            				retval.st = templateLib.getInstanceOf("assign_var_string",
                              new STAttrMap().put("expression", (expr30!=null?expr30.st:null)).put("counter", var_type.getNumber()));
                            			}
                            		}
                            		if(TypesChecker.isChar(varType))
                            		{
                            			if(names.isGlobal((ID28!=null?ID28.getText():null))){
                            				retval.st = templateLib.getInstanceOf("assign_field_char",
                              new STAttrMap().put("expression", (expr30!=null?expr30.st:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
                            			} 
                            			else{
                            				retval.st = templateLib.getInstanceOf("assign_var_char",
                              new STAttrMap().put("expression", (expr30!=null?expr30.st:null)).put("counter", var_type.getNumber()));
                            			}
                            		}
                            			
                            	

                            }
                            break;
                        case 2 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:651:4: call_delegate
                            {
                            pushFollow(FOLLOW_call_delegate_in_decl_stmt958);
                            call_delegate31=call_delegate();

                            state._fsp--;


                            	  NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID28!=null?ID28.getText():null));
                                String varType = var_type.getType();
                            	  if(!TypesChecker.checkTypes((type29!=null?input.toString(type29.start,type29.stop):null), (call_delegate31!=null?call_delegate31.type:null)))
                            	    errors.add("line "+(ID28!=null?ID28.getLine():0)+" : Type mismatch: cannot convert from "+(type29!=null?input.toString(type29.start,type29.stop):null)+" to "+(call_delegate31!=null?call_delegate31.type:null));
                            	  if(TypesChecker.isInteger(varType))
                                {
                                  if(names.isGlobal((ID28!=null?ID28.getText():null))){
                                    retval.st = templateLib.getInstanceOf("assign_field_int",
                              new STAttrMap().put("expression", (call_delegate31!=null?call_delegate31.stList:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
                                  } 
                                  else{
                                    retval.st = templateLib.getInstanceOf("assign_var_int",
                              new STAttrMap().put("expression", (call_delegate31!=null?call_delegate31.stList:null)).put("counter", var_type.getNumber()));
                                  }
                                }
                                if(TypesChecker.isString(varType))
                                {
                                  if(names.isGlobal((ID28!=null?ID28.getText():null))){
                                    retval.st = templateLib.getInstanceOf("assign_field_string",
                              new STAttrMap().put("expression", (call_delegate31!=null?call_delegate31.stList:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
                                  } 
                                  else{
                                    retval.st = templateLib.getInstanceOf("assign_var_string",
                              new STAttrMap().put("expression", (call_delegate31!=null?call_delegate31.stList:null)).put("counter", var_type.getNumber()));
                                  }
                                }
                                if(TypesChecker.isChar(varType))
                                {
                                  if(names.isGlobal((ID28!=null?ID28.getText():null))){
                                    retval.st = templateLib.getInstanceOf("assign_field_char",
                              new STAttrMap().put("expression", (call_delegate31!=null?call_delegate31.stList:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
                                  } 
                                  else{
                                    retval.st = templateLib.getInstanceOf("assign_var_char",
                              new STAttrMap().put("expression", (call_delegate31!=null?call_delegate31.stList:null)).put("counter", var_type.getNumber()));
                                  }
                                }
                            	

                            }
                            break;

                    }


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
    // $ANTLR end "decl_stmt"

    public static class write_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "write_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:688:1: write_stmt : 'write' '(' atom ')' ;
    public final MyStrLangParser.write_stmt_return write_stmt() throws RecognitionException {
        MyStrLangParser.write_stmt_return retval = new MyStrLangParser.write_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return atom32 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:690:2: ( 'write' '(' atom ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:690:4: 'write' '(' atom ')'
            {
            match(input,24,FOLLOW_24_in_write_stmt980); 
            match(input,14,FOLLOW_14_in_write_stmt982); 
            pushFollow(FOLLOW_atom_in_write_stmt984);
            atom32=atom();

            state._fsp--;

            match(input,15,FOLLOW_15_in_write_stmt986); 

            		if(TypesChecker.isInteger((atom32!=null?atom32.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_int",
              new STAttrMap().put("expression", (atom32!=null?atom32.st:null)));
            		}
            		if(TypesChecker.isString((atom32!=null?atom32.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_string",
              new STAttrMap().put("string", (atom32!=null?atom32.st:null)));
            		}
            		if(TypesChecker.isChar((atom32!=null?atom32.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_char",
              new STAttrMap().put("string", (atom32!=null?atom32.st:null)));
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
    // $ANTLR end "write_stmt"

    public static class atom_return extends ParserRuleReturnScope {
        public String text;
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "atom"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:710:1: atom returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st} | replace_firstElem -> {$replace_firstElem.st} | substring_op -> {$substring_op.st});
    public final MyStrLangParser.atom_return atom() throws RecognitionException {
        MyStrLangParser.atom_return retval = new MyStrLangParser.atom_return();
        retval.start = input.LT(1);

        Token ID33=null;
        Token INT34=null;
        Token STRING35=null;
        MyStrLangParser.char_c_return char_c36 = null;

        MyStrLangParser.call_func_return call_func37 = null;

        MyStrLangParser.length_stmt_return length_stmt38 = null;

        MyStrLangParser.elem_stmt_return elem_stmt39 = null;

        MyStrLangParser.to_string_stmt_return to_string_stmt40 = null;

        MyStrLangParser.indexOf_stmt_return indexOf_stmt41 = null;

        MyStrLangParser.replace_op_return replace_op42 = null;

        MyStrLangParser.replace_firstElem_return replace_firstElem43 = null;

        MyStrLangParser.substring_op_return substring_op44 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:711:2: ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st} | replace_firstElem -> {$replace_firstElem.st} | substring_op -> {$substring_op.st})
            int alt19=12;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:711:4: ID
                    {
                    ID33=(Token)match(input,ID,FOLLOW_ID_in_atom1007); 

                    		retval.text = (ID33!=null?ID33.getText():null);
                    		//System.out.println(((program_scope)program_stack.peek()).curBlock);
                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID33!=null?ID33.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID33!=null?ID33.getText():null));
                    			retval.type = v_type.getType();
                    			if(TypesChecker.isInteger(retval.type))
                    			{
                    				if(names.isGlobal(retval.text))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_int",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_int",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    			
                    			if(TypesChecker.isString(retval.type))
                    			{
                    				if(names.isGlobal(retval.text))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_string",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_string",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    			
                    			if(TypesChecker.isChar(retval.type))
                    			{
                    				if(names.isGlobal(retval.text))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_char",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_char",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    			
                    		}
                    		else
                    		{
                    			errors.add("line "+(ID33!=null?ID33.getLine():0)+": unknown variable "+(ID33!=null?ID33.getText():null));
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:757:4: INT
                    {
                    INT34=(Token)match(input,INT,FOLLOW_INT_in_atom1014); 
                    retval.text = (INT34!=null?INT34.getText():null); retval.type = "int"; 
                    	  if(retval.text.length()>10)
                    	    errors.add("line "+(INT34!=null?INT34.getLine():0)+": type int is out of range.");
                    	  else
                    	  {
                    		  try{
                    			  Integer numb = new Integer(retval.text);
                    			}
                    			catch(NumberFormatException e)
                    			{
                    			  errors.add("line "+(INT34!=null?INT34.getLine():0)+": type int is out of range.");
                    			}
                    		}
                    	  


                    // TEMPLATE REWRITE
                    // 770:9: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT34!=null?INT34.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:771:4: STRING
                    {
                    STRING35=(Token)match(input,STRING,FOLLOW_STRING_in_atom1033); 
                    retval.text = (STRING35!=null?STRING35.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 771:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING35!=null?STRING35.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:772:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_atom1051);
                    char_c36=char_c();

                    state._fsp--;

                    retval.type = "char";


                    // TEMPLATE REWRITE
                    // 772:33: -> {$char_c.st}
                    {
                        retval.st = (char_c36!=null?char_c36.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:773:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_atom1066);
                    call_func37=call_func();

                    state._fsp--;

                    retval.type =(call_func37!=null?call_func37.type:null);


                    // TEMPLATE REWRITE
                    // 773:40: -> {$call_func.st}
                    {
                        retval.st = (call_func37!=null?call_func37.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:774:4: length_stmt
                    {
                    pushFollow(FOLLOW_length_stmt_in_atom1078);
                    length_stmt38=length_stmt();

                    state._fsp--;

                    retval.type ="int";


                    // TEMPLATE REWRITE
                    // 774:33: -> {$length_stmt.st}
                    {
                        retval.st = (length_stmt38!=null?length_stmt38.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:775:4: elem_stmt
                    {
                    pushFollow(FOLLOW_elem_stmt_in_atom1091);
                    elem_stmt39=elem_stmt();

                    state._fsp--;

                    retval.type ="char";


                    // TEMPLATE REWRITE
                    // 775:32: -> {$elem_stmt.st}
                    {
                        retval.st = (elem_stmt39!=null?elem_stmt39.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:776:4: to_string_stmt
                    {
                    pushFollow(FOLLOW_to_string_stmt_in_atom1104);
                    to_string_stmt40=to_string_stmt();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 776:38: -> {$to_string_stmt.st}
                    {
                        retval.st = (to_string_stmt40!=null?to_string_stmt40.st:null);
                    }


                    }
                    break;
                case 9 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:777:4: indexOf_stmt
                    {
                    pushFollow(FOLLOW_indexOf_stmt_in_atom1116);
                    indexOf_stmt41=indexOf_stmt();

                    state._fsp--;

                    retval.type ="int";


                    // TEMPLATE REWRITE
                    // 777:34: -> {$indexOf_stmt.st}
                    {
                        retval.st = (indexOf_stmt41!=null?indexOf_stmt41.st:null);
                    }


                    }
                    break;
                case 10 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:778:4: replace_op
                    {
                    pushFollow(FOLLOW_replace_op_in_atom1129);
                    replace_op42=replace_op();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 778:35: -> {$replace_op.st}
                    {
                        retval.st = (replace_op42!=null?replace_op42.st:null);
                    }


                    }
                    break;
                case 11 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:779:4: replace_firstElem
                    {
                    pushFollow(FOLLOW_replace_firstElem_in_atom1142);
                    replace_firstElem43=replace_firstElem();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 779:40: -> {$replace_firstElem.st}
                    {
                        retval.st = (replace_firstElem43!=null?replace_firstElem43.st:null);
                    }


                    }
                    break;
                case 12 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:780:4: substring_op
                    {
                    pushFollow(FOLLOW_substring_op_in_atom1153);
                    substring_op44=substring_op();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 780:36: -> {$substring_op.st}
                    {
                        retval.st = (substring_op44!=null?substring_op44.st:null);
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
    // $ANTLR end "atom"

    public static class char_c_return extends ParserRuleReturnScope {
        public int numb;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "char_c"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:787:1: char_c returns [int numb] : CHAR -> const_char(cod=$numb);
    public final MyStrLangParser.char_c_return char_c() throws RecognitionException {
        MyStrLangParser.char_c_return retval = new MyStrLangParser.char_c_return();
        retval.start = input.LT(1);

        Token CHAR45=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:788:2: ( CHAR -> const_char(cod=$numb))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:788:4: CHAR
            {
            CHAR45=(Token)match(input,CHAR,FOLLOW_CHAR_in_char_c1177); 
            	
            			String str = (CHAR45!=null?CHAR45.getText():null);
            			char el = str.charAt(1);
            			try{
            				retval.numb = Character.toString(el).getBytes("cp1251")[0];
            			}
            			catch(UnsupportedEncodingException e)
            			{
            				e.printStackTrace();
            			}
            	


            // TEMPLATE REWRITE
            // 800:3: -> const_char(cod=$numb)
            {
                retval.st = templateLib.getInstanceOf("const_char",
              new STAttrMap().put("cod", retval.numb));
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
    // $ANTLR end "char_c"

    public static class read_strm_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "read_strm"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:803:1: read_strm : 'read' '(' ID ')' ;
    public final MyStrLangParser.read_strm_return read_strm() throws RecognitionException {
        MyStrLangParser.read_strm_return retval = new MyStrLangParser.read_strm_return();
        retval.start = input.LT(1);

        Token ID46=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:808:2: ( 'read' '(' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:808:4: 'read' '(' ID ')'
            {
            match(input,25,FOLLOW_25_in_read_strm1206); 
            match(input,14,FOLLOW_14_in_read_strm1208); 
            ID46=(Token)match(input,ID,FOLLOW_ID_in_read_strm1210); 
            match(input,15,FOLLOW_15_in_read_strm1212); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID46!=null?ID46.getText():null)))
            			errors.add("line "+(ID46!=null?ID46.getLine():0)+": unknown variable "+(ID46!=null?ID46.getText():null));
            		else{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID46!=null?ID46.getText():null));
            			String varType = var_type.getType();
            			if(TypesChecker.isInteger(varType))
            			{
            				if(names.isGlobal((ID46!=null?ID46.getText():null))){
            					retval.st = templateLib.getInstanceOf("read_field_int",
              new STAttrMap().put("programName", programName).put("fieldName", (ID46!=null?ID46.getText():null)));
            				} else
            					retval.st = templateLib.getInstanceOf("read_var_int",
              new STAttrMap().put("counter", var_type.getNumber()));
            			}
            			if(TypesChecker.isString(varType))
            			{
            				if(names.isGlobal((ID46!=null?ID46.getText():null))){
            					retval.st = templateLib.getInstanceOf("read_field_string",
              new STAttrMap().put("programName", programName).put("fieldName", (ID46!=null?ID46.getText():null)));
            				} else
            					retval.st = templateLib.getInstanceOf("read_var_string",
              new STAttrMap().put("counter", var_type.getNumber()));
            			}
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
    // $ANTLR end "read_strm"

    public static class if_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "if_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:836:1: if_stmt : 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )? ;
    public final MyStrLangParser.if_stmt_return if_stmt() throws RecognitionException {
        MyStrLangParser.if_stmt_return retval = new MyStrLangParser.if_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.block_return ifBlock = null;

        MyStrLangParser.block_return elseBlock = null;

        MyStrLangParser.expression_return expression47 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:837:2: ( 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:837:4: 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )?
            {
            match(input,26,FOLLOW_26_in_if_stmt1230); 
            match(input,14,FOLLOW_14_in_if_stmt1232); 
            pushFollow(FOLLOW_expression_in_if_stmt1234);
            expression47=expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_if_stmt1236); 
            match(input,11,FOLLOW_11_in_if_stmt1238); 
            pushFollow(FOLLOW_block_in_if_stmt1242);
            ifBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_if_stmt1244); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:837:50: ( 'else' '{' elseBlock= block '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:837:51: 'else' '{' elseBlock= block '}'
                    {
                    match(input,27,FOLLOW_27_in_if_stmt1247); 
                    match(input,11,FOLLOW_11_in_if_stmt1249); 
                    pushFollow(FOLLOW_block_in_if_stmt1253);
                    elseBlock=block();

                    state._fsp--;

                    match(input,12,FOLLOW_12_in_if_stmt1255); 

                    }
                    break;

            }


            		retval.st = templateLib.getInstanceOf("if_operation",
              new STAttrMap().put("expression", (expression47!=null?expression47.st:null)).put("ifBlock", (ifBlock!=null?ifBlock.stList:null)).put("elseBlock", (elseBlock!=null?elseBlock.stList:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
            		labelCounter = labelCounter+2;
            	

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
    // $ANTLR end "if_stmt"

    public static class for_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "for_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:848:1: for_stmt : 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}' ;
    public final MyStrLangParser.for_stmt_return for_stmt() throws RecognitionException {
        MyStrLangParser.for_stmt_return retval = new MyStrLangParser.for_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.assign_stmt_return begin = null;

        MyStrLangParser.expression_return check = null;

        MyStrLangParser.assign_stmt_return end = null;

        MyStrLangParser.block_return forBlock = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:849:2: ( 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:849:4: 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}'
            {
            match(input,28,FOLLOW_28_in_for_stmt1274); 
            match(input,14,FOLLOW_14_in_for_stmt1276); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt1280);
            begin=assign_stmt();

            state._fsp--;

            match(input,13,FOLLOW_13_in_for_stmt1282); 
            pushFollow(FOLLOW_expression_in_for_stmt1286);
            check=expression();

            state._fsp--;

            match(input,13,FOLLOW_13_in_for_stmt1288); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt1292);
            end=assign_stmt();

            state._fsp--;

            match(input,15,FOLLOW_15_in_for_stmt1294); 
            match(input,11,FOLLOW_11_in_for_stmt1296); 
            pushFollow(FOLLOW_block_in_for_stmt1300);
            forBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_for_stmt1302); 

            		retval.st = templateLib.getInstanceOf("for_operator",
              new STAttrMap().put("beginExpr", (begin!=null?begin.st:null)).put("checkExpr", (check!=null?check.st:null)).put("endExpr", (end!=null?end.st:null)).put("forBlock", (forBlock!=null?forBlock.stList:null)).put("firstLabel", labelCounter).put("secondLabel", labelCounter+1).put("thirdLabel", labelCounter+2));
            		labelCounter = labelCounter+3;
            	

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
    // $ANTLR end "for_stmt"

    public static class while_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "while_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:860:1: while_stmt : 'while' '(' check= expression ')' '{' whileBlock= block '}' ;
    public final MyStrLangParser.while_stmt_return while_stmt() throws RecognitionException {
        MyStrLangParser.while_stmt_return retval = new MyStrLangParser.while_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.expression_return check = null;

        MyStrLangParser.block_return whileBlock = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:861:2: ( 'while' '(' check= expression ')' '{' whileBlock= block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:861:4: 'while' '(' check= expression ')' '{' whileBlock= block '}'
            {
            match(input,29,FOLLOW_29_in_while_stmt1319); 
            match(input,14,FOLLOW_14_in_while_stmt1321); 
            pushFollow(FOLLOW_expression_in_while_stmt1325);
            check=expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_while_stmt1327); 
            match(input,11,FOLLOW_11_in_while_stmt1329); 
            pushFollow(FOLLOW_block_in_while_stmt1333);
            whileBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_while_stmt1335); 

            		retval.st = templateLib.getInstanceOf("while_operator",
              new STAttrMap().put("checkExpr", (check!=null?check.st:null)).put("whileBlock", (whileBlock!=null?whileBlock.stList:null)).put("firstLabel", labelCounter).put("secondLabel", labelCounter+1).put("thirdLabel", labelCounter+2));
            		labelCounter = labelCounter+3;
            	

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
    // $ANTLR end "while_stmt"

    public static class return_stmt_return extends ParserRuleReturnScope {
        public String value;
        public int line;
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "return_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:871:1: return_stmt returns [String value, int line, String type] : (a= 'return' atom ';' )? -> {$atom.st};
    public final MyStrLangParser.return_stmt_return return_stmt() throws RecognitionException {
        MyStrLangParser.return_stmt_return retval = new MyStrLangParser.return_stmt_return();
        retval.start = input.LT(1);

        Token a=null;
        MyStrLangParser.atom_return atom48 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:872:2: ( (a= 'return' atom ';' )? -> {$atom.st})
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:873:2: (a= 'return' atom ';' )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:873:2: (a= 'return' atom ';' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:873:3: a= 'return' atom ';'
                    {
                    a=(Token)match(input,30,FOLLOW_30_in_return_stmt1359); 
                    pushFollow(FOLLOW_atom_in_return_stmt1361);
                    atom48=atom();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_return_stmt1363); 
                    	
                    	  retval.type = (atom48!=null?atom48.type:null);
                    		if(((program_scope)program_stack.peek()).curBlock=="main")
                    			errors.add("line "+(a!=null?a.getLine():0)+": function main may not contain keyword return");
                    		retval.value = (atom48!=null?atom48.text:null);
                    		retval.line = (a!=null?a.getLine():0);
                    		
                    		try{
                    			String name = ((program_scope)program_stack.peek()).curBlock;
                    			NamesTable.FunctionName func = names.getFunction(name);
                    			String type = func.getReturnType();
                    			
                    			if(type.equals("void")){
                    				errors.add("line "+(a!=null?a.getLine():0)+": type of void may not contain keyword return");
                    			}
                    			
                    			String rType = (atom48!=null?atom48.type:null);
                    			if(!TypesChecker.checkTypes(type,rType)){
                    				errors.add("line "+(a!=null?a.getLine():0)+": Type mismatch: cannot convert from "+type+" to "+rType);
                    			}
                    		}
                    		catch(NullPointerException e)
                    		{
                    		}
                    	

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 900:2: -> {$atom.st}
            {
                retval.st = (atom48!=null?atom48.st:null);
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
    // $ANTLR end "return_stmt"

    public static class length_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "length_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:907:1: length_stmt : 'length' '(' param ')' ;
    public final MyStrLangParser.length_stmt_return length_stmt() throws RecognitionException {
        MyStrLangParser.length_stmt_return retval = new MyStrLangParser.length_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.param_return param49 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:908:2: ( 'length' '(' param ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:908:4: 'length' '(' param ')'
            {
            match(input,31,FOLLOW_31_in_length_stmt1390); 
            match(input,14,FOLLOW_14_in_length_stmt1392); 
            pushFollow(FOLLOW_param_in_length_stmt1394);
            param49=param();

            state._fsp--;

            match(input,15,FOLLOW_15_in_length_stmt1396); 

            		retval.st = templateLib.getInstanceOf("length_string",
              new STAttrMap().put("string", (param49!=null?param49.st:null)));
            	

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
    // $ANTLR end "length_stmt"

    public static class param_return extends ParserRuleReturnScope {
        public String text;
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "param"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:914:1: param returns [String text, String type] : ( ID | STRING -> const_string(value=$STRING.text));
    public final MyStrLangParser.param_return param() throws RecognitionException {
        MyStrLangParser.param_return retval = new MyStrLangParser.param_return();
        retval.start = input.LT(1);

        Token ID50=null;
        Token STRING51=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:916:2: ( ID | STRING -> const_string(value=$STRING.text))
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ID) ) {
                alt22=1;
            }
            else if ( (LA22_0==STRING) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:916:4: ID
                    {
                    ID50=(Token)match(input,ID,FOLLOW_ID_in_param1416); 

                    		retval.text = (ID50!=null?ID50.getText():null);
                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID50!=null?ID50.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID50!=null?ID50.getText():null));
                    			retval.type = v_type.getType();
                    			if(TypesChecker.isInteger(retval.type))
                    			{
                    				if(names.isGlobal(retval.type))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_int",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_int",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    			
                    			if(TypesChecker.isString(retval.type))
                    			{
                    				if(names.isGlobal(retval.text))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_string",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_string",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    			
                    		}
                    		else
                    		{
                    			errors.add("line "+(ID50!=null?ID50.getLine():0)+": unknown variable "+(ID50!=null?ID50.getText():null));
                    		}
                    		

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:950:4: STRING
                    {
                    STRING51=(Token)match(input,STRING,FOLLOW_STRING_in_param1423); 
                    retval.text = (STRING51!=null?STRING51.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 950:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING51!=null?STRING51.getText():null)));
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
    // $ANTLR end "param"

    public static class elem_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "elem_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:957:1: elem_stmt : 'elem' '(' f_el ',' s_el ')' ;
    public final MyStrLangParser.elem_stmt_return elem_stmt() throws RecognitionException {
        MyStrLangParser.elem_stmt_return retval = new MyStrLangParser.elem_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return f_el52 = null;

        MyStrLangParser.s_el_return s_el53 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:958:2: ( 'elem' '(' f_el ',' s_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:958:4: 'elem' '(' f_el ',' s_el ')'
            {
            match(input,32,FOLLOW_32_in_elem_stmt1450); 
            match(input,14,FOLLOW_14_in_elem_stmt1452); 
            pushFollow(FOLLOW_f_el_in_elem_stmt1453);
            f_el52=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_elem_stmt1455); 
            pushFollow(FOLLOW_s_el_in_elem_stmt1457);
            s_el53=s_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_elem_stmt1459); 

            		retval.st = templateLib.getInstanceOf("elem_in_string",
              new STAttrMap().put("fValue", (f_el52!=null?f_el52.st:null)).put("sValue", (s_el53!=null?s_el53.st:null)));
            	

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
    // $ANTLR end "elem_stmt"

    public static class f_el_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "f_el"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:964:1: f_el : ( ID | STRING -> const_string(value=$STRING.text));
    public final MyStrLangParser.f_el_return f_el() throws RecognitionException {
        MyStrLangParser.f_el_return retval = new MyStrLangParser.f_el_return();
        retval.start = input.LT(1);

        Token ID54=null;
        Token STRING55=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:966:2: ( ID | STRING -> const_string(value=$STRING.text))
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID) ) {
                alt23=1;
            }
            else if ( (LA23_0==STRING) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:966:4: ID
                    {
                    ID54=(Token)match(input,ID,FOLLOW_ID_in_f_el1475); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID54!=null?ID54.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID54!=null?ID54.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isString(type))
                    			{
                    				if(names.isGlobal((ID54!=null?ID54.getText():null)))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_string",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_string",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    		}
                    		else
                    			errors.add("line "+(ID54!=null?ID54.getLine():0)+": unknown variable "+(ID54!=null?ID54.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:986:4: STRING
                    {
                    STRING55=(Token)match(input,STRING,FOLLOW_STRING_in_f_el1483); 


                    // TEMPLATE REWRITE
                    // 986:12: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING55!=null?STRING55.getText():null)));
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
    // $ANTLR end "f_el"

    public static class s_el_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "s_el"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:989:1: s_el : ( ID | INT -> const_int(value=$INT.text));
    public final MyStrLangParser.s_el_return s_el() throws RecognitionException {
        MyStrLangParser.s_el_return retval = new MyStrLangParser.s_el_return();
        retval.start = input.LT(1);

        Token ID56=null;
        Token INT57=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:991:2: ( ID | INT -> const_int(value=$INT.text))
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID) ) {
                alt24=1;
            }
            else if ( (LA24_0==INT) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:991:4: ID
                    {
                    ID56=(Token)match(input,ID,FOLLOW_ID_in_s_el1509); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID56!=null?ID56.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID56!=null?ID56.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isInteger(type))
                    			{
                    				if(names.isGlobal((ID56!=null?ID56.getText():null)))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_int",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_int",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    		}
                    		else
                    			errors.add("line "+(ID56!=null?ID56.getLine():0)+": unknown variable "+(ID56!=null?ID56.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1011:4: INT
                    {
                    INT57=(Token)match(input,INT,FOLLOW_INT_in_s_el1517); 


                    // TEMPLATE REWRITE
                    // 1011:9: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT57!=null?INT57.getText():null)));
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
    // $ANTLR end "s_el"

    public static class to_string_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "to_string_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1018:1: to_string_stmt : line= 'ToString' '(' param_str ')' ;
    public final MyStrLangParser.to_string_stmt_return to_string_stmt() throws RecognitionException {
        MyStrLangParser.to_string_stmt_return retval = new MyStrLangParser.to_string_stmt_return();
        retval.start = input.LT(1);

        Token line=null;
        MyStrLangParser.param_str_return param_str58 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1019:2: (line= 'ToString' '(' param_str ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1019:4: line= 'ToString' '(' param_str ')'
            {
            line=(Token)match(input,33,FOLLOW_33_in_to_string_stmt1543); 
            match(input,14,FOLLOW_14_in_to_string_stmt1545); 
            pushFollow(FOLLOW_param_str_in_to_string_stmt1547);
            param_str58=param_str();

            state._fsp--;

            match(input,15,FOLLOW_15_in_to_string_stmt1549); 

            	  if(TypesChecker.isString((param_str58!=null?param_str58.t:null)))
            	  {
            	      errors.add("line "+(line!=null?line.getLine():0)+": Can't convert string to string");
            	  }
            		if(TypesChecker.isInteger((param_str58!=null?param_str58.t:null))){
            			retval.st = templateLib.getInstanceOf("int_to_string",
              new STAttrMap().put("value", (param_str58!=null?param_str58.st:null)));
            		}
            		if(TypesChecker.isChar((param_str58!=null?param_str58.t:null))){
            			retval.st = templateLib.getInstanceOf("char_to_string",
              new STAttrMap().put("value", (param_str58!=null?param_str58.st:null)));
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
    // $ANTLR end "to_string_stmt"

    public static class param_str_return extends ParserRuleReturnScope {
        public String t;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "param_str"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1034:1: param_str returns [String t] : ( ID | INT -> const_int(value=$INT.text) | char_c -> {$char_c.st});
    public final MyStrLangParser.param_str_return param_str() throws RecognitionException {
        MyStrLangParser.param_str_return retval = new MyStrLangParser.param_str_return();
        retval.start = input.LT(1);

        Token ID59=null;
        Token INT60=null;
        MyStrLangParser.char_c_return char_c61 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1036:2: ( ID | INT -> const_int(value=$INT.text) | char_c -> {$char_c.st})
            int alt25=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt25=1;
                }
                break;
            case INT:
                {
                alt25=2;
                }
                break;
            case CHAR:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1036:4: ID
                    {
                    ID59=(Token)match(input,ID,FOLLOW_ID_in_param_str1569); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID59!=null?ID59.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID59!=null?ID59.getText():null));
                    			String type = v_type.getType();
                    			retval.t = type;
                    			if(TypesChecker.isInteger(type))
                    			{
                    				if(names.isGlobal((ID59!=null?ID59.getText():null)))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_int",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_int",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    			
                    			if(TypesChecker.isChar(type))
                    			{
                    				if(names.isGlobal((ID59!=null?ID59.getText():null)))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_char",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_char",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    		}
                    		else
                    			errors.add("line "+(ID59!=null?ID59.getLine():0)+": unknown variable "+(ID59!=null?ID59.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1068:4: INT
                    {
                    INT60=(Token)match(input,INT,FOLLOW_INT_in_param_str1577); 
                    retval.t ="int";


                    // TEMPLATE REWRITE
                    // 1068:22: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT60!=null?INT60.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1069:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_param_str1595);
                    char_c61=char_c();

                    state._fsp--;

                    retval.t ="char";


                    // TEMPLATE REWRITE
                    // 1069:25: -> {$char_c.st}
                    {
                        retval.st = (char_c61!=null?char_c61.st:null);
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
    // $ANTLR end "param_str"

    public static class call_func_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "call_func_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1072:1: call_func_stmt : call_func -> {$call_func.st};
    public final MyStrLangParser.call_func_stmt_return call_func_stmt() throws RecognitionException {
        MyStrLangParser.call_func_stmt_return retval = new MyStrLangParser.call_func_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.call_func_return call_func62 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1073:2: ( call_func -> {$call_func.st})
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1073:4: call_func
            {
            pushFollow(FOLLOW_call_func_in_call_func_stmt1614);
            call_func62=call_func();

            state._fsp--;



            // TEMPLATE REWRITE
            // 1074:3: -> {$call_func.st}
            {
                retval.st = (call_func62!=null?call_func62.st:null);
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
    // $ANTLR end "call_func_stmt"

    protected static class call_func_scope {
        String methodName;
    }
    protected Stack call_func_stack = new Stack();

    public static class call_func_return extends ParserRuleReturnScope {
        public String type;
        public int line;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "call_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1077:1: call_func returns [String type, int line] : ID '(' arg_call ')' ;
    public final MyStrLangParser.call_func_return call_func() throws RecognitionException {
        call_func_stack.push(new call_func_scope());
        MyStrLangParser.call_func_return retval = new MyStrLangParser.call_func_return();
        retval.start = input.LT(1);

        Token ID63=null;
        MyStrLangParser.arg_call_return arg_call64 = null;



        	((call_func_scope)call_func_stack.peek()).methodName = "";
        	List<StringTemplate> argTypes = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1088:2: ( ID '(' arg_call ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1088:4: ID '(' arg_call ')'
            {
            ID63=(Token)match(input,ID,FOLLOW_ID_in_call_func1644); 
            ((call_func_scope)call_func_stack.peek()).methodName =(ID63!=null?ID63.getText():null);
            match(input,14,FOLLOW_14_in_call_func1647); 
            pushFollow(FOLLOW_arg_call_in_call_func1649);
            arg_call64=arg_call();

            state._fsp--;

            match(input,15,FOLLOW_15_in_call_func1651); 

            		retval.line = (ID63!=null?ID63.getLine():0);
            		ArrayList<String> list = null;
            		if((arg_call64!=null?arg_call64.argumentTypeList:null)==null)
            			list = new ArrayList<String>();
            		else
            			list = (arg_call64!=null?arg_call64.argumentTypeList:null);
            		if(!names.checkCallFunction((ID63!=null?ID63.getText():null), list, (ID63!=null?ID63.getLine():0)))
            		{
            			names.getAllErrors(errors);
            		}
            		if(!names.isExistFunction((ID63!=null?ID63.getText():null)))
            		{
            			errors.add("line "+(ID63!=null?ID63.getLine():0)+": function "+(ID63!=null?ID63.getText():null)+" is not exist");
            		}
            		else
            		{
            			NamesTable.FunctionName func = names.getFunction((ID63!=null?ID63.getText():null));
            			retval.type = func.getReturnType();
            		}
            		
            		for(String arg_type: (arg_call64!=null?arg_call64.argumentTypeList:null))
            		{
            			if(TypesChecker.isInteger(arg_type))
            			{
            				argTypes.add(templateLib.getInstanceOf("type_int"));
            			}
            			if(TypesChecker.isString(arg_type))
            			{
            				argTypes.add(templateLib.getInstanceOf("type_string"));
            			}
            			if(TypesChecker.isChar(arg_type))
            			{
            				argTypes.add(templateLib.getInstanceOf("type_char"));
            			}
            			  
            		}
            		
            		StringTemplate returnType = new StringTemplate();
            		
            		if(TypesChecker.isInteger(retval.type))
            		{
            			returnType = templateLib.getInstanceOf("type_int");
            		}
            		if(TypesChecker.isString(retval.type))
            		{
            			returnType = templateLib.getInstanceOf("type_string");
            		}
            		if(TypesChecker.isChar(retval.type))
            		{
            			returnType = templateLib.getInstanceOf("type_char");
            		}
            		if(TypesChecker.isVoid(retval.type))
            		{
            			returnType = templateLib.getInstanceOf("type_void");
            		}
            		
            		retval.st = templateLib.getInstanceOf("function_call",
              new STAttrMap().put("programName", programName).put("funcName", (ID63!=null?ID63.getText():null)).put("argTemplates", (arg_call64!=null?arg_call64.stList:null)).put("argTypes", argTypes).put("returnType", returnType));
            	

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

    public static class arg_call_return extends ParserRuleReturnScope {
        public ArrayList<String> argumentTypeList;
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "arg_call"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1150:1: arg_call returns [ArrayList<String> argumentTypeList, List<StringTemplate> stList] : (a= atom ( ',' b= atom )* )? ;
    public final MyStrLangParser.arg_call_return arg_call() throws RecognitionException {
        MyStrLangParser.arg_call_return retval = new MyStrLangParser.arg_call_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return a = null;

        MyStrLangParser.atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1152:2: ( (a= atom ( ',' b= atom )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1153:2: (a= atom ( ',' b= atom )* )?
            {

            		retval.argumentTypeList = new ArrayList<String>();
            		retval.stList = new ArrayList<StringTemplate>();
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1157:2: (a= atom ( ',' b= atom )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=ID && LA27_0<=CHAR)||(LA27_0>=31 && LA27_0<=33)||(LA27_0>=45 && LA27_0<=48)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1157:3: a= atom ( ',' b= atom )*
                    {
                    pushFollow(FOLLOW_atom_in_arg_call1679);
                    a=atom();

                    state._fsp--;

                    retval.argumentTypeList.add((a!=null?a.type:null)); retval.stList.add((a!=null?a.st:null));
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1157:64: ( ',' b= atom )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==16) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1157:65: ',' b= atom
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_call1684); 
                    	    pushFollow(FOLLOW_atom_in_arg_call1688);
                    	    b=atom();

                    	    state._fsp--;

                    	    retval.argumentTypeList.add((b!=null?b.type:null)); retval.stList.add((b!=null?b.st:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


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
    // $ANTLR end "arg_call"

    public static class expression_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "expression"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1164:1: expression : first= and_expression ( '||' second= expression )? ;
    public final MyStrLangParser.expression_return expression() throws RecognitionException {
        MyStrLangParser.expression_return retval = new MyStrLangParser.expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.and_expression_return first = null;

        MyStrLangParser.expression_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1165:2: (first= and_expression ( '||' second= expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1165:4: first= and_expression ( '||' second= expression )?
            {
            pushFollow(FOLLOW_and_expression_in_expression1711);
            first=and_expression();

            state._fsp--;

            retval.st = (first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1165:44: ( '||' second= expression )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1165:45: '||' second= expression
                    {
                    match(input,34,FOLLOW_34_in_expression1716); 
                    pushFollow(FOLLOW_expression_in_expression1721);
                    second=expression();

                    state._fsp--;


                    			retval.st = templateLib.getInstanceOf("logical_or",
                      new STAttrMap().put("firstExpr", (first!=null?first.st:null)).put("secondExpr", (second!=null?second.st:null)).put("firstLabel", labelCounter).put("secondLabel", labelCounter+1).put("thirdLabel", labelCounter+2));
                    			labelCounter = labelCounter+3;
                    		

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
    // $ANTLR end "expression"

    public static class and_expression_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "and_expression"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1178:1: and_expression : first= not_expression ( '&&' second= and_expression )? ;
    public final MyStrLangParser.and_expression_return and_expression() throws RecognitionException {
        MyStrLangParser.and_expression_return retval = new MyStrLangParser.and_expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.not_expression_return first = null;

        MyStrLangParser.and_expression_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1179:2: (first= not_expression ( '&&' second= and_expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1179:4: first= not_expression ( '&&' second= and_expression )?
            {
            pushFollow(FOLLOW_not_expression_in_and_expression1746);
            first=not_expression();

            state._fsp--;

            retval.st = (first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1179:44: ( '&&' second= and_expression )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==35) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1179:45: '&&' second= and_expression
                    {
                    match(input,35,FOLLOW_35_in_and_expression1751); 
                    pushFollow(FOLLOW_and_expression_in_and_expression1755);
                    second=and_expression();

                    state._fsp--;


                    			retval.st = templateLib.getInstanceOf("logical_and",
                      new STAttrMap().put("firstExpr", (first!=null?first.st:null)).put("secondExpr", (second!=null?second.st:null)).put("firstLabel", labelCounter).put("secondLabel", labelCounter+1).put("thirdLabel", labelCounter+2));
                    			labelCounter = labelCounter+3;
                    		

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
    // $ANTLR end "and_expression"

    public static class not_expression_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "not_expression"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1192:1: not_expression : ( '!' first= not_expression | second= comparison );
    public final MyStrLangParser.not_expression_return not_expression() throws RecognitionException {
        MyStrLangParser.not_expression_return retval = new MyStrLangParser.not_expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.not_expression_return first = null;

        MyStrLangParser.comparison_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1193:2: ( '!' first= not_expression | second= comparison )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=ID && LA30_0<=CHAR)||(LA30_0>=31 && LA30_0<=33)||(LA30_0>=43 && LA30_0<=48)) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1193:4: '!' first= not_expression
                    {
                    match(input,36,FOLLOW_36_in_not_expression1777); 
                    pushFollow(FOLLOW_not_expression_in_not_expression1781);
                    first=not_expression();

                    state._fsp--;


                    				retval.st = templateLib.getInstanceOf("logical_not",
                      new STAttrMap().put("expression", (first!=null?first.st:null)).put("firstLabel", labelCounter).put("secondLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1198:4: second= comparison
                    {
                    pushFollow(FOLLOW_comparison_in_not_expression1793);
                    second=comparison();

                    state._fsp--;

                    retval.st = (second!=null?second.st:null);

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
    // $ANTLR end "not_expression"

    public static class comparison_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "comparison"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1205:1: comparison : (first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom | equal_op -> {$equal_op.st} | contain_op -> {$contain_op.st});
    public final MyStrLangParser.comparison_return comparison() throws RecognitionException {
        MyStrLangParser.comparison_return retval = new MyStrLangParser.comparison_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.atom_return first = null;

        MyStrLangParser.atom_return second = null;

        MyStrLangParser.equal_op_return equal_op65 = null;

        MyStrLangParser.contain_op_return contain_op66 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1206:2: (first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom | equal_op -> {$equal_op.st} | contain_op -> {$contain_op.st})
            int alt31=3;
            switch ( input.LA(1) ) {
            case ID:
            case INT:
            case STRING:
            case CHAR:
            case 31:
            case 32:
            case 33:
            case 45:
            case 46:
            case 47:
            case 48:
                {
                alt31=1;
                }
                break;
            case 43:
                {
                alt31=2;
                }
                break;
            case 44:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1206:4: first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom
                    {
                    pushFollow(FOLLOW_atom_in_comparison1810);
                    first=atom();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=37 && input.LA(1)<=42) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_atom_in_comparison1830);
                    second=atom();

                    state._fsp--;


                    		if(!TypesChecker.checkTypes((first!=null?first.type:null), (second!=null?second.type:null)))
                    		{
                    			errors.add("line "+(op!=null?op.getLine():0)+": Incompatible types "+(first!=null?first.type:null)+" and "+(second!=null?second.type:null));
                    		}
                    		
                    		if(TypesChecker.isInteger((first!=null?first.type:null)))
                    		{
                    			if((op!=null?op.getText():null).equals("<")){
                    				retval.st = templateLib.getInstanceOf("integer_less",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals(">")){
                    				retval.st = templateLib.getInstanceOf("integer_greater",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals("==")){
                    				retval.st = templateLib.getInstanceOf("integer_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals("!=")){
                    				retval.st = templateLib.getInstanceOf("integer_not_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals("<=")){
                    				retval.st = templateLib.getInstanceOf("integer_less_or_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals(">=")){
                    				retval.st = templateLib.getInstanceOf("integer_greater_or_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    		}
                    		
                    		if(TypesChecker.isChar((first!=null?first.type:null)))
                    		{
                    			if((op!=null?op.getText():null).equals("<")){
                    				retval.st = templateLib.getInstanceOf("char_less",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			
                    			if((op!=null?op.getText():null).equals(">")){
                    				retval.st = templateLib.getInstanceOf("char_greater",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals("==")){
                    				retval.st = templateLib.getInstanceOf("char_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals("!=")){
                    				retval.st = templateLib.getInstanceOf("char_not_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals("<=")){
                    				retval.st = templateLib.getInstanceOf("char_less_or_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals(">=")){
                    				retval.st = templateLib.getInstanceOf("char_greater_or_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    		}
                    		
                    		if(TypesChecker.isString((first!=null?first.type:null)))
                    		{
                    			if((op!=null?op.getText():null).equals("<") || (op!=null?op.getText():null).equals(">") || (op!=null?op.getText():null).equals("<=") || (op!=null?op.getText():null).equals(">=")){
                    				errors.add("line "+(op!=null?op.getLine():0)+": The operator "+(op!=null?op.getText():null)+" for type string not applicable ");
                    			}
                    			
                    			if((op!=null?op.getText():null).equals("==")){
                    				retval.st = templateLib.getInstanceOf("string_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    			if((op!=null?op.getText():null).equals("!=")){
                    				retval.st = templateLib.getInstanceOf("string_not_equal",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			}
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1286:4: equal_op
                    {
                    pushFollow(FOLLOW_equal_op_in_comparison1838);
                    equal_op65=equal_op();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 1286:14: -> {$equal_op.st}
                    {
                        retval.st = (equal_op65!=null?equal_op65.st:null);
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1287:4: contain_op
                    {
                    pushFollow(FOLLOW_contain_op_in_comparison1848);
                    contain_op66=contain_op();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 1287:16: -> {$contain_op.st}
                    {
                        retval.st = (contain_op66!=null?contain_op66.st:null);
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
    // $ANTLR end "comparison"

    public static class equal_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "equal_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1294:1: equal_op : 'equals' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.equal_op_return equal_op() throws RecognitionException {
        MyStrLangParser.equal_op_return retval = new MyStrLangParser.equal_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1295:2: ( 'equals' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1295:4: 'equals' '(' first= f_el ',' second= f_el ')'
            {
            match(input,43,FOLLOW_43_in_equal_op1867); 
            match(input,14,FOLLOW_14_in_equal_op1869); 
            pushFollow(FOLLOW_f_el_in_equal_op1873);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_equal_op1875); 
            pushFollow(FOLLOW_f_el_in_equal_op1879);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_equal_op1881); 

            		retval.st = templateLib.getInstanceOf("equal_operation",
              new STAttrMap().put("fValue", (first!=null?first.st:null)).put("sValue", (second!=null?second.st:null)));
            	

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
    // $ANTLR end "equal_op"

    public static class contain_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "contain_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1305:1: contain_op : 'contains' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.contain_op_return contain_op() throws RecognitionException {
        MyStrLangParser.contain_op_return retval = new MyStrLangParser.contain_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1306:2: ( 'contains' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1306:4: 'contains' '(' first= f_el ',' second= f_el ')'
            {
            match(input,44,FOLLOW_44_in_contain_op1900); 
            match(input,14,FOLLOW_14_in_contain_op1902); 
            pushFollow(FOLLOW_f_el_in_contain_op1906);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_contain_op1908); 
            pushFollow(FOLLOW_f_el_in_contain_op1912);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_contain_op1914); 

            		retval.st = templateLib.getInstanceOf("contain_operation",
              new STAttrMap().put("fValue", (first!=null?first.st:null)).put("sValue", (second!=null?second.st:null)));
            	

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
    // $ANTLR end "contain_op"

    public static class indexOf_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "indexOf_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1316:1: indexOf_stmt : 'indexOf' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.indexOf_stmt_return indexOf_stmt() throws RecognitionException {
        MyStrLangParser.indexOf_stmt_return retval = new MyStrLangParser.indexOf_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1317:2: ( 'indexOf' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1317:4: 'indexOf' '(' first= f_el ',' second= f_el ')'
            {
            match(input,45,FOLLOW_45_in_indexOf_stmt1933); 
            match(input,14,FOLLOW_14_in_indexOf_stmt1935); 
            pushFollow(FOLLOW_f_el_in_indexOf_stmt1939);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_indexOf_stmt1941); 
            pushFollow(FOLLOW_f_el_in_indexOf_stmt1945);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_indexOf_stmt1946); 

            		retval.st = templateLib.getInstanceOf("indexOf_int",
              new STAttrMap().put("fValue", (first!=null?first.st:null)).put("sValue", (second!=null?second.st:null)));
            	

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
    // $ANTLR end "indexOf_stmt"

    public static class replace_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "replace_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1327:1: replace_op : 'replace' '(' f_el ',' first= char_param ',' second= char_param ')' ;
    public final MyStrLangParser.replace_op_return replace_op() throws RecognitionException {
        MyStrLangParser.replace_op_return retval = new MyStrLangParser.replace_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.char_param_return first = null;

        MyStrLangParser.char_param_return second = null;

        MyStrLangParser.f_el_return f_el67 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1328:2: ( 'replace' '(' f_el ',' first= char_param ',' second= char_param ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1328:4: 'replace' '(' f_el ',' first= char_param ',' second= char_param ')'
            {
            match(input,46,FOLLOW_46_in_replace_op1965); 
            match(input,14,FOLLOW_14_in_replace_op1967); 
            pushFollow(FOLLOW_f_el_in_replace_op1969);
            f_el67=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_op1971); 
            pushFollow(FOLLOW_char_param_in_replace_op1975);
            first=char_param();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_op1977); 
            pushFollow(FOLLOW_char_param_in_replace_op1981);
            second=char_param();

            state._fsp--;

            match(input,15,FOLLOW_15_in_replace_op1983); 

            		retval.st = templateLib.getInstanceOf("replace_operation",
              new STAttrMap().put("fValue", (f_el67!=null?f_el67.st:null)).put("sValue", (first!=null?first.st:null)).put("thValue", (second!=null?second.st:null)));
            	

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
    // $ANTLR end "replace_op"

    public static class char_param_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "char_param"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1334:1: char_param : ( ID | char_c -> {$char_c.st});
    public final MyStrLangParser.char_param_return char_param() throws RecognitionException {
        MyStrLangParser.char_param_return retval = new MyStrLangParser.char_param_return();
        retval.start = input.LT(1);

        Token ID68=null;
        MyStrLangParser.char_c_return char_c69 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1335:2: ( ID | char_c -> {$char_c.st})
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==ID) ) {
                alt32=1;
            }
            else if ( (LA32_0==CHAR) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1335:4: ID
                    {
                    ID68=(Token)match(input,ID,FOLLOW_ID_in_char_param1998); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID68!=null?ID68.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID68!=null?ID68.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isChar(type))
                    			{
                    				if(names.isGlobal((ID68!=null?ID68.getText():null)))
                    				{
                    					retval.st = templateLib.getInstanceOf("referenceField_char",
                      new STAttrMap().put("programName", programName).put("fieldName", v_type.getName()));
                    				}
                    				else{
                    					retval.st = templateLib.getInstanceOf("referenceVariable_char",
                      new STAttrMap().put("counter", v_type.getNumber()));
                    				}
                    			}
                    		}
                    		else
                    			errors.add("line "+(ID68!=null?ID68.getLine():0)+": unknown variable "+(ID68!=null?ID68.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1355:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_char_param2006);
                    char_c69=char_c();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 1355:12: -> {$char_c.st}
                    {
                        retval.st = (char_c69!=null?char_c69.st:null);
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
    // $ANTLR end "char_param"

    public static class replace_firstElem_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "replace_firstElem"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1362:1: replace_firstElem : 'replaceFirst' '(' first= f_el ',' second= f_el ',' third= f_el ')' ;
    public final MyStrLangParser.replace_firstElem_return replace_firstElem() throws RecognitionException {
        MyStrLangParser.replace_firstElem_return retval = new MyStrLangParser.replace_firstElem_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;

        MyStrLangParser.f_el_return third = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1363:2: ( 'replaceFirst' '(' first= f_el ',' second= f_el ',' third= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1363:4: 'replaceFirst' '(' first= f_el ',' second= f_el ',' third= f_el ')'
            {
            match(input,47,FOLLOW_47_in_replace_firstElem2026); 
            match(input,14,FOLLOW_14_in_replace_firstElem2028); 
            pushFollow(FOLLOW_f_el_in_replace_firstElem2032);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_firstElem2034); 
            pushFollow(FOLLOW_f_el_in_replace_firstElem2038);
            second=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_firstElem2040); 
            pushFollow(FOLLOW_f_el_in_replace_firstElem2044);
            third=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_replace_firstElem2046); 

            		retval.st = templateLib.getInstanceOf("replaceFirst_op",
              new STAttrMap().put("fValue", (first!=null?first.st:null)).put("sValue", (second!=null?second.st:null)).put("thValue", (third!=null?third.st:null)));
            	

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
    // $ANTLR end "replace_firstElem"

    public static class substring_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "substring_op"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1373:1: substring_op : ( 'subString' '(' first= f_el ',' second= s_el ')' | 'subString' '(' first= f_el ',' second= s_el ',' third= s_el ')' );
    public final MyStrLangParser.substring_op_return substring_op() throws RecognitionException {
        MyStrLangParser.substring_op_return retval = new MyStrLangParser.substring_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.s_el_return second = null;

        MyStrLangParser.s_el_return third = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1374:2: ( 'subString' '(' first= f_el ',' second= s_el ')' | 'subString' '(' first= f_el ',' second= s_el ',' third= s_el ')' )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1374:4: 'subString' '(' first= f_el ',' second= s_el ')'
                    {
                    match(input,48,FOLLOW_48_in_substring_op2066); 
                    match(input,14,FOLLOW_14_in_substring_op2068); 
                    pushFollow(FOLLOW_f_el_in_substring_op2072);
                    first=f_el();

                    state._fsp--;

                    match(input,16,FOLLOW_16_in_substring_op2074); 
                    pushFollow(FOLLOW_s_el_in_substring_op2078);
                    second=s_el();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_substring_op2079); 

                    		retval.st = templateLib.getInstanceOf("substring_op_one",
                      new STAttrMap().put("fValue", (first!=null?first.st:null)).put("sValue", (second!=null?second.st:null)));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1378:4: 'subString' '(' first= f_el ',' second= s_el ',' third= s_el ')'
                    {
                    match(input,48,FOLLOW_48_in_substring_op2087); 
                    match(input,14,FOLLOW_14_in_substring_op2089); 
                    pushFollow(FOLLOW_f_el_in_substring_op2093);
                    first=f_el();

                    state._fsp--;

                    match(input,16,FOLLOW_16_in_substring_op2095); 
                    pushFollow(FOLLOW_s_el_in_substring_op2099);
                    second=s_el();

                    state._fsp--;

                    match(input,16,FOLLOW_16_in_substring_op2101); 
                    pushFollow(FOLLOW_s_el_in_substring_op2105);
                    third=s_el();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_substring_op2107); 

                    		retval.st = templateLib.getInstanceOf("substring_op_two",
                      new STAttrMap().put("fValue", (first!=null?first.st:null)).put("sValue", (second!=null?second.st:null)).put("thValue", (third!=null?third.st:null)));
                    	

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
    // $ANTLR end "substring_op"

    public static class type_return extends ParserRuleReturnScope {
        public StringTemplate returnType;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1384:1: type returns [StringTemplate returnType] : ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char());
    public final MyStrLangParser.type_return type() throws RecognitionException {
        MyStrLangParser.type_return retval = new MyStrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1386:2: ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char())
            int alt34=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt34=1;
                }
                break;
            case 50:
                {
                alt34=2;
                }
                break;
            case 51:
                {
                alt34=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1386:4: 'int'
                    {
                    match(input,49,FOLLOW_49_in_type2129); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 1386:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1387:5: 'string'
                    {
                    match(input,50,FOLLOW_50_in_type2143); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 1387:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1388:5: 'char'
                    {
                    match(input,51,FOLLOW_51_in_type2156); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 1388:46: -> type_char()
                    {
                        retval.st = templateLib.getInstanceOf("type_char");
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
    // $ANTLR end "type"

    public static class type_func_return extends ParserRuleReturnScope {
        public StringTemplate returnType;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "type_func"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1391:1: type_func returns [StringTemplate returnType] : ( | 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char() | 'void' -> type_void());
    public final MyStrLangParser.type_func_return type_func() throws RecognitionException {
        MyStrLangParser.type_func_return retval = new MyStrLangParser.type_func_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1393:2: ( | 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char() | 'void' -> type_void())
            int alt35=5;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt35=1;
                }
                break;
            case 49:
                {
                alt35=2;
                }
                break;
            case 50:
                {
                alt35=3;
                }
                break;
            case 51:
                {
                alt35=4;
                }
                break;
            case 52:
                {
                alt35=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1394:2: 
                    {
                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1394:4: 'int'
                    {
                    match(input,49,FOLLOW_49_in_type_func2184); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 1394:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1395:5: 'string'
                    {
                    match(input,50,FOLLOW_50_in_type_func2198); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 1395:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1396:5: 'char'
                    {
                    match(input,51,FOLLOW_51_in_type_func2211); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 1396:46: -> type_char()
                    {
                        retval.st = templateLib.getInstanceOf("type_char");
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1397:4: 'void'
                    {
                    match(input,52,FOLLOW_52_in_type_func2223); 
                    retval.returnType = templateLib.getInstanceOf("return_void");


                    // TEMPLATE REWRITE
                    // 1397:43: -> type_void()
                    {
                        retval.st = templateLib.getInstanceOf("type_void");
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
    // $ANTLR end "type_func"

    protected static class call_delegate_scope {
        String methodName;
    }
    protected Stack call_delegate_stack = new Stack();

    public static class call_delegate_return extends ParserRuleReturnScope {
        public String type;
        public int line;
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "call_delegate"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1400:1: call_delegate returns [String type, int line, List<StringTemplate> stList] : ( '[' delegatename= ID ':' expr ']' '(' arg_call ')' | '[' delegatename= ID ':' '{' block '}' ']' '(' arg_call ')' );
    public final MyStrLangParser.call_delegate_return call_delegate() throws RecognitionException {
        call_delegate_stack.push(new call_delegate_scope());
        MyStrLangParser.call_delegate_return retval = new MyStrLangParser.call_delegate_return();
        retval.start = input.LT(1);

        Token delegatename=null;
        MyStrLangParser.expr_return expr70 = null;

        MyStrLangParser.arg_call_return arg_call71 = null;

        MyStrLangParser.block_return block72 = null;

        MyStrLangParser.arg_call_return arg_call73 = null;



          retval.stList = new ArrayList<StringTemplate>();
          ((call_delegate_scope)call_delegate_stack.peek()).methodName ="";

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1411:3: ( '[' delegatename= ID ':' expr ']' '(' arg_call ')' | '[' delegatename= ID ':' '{' block '}' ']' '(' arg_call ')' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==53) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==ID) ) {
                    int LA36_2 = input.LA(3);

                    if ( (LA36_2==54) ) {
                        int LA36_3 = input.LA(4);

                        if ( (LA36_3==11) ) {
                            alt36=2;
                        }
                        else if ( ((LA36_3>=ID && LA36_3<=CHAR)||(LA36_3>=31 && LA36_3<=33)||(LA36_3>=45 && LA36_3<=48)) ) {
                            alt36=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 36, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1412:5: '[' delegatename= ID ':' expr ']' '(' arg_call ')'
                    {
                    match(input,53,FOLLOW_53_in_call_delegate2263); 
                    ((call_delegate_scope)call_delegate_stack.peek()).methodName = ((program_scope)program_stack.peek()).curBlock;
                    delegatename=(Token)match(input,ID,FOLLOW_ID_in_call_delegate2269); 
                    ((program_scope)program_stack.peek()).curBlock =(delegatename!=null?delegatename.getText():null);
                    match(input,54,FOLLOW_54_in_call_delegate2273); 
                    pushFollow(FOLLOW_expr_in_call_delegate2275);
                    expr70=expr();

                    state._fsp--;

                    match(input,55,FOLLOW_55_in_call_delegate2277); 
                    match(input,14,FOLLOW_14_in_call_delegate2279); 
                    ((program_scope)program_stack.peek()).curBlock =((call_delegate_scope)call_delegate_stack.peek()).methodName;
                    pushFollow(FOLLOW_arg_call_in_call_delegate2283);
                    arg_call71=arg_call();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_call_delegate2285); 

                          if(names.isExistDelegate((delegatename!=null?delegatename.getText():null)))
                          {
                            NamesTable.DelegateName delName = names.getDelegate((delegatename!=null?delegatename.getText():null));
                            String functionName = delName.getNameFunction();
                            NamesTable.FunctionName funcName = names.getFunction(functionName);
                            retval.line = (delegatename!=null?delegatename.getLine():0);
                            retval.type = (expr70!=null?expr70.type:null);
                            if(!names.checkCallFunction(functionName, (arg_call71!=null?arg_call71.argumentTypeList:null), retval.line))
                    	      {
                    	        names.getAllErrors(errors);
                    	      }
                    	      ArrayList<String> argNames = new ArrayList<String>();
                            argNames = funcName.getArgumentNames();
                            List<StringTemplate> assign_list = (arg_call71!=null?arg_call71.stList:null);
                            for(String arg_name: argNames)
                            {
                                NamesTable.VariableName varName = names.getVariable((delegatename!=null?delegatename.getText():null)+"."+arg_name);
                                int _counter = varName.getNumber();
                                if(TypesChecker.isString(varName.getType())){
                                  StringTemplate t = templateLib.getInstanceOf("declaration_string",
                      new STAttrMap().put("counter", _counter));
                                  retval.stList.add(t);
                                  for(StringTemplate _t: assign_list)
                                  {
                                    StringTemplate t_assign= templateLib.getInstanceOf("assign_var_string",
                      new STAttrMap().put("expression", _t).put("counter", _counter));
                                    retval.stList.add(t_assign);
                                    assign_list.remove(_t);
                                    break;
                                  }
                                }
                                if(TypesChecker.isInteger(varName.getType())){
                    	            StringTemplate t = templateLib.getInstanceOf("declaration_int",
                      new STAttrMap().put("counter", _counter));
                    	            retval.stList.add(t);
                    	            for(StringTemplate _t: assign_list)
                    			        {
                    			          StringTemplate t_assign= templateLib.getInstanceOf("assign_var_int",
                      new STAttrMap().put("expression", _t).put("counter", _counter));
                    			          retval.stList.add(t_assign);
                    			          assign_list.remove(_t);
                    			          break;
                    			        }
                    			      }
                    			      
                            }
                            retval.stList.add((expr70!=null?expr70.st:null));        
                          }
                          else
                            errors.add("line "+(delegatename!=null?delegatename.getLine():0)+" unknown variable "+(delegatename!=null?delegatename.getText():null));
                          ((program_scope)program_stack.peek()).curBlock =((call_delegate_scope)call_delegate_stack.peek()).methodName;
                        

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1462:5: '[' delegatename= ID ':' '{' block '}' ']' '(' arg_call ')'
                    {
                    match(input,53,FOLLOW_53_in_call_delegate2297); 
                    ((call_delegate_scope)call_delegate_stack.peek()).methodName = ((program_scope)program_stack.peek()).curBlock;
                    delegatename=(Token)match(input,ID,FOLLOW_ID_in_call_delegate2303); 
                    ((program_scope)program_stack.peek()).curBlock =(delegatename!=null?delegatename.getText():null);
                    match(input,54,FOLLOW_54_in_call_delegate2307); 
                    match(input,11,FOLLOW_11_in_call_delegate2309); 
                    pushFollow(FOLLOW_block_in_call_delegate2311);
                    block72=block();

                    state._fsp--;

                    match(input,12,FOLLOW_12_in_call_delegate2313); 
                    match(input,55,FOLLOW_55_in_call_delegate2315); 
                    match(input,14,FOLLOW_14_in_call_delegate2317); 
                    ((program_scope)program_stack.peek()).curBlock =((call_delegate_scope)call_delegate_stack.peek()).methodName;
                    pushFollow(FOLLOW_arg_call_in_call_delegate2321);
                    arg_call73=arg_call();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_call_delegate2323); 

                        if(names.isExistDelegate((delegatename!=null?delegatename.getText():null)))
                        {
                            NamesTable.DelegateName delName = names.getDelegate((delegatename!=null?delegatename.getText():null));
                            String functionName = delName.getNameFunction();
                            NamesTable.FunctionName funcName = names.getFunction(functionName);
                            retval.line = (delegatename!=null?delegatename.getLine():0);
                            retval.type = funcName.getReturnType();
                            if(!TypesChecker.checkTypes(retval.type, (block72!=null?block72.type:null)))
                            {
                              errors.add("line "+retval.line+": delegate return "+(block72!=null?block72.type:null)+", but search type "+retval.type);
                            }
                            if(!names.checkCallFunction(functionName, (arg_call73!=null?arg_call73.argumentTypeList:null), retval.line))
                            {
                              names.getAllErrors(errors);
                            }
                            ArrayList<String> argNames = new ArrayList<String>();
                            argNames = funcName.getArgumentNames();
                            List<StringTemplate> assign_list = (arg_call73!=null?arg_call73.stList:null);
                            for(String arg_name: argNames)
                            {
                                NamesTable.VariableName varName = names.getVariable((delegatename!=null?delegatename.getText():null)+"."+arg_name);
                                int _counter = varName.getNumber();
                                if(TypesChecker.isString(varName.getType())){
                                  StringTemplate t = templateLib.getInstanceOf("declaration_string",
                      new STAttrMap().put("counter", _counter));
                                  retval.stList.add(t);
                                  for(StringTemplate _t: assign_list)
                                  {
                                    StringTemplate t_assign= templateLib.getInstanceOf("assign_var_string",
                      new STAttrMap().put("expression", _t).put("counter", _counter));
                                    retval.stList.add(t_assign);
                                    assign_list.remove(_t);
                                    break;
                                  }
                                }
                                if(TypesChecker.isInteger(varName.getType())){
                                  StringTemplate t = templateLib.getInstanceOf("declaration_int",
                      new STAttrMap().put("counter", _counter));
                                  retval.stList.add(t);
                                  for(StringTemplate _t: assign_list)
                                  {
                                    StringTemplate t_assign= templateLib.getInstanceOf("assign_var_int",
                      new STAttrMap().put("expression", _t).put("counter", _counter));
                                    retval.stList.add(t_assign);
                                    assign_list.remove(_t);
                                    break;
                                  }
                                }
                                
                                if(TypesChecker.isChar(varName.getType())){
                                  StringTemplate t = templateLib.getInstanceOf("declaration_char",
                      new STAttrMap().put("counter", _counter));
                                  retval.stList.add(t);
                                  for(StringTemplate _t: assign_list)
                                  {
                                    StringTemplate t_assign= templateLib.getInstanceOf("assign_var_char",
                      new STAttrMap().put("expression", _t).put("counter", _counter));
                                    retval.stList.add(t_assign);
                                    assign_list.remove(_t);
                                    break;
                                  }
                                }
                                
                            }
                            for(StringTemplate t: (block72!=null?block72.stList:null))
                              retval.stList.add(t);
                        }
                        else
                            errors.add("line "+(delegatename!=null?delegatename.getLine():0)+" unknown variable "+(delegatename!=null?delegatename.getText():null));
                        ((program_scope)program_stack.peek()).curBlock =((call_delegate_scope)call_delegate_stack.peek()).methodName;
                      

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
            call_delegate_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "call_delegate"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA10_eotS =
        "\13\uffff";
    static final String DFA10_eofS =
        "\13\uffff";
    static final String DFA10_minS =
        "\1\4\1\16\11\uffff";
    static final String DFA10_maxS =
        "\1\65\1\22\11\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\11\1\1\1\10";
    static final String DFA10_specialS =
        "\13\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\23\uffff\1\3\1\4\1\5\1\uffff\1\6\1\7\23\uffff\3\2\1\uffff"+
            "\1\10",
            "\1\12\3\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "364:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st} | call_delegate ';' -> {$call_delegate.st});";
        }
    }
    static final String DFA19_eotS =
        "\16\uffff";
    static final String DFA19_eofS =
        "\16\uffff";
    static final String DFA19_minS =
        "\1\4\1\15\14\uffff";
    static final String DFA19_maxS =
        "\1\60\1\67\14\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\1\1\5";
    static final String DFA19_specialS =
        "\16\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\2\1\3\1\4\27\uffff\1\5\1\6\1\7\13\uffff\1\10\1\11\1"+
            "\12\1\13",
            "\1\14\1\15\2\14\2\uffff\5\14\12\uffff\2\14\1\uffff\6\14\14"+
            "\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "710:1: atom returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st} | replace_firstElem -> {$replace_firstElem.st} | substring_op -> {$substring_op.st});";
        }
    }
    static final String DFA33_eotS =
        "\12\uffff";
    static final String DFA33_eofS =
        "\12\uffff";
    static final String DFA33_minS =
        "\1\60\1\16\1\4\2\20\1\4\2\17\2\uffff";
    static final String DFA33_maxS =
        "\1\60\1\16\1\6\2\20\1\5\2\20\2\uffff";
    static final String DFA33_acceptS =
        "\10\uffff\1\1\1\2";
    static final String DFA33_specialS =
        "\12\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\1\uffff\1\4",
            "\1\5",
            "\1\5",
            "\1\6\1\7",
            "\1\10\1\11",
            "\1\10\1\11",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1373:1: substring_op : ( 'subString' '(' first= f_el ',' second= s_el ')' | 'subString' '(' first= f_el ',' second= s_el ',' third= s_el ')' );";
        }
    }
 

    public static final BitSet FOLLOW_global_variables_in_program64 = new BitSet(new long[]{0x001E000000022410L});
    public static final BitSet FOLLOW_delegates_in_program68 = new BitSet(new long[]{0x001E000000020410L});
    public static final BitSet FOLLOW_functions_in_program75 = new BitSet(new long[]{0x001E000000020410L});
    public static final BitSet FOLLOW_mainBlock_in_program87 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_mainBlock133 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_mainBlock135 = new BitSet(new long[]{0x002E000077000010L});
    public static final BitSet FOLLOW_block_in_mainBlock137 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_mainBlock139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_declaration_in_global_variables167 = new BitSet(new long[]{0x000E000000002000L});
    public static final BitSet FOLLOW_13_in_global_variables173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_declaration187 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_declaration189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_func_in_functions230 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functions237 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_functions242 = new BitSet(new long[]{0x000E000000008000L});
    public static final BitSet FOLLOW_arg_list_in_functions244 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_functions246 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_functions254 = new BitSet(new long[]{0x002E000077000010L});
    public static final BitSet FOLLOW_block_in_functions259 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_functions262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_arg_list318 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list322 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_list332 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_type_in_arg_list336 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list340 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_17_in_delegates378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_delegates382 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_delegates384 = new BitSet(new long[]{0x001E000000000010L});
    public static final BitSet FOLLOW_type_func_in_delegates387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_delegates414 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_delegates421 = new BitSet(new long[]{0x000E000000008000L});
    public static final BitSet FOLLOW_arg_del_in_delegates425 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_delegates427 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_delegates429 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_delegates443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_arg_del473 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_del477 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_del490 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_type_in_arg_del494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_del498 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_statements_in_block545 = new BitSet(new long[]{0x002E000077000010L});
    public static final BitSet FOLLOW_return_stmt_in_block552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_stmt_in_statements573 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_stmt_in_statements585 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_stmt_in_statements597 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_strm_in_statements609 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_statements621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_stmt_in_statements631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_stmt_in_statements641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_stmt_in_statements651 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_delegate_in_statements667 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assign_stmt697 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_assign_stmt699 = new BitSet(new long[]{0x002FE003B70000F0L});
    public static final BitSet FOLLOW_expr_in_assign_stmt702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_delegate_in_assign_stmt710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_in_expr737 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_expr753 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_20_in_expr757 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_expr_in_expr762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_power_in_mult796 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_21_in_mult811 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_22_in_mult816 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_mult_in_mult821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cast_stmt_in_power864 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_power877 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_power_in_power881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_cast_stmt918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_stmt938 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_decl_stmt940 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_decl_stmt947 = new BitSet(new long[]{0x002FE003B70000F0L});
    public static final BitSet FOLLOW_expr_in_decl_stmt950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_delegate_in_decl_stmt958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_write_stmt980 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_write_stmt982 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_atom_in_write_stmt984 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_write_stmt986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_atom1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_atom1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_stmt_in_atom1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elem_stmt_in_atom1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_string_stmt_in_atom1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indexOf_stmt_in_atom1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_op_in_atom1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_firstElem_in_atom1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_substring_op_in_atom1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_char_c1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_read_strm1206 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_read_strm1208 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_read_strm1210 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_read_strm1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_if_stmt1230 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_stmt1232 = new BitSet(new long[]{0x0001F813800000F0L});
    public static final BitSet FOLLOW_expression_in_if_stmt1234 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_if_stmt1236 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt1238 = new BitSet(new long[]{0x002E000077000010L});
    public static final BitSet FOLLOW_block_in_if_stmt1242 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt1244 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_if_stmt1247 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt1249 = new BitSet(new long[]{0x002E000077000010L});
    public static final BitSet FOLLOW_block_in_if_stmt1253 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_for_stmt1274 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_for_stmt1276 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt1280 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt1282 = new BitSet(new long[]{0x0001F813800000F0L});
    public static final BitSet FOLLOW_expression_in_for_stmt1286 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt1288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt1292 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_for_stmt1294 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_for_stmt1296 = new BitSet(new long[]{0x002E000077000010L});
    public static final BitSet FOLLOW_block_in_for_stmt1300 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_for_stmt1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_while_stmt1319 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_stmt1321 = new BitSet(new long[]{0x0001F813800000F0L});
    public static final BitSet FOLLOW_expression_in_while_stmt1325 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_while_stmt1327 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_while_stmt1329 = new BitSet(new long[]{0x002E000077000010L});
    public static final BitSet FOLLOW_block_in_while_stmt1333 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_while_stmt1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_return_stmt1359 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_atom_in_return_stmt1361 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_return_stmt1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_length_stmt1390 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_length_stmt1392 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_param_in_length_stmt1394 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_length_stmt1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_param1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_elem_stmt1450 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_elem_stmt1452 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_elem_stmt1453 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_elem_stmt1455 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_elem_stmt1457 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_elem_stmt1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_f_el1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_f_el1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_s_el1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_s_el1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_to_string_stmt1543 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_to_string_stmt1545 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_param_str_in_to_string_stmt1547 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_to_string_stmt1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param_str1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_param_str1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_param_str1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_call_func_stmt1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func1644 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_call_func1647 = new BitSet(new long[]{0x0001E003800080F0L});
    public static final BitSet FOLLOW_arg_call_in_call_func1649 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_call_func1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_arg_call1679 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_call1684 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_atom_in_arg_call1688 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_and_expression_in_expression1711 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_expression1716 = new BitSet(new long[]{0x0001F813800000F0L});
    public static final BitSet FOLLOW_expression_in_expression1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_expression_in_and_expression1746 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_and_expression1751 = new BitSet(new long[]{0x0001F813800000F0L});
    public static final BitSet FOLLOW_and_expression_in_and_expression1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_not_expression1777 = new BitSet(new long[]{0x0001F813800000F0L});
    public static final BitSet FOLLOW_not_expression_in_not_expression1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_not_expression1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_comparison1810 = new BitSet(new long[]{0x000007E000000000L});
    public static final BitSet FOLLOW_set_in_comparison1814 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_atom_in_comparison1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equal_op_in_comparison1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_contain_op_in_comparison1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_equal_op1867 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_equal_op1869 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_equal_op1873 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_equal_op1875 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_equal_op1879 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_equal_op1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_contain_op1900 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_contain_op1902 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_contain_op1906 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_contain_op1908 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_contain_op1912 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_contain_op1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_indexOf_stmt1933 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_indexOf_stmt1935 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_indexOf_stmt1939 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_indexOf_stmt1941 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_indexOf_stmt1945 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_indexOf_stmt1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_replace_op1965 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_replace_op1967 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_op1969 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_op1971 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_char_param_in_replace_op1975 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_op1977 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_char_param_in_replace_op1981 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_replace_op1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_char_param1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_char_param2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_replace_firstElem2026 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_replace_firstElem2028 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_firstElem2032 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_firstElem2034 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_firstElem2038 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_firstElem2040 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_firstElem2044 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_replace_firstElem2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_substring_op2066 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_substring_op2068 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_substring_op2072 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_substring_op2074 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_substring_op2078 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_substring_op2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_substring_op2087 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_substring_op2089 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_substring_op2093 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_substring_op2095 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_substring_op2099 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_substring_op2101 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_substring_op2105 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_substring_op2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_type2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_type2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_type2156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_type_func2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_type_func2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_type_func2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_type_func2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_call_delegate2263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_call_delegate2269 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_call_delegate2273 = new BitSet(new long[]{0x0001E003800000F0L});
    public static final BitSet FOLLOW_expr_in_call_delegate2275 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_call_delegate2277 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_call_delegate2279 = new BitSet(new long[]{0x0001E003800080F0L});
    public static final BitSet FOLLOW_arg_call_in_call_delegate2283 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_call_delegate2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_call_delegate2297 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_call_delegate2303 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_call_delegate2307 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_call_delegate2309 = new BitSet(new long[]{0x002E000077000010L});
    public static final BitSet FOLLOW_block_in_call_delegate2311 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_call_delegate2313 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_call_delegate2315 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_call_delegate2317 = new BitSet(new long[]{0x0001E003800080F0L});
    public static final BitSet FOLLOW_arg_call_in_call_delegate2321 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_call_delegate2323 = new BitSet(new long[]{0x0000000000000002L});

}