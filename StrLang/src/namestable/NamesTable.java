package namestable;

/**
 * Description of the semantic analyzer
 * @author Gudini
 * 
 */

//import java.io.PrintStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @version 0.1.0
 * @author Gudini
 *
 */
public class NamesTable {
	
	/**
	 * Description of the table of the variable names
	 * @author Gudini
	 *
	 */
	public class VariableName{
		private String idtf;
		private String type;
		private int lineDeclaration;
		private int number;
		private ArrayList<Integer> linesUses = new ArrayList<Integer>();
		
		
		/**
		 * Construction sets the basic parameters that describe the variable
		 * @param idft - name of the new variable
		 * @param type - type of the new variable
		 * @param line - line in the code
		 */
		public VariableName(String idft, String type, int line)
		{
			this.idtf = idft;
			this.type = type;
			lineDeclaration = line;
		}
		
		/**
		 * Add line, where used variable
		 * @param line - line in the code
		 */
		public void addLineUses(int line) {
			linesUses.add(new Integer(line));
		}
		
		public String toString() {
			return idtf + ", " + type + ", " + lineDeclaration + ", "
				+ ((linesUses.isEmpty())? "not uses" : linesUses);
		}
		
		/**
		 * Returns the string value of the variable type
		 * @return - string, where contain type of variable
		 */
		public String getType() {
			return type;
		}
		
		public int getNumber()
		{
			return number;
		}
		
		public void setNumber(int number)
		{
			this.number = number;
		}
		
		public String getName()
		{
			String _name = idtf;
			if(_name.contains("global."))
			{
				int beginIndex = _name.indexOf(".");
				_name = _name.substring(beginIndex+1);
			}
			return _name;
		}
		
	}
		
	public class FunctionName{
		private String idtf;
		private String type;
		private int lineDeclaration;
		private ArrayList<Integer> linesUses = new ArrayList<Integer>();
		private ArrayList<String> argumentTypesList;
		private ArrayList<String> argumentNamesList;
		
		public FunctionName(String _idtf, String _type, ArrayList<String> _types, ArrayList<String> _names, int _lineDeclaration)
		{
			idtf = _idtf;
			type = _type;
			argumentNamesList = _names;
			argumentTypesList = _types;
			lineDeclaration = _lineDeclaration;
		}
		
		public void addLineUses(int line)
		{
			linesUses.add(new Integer(line));
		}
		
		public String toString()
		{
			return idtf+", "+type+", "+lineDeclaration+", "
					+((linesUses.isEmpty())?"not uses":linesUses);
		}
		
		public String getReturnType()
		{
			return type;
		}
		
		public ArrayList<String> getArgumentTypes()
		{
			return argumentTypesList;
		}
		
		public ArrayList<String> getArgumentNames()
		{
			return argumentNamesList;
		}
	}
	
	public class DelegateName{
		private String nameDelegate;
		private String nameFunc;
		private String type;
		private int lineDeclaration;
		private ArrayList<Integer> linesUses = new ArrayList<Integer>();
		private ArrayList<String> argumentTypesList;
		private ArrayList<String> argumentNamesList;
		
		public DelegateName(String _nameD, String _nameF, String _type, ArrayList<String> _types, ArrayList<String> _names, int _lineDeclaration)
		{
			nameDelegate = _nameD;
			nameFunc = _nameF;
			type = _type;
			argumentNamesList = _names;
			argumentTypesList = _types;
			lineDeclaration = _lineDeclaration;
		}
		
		public void addLineUses(int line)
		{
			linesUses.add(new Integer(line));
		}
		
		public String toString()
		{
			return nameFunc+", "+type+", "+lineDeclaration+", "
					+((linesUses.isEmpty())?"not uses":linesUses);
		}
		
		public String getReturnType()
		{
			return type;
		}
		
		public ArrayList<String> getArgumentTypes()
		{
			return argumentTypesList;
		}
		
		public ArrayList<String> getArgumentNames()
		{
			return argumentNamesList;
		}
		
		public String getNameDelegate()
		{
			return nameDelegate;
		}
		
		public String getNameFunction()
		{
			return nameFunc;
		}
	}
		
	private HashMap<String, VariableName> variableNames = new HashMap<String, VariableName>();
	private HashMap<String, FunctionName> functionNames = new HashMap<String, FunctionName>();
	private HashMap<String, DelegateName> delegateNames = new HashMap<String, DelegateName>();
	private Stack<String> errors = new Stack<String>();
	
	public String getLastError()
	{
		if(!errors.isEmpty())
			return errors.pop();
		else
			return "";
	}
	
	public boolean isExistVariable(String name)
	{
		boolean rv = variableNames.containsKey(name);
		if(!rv && name.indexOf(".")!=-1){
			rv = variableNames.containsKey("global"+name.substring(name.indexOf('.')));
			if(!rv)
			{
				rv = functionNames.containsKey(name.substring(name.indexOf('.')+1));
			}
		}
		return rv;
	}
	
	public boolean isDeclaredVariable(String name)
	{
		boolean result = false;
		VariableName _name= variableNames.get(name);
		if(_name==null)
		{
			if(name.indexOf('.')==-1)
				_name = variableNames.get("global."+name);
			else
				_name = variableNames.get("global"+name.substring(name.indexOf('.')));
			if(_name!=null)
				return true;
		}
		else
			result = true;
		return result;
	}
	
	public boolean isGlobal(String name)
	{
		boolean result = false;
		VariableName _name = variableNames.get(name);
		if(_name==null)
		{
			if(name.indexOf('.')==-1)
				_name = variableNames.get("global."+name);
			if(_name!=null)
				return true;
		}
		else
			result = true;
		return result;
	}
	
	public void addVariable(VariableName name)
	{
		variableNames.put(name.idtf, name);
	}
	
	public VariableName getVariable(String name)
	{
		VariableName _name = variableNames.get(name);
		if(_name==null)
		{
			if(name.indexOf('.')==-1)
				_name = variableNames.get("global."+name);
			else
				_name = variableNames.get("global"+name.substring(name.indexOf('.')));
		}
		return _name;
	}
	
	public void printVariable(PrintStream out)
	{
		for(String idtf: variableNames.keySet())
		{
			VariableName n = variableNames.get(idtf);
			out.println(n);
		}
	}
	
	public boolean isExistFunction(String name)
	{
		boolean rv = functionNames.containsKey(name);
		return rv;
	}
	
	public void addFunction(FunctionName name)
	{
		functionNames.put(name.idtf, name);
	}
	
	public FunctionName getFunction(String name)
	{
		FunctionName _name = functionNames.get(name);
		return _name;
	}
	
	public void printFunction(PrintStream out)
	{
		for(String idft : functionNames.keySet())
		{
			FunctionName name = functionNames.get(idft);
			out.println(name);
		}
	}
	
	public boolean checkCallFunction(String funcName, ArrayList<String> list, int line)
	{
		if(list==null)
			list = new ArrayList<String>();
		boolean result = true;
		if(!isExistFunction(funcName))
		{
			//errors.add("line "+line+": unknown function "+funcName);
			return false;
		}
		
		FunctionName func = functionNames.get(funcName);
		if(!func.getArgumentTypes().equals(list))
		{
			errors.add("line "+line+": incorrect argument types for function "+funcName+" need " + func.getArgumentTypes().toString() +" found "+ list.toString() );
			result = false;
		}
		return result;
	}
	
	public void getAllErrors(ArrayList<String> list)
	{
		while(!errors.isEmpty())
		{
			list.add(errors.pop());
		}
	}
	
	public boolean isExistDelegate(String name)
	{
		boolean rv = delegateNames.containsKey(name);
		return rv;
	}
	
	public void addDelegate(DelegateName name)
	{
		delegateNames.put(name.nameDelegate, name);
	}
	
	public DelegateName getDelegate(String name)
	{
		DelegateName _name = delegateNames.get(name);
		return _name;
	}
	
	public void printDelegate(PrintStream out)
	{
		for(String idft : delegateNames.keySet())
		{
			DelegateName name = delegateNames.get(idft);
			out.println(name);
		}
	}
}
