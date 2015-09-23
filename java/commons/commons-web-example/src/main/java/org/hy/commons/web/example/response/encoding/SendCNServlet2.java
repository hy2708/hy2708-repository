package org.hy.commons.web.example.response.encoding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCNServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//确定发送数据的编码，通知tomcat和浏览器发送数据的编码，两者统一 uTF-8
		response.setContentType("text/html;charset=utf-8"); //将在http响应头中添加，content-type:text/html;charset=utf-8
		
		//使用字节流 发送中文数据
		ServletOutputStream out = response.getOutputStream();
		String data = "中文";
		// * 发送数据
		out.write(data.getBytes("UTF-8"));		
		
	}

	

}
