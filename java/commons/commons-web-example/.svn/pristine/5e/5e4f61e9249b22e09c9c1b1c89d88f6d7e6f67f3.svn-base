package org.hy.commons.web.example.response.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestResponseServlet extends HttpServlet {

	Logger logger = LoggerFactory.getLogger(getClass());
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取
		
		Object pwd = request.getAttribute("pwd");
		System.out.println(pwd);
		
		logger.info("重定向调用中....");
		PrintWriter out = response.getWriter();  //必须值调用的servlet使用的流相同
		out.print("页面重定向调用中....");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
