package deserialization;

import java.io.ObjectStreamClass;
import java.util.*;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Set;
import java.util.UUID;
import java.io.ObjectInputStream;

public class Test4 {
  // A whitelist of authorized objects

  private Set<String> wssWhiteList =
      new HashSet<>(
          Arrays.asList(
              "deserialization.ObjectClass",
              "deserialization.SecondObjectClass",
              "java.util.Set",
              "deserialization.ParentClass"));

  public void test(FileInputStream fileIS)
      throws IOException, InterruptedException, ClassNotFoundException {

    // Replaced deserialization class with a safe version
    ObjectInputStream in = new WssObjectInputStream(fileIS, wssWhiteList);
    ParentClass button = (ParentClass) in.readObject();
    ObjectClass specificButton = (ObjectClass) button;
    in.close();
  }

  private static class WssObjectInputStream extends ObjectInputStream {
    public Set<String> classesWhiteList;
    private Set<String> subPackagesWhiteList = new HashSet<>(Arrays.asList("java.lang"));

    public WssObjectInputStream(InputStream inputStream, Set<String> classesWhiteList)
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

class ParentClass {
  private int val = 0;

  public ParentClass(int value) {
    this.val = value;
  }
}

class ObjectClass extends ParentClass {
  private SecondObjectClass obj = null;

  public ObjectClass(int value) {
    super(value);
    this.obj = new SecondObjectClass(value);
  }
}

class SecondObjectClass {
  private int val = 0;
  private Set<String> setVal = null;

  public SecondObjectClass(int value) {
    this.val = value;
  }
}
