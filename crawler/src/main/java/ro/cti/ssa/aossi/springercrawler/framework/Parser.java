package ro.cti.ssa.aossi.springercrawler.framework;

import org.w3c.dom.NodeList;

/**
 * @author adrian.zamfirescu
 * @since 10/17/13
 */
public interface Parser {

    void parse();

    void parseArticle();

    void search(NodeList nodeList);

}
