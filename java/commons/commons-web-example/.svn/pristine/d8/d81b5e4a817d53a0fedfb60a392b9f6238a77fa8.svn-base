package org.hy.commons.web.example.request.parameter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDataRequestServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//获得表单提交的所有的数据
		//获得用户名信息
		String username = request.getParameter("username");
		System.out.println("name: " + username);
		//获得用户密码
		String password = request.getParameter("userpassword");
		System.out.println("pwd: " + password);
		//获得性别
		String sex = request.getParameter("sex");
		System.out.println("sex: " + sex);
		
		//获得爱好,存在多个选择
//		String love = request.getParameter("love");
//		System.out.println("love : " + love);
		String[] loves = request.getParameterValues("love");
		//System.out.println(loves);  //[Ljava.lang.String;@9260ee
		String loveStr = Arrays.toString(loves);
		System.out.println(loveStr);
		
		
		String error = request.getParameter("error");
		System.out.println("error : " + error);
		

	}

}
