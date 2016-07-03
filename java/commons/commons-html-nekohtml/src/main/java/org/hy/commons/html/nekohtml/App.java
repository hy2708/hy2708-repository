package org.hy.commons.html.nekohtml;

import java.io.IOException;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SAXException, IOException
    {
    	//创建一个解析器  
    	DOMParser parser = new DOMParser();  
    	//解析HTML文件  
    	parser.parse("d:\\ggg.html");  
    	//获取解析后的DOM树  
    	Document document = parser.getDocument();  
    	  
    	//通过getElementsByTagName获取Node  
    	NodeList nodeList = document.getElementsByTagName("a");  
    	for (int i = 0; i < nodeList.getLength(); i++) {  
    	    Element e = (Element)nodeList.item(i);  
    	    System.out.print(e.getAttribute("href") + "\t");  
    	    System.out.println(e.getTextContent());  
    	} 
    }
}
