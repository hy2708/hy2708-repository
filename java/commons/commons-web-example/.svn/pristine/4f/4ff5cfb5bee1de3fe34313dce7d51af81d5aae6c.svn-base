package org.hy.commons.web.example.servlet.path;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.server.jetty8.JettyUtil;

public class DemoServlet extends HttpServlet {
	
	public static void main(String[] args) {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(DemoServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		//输出数据，显示的内容是<a>标签，href链接到demoServlet2中
		// * 确定输出流
		PrintWriter out = response.getWriter();
		// * 内容
		/*
		 * 当前页面：http://localhost:8080/day07/demoServlet
		 * 目标页面：http://localhost:8080/day07/demoServlet2
		 * 确定：服务器调用  还是浏览器
		 * 
		 * 
		 * 浏览器和服务器的根路径，不同
		 * 
		 * 
		 *  / 浏览器  -- 【web站点】  -- webapps  -- 【http://localhost:8080】
		 *  / 服务器 -- 【web项目】  -- WebRoot  -- 【http://localhost:8080/day07】
		 */
		//String path = this.getServletContext().getRealPath("/");  //  / --> 当前项目的根 context root
		//request.getRequestDispatcher("/");  // context root
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf8'>");
		out.println("<a href='/day07/demoServlet2'>demo2</a><br/>");
		//需要再request中设置登录信息
		request.setAttribute("login", "true");
		out.print("登录成功");
		

	}

}
