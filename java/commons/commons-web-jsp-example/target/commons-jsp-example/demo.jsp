<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public void print(){
		System.out.println("xxxxxx");
	}

	public static final String xxxx = "jack";

%>
######################<br/>
<%= 1 + 2 + 3 %>

*************************<br/>

<%
	//这是一个变量
    String str = "abcd";

	for(int i = 0 ; i < 10 ; i ++){
		System.out.println("abc");
	}
	
%>

<hr/>
<!--
输出h6 -- h1 html标签<br/>
要求：必须使用< % %> 和< %= %>
-->

<h1>sdfsdf</h1>

<%
 for(int i = 6 ; i > 0 ; i --){
	 //输出  <hi>sdfsdf</hi>
%>
<h<%=i %>>sdfsdf</h<%=i %>>
<%
 }

%>




