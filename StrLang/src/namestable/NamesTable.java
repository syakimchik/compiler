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
	
	public class MethodName{
		private String idtf;
		private String inputType;
		private String returnType;
		private ArrayList<String> argumentTypes;
		private ArrayList<Integer> linesUses = new ArrayList<Integer>();
		
		public MethodName(String _idtf, String _inputType, String _returnType, ArrayList<String> _argTypes)
		{
			idtf = _idtf;
			inputType = _inputType;
			returnType = _returnType;
			argumentTypes = _argTypes;
		}
		
		public void addLineUses(int line)
		{
			linesUses.add(new Integer(line));
		}
		
		public String toString()
		{
			return idtf+((linesUses.isEmpty())? "not uses":linesUses);
		}
		
		public String getReturnType()
		{
			return returnType;
		}
		
		public String getInputType()
		{
			return inputType;
		}
		
		public ArrayList<String> getArgumentTypes()
		{
			return argumentTypes;
		}
		
	}
		
	private HashMap<String, VariableName> variableNames = new HashMap<String, VariableName>();
	private HashMap<String, FunctionName> functionNames = new HashMap<String, FunctionName>();
	private HashMap<String, MethodName> methodNames = new HashMap<String, MethodName>();
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
		result = variableNames.containsKey(name);
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
	
	public boolean isExistMethod(String name)
	{
		boolean n = methodNames.containsKey(name); 
		return n;
	}
	
	/*public boolean isExistMethod(String curBlock, String idName, String methodName) {
		if(isExistVariable(curBlock+"."+idName))
		{
			String idType = getVariable(curBlock+"."+idName).getType();
			return methodNames.containsKey(idType+"."+methodName);
		}
		return methodNames.containsKey(idName);
	}*/
	
	public void addMethod(MethodName name)
	{
		methodNames.put(name.idtf, name);
	}
	
	public MethodName getMethod(String n)
	{
		return methodNames.get(n);
	}
	
	public void printMethod(PrintStream out)
	{
		for(String idtf: methodNames.keySet())
		{
			MethodName n = methodNames.get(idtf);
			out.println(n);
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
		
		//var.addLineUses(line);
		return true;
		
	}
	
	
	/*
	public MethodName getMethod(String curBlock, String idName, String methodName) {
		if(isExistVariable(curBlock+"."+idName)){
			String idType = getVariable(curBlock+"."+idName).getType();
			return methodNames.get(idType+"."+methodName);
		}
		return methodNames.get(methodName);
	}*/
	
	
	
	
	
	
	
	
	/*--------------------------------------------------------------------*/
	
	/*
	public boolean isExist(String name) {
		boolean rv = variableNames.containsKey(name);
		if (! rv) {
			rv = variableNames.containsKey(name.substring(name.indexOf('.')));
		}
		return rv;
	}
	
	public void add(VariableName n)
	{
		variableNames.put(n.idtf, n);
	}
	
	public VariableName get(String n)
	{
		VariableName _n = variableNames.get(n);
		if(_n==null)
			_n = variableNames.get(n.substring(n.indexOf('.')));
		return _n;
	}
	
	public void print(PrintStream out)
	{
		for(String idtf: variableNames.keySet())
		{
			VariableName n = variableNames.get(idtf);
			out.println(n);
		}
	}
	
	
	/*__________________________________________________________*/
	
	/*	public boolean FunctionIsExist(String name)
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
		*/

}
