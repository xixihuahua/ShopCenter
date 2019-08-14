<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>订单详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/showOrder.css" />
	<style>
	.img{
		width:50px;
	}
	
	</style>
</head>
<body>
	<!--导航栏 -->
		<!-- 导航栏-->
		<nav class="navbar navbar-default" role="navigation" style="height: 30px">
	    	<div class="container-fluid col-sm-offset-2">
				    
				    <div>
				        <ul class="nav navbar-nav">
				        	<li><a href="#">首页</a></li>
				            <li><a href="${pageContext.request.contextPath }/custom/customCenter.jsp"" id="a1">${customer.custom_name}</a></li>
				            <li><a href="${pageContext.request.contextPath }/nav/Reg.jsp">免费注册</a></li>
				            <li><a href="#" class="	glyphicon glyphicon-shopping-cart">购物车</a></li>
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
				 			<li><a href="${pageContext.request.contextPath }/custom/customCenter.jsp">订单详情</a></li>
				        	<li><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">首页</a></li>
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                    账户设置
				                    <b class="caret"></b>
				                </a>
				                <ul class="dropdown-menu">
				                    <li><a href="#">更改登录密码</a></li>
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



		<!--订单详情表单 -->
		<div id="body">
			<div id="left">
				<ul>
					<li>全部功能</li>
					<li><a href="${pageContext.request.contextPath}/custom/carSh">我的购物车</a></li>
					<li><a>已买到的宝贝</a></li>
					<li><a>退款维权</a></li>
					<li><a>我的收藏</a></li>
					<li><a>评价管理</a></li>
					<li><a>我的积分</a></li>
				</ul>	
			</div>
				
			<div id="right">
					<div id="frm" name="frm1">
						<table  class="table table-hover">
								<tbody class="table table-hover" border="0" cellpadding="0" cellspacing="20" >
									<tr  align="center" class='danger'>
										<th  align="center" style="width: 10px; "><div>全选<input id="selectAll" type="checkbox" ></div><br>
     							<div>反选<input id="reverseSelect" type="checkbox" ></div></th>
										<th  align="center" style="width: 10px; ">序号</th>
										<th  align="center" style="width: 10px; ">订单号</th>
										
										<th  align="center" style="width: 150px; ">宝贝</th>
										<th  align="center" style="width: 5px; ">单价</th>
										<th  align="center" style="width: 20px; ">数量</th>
										<th  align="center" style="width: 20px; ">折扣</th>
										<th  align="center" style="width: 200px; ">交易状态</th>
										<th  align="center" style="width: 20px; ">实付款</th>
										<th  align="center" style="width: 200px; ">店铺</th>
										<th  align="center" style="width: 100px; ">交易操作</th>
									</tr>
					<c:forEach items="${order }" var="orders" varStatus="status">
		 	    		 <tr  align="center" class='info'>
		 	     			 <td  align="center" style="width: 10px; "><div><input class='c1' type='checkbox'></div></td>
		     				 <td  align="center" style="width: 10px; ">${status.index+1}</td> 
		     				 <td  align="center" style="width: 10px; ">${orders.order_id}</td>
				     		 <td align="center" style="width: 150px; "><img class="img" src="${pageContext.request.contextPath }/${orders.goods_img }"><br>
				     		 <a href="goods.do?method=findGoodsById&goods_id=${orders.goods_id}"><p>${orders.goods_desception }</a></td>
				    		 <td align="center" style="width: 5px; ">￥${orders.goods_price }</td>
				    		 <td align="center" style="width: 20px; ">${orders.goods_number}</td>
				    		 <td align="center" style="width: 20px; ">${orders.goods_count }</td>
				    		 <td align="center" style="width: 300px; ">支付状态:${orders.ordergoods_checkPay }<br>
				    		 发货状态:${orders.ordergoods_shopsend }<br>
				    		 收货状态:${orders.ordergoods_customget }<br>
				    		 退货状态:${orders.ordergoods_customback }<br>
				    		 卖家退货:${orders.ordergoods_shopget }
				    		 </td>
				    		 <td align="center" style="width: 20px; ">￥${orders.goods_price * orders.goods_count*orders.goods_number}</td>
				    		 <td align="center" style="width: 200px; ">${orders.shop_name }</td>
				    		 <td align="center" style="width: 200px; ">
				    		<a href="javascript:ChangeCustomGet(${orders.goods_id },${orders.order_id })">收货</a>/
				    		 	
				    		 	<a href='javascript:ChangeCustomBack(${orders.goods_id },${orders.order_id })'>退货</a>/
				    		 	<a href='javascript:ChangeCustomBackGet(${orders.goods_id },${orders.order_id })'>取消退货</a>
				    		 </td>
		      	 		</tr>
		    		 </c:forEach>
							</tbody>
					</table>
				</div>
			</div>
		</div>
		

		<script type="text/javascript">	
		//收货
		function ChangeCustomGet(goods_id,order_id){
     		
     		
     		
     		$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "ChangeCustomGet" , "goods_id" : goods_id.toString()  ,"order_id" : order_id },function(data){
     			alert(data);
     		});
     	}
		//退货
		function ChangeCustomBack(goods_id,order_id){
		$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "ChangeCustomBack", "order_id" : order_id , "goods_id" : goods_id ,"ordergoods_customback" : "1"},function(result){
     				alert(result);
				});
				}
		function ChangeCustomBackGet(goods_id,order_id){
		$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "ChangeCustomBack", "order_id" : order_id , "goods_id" : goods_id ,"ordergoods_customback" : "0"},function(result){
     				alert(result);
				});
		}
				//全选
	  		 $(document).on("click","#selectAll",function(){
			 		var boxs=$(".c1");
			 		boxs.each(function(){
			 			$(this).prop("checked",$("#selectAll").prop("checked"));
			 		});
             });
   		 
	   		 //反选
			$(document).on("click","#reverseSelect",function(){		
				var boxs=$(".c1");
				for(var i=0;i<boxs.length;i++){
					boxs[i].click();
				}
			});
		</script>
</body>
</html>
