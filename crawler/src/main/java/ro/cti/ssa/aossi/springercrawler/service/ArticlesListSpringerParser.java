package ro.cti.ssa.aossi.springercrawler.service;

import org.fest.util.VisibleForTesting;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ro.cti.ssa.aossi.springercrawler.utils.ParserUtils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ro.cti.ssa.aossi.springercrawler.utils.ParserUtils.checkExistingNode;
import static ro.cti.ssa.aossi.springercrawler.utils.ParserUtils.getNodeAttributeValue;

/**
 * @author adrian.zamfirescu
 * @since 10/20/13
 */
public class ArticlesListSpringerParser extends SpringerParser{

    private List<String> articlesHrefs;

    private static final String WHITESPACE = " ";
    private static final String SPRINGER_AUTHOR_FACET = "http://link.springer.com/search?facet-author=";
    private static final String A = "a";
    private static final String HREF = "href";
    private static final String CLASS = "class";
    private static final String CLASS_ATTR_VALUE = "title";

    public ArticlesListSpringerParser(){
        articlesHrefs = new ArrayList<String>();
    }

    public List<String> getArticlesHrefs() {
        return articlesHrefs;
    }

    public NodeList getRoot(String authorName) throws IOException, SAXException, ParserConfigurationException {

        return super.getRoot(buildURLByAuthorName(authorName));

    }

    @VisibleForTesting
    String buildURLByAuthorName(String authorName){

        String[] nameComponents = authorName.split(WHITESPACE);
        StringBuffer sb = new StringBuffer();
        int index;
        for (index=0; index<nameComponents.length-1; index++)
            sb.append(nameComponents[index]+"+");
        sb.append(nameComponents[index]);

        return SPRINGER_AUTHOR_FACET + sb.toString();
    }

    public void searchDomTree(NodeList nodeList) {

        if (nodeList.getLength()==0)
            return;

        for (int index=0; index<nodeList.getLength(); index++){

            Node node = nodeList.item(index);
            String articleHref = extractArticleHref(node);
            if (articleHref!=null)
                articlesHrefs.add(articleHref);
            searchDomTree(node.getChildNodes());
        }

    }

    @VisibleForTesting
    String extractArticleHref(Node node){

        if (checkExistingNode(node, A, CLASS, CLASS_ATTR_VALUE))
            return getNodeAttributeValue(node, HREF);

        return null;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        String authorName = "Florin Pop";
        ArticlesListSpringerParser springerParser = new ArticlesListSpringerParser();
        springerParser.searchDomTree(springerParser.getRoot(authorName));
        System.out.println(springerParser.getArticlesHrefs());

    }

}
