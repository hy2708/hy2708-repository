package org.hy.commons.web.example.response.encoding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCNServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//通知tomcat和浏览器发送数据的编码
		response.setContentType("text/html;charset=utf-8");
		
		//使用 字符流 发送中文数据
		// * 获得字符流
		PrintWriter out = response.getWriter();
		// * 准备数据
		String data = "中文";
		
		// * 发送数据
		out.println(data);  // ln 发送数据到浏览器端后，生成的文件的内容，是换行的
		out.println("<br />"); //浏览器解析生成的文件时，换行的
		out.println(" end ");
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
