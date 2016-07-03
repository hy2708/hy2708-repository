<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <%
    	//转发 include.jsp
    	//获得请求调度器
    	//request
    	//RequestDispatcher rd = request.getRequestDispatcher("forward.jsp");  // 直接   /
    	//RequestDispatcher rd2 = request.getRequestDispatcher("/forward.jsp");  // 直接   /
    	//servletContext  -- application
    	//RequestDispatcher rd3 =application.getRequestDispatcher("/forward.jsp");  //  管理web --必须 /
    	
    	//转发
    	//rd.include(request,response);
    	
    %>
    
    JSP常用标签<br/>
    <!-- 
    	jsp:include:动态包含,在执行当前servlet时才进行文件的合并
    		* org.apache.jasper.runtime.JspRuntimeLibrary.include
    		* request.getRequestDispatcher
     -->
  <%
  	//设置request的编码
  	request.setCharacterEncoding("UTF-8");
  %>
    包含前<br/>
    <jsp:include page="include.jsp">
    	<jsp:param value="凤姐" name="gf"/>
    </jsp:include>
    包含后<br/>

  </body>
</html>
