package ro.cti.ssa.aossi.springercrawler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.cti.ssa.aossi.springercrawler.model.Topic;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {

    Topic findByTopicName(String topicName);

}
