<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>卖家订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
 	<style>
 		.table{
 			 border-collapse:collapse;
 		 
 		}
 		table, td, th {
			    border:1px solid green;
			}
		th {
			    background-color:green;
			    color:white;
			}
		.img{
			width : 50px ;
		 }
 	</style>
  </head>
  		
  <body>
 	   <button id="btnOrder">查看所有订单</button>
      <!--   <button id="btnOrderPay">待付款</button> -->
       <button id="btnOrderSellerSend">待发货</button>
       <button id="btnOrderCustomSend">待确认退货</button>
        <button id="btnOrderCustomComment">待评价</button>
	  <table >
	  			<thead>
			     	<tr id="main" >
			     		
			     	</tr>
		     	</thead>
	     		<tbody id="body" >
	     			
	     		</tbody>
	    </table>
   
    
      
     
     <script type="text/javascript">
     	 
   			 //默认显示所有所有订单
   			 AllOrder();
   			 
        	 //点击显示未评论的订单
   			 $("#btnOrderCustomComment").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findBySellerCustomComment" ,  "ordergoods_comment" : "0"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append( 
		    				"<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	"<th>商品id</th>"+
					 	 	"<th>商品名</th>"+
					 	 	"<th>商品图片</th>"+
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>单价</th>"+
					 	 	"<th>店铺名</th>"+
					 	 	"<th>操作</th>"
					  );
	    		
	    			
		    		$("#body").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='加载失败' src='${pageContext.request.contextPath}${customer.custom_img}'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
				    		 	"<td><button>联系买家</button></td>"+
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body").append("待评论订单为空呀 !!!");
		    		}
		    		
		    		},"json");	
   			
   			});
   			
     		
     		
     		 //点击显示被退货,等待确认退货 的订单
   			 $("#btnOrderCustomSend").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findBySellerCustomBackCId", "ordergoods_customback" : "0" ,"ordergoods_shopget" : "0" },function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append(  
		    			 	"<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	"<th>商品id</th>"+
					 	 	"<th>商品名</th>"+
					 	 	"<th>商品图片</th>"+
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>单价</th>"+
					 	 	"<th>店铺名</th>"+
					 	 	"<th>操作</th>"
					 );
	    		
	    			
		    		$("#body").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='加载失败' src='${pageContext.request.contextPath}${customer.custom_img}'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
				    			 "<td><button class = 'back'>确认退货</button></td>"+
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body").append("等待确认退货订单为空呀 !!!");
		    		}
		    		
		    		},"json");	
   			
   			});
   			
     		//卖家点击确认退货
     		$(document).on("click" , ".back" , function(){
     			 
     			//获取订单id
     			var order_id = $(this).parent().prevAll().eq(8).children().html();
     			//获取商品id
     			var goods_id = $(this).parent().prevAll().eq(7).html();
     			//获取商品数量
     			var goods_number =  $(this).parent().prevAll().eq(3).html();
     			
     			
     			$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "SellerReturnBack" ,"order_id":order_id ,"goods_id" : goods_id , "goods_number" : goods_number } , function(result){
     				alert(result);
     			});
     		});
     		
   			 //点击显示买家未收货订单
   			 $("#btnOrderGet").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findBySellerCustomGetCId",  "ordergoods_customget" : "0"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append( 
		    			    "<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	"<th>商品id</th>"+
					 	 	"<th>商品名</th>"+
					 	 	"<th>商品图片</th>"+
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>单价</th>"+
					 	 	"<th>店铺名</th>"+
					 	 	"<th>操作</th>"
					 );
	    		
	    			
		    		$("#body").empty();
		    		
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='加载失败' src='${pageContext.request.contextPath}${customer.custom_img}'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
				    		 	"<td><button>联系买家</button></td>"+
				    		  "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body").append("买家未收货订单为空呀 !!!");
		    		}
		    		
		    		},"json");	
   			
   			});
   			 
   			 
   			//点击查看待发货的订单
   			$("#btnOrderSellerSend").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findBySellerShopSendCId",  "ordergoods_shopsend" : "0"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append(  
		    				"<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	"<th>商品id</th>"+
					 	 	"<th>商品名</th>"+
					 	 	"<th>商品图片</th>"+
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>单价</th>"+
					 	 	"<th>店铺名</th>"+
					 	 	"<th>操作</th>"
				 	);
	    		
	    			
		    		$("#body").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
		    			    $("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='加载失败' src='${pageContext.request.contextPath}${customer.custom_img}'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
				    			 "<td><button class='send'>发货</button></td>"+
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body").append("待发货订单为空呀 !!!");
		    		}
		    		
		    		},"json");	
   			
   			});
   			
   			//点击发货
     		$(document).on("click", ".send" , function(){
     			//获取订单id
     			var order_id = $(this).parent().prevAll().eq(8).text();
     			//获取商品id
     			var goods_id = $(this).parent().prevAll().eq(7).text();
     			
     		
     			//更改发货状态
     			$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "ChangeShopSend", "order_id" : order_id , "goods_id" : goods_id},function(result){
     				alert(result);
     			
     			});
     			 
     		});
     		
     		
     		
   		/*	//点击查看待支付的订单
   			$("#btnOrderPay").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"orderBySellerPayCId",  "ordergoods_checkPay" : "0"},function(order){
	    		//获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append( 
		    			    "<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	"<th>商品id</th>"+
					 	 	"<th>商品名</th>"+
					 	 	"<th>商品图片</th>"+
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>单价</th>"+
					 	 	"<th>店铺名</th>"+
					 	 	"<th>操作</th>"
					 	 	"<th>操作</th>"
					);
	    		
		    		$("#body").empty();
		    		if(order != ""){
		    			$(order).each(function(){
		    			var i = 1 ;
		    			$("#body").append("<tr>"+
			     			" <td>"+i+"</td> "+
			     			" <td><a href = 'ordergoods.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
			     			" <td>"+this.order_id+"</td>"+
			    			 "<td>"+this.ordergoods_payTime+"</td>"+
							   	"<td>"+this.goods_id +"</td>"+
							   	"<td>"+this.goods_number +"</td>"+
							   	"<td>"+this.goods_price +"元</td>"+
			    			"<td><button class='return'>联系买家</button></td>"+
		    			 "</tr>");
		    			 i++;
		    			});
		    		}else{
		    			$("#body").append("订单为空呀 !!!");
		    		 }
		    		
		    		},"json");	
   			
   			});*/

   			//点击查看所有订单
   		 
   			$("#btnOrder").click(function( ){
   			 
   				 AllOrder();
   			 });
   			
   			function AllOrder(){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"orderBySellerId"},function(order){
	    		//获取到数据之后先清除之前的内容e
	    		$("#main").empty();
	    		$("#main").append(
	    					"<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	"<th>商品id</th>"+
					 	 	"<th>商品名</th>"+
					 	 	"<th>商品图片</th>"+
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>单价</th>"+
					 	 	"<th>店铺名</th>"+
					 	 	 "<th>买家是否支付</th>"+
				 	 		"<th>卖家是否发货</th>"+
				 	 		"<th>买家是否退货</th>"+
				 	 		"<th>卖家是否退货</th>"
			 	 );
	    		
	    	 
	    		$("#body").empty();
	    		if(order != ""){
	    			$(order).each(function(){
	    			var i = 1 ; 
	    			$("#body").append("<tr>"+
		     					"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='加载失败' src='${pageContext.request.contextPath}${customer.custom_img}'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
		    			 "<td>"+this.ordergoods_checkPay+"</td>"+
		    			 "<td>"+this.ordergoods_shopsend+"</td>"+
		    			 "<td>"+this.ordergoods_customget+"</td>"+
		    			 "<td>"+this.ordergoods_shopget+"</td>"+
	    			 "</tr>");
	    			   i++;
	    			});
	    		
	    		}else{
	    			$("#body").append(
		    			"订单为空呀 !!!"
			    	);
	    		}
	    		
	    		},"json");	
   			}
   			
   			
     </script>
  </body>
</html>
