package textDB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Create {
	
	public static void InitFile(Class<?> entityType) {
		String tableFullName = BaseFile.GetFullName(entityType);
		Path file = Paths.get(tableFullName);
		try {
			if(!Files.exists(file)) {
				Files.createFile(file);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
