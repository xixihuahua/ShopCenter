<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>${goods.goods_Desception }</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Goodsinfo.css" />
	<style type="text/css">
	 
	</style>
	</head>
	<body>	

		<!-- 导航栏 -->
		<div class="nav navbar-default">
			<ul class="">
				<li class="col-md-1 col-md-offset-2 col-sm-1"><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">首页</a></li>
				<li class="col-md-1 col-sm-1"><a href="${pageContext.request.contextPath }/custom/customCenter.jsp">我的主页</a></li>
				<% if (request.getSession().getAttribute("customer")!=null && request.getSession().getAttribute("seller")==null){%>
				<li class="col-md-1 col-sm-1"><a href="${pageContext.request.contextPath }/custom/carShow.jsp">购物车</a></li>
				<%}else if(request.getSession().getAttribute("customer")==null && request.getSession().getAttribute("seller")!=null ) {%>
				<%}else { %>
				<li class="col-md-1 col-sm-1"><a href="${pageContext.request.contextPath }/nav/Login.jsp">购物车</a></li>
				<%} %>
				<li class="col-md-1 col-sm-1"><a href="">收藏夹</a></li>
				<li class="col-md-1 col-sm-1"><a href="">商品分类</a></li>
			
				<li class="col-md-1 col-sm-1"><a href="">联系客服</a></li>
				<li class="col-md-1 col-sm-1"><a href="">网站导航</a></li>
			</ul>
		</div>	

		<!--搜索框 -->
		<div id="select">
			<div class="left col-md-3 col-md-offset-2">
				<img src="${pageContext.request.contextPath }/images/6.png">
				<span>商品详情</span>
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



		<!-- 商品信息 -->
		<div id="wrapper">
			<div id="image">
				<div id="small">
					<img id="" src="${pageContext.request.contextPath }/${goods.goods_Img}">
						
					<div id="slider"></div>
				</div>
				<div id = "big">
				<img  src="${pageContext.request.contextPath }/${goods.goods_Img}">
				
				</div>
				<div id="bottom">
					<a href="#n1"><img src="${pageContext.request.contextPath }/${goods.goods_Img}"></a>
					<a href="#n2"><img src="${pageContext.request.contextPath }/${goods.goods_Img}"></a>
					<a href="#n3"><img src="${pageContext.request.contextPath }/${goods.goods_Img}"></a>
				</div>
			</div>
			<div id="describe">
				<div>${goods.goods_Desception }</div>
				<img src="${pageContext.request.contextPath }/images/7.png" >
				<div id="data">
					
					<dl>
						<dt>价格:</dt>
						<dd><span>￥</span><span id="price">${goods.goods_OutputPrice }</span></dd>
					</dl>
					<dl>
						<dt>折扣价:</dt>
						<dd><span>￥</span><span id="discount">${goods.goods_Count * goods.goods_OutputPrice }</span></dd>
					</dl>
					<dl>
						<dt>类型:</dt>
						<dd><span id="goodsType">${goods.goodsType_name }</span></dd>
					</dl>
				</div>
				<dl>
					<dt>卖家:</dt>
					<dd><span id="address">${goods.shop_name }</span></dd>
				</dl>
				<dl>
					<dt>仓库地址:</dt>
					<dd><span id="address">${goods.shop_address }</span></dd>
				</dl>
				<dl>
					<dt>库存:</dt>
					<dd><span id="address">${goods.goods_Repertory }件</span></dd>
				</dl>
				<div id="panel">
					<ul>
						<li>
							<span>总销量</span>
							<span id="sales" class="red">${goods.goods_SellCount}</span>
						</li>
						<li>
							<span>累计评价</span>
							<span id="comment" class="red">1000</span>
						</li>
					</ul>
				</div>
				<div id="count">
					<dl class="count">
						<dt>数量</dt>
						<dd>
							<form>
								<input type="button" value="-" onClick="javascript:if(this.form.number.value>1) this.form.number.value--;">
								<input type="text" name="number" id="number" value="1" value=1 style="width: 30px; text-align: center;">
								<input type="button" value="+" onClick="javascript:this.form.number.value++;">
							</form>
						</dd>
					</dl>
					<dl class="stock">
						<dt>库存:</dt>
						<dd><span id="stock">${goods.goods_Repertory }</span><span>件</span></dd>
					</dl>
				</div>
				<div id="service">
					<dl>
						<dt>服务承诺</dt>
						<dd>
							<ul>
								<li>过敏包退</li>
								<li>破损包退</li>
								<li>正品保证</li>
								<li>急速退款</li>
								<li>七天无理由包退</li>
							</ul>
						</dd>
					</dl>
				</div>
				<div class="buy">
						<button id="buy" class="btn">立即购买</button>
				
						<button id="add" class="btn"><span class="	glyphicon glyphicon-shopping-cart">加入购物车</span></button>
					
				</div>
			</div>
		</div>
		
		


<!-- 评论区 -->
		<div id="box">
			<div id="left">
				<div id="top">
						<a href="#">旗舰店</a>
				</div>
				<div id="middle">
						黄金店铺
				</div>
				<div id="foot">
						<a href="shop.do?method=findShopById&shop_id=${goods.shop_id}">进店逛逛</a>
						<a href="#">收藏店铺</a>
				</div>
			</div> 
					
			<div id="right">
				<div  id="top">累计评价</div>
				<div id="middle">
					<br>	
					<div class="d1">与描述相符</div>
					<div class="d2">5</div>		
					<div class="d3">
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
					</div>
					
				</div>
				<form id="frm">
					<table>
							<thead>
								<tr>
			     	 				<th>买家id</th>
			     	 				<th>评论内容</th>
			     	 				<th>评论时间</th>
			     	 			</tr>
							</thead>

							<tbody id="main">
     	 		
     	 					</tbody>
		
					</table>

				</form>
			</div>

		</div>
        
		
		<div class="clear"></div>
	 
	 
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script> 
	 <script type="text/javascript">
	 
	  	var goods_id = ${goods.goods_id} ;
   		var shop_id = ${goods.shop_id};
   		
   		 //显示所有评论
   	    $.post("comment.do",{"method":"findCommentByGoods_id","goods_id" : goods_id},function(list){
	    		//获取到数据之后先清除之前的内容
	    	$("#main").empty();
	    	
	    	if(list != ""){
	    			$(list).each(function(){
	    			 $("#main").append("<tr>"+
	    			   	 "<td>"+this.custom_id+"*****</td>"+
	    			   	 "<td>"+this.comment_content+"</td>"+
	    			   	 "<td>"+this.comment_time+"</td>"+
	    			 "</tr>");
	    		});
	    	
	    	}else{
	    		$("#head").empty();
	    		 $("#main").append("<tr><td>还没有评论呀！！！</td></tr>");
	    	}
	    	
    	 },"json");
    	 
    	 
    	 
	  	//放大镜
	  	var small = document.getElementById("small");
		var slider = document.getElementById("slider");
		var big = document.getElementById("big");
		var bigImg = document.getElementsByTagName("img")[1];
		//让slider跟随鼠标移动.给小的方块绑定事件
		small.onmousemove = function(e) {
		var even = e || window.event;  //兼容火狐浏览器
		
		var x = even.clientX - small.offsetLeft - slider.offsetWidth/2;
		var y = even.clientY - small.offsetTop - slider.offsetHeight/2;
		
		//水平方向的最大值
		var maxX = small.clientWidth - slider.clientWidth;
		//竖直方向的最大值
		var maxY = small.clientHeight - slider.clientHeight;
		if(x<0){
		//相当于超出左侧,超出左侧时,拉回
		x=0;
		}
		//超出右侧时拉回
		if(x>maxX){
		x = maxX;
		}
		//顶部超出
		if(y<0){
		y=0;
		}
		//底部超出
		if(y>maxY){
		y = maxY;
		}
		slider.style.top = y + "px";
		slider.style.left = x + "px";
		//放大的图片的主要实现代码:一个比例计算
		big.scrollLeft = x/ (bigImg.clientWidth - big.clientWidth)*maxX ;
		big.scrollTop = y / (bigImg.clientHeight -big.clientHeight)*maxY;
		
		
		
		}
		//鼠标移入事件
		small.onmouseover = function(){
		//鼠标移入到原图时候实现,上面出现的小的方块
		slider.style.display = "block";
		//右侧的大图区域显示出来图片
		big.style.display = "block";
		}
		//添加鼠标移出事件,鼠标移出原图的时候,
		small.onmouseout = function(){
		slider.style.display="none";
		big.style.display = "none";
		}
	  	
	  	   //点击加入购物车
 		  	$(document).on("click","#add" , function(){
 		  		
 		  		   var goods_id =${goods.goods_id};
		  	       var carGoods_number =  $("#number").val() ;
		  	      
 		  	      $.post("car.do" ,{"method" : "addCar" , "goods_id" : goods_id , "carGoods_number" : carGoods_number },function(result){
 		  	       		alert(result);
 		  	      });  
 		  	    
 		  	      
 		  	       
 		  	      
 		  	}) ;
   		  	
	  	
	  		//点击立即购买
	  		$(document).on("click","#buy" , function(){
	  			
	  			var goods_id =${goods.goods_id};
	  	        var carGoods_number =  $("#number").val() ;
	  	      if(confirm("是否确定购买")){
	  	        $.post("car.do" ,{"method" : "buyNow" , "goods_id" : goods_id , "carGoods_number" : carGoods_number },function(result){
 		  	       		
							alert(result)
						
 		  	      });  
 		  	      }  
 		  	      
 		  	       
	  		});

	</script>

	</body>
</html>
