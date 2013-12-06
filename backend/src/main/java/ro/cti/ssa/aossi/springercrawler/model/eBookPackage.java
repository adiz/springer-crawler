package ro.cti.ssa.aossi.springercrawler.model;

/**
 * @author adrian.zamfirescu
 * @since 12/6/2013
 */
public class eBookPackage {

    private String eBookPackageName;
    private String url;

    public String geteBookPackageName() {
        return eBookPackageName;
    }

    public void seteBookPackageName(String eBookPackageName) {
        this.eBookPackageName = eBookPackageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
