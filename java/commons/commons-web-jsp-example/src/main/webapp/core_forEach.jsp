<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="cn.itcast.domain.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>foreach -- list</h3><br/>
	1.java<br/>
	
	<%
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("123");
		list.add("456");
		list.add("wasd");
		pageContext.setAttribute("list",list,PageContext.PAGE_SCOPE);
	
	%>
	
	
	
	<%
		//从指定的作用域中获得数据
		List<String> ls = (List<String>)pageContext.getAttribute("list",PageContext.PAGE_SCOPE);
		//遍历数据
		for(int i = 0 ; i < ls.size() ; i ++){
			//将数据输出到浏览器
			String s = ls.get(i);
			//要求使用el表达式将s发送到浏览器
			//pageContext.getOut().print("${s}");
			// * 将s的内容放置到作用域
			pageContext.setAttribute("s",s);
	%>
	
	${s}
	
	<%
		}
	%>
	
	最后的值<br/>
	\${s} -- ${s}<br/>
	
	\${list} --${list[1]} <br/>
	
	<hr/>
	2、forEach<br/>
	
	<c:forEach items="${list}" var="li">
		${li} ** 
	</c:forEach>
	<br/>
	最后的数据${li} **
	
	
	<hr/>
	<h3>foreach -- map</h3>
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("b001","Java");
		map.put("b002","Core");
		map.put("b003","Thinking");
		map.put("b004","Cooking");
		//添加到作用域
		pageContext.setAttribute("mapObj",map);
	%>
	${mapObj}<br/>
	
	遍历<br/>
	1.java<br/>
	
	<%
		//从作用域中获取信息 mapObj
		Map<String,String> m = (Map<String,String>)pageContext.getAttribute("mapObj");
		
		//遍历所有的内容 entrySet
		Set<Map.Entry<String,String>> set = m.entrySet();
		
		
		//使用foreach循环
		for(Map.Entry<String,String> entry : set){
			//要求，使用el表达式输出
			// * 将entry存放到作用域
			pageContext.setAttribute("entry",entry);
	%>
		${entry.key} -- ${entry.value} <br/>
	<%
		}
	%>
	<br/>
	2.foreach<br/>
	<c:forEach items="${mapObj}" var="m">
		${m.key} ** ${m.value} <br/>
	</c:forEach>
	
	<hr/>
	<h3>foreach -- map -- String,Book</h3><br/>
	<%
		Map<String,Book> mapBook = new HashMap<String,Book>();
		mapBook.put("b001",new Book("b001","Java Core","98"));
		mapBook.put("b002",new Book("b002","Java核心技术","89"));
		mapBook.put("b003",new Book("b003","Thinking Java","70"));
	
		pageContext.setAttribute("mapBookObj",mapBook);
	%>
	
	
	<c:forEach items="${mapBookObj}" var="mb">
		${mb.key}  -- ${mb.value.id} ,  ${mb.value.title} , ${mb.value.price} <br/>
	
	</c:forEach>
	
	<hr/>
	
	<table border="1">
		<tr>
			<td width="100px">编号</td>
			<td width="200px">标题</td>
			<td width="100px">价格</td>
		</tr>
		
		<c:forEach items="${mapBookObj}" var="mb">
			<tr>
				<td>${mb.value.id}</td>
				<td>${mb.value.title}</td>
				<td>${mb.value.price}</td>
			</tr>
		</c:forEach>

	</table>
	
	
	
</body>
</html>