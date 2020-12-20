package xpath;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

public class XPathTest1 {
  public String authenticate(String user, String pass) {
    XPath xPath = XPathFactory.newInstance().newXPath();
    String expression = "/users/user[@name='" + "$user" + "' and @pass='" + "$pass" + "']";
    try {
      xPath.setXPathVariableResolver(
          v -> {
            switch (v.getLocalPart()) {
              case "user":
                return user;
              case "pass":
                return pass;
              default:
                throw new IllegalArgumentException();
            }
          });
      return xPath.evaluate(expression, "null");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }
}
