package namestable;

//import java.io.PrintStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class NamesTable {
	public class Name{
		private String idtf;
		private String type;
		private int lineDeclaration;
		private ArrayList<Integer> linesUses = new ArrayList<Integer>();
		
		public Name(String idft, String type, int line)
		{
			this.idtf = idft;
			this.type = type;
			lineDeclaration = line;
		}
		
		public void addLineUses(int line) {
			linesUses.add(new Integer(line));
		}
		public String toString() {
			return idtf + ", " + type + ", " + lineDeclaration + ", "
				+ ((linesUses.isEmpty())? "not uses" : linesUses);
		}
		public String getType() {
			return type;
		}
	}
		
		private HashMap<String, Name> names = new HashMap<String, Name>();

		public boolean isExist(String name) {
			boolean rv = names.containsKey(name);
			if (! rv) {
				rv = names.containsKey(name.substring(name.indexOf('.')));
			}
			return rv;
		}
		
		public void add(Name n)
		{
			names.put(n.idtf, n);
		}
		
		public Name get(String n)
		{
			Name _n = names.get(n);
			if(_n==null)
				_n = names.get(n.substring(n.indexOf('.')));
			return _n;
		}
		
		public void print(PrintStream out)
		{
			for(String idtf: names.keySet())
			{
				Name n = names.get(idtf);
				out.println(n);
			}
		}
		
		public class FunctionName{
			private String idtf;
			private String type;
			private String returnType;
			private int lineDeclaration;
			private ArrayList<Integer> linesUses = new ArrayList<Integer>();
			private ArrayList<String> paramType = new ArrayList<String>();
			
			public FunctionName(String _idtf, String _type, String _returnType, int _lineDeclaration)
			{
				idtf = _idtf;
				type = _type;
				returnType = _returnType;
				lineDeclaration = _lineDeclaration;
			}
			
			public void FunctionAddLineUse(int line)
			{
				linesUses.add(new Integer(line));
			}
			
			public String FunctionToString()
			{
				return idtf+", "+type+", "+lineDeclaration+", "+((linesUses.isEmpty())?"not uses":linesUses);
			}
			
			public String FunctionGetType()
			{
				return type;
			}
			
			public void FunctionAddParamType(String str)
			{
				paramType.add(new String(str));
			}
		}
		
		private HashMap<String, FunctionName> FunctionNames = new HashMap<String, FunctionName>();
		
		public boolean FunctionIsExist(String name)
		{
			boolean rv = FunctionNames.containsKey(name);
			if(!rv)
				rv = FunctionNames.containsKey(name.substring(name.indexOf('.')));
			return rv;
		}
		
		public void FunctionAdd(FunctionName n)
		{
			FunctionNames.put(n.idtf, n);
		}
		
		public FunctionName FunctionGet(String n)
		{
			FunctionName _n = FunctionNames.get(n);
			if(_n==null)
				_n = FunctionNames.get(n.substring(n.indexOf('.')));
			return _n;
		}
		
		public void FunctionPrint(PrintStream out)
		{
			for(String idtf: FunctionNames.keySet())
			{
				FunctionName n = FunctionNames.get(idtf);
				out.println(n.idtf);
			}
		}

}
