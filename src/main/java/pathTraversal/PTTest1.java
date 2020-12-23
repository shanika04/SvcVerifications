package pathTraversal;

import java.util.UUID;
import java.io.File;

public class PTTest1 {
  private final String BASE_DIRECTORY = "src";

  public void Test(String filename) {
    try {
      File dictionaryFile = new File(BASE_DIRECTORY, filename);
      if (dictionaryFile.getCanonicalPath().startsWith(new File("src").getCanonicalPath())) {
        throw new Exception("invalid file path entered");
      }
      dictionaryFile.delete();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.print("sdfsf");
  }
}
