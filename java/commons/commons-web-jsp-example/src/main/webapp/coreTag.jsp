<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Set</h3><br/>
	<%
		pageContext.setAttribute("gfj","fengjie",PageContext.REQUEST_SCOPE);
	%>
	<!-- 
		set标签：给web域设置值的
			var 属性：属性的名称
			value属性：属性的值
			scope属性：确定作用域
				* page
				* request
				* session
				* application
	 -->
	<c:set var="gf" value="fengjie" scope="page"></c:set>
	<c:set var="gf" value="fengjie" scope="request"></c:set>
	<c:set var="gf" value="fengjie" scope="session"></c:set>
	<c:set var="gf" value="fengjie" scope="application"></c:set>
	\${gf} -- ${requestScope.gf}<br/>
	\${gf} -- ${requestScope.gf}<br/>
	\${gf} -- ${sessionScope.gf}<br/>
	\${gf} -- ${applicationScope.gf}<br/>
	<hr/>
	<h3>remove</h3><br/>
	<!-- 
		remove标签：删除指定名称的web域的值
			* var属性：确定名称
			* 注意：删除所有作用域的内容
	 -->
	<c:remove var="gf"/>
	\${gf} -- ${pageScope.gf}<br/>
	\${gf} -- ${requestScope.gf}<br/>
	\${gf} -- ${sessionScope.gf}<br/>
	\${gf} -- ${applicationScope.gf}<br/>
	<hr/>
	<h3>out</h3><br/>
	<c:set var="gf" value="<a href='#'>fengjieout</a>" scope="page"></c:set>
	<!-- 
		out标签：将内容输出
			* value:指定内容
				* 注意：可以使用EL表达式
			* escapeXml:是否转移html规定的字符
				* 默认值true，转移
			* default：当前输出内容为空时，显示默认值
	 -->
	 \${gf} -- ${gf2} <br/>
	<c:out value="${gf2}" default="没有值"></c:out><br/>
</body>
</html>