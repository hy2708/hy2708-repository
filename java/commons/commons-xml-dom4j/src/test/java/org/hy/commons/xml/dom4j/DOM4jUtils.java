package org.hy.commons.xml.dom4j;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4jUtils {
    /**
     * 在一个xml文件中，遍历xml文件，根据Element的elementName，取出所有复合条件的Element元素，把它们转换为javabean类型，并放入List中返回。
     */
    public static List parseElementsToObjects(Element root, String elementName) {
        List<Banner> result =  new ArrayList<Banner>();
          List<Element> list = root.elements(elementName);      
          for (Element element : list) {
             Banner banner = new Banner();
             for(Iterator it=element.attributeIterator();it.hasNext();){
                 Attribute attribute = (Attribute) it.next();
                 if(attribute.getName().equals(DOM4jConstant.ELEMENT_ATTRIBUTE_BGURL)){
                     banner.setBnurl(attribute.getValue());
                 }else if(attribute.getName().equals(DOM4jConstant.ELEMENT_ATTRIBUTE_IMG)){
                     banner.setImg(attribute.getValue());
                 }else if(attribute.getName().equals(DOM4jConstant.ELEMENT_ATTRIBUTE_BNTARGET)){
                     banner.setBntarget(attribute.getValue());
                 }
             }
             result.add(banner);            
        }
          return result ;
    }
    /**
     * 根据xml文件的文件名，把xml文件转换成Document对象并返回。
     */
    public static Document getDocument(String fileUrl)throws DocumentException {
        File file = new File(fileUrl);
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        return document;
    }
    /**
     * 根据root 元素的rootName，Element元素的javabean对象以及Element元素的elementName创建Document对象并返回。
     */

    public static Document createDocument(String rootName,Banner banner,String elementName) {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement(rootName);
        setDocumentHeader(root);
        addElement(root,banner,elementName);
        return doc;
    }
    /**
     * 根据Element元素的javabean对象以及Element元素的elementName在Element root下增加一个Element 。
     */
    public static void addElement(Element root, Banner banner,String elementName) {
        Element element = root.addElement(elementName);
        element.addAttribute(DOM4jConstant.ELEMENT_ATTRIBUTE_IMG, banner.getImg()).addAttribute(DOM4jConstant.ELEMENT_ATTRIBUTE_BGURL, banner.getBnurl()).addAttribute(DOM4jConstant.ELEMENT_ATTRIBUTE_BNTARGET, banner.getBntarget()).addText("");
    }
    /**
     * 在Document对象中，以elementName，attributeName，attributeValue为参数删除对应的Element元素。
     */
    public static Document removeElementByAttribute(Document document, String elementName,String attributeName,String attributeValue) {
          List<Element> list = document.getRootElement().elements(elementName);        
        exit:   for (Element element : list) {
             for(Iterator it=element.attributeIterator();it.hasNext();){
                 Attribute attribute = (Attribute) it.next();   
                 if(attribute.getName().equals(attributeName)&&attribute.getValue().equals(attributeValue)){
                     element.getParent().remove(element);
                     break exit;
                 }
             }           
        }
          return document ;        
    }
    /**
     * 把Document对象与filePath对应的物理文件进行同步。
     */
    public static void writeDocumentToFile(Document document, String filePath)throws IOException {
        XMLWriter writer = new XMLWriter(new FileWriter(filePath));
        writer.write(document);
        writer.flush();
        writer.close();
    }
    /**
     * 设置Document对象的文件头。
     */
    public static void setDocumentHeader(Element root) {
        Element fixedbn = root.addElement("fixedbn");
        fixedbn.addElement("fixedlink").addAttribute("posx", "0")
                                       .addAttribute("posy", "0")
                                       .addAttribute("scalex", "1510")
                                       .addAttribute("scaley", "800")
                                       .addAttribute("bnurl", "http://www.lanrentuku.com/")
                                       .addAttribute("bntarget", "_self")
                                       .addText("");
        fixedbn.addElement("fixedlink").addAttribute("posx", "0")
                                       .addAttribute("posy", "80")
                                       .addAttribute("scalex", "1510")
                                       .addAttribute("scaley", "1150")
                                       .addAttribute("bnurl", "http://www.lanrentuku.com/")
                                       .addAttribute("bntarget", "_self")
                                       .addText("");
        fixedbn.addAttribute("alpha_num", "0");
    }

}




