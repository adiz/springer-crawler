package ro.cti.ssa.aossi.springercrawler.basemodel;

import javax.persistence.*;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@MappedSuperclass
public abstract class BaseModel {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
