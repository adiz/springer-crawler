package ro.cti.ssa.aossi.springercrawler.framework;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author adrian.zamfirescu
 * @since 10/17/13
 */
public interface Parser {

    NodeList getRoot(String url) throws IOException, ParserConfigurationException, SAXException;

    void searchDomTree(NodeList nodeList);

}
