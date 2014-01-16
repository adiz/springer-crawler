package ro.cti.ssa.aossi.springercrawler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.cti.ssa.aossi.springercrawler.model.AuthorAffiliation;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Repository
public interface AuthorAffiliationRepository extends JpaRepository<AuthorAffiliation,Long>{

     AuthorAffiliation findByName(String name);

}
