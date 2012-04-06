package grammar;

import java.io.*;
import org.antlr.runtime.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String templateFileName;
		int a = 0;
		if(args.length<=1)
			templateFileName = "first.txt";
		else
		{
			templateFileName = args[a];
			a++;
		}	
		
		StrLangLexer lexer = new StrLangLexer(new ANTLRFileStream(templateFileName));
		StrLangParser parser = new StrLangParser(new CommonTokenStream(lexer));
		parser.program();
		System.out.println("Compiled successfully");
		
	}

}
