package textDB.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import textDB.Notepad;
import textDB.Model.Student;

class NotepadTests {
	
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
