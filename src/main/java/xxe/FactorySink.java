package xxe;

import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class FactorySink {

    public void getXml(String filename, XMLInputFactory inputFactory) throws XMLStreamException {

        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(new FileInputStream(filename));
            int eventCounter = 0;
            while (reader.hasNext()) {
                int event = reader.next();
                eventCounter++;
            }
            System.out.println("eventCounter = " + eventCounter);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
