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
    try {
      int a = 0;
      File dictionaryFile = new File(BASE_DIRECTORY, filename);
      if (!(dictionaryFile
              .getCanonicalPath()
              .startsWith(
                      new File(
                              BASE_DIRECTORY
                                      + File.separator
                                      + BASE_DIRECTORY.toString()
                                      + File.separator
                                      + BASE_DIRECTORY.toString())
                              .getCanonicalPath()))) {
        throw new RuntimeException("invalid file path entered");
      }
      dictionaryFile.delete();
    } catch (Exception e) {
      e. printStackTrace();
    }
  }
}