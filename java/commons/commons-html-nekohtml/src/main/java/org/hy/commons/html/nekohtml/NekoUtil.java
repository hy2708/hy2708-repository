package org.hy.commons.html.nekohtml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.cyberneko.html.parsers.DOMParser;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.http.HttpUnitUtil;
import org.hy.commons.xml.w3c.DOMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public class NekoUtil {
	static Logger logger = LoggerFactory.getLogger(NekoUtil.class);

	public static Document getDocument(String url){
		//获取网页里面的keywords和description 
        //BufferedReader in = new BufferedReader(new FileReader("d:/5pai/2013-3-13/2013-3-13-h15-0.html"));  
        
		DOMParser parser = new DOMParser();  
        try {
			parser.setProperty(  
			         "http://cyberneko.org/html/properties/default-encoding",  
			         "utf-8");
			 /**
	        The Xerces HTML DOM implementation does not support namespaces  
	        and cannot represent XHTML documents with namespace information.  
	        Therefore, in order to use the default HTML DOM implementation with NekoHTML's  
	        DOMParser to parse XHTML documents, you must turn off namespace processing.*/ 
			
	        parser.setFeature("http://xml.org/sax/features/namespaces", false);  
	        parser.parse(url);
		} catch (SAXNotRecognizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       	
		

       //InputStream in0 =HttpClientUtil.getInputStreamByvisitUrl(url, "gbk", "get");
 //     
     
          
       Document doc = parser.getDocument();  
       //System.err.println(document.getText());
       //Document doc = Dom4jUtil.parse(Dom4jUtil.getDocument(new FileReader(file))); 
//       System.err.println("解析得到的Document对象是"+DOMUtil.convertToString(doc));;
      // FileUtil.writeString(file, doc.getElementsByTagName("HTML").item(0).getTextContent(),"gbk");
//       System.err.println("解析得到的Document对象是"+StringUtil.convertCharset(doc.getElementsByTagName("HTML").item(0).getTextContent(), "gbk", "utf-8"));
//       System.err.println("解析得到的Document对象是"+new String(doc.getElementsByTagName("HTML").item(0).getTextContent().getBytes("iso8859-1"), "gbk"));
       //Element el2 = doc.getElementById("J_PromoBox");
       logger.debug("解析得到的Document对象是【" +
       		doc+"】");
       return doc;
       //System.err.println(DOMUtil.toStringFromDoc(doc));
	}
	
	public static Document getDocument(File file){
        FileInputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return getDocument(in);
	}

	
	public static Document getDocument(InputStream in){
		//获取网页里面的keywords和description 
        //BufferedReader in = new BufferedReader(new FileReader("d:/5pai/2013-3-13/2013-3-13-h15-0.html"));  
        
		DOMParser parser = new DOMParser();  
        try {
			parser.setProperty(  
			         "http://cyberneko.org/html/properties/default-encoding",  
			         "utf-8");
			/**
	        The Xerces HTML DOM implementation does not support namespaces  
	        and cannot represent XHTML documents with namespace information.  
	        Therefore, in order to use the default HTML DOM implementation with NekoHTML's  
	        DOMParser to parse XHTML documents, you must turn off namespace processing.*/  
	        parser.setFeature("http://xml.org/sax/features/namespaces", false);  
	        //InputStream in0 =HttpClientUtil.getInputStreamByvisitUrl(url, "gbk", "get");

	        //ByteArrayInputStream in = new ByteArrayInputStream(ss.getBytes("utf-8"));
	        //BufferedReader reader = new BufferedReader(new FileReader(file));
	        //parser.parse(new InputSource(in));
	        InputSource inputSource = new InputSource(in);
	        //inputSource.setCharacterStream(new FileReader(file));
	        parser.parse(inputSource); 
		} catch (SAXNotRecognizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
 
          
       Document doc = parser.getDocument();  
       //System.err.println(document.getText());
       //Document doc = Dom4jUtil.parse(Dom4jUtil.getDocument(new FileReader(file))); 
//       System.err.println("解析得到的Document对象是"+DOMUtil.convertToString(doc));;
      // FileUtil.writeString(file, doc.getElementsByTagName("HTML").item(0).getTextContent(),"gbk");
//       System.err.println("解析得到的Document对象是"+StringUtil.convertCharset(doc.getElementsByTagName("HTML").item(0).getTextContent(), "gbk", "utf-8"));
//       System.err.println("解析得到的Document对象是"+new String(doc.getElementsByTagName("HTML").item(0).getTextContent().getBytes("iso8859-1"), "gbk"));
       //Element el2 = doc.getElementById("J_PromoBox");
       logger.debug("解析得到的Document对象是【" +
          		doc+"】");
       //System.err.println(DOMUtil.toStringFromDoc(doc));
      // System.err.println(doc.getElementsByTagName("body"));
      // System.err.println(doc.getChildNodes().item(1));
      // System.err.println("========================================"+doc.getTextContent());
       return doc;

	}

}
