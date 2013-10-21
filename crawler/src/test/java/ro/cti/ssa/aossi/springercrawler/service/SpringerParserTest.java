package ro.cti.ssa.aossi.springercrawler.service;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author adrian.zamfirescu
 * @since 10/20/13
 */
public class SpringerParserTest {

    @Test
    public void should_get_correct_root_html_element() throws IOException, SAXException, ParserConfigurationException {

        // when
        String url = "http://link.springer.com/search?facet-author=Florin+Pop";
        SpringerParser springerParser = new SpringerParser() {
            public void searchDomTree(NodeList nodeList) {}
        };

        // then
        NodeList nodeList = springerParser.getRoot(url);

        // assert
        Assertions.assertThat(nodeList.item(0).getNodeName()).isEqualTo("html");

    }

}
