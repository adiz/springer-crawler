package ro.cti.ssa.aossi.springercrawler.model;

/**
 * @author adrian.zamfirescu
 * @since 12/6/2013
 */
public class Editor {

    private String name;
    private String url;
    private String mail;
    private String affiliation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
}
