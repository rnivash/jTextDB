package textDB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Delete {
	public static void DeleteFile(Class<?> entityType) {
		String tableFullName = BaseFile.GetFullName(entityType);
		Path file = Paths.get(tableFullName);
		try {
			Files.deleteIfExists(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
