<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>商品，${goods.goods_id}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.img{
			width : 50px ;
			height: 50px;
		}
	</style>
  </head>
  
  <body>
	  <a href = "${pageContext.request.contextPath}/seller/uploadGoodsImg.jsp">
	       <img class="img" alt="还没有头像呀" src="${pageContext.request.contextPath}/${goods.goods_Img}">
	  </a>   
  </body>
</html>
