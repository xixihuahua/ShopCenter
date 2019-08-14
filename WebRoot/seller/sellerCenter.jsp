<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>卖家中心, ${seller.seller_name}</title>
    
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sellerCenter.css" />

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
				            <li><a href="#" >${seller.seller_name}</a></li>
				            <li><a href="${pageContext.request.contextPath}/nav/Reg.jsp">免费注册</a></li>
				            <li><a href="${pageContext.request.contextPath}/seller/sellerCenter.jsp">我的主页</a></li>	           
				        </ul>
				    </div>
			</div>
		</nav>
		<!--店铺名和头像-->
		<div id="message">
			<ul>
				<li>
				
				<img src="${pageContext.request.contextPath}${seller.seller_img}" class="img-circle" style="width: 60px;height: 60px;"/>
				</li>
				<li><span id="username">${seller.seller_name} ID:${seller.seller_id }</span></li>
				
			</ul>
			<!--功能按钮-->
				<div id="btn">
					
			<button id="btnDel" type="button"  class="btn btn-danger right">注销账号</button>
					<!-- 按钮触发模态框 -->
					<!-- 修改头像 -->
			<button class="btn btn-primary btn-danger right" data-toggle="modal" data-target="#myModal3">修改头像</button>
			<!-- 修改头像模态框（Modal） -->
			<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                <h4 class="modal-title" id="myModalLabel">修改头像</h4>
			            </div>
			            <div class="modal-body">
			            	<img src="${pageContext.request.contextPath}${seller.seller_img}" class="img-circle" style="width: 60px;height: 60px;"/><br>
			            	<br>
			            	<form id="frm3" action="${pageContext.request.contextPath }/seller.do?method=uploadSellerImg" method="post" enctype="multipart/form-data">
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
					
			
			<!-- 按钮触发模态框 -->
						<button class="btn btn-primary btn-danger right" data-toggle="modal" data-target="#myModal1">修改号码</button>
						<!-- 模态框（Modal） -->
						<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						    <div class="modal-dialog">
						        <div class="modal-content">
						            <div class="modal-header">
						                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						                <h4 class="modal-title" id="myModalLabel">修改号码</h4>
						            </div>
						            <div class="modal-body">
						            	<form id="frm2" action="${pageContext.request.contextPath}/seller.do" method="post">
					  					<input name="method" value="sellerUpdateTel" type="hidden">
				  			      原手机号码<input  name="oldTel" value="${seller.seller_tel}" readonly><br>
					              修改后手机号码<input name="tel" ><br>
						            绑定的邮箱<input id ="inbox" name = "inbox" value="${seller.seller_email}" readonly><div style="color:red;" id = "text"></div>
					             		  验证码<input name="validation" id = "validation" placeholder="验证码区分大小写"><span id="text1">${valiMsg}</span>
		        
  		 				</form>
            			  <button id="btnSend" class="btn btn-sucess">发送验证码</button> 
             				 
						            </div>
						            <div class="modal-footer">
						                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						               <button type="button" class="btn btn-primary" id="btnSumbit">提交更改</button> 
						            </div>
						        </div><!-- /.modal-content -->
						    </div><!-- /.modal -->
						</div>
			
					
			<!--   添加店铺 -->
			<button class="btn btn-primary btn-warning right" data-toggle="modal" data-target="#myModal2">添加店铺</button>
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					    <div class="modal-dialog">
					        <div class="modal-content">
					            <div class="modal-header">
					                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					                <h4 class="modal-title" id="myModalLabel">添加店铺</h4>
					            </div>
					            <div class="modal-body">
					            	<form id = "frm1" action="${pageContext.request.contextPath}/shop.do" method="post" >
						    		  <input id = "method" name="method" value = "addShop" type= "hidden"> 
								      
								           店铺名 :<input id="name" name ="shop_name"><span id="nameError"></span><br>
								           仓库地址 : <select id = "province" name="provice"></select>
							    	  <select id = "city" name="city">
								    		<option>请选择市</option>
									    	</select>
									    	<Select id = "area" name="area">
									    		<option>"请选择区"</option>
									    	</Select>   
										<input name="street" placeholder = "请输入具体街道">  <br> 
									 </form>
          						
					            </div>
					            
					            <div class="modal-footer">
					                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					              	<button id = "btnAdd" class="btn btn-primary">注册</button>
					            </div>
					        </div><!-- /.modal-content -->
					    </div><!-- /.modal-dialog -->
					</div>			
				
					
					
			<!-- 编辑卖家资料 按钮触发模态框 -->
			<button class="btn btn-primary btn-danger right" data-toggle="modal" data-target="#myModal">编辑资料</button>
			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			            <button type="button" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			            <h4 class="modal-title" type="button" id="myModalLabel">修改资料</h4>
			            </div>
				         <div class="modal-body" style="background-image:url('${pageContext.request.contextPath}/images/pink.png')">
							<form id = "frm" action="${pageContext.request.contextPath}/seller.do" method="post" >
	   		 					<input id = "method" name="method" value = "sellerUpdate" type= "hidden"> 
							<table style="text-align: left;color:gray;">
	   		 					<tr>
							   		 <td> 用户名 :</td>
							   		 <td><input id="seller_name" name = "seller_name" value="${seller.seller_name}"><span id="nameError"></span></td>
						   		 </tr>
						   		 <tr>
							   	 	 <td> 性别：</td>
							   	 	 <td><input id="sex" name = "sex" value="${seller.seller_sex}" ><span id="sexError"></span></td>
						   	 	 </tr>
						   	 	 <tr>
							     	 <td>年龄 : </td>
							     	 <td><input id="age" type="number" name="age" max="130" min="18" value="${seller.seller_age}" ><span id="ageError"></span></td>
						     	 </tr>
						     	 <tr>
							       <td>旧收货地址</td>
							       <td><input  value="${seller.seller_address}" readonly> </td>
								   <td><input  id="address1" name = "seller_address" type="hidden"></td>
							     </tr>
							     <tr>
							     	 <td>收货地址 : </td>
							     	 <td>
								     	 <select id = "province1" name="provice">
					      					<option>请选择省</option>
							      			</select>
									    	<select id = "city1" name="city">
							    			<option>请选择市</option>
							    		</select>
				    					<Select id = "area1" name="area">
				    						<option>请选择区</option>
				    					</Select> 
			    					</td>
		    					</tr>  
		    					<tr>
		    					<td><span> </span></td>
						    	<td>
						    		<input id="street1" name="street" placeholder = "请输入具体街道">
						    	</td>
						    	</tr> 
						    	<tr>
				      			  	<td>电子邮箱：</td>
				      			  	<td><input id="email" type="email" name="email" value="${sellerer.seller_email}"><span id="emailError"><span id="emailError"></span></td>
				      			</tr>
				    			<tr>
				   			    	<td>验证码</td>	
				   			    	<td><input id="vali" name = "imageCode" style = "height:30px;">
				     				 <img id="imageCode" title="看不清换一张" style="height: 30px;vertical-align: middle;cursor: pointer;" width="200" height="30" 
				      			 src="${pageContext.request.contextPath}/vali.do?method=imageValidation">
				      			 	</td>
 								</tr>
 							</table>
    
      					</form>
							
			            </div>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			                 <button type="button" type="button" id="btnUpdate" class="btn btn-primary">提交更改</button>
			            </div>
			        </div><!-- /.modal-content -->
			    </div><!-- /.modal -->
			</div>

			<a class="btn btn-info right"  href="${pageContext.request.contextPath}/seller/orderSeller.jsp">查看订单</a>
						
					
					
				</div>
				<!--我的店铺表格-->
				<div id="myshop">
					
					<table class="table">
					  <thead>
					    <tr>
					      <th>全选<input type="checkbox" id="selectAll"><br>
					      	  反选<input type="checkbox" id="reverseSelect">
					      	</th>
					       <th>店铺id</th>	
					      <th>店铺名</th>
					      <th>店铺图片</th>
					     
					      <th>仓库地址</th>
					      <th>操作</th>
					    </tr>
					  </thead>
					  <tbody id="main">
					  </tbody>
					</table>
					<div id="Pagination">分页显示</div>
				</div>
				
		</div>
		
		
		
		
		<script type="text/javascript">
		/*修改头像*/
		$("#btnUpload").click(function(){
			
			frm3.submit();
		});
		
		
			/*邮箱验证*/
        var t ;
   		var time = 60 ;
   		 
   		$("#btnSend").click(function(){
   			$(this).hide();
   			//$(this).attr("disabled","disabled");
   			t = window.setInterval(function(){
   				$("#text").text(--time+"秒后可点击再次发送");
   				if(time == 0){
   					window.clearInterval(t);
   					time = 60 ;
   					$("#btnSend").show();
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
        $("#btnSumbit").click(function(){
             frm2.submit();
          });
          
		
		</script>
		
		<!-- 全选按钮 -->
	  	<script type="text/javascript">
	  	/*点击更改绑定的号码*/
   		$("#btnTel").click(function(){
   		      window.open('${pageContext.request.contextPath}/seller/updateSellerTel.jsp','_self','height=400, width=600, top=100px,left=320px, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes');
   		 });
   		
   		/*点击注销用户*/
   		$("#btnDel").click(function(){
   			var result = confirm("如果你注销账户，将会将你名下的所有店铺以及商品删除，ARE YOU 确定 ?");
   			if(result == true){
   				var result1 = confirm("真的不考虑一下了吗 ? 嗯 ？");
   				if(result1 == true){
   					alert("期待下次再会");
   				}else{
   					alert("good boy");
   				}
   			}else{
   				alert("good boy");
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
   	
   	<!-- 分页查询显示店铺 -->
   	<script type="text/javascript">
   	/*分页查询开始*/
   		//定义一页显示多少个
   		var pageSize = 5;
   		
   		//查询总行数
   		
    	//查询总行数
   		$.post("${pageContext.request.contextPath}/shop.do",{"method":"pageCount"},function(rowCount){
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
	    	$.post("${pageContext.request.contextPath}/shop.do",{"method":"ajaxPage","currentPage":pageIndex,"pageSize":pageSize},function(list){
	    		//获取到数据之后先清除之前的内容
	    		$("#main").empty();
	    		if(list == ""){
	    			$("#main").append("<div>你还没有店铺呀</div>");
	    		}else{
	    			$(list).each(function(){
	    			$("#main").append("<tr class='info'>"+
	    			"<td><input class='c1' type='checkbox'></td>"+
	    			 "<td>"+this.shop_id+"</td>"+
	    			"<td><a href='${pageContext.request.contextPath}/shop.do?method=findShopById&shop_id="+this.shop_id+"'>"+this.shop_name+"<td>"+
	    			"<td><img class='img' src='"+${pageContext.request.contextPath}/+""+this.shop_img+"'><td>"+
	    			"<td>"+this.shop_address+"</td>"+
	    			"<td><a href='#'>删除</a></td>"+
	    		    "</tr>");
	    		   });
	    		
	    		}
	    	
	    		},"json");
	    		
	   }    	//调用函数显示第一页的数据
    	
    	/*分页查询结束*/
    		PageCallback(0);
   	</script>
   	
   	<!-- 修改资料 -->
    <script type="text/javascript">
    
    //新建店铺
    		var nameFlag = false ;
    		
  		   $(document).on("blur" , "#shop_name" , function(){
  		   var shop_name =$("#shop_name").val();
  		   	$.post("${pageContext.request.contextPath}/shop.do",{"method" : "findShopByNa" , "name" : shop_name}, function(result){
  		   		if(result == "同名"){
  		   			$("#nameError").html("存在同名店铺");
  		   		}else{
  		   			$("#nameError").html("");
  		   			nameFlag = true ;
  		   		}
  		   		
  		    	});
  		   });
  		   
  		   $("#btnAdd").click(function(){
  		   
  		 
  		      if(nameFlag){
  		      	frm1.submit();
  		      }
  		   
  		   });
    
    
    
    //修改卖家资料
    			/*图片验证码*/
    			$("#imageCode").click(function(){
	   		 		$(this).attr("src","${pageContext.request.contextPath}/vali.do?method=imageValidation&t="+new Date());   		
	   			});
	   			
	   			var nameRegs=/^.{3,16}$/;
				var ageRegs=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
				 var emailRegs=/^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$/;
				 
				 //修改店铺
				 //修改店铺查看是否有重名
				var nameFlag = true ;
				 $(document).on("blur","#seller_name",function(){
				 	var  name = $("#seller_name").val() ;
				 	
				 	//如果通过正则验证
				if(nameRegs.test( name) ){
				   $.post("${pageContext.request.contextPath}/seller.do",{"method":"findSellerByNa","name":name},function(result){
    			
    				 		 if(result == "同名"){
    				 		 nameFlag = false ;
    				 			$("#nameError").html("存在同名用户");
    				 		}else{
    				 			 
		                        $("#nameError").html("");
    				 		}
    				  });
	    		 }else{
	    		 		nameFlag = false ;
					  $("#nameError").html("用户名格式错误"); 
				}
		    });
				   
				
				
				//年龄正则验证
				var ageFlag = true ;
				var age=$("#age").val();
				
				 $(document).on("blur","#age",function(){
				 	
					if(ageRegs.test(age) ){
					      
					       $("#ageError").html("");  
					}else{
					 ageFlag = false ;
						  $("#ageError").html("年龄不符合"); 
					}
				});
	   			
	   			$("#btnUpdate").click(function(){
                      //获取新地址
                    
    					var province = $("#province1 option:selected").text() ;
    					
    					var city = $("#city1 option:selected").text() ;
    					var area = $("#area1 option:selected").text();
    					var street = $("#street1").val();
    					 $("#province1").attr("value" , province); 
    					  $("#city1").attr("value" , city); 
    					  $("#area1").attr("value" , area); 
    					  //说明用户地址没有更改
    					  if($("#province1").attr("value") == "请选择省"){
    					         $("#address1").val("${customer.custom_address}");
    					  }else{
    					  	var add = province+"-"+city+"-" + area+"-"+street;
    					    $("#address1").val(add);
    					  }
    						
    					  if(nameFlag && ageFlag){
    					  	alert("修改成功");
    					  		frm.submit();
    					  }else{
    					  	alert("用户名或年龄格式错误");
    					  }
                    });    
           
    		  
    			/*三级联动*/
    			$.post("${pageContext.request.contextPath}/xml/city.xml",function(data){
    				$("#province1").empty();
    				$(data).find("province").each(function(){
    					var province = $(this).attr("name");
    					$("#province1").append("<option>"+province+"</option>");
    				 });
    			},"xml");
    			
    			$("#province1").change(function(){
    				$("#city1").empty();
    				$.post("${pageContext.request.contextPath}/xml/city.xml",function(data){
    					var province = $("#province1").val();
    					$(data).find("province[name="+province+"]").find("city").each(function(){
    						var city = $(this).attr("name");
    						$("#city1").append("<option>"+city+"</option>");
    					 });
    					 changeArea1();
    				},"xml");
    			});
    			
    			$("#city1").change(function(){
    				changeArea1();
    			}) ;
    			
    			function changeArea1(){
    				$("#area1").empty();
    				$.post("${pageContext.request.contextPath}/xml/city.xml",function(data){
    					var province = $("#province1").val();
    					var city = $("#city1").val();
    					$(data).find("province[name="+province+"]").find("city[name="+city+"]").find("area").each(function(){
    						var area = $(this).attr("name");
    						$("#area1").append("<option>"+area+"</option>");
    					
    					});
    				},"xml");
    			}
    		 /*三级联动*/
    		 
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
