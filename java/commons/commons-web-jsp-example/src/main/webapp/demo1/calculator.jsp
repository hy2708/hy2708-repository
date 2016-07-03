<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ page errorPage="calculator.jsp" %>
<%@page import="cn.itcast.domain.Calculator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//处理数据
		//String firstNum = request.getParameter("firstNum");
		//Calculator c = new Calculator();
		//c.setFirstNum(firstNum);
		//c.calculator();
	%>
	<!--
		jsp:useBean标签：创建class指定的类，并将此类添加到作用域中
			* class属性：指定类的完整路径名
			* id属性：确定对象的实例对象
		setProperty标签：给指定的Javabean对象设置属性值
			* name属性：已有的JavaBean在web域中的对象
			* property属性：确定需要使用的Javabean的属性
			* value属性：确定设置的具体的内容
			* param属性：获得指定参数的内容
			* 注意：当内容是null时，将不会赋值
	 -->
	<jsp:useBean id="cal" class="cn.itcast.domain.Calculator"></jsp:useBean>
	<jsp:setProperty property="*" name="cal"/>

	<c:if test="${empty pageContext.exception}">
	
		<%
			//if(exception == null){
				cal.calculator();
			//}
		%>
	
	</c:if>
	
	<hr/>
	
	计算结果：${cal.firstNum} ${cal.operator} ${cal.secondNum} = ${cal.result} <br/>
	
	<hr/>
	<!-- JSP + JavaBean
		1、点击计算，当前页面显示计算结果
		2、需要将数据封装到JavaBean
			* 与页面的字段向对应
		3、开始计算
	
	 -->
	<c:url var="demoUrl" value="/demo1/calculator.jsp"></c:url>
	<!-- 
		URL标签：生成当前响应的相对于web站点的完成路径
			* value属性：指定的页面的位置
				* 注意：内容如果/开头，相对于当前web项目
	 -->
	<form action="${demoUrl}" method="post">
		<table border="1">
			<tr>
				<td colspan="2">简单计算机</td>
			</tr>
			<tr>
				<td>第一个参数：</td>
				<td><input type="text" name="firstNum"/></td>
			</tr>
			<tr>
				<td>运算符</td>
				<td><select name="operator">
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>
				</select></td>
			</tr>
			<tr>
				<td>第二个参数：</td>
				<td><input type="text" name="secondNum"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="计算"/></td>
			</tr>
		
		</table>
	</form>
</body>
</html>