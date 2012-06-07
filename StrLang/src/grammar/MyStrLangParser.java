// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g 2012-06-08 01:17:20

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
    		private int labelNumber=0;
    		
    		protected NamesTable names = new NamesTable();
    		protected ArrayList<String> errors = new ArrayList<String>();
    		protected ArrayList<String> tmpVarNamesList = new ArrayList<String>();
    		
    		public static StringTemplateGroup templateGroup;
    		public static final String templateFileName = "D:/Projects/Yapis/StrLang/src/template/ByteCode.stg";
    		
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:92:1: program : ( global_variables )* ( functions )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName);
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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:103:2: ( ( global_variables )* ( functions )* mainBlock EOF -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:103:4: ( global_variables )* ( functions )* mainBlock EOF
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:103:4: ( global_variables )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 37:
                    {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==ID) ) {
                        int LA1_6 = input.LA(3);

                        if ( (LA1_6==13||(LA1_6>=37 && LA1_6<=39)) ) {
                            alt1=1;
                        }


                    }


                    }
                    break;
                case 38:
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
                case 39:
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
                case 13:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:103:4: global_variables
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

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:103:22: ( functions )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=37 && LA2_0<=40)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:103:23: functions
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
            // 104:3: -> program(global_variables=$program::global_variablesfunctions=$program::functionsprogram=$mainBlock.stprogramName=programName)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:107:1: mainBlock : 'main' '{' block '}' -> mainBlock(block=$block.stList);
    public final MyStrLangParser.mainBlock_return mainBlock() throws RecognitionException {
        MyStrLangParser.mainBlock_return retval = new MyStrLangParser.mainBlock_return();
        retval.start = input.LT(1);

        MyStrLangParser.block_return block3 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:108:2: ( 'main' '{' block '}' -> mainBlock(block=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:108:4: 'main' '{' block '}'
            {
            match(input,10,FOLLOW_10_in_mainBlock113); 
            match(input,11,FOLLOW_11_in_mainBlock115); 
            pushFollow(FOLLOW_block_in_mainBlock117);
            block3=block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_mainBlock119); 


            // TEMPLATE REWRITE
            // 109:3: -> mainBlock(block=$block.stList)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:112:1: global_variables : ( global_declaration )* ';' ;
    public final MyStrLangParser.global_variables_return global_variables() throws RecognitionException {
        MyStrLangParser.global_variables_return retval = new MyStrLangParser.global_variables_return();
        retval.start = input.LT(1);

        MyStrLangParser.global_declaration_return global_declaration4 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:113:2: ( ( global_declaration )* ';' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:113:4: ( global_declaration )* ';'
            {
             ((program_scope)program_stack.peek()).curBlock = "global";
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:113:38: ( global_declaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=37 && LA3_0<=39)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:113:39: global_declaration
            	    {
            	    pushFollow(FOLLOW_global_declaration_in_global_variables145);
            	    global_declaration4=global_declaration();

            	    state._fsp--;

            	    ((program_scope)program_stack.peek()).global_variables.add((global_declaration4!=null?global_declaration4.st:null));

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_global_variables151); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:116:1: global_declaration : type ID -> global_declaration(ident=$ID.texttype=$type.st);
    public final MyStrLangParser.global_declaration_return global_declaration() throws RecognitionException {
        MyStrLangParser.global_declaration_return retval = new MyStrLangParser.global_declaration_return();
        retval.start = input.LT(1);

        Token ID5=null;
        MyStrLangParser.type_return type6 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:117:2: ( type ID -> global_declaration(ident=$ID.texttype=$type.st))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:117:4: type ID
            {
            pushFollow(FOLLOW_type_in_global_declaration163);
            type6=type();

            state._fsp--;

            ID5=(Token)match(input,ID,FOLLOW_ID_in_global_declaration165); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID5!=null?ID5.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID5!=null?ID5.getText():null), (type6!=null?input.toString(type6.start,type6.stop):null), (ID5!=null?ID5.getLine():0)));
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID5!=null?ID5.getText():null)))
            				errors.add("line "+(ID5!=null?ID5.getLine():0)+": Duplicated variable name "+(ID5!=null?ID5.getText():null));
            		}
            	


            // TEMPLATE REWRITE
            // 130:2: -> global_declaration(ident=$ID.texttype=$type.st)
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:133:1: functions : type_func ID '(' arg_list ')' '{' block return_stmt '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$return_stmt.typeblock=$block.stList);
    public final MyStrLangParser.functions_return functions() throws RecognitionException {
        functions_stack.push(new functions_scope());
        MyStrLangParser.functions_return retval = new MyStrLangParser.functions_return();
        retval.start = input.LT(1);

        Token ID8=null;
        MyStrLangParser.type_func_return type_func7 = null;

        MyStrLangParser.return_stmt_return return_stmt9 = null;

        MyStrLangParser.arg_list_return arg_list10 = null;

        MyStrLangParser.block_return block11 = null;



        	((functions_scope)functions_stack.peek()).funcName = "";
        	((functions_scope)functions_stack.peek()).funcType = "";
        	((functions_scope)functions_stack.peek()).returnVariable = "";
        	((functions_scope)functions_stack.peek()).funcArgNames = new ArrayList<String>();
        	((functions_scope)functions_stack.peek()).funcArgTypes = new ArrayList<String>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:149:2: ( type_func ID '(' arg_list ')' '{' block return_stmt '}' -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$return_stmt.typeblock=$block.stList))
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:149:4: type_func ID '(' arg_list ')' '{' block return_stmt '}'
            {
            pushFollow(FOLLOW_type_func_in_functions204);
            type_func7=type_func();

            state._fsp--;

            ((functions_scope)functions_stack.peek()).funcType = (type_func7!=null?input.toString(type_func7.start,type_func7.stop):null);
            ID8=(Token)match(input,ID,FOLLOW_ID_in_functions208); 
            ((program_scope)program_stack.peek()).curBlock = (ID8!=null?ID8.getText():null); ((functions_scope)functions_stack.peek()).funcName =(ID8!=null?ID8.getText():null);
            match(input,14,FOLLOW_14_in_functions212); 
            pushFollow(FOLLOW_arg_list_in_functions214);
            arg_list10=arg_list();

            state._fsp--;

            match(input,15,FOLLOW_15_in_functions216); 

            		if(!names.isExistFunction((ID8!=null?ID8.getText():null)))
            		{
            			names.addFunction(names.new FunctionName((ID8!=null?ID8.getText():null), (type_func7!=null?input.toString(type_func7.start,type_func7.stop):null), ((functions_scope)functions_stack.peek()).funcArgTypes, ((functions_scope)functions_stack.peek()).funcArgNames, (ID8!=null?ID8.getLine():0)));
            		}
            		else
            		{
            			errors.add("line "+(ID8!=null?ID8.getLine():0)+": Duplicated declaration function "+(ID8!=null?ID8.getText():null));
            		}
            	
            match(input,11,FOLLOW_11_in_functions224); 
            pushFollow(FOLLOW_block_in_functions229);
            block11=block();

            state._fsp--;

            pushFollow(FOLLOW_return_stmt_in_functions234);
            return_stmt9=return_stmt();

            state._fsp--;


            			boolean result = names.checkReturnType((ID8!=null?ID8.getText():null), ((functions_scope)functions_stack.peek()).returnVariable, (return_stmt9!=null?return_stmt9.type:null), ((program_scope)program_stack.peek()).curBlock, (ID8!=null?ID8.getLine():0));
            			if(result==false)
            			{
            				errors.add(names.getLastError());
            			}
            		
            match(input,12,FOLLOW_12_in_functions242); 


            // TEMPLATE REWRITE
            // 174:2: -> functions(type=$type_func.stident=$ID.textargs=$arg_list.stListreturnType=$return_stmt.typeblock=$block.stList)
            {
                retval.st = templateLib.getInstanceOf("functions",
              new STAttrMap().put("type", (type_func7!=null?type_func7.st:null)).put("ident", (ID8!=null?ID8.getText():null)).put("args", (arg_list10!=null?arg_list10.stList:null)).put("returnType", (return_stmt9!=null?return_stmt9.type:null)).put("block", (block11!=null?block11.stList:null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:177:1: arg_list returns [List<StringTemplate> stList] : (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? ;
    public final MyStrLangParser.arg_list_return arg_list() throws RecognitionException {
        MyStrLangParser.arg_list_return retval = new MyStrLangParser.arg_list_return();
        retval.start = input.LT(1);

        Token firstId=null;
        Token secondId=null;
        MyStrLangParser.type_return firstType = null;

        MyStrLangParser.type_return secondType = null;



        	retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:181:2: ( (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:181:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:181:4: (firstType= type firstId= ID ( ',' secondType= type secondId= ID )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=37 && LA5_0<=39)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:182:3: firstType= type firstId= ID ( ',' secondType= type secondId= ID )*
                    {
                    pushFollow(FOLLOW_type_in_arg_list297);
                    firstType=type();

                    state._fsp--;

                    firstId=(Token)match(input,ID,FOLLOW_ID_in_arg_list301); 

                    			((functions_scope)functions_stack.peek()).funcArgTypes.add((firstType!=null?input.toString(firstType.start,firstType.stop):null));
                    			((functions_scope)functions_stack.peek()).funcArgNames.add((firstId!=null?firstId.getText():null));
                    			if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(firstId!=null?firstId.getText():null)))
                    			{
                    				names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(firstId!=null?firstId.getText():null), (firstType!=null?input.toString(firstType.start,firstType.stop):null), (firstId!=null?firstId.getLine():0)));
                    				retval.stList.add(templateLib.getInstanceOf("parameter",
                      new STAttrMap().put("type", (firstType!=null?firstType.st:null)).put("ident", (firstId!=null?firstId.getText():null))));
                    			}
                    			else
                    			{
                    				errors.add("line "+(firstId!=null?firstId.getLine():0)+": Duplicated variable name "+(firstId!=null?firstId.getText():null));
                    			}
                    		
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:196:4: ( ',' secondType= type secondId= ID )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:196:5: ',' secondType= type secondId= ID
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_list311); 
                    	    pushFollow(FOLLOW_type_in_arg_list315);
                    	    secondType=type();

                    	    state._fsp--;

                    	    secondId=(Token)match(input,ID,FOLLOW_ID_in_arg_list319); 

                    	     			((functions_scope)functions_stack.peek()).funcArgTypes.add((secondType!=null?input.toString(secondType.start,secondType.stop):null));
                    	    			((functions_scope)functions_stack.peek()).funcArgNames.add((secondId!=null?secondId.getText():null));
                    	    			if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(secondId!=null?secondId.getText():null)))
                    	    			{
                    	    				names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(secondId!=null?secondId.getText():null), (secondType!=null?input.toString(secondType.start,secondType.stop):null), (secondId!=null?secondId.getLine():0)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:214:1: block returns [List<StringTemplate> stList] : ( statements )* ;
    public final MyStrLangParser.block_return block() throws RecognitionException {
        MyStrLangParser.block_return retval = new MyStrLangParser.block_return();
        retval.start = input.LT(1);

        MyStrLangParser.statements_return statements12 = null;



        	retval.stList = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:218:2: ( ( statements )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:218:4: ( statements )*
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:218:4: ( statements )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ID||(LA6_0>=20 && LA6_0<=22)||(LA6_0>=24 && LA6_0<=25)||(LA6_0>=37 && LA6_0<=39)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:218:5: statements
            	    {
            	    pushFollow(FOLLOW_statements_in_block357);
            	    statements12=statements();

            	    state._fsp--;

            	    retval.stList.add((statements12!=null?statements12.st:null));

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "block"

    public static class statements_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "statements"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:221:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st});
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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:222:2: ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st})
            int alt7=8;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:222:4: assign_stmt ';'
                    {
                    pushFollow(FOLLOW_assign_stmt_in_statements373);
                    assign_stmt13=assign_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements375); 


                    // TEMPLATE REWRITE
                    // 222:20: -> {$assign_stmt.st}
                    {
                        retval.st = (assign_stmt13!=null?assign_stmt13.st:null);
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:223:4: decl_stmt ';'
                    {
                    pushFollow(FOLLOW_decl_stmt_in_statements384);
                    decl_stmt14=decl_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements386); 


                    // TEMPLATE REWRITE
                    // 223:18: -> {$decl_stmt.st}
                    {
                        retval.st = (decl_stmt14!=null?decl_stmt14.st:null);
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:224:4: write_stmt ';'
                    {
                    pushFollow(FOLLOW_write_stmt_in_statements395);
                    write_stmt15=write_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements397); 


                    // TEMPLATE REWRITE
                    // 224:19: -> {$write_stmt.st}
                    {
                        retval.st = (write_stmt15!=null?write_stmt15.st:null);
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:225:4: read_strm ';'
                    {
                    pushFollow(FOLLOW_read_strm_in_statements406);
                    read_strm16=read_strm();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements408); 


                    // TEMPLATE REWRITE
                    // 225:18: -> {$read_strm.st}
                    {
                        retval.st = (read_strm16!=null?read_strm16.st:null);
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:226:4: if_stmt
                    {
                    pushFollow(FOLLOW_if_stmt_in_statements417);
                    if_stmt17=if_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 226:12: -> {$if_stmt.st}
                    {
                        retval.st = (if_stmt17!=null?if_stmt17.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:227:4: for_stmt
                    {
                    pushFollow(FOLLOW_for_stmt_in_statements426);
                    for_stmt18=for_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 227:13: -> {$for_stmt.st}
                    {
                        retval.st = (for_stmt18!=null?for_stmt18.st:null);
                    }


                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:228:4: while_stmt
                    {
                    pushFollow(FOLLOW_while_stmt_in_statements435);
                    while_stmt19=while_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 228:15: -> {$while_stmt.st}
                    {
                        retval.st = (while_stmt19!=null?while_stmt19.st:null);
                    }


                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:229:5: call_func_stmt ';'
                    {
                    pushFollow(FOLLOW_call_func_stmt_in_statements444);
                    call_func_stmt20=call_func_stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statements446); 


                    // TEMPLATE REWRITE
                    // 229:24: -> {$call_func_stmt.st}
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:232:1: assign_stmt : ID '=' firstAssign= atom ( ( '+' | '-' ) secondAssign= atom )? ;
    public final MyStrLangParser.assign_stmt_return assign_stmt() throws RecognitionException {
        MyStrLangParser.assign_stmt_return retval = new MyStrLangParser.assign_stmt_return();
        retval.start = input.LT(1);

        Token ID21=null;
        MyStrLangParser.atom_return firstAssign = null;

        MyStrLangParser.atom_return secondAssign = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:233:2: ( ID '=' firstAssign= atom ( ( '+' | '-' ) secondAssign= atom )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:233:4: ID '=' firstAssign= atom ( ( '+' | '-' ) secondAssign= atom )?
            {
            ID21=(Token)match(input,ID,FOLLOW_ID_in_assign_stmt462); 
            match(input,17,FOLLOW_17_in_assign_stmt464); 
            pushFollow(FOLLOW_atom_in_assign_stmt468);
            firstAssign=atom();

            state._fsp--;


            		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID21!=null?ID21.getText():null)))
            		{
            			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID21!=null?ID21.getText():null));
            			String varType = var_type.getType();
            			if(!TypesChecker.checkTypes(varType, (firstAssign!=null?firstAssign.type:null)))
            			{
            				errors.add("line "+(ID21!=null?ID21.getLine():0)+": Type mismatch: cannot convert from "+varType+" to "+(firstAssign!=null?firstAssign.type:null));
            			}
            		}
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:245:2: ( ( '+' | '-' ) secondAssign= atom )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=18 && LA8_0<=19)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:245:3: ( '+' | '-' ) secondAssign= atom
                    {
                    if ( (input.LA(1)>=18 && input.LA(1)<=19) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_atom_in_assign_stmt484);
                    secondAssign=atom();

                    state._fsp--;


                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID21!=null?ID21.getText():null)))
                    		{
                    			NamesTable.VariableName var_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID21!=null?ID21.getText():null));
                    			String varType = var_type.getType();
                    			if(!TypesChecker.checkTypes(varType, (secondAssign!=null?secondAssign.type:null)))
                    			{
                    				errors.add("line "+(ID21!=null?ID21.getLine():0)+": Type mismatch: cannot convert from "+varType+" to "+(secondAssign!=null?secondAssign.type:null));
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

    public static class decl_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "decl_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:260:1: decl_stmt : type ID ;
    public final MyStrLangParser.decl_stmt_return decl_stmt() throws RecognitionException {
        MyStrLangParser.decl_stmt_return retval = new MyStrLangParser.decl_stmt_return();
        retval.start = input.LT(1);

        Token ID22=null;
        MyStrLangParser.type_return type23 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:261:2: ( type ID )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:261:4: type ID
            {
            pushFollow(FOLLOW_type_in_decl_stmt503);
            type23=type();

            state._fsp--;

            ID22=(Token)match(input,ID,FOLLOW_ID_in_decl_stmt505); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID22!=null?ID22.getText():null)))
            		{
            			names.addVariable(names.new VariableName(((program_scope)program_stack.peek()).curBlock+"."+(ID22!=null?ID22.getText():null), (type23!=null?input.toString(type23.start,type23.stop):null), (ID22!=null?ID22.getLine():0)));
            		}
            		else
            		{
            			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID22!=null?ID22.getText():null)))
            				errors.add("line "+(ID22!=null?ID22.getLine():0)+": Duplicated variable name "+(ID22!=null?ID22.getText():null));
            		}
            		
            		if(TypesChecker.isInteger((type23!=null?input.toString(type23.start,type23.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_int",
              new STAttrMap().put("variableNumber", (ID22!=null?ID22.getText():null)));
            		}
            		if(TypesChecker.isString((type23!=null?input.toString(type23.start,type23.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_string",
              new STAttrMap().put("string", (ID22!=null?ID22.getText():null)));
            		}
            		if(TypesChecker.isChar((type23!=null?input.toString(type23.start,type23.stop):null)))
            		{
            			retval.st = templateLib.getInstanceOf("declaration_char",
              new STAttrMap().put("char", (ID22!=null?ID22.getText():null)));
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:288:1: write_stmt : 'write' '(' write_param ')' ;
    public final MyStrLangParser.write_stmt_return write_stmt() throws RecognitionException {
        MyStrLangParser.write_stmt_return retval = new MyStrLangParser.write_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.write_param_return write_param24 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:289:2: ( 'write' '(' write_param ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:289:4: 'write' '(' write_param ')'
            {
            match(input,20,FOLLOW_20_in_write_stmt520); 
            match(input,14,FOLLOW_14_in_write_stmt522); 
            pushFollow(FOLLOW_write_param_in_write_stmt524);
            write_param24=write_param();

            state._fsp--;

            match(input,15,FOLLOW_15_in_write_stmt526); 

            		if(TypesChecker.isInteger((write_param24!=null?write_param24.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_int",
              new STAttrMap().put("expression", (write_param24!=null?write_param24.st:null)));
            		}
            		if(TypesChecker.isString((write_param24!=null?write_param24.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_string",
              new STAttrMap().put("string", (write_param24!=null?write_param24.st:null)));
            		}
            		if(TypesChecker.isChar((write_param24!=null?write_param24.type:null)))
            		{
            			retval.st = templateLib.getInstanceOf("write_char",
              new STAttrMap().put("expression", (write_param24!=null?write_param24.st:null)));
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

    public static class write_param_return extends ParserRuleReturnScope {
        public String text;
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "write_param"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:306:1: write_param returns [String text, String type] : ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | CHAR -> const_char(value=$CHAR.text));
    public final MyStrLangParser.write_param_return write_param() throws RecognitionException {
        MyStrLangParser.write_param_return retval = new MyStrLangParser.write_param_return();
        retval.start = input.LT(1);

        Token ID25=null;
        Token INT26=null;
        Token STRING27=null;
        Token CHAR28=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:307:2: ( ID | INT -> const_int(value=$INT.text) | STRING -> const_string(value=$STRING.text) | CHAR -> const_char(value=$CHAR.text))
            int alt9=4;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt9=1;
                }
                break;
            case INT:
                {
                alt9=2;
                }
                break;
            case STRING:
                {
                alt9=3;
                }
                break;
            case CHAR:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:307:4: ID
                    {
                    ID25=(Token)match(input,ID,FOLLOW_ID_in_write_param545); 

                    		retval.text = (ID25!=null?ID25.getText():null);
                    		if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID25!=null?ID25.getText():null)))
                    		{
                    			NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID25!=null?ID25.getText():null));
                    			retval.type = v_type.getType();
                    		}
                    		else
                    		{
                    			errors.add("line "+(ID25!=null?ID25.getLine():0)+": unknown variable "+(ID25!=null?ID25.getText():null));
                    		}
                    	

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:319:4: INT
                    {
                    INT26=(Token)match(input,INT,FOLLOW_INT_in_write_param552); 
                    retval.text = (INT26!=null?INT26.getText():null); retval.type = "int";


                    // TEMPLATE REWRITE
                    // 319:47: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT26!=null?INT26.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:320:4: STRING
                    {
                    STRING27=(Token)match(input,STRING,FOLLOW_STRING_in_write_param571); 
                    retval.text = (STRING27!=null?STRING27.getText():null); retval.type = "string";


                    // TEMPLATE REWRITE
                    // 320:53: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING27!=null?STRING27.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:321:4: CHAR
                    {
                    CHAR28=(Token)match(input,CHAR,FOLLOW_CHAR_in_write_param589); 
                    retval.text = (CHAR28!=null?CHAR28.getText():null); retval.type = "char";


                    // TEMPLATE REWRITE
                    // 321:49: -> const_char(value=$CHAR.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_char",
                      new STAttrMap().put("value", (CHAR28!=null?CHAR28.getText():null)));
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
    // $ANTLR end "write_param"

    public static class read_strm_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "read_strm"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:324:1: read_strm : 'read' '(' ID ')' ;
    public final MyStrLangParser.read_strm_return read_strm() throws RecognitionException {
        MyStrLangParser.read_strm_return retval = new MyStrLangParser.read_strm_return();
        retval.start = input.LT(1);

        Token ID29=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:325:2: ( 'read' '(' ID ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:325:4: 'read' '(' ID ')'
            {
            match(input,21,FOLLOW_21_in_read_strm616); 
            match(input,14,FOLLOW_14_in_read_strm618); 
            ID29=(Token)match(input,ID,FOLLOW_ID_in_read_strm620); 
            match(input,15,FOLLOW_15_in_read_strm622); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID29!=null?ID29.getText():null)))
            			errors.add("line "+(ID29!=null?ID29.getLine():0)+": unknown variable "+(ID29!=null?ID29.getText():null));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:332:1: if_stmt : 'if' '(' expression ')' '{' block '}' ( 'else' '{' block '}' )? ;
    public final MyStrLangParser.if_stmt_return if_stmt() throws RecognitionException {
        MyStrLangParser.if_stmt_return retval = new MyStrLangParser.if_stmt_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:332:9: ( 'if' '(' expression ')' '{' block '}' ( 'else' '{' block '}' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:332:11: 'if' '(' expression ')' '{' block '}' ( 'else' '{' block '}' )?
            {
            match(input,22,FOLLOW_22_in_if_stmt636); 
            match(input,14,FOLLOW_14_in_if_stmt638); 
            pushFollow(FOLLOW_expression_in_if_stmt640);
            expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_if_stmt642); 
            match(input,11,FOLLOW_11_in_if_stmt644); 
            pushFollow(FOLLOW_block_in_if_stmt646);
            block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_if_stmt648); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:332:49: ( 'else' '{' block '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:332:50: 'else' '{' block '}'
                    {
                    match(input,23,FOLLOW_23_in_if_stmt651); 
                    match(input,11,FOLLOW_11_in_if_stmt653); 
                    pushFollow(FOLLOW_block_in_if_stmt655);
                    block();

                    state._fsp--;

                    match(input,12,FOLLOW_12_in_if_stmt657); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:335:1: for_stmt : 'for' '(' ( assign_stmt )? ';' expression ';' assign_stmt ')' '{' block '}' ;
    public final MyStrLangParser.for_stmt_return for_stmt() throws RecognitionException {
        MyStrLangParser.for_stmt_return retval = new MyStrLangParser.for_stmt_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:335:9: ( 'for' '(' ( assign_stmt )? ';' expression ';' assign_stmt ')' '{' block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:335:11: 'for' '(' ( assign_stmt )? ';' expression ';' assign_stmt ')' '{' block '}'
            {
            match(input,24,FOLLOW_24_in_for_stmt669); 
            match(input,14,FOLLOW_14_in_for_stmt671); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:335:21: ( assign_stmt )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:335:21: assign_stmt
                    {
                    pushFollow(FOLLOW_assign_stmt_in_for_stmt673);
                    assign_stmt();

                    state._fsp--;


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_for_stmt676); 
            pushFollow(FOLLOW_expression_in_for_stmt678);
            expression();

            state._fsp--;

            match(input,13,FOLLOW_13_in_for_stmt680); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt682);
            assign_stmt();

            state._fsp--;

            match(input,15,FOLLOW_15_in_for_stmt684); 
            match(input,11,FOLLOW_11_in_for_stmt686); 
            pushFollow(FOLLOW_block_in_for_stmt688);
            block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_for_stmt690); 

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:338:1: while_stmt : 'while' '(' expression ')' '{' block '}' ;
    public final MyStrLangParser.while_stmt_return while_stmt() throws RecognitionException {
        MyStrLangParser.while_stmt_return retval = new MyStrLangParser.while_stmt_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:339:2: ( 'while' '(' expression ')' '{' block '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:339:4: 'while' '(' expression ')' '{' block '}'
            {
            match(input,25,FOLLOW_25_in_while_stmt702); 
            match(input,14,FOLLOW_14_in_while_stmt704); 
            pushFollow(FOLLOW_expression_in_while_stmt706);
            expression();

            state._fsp--;

            match(input,15,FOLLOW_15_in_while_stmt708); 
            match(input,11,FOLLOW_11_in_while_stmt710); 
            pushFollow(FOLLOW_block_in_while_stmt712);
            block();

            state._fsp--;

            match(input,12,FOLLOW_12_in_while_stmt714); 

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
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "return_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:342:1: return_stmt returns [String type] : ( 'return' atom ';' )? ;
    public final MyStrLangParser.return_stmt_return return_stmt() throws RecognitionException {
        MyStrLangParser.return_stmt_return retval = new MyStrLangParser.return_stmt_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return atom30 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:343:2: ( ( 'return' atom ';' )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:343:4: ( 'return' atom ';' )?
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:343:4: ( 'return' atom ';' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:343:5: 'return' atom ';'
                    {
                    match(input,26,FOLLOW_26_in_return_stmt730); 
                    pushFollow(FOLLOW_atom_in_return_stmt732);
                    atom30=atom();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_return_stmt734); 
                    ((functions_scope)functions_stack.peek()).returnVariable =(atom30!=null?atom30.value:null); retval.type =(atom30!=null?atom30.type:null);

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
    // $ANTLR end "return_stmt"

    public static class length_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "length_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:346:1: length_stmt : 'length' '(' (a= ID | STRING ) ')' ;
    public final MyStrLangParser.length_stmt_return length_stmt() throws RecognitionException {
        MyStrLangParser.length_stmt_return retval = new MyStrLangParser.length_stmt_return();
        retval.start = input.LT(1);

        Token a=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:347:2: ( 'length' '(' (a= ID | STRING ) ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:347:4: 'length' '(' (a= ID | STRING ) ')'
            {
            match(input,27,FOLLOW_27_in_length_stmt750); 
            match(input,14,FOLLOW_14_in_length_stmt752); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:347:17: (a= ID | STRING )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID) ) {
                alt13=1;
            }
            else if ( (LA13_0==STRING) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:347:18: a= ID
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_length_stmt757); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:347:23: STRING
                    {
                    match(input,STRING,FOLLOW_STRING_in_length_stmt759); 

                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_length_stmt762); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(a!=null?a.getText():null)))
            			errors.add("line "+(a!=null?a.getLine():0)+": unknown variable "+(a!=null?a.getText():null));
            	

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

    public static class elem_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "elem_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:354:1: elem_stmt : 'elem' '(' (a= ID | STRING ) ',' ( INT | b= ID ) ')' ;
    public final MyStrLangParser.elem_stmt_return elem_stmt() throws RecognitionException {
        MyStrLangParser.elem_stmt_return retval = new MyStrLangParser.elem_stmt_return();
        retval.start = input.LT(1);

        Token a=null;
        Token b=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:355:2: ( 'elem' '(' (a= ID | STRING ) ',' ( INT | b= ID ) ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:355:4: 'elem' '(' (a= ID | STRING ) ',' ( INT | b= ID ) ')'
            {
            match(input,28,FOLLOW_28_in_elem_stmt777); 
            match(input,14,FOLLOW_14_in_elem_stmt779); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:355:14: (a= ID | STRING )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:355:15: a= ID
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_elem_stmt783); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:355:20: STRING
                    {
                    match(input,STRING,FOLLOW_STRING_in_elem_stmt785); 

                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_elem_stmt787); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:355:30: ( INT | b= ID )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==INT) ) {
                alt15=1;
            }
            else if ( (LA15_0==ID) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:355:31: INT
                    {
                    match(input,INT,FOLLOW_INT_in_elem_stmt789); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:355:35: b= ID
                    {
                    b=(Token)match(input,ID,FOLLOW_ID_in_elem_stmt793); 

                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_elem_stmt796); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(a!=null?a.getText():null)))
            			errors.add("line "+(a!=null?a.getLine():0)+": unknown variable "+(a!=null?a.getText():null));
            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(b!=null?b.getText():null)))
            			errors.add("line "+(b!=null?b.getLine():0)+": unknown variable "+(b!=null?b.getText():null));
            	

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

    public static class to_string_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "to_string_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:364:1: to_string_stmt : 'ToString' '(' (b= CHAR | a= ID ) ')' ;
    public final MyStrLangParser.to_string_stmt_return to_string_stmt() throws RecognitionException {
        MyStrLangParser.to_string_stmt_return retval = new MyStrLangParser.to_string_stmt_return();
        retval.start = input.LT(1);

        Token b=null;
        Token a=null;

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:365:2: ( 'ToString' '(' (b= CHAR | a= ID ) ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:365:4: 'ToString' '(' (b= CHAR | a= ID ) ')'
            {
            match(input,29,FOLLOW_29_in_to_string_stmt811); 
            match(input,14,FOLLOW_14_in_to_string_stmt813); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:365:19: (b= CHAR | a= ID )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==CHAR) ) {
                alt16=1;
            }
            else if ( (LA16_0==ID) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:365:20: b= CHAR
                    {
                    b=(Token)match(input,CHAR,FOLLOW_CHAR_in_to_string_stmt818); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:365:27: a= ID
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_to_string_stmt822); 

                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_to_string_stmt825); 

            		if(!names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(a!=null?a.getText():null)))
            			errors.add("line "+(a!=null?a.getLine():0)+": unknown variable "+(a!=null?a.getText():null));
            	

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

    public static class call_func_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "call_func_stmt"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:372:1: call_func_stmt : call_func ;
    public final MyStrLangParser.call_func_stmt_return call_func_stmt() throws RecognitionException {
        MyStrLangParser.call_func_stmt_return retval = new MyStrLangParser.call_func_stmt_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:373:2: ( call_func )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:373:4: call_func
            {
            pushFollow(FOLLOW_call_func_in_call_func_stmt840);
            call_func();

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:376:1: call_func returns [String type, int line] : ID '(' arg_call ')' ;
    public final MyStrLangParser.call_func_return call_func() throws RecognitionException {
        call_func_stack.push(new call_func_scope());
        MyStrLangParser.call_func_return retval = new MyStrLangParser.call_func_return();
        retval.start = input.LT(1);

        Token ID31=null;
        MyStrLangParser.arg_call_return arg_call32 = null;



        	((call_func_scope)call_func_stack.peek()).methodName = "";
        	List<StringTemplate> argTypes = new ArrayList<StringTemplate>();

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:384:2: ( ID '(' arg_call ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:384:4: ID '(' arg_call ')'
            {
            ID31=(Token)match(input,ID,FOLLOW_ID_in_call_func862); 
            ((call_func_scope)call_func_stack.peek()).methodName =(ID31!=null?ID31.getText():null);
            match(input,14,FOLLOW_14_in_call_func865); 
            pushFollow(FOLLOW_arg_call_in_call_func867);
            arg_call32=arg_call();

            state._fsp--;

            match(input,15,FOLLOW_15_in_call_func869); 

            		retval.line = (ID31!=null?ID31.getLine():0);
            		ArrayList<String> list = null;
            		if((arg_call32!=null?arg_call32.argumentTypeList:null)==null)
            			list = new ArrayList<String>();
            		else
            			list = (arg_call32!=null?arg_call32.argumentTypeList:null);
            		if(!names.checkCallFunction((ID31!=null?ID31.getText():null), list, (ID31!=null?ID31.getLine():0)))
            		{
            			names.getAllErrors(errors);
            		}
            		if(!names.isExistFunction((ID31!=null?ID31.getText():null)))
            		{
            			errors.add("line "+(ID31!=null?ID31.getLine():0)+": function "+(ID31!=null?ID31.getText():null)+" is not exist");
            		}
            		else
            		{
            			NamesTable.FunctionName func = names.getFunction((ID31!=null?ID31.getText():null));
            			retval.type = func.getReturnType();
            		}
            		
            		for(String arg_type: (arg_call32!=null?arg_call32.argumentTypeList:null))
            		{
            			if(TypesChecker.isInteger(arg_type))
            			{
            				argTypes.add(templateLib.getInstanceOf("type_int"));
            			}
            			if(TypesChecker.isString(arg_type))
            			{
            				argTypes.add(templateLib.getInstanceOf("type_string"));
            			}
            			if(TypesChecker.isVoid(arg_type))
            			{
            				argTypes.add(templateLib.getInstanceOf("type_void"));
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
            		if(TypesChecker.isVoid(retval.type))
            		{
            			returnType = templateLib.getInstanceOf("type_void");
            		}
            		if(TypesChecker.isChar(retval.type))
            		{
            			returnType = templateLib.getInstanceOf("type_char");
            		}
            		
            		retval.st = templateLib.getInstanceOf("function_call",
              new STAttrMap().put("programName", programName).put("funcName", (ID31!=null?ID31.getText():null)).put("argTemplates", (arg_call32!=null?arg_call32.stList:null)).put("argTypes", argTypes).put("returnType", returnType));
            	

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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:449:1: arg_call returns [ArrayList<String> argumentTypeList, List<StringTemplate> stList] : (a= atom ( ',' b= atom )* )? ;
    public final MyStrLangParser.arg_call_return arg_call() throws RecognitionException {
        MyStrLangParser.arg_call_return retval = new MyStrLangParser.arg_call_return();
        retval.start = input.LT(1);

        MyStrLangParser.atom_return a = null;

        MyStrLangParser.atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:450:2: ( (a= atom ( ',' b= atom )* )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:451:2: (a= atom ( ',' b= atom )* )?
            {

            		retval.argumentTypeList = new ArrayList<String>();
            		retval.stList = new ArrayList<StringTemplate>();
            	
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:455:2: (a= atom ( ',' b= atom )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=ID && LA18_0<=CHAR)||(LA18_0>=27 && LA18_0<=29)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:455:3: a= atom ( ',' b= atom )*
                    {
                    pushFollow(FOLLOW_atom_in_arg_call895);
                    a=atom();

                    state._fsp--;

                    retval.argumentTypeList.add((a!=null?a.type:null)); retval.stList.add((a!=null?a.st:null));
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:455:64: ( ',' b= atom )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==16) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:455:65: ',' b= atom
                    	    {
                    	    match(input,16,FOLLOW_16_in_arg_call900); 
                    	    pushFollow(FOLLOW_atom_in_arg_call904);
                    	    b=atom();

                    	    state._fsp--;

                    	    retval.argumentTypeList.add((b!=null?b.type:null)); retval.stList.add((b!=null?b.st:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:458:1: expression : and_expression ( '|' expression )? ;
    public final MyStrLangParser.expression_return expression() throws RecognitionException {
        MyStrLangParser.expression_return retval = new MyStrLangParser.expression_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:458:11: ( and_expression ( '|' expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:458:13: and_expression ( '|' expression )?
            {
            pushFollow(FOLLOW_and_expression_in_expression920);
            and_expression();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:458:28: ( '|' expression )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:458:29: '|' expression
                    {
                    match(input,30,FOLLOW_30_in_expression923); 
                    pushFollow(FOLLOW_expression_in_expression926);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:461:1: and_expression : not_expression ( '&' and_expression )? ;
    public final MyStrLangParser.and_expression_return and_expression() throws RecognitionException {
        MyStrLangParser.and_expression_return retval = new MyStrLangParser.and_expression_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:462:2: ( not_expression ( '&' and_expression )? )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:462:4: not_expression ( '&' and_expression )?
            {
            pushFollow(FOLLOW_not_expression_in_and_expression941);
            not_expression();

            state._fsp--;

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:462:19: ( '&' and_expression )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:462:20: '&' and_expression
                    {
                    match(input,31,FOLLOW_31_in_and_expression944); 
                    pushFollow(FOLLOW_and_expression_in_and_expression946);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:465:1: not_expression : ( '!' not_expression | comparison );
    public final MyStrLangParser.not_expression_return not_expression() throws RecognitionException {
        MyStrLangParser.not_expression_return retval = new MyStrLangParser.not_expression_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:466:2: ( '!' not_expression | comparison )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=ID && LA21_0<=CHAR)||(LA21_0>=27 && LA21_0<=29)) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:466:4: '!' not_expression
                    {
                    match(input,32,FOLLOW_32_in_not_expression960); 
                    pushFollow(FOLLOW_not_expression_in_not_expression962);
                    not_expression();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:466:23: comparison
                    {
                    pushFollow(FOLLOW_comparison_in_not_expression964);
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:469:1: comparison : a= atom c= ( '<' | '>' | '==' | '!=' ) b= atom ;
    public final MyStrLangParser.comparison_return comparison() throws RecognitionException {
        MyStrLangParser.comparison_return retval = new MyStrLangParser.comparison_return();
        retval.start = input.LT(1);

        Token c=null;
        MyStrLangParser.atom_return a = null;

        MyStrLangParser.atom_return b = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:470:2: (a= atom c= ( '<' | '>' | '==' | '!=' ) b= atom )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:470:4: a= atom c= ( '<' | '>' | '==' | '!=' ) b= atom
            {
            pushFollow(FOLLOW_atom_in_comparison977);
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

            pushFollow(FOLLOW_atom_in_comparison993);
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

    public static class atom_return extends ParserRuleReturnScope {
        public String value;
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "atom"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:479:1: atom returns [String value, String type] : ( ID | INT -> const_int(value=$INT.text) | CHAR -> const_char(value=$CHAR.text) | STRING -> const_string(value=$STRING.text) | call_func -> {$call_func.st} | length_stmt | elem_stmt | to_string_stmt );
    public final MyStrLangParser.atom_return atom() throws RecognitionException {
        MyStrLangParser.atom_return retval = new MyStrLangParser.atom_return();
        retval.start = input.LT(1);

        Token ID33=null;
        Token INT34=null;
        Token CHAR35=null;
        Token STRING36=null;
        MyStrLangParser.call_func_return call_func37 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:480:2: ( ID | INT -> const_int(value=$INT.text) | CHAR -> const_char(value=$CHAR.text) | STRING -> const_string(value=$STRING.text) | call_func -> {$call_func.st} | length_stmt | elem_stmt | to_string_stmt )
            int alt22=8;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:480:4: ID
                    {
                    ID33=(Token)match(input,ID,FOLLOW_ID_in_atom1012); 

                    			retval.value = (ID33!=null?ID33.getText():null);
                    			if(names.isDeclaredVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID33!=null?ID33.getText():null)))
                    			{
                    				NamesTable.VariableName v_type = names.getVariable(((program_scope)program_stack.peek()).curBlock+"."+(ID33!=null?ID33.getText():null));
                    				retval.type = v_type.getType();
                    			}
                    			else
                    			{
                    				errors.add("line "+(ID33!=null?ID33.getLine():0)+": unknown variable "+(ID33!=null?ID33.getText():null));
                    			}
                    		

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:493:4: INT
                    {
                    INT34=(Token)match(input,INT,FOLLOW_INT_in_atom1022); 
                    retval.type ="int"; retval.value =(INT34!=null?INT34.getText():null);


                    // TEMPLATE REWRITE
                    // 493:41: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT34!=null?INT34.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:494:4: CHAR
                    {
                    CHAR35=(Token)match(input,CHAR,FOLLOW_CHAR_in_atom1038); 
                    retval.type ="char"; retval.value =(CHAR35!=null?CHAR35.getText():null);


                    // TEMPLATE REWRITE
                    // 494:43: -> const_char(value=$CHAR.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_char",
                      new STAttrMap().put("value", (CHAR35!=null?CHAR35.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:495:4: STRING
                    {
                    STRING36=(Token)match(input,STRING,FOLLOW_STRING_in_atom1055); 
                    retval.type ="string"; retval.value =(STRING36!=null?STRING36.getText():null);


                    // TEMPLATE REWRITE
                    // 495:49: -> const_string(value=$STRING.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_string",
                      new STAttrMap().put("value", (STRING36!=null?STRING36.getText():null)));
                    }


                    }
                    break;
                case 5 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:496:4: call_func
                    {
                    pushFollow(FOLLOW_call_func_in_atom1072);
                    call_func37=call_func();

                    state._fsp--;

                    retval.type =(call_func37!=null?call_func37.type:null);


                    // TEMPLATE REWRITE
                    // 496:40: -> {$call_func.st}
                    {
                        retval.st = (call_func37!=null?call_func37.st:null);
                    }


                    }
                    break;
                case 6 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:497:4: length_stmt
                    {
                    pushFollow(FOLLOW_length_stmt_in_atom1084);
                    length_stmt();

                    state._fsp--;

                    retval.type ="int";

                    }
                    break;
                case 7 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:498:4: elem_stmt
                    {
                    pushFollow(FOLLOW_elem_stmt_in_atom1090);
                    elem_stmt();

                    state._fsp--;

                    retval.type ="char";

                    }
                    break;
                case 8 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:499:4: to_string_stmt
                    {
                    pushFollow(FOLLOW_to_string_stmt_in_atom1096);
                    to_string_stmt();

                    state._fsp--;

                    retval.type ="string";

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

    public static class type_return extends ParserRuleReturnScope {
        public StringTemplate returnType;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "type"
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:502:1: type returns [StringTemplate returnType] : ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char());
    public final MyStrLangParser.type_return type() throws RecognitionException {
        MyStrLangParser.type_return retval = new MyStrLangParser.type_return();
        retval.start = input.LT(1);

        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:503:2: ( 'int' -> type_int() | 'string' -> type_string() | 'char' -> type_char())
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:503:4: 'int'
                    {
                    match(input,37,FOLLOW_37_in_type1113); 
                    retval.returnType = templateLib.getInstanceOf("return_int");


                    // TEMPLATE REWRITE
                    // 503:41: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:504:5: 'string'
                    {
                    match(input,38,FOLLOW_38_in_type1127); 
                    retval.returnType = templateLib.getInstanceOf("return_string");


                    // TEMPLATE REWRITE
                    // 504:48: -> type_string()
                    {
                        retval.st = templateLib.getInstanceOf("type_string");
                    }


                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:505:5: 'char'
                    {
                    match(input,39,FOLLOW_39_in_type1140); 
                    retval.returnType = templateLib.getInstanceOf("return_char");


                    // TEMPLATE REWRITE
                    // 505:44: -> type_char()
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
    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:508:1: type_func returns [StringTemplate returnType] : ( type | 'void' -> type_void());
    public final MyStrLangParser.type_func_return type_func() throws RecognitionException {
        MyStrLangParser.type_func_return retval = new MyStrLangParser.type_func_return();
        retval.start = input.LT(1);

        MyStrLangParser.type_return type38 = null;


        try {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:509:2: ( type | 'void' -> type_void())
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=37 && LA24_0<=39)) ) {
                alt24=1;
            }
            else if ( (LA24_0==40) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:509:4: type
                    {
                    pushFollow(FOLLOW_type_in_type_func1162);
                    type38=type();

                    state._fsp--;

                    retval.returnType = (type38!=null?type38.returnType:null);

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:510:4: 'void'
                    {
                    match(input,40,FOLLOW_40_in_type_func1169); 
                    retval.returnType = templateLib.getInstanceOf("return_void");


                    // TEMPLATE REWRITE
                    // 510:43: -> type_void()
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
    protected DFA22 dfa22 = new DFA22(this);
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
            return "221:1: statements : ( assign_stmt ';' -> {$assign_stmt.st} | decl_stmt ';' -> {$decl_stmt.st} | write_stmt ';' -> {$write_stmt.st} | read_strm ';' -> {$read_strm.st} | if_stmt -> {$if_stmt.st} | for_stmt -> {$for_stmt.st} | while_stmt -> {$while_stmt.st} | call_func_stmt ';' -> {$call_func_stmt.st});";
        }
    }
    static final String DFA22_eotS =
        "\12\uffff";
    static final String DFA22_eofS =
        "\12\uffff";
    static final String DFA22_minS =
        "\1\4\1\15\10\uffff";
    static final String DFA22_maxS =
        "\1\35\1\44\10\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\6\1\7\1\10\1\1\1\5";
    static final String DFA22_specialS =
        "\12\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\2\1\4\1\3\23\uffff\1\5\1\6\1\7",
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

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "479:1: atom returns [String value, String type] : ( ID | INT -> const_int(value=$INT.text) | CHAR -> const_char(value=$CHAR.text) | STRING -> const_string(value=$STRING.text) | call_func -> {$call_func.st} | length_stmt | elem_stmt | to_string_stmt );";
        }
    }
 

    public static final BitSet FOLLOW_global_variables_in_program61 = new BitSet(new long[]{0x000001E000002400L});
    public static final BitSet FOLLOW_functions_in_program65 = new BitSet(new long[]{0x000001E000000400L});
    public static final BitSet FOLLOW_mainBlock_in_program73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_mainBlock113 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_mainBlock115 = new BitSet(new long[]{0x000000E003701010L});
    public static final BitSet FOLLOW_block_in_mainBlock117 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_mainBlock119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_declaration_in_global_variables145 = new BitSet(new long[]{0x000000E000002000L});
    public static final BitSet FOLLOW_13_in_global_variables151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_global_declaration163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_global_declaration165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_func_in_functions204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_functions208 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_functions212 = new BitSet(new long[]{0x000000E000008000L});
    public static final BitSet FOLLOW_arg_list_in_functions214 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_functions216 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_functions224 = new BitSet(new long[]{0x000000E007701010L});
    public static final BitSet FOLLOW_block_in_functions229 = new BitSet(new long[]{0x0000000004001000L});
    public static final BitSet FOLLOW_return_stmt_in_functions234 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_functions242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_arg_list297 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list301 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_list311 = new BitSet(new long[]{0x000000E000000000L});
    public static final BitSet FOLLOW_type_in_arg_list315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_arg_list319 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_statements_in_block357 = new BitSet(new long[]{0x000000E003700012L});
    public static final BitSet FOLLOW_assign_stmt_in_statements373 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_stmt_in_statements384 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_stmt_in_statements395 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_strm_in_statements406 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_statements417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_stmt_in_statements426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_stmt_in_statements435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_stmt_in_statements444 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statements446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assign_stmt462 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_assign_stmt464 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_assign_stmt468 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_set_in_assign_stmt476 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_assign_stmt484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl_stmt503 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_decl_stmt505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_write_stmt520 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_write_stmt522 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_write_param_in_write_stmt524 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_write_stmt526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_write_param545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_write_param552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_write_param571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_write_param589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_read_strm616 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_read_strm618 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_read_strm620 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_read_strm622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_if_stmt636 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_stmt638 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_expression_in_if_stmt640 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_if_stmt642 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt644 = new BitSet(new long[]{0x000000E003701010L});
    public static final BitSet FOLLOW_block_in_if_stmt646 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt648 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_if_stmt651 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_if_stmt653 = new BitSet(new long[]{0x000000E003701010L});
    public static final BitSet FOLLOW_block_in_if_stmt655 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_if_stmt657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_for_stmt669 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_for_stmt671 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt673 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt676 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_expression_in_for_stmt678 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_for_stmt680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt682 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_for_stmt684 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_for_stmt686 = new BitSet(new long[]{0x000000E003701010L});
    public static final BitSet FOLLOW_block_in_for_stmt688 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_for_stmt690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_while_stmt702 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_stmt704 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_expression_in_while_stmt706 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_while_stmt708 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_while_stmt710 = new BitSet(new long[]{0x000000E003701010L});
    public static final BitSet FOLLOW_block_in_while_stmt712 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_while_stmt714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_return_stmt730 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_return_stmt732 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_return_stmt734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_length_stmt750 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_length_stmt752 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ID_in_length_stmt757 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_length_stmt759 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_length_stmt762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_elem_stmt777 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_elem_stmt779 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ID_in_elem_stmt783 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_elem_stmt785 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_elem_stmt787 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_INT_in_elem_stmt789 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_elem_stmt793 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_elem_stmt796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_to_string_stmt811 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_to_string_stmt813 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_CHAR_in_to_string_stmt818 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_to_string_stmt822 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_to_string_stmt825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_call_func_stmt840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_call_func862 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_call_func865 = new BitSet(new long[]{0x000000E03B7080F0L});
    public static final BitSet FOLLOW_arg_call_in_call_func867 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_call_func869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_arg_call895 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_arg_call900 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_arg_call904 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_and_expression_in_expression920 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_expression923 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_expression_in_expression926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_expression_in_and_expression941 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_and_expression944 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_and_expression_in_and_expression946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_not_expression960 = new BitSet(new long[]{0x000000E13B7000F0L});
    public static final BitSet FOLLOW_not_expression_in_not_expression962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_not_expression964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_comparison977 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_set_in_comparison981 = new BitSet(new long[]{0x000000E03B7000F0L});
    public static final BitSet FOLLOW_atom_in_comparison993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_atom1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_func_in_atom1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_length_stmt_in_atom1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elem_stmt_in_atom1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_string_stmt_in_atom1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_type1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_type1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_type1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_type_func1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_type_func1169 = new BitSet(new long[]{0x0000000000000002L});

}