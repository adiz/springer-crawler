package ro.cti.ssa.aossi.springercrawler.service;

import org.fest.util.VisibleForTesting;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ro.cti.ssa.aossi.springercrawler.model.*;
import ro.cti.ssa.aossi.springercrawler.utils.ParserUtils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ro.cti.ssa.aossi.springercrawler.utils.ParserUtils.*;

/**
* @author adrian.zamfirescu
* @since 10/27/13
*/
public class ArticleSpringerParser extends SpringerParser{

    private Article article;

    private static final String A = "a";
    private static final String P = "p";
    private static final String HREF = "href";
    private static final String DD = "dd";
    private static final String ID = "id";
    private static final String UL = "ul";
    private static final String LI = "li";
    private static final String CLASS = "class";
    private static final String TITLE = "title";
    private static final String SUP = "sup";
    private static final String ABSTRACT = "a-plus-plus";
    private static final String ABSTRACT_TITLE = "abstract-about-title";
    private static final String ABSTRACT_PUBLICATION = "abstract-about-publication";
    private static final String ABSTRACT_PAGE_RANGE = "abstract-about-book-chapter-page-ranges";
    private static final String ABSTRACT_COPYRIGHT_YEAR = "abstract-about-book-chapter-copyright-year";
    private static final String ABSTRACT_DOI = "abstract-about-book-chapter-doi";
    private static final String ABSTRACT_PRINT_ISBN = "abstract-about-book-print-isbn";
    private static final String ABSTRACT_ONLINE_ISBN = "abstract-about-book-online-isbn";
    private static final String ABSTRACT_SERIES = "abstract-about-book-series-title";
    private static final String ABSTRACT_SERIES_VOLUME = "abstract-about-book-series-volume";
    private static final String ABSTRACT_SERIES_ISSN = "abstract-about-book-series-print-issn";
    private static final String ABSTRACT_PUBLISHER = "abstract-about-publisher";
    private static final String ABSTRACT_COPYRIGHT_HOLDER = "abstract-about-book-copyright-holder";
    private static final String ABSTRACT_ADDITIONAL_LINKS = "abstract-about-additional-links";
    private static final String EXTERNAL = "external";
    private static final String ABSTRACT_TOPICS = "abstract-about-subject";
    private static final String ABSTRACT_KEYWORDS = "abstract-keywords";
    private static final String ABSTRACT_INDUSTRY_SECTORS = "abstract-about-industrysectors";
    private static final String ABSTRACT_EBOOK_PACKAGES = "abstract-about-ebook-packages";
    private static final String EDITORS = "editors";
    private static final String PERSON = "person";
    private static final String ENVELOPE = "envelope";
    private static final String EDITOR_AFFILIATIONS = "editor-affiliations";
    private static final String AUTHORS = "authors";
    private static final String AUTHOR_AFFILIATIONS = "author-affiliations";

    private boolean hasArticleTitle = false;
    private boolean hasArticlePublication = false;
    private boolean hasArticlePageRange = false;
    private boolean hasArticleCopyrightYear = false;
    private boolean hasArticleDoi = false;
    private boolean hasArticlePrintIsbn = false;
    private boolean hasArticleOnlineIsbn = false;
    private boolean hasArticleSeries = false;
    private boolean hasArticleSeriesVolume = false;
    private boolean hasArticleSeriesIssn = false;
    private boolean hasArticlePublisher = false;
    private boolean hasArticleCopyrightHolder = false;
    private boolean hasArticleAdditionalLinks = false;
    private boolean hasArticleTopics = false;
    private boolean hasArticleKeywords = false;
    private boolean hasArticleIndustrySectors = false;
    private boolean hasArticleEBookPackages = false;
    private boolean hasArticleEditors = false;
    private boolean hasArticleEditorAffiliations = false;
    private boolean hasArticleAuthors = false;
    private boolean hasArticleAuthorAffiliations = false;
    private boolean hasArticleAbstract = false;

    private static final String SPRINGER_BASE_URL = "http://link.springer.com";

    public ArticleSpringerParser(){
        article = new Article();
    }

    public Article getArticle(){
        return article;
    }

    public void searchDomTree(NodeList nodeList) {

        if (nodeList.getLength()==0)
            return;

        for (int index=0; index<nodeList.getLength(); index++){

            Node node = nodeList.item(index);

            if (!hasArticleAbstract){
                String articleAbstract = getArticleAbstract(node);
                if (articleAbstract!=null){
                    article.setArticleAbstract(articleAbstract);
                    hasArticleAbstract = true;
                }
            }

            if (!hasArticleTitle){
                String articleTitle = getArticleTitle(node);
                if (articleTitle!=null){
                    article.setTitle(articleTitle);
                    hasArticleTitle = true;
                }
            }

            if (!hasArticlePublication){
                Publication articlePublication = getArticlePublication(node);
                if (articlePublication!=null){
                    article.setPublication(articlePublication);
                    hasArticlePublication = true;
                }
            }

            if (!hasArticlePageRange){
                String articlePageRange = getPageRange(node);
                if (articlePageRange!=null){
                    article.setPageRange(articlePageRange);
                    hasArticlePageRange = true;
                }
            }

            if (!hasArticleCopyrightYear){
                String articleCopyrightYear = getCopyrightYear(node);
                if (articleCopyrightYear!=null){
                    article.setCopyrightYear(articleCopyrightYear);
                    hasArticleCopyrightYear = true;
                }
            }

            if (!hasArticleDoi){
                String articleDoi = getDoi(node);
                if (articleDoi!=null){
                    article.setDoi(articleDoi);
                    hasArticleDoi = true;
                }
            }

            if (!hasArticlePrintIsbn){
                String articlePrintIsbn = getPrintIsbn(node);
                if (articlePrintIsbn!=null){
                    article.setPrintIsbn(articlePrintIsbn);
                    hasArticlePrintIsbn = true;
                }
            }

            if (!hasArticleOnlineIsbn){
                String articleOnlineIsbn = getOnlineIsbn(node);
                if (articleOnlineIsbn!=null){
                    article.setOnlineIsbn(articleOnlineIsbn);
                    hasArticleOnlineIsbn = true;
                }
            }

            if (!hasArticleSeries){
                Series articleSeries = getSeries(node);
                if (articleSeries!=null){
                    article.setSeries(articleSeries);
                    hasArticleSeries = true;
                }
            }

            if (!hasArticleSeriesVolume){
                String articleSeriesVolume = getSeriesVolume(node);
                if (articleSeriesVolume!=null){
                    article.setSeriesVolume(articleSeriesVolume);
                    hasArticleSeriesVolume = true;
                }
            }

            if (!hasArticleSeriesIssn){
                String articleSeriesIssn = getSeriesIssn(node);
                if (articleSeriesIssn!=null){
                    article.setIssn(articleSeriesIssn);
                    hasArticleSeriesIssn = true;
                }
            }

            if (!hasArticlePublisher){
                String articlePublisher = getPublisher(node);
                if (articlePublisher!=null){
                    article.setPublisher(articlePublisher);
                    hasArticlePublisher = true;
                }
            }

            if (!hasArticleCopyrightHolder){
                String articleCopyrightHolder = getCopyrightHolder(node);
                if (articleCopyrightHolder!=null){
                    article.setCopyrightHolder(articleCopyrightHolder);
                    hasArticleCopyrightHolder = true;
                }
            }

            if (!hasArticleAdditionalLinks){
                List<AdditionalLink> articleAdditionalLinks = getAdditionalLinks(node);
                if (articleAdditionalLinks!=null){
                    article.setAdditionalLinks(articleAdditionalLinks);
                    hasArticleAdditionalLinks = true;
                }
            }

            if (!hasArticleAdditionalLinks){
                List<AdditionalLink> articleAdditionalLinks = getAdditionalLinks(node);
                if (articleAdditionalLinks!=null){
                    article.setAdditionalLinks(articleAdditionalLinks);
                    hasArticleAdditionalLinks = true;
                }
            }

            if (!hasArticleTopics){
                List<Topic> articleTopics = getTopics(node);
                if (articleTopics!=null){
                    article.setTopics(articleTopics);
                    hasArticleTopics = true;
                }
            }

            if (!hasArticleKeywords){
                List<Keyword> articleKeywords = getKeywords(node);
                if (articleKeywords!=null){
                    article.setKeywords(articleKeywords);
                    hasArticleKeywords = true;
                }
            }

            if (!hasArticleIndustrySectors){
                List<IndustrySector> articleIndustrySectors = getIndustrySectors(node);
                if (articleIndustrySectors!=null){
                    article.setIndustrySectors(articleIndustrySectors);
                    hasArticleIndustrySectors = true;
                }
            }

            if (!hasArticleEBookPackages){
                List<EBookPackage> articleEBookPackages = getEBookPackages(node);
                if (articleEBookPackages!=null){
                    article.seteBookPackages(articleEBookPackages);
                    hasArticleEBookPackages = true;
                }
            }

            if (!hasArticleEditors){
                List<Editor> articleEditors = getEditors(node);
                if (articleEditors!=null){
                    article.setEditors(articleEditors);
                    hasArticleEditors = true;
                }
            }

            if (!hasArticleEditorAffiliations){
                List<EditorAffiliation> articleEditorAffiliations = getEditorAffiliations(node);
                if (articleEditorAffiliations!=null){
                    article.setEditorAffiliations(articleEditorAffiliations);
                    hasArticleEditorAffiliations = true;
                }
            }

            if (!hasArticleAuthors){
                List<Author> articleAuthors = getAuthors(node);
                if (articleAuthors!=null){
                    article.setAuthors(articleAuthors);
                    hasArticleAuthors = true;
                }
            }

            if (!hasArticleAuthorAffiliations){
                List<AuthorAffiliation> articleAuthorAffiliations = getAuthorAffiliations(node);
                if (articleAuthorAffiliations!=null){
                    article.setAuthorAffiliations(articleAuthorAffiliations);
                    hasArticleAuthorAffiliations = true;
                }
            }

            searchDomTree(node.getChildNodes());

        }

    }

    private String getArticleAbstract(Node node){

        if (checkExistingNode(node, P, CLASS, ABSTRACT))
            return getNodeTextContent(node);

        return null;
    }

    private String getArticleTitle(Node node) {

        if (checkExistingNode(node, DD, ID, ABSTRACT_TITLE))
            return getNodeTextContent(node);

        return null;
    }

    private Publication getArticlePublication(Node node) {

        if (checkExistingNode(node, DD, ID, ABSTRACT_PUBLICATION)){
            Publication publication = new Publication();

            node = getSecondChildNode(node);

            if (node!=null){
                String relativeURL = getNodeAttributeValue(node,HREF);
                if (relativeURL!=null){
                    publication.setUrl(SPRINGER_BASE_URL + relativeURL);
                    String publicationTitle = getNodeTextContent(node);

                    if (publicationTitle==null)
                        return null;

                    publication.setPublicationTitle(publicationTitle);
                    return publication;
                }
            }
        }

        return null;
    }

    private String getPageRange(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_PAGE_RANGE))
            return getNodeTextContent(node);

        return null;
    }

    private String getCopyrightYear(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_COPYRIGHT_YEAR))
            return getNodeTextContent(node);

        return null;
    }

    private String getDoi(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_DOI))
            return getNodeTextContent(node);

        return null;
    }

    private String getPrintIsbn(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_PRINT_ISBN))
            return getNodeTextContent(node);

        return null;
    }

    private String getOnlineIsbn(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_ONLINE_ISBN))
            return getNodeTextContent(node);

        return null;
    }

    private Series getSeries(Node node) {

        if (checkExistingNode(node, DD, ID, ABSTRACT_SERIES)){
            Series series = new Series();

            node = getSecondChildNode(node);

            if (node!=null){
                String relativeURL = getNodeAttributeValue(node,HREF);
                if (relativeURL!=null){
                    series.setUrl(SPRINGER_BASE_URL + relativeURL);
                    String seriesTitle = getNodeTextContent(node);

                    if (seriesTitle==null)
                        return null;

                    series.setSeriesTitle(seriesTitle);
                    return series;
                }
            }
        }

        return null;
    }

    private String getSeriesVolume(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_SERIES_VOLUME))
            return getNodeTextContent(node);

        return null;
    }

    private String getSeriesIssn(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_SERIES_ISSN))
            return getNodeTextContent(node);

        return null;
    }

    private String getPublisher(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_PUBLISHER))
            return getNodeTextContent(node);

        return null;
    }

    private String getCopyrightHolder(Node node){

        if (checkExistingNode(node,DD,ID,ABSTRACT_COPYRIGHT_HOLDER))
            return getNodeTextContent(node);

        return null;
    }

    private List<AdditionalLink> getAdditionalLinks(Node node){

        if (checkExistingNode(node, DD, ID, ABSTRACT_ADDITIONAL_LINKS)){
            List<AdditionalLink> additionalLinks = new ArrayList<AdditionalLink>();

            node = getSecondChildNode(node);

            if (node!=null){

                for (int index=0; index<node.getChildNodes().getLength(); index++){

                    Node child = node.getChildNodes().item(index);
                    if (checkExistingNode(child, LI)){

                        child = getSecondChildNode(child);
                        if (checkExistingNode(child, A, CLASS, EXTERNAL)){

                            String relativeURL = getNodeAttributeValue(child,HREF);
                            if (relativeURL!=null){

                                AdditionalLink additionalLink = new AdditionalLink();

                                additionalLink.setUrl(relativeURL);
                                String linkName = getNodeTextContent(child);

                                if (linkName==null)
                                    continue;

                                additionalLink.setLinkName(linkName);
                                additionalLinks.add(additionalLink);
                            }

                        }
                    }

                }

                if (!additionalLinks.isEmpty())
                    return additionalLinks;

            }
        }

        return null;
    }

    private List<Topic> getTopics(Node node){

        if (checkExistingNode(node, UL, CLASS, ABSTRACT_TOPICS)){
            List<Topic> topics = new ArrayList<Topic>();

            for (int index=0; index<node.getChildNodes().getLength(); index++){

                Node child = node.getChildNodes().item(index);
                if (checkExistingNode(child, LI)){

                    child = getSecondChildNode(child);
                    if (checkExistingNode(child, A)){

                        String relativeURL = getNodeAttributeValue(child,HREF);
                        if (relativeURL!=null){

                            Topic topic = new Topic();

                            topic.setUrl(SPRINGER_BASE_URL + relativeURL);
                            String topicName = getNodeTextContent(child);

                            if (topicName==null)
                                continue;

                            topic.setTopicName(topicName);
                            topics.add(topic);
                        }

                    }
                }

            }

            if (!topics.isEmpty())
                return topics;

        }

        return null;
    }

    private List<Keyword> getKeywords(Node node){

        if (checkExistingNode(node, UL, CLASS, ABSTRACT_KEYWORDS)){
            List<Keyword> keywords = new ArrayList<Keyword>();

            for (int index=0; index<node.getChildNodes().getLength(); index++){

                Node child = node.getChildNodes().item(index);
                if (checkExistingNode(child, LI)){

                    Keyword keyword = new Keyword();

                    String name = getNodeTextContent(child);

                    if (name==null)
                        continue;

                    keyword.setName(name);
                    keywords.add(keyword);
                }

            }

            if (!keywords.isEmpty())
                return keywords;

        }

        return null;
    }

    private List<IndustrySector> getIndustrySectors(Node node){

        if (checkExistingNode(node, UL, CLASS, ABSTRACT_INDUSTRY_SECTORS)){
            List<IndustrySector> industrySectors = new ArrayList<IndustrySector>();

            for (int index=0; index<node.getChildNodes().getLength(); index++){

                Node child = node.getChildNodes().item(index);
                if (checkExistingNode(child, LI)){

                    child = getSecondChildNode(child);
                    if (checkExistingNode(child, A)){

                        String relativeURL = getNodeAttributeValue(child,HREF);
                        if (relativeURL!=null){

                            IndustrySector industrySector = new IndustrySector();

                            industrySector.setUrl(SPRINGER_BASE_URL + relativeURL);
                            String industrySectorName = getNodeTextContent(child);

                            if (industrySectorName==null)
                                continue;

                            industrySector.setIndustrySectorName(industrySectorName);
                            industrySectors.add(industrySector);
                        }

                    }
                }

            }

            if (!industrySectors.isEmpty())
                return industrySectors;

        }

        return null;
    }

    private List<EBookPackage> getEBookPackages(Node node){

        if (checkExistingNode(node, UL, CLASS, ABSTRACT_EBOOK_PACKAGES)){
            List<EBookPackage> eBookPackages = new ArrayList<EBookPackage>();

            for (int index=0; index<node.getChildNodes().getLength(); index++){

                Node child = node.getChildNodes().item(index);
                if (checkExistingNode(child, LI)){

                    child = getSecondChildNode(child);
                    if (checkExistingNode(child, A)){

                        String relativeURL = getNodeAttributeValue(child,HREF);
                        if (relativeURL!=null){

                            EBookPackage eBookPackage = new EBookPackage();

                            eBookPackage.setUrl(SPRINGER_BASE_URL + relativeURL);
                            String eBookPackageName = getNodeTextContent(child);

                            if (eBookPackageName==null)
                                continue;

                            eBookPackage.seteBookPackageName(eBookPackageName);
                            eBookPackages.add(eBookPackage);
                        }

                    }
                }

            }

            if (!eBookPackages.isEmpty())
                return eBookPackages;

        }

        return null;
    }

    private List<Editor> getEditors(Node node){

        if (checkExistingNode(node, UL, CLASS, EDITORS)){
            List<Editor> editors = new ArrayList<Editor>();

            for (int index=0; index<node.getChildNodes().getLength(); index++){

                Node child = node.getChildNodes().item(index);
                if (checkExistingNode(child, LI)){

                    Editor editor = new Editor();

                    Node child1 = getSecondChildNode(child);
                    if (checkExistingNode(child1, A, CLASS, PERSON)){

                        String relativeURL = getNodeAttributeValue(child1,HREF);
                        if (relativeURL!=null){
                            editor.setUrl(SPRINGER_BASE_URL + relativeURL);
                        }

                        String name = getNodeTextContent(child1);
                        if (name!=null){
                            editor.setName(name);
                        }
                    }

                    Node child2 = getFourthChildNode(child);
                    if (checkExistingNode(child2, A, CLASS, ENVELOPE)){
                        String mail = getNodeAttributeValue(child2,TITLE);
                        if (mail!=null){
                            editor.setMail(mail);
                        }
                    }

                    Node child3 = getSixthChildNode(child);
                    if (checkExistingNode(child3, SUP)){
                        String affiliation = getNodeAttributeValue(child3,TITLE);
                        if (affiliation!=null){
                            editor.setAffiliation(affiliation);
                        }
                    }

                    editors.add(editor);
                }

            }

            if (!editors.isEmpty())
                return editors;

        }

        return null;
    }

    private List<EditorAffiliation> getEditorAffiliations(Node node){

        if (checkExistingNode(node, UL, CLASS, EDITOR_AFFILIATIONS)){
            List<EditorAffiliation> editorAffiliations = new ArrayList<EditorAffiliation>();

            for (int index=0; index<node.getChildNodes().getLength(); index++){

                Node child = node.getChildNodes().item(index);
                if (checkExistingNode(child, LI)){

                    EditorAffiliation editorAffiliation = new EditorAffiliation();

                    String name = getNodeTextContent(child);

                    if (name==null)
                        continue;

                    editorAffiliation.setName(name);
                    editorAffiliations.add(editorAffiliation);
                }

            }

            if (!editorAffiliations.isEmpty())
                return editorAffiliations;

        }

        return null;
    }

    private List<Author> getAuthors(Node node){

        if (checkExistingNode(node, UL, CLASS, AUTHORS) && checkExistingNode(node.getParentNode(),DD)){
            List<Author> authors = new ArrayList<Author>();

            for (int index=0; index<node.getChildNodes().getLength(); index++){

                Node child = node.getChildNodes().item(index);
                if (checkExistingNode(child, LI)){

                    Author author = new Author();

                    Node child1 = getSecondChildNode(child);
                    if (checkExistingNode(child1, A, CLASS, PERSON)){

                        String relativeURL = getNodeAttributeValue(child1,HREF);
                        if (relativeURL!=null){
                            author.setUrl(SPRINGER_BASE_URL + relativeURL);
                        }

                        String name = getNodeTextContent(child1);
                        if (name!=null){
                            author.setName(name);
                        }
                    }

                    Node child2 = getFourthChildNode(child);
                    if (checkExistingNode(child2, A, CLASS, ENVELOPE)){
                        String mail = getNodeAttributeValue(child2,TITLE);
                        if (mail!=null){
                            author.setMail(mail);
                        }
                    }

                    Node child3 = getSixthChildNode(child);
                    if (checkExistingNode(child3, SUP)){
                        String affiliation = getNodeAttributeValue(child3,TITLE);
                        if (affiliation!=null){
                            author.setAffiliation(affiliation);
                        }
                    }

                    authors.add(author);
                }

            }

            if (!authors.isEmpty())
                return authors;

        }

        return null;
    }

    private List<AuthorAffiliation> getAuthorAffiliations(Node node){

        if (checkExistingNode(node, UL, CLASS, AUTHOR_AFFILIATIONS)){
            List<AuthorAffiliation> authorAffiliations = new ArrayList<AuthorAffiliation>();

            for (int index=0; index<node.getChildNodes().getLength(); index++){

                Node child = node.getChildNodes().item(index);
                if (checkExistingNode(child, LI)){

                    AuthorAffiliation authorAffiliation = new AuthorAffiliation();

                    String name = getNodeTextContent(child);

                    if (name==null)
                        continue;

                    authorAffiliation.setName(name);
                    authorAffiliations.add(authorAffiliation);
                }

            }

            if (!authorAffiliations.isEmpty())
                return authorAffiliations;

        }

        return null;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        String chapterRelativeURL = "/chapter/10.1007/978-3-642-32548-9_30";
//        String chapterRelativeURL = "/article/10.1007/s00013-011-0287-5";
        ArticleSpringerParser articleSpringerParser = new ArticleSpringerParser();
        articleSpringerParser.searchDomTree(articleSpringerParser.getRoot(SPRINGER_BASE_URL+chapterRelativeURL));
        System.out.println("Article abstract: "+articleSpringerParser.article.getArticleAbstract());
        System.out.println("Article title: "+articleSpringerParser.article.getTitle());
        System.out.println("Article publication: "+articleSpringerParser.article.getPublication());
        System.out.println("Article page range: "+articleSpringerParser.article.getPageRange());
        System.out.println("Article copyright year: "+articleSpringerParser.article.getCopyrightYear());
        System.out.println("Article doi: "+articleSpringerParser.article.getDoi());
        System.out.println("Article print isbn: "+articleSpringerParser.article.getPrintIsbn());
        System.out.println("Article online isbn: "+articleSpringerParser.article.getOnlineIsbn());
        System.out.println("Article series: "+articleSpringerParser.article.getSeries());
        System.out.println("Article series volume: "+articleSpringerParser.article.getSeriesVolume());
        System.out.println("Article series issn: "+articleSpringerParser.article.getIssn());
        System.out.println("Article publisher: "+articleSpringerParser.article.getPublisher());
        System.out.println("Article copyright holder: "+articleSpringerParser.article.getCopyrightHolder());
        System.out.println("Article additional links: "+articleSpringerParser.article.getAdditionalLinks());
        System.out.println("Article topics: "+articleSpringerParser.article.getTopics());
        System.out.println("Article keywords: "+articleSpringerParser.article.getKeywords());
        System.out.println("Article industry sectors: "+articleSpringerParser.article.getIndustrySectors());
        System.out.println("Article ebook packages: "+articleSpringerParser.article.geteBookPackages());
        System.out.println("Article editors: "+articleSpringerParser.article.getEditors());
        System.out.println("Article editor affiliations: "+articleSpringerParser.article.getEditorAffiliations());
        System.out.println("Article authors: "+articleSpringerParser.article.getAuthors());
        System.out.println("Article author affiliations: "+articleSpringerParser.article.getAuthorAffiliations());

    }

}
