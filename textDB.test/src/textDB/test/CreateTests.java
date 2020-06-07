package textDB.test;

import org.junit.jupiter.api.Test;
import textDB.Create;
import textDB.Model.Student;

class CreateTests {

	
	@Test
	void test() {
		Create.InitFile(new Student().getClass());
	}

}
