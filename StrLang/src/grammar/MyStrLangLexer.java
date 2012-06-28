// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g 2012-06-27 03:02:53

    package grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MyStrLangLexer extends Lexer {
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

    public MyStrLangLexer() {;} 
    public MyStrLangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MyStrLangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:11:7: ( 'main' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:11:9: 'main'
            {
            match("main"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:12:7: ( '{' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:12:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:13:7: ( '}' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:13:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:14:7: ( ';' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:14:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:15:7: ( '(' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:16:7: ( ')' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:16:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:17:7: ( ',' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:17:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:18:7: ( 'delegate' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:18:9: 'delegate'
            {
            match("delegate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:19:7: ( '=' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:19:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:20:7: ( '+' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:20:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:21:7: ( '-' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:21:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:22:7: ( '*' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:22:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:23:7: ( '/' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:23:9: '/'
            {
            match('/'); 

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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:24:7: ( '^' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:24:9: '^'
            {
            match('^'); 

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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:25:7: ( 'write' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:25:9: 'write'
            {
            match("write"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:26:7: ( 'read' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:26:9: 'read'
            {
            match("read"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:27:7: ( 'if' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:27:9: 'if'
            {
            match("if"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:28:7: ( 'else' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:28:9: 'else'
            {
            match("else"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:29:7: ( 'for' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:29:9: 'for'
            {
            match("for"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:30:7: ( 'while' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:30:9: 'while'
            {
            match("while"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:31:7: ( 'return' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:31:9: 'return'
            {
            match("return"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:32:7: ( 'length' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:32:9: 'length'
            {
            match("length"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:33:7: ( 'elem' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:33:9: 'elem'
            {
            match("elem"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:34:7: ( 'ToString' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:34:9: 'ToString'
            {
            match("ToString"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:35:7: ( '||' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:35:9: '||'
            {
            match("||"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:36:7: ( '&&' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:36:9: '&&'
            {
            match("&&"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:37:7: ( '!' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:37:9: '!'
            {
            match('!'); 

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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:38:7: ( '<' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:38:9: '<'
            {
            match('<'); 

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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:39:7: ( '>' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:39:9: '>'
            {
            match('>'); 

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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:40:7: ( '==' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:40:9: '=='
            {
            match("=="); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:41:7: ( '!=' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:41:9: '!='
            {
            match("!="); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:42:7: ( '>=' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:42:9: '>='
            {
            match(">="); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:43:7: ( '<=' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:43:9: '<='
            {
            match("<="); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:44:7: ( 'equals' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:44:9: 'equals'
            {
            match("equals"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:45:7: ( 'contains' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:45:9: 'contains'
            {
            match("contains"); 


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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:46:7: ( 'indexOf' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:46:9: 'indexOf'
            {
            match("indexOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:47:7: ( 'replace' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:47:9: 'replace'
            {
            match("replace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:48:7: ( 'replaceFirst' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:48:9: 'replaceFirst'
            {
            match("replaceFirst"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:49:7: ( 'subString' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:49:9: 'subString'
            {
            match("subString"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:50:7: ( 'int' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:50:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:51:7: ( 'string' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:51:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:52:7: ( 'char' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:52:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:53:7: ( 'void' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:53:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:54:7: ( '[' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:54:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:55:7: ( ':' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:55:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:56:7: ( ']' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:56:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1535:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1535:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1535:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:
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
            	    break loop1;
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

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1541:5: ( ( '-' )? ( '0' .. '9' )+ )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1541:7: ( '-' )? ( '0' .. '9' )+
            {
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1541:7: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1541:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1541:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1541:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1547:6: ( '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\\\n' ) '\\'' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1547:8: '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\\\n' ) '\\''
            {
            match('\''); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1547:13: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\\\n' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt4=1;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                {
                alt4=2;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt4=3;
                }
                break;
            case '\\':
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1547:14: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1547:25: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }
                    break;
                case 3 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1547:36: '0' .. '9'
                    {
                    matchRange('0','9'); 

                    }
                    break;
                case 4 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1547:45: '\\\\n'
                    {
                    match("\\n"); 


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1553:8: ( '\"' (~ '\"' )* '\"' )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1553:10: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1553:14: (~ '\"' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1553:14: ~ '\"'
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
            	    break loop5;
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
    // $ANTLR end "STRING"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1558:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='/') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='/') ) {
                    alt9=1;
                }
                else if ( (LA9_1=='*') ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1558:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1558:14: (~ ( '\\n' | '\\r' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1558:14: ~ ( '\\n' | '\\r' )
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
                    	    break loop6;
                        }
                    } while (true);

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1558:28: ( '\\r' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\r') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1558:28: '\\r'
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
                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1559:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1559:14: ( options {greedy=false; } : . )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='*') ) {
                            int LA8_1 = input.LA(2);

                            if ( (LA8_1=='/') ) {
                                alt8=2;
                            }
                            else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                                alt8=1;
                            }


                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1559:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
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
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1562:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1562:9: ( ' ' | '\\t' | '\\r' | '\\n' )
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
        // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | ID | INT | CHAR | STRING | COMMENT | WS )
        int alt10=52;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:22: T__12
                {
                mT__12(); 

                }
                break;
            case 4 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:28: T__13
                {
                mT__13(); 

                }
                break;
            case 5 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:34: T__14
                {
                mT__14(); 

                }
                break;
            case 6 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:40: T__15
                {
                mT__15(); 

                }
                break;
            case 7 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:46: T__16
                {
                mT__16(); 

                }
                break;
            case 8 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:52: T__17
                {
                mT__17(); 

                }
                break;
            case 9 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:58: T__18
                {
                mT__18(); 

                }
                break;
            case 10 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:64: T__19
                {
                mT__19(); 

                }
                break;
            case 11 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:70: T__20
                {
                mT__20(); 

                }
                break;
            case 12 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:76: T__21
                {
                mT__21(); 

                }
                break;
            case 13 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:82: T__22
                {
                mT__22(); 

                }
                break;
            case 14 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:88: T__23
                {
                mT__23(); 

                }
                break;
            case 15 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:94: T__24
                {
                mT__24(); 

                }
                break;
            case 16 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:100: T__25
                {
                mT__25(); 

                }
                break;
            case 17 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:106: T__26
                {
                mT__26(); 

                }
                break;
            case 18 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:112: T__27
                {
                mT__27(); 

                }
                break;
            case 19 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:118: T__28
                {
                mT__28(); 

                }
                break;
            case 20 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:124: T__29
                {
                mT__29(); 

                }
                break;
            case 21 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:130: T__30
                {
                mT__30(); 

                }
                break;
            case 22 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:136: T__31
                {
                mT__31(); 

                }
                break;
            case 23 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:142: T__32
                {
                mT__32(); 

                }
                break;
            case 24 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:148: T__33
                {
                mT__33(); 

                }
                break;
            case 25 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:154: T__34
                {
                mT__34(); 

                }
                break;
            case 26 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:160: T__35
                {
                mT__35(); 

                }
                break;
            case 27 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:166: T__36
                {
                mT__36(); 

                }
                break;
            case 28 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:172: T__37
                {
                mT__37(); 

                }
                break;
            case 29 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:178: T__38
                {
                mT__38(); 

                }
                break;
            case 30 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:184: T__39
                {
                mT__39(); 

                }
                break;
            case 31 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:190: T__40
                {
                mT__40(); 

                }
                break;
            case 32 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:196: T__41
                {
                mT__41(); 

                }
                break;
            case 33 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:202: T__42
                {
                mT__42(); 

                }
                break;
            case 34 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:208: T__43
                {
                mT__43(); 

                }
                break;
            case 35 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:214: T__44
                {
                mT__44(); 

                }
                break;
            case 36 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:220: T__45
                {
                mT__45(); 

                }
                break;
            case 37 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:226: T__46
                {
                mT__46(); 

                }
                break;
            case 38 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:232: T__47
                {
                mT__47(); 

                }
                break;
            case 39 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:238: T__48
                {
                mT__48(); 

                }
                break;
            case 40 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:244: T__49
                {
                mT__49(); 

                }
                break;
            case 41 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:250: T__50
                {
                mT__50(); 

                }
                break;
            case 42 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:256: T__51
                {
                mT__51(); 

                }
                break;
            case 43 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:262: T__52
                {
                mT__52(); 

                }
                break;
            case 44 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:268: T__53
                {
                mT__53(); 

                }
                break;
            case 45 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:274: T__54
                {
                mT__54(); 

                }
                break;
            case 46 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:280: T__55
                {
                mT__55(); 

                }
                break;
            case 47 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:286: ID
                {
                mID(); 

                }
                break;
            case 48 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:289: INT
                {
                mINT(); 

                }
                break;
            case 49 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:293: CHAR
                {
                mCHAR(); 

                }
                break;
            case 50 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:298: STRING
                {
                mSTRING(); 

                }
                break;
            case 51 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:305: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 52 :
                // D:\\Projects\\Yapis\\StrLang\\src\\grammar\\MyStrLang.g:1:313: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\1\41\6\uffff\1\41\1\51\1\uffff\1\52\1\uffff\1\54\1\uffff"+
        "\7\41\2\uffff\1\70\1\72\1\74\3\41\10\uffff\2\41\5\uffff\3\41\1\111"+
        "\6\41\6\uffff\14\41\1\uffff\1\41\1\137\3\41\1\143\7\41\1\153\3\41"+
        "\1\157\3\41\1\uffff\1\163\1\164\1\41\1\uffff\3\41\1\171\2\41\1\174"+
        "\1\uffff\1\41\1\176\1\177\1\uffff\3\41\2\uffff\4\41\1\uffff\2\41"+
        "\1\uffff\1\41\2\uffff\1\u008a\2\41\1\u008d\1\u008e\3\41\1\u0092"+
        "\1\41\1\uffff\1\u0095\1\u0096\2\uffff\3\41\1\uffff\1\u009a\1\41"+
        "\2\uffff\1\u009c\1\u009d\1\41\1\uffff\1\41\2\uffff\1\u00a0\1\41"+
        "\1\uffff\1\41\1\u00a3\1\uffff";
    static final String DFA10_eofS =
        "\u00a4\uffff";
    static final String DFA10_minS =
        "\1\11\1\141\6\uffff\1\145\1\75\1\uffff\1\60\1\uffff\1\52\1\uffff"+
        "\1\150\1\145\1\146\1\154\1\157\1\145\1\157\2\uffff\3\75\1\150\1"+
        "\164\1\157\10\uffff\1\151\1\154\5\uffff\2\151\1\141\1\60\1\144\1"+
        "\145\1\165\1\162\1\156\1\123\6\uffff\1\156\1\141\1\142\1\162\1\151"+
        "\1\156\1\145\1\164\1\154\1\144\1\165\1\154\1\uffff\1\145\1\60\1"+
        "\145\1\155\1\141\1\60\1\147\2\164\1\162\1\123\1\151\1\144\1\60\1"+
        "\147\2\145\1\60\1\162\1\141\1\170\1\uffff\2\60\1\154\1\uffff\1\164"+
        "\1\162\1\141\1\60\1\164\1\156\1\60\1\uffff\1\141\2\60\1\uffff\1"+
        "\156\1\143\1\117\2\uffff\1\163\1\150\2\151\1\uffff\1\162\1\147\1"+
        "\uffff\1\164\2\uffff\1\60\1\145\1\146\2\60\2\156\1\151\1\60\1\145"+
        "\1\uffff\2\60\2\uffff\1\147\1\163\1\156\1\uffff\1\60\1\151\2\uffff"+
        "\2\60\1\147\1\uffff\1\162\2\uffff\1\60\1\163\1\uffff\1\164\1\60"+
        "\1\uffff";
    static final String DFA10_maxS =
        "\1\175\1\141\6\uffff\1\145\1\75\1\uffff\1\71\1\uffff\1\57\1\uffff"+
        "\1\162\1\145\1\156\1\161\1\157\1\145\1\157\2\uffff\3\75\1\157\1"+
        "\165\1\157\10\uffff\1\151\1\154\5\uffff\2\151\1\164\1\172\1\164"+
        "\1\163\1\165\1\162\1\156\1\123\6\uffff\1\156\1\141\1\142\1\162\1"+
        "\151\1\156\1\145\1\164\1\154\1\144\1\165\1\154\1\uffff\1\145\1\172"+
        "\1\145\1\155\1\141\1\172\1\147\2\164\1\162\1\123\1\151\1\144\1\172"+
        "\1\147\2\145\1\172\1\162\1\141\1\170\1\uffff\2\172\1\154\1\uffff"+
        "\1\164\1\162\1\141\1\172\1\164\1\156\1\172\1\uffff\1\141\2\172\1"+
        "\uffff\1\156\1\143\1\117\2\uffff\1\163\1\150\2\151\1\uffff\1\162"+
        "\1\147\1\uffff\1\164\2\uffff\1\172\1\145\1\146\2\172\2\156\1\151"+
        "\1\172\1\145\1\uffff\2\172\2\uffff\1\147\1\163\1\156\1\uffff\1\172"+
        "\1\151\2\uffff\2\172\1\147\1\uffff\1\162\2\uffff\1\172\1\163\1\uffff"+
        "\1\164\1\172\1\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\1\12\1\uffff\1\14\1\uffff"+
        "\1\16\7\uffff\1\31\1\32\6\uffff\1\54\1\55\1\56\1\57\1\60\1\61\1"+
        "\62\1\64\2\uffff\1\36\1\11\1\13\1\63\1\15\12\uffff\1\37\1\33\1\41"+
        "\1\34\1\40\1\35\14\uffff\1\21\25\uffff\1\50\3\uffff\1\23\7\uffff"+
        "\1\1\3\uffff\1\20\3\uffff\1\22\1\27\4\uffff\1\52\2\uffff\1\53\1"+
        "\uffff\1\17\1\24\12\uffff\1\25\2\uffff\1\42\1\26\3\uffff\1\51\2"+
        "\uffff\1\45\1\44\3\uffff\1\10\1\uffff\1\30\1\43\2\uffff\1\47\2\uffff"+
        "\1\46";
    static final String DFA10_specialS =
        "\u00a4\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\45\2\uffff\1\45\22\uffff\1\45\1\30\1\44\3\uffff\1\27\1\43"+
            "\1\5\1\6\1\14\1\12\1\7\1\13\1\uffff\1\15\12\42\1\37\1\4\1\31"+
            "\1\11\1\32\2\uffff\23\41\1\25\6\41\1\36\1\uffff\1\40\1\16\1"+
            "\41\1\uffff\2\41\1\33\1\10\1\22\1\23\2\41\1\21\2\41\1\24\1\1"+
            "\4\41\1\20\1\34\2\41\1\35\1\17\3\41\1\2\1\26\1\3",
            "\1\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "",
            "\12\42",
            "",
            "\1\53\4\uffff\1\53",
            "",
            "\1\56\11\uffff\1\55",
            "\1\57",
            "\1\60\7\uffff\1\61",
            "\1\62\4\uffff\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "",
            "\1\67",
            "\1\71",
            "\1\73",
            "\1\76\6\uffff\1\75",
            "\1\100\1\77",
            "\1\101",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\102",
            "\1\103",
            "",
            "",
            "",
            "",
            "",
            "\1\104",
            "\1\105",
            "\1\106\16\uffff\1\110\3\uffff\1\107",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\112\17\uffff\1\113",
            "\1\115\15\uffff\1\114",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "",
            "\1\136",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\140",
            "\1\141",
            "\1\142",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\154",
            "\1\155",
            "\1\156",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\165",
            "",
            "\1\166",
            "\1\167",
            "\1\170",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\172",
            "\1\173",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\1\175",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\u0088",
            "",
            "\1\u0089",
            "",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u008b",
            "\1\u008c",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u0093",
            "",
            "\12\41\7\uffff\5\41\1\u0094\24\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u009b",
            "",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u009e",
            "",
            "\1\u009f",
            "",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00a1",
            "",
            "\1\u00a2",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
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
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | ID | INT | CHAR | STRING | COMMENT | WS );";
        }
    }
 

}