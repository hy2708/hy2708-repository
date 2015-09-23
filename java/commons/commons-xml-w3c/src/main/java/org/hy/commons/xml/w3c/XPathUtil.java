package org.hy.commons.xml.w3c;

import java.util.LinkedList;
import java.util.List;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathException;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XPathUtil extends XPathAPI{

	public static void main(String[] args) {
		//String string3 =XPathAPI.selectSingleNodeAsString(doc, "//*[@id='J_PromoBox']");
       // String string =XPathAPI.selectSingleNodeAsString(doc, productNameXpath);
       // NodeList str =XPathAPI.selectNodeList(doc, productNameXpath);
       // NodeList str2 =XPathAPI.selectNodeList(doc, "/HTML/BODY");
      //  String str22 =XPathAPI.selectSingleNodeAsString(doc, "/HTML/BODY");
        
	}
	
	public  Element getElementAsString(Document document ,String xpathString,String... args) {
		Element element = getElement(document, xpathString, args);
		return null;
	}

	public static  Element getElement(Document document ,String xpathString,String... args) {
		Element element = null;
//		try {
//			element =  (Element)XPathAPI.selectSingleNode(document, xpathString, args);
//		} catch (XPathException e){
//			e.printStackTrace();
//		}
		List<Element > list = getElements(document, xpathString, args);
		if (list.size()<=1) {			
			return list.get(0);
		}
		throw new RuntimeException("111111111");
	}
	
	public static  List<Element> getElements(Document document ,String xpathString,String... args) {
		Element element = null;
		List<Element> list = new LinkedList<Element>();
		try {
			NodeList nodeList = XPathAPI.selectNodeList(document, xpathString);
			for (int i = 0; i < nodeList.getLength(); i++) {
				list.add((Element)nodeList.item(i));
			}
		}  catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
