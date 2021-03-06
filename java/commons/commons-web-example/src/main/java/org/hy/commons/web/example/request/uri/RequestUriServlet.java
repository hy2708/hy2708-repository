package org.hy.commons.web.example.request.uri;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.hy.commons.web.servlet.HttpServletUtil;

import jodd.util.StringUtil;

public class RequestUriServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");
		
		//获得提交数据
		// * 获得表单提交的username的内容
		String username = request.getParameter("username");
		System.out.println(username);
		// * 获得表单提交的userpwd的内容
		String userpwd = request.getParameter("userpassword");
		System.out.println(userpwd);
		System.out.println(request.getRequestURI());
		System.out.println(request.getServletPath());
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI().replaceFirst(request.getContextPath(), ""));
		System.err.println(StringUtil.replace(request.getRequestURI(), request.getContextPath(), ""));
		System.err.println(HttpServletUtil.getRequestURIInContext(request));
	}

}
