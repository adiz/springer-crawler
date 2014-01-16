package ro.cti.ssa.aossi.springercrawler.wrapper;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import ro.cti.ssa.aossi.springercrawler.model.Article;
import ro.cti.ssa.aossi.springercrawler.service.ArticleSpringerParser;
import ro.cti.ssa.aossi.springercrawler.service.ArticlesListSpringerParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
public class SpringerCrawler {

    private static final String SPRINGER_BASE_URL = "http://link.springer.com";

    public List<Article> getArticles(String authorName){

        List<Article> articles = new ArrayList<Article>();

        ArticlesListSpringerParser springerParser = new ArticlesListSpringerParser();

        try {
            springerParser.searchDomTree(springerParser.getRoot(authorName));
        } catch (Exception e) {
            return null;
        }

        List<String> chapterRelativeURLs = springerParser.getArticlesHrefs();
        ArticleSpringerParser articleSpringerParser;
        for (String chapterRelativeURL : chapterRelativeURLs){
            articleSpringerParser = new ArticleSpringerParser();
            try {
                articleSpringerParser.searchDomTree(articleSpringerParser.getRoot(SPRINGER_BASE_URL+chapterRelativeURL));
            } catch (Exception e) {
                continue;
            }

            articles.add(articleSpringerParser.getArticle());
        }

        return articles;
    }

}
