package org.hy.commons.web.example.response.encoding;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendDataServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//使用 字符流  发送数据  Writer Reader
		
		// * 获得
		PrintWriter out = response.getWriter();
		// * 数据
		String date = new Date().toString();
		// * 发送数据到浏览器
		out.println(date);
		
		
		
		
		
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
