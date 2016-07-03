<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		*{
			font-size:9pt;
		}
		div{
			text-align:center;
			border:1px solid red;
			margin:3px;
			float: left;
		}
	</style>
  </head>
  <body>
  <fn:
   	<p>以下是所的资源</p>
   	<c:forEach items="${imgs}" var="img">
   		<div>
   			<a href="<c:url value='/up/${img.newname}'/>">
   				<img style="width:200px;height:200px;" src='<c:url value='/up/${img.newname}'/>'/>
   			</a>
   		<br/>
   		<c:choose>
   			<c:when test="${fn:length(img.oldname)>7}">
   				${fn:substring(img.oldname,0,7)}...
   			</c:when>
   			<c:otherwise>
   				${img.oldname}
   			</c:otherwise>
   		</c:choose>
   		<br/>
   		<c:if test="${fn:length(img.note)>7}" var="boo">
   			${fn:substring(img.note,0,7)}...
   		</c:if>
   		<c:if test="${!boo}">
   			${img.note}
   		</c:if>
   		<a href="<c:url value='/DelServlet?id=${img.id}'/>">删除</a>
   		<a href="javascript:_down('${img.oldname}','${img.newname}');">下载</a>
   		</div>
   	</c:forEach>
  </body>
  <script type="text/javascript">
  	 function _down(oname,nname){
  		 var url = "<c:url value='/DownServlet?oldname='/>"+oname+"&newname="+nname;
  		 url = encodeURI(url);
  		 alert(url);
  		 window.location.href=url;
  	 }
  </script>
</html>
