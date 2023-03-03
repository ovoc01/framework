package web.xmlparser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class XMLParser {
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;

    public XMLParser() throws ParserConfigurationException, IOException, SAXException {
        initFactoryBuilder();
        initDocument();
    }

    /**
     * Function who build the DocumentBuilderFactory and the DocumentBuilder
     * @return void
     * */
    private void initFactoryBuilder() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    /**
     * Function who Build document and normalize the XML structure
     * @return void
     * */
    private void initDocument() throws IOException, SAXException {
        document = builder.parse(new File("./src/conf.xml"));
        document.getDocumentElement().normalize();
    }

    /**
     * Function who retrieve the connection information in <h3>conf.xml</h3>
     * @return Vector<Element>
     * */
    public Vector<Element> connectionInf(){
        NodeList nodeList = document.getElementsByTagName("connection");
        Vector<Element> elementVector = new Vector<>();
        int nodeListLength = nodeList.getLength();
        for (int i = 0; i <nodeListLength ; i++) {
            Node node = nodeList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE) elementVector.add((Element) node);
        }
        return elementVector;
    }
}
