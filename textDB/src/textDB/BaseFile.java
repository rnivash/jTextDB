package textDB;

import java.lang.Class;
import java.lang.reflect.*;

public class BaseFile {
	
	public static String GetFullName(Class<?> entityType) {
		
		return String.format("%s/%s.%d.db1","C:/test", entityType.getSimpleName(), GetId(entityType));
		
	}
	
	public static int GetId(Class<?> entityType) {
		
		Field[] fs = entityType.getFields();
		
		String allfields = entityType.getName();
		
		for(int i=0; i < fs.length; i++) {
			allfields += "|" + fs[i].getName();
		}
		
		return allfields.hashCode();
		
	}

}
