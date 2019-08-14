 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
  
    <title>买家中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="购物,商城,正品">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/maijia.css" />
  	<style>
	.right{
				float: right;
				backgroud-color:red;
				margin-left: 10px;
				line-height: 30px;
			}
	.img{
			width:50px;
	}		
	</style>
  
  </head>
  <body>
 	<nav class="navbar navbar-default navbar-fixed-top " role="navigation">
    <div class="container-fluid d1 bg-danger col-lg-6 col-md-6 col-xs-6 col-sm-6">
   
    <div>
        <ul class="nav navbar-nav d2">
              <% if(request.getSession().getAttribute("customer")!=null && request.getSession().getAttribute("seller")==null){ %>
            <li><a href="${pageContext.request.contextPath }/custom/customCenter.jsp"> ${customer.custom_name}</a>
           </li>
             <%}else if(request.getSession().getAttribute("customer")==null && request.getSession().getAttribute("seller")!=null){ %>
              <li><a href="${pageContext.request.contextPath }/seller/sellerCenter.jsp"> ${seller.seller_name}</a></li>
              <%}else{ %>
               <li><a href="${pageContext.request.contextPath }/nav/Login.jsp">用户名</a></li>
               <%} %>
            <li><a href="${pageContext.request.contextPath }/nav/Login.jsp">退出</a></li>
            <li><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">购物商城首页</a></li>
            
        </ul>
    </div>
    <div id="d3">
    	<ul class="nav navbar-nav ">
    		<li><img src="${pageContext.request.contextPath }/images/1.png"/></li>
    	</ul>
    </div>
    <div id="d4">
    	<ul class="nav navbar-nav">
    	<li><a >余额:${customer.custom_money}</a>
            </li>
            <li><a  data-toggle="modal" data-target="#myModal4">点我充值</a></li>
    		 <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    商品分类<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a class = "type"  href="#">底妆</a></li>
                    <li><a class = "type" href="#">唇部</a></li>
                    <li><a class = "type" href="#">眼部</a></li>
                    <li><a class = "type" href="#">修容</a></li>
                    <li><a class = "type" href="#">眉毛</a></li>
                    <li><a class = "type" href="#">护肤</a></li>
                </ul>
            </li>
             <li> 
        <a href="${pageContext.request.contextPath }/custom/carShow.jsp">
          <span class="glyphicon glyphicon-shopping-cart"></span>购物车
        </a>
             </li>
             <li><a href="#">联系客服</a></li>
            
    	</ul>
    </div>
    </div>
</nav>	
<nav class="navbar navbar-default navbar-fixed-top d5 " role="navigation">
    <div class="container-fluid d6 bg-warning col-lg-12 col-md-12 col-xs-12 col-sm-12">
    <div>
        <ul class="nav navbar-nav d7">
            <li></li>
            <li><a href="">我的购物商城</a></li>
            <li><a href="">首页</a></li>
        </ul>
        
        
    </div>
    <div id="d8">
    	<ul class="nav navbar-nav">
    		<div id="input" class="input-group ">
				 <select id = "select" style="width: 99px; ">
  				<option>宝贝</option>
  				<option>店铺</option>
  				</select>
		        <input id="name" name="name" type="text" class="form-control" placeholder="每天都要买买买！" style="border-color: pink; height: 36px">
		        <span class="input-group-addon" style="background-color: pink;">
		        	<a id="a" href="${pageContext.request.contextPath}/customFind.jsp" >搜索</a>
		        </span>
		    </div>
    	</ul>
    </div>
    </div>
</nav>	
<div id="d9">

<div id="d10">

	<nav class="navbar navbar-default navbar-fixed-top d11" role="navigation">
	<div class="container-fluid d12 bg-danger col-lg-12 col-md-12 col-xs-12 col-sm-12">
	
    <div>
        <ul class="nav navbar-nav d13">
            <li><a href="#"><img class="img" src="${pageContext.request.contextPath }/${customer.custom_img}" /></a></li>
        </ul>
    </div>
    
    <div>
    	<ul class="nav navbar-nav d14">
    		 <li><a href="${pageContext.request.contextPath }/custom/customCenter.jsp">${customer.custom_name }</a></li>
            
     	  <li>
     	  	<a class="s-avatar" data-spm="d4911997" data-toggle="modal" data-target="#myModal">
     	  	编辑用户资料
     	  	</a>
     	  </li>
          <li>
          <a class="s-avatar" data-spm="d4911997" data-toggle="modal" data-target="#myModal1">修改支付密码</a>
         </li>
          <li>
          <a  class="s-avatar" data-spm="d4911997" data-toggle="modal" data-target="#myModal2">更改绑定电话号码</a>
         </li>
         <li>
         <a class="s-avatar" data-spm="d4911997" data-toggle="modal" data-target="#myModal3">上传头像</a>
         </li>
          <li><a id="btnDel">注销账户</a></li>
          
    	</ul>
    	
    	
    </div>
    
    </div>
    </nav>
    <nav class="navbar navbar-default navbar-fixed-top d15 " role="navigation">
       <div class="container-fluid  col-lg-12 col-md-12 col-xs-12 col-sm-12">
    <div >
        <ul class="nav navbar-nav d16">
        	<li>
                <button class="btn btn-primary right" id="btnOrder" data-spm="d4919660"> <span>全部订单</span></button>
            </li>
           
            <li>
                <button class="btn btn-warning right" data-spm="d4919661"  id="btnOrderSellerSend" ><span>待发货</span></button>
            </li>
            <li>
                <button class="btn btn-info right" data-spm="d4919662" id="btnOrderGet" ><span>待收货</span></button>
            </li>
             
            <li>
                <button class="btn btn-default right" data-spm="d4919664" id="btnOrderCustomSend"  ><span>退款中</span></button>
            </li>
            <li>
            	<button class="btn btn-success right" data-spm="d4919665" id="btnOrderCustomComment"  ><span>待评价</span></button>
            </li>
            <li>
            	<button class="btn btn-warning right" data-spm="d491966" id="btnOrderMyComment"  ><span>我的评价</span></button>
            </li>
           
        </ul>
    </div>
   </div>
   </nav>
   <div id="table" class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
   
  <table class="table">
	     	<thead id="main" >
	     		
	     	</thead>
	     	
     		<tbody id="body" >
     		</tbody>
 </table>
 
</div>

</div>

</div>


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
	<script type="text/javascript">
   			 
   			 //默认显示所有所有订单
   			 AllOrder();
   			 
   			 //根据商品类型搜索
	    	$(document).on("click" , ".type" , function(){
	    		var typename = $(this).html();
	    	 	//修改跳转的页面以及传递的参数
	    		$(this).attr("href" , "${pageContext.request.contextPath}/selectGoods.jsp?desception="+typename+"&selected=商品类型");
	    	});
	    	
	    	//点击显示我的评论btnOrderMyComment
	    	 $("#btnOrderMyComment").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/comment.do",{"method":"findCommentByCustom_id" },function(comm){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append("<tr>"+ 
		    			   "<th>序号</th>"+
					 	 	"<th>订单id</th>"+ 
					 	 	"<th>商品id</th>"+
					 	 	"<th>评论内容</th>"+
					 	 	"<th>评论时间</th>"+
					 	 	 
					  "</tr>");
	    		
	    			
		    		$("#body").empty();
		    		if(comm != ""){
		    			var i = 1 ;
		    			$(comm).each(function(){
			    			$("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td><a href = '${pageContext.request.contextPath}/goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+this.goods_id+"</a></td>"+
					     		"<td>"+this.comment_content+"</td>"+
					     		"<td>"+this.comment_time+"</td>"+
					         "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body").append("你还没有评论过哦 !!!"+
		    				"<a href = '${pageContext.request.contextPath}/index.jsp'>去首页逛逛吧</a>"
		    			);
		    		}
		    		
		    		},"json");	
   			
   			});
   			
	    	
	    	
	    	
	    	
        	 //点击显示未评论的订单
   			 $("#btnOrderCustomComment").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findByCustomComment" ,  "ordergoods_customcomment" : "0"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append("<tr>"+ 
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
					 	 	"<th>操作</th>"+
					  "</tr>");
	    		
	    			
		    		$("#body").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='无' src='${pageContext.request.contextPath}/"+this.goods_img+"'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
				    		 	"<td><a href='${pageContext.request.contextPath}/custom/customComment.jsp?order_id="+this.order_id+"&goods_id="+this.goods_id+"'>评论</a></td>"+
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body").append("没有待评价的订单哦 !!!"+
		    				"<a href = '${pageContext.request.contextPath}/index.jsp'>去首页逛逛吧</a>"
		    			);
		    		}
		    		
		    		},"json");	
   			
   			});
   			
     		
     		
     		 //点击显示退货中订单
   			 $("#btnOrderCustomSend").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findByCustomBackCId", "order_CustomBack" : "1"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append("<tr>"  +
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
					 	 	"<th>操作</th>"+
					 "</tr>");
	    		
	    			
		    		$("#body").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href ='${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='无' src='${pageContext.request.contextPath}/"+this.goods_img+"'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
				    		 	"<td><a>联系卖家</a>/"+
				    		 		"<a class = 'backCan'>取消退货</a>"+
				    		 	"</td>"+
				    			 
			    			 "</tr>");
			    			   ++i;
		    			});
		    		}else{
		    			$("#body").append("没有要退货的订单 !!!"+
		    			"<a href = '${pageContext.request.contextPath}/nav/shopCenter.jsp'>去首页逛逛吧</a>"
		    			);
		    		}
		    		
		    		},"json");	
   			
   			});
   			
     		
     		 //点击取消退货
   			$(document).on("click" , ".backCan" ,function(){
   				//获取订单id 以及 商品id 
   				var order_id = $(this).parent().prevAll().eq(8).children().html();
   				var goods_id = $(this).parent().prevAll().eq(7).html();
   				alert(order_id);
   				 //更改退货状态
     			$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "ChangeCustomBack", "order_id" : order_id , "goods_id" : goods_id , "ordergoods_customback" : "0"},function(result){
     				alert(result);
     			 });
     			 
   			});
   			
   			 //点击显示待收货订单
   			 $("#btnOrderGet").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findByCustomGetCId" , "order_customGet" : "0"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append("<tr>"+ 
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
					 	 	"<th>操作</th>"+
					 "</tr>");
	    		
	    			
		    		$("#body").empty();
		    		
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
			    			$("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='无' src='${pageContext.request.contextPath}/"+this.goods_img+"'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
				    		    "<td><button class='get'>确认收货</button>"+
				    		    "<a class='back'>退货</button></a>"+
				    		    "</td>"+
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body").append("没有待收货的订单 !!!"+
		    			"<a href = '${pageContext.request.contextPath}/nav/shopCenter.jsp'>去首页逛逛吧</a>"
		    			);
		    		}
		    		
		    		},"json");	
   			
   			});
   			 
   			 //点击确认收货
   			$(document).on("click" , ".get" ,function(){
   				//获取订单id 以及 商品id 
   				var order_id = $(this).parent().prevAll().eq(8).children().html();
   				var goods_id = $(this).parent().prevAll().eq(7).html();
   				alert(order_id);
   				 //更改收货状态
     			$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "ChangeCustomGet", "order_id" : order_id , "goods_id" : goods_id},function(result){
     				alert(result);
     			 });
     			 
   			});
   			
   			  //点击确认退货
   			$(document).on("click" , ".back" ,function(){
   				//获取订单id 以及 商品id 
   				var order_id = $(this).parent().prevAll().eq(8).children().html();
   				var goods_id = $(this).parent().prevAll().eq(7).html();
   				 //更改收货状态
     			$.post("${pageContext.request.contextPath}/ordergoods.do" , {"method" : "ChangeCustomBack", "order_id" : order_id , "goods_id" : goods_id ,"ordergoods_customback" : "1"},function(result){
     				alert(result);
     			
     			});
     			 
   			});
   			
   			//点击查看待发货的订单
   			$("#btnOrderSellerSend").click(function(custom_id){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"findByShopSendCId" , "order_shopSend" : "0"},function(order){
	    		 //获取到数据之后先清除之前的内容e
	    		 
		    		$("#main").empty();
		    		$("#main").append( "<tr>"+
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
					 	 	"<th>操作</th>"+
				 	"</tr>");
	    		
	    			
		    		$("#body").empty();
		    		if(order != ""){
		    			var i = 1 ;
		    			$(order).each(function(){
		    			
			    			$("#body").append("<tr>"+
				     			"<td>"+i+"</td> "+
					     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
					     		"<td>"+this.goods_id+"</td>"+
					     		"<td>"+this.goods_desception+"</td>"+
					     		"<td><img class='img' alt='无' src='${pageContext.request.contextPath}/"+this.goods_img+"'></td>"+
				    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
				    			"<td>"+this.goods_number+"</td>"+
				    			"<td>"+this.goods_allprice +"元</td>"+ 
				    			"<td>"+this.goods_price +"元</td>"+ 
			    			 	"<td>"+this.shop_name +"</td>"+ 
				    		    "<td><a class='back'>退货</button></a>"+
				    			 
			    			 "</tr>");
			    			   i++;
		    			});
		    		}else{
		    			$("#body").append("没有待发货的订单哦 !!!"+
		    			"<a href = '${pageContext.request.contextPath}/nav/shopCenter.jsp'>去首页逛逛吧</a>"
		    			);
		    		}
		    		
		    		},"json");	
   			
   			});
   			
   		


   			//点击查看所有订单
   			 $("#btnOrder").click(function(custom_id){
   				 AllOrder();
   			 });
   			
   			function AllOrder(){
   				$.post("${pageContext.request.contextPath}/ordergoods.do",{"method":"orderByCustomId"},function(order){
	    		//获取到数据之后先清除之前的内容e
	    		$("#main").empty();
	    		$("#main").append("<tr>"+
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
				"</tr>");
	    	 
	    		$("#body").empty();
	    		if(order != ""){
	    		var i = 1 ; 
	    			$(order).each(function(){
	    			
	    			$("#body").append("<tr>"+
		     				"<td>"+i+"</td> "+
				     		"<td><a href = '${pageContext.request.contextPath}/order.do?method=findByOrderId&order_id="+this.order_id+"'>"+this.order_id+"</a></td>"+
				     		"<td>"+this.goods_id+"</td>"+
				     		"<td>"+this.goods_desception+"</td>"+
				     		"<td><img class='img' alt='无' src='${pageContext.request.contextPath}/"+this.goods_img+"'></td>"+
			    			"<td><p>"+this.ordergoods_payTime+"</p></td>"+
			    			"<td>"+this.goods_number+"</td>"+
			    			"<td>"+this.goods_allprice +"元</td>"+ 
			    			"<td>"+this.goods_price +"元</td>"+ 
		    			 	"<td>"+this.shop_name +"</td>"+ 
	    			 "</tr>");
	    			   i++;
	    			});
	    		
	    		}else{
	    			$("#body").append(
		    			"订单为空呀 !!!"+
			    		"<a href = '${pageContext.request.contextPath}/index.jsp'>去首页逛逛吧</a>"
		    		);
	    		}
	    		
	    		},"json");	
   			}
   				
	    		
   			//更改用户电话号码
	   		$("#btnTel").click(function(){
	   		  mywindow = window.open('${pageContext.request.contextPath}/custom/updateCustomTel.jsp','_self','height=400, width=600, top=100px,left=320px, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes');
	   		 });
   		 	
   		 	//更改用户支付密码
   		 	$("#btnPay").click(function(){
	   		  mywindow = window.open('${pageContext.request.contextPath}/custom/updateCustomPay.jsp','_self','height=400, width=600, top=100px,left=320px, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes');
	   		 });
   		 	
   		 	//注销用户
   		 	$("#btnDel").click(function(){
   		 		var result = confirm("是否确认注销该账号?");
   		 		if(result == true){
   		 			$.post("${pageContext.request.contextPath}/custom.do",{"method":"delCustom"},function(result){
   		 				alert(result);
   		 			});
   		 		}
   		 	});
   		 	
   		 	 
   		 </script>
   		 
   		 
	<script type="text/javascript">
	$("#a").click(function(){
  			  		  name = $("#name").val();
  			  		  select = $("#select option:selected").text();
  				      $("#a").attr("href","${pageContext.request.contextPath}/customFind.jsp?desception="+name+"&selected="+select+"");                
	    		   });
	</script>
	<!-- 编辑用户资料模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
	            </div>
	            <div class="modal-body">
	            	 <form id = "frm" action="${pageContext.request.contextPath}/custom.do" method="post" >
    		 			 <input id = "method" name="method" value = "customUpdate" type= "hidden"> 
					      1. 用户名 :<input id="custom_name" name = "custom_name" value="${customer.custom_name}"><span id="nameError"></span><br>
					      2. 性别：  <input id="sex" name = "sex" value="${customer.custom_sex}" ><span id="sexError"></span><br>
					      3.年龄 : <input id="age" type="number" name="age" max="130" min="18" value="${customer.custom_age}" ><span id="ageError"></span><br>
		        		   旧收货地址<input  value="${customer.custom_address}" readonly> <br>
			              <input  id="address" name = "custom_address" type="hidden">
			     		  5.收货地址 : <select id = "province" name="provice">
		      				<option>请选择省</option>
				      			</select>
				    		<select id = "city" name="city">
						    		<option>请选择市</option>
					    	</select>
					    	<Select id = "area" name="area">
					    		<option>请选择区</option>
					    	</Select>   
					    	<input id="street" name="street" placeholder = "请输入具体街道">  <br> 
			       			6.电子邮箱：<input id="email" type="email" name="email" value="${customer.custom_email}"><span id="emailError"></span><br>
			    
			       	验证码	<input id="vali" name = "imageCode" style = "height:30px;">
			       <img id="imageCode" title="看不清换一张" style="height: 30px;vertical-align: middle;cursor: pointer;" width="200" height="30" 
			       src="${pageContext.request.contextPath}/vali.do?method=imageValidation"><br>
    			<br>
		  </form>
         
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="button" id="btnUpdate" class="btn btn-primary">提交更改</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	
	<!-- 支付模态框 -->
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel4" aria-hidden="true">
					    <div class="modal-dialog">
					        <div class="modal-content">
					            <div class="modal-header">
					                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					                <h4 class="modal-title" id="myModalLabel">支付</h4>
					            </div>
					            <div class="modal-body">
					            	 <iframe id="frm" name="frm" src="${pageContext.request.contextPath}/paydemo.html" width="100%" height="500px">
    	
   									 </iframe>
					            </div>
					            
					            <div class="modal-footer">
					                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					                <button id="submit" type="button" class="btn btn-primary">提交更改</button>
					            </div>
					        </div><!-- /.modal-content -->
					    </div><!-- /.modal-dialog -->
					</div>
	
		
	<!-- 修改支付密码模态框（Modal） -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" id="myModalLabel">修改支付密码信息</h4>
	            </div>
	            <div class="modal-body">
	            	<form id="frm1" action="${pageContext.request.contextPath}/custom.do" method="post">
  						<input name="method" value="customUpdatePay" type="hidden">
  						<table  class="table table-hover">
  							<tr>
  							<td>原支付密码:</td>
  							<td><input name="oldPwd" value="${customer.custom_paypwd}" readonly></td>
  							</tr>
  							<tr>
  							<td> 修改后支付密码:</td>
  							<td><input type="password" name="pwd" id="pwd"></td>
  							</tr>
  							<tr>
  							<td> 再次输入支付密码:</td>
  							<td><input type="password" name="pwd2" id="pwd2"><span style="color:red" id="pwdError"></span></td>
  							</tr>
  							<tr>
  							<td>  邮箱:</td>
  							<td><input id ="inbox" name = "inbox" value="${customer.custom_email}" readonly><div style="color:red" id = "text"></div></td>
  							</tr>
  							<tr>
  							<td>验证码</td>
  							<td><input name="validation" id = "validation1" placeholder="验证码区分大小写"><span style="color:red" id="text1">${valiMsg}</span><br><button type="button" id="btnSendVali">发送验证码</button> </td>
  							</tr>
  							
  						</table>
  					 </form>
	            </div>   
	            <div class="modal-footer">
	                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button id="btnUpdatePay" type="button" class="btn btn-primary">提交更改</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
	</div>
	
		
	
	<!-- 修改电话号码模态框（Modal） -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">修改电话</h4>
	            </div>
	            <div class="modal-body">
	            <form id="frm2" action="${pageContext.request.contextPath}/custom.do" method="post">
	            <input name="method" value="customUpdateTel" type="hidden">
	            	<table  class="table table-hover">
  							<tr>
  							<td>原电话号码:</td>
  							<td><input  name="oldTel" value="${customer.custom_tel}" readonly></td>
  							</tr>
  							<tr>
  							<td>修改后电话号码:</td>
  							<td><input name="tel" ></td>
  							</tr>
  							
  							<tr>
  							<td>  邮箱:</td>
  							<td><input id ="inbox1" name = "inbox" value="${customer.custom_email}" readonly><div style="color:red" id = "text2"></div></td>
  							</tr>
  							<tr>
  							<td>验证码</td>
  							<td><input name="validation" id = "validation" placeholder="验证码区分大小写"><span style="color:red" id="text3">${valiMsg}</span><br><button type="button" id="btnSendVali1">发送验证码</button> </td>
  							</tr>
  							
  						</table>
  					</form>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="button" id="btnUpdateTel" class="btn btn-primary">提交更改</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	
	

	<!-- 修改头像模态框（Modal） -->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">上传头像</h4>
	            </div>
	            <div class="modal-body">
	          	  <img src="${pageContext.request.contextPath}${customer.custom_img}" class="img-circle" style="width: 60px;height: 60px;"/><br>
			            	<br>
	            	 <form id="frm3" action="${pageContext.request.contextPath }/custom.do?method=uploadCustomImg" method="post" enctype="multipart/form-data">
    					<input name="file" type="file">
    					
    				</form>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="button" id="btnUpload" class="btn btn-primary">提交更改</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	<script type="text/javascript">
	$("#btnUpload").click(function(){
	
	 frm3.submit();
	});
	
	
	/*邮箱验证*/
        var t ;
   		var time = 60 ;
   		 
   		$("#btnSendVali1").click(function(){
   			$(this).hide();
   			//$(this).attr("disabled","disabled");
   			t = window.setInterval(function(){
   				$("#text2").text(--time+"秒后可点击再次发送");
   				if(time == 0){
   					window.clearInterval(t);
   					time = 60 ;
   					$("#btn").show();
   					//$("#btn").removeAttr("disabled");
   					$("#text2").text("");
   				}
   			}, 1000);
   			$.post("${pageContext.request.contextPath}/vali.do?method=mailValidation",{"inbox":jQuery("#inbox1").val()},function(result){
   				alert(result);
   			 });
   		});
        /*邮箱验证结束*/
        
         
        //提交表单
        $("#btnUpdateTel").click(function(){
             if(confirm("是否提交?")){
             frm2.submit();
             }
          });
	
	
	
	</script>
	<script type="text/javascript">
	/**
		修改支付密码
	*/
	//验证密码
        $(document).on("blur","#pwd2",function(){
         
        	if($("#pwd2").val() == $("#pwd").val()){
        		$("#pwdError").html("");
        	}else{
        		$("#pwdError").html("两次密码不一致");
        	}
        });	
        	 
        /*邮箱验证*/
        var t ;
   		var time = 60 ;
   		 
   		$("#btnSendVali").click(function(){
   			$(this).hide();
   			//$(this).attr("disabled","disabled");
   			t = window.setInterval(function(){
   				$("#text").text(--time+"秒后可点击再次发送");
   				if(time == 0){
   					window.clearInterval(t);
   					time = 60 ;
   					$("#btnSendVali").show();
   					//$("#btn").removeAttr("disabled");
   					$("#text").text("");
   				}
   			}, 1000);
   			$.post("${pageContext.request.contextPath}/vali.do?method=mailValidation",{"inbox":jQuery("#inbox").val()},function(result){
   				alert(result);
   			 });
   		});
        /*邮箱验证结束*/
        
         
        //提交表单
        $("#btnUpdatePay").click(function(){
        	if(confirm("确定修改吗")){
             frm1.submit();
             }
          });
          
	</script>
	<script type="text/javascript">
	  /**
	  	编辑用户资料
	  */
           
    			var nameRegs=/^.{3,16}$/;
				var passwordRegs=/^[a-zA-Z]\\w{5,17}$/;
				var ageRegs=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
				var emailRegs=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
				 
				 
				 //查看是否有重名
				var nameFlag = true ;
				 $(document).on("blur","#custom_name",function(){
				 	var  name = $("#custom_name").val() ;
				 	//如果通过正则验证
				 	
				if(nameRegs.test( name) ){
				   $.post("${pageContext.request.contextPath}/custom.do",{"method":"findCustomByNa","name":name},function(result){
    				 		 if(result == "同名"){
    				 		 nameFlag = false ;
    				 			$("#nameError").html("存在同名用户");
    				 		}else{
    				 			 
		                        $("#nameError").html("");
    				 		}
    				  });
	    		 }else{
					  $("#nameError").html("用户名格式错误"); 
				}
		    });
				   
				//密码正则验证
				var pwdFlag = true ;
				 $(document).on("blur","#password",function(){
						if(passwordRegs.test( $("#password").val() ) ){
						       
						       $("#pwdError").html("");  
						}else{
						pwdFlag = false ;
							  $("#pwdError").html("密码格式错误"); 
						}
				});
				
				//年龄正则验证
				var ageFlag = true ;
				 $(document).on("blur","#age",function(){
					if(ageRegs.test( $("#age").val() ) ){
					       ageFlag = true ;
					       $("#ageError").html("");  
					}else{
					ageFlag = false;
						  $("#ageError").html("年龄不符合"); 
					}
				});
				
				 
				
				//邮箱验证
				var emailFlag = true ;
				 $(document).on("blur","#email",function(){
					if(emailRegs.test( $("#email").val() ) ){
					     
					       $("#emailError").html("");  
					}else{
					  emailFlag = false ;
						  $("#emailError").html("邮箱格式不正确"); 
					}
				});
				 
				  $("#btnUpdate").click(function(){
                      //获取新地址
    					var province = $("#province option:selected").text() ;
    					var city = $("#city option:selected").text() ;
    					var area = $("#area option:selected").text();
    					var street = $("#street").val();
    					 $("#province").attr("value" , province); 
    					  $("#city").attr("value" , city); 
    					  $("#area").attr("value" , area); 
    					  //说明用户地址没有更改
    					  if($("#province").attr("value") == "请选择省"){
    					         $("#address").val("${customer.custom_address}");
    					  }else{
    					  	var add = province+"-"+city+"-" + area+"-"+street;
    					    $("#address").val(add);
    					  }
    					 
    					  if(nameFlag&&pwdFlag&&ageFlag&&emailFlag){
    					  		if(confirm("确定吗")){
    					  		frm.submit();
    					  		}
    					  };
                    });    
         
              /*图片验证码*/
    			$("#imageCode").click(function(){
	   		 		$(this).attr("src","${pageContext.request.contextPath}/vali.do?method=imageValidation&t="+new Date());   		
	   			});
    			
    		  /*地址三级联动开始*/
    			$.post("${pageContext.request.contextPath}/xml/city.xml",function(data){
    				$("#province").empty();
    				$(data).find("province").each(function(){
    					var province = $(this).attr("name");
    					$("#province").append("<option>"+province+"</option>");
    				 });
    			},"xml");
    			
    			$("#province").change(function(){
    				$("#city").empty();
    				$.post("${pageContext.request.contextPath}/xml/city.xml",function(data){
    					var province = $("#province").val();
    					$(data).find("province[name="+province+"]").find("city").each(function(){
    						var city = $(this).attr("name");
    						$("#city").append("<option>"+city+"</option>");
    					 });
    					 changeArea();
    				},"xml");
    			});
    			
    			$("#city").change(function(){
    				changeArea();
    			}) ;
    			
    			function changeArea(){
    				$("#area").empty();
    				$.post("${pageContext.request.contextPath}/xml/city.xml",function(data){
    					var province = $("#province").val();
    					var city = $("#city").val();
    					$(data).find("province[name="+province+"]").find("city[name="+city+"]").find("area").each(function(){
    						var area = $(this).attr("name");
    						$("#area").append("<option>"+area+"</option>");
    					
    					});
    				},"xml");
    			}
    			/*三级联动结束*/
    			
    		 
    		</script>				
	</body>
</html>
