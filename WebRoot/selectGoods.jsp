<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>宝贝搜索</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pagination.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/selectGoods.css" />
   <style>
   	.img{
   		width:280px; 
   		height:350px
   	}
   	.describe{
   		font-size: 18px;
   	}
   	.img1{
   		width:300px; 
   		height:200px
   	}
   	.shopname{
   		font-size: 20px;
   	}
   	.seller{
   	font-size: 18px;
   	}
   </style>
  </head>
 
  <body>
   <!-- 导航栏-->
	
		
		 <div class="head">
		 	<nav class="navbar navbar-default" role="navigation">
	    				
				    <div>
				        <ul class="nav navbar-nav">
				        	<li><a href="${pageContext.request.contextPath}/nav/shopCenter.jsp">首页</a></li>
				            <% if (request.getSession().getAttribute("customer")==null && request.getSession().getAttribute("seller")==null){ %>
				            <li><a href="#">亲,请登录</a></li>
				            <%}else if(request.getSession().getAttribute("customer") !=null && request.getSession().getAttribute("seller")==null){ %>
				            <li><a href="${pageContext.request.contextPath}/custom/customCenter.jsp">${customer.custom_name }</a></li>
				            <li><a href="${pageContext.request.contextPath}/custom/customCenter.jsp">我的主页</a></li>
				            <%}else if(request.getSession().getAttribute("customer")==null&& request.getSession().getAttribute("seller")!=null){ %>
				            <li><a href="${pageContext.request.contextPath}/seller/sellerCenter.jsp" >${seller.seller_name}</a></li>
				            <li><a href="${pageContext.request.contextPath}/seller/sellerCenter.jsp">我的主页</a></li>
				            <%} %>
				            <li><a href="${pageContext.request.contextPath}/nav/Reg.jsp">免费注册</a></li>
				            	           
				        </ul>
				    </div>
			
		</nav>
    	<form action="#"  method="post" >
    		<img src="images/1.png">
    		<select name="choice" id="choice" style="color:gray;"  >
    			<option selected>宝贝</option>
    			<option>店铺</option>
    		</select>
	    	<input type="text" id="searchbaby"  name="searchbaby" value=" ">
	    	<button id="btn">搜索</button>
    	</form>
    </div>
	
	
	<div class="word">所有宝贝</div>	
	
	<hr style="height:3px;border:none;background-color:white;" />
	
	
	
	<div class="adv"></div>
	
	
	
	<div class="nav">
			<nav class="navbar navbar-default" role="navigation">
		    <div class="container-fluid    bg-danger "> 
		    <div class="navbar-header">
		        <button type="button" class="navbar-toggle" data-toggle="collapse"
		                data-target="#example-navbar-collapse">
		            <span class="sr-only">切换导航</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		        </button>
		       
		    </div>
		    <div class="collapse navbar-collapse" id="example-navbar-collapse">
		        <ul class="nav navbar-nav  navbar-right">
		            <li class="active"><a href="#">综合排名</a></li>
		             <li><a href="#">销量</a></li>
		            <li><a href="#">信用</a></li>
		            <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                   	 价格 <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">价格从高到低</a></li>
		                    <li><a href="#">价格从低到高</a></li>
		                    	<li class="divider"></li>
		                    <li><a href="#">总价从高到低</a></li>
		                   
		                    <li><a href="#">总价从低到高</a></li> 
		                </ul>
		            </li>
		        </ul>
		    </div>
		    </div>
		</nav>
	</div>	
			
	 
    
     <div class="goods"  id="goods">
	
	 </div>    	
	 <div class="shops" id="shops">
	 
	 </div>	
	 
	 
	 
	 <div class="clearfix"></div>	
	
	
		<div align="center" id="Pagination"></div>
			
	
	
	 <div class="clearfix"></div>	
	
	
	
	
	<div id="footer">
			<hr/>
			<ul id="foot1">
				<li>阿里巴巴集团</li>
				<li>|</li>
				<li>阿里巴巴国际站</li>
				<li>|</li>
				<li>阿里巴巴中国站</li>
				<li>|</li>
				<li>淘宝网</li>
				<li>|</li>
				<li>天猫</li>
				<li>|</li>
				<li>一淘</li>
				<li>|</li>
				<li>支付宝</li>
				<li>|</li>
				<li>聚划算</li>
				<li>|</li>
				<li>京东</li>
			</ul>
			
		<ul id="foot2">
			<li>关于淘宝</li>
			<li>|</li>
			<li>合作伙伴</li>
			<li>|</li>
			<li>营销中心</li>
			<li>|</li>
			<li>联系客服</li>
			<li>|</li>
			<li>联系我们</li>
			<li>|</li>
			<li>法律声明及隐私政策</li>
			
		</ul>
	</div>
	
	
	
	
	
	
		
		
		
		
		
	<script type="text/javascript" src="js/jquery.min.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
	<script type="text/javascript">
		//定义一页显示多少个
   		var pageSize = 12;
   	 	var desception = "${param.desception}" ;
   	 	var selected = "${param.selected}" ;
   	  
   	 	if(selected == "宝贝"){
   	 	//选择根据宝贝搜索
   	 		getData();
   	 	}else if(selected == "店铺"){
   	 		//如果选择根据店铺搜索
   	 		$("#head").empty();
   	 		$("#head").append("<td>店铺id</td><td>店铺名称</td><td>店铺图片</td><td>发货地址</td>");
   	 		getDataShop();
   	 	}else if(selected == "商品类型"){
   	 		getDataType2();
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
			   		 	$("#goods").empty();
		    		   	//获取到数据之后先清除之前的内容
				   		$("#shops").empty();
				   		if(list !=""){
				   		$(list).each(function(){
				   			  $("#shops").append(
				   			  "<div class='col-md-4 col-xs-6 text-left'>"+
				   			  	"<div class='frame1'>"+
				   			  	"<a href='${pageContext.request.contextPath}/shop.do?method=findShopById&shop_id="+this.shop_id+"'>"+
				   			  	"<img title='"+this.shop_name+"' alt='图片不见啦!' class='img1' src='${pageContext.request.contextPath}/"+this.shop_img+"'></a>"+
				   			  	"<br><a href='${pageContext.request.contextPath}/shop.do?method=findShopById&shop_id="+this.shop_id+"'>"+
				   			  	"<span class='shopname' name='shopname ' >"+this.shop_name+"</span></a>"+
				   			  	"<br> 卖家: <a href='#'><span class='seller' name='seller '  >"+this.seller_name+"</span>"+
				   			  	"<img src='images/wangwang.png'></a>"+
				   			  	"&nbsp;&nbsp;&nbsp;<span id='address'  name='address'   >"+this.shop_address+" </span><br>"+
				   			  	"主营:化妆品"+
				   			  	"</div></div>"
				   			  
				   			  );
		   		        });
	    		  }else{
	    		  $("#goods").append("<h1 align='center'>亲,没有你要找的店铺"+
		    				"<a href = '${pageContext.request.contextPath}/nav/shopCenter.jsp'>去首页逛逛吧</a></h1>");
	    		  
	    		  }
		   			
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
		   		 		$("#shops").empty();
	    		   	//获取到数据之后先清除之前的内容
			   		   $("#goods").empty();
			   		  var i=0;
			   		  if(list !=""){
				   		$(list).each(function(){
				   		
				   			$("#goods").append(
				   			"<div class='col-md-4 col-xs-6 text-left'>"+
				   				"<div class='frame'>"+
				   					"<a href='${pageContext.request.contextPath}/goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+
				   						"<img title='"+this.goods_Desception+"' alt='图片不见啦!' class='img' src='${pageContext.request.contextPath}/"+this.goods_Img+"'></a><br>"+
				   						"￥<span class='price' name='price'>"+this.goods_OutputPrice+"</span>"+
				   						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				   						"<span class='sellcount' name='sellcount'>"+this.goods_SellCount+"人付款</span><br>"+
				   						"<a href='${pageContext.request.contextPath}/goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+
				   						"<span class='describe' name='descibe'>"+this.goods_Desception+"</span></a><br>"+
				   						"店铺:<a href='${pageContext.request.contextPath}/shop.do?method=findShopById&shop_id="+this.shop_id+"'>"+
				   						"<span class='shopname' name='shopname' >"+this.shop_name+"</span></a>"+
				   						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				   						"<br><span class='adress' name='adress'>"+this.shop_address+"</span>"+
				   				"</div>"+
				   			"</div> "
				   				);
				   			
				   				
			   		});
			   		}else{
			   			$("#goods").append("<h1 align='center'>亲,没有你要的商品"+
		    				"<a href = '${pageContext.request.contextPath}/nav/shopCenter.jsp'>去首页逛逛吧</a></h1>");
			   		}
	    		   
		   	 	},"json");
		  	}
		  	//调用函数显示第一页的数据
		  	PageCallback(0);
      }
   		  	
   	/*根据 商品类型名 搜索 ， 进行分页查询*/
 	 	function getDataType2(){
		 	 	//查询总行数
		 		$.post("${pageContext.request.contextPath}/goodstype.do",{"method":"pageCountSelect","goodsType_name":desception},function(rowCount){
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
		   	$.post("${pageContext.request.contextPath}/goodstype.do",{"method":"AjaxfindGoodsByTypeName","currentPage":pageIndex,"pageSize":pageSize,"goodsType_name":desception},function(list){
		   		 
	    		    $("#shops").empty();
	    		   	//获取到数据之后先清除之前的内容
			   		   $("#goods").empty();
			   		  var i=0;
			   		  if(list !=""){
				   		$(list).each(function(){
				   		 
				   			$("#goods").append(
				   			"<div class='col-md-4 col-xs-6 text-left'>"+
				   				"<div class='frame'>"+
				   					"<a href='${pageContext.request.contextPath}/goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+
				   						"<img title='"+this.goods_Desception+"' alt='图片不见啦!' class='img' src='${pageContext.request.contextPath}/"+this.goods_Img+"'></a><br>"+
				   						"￥<span class='price' name='price'>"+this.goods_OutputPrice+"</span>"+
				   						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				   						"<span class='sellcount' name='sellcount'>"+this.goods_SellCount+"人付款</span><br>"+
				   						"<a href='${pageContext.request.contextPath}/goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+
				   						"<span class='describe' name='descibe'>"+this.goods_Desception+"</span></a><br>"+
				   						"店铺:<a href='${pageContext.request.contextPath}/shop.do?method=findShopById&shop_id="+this.shop_id+"'>"+
				   						"<span class='shopname' name='shopname' >"+this.shop_name+"</span></a>"+
				   						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				   						"<br><span class='adress' name='adress'>"+this.shop_address+"</span>"+
				   				"</div>"+
				   			"</div> "
				   				);
				   			
				   				
			   		});
			   		}else{
			   			$("#goods").append("<h1 align='center'>亲,没有你要的商品"+
		    				"<a href = '${pageContext.request.contextPath}/nav/shopCenter.jsp'>去首页逛逛吧</a></h1>");
			   		}
			   		
		   	 	},"json");
		  	}
		  	//调用函数显示第一页的数据
		  	PageCallback(0);
      }
   		/*结束根据  商品类型名 搜索 ， 进行分页查询*/  	
   		  	
		
	</script>
	
	
	
	
	

	
	
	
	</body>
  </body>
</html>
