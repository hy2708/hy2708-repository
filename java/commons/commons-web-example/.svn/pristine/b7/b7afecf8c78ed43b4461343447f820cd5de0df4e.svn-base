package org.hy.commons.web.example.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class URLSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获得session
		HttpSession session = request.getSession();
		System.out.println("urlsession " + session.getId());
		
		String url = "/urlSessionServlet2";
		
		/* 当前页面：http://localhost:8080/day07/urlSessionServlet
		 * 目标页面：http://localhost:8080/day07/urlSessionServlet2
		 */
		//ＵＲＬ重写
		url = response.encodeURL(url);   //处理：如果需要sessionId，则在URL中追加
		
		this.getServletContext().getRealPath(""); //获得真实的路径  web项目 / WebRoot
		//浏览器  / web站点 webapps 
		
		System.out.println(url);
		String path = request.getContextPath();
		System.out.println(path);
		System.out.println(response.encodeURL("/day07/urlSessionServlet2"));
		System.out.println(response.encodeURL(""));
		
		
		//将此链接，以a标签的输出
		PrintWriter out = response.getWriter();
		out.print("<a href='"+url+"'>demosession</a>");

	}

}
