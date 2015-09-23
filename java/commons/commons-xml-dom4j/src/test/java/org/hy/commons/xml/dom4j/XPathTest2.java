package org.hy.commons.xml.dom4j;


import java.io.File;

import java_cup.runtime.virtual_parse_stack;

import org.dom4j.Document;
import org.dom4j.Node;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.xml.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPathTest2 {
	
	static Logger logger = LoggerFactory.getLogger(XPathTest.class);	
	
	public static void main(String[] args) throws Exception {
		
	
		//获得document
				//获得解析流
				//SAXReader reader = new SAXReader();
				//解析xml
				//Document document  = reader.read(filepath);
				String filepath = ProjectPathUtil.getProjectClassPath()
				+ File.separator + 
				//"Person.hbm.xml";
				"books.xml";
				Document document = new XmlUtil(filepath).getDocument();
				//System.err.println(document);
				
				logger.info(document.selectSingleNode("/books").getName());
				logger.info(document.selectSingleNode("/books/book").getName());
				logger.info(document.selectSingleNode("/books/book/title").getName());
				logger.info(document.selectSingleNode("/books/book/price").getName());
				//查询book id = b002 的元素   java.lang.NoClassDefFoundError
				Node node = document.selectSingleNode("//book[@id='b002']"); 
				
				//System.out.println(node);
	}

}
