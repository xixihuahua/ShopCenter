<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>商品详情</title>
    
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/GoodsSeller.css" />
 	 
 
  </head>
  
  <body>
  
  	<!-- 导航栏 -->
		<div class="nav navbar-default">
			<ul class="">
				<li class="col-md-1 col-md-offset-2 col-sm-1"><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">首页</a></li>
				<li class="col-md-1 col-sm-1"><a href="${pageContext.request.contextPath }/seller/sellerCenter.jsp">我的主页</a></li>
				<li class="col-md-1 col-sm-1"><a href="${pageContext.request.contextPath }/seller/centerShop.jsp">我的店铺</a></li>
				<li class="col-md-1 col-sm-1"><a href="">收藏夹</a></li>
				<li class="col-md-1 col-sm-1"><a href="">商品分类</a></li>
				<li class="col-md-1 col-sm-1"><a href="">卖家中心</a></li>
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
				<div id="main">
					<a name="n1"  data-toggle="modal" data-target="#myModal">
					<img  alt="点击更改图片" src="${pageContext.request.contextPath }${goods.goods_Img}">
					</a>
					
				</div>
				
				
			</div>
			<div id="describe">
			
				<div id="goods_name"  ><h3  id="goods_Desception" name="goods_Desception">${goods.goods_Desception }</h3><span id = "dError"></span> </div>
				<img src="${pageContext.request.contextPath }/images/7.png" >
				<div id="data">
					<dl>
						<dt>进价:</dt>
						<dd><span>￥</span> 
						<input id = "in" name="goods_InputPrice" value="${goods.goods_InputPrice}" type="number"><span style="color:red;" id="inError"></span></dd>
					</dl>
					<dl>
						<dt>售价:</dt>
						<dd><span>￥</span>
						<input id = "out"  name="goods_OutputPrice" value="${goods.goods_OutputPrice}"  type="number"><span style="color:red;" id="outError"></span></dd>
					</dl>
					
					<dl>
						<dt>类型:</dt>
						<dd><select id = "first" name="first"></select>
						    	<select id = "second" name="second">
						    		<option>请选择二级类型</option>
						    	</select>
						    	<select id = "third" name="third">
						    		<option>"请选择三级类型"</option>
						    	</select><span id="typeError"></span>
					</dd>
					</dl>
				</div>
				<dl>
					<dt>折扣:</dt>
					<dd><input id="count1" name="goods_count" value="${goods.goods_Count }" type = "number" placeholder="折扣大于0小于1"><span style="color:red;" id="countError"></span></dd>
				</dl>
				<dl>
					<dt>库存:</dt>
					<dd><input id = "r" name= "goods_Repertory" type="number" value="${goods.goods_Repertory }">件<span style="color:red;" id="rError"></dd>
				</dl>
				<dl>
					<dt>库存:</dt>
					<dd><select id = "status" name="goods_status">
						 <option>上架</option>
						 <option>下架</option>
					   </select>
					   </dd>
					 </dl>
				
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
					
						<button  type="button" id="btnUpdate" class="btn">提交修改</button>
					
				</div>
				
			
				 </div>
		 	</div>
		</div>
		
		<hr>
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
							<thead id="commentHead">
								<tr>
			     	 				<th>买家id</th>
			     	 				<th>评论内容</th>
			     	 				<th>评论时间</th>
			     	 			</tr>
							</thead>

							<tbody id="comment">
     	 		
     	 					</tbody>
		
					</table>

				</form>
			</div>

		</div>
        
		 
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					    <div class="modal-dialog">
					        <div class="modal-content">
					            <div class="modal-header">
					                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					                <h4 class="modal-title" id="myModalLabel">修改店铺信息</h4>
					            </div>
					            <div class="modal-body">
					            	<img style="width:50px;" src="${pageContext.request.contextPath }${goods.goods_Img}"><br>
					            	<form id="frm1" action="${pageContext.request.contextPath }/goods.do?method=uploadGoodsImg" method="post" enctype="multipart/form-data">
	    							<input name="file" type="file">
	    							 
	  								 </form>
					            </div>
					            
					            <div class="modal-footer">
					                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					              	 <button id="btnUpload" type="button" class="btn btn-primary">提交更改</button>
					            </div>
					        </div><!-- /.modal-content -->
					    </div><!-- /.modal-dialog -->
					</div>
		
	
				
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    	<script type="text/javascript">
    		//上传头像
    		$("#btnUpload").click(function(){
    			frm1.submit();
    		});
    	
    		//获取该商品的所有评价
    		 //显示所有评论
    		 var goods_id = ${goods.goods_id } ;
   	   		 $.post("comment.do",{"method":"findCommentByGoods_id","goods_id" : goods_id},function(list){
	    		//获取到数据之后先清除之前的内容
	    	 $("#comment").empty();
	    	
		    	if(list != ""){
		    			$(list).each(function(){
		    			 $("#comment").append("<tr>"+
		    			   	 "<td>****"+this.custom_id+"*****</td>"+
		    			   	 "<td>"+this.comment_content+"</td>"+
		    			   	 "<td>"+this.comment_time+"</td>"+
		    			 "</tr>");
		    		});
		    	
		    	}else{
		    		$("#commentHead").empty();
		    		 $("#comment").append("<tr><td>还没有评论呀！！！</td></tr>");
		    	}
	    	
    	 },"json");
    	 
    	 
    		
    		//获取值
    				var oldVal=$("#goods_Desception").text();
    				var dFlag=false;
    				//双击改名 
    				$(document).on("dblclick","#goods_Desception",function(){
			
				    		//获取当前td中的内容
				    		oldValue = $(this).text();
				    		//清空当前td
				    		$("#goods_name").empty();
				    		//在当前td上写一个<input>
				    		$("#goods_name").append("<input id='goods_Desception' name='goods_Desception' value='"+oldValue+"'><span id='dError'></span>");
    				});
    				$(document).on("blur","#goods_name",function(){
			
				    		//获取值
				    		var val = $("#goods_Desception").val();
				    		 $.post("${pageContext.request.contextPath}/goods.do",{"method":"findGoodsByDe","desception":val},function(result){
		    				 		 if(result == "同名"){
		    				 			 $("goods_name").empty();
				    					//在当前td上写一个<input>
				    					$("#goods_name").html("<h3 id='goods_Desception' name='goods_Desception'>"+val+"</h3><span id='dError'>存在同名描述</span>");
		    				 			
		    				 		}else{
		    				 			dFlag = true ;
		    				 			//清空当前td
				    					$("goods_name").empty();
				    					//在当前td上写一个<input>
				    					$("#goods_name").html("<h3 id='goods_Desception' name='goods_Desception'>"+val+"</h3><span id='dError'></span>");
		    				 		}
		    				  });
				    		
    					
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
    				 $(document).on("blur","#count1",function(){
    				 
    					if($("#count1").val() < 0){
    					 	$("#countError").html("请输入正确折扣");
    					  }else if($("#count1").val() == "") {
    					    $("#countError").html("请输入折扣");
    					  }else {
    					    countFlag = true ;
    					    $("#countError").html("");
    					 }
    				 });
    				 
    				
    				 
    				 
    				 
    				 //点击提交按钮
    				$("#btnUpdate").click(function(){
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
    					
    					var goods_id =${goods.goods_id};//商品id
    					var goods_Desception=$("#goods_Desception").text();//商品名
    					var shop_id=${goods.shop_id};//店铺id
    					var goods_Repertory =$("#r").val();//库存
    					var goods_InputPrice =$("#in").val(); //进价
    					var goods_OutputPrice = $("#out").val();//售价
    					var goods_count=$("#count1").val(); //折扣
    					var goods_status=$("#status").val();//状态
    					var goodsType=third; //商品类型
    					
    					if(dFlag && typeFlag && tFlag&& inFlag && outFlag && countFlag  ){
    					$.post("${pageContext.request.contextPath}/goods.do",
    					{"method":"updateGoods","shop_id":shop_id,"goods_Desception":goods_Desception,
    					"goods_id":goods_id,"goods_Repertory":goods_Repertory,"goods_InputPrice":goods_InputPrice,
    					"goods_OutputPrice":goods_OutputPrice,"goods_count":goods_count,"goods_status":goods_status,
    					"third":goodsType},
    					function(result){
    						alert(result);
    					});
    					}else{
    						alert("修改失败");
    					}
    				});
    					
    		  /*商品三级联动开始*/
    			$.post("${pageContext.request.contextPath}/xml/goodsType.xml",function(data){
    				$("#first").empty();
    				$(data).find("first").each(function(){
    					var first = $(this).attr("name");
    					$("#first").append("<option>"+first+"</option>");
    				 });
    			},"xml");
    			
    			$("#first").change(function(){
    				$("#second").empty();
    				$.post("${pageContext.request.contextPath}/xml/goodsType.xml",function(data){
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
    				$.post("${pageContext.request.contextPath}/xml/goodsType.xml",function(data){
    					var first = $("#first").val();
    					var second = $("#second").val();
    					$(data).find("first[name="+first+"]").find("second[name="+second+"]").find("third").each(function(){
    						var third = $(this).attr("name");
    						$("#third").append("<option>"+third+"</option>");
    					
    					});
    				},"xml");
    			}
    			/*三级联动结束*/
    			
    		 
    		</script>
    		
  </body>
</html>
