package org.hy.commons.web.example.request.header;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//常用的方法
public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String url = request.getRequestURL().toString();//  http://localhost:8080/day05/servlet/RequestDemo1
		String uri = request.getRequestURI();//  /day05/servlet/RequestDemo1
		//访问地址：  http://localhost:8080/day05/servlet/RequestDemo1?username=admin&password=123
		String queryString = request.getQueryString();  //  username=admin&password=123
		String remoteIp = request.getRemoteAddr();// 访问者的IP地址
		String remoteHostName = request.getRemoteHost();// 访问者的机器名
		int remotePort = request.getRemotePort(); // 访问者的端口号 随机的  1024~65535之间的一个随机数
		String method = request.getMethod();// 客户的请求方式  get post 大写还是小写，浏览器不同而不同
		out.write("getRequestURL=="+url+"<br/>");
		out.write("getRequestURI=="+uri+"<br/>");
		out.write("getQueryString=="+queryString+"<br/>");
		out.write("getRemoteAddr=="+remoteIp+"<br/>");
		out.write("getRemoteHost=="+remoteHostName+"<br/>");
		out.write("getRemotePort=="+remotePort+"<br/>");
		out.write("getMethod=="+method+"<br/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
