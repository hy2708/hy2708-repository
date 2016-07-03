/*
 * Created on 2003-12-14 by Liudong
 */

package org.hy.commons.net;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.action.NewRuleAction;

import org.hy.commons.io.core.IoUtil;

/**
 * 最简单的HTTP客户端,用来演示通过GET或者POST方式访问某个页面
 * 
 * @authorLiudong
 */
public class Down5paiData {
	
	private static Logger logger = LoggerFactory.getLogger(Down5paiData.class);
	
	public static void main(String[] args) throws IOException {
		String dateStr =new Date().toLocaleString();
		String subStr = dateStr.substring(0, dateStr.indexOf(" "));
				System.err.println(dateStr+"00000000000000000000000");
				System.err.println(new Date().getHours()+"00000000000000000000000");
		String filePath =		"d:/5pai/"+subStr;
		System.err.println(filePath);
		IoUtil.createFile(filePath);

		new Down5paiData().name(filePath+"/");
	}
	
	public String visitUrl(String url) throws HttpException, IOException {
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
	
	public void name(String baseFilePath) throws HttpException, IOException {
		String baseUrl = "http://www.5pai.com/end";
		String htmlContent = null;
		
		for (int i = 0; i < 85; i++) {
			if (i==0) {
				
				 htmlContent = visitUrl(baseUrl);
			} else {
				htmlContent = visitUrl(baseUrl+"/"+i+".html");
				System.err.println(baseUrl+"/"+i+".html");

			}
			String dateStr =new Date().toLocaleString();
			String subStr = dateStr.substring(0, dateStr.indexOf(" "));
					System.err.println(dateStr+"00000000000000000000000");
					System.err.println(new Date().getHours()+"00000000000000000000000");
			String filePath =		baseFilePath+subStr+ "-h"+new Date().getHours()+"-"+i+".html";
			System.err.println(filePath+"00000000000000000000000");
			IoUtil.createFile(filePath);
			//File file = new File("d:/5pai/" +i+".html");
			//IoUtil.createFile(file);
			BufferedWriter bw = IoUtil.getBufferedWriter(filePath,"utf8");
			bw.write(htmlContent);
			bw.close();
		}
		
		
 
	}
}