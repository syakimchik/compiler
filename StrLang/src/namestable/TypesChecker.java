package namestable;

/**
 * 
 * @author Gudini
 *
 */

public class TypesChecker {
	
	public static boolean checkTypes(String firstType, String secondType)
	{
		if(firstType==null || secondType==null)
			return false;
		
		if(firstType.equals(secondType))
			return true;
		else
			return false;
	}
	
	public static String getSumResultType(String firstType, String secondType)
	{
		if(isInteger(firstType) && isInteger(secondType)){
			return Type.INTEGER;
		}
		else
		{
			if(isString(firstType) && isString(secondType))
				return Type.STRING;
			else
				return Type.ERROR;
		}
	}
	
	public static boolean isVoid(String type)
	{
		if(type==null)
			return false;
		if(type.equals(Type.VOID))
			return true;
		
		return false;
	}
	
	public static boolean isChar(String type)
	{
		if(type==null)
			return false;
		if(type.equals(Type.CHAR))
			return true;
		
		return false;
	}
	
	public static boolean isInteger(String type)
	{
		if(type==null)
			return false;
		if(type.equals(Type.INTEGER))
			return true;
		
		return false;
	}
	
	public static boolean isString(String type)
	{
		if(type==null)
			return false;
		if(type.equals(Type.STRING))
			return true;
		
		return false;
	}
}
