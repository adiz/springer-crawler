package ro.cti.ssa.aossi.springercrawler.service;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 10/20/13
 */
public class ArticlesListSpringerParser extends SpringerParser{

    private List<String> articlesHrefs;

    private static final String A = "a";
    private static final String CLASS_ATTR_VALUE = "title";

    public ArticlesListSpringerParser(){
        articlesHrefs = new ArrayList<String>();
    }

    public List<String> getArticlesHrefs() {
        return articlesHrefs;
    }

    public void searchDomTree(NodeList nodeList) {

        if (nodeList.getLength()==0)
            return;

        for (int index=0; index<nodeList.getLength(); index++){

            Node node = nodeList.item(index);
            String nodeName = node.getNodeName();
            if (nodeName.equals(A) && node.hasAttributes()){
                NamedNodeMap namedNodeMap = node.getAttributes();
                Node classAttributeNode = namedNodeMap.getNamedItem("class");
                if (classAttributeNode!=null && classAttributeNode.getNodeValue().equals(CLASS_ATTR_VALUE)){
                    Node hrefAttributeNode = namedNodeMap.getNamedItem("href");
                    if (hrefAttributeNode!=null)
                        articlesHrefs.add(hrefAttributeNode.getNodeValue());
                }
            }

            searchDomTree(node.getChildNodes());
        }


    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        String url = "http://link.springer.com/search?facet-author=Florin+Pop";
        ArticlesListSpringerParser springerParser = new ArticlesListSpringerParser();
        springerParser.searchDomTree(springerParser.getRoot(url));
        System.out.println(springerParser.getArticlesHrefs());

    }

}
