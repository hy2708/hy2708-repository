package org.hy.commons.xml.w3c;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hy.commons.io.core.ProjectPathUtil;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOMUtil {

	private File inputXml;
	private InputStream xmlInputStream;

	public DOMUtil() {
		super();
	}

	public DOMUtil(String filepath) {
		this.inputXml = new File(filepath);
		if (!inputXml.exists()) {
			throw new RuntimeException("ssssssssssss");
		}
	}

	public DOMUtil(File inputXml) {
		this.inputXml = inputXml;
		if (!inputXml.exists()) {
			throw new RuntimeException("ssssssssssss");
		}
	}
	
	 /**  
     * 初始化一个空Document对象返回。  
     *  
     * @return a Document  
     */  
    public static Document newXMLDocument() {  
        try {  
            return newDocumentBuilder().newDocument();  
        } catch (ParserConfigurationException e) {  
            throw new RuntimeException(e.getMessage());  
        }  
    }  
  
    /**  
     * 初始化一个DocumentBuilder  
     *  
     * @return a DocumentBuilder  
     * @throws ParserConfigurationException  
     */  
    public static DocumentBuilder newDocumentBuilder()  
            throws ParserConfigurationException {  
        return newDocumentBuilderFactory().newDocumentBuilder();  
    }  
  
    /**  
     * 初始化一个DocumentBuilderFactory  
     *  
     * @return a DocumentBuilderFactory  
     */  
    public static DocumentBuilderFactory newDocumentBuilderFactory() {  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        dbf.setNamespaceAware(true);  
        return dbf;  
    }  
  
    /**  
     * 将传入的一个XML String转换成一个org.w3c.dom.Document对象返回。  
     *  
     * @param xmlString  
     *            一个符合XML规范的字符串表达。  
     * @return a Document  
     */  
    public static Document parseXMLDocument(String xmlString) {  
        if (xmlString == null) {  
            throw new IllegalArgumentException();  
        }  
        try {  
            return newDocumentBuilder().parse(  
                    new InputSource(new StringReader(xmlString)));  
        } catch (Exception e) {  
            throw new RuntimeException(e.getMessage());  
        }  
    }  
  
    /**  
     * 给定一个输入流，解析为一个org.w3c.dom.Document对象返回。  
     *  
     * @param input  
     * @return a org.w3c.dom.Document  
     */  
    public static Document parseXMLDocument(InputStream input) {  
        if (input == null) {  
            throw new IllegalArgumentException("参数为null！");  
        }  
        try {  
            return newDocumentBuilder().parse(input);  
        } catch (Exception e) {  
            throw new RuntimeException(e.getMessage());  
        }  
    }  
  
    /**  
     * 给定一个文件名，获取该文件并解析为一个org.w3c.dom.Document对象返回。  
     *  
     * @param fileName  
     *            待解析文件的文件名  
     * @return a org.w3c.dom.Document  
     */  
    public static Document loadXMLDocumentFromFile(String fileName) {  
        if (fileName == null) {  
            throw new IllegalArgumentException("未指定文件名及其物理路径！");  
        }  
        try {  
            return newDocumentBuilder().parse(new File(fileName));  
        } catch (SAXException e) {  
            throw new IllegalArgumentException("目标文件（" + fileName  
                    + "）不能被正确解析为XML！" + e.getMessage());  
        } catch (IOException e) {  
            throw new IllegalArgumentException("不能获取目标文件（" + fileName + "）！"  
                    + e.getMessage());  
        } catch (ParserConfigurationException e) {  
            throw new RuntimeException(e.getMessage());  
        }  
    }  
  
    
  
    /**  
     * 给定一个节点，将该节点加入新构造的Document中。  
     *  
     * @param node  
     *            a Document node  
     * @return a new Document  
     */  
  
    public static Document newXMLDocument(Node node) {  
        Document doc = newXMLDocument();  
        doc.appendChild(doc.importNode(node, true));  
        return doc;  
    }  
  
    /**  
     * 将传入的一个DOM Node对象输出成字符串。如果失败则返回一个空字符串""。  
     *  
     * @param node  
     *            DOM Node 对象。  
     * @return a XML String from node  
     */  
  
    /*  
     * public static String toString(Node node) { if (node == null) { throw new  
     * IllegalArgumentException(); } Transformer transformer = new  
     * Transformer(); if (transformer != null) { try { StringWriter sw = new  
     * StringWriter(); transformer .transform(new DOMSource(node), new  
     * StreamResult(sw)); return sw.toString(); } catch (TransformerException  
     * te) { throw new RuntimeException(te.getMessage()); } } return ""; }  
     */  
  
    /**  
     * 将传入的一个DOM Node对象输出成字符串。如果失败则返回一个空字符串""。  
     *  
     * @param node  
     *            DOM Node 对象。  
     * @return a XML String from node  
     */  
  
    /*  
     * public static String toString(Node node) { if (node == null) { throw new  
     * IllegalArgumentException(); } Transformer transformer = new  
     * Transformer(); if (transformer != null) { try { StringWriter sw = new  
     * StringWriter(); transformer .transform(new DOMSource(node), new  
     * StreamResult(sw)); return sw.toString(); } catch (TransformerException  
     * te) { throw new RuntimeException(te.getMessage()); } } return ""; }  
     */  
  
    /**  
     * 获取一个Transformer对象，由于使用时都做相同的初始化，所以提取出来作为公共方法。  
     *  
     * @return a Transformer encoding gb2312  
     */  
  
    public static Transformer newTransformer() {  
        try {  
            Transformer transformer = TransformerFactory.newInstance()  
                    .newTransformer();  
            Properties properties = transformer.getOutputProperties();  
            properties.setProperty(OutputKeys.ENCODING, "gb2312");  
            properties.setProperty(OutputKeys.METHOD, "xml");  
            properties.setProperty(OutputKeys.VERSION, "1.0");  
            properties.setProperty(OutputKeys.INDENT, "no");  
            transformer.setOutputProperties(properties);  
            return transformer;  
        } catch (TransformerConfigurationException tce) {  
            throw new RuntimeException(tce.getMessage());  
        }  
    }  
  
    /**  
     * 返回一段XML表述的错误信息。提示信息的TITLE为：系统错误。之所以使用字符串拼装，主要是这样做一般 不会有异常出现。  
     *  
     * @param errMsg  
     *            提示错误信息  
     * @return a XML String show err msg  
     */  
    /*  
     * public static String errXMLString(String errMsg) { StringBuffer msg = new  
     * StringBuffer(100);  
     * msg.append("<?xml version="1.0" encoding="gb2312" ?>");  
     * msg.append("<errNode title="系统错误" errMsg="" + errMsg + ""/>"); return  
     * msg.toString(); }  
     */  
    /**  
     * 返回一段XML表述的错误信息。提示信息的TITLE为：系统错误  
     *  
     * @param errMsg  
     *            提示错误信息  
     * @param errClass  
     *            抛出该错误的类，用于提取错误来源信息。  
     * @return a XML String show err msg  
     */  
    /*  
     * public static String errXMLString(String errMsg, Class errClass) {  
     * StringBuffer msg = new StringBuffer(100);  
     * msg.append("<?xml version='1.0' encoding='gb2312' ?>");  
     * msg.append("<errNode title="  
     * 系统错误" errMsg=""+ errMsg + "" errSource=""+ errClass.getName()+ ""/>");  
     * 　return msg.toString(); }  
     */  
    /**  
     * 返回一段XML表述的错误信息。  
     *  
     * @param title  
     *            提示的title  
     * @param errMsg  
     *            提示错误信息  
     * @param errClass  
     *            抛出该错误的类，用于提取错误来源信息。  
     * @return a XML String show err msg  
     */  
  
    public static String errXMLString(String title, String errMsg,  
            Class errClass) {  
        StringBuffer msg = new StringBuffer(100);  
        msg.append("<?xml version='1.0' encoding='utf-8' ?>");  
        msg.append("<errNode title=" + title + "errMsg=" + errMsg  
                + "errSource=" + errClass.getName() + "/>");  
        return msg.toString();  
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
	
	
   // 1、将XML文件的内容转化为String
    /** 
     * doc2String 
     * 将xml文档内容转为String 
     * @return 字符串 
     * @param document 
     */ 
    public static String convertToString(Document document) 
    { 
       String s = ""; 
       try 
       { 
           TransformerFactory tFactory = TransformerFactory.newInstance();    
           Transformer transformer = tFactory.newTransformer(); 
           /** 使用GB2312编码 */ 
           //transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312"); 
           Source source = new DOMSource( document );             
           /** 直接输出到控制台 */ 
           //Result output = new StreamResult( System.out );          
           StringWriter out = new StringWriter();  
           Result output = new StreamResult( out ); 
           transformer.transform( source, output ); 
           out.flush(); 
           s = out.toString(); 
       }catch(Exception ex) 
       {             
           ex.printStackTrace(); 
       }       
       return s; 
    }
 //2、将符合XML格式的String 转化为XML Document
    /** 
     * string2Document 
     * 将字符串转为Document 
     * @return  
     * @param s xml格式的字符串 
     */ 
    public static Document string2Document(String s) 
    { 
       Document document = null; 
       try 
       { 
           DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
           document = parser.parse( new InputSource(new StringReader(s)) ); 
       }catch(Exception ex) 
       {             
            ex.printStackTrace(); 
       } 
       return document; 
    }
 //3、将Document对象保存为一个xml文件到本地
    /** 
     * doc2XmlFile 
     * 将Document对象保存为一个xml文件到本地 
     * @return true:保存成功  flase:失败 
     * @param filename 保存的文件名 
     * @param document 需要保存的document对象 
     */ 
    public static boolean doc2XmlFile(Document document,String filename) 
    { 
       boolean flag = true; 
       try 
       { 
             /** 将document中的内容写入文件中  */ 
             TransformerFactory tFactory = TransformerFactory.newInstance();    
             Transformer transformer = tFactory.newTransformer();  
             /** 编码 */ 
             //transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312"); 
             DOMSource source = new DOMSource(document);  
             StreamResult result = new StreamResult(new File(filename));    
             transformer.transform(source, result);  
         }catch(Exception ex) 
         { 
             flag = false; 
             ex.printStackTrace(); 
         } 
         return flag;       
    }
 //4、将xml格式的字符串保存为本地文件，如果字符串格式不符合xml规则，则返回失败
    /** 
     * string2XmlFile 
     * 将xml格式的字符串保存为本地文件，如果字符串格式不符合xml规则，则返回失败 
     * @return true:保存成功  flase:失败 
     * @param filename 保存的文件名 
     * @param str 需要保存的字符串 
     */ 
    public static boolean string2XmlFile(String str,String filename) 
    { 
       boolean flag = true; 
       /* 以下格式生成的文件是以UTF-8为格式 */ 
       try 
       { 
          Document doc = string2Document(str);        
          flag = doc2XmlFile(doc,filename); 
       }catch (Exception ex) 
       { 
          flag = false; 
          ex.printStackTrace(); 
       } 
       /** 以下不通过xml格式验证，象生成普通文件格式的方法生成xml文件 
         OutputStream os = null;        
         try { 
                 os = new FileOutputStream(filename); 
                 os.write(str.getBytes()); 
                 os.flush(); 
         } catch (Exception ex) { 
                 flag = false; 
                 ex.printStackTrace(); 
         }finally 
         {      
               try{  
                 if (os!=null) os.close(); 
               }catch (Exception ex) { 
                 ex.printStackTrace(); 
               }               
         } 
          */ 
       return flag; 
    }
 //5、载入一个xml文档
    /** 
     * load 
     * 载入一个xml文档 
     * @return 成功返回Document对象，失败返回null 
     * @param uri 文件路径 
     */ 
    public static Document load(String filename) 
    { 
       Document document = null; 
       try  
       {  
            DocumentBuilderFactory  factory = DocumentBuilderFactory.newInstance();    
            DocumentBuilder builder=factory.newDocumentBuilder();    
            document=builder.parse(new File(filename));    
            document.normalize(); 
       } 
       catch (Exception ex){ 
           ex.printStackTrace(); 
       }   
       return document; 
    }
 //6、演示String保存为xml文件
    /** 
     * xmlWriteDemoByString 
     * 演示String保存为xml文件 
     */ 
    public void xmlWriteDemoByString() 
    { 
       String s = ""; 
       /** xml格式标题 "<?xml version='1.0' encoding='GB2312'?>" 可以不用写*/ 
       s = "<?xml version='1.0' encoding='GB2312'?>" 
          +"<config>\r\n" 
          +"   <ftp name='DongDian'>\r\n" 
          +"     <ftp-host>127.0.0.1</ftp-host>\r\n" 
          +"     <ftp-port>21</ftp-port>\r\n" 
          +"     <ftp-user>cxl</ftp-user>\r\n" 
          +"     <ftp-pwd>longshine</ftp-pwd>\r\n" 
          +"     <!-- ftp最多尝试连接次数 -->\r\n" 
          +"     <ftp-try>50</ftp-try>\r\n" 
          +"     <!-- ftp尝试连接延迟时间 -->\r\n" 
          +"     <ftp-delay>10</ftp-delay>\r\n" 
          +"     <ftp-chn>中文</ftp-chn>\r\n" 
          +"  </ftp>\r\n" 
          +"</config>\r\n"; 
       //将文件生成到classes文件夹所在的目录里    
       string2XmlFile(s,"xmlWriteDemoByString.xml");    
       //将文件生成到classes文件夹里    
       string2XmlFile(s,"classes/xmlWriteDemoByString.xml");   
    }
 //7、演示手动创建一个Document，并保存为XML文件
    /** 
     * 演示手动创建一个Document，并保存为XML文件 
     */ 
    public void xmlWriteDemoByDocument() 
    { 
         /** 建立document对象 */ 
         try  
         {  
            DocumentBuilderFactory  factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder(); 

            Document document = builder.newDocument(); 
            /** 建立config根节点 */ 
            Element configElement = document.createElement("config"); 
            document.appendChild( configElement ); 
            /** 建立ftp节点 */ 
            Comment cmt = document.createComment("东电ftp配置");         
            configElement.appendChild(cmt);         
         
            Element ftpElement = document.createElement("ftp"); 
            configElement.appendChild(ftpElement); 
            ftpElement.setAttribute("name","DongDian"); 
            /** ftp 属性配置 */ 
            Element element = document.createElement("ftp-host"); 
            element.appendChild(document.createTextNode( "127.0.0.1" )); 
            ftpElement.appendChild(element); 
             
            element = document.createElement("ftp-port"); 
            element.appendChild(document.createTextNode( "21" )); 
            ftpElement.appendChild(element); 
             
            element = document.createElement("ftp-user"); 
            element.appendChild(document.createTextNode( "cxl" )); 
            ftpElement.appendChild(element); 
             
            element = document.createElement("ftp-pwd"); 
            element.appendChild(document.createTextNode( "longshine" )); 
            ftpElement.appendChild(element); 
             
            element = document.createElement("ftp-try"); 
            element.appendChild(document.createTextNode( "50" )); 
            ftpElement.appendChild(element); 
             
            element = document.createElement("ftp-chn"); 
            element.appendChild(document.createTextNode( "中文" )); 
            ftpElement.appendChild(element); 
             
            /** 保存Document */ 
            doc2XmlFile(document,"classes/xmlWriteDemoByDocument.xml"); 
       } 
       catch (Exception ex){ 
           ex.printStackTrace(); 
       }        
    }
 //8、演示读取文件的具体某个节点的值
    /** 
     *  演示读取文件的具体某个节点的值  
     */ 
    public static void xmlReadDemo() 
    { 
       Document document = load("classes/xmlWriteDemoByDocument.xml"); 
       Node root=document.getDocumentElement(); 
       /** 如果root有子元素 */ 
       if(root.hasChildNodes()) 
       { 
          /** ftpnodes */ 
          NodeList ftpnodes = root.getChildNodes(); 
          /** 循环取得ftp所有节点 */ 
          for (int i=0;i<ftpnodes.getLength();i++) 
          { 
             NodeList ftplist = ftpnodes.item(i).getChildNodes(); 
             for (int k=0;k<ftplist.getLength();k++) 
             { 
               Node subnode = ftplist.item(k); 
               if (subnode.getNodeType()==Node.ELEMENT_NODE) 
               { 
                 /** 打印ftp所有节点属性的值 */ 
                 System.out.println(subnode.getNodeName()+":"+subnode.getFirstChild().getNodeValue()); 
               } 
             } 
          } 
       } 
    }
 //9、演示修改文件的具体某个节点的值
    /** 
     *  演示修改文件的具体某个节点的值  
     */ 
    public static void xmlUpdateDemo() 
    { 
       Document document = load("classes/xmlWriteDemoByDocument.xml"); 
       Node root=document.getDocumentElement(); 
       /** 如果root有子元素 */ 
       if(root.hasChildNodes()) 
       { 
          /** ftpnodes */ 
          NodeList ftpnodes = root.getChildNodes(); 
          /** 循环取得ftp所有节点 */ 
          for (int i=0;i<ftpnodes.getLength();i++) 
          {                       
             NodeList ftplist = ftpnodes.item(i).getChildNodes(); 
             for (int k=0;k<ftplist.getLength();k++) 
             { 
               Node subnode = ftplist.item(k); 
               /** 删除ftp-chn节点 */ 
               if (subnode.getNodeType()==Node.ELEMENT_NODE&&subnode.getNodeName()=="ftp-chn") 
               { 
                  ftpnodes.item(i).removeChild(subnode); 
               } 
               /** 修改ftp-host的值为 192.168.0.1 */ 
               if (subnode.getNodeType()==Node.ELEMENT_NODE&&subnode.getNodeName()=="ftp-host") 
               {                  
                  subnode.getFirstChild().setNodeValue("192.168.0.1"); 
               } 
             } 
              
          } 
       } 
       /** 修改完后重新保存 */ 
       doc2XmlFile(document,"classes/xmlWriteDemoByDocument.xml"); 
    }
	
	
	

	
	
	

	public static void main(String[] argv) {

		String filepath =ProjectPathUtil.getProjectClassPath()+File.separator+"books.xml";
//		String filepath = ProjectPathUtil.getProjectClassPath()
//				+ File.separator + "books.xml";
		System.err.println(filepath);
		Document document = loadXMLDocumentFromFile(filepath);
		//toString2(document);
		String string =convertToString(document);
		System.err.println(string);
		// dom4jParser.traversalDocumentByIterator();
		// dom4jParser.traversalDocumentByVisitor();
		
	}
}