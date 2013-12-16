package ro.cti.ssa.aossi.springercrawler.service;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.fest.util.VisibleForTesting;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ro.cti.ssa.aossi.springercrawler.model.Article;
import ro.cti.ssa.aossi.springercrawler.model.Publication;
import ro.cti.ssa.aossi.springercrawler.utils.ParserUtils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static ro.cti.ssa.aossi.springercrawler.utils.ParserUtils.*;

/**
* @author adrian.zamfirescu
* @since 10/27/13
*/
public class ArticleSpringerParser extends SpringerParser{

    private Article article;

    private static final String A = "a";
    private static final String HREF = "href";
    private static final String DD = "dd";
    private static final String ID = "id";
    private static final String ABSTRACT_TITLE = "abstract-about-title";
    private static final String ABSTRACT_PUBLICATION = "abstract-about-publication";
    private boolean hasArticleTitle = false;
    private boolean hasArticlePublication = false;

    private static final String SPRINGER_BASE_URL = "http://link.springer.com";

    public ArticleSpringerParser(){
        article = new Article();
    }

    public void searchDomTree(NodeList nodeList) {

        if (nodeList.getLength()==0)
            return;

        for (int index=0; index<nodeList.getLength(); index++){

            Node node = nodeList.item(index);

            if (!hasArticleTitle){
                String articleTitle = getArticleTitle(node);
                if (articleTitle!=null){
                    article.setTitle(articleTitle);
                    hasArticleTitle = true;
                }
            }

            if (!hasArticlePublication){
                Publication articlePublication = getArticlePublication(node);
                if (articlePublication!=null){
                    article.setPublication(articlePublication);
                    hasArticlePublication = true;
                }
            }
            System.out.println(node);
            searchDomTree(node.getChildNodes());

        }

    }

    private Publication getArticlePublication(Node node) {

        if (checkExistingNode(node, DD, ID, ABSTRACT_PUBLICATION)){
            Publication publication = new Publication();

            node = getFirstChildNode(node);
            if (node!=null){
                String relativeURL = getNodeAttributeValue(node,HREF);
                System.out.println(">"+relativeURL);
                if (relativeURL!=null){
                    publication.setUrl(SPRINGER_BASE_URL + relativeURL);
                    String publicationTitle = getNodeTextContent(node);
                    System.out.println("Publication title: "+publicationTitle);
                }
            }
        }

        return null;
    }

    private String getArticleTitle(Node node) {

        if (checkExistingNode(node, DD, ID, ABSTRACT_TITLE))
            return getNodeTextContent(node);

        return null;
    }


    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        String chapterRelativeURL = "/chapter/10.1007/978-3-642-32548-9_30";
        ArticleSpringerParser articleSpringerParser = new ArticleSpringerParser();
        articleSpringerParser.searchDomTree(articleSpringerParser.getRoot(SPRINGER_BASE_URL+chapterRelativeURL));
        System.out.println("Article title: "+articleSpringerParser.article.getTitle());

    }

}
