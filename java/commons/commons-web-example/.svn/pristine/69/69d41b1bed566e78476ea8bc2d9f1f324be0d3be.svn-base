package org.hy.commons.web.example.cookie.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//显示书籍的详细内容
//写Cookie
public class ShowDetailsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//显示书籍的详细内容
		String id = request.getParameter("id");
		Book book = BookDB.findBookById(id);
		out.write("本书的详细内容是：<br/>");
		out.write(book.toString());
		//写Cookie
		String ids = makeIds(request,id);  //2-1
		Cookie cookie = new Cookie("bookHistory",ids);
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
	}
	/*
	 * 原有的id                    新访问的书的id                        组织后的ids
	 * 一个getCookies==null               1                                  1
	 * 没有名称为bookHistory的cookie      1                                   1
	 * 1								2									2-1
	 * 1-2								2									2-1
	 * 1-2								3									3-1-2
	 * 3-1-2							4									4-3-1
	 * 3-1-2							1									1-3-2
	 */
	private String makeIds(HttpServletRequest request, String id) {
//		一个getCookies==null               1                                  1
		Cookie cookies[] = request.getCookies();
		if(cookies==null){
			return id;
		}
		//没有名称为bookHistory的cookie      1                                   1
		boolean hasBookHistoryCookie = false;
		String value = "";
		for(Cookie c:cookies){
			if("bookHistory".equals(c.getName())){
				hasBookHistoryCookie = true;
				value = c.getValue();
			}
		}
		if(!hasBookHistoryCookie){
			return id;
		}
		
//		 * 1								2									2-1
//		 * 1-2								2									2-1
//		 * 1-2								3									3-1-2
//		 * 3-1-2							4									4-3-1
//		 * 3-1-2							1									1-3-2
		String vs[] = value.split("\\-");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(vs));
		if(list.size()<3){
//		 * 1								2									2-1
//		 * 1-2								2									2-1
//		 * 1-2								3									3-1-2
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else{
				list.addFirst(id);
			}
		}else{
//		 * 3-1-2							4									4-3-1
//		 * 3-1-2							1									1-3-2
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else{
				list.removeLast();
				list.addFirst(id);
			}
		}
		//List: 1 3 4--->1-3-4        
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<list.size();i++){
			if(i>0){
				sb.append("-");
			}
			sb.append(list.get(i));
		}
		
		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
