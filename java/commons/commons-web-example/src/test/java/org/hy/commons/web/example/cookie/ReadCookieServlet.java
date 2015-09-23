package org.hy.commons.web.example.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获得浏览器保存的cookie信息
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c :cookies){
				System.out.println(c.getName() + ":" + c.getValue());
			}
		}
		
		
		
		
		

	}

}
