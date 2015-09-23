package org.hy.commons.html.nekohtml;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeUtil {

	private static Logger logger = LoggerFactory.getLogger(NodeUtil.class);

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：判断Node的类型，是否为DIV标签</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-3-9；时间：下午2:45:11</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param node
	 * @return
	 * @return
	 */
	public static Boolean isDiv(Node node) {

		return isNodeName(node, "DIV");

	}

	public static Boolean isNodeName(Node node, String nodeName) {

		if (node.getNodeName().equalsIgnoreCase(nodeName)) {
			return true;
		}
		return false;

	}

	public static void printAllNodeAttributesInfo(Node node) {

		Element element = (Element) node;
		printAllElementAttributesInfo(element);

	}

	public static void printAllElementAttributesInfo(Element element) {

		for (int k = 0; k < element.getAttributes().getLength(); k++) {
			logger.debug(element.getAttributes().item(k).toString());
		}

	}
	
	public static List<Element> findElementsByElementName(Element element,String elementName) {
		List<Element> list = new LinkedList<Element>();
		NodeList childNodes = element.getChildNodes();
		for (int j = 0; j < childNodes.getLength(); j++) {
			//System.err.println(childNodes.item(j));
			//System.err.println(childNodes.item(j).getNodeName());
			Element subElement =null;
			//找到elementName结点
			if (childNodes.item(j).getNodeName().equalsIgnoreCase(elementName)) {
				subElement=(Element) childNodes.item(j);;
				list.add(subElement);
				
			}
			
		}
		
		if (list==null||list.size()==0) {
			return null;
		} else {
			return list;
		}
	}

	public static Element findElementByElementAndAttribute(Element element,String elementName,String attributeName,String attributeValue) {

		if (element==null) {
			throw new RuntimeException("Element 结点不能为空!\n" +
					" elementName:"+elementName+
					"\n attributeName :"+attributeName+
					"\n attributeValue :"+attributeValue);
		}
		List<Element> list = findElementsByElementName(element, elementName);
		List<Element> resultList =new LinkedList<Element>();
		if (list==null) {
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			Element tempElement = list.get(i);
			if (tempElement.getAttribute(attributeName)!=null&&tempElement.getAttribute(attributeName).equals(attributeValue)) {
				logger.debug(tempElement.getAttribute(attributeName));
				resultList.add(list.get(i));
			}
		}
		
		if (resultList.size()==0) {
			return null;
		} else if (resultList.size()>1) {
			throw new RuntimeException("含有多个结果");
		}else {
			return resultList.get(0);
		}
		 
	  
	  }
}
