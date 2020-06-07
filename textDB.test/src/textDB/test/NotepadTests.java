package textDB.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import textDB.Notepad;
import textDB.Model.Student;

class NotepadTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Student stud = new Student();
		stud.Name = "Darshan";
		stud.Age = 4;
		stud.Grade = 10;
		Notepad.InsertValue(stud);
		List<Student> ls = Notepad.Select(Student.class);
		assertEquals(ls.get(0).Name, "Darshan");
		assertEquals(ls.get(0).Age, 4);
		assertEquals(ls.get(0).Grade, 10);
	}

}
