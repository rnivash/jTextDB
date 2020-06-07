package textDB;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Write {
	
	public static void WriteData(Class<?> entityType, String[] values) {
		Charset charset = Charset.forName("US-ASCII");
		Path file = Paths.get(BaseFile.GetFullName(entityType));
		
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset, StandardOpenOption.APPEND)) {			
			String s = BaseFile.Encode(values);
			writer.write(s, 0, s.length());	
			writer.newLine();
		    
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}

	}

}
