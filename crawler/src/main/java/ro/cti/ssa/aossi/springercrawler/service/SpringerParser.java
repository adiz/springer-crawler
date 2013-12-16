package ro.cti.ssa.aossi.springercrawler.service;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ro.cti.ssa.aossi.springercrawler.framework.Parser;
import ro.cti.ssa.aossi.springercrawler.utils.ParserUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import static ro.cti.ssa.aossi.springercrawler.utils.ParserUtils.removeComments;

/**
 * @author adrian.zamfirescu
 * @since 10/17/13
 */
public abstract class SpringerParser implements Parser {

    private static final String COMMENTS_START = "[if";
    private static final String COMMENTS_END = "[endif]";

    public NodeList getRoot(String url) throws IOException, ParserConfigurationException, SAXException {

        String sourceCode = ParserUtils.getUrlSource(url);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        String cleanedSourceCode = removeComments(sourceCode, COMMENTS_START, COMMENTS_END);
        cleanedSourceCode = cleanedSourceCode.replace("<!DOCTYPE html>","<html>")
                                             .replace("&copy","_copy")
                                             .replace("&hellip","_hellip");
        Document doc = dBuilder.parse(new InputSource(new StringReader(cleanedSourceCode)));

        return doc.getChildNodes();

    }

}
