package org.hy.commons.web.example.servlet.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetAttributeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//在servletContext中设置属性值
		
		// * 获取servletcontext
		ServletContext sc = this.getServletConfig().getServletContext();
		// * 在sc设置值
		sc.setAttribute("bs", "日本");
		
		
		System.out.println("set");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
