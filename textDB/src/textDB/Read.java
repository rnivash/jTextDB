package textDB;

import java.util.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

public class Read {
	
	public static ArrayList<String[]> ReadData(Class<?> entityType) {
		
		
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		Path file = Paths.get(BaseFile.GetFullName(entityType));
		
		Charset charset = Charset.forName("US-ASCII");
		
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			
		    String line = null;
		    
		    while ((line = reader.readLine()) != null) {
		        String[] row = BaseFile.Decode(line);
		        result.add(row);
		    }
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return result;
	}

}
