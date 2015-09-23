package org.hy.commons.web.example.request.header;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


public class RequestDemo4 extends HttpServlet {
	//get方式的请求参数的乱码问题
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");// ISO-8859-1
		byte b[] = name.getBytes("ISO-8859-1");//客户端传递过来的字节数组
		//用UTF-8进行重新编码
		name = new String(b,"UTF-8");
		System.out.println(name);
	}
	//POST请求参数的乱码
	private void test2(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		Student s = new Student();
		System.out.println("封装前："+s);
		try{
			//String--->其他类型；其他类型---->String
			//完成类型的自动转换：但只限JavaBean中的基本类型
			BeanUtils.populate(s, request.getParameterMap());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("封装后："+s);
	}

	private void test1(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String married = request.getParameter("married");
		String hobby[] = request.getParameterValues("hobby");
		if(hobby!=null&&hobby.length>0){
			for(String s:hobby)
				System.out.println(s);
		}else{
			System.out.println("没有hobby的值");
		}
		String address = request.getParameter("city");
		String description = request.getParameter("description");
		System.out.println("name="+name);
		System.out.println("password="+password);
		System.out.println("gender="+gender);
		System.out.println("married="+married);
		System.out.println("address="+address);
		System.out.println("description="+description);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
