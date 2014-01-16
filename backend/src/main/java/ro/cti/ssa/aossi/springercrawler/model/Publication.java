package ro.cti.ssa.aossi.springercrawler.model;

import ro.cti.ssa.aossi.springercrawler.basemodel.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author adrian.zamfirescu
 * @since 12/1/2013
 */
@Entity
@Table(name = "publication")
public class Publication extends BaseModel {

    private String publicationTitle;
    private String url;

    @Column(name = "publication_title")
    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
