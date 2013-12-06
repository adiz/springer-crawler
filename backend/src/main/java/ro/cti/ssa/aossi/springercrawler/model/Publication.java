package ro.cti.ssa.aossi.springercrawler.model;

/**
 * @author adrian.zamfirescu
 * @since 12/1/2013
 */
public class Publication {

    private String publicationTitle;
    private String url;

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
