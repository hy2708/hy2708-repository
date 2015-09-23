package org.hy.commons.web.example.request.header;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;

public class RequestDemo2 extends HttpServlet {
	
	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(RequestDemo2.class, JettyUtil.HELLO);
		JettyUtil.startServer();

		String content = HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		Thread.sleep(1000);

		//JettyUtil.stopServer();
		System.err.println(content);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------获取指定名称的头值--------");
		String value = request.getHeader("Accept-Encoding");
		/*
		 * gzip,deflate,sdch
		 */
		System.out.println(value);
		System.out.println("------获取所有的头和值--------");
		/*
		 
		 
		 */
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			System.out.println(name+"="+request.getHeader(name));
		}
		System.out.println("------获取重名的头--------");
		e = request.getHeaders("Accept-Encoding");//头的值
		while(e.hasMoreElements()){
			value = (String) e.nextElement();
			System.out.println(value);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
