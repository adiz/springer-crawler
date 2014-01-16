//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import ro.cti.ssa.aossi.springercrawler.dao.ArticleRepository;
//import ro.cti.ssa.aossi.springercrawler.dao.AuthorRepository;
//import ro.cti.ssa.aossi.springercrawler.model.Article;
//import ro.cti.ssa.aossi.springercrawler.model.Author;
//import ro.cti.ssa.aossi.springercrawler.wrapper.SpringerCrawler;
//
//import java.util.List;
//
///**
//* @author adrian.zamfirescu
//* @since 1/16/2014
//*/
//public class Test {
//
//    public static void main(String[] args){
//
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"repository-beans-config.xml","crawler-bean.xml"});
//
//        SpringerCrawler springerCrawler = (SpringerCrawler)applicationContext.getBean("springerCrawler");
//        List<Article> articles = springerCrawler.getArticles("Florin Pop");
//
//        ArticleRepository articleRepository = (ArticleRepository)applicationContext.getBean(ArticleRepository.class);
//        AuthorRepository authorRepository = (AuthorRepository)applicationContext.getBean(AuthorRepository.class);
//
//        Article article = articles.get(0);
//
//        for (int index=0; index<article.getAuthors().size(); index++){
//
//            Author foundAuthor = authorRepository.findByName(article.getAuthors().get(index).getName());
//            if (foundAuthor==null)
//                authorRepository.save(article.getAuthors().get(index));
//            else
//                article.getAuthors().set(index,foundAuthor);
//
//        }
//
//        articleRepository.save(article);
//
//    }
//
//}
