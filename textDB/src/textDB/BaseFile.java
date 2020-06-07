package textDB;

import java.lang.Class;
import java.lang.reflect.*;

public class BaseFile {

	public static String DbExtension = ".db1";

	public static String CommaSeparator = "#comma#";

	public static String Comma = ",";

	public static String GetFullName(Class<?> entityType) {

		return String.format("%s\\%s.%d%s", Engine.getInstance().Config.FilePath, entityType.getSimpleName(),
				GetId(entityType), DbExtension);

	}

	public static int GetId(Class<?> entityType) {

		Field[] fs = entityType.getFields();

		String allfields = entityType.getName();

		for (int i = 0; i < fs.length; i++) {
			allfields += "|" + fs[i].getName();
		}

		return allfields.hashCode();

	}

	public static String[] Decode(String value) {
		String[] data = value.split(Comma);
		for (int i = 0; i < data.length; i++) {
			data[i] = data[i].replace(CommaSeparator, Comma);
		}
		return data;
	}

	public static String Encode(String[] values) {
		for (int i = 0; i < values.length; i++) {
			values[i] = values[i].replace(Comma, CommaSeparator);
		}
		return String.join(Comma, values);
	}

}
