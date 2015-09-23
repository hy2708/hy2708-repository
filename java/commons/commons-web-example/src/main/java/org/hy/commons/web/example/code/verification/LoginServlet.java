package org.hy.commons.web.example.code.verification;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获得用户提交的数据 imageNumber
		String imageNumber = request.getParameter("imageNumber");
		//需要判断  从session获得保存的验证码的信息
		// * 获得session
		HttpSession session = request.getSession();
		// * 获得保存的值number
		String number = (String)session.getAttribute("number");
		
		PrintWriter out = response.getWriter();
		
		//匹配 用户提交的数据与程序保存的数据
		if(number != null){ //程序保存
			if(number.equalsIgnoreCase(imageNumber)){
				//输入正确
				out.print("验证通过");
			} else {
				//验证码错误
				out.print("验证码错误");
			}
			//无论情况，程序存储的数据，只能使用一次
			session.removeAttribute("number");
		} else {
			out.print("验证码失效");
		}

		
		

	}

}
