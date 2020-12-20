package pathTraversal;

import java.util.UUID;
import java.io.File;

public class PTTest6 {
  private final String BASE_DIRECTORY = "src";

  public void Test(String file) {
    System.out.print("sdfsf");
    String a = file + "abc";
    sink(file);
  }

  private void sink(String filename) {
    int a = 0;
    File dictionaryFile = new File(BASE_DIRECTORY, filename);
    if (dictionaryFile.getCanonicalPath().startsWith(new File("src").getCanonicalPath())) {
      throw new PathTraversalException("invalid file path entered");
    }
    dictionaryFile.delete();
  }
}
