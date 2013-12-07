package ro.cti.ssa.aossi.springercrawler.model;

import java.util.List;

/**
 * @author adrian.zamfirescu
 */
public class Article {

    private Publication publication;
    private Series series;
    private String bookVolume;
    private String copyrightYear;
    private String pageRange;
    private String title;
    private List<Author> authors;
    private String articleAbstract;
    private String doi;
    private String printIsbn;
    private String onlineIsbn;
    private String issn;
    private String publisher;
    private String copyrightHolder;
    private String bookLink;
    private List<Topic> topics;
    private List<Data> keywords;
    private List<IndustrySector> industrySectors;
    private List<EBookPackage> eBookPackages;
    private List<Editor> editors;
    private List<Data> authorAffiliations;
    private List<Data> editorAffiliations;

}
