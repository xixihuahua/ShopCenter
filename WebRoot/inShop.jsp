<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>${shop.shop_name}</title>
    
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/inShop.css" />
	<style>	
	.img{
   		width:280px; 
   		height:300px
   	}
   	.describe{
   		font-size: 18px;
   	}
   	</style>
	</head>
	<body>
		<div class="logo">
			<img src="${pageContext.request.contextPath }/images/1.png">
		</div>
		
		
		<div class="shoptitle" >
			<a href="#"><span id="shopname" name="shopname"  > ${shop.shop_name}   </span></a>
			<br>
			 <span id="word">品牌直销售</span>
			 <a href="#"><img src="${pageContext.request.contextPath }/images/wangwang.png"></a>
			
		</div>
		
		
		<div class="search">
    		<form action="#"  method="post" >
	    		<input id="searching"  type="text"  name="searching"  value=" ">
	    		<button id="btn_1">搜索</button>
	    		<button id="btn_2">搜索店内</button>
    		</form>
   	 	</div>
	
		
			
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
		             <span class="icon-bar"></span>
		             <span class="icon-bar"></span>
		             <span class="icon-bar"></span>
		        </button>
		    </div>
		  
		    <div class="collapse navbar-collapse" id="example-navbar-collapse">
		        <ul class="nav navbar-nav  navbar-right">
		            <li ><a href="#">首页</a></li>
		             <li  class="active"><a href="#">所有产品</a></li>
		            <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                   	 底妆 <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">粉底</a></li>
		                    <li><a href="#">遮瑕</a></li>
		                    <li><a href="#">隔离</a></li>
		                   
		                    <li><a href="#">其他</a></li> 
		                </ul>
		            </li>
		              <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                   	 唇部 <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">口红</a></li>
		                    <li><a href="#">唇釉</a></li>
		                    <li><a href="#">唇部护理</a></li>
		                   
		                    <li><a href="#">其他</a></li> 
		                </ul>
		            </li>
		              <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                   	 眼部 <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">眼影</a></li>
		                    <li><a href="#">眼线</a></li>
		                    <li><a href="#">睫毛膏</a></li>
		                   
		                    <li><a href="#">其他</a></li> 
		                </ul>
		            </li>
		            
		            <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                   	 修容 <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">高光</a></li>
		                    <li><a href="#">眼影</a></li>
		                    <li><a href="#">修容盘</a></li>
		                   
		                    <li><a href="#">其他</a></li> 
		                </ul>
		            </li>
		            <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                   	 眉毛 <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">眉笔</a></li>
		                    <li><a href="#">染眉膏</a></li>
		                    <li><a href="#">眉粉</a></li>
		                   
		                    <li><a href="#">其他</a></li> 
		                </ul>
		            </li>
		            
		             <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                   	 护肤 <b class="caret"></b>
		                </a>
		                
		                <ul class="dropdown-menu">
		                    <li><a href="#">水乳</a></li>
		                    <li><a href="#">精华</a></li>
		                    <li><a href="#">眼霜</a></li>
		                     <li><a href="#">面霜</a></li>
		                    <li><a href="#">其他</a></li> 
		                </ul>
		            </li>
		          </ul>  </div></div></nav>
		</div>
	<div class="clearfix"></divs> 	
	

	<div class="rank">
			 <div class="btn-group ">
			 	<a href="#"><button type="button" class="btn btn-default">综合排序</button></a>
					<a href="#"><button type="button" class="btn btn-default">销量</button></a>
				   <a href="#"><button type="button" class="btn btn-default">新品</button></a>
				  <a href="#"><button type="button" class="btn btn-default">价格</button></a>
			</div>
	</div>
	 
	 <div class="goods"  id="goods">
	
	 </div>    	
	    
	
	<div id="Pagination">
		
	</div>		
			
	<diV class="clearfix"></diV> 	
			
			
			
			
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
  	    
	  		<script type="text/javascript">
	  	 //定义一页显示多少个
   		var pageSize = 12;
   		var shop_id = ${shop.shop_id} ;
   		 
   		//查询总行数
   		$.post("goods.do",{"method":"pageCount","shop_id":shop_id},function(rowCount){
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
	    	$.post("goods.do",{"method":"ajaxPage","currentPage":pageIndex,"pageSize":pageSize,"shop_id":shop_id},function(list){
	    		//获取到数据之后先清除之前的内容
	    		//获取到数据之后先清除之前的内容
			   		   $("#goods").empty();
			   		  
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
		    				"<a href = '${pageContext.request.contextPath}/index.jsp'>去首页逛逛吧</a></h1>");
			   		}
	    		   
		   	 	},"json");
		  	}
		  	//调用函数显示第一页的数据
		  	PageCallback(0);
      
    	
   	</script>
	</body>
</html>
