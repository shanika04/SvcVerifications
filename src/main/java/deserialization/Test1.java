package deserialization;

import java.util.*;
import java.io.ObjectStreamClass;

import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;
import java.io.ObjectInputStream;
import org.xml.sax.helpers.XMLReaderFactory;

public class Test1 {
  // A whitelist of authorized objects

  private Set<String> wl =
      new HashSet<>(
          Arrays.asList(
              "org.xml.sax.helpers.XMLReaderFactory", "org.xml.sax.helpers.SecuritySupport"));

  public void test(File file) throws IOException, InterruptedException, ClassNotFoundException {

    // Replaced deserialization class with a safe version
    ObjectInputStream in = new BetterObjectInputStream(new FileInputStream(file), wl);
    XMLReaderFactory xmlParser = (XMLReaderFactory) in.readObject();
    XMLReaderFactory xmlParser_two = (XMLReaderFactory) xmlParser;
    in.close();
  }

  private static class BetterObjectInputStream extends ObjectInputStream {
    public Set<String> classesWhiteList;
    private Set<String> subPackagesWhiteList = new HashSet<>(Arrays.asList("java.lang"));

    public BetterObjectInputStream(InputStream inputStream, Set<String> classesWhiteList)
        throws IOException {
      super(inputStream);
      this.classesWhiteList = classesWhiteList;
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass cls)
        throws IOException, ClassNotFoundException {
      String className = cls.getName();
      String subPackageName = className.substring(0, className.lastIndexOf("."));
      if (classesWhiteList.contains(className) || subPackagesWhiteList.contains(subPackageName)) {
        return super.resolveClass(cls);
      } else {
        throw new java.lang.RuntimeException("class " + className + " is not white listed");
      }
    }
  }
}
