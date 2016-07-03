package org.hy.commons.web.example.response.encoding;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//使用字符流，将数据发送到浏览器
		
		// * 获得字节流  OutputStream  InputStream
		
		ServletOutputStream out = response.getOutputStream();
		// * 准备数据
		long data = new Date().getTime() ;  //"Hello World !!!";
		// * 将数据写入到获得的字符流中
		
		out.print(data);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
