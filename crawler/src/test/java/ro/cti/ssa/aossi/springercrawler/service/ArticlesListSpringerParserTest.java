package ro.cti.ssa.aossi.springercrawler.service;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 10/20/13
 */
public class ArticlesListSpringerParserTest {

    @Test
    public void should_extract_correct_articles_list() throws IOException, SAXException, ParserConfigurationException {

        // when
        String url = "http://link.springer.com/search?facet-author=Florin+Pop";
        List<String> articles;
        ArticlesListSpringerParser articlesListSpringerParser = new ArticlesListSpringerParser();

        // then
        articlesListSpringerParser.searchDomTree(articlesListSpringerParser.getRoot(url));
        articles = articlesListSpringerParser.getArticlesHrefs();

        // assert
        Assertions.assertThat(articles).hasSize(16);
        for (String article : articles){
            boolean validArticle = false;
            if (article.startsWith("/article/10.1007/") || article.startsWith("/chapter/10.1007/"))
                validArticle = true;
            Assertions.assertThat(validArticle).isTrue();
        }

    }
}
