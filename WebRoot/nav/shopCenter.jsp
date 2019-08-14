<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>购物商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dengluqian.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>

  </head>
  
  <body>
   		<nav class="navbar navbar-default navbar-fixed-top " role="navigation">
    <div class="container-fluid d1 bg-danger">
    <div>
    <% if(request.getSession().getAttribute("customer")==null && request.getSession().getAttribute("seller")==null){ %>
        <ul class="nav navbar-nav ">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    亲,请先登录<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath }/nav/Login.jsp">买家登录</a></li>
                    <li><a href="${pageContext.request.contextPath }/nav/Login.jsp">卖家登录</a></li>
                </ul>
            </li>
            <li><a href="${pageContext.request.contextPath }/nav/Reg.jsp">免费注册</a></li>
            <li><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">购物商城首页</a></li>
        </ul>
        <%}else{ %>
         <ul class="nav navbar-nav" >
             <% if(request.getSession().getAttribute("customer")!=null && request.getSession().getAttribute("seller")==null){ %>
            <li><a href="${pageContext.request.contextPath }/custom/customCenter.jsp"> ${customer.custom_name} ID:${customer.custom_id }</a></li>
             <%}else if(request.getSession().getAttribute("customer")==null && request.getSession().getAttribute("seller")!=null){ %>
              <li><a href="${pageContext.request.contextPath }/seller/sellerCenter.jsp"> ${seller.seller_name} ID:${seller.seller_id }</a></li>
              <%}else{ %>
               <li><a href="${pageContext.request.contextPath }/nav/Login.jsp">用户名</a></li>
               <%} %>
            <li><a href="${pageContext.request.contextPath}/nav/Login.jsp">退出</a></li>
            <li><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">购物商城首页</a></li>
        </ul>
        <%} %>
    </div>
    <div id="d2">
    	<ul class="nav navbar-nav ">
    		<li><img src="${pageContext.request.contextPath }/images/1.png"/></li>
    	</ul>
    </div>
    <div id="d3">
    	<ul class="nav navbar-nav">
    		 <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    商品分类<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a class = "type" href="#">底妆</a></li>
                    <li><a class = "type" href="#">唇部</a></li>
                    <li><a class = "type" href="#">眼部</a></li>
                    <li><a class = "type" href="#">修容</a></li>
                    <li><a class = "type" href="#">眉毛</a></li>
                    <li><a class = "type" href="#">护肤</a></li>
                </ul>
            </li>
         <% if(request.getSession().getAttribute("customer")!=null && request.getSession().getAttribute("seller")==null){ %>
             <li> 
        <a href="${pageContext.request.contextPath }/custom/carShow.jsp">
          <span class="glyphicon glyphicon-shopping-cart"></span>购物车
        </a>
             </li>
        	 <%}else if(request.getSession().getAttribute("customer")==null && request.getSession().getAttribute("seller")!=null){ %> 
        	 <li></li>
        	 <%}else{ %>
        	 <li>
        <a href="${pageContext.request.contextPath }/nav/Login.jsp">
          <span class="glyphicon glyphicon-shopping-cart"></span>购物车
        </a>  
        </li>
        	 <%} %> 
             <% if(request.getSession().getAttribute("customer")!=null && request.getSession().getAttribute("seller")==null){ %>
             <li><a href="${pageContext.request.contextPath }/custom/customCenter.jsp">用户中心</a></li>
             <%}else if(request.getSession().getAttribute("customer")==null && request.getSession().getAttribute("seller")!=null){ %>
           	 <li><a href="${pageContext.request.contextPath }/seller/sellerCenter.jsp">用户中心</a></li>
           	 <%}else{ %>
           	 <li><a href="${pageContext.request.contextPath}/nav/Login.jsp">用户中心</a></li>
           	 <%} %>
             </li>
    	</ul>
    </div>
    </div>
</nav>	
<div id="background">
<div class="middle_right">
   			 <div id="lunbobox">
        		<div id="toleft">&lt;</div>
                <div class="lunbo">
                    <a href="#"><img src="${pageContext.request.contextPath }/images/P1.jpg"></a>
                    <a href="#"><img src="${pageContext.request.contextPath }/images/p6.jpg"></a>
                    <a href="#"><img src="${pageContext.request.contextPath }/images/P3.jpg"></a>
                    <a href="#"><img src="${pageContext.request.contextPath }/images/p4.jpg"></a>
                    <a href="#"><img src="${pageContext.request.contextPath }/images/p5.jpg"></a>
                </div>
                <div id="toright">&gt;</div>
                <ul>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
                <span></span>
        	</div>
        </div>
         
        <!--输入框组-->
			<div id="input" class="input-group ">
				 <select id = "select">
  				<option>宝贝</option>
  				<option>店铺</option>
  				</select>
		        <input id="name" name="name" type="text" class="form-control" placeholder="每天都要买买买！" style="border-color: pink;">
		        <span class="input-group-addon" style="background-color: pink;">
		        	<a id="a" href="${pageContext.request.contextPath}/selectGoods.jsp" >搜索</a>
		        </span>
		    </div>
		  </div>
		    <div id="show">
		    	
		    
		    <!--产品类型展示-->
		    <div id="hover">
		    	<ul>
		    		
		    		<li>
		    			<a class = "type" href="#">底妆</a><span>&gt;</span>
			    		<ul>
			    			<li>
			    				<a class = "type" href="#">粉底</a><span>/</span>
				    			<a class = "type" href="#">遮瑕</a><span>/</span>
				    			<a class = "type"  href="#">隔离</a>
			    			</li>
			    		</ul>
		    		</li>
		    		
		    		<li>
		    			<a class = "type" href="#">唇部</a><span>&gt;</span>
		    			<ul>
			    			<li>
			    				<a class = "type" href="#">口红</a><span>/</span>
			    				<a class = "type" href="#">唇釉</a><span>/</span>
			    			    <a class = "type" href="#">唇部护理</a>
			    			</li>
		    			</ul>
		    		</li> 
		    		
		    		<li>
		    			<a class = "type" href="#">眼部</a><span>&gt;</span>
		    			<ul>
			    			<li>
			    				<a class = "type" href="#">眼影</a><span>/</span>
				    			<a class = "type" href="#">眼线</a><span>/</span>
				    			<a class = "type" href="#">睫毛</a>
			    			</li>
		    			</ul>
		    		</li>
		    		
		    		<li>
		    			<a class = "type" href="#">修容</a><span>&gt;</span>
		    			<ul>
			    			<li>
			    				<a class = "type" href="#">高光</a><span>/</span>
			    				<a class = "type" href="#">阴影</a><span>/</span>
			    				<a class = "type" href="#">修容盘</a>
			    				
			    			</li>
		    			</ul>
		    		</li>
		    		
		    		<li>
		    			<a class = "type" href="#">眉毛</a><span>&gt;</span>
		    			<ul>
			    			<li>
			    				<a class = "type" href="#">眉笔</a><span>/</span>
				    			<a class = "type" href="#">染眉膏</a><span>/</span>
				    			<a class = "type" href="#">眉粉</a>
			    			</li>
		    			</ul>
		    		</li>
		    		
		    		<li>
		    			<a class = "type" href="#">护肤类</a><span>&gt;</span>
		    			<ul>
		    				<li>
		    					<a class = "type" href="#">水乳</a><span>/</span>
				    			<a class = "type" href="#">精华</a><span>/</span>
				    			<a class = "type" href="#">眼霜</a><span>/</span>
				    			<a class = "type" href="#">面霜</a>
		    				</li>
		    			</ul>
		    		</li>
		    		
		    			
		    		
		    	</ul>
		    	
		    </div>
		    <div id="myCarousel" class="carousel slide">
			    <!-- 轮播（Carousel）指标 -->
			    <ol class="carousel-indicators">
			        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			        <li data-target="#myCarousel" data-slide-to="1"></li>
			        <li data-target="#myCarousel" data-slide-to="2"></li>
			    </ol>   
			    <!-- 轮播（Carousel）项目 -->
			    <div class="carousel-inner">
			        <div class="item active">
			            <img src="${pageContext.request.contextPath }/images/show1.jpg" alt="First slide">
			        </div>
			        <div class="item">
			            <img src="${pageContext.request.contextPath }/images/show2.jpg" alt="Second slide">
			        </div>
			        <div class="item">
			            <img src="${pageContext.request.contextPath }/images/show3.jpg" alt="Third slide">
			        </div>
			        <div class="item">
			            <img src="${pageContext.request.contextPath }/images/show4.jpg" alt="Four slide">
			        </div>
			    </div>
			    <!-- 轮播（Carousel）导航 -->
			    <a class="carousel-control left" href="#myCarousel" 
			       data-slide="prev"> <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span></a>
			    <a class="carousel-control right" href="#myCarousel" 
			       data-slide="next"><span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
    
		</div>
		
		

	  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
	   	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript">
	    	
	    	//根据商品类型搜索
	    	$(document).on("click" , ".type" , function(){
	    		var typename = $(this).html();
	    	 	//修改跳转的页面以及传递的参数
	    		$(this).attr("href" , "${pageContext.request.contextPath}/selectGoods.jsp?desception="+typename+"&selected=商品类型");
	    	});
	    
	    
	    
  			  $("#a").click(function(){
  			  		  name = $("#name").val();
  			  		  select = $("#select option:selected").text();
  				      $("#a").attr("href","${pageContext.request.contextPath}/selectGoods.jsp?desception="+name+"&selected="+select+"");                
	    		   });
	    	$("#myCarousel").carousel({//自动轮播
			    interval: 3000
			});
	    	
						///轮播
			$(function() {
			    //$("#toright").hide();
			    //$("#toleft").hide();
			    $('#toright').hover(function() {
			        $("#toleft").hide();
			    }, function() {
			        $("#toleft").show();
			    });
			    $('#toleft').hover(function() {
			        $("#toright").hide();
			    }, function() {
			        $("#toright").show();
			    });
			});
			
			var t;
			var index = 0;
			/////自动播放
			t = setInterval(play, 3000);
			
			function play() {
			    index++;
			    if (index > 4) {
			        index = 0;
			    }
			    // console.log(index)
			    $("#lunbobox ul li").eq(index).css({
			        "background": "#999",
			        "border": "1px solid #ffffff"
			    }).siblings().css({
			        "background": "#cccccc",
			        "border": ""
			    });
			
			    $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000);
			};
			
			///点击鼠标 图片切换
			$("#lunbobox ul li").click(function() {
			
			    //添加 移除样式
			    //$(this).addClass("lito").siblings().removeClass("lito"); //给当前鼠标移动到的li增加样式 且其余兄弟元素移除样式   可以在样式中 用hover 来对li 实现
			    $(this).css({
			        "background": "#999",
			        "border": "1px solid #ffffff"
			    }).siblings().css({
			        "background": "#cccccc"
			    });
			    var index = $(this).index(); //获取索引 图片索引与按钮的索引是一一对应的
			    // console.log(index);
			
			    $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000); // siblings  找到 兄弟节点(不包括自己）
			});
			
			/////////////上一张、下一张切换
			$("#toleft").click(function() {
			    index--;
			    if (index <= 0) //判断index<0的情况为：开始点击#toright  index=0时  再点击 #toleft 为负数了 会出错
			    {
			        index = 4;
			    }
			    console.log(index);
			    $("#lunbobox ul li").eq(index).css({
			        "background": "#999",
			        "border": "1px solid #ffffff"
			    }).siblings().css({
			        "background": "#cccccc"
			    });
			
			    $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000); // siblings  找到 兄弟节点(不包括自己）必须要写
			}); // $("#imgbox a ")获取到的是一个数组集合 。所以可以用index来控制切换
			
			$("#toright").click(function() {
			    index++;
			    if (index > 4) {
			        index = 0;
			    }
			    console.log(index);
			    $(this).css({
			        "opacity": "0.5"
			    });
			    $("#lunbobox ul li").eq(index).css({
			        "background": "#999",
			        "border": "1px solid #ffffff"
			    }).siblings().css({
			        "background": "#cccccc"
			    });
			    $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000); // siblings  找到 兄弟节点(不包括自己）
			});
			$("#toleft,#toright").hover(function() {
			        $(this).css({
			            "color": "black"
			        });
			    },
			    function() {
			        $(this).css({
			            "opacity": "0.3",
			            "color": ""
			        });
			    });
			///
			
			///////鼠标移进  移出
			$("#lunbobox ul li,.lunbo a img,#toright,#toleft ").hover(
			    ////////鼠标移进
			    function() {
			        $('#toright,#toleft').show();
			        clearInterval(t);
			
			    },
			    ///////鼠标移开
			    function() {
			        //$('#toright,#toleft').hide()
			        //alert('aaa')
			        t = setInterval(play, 3000);
			
			        function play() {
			            index++;
			            if (index > 4) {
			                index = 0;
			            }
			            $("#lunbobox ul li").eq(index).css({
			                "background": "#999",
			                "border": "1px solid #ffffff"
			            }).siblings().css({
			                "background": "#cccccc"
			            });
			            $(".lunbo a ").eq(index).fadeIn(1000).siblings().fadeOut(1000);
			        }
			    });
		
		
		
		
		</script>
		
  </body>
  
</html>
