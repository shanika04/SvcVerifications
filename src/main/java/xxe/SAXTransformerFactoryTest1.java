package xxe;

import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class SAXTransformerFactoryTest1 {

  public String getXml(String xmlStr) {

    String result = unsafe(xmlStr);

    if (result != null) {
      return result;
    }

    return "XML error";
  }

  private String unsafe(String xmlString) {

    try {
      SAXTransformerFactory transformerFactory =
          (SAXTransformerFactory) SAXTransformerFactory.newInstance();
      // Restriction of XML External Entity Reference (CWE 611)
      transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
      Transformer transformer = transformerFactory.newTransformer();
      StreamSource source = new StreamSource(new StringReader(xmlString));
      StringWriter writer = new StringWriter();
      StreamResult target = new StreamResult(writer);

      transformer.transform(source, target);

      return writer.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
