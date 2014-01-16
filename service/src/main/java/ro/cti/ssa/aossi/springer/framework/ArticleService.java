package ro.cti.ssa.aossi.springer.framework;

import org.springframework.stereotype.Service;
import ro.cti.ssa.aossi.springercrawler.model.Article;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Service
public interface ArticleService {

    /**
     * returneaza lista de articole din baza de date
     */
    List<Article> getArticles();

}
