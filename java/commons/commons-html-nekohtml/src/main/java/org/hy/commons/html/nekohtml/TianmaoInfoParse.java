package org.hy.commons.html.nekohtml;

import it.svario.xpathapi.jaxp.XPathAPI;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.cyberneko.html.parsers.DOMParser;
import org.dom4j.io.DOMReader;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.exception.HttpException;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.http.HttpUnitUtil;
import org.hy.commons.xml.w3c.DOMUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TianmaoInfoParse {
	public static String visitUrl(String url) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		client.getParams().setParameter(
			      HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		// 设置代理服务器地址和端口

		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		//String chinese= URLEncoder.encode("啊啊啊啊啊啊", "utf-8"); 
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		HttpMethod method = new GetMethod(url);
		// 使用POST方法
		// HttpMethod method = new PostMethod("http://java.sun.com");
		client.executeMethod(method);

		// 打印服务器返回的状态
		System.out.println(method.getStatusLine());
		// 打印返回的信息
		String htmlContent = method.getResponseBodyAsString();

		// 释放连接
		method.releaseConnection();
		
		//logger.debug(htmlContent);
		
		return htmlContent;
	}

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
		Document document = NekoUtil.getDocument(
				"http://detail.tmall.com/item.htm?id=15916077445&ali_trackid=2:mm_31651633_0_0:1379495059_6k4_724291913"

				);
		String string =parse(
				document,
				"49.9");
		//String string =HttpUnitUtil.visitUrl(
		//"http://mdskip.taobao.com/core/initItemDetail.htm?isSpu=false&isIFC=false&isNewDecorate=true&sellerUserTag4=1729382399350965635&notAllowOriginPrice=false&sellerUserTag2=18020085113290752&sellerUserTag3=633318731186304&isAreaSell=false&isForbidBuyItem=false&rtk=rstime_sid64581872pid391480980&tmallBuySupport=true&itemTags=775,907,1163,1478,1483,1803,2049,2123,2251,3974,4166,8258&household=false&sellerUserTag=303632416&queryMemberRight=true&tgTag=false&isRegionLevel=false&isUseInventoryCenter=false&itemId=15916077445&isSecKill=false&renderTime=1379584117669&isApparel=true&showTagPrice=false&lastVersionMD5=5dd86f86b12418b6da85c8755950b7aa&releaseTime=1379322216000&hitPrizeAuction=false&showShopProm=true&service3C=false&cartEnable=true&callback=onMdskip&ip=&campaignId=&key=&abt=&cat_id=&q=&u_channel=&areaId=&ref=http%253A%252F%252Fs.click.taobao.com%252Ft_js%253Ftu%253Dhttp%25253A%25252F%25252Fs.click.taobao.com%25252Ft%25253Fe%25253DzGU34CA7K%2525252BPkqB07S4%2525252FK0CFcRfH0GoT805sipKkHWyjqLnsc4Vz0rz%2525252BFvz6bGzP3YH8lF4CkN%2525252Fm9khLXO1hZx6ZTdqZ7VRIii2GDiu731Qt9iA%2525253D%2525253D%252526ref%25253D%252526et%25253DjFBDMTp0JqFFAg%2525253D%2525253D&brandSiteId=0",
		//		"get");
		//System.err.println(string);
		//System.err.println(string);
    }   
  
	

	public static String parse(Document doc,String keyword) throws Exception {
		//获取网页里面的keywords和description 
        
       //System.err.println(document.getText());
       //Document doc = Dom4jUtil.parse(Dom4jUtil.getDocument(new FileReader(file))); 
//       System.err.println("解析得到的Document对象是"+DOMUtil.convertToString(doc));;
      // FileUtil.writeString(file, doc.getElementsByTagName("HTML").item(0).getTextContent(),"gbk");
//       System.err.println("解析得到的Document对象是"+StringUtil.convertCharset(doc.getElementsByTagName("HTML").item(0).getTextContent(), "gbk", "utf-8"));
//       System.err.println("解析得到的Document对象是"+new String(doc.getElementsByTagName("HTML").item(0).getTextContent().getBytes("iso8859-1"), "gbk"));
       Element el2 = doc.getElementById("J_PromoBox");
       System.err.println("解析得到的Document对象是"+el2.getTextContent());

       System.err.println(DOMUtil.toStringFromDoc(doc));
       System.err.println(doc.getElementsByTagName("body"));
       System.err.println(doc.getChildNodes().item(1));
       System.err.println("========================================"+doc.getTextContent());
        
//        String productsXpath = "/HTML/BODY/DIV[2]/DIV[4]/DIV[2]/DIV/DIV[3]/UL[@class]/LI[9]";  
        // tags should be in upper case  
        //String productsXpath = "/html/body/div[10]/div/div[2]/div/div/div/div";
        /*
         * 商品名称与备注，相关信息/html/body/div[10]/div/div[2]/div/div/div/div
         * /html/body/div[10]/div/div[2]/div/div/div/div
         */
        String productNameXpath = "/HTML/BODY/DIV[10]/DIV/DIV[2]/DIV/DIV/DIV/DIV";  
        /*
         * 商品促销价格，相关信息//*[@id="J_PromoBox"]
         */
        String productPriceXpath = "//*[@id='J_PromoBox']";  
 
        //获得页面中的所有产品的产品列表
        NodeList products=null; 
        //products = XPathAPI.selectNodeList(doc, productsXpath);
        String string3 =XPathAPI.selectSingleNodeAsString(doc, "//*[@id='J_PromoBox']");
        String string =XPathAPI.selectSingleNodeAsString(doc, productNameXpath);
        NodeList str =XPathAPI.selectNodeList(doc, productNameXpath);
        NodeList str2 =XPathAPI.selectNodeList(doc, "/HTML/BODY");
        String str22 =XPathAPI.selectSingleNodeAsString(doc, "/HTML/BODY");
        
        Element el = doc.getElementById("J_PromoBox");
        String s = el.getTextContent();
        System.err.println(s);
        System.err.println("zzzzzzzzzzzzzzzzz000000---"+s);
        //System.err.println("77777777777"+str22);
        System.err.println("77777777777"+str2.item(0));
        System.err.println("111111111"+string3);
        System.err.println("222222222"+string);
        String string2 =XPathAPI.selectSingleNodeAsString(doc, productPriceXpath);
        //String string2 =XPathAPI.tSingleNodeAsString(doc, productPriceXpath);
        System.err.println("nnnnnnnnnnnnnnnnnnnnnn"+string2);
        if (StringUtils.contains(string, keyword)) {
			return string+string2;
		}
        if (StringUtils.contains(string2, keyword)) {
			return string+string2;
		}
        //DOMUtil.writeToFile(ProjectPathUtil.getProjectResourcesDirPath()+FileUtil.fileSeparator+"01.temp", doc);
        return null;
		//遍历每一个产品
//        for(int i=0; i< products.getLength();i++)  
        /*for(int i=0; i< 1;i++)  
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
			
        	
        	
            
		}*/   
        
		/*Node node = null;  
		for(int i=0; i< products.getLength();i++)  
		{  
		    node = products.item(i);  
		    
		    NamedNodeMap nodeMap = node.getAttributes();
		    
		    System.out.println( i + ":\n" + node.getTextContent());  
		} */  
	}
	

}
