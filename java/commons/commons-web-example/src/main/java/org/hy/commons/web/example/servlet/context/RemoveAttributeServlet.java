package org.hy.commons.web.example.servlet.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveAttributeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//删除属性bs的值
		
		// * 获取 sc
		ServletContext sc = this.getServletContext();
		// * 删除bs
		sc.removeAttribute("bs");
		
		System.out.println("remove");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
