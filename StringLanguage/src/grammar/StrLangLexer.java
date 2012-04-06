// $ANTLR 3.4 src\\grammar\\StrLang.g 2012-04-06 16:22:51

	package grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class StrLangLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public StrLangLexer() {} 
    public StrLangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public StrLangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "src\\grammar\\StrLang.g"; }

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:11:7: ( '(' )
            // src\\grammar\\StrLang.g:11:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:12:7: ( ')' )
            // src\\grammar\\StrLang.g:12:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:13:7: ( ',' )
            // src\\grammar\\StrLang.g:13:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:14:7: ( ';' )
            // src\\grammar\\StrLang.g:14:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:15:7: ( 'ReadFile' )
            // src\\grammar\\StrLang.g:15:9: 'ReadFile'
            {
            match("ReadFile"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:16:7: ( 'WriteToFile' )
            // src\\grammar\\StrLang.g:16:9: 'WriteToFile'
            {
            match("WriteToFile"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:17:7: ( 'and' )
            // src\\grammar\\StrLang.g:17:9: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:18:7: ( 'break' )
            // src\\grammar\\StrLang.g:18:9: 'break'
            {
            match("break"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:19:7: ( 'elem' )
            // src\\grammar\\StrLang.g:19:9: 'elem'
            {
            match("elem"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:20:7: ( 'else' )
            // src\\grammar\\StrLang.g:20:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:21:7: ( 'for' )
            // src\\grammar\\StrLang.g:21:9: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:22:7: ( 'if' )
            // src\\grammar\\StrLang.g:22:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:23:7: ( 'length' )
            // src\\grammar\\StrLang.g:23:9: 'length'
            {
            match("length"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:24:7: ( 'or' )
            // src\\grammar\\StrLang.g:24:9: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:25:7: ( 'print' )
            // src\\grammar\\StrLang.g:25:9: 'print'
            {
            match("print"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:26:7: ( 'return' )
            // src\\grammar\\StrLang.g:26:9: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:27:7: ( 'while' )
            // src\\grammar\\StrLang.g:27:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:28:7: ( '{' )
            // src\\grammar\\StrLang.g:28:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:29:7: ( '}' )
            // src\\grammar\\StrLang.g:29:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "LINE_TYPE"
    public final void mLINE_TYPE() throws RecognitionException {
        try {
            int _type = LINE_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:170:11: ( 'string' )
            // src\\grammar\\StrLang.g:170:12: 'string'
            {
            match("string"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_TYPE"

    // $ANTLR start "INT_TYPE"
    public final void mINT_TYPE() throws RecognitionException {
        try {
            int _type = INT_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:171:10: ( 'int' )
            // src\\grammar\\StrLang.g:171:11: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT_TYPE"

    // $ANTLR start "SYMBOL_TYPE"
    public final void mSYMBOL_TYPE() throws RecognitionException {
        try {
            int _type = SYMBOL_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:172:13: ( 'char' )
            // src\\grammar\\StrLang.g:172:14: 'char'
            {
            match("char"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SYMBOL_TYPE"

    // $ANTLR start "VOID_TYPE"
    public final void mVOID_TYPE() throws RecognitionException {
        try {
            int _type = VOID_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:173:11: ( 'void' )
            // src\\grammar\\StrLang.g:173:12: 'void'
            {
            match("void"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VOID_TYPE"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:177:2: ( ( '0' .. '9' )+ )
            // src\\grammar\\StrLang.g:177:4: ( '0' .. '9' )+
            {
            // src\\grammar\\StrLang.g:177:4: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "END_LINE"
    public final void mEND_LINE() throws RecognitionException {
        try {
            int _type = END_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:181:2: ( '\\'~\\'' )
            // src\\grammar\\StrLang.g:181:5: '\\'~\\''
            {
            match("'~'"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END_LINE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:185:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '\"' | ':' | '\\\\' | '.' )+ )
            // src\\grammar\\StrLang.g:185:4: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '\"' | ':' | '\\\\' | '.' )+
            {
            // src\\grammar\\StrLang.g:185:4: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '\"' | ':' | '\\\\' | '.' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\"'||LA2_0=='.'||(LA2_0 >= '0' && LA2_0 <= ':')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='\\'||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:
            	    {
            	    if ( input.LA(1)=='\"'||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "SYMBOL"
    public final void mSYMBOL() throws RecognitionException {
        try {
            int _type = SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:189:2: ( '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' ) '\\'' )
            // src\\grammar\\StrLang.g:189:4: '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' ) '\\''
            {
            match('\''); 

            if ( input.LA(1)==' '||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SYMBOL"

    // $ANTLR start "LINE"
    public final void mLINE() throws RecognitionException {
        try {
            int _type = LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:193:2: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | ' ' | '_' )* '\"' )
            // src\\grammar\\StrLang.g:193:3: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | ' ' | '_' )* '\"'
            {
            match('\"'); 

            // src\\grammar\\StrLang.g:193:7: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | ' ' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==' '||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src\\grammar\\StrLang.g:
            	    {
            	    if ( input.LA(1)==' '||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE"

    // $ANTLR start "DOUBLE_PLUS"
    public final void mDOUBLE_PLUS() throws RecognitionException {
        try {
            int _type = DOUBLE_PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:198:2: ( '++' )
            // src\\grammar\\StrLang.g:198:4: '++'
            {
            match("++"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE_PLUS"

    // $ANTLR start "ASSIGN_OP"
    public final void mASSIGN_OP() throws RecognitionException {
        try {
            int _type = ASSIGN_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:202:2: ( '=' )
            // src\\grammar\\StrLang.g:202:4: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN_OP"

    // $ANTLR start "DOUBLE_MINUS"
    public final void mDOUBLE_MINUS() throws RecognitionException {
        try {
            int _type = DOUBLE_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:206:2: ( '--' )
            // src\\grammar\\StrLang.g:206:4: '--'
            {
            match("--"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE_MINUS"

    // $ANTLR start "PLUS_OP"
    public final void mPLUS_OP() throws RecognitionException {
        try {
            int _type = PLUS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:210:2: ( '+' )
            // src\\grammar\\StrLang.g:210:4: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS_OP"

    // $ANTLR start "MINUS_OP"
    public final void mMINUS_OP() throws RecognitionException {
        try {
            int _type = MINUS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:213:9: ( '-' )
            // src\\grammar\\StrLang.g:213:11: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS_OP"

    // $ANTLR start "LESS_OP"
    public final void mLESS_OP() throws RecognitionException {
        try {
            int _type = LESS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:216:9: ( '<' )
            // src\\grammar\\StrLang.g:216:11: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESS_OP"

    // $ANTLR start "MORE_OP"
    public final void mMORE_OP() throws RecognitionException {
        try {
            int _type = MORE_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:219:9: ( '>' )
            // src\\grammar\\StrLang.g:219:11: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MORE_OP"

    // $ANTLR start "LESS_EQL_OP"
    public final void mLESS_EQL_OP() throws RecognitionException {
        try {
            int _type = LESS_EQL_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:223:2: ( '<=' )
            // src\\grammar\\StrLang.g:223:4: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESS_EQL_OP"

    // $ANTLR start "MORE_EQL_OP"
    public final void mMORE_EQL_OP() throws RecognitionException {
        try {
            int _type = MORE_EQL_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:227:2: ( '>=' )
            // src\\grammar\\StrLang.g:227:4: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MORE_EQL_OP"

    // $ANTLR start "EQUALLY_EQL_OP"
    public final void mEQUALLY_EQL_OP() throws RecognitionException {
        try {
            int _type = EQUALLY_EQL_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:231:2: ( '==' )
            // src\\grammar\\StrLang.g:231:4: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUALLY_EQL_OP"

    // $ANTLR start "NO_EQUALLY"
    public final void mNO_EQUALLY() throws RecognitionException {
        try {
            int _type = NO_EQUALLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:235:2: ( '!=' )
            // src\\grammar\\StrLang.g:235:4: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NO_EQUALLY"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:239:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='/') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='/') ) {
                    alt7=1;
                }
                else if ( (LA7_1=='*') ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // src\\grammar\\StrLang.g:239:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // src\\grammar\\StrLang.g:239:14: (~ ( '\\n' | '\\r' ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // src\\grammar\\StrLang.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    // src\\grammar\\StrLang.g:239:28: ( '\\r' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='\r') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src\\grammar\\StrLang.g:239:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // src\\grammar\\StrLang.g:240:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // src\\grammar\\StrLang.g:240:14: ( options {greedy=false; } : . )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='*') ) {
                            int LA6_1 = input.LA(2);

                            if ( (LA6_1=='/') ) {
                                alt6=2;
                            }
                            else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '.')||(LA6_1 >= '0' && LA6_1 <= '\uFFFF')) ) {
                                alt6=1;
                            }


                        }
                        else if ( ((LA6_0 >= '\u0000' && LA6_0 <= ')')||(LA6_0 >= '+' && LA6_0 <= '\uFFFF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // src\\grammar\\StrLang.g:240:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\grammar\\StrLang.g:243:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // src\\grammar\\StrLang.g:243:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // src\\grammar\\StrLang.g:1:8: ( T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | LINE_TYPE | INT_TYPE | SYMBOL_TYPE | VOID_TYPE | INT | END_LINE | ID | SYMBOL | LINE | DOUBLE_PLUS | ASSIGN_OP | DOUBLE_MINUS | PLUS_OP | MINUS_OP | LESS_OP | MORE_OP | LESS_EQL_OP | MORE_EQL_OP | EQUALLY_EQL_OP | NO_EQUALLY | COMMENT | WS )
        int alt8=41;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // src\\grammar\\StrLang.g:1:10: T__26
                {
                mT__26(); 


                }
                break;
            case 2 :
                // src\\grammar\\StrLang.g:1:16: T__27
                {
                mT__27(); 


                }
                break;
            case 3 :
                // src\\grammar\\StrLang.g:1:22: T__28
                {
                mT__28(); 


                }
                break;
            case 4 :
                // src\\grammar\\StrLang.g:1:28: T__29
                {
                mT__29(); 


                }
                break;
            case 5 :
                // src\\grammar\\StrLang.g:1:34: T__30
                {
                mT__30(); 


                }
                break;
            case 6 :
                // src\\grammar\\StrLang.g:1:40: T__31
                {
                mT__31(); 


                }
                break;
            case 7 :
                // src\\grammar\\StrLang.g:1:46: T__32
                {
                mT__32(); 


                }
                break;
            case 8 :
                // src\\grammar\\StrLang.g:1:52: T__33
                {
                mT__33(); 


                }
                break;
            case 9 :
                // src\\grammar\\StrLang.g:1:58: T__34
                {
                mT__34(); 


                }
                break;
            case 10 :
                // src\\grammar\\StrLang.g:1:64: T__35
                {
                mT__35(); 


                }
                break;
            case 11 :
                // src\\grammar\\StrLang.g:1:70: T__36
                {
                mT__36(); 


                }
                break;
            case 12 :
                // src\\grammar\\StrLang.g:1:76: T__37
                {
                mT__37(); 


                }
                break;
            case 13 :
                // src\\grammar\\StrLang.g:1:82: T__38
                {
                mT__38(); 


                }
                break;
            case 14 :
                // src\\grammar\\StrLang.g:1:88: T__39
                {
                mT__39(); 


                }
                break;
            case 15 :
                // src\\grammar\\StrLang.g:1:94: T__40
                {
                mT__40(); 


                }
                break;
            case 16 :
                // src\\grammar\\StrLang.g:1:100: T__41
                {
                mT__41(); 


                }
                break;
            case 17 :
                // src\\grammar\\StrLang.g:1:106: T__42
                {
                mT__42(); 


                }
                break;
            case 18 :
                // src\\grammar\\StrLang.g:1:112: T__43
                {
                mT__43(); 


                }
                break;
            case 19 :
                // src\\grammar\\StrLang.g:1:118: T__44
                {
                mT__44(); 


                }
                break;
            case 20 :
                // src\\grammar\\StrLang.g:1:124: LINE_TYPE
                {
                mLINE_TYPE(); 


                }
                break;
            case 21 :
                // src\\grammar\\StrLang.g:1:134: INT_TYPE
                {
                mINT_TYPE(); 


                }
                break;
            case 22 :
                // src\\grammar\\StrLang.g:1:143: SYMBOL_TYPE
                {
                mSYMBOL_TYPE(); 


                }
                break;
            case 23 :
                // src\\grammar\\StrLang.g:1:155: VOID_TYPE
                {
                mVOID_TYPE(); 


                }
                break;
            case 24 :
                // src\\grammar\\StrLang.g:1:165: INT
                {
                mINT(); 


                }
                break;
            case 25 :
                // src\\grammar\\StrLang.g:1:169: END_LINE
                {
                mEND_LINE(); 


                }
                break;
            case 26 :
                // src\\grammar\\StrLang.g:1:178: ID
                {
                mID(); 


                }
                break;
            case 27 :
                // src\\grammar\\StrLang.g:1:181: SYMBOL
                {
                mSYMBOL(); 


                }
                break;
            case 28 :
                // src\\grammar\\StrLang.g:1:188: LINE
                {
                mLINE(); 


                }
                break;
            case 29 :
                // src\\grammar\\StrLang.g:1:193: DOUBLE_PLUS
                {
                mDOUBLE_PLUS(); 


                }
                break;
            case 30 :
                // src\\grammar\\StrLang.g:1:205: ASSIGN_OP
                {
                mASSIGN_OP(); 


                }
                break;
            case 31 :
                // src\\grammar\\StrLang.g:1:215: DOUBLE_MINUS
                {
                mDOUBLE_MINUS(); 


                }
                break;
            case 32 :
                // src\\grammar\\StrLang.g:1:228: PLUS_OP
                {
                mPLUS_OP(); 


                }
                break;
            case 33 :
                // src\\grammar\\StrLang.g:1:236: MINUS_OP
                {
                mMINUS_OP(); 


                }
                break;
            case 34 :
                // src\\grammar\\StrLang.g:1:245: LESS_OP
                {
                mLESS_OP(); 


                }
                break;
            case 35 :
                // src\\grammar\\StrLang.g:1:253: MORE_OP
                {
                mMORE_OP(); 


                }
                break;
            case 36 :
                // src\\grammar\\StrLang.g:1:261: LESS_EQL_OP
                {
                mLESS_EQL_OP(); 


                }
                break;
            case 37 :
                // src\\grammar\\StrLang.g:1:273: MORE_EQL_OP
                {
                mMORE_EQL_OP(); 


                }
                break;
            case 38 :
                // src\\grammar\\StrLang.g:1:285: EQUALLY_EQL_OP
                {
                mEQUALLY_EQL_OP(); 


                }
                break;
            case 39 :
                // src\\grammar\\StrLang.g:1:300: NO_EQUALLY
                {
                mNO_EQUALLY(); 


                }
                break;
            case 40 :
                // src\\grammar\\StrLang.g:1:311: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 41 :
                // src\\grammar\\StrLang.g:1:319: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\5\uffff\14\31\2\uffff\3\31\1\62\1\uffff\1\31\1\uffff\1\71\1\73"+
        "\1\75\1\77\1\101\3\uffff\6\31\1\111\2\31\1\114\6\31\3\uffff\1\31"+
        "\14\uffff\2\31\1\125\3\31\1\131\1\uffff\1\132\1\31\1\uffff\10\31"+
        "\1\uffff\1\31\1\145\1\146\2\uffff\5\31\1\154\1\155\2\31\1\160\2"+
        "\uffff\1\31\1\162\1\31\1\164\1\31\2\uffff\2\31\1\uffff\1\170\1\uffff"+
        "\1\171\1\uffff\1\172\2\31\3\uffff\1\175\1\31\1\uffff\2\31\1\u0081"+
        "\1\uffff";
    static final String DFA8_eofS =
        "\u0082\uffff";
    static final String DFA8_minS =
        "\1\11\4\uffff\1\145\1\162\1\156\1\162\1\154\1\157\1\146\1\145\2"+
        "\162\1\145\1\150\2\uffff\1\164\1\150\1\157\1\42\2\40\1\uffff\1\53"+
        "\1\75\1\55\2\75\3\uffff\1\141\1\151\1\144\2\145\1\162\1\42\1\164"+
        "\1\156\1\42\1\151\1\164\1\151\1\162\1\141\1\151\3\uffff\1\40\14"+
        "\uffff\1\144\1\164\1\42\1\141\1\155\1\145\1\42\1\uffff\1\42\1\147"+
        "\1\uffff\1\156\1\165\1\154\1\151\1\162\1\144\1\106\1\145\1\uffff"+
        "\1\153\2\42\2\uffff\2\164\1\162\1\145\1\156\2\42\1\151\1\124\1\42"+
        "\2\uffff\1\150\1\42\1\156\1\42\1\147\2\uffff\1\154\1\157\1\uffff"+
        "\1\42\1\uffff\1\42\1\uffff\1\42\1\145\1\106\3\uffff\1\42\1\151\1"+
        "\uffff\1\154\1\145\1\42\1\uffff";
    static final String DFA8_maxS =
        "\1\175\4\uffff\1\145\1\162\1\156\1\162\1\154\1\157\1\156\1\145\2"+
        "\162\1\145\1\150\2\uffff\1\164\1\150\1\157\1\172\1\176\1\172\1\uffff"+
        "\1\53\1\75\1\55\2\75\3\uffff\1\141\1\151\1\144\1\145\1\163\1\162"+
        "\1\172\1\164\1\156\1\172\1\151\1\164\1\151\1\162\1\141\1\151\3\uffff"+
        "\1\172\14\uffff\1\144\1\164\1\172\1\141\1\155\1\145\1\172\1\uffff"+
        "\1\172\1\147\1\uffff\1\156\1\165\1\154\1\151\1\162\1\144\1\106\1"+
        "\145\1\uffff\1\153\2\172\2\uffff\2\164\1\162\1\145\1\156\2\172\1"+
        "\151\1\124\1\172\2\uffff\1\150\1\172\1\156\1\172\1\147\2\uffff\1"+
        "\154\1\157\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\1\145\1\106"+
        "\3\uffff\1\172\1\151\1\uffff\1\154\1\145\1\172\1\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\14\uffff\1\22\1\23\6\uffff\1\32\5\uffff"+
        "\1\47\1\50\1\51\20\uffff\1\30\1\31\1\33\1\uffff\1\32\1\34\1\35\1"+
        "\40\1\46\1\36\1\37\1\41\1\44\1\42\1\45\1\43\7\uffff\1\14\2\uffff"+
        "\1\16\10\uffff\1\7\3\uffff\1\13\1\25\12\uffff\1\11\1\12\5\uffff"+
        "\1\26\1\27\2\uffff\1\10\1\uffff\1\17\1\uffff\1\21\3\uffff\1\15\1"+
        "\20\1\24\2\uffff\1\5\3\uffff\1\6";
    static final String DFA8_specialS =
        "\u0082\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\41\2\uffff\1\41\22\uffff\1\41\1\37\1\30\4\uffff\1\27\1\1"+
            "\1\2\1\uffff\1\32\1\3\1\34\1\31\1\40\12\26\1\31\1\4\1\35\1\33"+
            "\1\36\2\uffff\21\31\1\5\4\31\1\6\3\31\1\uffff\1\31\2\uffff\1"+
            "\31\1\uffff\1\7\1\10\1\24\1\31\1\11\1\12\2\31\1\13\2\31\1\14"+
            "\2\31\1\15\1\16\1\31\1\17\1\23\2\31\1\25\1\20\3\31\1\21\1\uffff"+
            "\1\22",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50\7\uffff\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "",
            "",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\31\13\uffff\1\31\1\uffff\12\26\1\31\6\uffff\32\31\1\uffff"+
            "\1\31\2\uffff\1\31\1\uffff\32\31",
            "\1\64\15\uffff\1\64\1\uffff\12\64\7\uffff\32\64\4\uffff\1\64"+
            "\1\uffff\32\64\3\uffff\1\63",
            "\1\67\1\uffff\1\66\15\uffff\12\65\7\uffff\32\65\4\uffff\1\65"+
            "\1\uffff\32\65",
            "",
            "\1\70",
            "\1\72",
            "\1\74",
            "\1\76",
            "\1\100",
            "",
            "",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106\15\uffff\1\107",
            "\1\110",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\112",
            "\1\113",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "",
            "",
            "\1\67\1\uffff\1\66\15\uffff\12\65\7\uffff\32\65\4\uffff\1\65"+
            "\1\uffff\32\65",
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
            "",
            "\1\123",
            "\1\124",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\133",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "",
            "\1\144",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\156",
            "\1\157",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "\1\161",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\163",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\165",
            "",
            "",
            "\1\166",
            "\1\167",
            "",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\173",
            "\1\174",
            "",
            "",
            "",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            "\1\176",
            "",
            "\1\177",
            "\1\u0080",
            "\1\31\13\uffff\1\31\1\uffff\13\31\6\uffff\32\31\1\uffff\1\31"+
            "\2\uffff\1\31\1\uffff\32\31",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | LINE_TYPE | INT_TYPE | SYMBOL_TYPE | VOID_TYPE | INT | END_LINE | ID | SYMBOL | LINE | DOUBLE_PLUS | ASSIGN_OP | DOUBLE_MINUS | PLUS_OP | MINUS_OP | LESS_OP | MORE_OP | LESS_EQL_OP | MORE_EQL_OP | EQUALLY_EQL_OP | NO_EQUALLY | COMMENT | WS );";
        }
    }
 

}