package ro.cti.ssa.aossi.springercrawler.model;

import ro.cti.ssa.aossi.springercrawler.basemodel.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 12/6/2013
 */
@Entity
@Table(name = "editor")
public class Editor extends BaseModel {

    private String name;
    private String url;
    private String mail;
    private String affiliation;

    private List<Article> articles;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "affiliation")
    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @ManyToMany(mappedBy = "editors")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
