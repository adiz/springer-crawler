package ro.cti.ssa.aossi.springercrawler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.cti.ssa.aossi.springercrawler.model.EBookPackage;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Repository
public interface EBookPackageRepository extends JpaRepository<EBookPackage,Long>{

    EBookPackage findByeBookPackageName(String eBookPackageName);

}
