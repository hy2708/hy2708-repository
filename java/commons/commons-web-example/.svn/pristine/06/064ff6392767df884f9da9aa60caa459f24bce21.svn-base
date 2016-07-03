package org.hy.commons.web.example.servlet.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAttributeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//在servletContext中获取属性值
		
		// * 获得sc
		ServletContext sc = this.getServletContext();
		// * 获得bs属性值
		Object obj = sc.getAttribute("bs");
		
		System.out.println("get : " + obj);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
