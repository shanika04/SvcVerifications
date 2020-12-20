package xpath;

import javax.xml.xpath.XPath;
import javax.servlet.http.HttpServletRequest;
import javax.xml.xpath.XPathFactory;

public class XPathTest2 {

  public String authenticate(String user, String pass) {
    XPath xPath = XPathFactory.newInstance().newXPath();
    String expression = "/users/user[@name='" + "$user" + "' and @pass='" + "$pass" + "']";
    try {
      if (!user.isEmpty()) {
        xPath.setXPathVariableResolver(
            v -> {
              switch (v.getLocalPart()) {
                case "pass":
                  return pass;
                case "user":
                  return user;
                default:
                  throw new IllegalArgumentException();
              }
            });
        return xPath.evaluate(expression, "null");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }
}
