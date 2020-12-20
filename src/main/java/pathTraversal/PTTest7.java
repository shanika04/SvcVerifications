package pathTraversal;

import java.io.FileOutputStream;
import java.util.UUID;
import java.io.File;

public class PTTest7 {
  private final String BASE_DIRECTORY = "src";

  public void Test(String filename, String f) {
    try {
      int a = 0;
      String s = BASE_DIRECTORY + "qqq" + f + getvalue("abc");
      File file = new File(s + filename);
      if (file.getCanonicalPath().startsWith(new File("srcqqq").getCanonicalPath())) {
        throw new PathTraversalException("invalid file path entered");
      }
      FileOutputStream fos = new FileOutputStream(file);
      fos.write("abcd".getBytes());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public String getvalue(String s) {
    return "rrr" + s + "aaa";
  }
}
