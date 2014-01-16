package ro.cti.ssa.aossi.springercrawler.model;

import ro.cti.ssa.aossi.springercrawler.basemodel.BaseModel;

import javax.persistence.*;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 12/7/2013
 */
@Entity
@Table(name = "additional_link")
public class AdditionalLink extends BaseModel{

    private String linkName;
    private String url;

    private List<Article> articles;

    @Column(name = "link_name")
    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToMany(mappedBy = "additionalLinks", fetch = FetchType.EAGER)
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
