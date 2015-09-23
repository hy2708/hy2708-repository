package org.hy.commons.web.example.response.encoding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//将表单书发送给浏览器
		// * 确定发送数据的编码
		response.setContentType("text/html;charset=UTF-8");
		// * 获得字符流
		PrintWriter out = response.getWriter();
		// * 发送数据
		
		out.println("<form action=\"#\" method=\"post\">");
		out.println("名称：<input type='text' name='username' value='凤姐'> <br/>");
		out.println("密码：<input type='password' name='userpwd'> <br/>");
		out.println("<input type='submit' value='提交' />");
		out.println(" </form>");
		
		
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
