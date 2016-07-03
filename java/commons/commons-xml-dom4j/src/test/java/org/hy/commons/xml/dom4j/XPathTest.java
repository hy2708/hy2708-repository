package org.hy.commons.xml.dom4j;


import java.io.File;

import java_cup.runtime.virtual_parse_stack;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.xml.XmlUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPathTest {
	
	static Logger logger = LoggerFactory.getLogger(XPathTest.class);	
	
	@Test
	public  void main() throws Exception {
		
	
		//获得document
				//获得解析流
				//SAXReader reader = new SAXReader();
				//解析xml
				//Document document  = reader.read(filepath);
				String filepath = ProjectPathUtil.getProjectClassPath()
				+ File.separator + "books.xml";
				Document document = new XmlUtil(filepath).getDocument();
				//System.err.println(document);
				logger.error("xxxxxxxxxxxxx");
				System.err.println(document.selectSingleNode("/books").toString());
				//查询book id = b002 的元素   java.lang.NoClassDefFoundError
				Node node = document.selectSingleNode("//book[@id='b002']"); 
				
				System.out.println(((Element)node).attributeValue("id"));
	}

}
