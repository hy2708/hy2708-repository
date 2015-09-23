package org.hy.commons.xml.dom4j;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import java_cup.runtime.virtual_parse_stack;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.xml.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPathTest_mybatis_config {
	
	static Logger logger = LoggerFactory.getLogger(XPathTest.class);	
	
	public static void main(String[] args) throws Exception {
		
	
		//获得document
				//获得解析流
				//SAXReader reader = new SAXReader();
				//解析xml
				//Document document  = reader.read(filepath);
				String filepath = ProjectPathUtil.getProjectResourcesDirPath()
				+ File.separator + 
				//"Person.hbm.xml";
				"mybatis-config.xml";
				
				String filepath2 = ProjectPathUtil.getProjectResourcesDirPath()
						+ File.separator + 
						//"Person.hbm.xml";
						"mmmmmmmm.xml";
						
				Document document = new XmlUtil(filepath).getDocument();
				//System.err.println(document);
				
				logger.info(document.selectSingleNode("/configuration").getName());
				logger.info(document.selectSingleNode("/configuration").toString());
				logger.info(document.selectSingleNode("/configuration/mappers").getName());
				logger.info(document.selectNodes("/configuration/mappers").size()+"");
				logger.info(document.selectSingleNode("/configuration/mappers/mapper").getName());
				logger.info(document.selectNodes("/configuration/mappers/mapper").size()+"");
				logger.info(document.selectSingleNode("/configuration/mappers/mapper[@class]").toString());
				Element mappers = (Element) document.selectSingleNode("/configuration/mappers");
				Element element = mappers.addElement("mmm");
				element.setAttributeValue("sf", "545");
				List<Element> list= document.selectNodes("/configuration/mappers/mapper");
				for (Element element2 : list) {
					element2.addElement("aaa");
					logger.info("");
				}
				XmlUtil.writeToFile(filepath2, document);

				//查询book id = b002 的元素   java.lang.NoClassDefFoundError
				//Node node = document.selectSingleNode("//mapper[@id='b002']"); 
				
				//System.out.println(node);
	}

}
