package org.hy.commons.xml.dom4j;


import java.io.File;
import java.util.List;

import java_cup.runtime.virtual_parse_stack;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.xml.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPathTest_hibernate_mapping {
	
	static Logger logger = LoggerFactory.getLogger(XPathTest.class);	
	
	public static void main(String[] args) throws Exception {
		
	
		//获得document
				//获得解析流
				//SAXReader reader = new SAXReader();
				//解析xml
				//Document document  = reader.read(filepath);
				String filepath = ProjectPathUtil.getProjectClassPath()
				+ File.separator + 
				"Person.hbm.xml";
				//"books.xml";
				Document document = new XmlUtil(filepath).getDocument();
				//System.err.println(document);
				System.err.println(document.getRootElement().getName());
				Element classElement =(Element) document.selectSingleNode("/hibernate-mapping/class");
				String className =classElement.attribute("name").getValue();
				String table =classElement.attribute("table").getValue();
				logger.info(classElement.getName());
				logger.info(className);
				
				Element idElement =(Element) document.selectSingleNode("/hibernate-mapping/class/id");
				String idName =idElement.attribute("name").getValue();
				String idType =idElement.attribute("type").getValue();
				logger.info(idName);
				logger.info(idType);
				
				List<Element> propertyElements =(List<Element>) document.selectNodes("/hibernate-mapping/class/property");
				for (Element propertyElement : propertyElements) {					
					String propertyName =propertyElement.attribute("name").getValue();
					String propertyType =propertyElement.attribute("type").getValue();
					logger.info(propertyName);
					logger.info(propertyType);
				}
				
				
				//查询book id = b002 的元素   java.lang.NoClassDefFoundError
				Node node = document.selectSingleNode("//book[@id='b002']"); 
				
				//System.out.println(node);
	}

}
