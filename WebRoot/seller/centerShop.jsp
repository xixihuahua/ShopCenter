<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>卖家店铺</title>
    
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/centerShop.css" />
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
		<!-- 导航栏-->
		<nav class="navbar navbar-default" role="navigation">
	    	<div class="container-fluid col-sm-offset-2">			
				    <div>
				        <ul class="nav navbar-nav">
				        	<li><a href="${pageContext.request.contextPath}/nav/shopCenter.jsp">首页</a></li>
				            <li><a href="${pageContext.request.contextPath}/seller/centerShop.jsp" >${shop.shop_name}</a></li>
				            <li><a href="${pageContext.request.contextPath}/nav/Reg.jsp">免费注册</a></li>
				            <li><a href="${pageContext.request.contextPath}/seller/sellerCenter.jsp">我的主页</a></li>	           
				        </ul>
				    </div>
			</div>
		</nav>
		<!-- 店铺头像店铺名 -->
		<div id="message">
			<ul>
				<li><a href = "${pageContext.request.contextPath}/seller/uploadShopImg.jsp">
				<img src="${pageContext.request.contextPath }/${shop.shop_img}" class="img-circle" style="width: 60px;height: 60px;"/></li>
				</a>
				
				
				<li><span id="username">${shop.shop_name}</span></li>
				
			</ul>
				<!-- 按钮组 -->
				<div id="btn">
				<button class="btn btn-primary btn-danger right" data-toggle="modal" data-target="#myModal3">修改头像</button>
						<!-- 模态框（Modal） -->
						<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						    <div class="modal-dialog">
						        <div class="modal-content">
						            <div class="modal-header">
						                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						                <h4 class="modal-title" id="myModalLabel">修改头像</h4>
						            </div>
						            <div class="modal-body">
						            	<img src="${pageContext.request.contextPath}${shop.shop_img}" class="img-circle" style="width: 60px;height: 60px;"/><br>
						            	<br>
						            	
						            	<form id="frm3" action="${pageContext.request.contextPath }/shop.do?method=uploadShopImg" method="post" enctype="multipart/form-data">
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
					
					<!-- action="${pageContext.request.contextPath}/seller/addGoods.jsp?shop_id=${shop.shop_id }" method="post" -->
						<!-- 按钮触发模态框 -->
						<button class="btn btn-primary btn-danger right" data-toggle="modal" data-target="#myModal">添加商品</button>
						<!-- 模态框（Modal） -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						    <div class="modal-dialog">
						        <div class="modal-content">
						            <div class="modal-header">
						            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						            <h4 class="modal-title" id="myModalLabel">添加商品</h4>
						            </div>
							        <div class="modal-body">
							        <form id = "frm" name="frm" action="${pageContext.request.contextPath}/goods.do" method="post">
							        <input  name="method" value = "addGoods" type= "hidden">
							    	<input  name="shop_id" value ="${shop.shop_id}"  type= "hidden">
							    	     商品类型
								    <select id = "first" name="first"></select>
							    	<select id = "second" name="second">
							    	<option>请选择二级类型</option>
							    	</select>
							    	<select id = "third" name="third">
						    		<option>请选择三级类型</option>
						    		</select><span id="typeError"></span> <br>
								        商品库存 <input  id = "r" name= "goods_Repertory" type="number"><span id="rError"></span><br>
								        商品描述  <input id = "d" name="goods_Desception" ><span id = "dError"></span><br>
									商品进价 <input id = "in" name="goods_InputPrice" type="number"><span id="inError"></span><br>
									商品售价<input id = "out" name="goods_OutputPrice" type="number"><span id="outError"></span><br>
									 商品折扣<input id = "count" name="goods_count" type = "number" placeholder="折扣大于0小于1"><span id="countError"></span><br>
									 商品状态<select id = "status" name="goods_status">
									 <option>上架</option>
									 <option>下架</option>
					  			 </select>				 
		 							</form>
		 							 <button type="button" id="btnAdd" class="btn btn-primary">添加商品</button>
						            </div>
						            <div class="modal-footer">
						                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						                
						            </div>
						        </div><!-- /.modal-content -->
						    </div><!-- /.modal -->
						</div>
						
					<!--  <form action="${pageContext.request.contextPath}/seller/updateShop.jsp?shop=${shop}" method="post">-->
						<!--触发模态框-->
					
					<button class="btn btn-primary btn-warning right" data-toggle="modal" data-target="#myModal2">修改店铺信息</button>
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					    <div class="modal-dialog">
					        <div class="modal-content">
					            <div class="modal-header">
					                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					                <h4 class="modal-title" id="myModalLabel">修改店铺信息</h4>
					            </div>
					            <div class="modal-body">
					           		<form id = "frm1" name="frm1" action="${pageContext.request.contextPath}/shop.do" method="post" >
					    		  	<input id = "method" name="method" value = "updateShop" type= "hidden"> 
									<input id="shop_id" name="shop_id" value="${shop.shop_id }" type="hidden">
									         店铺名 :<input id="name" name ="name" value="${shop.shop_name}"><span id="nameError"></span><br>
									         旧仓库地址<input  value="${shop.shop_address}" readonly> <br>
									    <input  id="address" name = "shop_address" type="hidden">
									         仓库地址 : <select id = "province" name="provice">
									      				<option>请选择省</option>
								      			</select>
										    	<select id = "city" name="city">
										    		<option>请选择市</option>
										    	</select>
										    	<Select id = "area" name="area">
										    		<option>请选择区</option>
										    	</Select>   
										    	<input id="street" name="street" placeholder = "请输入具体街道">  <br> 
										验证码	<input id="vali" name = "imageCode" style = "height:30px;">
								       <img id="imageCode" title="看不清换一张" style="height: 30px;vertical-align: middle;cursor: pointer;" width="200" height="30" 
								       src="${pageContext.request.contextPath}/vali.do?method=imageValidation"><br>	    	
		   								</form>
		   								
					            </div>
					            
					            <div class="modal-footer">
					                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					                <button id="btnUpdate" type="button" class="btn btn-primary">提交更改</button>
					            </div>
					        </div><!-- /.modal-content -->
					    </div><!-- /.modal-dialog -->
					
					<!-- /.modal -->
				
					</div>
					
						<button id="new" type="button" class="btn btn-success right">我的店铺</button>
					
					
				</div>
				<!-- 商品表格 -->
				<div id="myshop">
					
					<table class="table">
					  <thead>
					    <tr>
					      <th><div>全选<input type="checkbox" id="selectAll"></div><br>
					      	  <div>反选<input type="checkbox" id="reverseSelect"></div></th>
						       <th>商品id</th>
						      <th>商品名</th>
						      <th>商品图片</th>
						     
						      <th>商品进价</th>
						      <th>商品售价</th>
						      <th>商品折扣</th>
						      <th>商品状态</th>
						      <th>商品销量</th>
						      <th>操作</th>
					      
					      
					    </tr>
					  </thead>
					  <tbody id="main">
					    <tr class="info">
					    	
					    	
					    </tr>
					   
					   
					  </tbody>
					  
					</table>
					<div id="Pagination" >分页显示</div>
					<button id="delete_btn" class="btn btn-danger">删除</button>
					
					
				
						
					
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.pagination.js"></script>
	<script type="text/javascript">
	/*修改头像*/
		$("#btnUpload").click(function(){
		
			frm3.submit();
		});
		
	
	
						//判断是否选择了商品类型
    				 var typeFlag = false ;
    				$(document).on("blur","#first",function(){
    					var first = $("#first option:selected").text() ;
    					 if(first == "请选择一级分类"){
    					 	$("#typeError").html("请选择商品类型");
    					  }else{
    					    typeFlag = true ;
    					    $("#typeError").html("");
    					 }
    				 });
    				 //判断库存
    				 var tFlag = false ;
    			   $(document).on("blur","#r",function(){
    					  if($("#r").val() < 0){
    					 	$("#rError").html("请输入正确库存");
    					  }else if($("#r").val() == "") {
    					    $("#rError").html("请输入库存");
    					  }else {
    					    tFlag = true ;
    					    $("#rError").html("");
    					 }
    				 });
    				 
    				 //判断进价
    				 var inFlag = false ;
    				 $(document).on("blur","#in",function(){
    				 
    					if($("#in").val() < 0){
    					 	$("#inError").html("请输入正确进价");
    					  }else if($("#in").val() == "") {
    					    $("#inError").html("请输入进价");
    					  }else {
    					    inFlag = true ;
    					    $("#inError").html("");
    					 }
    				 });
    				 
    				 //判断售价
    				 var outFlag = false ;
    				 $(document).on("blur","#out",function(){
    				 
    					if($("#out").val() < 0){
    					 	$("#outError").html("请输入正确售价");
    					  }else if($("#out").val() == "") {
    					    $("#outError").html("请输入售价");
    					  }else {
    					    outFlag = true ;
    					    $("#outError").html("");
    					 }
    				 });
    				 
    				 //判断折扣
    				 var countFlag = false ;
    				 $(document).on("blur","#count",function(){
    				 
    					if($("#count").val() < 0){
    					 	$("#countError").html("请输入正确折扣");
    					  }else if($("#count").val() == "") {
    					    $("#countError").html("请输入折扣");
    					  }else {
    					    countFlag = true ;
    					    $("#countError").html("");
    					 }
    				 });
    				 
    				 //判断商品描述,描述不能重名,数据库查询
    				 var dFlag = false ;
    				 $(document).on("blur","#d",function(){
    				    var  desception = $("#d").val() ;
    				    if(desception == ""){
    				    	$("#dError").html("请输入商品描述");
    				    }else{
		    				  $.post("${pageContext.request.contextPath}/goods.do",{"method":"findGoodsByDe","desception":desception},function(result){
		    				 		 if(result == "同名"){
		    				 			$("#dError").html("存在同名描述");
		    				 		}else{
		    				 			dFlag = true ;
		    				 			$("#dError").html("");
		    				 		}
		    				  });
    					}
                   });
    				 
    				 
    				 
    				 //点击提交按钮
    				$("#btnAdd").click(function(){
    					//判断商品是商品状态
    					if($("#status option:selected").text() == "上架"){
    						 $("#status").attr("goods_status","上架");
    					 }else{
    						$("#status").attr("goods_status","下架");
    					}
    					
    					//获取third的值为所选择的商品类型名，方便在controller层，获取商品类型名
    					var first = $("#first option:selected").text() ;
    					var second = $("#second option:selected").text() ;
    					var third = $("#third option:selected").text();
    					  $("#first").attr("value" , first); 
    					  $("#second").attr("value" , second); 
    					  $("#third").attr("value" , third); 
    					if(typeFlag && tFlag && countFlag && dFlag && inFlag && outFlag ){
    					    frm.submit();
    					}
    					 
    					
    				});
    				
    		  /*商品三级联动开始*/
    			$.post("${pageContext.request.contextPath }/xml/goodsType.xml",function(data){
    				$("#first").empty();
    				$(data).find("first").each(function(){
    					var first = $(this).attr("name");
    					$("#first").append("<option>"+first+"</option>");
    				 });
    			},"xml");
    			
    			$("#first").change(function(){
    				$("#second").empty();
    				$.post("${pageContext.request.contextPath }/xml/goodsType.xml",function(data){
    					var first = $("#first").val();
    					$(data).find("first[name="+first+"]").find("second").each(function(){
    						var second = $(this).attr("name");
    						$("#second").append("<option>"+second+"</option>");
    					 });
    					 changethird();
    				},"xml");
    			});
    			
    			$("#second").change(function(){
    				changethird();
    			}) ;
    			
    			function changethird(){
    				$("#third").empty();
    				$.post("${pageContext.request.contextPath }/xml/goodsType.xml",function(data){
    					var first = $("#first").val();
    					var second = $("#second").val();
    					$(data).find("first[name="+first+"]").find("second[name="+second+"]").find("third").each(function(){
    						var third = $(this).attr("name");
    						$("#third").append("<option>"+third+"</option>");
    					
    					});
    				},"xml");
    			}
    			/*三级联动结束*/
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.pagination.js"></script>
	
	<script type="text/javascript">
   	/*分页查询开始*/
   		//定义一页显示多少个
   		var pageSize = 5;
   		var shop_id = ${shop.shop_id} ;
   		//查询总行数
   		
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
		         num_edge_entries: 2       //省略号两边的页数
		     }); 
    	});
    	
    	function PageCallback(pageIndex,jq){
	    	$.post("${pageContext.request.contextPath}/goods.do",{"method":"ajaxPage","currentPage":pageIndex,"pageSize":pageSize,"shop_id":shop_id},function(list){
	    		//获取到数据之后先清除之前的内容
	    		$("#main").empty();
	    		if(list == ""){
	    			$("#main").append("<div>你还没有商品呀</div>");
	    		}else{
	    			$(list).each(function(){
	    			$("#main").append("<tr>"+
		    			"<td><input class='c1' type='checkbox'></td>"+
		    			"<td>"+this.goods_id+"</td>"+
		    			"<td><a href='goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+this.goods_Desception+"</a></td>"+
		    			"<td><img class='img' alt='无' src='${pageContext.request.contextPath}"+this.goods_Img+"'></td>"+
		    			"<td>"+this.goods_InputPrice+"</td>"+
		    			"<td>"+this.goods_OutputPrice+"</td>"+
		    			"<td>"+this.goods_Count+"</td>"+
		    			"<td>"+this.goods_Status+"</td>"+
		    			"<td>"+this.goods_SellCount+"</td>"+
		    			"<td><a href='goods.do?method=deleteGoods&shop_id=${shop.shop_id }&goods_id="+this.goods_id+"'>删除</a></td>"+	
		    			
	    			 "</tr>");
	    		});
	    				
	    		};
	    		
	    	},"json");
	    	
    	}
    	//调用函数显示第一页的数据
    	PageCallback(0);
   	</script>
	
	<script type="text/javascript">
			//定义一页显示多少个
   		
   		
   	
    	
    	$(document).on("click","#delete_btn",function(){
    		confirm("是否确认删除该商品");
    	
    	});
		
	</script>
	
	
	<script type="text/javascript">
				 var nameFlag = false ;
    		   $(document).on("blur" , "#name" , function(){
    		   	$.post("${pageContext.request.contextPath}/shop.do",{"method" : "findShopByNa" , "name" : $(this).val()}, function(result){
    		   		if(result == "同名"){
    		   			$("#nameError").html("存在同名店铺");
    		   		}else{
    		   			$("#nameError").html("");
    		   			nameFlag = true ;
    		   		}
    		   		
    		    	});
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
    					         $("#address").val("${shop.shop_address}");
    					  }else{
    					  	var add = province+"-"+city+"-" + area+"-"+street;
    					    $("#address").val(add);
    					  }
    					  		frm1.submit();
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
