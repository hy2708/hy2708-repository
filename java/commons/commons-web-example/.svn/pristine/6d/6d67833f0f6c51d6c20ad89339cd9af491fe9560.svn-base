package com.itheima.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//显示用户已购买的商品
public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session==null){
			out.write("对不起！没有购物任何东东");
			return;
		}
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if(cart==null){
			out.write("对不起！没有购物任何东东");
			return;
		}
		out.write("<h1>您购买了以下商品</h1><hr/>");
		for(Book b:cart){
			out.write(b.getName()+"<br/>");
		}
		out.write("<a href='#'>去结算</a>&nbsp;&nbsp;<a href='"+request.getContextPath()+"/servlet/ShowProductServlet'>继续购物</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
