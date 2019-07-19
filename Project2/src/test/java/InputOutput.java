import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;



public class InputOutput {

    private static String xmlFileLocation="C:\\Users\\Inga\\IdeaProjects\\Project2\\config.xml";
    private static String xmlUserDataFileLocation="C:\\Users\\Inga\\IdeaProjects\\Project2\\userData.xml";

    public static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File(xmlFileLocation);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    public static String getUserData (String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File(xmlUserDataFileLocation);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
