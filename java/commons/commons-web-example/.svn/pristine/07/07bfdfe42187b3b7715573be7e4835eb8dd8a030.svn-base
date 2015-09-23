package org.hy.commons.web.example.request.header;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hy.commons.lang.example.entity.User;

//获取请求参数的值:用户的所有输入都是字符串
public class RequestDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream in = request.getInputStream();
		int len = -1;
		byte buf[] = new byte[1024];
		while((len=in.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		in.close();
	}
	//前提：JavaBean的属性要与表单的输入与的name一致
	private void test2(HttpServletRequest request) {
		try{
			System.out.println("获取所有的请求参数及参数的值");
			User user = new User();
			System.out.println("封装前："+user);
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String paramName = (String) e.nextElement();
				String paramValue = request.getParameter(paramName);
				PropertyDescriptor pd = new PropertyDescriptor(paramName, User.class);// getUsername读 setUsername写
				Method m = pd.getWriteMethod();//setUsername(String username)
				m.invoke(user, paramValue);
			}
			System.out.println("封装后："+user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//前提：JavaBean的属性要与表单的输入与的name一致
	private void test3(HttpServletRequest request) {
		//key:请求参数名  value：对应的参数值String数组
		User user = new User();
		System.out.println("封装前："+user);
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("封装后："+user);
	}

	private void test1(HttpServletRequest request) {
		System.out.println("获取单一的请求参数的值:get和post通用");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		System.out.println(username+"\t"+password+"\t"+code);
		System.out.println("获取重名的所有参数的值");
		String values[] = request.getParameterValues("username");
		if(values!=null&&values.length>0){
			for(String s:values){
				System.out.println(s);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
