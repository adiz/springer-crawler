package ro.cti.ssa.aossi.springer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.cti.ssa.aossi.springer.framework.ArticleService;
import ro.cti.ssa.aossi.springer.framework.CrawlerService;
import ro.cti.ssa.aossi.springer.web.ControllerException;
import ro.cti.ssa.aossi.springercrawler.model.Article;
import ro.cti.ssa.aossi.springercrawler.model.Author;
import ro.cti.ssa.aossi.springercrawler.model.Publication;
import ro.cti.ssa.aossi.springercrawler.wrapper.SpringerCrawler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Controller
@RequestMapping("/springer")
public class SpringerController {

    private CrawlerService crawlerService;
    private ArticleService articleService;

    @Autowired
    public SpringerController(CrawlerService crawlerService, ArticleService articleService){
        this.crawlerService = crawlerService;
        this.articleService = articleService;
    }

    @RequestMapping(value = "crawl", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateUser(@RequestBody String authorName) throws ControllerException {

        Integer noArticles = crawlerService.crawlArticles(authorName);

        if (noArticles==null)
            throw new ControllerException("List not found", HttpServletResponse.SC_BAD_REQUEST);

        return noArticles;

    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getArticles() throws ControllerException {

        return articleService.getArticles();
//          return articleService.getArticles().get(0).getPublication();
    }


}
