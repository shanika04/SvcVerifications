package xxe;

import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XXESource {

  private void source(String filename) throws XMLStreamException {
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    // Restriction of XML External Entity Reference (CWE 611)
    inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
    // Restriction of XML External Entity Reference (CWE 611)
    inputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
    new FactorySink().getXml(filename, inputFactory);
  }
}
