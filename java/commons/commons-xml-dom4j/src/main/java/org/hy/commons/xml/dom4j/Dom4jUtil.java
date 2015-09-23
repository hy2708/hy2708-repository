package org.hy.commons.xml.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ProcessingInstruction;
import org.dom4j.VisitorSupport;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.xml.IgnoreDTDEntityResolver;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Dom4jUtil {

	private File inputXml;
	private InputStream xmlInputStream;

	public Dom4jUtil() {
		super();
	}

	public Dom4jUtil(String filepath) {
		this.inputXml = new File(filepath);
		if (!inputXml.exists()) {
			throw new RuntimeException("ssssssssssss");
		}
	}

	public Dom4jUtil(File inputXml) {
		this.inputXml = inputXml;
		if (!inputXml.exists()) {
			throw new RuntimeException("ssssssssssss");
		}
	}
	
	/**
	 * org.w3c.dom.Document -> org.dom4j.Document
	 * 
	 * @param doc
	 *            Document(org.w3c.dom.Document)
	 * @return Document
	 */
	public static Document parse(org.w3c.dom.Document doc) throws Exception {
		if (doc == null) {
			return (null);
		}
		org.dom4j.io.DOMReader xmlReader = new org.dom4j.io.DOMReader();
		return (xmlReader.read(doc));
	}

	/**
	 * org.dom4j.Document -> org.w3c.dom.Document
	 * 
	 * @param doc
	 *            Document(org.dom4j.Document)
	 * @throws Exception
	 * @return Document
	 */
	public static org.w3c.dom.Document parse(Document doc) throws Exception {
		if (doc == null) {
			return (null);
		}
		java.io.StringReader reader = new java.io.StringReader(doc.asXML());
		org.xml.sax.InputSource source = new org.xml.sax.InputSource(reader);
		javax.xml.parsers.DocumentBuilderFactory documentBuilderFactory = javax.xml.parsers.DocumentBuilderFactory
				.newInstance();
		javax.xml.parsers.DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		return   (documentBuilder.parse(source));  
   }
	
	/**  
     * 将传入的一个DOM Node对象输出成字符串。如果失败则返回一个空字符串""。  
     *  
     * @param node  
     *            DOM Node 对象。  
     * @return a XML String from node  
     */  
  
      
	public static String toString(Node node) {
		if (node == null) {
			throw new IllegalArgumentException();
		}
		Transformer transformer = new Transformer();
		if (transformer != null) {
			try {
				StringWriter sw = new StringWriter();
				transformer
						.transform(new DOMSource(node), new StreamResult(sw));
				return sw.toString();
			} catch (TransformerException te) {
				throw new RuntimeException(te.getMessage());
			}
		}
		return "";
	}
       

	/*  
     * 把dom文件转换为xml字符串  
     */  
    public static String toStringFromDoc(org.w3c.dom.Document document) {  
        String result = null;  
  
        if (document != null) {  
            StringWriter strWtr = new StringWriter();  
            StreamResult strResult = new StreamResult(strWtr);  
            TransformerFactory tfac = TransformerFactory.newInstance();  
            try {  
                javax.xml.transform.Transformer t = tfac.newTransformer();  
                t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");  
                t.setOutputProperty(OutputKeys.INDENT, "yes");  
                t.setOutputProperty(OutputKeys.METHOD, "xml"); // xml, html,  
                // text  
                t.setOutputProperty(  
                        "{http://xml.apache.org/xslt}indent-amount", "4");  
                t.transform(new DOMSource(document.getDocumentElement()),  
                        strResult);  
            } catch (Exception e) {  
                System.err.println("XML.toString(Document): " + e);  
            }  
            result = strResult.getWriter().toString();  
            try {  
                strWtr.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
  
        return result;  
    }  
	
	public Document getDocument() {
		SAXReader saxReader = new SAXReader();
		saxReader.setEntityResolver(new IgnoreDTDEntityResolver()); 
		Document document = null;
		try {
			document = saxReader.read(inputXml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public static Document getDocument(InputStream inputStream) {
		SAXReader saxReader = new SAXReader();
		saxReader.setEntityResolver(new IgnoreDTDEntityResolver()); 
		Document document = null;
		try {
			document = saxReader.read(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public static Document getDocument(Reader reader) {
		SAXReader saxReader = new SAXReader();
		try {
			saxReader.setFeature("http://xml.org/sax/features/namespaces", false);
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		saxReader.setEntityResolver(new IgnoreDTDEntityResolver()); 
		Document document = null;
		try {
			document = saxReader.read(reader);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

	public Element getRootElement() {
		return getDocument().getRootElement();
	}
	
	public static void writeToFile(String filepath,Document document) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		OutputFormat outputFormat = new OutputFormat("   ", true);
		format.setEncoding("UTF-8");    // 指定XML编码
		XMLWriter xmlWriter = null;
		try {
			xmlWriter = new XMLWriter(new FileOutputStream(filepath),format);
			xmlWriter.write(document);
			XMLWriter consoleXmlWriter = new XMLWriter(new OutputFormat("   ", true));
			consoleXmlWriter.write(document);
			consoleXmlWriter.flush();
			consoleXmlWriter.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void traversalDocumentByIterator() {
		Element root = getRootElement();
		// 枚举根节点下所有子节点
		for (Iterator ie = root.elementIterator(); ie.hasNext();) {
			System.out.println("======");
			Element element = (Element) ie.next();
			System.out.println(element.getName());

			// 枚举属性
			for (Iterator ia = element.attributeIterator(); ia.hasNext();) {
				Attribute attribute = (Attribute) ia.next();
				System.out.println(attribute.getName() + ":"
						+ attribute.getData());
			}
			// 枚举当前节点下所有子节点
			for (Iterator ieson = element.elementIterator(); ieson.hasNext();) {
				Element elementSon = (Element) ieson.next();
				System.out.println(elementSon.getName() + ":"
						+ elementSon.getText());
			}
		}
	}

	public void traversalDocumentByVisitor() {
		getDocument().accept(new MyVisitor());
	}

	/**
	 * 定义自己的访问者类
	 */
	private static class MyVisitor extends VisitorSupport {
		/**
		 * 对于属性节点，打印属性的名字和值
		 */
		public void visit(Attribute node) {
			System.out.println("attribute : " + node.getName() + " = "
					+ node.getValue());
		}

		/**
		 * 对于处理指令节点，打印处理指令目标和数据
		 */
		public void visit(ProcessingInstruction node) {
			System.out.println("PI : " + node.getTarget() + " "
					+ node.getText());
		}

		/**
		 * 对于元素节点，判断是否只包含文本内容，如是，则打印标记的名字和 元素的内容。如果不是，则只打印标记的名字
		 */
		public void visit(Element node) {
			if (node.isTextOnly())
				System.out.println("element : " + node.getName() + " = "
						+ node.getText());
			else
				System.out.println("--------" + node.getName() + "--------");
		}
	}

	public static void main(String[] argv) {

		String filepath =ProjectPathUtil.getProjectClassPath()+File.separator+"Person.hbm.xml";
//		String filepath = ProjectPathUtil.getProjectClassPath()
//				+ File.separator + "books.xml";
		System.err.println(filepath);
		Dom4jUtil dom4jParser = new Dom4jUtil(filepath);
		System.err.println(dom4jParser.getDocument());
		// dom4jParser.traversalDocumentByIterator();
		// dom4jParser.traversalDocumentByVisitor();
		
	}
}