package textDB.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import textDB.Write;
import textDB.Model.Student;

class WriteTests {

	

	@Test
	void test() {
		
		String[] values = new String[] { "Test Line 1", "Test Line 2" };
		
		Write.WriteData((new Student()).getClass(), values);
		
		assertNotNull(values);
		
	}

}
