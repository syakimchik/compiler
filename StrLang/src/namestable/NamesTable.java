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
		private ArrayList<Integer> linesUses = new ArrayList<Integer>();
		
		public VariableName(String idft, String type, int line)
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
		
	private HashMap<String, VariableName> variableNames = new HashMap<String, VariableName>();
	private HashMap<String, FunctionName> functionNames = new HashMap<String, FunctionName>();
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
	
	
	
	public boolean checkReturnType(String funcName, String varName, String curBlock, int line)
	{
		
		if(curBlock.equals("main"))
		{
			errors.add("line "+line+": return statments in main function");
			return false;
		}
		
		if(!isExistFunction(funcName))
		{
			errors.add("line "+line+": function "+funcName+" doesn't exists");
			return false;
		}
		
		if(!isExistVariable(curBlock+"."+varName) && varName!=null && !varName.equals(""))
		{
			errors.add("line "+line+": variable "+varName+" doesn't exists");
			return false;
		}
		
		FunctionName func = getFunction(funcName);
		VariableName var = getVariable(curBlock+"."+varName);
		String funcReturnType = func.getReturnType();
		
		if(funcReturnType.equals("void"))
		{
			if(varName!=null)
			{
				errors.add("line "+line+": return type of "+funcName+" mismatch - need void, found "+var.getType());
				return false;
			}
		}
		else
		{
			if(varName==null)
			{
				errors.add("line "+line+": function "+funcName+" must return a value of type "+funcReturnType);
				return false;
			}
			else
			{
				String varType = var.getType();
				if(!varType.equals(funcReturnType))
				{
					errors.add("line "+line+": return type of "+funcName+" mismatch - need "+funcReturnType+", found "+varType);
					return false;
				}
			}
		}
		
		var.addLineUses(line);
		return true;
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
	
	/*public static void printValue(String f_avg, String s_avg)
	{
		//removing unnecessary characters
		if(f_avg.contains("\""))
			f_avg=f_avg.replace("\"", "");
		if(f_avg.contains("\'"))
			f_avg=f_avg.replace("\'", "");
		if(s_avg.contains("\""))
			s_avg=s_avg.replace("\"", "");
		if(s_avg.contains("\'"))
			s_avg=s_avg.replace("\'", "");
		System.out.print(f_avg);
		System.out.print(s_avg+"\n");
	}*/

}
