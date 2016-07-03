package org.hy.commons.web.example.response.encoding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendDataServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//当使用getOutputStream时，不能使用getWriter
		// * getOutputStream() has already been called for this response
		//当使用getWriter时，不能使用getOutputStream
		// * getWriter() has already been called for this response
		//总结：两个流同时只能使用一个
		
		//字节流
		ServletOutputStream out = response.getOutputStream(); 
		out.print("abc");
		
		
		//字符流
//		PrintWriter writer = response.getWriter();  
//		writer.print("123");
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
