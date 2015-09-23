package org.hy.commons.web.example.servlet.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadParamServlet extends HttpServlet {
	
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//在任意servlet中获取context的配置信息
		
		// * 获得ServletContext 
		ServletContext sc = this.getServletContext();
		// * 获得所有的配置信息的名称   <context-param><param-name>
		Enumeration<String> names = sc.getInitParameterNames();
		// * 遍历
		while(names.hasMoreElements()){
			// * 获得每一个名称
			String name = names.nextElement();
			// * 获得指定名称的内容  <context-param><param-value>
			String value = sc.getInitParameter(name);
			System.out.println("context -->  " + name + " : " + value);
		}
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
