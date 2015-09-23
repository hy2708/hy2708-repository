package org.hy.commons.web.example.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaxLengthServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//拼凑数据，获得4kb字符串
		StringBuffer buf = new StringBuffer();
		for(int i = 0 ; i < 1024 * 5 ; i ++){
			buf.append("a");
		}
		
		String data = buf.toString();
		
		
		//创建cookie
		Cookie cookie = new Cookie("max",data);
		//设置有效时间
		cookie.setMaxAge(60*60);
		//发送数据
		response.addCookie(cookie);
		
		

	}

}
