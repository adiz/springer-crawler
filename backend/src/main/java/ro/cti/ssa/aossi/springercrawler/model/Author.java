package ro.cti.ssa.aossi.springercrawler.model;

/**
 * @author adrian.zamfirescu
 * @since 12/1/2013
 */
public class Author {

    private String authorName;
    private String url;
    private String affiliation;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
}
