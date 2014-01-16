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
@Table(name = "industry_sector")
public class IndustrySector extends BaseModel {

    private String industrySectorName;
    private String url;

    private List<Article> articles;

    @Column(name = "industry_sector_name")
    public String getIndustrySectorName() {
        return industrySectorName;
    }

    public void setIndustrySectorName(String industrySectorName) {
        this.industrySectorName = industrySectorName;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToMany(mappedBy = "industrySectors")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
