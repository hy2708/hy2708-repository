package org.hy.commons.web.example.cookie.cn;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CnCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("ggggggggggggggggggggggggggg");
		response.setContentType("text/html;charset=UTF-8");
		Cookie cookie = new Cookie("cn","中文");
		response.addCookie(cookie);
		
		//读取cookie
				Cookie[] cookies = request.getCookies();
				System.err.println(cookies.length);
				if(cookies != null){
					for(Cookie c : cookies){
						System.out.println(c.getName() + ":" + c.getValue());
						//获得cn的值，然后解码
						if("cn".equals(c.getName())){
							//String value = URLDecoder.decode(c.getValue(), "UTF-8");
							System.out.println(c.getValue());
						}
					}
				}
				
//		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//String[]  -- byte[]
		//"中文".getBytes("UTF-8") -- byte[] -- > 12,45,67,98
		//12,45,67,98  --> String[] -- byte[]  -- new String()
		
		
		
		//读取cookie
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				System.out.println(c.getName() + ":" + c.getValue());
				//获得cn的值，然后解码
				if("cn".equals(c.getName())){
					String value = URLDecoder.decode(c.getValue(), "UTF-8");
					System.out.println(value);
				}
			}
		}
		
		
		String data = "中文";
		String returnData  = URLEncoder.encode(data, "UTF-8");  //base64
		
		Cookie cookie = new Cookie("cn",returnData);
		
		response.addCookie(cookie);
		
		

	}

}
