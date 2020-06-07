package textDB.test;

import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import textDB.BaseFile;
import textDB.Create;
import textDB.Delete;
import textDB.Model.Student;

class CreateTests {

	@Test
	void Should_create_file_when_not_exists() {
		Path file = Paths.get(BaseFile.GetFullName(Student.class));
		if (Files.exists(file)) {
			Delete.DeleteFile(Student.class);
		}
		Create.InitFile(Student.class);

		assertEquals(true, Files.exists(file));
	}

}
