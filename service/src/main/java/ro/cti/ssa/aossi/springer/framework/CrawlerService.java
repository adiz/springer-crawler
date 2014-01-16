package ro.cti.ssa.aossi.springer.framework;

import org.springframework.stereotype.Service;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Service
public interface CrawlerService {

    /**
     * colecteaza articole, daca acestea apar in lista asociata unui autor si intoarce numarul de articole gasite
     * @param authorName
     * @return
     */
    Integer crawlArticles(String authorName);

}
