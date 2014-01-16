package ro.cti.ssa.aossi.springer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.cti.ssa.aossi.springer.framework.ArticleService;
import ro.cti.ssa.aossi.springercrawler.dao.ArticleRepository;
import ro.cti.ssa.aossi.springercrawler.model.Article;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;


    @Override
    @Transactional
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }
}
