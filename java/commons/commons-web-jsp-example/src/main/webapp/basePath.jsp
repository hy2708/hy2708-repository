<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

basePath= http  ://  localhost : 8080 /WebName / 
(http://localhost:8080/WebName/ 这个在IE地址览里最熟悉不过的地址就是这样产生的)

 

1.这样的好处在于可以为当前的链接使用绝对路径（同时，也强烈推荐使用绝对路径），如：
<a href="<%=basePath %>index.jsp">跳回首页</a>

 

2.在jsp页面还自动生成了以下代码：
<base href="<%=basePath %>" />
它指定了当前页面的默认地址为basePath,所以

<a href="index.jsp">跳回首页</a>

即真实的跳转路径为：http://localhost:8080/WebName/index.jsp
</body>
</html>