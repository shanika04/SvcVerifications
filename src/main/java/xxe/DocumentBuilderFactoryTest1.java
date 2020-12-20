package xxe;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import java.io.StringReader;

public class DocumentBuilderFactoryTest1 {

  public String getXml(String xmlStr) {

    Document doc = unsafe(xmlStr);

    if (doc != null) {
      return doc.getElementsByTagName("foo").item(0).getTextContent();
    } else {
      return "XML error";
    }
  }

  private Document unsafe(String xmlString) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // Restriction of XML External Entity Reference (CWE 611)
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    DocumentBuilder builder;
    try {
      builder = factory.newDocumentBuilder();
      return builder.parse(new InputSource(new StringReader(xmlString)));

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
