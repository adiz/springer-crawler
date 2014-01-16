package ro.cti.ssa.aossi.springercrawler.service;

import com.sun.org.apache.xerces.internal.dom.CoreDocumentImpl;
import com.sun.org.apache.xerces.internal.dom.ElementImpl;
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultNode;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 10/20/13
 */
public class ArticlesListSpringerParserTest {

    private ArticlesListSpringerParser articlesListSpringerParser;
    private Document document;

    @Before
    public void init() throws ParserConfigurationException {
        articlesListSpringerParser = new ArticlesListSpringerParser();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
    }

    @Test
    public void should_build_correct_url_by_author_name(){

        // when
        String authorName = "Florin Pop";

        // then
        String url = articlesListSpringerParser.buildURLByAuthorName(authorName);

        // assert
        Assertions.assertThat(url).isEqualTo("http://link.springer.com/search?facet-author=Florin+Pop");

    }

    @Test
    public void should_extract_correct_article_href_from_html_node() throws ParserConfigurationException {

        // when
        Element node = (Element)document.createElement("a");
        node.setAttribute("class","title");
        node.setAttribute("href","articleURLReference");

        // then
        String articleHref = articlesListSpringerParser.extractArticleHref(node);

        // assert
        Assertions.assertThat(articleHref).isEqualTo("articleURLReference");

    }

    @Test
    public void should_extract_correct_articles_list() throws IOException, SAXException, ParserConfigurationException {

        // when
        String authorName = "Florin Pop";
        List<String> articles;

        // then
        articlesListSpringerParser.searchDomTree(articlesListSpringerParser.getRoot(authorName));
        articles = articlesListSpringerParser.getArticlesHrefs();

        // assert
        Assertions.assertThat(articles).hasSize(18);
        for (String article : articles){
            boolean validArticle = false;
            if (article.startsWith("/article/10.1007/") || article.startsWith("/chapter/10.1007/"))
                validArticle = true;
            Assertions.assertThat(validArticle).isTrue();
        }

    }
}
