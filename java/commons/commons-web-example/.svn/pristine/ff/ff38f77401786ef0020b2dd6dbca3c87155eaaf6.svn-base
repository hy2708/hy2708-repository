package com.itheima.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//把要买的商品放到购物车中
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Book book = BookDB.findBookById(id);
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		
		if(obj==null){
			//没有购物车
			List<Book> cart = new ArrayList<Book>();
			cart.add(book);
			session.setAttribute("cart", cart);
		}else{
			List<Book> cart = (List<Book>)obj;
			cart.add(book);
		}
		
		out.write(book.getName()+"已成功放入您的购物车！<a href='"+request.getContextPath()+"/servlet/ShowProductServlet'>继续购物</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
