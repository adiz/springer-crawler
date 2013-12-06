package ro.cti.ssa.aossi.springercrawler.model;

/**
 * @author adrian.zamfirescu
 * @since 12/5/2013
 */
public class Topic {

    private String topicName;
    private String url;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
