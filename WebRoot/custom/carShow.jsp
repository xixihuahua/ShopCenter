<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.shop.entity.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>${customer.custom_name}的购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/carShow.css" />
	<style>
		.img{
			width:100px;
		}
		
	</style>
	
</head>
<body>
 <%Custominfo custom=(Custominfo)request.getSession().getAttribute("customer");
  		 	if(custom==null){response.sendRedirect("/nav/Login.jsp");
  		  %>不存在用户<%}else{ %>
	<!-- 导航栏-->
	<div class="nav navbar-default">
		<ul class="">
			<li class="col-md-1 col-md-offset-2 col-sm-1"><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">首页</a></li>
			<li class="col-md-1 col-sm-1"><a href="${pageContext.request.contextPath }/custom/customCenter.jsp">我的主页</a></li>
			<li class="col-md-1 col-sm-1"><a href="${pageContext.request.contextPath }/custom/carShow.jsp">购物车</a></li>
			<li class="col-md-1 col-sm-1"><a href="">收藏夹</a></li>
			<li class="col-md-1 col-sm-1"><a href="">商品分类</a></li>
			<li class="col-md-1 col-sm-1"><a href="">卖家中心</a></li>
			<li class="col-md-1 col-sm-1"><a href="">联系客服</a></li>
			<li class="col-md-1 col-sm-1"><a href="">网站导航</a></li>
		</ul>
	</div>	
	

	<div id="body">
		<div id="top">
			<div class="left col-md-3 col-md-offset-2">
				<img src="${pageContext.request.contextPath }/images/6.png">
				<span>${customer.custom_name}的购物车</span>
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
		<hr width=900 SIZE=20>


		<!--商品信息 -->
		<div id="center">
			<div id="box-top">
				<ul id="left" class="col-md-4 col-md-offset-2">
					<li><a href="">全部商品</a></li>
					<li>|</li>
					<li><a href="">降价商品</a></li>
					<li>|</li>
					<li><a href="">库存紧张</a></li>
				</ul>
				<ul id="right" class="col-md-4 col-md-offset-1">
					<li>已选商品（不含运费）</li>
					<li><input id="price" type="number" readonly value="0.0"/></li>
					
				</ul>
			</div>					
			<hr width=900>
		
			<!--商品表单 -->
			<form id="frm" name="frm1">
					<table id="box-center" >
						<thead>
							<tr id="max" class="">
								<th>
								<div>全选<input id="selectAll" type="checkbox" ></div><br>
     							<div>反选<input id="reverseSelect" type="checkbox" ></div>
     							</th>
								<th>商品信息</th>
								<th>商品id</th>
								<th>单价</th>
								<th>数量</th>
								<th>折扣</th>
								<th>店铺名</th>
								
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="main"> 
							
												
						</tbody>
						<tfoot id="foot">
						</tfoot>
					</table>
			</form>
				<div align="center"><button id="buy">立即购买</button></div>
		</div>
	</div>
<%} %>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<!-- 底部 -->
	<hr>
	<div id="footer">
			<ul>
				<li>合作伙伴</li>
				<li>淘宝</li>
				<li>天猫</li>
				<li>京东</li>					
				<li>支付宝</li>
				<li>阿里巴巴</li>
			</ul>
			<ul>
				<li>护肤</li>
				<li>产品汇总</li>
				<li>产品种类</li>
				<li>肌肤烦恼</li>
				<li>明星产品</li>
			</ul>
			<ul>
				<li>彩妆</li>
				<li>粉底</li>			
				<li>卸妆</li>
				<li>美妆工具</li>
				<li>肌肤小帮手</li>
				<li>重点彩妆</li>
			</ul>
			<ul>
				<li>个人中心</li>
				<li>个人中心</li>
				<li>个人信息</li>
				<li>我的客服</li>
				<li>素颜管家</li>
			</ul>
			<ul>
				<li>其他</li>
				<li>正品声明</li>
				<li>服务条款</li>
				<li>联系我们</li>
				<li></li>
			</ul>
	</div>
	<hr>
	<div id="footer2">
		品牌热线： 000-000-0000（固定电话） 010-101-1007（手机用户）    服务时间为： 周一至周五9:00-16:30，国家法定节假日除外
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
	<script type="text/javascript">
		 var custom_id =${customer.custom_id};
  			//选中的商品的总价
  			var price = 0.0;
  			 
  			 $("#price").blur(function(){
  					price = 0.0;
  			 		var box =  $(":checkbox:checked");
  			        var i = 0 ;
  			        
					box.each(function(){
						
						if($(this).parent().text()!="全选" && $(this).parent().text()!="反选"){
					 	 //获取对应商品的数量
			 			 var goods_number = $(this).parent().parent().nextAll().eq(3).children().val();
			 			 //获取对应商品的价格
			 			 
			 			  var goods_price = $(this).parent().parent().nextAll().eq(2).html();
			 			  //获取“元”的下标
			 			 
			 			  var index = goods_price.indexOf("元");
			 			  //获取商品的价格的数字
			 			  goods_price = goods_price.substring(0,index);
			 			   //获取对应商品的折扣
			 			  var goods_count = $(this).parent().parent().nextAll().eq(4).html();
			 			
						 price += eval(goods_price * goods_number * goods_count );
						 
						
			 			 i++;
			 			}
			 	  });
			 	  //保留两位小数
					 price =price.toFixed(2);
					 $("#price").val(price);
  			  });
  			  
  			  //显示全部商品
  		$.post("${pageContext.request.contextPath}/car.do",{"method":"goodsInCar"},function(list){
		    	$("#main").empty();
		    		$(list).each(function(){
		    			$("#main").append(
		    			"<tr>"+
		    			   "<td><div><input class='c1' type='checkbox' goods_id ="+this.goods_id+"></div></td>"+
		    			   "<td><a href='${pageContext.request.contextPath}/goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+
		    			   "<img class='img' src='${pageContext.request.contextPath }/"+this.goods_Img+"'>"+this.goods_desception+"</a></td>"+
		    			   "<td>"+this.goods_id+"</td>"+
		    			   "<td>"+this.goods_OutputPrice+"元</td>"+
		    			   "<td id='number'><input type='number' class='carNumber' id='carNumber' name='carGoods_number' max='10000' min='1' goods_id="+this.goods_id+" value='"+this.carGoods_number+"' ></td>"+
		    			   "<td>"+this.goods_count+"</td>"+
		    			   "<td><a href='${pageContext.request.contextPath}/shop.do?method=findShopByName&shop_name="+this.shop_name+"'>"+this.shop_name+"</a></td>"+
		    				 
		    				"<td><a href='javascript:deleteCar("+this.goods_id+","+custom_id+")'>删除</a></td>"+
		    			 
		    			 "</tr>"
		    			);
		    		});
		    	
		 },"json");
		 	
		 	//每次商品数量更改时，也更改数据库里面的值
		 	$(document).on("blur" , "#carNumber" , function(){
		 		   
		 	 	$.post("${pageContext.request.contextPath}/car.do",{"method" : "updateCar" , "goods_id":$(this).attr("goods_id") , "carGoods_number" : $(this).val()},function(result){
		 		  alert(result);
		 		 });
		 	});
  			  
  			  //删除购物车
  			  function deleteCar(goods_id,custom_id){
  				if(confirm("确定要删除吗?")){
  			  	$.post("${pageContext.request.contextPath}/car.do",{"method":"deleteCar","goods_id":goods_id,"custom_id":custom_id},function(data){
  			  		alert(data);
  			  		
  			  	});
  			  	}
  			  }
  			 
  			  
  			  //点击购买
	  		 $(document).on("click","#buy",function(){
	  		 	var ordersgoods_id = new Array();//存放被选中的商品的id
		 	    var ordersgoods_number = new Array() ;//存放商品的数量
			 	var box =  $(":checkbox:checked");
			 	var i = 0 ;
				 box.each(function(){
				 		//存放被选中的商品的id
				 		 
				 		  if($(this).parent().text()!="全选" && $(this).parent().text()!="反选"){
			 			  ordersgoods_id[i] = $(this).attr("goods_id") ;
			 			  ordersgoods_number[i] = $(this).parent().parent().nextAll().eq(3).children().val();
			 			  i++;
			 			 }
			 		});
				$.post("${pageContext.request.contextPath}/car.do",{"method":"submitCar","ordersgoods_id":ordersgoods_id.toString(),"ordersgoods_number":ordersgoods_number.toString()},function(result){
					alert(result);
					
				});
				
				
		    	
						    	
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
