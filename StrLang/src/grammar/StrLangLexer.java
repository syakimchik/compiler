// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g 2012-05-11 03:14:37

	package grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StrLangLexer extends Lexer {
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

    public StrLangLexer() {;} 
    public StrLangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public StrLangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g"; }

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:11:7: ( 'main' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:11:9: 'main'
            {
            match("main"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:12:7: ( '{' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:12:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:13:7: ( '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:13:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:14:7: ( ',' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:14:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:15:7: ( '(' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:16:7: ( ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:16:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:17:7: ( 'string' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:17:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:18:7: ( 'int' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:18:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:19:7: ( 'char' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:19:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:20:7: ( 'void' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:20:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:21:7: ( 'WriteToFile' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:21:9: 'WriteToFile'
            {
            match("WriteToFile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:22:7: ( 'ReadFile' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:22:9: 'ReadFile'
            {
            match("ReadFile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:23:7: ( 'while' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:23:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:24:7: ( 'for' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:24:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:25:7: ( ';' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:25:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:26:7: ( 'print' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:26:9: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:27:7: ( 'length' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:27:9: 'length'
            {
            match("length"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:28:7: ( 'elem' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:28:9: 'elem'
            {
            match("elem"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:29:7: ( 'break' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:29:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:30:7: ( 'return' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:30:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:31:7: ( 'if' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:31:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:32:7: ( 'else' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:32:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:33:7: ( 'and' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:33:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:34:7: ( 'or' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:34:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:501:2: ( ( '0' .. '9' )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:501:4: ( '0' .. '9' )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:501:4: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:501:5: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "END_LINE"
    public final void mEND_LINE() throws RecognitionException {
        try {
            int _type = END_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:505:2: ( '\\'~\\'' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:505:5: '\\'~\\''
            {
            match("'~'"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_LINE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:509:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:509:4: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:509:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "SYMBOL"
    public final void mSYMBOL() throws RecognitionException {
        try {
            int _type = SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:513:2: ( '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' ) '\\'' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:513:4: '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' ) '\\''
            {
            match('\''); 
            if ( input.LA(1)==' '||input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SYMBOL"

    // $ANTLR start "LINE"
    public final void mLINE() throws RecognitionException {
        try {
            int _type = LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:517:2: ( '\"' (~ '\"' )* '\"' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:517:4: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:517:8: (~ '\"' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:517:8: ~ '\"'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
        }
    }
    // $ANTLR end "LINE"

    // $ANTLR start "DOUBLE_PLUS"
    public final void mDOUBLE_PLUS() throws RecognitionException {
        try {
            int _type = DOUBLE_PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:521:2: ( '++' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:521:4: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_PLUS"

    // $ANTLR start "ASSIGN_OP"
    public final void mASSIGN_OP() throws RecognitionException {
        try {
            int _type = ASSIGN_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:525:2: ( '=' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:525:4: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN_OP"

    // $ANTLR start "DOUBLE_MINUS"
    public final void mDOUBLE_MINUS() throws RecognitionException {
        try {
            int _type = DOUBLE_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:529:2: ( '--' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:529:4: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_MINUS"

    // $ANTLR start "PLUS_OP"
    public final void mPLUS_OP() throws RecognitionException {
        try {
            int _type = PLUS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:533:2: ( '+' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:533:4: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS_OP"

    // $ANTLR start "MINUS_OP"
    public final void mMINUS_OP() throws RecognitionException {
        try {
            int _type = MINUS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:536:9: ( '-' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:536:11: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS_OP"

    // $ANTLR start "LESS_OP"
    public final void mLESS_OP() throws RecognitionException {
        try {
            int _type = LESS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:539:9: ( '<' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:539:11: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_OP"

    // $ANTLR start "MORE_OP"
    public final void mMORE_OP() throws RecognitionException {
        try {
            int _type = MORE_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:542:9: ( '>' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:542:11: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MORE_OP"

    // $ANTLR start "LESS_EQL_OP"
    public final void mLESS_EQL_OP() throws RecognitionException {
        try {
            int _type = LESS_EQL_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:546:2: ( '<=' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:546:4: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_EQL_OP"

    // $ANTLR start "MORE_EQL_OP"
    public final void mMORE_EQL_OP() throws RecognitionException {
        try {
            int _type = MORE_EQL_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:550:2: ( '>=' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:550:4: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MORE_EQL_OP"

    // $ANTLR start "EQUALLY_EQL_OP"
    public final void mEQUALLY_EQL_OP() throws RecognitionException {
        try {
            int _type = EQUALLY_EQL_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:554:2: ( '==' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:554:4: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALLY_EQL_OP"

    // $ANTLR start "NO_EQUALLY"
    public final void mNO_EQUALLY() throws RecognitionException {
        try {
            int _type = NO_EQUALLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:558:2: ( '!=' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:558:4: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NO_EQUALLY"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:562:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:562:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:562:14: (~ ( '\\n' | '\\r' ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:562:14: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:562:28: ( '\\r' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='\r') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:562:28: '\\r'
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:563:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:563:14: ( options {greedy=false; } : . )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='*') ) {
                            int LA6_1 = input.LA(2);

                            if ( (LA6_1=='/') ) {
                                alt6=2;
                            }
                            else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                                alt6=1;
                            }


                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:563:42: .
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
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:566:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:566:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:8: ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | INT | END_LINE | ID | SYMBOL | LINE | DOUBLE_PLUS | ASSIGN_OP | DOUBLE_MINUS | PLUS_OP | MINUS_OP | LESS_OP | MORE_OP | LESS_EQL_OP | MORE_EQL_OP | EQUALLY_EQL_OP | NO_EQUALLY | COMMENT | WS )
        int alt8=42;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:10: T__22
                {
                mT__22(); 

                }
                break;
            case 2 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:16: T__23
                {
                mT__23(); 

                }
                break;
            case 3 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:22: T__24
                {
                mT__24(); 

                }
                break;
            case 4 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:28: T__25
                {
                mT__25(); 

                }
                break;
            case 5 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:34: T__26
                {
                mT__26(); 

                }
                break;
            case 6 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:40: T__27
                {
                mT__27(); 

                }
                break;
            case 7 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:46: T__28
                {
                mT__28(); 

                }
                break;
            case 8 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:52: T__29
                {
                mT__29(); 

                }
                break;
            case 9 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:58: T__30
                {
                mT__30(); 

                }
                break;
            case 10 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:64: T__31
                {
                mT__31(); 

                }
                break;
            case 11 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:70: T__32
                {
                mT__32(); 

                }
                break;
            case 12 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:76: T__33
                {
                mT__33(); 

                }
                break;
            case 13 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:82: T__34
                {
                mT__34(); 

                }
                break;
            case 14 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:88: T__35
                {
                mT__35(); 

                }
                break;
            case 15 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:94: T__36
                {
                mT__36(); 

                }
                break;
            case 16 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:100: T__37
                {
                mT__37(); 

                }
                break;
            case 17 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:106: T__38
                {
                mT__38(); 

                }
                break;
            case 18 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:112: T__39
                {
                mT__39(); 

                }
                break;
            case 19 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:118: T__40
                {
                mT__40(); 

                }
                break;
            case 20 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:124: T__41
                {
                mT__41(); 

                }
                break;
            case 21 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:130: T__42
                {
                mT__42(); 

                }
                break;
            case 22 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:136: T__43
                {
                mT__43(); 

                }
                break;
            case 23 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:142: T__44
                {
                mT__44(); 

                }
                break;
            case 24 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:148: T__45
                {
                mT__45(); 

                }
                break;
            case 25 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:154: INT
                {
                mINT(); 

                }
                break;
            case 26 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:158: END_LINE
                {
                mEND_LINE(); 

                }
                break;
            case 27 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:167: ID
                {
                mID(); 

                }
                break;
            case 28 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:170: SYMBOL
                {
                mSYMBOL(); 

                }
                break;
            case 29 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:177: LINE
                {
                mLINE(); 

                }
                break;
            case 30 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:182: DOUBLE_PLUS
                {
                mDOUBLE_PLUS(); 

                }
                break;
            case 31 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:194: ASSIGN_OP
                {
                mASSIGN_OP(); 

                }
                break;
            case 32 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:204: DOUBLE_MINUS
                {
                mDOUBLE_MINUS(); 

                }
                break;
            case 33 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:217: PLUS_OP
                {
                mPLUS_OP(); 

                }
                break;
            case 34 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:225: MINUS_OP
                {
                mMINUS_OP(); 

                }
                break;
            case 35 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:234: LESS_OP
                {
                mLESS_OP(); 

                }
                break;
            case 36 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:242: MORE_OP
                {
                mMORE_OP(); 

                }
                break;
            case 37 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:250: LESS_EQL_OP
                {
                mLESS_EQL_OP(); 

                }
                break;
            case 38 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:262: MORE_EQL_OP
                {
                mMORE_EQL_OP(); 

                }
                break;
            case 39 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:274: EQUALLY_EQL_OP
                {
                mEQUALLY_EQL_OP(); 

                }
                break;
            case 40 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:289: NO_EQUALLY
                {
                mNO_EQUALLY(); 

                }
                break;
            case 41 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:300: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 42 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\StrLang.g:1:308: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\1\31\5\uffff\10\31\1\uffff\7\31\4\uffff\1\67\1\71\1\73"+
        "\1\75\1\77\3\uffff\3\31\1\103\14\31\1\121\14\uffff\2\31\1\124\1"+
        "\uffff\5\31\1\132\6\31\1\141\1\uffff\1\142\1\31\1\uffff\1\144\1"+
        "\145\3\31\1\uffff\2\31\1\153\1\154\2\31\2\uffff\1\31\2\uffff\2\31"+
        "\1\162\1\163\1\31\2\uffff\1\165\1\31\1\167\2\31\2\uffff\1\172\1"+
        "\uffff\1\173\1\uffff\2\31\2\uffff\1\31\1\177\1\31\1\uffff\1\31\1"+
        "\u0082\1\uffff";
    static final String DFA8_eofS =
        "\u0083\uffff";
    static final String DFA8_minS =
        "\1\11\1\141\5\uffff\1\164\1\146\1\150\1\157\1\162\1\145\1\150\1"+
        "\157\1\uffff\1\162\1\145\1\154\1\162\1\145\1\156\1\162\1\uffff\1"+
        "\40\2\uffff\1\53\1\75\1\55\2\75\3\uffff\1\151\1\162\1\164\1\60\1"+
        "\141\2\151\1\141\1\151\1\162\1\151\1\156\2\145\1\164\1\144\1\60"+
        "\14\uffff\1\156\1\151\1\60\1\uffff\1\162\1\144\1\164\1\144\1\154"+
        "\1\60\1\156\1\147\1\155\1\145\1\141\1\165\1\60\1\uffff\1\60\1\156"+
        "\1\uffff\2\60\1\145\1\106\1\145\1\uffff\2\164\2\60\1\153\1\162\2"+
        "\uffff\1\147\2\uffff\1\124\1\151\2\60\1\150\2\uffff\1\60\1\156\1"+
        "\60\1\157\1\154\2\uffff\1\60\1\uffff\1\60\1\uffff\1\106\1\145\2"+
        "\uffff\1\151\1\60\1\154\1\uffff\1\145\1\60\1\uffff";
    static final String DFA8_maxS =
        "\1\175\1\141\5\uffff\1\164\1\156\1\150\1\157\1\162\1\145\1\150"+
        "\1\157\1\uffff\1\162\1\145\1\154\1\162\1\145\1\156\1\162\1\uffff"+
        "\1\176\2\uffff\1\53\1\75\1\55\2\75\3\uffff\1\151\1\162\1\164\1\172"+
        "\1\141\2\151\1\141\1\151\1\162\1\151\1\156\1\163\1\145\1\164\1\144"+
        "\1\172\14\uffff\1\156\1\151\1\172\1\uffff\1\162\1\144\1\164\1\144"+
        "\1\154\1\172\1\156\1\147\1\155\1\145\1\141\1\165\1\172\1\uffff\1"+
        "\172\1\156\1\uffff\2\172\1\145\1\106\1\145\1\uffff\2\164\2\172\1"+
        "\153\1\162\2\uffff\1\147\2\uffff\1\124\1\151\2\172\1\150\2\uffff"+
        "\1\172\1\156\1\172\1\157\1\154\2\uffff\1\172\1\uffff\1\172\1\uffff"+
        "\1\106\1\145\2\uffff\1\151\1\172\1\154\1\uffff\1\145\1\172\1\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\10\uffff\1\17\7\uffff\1\31\1\uffff"+
        "\1\33\1\35\5\uffff\1\50\1\51\1\52\21\uffff\1\32\1\34\1\36\1\41\1"+
        "\47\1\37\1\40\1\42\1\45\1\43\1\46\1\44\3\uffff\1\25\15\uffff\1\30"+
        "\2\uffff\1\10\5\uffff\1\16\6\uffff\1\27\1\1\1\uffff\1\11\1\12\5"+
        "\uffff\1\22\1\26\5\uffff\1\15\1\20\1\uffff\1\23\1\uffff\1\7\2\uffff"+
        "\1\21\1\24\3\uffff\1\14\2\uffff\1\13";
    static final String DFA8_specialS =
        "\u0083\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\42\2\uffff\1\42\22\uffff\1\42\1\40\1\32\4\uffff\1\30\1\5"+
            "\1\6\1\uffff\1\33\1\4\1\35\1\uffff\1\41\12\27\1\uffff\1\17\1"+
            "\36\1\34\1\37\2\uffff\21\31\1\14\4\31\1\13\3\31\4\uffff\1\31"+
            "\1\uffff\1\25\1\23\1\11\1\31\1\22\1\16\2\31\1\10\2\31\1\21\1"+
            "\1\1\31\1\26\1\20\1\31\1\24\1\7\2\31\1\12\1\15\3\31\1\2\1\uffff"+
            "\1\3",
            "\1\43",
            "",
            "",
            "",
            "",
            "",
            "\1\44",
            "\1\46\7\uffff\1\45",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "\1\65\15\uffff\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1"+
            "\65\1\uffff\32\65\3\uffff\1\64",
            "",
            "",
            "\1\66",
            "\1\70",
            "\1\72",
            "\1\74",
            "\1\76",
            "",
            "",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114\15\uffff\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
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
            "\1\122",
            "\1\123",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\143",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\146",
            "\1\147",
            "\1\150",
            "",
            "\1\151",
            "\1\152",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\155",
            "\1\156",
            "",
            "",
            "\1\157",
            "",
            "",
            "\1\160",
            "\1\161",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\164",
            "",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\166",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\170",
            "\1\171",
            "",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\1\174",
            "\1\175",
            "",
            "",
            "\1\176",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\u0080",
            "",
            "\1\u0081",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
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
            return "1:1: Tokens : ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | INT | END_LINE | ID | SYMBOL | LINE | DOUBLE_PLUS | ASSIGN_OP | DOUBLE_MINUS | PLUS_OP | MINUS_OP | LESS_OP | MORE_OP | LESS_EQL_OP | MORE_EQL_OP | EQUALLY_EQL_OP | NO_EQUALLY | COMMENT | WS );";
        }
    }
 

}