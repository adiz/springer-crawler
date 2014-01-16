//package ro.cti.ssa.aossi.springercrawler;
//
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import ro.cti.ssa.aossi.springercrawler.model.Article;
//import ro.cti.ssa.aossi.springercrawler.wrapper.SpringerCrawler;
//
//import java.util.List;
//
//public class Test {
//
//    public static void main(String[] args){
//
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:crawler-bean.xml");
//
//        SpringerCrawler springerCrawler = (SpringerCrawler)applicationContext.getBean("springerCrawler");
//
//        List<Article> articles = springerCrawler.getArticles("Florin Pop");
//
//    }
//
//}
