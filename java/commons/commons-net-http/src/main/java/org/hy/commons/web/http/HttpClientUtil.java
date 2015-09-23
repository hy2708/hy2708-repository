package org.hy.commons.web.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * http://blog.csdn.net/jiangfeng861016/article/details/5994875
 * http://linian411.blog.163.com/blog/static/2077824272012980481102/
 */
public class HttpClientUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	public static final String POST_METHOD ="post";
	public static final String GET_METHOD ="get";
	public static final String LOCALHOST_URL ="http://localhost:8080";
	public static final String MY_APP ="/myApp";
	public static final String HELLO ="/hello";
	public static final String DEFAULT_CHARSET ="utf-8";


	//"http://localhost:8080/myApp/hello";
	public static final String WHOLE_URL =LOCALHOST_URL+MY_APP+HELLO;
	
	public static void main(String[] args) throws HttpException, IOException {
		visitUrl("http://localhost:8080/myApp/hello");
	}
	
	public static void connectUrl(String url) {
		visitUrl(url);
	}

	public static String visitUrl(String url) {		
		return visitUrl(url, DEFAULT_CHARSET,"get");
		
	}
	
	
	
	
	public static String visitUrlWithPostMethod(String url,String contentCharset,NameValuePair... datas) {
		return visitUrl(url, contentCharset, POST_METHOD, datas);
	}
	
	
	public static String visitUrlWithPostMethod(String url,String contentCharset,Map<String, String> datas) {
		List<NameValuePair> list = new LinkedList<NameValuePair>();
		NameValuePair nameValuePair = null;
		for (String name : datas.keySet()) {			
			nameValuePair = new NameValuePair();
			nameValuePair.setName(name);
			nameValuePair.setValue(datas.get(name));
			list.add(nameValuePair);
		}
		return visitUrl(url, contentCharset, POST_METHOD, list.toArray(new NameValuePair[list.size()] ));
	}
	
	public static String visitUrlWithGetMethod(String url,String contentCharset) {
		return visitUrl(url, contentCharset, GET_METHOD, null);
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-6-26；时间：下午1:21:38</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param url
	 * @param contentCharset
	 * @param httpMehtod
	 * @param datas Post方法访问URL的时候，传递的参数
	 * @return
	 * @return
	 */
	public static String visitUrl(String url,String contentCharset,String httpMehtod,NameValuePair... datas) {
		// 打印服务器返回的状态
		logger.info("打印HTTP请求的请求头【" +
				url+"】，参数【" +
				HttpMethodParams.HTTP_CONTENT_CHARSET+
				"=" +
				contentCharset+
				"】");
		HttpClient client = new HttpClient();
		client.setConnectionTimeout(10000);
        client.setTimeout(10000);
		client.getParams().setParameter(
			      HttpMethodParams.HTTP_CONTENT_CHARSET, contentCharset);
		
		// 设置代理服务器地址和端口

		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		//String chinese= URLEncoder.encode("啊啊啊啊啊啊", "utf-8"); 
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		HttpMethod method = null;
		if (httpMehtod!=null&&httpMehtod.equalsIgnoreCase(POST_METHOD)) {
			method = new PostMethod(url);
			 // 填入各个表单域的值
			  //NameValuePair[] data = { new NameValuePair("id", "herrapfel"),new NameValuePair("passwd", "") };
			  // 将表单的值放入postMethod中
			if (datas!=null&&datas.length>0) {				
				((PostMethod)method).setRequestBody(datas);
			}
		}else {			
			method = new GetMethod(url);
		}
		// 使用POST方法
		// HttpMethod method = new PostMethod("http://java.sun.com");
		try {
			client.executeMethod(method);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 打印服务器返回的状态
		logger.info(method.getStatusLine().toString());
		// 打印返回的信息
		String htmlContent=null;
		try {
			htmlContent = method.getResponseBodyAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 释放连接
		method.releaseConnection();
		
		//logger.debug(htmlContent);
		
		return htmlContent;
	}
	
	public static InputStream getInputStreamByvisitUrl(String url,String contentCharset,String httpMehtod,NameValuePair... datas) {
		// 打印服务器返回的状态
		logger.info("打印HTTP请求的请求头【" +
				url+"】，参数【" +
				HttpMethodParams.HTTP_CONTENT_CHARSET+
				"=" +
				contentCharset+
				"】");
		HttpClient client = new HttpClient();
		client.setConnectionTimeout(30000);
        client.setTimeout(30000);
		client.getParams().setParameter(
			      HttpMethodParams.HTTP_CONTENT_CHARSET, contentCharset);
		// 设置代理服务器地址和端口

		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		//String chinese= URLEncoder.encode("啊啊啊啊啊啊", "utf-8"); 
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		HttpMethod method = null;
		if (httpMehtod!=null&&httpMehtod.equalsIgnoreCase(POST_METHOD)) {
			method = new PostMethod(url);
			 // 填入各个表单域的值
			  //NameValuePair[] data = { new NameValuePair("id", "herrapfel"),new NameValuePair("passwd", "") };
			  // 将表单的值放入postMethod中
			if (datas!=null&&datas.length>0) {				
				((PostMethod)method).setRequestBody(datas);
			}
		}else {			
			method = new GetMethod(url);
		}
		// 使用POST方法
		// HttpMethod method = new PostMethod("http://java.sun.com");
		try {
			client.executeMethod(method);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 打印服务器返回的状态
		logger.info(method.getStatusLine().toString());
		// 打印返回的信息
		InputStream htmlContent=null;
		try {
			htmlContent = method.getResponseBodyAsStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 释放连接
		//method.releaseConnection();
		
		//logger.debug(htmlContent);
		
		return htmlContent;
	}

}
