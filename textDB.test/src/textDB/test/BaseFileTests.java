package textDB.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import textDB.BaseFile;
import textDB.Model.Student;

class BaseFileTests {

	@Test
	void test() {
		Student st = new Student();
		String v1 = BaseFile.GetFullName(st.getClass());
		System.out.print(v1);
		
		assertEquals("Name", v1);
		
	}

}
