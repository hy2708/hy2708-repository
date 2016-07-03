package org.hy.commons.web.example.response.encoding;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCNServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		设置响应浏览器的字符编码  : 通知【tomcat】和【浏览器】，【当前servlet发送的数据的编码】
		即：告诉【服务器】，【用什么编码写数据，只对Writer，对outputStream无效】，告诉【浏览器】，【用什么编码*读取*数据】
		相当于，同时创建了，字符流Writer和Reader，并设置了字符的编码
		//response.setContentType("text/html;charset=UTF-8");
		 */
		
		//发送中文数据 --“中文”
		String data = "中文";
		//字节流
		ServletOutputStream out = response.getOutputStream();
		//out.print(data); 不能发送中文数据 java.io.CharConversionException Not an ISO 8859-1 character: 中
		String csn = Charset.defaultCharset().name();
		out.write(("当前Servlet的默认字符集是【" +
				csn+
				"】").getBytes());
		//======================================================
		out.write(data.getBytes("UTF-8"));
		//Reader，需要用utf8读取。因此response.setContentType("text/html;charset=UTF-8");
		//======================================================
		out.write(data.getBytes("gbk"));
		//Reader，需要用gbk读取。因此response.setContentType("text/html;charset=gbk");

		//==========================================================
		out.write(data.getBytes("iso8859-1"));
		//Reader，需要用iso8859-1读取。因此response.setContentType("text/html;charset=iso8859-1");

		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
