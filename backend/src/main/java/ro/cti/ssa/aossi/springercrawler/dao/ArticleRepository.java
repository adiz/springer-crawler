package ro.cti.ssa.aossi.springercrawler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.cti.ssa.aossi.springercrawler.model.Article;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long>{


}
