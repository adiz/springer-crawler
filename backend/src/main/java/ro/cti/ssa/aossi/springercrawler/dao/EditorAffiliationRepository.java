package ro.cti.ssa.aossi.springercrawler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.cti.ssa.aossi.springercrawler.model.EditorAffiliation;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Repository
public interface EditorAffiliationRepository extends JpaRepository<EditorAffiliation,Long>{

    EditorAffiliation findByName(String name);


}
