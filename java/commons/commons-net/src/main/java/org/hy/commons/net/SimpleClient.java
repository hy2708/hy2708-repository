/*
 * Created on 2003-12-14 by Liudong
 */

package org.hy.commons.net;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 最简单的HTTP客户端,用来演示通过GET或者POST方式访问某个页面
 * 
 * @authorLiudong
 */
public class SimpleClient {
	public static void main(String[] args) throws IOException {
		HttpClient client = new HttpClient();
		client.getParams().setParameter(
			      HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		// 设置代理服务器地址和端口

		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		String chinese= URLEncoder.encode("啊啊啊啊啊啊", "utf-8"); 
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		HttpMethod method = new GetMethod("http://www.baidu.com/s?tn=monline_5_dg&ie=utf-8&bs=aa&f=8&rsv_bp=1&rsv_spt=1&wd=" +
				"000000" +
				chinese +
				"&rsv_sug3=6&rsv_sug=0&rsv_sug1=3&rsv_sug4=550&inputT=2264");
		// 使用POST方法
		// HttpMethod method = new PostMethod("http://java.sun.com");
		client.executeMethod(method);

		// 打印服务器返回的状态
		System.out.println(method.getStatusLine());
		// 打印返回的信息
		System.out.println(method.getResponseBodyAsString());
		// 释放连接
		method.releaseConnection();
		//http://www.5pai.com/Search.aspx?word=00000&x=0&y=0
	//	http://www.baidu.com/s?tn=monline_5_dg&ie=utf-8&bs=0000000%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A&f=8&rsv_bp=1&rsv_spt=1&wd=0000000%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A&inputT=0
	Map<K, V>
	}
}