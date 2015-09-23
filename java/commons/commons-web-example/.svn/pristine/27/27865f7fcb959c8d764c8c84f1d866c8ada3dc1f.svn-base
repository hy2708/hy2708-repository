package org.hy.commons.web.example.servlet.context;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得资源文件
		ServletContext sc = this.getServletContext();
		System.out.println(sc);
		
		
		URL url = sc.getResource("/1.html");  //http://localhost:8080/myApp/1.html
		System.out.println(url.getPath());
		
		InputStream is = sc.getResourceAsStream("/1.html");
		System.out.println(is);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
