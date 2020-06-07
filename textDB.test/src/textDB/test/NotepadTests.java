package textDB.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

import textDB.Delete;
import textDB.Notepad;
import textDB.Model.Student;

class NotepadTests {
	
	@Test
	void Should_insert_values_to_db() {
		Delete.DeleteFile(Student.class);
		
		Student stud = new Student();
		stud.Name = "Darshan";
		stud.Age = 4;
		stud.Grade = 10;
		Notepad.InsertValue(stud);		
		stud = new Student();
		stud.Name = "Nivash";
		stud.Age = 4;
		stud.Grade = 10;		
		Notepad.InsertValue(stud);
		
		List<Student> ls = Notepad.Select(Student.class);
		assertEquals(ls.get(1).Name, "Nivash");
		assertEquals(ls.get(1).Age, 4);
		assertEquals(ls.get(1).Grade, 10);		
	}
	
	@Test
	void Should_fetch_values_from_db() {
		Delete.DeleteFile(Student.class);		
		Student stud = new Student();
		stud.Name = "Darshan";
		stud.Age = 4;
		stud.Grade = 10;
		Notepad.InsertValue(stud);
		
		List<Student> ls = Notepad.Select(Student.class);
		
		assertEquals(ls.get(0).Name, "Darshan");
		assertEquals(ls.get(0).Age, 4);
		assertEquals(ls.get(0).Grade, 10);
		Notepad.Delete(stud);
	}
	
	@Test
	void Should_delete_values_from_db() {
		Delete.DeleteFile(Student.class);		
		Student stud = new Student();
		stud.Name = "Darshan";
		stud.Age = 4;
		stud.Grade = 10;
		Notepad.InsertValue(stud);
				
		Notepad.Delete(stud);
		
		List<Student> ls = Notepad.Select(Student.class);
		assertEquals(0, ls.size());
	}

}
