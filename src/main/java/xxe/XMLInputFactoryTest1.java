package xxe;

import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLInputFactoryTest1 {

  private void getXml(String filename) throws XMLStreamException {

    try {

      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
      // Restriction of XML External Entity Reference (CWE 611)
      inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
      // Restriction of XML External Entity Reference (CWE 611)
      inputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
      XMLStreamReader reader = inputFactory.createXMLStreamReader(new FileInputStream(filename));
      int eventCounter = 0;
      while (reader.hasNext()) {
        int event = reader.next();
        eventCounter++;
      }
      System.out.println("eventCounter = " + eventCounter);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
