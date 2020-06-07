package textDB.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import textDB.Create;
import textDB.Model.Student;

class CreateTests {

	
	@Test
	void test() {
		Create.InitFile(new Student().getClass());
	}

}
