package org.hy.commons.html.nekohtml;

import it.svario.xpathapi.jaxp.XPathAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.cyberneko.html.parsers.DOMParser;
import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.xml.dom4j.Dom4jUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FivepaiStorage {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-3-12；时间：下午8:34:45</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 * @return 
	 */
	public static void main(String[] argv) throws Exception {  
		
    }   
  

	@Test
	public void persist5PaiData() throws Exception {
        File file = FileUtil.createFile(ProjectPathUtil.getProjectResourcesDirPath()+FileUtil.fileSeparator+"01.temp");

		//获取网页里面的keywords和description 
        //BufferedReader in = new BufferedReader(new FileReader("d:/5pai/2013-3-13/2013-3-13-h15-0.html"));

        BufferedReader in = new BufferedReader(new FileReader(file));  
        DOMParser parser = new DOMParser();  
         /*parser.setProperty(  
                 "http://cyberneko.org/html/properties/default-encoding",  
                 "gb2312");*/ 
        /**
        The Xerces HTML DOM implementation does not support namespaces  
        and cannot represent XHTML documents with namespace information.  
        Therefore, in order to use the default HTML DOM implementation with NekoHTML's  
        DOMParser to parse XHTML documents, you must turn off namespace processing.*/  
        parser.setFeature("http://xml.org/sax/features/namespaces", false);  

        parser.parse(new InputSource(in));  
          
        Document doc = parser.getDocument();  
        System.err.println(Dom4jUtil.toStringFromDoc(doc));
        System.err.println(doc.getElementsByTagName("body").item(0));
        System.err.println(doc.getChildNodes().item(1));
        System.err.println("ccccccccc"+doc.getTextContent());
        
//        String productsXpath = "/HTML/BODY/DIV[2]/DIV[4]/DIV[2]/DIV/DIV[3]/UL[@class]/LI[9]";  
        // tags should be in upper case  
        String productsXpath = "/HTML/BODY/DIV[5]/DIV/DIV[2]/DIV/DIV/DIV";  
 
        //获得页面中的所有产品的产品列表
        NodeList products=null; 
        products = XPathAPI.selectNodeList(doc, productsXpath);  
		System.out.println("found: " + products.getLength());  
		//遍历每一个产品
//        for(int i=0; i< products.getLength();i++)  
        	for(int i=0; i< 1;i++)  
		{  
        	//商品信息的最外层的Element	
        	Element e = (Element) products.item(i);  
        	//System.err.println(e.getChildNodes().getLength());
        	//获得所有子节点，获取真正包含产品信息的Div结点
        	//NodeList childNodes = e.getChildNodes();        	
        	List<Element> elements = NodeUtil.findElementsByElementName(e, "DIV");
        	System.err.println(elements.size());
        	Element element =elements.get(0);
        	
        	//打印商品的拍卖信息01
        	NodeUtil.printAllElementAttributesInfo(element);
			//////////////////////////////////////////////////////////////
			Element n_hn_n_pitem_title = NodeUtil.findElementByElementAndAttribute(element, "H3", "class", "n_hn n_pitem_title");
			Element commodityItem = NodeUtil.findElementsByElementName(n_hn_n_pitem_title, "A").get(0);
			String commodityItemUrl = commodityItem.getAttribute("href");
					String commodityItemName = commodityItem.getAttribute("title");
			System.err.println(commodityItemUrl+commodityItemName);
		///////////////////////////////////////////////////////////////

        	//打印商品的拍卖信息002
			System.err.println(NodeUtil.findElementsByElementName(element, "DIV").size()+"---------------");
			Element n_pi_info= NodeUtil.findElementByElementAndAttribute(element, "DIV", "class", "n_pi_info");
			//////////////////////////////////////////////////////////////
				Element n_pi_pp_clearfix = NodeUtil.findElementByElementAndAttribute(n_pi_info, "DIV", "class", "n_pi_pp clearfix");
				Element n_pi_left = NodeUtil.findElementByElementAndAttribute(n_pi_pp_clearfix, "DIV", "class", "n_pi_left");
				Element n_pi_right = NodeUtil.findElementByElementAndAttribute(n_pi_pp_clearfix, "DIV", "class", "n_pi_right");
				String marketPriceStr = n_pi_right.getTextContent();
				Float marketPrice = Float.valueOf(marketPriceStr.substring(1));
			///////////////////////////////////////////////////////////////
				Element n_pi_p_clearfix_f_t_price = NodeUtil.findElementByElementAndAttribute(n_pi_info, "DIV", "class", "n_pi_p clearfix f_t_price");
				Element n_pi_left_2 = NodeUtil.findElementByElementAndAttribute(n_pi_p_clearfix_f_t_price, "DIV", "class", "n_pi_left");
				Element n_pi_right_2 = NodeUtil.findElementByElementAndAttribute(n_pi_p_clearfix_f_t_price, "DIV", "class", "n_pi_right");
				String auctionPriceStr = n_pi_right_2.getTextContent();
				Float auctionPrice = Float.valueOf(auctionPriceStr.substring(1));
				System.err.println(auctionPrice);
			///////////////////////////////////////////////////////////////
				Element n_pi_u_clearfix_f_t_user = NodeUtil.findElementByElementAndAttribute(n_pi_info, "DIV", "class", "n_pi_u clearfix f_t_user");
				Element n_pi_left_3 = NodeUtil.findElementByElementAndAttribute(n_pi_u_clearfix_f_t_user, "DIV", "class", "n_pi_left");
				Element n_pi_right_noreturn = NodeUtil.findElementByElementAndAttribute(n_pi_u_clearfix_f_t_user, "DIV", "class", "n_pi_right noreturn");
				Element customer = NodeUtil.findElementByElementAndAttribute(n_pi_right_noreturn, "A", "class", "n_u");
				String customerName = customer.getTextContent();
				String customerUrl = customer.getAttribute("href");
			///////////////////////////////////////////////////////////////
				Element n_pi_btn_clearfix = NodeUtil.findElementByElementAndAttribute(n_pi_info, "DIV", "class", "n_pi_btn clearfix");
				Element n_pi_left_4 = NodeUtil.findElementByElementAndAttribute(n_pi_btn_clearfix, "DIV", "class", "n_pi_left");
				Element dealTime = NodeUtil.findElementsByElementName(n_pi_btn_clearfix, "DIV").get(1);
				String dealTimeStr = dealTime.getTextContent();
				System.err.println(dealTimeStr);
				SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm");            
		        Date date = (Date) fmt.parse(dealTimeStr);
		         System.out.println(fmt.format(date));
				System.err.println(date);
			///////////////////////////////////////////////////////////////

			NodeList list = element.getElementsByTagName("DIV");
			
        	
        	
            
		}   
        
		/*Node node = null;  
		for(int i=0; i< products.getLength();i++)  
		{  
		    node = products.item(i);  
		    
		    NamedNodeMap nodeMap = node.getAttributes();
		    
		    System.out.println( i + ":\n" + node.getTextContent());  
		} */  
	}
	

}
