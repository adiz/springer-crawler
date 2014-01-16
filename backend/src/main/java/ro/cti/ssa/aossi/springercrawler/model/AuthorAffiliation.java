package ro.cti.ssa.aossi.springercrawler.model;

import ro.cti.ssa.aossi.springercrawler.basemodel.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 1/15/2014
 */
@Entity
@Table(name = "author_affiliation")
public class AuthorAffiliation extends BaseModel {

    private String name;

    private List<Article> articles;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "authorAffiliations")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
