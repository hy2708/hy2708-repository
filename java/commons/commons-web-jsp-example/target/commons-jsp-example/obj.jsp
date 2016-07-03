<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//String user = config.getInitParameter("user");
	//out.print(user);
	//System.out.println(out);
	//pageContext.setAttribute("user","liang");  //page scope
	
	//pageContext.setAttribute("user","liang_page",PageContext.PAGE_SCOPE);
	//pageContext.setAttribute("user","liang_request",PageContext.REQUEST_SCOPE);
	//pageContext.setAttribute("user","liang_session",PageContext.SESSION_SCOPE);
	//pageContext.setAttribute("user","liang_application",PageContext.APPLICATION_SCOPE);

%>
<%=pageContext.getAttribute("user",PageContext.PAGE_SCOPE) %><br/>
<%=pageContext.getAttribute("user",PageContext.REQUEST_SCOPE) %><br/>
<%=pageContext.getAttribute("user",PageContext.SESSION_SCOPE) %><br/>
<%=pageContext.getAttribute("user",PageContext.APPLICATION_SCOPE) %><br/>

<hr/>
<%=pageContext.findAttribute("user") %>

</body>
</html>