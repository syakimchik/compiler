// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g 2012-06-14 20:13:05

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "STRING", "CHAR", "COMMENT", "WS", "'main'", "'{'", "'}'", "';'", "'('", "')'", "','", "'='", "'+'", "'-'", "'write'", "'read'", "'if'", "'else'", "'for'", "'while'", "'return'", "'length'", "'elem'", "'ToString'", "'|'", "'&'", "'!'", "'<'", "'>'", "'=='", "'!='", "'int'", "'string'", "'char'", "'void'"
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
    		private String _funcName = "";
    		private String _funcType = "";
    		
    		protected NamesTable names = new NamesTable();
    		protected ArrayList<String> errors = new ArrayList<String>();
    		protected ArrayList<String> tmpVarNamesList = new ArrayList<String>();
    		
    		public static StringTemplateGroup templateGroup;
    		public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";	//testing line
    		//public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";	//line for jar file
    		
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:96:1: program : ( global_variables )* ( functions )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName);
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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:107:2: ( ( global_variables )* ( functions )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:107:4: ( global_variables )* ( functions )* mainBlock EOF
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:107:4: ( global_variables )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 37:
                    {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=37 && LA1_6<=39)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 38:
                    {
                    int LA1_3 = input.LA(2);

                    if ( (LA1_3==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=37 && LA1_6<=39)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 39:
                    {
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=37 && LA1_6<=39)) ) {
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
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:107:4: global_variables
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

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:107:22: ( functions )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||(LA2_0>=37 && LA2_0<=40)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:107:23: functions
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
            // 108:3: -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:111:1: mainBlock : 'main' '{' block '}' -> mainBlock(block=$block.stList);
    public final MyStrLangParser.mainBlock_return mainBlock() throws RecognitionException {
        MyStrLangParser.mainBlock_return retval = new MyStrLangParser.mainBlock_return();
        retval.start = input.LT(1);

        MyStrLangParser.block_return block3 = null;



        	counter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:115:2: ( 'main' '{' block '}' -> mainBlock(block=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:115:4: 'main' '{' block '}'
            {
            match(input,10,FOLLOW_10_in_mainBlock117); 
            match(input,11,FOLLOW_11_in_mainBlock119); 
            pushFollow(FOLLOW_block_in_mainBlock121);
            block3=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_mainBlock123); 


            // TEMPLATE REWRITE
            // 116:3: -> mainBlock(block=$block.stList)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:119:1: global_variables : ( global_declaration )* ';' ;
    public final MyStrLangParser.global_variables_return global_variables() throws RecognitionException {
        MyStrLangParser.global_variables_return retval = new MyStrLangParser.global_variables_return();
        retval.start = input.LT(1);

        MyStrLangParser.global_declaration_return global_declaration4 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:120:2: ( ( global_declaration )* ';' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:120:4: ( global_declaration )* ';'
            {
             ((program_scope)program_stack.peek()).curBlock = "global";
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:120:38: ( global_declaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=37 && LA3_0<=39)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:120:39: global_declaration
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:123:1: global_declaration : type ID -> global_declaration(ident=$ID.texttype=$type.st);
    public final MyStrLangParser.global_declaration_return global_declaration() throws RecognitionException {
        MyStrLangParser.global_declaration_return retval = new MyStrLangParser.global_declaration_return();
        retval.start = input.LT(1);

        Token ID5=null;
        MyStrLangParser.type_return type6 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:124:2: ( type ID -> global_declaration(ident=$ID.texttype=$type.st))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:124:4: type ID
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
            // 140:2: -> global_declaration(ident=$ID.texttype=$type.st)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:143:1: functions : type_func ID '(' arg_list ')' '{' block '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList);
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

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:158:2: ( type_func ID '(' arg_list ')' '{' block '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:158:4: type_func ID '(' arg_list ')' '{' block '}'
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
            // 175:2: -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$type_func.returnTypeblock=$block.stList)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:178:1: arg_list returns [List<StringTemplate> stList] : (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? ;
    public final MyStrLangParser.arg_list_return arg_list() throws RecognitionException {
        MyStrLangParser.arg_list_return retval = new MyStrLangParser.arg_list_return();
        retval.start = input.LT(1);

        Token firstId=null;
        Token secondId=null;
        MyStrLangParser.type_return firstType = null;

        MyStrLangParser.type_return secondType = null;



        	retval.stList = new ArrayList<StringTemplate>();
        	counter = 0;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:183:2: ( (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:183:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:183:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=37 && LA5_0<=39)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:184:3: firstType= type firstId= ID ( ',' secondType= type secondId= ID )*
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
                    		
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:201:4: ( ',' secondType= type secondId= ID )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:201:5: ',' secondType= type secondId= ID
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:222:1: block returns [List<StringTemplate> stList] : ( statements )* ( return_stmt ) ;
    public final MyStrLangParser.block_return block() throws RecognitionException {
        MyStrLangParser.block_return retval = new MyStrLangParser.block_return();
        retval.start = input.LT(1);

        MyStrLangParser.statements_return statements11 = null;

        MyStrLangParser.return_stmt_return return_stmt12 = null;



        	retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:226:2: ( ( statements )* ( return_stmt ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:226:4: ( statements )* ( return_stmt )
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:226:4: ( statements )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ID||(LA6_0>=20 && LA6_0<=22)||(LA6_0>=24 && LA6_0<=25)||(LA6_0>=37 && LA6_0<=39)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:226:5: statements
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

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:226:49: ( return_stmt )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:226:50: return_stmt
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:241:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st});
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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:242:2: ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st})
            int alt7=8;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:242:4: assign_stmt ';'
                    {
                    pushFollow(FOLLOW_assign_stmt_in_statements379);
                    assign_stmt13=assign_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements381); 


                    // TEMPLATE REWRITE
                    // 242:20: -> {$assign_stmt.st}
                    {
                        retval.st = (assign_stmt13!=null?assign_stmt13.st:null);
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:243:4: decl_stmt ';'
                    {
                    pushFollow(FOLLOW_decl_stmt_in_statements390);
                    decl_stmt14=decl_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements392); 


                    // TEMPLATE REWRITE
                    // 243:18: -> {$decl_stmt.st}
                    {
                        retval.st = (decl_stmt14!=null?decl_stmt14.st:null);
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:244:4: write_stmt ';'
                    {
                    pushFollow(FOLLOW_write_stmt_in_statements401);
                    write_stmt15=write_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements403); 


                    // TEMPLATE REWRITE
                    // 244:19: -> {$write_stmt.st}
                    {
                        retval.st = (write_stmt15!=null?write_stmt15.st:null);
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:245:4: read_strm ';'
                    {
                    pushFollow(FOLLOW_read_strm_in_statements412);
                    read_strm16=read_strm();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements414); 


                    // TEMPLATE REWRITE
                    // 245:18: -> {$read_strm.st}
                    {
                        retval.st = (read_strm16!=null?read_strm16.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:246:4: if_stmt
                    {
                    pushFollow(FOLLOW_if_stmt_in_statements423);
                    if_stmt17=if_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 246:12: -> {$if_stmt.st}
                    {
                        retval.st = (if_stmt17!=null?if_stmt17.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:247:4: for_stmt
                    {
                    pushFollow(FOLLOW_for_stmt_in_statements432);
                    for_stmt18=for_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 247:13: -> {$for_stmt.st}
                    {
                        retval.st = (for_stmt18!=null?for_stmt18.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:248:4: while_stmt
                    {
                    pushFollow(FOLLOW_while_stmt_in_statements441);
                    while_stmt19=while_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 248:15: -> {$while_stmt.st}
                    {
                        retval.st = (while_stmt19!=null?while_stmt19.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:249:5: call_func_stmt ';'
                    {
                    pushFollow(FOLLOW_call_func_stmt_in_statements451);
                    call_func_stmt20=call_func_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements453); 


                    // TEMPLATE REWRITE
                    // 249:24: -> {$call_func_stmt.st}
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:252:1: assign_stmt : ID '=' expr ;
    public final MyStrLangParser.assign_stmt_return assign_stmt() throws RecognitionException {
        MyStrLangParser.assign_stmt_return retval = new MyStrLangParser.assign_stmt_return();
        retval.start = input.LT(1);

        Token ID21=null;
        MyStrLangParser.expr_return expr22 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:253:2: ( ID '=' expr )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:253:4: ID '=' expr
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:295:1: expr returns [String type] : firstAssign= atom ( (op= '+' | op= '-' ) secondAssign= atom )? ;
    public final MyStrLangParser.expr_return expr() throws RecognitionException {
        MyStrLangParser.expr_return retval = new MyStrLangParser.expr_return();
        retval.start = input.LT(1);

        Token op=null;
        MyStrLangParser.atom_return firstAssign = null;

        MyStrLangParser.atom_return secondAssign = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:296:2: (firstAssign= atom ( (op= '+' | op= '-' ) secondAssign= atom )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:297:3: firstAssign= atom ( (op= '+' | op= '-' ) secondAssign= atom )?
            {
            pushFollow(FOLLOW_atom_in_expr497);
            firstAssign=atom();

            state._fsp--;


            			retval.type = (firstAssign!=null?firstAssign.type:null);
            			retval.st = (firstAssign!=null?firstAssign.st:null);
            		
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:302:3: ( (op= '+' | op= '-' ) secondAssign= atom )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=18 && LA9_0<=19)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:303:4: (op= '+' | op= '-' ) secondAssign= atom
                    {
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:303:4: (op= '+' | op= '-' )
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
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:303:5: op= '+'
                            {
                            op=(Token)match(input,18,FOLLOW_18_in_expr513); 

                            }
                            break;
                        case 2 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:303:12: op= '-'
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:338:1: decl_stmt : type ID ;
    public final MyStrLangParser.decl_stmt_return decl_stmt() throws RecognitionException {
        MyStrLangParser.decl_stmt_return retval = new MyStrLangParser.decl_stmt_return();
        retval.start = input.LT(1);

        Token ID23=null;
        MyStrLangParser.type_return type24 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:339:2: ( type ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:339:4: type ID
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:371:1: write_stmt : 'write' '(' atom ')' ;
    public final MyStrLangParser.write_stmt_return write_stmt() throws RecognitionException {
        MyStrLangParser.write_stmt_return retval = new MyStrLangParser.write_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return atom25 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:372:2: ( 'write' '(' atom ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:372:4: 'write' '(' atom ')'
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:389:1: atom returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st});
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


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:390:2: ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st})
            int alt10=8;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:390:4: ID
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:435:4: INT
                    {
                    INT27=(Token)match(input,INT,FOLLOW_INT_in_atom595); 
                    retval.text = (INT27!=null?INT27.getText():null); retval.type = "int";


                    // TEMPLATE REWRITE
                    // 435:47: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT27!=null?INT27.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:436:4: STRING
                    {
                    STRING28=(Token)match(input,STRING,FOLLOW_STRING_in_atom614); 
                    retval.text = (STRING28!=null?STRING28.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 436:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING28!=null?STRING28.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:437:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_atom632);
                    char_c29=char_c();

                    state._fsp--;

                    retval.type = "char";


                    // TEMPLATE REWRITE
                    // 437:33: -> {$char_c.st}
                    {
                        retval.st = (char_c29!=null?char_c29.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:438:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_atom647);
                    call_func30=call_func();

                    state._fsp--;

                    retval.type =(call_func30!=null?call_func30.type:null);


                    // TEMPLATE REWRITE
                    // 438:40: -> {$call_func.st}
                    {
                        retval.st = (call_func30!=null?call_func30.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:439:4: length_stmt
                    {
                    pushFollow(FOLLOW_length_stmt_in_atom659);
                    length_stmt31=length_stmt();

                    state._fsp--;

                    retval.type ="int";


                    // TEMPLATE REWRITE
                    // 439:33: -> {$length_stmt.st}
                    {
                        retval.st = (length_stmt31!=null?length_stmt31.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:440:4: elem_stmt
                    {
                    pushFollow(FOLLOW_elem_stmt_in_atom672);
                    elem_stmt32=elem_stmt();

                    state._fsp--;

                    retval.type ="char";


                    // TEMPLATE REWRITE
                    // 440:32: -> {$elem_stmt.st}
                    {
                        retval.st = (elem_stmt32!=null?elem_stmt32.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:441:4: to_string_stmt
                    {
                    pushFollow(FOLLOW_to_string_stmt_in_atom685);
                    to_string_stmt33=to_string_stmt();

                    state._fsp--;

                    retval.type ="string";


                    // TEMPLATE REWRITE
                    // 441:38: -> {$to_string_stmt.st}
                    {
                        retval.st = (to_string_stmt33!=null?to_string_stmt33.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:444:1: char_c returns [int numb] : CHAR -> const_char(cod=$numb);
    public final MyStrLangParser.char_c_return char_c() throws RecognitionException {
        MyStrLangParser.char_c_return retval = new MyStrLangParser.char_c_return();
        retval.start = input.LT(1);

        Token CHAR34=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:445:2: ( CHAR -> const_char(cod=$numb))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:445:4: CHAR
            {
            CHAR34=(Token)match(input,CHAR,FOLLOW_CHAR_in_char_c707); 
            	
            			String str = (CHAR34!=null?CHAR34.getText():null);
            			char el = str.charAt(1);
            			try{
            				retval.numb = Character.toString(el).getBytes("cp1251")[0];
            			}
            			catch(UnsupportedEncodingException e)
            			{
            				e.printStackTrace();
            			}
            	


            // TEMPLATE REWRITE
            // 457:3: -> const_char(cod=$numb)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:460:1: read_strm : 'read' '(' ID ')' ;
    public final MyStrLangParser.read_strm_return read_strm() throws RecognitionException {
        MyStrLangParser.read_strm_return retval = new MyStrLangParser.read_strm_return();
        retval.start = input.LT(1);

        Token ID35=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:461:2: ( 'read' '(' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:461:4: 'read' '(' ID ')'
            {
            match(input,21,FOLLOW_21_in_read_strm733); 
            match(input,14,FOLLOW_14_in_read_strm735); 
            ID35=(Token)match(input,ID,FOLLOW_ID_in_read_strm737); 
            match(input,15,FOLLOW_15_in_read_strm739); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID35!=null?ID35.getText():null)))
            			errors.add("line "+(ID35!=null?ID35.getLine():0)+": unknown variable "+(ID35!=null?ID35.getText():null));
            		else{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID35!=null?ID35.getText():null));
            			String varType = var_type.getType();
            			if(TypesChecker.isInteger(varType))
            			{
            				if(names.isGlobal((ID35!=null?ID35.getText():null))){
            					retval.st = templateLib.getInstanceOf("read_field_int",
              new STAttrMap().put("programName", programName).put("fieldName", (ID35!=null?ID35.getText():null)));
            				} else
            					retval.st = templateLib.getInstanceOf("read_var_int",
              new STAttrMap().put("counter", var_type.getNumber()));
            			}
            			if(TypesChecker.isString(varType))
            			{
            				if(names.isGlobal((ID35!=null?ID35.getText():null))){
            					retval.st = templateLib.getInstanceOf("read_field_string",
              new STAttrMap().put("programName", programName).put("fieldName", (ID35!=null?ID35.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:486:1: if_stmt : 'if' '(' expression ')' '{' block '}' ( 'else' '{' block '}' )? ;
    public final MyStrLangParser.if_stmt_return if_stmt() throws RecognitionException {
        MyStrLangParser.if_stmt_return retval = new MyStrLangParser.if_stmt_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:486:9: ( 'if' '(' expression ')' '{' block '}' ( 'else' '{' block '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:486:11: 'if' '(' expression ')' '{' block '}' ( 'else' '{' block '}' )?
            {
            match(input,22,FOLLOW_22_in_if_stmt753); 
            match(input,14,FOLLOW_14_in_if_stmt755); 
            pushFollow(FOLLOW_expression_in_if_stmt757);
            expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_if_stmt759); 
            match(input,11,FOLLOW_11_in_if_stmt761); 
            pushFollow(FOLLOW_block_in_if_stmt763);
            block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_if_stmt765); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:486:49: ( 'else' '{' block '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:486:50: 'else' '{' block '}'
                    {
                    match(input,23,FOLLOW_23_in_if_stmt768); 
                    match(input,11,FOLLOW_11_in_if_stmt770); 
                    pushFollow(FOLLOW_block_in_if_stmt772);
                    block();

                    state._fsp--;

                    match(input,12,FOLLOW_12_in_if_stmt774); 

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
    // $ANTLR end "if_stmt"

    public static class for_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "for_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:489:1: for_stmt : 'for' '(' ( assign_stmt )? ';' expression ';' assign_stmt ')' '{' block '}' ;
    public final MyStrLangParser.for_stmt_return for_stmt() throws RecognitionException {
        MyStrLangParser.for_stmt_return retval = new MyStrLangParser.for_stmt_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:489:9: ( 'for' '(' ( assign_stmt )? ';' expression ';' assign_stmt ')' '{' block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:489:11: 'for' '(' ( assign_stmt )? ';' expression ';' assign_stmt ')' '{' block '}'
            {
            match(input,24,FOLLOW_24_in_for_stmt786); 
            match(input,14,FOLLOW_14_in_for_stmt788); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:489:21: ( assign_stmt )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:489:21: assign_stmt
                    {
                    pushFollow(FOLLOW_assign_stmt_in_for_stmt790);
                    assign_stmt();

                    state._fsp--;


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_for_stmt793); 
            pushFollow(FOLLOW_expression_in_for_stmt795);
            expression();

            state._fsp--;

            match(input,13,FOLLOW_13_in_for_stmt797); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt799);
            assign_stmt();

            state._fsp--;

            match(input,15,FOLLOW_15_in_for_stmt801); 
            match(input,11,FOLLOW_11_in_for_stmt803); 
            pushFollow(FOLLOW_block_in_for_stmt805);
            block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_for_stmt807); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:492:1: while_stmt : 'while' '(' expression ')' '{' block '}' ;
    public final MyStrLangParser.while_stmt_return while_stmt() throws RecognitionException {
        MyStrLangParser.while_stmt_return retval = new MyStrLangParser.while_stmt_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:493:2: ( 'while' '(' expression ')' '{' block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:493:4: 'while' '(' expression ')' '{' block '}'
            {
            match(input,25,FOLLOW_25_in_while_stmt819); 
            match(input,14,FOLLOW_14_in_while_stmt821); 
            pushFollow(FOLLOW_expression_in_while_stmt823);
            expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_while_stmt825); 
            match(input,11,FOLLOW_11_in_while_stmt827); 
            pushFollow(FOLLOW_block_in_while_stmt829);
            block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_while_stmt831); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:496:1: return_stmt returns [String value, int line] : (a= 'return' atom ';' )? -> {$atom.st};
    public final MyStrLangParser.return_stmt_return return_stmt() throws RecognitionException {
        MyStrLangParser.return_stmt_return retval = new MyStrLangParser.return_stmt_return();
        retval.start = input.LT(1);

        Token a=null;
        MyStrLangParser.atom_return atom36 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:497:2: ( (a= 'return' atom ';' )? -> {$atom.st})
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:498:2: (a= 'return' atom ';' )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:498:2: (a= 'return' atom ';' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:498:3: a= 'return' atom ';'
                    {
                    a=(Token)match(input,26,FOLLOW_26_in_return_stmt850); 
                    pushFollow(FOLLOW_atom_in_return_stmt852);
                    atom36=atom();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_return_stmt854); 
                    	
                    		if(((program_scope)program_stack.peek()).curBlock=="main")
                    			errors.add("line "+(a!=null?a.getLine():0)+": function main may not contain keyword return");
                    		retval.value = (atom36!=null?atom36.text:null);
                    		retval.line = (a!=null?a.getLine():0);
                    		
                    		String name = ((functions_scope)functions_stack.peek()).funcName;
                    		NamesTable.FunctionName func = names.getFunction(name);
                    		String type = func.getReturnType();
                    		
                    		if(type.equals("void")){
                    			errors.add("line "+(a!=null?a.getLine():0)+": type of void may not contain keyword return");
                    		}
                    		
                    		String rType = (atom36!=null?atom36.type:null);
                    		if(!TypesChecker.checkTypes(type,rType)){
                    			errors.add("line "+(a!=null?a.getLine():0)+": Type mismatch: cannot convert from "+type+" to "+rType);
                    		}
                    	

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 519:2: -> {$atom.st}
            {
                retval.st = (atom36!=null?atom36.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:522:1: length_stmt : 'length' '(' param ')' ;
    public final MyStrLangParser.length_stmt_return length_stmt() throws RecognitionException {
        MyStrLangParser.length_stmt_return retval = new MyStrLangParser.length_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.param_return param37 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:523:2: ( 'length' '(' param ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:523:4: 'length' '(' param ')'
            {
            match(input,27,FOLLOW_27_in_length_stmt879); 
            match(input,14,FOLLOW_14_in_length_stmt881); 
            pushFollow(FOLLOW_param_in_length_stmt883);
            param37=param();

            state._fsp--;

            match(input,15,FOLLOW_15_in_length_stmt885); 

            		retval.st = templateLib.getInstanceOf("length_string",
              new STAttrMap().put("string", (param37!=null?param37.st:null)));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:529:1: param returns [String text, String type] : ( ID | STRING -> const_string(value=$STRING.text));
    public final MyStrLangParser.param_return param() throws RecognitionException {
        MyStrLangParser.param_return retval = new MyStrLangParser.param_return();
        retval.start = input.LT(1);

        Token ID38=null;
        Token STRING39=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:530:2: ( ID | STRING -> const_string(value=$STRING.text))
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:530:4: ID
                    {
                    ID38=(Token)match(input,ID,FOLLOW_ID_in_param903); 

                    		retval.text = (ID38!=null?ID38.getText():null);
                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID38!=null?ID38.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID38!=null?ID38.getText():null));
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
                    			errors.add("line "+(ID38!=null?ID38.getLine():0)+": unknown variable "+(ID38!=null?ID38.getText():null));
                    		}
                    		

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:564:4: STRING
                    {
                    STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_param910); 
                    retval.text = (STRING39!=null?STRING39.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 564:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING39!=null?STRING39.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:567:1: elem_stmt : 'elem' '(' f_el ',' s_el ')' ;
    public final MyStrLangParser.elem_stmt_return elem_stmt() throws RecognitionException {
        MyStrLangParser.elem_stmt_return retval = new MyStrLangParser.elem_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.f_el_return f_el40 = null;

        MyStrLangParser.s_el_return s_el41 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:568:2: ( 'elem' '(' f_el ',' s_el ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:568:4: 'elem' '(' f_el ',' s_el ')'
            {
            match(input,28,FOLLOW_28_in_elem_stmt935); 
            match(input,14,FOLLOW_14_in_elem_stmt937); 
            pushFollow(FOLLOW_f_el_in_elem_stmt938);
            f_el40=f_el();

            state._fsp--;

            match(input,16,FOLLOW_16_in_elem_stmt940); 
            pushFollow(FOLLOW_s_el_in_elem_stmt942);
            s_el41=s_el();

            state._fsp--;

            match(input,15,FOLLOW_15_in_elem_stmt944); 

            		retval.st = templateLib.getInstanceOf("elem_in_string",
              new STAttrMap().put("fValue", (f_el40!=null?f_el40.st:null)).put("sValue", (s_el41!=null?s_el41.st:null)));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:574:1: f_el : ( ID | STRING -> const_string(value=$STRING.text));
    public final MyStrLangParser.f_el_return f_el() throws RecognitionException {
        MyStrLangParser.f_el_return retval = new MyStrLangParser.f_el_return();
        retval.start = input.LT(1);

        Token ID42=null;
        Token STRING43=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:575:2: ( ID | STRING -> const_string(value=$STRING.text))
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:575:4: ID
                    {
                    ID42=(Token)match(input,ID,FOLLOW_ID_in_f_el959); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID42!=null?ID42.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID42!=null?ID42.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isString(type))
                    			{
                    				if(names.isGlobal((ID42!=null?ID42.getText():null)))
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
                    			errors.add("line "+(ID42!=null?ID42.getLine():0)+": unknown variable "+(ID42!=null?ID42.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:595:4: STRING
                    {
                    STRING43=(Token)match(input,STRING,FOLLOW_STRING_in_f_el967); 


                    // TEMPLATE REWRITE
                    // 595:12: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING43!=null?STRING43.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:598:1: s_el : ( ID | INT -> const_int(value=$INT.text));
    public final MyStrLangParser.s_el_return s_el() throws RecognitionException {
        MyStrLangParser.s_el_return retval = new MyStrLangParser.s_el_return();
        retval.start = input.LT(1);

        Token ID44=null;
        Token INT45=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:599:2: ( ID | INT -> const_int(value=$INT.text))
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:599:4: ID
                    {
                    ID44=(Token)match(input,ID,FOLLOW_ID_in_s_el989); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID44!=null?ID44.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID44!=null?ID44.getText():null));
                    			String type = v_type.getType();
                    			if(TypesChecker.isInteger(type))
                    			{
                    				if(names.isGlobal((ID44!=null?ID44.getText():null)))
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
                    			errors.add("line "+(ID44!=null?ID44.getLine():0)+": unknown variable "+(ID44!=null?ID44.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:619:4: INT
                    {
                    INT45=(Token)match(input,INT,FOLLOW_INT_in_s_el997); 


                    // TEMPLATE REWRITE
                    // 619:9: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT45!=null?INT45.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:622:1: to_string_stmt : 'ToString' '(' param_str ')' ;
    public final MyStrLangParser.to_string_stmt_return to_string_stmt() throws RecognitionException {
        MyStrLangParser.to_string_stmt_return retval = new MyStrLangParser.to_string_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.param_str_return param_str46 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:623:2: ( 'ToString' '(' param_str ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:623:4: 'ToString' '(' param_str ')'
            {
            match(input,29,FOLLOW_29_in_to_string_stmt1019); 
            match(input,14,FOLLOW_14_in_to_string_stmt1021); 
            pushFollow(FOLLOW_param_str_in_to_string_stmt1023);
            param_str46=param_str();

            state._fsp--;

            match(input,15,FOLLOW_15_in_to_string_stmt1025); 

            		if(TypesChecker.isInteger((param_str46!=null?param_str46.t:null))){
            			retval.st = templateLib.getInstanceOf("int_to_string",
              new STAttrMap().put("value", (param_str46!=null?param_str46.st:null)));
            		}
            		if(TypesChecker.isChar((param_str46!=null?param_str46.t:null))){
            			retval.st = templateLib.getInstanceOf("char_to_string",
              new STAttrMap().put("value", (param_str46!=null?param_str46.st:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:634:1: param_str returns [String t] : ( ID | INT -> const_int(value=$INT.text) | char_c -> {$char_c.st});
    public final MyStrLangParser.param_str_return param_str() throws RecognitionException {
        MyStrLangParser.param_str_return retval = new MyStrLangParser.param_str_return();
        retval.start = input.LT(1);

        Token ID47=null;
        Token INT48=null;
        MyStrLangParser.char_c_return char_c49 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:635:2: ( ID | INT -> const_int(value=$INT.text) | char_c -> {$char_c.st})
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:635:4: ID
                    {
                    ID47=(Token)match(input,ID,FOLLOW_ID_in_param_str1043); 

                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID47!=null?ID47.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID47!=null?ID47.getText():null));
                    			String type = v_type.getType();
                    			retval.t = type;
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
                    			
                    			if(TypesChecker.isChar(type))
                    			{
                    				if(names.isGlobal((ID47!=null?ID47.getText():null)))
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
                    			errors.add("line "+(ID47!=null?ID47.getLine():0)+": unknown variable "+(ID47!=null?ID47.getText():null));
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:667:4: INT
                    {
                    INT48=(Token)match(input,INT,FOLLOW_INT_in_param_str1051); 
                    retval.t ="int";


                    // TEMPLATE REWRITE
                    // 667:22: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT48!=null?INT48.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:668:4: char_c
                    {
                    pushFollow(FOLLOW_char_c_in_param_str1069);
                    char_c49=char_c();

                    state._fsp--;

                    retval.t ="char";


                    // TEMPLATE REWRITE
                    // 668:25: -> {$char_c.st}
                    {
                        retval.st = (char_c49!=null?char_c49.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:671:1: call_func_stmt : call_func -> {$call_func.st};
    public final MyStrLangParser.call_func_stmt_return call_func_stmt() throws RecognitionException {
        MyStrLangParser.call_func_stmt_return retval = new MyStrLangParser.call_func_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.call_func_return call_func50 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:672:2: ( call_func -> {$call_func.st})
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:672:4: call_func
            {
            pushFollow(FOLLOW_call_func_in_call_func_stmt1088);
            call_func50=call_func();

            state._fsp--;



            // TEMPLATE REWRITE
            // 673:3: -> {$call_func.st}
            {
                retval.st = (call_func50!=null?call_func50.st:null);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:676:1: call_func returns [String type, int line] : ID '(' arg_call ')' ;
    public final MyStrLangParser.call_func_return call_func() throws RecognitionException {
        call_func_stack.push(new call_func_scope());
        MyStrLangParser.call_func_return retval = new MyStrLangParser.call_func_return();
        retval.start = input.LT(1);

        Token ID51=null;
        MyStrLangParser.arg_call_return arg_call52 = null;



        	((call_func_scope)call_func_stack.peek()).methodName = "";
        	List<StringTemplate> argTypes = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:684:2: ( ID '(' arg_call ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:684:4: ID '(' arg_call ')'
            {
            ID51=(Token)match(input,ID,FOLLOW_ID_in_call_func1116); 
            ((call_func_scope)call_func_stack.peek()).methodName =(ID51!=null?ID51.getText():null);
            match(input,14,FOLLOW_14_in_call_func1119); 
            pushFollow(FOLLOW_arg_call_in_call_func1121);
            arg_call52=arg_call();

            state._fsp--;

            match(input,15,FOLLOW_15_in_call_func1123); 

            		retval.line = (ID51!=null?ID51.getLine():0);
            		ArrayList<String> list = null;
            		if((arg_call52!=null?arg_call52.argumentTypeList:null)==null)
            			list = new ArrayList<String>();
            		else
            			list = (arg_call52!=null?arg_call52.argumentTypeList:null);
            		if(!names.checkCallFunction((ID51!=null?ID51.getText():null), list, (ID51!=null?ID51.getLine():0)))
            		{
            			names.getAllErrors(errors);
            		}
            		if(!names.isExistFunction((ID51!=null?ID51.getText():null)))
            		{
            			errors.add("line "+(ID51!=null?ID51.getLine():0)+": function "+(ID51!=null?ID51.getText():null)+" is not exist");
            		}
            		else
            		{
            			NamesTable.FunctionName func = names.getFunction((ID51!=null?ID51.getText():null));
            			retval.type = func.getReturnType();
            		}
            		
            		for(String arg_type: (arg_call52!=null?arg_call52.argumentTypeList:null))
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
              new STAttrMap().put("programName", programName).put("funcName", (ID51!=null?ID51.getText():null)).put("argTemplates", (arg_call52!=null?arg_call52.stList:null)).put("argTypes", argTypes).put("returnType", returnType));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:746:1: arg_call returns [ArrayList<String> argumentTypeList, List<StringTemplate> stList] : (a= atom ( ',' b= atom )* )? ;
    public final MyStrLangParser.arg_call_return arg_call() throws RecognitionException {
        MyStrLangParser.arg_call_return retval = new MyStrLangParser.arg_call_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return a = null;

        MyStrLangParser.atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:747:2: ( (a= atom ( ',' b= atom )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:748:2: (a= atom ( ',' b= atom )* )?
            {

            		retval.argumentTypeList = new ArrayList<String>();
            		retval.stList = new ArrayList<StringTemplate>();
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:752:2: (a= atom ( ',' b= atom )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=ID && LA19_0<=CHAR)||(LA19_0>=27 && LA19_0<=29)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:752:3: a= atom ( ',' b= atom )*
                    {
                    pushFollow(FOLLOW_atom_in_arg_call1149);
                    a=atom();

                    state._fsp--;

                    retval.argumentTypeList.add((a!=null?a.type:null)); retval.stList.add((a!=null?a.st:null));
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:752:64: ( ',' b= atom )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==16) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:752:65: ',' b= atom
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_call1154); 
                    	    pushFollow(FOLLOW_atom_in_arg_call1158);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:755:1: expression : and_expression ( '|' expression )? ;
    public final MyStrLangParser.expression_return expression() throws RecognitionException {
        MyStrLangParser.expression_return retval = new MyStrLangParser.expression_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:755:11: ( and_expression ( '|' expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:755:13: and_expression ( '|' expression )?
            {
            pushFollow(FOLLOW_and_expression_in_expression1174);
            and_expression();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:755:28: ( '|' expression )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:755:29: '|' expression
                    {
                    match(input,30,FOLLOW_30_in_expression1177); 
                    pushFollow(FOLLOW_expression_in_expression1180);
                    expression();

                    state._fsp--;


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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:758:1: and_expression : not_expression ( '&' and_expression )? ;
    public final MyStrLangParser.and_expression_return and_expression() throws RecognitionException {
        MyStrLangParser.and_expression_return retval = new MyStrLangParser.and_expression_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:759:2: ( not_expression ( '&' and_expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:759:4: not_expression ( '&' and_expression )?
            {
            pushFollow(FOLLOW_not_expression_in_and_expression1195);
            not_expression();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:759:19: ( '&' and_expression )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:759:20: '&' and_expression
                    {
                    match(input,31,FOLLOW_31_in_and_expression1198); 
                    pushFollow(FOLLOW_and_expression_in_and_expression1200);
                    and_expression();

                    state._fsp--;


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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:762:1: not_expression : ( '!' not_expression | comparison );
    public final MyStrLangParser.not_expression_return not_expression() throws RecognitionException {
        MyStrLangParser.not_expression_return retval = new MyStrLangParser.not_expression_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:763:2: ( '!' not_expression | comparison )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=ID && LA22_0<=CHAR)||(LA22_0>=27 && LA22_0<=29)) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:763:4: '!' not_expression
                    {
                    match(input,32,FOLLOW_32_in_not_expression1214); 
                    pushFollow(FOLLOW_not_expression_in_not_expression1216);
                    not_expression();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:763:23: comparison
                    {
                    pushFollow(FOLLOW_comparison_in_not_expression1218);
                    comparison();

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
    // $ANTLR end "not_expression"

    public static class comparison_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "comparison"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:766:1: comparison : a= atom c= ( '<' | '>' | '==' | '!=' ) b= atom ;
    public final MyStrLangParser.comparison_return comparison() throws RecognitionException {
        MyStrLangParser.comparison_return retval = new MyStrLangParser.comparison_return();
        retval.start = input.LT(1);

        Token c=null;
        MyStrLangParser.atom_return a = null;

        MyStrLangParser.atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:767:2: (a= atom c= ( '<' | '>' | '==' | '!=' ) b= atom )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:767:4: a= atom c= ( '<' | '>' | '==' | '!=' ) b= atom
            {
            pushFollow(FOLLOW_atom_in_comparison1231);
            a=atom();

            state._fsp--;

            c=(Token)input.LT(1);
            if ( (input.LA(1)>=33 && input.LA(1)<=36) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_atom_in_comparison1247);
            b=atom();

            state._fsp--;


            		if(!TypesChecker.checkTypes((a!=null?a.type:null), (b!=null?b.type:null)))
            		{
            			errors.add("line "+(c!=null?c.getLine():0)+": Incompatible types "+(a!=null?a.type:null)+" and "+(b!=null?b.type:null));
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
    // $ANTLR end "comparison"

    public static class type_return extends ParserRuleReturnScope {
        public StringTemplate returnType;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:776:1: type returns [StringTemplate returnType] : ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char());
    public final MyStrLangParser.type_return type() throws RecognitionException {
        MyStrLangParser.type_return retval = new MyStrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:777:2: ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char())
            int alt23=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt23=1;
                }
                break;
            case 38:
                {
                alt23=2;
                }
                break;
            case 39:
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:777:4: 'int'
                    {
                    match(input,37,FOLLOW_37_in_type1266); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 777:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:778:5: 'string'
                    {
                    match(input,38,FOLLOW_38_in_type1280); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 778:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:779:5: 'char'
                    {
                    match(input,39,FOLLOW_39_in_type1293); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 779:46: -> type_char()
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:782:1: type_func returns [StringTemplate returnType] : ( | 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char() | 'void' -> type_void());
    public final MyStrLangParser.type_func_return type_func() throws RecognitionException {
        MyStrLangParser.type_func_return retval = new MyStrLangParser.type_func_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:783:2: ( | 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char() | 'void' -> type_void())
            int alt24=5;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt24=1;
                }
                break;
            case 37:
                {
                alt24=2;
                }
                break;
            case 38:
                {
                alt24=3;
                }
                break;
            case 39:
                {
                alt24=4;
                }
                break;
            case 40:
                {
                alt24=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:784:2: 
                    {
                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:784:4: 'int'
                    {
                    match(input,37,FOLLOW_37_in_type_func1319); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 784:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:785:5: 'string'
                    {
                    match(input,38,FOLLOW_38_in_type_func1333); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 785:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:786:5: 'char'
                    {
                    match(input,39,FOLLOW_39_in_type_func1346); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 786:46: -> type_char()
                    {
                        retval.st = templateLib.getInstanceOf("type_char");
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:787:4: 'void'
                    {
                    match(input,40,FOLLOW_40_in_type_func1358); 
                    retval.returnType = templateLib.getInstanceOf("return_void");


                    // TEMPLATE REWRITE
                    // 787:43: -> type_void()
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
        "\1\47\1\21\10\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\1\1\10";
    static final String DFA7_specialS =
        "\12\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\17\uffff\1\3\1\4\1\5\1\uffff\1\6\1\7\13\uffff\3\2",
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
            return "241:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st});";
        }
    }
    static final String DFA10_eotS =
        "\12\uffff";
    static final String DFA10_eofS =
        "\12\uffff";
    static final String DFA10_minS =
        "\1\4\1\15\10\uffff";
    static final String DFA10_maxS =
        "\1\35\1\44\10\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\6\1\7\1\10\1\1\1\5";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\1\2\1\3\1\4\23\uffff\1\5\1\6\1\7",
            "\1\10\1\11\2\10\1\uffff\2\10\12\uffff\2\10\1\uffff\4\10",
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
            return "389:1: atom returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | char_c -> {$char_c.st} | call_func -> {$call_func.st} | length_stmt -> {$length_stmt.st} | elem_stmt -> {$elem_stmt.st} | to_string_stmt -> {$to_string_stmt.st});";
        }
    }
 

    public static final BitSet FOLLOW_global_variables_in_program61 = new BitSet(new long[]{0x000001E000002410L});
    public static final BitSet FOLLOW_functions_in_program65 = new BitSet(new long[]{0x000001E000000410L});
    public static final BitSet FOLLOW_mainBlock_in_program73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_mainBlock117 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_mainBlock119 = new BitSet(new long[]{0x000000E007700010L});
    public static final BitSet FOLLOW_block_in_mainBlock121 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_mainBlock123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_declaration_in_global_variables149 = new BitSet(new long[]{0x000000E000002000L});
    public static final BitSet FOLLOW_13_in_global_variables155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_declaration167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_declaration169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_func_in_functions208 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functions215 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_functions220 = new BitSet(new long[]{0x000000E000008000L});
    public static final BitSet FOLLOW_arg_list_in_functions222 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_functions224 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_functions232 = new BitSet(new long[]{0x000000E007700010L});
    public static final BitSet FOLLOW_block_in_functions237 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_functions240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_arg_list294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list298 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_list308 = new BitSet(new long[]{0x000000E000000000L});
    public static final BitSet FOLLOW_type_in_arg_list312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list316 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_statements_in_block354 = new BitSet(new long[]{0x000000E007700010L});
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
    public static final BitSet FOLLOW_17_in_assign_stmt471 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_expr_in_assign_stmt473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_expr497 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_expr513 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_19_in_expr517 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_expr522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_stmt546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_decl_stmt548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_write_stmt563 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_write_stmt565 = new BitSet(new long[]{0x000000E03B7000F0L});
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
    public static final BitSet FOLLOW_CHAR_in_char_c707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_read_strm733 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_read_strm735 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_read_strm737 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_read_strm739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_if_stmt753 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_stmt755 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_expression_in_if_stmt757 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_if_stmt759 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt761 = new BitSet(new long[]{0x000000E007700010L});
    public static final BitSet FOLLOW_block_in_if_stmt763 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt765 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_if_stmt768 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt770 = new BitSet(new long[]{0x000000E007700010L});
    public static final BitSet FOLLOW_block_in_if_stmt772 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_for_stmt786 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_for_stmt788 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt790 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt793 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_expression_in_for_stmt795 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt797 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt799 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_for_stmt801 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_for_stmt803 = new BitSet(new long[]{0x000000E007700010L});
    public static final BitSet FOLLOW_block_in_for_stmt805 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_for_stmt807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_while_stmt819 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_stmt821 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_expression_in_while_stmt823 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_while_stmt825 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_while_stmt827 = new BitSet(new long[]{0x000000E007700010L});
    public static final BitSet FOLLOW_block_in_while_stmt829 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_while_stmt831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_return_stmt850 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_return_stmt852 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_return_stmt854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_length_stmt879 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_length_stmt881 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_param_in_length_stmt883 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_length_stmt885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_param910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_elem_stmt935 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_elem_stmt937 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_f_el_in_elem_stmt938 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_elem_stmt940 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_s_el_in_elem_stmt942 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_elem_stmt944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_f_el959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_f_el967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_s_el989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_s_el997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_to_string_stmt1019 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_to_string_stmt1021 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_param_str_in_to_string_stmt1023 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_to_string_stmt1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param_str1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_param_str1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_c_in_param_str1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_call_func_stmt1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func1116 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_call_func1119 = new BitSet(new long[]{0x000000E03B7080F0L});
    public static final BitSet FOLLOW_arg_call_in_call_func1121 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_call_func1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_arg_call1149 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_call1154 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_arg_call1158 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_and_expression_in_expression1174 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_expression1177 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_expression_in_expression1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_expression_in_and_expression1195 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_and_expression1198 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_and_expression_in_and_expression1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_not_expression1214 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_not_expression_in_not_expression1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_not_expression1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_comparison1231 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_set_in_comparison1235 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_comparison1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_type1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_type1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_type1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_type_func1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_type_func1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_type_func1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_type_func1358 = new BitSet(new long[]{0x0000000000000002L});

}