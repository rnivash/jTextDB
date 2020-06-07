package textDB.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import textDB.BaseFile;
import textDB.Model.Student;

class BaseFileTests {

	@Test
	void Should_generate_file_path() {		
		
		String filePath = BaseFile.GetFullName(Student.class);
		
		assertEquals(true, filePath.contains("Student.-1975158926.db1"));
		
	}
	
	@Test
	void Should_generate_hash_code_from_type() {		
		
		int fileId = BaseFile.GetId(Student.class);
		
		assertEquals(-1975158926, fileId);		
	}
	
	@Test
	void Should_encode_file_content() {		
		
		String[] rowData = new String[] {"Test", "24", "45", "Apple,Orange"};
		String encodeString = BaseFile.Encode(rowData);
		
		assertEquals("Test,24,45,Apple#comma#Orange", encodeString);		
	}
	
	@Test
	void Should_decode_file_content() {		
		
		String[] rowData = BaseFile.Decode("Test,24,45,Apple#comma#Orange");
		
		assertEquals("Test", rowData[0]);
		assertEquals("24", rowData[1]);
		assertEquals("45", rowData[2]);
		assertEquals("Apple,Orange", rowData[3]);
	}

}
