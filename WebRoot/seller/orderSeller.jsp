<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>卖家订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pagination.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/orderSeller.css" />

  </head>
  
  <body>
  		<!-- 导航栏-->
		<nav class="navbar navbar-default" role="navigation">
	    	<div class="container-fluid col-md-offset-2">
				    <div>
				        <ul class="nav navbar-nav">
				        	<li><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">首页</a></li>
				            <li><a href="${pageContext.request.contextPath }/seller/sellerCenter.jsp" id="a1">${seller.seller_name }</a></li>
				            
				            
							<li><a href="#">收藏夹</a></li>
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                    网站导航
				                    <b class="caret"></b>
				                </a>
				                <ul class="dropdown-menu">
				                    <li><a href="#">百度</a></li>
				                    <li><a href="#">新浪</a></li>
				                    <li><a href="#">天猫</a></li>
				                    <li class="divider"></li>
				                    <li><a href="#">京东</a></li>
				                    <li class="divider"></li>
				                    <li><a href="#">谷歌</a></li>
				                </ul>
				            </li>
				        </ul>
				    </div>
			</div>
		</nav>
		
	
		<!--搜索框 -->
		<div id="select">
			<div class="left col-md-3 col-md-offset-2">
				<img src="">
				 <ul>		
				 			<li><a href="${pageContext.request.contextPath }/seller/orderSeller.jsp">订单表</a></li>
				        	<li><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">首页</a></li>
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                    账户设置
				                    <b class="caret"></b>
				                </a>
				                <ul class="dropdown-menu">
				                    <li><a href="${pageContext.request.contextPath }/seller/sellerCenter.jsp">更改登录密码</a></li>
				                    <li><a href="#">手机绑定</a></li>
				                    <li><a href="#">更改头像</a></li>      
				                    <li><a href="#">收货地址</a></li>           
				                    
				                </ul>
				            </li>
				        </ul>
			</div>
			<!--搜索框 -->
			<div class=" right col-md-4 col-md-offset-1 " >
				<div class="input-group">
						<input type="text" class="form-control" >
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								搜索
							</button>
						</span>
					</div><!-- /input-group -->
			</div>
		</div>


	<!--订单表 -->
			<div id="body">
				<div id="left">
						<ul>
							<li>全部功能</li>
							<li>退款维权</li>
							<li>评价管理</li>
							<li>我的积分</li>
						</ul>	
					</div>

				<div id="right">
				
				 <button class="btn btn-primary" id="btnOrder">查看所有订单</button>
			      <!--   <button id="btnOrderPay">待付款</button> -->
			       <button class="btn btn-info" id="btnOrderSellerSend">待发货</button>
			       <button class="btn btn-dark" id="btnOrderGet">待收货</button>
			       <button class="btn btn-warning" id="btnOrderCustomSend">待确认退货</button>
			        <button  class="btn btn-success" id="btnOrderCustomComment">待评价</button>
										<div id="frm" name="frm1">
								<table class="table table table-hover">
										<thead class="table-primary">
											<tr  id="main">
												
											</tr>
										</thead>
										<tbody id="body1">
											
											
										</tbody>
								</table>
							</div>
					</div>
				</div>

		<script type="text/javascript">
     	 
   			 //默认显示所有所有订单
   			 AllOrder();
   			 
   			 
   			 
   			
   			 //已收货的订单
   			 
   			 
   			 
        	 //点击显示未评论的订单
   			 $("#btnOrderCustomComment").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findBySellerCustomComment" ,  "ordergoods_comment" : "0"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append( 
		    				"<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>交易状态</th>"+
					 	 	"<th>操作</th>"
					  );
	    		
	    			
		    		$("#body1").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body1").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			 "<td>支付状态"+this.ordergoods_checkPay+
		    			 "<br>发货状态"+this.ordergoods_shopsend+
		    			 "<br>收货状态"+this.ordergoods_customget+
		    			 "<br>买家退货状态:"+this.ordergoods_customback+
		    			 "<br>退货状态"+this.ordergoods_shopget+"</td>"+
				    			"<td><a>删除订单</a><td>"+
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body1").append("待评论订单为空呀 !!!");
		    		}
		    		
		    		},"json");	
   			
   			});
   			
     		
     		
     		 //点击显示被退货,等待确认退货 的订单
   			 $("#btnOrderCustomSend").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findBySellerCustomBackCId", "ordergoods_customback" : "1" ,"ordergoods_shopget" : "0" },function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append(  
		    			 	"<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>交易状态</th>"+
					 	 	"<th>操作</th>"
					 );
	    		
	    			
		    		$("#body1").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body1").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    					
		    			 "<td>支付状态"+this.ordergoods_checkPay+
		    			 "<br>发货状态"+this.ordergoods_shopsend+
		    			 "<br>收货状态"+this.ordergoods_customget+
		    			 "<br>买家退货状态:"+this.ordergoods_customback+
		    			 "<br>退货状态"+this.ordergoods_shopget+"</td>"+
				    			"<td><a>删除订单</a><td>"+
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body1").append("等待确认退货订单为空呀 !!!");
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
					 	 	
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>交易状态</th>"+
					 	 
					 	 	"<th>操作</th>"
					 );
	    		
	    			
		    		$("#body1").empty();
		    		
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body1").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    					
		    			 "<td>支付状态"+this.ordergoods_checkPay+
		    			 "<br>发货状态"+this.ordergoods_shopsend+
		    			 "<br>收货状态"+this.ordergoods_customget+
		    			 "<br>退货状态"+this.ordergoods_shopget+"</td>"+
				    		 	"<td><a>删除订单</a><td>"+
				    		  "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body1").append("买家未收货订单为空呀 !!!");
		    		}
		    		
		    		},"json");	
   			
   			});
     		
     		
     		
   			 //点击显示买家未收货订单
   			 $("#btnOrderGet").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findBySellerCustomGetCId",  "ordergoods_customget" : "0"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append( 
		    			    "<th>序号</th>"+
					 	 	"<th>订单id</th>"+
					 	 	
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>交易状态</th>"+
					 	 
					 	 	"<th>操作</th>"
					 );
	    		
	    			
		    		$("#body1").empty();
		    		
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body1").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    					
		    			 "<td>支付状态"+this.ordergoods_checkPay+
		    			 "<br>发货状态"+this.ordergoods_shopsend+
		    			 "<br>收货状态"+this.ordergoods_customget+
		    			 "<br>退货状态"+this.ordergoods_shopget+"</td>"+
				    		 	"<td><a>删除订单</a><td>"+
				    		  "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body1").append("买家未收货订单为空呀 !!!");
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
					 	 
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	
					 	 	"<th>交易状态</th>"	+
					 	 	"<th>操作</th>"
				 	);
	    		
	    			
		    		$("#body1").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
		    			    $("#body1").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    					
		    			 "<td>支付状态"+this.ordergoods_checkPay+
		    			 "<br>发货状态"+this.ordergoods_shopsend+
		    			 "<br>收货状态"+this.ordergoods_customget+
		    			 "<br>退货状态"+this.ordergoods_shopget+"</td>"+
				    			 "<td><a>删除订单</a><td>"+
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body1").append("待发货订单为空呀 !!!");
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
					 	 	
					 	 	"<th>下单时间</th>"+
					 	 	"<th>总数</th>"+
					 	 	"<th>总价</th>"+
					 	 	"<th>交易状态</th>"
			 	 );
	    		
	    	 
	    		$("#body1").empty();
	    		if(order != ""){
	    		var i = 1 ; 
	    			$(order).each(function(){
	    			
	    			$("#body1").append("<tr>"+
		     					"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			
		    			 "<td>支付状态"+this.ordergoods_checkPay+
		    			 "<br>发货状态"+this.ordergoods_shopsend+
		    			 "<br>收货状态"+this.ordergoods_customget+
		    			 "<br>退货状态"+this.ordergoods_shopget+"</td>"+
	    			 "</tr>");
	    			   i=i+1;
	    			});
	    		
	    		}else{
	    			$("#body1").append(
		    			"订单为空呀 !!!"
			    	);
	    		}
	    		
	    		},"json");	
   			}
   			
   			
     </script>
  </body>
</html>
