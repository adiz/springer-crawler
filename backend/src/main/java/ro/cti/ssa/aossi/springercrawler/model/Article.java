package ro.cti.ssa.aossi.springercrawler.model;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 10/17/13
 */
public class Article {

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

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public String getPageRange() {
        return pageRange;
    }

    public void setPageRange(String pageRange) {
        this.pageRange = pageRange;
    }

    public String getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getPrintIsbn() {
        return printIsbn;
    }

    public void setPrintIsbn(String printIsbn) {
        this.printIsbn = printIsbn;
    }

    public String getOnlineIsbn() {
        return onlineIsbn;
    }

    public void setOnlineIsbn(String onlineIsbn) {
        this.onlineIsbn = onlineIsbn;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public String getSeriesVolume() {
        return seriesVolume;
    }

    public void setSeriesVolume(String seriesVolume) {
        this.seriesVolume = seriesVolume;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCopyrightHolder() {
        return copyrightHolder;
    }

    public void setCopyrightHolder(String copyrightHolder) {
        this.copyrightHolder = copyrightHolder;
    }

    public List<AdditionalLink> getAdditionalLinks() {
        return additionalLinks;
    }

    public void setAdditionalLinks(List<AdditionalLink> additionalLinks) {
        this.additionalLinks = additionalLinks;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<IndustrySector> getIndustrySectors() {
        return industrySectors;
    }

    public void setIndustrySectors(List<IndustrySector> industrySectors) {
        this.industrySectors = industrySectors;
    }

    public List<EBookPackage> geteBookPackages() {
        return eBookPackages;
    }

    public void seteBookPackages(List<EBookPackage> eBookPackages) {
        this.eBookPackages = eBookPackages;
    }

    public List<Editor> getEditors() {
        return editors;
    }

    public void setEditors(List<Editor> editors) {
        this.editors = editors;
    }

    public List<EditorAffiliation> getEditorAffiliations() {
        return editorAffiliations;
    }

    public void setEditorAffiliations(List<EditorAffiliation> editorAffiliations) {
        this.editorAffiliations = editorAffiliations;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<AuthorAffiliation> getAuthorAffiliations() {
        return authorAffiliations;
    }

    public void setAuthorAffiliations(List<AuthorAffiliation> authorAffiliations) {
        this.authorAffiliations = authorAffiliations;
    }
}
