<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    
    <title>搜索</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pagination.css">
	<style>
		.img{
			width : 50px;
		}
		 
	</style>
  </head>
  
  <body>
  			<a href="login.jsp">前往登陆</a>
  			<a href="reg.jsp">前往注册</a>
  			<a href="custom/customCenter.jsp">个人中心</a>
  	     <table>
     	<thead>
     		<tr id="head">
	     		<th>商品id</th>
	     		<th>商品名</th>
	     		<th>商品图片</th>
	     		<th>商品价格</th>
	     		<th>商品销售量</th>
	     		<th>商品折扣</th>
	     		<th>商品状态</th>
	     	 </tr>
     	 </thead>
     	 <tbody id="main">
     	 
     	 </tbody>
     	</table>
	  	<!-- 用来显示上一页和下一页 -->
	  	<div id="Pagination"></div>
	  	
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
  	    
	  	<script type="text/javascript">
	  			 
	  	
	  	
	  	
   		//定义一页显示多少个
   		var pageSize = 2;
   	 	var desception = "${param.desception}" ;
   	 	var selected = "${param.selected}" ;
   	 	
   	 	if(selected == "宝贝"){
   	 	//选择根据宝贝搜索
   	 		getData();
   	 	}else{
   	 		//如果选择根据店铺搜索
   	 		$("#head").empty();
   	 		$("#head").append("<td>店铺id</td><td>店铺名称</td><td>店铺图片</td><td>发货地址</td>");
   	 		getDataShop();
   	 	}
   	 	
   	 	
   	 	/*根据店铺搜索 ， 进行分页查询*/
 	 	function getDataShop(){
		 	 	//查询总行数
		 		$.post("${pageContext.request.contextPath}/shop.do",{"method":"pageCountSelect","desception":desception},function(rowCount){
		  		//等我已经拿到返回值了  在去计算要分页的显示情况
		  		 
		  		$("#Pagination").pagination(rowCount, {  
		  		     callback: PageCallback,  //回调函数  用来加载某一页的数据的Ajax的方法
			         prev_text: '<<  上一页',       //上一页按钮里text  
			         next_text: '下一页  >>',       //下一页按钮里text  
			         items_per_page: pageSize,  //每一页显示条数  
			         num_display_entries: 5,    //省略号中间连续显示的页面
			         current_page: 0,   //当前页索引  
			         num_edge_entries: 2        //省略号两边的页数
		     	}); 
		  	});
		  	
		  	function PageCallback(pageIndex,jq){
			   	$.post("${pageContext.request.contextPath}/shop.do",{"method":"ajaxPageSelect","currentPage":pageIndex,"pageSize":pageSize,"desception":desception},function(list){
			   		 
		    		   	//获取到数据之后先清除之前的内容
				   		$("#main").empty();
				   		$(list).each(function(){
				   			  $("#main").append("<tr>"+
				    			  "<td>"+this.shop_id+"</td>"+
				    			"<td><a href='${pageContext.request.contextPath}/shop.do?method=findShopById&shop_id="+this.shop_id+"'>"+this.shop_name+"<td>"+
				    			"<td><img class='img' src='"+${pageContext.request.contextPath}/+""+this.shop_img+"'><td>"+
				    			 "<td>"+this.shop_address+"</td>"+
				    		    "</tr>");
		   		        });
	    		  
		   			
			      },"json");
		  	}
		  	//调用函数显示第一页的数据
		  	PageCallback(0);
         }
         /*结束  根据店铺搜索 ， 进行分页查询*/
         
 	 	/*根据 商品 搜索 ， 进行分页查询*/
 	 	function getData(){
		 	 	//查询总行数
		 		$.post("${pageContext.request.contextPath}/goods.do",{"method":"pageCountSelect","goods_Desception":desception},function(rowCount){
		  		//等我已经拿到返回值了  在去计算要分页的显示情况
		  		 
		  		$("#Pagination").pagination(rowCount, {  
		  		     callback: PageCallback,  //回调函数  用来加载某一页的数据的Ajax的方法
			         prev_text: '<<  上一页',       //上一页按钮里text  
			         next_text: '下一页  >>',       //下一页按钮里text  
			         items_per_page: pageSize,  //每一页显示条数  
			         num_display_entries: 5,    //省略号中间连续显示的页面
			         current_page: 0,   //当前页索引  
			         num_edge_entries: 2        //省略号两边的页数
		      }); 
		  	});
		  	
		  	function PageCallback(pageIndex,jq){
		   	$.post("${pageContext.request.contextPath}/goods.do",{"method":"ajaxPageSelect","currentPage":pageIndex,"pageSize":pageSize,"goods_Desception":desception},function(list){
		   		 
	    		   	//获取到数据之后先清除之前的内容
			   		   $("#main").empty();
				   		$(list).each(function(){
				   			$("#main").append("<tr>"+
		    			 
		    			"<td><p id = 'id'>"+this.goods_id+"<p></td>"+
		    			 "<td><a href='${pageContext.request.contextPath}/goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+this.goods_Desception+"</a></td>"+
		    			 "<td><img class='img' src='"+${pageContext.request.contextPath}/+""+this.goods_img+"'><td>"+
		    			    "<td>"+this.goods_OutputPrice+"</td>"+
		    				"<td>"+this.goods_Count+"</td>"+
		    				"<td>"+this.goods_Status+"</td>"+
		    				"<td>"+this.goods_SellCount+"</td>"+
		    			//	"<td><a href='${pageContext.request.contextPath}/car.do?method=addCar&goods_id="+this.goods_id+"'>添加购物车</a></td>"+
		    			  "<td><button id='car' goods_id = "+this.goods_id+">添加到购物车</button></td>"+
		    			 "</tr>");
			   		});
	    		   
		   	 	},"json");
		  	}
		  	//调用函数显示第一页的数据
		  	PageCallback(0);
      }
   		  	
   		  	//点击加入购物车
   		  	$(document).on("click","#car" , function(){
   		  			var goods_id = $(this).attr("goods_id") ;
   		  	          
   		  	       $.post("car.do" ,{"method" : "addCar" , "goods_id" : goods_id},function(result){
   		  	       		alert(result);
   		  	       }); 
   		  	       
   		  	}) ;
   		  		
   		  		
   		  	 
   	</script> 
  </body>
</html>
