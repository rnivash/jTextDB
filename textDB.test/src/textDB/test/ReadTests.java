package textDB.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import textDB.Create;
import textDB.Delete;
import textDB.Read;
import textDB.Write;
import textDB.Model.Student;

class ReadTests {

	@Test
	void Should_read_from_file() {
		Delete.DeleteFile(Student.class);
		Create.InitFile(Student.class);		
		Write.WriteData(Student.class, new String[] { "TestName", "10", "20" });
		
		ArrayList<String[]> results = Read.ReadData(Student.class);

		assertEquals(1, results.size());
		assertEquals("TestName", results.get(0)[0]);
		assertEquals("10", results.get(0)[1]);
		assertEquals("20", results.get(0)[2]);
	}

}
