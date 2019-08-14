<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<style type="text/css">
			 
	</style>
  </head>
  
  <body>
  
  	       <select id = "select">
  				<option>宝贝</option>
  				<option>店铺</option>
  			</select>
  			<input id = "name" name = "name">
  			 <a id="a" href="${pageContext.request.contextPath}/customFind.jsp">搜索</a>	
  			 
  	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  	   	<script type="text/javascript">
  			/*$("#btn").click(function(){
  				
  			 	 frm.submit();
  			});*/
  			 
  			  $("#a").click(function(){
  			  		  name = $("#name").val();
  			  		  select = $("#select option:selected").text();
  				      $("#a").attr("href","${pageContext.request.contextPath}/customFind.jsp?desception="+name+"&selected="+select+"");                
	    		   });	
  			 
  	 </script>
     
  </body>
</html>
