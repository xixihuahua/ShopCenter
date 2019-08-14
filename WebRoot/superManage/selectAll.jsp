<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>超级管理员首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  </head>
  
  <body>
     <table>
     	<thead>
     		<tr>
     			<th>买家id</th>
     			<th>买家昵称</th>
     			<th>买家性别</th>
     			<th>买家年龄</th>
     			<th>买家电话</th>
     			<th>买家地址</th>
     			<th>买家头像</th>
     			<th>买家注册时间</th>
     			<th>买家邮箱</th>
     			<th>买家等级</th>
     			<th>买家余额</th>
     		 </tr>
     	</thead>
     	<tbody id="main">
     		
     	</tbody>
     </table>
     
     <script type="text/javascript">
     	$.post("super.do",{"method" : "findAllCustom"}, function(list){
     		 $("#main").empty();
     		 $(list).each(function(){
     		 	$("#main").append("<tr>"+
     		 	"<td>"+this.custom_id+"</td>"+
     		 	"<td>"+this.custom_name+"</td>"+
     		 	"<td>"+this.custom_sex+"</td>"+
     		 	"<td>"+this.custom_age+"</td>"+
     		 	"<td>"+this.custom_tel+"</td>"+
     		 	"<td>"+this.custom_address+"</td>"+
     		 	"<td><img class='img' src='"+${pageContext.request.contextPath}/+""+this.custom_img+"'></td>"+
     		 	"<td>"+this.custom_regtime+"</td>"+
     		 	"<td>"+this.custom_email+"</td>"+
     		 	"<td>"+this.custom_level+"</td>"+
     		 	"<td>"+this.custom_money+"</td>"+
     		 	+"</tr>");
     		 });
     	});
     </script>
  </body>
</html>
