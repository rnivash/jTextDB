package textDB.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import textDB.Create;
import textDB.Delete;
import textDB.Model.Student;

class DeleteTests {

	
	@Test
	void test() {
		Create.InitFile(new Student().getClass());
		Delete.DeleteFile(new Student().getClass());
	}

}
