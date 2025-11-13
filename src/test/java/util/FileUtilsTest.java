package util;

import com.teaching.util.FileUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class FileUtilsTest {

  @Test
  void nullPathString() {
    assertThrows(NullPointerException.class, () -> FileUtils.listFilesAndFolders(null));
  }

  @Test
  void emptyPathString() {
    var result = FileUtils.listFilesAndFolders("");
    assertTrue(result.isEmpty());
  }

  @Test
  void invalidPath() {
    var result = FileUtils.listFilesAndFolders("src/test/does/not/exist");
    assertTrue(result.isEmpty());
  }

  @Test
  void emptyFolder() {
    var result = FileUtils.listFilesAndFolders("src/main/resources");
    assertTrue(result.isEmpty());
  }

  @Test
  void validFolderWithFileAsInput() {
    var result = FileUtils.listFilesAndFolders("src/main/java/com/teaching/Main.java");
    assertTrue(result.isEmpty());
  }

  @Test
  void validFolderWithFiles() {
    var result = FileUtils.listFilesAndFolders("src/main/java/com/teaching");
    var expected = List.of("src/main/java/com/teaching/util", "src/main/java/com/teaching/Main.java");

    assertEquals(expected, result);
  }

}
