package textDB;

import java.lang.reflect.*;
import java.util.*;
import java.lang.Class;

public class Notepad {

	public static <T> List<T> Select(Class<T> c) {
		List<T> records = new ArrayList<T>();

		try {

			Create.InitFile(c);

			List<String[]> rawRecords = Read.ReadData(c);

			Field[] propertyInfos = c.getFields();

			if (rawRecords.size() <= 0 || propertyInfos.length != rawRecords.get(0).length) {
				return records;
			}
			for (int i = 0; i < rawRecords.size(); i++) {
				String[] rawData = rawRecords.get(i);
				int index = 0;
				T data = c.newInstance();

				for (int j = 0; j < propertyInfos.length; j++) {
					Field propertyInfo = propertyInfos[j];
					if (propertyInfo.getType() == int.class) {
						propertyInfo.set(data, Integer.parseInt(rawData[index++]));
					} else if (propertyInfo.getType() == boolean.class) {
						propertyInfo.set(data, Boolean.parseBoolean(rawData[index++]));
					} else if (propertyInfo.getType() == float.class) {
						propertyInfo.set(data, Float.parseFloat(rawData[index++]));
					} else if (propertyInfo.getType() == long.class) {
						propertyInfo.set(data, Long.parseLong(rawData[index++]));
					} else if (propertyInfo.getType() == double.class) {
						propertyInfo.set(data, Double.parseDouble(rawData[index++]));
					} else if (propertyInfo.getType() == short.class) {
						propertyInfo.set(data, Short.parseShort(rawData[index++]));
					} else if (propertyInfo.getType() == String.class) {
						propertyInfo.set(data, rawData[index++]);
					}

				}
				records.add(data);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return records;
	}

	public static <T> void InsertValue(T entity) {
		try {

			Class<?> entityType = entity.getClass();

			Create.InitFile(entityType);

			Field[] propertyInfos = entityType.getFields();

			int j = 0;
			String[] row = new String[propertyInfos.length];
			for (int i = 0; i < propertyInfos.length; i++) {
				Field propertyInfo = propertyInfos[i];
				row[j++] = propertyInfo.get(entity).toString();
			}

			Write.WriteData(entityType, row);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static <T> void Delete(T entity)
    {
		try {
			
			Class<? extends Object> entityType = entity.getClass();
	        List<? extends Object> deleteList = Select(entityType);
	        Delete.DeleteFile(entityType);
	        
	        Field[] pinfo = entityType.getFields();
	        for(int i=0;i<deleteList.size();i++) {
	        	Object newT = deleteList.get(i);
	        	boolean add = false;
	        	for(int j=0;j<pinfo.length;j++) {
	        		Field pi = pinfo[j];
	        		if (!pi.get(newT).equals(pi.get(entity)))
	                {
	                    add = true;
	                    break;
	                }
	        	}
	            if (add)
	            {
	                InsertValue(newT);
	            }
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}
