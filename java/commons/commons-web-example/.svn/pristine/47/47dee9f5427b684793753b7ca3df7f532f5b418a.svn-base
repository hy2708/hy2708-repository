package org.hy.commons.web.example.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaxAgeCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//输出到浏览器
		PrintWriter out = response.getWriter();
		
		//读取cookie
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				out.print(c.getName() + ":" + c.getValue() + "<br/>");
			}
		} else {
			//不存在cookie
			out.print("不存在cookie");
		}
		
		
		//设置cookie的有效时间，使会话级cookie变成持久化cookie
		
		// * 创建cookie
		Cookie cookie = new Cookie("gf","fengjie");
		// * 设置有效时间
		cookie.setMaxAge(60 * 60 * 24);
		// * 通知浏览器 
		response.addCookie(cookie);
		
		
		
		

	}

}
