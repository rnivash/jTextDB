package textDB.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import textDB.Read;
import textDB.Model.Student;

class ReadTests {

	@Test
	void test() {
		ArrayList<String[]> test = Read.ReadData((new Student()).getClass());
		
		assertNotNull(test);
	}

}
