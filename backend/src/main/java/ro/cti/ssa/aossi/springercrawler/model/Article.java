package ro.cti.ssa.aossi.springercrawler.model;

import ro.cti.ssa.aossi.springercrawler.basemodel.BaseModel;

import javax.persistence.*;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 10/17/13
 */
@Entity
@Table(name = "article")
public class Article extends BaseModel {

    private String articleAbstract;

    private String title;
    private Publication publication;
    private String pageRange;
    private String copyrightYear;
    private String doi;
    private String printIsbn;
    private String onlineIsbn;
    private Series series;
    private String seriesVolume;
    private String issn;
    private String publisher;
    private String copyrightHolder;
    private List<AdditionalLink> additionalLinks;

    private List<Topic> topics;
    private List<Keyword> keywords;
    private List<IndustrySector> industrySectors;
    private List<EBookPackage> eBookPackages;

    private List<Editor> editors;
    private List<EditorAffiliation> editorAffiliations;
    private List<Author> authors;
    private List<AuthorAffiliation> authorAffiliations;

    @Column(name = "article_abstract")
    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "publication_id")
    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    @Column(name = "page_range")
    public String getPageRange() {
        return pageRange;
    }

    public void setPageRange(String pageRange) {
        this.pageRange = pageRange;
    }

    @Column(name = "copyright_year")
    public String getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    @Column(name = "doi")
    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    @Column(name = "print_isbn")
    public String getPrintIsbn() {
        return printIsbn;
    }

    public void setPrintIsbn(String printIsbn) {
        this.printIsbn = printIsbn;
    }

    @Column(name = "online_isbn")
    public String getOnlineIsbn() {
        return onlineIsbn;
    }

    public void setOnlineIsbn(String onlineIsbn) {
        this.onlineIsbn = onlineIsbn;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "series_id")
    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    @Column(name = "series_volume")
    public String getSeriesVolume() {
        return seriesVolume;
    }

    public void setSeriesVolume(String seriesVolume) {
        this.seriesVolume = seriesVolume;
    }

    @Column(name = "issn")
    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "copyright_holder")
    public String getCopyrightHolder() {
        return copyrightHolder;
    }

    public void setCopyrightHolder(String copyrightHolder) {
        this.copyrightHolder = copyrightHolder;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "article_additional_link",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "additional_link_id"))
    public List<AdditionalLink> getAdditionalLinks() {
        return additionalLinks;
    }

    public void setAdditionalLinks(List<AdditionalLink> additionalLinks) {
        this.additionalLinks = additionalLinks;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "article_topic",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "topic_id"))
    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "article_keyword",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "article_industry_sector",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "industry_sector_id"))
    public List<IndustrySector> getIndustrySectors() {
        return industrySectors;
    }

    public void setIndustrySectors(List<IndustrySector> industrySectors) {
        this.industrySectors = industrySectors;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "article_e_book_package",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "e_book_package_id"))
    public List<EBookPackage> geteBookPackages() {
        return eBookPackages;
    }

    public void seteBookPackages(List<EBookPackage> eBookPackages) {
        this.eBookPackages = eBookPackages;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "article_editor",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "editor_id"))
    public List<Editor> getEditors() {
        return editors;
    }

    public void setEditors(List<Editor> editors) {
        this.editors = editors;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "article_editor_affiliation",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "editor_affiliation_id"))
    public List<EditorAffiliation> getEditorAffiliations() {
        return editorAffiliations;
    }

    public void setEditorAffiliations(List<EditorAffiliation> editorAffiliations) {
        this.editorAffiliations = editorAffiliations;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "article_author",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "author_id"))
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "article_author_affiliation",
                joinColumns = @JoinColumn(name = "article_id"),
                inverseJoinColumns = @JoinColumn(name = "author_affiliation_id"))
    public List<AuthorAffiliation> getAuthorAffiliations() {
        return authorAffiliations;
    }

    public void setAuthorAffiliations(List<AuthorAffiliation> authorAffiliations) {
        this.authorAffiliations = authorAffiliations;
    }
}
