<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <%
    	//转发 forward.jsp
    	//获得请求调度器
    	//request
    	//RequestDispatcher rd = request.getRequestDispatcher("forward.jsp");  // 直接   /
    	//RequestDispatcher rd2 = request.getRequestDispatcher("/forward.jsp");  // 直接   /
    	//servletContext  -- application
    	//RequestDispatcher rd3 =application.getRequestDispatcher("/forward.jsp");  //  管理web --必须 /
    	
    	//转发
    	//rd.forward(request,response);
    	
    %>
    
    JSP常用标签<br/>
     <!-- 只要支持JSP文件，常用标签有可以直接使用
        	格式： jsp:xxxx
      -->
    <!-- 
    	jsp:forward:完成jsp页面的转发
    		* page属性：转发的地址
    	JSP引擎，处理JSP文件，自己解析特定的标签，然后将其编译成java代码
    	jsp:forward -- application.getRequestDispatcher("/forward.jsp");
    		* 注意：在JSP页面中可以不用斜杠开头
    		    * String path = getAbsolutePathRelativeToContext(relativeUrlPath);自己单独处理，如果不是/开头，自动添加
     -->
     <%
     	request.setCharacterEncoding("UTF-8");
     %>
   <%=request.getCharacterEncoding() %><br/>
   ${pageContext.request.characterEncoding}
    
     <jsp:forward page="forward.jsp">
    	<jsp:param value="凤姐" name="gf"/>
    </jsp:forward>
    
    
    
  </body>
</html>
