package ro.cti.ssa.aossi.springercrawler.utils;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import ro.cti.ssa.aossi.springercrawler.service.ArticleSpringerParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 10/19/13
 */
public class ParserUtilsTest {

    private static final String COMMENTS_START = "[if";
    private static final String COMMENTS_END = "[endif]";

    private Document document;

    @Before
    public void init() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
    }

    @Test
    public void should_replace_correct_alphanumeric_regex(){

        // when
        String text = "Inlocuieste <!--[if ce e aici cu[endif]--> cu nimic";

        // then
        String replacedText = ParserUtils.removeComments(text, COMMENTS_START, COMMENTS_END);

        // assert
        Assertions.assertThat(replacedText).isEqualTo("Inlocuieste  cu nimic");

    }

    @Test
    public void should_replace_correct_metacharacter_regex_1(){

        // when
        String text = "<!DOCTYPE html>\n" +
                "<!--[if lt IE 7]> <html lang=\"en\" class=\"no-js ie6 lt-ie9 lt-ie8\"> <![endif]-->\n" +
                "<!--[if IE 7]>    <html lang=\"en\" class=\"no-js ie7 lt-ie9 lt-ie8\"> <![endif]-->\n" +
                "<!--[if IE 8]>    <html lang=\"en\" class=\"no-js ie8 lt-ie9\"> <![endif]-->\n" +
                "<!--[if IE 9]>    <html lang=\"en\" class=\"no-js ie9\"> <![endif]-->\n" +
                "<!--[if gt IE 9]><!--> <html lang=\"en\" class=\"no-js\"> <!--<![endif]-->\n" +
                "<head>";

        // then
        String replacedText = ParserUtils.removeComments(text, COMMENTS_START, COMMENTS_END);

        // assert
        Assertions.assertThat(replacedText).isEqualTo("<!DOCTYPE html>\n\n\n\n\n\n<head>");

    }

    @Test
    public void should_replace_correct_metacharacter_regex_2(){

        // when
        String text = "<link rel=\"shortcut icon\" href=\"/static/0.6867/sites/link/images/favicon-32x32.png\"/>\n" +
                "  <!--[if IE]>\n" +
                "    <link rel=\"shortcut icon\" href=\"/static/0.6867/sites/link/images/favicon.ico\"/>\n" +
                "  <![endif]-->\n" +
                "  <meta name=\"msapplication-TileColor\" content=\"#FFFFFF\"/>";

        // then
        String replacedText = ParserUtils.removeComments(text, COMMENTS_START, COMMENTS_END);

        // assert
        Assertions.assertThat(replacedText).isEqualTo("<link rel=\"shortcut icon\" href=\"/static/0.6867/sites/link/images/favicon-32x32.png\"/>\n  \n  <meta name=\"msapplication-TileColor\" content=\"#FFFFFF\"/>");

    }

    @Test
    public void should_check_if_node_has_given_attribute(){

        // when
        Element node = (Element)document.createElement("element");
        node.setAttribute("attrName","attrValue");

        // then
        boolean nodeHasAttribute = ParserUtils.checkExistingNode(node, "element", "attrName", "attrValue");

        // assert
        Assertions.assertThat(nodeHasAttribute).isTrue();

    }

    @Test
    public void should_extract_node_text(){

        // when
        Element node = (Element)document.createElement("element");
        node.setTextContent("something");

        // then
        String textContent = ParserUtils.getNodeTextContent(node);

        // assert
        Assertions.assertThat(textContent).isEqualTo("something");

    }

    @Test
    public void should_retrieve_first_child_node(){

        // when
        Element node = (Element)document.createElement("element");
        Element child = (Element)document.createElement("child");
        node.appendChild(child);

        // then
        Node firstChild = ParserUtils.getFirstChildNode(node);

        // assert
        Assertions.assertThat(firstChild).isEqualTo(child);

    }

    @Test
    public void should_retrieve_child_node_list(){

        // when
        Element node = (Element)document.createElement("element");
        Element childOne = (Element)document.createElement("child1");
        Element childTwo = (Element)document.createElement("child2");
        Element childThree = (Element)document.createElement("child3");

        node.appendChild(childOne);
        node.appendChild(childTwo);
        node.appendChild(childThree);

        // then
        List<Node> children = ParserUtils.getNodeChildren(node);

        // assert
        Assertions.assertThat(children).hasSize(3);
        Assertions.assertThat(children).contains(childOne);
        Assertions.assertThat(children).contains(childTwo);
        Assertions.assertThat(children).contains(childThree);

    }

}
