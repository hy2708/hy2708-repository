<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" import="java.util.List"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList,java.util.List;"%>
<%@ page language="java"%>
<%@ page info="Hello World" %>
<%@ page session="true" %>
<!-- 
	* pageEncoding:配置当前页面保存信息的编码
	* contentType:配置当前页面生成的servlet文件响应浏览器的编码
		* response.setContentType("text/html;charset=UTF-8");
		* 比较：
			* 仅有pageEncoding
				* 配置当前页面的编码
				* 配置生成servlet文件响应浏览器的编码
			* 仅有contentType
				* 配置当前页面的编码
				* 配置生成servlet文件响应浏览器的编码
			* 两个都有
				* pageEncoding仅设置当前页面的编码
				* contentType仅设置servlet文件响应浏览器的编码
	* import：引入当前JSP页面需要使用的Java类或接口的包路径
		* 可以重复引用
		* 多个之间可以使用逗号分隔
		* 导包最后一条可以输入多个分号
	* language:确定当前jsp页面使用的语言
		* 默认：java
	* info:确定当前页面的输出信息
	* session：确定当前页面是否可以使用session
		* 默认：ture
	* extends,确定当前jsp页面在生成servlet文件时，继承的父类
		* 扩展
		* 例如：page extends="java.lang.String"
		
	* isErrorPage:是否是错误页面
		* 默认值：false
		* 当设置成true，在当前页面将可以使用一个变量 exception
	* errorPage：确定错误页面
		* 当页面出现异常时，跳转的页面
		* / 指 context root
	* isThreadSafe:是否是线程安全
		* 默认值：true
		* 如果设置成false，在生成的java源码中添加implementsSingleThreadModel 
	* isELIgnored：是否忽略EL表达式
		* 默认值：false
		* 如果设置true，将忽略EL表达式
		
	* buffer:当前servlet文件的缓存区大小
		* 默认值是8kb
	* autoFlush:是否自动刷新,当buffer缓存区被填写满后，会自动的刷新内容到浏览器

 -->
 
 <%@ page isErrorPage="true" errorPage="/error.jsp"%>
 <%@ page isThreadSafe="true" %>
 <%@ page isELIgnored="true" %>
 <%@ page buffer="8kb" %>
 <%@ page autoFlush="true" %>
 
 
 
 
这个是第一个jsp页面
<%
	List list = new ArrayList();
	session.isNew();
	//int i = 10 / 0 ;
	request.setAttribute("attr","xxxxxx");
	
	for(int i = 0 ; i < 1024 ; i ++){
		out.print("a");
	}
	
	
%>

${attr}