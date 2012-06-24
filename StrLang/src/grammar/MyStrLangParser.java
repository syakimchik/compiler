// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g 2012-06-25 00:56:52

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "STRING", "CHAR", "COMMENT", "WS", "'main'", "'{'", "'}'", "';'", "'('", "')'", "','", "'delegate'", "'='", "'=>'", "'+'", "'-'", "'*'", "'/'", "'^'", "'write'", "'read'", "'if'", "'else'", "'for'", "'while'", "'return'", "'length'", "'elem'", "'ToString'", "'||'", "'&&'", "'!'", "'<'", "'>'", "'=='", "'!='", "'>='", "'<='", "'equals'", "'contains'", "'indexOf'", "'replace'", "'replaceFirst'", "'subString'", "'int'", "'string'", "'char'", "'void'", "'.'"
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


    		private static String programName = "";
    		private int counter;
    		private int labelCounter;
    		private String _funcName = "";
    		private String _funcType = "";
    		List<StringTemplate> stDelList;
    		
    		protected NamesTable names = new NamesTable();
    		protected ArrayList<String> errors = new ArrayList<String>();
    		protected ArrayList<String> tmpVarNamesList = new ArrayList<String>();
    		
    		public static StringTemplateGroup templateGroup;
    		public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";	//testing line
    		//public static final String templateFileName = "template/ByteCode.stg";	//line for jar file
    		
    		/**
    		* @param args
    		*/
    		public static void main(String[] args) throws Exception {
    			templateGroup = new StringTemplateGroup(new FileReader(templateFileName), AngleBracketTemplateLexer.class);
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
        List global_variables;
        List functions;
    }
    protected Stack program_stack = new Stack();

    public static class program_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "program"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:97:1: program : ( global_variables )* ( functions )* ( delegates )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName);
    public final MyStrLangParser.program_return program() throws RecognitionException {
        program_stack.push(new program_scope());
        MyStrLangParser.program_return retval = new MyStrLangParser.program_return();
        retval.start = input.LT(1);

        MyStrLangParser.functions_return functions1 = null;

        MyStrLangParser.delegates_return delegates2 = null;

        MyStrLangParser.mainBlock_return mainBlock3 = null;



        	((program_scope)program_stack.peek()).curBlock = "";
        	((program_scope)program_stack.peek()).global_variables = new ArrayList();
        	((program_scope)program_stack.peek()).functions = new ArrayList();
        	stDelList = new ArrayList<StringTemplate>();
        	//counter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:110:2: ( ( global_variables )* ( functions )* ( delegates )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:110:4: ( global_variables )* ( functions )* ( delegates )* mainBlock EOF
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:110:4: ( global_variables )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 50:
                    {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=50 && LA1_6<=52)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 51:
                    {
                    int LA1_3 = input.LA(2);

                    if ( (LA1_3==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=50 && LA1_6<=52)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 52:
                    {
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=50 && LA1_6<=52)) ) {
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
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:110:4: global_variables
            	    {
            	    pushFollow(FOLLOW_global_variables_in_program61);
            	    global_variables();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:110:22: ( functions )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||(LA2_0>=50 && LA2_0<=53)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:110:23: functions
            	    {
            	    pushFollow(FOLLOW_functions_in_program65);
            	    functions1=functions();

            	    state._fsp--;

            	    ((program_scope)program_stack.peek()).functions.add((functions1!=null?functions1.st:null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:111:4: ( delegates )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:111:5: delegates
            	    {
            	    pushFollow(FOLLOW_delegates_in_program76);
            	    delegates2=delegates();

            	    state._fsp--;

            	    ((program_scope)program_stack.peek()).functions.add((delegates2!=null?delegates2.st:null));

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
            // 113:3: -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:1: mainBlock : 'main' '{' block '}' -> mainBlock(block=$block.stList);
    public final MyStrLangParser.mainBlock_return mainBlock() throws RecognitionException {
        MyStrLangParser.mainBlock_return retval = new MyStrLangParser.mainBlock_return();
        retval.start = input.LT(1);

        MyStrLangParser.block_return block4 = null;



        	counter = 0;
        	labelCounter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:121:2: ( 'main' '{' block '}' -> mainBlock(block=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:121:4: 'main' '{' block '}'
            {
            match(input,10,FOLLOW_10_in_mainBlock131); 
            match(input,11,FOLLOW_11_in_mainBlock133); 
            pushFollow(FOLLOW_block_in_mainBlock135);
            block4=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_mainBlock137); 


            // TEMPLATE REWRITE
            // 122:3: -> mainBlock(block=$block.stList)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:125:1: global_variables : ( global_declaration )* ';' ;
    public final MyStrLangParser.global_variables_return global_variables() throws RecognitionException {
        MyStrLangParser.global_variables_return retval = new MyStrLangParser.global_variables_return();
        retval.start = input.LT(1);

        MyStrLangParser.global_declaration_return global_declaration5 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:126:2: ( ( global_declaration )* ';' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:126:4: ( global_declaration )* ';'
            {
             ((program_scope)program_stack.peek()).curBlock = "global";
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:126:38: ( global_declaration )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=50 && LA4_0<=52)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:126:39: global_declaration
            	    {
            	    pushFollow(FOLLOW_global_declaration_in_global_variables163);
            	    global_declaration5=global_declaration();

            	    state._fsp--;

            	    ((program_scope)program_stack.peek()).global_variables.add((global_declaration5!=null?global_declaration5.st:null));

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_global_variables169); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:129:1: global_declaration : type ID -> global_declaration(ident=$ID.texttype=$type.st);
    public final MyStrLangParser.global_declaration_return global_declaration() throws RecognitionException {
        MyStrLangParser.global_declaration_return retval = new MyStrLangParser.global_declaration_return();
        retval.start = input.LT(1);

        Token ID6=null;
        MyStrLangParser.type_return type7 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:130:2: ( type ID -> global_declaration(ident=$ID.texttype=$type.st))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:130:4: type ID
            {
            pushFollow(FOLLOW_type_in_global_declaration181);
            type7=type();

            state._fsp--;

            ID6=(Token)match(input,ID,FOLLOW_ID_in_global_declaration183); 

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
            				errors.add("line "+(ID6!=null?ID6.getLine():0)+": Duplicated variable name "+(ID6!=null?ID6.getText():null));
            		}
            	


            // TEMPLATE REWRITE
            // 146:2: -> global_declaration(ident=$ID.texttype=$type.st)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:149:1: functions : type_func ID '(' arg_list ')' '{' block '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList);
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
        	counter=0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:166:2: ( type_func ID '(' arg_list ')' '{' block '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:166:4: type_func ID '(' arg_list ')' '{' block '}'
            {
            pushFollow(FOLLOW_type_func_in_functions222);
            type_func8=type_func();

            state._fsp--;

            ((functions_scope)functions_stack.peek()).funcType = (type_func8!=null?input.toString(type_func8.start,type_func8.stop):null); _funcType = (type_func8!=null?input.toString(type_func8.start,type_func8.stop):null); 
            ID9=(Token)match(input,ID,FOLLOW_ID_in_functions229); 
            ((program_scope)program_stack.peek()).curBlock = (ID9!=null?ID9.getText():null); ((functions_scope)functions_stack.peek()).funcName =(ID9!=null?ID9.getText():null); _funcName = (ID9!=null?ID9.getText():null);
            match(input,14,FOLLOW_14_in_functions234); 
            pushFollow(FOLLOW_arg_list_in_functions236);
            arg_list10=arg_list();

            state._fsp--;

            match(input,15,FOLLOW_15_in_functions238); 

            		if(!names.isExistFunction((ID9!=null?ID9.getText():null)))
            		{
            			names.addFunction(names.new FunctionName((ID9!=null?ID9.getText():null), (type_func8!=null?input.toString(type_func8.start,type_func8.stop):null), ((functions_scope)functions_stack.peek()).funcArgTypes, ((functions_scope)functions_stack.peek()).funcArgNames, (ID9!=null?ID9.getLine():0)));
            		}
            		else
            		{
            			errors.add("line "+(ID9!=null?ID9.getLine():0)+": Duplicated declaration function "+(ID9!=null?ID9.getText():null));
            		}
            	
            match(input,11,FOLLOW_11_in_functions246); 
            pushFollow(FOLLOW_block_in_functions251);
            block11=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_functions254); 


            // TEMPLATE REWRITE
            // 183:2: -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:186:1: arg_list returns [List<StringTemplate> stList] : (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? ;
    public final MyStrLangParser.arg_list_return arg_list() throws RecognitionException {
        MyStrLangParser.arg_list_return retval = new MyStrLangParser.arg_list_return();
        retval.start = input.LT(1);

        Token firstId=null;
        Token secondId=null;
        MyStrLangParser.type_return firstType = null;

        MyStrLangParser.type_return secondType = null;



        	retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:190:2: ( (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:190:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:190:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=50 && LA6_0<=52)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:191:3: firstType= type firstId= ID ( ',' secondType= type secondId= ID )*
                    {
                    pushFollow(FOLLOW_type_in_arg_list308);
                    firstType=type();

                    state._fsp--;

                    firstId=(Token)match(input,ID,FOLLOW_ID_in_arg_list312); 

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
                    		
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:208:4: ( ',' secondType= type secondId= ID )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:208:5: ',' secondType= type secondId= ID
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_list322); 
                    	    pushFollow(FOLLOW_type_in_arg_list326);
                    	    secondType=type();

                    	    state._fsp--;

                    	    secondId=(Token)match(input,ID,FOLLOW_ID_in_arg_list330); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:229:1: delegates : 'delegate' nameDelegate= ID '{' type_func nameFunc= ID '(' arg_del ')' ';' '}' delegate_stmt_decl -> functions(type=$type_func.stident=$nameDelegate.text+$nameFunc.textargs=$arg_del.stListreturnType=$type_func.returnTypeblock=$delegate_stmt_decl.stList);
    public final MyStrLangParser.delegates_return delegates() throws RecognitionException {
        delegates_stack.push(new delegates_scope());
        MyStrLangParser.delegates_return retval = new MyStrLangParser.delegates_return();
        retval.start = input.LT(1);

        Token nameDelegate=null;
        Token nameFunc=null;
        MyStrLangParser.type_func_return type_func12 = null;

        MyStrLangParser.arg_del_return arg_del13 = null;

        MyStrLangParser.delegate_stmt_decl_return delegate_stmt_decl14 = null;



          ((delegates_scope)delegates_stack.peek()).delName = "";
          ((delegates_scope)delegates_stack.peek()).delType = "";
          ((delegates_scope)delegates_stack.peek()).delArgNames = new ArrayList<String>();
          ((delegates_scope)delegates_stack.peek()).delArgTypes = new ArrayList<String>();
          labelCounter = 0;
          counter=0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:246:2: ( 'delegate' nameDelegate= ID '{' type_func nameFunc= ID '(' arg_del ')' ';' '}' delegate_stmt_decl -> functions(type=$type_func.stident=$nameDelegate.text+$nameFunc.textargs=$arg_del.stListreturnType=$type_func.returnTypeblock=$delegate_stmt_decl.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:246:4: 'delegate' nameDelegate= ID '{' type_func nameFunc= ID '(' arg_del ')' ';' '}' delegate_stmt_decl
            {
            match(input,17,FOLLOW_17_in_delegates366); 
            nameDelegate=(Token)match(input,ID,FOLLOW_ID_in_delegates370); 
            match(input,11,FOLLOW_11_in_delegates372); 
            pushFollow(FOLLOW_type_func_in_delegates375);
            type_func12=type_func();

            state._fsp--;

            ((delegates_scope)delegates_stack.peek()).delType = (type_func12!=null?input.toString(type_func12.start,type_func12.stop):null); _funcType = (type_func12!=null?input.toString(type_func12.start,type_func12.stop):null); 
            nameFunc=(Token)match(input,ID,FOLLOW_ID_in_delegates402); 
            ((program_scope)program_stack.peek()).curBlock = (nameDelegate!=null?nameDelegate.getText():null); ((delegates_scope)delegates_stack.peek()).delName =(nameFunc!=null?nameFunc.getText():null); 
            match(input,14,FOLLOW_14_in_delegates409); 
            pushFollow(FOLLOW_arg_del_in_delegates411);
            arg_del13=arg_del();

            state._fsp--;

            match(input,15,FOLLOW_15_in_delegates413); 
            match(input,13,FOLLOW_13_in_delegates415); 

            	    if(!names.isExistDelegate((nameDelegate!=null?nameDelegate.getText():null)))
            	    {
            	      names.addDelegate(names.new DelegateName((nameDelegate!=null?nameDelegate.getText():null), (nameDelegate!=null?nameDelegate.getText():null)+(nameFunc!=null?nameFunc.getText():null), (type_func12!=null?input.toString(type_func12.start,type_func12.stop):null), ((delegates_scope)delegates_stack.peek()).delArgTypes, ((delegates_scope)delegates_stack.peek()).delArgNames, (nameDelegate!=null?nameDelegate.getLine():0)));
            	      names.addFunction(names.new FunctionName((nameDelegate!=null?nameDelegate.getText():null)+(nameFunc!=null?nameFunc.getText():null), (type_func12!=null?input.toString(type_func12.start,type_func12.stop):null), ((delegates_scope)delegates_stack.peek()).delArgTypes, ((delegates_scope)delegates_stack.peek()).delArgNames, (nameDelegate!=null?nameDelegate.getLine():0)));
            	    }
            	    else
            	    {
            	      errors.add("line "+(nameDelegate!=null?nameDelegate.getLine():0)+": Duplicated declaration delegate "+(nameDelegate!=null?nameDelegate.getText():null));
            	    }
            	  
            match(input,12,FOLLOW_12_in_delegates429); 
            pushFollow(FOLLOW_delegate_stmt_decl_in_delegates434);
            delegate_stmt_decl14=delegate_stmt_decl();

            state._fsp--;



            // TEMPLATE REWRITE
            // 263:4: -> functions(type=$type_func.stident=$nameDelegate.text+$nameFunc.textargs=$arg_del.stListreturnType=$type_func.returnTypeblock=$delegate_stmt_decl.stList)
            {
                retval.st = templateLib.getInstanceOf("functions",
              new STAttrMap().put("type", (type_func12!=null?type_func12.st:null)).put("ident", (nameDelegate!=null?nameDelegate.getText():null)+(nameFunc!=null?nameFunc.getText():null)).put("args", (arg_del13!=null?arg_del13.stList:null)).put("returnType", (type_func12!=null?type_func12.returnType:null)).put("block", (delegate_stmt_decl14!=null?delegate_stmt_decl14.stList:null)));
            }


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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:266:1: arg_del returns [List<StringTemplate> stList] : (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? ;
    public final MyStrLangParser.arg_del_return arg_del() throws RecognitionException {
        MyStrLangParser.arg_del_return retval = new MyStrLangParser.arg_del_return();
        retval.start = input.LT(1);

        Token firstId=null;
        Token secondId=null;
        MyStrLangParser.type_return firstType = null;

        MyStrLangParser.type_return secondType = null;



          retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:270:3: ( (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:270:5: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:270:5: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=50 && LA8_0<=52)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:271:5: firstType= type firstId= ID ( ',' secondType= type secondId= ID )*
                    {
                    pushFollow(FOLLOW_type_in_arg_del494);
                    firstType=type();

                    state._fsp--;

                    firstId=(Token)match(input,ID,FOLLOW_ID_in_arg_del498); 

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
                        
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:288:5: ( ',' secondType= type secondId= ID )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:288:6: ',' secondType= type secondId= ID
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_del511); 
                    	    pushFollow(FOLLOW_type_in_arg_del515);
                    	    secondType=type();

                    	    state._fsp--;

                    	    secondId=(Token)match(input,ID,FOLLOW_ID_in_arg_del519); 

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

    public static class delegate_stmt_decl_return extends ParserRuleReturnScope {
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "delegate_stmt_decl"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:309:1: delegate_stmt_decl returns [List<StringTemplate> stList] : nameDelegate= ID varName= ID '=' b= ID '=>' ( '{' block '}' | expr ) ';' ;
    public final MyStrLangParser.delegate_stmt_decl_return delegate_stmt_decl() throws RecognitionException {
        MyStrLangParser.delegate_stmt_decl_return retval = new MyStrLangParser.delegate_stmt_decl_return();
        retval.start = input.LT(1);

        Token nameDelegate=null;
        Token varName=null;
        Token b=null;
        MyStrLangParser.block_return block15 = null;

        MyStrLangParser.expr_return expr16 = null;



          retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:313:3: (nameDelegate= ID varName= ID '=' b= ID '=>' ( '{' block '}' | expr ) ';' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:313:5: nameDelegate= ID varName= ID '=' b= ID '=>' ( '{' block '}' | expr ) ';'
            {
            nameDelegate=(Token)match(input,ID,FOLLOW_ID_in_delegate_stmt_decl564); 
            varName=(Token)match(input,ID,FOLLOW_ID_in_delegate_stmt_decl568); 
            match(input,18,FOLLOW_18_in_delegate_stmt_decl570); 
            b=(Token)match(input,ID,FOLLOW_ID_in_delegate_stmt_decl574); 
            match(input,19,FOLLOW_19_in_delegate_stmt_decl576); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:314:3: ( '{' block '}' | expr )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==11) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=ID && LA9_0<=CHAR)||(LA9_0>=32 && LA9_0<=34)||(LA9_0>=46 && LA9_0<=49)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:314:4: '{' block '}'
                    {
                    match(input,11,FOLLOW_11_in_delegate_stmt_decl582); 

                            NamesTable.DelegateName del = names.getDelegate((nameDelegate!=null?nameDelegate.getText():null));
                            String t = del.getNameFunction();
                            ((program_scope)program_stack.peek()).curBlock = t;
                    pushFollow(FOLLOW_block_in_delegate_stmt_decl596);
                    block15=block();

                    state._fsp--;

                    retval.stList = (block15!=null?block15.stList:null);
                    match(input,12,FOLLOW_12_in_delegate_stmt_decl600); 
                        
                    	    if(!names.isExistDelegate((nameDelegate!=null?nameDelegate.getText():null)))
                    	        errors.add("line "+(nameDelegate!=null?nameDelegate.getLine():0)+": unknown delegate "+(nameDelegate!=null?nameDelegate.getText():null));
                    	    if(!names.isDeclaredVariable("global."+(varName!=null?varName.getText():null)))
                    	    {
                    	      NamesTable.VariableName var = names.new VariableName("global."+(varName!=null?varName.getText():null), (nameDelegate!=null?nameDelegate.getText():null), (varName!=null?varName.getLine():0));
                    	      var.setNumber(counter);
                            names.addVariable(var);
                            counter++;
                    	    }
                    	    else
                    	    {
                    	      if(names.isDeclaredVariable("global."+(varName!=null?varName.getText():null)))
                    	        errors.add("line "+(varName!=null?varName.getLine():0)+": Duplicated variable name "+(varName!=null?varName.getText():null));
                    	    } 
                    	    
                    	  

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:337:5: expr
                    {
                    pushFollow(FOLLOW_expr_in_delegate_stmt_decl611);
                    expr16=expr();

                    state._fsp--;


                    	      retval.stList.add((expr16!=null?expr16.st:null));
                    	      if(!names.isExistDelegate((nameDelegate!=null?nameDelegate.getText():null)))
                              errors.add("line "+(nameDelegate!=null?nameDelegate.getLine():0)+": unknown delegate "+(nameDelegate!=null?nameDelegate.getText():null));
                    	      if(!names.isDeclaredVariable("global."+(varName!=null?varName.getText():null)))
                    	      {   
                    	        NamesTable.VariableName var = names.new VariableName("global."+(varName!=null?varName.getText():null), (nameDelegate!=null?nameDelegate.getText():null), (varName!=null?varName.getLine():0));
                    	        var.setNumber(counter);
                    	        names.addVariable(var);
                    	        counter++;
                    	      }
                    	      else
                    	      {
                    	        if(names.isDeclaredVariable("global."+(varName!=null?varName.getText():null)))
                    	          errors.add("line "+(varName!=null?varName.getLine():0)+": Duplicated variable name "+(varName!=null?varName.getText():null));
                    	      }
                    	      retval.st = (expr16!=null?expr16.st:null);
                    	    

                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_delegate_stmt_decl624); 

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
    // $ANTLR end "delegate_stmt_decl"

    public static class block_return extends ParserRuleReturnScope {
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "block"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:360:1: block returns [List<StringTemplate> stList] : ( statements )* ( return_stmt ) ;
    public final MyStrLangParser.block_return block() throws RecognitionException {
        MyStrLangParser.block_return retval = new MyStrLangParser.block_return();
        retval.start = input.LT(1);

        MyStrLangParser.statements_return statements17 = null;

        MyStrLangParser.return_stmt_return return_stmt18 = null;



        	retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:364:2: ( ( statements )* ( return_stmt ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:364:4: ( statements )* ( return_stmt )
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:364:4: ( statements )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==ID||(LA10_0>=25 && LA10_0<=27)||(LA10_0>=29 && LA10_0<=30)||(LA10_0>=50 && LA10_0<=52)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:364:5: statements
            	    {
            	    pushFollow(FOLLOW_statements_in_block649);
            	    statements17=statements();

            	    state._fsp--;

            	    retval.stList.add((statements17!=null?statements17.st:null));

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:364:49: ( return_stmt )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:364:50: return_stmt
            {
            pushFollow(FOLLOW_return_stmt_in_block656);
            return_stmt18=return_stmt();

            state._fsp--;

            retval.stList.add((return_stmt18!=null?return_stmt18.st:null));

            }

            		
            			if(((program_scope)program_stack.peek()).curBlock!="main"){
            			  String name = ((program_scope)program_stack.peek()).curBlock;
            			  if(names.isExistFunction(name)){
            					NamesTable.FunctionName func = names.getFunction(name);
            					String type = func.getReturnType();
            					if((return_stmt18!=null?return_stmt18.value:null)==null)
            					{
            						if(!type.equals("void"))
            							errors.add("line "+(return_stmt18!=null?return_stmt18.line:0)+": Not found the keyword return in function with name "+name);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:381:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st} | call_delegate ';' -> {$call_delegate.st});
    public final MyStrLangParser.statements_return statements() throws RecognitionException {
        MyStrLangParser.statements_return retval = new MyStrLangParser.statements_return();
        retval.start = input.LT(1);

        MyStrLangParser.assign_stmt_return assign_stmt19 = null;

        MyStrLangParser.decl_stmt_return decl_stmt20 = null;

        MyStrLangParser.write_stmt_return write_stmt21 = null;

        MyStrLangParser.read_strm_return read_strm22 = null;

        MyStrLangParser.if_stmt_return if_stmt23 = null;

        MyStrLangParser.for_stmt_return for_stmt24 = null;

        MyStrLangParser.while_stmt_return while_stmt25 = null;

        MyStrLangParser.call_func_stmt_return call_func_stmt26 = null;

        MyStrLangParser.call_delegate_return call_delegate27 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:382:2: ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st} | call_delegate ';' -> {$call_delegate.st})
            int alt11=9;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:382:5: assign_stmt ';'
                    {
                    pushFollow(FOLLOW_assign_stmt_in_statements675);
                    assign_stmt19=assign_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements677); 


                    // TEMPLATE REWRITE
                    // 382:21: -> {$assign_stmt.st}
                    {
                        retval.st = (assign_stmt19!=null?assign_stmt19.st:null);
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:383:5: decl_stmt ';'
                    {
                    pushFollow(FOLLOW_decl_stmt_in_statements687);
                    decl_stmt20=decl_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements689); 


                    // TEMPLATE REWRITE
                    // 383:19: -> {$decl_stmt.st}
                    {
                        retval.st = (decl_stmt20!=null?decl_stmt20.st:null);
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:384:5: write_stmt ';'
                    {
                    pushFollow(FOLLOW_write_stmt_in_statements699);
                    write_stmt21=write_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements701); 


                    // TEMPLATE REWRITE
                    // 384:20: -> {$write_stmt.st}
                    {
                        retval.st = (write_stmt21!=null?write_stmt21.st:null);
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:385:5: read_strm ';'
                    {
                    pushFollow(FOLLOW_read_strm_in_statements711);
                    read_strm22=read_strm();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements713); 


                    // TEMPLATE REWRITE
                    // 385:19: -> {$read_strm.st}
                    {
                        retval.st = (read_strm22!=null?read_strm22.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:386:5: if_stmt
                    {
                    pushFollow(FOLLOW_if_stmt_in_statements723);
                    if_stmt23=if_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 386:13: -> {$if_stmt.st}
                    {
                        retval.st = (if_stmt23!=null?if_stmt23.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:387:5: for_stmt
                    {
                    pushFollow(FOLLOW_for_stmt_in_statements733);
                    for_stmt24=for_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 387:14: -> {$for_stmt.st}
                    {
                        retval.st = (for_stmt24!=null?for_stmt24.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:388:5: while_stmt
                    {
                    pushFollow(FOLLOW_while_stmt_in_statements743);
                    while_stmt25=while_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 388:16: -> {$while_stmt.st}
                    {
                        retval.st = (while_stmt25!=null?while_stmt25.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:389:5: call_func_stmt ';'
                    {
                    pushFollow(FOLLOW_call_func_stmt_in_statements753);
                    call_func_stmt26=call_func_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements755); 


                    // TEMPLATE REWRITE
                    // 389:24: -> {$call_func_stmt.st}
                    {
                        retval.st = (call_func_stmt26!=null?call_func_stmt26.st:null);
                    }


                    }
                    break;
                case 9 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:390:5: call_delegate ';'
                    {
                    pushFollow(FOLLOW_call_delegate_in_statements769);
                    call_delegate27=call_delegate();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements771); 


                    // TEMPLATE REWRITE
                    // 390:33: -> {$call_delegate.st}
                    {
                        retval.st = (call_delegate27!=null?call_delegate27.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:393:1: assign_stmt : ID '=' expr ;
    public final MyStrLangParser.assign_stmt_return assign_stmt() throws RecognitionException {
        MyStrLangParser.assign_stmt_return retval = new MyStrLangParser.assign_stmt_return();
        retval.start = input.LT(1);

        Token ID28=null;
        MyStrLangParser.expr_return expr29 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:394:2: ( ID '=' expr )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:394:4: ID '=' expr
            {
            ID28=(Token)match(input,ID,FOLLOW_ID_in_assign_stmt797); 
            match(input,18,FOLLOW_18_in_assign_stmt799); 
            pushFollow(FOLLOW_expr_in_assign_stmt801);
            expr29=expr();

            state._fsp--;


            		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID28!=null?ID28.getText():null)))
            		{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID28!=null?ID28.getText():null));
            			String varType = var_type.getType();
            			if(!TypesChecker.checkTypes(varType, (expr29!=null?expr29.type:null)))
            			{
            			  /*if(TypesChecker.checkTypes(varType, "delegate"))
            	      {
            	         //System.out.println("Good");
            	      }
            				else
            				*/
            				  errors.add("line "+(ID28!=null?ID28.getLine():0)+": Type mismatch: cannot convert from "+varType+" to "+(expr29!=null?expr29.type:null));
            			}
            			if(TypesChecker.isInteger(varType))
            			{
            				if(names.isGlobal((ID28!=null?ID28.getText():null))){
            					retval.st = templateLib.getInstanceOf("assign_field_int",
              new STAttrMap().put("expression", (expr29!=null?expr29.st:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
            				} 
            				else{
            					retval.st = templateLib.getInstanceOf("assign_var_int",
              new STAttrMap().put("expression", (expr29!=null?expr29.st:null)).put("counter", var_type.getNumber()));
            				}
            			}
            			if(TypesChecker.isString(varType))
            			{
            				if(names.isGlobal((ID28!=null?ID28.getText():null))){
            					retval.st = templateLib.getInstanceOf("assign_field_string",
              new STAttrMap().put("expression", (expr29!=null?expr29.st:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
            				} 
            				else{
            					retval.st = templateLib.getInstanceOf("assign_var_string",
              new STAttrMap().put("expression", (expr29!=null?expr29.st:null)).put("counter", var_type.getNumber()));
            				}
            			}
            			if(TypesChecker.isChar(varType))
            			{
            				if(names.isGlobal((ID28!=null?ID28.getText():null))){
            					retval.st = templateLib.getInstanceOf("assign_field_char",
              new STAttrMap().put("expression", (expr29!=null?expr29.st:null)).put("programName", programName).put("fieldName", (ID28!=null?ID28.getText():null)));
            				} 
            				else{
            					retval.st = templateLib.getInstanceOf("assign_var_char",
              new STAttrMap().put("expression", (expr29!=null?expr29.st:null)).put("counter", var_type.getNumber()));
            				}
            			}
            			
            		}
            		else{
                    errors.add("line "+(ID28!=null?ID28.getLine():0)+": unknown variable "+(ID28!=null?ID28.getText():null));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:445:1: expr returns [String type] : firstAssign= mult ( (op= '+' | op= '-' ) secondAssign= expr )? ;
    public final MyStrLangParser.expr_return expr() throws RecognitionException {
        MyStrLangParser.expr_return retval = new MyStrLangParser.expr_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.mult_return firstAssign = null;

        MyStrLangParser.expr_return secondAssign = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:446:2: (firstAssign= mult ( (op= '+' | op= '-' ) secondAssign= expr )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:447:3: firstAssign= mult ( (op= '+' | op= '-' ) secondAssign= expr )?
            {
            pushFollow(FOLLOW_mult_in_expr825);
            firstAssign=mult();

            state._fsp--;


            			retval.type = (firstAssign!=null?firstAssign.type:null);
            			retval.st = (firstAssign!=null?firstAssign.st:null);
            		
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:452:3: ( (op= '+' | op= '-' ) secondAssign= expr )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=20 && LA13_0<=21)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:453:4: (op= '+' | op= '-' ) secondAssign= expr
                    {
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:453:4: (op= '+' | op= '-' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==20) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==21) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:453:5: op= '+'
                            {
                            op=(Token)match(input,20,FOLLOW_20_in_expr841); 

                            }
                            break;
                        case 2 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:453:12: op= '-'
                            {
                            op=(Token)match(input,21,FOLLOW_21_in_expr845); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expr_in_expr850);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:488:1: mult returns [String type] : first= power ( (op= '*' | op= '/' ) second= mult )? ;
    public final MyStrLangParser.mult_return mult() throws RecognitionException {
        MyStrLangParser.mult_return retval = new MyStrLangParser.mult_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.power_return first = null;

        MyStrLangParser.mult_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:489:3: (first= power ( (op= '*' | op= '/' ) second= mult )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:489:7: first= power ( (op= '*' | op= '/' ) second= mult )?
            {
            pushFollow(FOLLOW_power_in_mult882);
            first=power();

            state._fsp--;

            retval.type =(first!=null?first.type:null); retval.st = (first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:490:7: ( (op= '*' | op= '/' ) second= mult )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=22 && LA15_0<=23)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:490:8: (op= '*' | op= '/' ) second= mult
                    {
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:490:8: (op= '*' | op= '/' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==22) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==23) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:490:9: op= '*'
                            {
                            op=(Token)match(input,22,FOLLOW_22_in_mult897); 

                            }
                            break;
                        case 2 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:490:17: op= '/'
                            {
                            op=(Token)match(input,23,FOLLOW_23_in_mult902); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_mult_in_mult907);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:521:1: power returns [String type] : first= cast_stmt (op= '^' second= power )? ;
    public final MyStrLangParser.power_return power() throws RecognitionException {
        MyStrLangParser.power_return retval = new MyStrLangParser.power_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.cast_stmt_return first = null;

        MyStrLangParser.power_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:522:3: (first= cast_stmt (op= '^' second= power )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:522:7: first= cast_stmt (op= '^' second= power )?
            {
            pushFollow(FOLLOW_cast_stmt_in_power948);
            first=cast_stmt();

            state._fsp--;

            retval.type =(first!=null?first.type:null); retval.st =(first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:523:7: (op= '^' second= power )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:523:8: op= '^' second= power
                    {
                    op=(Token)match(input,24,FOLLOW_24_in_power961); 
                    pushFollow(FOLLOW_power_in_power965);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:548:1: cast_stmt returns [String type] : atom ;
    public final MyStrLangParser.cast_stmt_return cast_stmt() throws RecognitionException {
        MyStrLangParser.cast_stmt_return retval = new MyStrLangParser.cast_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return atom30 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:549:3: ( atom )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:549:7: atom
            {
            pushFollow(FOLLOW_atom_in_cast_stmt1002);
            atom30=atom();

            state._fsp--;

            retval.type = (atom30!=null?atom30.type:null); retval.st = (atom30!=null?atom30.st:null);

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:552:1: decl_stmt : type ID ( '=' ( expr | call_delegate ) )? ;
    public final MyStrLangParser.decl_stmt_return decl_stmt() throws RecognitionException {
        MyStrLangParser.decl_stmt_return retval = new MyStrLangParser.decl_stmt_return();
        retval.start = input.LT(1);

        Token ID31=null;
        MyStrLangParser.type_return type32 = null;

        MyStrLangParser.expr_return expr33 = null;

        MyStrLangParser.call_delegate_return call_delegate34 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:553:2: ( type ID ( '=' ( expr | call_delegate ) )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:553:4: type ID ( '=' ( expr | call_delegate ) )?
            {
            pushFollow(FOLLOW_type_in_decl_stmt1018);
            type32=type();

            state._fsp--;

            ID31=(Token)match(input,ID,FOLLOW_ID_in_decl_stmt1020); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID31!=null?ID31.getText():null)))
            		{
            			NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID31!=null?ID31.getText():null), (type32!=null?input.toString(type32.start,type32.stop):null), (ID31!=null?ID31.getLine():0));
            			var.setNumber(counter);
            			names.addVariable(var);
            			counter++;
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID31!=null?ID31.getText():null)))
            				errors.add("line "+(ID31!=null?ID31.getLine():0)+": Duplicated variable name "+(ID31!=null?ID31.getText():null));
            		}
            		
            		if(TypesChecker.isInteger((type32!=null?input.toString(type32.start,type32.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_int",
              new STAttrMap().put("counter", counter));
            		}
            		if(TypesChecker.isString((type32!=null?input.toString(type32.start,type32.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_string",
              new STAttrMap().put("counter", counter));
            		}
            		
            		if(TypesChecker.isChar((type32!=null?input.toString(type32.start,type32.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_char",
              new STAttrMap().put("counter", counter));
            		}
            		
            		//counter++;
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:584:2: ( '=' ( expr | call_delegate ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:584:3: '=' ( expr | call_delegate )
                    {
                    match(input,18,FOLLOW_18_in_decl_stmt1027); 
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:584:7: ( expr | call_delegate )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==ID) ) {
                        int LA17_1 = input.LA(2);

                        if ( (LA17_1==54) ) {
                            alt17=2;
                        }
                        else if ( ((LA17_1>=13 && LA17_1<=14)||(LA17_1>=20 && LA17_1<=24)) ) {
                            alt17=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA17_0>=INT && LA17_0<=CHAR)||(LA17_0>=32 && LA17_0<=34)||(LA17_0>=46 && LA17_0<=49)) ) {
                        alt17=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:584:8: expr
                            {
                            pushFollow(FOLLOW_expr_in_decl_stmt1030);
                            expr33=expr();

                            state._fsp--;


                            		NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID31!=null?ID31.getText():null));
                            		String varType = var_type.getType();
                            		if(!TypesChecker.checkTypes(varType, (expr33!=null?expr33.type:null)))
                            		{
                            			errors.add("line "+(ID31!=null?ID31.getLine():0)+": Type mismatch: cannot convert from "+varType+" to "+(expr33!=null?expr33.type:null));
                            		}
                            		if(TypesChecker.isInteger(varType))
                            		{
                            			if(names.isGlobal((ID31!=null?ID31.getText():null))){
                            				retval.st = templateLib.getInstanceOf("assign_field_int",
                              new STAttrMap().put("expression", (expr33!=null?expr33.st:null)).put("programName", programName).put("fieldName", (ID31!=null?ID31.getText():null)));
                            			} 
                            			else{
                            				retval.st = templateLib.getInstanceOf("assign_var_int",
                              new STAttrMap().put("expression", (expr33!=null?expr33.st:null)).put("counter", var_type.getNumber()));
                            			}
                            		}
                            		if(TypesChecker.isString(varType))
                            		{
                            			if(names.isGlobal((ID31!=null?ID31.getText():null))){
                            				retval.st = templateLib.getInstanceOf("assign_field_string",
                              new STAttrMap().put("expression", (expr33!=null?expr33.st:null)).put("programName", programName).put("fieldName", (ID31!=null?ID31.getText():null)));
                            			} 
                            			else{
                            				retval.st = templateLib.getInstanceOf("assign_var_string",
                              new STAttrMap().put("expression", (expr33!=null?expr33.st:null)).put("counter", var_type.getNumber()));
                            			}
                            		}
                            		if(TypesChecker.isChar(varType))
                            		{
                            			if(names.isGlobal((ID31!=null?ID31.getText():null))){
                            				retval.st = templateLib.getInstanceOf("assign_field_char",
                              new STAttrMap().put("expression", (expr33!=null?expr33.st:null)).put("programName", programName).put("fieldName", (ID31!=null?ID31.getText():null)));
                            			} 
                            			else{
                            				retval.st = templateLib.getInstanceOf("assign_var_char",
                              new STAttrMap().put("expression", (expr33!=null?expr33.st:null)).put("counter", var_type.getNumber()));
                            			}
                            		}
                            			
                            	

                            }
                            break;
                        case 2 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:621:4: call_delegate
                            {
                            pushFollow(FOLLOW_call_delegate_in_decl_stmt1038);
                            call_delegate34=call_delegate();

                            state._fsp--;


                            	  NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID31!=null?ID31.getText():null));
                                String varType = var_type.getType();
                            	  if(!TypesChecker.checkTypes((type32!=null?input.toString(type32.start,type32.stop):null), (call_delegate34!=null?call_delegate34.type:null)))
                            	    errors.add("line "+(ID31!=null?ID31.getLine():0)+" : Type mismatch: cannot convert from "+(type32!=null?input.toString(type32.start,type32.stop):null)+" to "+(call_delegate34!=null?call_delegate34.type:null));
                            	  if(TypesChecker.isInteger(varType))
                                {
                                  if(names.isGlobal((ID31!=null?ID31.getText():null))){
                                    retval.st = templateLib.getInstanceOf("assign_field_int",
                              new STAttrMap().put("expression", (call_delegate34!=null?call_delegate34.st:null)).put("programName", programName).put("fieldName", (ID31!=null?ID31.getText():null)));
                                  } 
                                  else{
                                    retval.st = templateLib.getInstanceOf("assign_var_int",
                              new STAttrMap().put("expression", (call_delegate34!=null?call_delegate34.st:null)).put("counter", var_type.getNumber()));
                                  }
                                }
                                if(TypesChecker.isString(varType))
                                {
                                  if(names.isGlobal((ID31!=null?ID31.getText():null))){
                                    retval.st = templateLib.getInstanceOf("assign_field_string",
                              new STAttrMap().put("expression", (call_delegate34!=null?call_delegate34.st:null)).put("programName", programName).put("fieldName", (ID31!=null?ID31.getText():null)));
                                  } 
                                  else{
                                    retval.st = templateLib.getInstanceOf("assign_var_string",
                              new STAttrMap().put("expression", (call_delegate34!=null?call_delegate34.st:null)).put("counter", var_type.getNumber()));
                                  }
                                }
                                if(TypesChecker.isChar(varType))
                                {
                                  if(names.isGlobal((ID31!=null?ID31.getText():null))){
                                    retval.st = templateLib.getInstanceOf("assign_field_char",
                              new STAttrMap().put("expression", (call_delegate34!=null?call_delegate34.st:null)).put("programName", programName).put("fieldName", (ID31!=null?ID31.getText():null)));
                                  } 
                                  else{
                                    retval.st = templateLib.getInstanceOf("assign_var_char",
                              new STAttrMap().put("expression", (call_delegate34!=null?call_delegate34.st:null)).put("counter", var_type.getNumber()));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:658:1: write_stmt : 'write' '(' atom ')' ;
    public final MyStrLangParser.write_stmt_return write_stmt() throws RecognitionException {
        MyStrLangParser.write_stmt_return retval = new MyStrLangParser.write_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return atom35 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:659:2: ( 'write' '(' atom ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:659:4: 'write' '(' atom ')'
            {
            match(input,25,FOLLOW_25_in_write_stmt1058); 
            match(input,14,FOLLOW_14_in_write_stmt1060); 
            pushFollow(FOLLOW_atom_in_write_stmt1062);
            atom35=atom();

            state._fsp--;

            match(input,15,FOLLOW_15_in_write_stmt1064); 

            		if(TypesChecker.isInteger((atom35!=null?atom35.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_int",
              new STAttrMap().put("expression", (atom35!=null?atom35.st:null)));
            		}
            		if(TypesChecker.isString((atom35!=null?atom35.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_string",
              new STAttrMap().put("string", (atom35!=null?atom35.st:null)));
            		}
            		if(TypesChecker.isChar((atom35!=null?atom35.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_char",
              new STAttrMap().put("string", (atom35!=null?atom35.st:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:676:1: atom returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st} | replace_firstElem -> {$replace_firstElem.st} | substring_op -> {$substring_op.st});
    public final MyStrLangParser.atom_return atom() throws RecognitionException {
        MyStrLangParser.atom_return retval = new MyStrLangParser.atom_return();
        retval.start = input.LT(1);

        Token ID36=null;
        Token INT37=null;
        Token STRING38=null;
        MyStrLangParser.char_c_return char_c39 = null;

        MyStrLangParser.call_func_return call_func40 = null;

        MyStrLangParser.length_stmt_return length_stmt41 = null;

        MyStrLangParser.elem_stmt_return elem_stmt42 = null;

        MyStrLangParser.to_string_stmt_return to_string_stmt43 = null;

        MyStrLangParser.indexOf_stmt_return indexOf_stmt44 = null;

        MyStrLangParser.replace_op_return replace_op45 = null;

        MyStrLangParser.replace_firstElem_return replace_firstElem46 = null;

        MyStrLangParser.substring_op_return substring_op47 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:677:2: ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st} | replace_firstElem -> {$replace_firstElem.st} | substring_op -> {$substring_op.st})
            int alt19=12;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:677:4: ID
                    {
                    ID36=(Token)match(input,ID,FOLLOW_ID_in_atom1083); 

                    		retval.text = (ID36!=null?ID36.getText():null);
                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID36!=null?ID36.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID36!=null?ID36.getText():null));
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
                    			errors.add("line "+(ID36!=null?ID36.getLine():0)+": unknown variable "+(ID36!=null?ID36.getText():null));
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:722:4: INT
                    {
                    INT37=(Token)match(input,INT,FOLLOW_INT_in_atom1090); 
                    retval.text = (INT37!=null?INT37.getText():null); retval.type = "int"; 
                    	  if(retval.text.length()>10)
                    	    errors.add("line "+(INT37!=null?INT37.getLine():0)+": type int is out of range.");
                    	  else
                    	  {
                    		  try{
                    			  Integer numb = new Integer(retval.text);
                    			}
                    			catch(NumberFormatException e)
                    			{
                    			  errors.add("line "+(INT37!=null?INT37.getLine():0)+": type int is out of range.");
                    			}
                    		}
                    	  


                    // TEMPLATE REWRITE
                    // 735:9: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT37!=null?INT37.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:736:4: STRING
                    {
                    STRING38=(Token)match(input,STRING,FOLLOW_STRING_in_atom1109); 
                    retval.text = (STRING38!=null?STRING38.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 736:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING38!=null?STRING38.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:737:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_atom1127);
                    char_c39=char_c();

                    state._fsp--;

                    retval.type = "char";


                    // TEMPLATE REWRITE
                    // 737:33: -> {$char_c.st}
                    {
                        retval.st = (char_c39!=null?char_c39.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:738:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_atom1142);
                    call_func40=call_func();

                    state._fsp--;

                    retval.type =(call_func40!=null?call_func40.type:null);


                    // TEMPLATE REWRITE
                    // 738:40: -> {$call_func.st}
                    {
                        retval.st = (call_func40!=null?call_func40.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:739:4: length_stmt
                    {
                    pushFollow(FOLLOW_length_stmt_in_atom1154);
                    length_stmt41=length_stmt();

                    state._fsp--;

                    retval.type ="int";


                    // TEMPLATE REWRITE
                    // 739:33: -> {$length_stmt.st}
                    {
                        retval.st = (length_stmt41!=null?length_stmt41.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:740:4: elem_stmt
                    {
                    pushFollow(FOLLOW_elem_stmt_in_atom1167);
                    elem_stmt42=elem_stmt();

                    state._fsp--;

                    retval.type ="char";


                    // TEMPLATE REWRITE
                    // 740:32: -> {$elem_stmt.st}
                    {
                        retval.st = (elem_stmt42!=null?elem_stmt42.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:741:4: to_string_stmt
                    {
                    pushFollow(FOLLOW_to_string_stmt_in_atom1180);
                    to_string_stmt43=to_string_stmt();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 741:38: -> {$to_string_stmt.st}
                    {
                        retval.st = (to_string_stmt43!=null?to_string_stmt43.st:null);
                    }


                    }
                    break;
                case 9 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:742:4: indexOf_stmt
                    {
                    pushFollow(FOLLOW_indexOf_stmt_in_atom1192);
                    indexOf_stmt44=indexOf_stmt();

                    state._fsp--;

                    retval.type ="int";


                    // TEMPLATE REWRITE
                    // 742:34: -> {$indexOf_stmt.st}
                    {
                        retval.st = (indexOf_stmt44!=null?indexOf_stmt44.st:null);
                    }


                    }
                    break;
                case 10 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:743:4: replace_op
                    {
                    pushFollow(FOLLOW_replace_op_in_atom1205);
                    replace_op45=replace_op();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 743:35: -> {$replace_op.st}
                    {
                        retval.st = (replace_op45!=null?replace_op45.st:null);
                    }


                    }
                    break;
                case 11 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:744:4: replace_firstElem
                    {
                    pushFollow(FOLLOW_replace_firstElem_in_atom1218);
                    replace_firstElem46=replace_firstElem();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 744:40: -> {$replace_firstElem.st}
                    {
                        retval.st = (replace_firstElem46!=null?replace_firstElem46.st:null);
                    }


                    }
                    break;
                case 12 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:745:4: substring_op
                    {
                    pushFollow(FOLLOW_substring_op_in_atom1229);
                    substring_op47=substring_op();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 745:36: -> {$substring_op.st}
                    {
                        retval.st = (substring_op47!=null?substring_op47.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:748:1: char_c returns [int numb] : CHAR -> const_char(cod=$numb);
    public final MyStrLangParser.char_c_return char_c() throws RecognitionException {
        MyStrLangParser.char_c_return retval = new MyStrLangParser.char_c_return();
        retval.start = input.LT(1);

        Token CHAR48=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:749:2: ( CHAR -> const_char(cod=$numb))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:749:4: CHAR
            {
            CHAR48=(Token)match(input,CHAR,FOLLOW_CHAR_in_char_c1251); 
            	
            			String str = (CHAR48!=null?CHAR48.getText():null);
            			char el = str.charAt(1);
            			try{
            				retval.numb = Character.toString(el).getBytes("cp1251")[0];
            			}
            			catch(UnsupportedEncodingException e)
            			{
            				e.printStackTrace();
            			}
            	


            // TEMPLATE REWRITE
            // 761:3: -> const_char(cod=$numb)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:764:1: read_strm : 'read' '(' ID ')' ;
    public final MyStrLangParser.read_strm_return read_strm() throws RecognitionException {
        MyStrLangParser.read_strm_return retval = new MyStrLangParser.read_strm_return();
        retval.start = input.LT(1);

        Token ID49=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:765:2: ( 'read' '(' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:765:4: 'read' '(' ID ')'
            {
            match(input,26,FOLLOW_26_in_read_strm1277); 
            match(input,14,FOLLOW_14_in_read_strm1279); 
            ID49=(Token)match(input,ID,FOLLOW_ID_in_read_strm1281); 
            match(input,15,FOLLOW_15_in_read_strm1283); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID49!=null?ID49.getText():null)))
            			errors.add("line "+(ID49!=null?ID49.getLine():0)+": unknown variable "+(ID49!=null?ID49.getText():null));
            		else{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID49!=null?ID49.getText():null));
            			String varType = var_type.getType();
            			if(TypesChecker.isInteger(varType))
            			{
            				if(names.isGlobal((ID49!=null?ID49.getText():null))){
            					retval.st = templateLib.getInstanceOf("read_field_int",
              new STAttrMap().put("programName", programName).put("fieldName", (ID49!=null?ID49.getText():null)));
            				} else
            					retval.st = templateLib.getInstanceOf("read_var_int",
              new STAttrMap().put("counter", var_type.getNumber()));
            			}
            			if(TypesChecker.isString(varType))
            			{
            				if(names.isGlobal((ID49!=null?ID49.getText():null))){
            					retval.st = templateLib.getInstanceOf("read_field_string",
              new STAttrMap().put("programName", programName).put("fieldName", (ID49!=null?ID49.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:790:1: if_stmt : 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )? ;
    public final MyStrLangParser.if_stmt_return if_stmt() throws RecognitionException {
        MyStrLangParser.if_stmt_return retval = new MyStrLangParser.if_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.block_return ifBlock = null;

        MyStrLangParser.block_return elseBlock = null;

        MyStrLangParser.expression_return expression50 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:791:2: ( 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:791:4: 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )?
            {
            match(input,27,FOLLOW_27_in_if_stmt1299); 
            match(input,14,FOLLOW_14_in_if_stmt1301); 
            pushFollow(FOLLOW_expression_in_if_stmt1303);
            expression50=expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_if_stmt1305); 
            match(input,11,FOLLOW_11_in_if_stmt1307); 
            pushFollow(FOLLOW_block_in_if_stmt1311);
            ifBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_if_stmt1313); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:791:50: ( 'else' '{' elseBlock= block '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:791:51: 'else' '{' elseBlock= block '}'
                    {
                    match(input,28,FOLLOW_28_in_if_stmt1316); 
                    match(input,11,FOLLOW_11_in_if_stmt1318); 
                    pushFollow(FOLLOW_block_in_if_stmt1322);
                    elseBlock=block();

                    state._fsp--;

                    match(input,12,FOLLOW_12_in_if_stmt1324); 

                    }
                    break;

            }


            		retval.st = templateLib.getInstanceOf("if_operation",
              new STAttrMap().put("expression", (expression50!=null?expression50.st:null)).put("ifBlock", (ifBlock!=null?ifBlock.stList:null)).put("elseBlock", (elseBlock!=null?elseBlock.stList:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:799:1: for_stmt : 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}' ;
    public final MyStrLangParser.for_stmt_return for_stmt() throws RecognitionException {
        MyStrLangParser.for_stmt_return retval = new MyStrLangParser.for_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.assign_stmt_return begin = null;

        MyStrLangParser.expression_return check = null;

        MyStrLangParser.assign_stmt_return end = null;

        MyStrLangParser.block_return forBlock = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:800:2: ( 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:800:4: 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}'
            {
            match(input,29,FOLLOW_29_in_for_stmt1341); 
            match(input,14,FOLLOW_14_in_for_stmt1343); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt1347);
            begin=assign_stmt();

            state._fsp--;

            match(input,13,FOLLOW_13_in_for_stmt1349); 
            pushFollow(FOLLOW_expression_in_for_stmt1353);
            check=expression();

            state._fsp--;

            match(input,13,FOLLOW_13_in_for_stmt1355); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt1359);
            end=assign_stmt();

            state._fsp--;

            match(input,15,FOLLOW_15_in_for_stmt1361); 
            match(input,11,FOLLOW_11_in_for_stmt1363); 
            pushFollow(FOLLOW_block_in_for_stmt1367);
            forBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_for_stmt1369); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:808:1: while_stmt : 'while' '(' check= expression ')' '{' whileBlock= block '}' ;
    public final MyStrLangParser.while_stmt_return while_stmt() throws RecognitionException {
        MyStrLangParser.while_stmt_return retval = new MyStrLangParser.while_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.expression_return check = null;

        MyStrLangParser.block_return whileBlock = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:809:2: ( 'while' '(' check= expression ')' '{' whileBlock= block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:809:4: 'while' '(' check= expression ')' '{' whileBlock= block '}'
            {
            match(input,30,FOLLOW_30_in_while_stmt1384); 
            match(input,14,FOLLOW_14_in_while_stmt1386); 
            pushFollow(FOLLOW_expression_in_while_stmt1390);
            check=expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_while_stmt1392); 
            match(input,11,FOLLOW_11_in_while_stmt1394); 
            pushFollow(FOLLOW_block_in_while_stmt1398);
            whileBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_while_stmt1400); 

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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "return_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:816:1: return_stmt returns [String value, int line] : (a= 'return' atom ';' )? -> {$atom.st};
    public final MyStrLangParser.return_stmt_return return_stmt() throws RecognitionException {
        MyStrLangParser.return_stmt_return retval = new MyStrLangParser.return_stmt_return();
        retval.start = input.LT(1);

        Token a=null;
        MyStrLangParser.atom_return atom51 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:817:2: ( (a= 'return' atom ';' )? -> {$atom.st})
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:818:2: (a= 'return' atom ';' )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:818:2: (a= 'return' atom ';' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:818:3: a= 'return' atom ';'
                    {
                    a=(Token)match(input,31,FOLLOW_31_in_return_stmt1422); 
                    pushFollow(FOLLOW_atom_in_return_stmt1424);
                    atom51=atom();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_return_stmt1426); 
                    	
                    		if(((program_scope)program_stack.peek()).curBlock=="main")
                    			errors.add("line "+(a!=null?a.getLine():0)+": function main may not contain keyword return");
                    		retval.value = (atom51!=null?atom51.text:null);
                    		retval.line = (a!=null?a.getLine():0);
                    		
                    		try{
                    			String name = ((program_scope)program_stack.peek()).curBlock;
                    			NamesTable.FunctionName func = names.getFunction(name);
                    			String type = func.getReturnType();
                    			
                    			if(type.equals("void")){
                    				errors.add("line "+(a!=null?a.getLine():0)+": type of void may not contain keyword return");
                    			}
                    			
                    			String rType = (atom51!=null?atom51.type:null);
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
            // 844:2: -> {$atom.st}
            {
                retval.st = (atom51!=null?atom51.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:847:1: length_stmt : 'length' '(' param ')' ;
    public final MyStrLangParser.length_stmt_return length_stmt() throws RecognitionException {
        MyStrLangParser.length_stmt_return retval = new MyStrLangParser.length_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.param_return param52 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:848:2: ( 'length' '(' param ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:848:4: 'length' '(' param ')'
            {
            match(input,32,FOLLOW_32_in_length_stmt1451); 
            match(input,14,FOLLOW_14_in_length_stmt1453); 
            pushFollow(FOLLOW_param_in_length_stmt1455);
            param52=param();

            state._fsp--;

            match(input,15,FOLLOW_15_in_length_stmt1457); 

            		retval.st = templateLib.getInstanceOf("length_string",
              new STAttrMap().put("string", (param52!=null?param52.st:null)));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:854:1: param returns [String text, String type] : ( ID | STRING -> const_string(value=$STRING.text));
    public final MyStrLangParser.param_return param() throws RecognitionException {
        MyStrLangParser.param_return retval = new MyStrLangParser.param_return();
        retval.start = input.LT(1);

        Token ID53=null;
        Token STRING54=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:855:2: ( ID | STRING -> const_string(value=$STRING.text))
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:855:4: ID
                    {
                    ID53=(Token)match(input,ID,FOLLOW_ID_in_param1475); 

                    		retval.text = (ID53!=null?ID53.getText():null);
                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID53!=null?ID53.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID53!=null?ID53.getText():null));
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
                    			errors.add("line "+(ID53!=null?ID53.getLine():0)+": unknown variable "+(ID53!=null?ID53.getText():null));
                    		}
                    		

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:889:4: STRING
                    {
                    STRING54=(Token)match(input,STRING,FOLLOW_STRING_in_param1482); 
                    retval.text = (STRING54!=null?STRING54.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 889:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING54!=null?STRING54.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:892:1: elem_stmt : 'elem' '(' f_el ',' s_el ')' ;
    public final MyStrLangParser.elem_stmt_return elem_stmt() throws RecognitionException {
        MyStrLangParser.elem_stmt_return retval = new MyStrLangParser.elem_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return f_el55 = null;

        MyStrLangParser.s_el_return s_el56 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:893:2: ( 'elem' '(' f_el ',' s_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:893:4: 'elem' '(' f_el ',' s_el ')'
            {
            match(input,33,FOLLOW_33_in_elem_stmt1507); 
            match(input,14,FOLLOW_14_in_elem_stmt1509); 
            pushFollow(FOLLOW_f_el_in_elem_stmt1510);
            f_el55=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_elem_stmt1512); 
            pushFollow(FOLLOW_s_el_in_elem_stmt1514);
            s_el56=s_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_elem_stmt1516); 

            		retval.st = templateLib.getInstanceOf("elem_in_string",
              new STAttrMap().put("fValue", (f_el55!=null?f_el55.st:null)).put("sValue", (s_el56!=null?s_el56.st:null)));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:899:1: f_el : ( ID | STRING -> const_string(value=$STRING.text));
    public final MyStrLangParser.f_el_return f_el() throws RecognitionException {
        MyStrLangParser.f_el_return retval = new MyStrLangParser.f_el_return();
        retval.start = input.LT(1);

        Token ID57=null;
        Token STRING58=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:900:2: ( ID | STRING -> const_string(value=$STRING.text))
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:900:4: ID
                    {
                    ID57=(Token)match(input,ID,FOLLOW_ID_in_f_el1531); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID57!=null?ID57.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID57!=null?ID57.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isString(type))
                    			{
                    				if(names.isGlobal((ID57!=null?ID57.getText():null)))
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
                    			errors.add("line "+(ID57!=null?ID57.getLine():0)+": unknown variable "+(ID57!=null?ID57.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:920:4: STRING
                    {
                    STRING58=(Token)match(input,STRING,FOLLOW_STRING_in_f_el1539); 


                    // TEMPLATE REWRITE
                    // 920:12: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING58!=null?STRING58.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:923:1: s_el : ( ID | INT -> const_int(value=$INT.text));
    public final MyStrLangParser.s_el_return s_el() throws RecognitionException {
        MyStrLangParser.s_el_return retval = new MyStrLangParser.s_el_return();
        retval.start = input.LT(1);

        Token ID59=null;
        Token INT60=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:924:2: ( ID | INT -> const_int(value=$INT.text))
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:924:4: ID
                    {
                    ID59=(Token)match(input,ID,FOLLOW_ID_in_s_el1561); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID59!=null?ID59.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID59!=null?ID59.getText():null));
                    			String type = v_type.getType();
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
                    		}
                    		else
                    			errors.add("line "+(ID59!=null?ID59.getLine():0)+": unknown variable "+(ID59!=null?ID59.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:944:4: INT
                    {
                    INT60=(Token)match(input,INT,FOLLOW_INT_in_s_el1569); 


                    // TEMPLATE REWRITE
                    // 944:9: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT60!=null?INT60.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:947:1: to_string_stmt : 'ToString' '(' param_str ')' ;
    public final MyStrLangParser.to_string_stmt_return to_string_stmt() throws RecognitionException {
        MyStrLangParser.to_string_stmt_return retval = new MyStrLangParser.to_string_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.param_str_return param_str61 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:948:2: ( 'ToString' '(' param_str ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:948:4: 'ToString' '(' param_str ')'
            {
            match(input,34,FOLLOW_34_in_to_string_stmt1591); 
            match(input,14,FOLLOW_14_in_to_string_stmt1593); 
            pushFollow(FOLLOW_param_str_in_to_string_stmt1595);
            param_str61=param_str();

            state._fsp--;

            match(input,15,FOLLOW_15_in_to_string_stmt1597); 

            		if(TypesChecker.isInteger((param_str61!=null?param_str61.t:null))){
            			retval.st = templateLib.getInstanceOf("int_to_string",
              new STAttrMap().put("value", (param_str61!=null?param_str61.st:null)));
            		}
            		if(TypesChecker.isChar((param_str61!=null?param_str61.t:null))){
            			retval.st = templateLib.getInstanceOf("char_to_string",
              new STAttrMap().put("value", (param_str61!=null?param_str61.st:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:959:1: param_str returns [String t] : ( ID | INT -> const_int(value=$INT.text) | char_c -> {$char_c.st});
    public final MyStrLangParser.param_str_return param_str() throws RecognitionException {
        MyStrLangParser.param_str_return retval = new MyStrLangParser.param_str_return();
        retval.start = input.LT(1);

        Token ID62=null;
        Token INT63=null;
        MyStrLangParser.char_c_return char_c64 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:960:2: ( ID | INT -> const_int(value=$INT.text) | char_c -> {$char_c.st})
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:960:4: ID
                    {
                    ID62=(Token)match(input,ID,FOLLOW_ID_in_param_str1615); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID62!=null?ID62.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID62!=null?ID62.getText():null));
                    			String type = v_type.getType();
                    			retval.t = type;
                    			if(TypesChecker.isInteger(type))
                    			{
                    				if(names.isGlobal((ID62!=null?ID62.getText():null)))
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
                    				if(names.isGlobal((ID62!=null?ID62.getText():null)))
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
                    			errors.add("line "+(ID62!=null?ID62.getLine():0)+": unknown variable "+(ID62!=null?ID62.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:992:4: INT
                    {
                    INT63=(Token)match(input,INT,FOLLOW_INT_in_param_str1623); 
                    retval.t ="int";


                    // TEMPLATE REWRITE
                    // 992:22: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT63!=null?INT63.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:993:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_param_str1641);
                    char_c64=char_c();

                    state._fsp--;

                    retval.t ="char";


                    // TEMPLATE REWRITE
                    // 993:25: -> {$char_c.st}
                    {
                        retval.st = (char_c64!=null?char_c64.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:996:1: call_func_stmt : call_func -> {$call_func.st};
    public final MyStrLangParser.call_func_stmt_return call_func_stmt() throws RecognitionException {
        MyStrLangParser.call_func_stmt_return retval = new MyStrLangParser.call_func_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.call_func_return call_func65 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:997:2: ( call_func -> {$call_func.st})
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:997:4: call_func
            {
            pushFollow(FOLLOW_call_func_in_call_func_stmt1660);
            call_func65=call_func();

            state._fsp--;



            // TEMPLATE REWRITE
            // 998:3: -> {$call_func.st}
            {
                retval.st = (call_func65!=null?call_func65.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1001:1: call_func returns [String type, int line] : ID '(' arg_call ')' ;
    public final MyStrLangParser.call_func_return call_func() throws RecognitionException {
        call_func_stack.push(new call_func_scope());
        MyStrLangParser.call_func_return retval = new MyStrLangParser.call_func_return();
        retval.start = input.LT(1);

        Token ID66=null;
        MyStrLangParser.arg_call_return arg_call67 = null;



        	((call_func_scope)call_func_stack.peek()).methodName = "";
        	List<StringTemplate> argTypes = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1009:2: ( ID '(' arg_call ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1009:4: ID '(' arg_call ')'
            {
            ID66=(Token)match(input,ID,FOLLOW_ID_in_call_func1688); 
            ((call_func_scope)call_func_stack.peek()).methodName =(ID66!=null?ID66.getText():null);
            match(input,14,FOLLOW_14_in_call_func1691); 
            pushFollow(FOLLOW_arg_call_in_call_func1693);
            arg_call67=arg_call();

            state._fsp--;

            match(input,15,FOLLOW_15_in_call_func1695); 

            		retval.line = (ID66!=null?ID66.getLine():0);
            		ArrayList<String> list = null;
            		if((arg_call67!=null?arg_call67.argumentTypeList:null)==null)
            			list = new ArrayList<String>();
            		else
            			list = (arg_call67!=null?arg_call67.argumentTypeList:null);
            		if(!names.checkCallFunction((ID66!=null?ID66.getText():null), list, (ID66!=null?ID66.getLine():0)))
            		{
            			names.getAllErrors(errors);
            		}
            		if(!names.isExistFunction((ID66!=null?ID66.getText():null)))
            		{
            			errors.add("line "+(ID66!=null?ID66.getLine():0)+": function "+(ID66!=null?ID66.getText():null)+" is not exist");
            		}
            		else
            		{
            			NamesTable.FunctionName func = names.getFunction((ID66!=null?ID66.getText():null));
            			retval.type = func.getReturnType();
            		}
            		
            		for(String arg_type: (arg_call67!=null?arg_call67.argumentTypeList:null))
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
              new STAttrMap().put("programName", programName).put("funcName", (ID66!=null?ID66.getText():null)).put("argTemplates", (arg_call67!=null?arg_call67.stList:null)).put("argTypes", argTypes).put("returnType", returnType));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1071:1: arg_call returns [ArrayList<String> argumentTypeList, List<StringTemplate> stList] : (a= atom ( ',' b= atom )* )? ;
    public final MyStrLangParser.arg_call_return arg_call() throws RecognitionException {
        MyStrLangParser.arg_call_return retval = new MyStrLangParser.arg_call_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return a = null;

        MyStrLangParser.atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1072:2: ( (a= atom ( ',' b= atom )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1073:2: (a= atom ( ',' b= atom )* )?
            {

            		retval.argumentTypeList = new ArrayList<String>();
            		retval.stList = new ArrayList<StringTemplate>();
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1077:2: (a= atom ( ',' b= atom )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=ID && LA27_0<=CHAR)||(LA27_0>=32 && LA27_0<=34)||(LA27_0>=46 && LA27_0<=49)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1077:3: a= atom ( ',' b= atom )*
                    {
                    pushFollow(FOLLOW_atom_in_arg_call1721);
                    a=atom();

                    state._fsp--;

                    retval.argumentTypeList.add((a!=null?a.type:null)); retval.stList.add((a!=null?a.st:null));
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1077:64: ( ',' b= atom )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==16) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1077:65: ',' b= atom
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_call1726); 
                    	    pushFollow(FOLLOW_atom_in_arg_call1730);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1080:1: expression : first= and_expression ( '||' second= expression )? ;
    public final MyStrLangParser.expression_return expression() throws RecognitionException {
        MyStrLangParser.expression_return retval = new MyStrLangParser.expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.and_expression_return first = null;

        MyStrLangParser.expression_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1081:2: (first= and_expression ( '||' second= expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1081:4: first= and_expression ( '||' second= expression )?
            {
            pushFollow(FOLLOW_and_expression_in_expression1750);
            first=and_expression();

            state._fsp--;

            retval.st = (first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1081:44: ( '||' second= expression )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==35) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1081:45: '||' second= expression
                    {
                    match(input,35,FOLLOW_35_in_expression1755); 
                    pushFollow(FOLLOW_expression_in_expression1760);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1090:1: and_expression : first= not_expression ( '&&' second= and_expression )? ;
    public final MyStrLangParser.and_expression_return and_expression() throws RecognitionException {
        MyStrLangParser.and_expression_return retval = new MyStrLangParser.and_expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.not_expression_return first = null;

        MyStrLangParser.and_expression_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1091:2: (first= not_expression ( '&&' second= and_expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1091:4: first= not_expression ( '&&' second= and_expression )?
            {
            pushFollow(FOLLOW_not_expression_in_and_expression1783);
            first=not_expression();

            state._fsp--;

            retval.st = (first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1091:44: ( '&&' second= and_expression )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==36) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1091:45: '&&' second= and_expression
                    {
                    match(input,36,FOLLOW_36_in_and_expression1788); 
                    pushFollow(FOLLOW_and_expression_in_and_expression1792);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1100:1: not_expression : ( '!' first= not_expression | second= comparison );
    public final MyStrLangParser.not_expression_return not_expression() throws RecognitionException {
        MyStrLangParser.not_expression_return retval = new MyStrLangParser.not_expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.not_expression_return first = null;

        MyStrLangParser.comparison_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1101:2: ( '!' first= not_expression | second= comparison )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==37) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=ID && LA30_0<=CHAR)||(LA30_0>=32 && LA30_0<=34)||(LA30_0>=44 && LA30_0<=49)) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1101:4: '!' first= not_expression
                    {
                    match(input,37,FOLLOW_37_in_not_expression1812); 
                    pushFollow(FOLLOW_not_expression_in_not_expression1816);
                    first=not_expression();

                    state._fsp--;


                    				retval.st = templateLib.getInstanceOf("logical_not",
                      new STAttrMap().put("expression", (first!=null?first.st:null)).put("firstLabel", labelCounter).put("secondLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1106:4: second= comparison
                    {
                    pushFollow(FOLLOW_comparison_in_not_expression1828);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1109:1: comparison : (first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom | equal_op -> {$equal_op.st} | contain_op -> {$contain_op.st});
    public final MyStrLangParser.comparison_return comparison() throws RecognitionException {
        MyStrLangParser.comparison_return retval = new MyStrLangParser.comparison_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.atom_return first = null;

        MyStrLangParser.atom_return second = null;

        MyStrLangParser.equal_op_return equal_op68 = null;

        MyStrLangParser.contain_op_return contain_op69 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1110:2: (first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom | equal_op -> {$equal_op.st} | contain_op -> {$contain_op.st})
            int alt31=3;
            switch ( input.LA(1) ) {
            case ID:
            case INT:
            case STRING:
            case CHAR:
            case 32:
            case 33:
            case 34:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt31=1;
                }
                break;
            case 44:
                {
                alt31=2;
                }
                break;
            case 45:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1110:4: first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom
                    {
                    pushFollow(FOLLOW_atom_in_comparison1843);
                    first=atom();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=38 && input.LA(1)<=43) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_atom_in_comparison1863);
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1190:4: equal_op
                    {
                    pushFollow(FOLLOW_equal_op_in_comparison1871);
                    equal_op68=equal_op();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 1190:14: -> {$equal_op.st}
                    {
                        retval.st = (equal_op68!=null?equal_op68.st:null);
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1191:4: contain_op
                    {
                    pushFollow(FOLLOW_contain_op_in_comparison1881);
                    contain_op69=contain_op();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 1191:16: -> {$contain_op.st}
                    {
                        retval.st = (contain_op69!=null?contain_op69.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1194:1: equal_op : 'equals' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.equal_op_return equal_op() throws RecognitionException {
        MyStrLangParser.equal_op_return retval = new MyStrLangParser.equal_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1195:2: ( 'equals' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1195:4: 'equals' '(' first= f_el ',' second= f_el ')'
            {
            match(input,44,FOLLOW_44_in_equal_op1898); 
            match(input,14,FOLLOW_14_in_equal_op1900); 
            pushFollow(FOLLOW_f_el_in_equal_op1904);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_equal_op1906); 
            pushFollow(FOLLOW_f_el_in_equal_op1910);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_equal_op1912); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1201:1: contain_op : 'contains' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.contain_op_return contain_op() throws RecognitionException {
        MyStrLangParser.contain_op_return retval = new MyStrLangParser.contain_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1202:2: ( 'contains' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1202:4: 'contains' '(' first= f_el ',' second= f_el ')'
            {
            match(input,45,FOLLOW_45_in_contain_op1927); 
            match(input,14,FOLLOW_14_in_contain_op1929); 
            pushFollow(FOLLOW_f_el_in_contain_op1933);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_contain_op1935); 
            pushFollow(FOLLOW_f_el_in_contain_op1939);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_contain_op1941); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1208:1: indexOf_stmt : 'indexOf' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.indexOf_stmt_return indexOf_stmt() throws RecognitionException {
        MyStrLangParser.indexOf_stmt_return retval = new MyStrLangParser.indexOf_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1209:2: ( 'indexOf' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1209:4: 'indexOf' '(' first= f_el ',' second= f_el ')'
            {
            match(input,46,FOLLOW_46_in_indexOf_stmt1956); 
            match(input,14,FOLLOW_14_in_indexOf_stmt1958); 
            pushFollow(FOLLOW_f_el_in_indexOf_stmt1962);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_indexOf_stmt1964); 
            pushFollow(FOLLOW_f_el_in_indexOf_stmt1968);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_indexOf_stmt1969); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1215:1: replace_op : 'replace' '(' f_el ',' first= char_param ',' second= char_param ')' ;
    public final MyStrLangParser.replace_op_return replace_op() throws RecognitionException {
        MyStrLangParser.replace_op_return retval = new MyStrLangParser.replace_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.char_param_return first = null;

        MyStrLangParser.char_param_return second = null;

        MyStrLangParser.f_el_return f_el70 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1216:2: ( 'replace' '(' f_el ',' first= char_param ',' second= char_param ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1216:4: 'replace' '(' f_el ',' first= char_param ',' second= char_param ')'
            {
            match(input,47,FOLLOW_47_in_replace_op1984); 
            match(input,14,FOLLOW_14_in_replace_op1986); 
            pushFollow(FOLLOW_f_el_in_replace_op1988);
            f_el70=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_op1990); 
            pushFollow(FOLLOW_char_param_in_replace_op1994);
            first=char_param();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_op1996); 
            pushFollow(FOLLOW_char_param_in_replace_op2000);
            second=char_param();

            state._fsp--;

            match(input,15,FOLLOW_15_in_replace_op2002); 

            		retval.st = templateLib.getInstanceOf("replace_operation",
              new STAttrMap().put("fValue", (f_el70!=null?f_el70.st:null)).put("sValue", (first!=null?first.st:null)).put("thValue", (second!=null?second.st:null)));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1222:1: char_param : ( ID | char_c -> {$char_c.st});
    public final MyStrLangParser.char_param_return char_param() throws RecognitionException {
        MyStrLangParser.char_param_return retval = new MyStrLangParser.char_param_return();
        retval.start = input.LT(1);

        Token ID71=null;
        MyStrLangParser.char_c_return char_c72 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1223:2: ( ID | char_c -> {$char_c.st})
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1223:4: ID
                    {
                    ID71=(Token)match(input,ID,FOLLOW_ID_in_char_param2017); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID71!=null?ID71.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID71!=null?ID71.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isChar(type))
                    			{
                    				if(names.isGlobal((ID71!=null?ID71.getText():null)))
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
                    			errors.add("line "+(ID71!=null?ID71.getLine():0)+": unknown variable "+(ID71!=null?ID71.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1243:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_char_param2025);
                    char_c72=char_c();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 1243:12: -> {$char_c.st}
                    {
                        retval.st = (char_c72!=null?char_c72.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1246:1: replace_firstElem : 'replaceFirst' '(' first= f_el ',' second= f_el ',' third= f_el ')' ;
    public final MyStrLangParser.replace_firstElem_return replace_firstElem() throws RecognitionException {
        MyStrLangParser.replace_firstElem_return retval = new MyStrLangParser.replace_firstElem_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;

        MyStrLangParser.f_el_return third = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1247:2: ( 'replaceFirst' '(' first= f_el ',' second= f_el ',' third= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1247:4: 'replaceFirst' '(' first= f_el ',' second= f_el ',' third= f_el ')'
            {
            match(input,48,FOLLOW_48_in_replace_firstElem2041); 
            match(input,14,FOLLOW_14_in_replace_firstElem2043); 
            pushFollow(FOLLOW_f_el_in_replace_firstElem2047);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_firstElem2049); 
            pushFollow(FOLLOW_f_el_in_replace_firstElem2053);
            second=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_firstElem2055); 
            pushFollow(FOLLOW_f_el_in_replace_firstElem2059);
            third=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_replace_firstElem2061); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1253:1: substring_op : ( 'subString' '(' first= f_el ',' second= s_el ')' | 'subString' '(' first= f_el ',' second= s_el ',' third= s_el ')' );
    public final MyStrLangParser.substring_op_return substring_op() throws RecognitionException {
        MyStrLangParser.substring_op_return retval = new MyStrLangParser.substring_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.s_el_return second = null;

        MyStrLangParser.s_el_return third = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1254:2: ( 'subString' '(' first= f_el ',' second= s_el ')' | 'subString' '(' first= f_el ',' second= s_el ',' third= s_el ')' )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1254:4: 'subString' '(' first= f_el ',' second= s_el ')'
                    {
                    match(input,49,FOLLOW_49_in_substring_op2076); 
                    match(input,14,FOLLOW_14_in_substring_op2078); 
                    pushFollow(FOLLOW_f_el_in_substring_op2082);
                    first=f_el();

                    state._fsp--;

                    match(input,16,FOLLOW_16_in_substring_op2084); 
                    pushFollow(FOLLOW_s_el_in_substring_op2088);
                    second=s_el();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_substring_op2089); 

                    		retval.st = templateLib.getInstanceOf("substring_op_one",
                      new STAttrMap().put("fValue", (first!=null?first.st:null)).put("sValue", (second!=null?second.st:null)));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1258:4: 'subString' '(' first= f_el ',' second= s_el ',' third= s_el ')'
                    {
                    match(input,49,FOLLOW_49_in_substring_op2097); 
                    match(input,14,FOLLOW_14_in_substring_op2099); 
                    pushFollow(FOLLOW_f_el_in_substring_op2103);
                    first=f_el();

                    state._fsp--;

                    match(input,16,FOLLOW_16_in_substring_op2105); 
                    pushFollow(FOLLOW_s_el_in_substring_op2109);
                    second=s_el();

                    state._fsp--;

                    match(input,16,FOLLOW_16_in_substring_op2111); 
                    pushFollow(FOLLOW_s_el_in_substring_op2115);
                    third=s_el();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_substring_op2117); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1264:1: type returns [StringTemplate returnType] : ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char());
    public final MyStrLangParser.type_return type() throws RecognitionException {
        MyStrLangParser.type_return retval = new MyStrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1265:2: ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char())
            int alt34=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt34=1;
                }
                break;
            case 51:
                {
                alt34=2;
                }
                break;
            case 52:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1265:4: 'int'
                    {
                    match(input,50,FOLLOW_50_in_type2136); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 1265:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1266:5: 'string'
                    {
                    match(input,51,FOLLOW_51_in_type2150); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 1266:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1267:5: 'char'
                    {
                    match(input,52,FOLLOW_52_in_type2163); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 1267:46: -> type_char()
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1270:1: type_func returns [StringTemplate returnType] : ( | 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char() | 'void' -> type_void());
    public final MyStrLangParser.type_func_return type_func() throws RecognitionException {
        MyStrLangParser.type_func_return retval = new MyStrLangParser.type_func_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1271:2: ( | 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char() | 'void' -> type_void())
            int alt35=5;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt35=1;
                }
                break;
            case 50:
                {
                alt35=2;
                }
                break;
            case 51:
                {
                alt35=3;
                }
                break;
            case 52:
                {
                alt35=4;
                }
                break;
            case 53:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1272:2: 
                    {
                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1272:4: 'int'
                    {
                    match(input,50,FOLLOW_50_in_type_func2189); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 1272:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1273:5: 'string'
                    {
                    match(input,51,FOLLOW_51_in_type_func2203); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 1273:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1274:5: 'char'
                    {
                    match(input,52,FOLLOW_52_in_type_func2216); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 1274:46: -> type_char()
                    {
                        retval.st = templateLib.getInstanceOf("type_char");
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1275:4: 'void'
                    {
                    match(input,53,FOLLOW_53_in_type_func2228); 
                    retval.returnType = templateLib.getInstanceOf("return_void");


                    // TEMPLATE REWRITE
                    // 1275:43: -> type_void()
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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "call_delegate"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1278:1: call_delegate returns [String type, int line] : nameVar= ID '.' funcName= ID '(' arg_call ')' ;
    public final MyStrLangParser.call_delegate_return call_delegate() throws RecognitionException {
        call_delegate_stack.push(new call_delegate_scope());
        MyStrLangParser.call_delegate_return retval = new MyStrLangParser.call_delegate_return();
        retval.start = input.LT(1);

        Token nameVar=null;
        Token funcName=null;
        MyStrLangParser.arg_call_return arg_call73 = null;



          List<StringTemplate> argTypes = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1285:3: (nameVar= ID '.' funcName= ID '(' arg_call ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1285:5: nameVar= ID '.' funcName= ID '(' arg_call ')'
            {
            nameVar=(Token)match(input,ID,FOLLOW_ID_in_call_delegate2263); 
            match(input,54,FOLLOW_54_in_call_delegate2264); 
            funcName=(Token)match(input,ID,FOLLOW_ID_in_call_delegate2267); 
            match(input,14,FOLLOW_14_in_call_delegate2269); 
            pushFollow(FOLLOW_arg_call_in_call_delegate2271);
            arg_call73=arg_call();

            state._fsp--;

            match(input,15,FOLLOW_15_in_call_delegate2273); 

                if(!names.isDeclaredVariable("global."+(nameVar!=null?nameVar.getText():null)))
                  errors.add("line "+(nameVar!=null?nameVar.getLine():0)+" unknown variable "+(nameVar!=null?nameVar.getText():null));
                String nameDelegate = "";
                try{
            	    NamesTable.VariableName del = names.getVariable((nameVar!=null?nameVar.getText():null));
            	    nameDelegate = del.getType(); 
            	  }
            	  catch(NullPointerException e){}
                if(!names.isExistFunction(nameDelegate+(funcName!=null?funcName.getText():null)))
                  errors.add("line "+(funcName!=null?funcName.getLine():0)+" unknown variable "+nameDelegate+(funcName!=null?funcName.getText():null));
                else
                {
                  ArrayList<String> list = null;
            	    if((arg_call73!=null?arg_call73.argumentTypeList:null)==null)
            	      list = new ArrayList<String>();
            	    else
            	      list = (arg_call73!=null?arg_call73.argumentTypeList:null);
            	    if(!names.checkCallFunction(nameDelegate+(funcName!=null?funcName.getText():null), list, (nameVar!=null?nameVar.getLine():0)))
            	    {
            	      names.getAllErrors(errors);
            	    }
            	    NamesTable.FunctionName func = names.getFunction(nameDelegate+(funcName!=null?funcName.getText():null));
                  retval.type = func.getReturnType();
                  
                  for(String arg_type: (arg_call73!=null?arg_call73.argumentTypeList:null))
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
              new STAttrMap().put("programName", programName).put("funcName", nameDelegate+(funcName!=null?funcName.getText():null)).put("argTemplates", (arg_call73!=null?arg_call73.stList:null)).put("argTypes", argTypes).put("returnType", returnType));
                }  
                
              

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


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA11_eotS =
        "\13\uffff";
    static final String DFA11_eofS =
        "\13\uffff";
    static final String DFA11_minS =
        "\1\4\1\16\11\uffff";
    static final String DFA11_maxS =
        "\1\64\1\66\11\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\1\1\11\1\10";
    static final String DFA11_specialS =
        "\13\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\24\uffff\1\3\1\4\1\5\1\uffff\1\6\1\7\23\uffff\3\2",
            "\1\12\3\uffff\1\10\43\uffff\1\11",
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

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "381:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st} | call_delegate ';' -> {$call_delegate.st});";
        }
    }
    static final String DFA19_eotS =
        "\16\uffff";
    static final String DFA19_eofS =
        "\16\uffff";
    static final String DFA19_minS =
        "\1\4\1\15\14\uffff";
    static final String DFA19_maxS =
        "\1\61\1\53\14\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\1\1\5";
    static final String DFA19_specialS =
        "\16\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\2\1\3\1\4\30\uffff\1\5\1\6\1\7\13\uffff\1\10\1\11\1"+
            "\12\1\13",
            "\1\14\1\15\2\14\3\uffff\5\14\12\uffff\2\14\1\uffff\6\14",
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
            return "676:1: atom returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st} | replace_firstElem -> {$replace_firstElem.st} | substring_op -> {$substring_op.st});";
        }
    }
    static final String DFA33_eotS =
        "\12\uffff";
    static final String DFA33_eofS =
        "\12\uffff";
    static final String DFA33_minS =
        "\1\61\1\16\1\4\2\20\1\4\2\17\2\uffff";
    static final String DFA33_maxS =
        "\1\61\1\16\1\6\2\20\1\5\2\20\2\uffff";
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
            return "1253:1: substring_op : ( 'subString' '(' first= f_el ',' second= s_el ')' | 'subString' '(' first= f_el ',' second= s_el ',' third= s_el ')' );";
        }
    }
 

    public static final BitSet FOLLOW_global_variables_in_program61 = new BitSet(new long[]{0x003C000000022410L});
    public static final BitSet FOLLOW_functions_in_program65 = new BitSet(new long[]{0x003C000000020410L});
    public static final BitSet FOLLOW_delegates_in_program76 = new BitSet(new long[]{0x003C000000020410L});
    public static final BitSet FOLLOW_mainBlock_in_program87 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_mainBlock131 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_mainBlock133 = new BitSet(new long[]{0x001C0000EE000010L});
    public static final BitSet FOLLOW_block_in_mainBlock135 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_mainBlock137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_declaration_in_global_variables163 = new BitSet(new long[]{0x001C000000002000L});
    public static final BitSet FOLLOW_13_in_global_variables169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_declaration181 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_declaration183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_func_in_functions222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functions229 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_functions234 = new BitSet(new long[]{0x001C000000008000L});
    public static final BitSet FOLLOW_arg_list_in_functions236 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_functions238 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_functions246 = new BitSet(new long[]{0x001C0000EE000010L});
    public static final BitSet FOLLOW_block_in_functions251 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_functions254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_arg_list308 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list312 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_list322 = new BitSet(new long[]{0x001C000000000000L});
    public static final BitSet FOLLOW_type_in_arg_list326 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list330 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_17_in_delegates366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_delegates370 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_delegates372 = new BitSet(new long[]{0x003C000000000010L});
    public static final BitSet FOLLOW_type_func_in_delegates375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_delegates402 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_delegates409 = new BitSet(new long[]{0x001C000000008000L});
    public static final BitSet FOLLOW_arg_del_in_delegates411 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_delegates413 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_delegates415 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_delegates429 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_delegate_stmt_decl_in_delegates434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_arg_del494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_del498 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_del511 = new BitSet(new long[]{0x001C000000000000L});
    public static final BitSet FOLLOW_type_in_arg_del515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_del519 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ID_in_delegate_stmt_decl564 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_delegate_stmt_decl568 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_delegate_stmt_decl570 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_delegate_stmt_decl574 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_delegate_stmt_decl576 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_11_in_delegate_stmt_decl582 = new BitSet(new long[]{0x001C0000EE000010L});
    public static final BitSet FOLLOW_block_in_delegate_stmt_decl596 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_delegate_stmt_decl600 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_expr_in_delegate_stmt_decl611 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_delegate_stmt_decl624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statements_in_block649 = new BitSet(new long[]{0x001C0000EE000010L});
    public static final BitSet FOLLOW_return_stmt_in_block656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_stmt_in_statements675 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_stmt_in_statements687 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_stmt_in_statements699 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_strm_in_statements711 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_statements723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_stmt_in_statements733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_stmt_in_statements743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_stmt_in_statements753 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_delegate_in_statements769 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assign_stmt797 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_assign_stmt799 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_expr_in_assign_stmt801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_in_expr825 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_20_in_expr841 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_21_in_expr845 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_expr_in_expr850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_power_in_mult882 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_22_in_mult897 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_23_in_mult902 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_mult_in_mult907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cast_stmt_in_power948 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_power961 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_power_in_power965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_cast_stmt1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_stmt1018 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_decl_stmt1020 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_decl_stmt1027 = new BitSet(new long[]{0x001FC0076E0008F0L});
    public static final BitSet FOLLOW_expr_in_decl_stmt1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_delegate_in_decl_stmt1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_write_stmt1058 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_write_stmt1060 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_atom_in_write_stmt1062 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_write_stmt1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_atom1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_atom1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_stmt_in_atom1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elem_stmt_in_atom1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_string_stmt_in_atom1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indexOf_stmt_in_atom1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_op_in_atom1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_firstElem_in_atom1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_substring_op_in_atom1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_char_c1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_read_strm1277 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_read_strm1279 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_read_strm1281 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_read_strm1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_if_stmt1299 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_stmt1301 = new BitSet(new long[]{0x0003F027000008F0L});
    public static final BitSet FOLLOW_expression_in_if_stmt1303 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_if_stmt1305 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt1307 = new BitSet(new long[]{0x001C0000EE000010L});
    public static final BitSet FOLLOW_block_in_if_stmt1311 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt1313 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_if_stmt1316 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt1318 = new BitSet(new long[]{0x001C0000EE000010L});
    public static final BitSet FOLLOW_block_in_if_stmt1322 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_for_stmt1341 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_for_stmt1343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt1347 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt1349 = new BitSet(new long[]{0x0003F027000008F0L});
    public static final BitSet FOLLOW_expression_in_for_stmt1353 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt1355 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt1359 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_for_stmt1361 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_for_stmt1363 = new BitSet(new long[]{0x001C0000EE000010L});
    public static final BitSet FOLLOW_block_in_for_stmt1367 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_for_stmt1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_while_stmt1384 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_stmt1386 = new BitSet(new long[]{0x0003F027000008F0L});
    public static final BitSet FOLLOW_expression_in_while_stmt1390 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_while_stmt1392 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_while_stmt1394 = new BitSet(new long[]{0x001C0000EE000010L});
    public static final BitSet FOLLOW_block_in_while_stmt1398 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_while_stmt1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_return_stmt1422 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_atom_in_return_stmt1424 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_return_stmt1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_length_stmt1451 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_length_stmt1453 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_param_in_length_stmt1455 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_length_stmt1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_param1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_elem_stmt1507 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_elem_stmt1509 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_elem_stmt1510 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_elem_stmt1512 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_elem_stmt1514 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_elem_stmt1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_f_el1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_f_el1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_s_el1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_s_el1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_to_string_stmt1591 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_to_string_stmt1593 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_param_str_in_to_string_stmt1595 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_to_string_stmt1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param_str1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_param_str1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_param_str1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_call_func_stmt1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func1688 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_call_func1691 = new BitSet(new long[]{0x0003C007000088F0L});
    public static final BitSet FOLLOW_arg_call_in_call_func1693 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_call_func1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_arg_call1721 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_call1726 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_atom_in_arg_call1730 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_and_expression_in_expression1750 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_expression1755 = new BitSet(new long[]{0x0003F027000008F0L});
    public static final BitSet FOLLOW_expression_in_expression1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_expression_in_and_expression1783 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_and_expression1788 = new BitSet(new long[]{0x0003F027000008F0L});
    public static final BitSet FOLLOW_and_expression_in_and_expression1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_not_expression1812 = new BitSet(new long[]{0x0003F027000008F0L});
    public static final BitSet FOLLOW_not_expression_in_not_expression1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_not_expression1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_comparison1843 = new BitSet(new long[]{0x00000FC000000000L});
    public static final BitSet FOLLOW_set_in_comparison1847 = new BitSet(new long[]{0x0003C007000008F0L});
    public static final BitSet FOLLOW_atom_in_comparison1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equal_op_in_comparison1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_contain_op_in_comparison1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_equal_op1898 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_equal_op1900 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_equal_op1904 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_equal_op1906 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_equal_op1910 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_equal_op1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_contain_op1927 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_contain_op1929 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_contain_op1933 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_contain_op1935 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_contain_op1939 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_contain_op1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_indexOf_stmt1956 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_indexOf_stmt1958 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_indexOf_stmt1962 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_indexOf_stmt1964 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_indexOf_stmt1968 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_indexOf_stmt1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_replace_op1984 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_replace_op1986 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_op1988 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_op1990 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_char_param_in_replace_op1994 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_op1996 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_char_param_in_replace_op2000 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_replace_op2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_char_param2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_char_param2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_replace_firstElem2041 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_replace_firstElem2043 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_firstElem2047 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_firstElem2049 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_firstElem2053 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_firstElem2055 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_firstElem2059 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_replace_firstElem2061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_substring_op2076 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_substring_op2078 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_substring_op2082 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_substring_op2084 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_substring_op2088 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_substring_op2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_substring_op2097 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_substring_op2099 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_substring_op2103 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_substring_op2105 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_substring_op2109 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_substring_op2111 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_substring_op2115 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_substring_op2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_type2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_type2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_type2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_type_func2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_type_func2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_type_func2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_type_func2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_delegate2263 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_call_delegate2264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_call_delegate2267 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_call_delegate2269 = new BitSet(new long[]{0x0003C007000088F0L});
    public static final BitSet FOLLOW_arg_call_in_call_delegate2271 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_call_delegate2273 = new BitSet(new long[]{0x0000000000000002L});

}