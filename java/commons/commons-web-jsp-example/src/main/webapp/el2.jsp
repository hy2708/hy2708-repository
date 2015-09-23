<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

获得request.getContextPath();<br/>
1.java <br/>
111 <%=request.getContextPath() %> <br/>
222 <%=((HttpServletRequest)pageContext.getRequest()).getContextPath() %> <br/>

2.EL<br/>
${pageContext.request.contextPath} <br/>

<hr/>
\${headerValues} <br/>

${headerValues.cookie[0]}<br/>
${headerValues.cookie[1]}<br/>

${headerValues["user-agent"][0]}<br/>

<hr/>

\${5 / 2}  -- ${5 / 2} <br/>
\${6 &gt; 3 } -- ${6 gt 3} <br/>
\${empty user} -- ${empty user}

<hr/>

<%
	String ab = "abcde";
	pageContext.setAttribute("abObj",ab,PageContext.REQUEST_SCOPE);
%>
\${abObj} -- ${abObj} <br/>

</body>
</html>