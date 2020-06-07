package textDB.test;

import org.junit.jupiter.api.Test;
import textDB.Create;
import textDB.Delete;
import textDB.Model.Student;

class DeleteTests {

	@Test
	void Should_delete_file_if_exists() {
		Create.InitFile(Student.class);
		Delete.DeleteFile(Student.class);
	}

}
