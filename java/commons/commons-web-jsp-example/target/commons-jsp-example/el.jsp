<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.itcast.servlet.Book"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	pageContext.setAttribute("user","liang_page",PageContext.PAGE_SCOPE);
	pageContext.setAttribute("user","liang_request",PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("user","liang_session",PageContext.SESSION_SCOPE);
	pageContext.setAttribute("user","liang_application",PageContext.APPLICATION_SCOPE);

	//request.setAttribute("user","liang_request");
%>
java <br/>
<%=pageContext.getAttribute("user",PageContext.REQUEST_SCOPE) %><br/>
<!-- 在JSP页面中不再使用Java脚本 -->
el -- <br/>
${user2}  -- pageContext.findAttribute("user"); <br/>

page: ${pageScope.user}<br/>
request:${requestScope.user}<br/>
session:${sessionScope.user}<br/>
application:${applicationScope.user}<br/>

<hr/>

<%

	Book book = new Book("b007","Java Core","78");
	pageContext.setAttribute("bookObj",book);

%>
<!-- 获得JavaBean中的，属性的值 -->
${pageScope.bookObj.id}<br/>
${pageScope.bookObj.title}<br/>
${pageScope.bookObj.price}<br/>

<hr/>

<%
	Map<String,Book> map = new HashMap<String,Book>();
	map.put("b001",	new Book("b004","Thinking Java","78") );
	
	//迭代器
	Set<Map.Entry<String,Book>> set = map.entrySet();
	Iterator<Map.Entry<String,Book>> it = set.iterator();
	while(it.hasNext()){
		Map.Entry<String,Book> entry = it.next();
		//entry.getKey()
		//entry.getValue()
		pageContext.setAttribute("entry",entry);
	}

%>
${entry.key} <br/>
${entry.value.id}
<hr/>

<%=pageContext.getSession().isNew() %><br/>
${pageContext.session.new}<br/>
<hr/>

<%=((HttpServletRequest)pageContext.getRequest()).getContextPath() %><br/>
${pageContext.request.contextPath}


</body>
</html>