package org.hy.commons.net;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientUtil {
	
	public static void main(String[] args) throws HttpException, IOException {
		visitUrl("http://localhost:8080/myApp2/hello");
	}
	
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

}
