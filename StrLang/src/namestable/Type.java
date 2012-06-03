package namestable;

import java.util.HashMap;
import java.util.Map;

/**
 * Type description.
 * @author Gudini
 *
 */

public class Type {
	public static final Map<String, String> jvmTypes = new HashMap<String, String>();

	public static final String INTEGER = "int";
	public static final String STRING = "string";
	public static final String CHAR = "char";
	public static final String VOID = "void";
	public static final String ERROR = "error";
	
	static{
		jvmTypes.put("int", "I");
		jvmTypes.put("string", "S");
		jvmTypes.put("char", "C");
		jvmTypes.put("void", "V");
	}
}
