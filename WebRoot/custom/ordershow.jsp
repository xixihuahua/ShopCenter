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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
   <form id="frm" name="frm" action="">
   
   <table class="table table-hover">
 	 <tr class='danger'>
 	 	<th><div>全选<input id="selectAll" type="checkbox" ></div><br>
     		<div>反选<input id="reverseSelect" type="checkbox" ></div>
		</th>
 	 	<th>序号</th>
 	 	<th>订单id</th>
 	 	<th>商品号</th>
 	 	<th>商品名字</th>
 	 	<th>商品图</th>
 	 	<th>商品数量</th>
 	 	
 	 	<th>商品状态</th>
 	 	<th>单价</th>
 	 	<th>折扣</th>
 	 	<th>商品总价</th>
 	 	<th>店家</th>
 	 	<th>发货地址</th>
 	 	<th>操作</th>
 	 </tr>
 	<c:forEach items="${order }" var="orders" varStatus="status">
 	     <tr class='info'>
 	     	<td><div><input class='c1' type='checkbox'></div></td>
     		 <td>${status.index+1}</td> 
     		 <td>${orders.order_id}</td>
     		 <td><a href="goods.do?method=findGoodsById&goods_id=${orders.goods_id}"><p>${orders.goods_id }</p></a></td>
    		 <td><p>${orders.goods_desception }</p></td>
    		 <td>${orders.goods_img }</td>
    		 <td>${orders.goods_number}</td>
    		 <td>支付状态:${orders.ordergoods_checkPay }<br>
    		 	 发货状态:${orders.ordergoods_shopsend }<br>
    		 	 收货状态:${orders.ordergoods_customget }<br>
    		 	 是否退货:${orders.ordergoods_customback }
    		 </td>
    		
    		
    		 
    		 <td>${orders.goods_price }</td>
    		 <td>${orders.goods_count }</td>
    		 <td>${orders.goods_price * orders.goods_count*orders.goods_number}元</td>
    		 <td>${orders.shop_name }</td>
    		 <td>${orders.shop_address }</td>
    		 <td><a href="javascript:">退货</a>/
    		 	<a href="javascript:getGoods(${orders.goods_id },${orders.order_id })">收货</a></td>
      	 </tr>
     </c:forEach>
     </table>
     </form>
     <button type="button" class="btn btn-default" id="btnGet">收货</button>
     <button type="button" class="btn btn-default" id="btnBack">退货</button>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
     <script type="text/javascript">
     	//收货
     	 $(document).on("click","#btnGet",function(){
     	 	var an = confirm("您确定收货了吗?");
     		var goods_id = new Array();//存放被选中的商品的id
	 	    var orders_id = new Array() ;//存放商品的数量
		 	var box =  $(":checkbox:checked");
		 	var i = 0 ;
		 if(an){
			box.each(function(){
		 		  if($(this).parent().text()!="全选" && $(this).parent().text()!="反选"){
	 			 //	alert($(this).parent().parent().nextAll().eq(2).text());
	 			 //	alert($(this).parent().parent().nextAll().eq(1).text());
	 			  	goods_id[i] = $(this).parent().parent().nextAll().eq(2).text();
	 			 	
	 			 	orders_id[i] = $(this).parent().parent().nextAll().eq(1).text();
	 			 	
	 			
	 			  i++;
	 			 }
     	});
     		
     		$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "getGoods" , "goods_id" : goods_id.toString()  ,"orders_id" : orders_id.toString() },function(data){
     			alert(data);
     		});
     		/* $.ajax({
						dataType:"json",
		    			type:"post",
				 		type : "post" ,
				 		url : "${pageContext.request.contextPath}/ordergoods.do" ,
				 		data : {method : "getGoods" , goods_id : goods_id.toString()  ,orders_id : orders_id.toString() } ,
				 		erro: function(data){
				 			alert(result);},
				 		success: function (data) {
							alert(result);
						}
		    	});*/
     		}
     	});
     	
     	function getGoods(goods_id,order_id){
     		
     		alert("goods_id:"+goods_id);
     		$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "ChangeCustomGet" , "goods_id" : goods_id.toString()  ,"order_id" : order_id },function(data){
     			alert(data);
     		});
     	}
     	
     	
     	//退货
     	 $(document).on("click","#btnBack",function(){
     	 	var an = confirm("您确定退货了吗?");
     		var goods_id = new Array();//存放被选中的商品的id
	 	    var orders_id = new Array() ;//存放商品的数量
		 	var box =  $(":checkbox:checked");
		 	var i = 0 ;
		 if(an){
			box.each(function(){
		 		  if($(this).parent().text()!="全选" && $(this).parent().text()!="反选"){
	 			 //	alert($(this).parent().parent().nextAll().eq(2).text());
	 			 //	alert($(this).parent().parent().nextAll().eq(1).text());
	 			  	goods_id[i] = $(this).parent().parent().nextAll().eq(2).text();
	 			 
	 			 	orders_id[i] = $(this).parent().parent().nextAll().eq(1).text();
	 			 
	 			
	 			  i++;
	 			 }
     	});
     	
     		$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "backGoods" , "goods_id" : goods_id.toString()  ,"orders_id" : orders_id.toString() },function(data){
     			alert(data);
     		});
     		
     		/* $.ajax({
						dataType:"json",
		    			type:"post",
				 		type : "post" ,
				 		url : "${pageContext.request.contextPath}/ordergoods.do" ,
				 		data : {method : "backGoods" , goods_id : goods_id.toString()  ,orders_id : orders_id.toString() } ,
				 		success: function (data) {
				 		alert(1);
							alert(data);
						}
		    	});*/
     		}
     	});
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
