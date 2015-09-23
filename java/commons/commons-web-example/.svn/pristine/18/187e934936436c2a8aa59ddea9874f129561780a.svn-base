package org.hy.commons.web.example.response.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//重定向  -- 服务器通知浏览器，重新发送请求
		
		//参数：确定重新发送的URL，建议使用绝对(完整) http://localhost:8080/  -- http://www.baidu.com
		// * 1.html  --> http://localhost:8080/day07/1.html
//		String url = "http://localhost:8080/day07/1.html";
		/* 确定，当前页面与目标页面时两次请求
		 * 当前页面：http://localhost:8080/day07/sendServlet
		 * 目标页面：http://localhost:8080/day07/1.html
		 */
//		String url = "1.html";
//		String url = "/day07/1.html";
//		String url = "./1.html";
//		String url = "../day07/1.html";
		String url = "/hello2";
		
		
		response.sendRedirect(url);
		//完全等价，隐藏了HTTP协议的具体要求
		//跳转
		//response.setStatus(302);
		//response.setHeader("location", "http://localhost:8080/day07/1.html");
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
