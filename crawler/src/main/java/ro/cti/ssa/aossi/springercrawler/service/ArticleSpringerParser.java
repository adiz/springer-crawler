//package ro.cti.ssa.aossi.springercrawler.service;
//
//import org.w3c.dom.NamedNodeMap;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
//* @author adrian.zamfirescu
//* @since 10/27/13
//*/
//public class ArticleSpringerParser extends SpringerParser{
//
//    private Map<String,Object> articleInfo;
//    private static final String DIV = "div";
//    private static final String ID_PUBLICATION_TITLE = "publication-title";
//
//    public ArticleSpringerParser(){
//        articleInfo = new HashMap<String,Object>();
//    }
//
//    public void searchDomTree(NodeList nodeList) {
//
//        if (nodeList.getLength()==0)
//            return;
//
//        for (int index=0; index<nodeList.getLength(); index++){
//
//            Node node = nodeList.item(index);
//            String nodeName = node.getNodeName();
//            if (nodeName.equals(DIV) && node.hasAttributes()){
//                NamedNodeMap namedNodeMap = node.getAttributes();
//                Node classAttributeNode = namedNodeMap.getNamedItem("id");
//                if (classAttributeNode!=null && classAttributeNode.getNodeValue().equals(ID_PUBLICATION_TITLE)){
//                    Node hrefAttributeNode = namedNodeMap.getNamedItem("id");
//                    if (hrefAttributeNode!=null)
//                        articlesHrefs.add(hrefAttributeNode.getNodeValue());
//                }
//            }
//
//            searchDomTree(node.getChildNodes());
//        }
//
//    }
//
//}
