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
	<h3>if</h3><br/>
	<c:set var="user" value="xx"></c:set>
	<!-- 
		if标签：逻辑判断
			* test属性：逻辑值true|false
				* 支持EL表达式
	 -->
	<c:if test="${empty user}">
		user对象是null <br/>
	</c:if>
	<hr/>
	<h3>choose when otherwise</h3><br/>
	<!-- 
		choose标签：确定一组可以进行选择的显示结果
			* 必须放置when标签
			* 子标签
				* when标签：逻辑判断
					* test属性：填写逻辑值
				* otherwise标签：处理没有处理项，默认项
	
	 -->
	<c:choose>
		<c:when test="${empty user}">
			when:user null
		</c:when>
		<c:when test="${!empty user2}">
			when:user not null
		</c:when>
		<c:otherwise>
			没有任何处理项
		</c:otherwise>
	</c:choose>
	<hr/>
	<h3>forEach</h3><br/>
	<!--
		forEach标签：进行迭代,每一条信息将显示在标签体
			* items属性：确定遍历的对象
				* 支持EL表达式
			或
			* begin属性：
			* end属性：
			
			* var属性：确定遍历变量
			* step属性：步长 i+=2  i++ -- i+=1
	 -->
	 <!-- 
	 	String hvs
	 	pageContent.setAtt
	  -->
	<c:forEach items="${headerValues}" var="hvs">  
		\${hvs} -- ${hvs.key}:
		<c:forEach items="${hvs.value}" var="h">
			${h} *****
		</c:forEach>
		
		
		 <br/>
	</c:forEach>
	
	
</body>
</html>