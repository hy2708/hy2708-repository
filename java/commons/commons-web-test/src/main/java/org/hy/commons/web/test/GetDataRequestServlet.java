package org.hy.commons.web.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDataRequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");
		request.getSession().setAttribute("xx", "xx");
		//获得提交数据
		// * 获得表单提交的username的内容
		String username = request.getParameter("username");
		System.out.println(username);
		// * 获得表单提交的userpwd的内容
		String userpwd = request.getParameter("userpassword");
		System.out.println(userpwd);
		
	}

}
