package org.hy.commons.web.example.cookie.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//显示所有的书，提供购买链接
//显示用户最近浏览的记录：Cookie  bookHistory=2-1   最多显示3条
public class ShowAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//显示所有的书，提供购买链接
		out.write("<h1>本站有以下好书:</h1><hr/>");
		Map<String, Book> books = BookDB.findAllBooks();
		for(Map.Entry<String, Book> me:books.entrySet()){
			out.write(me.getValue().getName()+"&nbsp;&nbsp;<a target='_blank' href='"+request.getContextPath()+"/servlet/ShowDetailsServlet?id="+me.getKey()+"'>详细</a><br/>");
		}
		//显示用户最近浏览的记录：Cookie  bookHistory=2-1   最多显示3条
		out.write("<hr/>最近浏览的商品如下：<br/>");
		Cookie cookies[] = request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("bookHistory".equals(cookies[i].getName())){
				String value = cookies[i].getValue();// 2-1 书的id
				String ids[] = value.split("\\-");// 2 1
				for(String id:ids){
					Book b = BookDB.findBookById(id);
					out.write(b.getName()+"<br/>");
				}
				break;
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
