// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g 2012-06-19 00:39:46

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "STRING", "CHAR", "COMMENT", "WS", "'main'", "'{'", "'}'", "';'", "'('", "')'", "','", "'='", "'+'", "'-'", "'write'", "'read'", "'if'", "'else'", "'for'", "'while'", "'return'", "'length'", "'elem'", "'ToString'", "'||'", "'&&'", "'!'", "'<'", "'>'", "'=='", "'!='", "'>='", "'<='", "'equals'", "'contains'", "'indexOf'", "'replace'", "'int'", "'string'", "'char'", "'void'"
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
    				//parser.program();
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:97:1: program : ( global_variables )* ( functions )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName);
    public final MyStrLangParser.program_return program() throws RecognitionException {
        program_stack.push(new program_scope());
        MyStrLangParser.program_return retval = new MyStrLangParser.program_return();
        retval.start = input.LT(1);

        MyStrLangParser.functions_return functions1 = null;

        MyStrLangParser.mainBlock_return mainBlock2 = null;



        	((program_scope)program_stack.peek()).curBlock = "";
        	((program_scope)program_stack.peek()).global_variables = new ArrayList();
        	((program_scope)program_stack.peek()).functions = new ArrayList();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:108:2: ( ( global_variables )* ( functions )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:108:4: ( global_variables )* ( functions )* mainBlock EOF
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:108:4: ( global_variables )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 43:
                    {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=43 && LA1_6<=45)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 44:
                    {
                    int LA1_3 = input.LA(2);

                    if ( (LA1_3==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=43 && LA1_6<=45)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 45:
                    {
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=43 && LA1_6<=45)) ) {
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
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:108:4: global_variables
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

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:108:22: ( functions )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||(LA2_0>=43 && LA2_0<=46)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:108:23: functions
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

            ((program_scope)program_stack.peek()).curBlock ="main";
            pushFollow(FOLLOW_mainBlock_in_program73);
            mainBlock2=mainBlock();

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_program75); 


            // TEMPLATE REWRITE
            // 109:3: -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName)
            {
                retval.st = templateLib.getInstanceOf("program",
              new STAttrMap().put("global_variables", ((program_scope)program_stack.peek()).global_variables).put("functions", ((program_scope)program_stack.peek()).functions).put("program", (mainBlock2!=null?mainBlock2.st:null)).put("programName", programName));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:112:1: mainBlock : 'main' '{' block '}' -> mainBlock(block=$block.stList);
    public final MyStrLangParser.mainBlock_return mainBlock() throws RecognitionException {
        MyStrLangParser.mainBlock_return retval = new MyStrLangParser.mainBlock_return();
        retval.start = input.LT(1);

        MyStrLangParser.block_return block3 = null;



        	counter = 0;
        	labelCounter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:117:2: ( 'main' '{' block '}' -> mainBlock(block=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:117:4: 'main' '{' block '}'
            {
            match(input,10,FOLLOW_10_in_mainBlock117); 
            match(input,11,FOLLOW_11_in_mainBlock119); 
            pushFollow(FOLLOW_block_in_mainBlock121);
            block3=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_mainBlock123); 


            // TEMPLATE REWRITE
            // 118:3: -> mainBlock(block=$block.stList)
            {
                retval.st = templateLib.getInstanceOf("mainBlock",
              new STAttrMap().put("block", (block3!=null?block3.stList:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:121:1: global_variables : ( global_declaration )* ';' ;
    public final MyStrLangParser.global_variables_return global_variables() throws RecognitionException {
        MyStrLangParser.global_variables_return retval = new MyStrLangParser.global_variables_return();
        retval.start = input.LT(1);

        MyStrLangParser.global_declaration_return global_declaration4 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:122:2: ( ( global_declaration )* ';' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:122:4: ( global_declaration )* ';'
            {
             ((program_scope)program_stack.peek()).curBlock = "global";
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:122:38: ( global_declaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=43 && LA3_0<=45)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:122:39: global_declaration
            	    {
            	    pushFollow(FOLLOW_global_declaration_in_global_variables149);
            	    global_declaration4=global_declaration();

            	    state._fsp--;

            	    ((program_scope)program_stack.peek()).global_variables.add((global_declaration4!=null?global_declaration4.st:null));

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_global_variables155); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:125:1: global_declaration : type ID -> global_declaration(ident=$ID.texttype=$type.st);
    public final MyStrLangParser.global_declaration_return global_declaration() throws RecognitionException {
        MyStrLangParser.global_declaration_return retval = new MyStrLangParser.global_declaration_return();
        retval.start = input.LT(1);

        Token ID5=null;
        MyStrLangParser.type_return type6 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:126:2: ( type ID -> global_declaration(ident=$ID.texttype=$type.st))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:126:4: type ID
            {
            pushFollow(FOLLOW_type_in_global_declaration167);
            type6=type();

            state._fsp--;

            ID5=(Token)match(input,ID,FOLLOW_ID_in_global_declaration169); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID5!=null?ID5.getText():null)))
            		{
            			NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID5!=null?ID5.getText():null), (type6!=null?input.toString(type6.start,type6.stop):null), (ID5!=null?ID5.getLine():0));
            			var.setNumber(counter);
            			names.addVariable(var);
            			counter++;
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID5!=null?ID5.getText():null)))
            				errors.add("line "+(ID5!=null?ID5.getLine():0)+": Duplicated variable name "+(ID5!=null?ID5.getText():null));
            		}
            	


            // TEMPLATE REWRITE
            // 142:2: -> global_declaration(ident=$ID.texttype=$type.st)
            {
                retval.st = templateLib.getInstanceOf("global_declaration",
              new STAttrMap().put("ident", (ID5!=null?ID5.getText():null)).put("type", (type6!=null?type6.st:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:145:1: functions : type_func ID '(' arg_list ')' '{' block '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList);
    public final MyStrLangParser.functions_return functions() throws RecognitionException {
        functions_stack.push(new functions_scope());
        MyStrLangParser.functions_return retval = new MyStrLangParser.functions_return();
        retval.start = input.LT(1);

        Token ID8=null;
        MyStrLangParser.type_func_return type_func7 = null;

        MyStrLangParser.arg_list_return arg_list9 = null;

        MyStrLangParser.block_return block10 = null;



        	((functions_scope)functions_stack.peek()).funcName = "";
        	((functions_scope)functions_stack.peek()).funcType = "";
        	((functions_scope)functions_stack.peek()).funcArgNames = new ArrayList<String>();
        	((functions_scope)functions_stack.peek()).funcArgTypes = new ArrayList<String>();
        	labelCounter = 0;
        	counter=0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:162:2: ( type_func ID '(' arg_list ')' '{' block '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:162:4: type_func ID '(' arg_list ')' '{' block '}'
            {
            pushFollow(FOLLOW_type_func_in_functions208);
            type_func7=type_func();

            state._fsp--;

            ((functions_scope)functions_stack.peek()).funcType = (type_func7!=null?input.toString(type_func7.start,type_func7.stop):null); _funcType = (type_func7!=null?input.toString(type_func7.start,type_func7.stop):null); 
            ID8=(Token)match(input,ID,FOLLOW_ID_in_functions215); 
            ((program_scope)program_stack.peek()).curBlock = (ID8!=null?ID8.getText():null); ((functions_scope)functions_stack.peek()).funcName =(ID8!=null?ID8.getText():null); _funcName = (ID8!=null?ID8.getText():null);
            match(input,14,FOLLOW_14_in_functions220); 
            pushFollow(FOLLOW_arg_list_in_functions222);
            arg_list9=arg_list();

            state._fsp--;

            match(input,15,FOLLOW_15_in_functions224); 

            		if(!names.isExistFunction((ID8!=null?ID8.getText():null)))
            		{
            			names.addFunction(names.new FunctionName((ID8!=null?ID8.getText():null), (type_func7!=null?input.toString(type_func7.start,type_func7.stop):null), ((functions_scope)functions_stack.peek()).funcArgTypes, ((functions_scope)functions_stack.peek()).funcArgNames, (ID8!=null?ID8.getLine():0)));
            		}
            		else
            		{
            			errors.add("line "+(ID8!=null?ID8.getLine():0)+": Duplicated declaration function "+(ID8!=null?ID8.getText():null));
            		}
            	
            match(input,11,FOLLOW_11_in_functions232); 
            pushFollow(FOLLOW_block_in_functions237);
            block10=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_functions240); 


            // TEMPLATE REWRITE
            // 179:2: -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList)
            {
                retval.st = templateLib.getInstanceOf("functions",
              new STAttrMap().put("type", (type_func7!=null?type_func7.st:null)).put("ident", (ID8!=null?ID8.getText():null)).put("args", (arg_list9!=null?arg_list9.stList:null)).put("returnType", (type_func7!=null?type_func7.returnType:null)).put("block", (block10!=null?block10.stList:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:182:1: arg_list returns [List<StringTemplate> stList] : (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? ;
    public final MyStrLangParser.arg_list_return arg_list() throws RecognitionException {
        MyStrLangParser.arg_list_return retval = new MyStrLangParser.arg_list_return();
        retval.start = input.LT(1);

        Token firstId=null;
        Token secondId=null;
        MyStrLangParser.type_return firstType = null;

        MyStrLangParser.type_return secondType = null;



        	retval.stList = new ArrayList<StringTemplate>();
        	//counter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:187:2: ( (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:187:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:187:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=43 && LA5_0<=45)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:188:3: firstType= type firstId= ID ( ',' secondType= type secondId= ID )*
                    {
                    pushFollow(FOLLOW_type_in_arg_list294);
                    firstType=type();

                    state._fsp--;

                    firstId=(Token)match(input,ID,FOLLOW_ID_in_arg_list298); 

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
                    		
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:205:4: ( ',' secondType= type secondId= ID )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:205:5: ',' secondType= type secondId= ID
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_list308); 
                    	    pushFollow(FOLLOW_type_in_arg_list312);
                    	    secondType=type();

                    	    state._fsp--;

                    	    secondId=(Token)match(input,ID,FOLLOW_ID_in_arg_list316); 

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
                    	    break loop4;
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

    public static class block_return extends ParserRuleReturnScope {
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "block"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:226:1: block returns [List<StringTemplate> stList] : ( statements )* ( return_stmt ) ;
    public final MyStrLangParser.block_return block() throws RecognitionException {
        MyStrLangParser.block_return retval = new MyStrLangParser.block_return();
        retval.start = input.LT(1);

        MyStrLangParser.statements_return statements11 = null;

        MyStrLangParser.return_stmt_return return_stmt12 = null;



        	retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:230:2: ( ( statements )* ( return_stmt ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:230:4: ( statements )* ( return_stmt )
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:230:4: ( statements )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ID||(LA6_0>=20 && LA6_0<=22)||(LA6_0>=24 && LA6_0<=25)||(LA6_0>=43 && LA6_0<=45)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:230:5: statements
            	    {
            	    pushFollow(FOLLOW_statements_in_block354);
            	    statements11=statements();

            	    state._fsp--;

            	    retval.stList.add((statements11!=null?statements11.st:null));

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:230:49: ( return_stmt )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:230:50: return_stmt
            {
            pushFollow(FOLLOW_return_stmt_in_block361);
            return_stmt12=return_stmt();

            state._fsp--;

            retval.stList.add((return_stmt12!=null?return_stmt12.st:null));

            }

            		
            		if(((program_scope)program_stack.peek()).curBlock!="main"){
            			String name = ((program_scope)program_stack.peek()).curBlock;
            			NamesTable.FunctionName func = names.getFunction(name);
            			String type = func.getReturnType();
            			if((return_stmt12!=null?return_stmt12.value:null)==null)
            			{
            				if(!type.equals("void"))
            					errors.add("line "+(return_stmt12!=null?return_stmt12.line:0)+": Not found the keyword return in function with name "+name);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:245:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st});
    public final MyStrLangParser.statements_return statements() throws RecognitionException {
        MyStrLangParser.statements_return retval = new MyStrLangParser.statements_return();
        retval.start = input.LT(1);

        MyStrLangParser.assign_stmt_return assign_stmt13 = null;

        MyStrLangParser.decl_stmt_return decl_stmt14 = null;

        MyStrLangParser.write_stmt_return write_stmt15 = null;

        MyStrLangParser.read_strm_return read_strm16 = null;

        MyStrLangParser.if_stmt_return if_stmt17 = null;

        MyStrLangParser.for_stmt_return for_stmt18 = null;

        MyStrLangParser.while_stmt_return while_stmt19 = null;

        MyStrLangParser.call_func_stmt_return call_func_stmt20 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:246:2: ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st})
            int alt7=8;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:246:4: assign_stmt ';'
                    {
                    pushFollow(FOLLOW_assign_stmt_in_statements379);
                    assign_stmt13=assign_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements381); 


                    // TEMPLATE REWRITE
                    // 246:20: -> {$assign_stmt.st}
                    {
                        retval.st = (assign_stmt13!=null?assign_stmt13.st:null);
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:247:4: decl_stmt ';'
                    {
                    pushFollow(FOLLOW_decl_stmt_in_statements390);
                    decl_stmt14=decl_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements392); 


                    // TEMPLATE REWRITE
                    // 247:18: -> {$decl_stmt.st}
                    {
                        retval.st = (decl_stmt14!=null?decl_stmt14.st:null);
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:248:4: write_stmt ';'
                    {
                    pushFollow(FOLLOW_write_stmt_in_statements401);
                    write_stmt15=write_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements403); 


                    // TEMPLATE REWRITE
                    // 248:19: -> {$write_stmt.st}
                    {
                        retval.st = (write_stmt15!=null?write_stmt15.st:null);
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:249:4: read_strm ';'
                    {
                    pushFollow(FOLLOW_read_strm_in_statements412);
                    read_strm16=read_strm();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements414); 


                    // TEMPLATE REWRITE
                    // 249:18: -> {$read_strm.st}
                    {
                        retval.st = (read_strm16!=null?read_strm16.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:250:4: if_stmt
                    {
                    pushFollow(FOLLOW_if_stmt_in_statements423);
                    if_stmt17=if_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 250:12: -> {$if_stmt.st}
                    {
                        retval.st = (if_stmt17!=null?if_stmt17.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:251:4: for_stmt
                    {
                    pushFollow(FOLLOW_for_stmt_in_statements432);
                    for_stmt18=for_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 251:13: -> {$for_stmt.st}
                    {
                        retval.st = (for_stmt18!=null?for_stmt18.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:252:4: while_stmt
                    {
                    pushFollow(FOLLOW_while_stmt_in_statements441);
                    while_stmt19=while_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 252:15: -> {$while_stmt.st}
                    {
                        retval.st = (while_stmt19!=null?while_stmt19.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:253:5: call_func_stmt ';'
                    {
                    pushFollow(FOLLOW_call_func_stmt_in_statements451);
                    call_func_stmt20=call_func_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements453); 


                    // TEMPLATE REWRITE
                    // 253:24: -> {$call_func_stmt.st}
                    {
                        retval.st = (call_func_stmt20!=null?call_func_stmt20.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:256:1: assign_stmt : ID '=' expr ;
    public final MyStrLangParser.assign_stmt_return assign_stmt() throws RecognitionException {
        MyStrLangParser.assign_stmt_return retval = new MyStrLangParser.assign_stmt_return();
        retval.start = input.LT(1);

        Token ID21=null;
        MyStrLangParser.expr_return expr22 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:257:2: ( ID '=' expr )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:257:4: ID '=' expr
            {
            ID21=(Token)match(input,ID,FOLLOW_ID_in_assign_stmt469); 
            match(input,17,FOLLOW_17_in_assign_stmt471); 
            pushFollow(FOLLOW_expr_in_assign_stmt473);
            expr22=expr();

            state._fsp--;


            		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID21!=null?ID21.getText():null)))
            		{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID21!=null?ID21.getText():null));
            			String varType = var_type.getType();
            			if(!TypesChecker.checkTypes(varType, (expr22!=null?expr22.type:null)))
            			{
            				errors.add("line "+(ID21!=null?ID21.getLine():0)+": Type mismatch: cannot convert from "+varType+" to "+(expr22!=null?expr22.type:null));
            			}
            			if(TypesChecker.isInteger(varType))
            			{
            				if(names.isGlobal((ID21!=null?ID21.getText():null))){
            					retval.st = templateLib.getInstanceOf("assign_field_int",
              new STAttrMap().put("expression", (expr22!=null?expr22.st:null)).put("programName", programName).put("fieldName", (ID21!=null?ID21.getText():null)));
            				} 
            				else{
            					retval.st = templateLib.getInstanceOf("assign_var_int",
              new STAttrMap().put("expression", (expr22!=null?expr22.st:null)).put("counter", var_type.getNumber()));
            				}
            			}
            			if(TypesChecker.isString(varType))
            			{
            				if(names.isGlobal((ID21!=null?ID21.getText():null))){
            					retval.st = templateLib.getInstanceOf("assign_field_string",
              new STAttrMap().put("expression", (expr22!=null?expr22.st:null)).put("programName", programName).put("fieldName", (ID21!=null?ID21.getText():null)));
            				} 
            				else{
            					retval.st = templateLib.getInstanceOf("assign_var_string",
              new STAttrMap().put("expression", (expr22!=null?expr22.st:null)).put("counter", var_type.getNumber()));
            				}
            			}
            			if(TypesChecker.isChar(varType))
            			{
            				if(names.isGlobal((ID21!=null?ID21.getText():null))){
            					retval.st = templateLib.getInstanceOf("assign_field_char",
              new STAttrMap().put("expression", (expr22!=null?expr22.st:null)).put("programName", programName).put("fieldName", (ID21!=null?ID21.getText():null)));
            				} 
            				else{
            					retval.st = templateLib.getInstanceOf("assign_var_char",
              new STAttrMap().put("expression", (expr22!=null?expr22.st:null)).put("counter", var_type.getNumber()));
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
    // $ANTLR end "assign_stmt"

    public static class expr_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "expr"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:299:1: expr returns [String type] : firstAssign= atom ( (op= '+' | op= '-' ) secondAssign= atom )? ;
    public final MyStrLangParser.expr_return expr() throws RecognitionException {
        MyStrLangParser.expr_return retval = new MyStrLangParser.expr_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.atom_return firstAssign = null;

        MyStrLangParser.atom_return secondAssign = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:300:2: (firstAssign= atom ( (op= '+' | op= '-' ) secondAssign= atom )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:301:3: firstAssign= atom ( (op= '+' | op= '-' ) secondAssign= atom )?
            {
            pushFollow(FOLLOW_atom_in_expr497);
            firstAssign=atom();

            state._fsp--;


            			retval.type = (firstAssign!=null?firstAssign.type:null);
            			retval.st = (firstAssign!=null?firstAssign.st:null);
            		
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:306:3: ( (op= '+' | op= '-' ) secondAssign= atom )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=18 && LA9_0<=19)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:307:4: (op= '+' | op= '-' ) secondAssign= atom
                    {
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:307:4: (op= '+' | op= '-' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==18) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==19) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:307:5: op= '+'
                            {
                            op=(Token)match(input,18,FOLLOW_18_in_expr513); 

                            }
                            break;
                        case 2 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:307:12: op= '-'
                            {
                            op=(Token)match(input,19,FOLLOW_19_in_expr517); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_atom_in_expr522);
                    secondAssign=atom();

                    state._fsp--;


                    				retval.type = (firstAssign!=null?firstAssign.type:null);
                    				String t_1 = (secondAssign!=null?secondAssign.type:null);
                    				if(TypesChecker.isChar((secondAssign!=null?secondAssign.type:null)))
                    				{
                    					errors.add("line "+(op!=null?op.getLine():0)+": impossibly addition type of char to char");
                    				}
                    				if(!TypesChecker.checkTypes((firstAssign!=null?firstAssign.type:null), (secondAssign!=null?secondAssign.type:null)))
                    				{
                    					errors.add("line "+(op!=null?op.getLine():0)+": mismatch in math operation. Found "+(firstAssign!=null?firstAssign.type:null)+"and"+(secondAssign!=null?secondAssign.type:null));
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

    public static class decl_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "decl_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:342:1: decl_stmt : type ID ;
    public final MyStrLangParser.decl_stmt_return decl_stmt() throws RecognitionException {
        MyStrLangParser.decl_stmt_return retval = new MyStrLangParser.decl_stmt_return();
        retval.start = input.LT(1);

        Token ID23=null;
        MyStrLangParser.type_return type24 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:343:2: ( type ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:343:4: type ID
            {
            pushFollow(FOLLOW_type_in_decl_stmt546);
            type24=type();

            state._fsp--;

            ID23=(Token)match(input,ID,FOLLOW_ID_in_decl_stmt548); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID23!=null?ID23.getText():null)))
            		{
            			NamesTable.VariableName var = names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID23!=null?ID23.getText():null), (type24!=null?input.toString(type24.start,type24.stop):null), (ID23!=null?ID23.getLine():0));
            			var.setNumber(counter);
            			names.addVariable(var);	
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID23!=null?ID23.getText():null)))
            				errors.add("line "+(ID23!=null?ID23.getLine():0)+": Duplicated variable name "+(ID23!=null?ID23.getText():null));
            		}
            		
            		if(TypesChecker.isInteger((type24!=null?input.toString(type24.start,type24.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_int",
              new STAttrMap().put("counter", counter));
            		}
            		if(TypesChecker.isString((type24!=null?input.toString(type24.start,type24.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_string",
              new STAttrMap().put("counter", counter));
            		}
            		
            		if(TypesChecker.isChar((type24!=null?input.toString(type24.start,type24.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_char",
              new STAttrMap().put("counter", counter));
            		}
            		
            		counter++;
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:375:1: write_stmt : 'write' '(' atom ')' ;
    public final MyStrLangParser.write_stmt_return write_stmt() throws RecognitionException {
        MyStrLangParser.write_stmt_return retval = new MyStrLangParser.write_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return atom25 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:376:2: ( 'write' '(' atom ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:376:4: 'write' '(' atom ')'
            {
            match(input,20,FOLLOW_20_in_write_stmt563); 
            match(input,14,FOLLOW_14_in_write_stmt565); 
            pushFollow(FOLLOW_atom_in_write_stmt567);
            atom25=atom();

            state._fsp--;

            match(input,15,FOLLOW_15_in_write_stmt569); 

            		if(TypesChecker.isInteger((atom25!=null?atom25.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_int",
              new STAttrMap().put("expression", (atom25!=null?atom25.st:null)));
            		}
            		if(TypesChecker.isString((atom25!=null?atom25.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_string",
              new STAttrMap().put("string", (atom25!=null?atom25.st:null)));
            		}
            		if(TypesChecker.isChar((atom25!=null?atom25.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_char",
              new STAttrMap().put("string", (atom25!=null?atom25.st:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:393:1: atom returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st});
    public final MyStrLangParser.atom_return atom() throws RecognitionException {
        MyStrLangParser.atom_return retval = new MyStrLangParser.atom_return();
        retval.start = input.LT(1);

        Token ID26=null;
        Token INT27=null;
        Token STRING28=null;
        MyStrLangParser.char_c_return char_c29 = null;

        MyStrLangParser.call_func_return call_func30 = null;

        MyStrLangParser.length_stmt_return length_stmt31 = null;

        MyStrLangParser.elem_stmt_return elem_stmt32 = null;

        MyStrLangParser.to_string_stmt_return to_string_stmt33 = null;

        MyStrLangParser.indexOf_stmt_return indexOf_stmt34 = null;

        MyStrLangParser.replace_op_return replace_op35 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:394:2: ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st})
            int alt10=10;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:394:4: ID
                    {
                    ID26=(Token)match(input,ID,FOLLOW_ID_in_atom588); 

                    		retval.text = (ID26!=null?ID26.getText():null);
                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID26!=null?ID26.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID26!=null?ID26.getText():null));
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
                    			errors.add("line "+(ID26!=null?ID26.getLine():0)+": unknown variable "+(ID26!=null?ID26.getText():null));
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:439:4: INT
                    {
                    INT27=(Token)match(input,INT,FOLLOW_INT_in_atom595); 
                    retval.text = (INT27!=null?INT27.getText():null); retval.type = "int";


                    // TEMPLATE REWRITE
                    // 439:47: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT27!=null?INT27.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:440:4: STRING
                    {
                    STRING28=(Token)match(input,STRING,FOLLOW_STRING_in_atom614); 
                    retval.text = (STRING28!=null?STRING28.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 440:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING28!=null?STRING28.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:441:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_atom632);
                    char_c29=char_c();

                    state._fsp--;

                    retval.type = "char";


                    // TEMPLATE REWRITE
                    // 441:33: -> {$char_c.st}
                    {
                        retval.st = (char_c29!=null?char_c29.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:442:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_atom647);
                    call_func30=call_func();

                    state._fsp--;

                    retval.type =(call_func30!=null?call_func30.type:null);


                    // TEMPLATE REWRITE
                    // 442:40: -> {$call_func.st}
                    {
                        retval.st = (call_func30!=null?call_func30.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:443:4: length_stmt
                    {
                    pushFollow(FOLLOW_length_stmt_in_atom659);
                    length_stmt31=length_stmt();

                    state._fsp--;

                    retval.type ="int";


                    // TEMPLATE REWRITE
                    // 443:33: -> {$length_stmt.st}
                    {
                        retval.st = (length_stmt31!=null?length_stmt31.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:444:4: elem_stmt
                    {
                    pushFollow(FOLLOW_elem_stmt_in_atom672);
                    elem_stmt32=elem_stmt();

                    state._fsp--;

                    retval.type ="char";


                    // TEMPLATE REWRITE
                    // 444:32: -> {$elem_stmt.st}
                    {
                        retval.st = (elem_stmt32!=null?elem_stmt32.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:445:4: to_string_stmt
                    {
                    pushFollow(FOLLOW_to_string_stmt_in_atom685);
                    to_string_stmt33=to_string_stmt();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 445:38: -> {$to_string_stmt.st}
                    {
                        retval.st = (to_string_stmt33!=null?to_string_stmt33.st:null);
                    }


                    }
                    break;
                case 9 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:446:4: indexOf_stmt
                    {
                    pushFollow(FOLLOW_indexOf_stmt_in_atom697);
                    indexOf_stmt34=indexOf_stmt();

                    state._fsp--;

                    retval.type ="int";


                    // TEMPLATE REWRITE
                    // 446:34: -> {$indexOf_stmt.st}
                    {
                        retval.st = (indexOf_stmt34!=null?indexOf_stmt34.st:null);
                    }


                    }
                    break;
                case 10 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:447:4: replace_op
                    {
                    pushFollow(FOLLOW_replace_op_in_atom710);
                    replace_op35=replace_op();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 447:35: -> {$replace_op.st}
                    {
                        retval.st = (replace_op35!=null?replace_op35.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:450:1: char_c returns [int numb] : CHAR -> const_char(cod=$numb);
    public final MyStrLangParser.char_c_return char_c() throws RecognitionException {
        MyStrLangParser.char_c_return retval = new MyStrLangParser.char_c_return();
        retval.start = input.LT(1);

        Token CHAR36=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:451:2: ( CHAR -> const_char(cod=$numb))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:451:4: CHAR
            {
            CHAR36=(Token)match(input,CHAR,FOLLOW_CHAR_in_char_c733); 
            	
            			String str = (CHAR36!=null?CHAR36.getText():null);
            			char el = str.charAt(1);
            			try{
            				retval.numb = Character.toString(el).getBytes("cp1251")[0];
            			}
            			catch(UnsupportedEncodingException e)
            			{
            				e.printStackTrace();
            			}
            	


            // TEMPLATE REWRITE
            // 463:3: -> const_char(cod=$numb)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:466:1: read_strm : 'read' '(' ID ')' ;
    public final MyStrLangParser.read_strm_return read_strm() throws RecognitionException {
        MyStrLangParser.read_strm_return retval = new MyStrLangParser.read_strm_return();
        retval.start = input.LT(1);

        Token ID37=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:467:2: ( 'read' '(' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:467:4: 'read' '(' ID ')'
            {
            match(input,21,FOLLOW_21_in_read_strm759); 
            match(input,14,FOLLOW_14_in_read_strm761); 
            ID37=(Token)match(input,ID,FOLLOW_ID_in_read_strm763); 
            match(input,15,FOLLOW_15_in_read_strm765); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID37!=null?ID37.getText():null)))
            			errors.add("line "+(ID37!=null?ID37.getLine():0)+": unknown variable "+(ID37!=null?ID37.getText():null));
            		else{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID37!=null?ID37.getText():null));
            			String varType = var_type.getType();
            			if(TypesChecker.isInteger(varType))
            			{
            				if(names.isGlobal((ID37!=null?ID37.getText():null))){
            					retval.st = templateLib.getInstanceOf("read_field_int",
              new STAttrMap().put("programName", programName).put("fieldName", (ID37!=null?ID37.getText():null)));
            				} else
            					retval.st = templateLib.getInstanceOf("read_var_int",
              new STAttrMap().put("counter", var_type.getNumber()));
            			}
            			if(TypesChecker.isString(varType))
            			{
            				if(names.isGlobal((ID37!=null?ID37.getText():null))){
            					retval.st = templateLib.getInstanceOf("read_field_string",
              new STAttrMap().put("programName", programName).put("fieldName", (ID37!=null?ID37.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:492:1: if_stmt : 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )? ;
    public final MyStrLangParser.if_stmt_return if_stmt() throws RecognitionException {
        MyStrLangParser.if_stmt_return retval = new MyStrLangParser.if_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.block_return ifBlock = null;

        MyStrLangParser.block_return elseBlock = null;

        MyStrLangParser.expression_return expression38 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:493:2: ( 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:493:4: 'if' '(' expression ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )?
            {
            match(input,22,FOLLOW_22_in_if_stmt781); 
            match(input,14,FOLLOW_14_in_if_stmt783); 
            pushFollow(FOLLOW_expression_in_if_stmt785);
            expression38=expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_if_stmt787); 
            match(input,11,FOLLOW_11_in_if_stmt789); 
            pushFollow(FOLLOW_block_in_if_stmt793);
            ifBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_if_stmt795); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:493:50: ( 'else' '{' elseBlock= block '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:493:51: 'else' '{' elseBlock= block '}'
                    {
                    match(input,23,FOLLOW_23_in_if_stmt798); 
                    match(input,11,FOLLOW_11_in_if_stmt800); 
                    pushFollow(FOLLOW_block_in_if_stmt804);
                    elseBlock=block();

                    state._fsp--;

                    match(input,12,FOLLOW_12_in_if_stmt806); 

                    }
                    break;

            }


            		retval.st = templateLib.getInstanceOf("if_operation",
              new STAttrMap().put("expression", (expression38!=null?expression38.st:null)).put("ifBlock", (ifBlock!=null?ifBlock.stList:null)).put("elseBlock", (elseBlock!=null?elseBlock.stList:null)).put("trueLabel", labelCounter).put("falseLabel", labelCounter+1));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:501:1: for_stmt : 'for' '(' (begin= assign_stmt )? ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}' ;
    public final MyStrLangParser.for_stmt_return for_stmt() throws RecognitionException {
        MyStrLangParser.for_stmt_return retval = new MyStrLangParser.for_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.assign_stmt_return begin = null;

        MyStrLangParser.expression_return check = null;

        MyStrLangParser.assign_stmt_return end = null;

        MyStrLangParser.block_return forBlock = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:502:2: ( 'for' '(' (begin= assign_stmt )? ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:502:4: 'for' '(' (begin= assign_stmt )? ';' check= expression ';' end= assign_stmt ')' '{' forBlock= block '}'
            {
            match(input,24,FOLLOW_24_in_for_stmt823); 
            match(input,14,FOLLOW_14_in_for_stmt825); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:502:19: (begin= assign_stmt )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:502:19: begin= assign_stmt
                    {
                    pushFollow(FOLLOW_assign_stmt_in_for_stmt829);
                    begin=assign_stmt();

                    state._fsp--;


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_for_stmt832); 
            pushFollow(FOLLOW_expression_in_for_stmt836);
            check=expression();

            state._fsp--;

            match(input,13,FOLLOW_13_in_for_stmt838); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt842);
            end=assign_stmt();

            state._fsp--;

            match(input,15,FOLLOW_15_in_for_stmt844); 
            match(input,11,FOLLOW_11_in_for_stmt846); 
            pushFollow(FOLLOW_block_in_for_stmt850);
            forBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_for_stmt852); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:510:1: while_stmt : 'while' '(' check= expression ')' '{' whileBlock= block '}' ;
    public final MyStrLangParser.while_stmt_return while_stmt() throws RecognitionException {
        MyStrLangParser.while_stmt_return retval = new MyStrLangParser.while_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.expression_return check = null;

        MyStrLangParser.block_return whileBlock = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:511:2: ( 'while' '(' check= expression ')' '{' whileBlock= block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:511:4: 'while' '(' check= expression ')' '{' whileBlock= block '}'
            {
            match(input,25,FOLLOW_25_in_while_stmt867); 
            match(input,14,FOLLOW_14_in_while_stmt869); 
            pushFollow(FOLLOW_expression_in_while_stmt873);
            check=expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_while_stmt875); 
            match(input,11,FOLLOW_11_in_while_stmt877); 
            pushFollow(FOLLOW_block_in_while_stmt881);
            whileBlock=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_while_stmt883); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:518:1: return_stmt returns [String value, int line] : (a= 'return' atom ';' )? -> {$atom.st};
    public final MyStrLangParser.return_stmt_return return_stmt() throws RecognitionException {
        MyStrLangParser.return_stmt_return retval = new MyStrLangParser.return_stmt_return();
        retval.start = input.LT(1);

        Token a=null;
        MyStrLangParser.atom_return atom39 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:519:2: ( (a= 'return' atom ';' )? -> {$atom.st})
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:520:2: (a= 'return' atom ';' )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:520:2: (a= 'return' atom ';' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:520:3: a= 'return' atom ';'
                    {
                    a=(Token)match(input,26,FOLLOW_26_in_return_stmt905); 
                    pushFollow(FOLLOW_atom_in_return_stmt907);
                    atom39=atom();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_return_stmt909); 
                    	
                    		if(((program_scope)program_stack.peek()).curBlock=="main")
                    			errors.add("line "+(a!=null?a.getLine():0)+": function main may not contain keyword return");
                    		retval.value = (atom39!=null?atom39.text:null);
                    		retval.line = (a!=null?a.getLine():0);
                    		
                    		String name = ((functions_scope)functions_stack.peek()).funcName;
                    		NamesTable.FunctionName func = names.getFunction(name);
                    		String type = func.getReturnType();
                    		
                    		if(type.equals("void")){
                    			errors.add("line "+(a!=null?a.getLine():0)+": type of void may not contain keyword return");
                    		}
                    		
                    		String rType = (atom39!=null?atom39.type:null);
                    		if(!TypesChecker.checkTypes(type,rType)){
                    			errors.add("line "+(a!=null?a.getLine():0)+": Type mismatch: cannot convert from "+type+" to "+rType);
                    		}
                    	

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 541:2: -> {$atom.st}
            {
                retval.st = (atom39!=null?atom39.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:544:1: length_stmt : 'length' '(' param ')' ;
    public final MyStrLangParser.length_stmt_return length_stmt() throws RecognitionException {
        MyStrLangParser.length_stmt_return retval = new MyStrLangParser.length_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.param_return param40 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:545:2: ( 'length' '(' param ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:545:4: 'length' '(' param ')'
            {
            match(input,27,FOLLOW_27_in_length_stmt934); 
            match(input,14,FOLLOW_14_in_length_stmt936); 
            pushFollow(FOLLOW_param_in_length_stmt938);
            param40=param();

            state._fsp--;

            match(input,15,FOLLOW_15_in_length_stmt940); 

            		retval.st = templateLib.getInstanceOf("length_string",
              new STAttrMap().put("string", (param40!=null?param40.st:null)));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:551:1: param returns [String text, String type] : ( ID | STRING -> const_string(value=$STRING.text));
    public final MyStrLangParser.param_return param() throws RecognitionException {
        MyStrLangParser.param_return retval = new MyStrLangParser.param_return();
        retval.start = input.LT(1);

        Token ID41=null;
        Token STRING42=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:552:2: ( ID | STRING -> const_string(value=$STRING.text))
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==STRING) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:552:4: ID
                    {
                    ID41=(Token)match(input,ID,FOLLOW_ID_in_param958); 

                    		retval.text = (ID41!=null?ID41.getText():null);
                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID41!=null?ID41.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID41!=null?ID41.getText():null));
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
                    				if(names.isGlobal(retval.type))
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
                    			errors.add("line "+(ID41!=null?ID41.getLine():0)+": unknown variable "+(ID41!=null?ID41.getText():null));
                    		}
                    		

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:586:4: STRING
                    {
                    STRING42=(Token)match(input,STRING,FOLLOW_STRING_in_param965); 
                    retval.text = (STRING42!=null?STRING42.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 586:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING42!=null?STRING42.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:589:1: elem_stmt : 'elem' '(' f_el ',' s_el ')' ;
    public final MyStrLangParser.elem_stmt_return elem_stmt() throws RecognitionException {
        MyStrLangParser.elem_stmt_return retval = new MyStrLangParser.elem_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return f_el43 = null;

        MyStrLangParser.s_el_return s_el44 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:590:2: ( 'elem' '(' f_el ',' s_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:590:4: 'elem' '(' f_el ',' s_el ')'
            {
            match(input,28,FOLLOW_28_in_elem_stmt990); 
            match(input,14,FOLLOW_14_in_elem_stmt992); 
            pushFollow(FOLLOW_f_el_in_elem_stmt993);
            f_el43=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_elem_stmt995); 
            pushFollow(FOLLOW_s_el_in_elem_stmt997);
            s_el44=s_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_elem_stmt999); 

            		retval.st = templateLib.getInstanceOf("elem_in_string",
              new STAttrMap().put("fValue", (f_el43!=null?f_el43.st:null)).put("sValue", (s_el44!=null?s_el44.st:null)));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:596:1: f_el : ( ID | STRING -> const_string(value=$STRING.text));
    public final MyStrLangParser.f_el_return f_el() throws RecognitionException {
        MyStrLangParser.f_el_return retval = new MyStrLangParser.f_el_return();
        retval.start = input.LT(1);

        Token ID45=null;
        Token STRING46=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:597:2: ( ID | STRING -> const_string(value=$STRING.text))
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ID) ) {
                alt15=1;
            }
            else if ( (LA15_0==STRING) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:597:4: ID
                    {
                    ID45=(Token)match(input,ID,FOLLOW_ID_in_f_el1014); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID45!=null?ID45.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID45!=null?ID45.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isString(type))
                    			{
                    				if(names.isGlobal((ID45!=null?ID45.getText():null)))
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
                    			errors.add("line "+(ID45!=null?ID45.getLine():0)+": unknown variable "+(ID45!=null?ID45.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:617:4: STRING
                    {
                    STRING46=(Token)match(input,STRING,FOLLOW_STRING_in_f_el1022); 


                    // TEMPLATE REWRITE
                    // 617:12: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING46!=null?STRING46.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:620:1: s_el : ( ID | INT -> const_int(value=$INT.text));
    public final MyStrLangParser.s_el_return s_el() throws RecognitionException {
        MyStrLangParser.s_el_return retval = new MyStrLangParser.s_el_return();
        retval.start = input.LT(1);

        Token ID47=null;
        Token INT48=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:621:2: ( ID | INT -> const_int(value=$INT.text))
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ID) ) {
                alt16=1;
            }
            else if ( (LA16_0==INT) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:621:4: ID
                    {
                    ID47=(Token)match(input,ID,FOLLOW_ID_in_s_el1044); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID47!=null?ID47.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID47!=null?ID47.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isInteger(type))
                    			{
                    				if(names.isGlobal((ID47!=null?ID47.getText():null)))
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
                    			errors.add("line "+(ID47!=null?ID47.getLine():0)+": unknown variable "+(ID47!=null?ID47.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:641:4: INT
                    {
                    INT48=(Token)match(input,INT,FOLLOW_INT_in_s_el1052); 


                    // TEMPLATE REWRITE
                    // 641:9: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT48!=null?INT48.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:644:1: to_string_stmt : 'ToString' '(' param_str ')' ;
    public final MyStrLangParser.to_string_stmt_return to_string_stmt() throws RecognitionException {
        MyStrLangParser.to_string_stmt_return retval = new MyStrLangParser.to_string_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.param_str_return param_str49 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:645:2: ( 'ToString' '(' param_str ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:645:4: 'ToString' '(' param_str ')'
            {
            match(input,29,FOLLOW_29_in_to_string_stmt1074); 
            match(input,14,FOLLOW_14_in_to_string_stmt1076); 
            pushFollow(FOLLOW_param_str_in_to_string_stmt1078);
            param_str49=param_str();

            state._fsp--;

            match(input,15,FOLLOW_15_in_to_string_stmt1080); 

            		if(TypesChecker.isInteger((param_str49!=null?param_str49.t:null))){
            			retval.st = templateLib.getInstanceOf("int_to_string",
              new STAttrMap().put("value", (param_str49!=null?param_str49.st:null)));
            		}
            		if(TypesChecker.isChar((param_str49!=null?param_str49.t:null))){
            			retval.st = templateLib.getInstanceOf("char_to_string",
              new STAttrMap().put("value", (param_str49!=null?param_str49.st:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:656:1: param_str returns [String t] : ( ID | INT -> const_int(value=$INT.text) | char_c -> {$char_c.st});
    public final MyStrLangParser.param_str_return param_str() throws RecognitionException {
        MyStrLangParser.param_str_return retval = new MyStrLangParser.param_str_return();
        retval.start = input.LT(1);

        Token ID50=null;
        Token INT51=null;
        MyStrLangParser.char_c_return char_c52 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:657:2: ( ID | INT -> const_int(value=$INT.text) | char_c -> {$char_c.st})
            int alt17=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt17=1;
                }
                break;
            case INT:
                {
                alt17=2;
                }
                break;
            case CHAR:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:657:4: ID
                    {
                    ID50=(Token)match(input,ID,FOLLOW_ID_in_param_str1098); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID50!=null?ID50.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID50!=null?ID50.getText():null));
                    			String type = v_type.getType();
                    			retval.t = type;
                    			if(TypesChecker.isInteger(type))
                    			{
                    				if(names.isGlobal((ID50!=null?ID50.getText():null)))
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
                    				if(names.isGlobal((ID50!=null?ID50.getText():null)))
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
                    			errors.add("line "+(ID50!=null?ID50.getLine():0)+": unknown variable "+(ID50!=null?ID50.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:689:4: INT
                    {
                    INT51=(Token)match(input,INT,FOLLOW_INT_in_param_str1106); 
                    retval.t ="int";


                    // TEMPLATE REWRITE
                    // 689:22: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT51!=null?INT51.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:690:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_param_str1124);
                    char_c52=char_c();

                    state._fsp--;

                    retval.t ="char";


                    // TEMPLATE REWRITE
                    // 690:25: -> {$char_c.st}
                    {
                        retval.st = (char_c52!=null?char_c52.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:693:1: call_func_stmt : call_func -> {$call_func.st};
    public final MyStrLangParser.call_func_stmt_return call_func_stmt() throws RecognitionException {
        MyStrLangParser.call_func_stmt_return retval = new MyStrLangParser.call_func_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.call_func_return call_func53 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:694:2: ( call_func -> {$call_func.st})
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:694:4: call_func
            {
            pushFollow(FOLLOW_call_func_in_call_func_stmt1143);
            call_func53=call_func();

            state._fsp--;



            // TEMPLATE REWRITE
            // 695:3: -> {$call_func.st}
            {
                retval.st = (call_func53!=null?call_func53.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:698:1: call_func returns [String type, int line] : ID '(' arg_call ')' ;
    public final MyStrLangParser.call_func_return call_func() throws RecognitionException {
        call_func_stack.push(new call_func_scope());
        MyStrLangParser.call_func_return retval = new MyStrLangParser.call_func_return();
        retval.start = input.LT(1);

        Token ID54=null;
        MyStrLangParser.arg_call_return arg_call55 = null;



        	((call_func_scope)call_func_stack.peek()).methodName = "";
        	List<StringTemplate> argTypes = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:706:2: ( ID '(' arg_call ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:706:4: ID '(' arg_call ')'
            {
            ID54=(Token)match(input,ID,FOLLOW_ID_in_call_func1171); 
            ((call_func_scope)call_func_stack.peek()).methodName =(ID54!=null?ID54.getText():null);
            match(input,14,FOLLOW_14_in_call_func1174); 
            pushFollow(FOLLOW_arg_call_in_call_func1176);
            arg_call55=arg_call();

            state._fsp--;

            match(input,15,FOLLOW_15_in_call_func1178); 

            		retval.line = (ID54!=null?ID54.getLine():0);
            		ArrayList<String> list = null;
            		if((arg_call55!=null?arg_call55.argumentTypeList:null)==null)
            			list = new ArrayList<String>();
            		else
            			list = (arg_call55!=null?arg_call55.argumentTypeList:null);
            		if(!names.checkCallFunction((ID54!=null?ID54.getText():null), list, (ID54!=null?ID54.getLine():0)))
            		{
            			names.getAllErrors(errors);
            		}
            		if(!names.isExistFunction((ID54!=null?ID54.getText():null)))
            		{
            			errors.add("line "+(ID54!=null?ID54.getLine():0)+": function "+(ID54!=null?ID54.getText():null)+" is not exist");
            		}
            		else
            		{
            			NamesTable.FunctionName func = names.getFunction((ID54!=null?ID54.getText():null));
            			retval.type = func.getReturnType();
            		}
            		
            		for(String arg_type: (arg_call55!=null?arg_call55.argumentTypeList:null))
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
              new STAttrMap().put("programName", programName).put("funcName", (ID54!=null?ID54.getText():null)).put("argTemplates", (arg_call55!=null?arg_call55.stList:null)).put("argTypes", argTypes).put("returnType", returnType));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:768:1: arg_call returns [ArrayList<String> argumentTypeList, List<StringTemplate> stList] : (a= atom ( ',' b= atom )* )? ;
    public final MyStrLangParser.arg_call_return arg_call() throws RecognitionException {
        MyStrLangParser.arg_call_return retval = new MyStrLangParser.arg_call_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return a = null;

        MyStrLangParser.atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:769:2: ( (a= atom ( ',' b= atom )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:770:2: (a= atom ( ',' b= atom )* )?
            {

            		retval.argumentTypeList = new ArrayList<String>();
            		retval.stList = new ArrayList<StringTemplate>();
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:774:2: (a= atom ( ',' b= atom )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=ID && LA19_0<=CHAR)||(LA19_0>=27 && LA19_0<=29)||(LA19_0>=41 && LA19_0<=42)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:774:3: a= atom ( ',' b= atom )*
                    {
                    pushFollow(FOLLOW_atom_in_arg_call1204);
                    a=atom();

                    state._fsp--;

                    retval.argumentTypeList.add((a!=null?a.type:null)); retval.stList.add((a!=null?a.st:null));
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:774:64: ( ',' b= atom )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==16) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:774:65: ',' b= atom
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_call1209); 
                    	    pushFollow(FOLLOW_atom_in_arg_call1213);
                    	    b=atom();

                    	    state._fsp--;

                    	    retval.argumentTypeList.add((b!=null?b.type:null)); retval.stList.add((b!=null?b.st:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:777:1: expression : first= and_expression ( '||' second= expression )? ;
    public final MyStrLangParser.expression_return expression() throws RecognitionException {
        MyStrLangParser.expression_return retval = new MyStrLangParser.expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.and_expression_return first = null;

        MyStrLangParser.expression_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:778:2: (first= and_expression ( '||' second= expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:778:4: first= and_expression ( '||' second= expression )?
            {
            pushFollow(FOLLOW_and_expression_in_expression1233);
            first=and_expression();

            state._fsp--;

            retval.st = (first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:778:44: ( '||' second= expression )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:778:45: '||' second= expression
                    {
                    match(input,30,FOLLOW_30_in_expression1238); 
                    pushFollow(FOLLOW_expression_in_expression1243);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:787:1: and_expression : first= not_expression ( '&&' second= and_expression )? ;
    public final MyStrLangParser.and_expression_return and_expression() throws RecognitionException {
        MyStrLangParser.and_expression_return retval = new MyStrLangParser.and_expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.not_expression_return first = null;

        MyStrLangParser.and_expression_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:788:2: (first= not_expression ( '&&' second= and_expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:788:4: first= not_expression ( '&&' second= and_expression )?
            {
            pushFollow(FOLLOW_not_expression_in_and_expression1266);
            first=not_expression();

            state._fsp--;

            retval.st = (first!=null?first.st:null);
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:788:44: ( '&&' second= and_expression )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:788:45: '&&' second= and_expression
                    {
                    match(input,31,FOLLOW_31_in_and_expression1271); 
                    pushFollow(FOLLOW_and_expression_in_and_expression1275);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:797:1: not_expression : ( '!' first= not_expression | second= comparison );
    public final MyStrLangParser.not_expression_return not_expression() throws RecognitionException {
        MyStrLangParser.not_expression_return retval = new MyStrLangParser.not_expression_return();
        retval.start = input.LT(1);

        MyStrLangParser.not_expression_return first = null;

        MyStrLangParser.comparison_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:798:2: ( '!' first= not_expression | second= comparison )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=ID && LA22_0<=CHAR)||(LA22_0>=27 && LA22_0<=29)||(LA22_0>=39 && LA22_0<=42)) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:798:4: '!' first= not_expression
                    {
                    match(input,32,FOLLOW_32_in_not_expression1295); 
                    pushFollow(FOLLOW_not_expression_in_not_expression1299);
                    first=not_expression();

                    state._fsp--;


                    				retval.st = templateLib.getInstanceOf("logical_not",
                      new STAttrMap().put("expression", (first!=null?first.st:null)).put("firstLabel", labelCounter).put("secondLabel", labelCounter+1));
                    				labelCounter = labelCounter+2;
                    			

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:803:4: second= comparison
                    {
                    pushFollow(FOLLOW_comparison_in_not_expression1311);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:806:1: comparison : (first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom | equal_op -> {$equal_op.st} | contain_op -> {$contain_op.st});
    public final MyStrLangParser.comparison_return comparison() throws RecognitionException {
        MyStrLangParser.comparison_return retval = new MyStrLangParser.comparison_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.atom_return first = null;

        MyStrLangParser.atom_return second = null;

        MyStrLangParser.equal_op_return equal_op56 = null;

        MyStrLangParser.contain_op_return contain_op57 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:807:2: (first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom | equal_op -> {$equal_op.st} | contain_op -> {$contain_op.st})
            int alt23=3;
            switch ( input.LA(1) ) {
            case ID:
            case INT:
            case STRING:
            case CHAR:
            case 27:
            case 28:
            case 29:
            case 41:
            case 42:
                {
                alt23=1;
                }
                break;
            case 39:
                {
                alt23=2;
                }
                break;
            case 40:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:807:4: first= atom op= ( '<' | '>' | '==' | '!=' | '>=' | '<=' ) second= atom
                    {
                    pushFollow(FOLLOW_atom_in_comparison1326);
                    first=atom();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=33 && input.LA(1)<=38) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_atom_in_comparison1346);
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
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:843:4: equal_op
                    {
                    pushFollow(FOLLOW_equal_op_in_comparison1354);
                    equal_op56=equal_op();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 843:14: -> {$equal_op.st}
                    {
                        retval.st = (equal_op56!=null?equal_op56.st:null);
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:844:4: contain_op
                    {
                    pushFollow(FOLLOW_contain_op_in_comparison1364);
                    contain_op57=contain_op();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 844:16: -> {$contain_op.st}
                    {
                        retval.st = (contain_op57!=null?contain_op57.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:847:1: equal_op : 'equals' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.equal_op_return equal_op() throws RecognitionException {
        MyStrLangParser.equal_op_return retval = new MyStrLangParser.equal_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:848:2: ( 'equals' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:848:4: 'equals' '(' first= f_el ',' second= f_el ')'
            {
            match(input,39,FOLLOW_39_in_equal_op1381); 
            match(input,14,FOLLOW_14_in_equal_op1383); 
            pushFollow(FOLLOW_f_el_in_equal_op1387);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_equal_op1389); 
            pushFollow(FOLLOW_f_el_in_equal_op1393);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_equal_op1395); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:854:1: contain_op : 'contains' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.contain_op_return contain_op() throws RecognitionException {
        MyStrLangParser.contain_op_return retval = new MyStrLangParser.contain_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:855:2: ( 'contains' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:855:4: 'contains' '(' first= f_el ',' second= f_el ')'
            {
            match(input,40,FOLLOW_40_in_contain_op1410); 
            match(input,14,FOLLOW_14_in_contain_op1412); 
            pushFollow(FOLLOW_f_el_in_contain_op1416);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_contain_op1418); 
            pushFollow(FOLLOW_f_el_in_contain_op1422);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_contain_op1424); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:861:1: indexOf_stmt : 'indexOf' '(' first= f_el ',' second= f_el ')' ;
    public final MyStrLangParser.indexOf_stmt_return indexOf_stmt() throws RecognitionException {
        MyStrLangParser.indexOf_stmt_return retval = new MyStrLangParser.indexOf_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return first = null;

        MyStrLangParser.f_el_return second = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:862:2: ( 'indexOf' '(' first= f_el ',' second= f_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:862:4: 'indexOf' '(' first= f_el ',' second= f_el ')'
            {
            match(input,41,FOLLOW_41_in_indexOf_stmt1439); 
            match(input,14,FOLLOW_14_in_indexOf_stmt1441); 
            pushFollow(FOLLOW_f_el_in_indexOf_stmt1445);
            first=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_indexOf_stmt1447); 
            pushFollow(FOLLOW_f_el_in_indexOf_stmt1451);
            second=f_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_indexOf_stmt1452); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:868:1: replace_op : 'replace' '(' f_el ',' first= char_param ',' second= char_param ')' ;
    public final MyStrLangParser.replace_op_return replace_op() throws RecognitionException {
        MyStrLangParser.replace_op_return retval = new MyStrLangParser.replace_op_return();
        retval.start = input.LT(1);

        MyStrLangParser.char_param_return first = null;

        MyStrLangParser.char_param_return second = null;

        MyStrLangParser.f_el_return f_el58 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:869:2: ( 'replace' '(' f_el ',' first= char_param ',' second= char_param ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:869:4: 'replace' '(' f_el ',' first= char_param ',' second= char_param ')'
            {
            match(input,42,FOLLOW_42_in_replace_op1467); 
            match(input,14,FOLLOW_14_in_replace_op1469); 
            pushFollow(FOLLOW_f_el_in_replace_op1471);
            f_el58=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_op1473); 
            pushFollow(FOLLOW_char_param_in_replace_op1477);
            first=char_param();

            state._fsp--;

            match(input,16,FOLLOW_16_in_replace_op1479); 
            pushFollow(FOLLOW_char_param_in_replace_op1483);
            second=char_param();

            state._fsp--;

            match(input,15,FOLLOW_15_in_replace_op1485); 

            		retval.st = templateLib.getInstanceOf("replace_operation",
              new STAttrMap().put("fValue", (f_el58!=null?f_el58.st:null)).put("sValue", (first!=null?first.st:null)).put("thValue", (second!=null?second.st:null)));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:875:1: char_param : ( ID | char_c -> {$char_c.st});
    public final MyStrLangParser.char_param_return char_param() throws RecognitionException {
        MyStrLangParser.char_param_return retval = new MyStrLangParser.char_param_return();
        retval.start = input.LT(1);

        Token ID59=null;
        MyStrLangParser.char_c_return char_c60 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:876:2: ( ID | char_c -> {$char_c.st})
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID) ) {
                alt24=1;
            }
            else if ( (LA24_0==CHAR) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:876:4: ID
                    {
                    ID59=(Token)match(input,ID,FOLLOW_ID_in_char_param1500); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID59!=null?ID59.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID59!=null?ID59.getText():null));
                    			String type = v_type.getType();
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:896:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_char_param1508);
                    char_c60=char_c();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 896:12: -> {$char_c.st}
                    {
                        retval.st = (char_c60!=null?char_c60.st:null);
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

    public static class type_return extends ParserRuleReturnScope {
        public StringTemplate returnType;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:899:1: type returns [StringTemplate returnType] : ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char());
    public final MyStrLangParser.type_return type() throws RecognitionException {
        MyStrLangParser.type_return retval = new MyStrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:900:2: ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char())
            int alt25=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt25=1;
                }
                break;
            case 44:
                {
                alt25=2;
                }
                break;
            case 45:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:900:4: 'int'
                    {
                    match(input,43,FOLLOW_43_in_type1528); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 900:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:901:5: 'string'
                    {
                    match(input,44,FOLLOW_44_in_type1542); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 901:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:902:5: 'char'
                    {
                    match(input,45,FOLLOW_45_in_type1555); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 902:46: -> type_char()
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:905:1: type_func returns [StringTemplate returnType] : ( | 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char() | 'void' -> type_void());
    public final MyStrLangParser.type_func_return type_func() throws RecognitionException {
        MyStrLangParser.type_func_return retval = new MyStrLangParser.type_func_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:906:2: ( | 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char() | 'void' -> type_void())
            int alt26=5;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt26=1;
                }
                break;
            case 43:
                {
                alt26=2;
                }
                break;
            case 44:
                {
                alt26=3;
                }
                break;
            case 45:
                {
                alt26=4;
                }
                break;
            case 46:
                {
                alt26=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:907:2: 
                    {
                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:907:4: 'int'
                    {
                    match(input,43,FOLLOW_43_in_type_func1581); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 907:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:908:5: 'string'
                    {
                    match(input,44,FOLLOW_44_in_type_func1595); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 908:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:909:5: 'char'
                    {
                    match(input,45,FOLLOW_45_in_type_func1608); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 909:46: -> type_char()
                    {
                        retval.st = templateLib.getInstanceOf("type_char");
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:910:4: 'void'
                    {
                    match(input,46,FOLLOW_46_in_type_func1620); 
                    retval.returnType = templateLib.getInstanceOf("return_void");


                    // TEMPLATE REWRITE
                    // 910:43: -> type_void()
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

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA7_eotS =
        "\12\uffff";
    static final String DFA7_eofS =
        "\12\uffff";
    static final String DFA7_minS =
        "\1\4\1\16\10\uffff";
    static final String DFA7_maxS =
        "\1\55\1\21\10\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\1\1\10";
    static final String DFA7_specialS =
        "\12\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\17\uffff\1\3\1\4\1\5\1\uffff\1\6\1\7\21\uffff\3\2",
            "\1\11\2\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "245:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st});";
        }
    }
    static final String DFA10_eotS =
        "\14\uffff";
    static final String DFA10_eofS =
        "\14\uffff";
    static final String DFA10_minS =
        "\1\4\1\15\12\uffff";
    static final String DFA10_maxS =
        "\1\52\1\46\12\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\6\1\7\1\10\1\11\1\12\1\1\1\5";
    static final String DFA10_specialS =
        "\14\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\1\2\1\3\1\4\23\uffff\1\5\1\6\1\7\13\uffff\1\10\1\11",
            "\1\12\1\13\2\12\1\uffff\2\12\12\uffff\2\12\1\uffff\6\12",
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
            return "393:1: atom returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st} | indexOf_stmt -> {$indexOf_stmt.st} | replace_op -> {$replace_op.st});";
        }
    }
 

    public static final BitSet FOLLOW_global_variables_in_program61 = new BitSet(new long[]{0x0000780000002410L});
    public static final BitSet FOLLOW_functions_in_program65 = new BitSet(new long[]{0x0000780000000410L});
    public static final BitSet FOLLOW_mainBlock_in_program73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_mainBlock117 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_mainBlock119 = new BitSet(new long[]{0x0000380007700010L});
    public static final BitSet FOLLOW_block_in_mainBlock121 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_mainBlock123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_declaration_in_global_variables149 = new BitSet(new long[]{0x0000380000002000L});
    public static final BitSet FOLLOW_13_in_global_variables155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_declaration167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_declaration169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_func_in_functions208 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functions215 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_functions220 = new BitSet(new long[]{0x0000380000008000L});
    public static final BitSet FOLLOW_arg_list_in_functions222 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_functions224 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_functions232 = new BitSet(new long[]{0x0000380007700010L});
    public static final BitSet FOLLOW_block_in_functions237 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_functions240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_arg_list294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list298 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_list308 = new BitSet(new long[]{0x0000380000000000L});
    public static final BitSet FOLLOW_type_in_arg_list312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list316 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_statements_in_block354 = new BitSet(new long[]{0x0000380007700010L});
    public static final BitSet FOLLOW_return_stmt_in_block361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_stmt_in_statements379 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_stmt_in_statements390 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_stmt_in_statements401 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_strm_in_statements412 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_statements423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_stmt_in_statements432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_stmt_in_statements441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_stmt_in_statements451 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assign_stmt469 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_assign_stmt471 = new BitSet(new long[]{0x00003E003B7000F0L});
    public static final BitSet FOLLOW_expr_in_assign_stmt473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_expr497 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_expr513 = new BitSet(new long[]{0x00003E003B7000F0L});
    public static final BitSet FOLLOW_19_in_expr517 = new BitSet(new long[]{0x00003E003B7000F0L});
    public static final BitSet FOLLOW_atom_in_expr522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_stmt546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_decl_stmt548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_write_stmt563 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_write_stmt565 = new BitSet(new long[]{0x00003E003B7000F0L});
    public static final BitSet FOLLOW_atom_in_write_stmt567 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_write_stmt569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_atom632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_atom647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_stmt_in_atom659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elem_stmt_in_atom672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_string_stmt_in_atom685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indexOf_stmt_in_atom697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_op_in_atom710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_char_c733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_read_strm759 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_read_strm761 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_read_strm763 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_read_strm765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_if_stmt781 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_stmt783 = new BitSet(new long[]{0x00003F813B7000F0L});
    public static final BitSet FOLLOW_expression_in_if_stmt785 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_if_stmt787 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt789 = new BitSet(new long[]{0x0000380007700010L});
    public static final BitSet FOLLOW_block_in_if_stmt793 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt795 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_if_stmt798 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt800 = new BitSet(new long[]{0x0000380007700010L});
    public static final BitSet FOLLOW_block_in_if_stmt804 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_for_stmt823 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_for_stmt825 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt829 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt832 = new BitSet(new long[]{0x00003F813B7000F0L});
    public static final BitSet FOLLOW_expression_in_for_stmt836 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt838 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt842 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_for_stmt844 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_for_stmt846 = new BitSet(new long[]{0x0000380007700010L});
    public static final BitSet FOLLOW_block_in_for_stmt850 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_for_stmt852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_while_stmt867 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_stmt869 = new BitSet(new long[]{0x00003F813B7000F0L});
    public static final BitSet FOLLOW_expression_in_while_stmt873 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_while_stmt875 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_while_stmt877 = new BitSet(new long[]{0x0000380007700010L});
    public static final BitSet FOLLOW_block_in_while_stmt881 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_while_stmt883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_return_stmt905 = new BitSet(new long[]{0x00003E003B7000F0L});
    public static final BitSet FOLLOW_atom_in_return_stmt907 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_return_stmt909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_length_stmt934 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_length_stmt936 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_param_in_length_stmt938 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_length_stmt940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_param965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_elem_stmt990 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_elem_stmt992 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_elem_stmt993 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_elem_stmt995 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_elem_stmt997 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_elem_stmt999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_f_el1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_f_el1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_s_el1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_s_el1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_to_string_stmt1074 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_to_string_stmt1076 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_param_str_in_to_string_stmt1078 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_to_string_stmt1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param_str1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_param_str1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_param_str1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_call_func_stmt1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func1171 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_call_func1174 = new BitSet(new long[]{0x00003E003B7080F0L});
    public static final BitSet FOLLOW_arg_call_in_call_func1176 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_call_func1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_arg_call1204 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_call1209 = new BitSet(new long[]{0x00003E003B7000F0L});
    public static final BitSet FOLLOW_atom_in_arg_call1213 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_and_expression_in_expression1233 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_expression1238 = new BitSet(new long[]{0x00003F813B7000F0L});
    public static final BitSet FOLLOW_expression_in_expression1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_expression_in_and_expression1266 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_and_expression1271 = new BitSet(new long[]{0x00003F813B7000F0L});
    public static final BitSet FOLLOW_and_expression_in_and_expression1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_not_expression1295 = new BitSet(new long[]{0x00003F813B7000F0L});
    public static final BitSet FOLLOW_not_expression_in_not_expression1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_not_expression1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_comparison1326 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_set_in_comparison1330 = new BitSet(new long[]{0x00003E003B7000F0L});
    public static final BitSet FOLLOW_atom_in_comparison1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equal_op_in_comparison1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_contain_op_in_comparison1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_equal_op1381 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_equal_op1383 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_equal_op1387 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_equal_op1389 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_equal_op1393 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_equal_op1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_contain_op1410 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_contain_op1412 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_contain_op1416 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_contain_op1418 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_contain_op1422 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_contain_op1424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_indexOf_stmt1439 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_indexOf_stmt1441 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_indexOf_stmt1445 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_indexOf_stmt1447 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_indexOf_stmt1451 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_indexOf_stmt1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_replace_op1467 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_replace_op1469 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_replace_op1471 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_op1473 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_char_param_in_replace_op1477 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_replace_op1479 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_char_param_in_replace_op1483 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_replace_op1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_char_param1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_char_param1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_type1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_type1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_type1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_type_func1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_type_func1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_type_func1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_type_func1620 = new BitSet(new long[]{0x0000000000000002L});

}