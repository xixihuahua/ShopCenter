<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Reg.css" />
</head>
<body>
	<!-- 导航栏-->
		<nav class="navbar navbar-default" role="navigation">
	    	<div class="container-fluid col-md-offset-2">
				    <div>
				        <ul class="nav navbar-nav">
				        	<li><a href="${pageContext.request.contextPath}/nav/shopCenter.jsp">首页</a></li>
				            <li><a href="${pageContext.request.contextPath}/nav/Login.jsp" id="a1">亲，请登录</a></li>
				            <li><a href="#">免费注册</a></li>
				            <li><a href="#">购物车</a></li>
							<li><a href="#">收藏夹</a></li>
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                    网站导航
				                    <b class="caret"></b>
				                </a>
				                <ul class="dropdown-menu">
				                    <li><a href="#">百度</a></li>
				                    <li><a href="#">新浪</a></li>
				                    <li><a href="#">天猫</a></li>
				                    <li class="divider"></li>
				                    <li><a href="#">京东</a></li>
				                    <li class="divider"></li>
				                    <li><a href="#">谷歌</a></li>
				                </ul>
				            </li>
				        </ul>
				    </div>
			</div>
		</nav>
	
			

				<!-- 注册表-->
			<form id="frm" class="navbar-default" action="${pageContext.request.contextPath}/custom.do" method="post" >	
				     <input id = "method" name="method" value = "customReg" type= "hidden"> 
				    <div id="box">
						<div id="box1">	
								<div class="dropdown">
									
								 <select id = "reg"  class="btn dropdown-toggle">
					 				 <option>买家注册 </option>
					 				 <option>卖家注册</option>
				 				 </select>
									
								</div>							
								<div>
								  <div class=" left ">用户名</div>  
								  <input type="text" id="name" name = "name" class="right"  placeholder="请输入用户名" style="border-radius: 4px"/>
								
								   <span id="nameError" class="red"></span>
								   
								</div>
								<div>
								  <div class="  left  ">密码</div>      
								  <input  id="password" type="password" name = "password" class="right"  placeholder="密码请以字母开头"> 
								  <span id="pwdError" class="red"></span>
								</div>
								<div>	
								  <div class="  left ">密码确认</div> 
								  <input id="password2" type="password" name="password2" class="right"  placeholder="请再输入一次密码"> 
								 
								  <span class="red"></span>
								</div>
								<div>
								   <div class="  left " id="d1">性别</div>  
								   <label>  
								  <input type="radio" name="sex" value="0" checked required/> 男 
								   </label>
								   <label for="sex1"><input type="radio" id="sex1" name="sex" value="1" required/> 女
								   </label>
								</div>
								<div>
								   <div class="  left ">年龄</div>     
								   <input type="number" name="age" class="right" id="age" max="120" min="18" step="1"> 
								   <span id="ageError" class="red"></span>
								</div>
						</div>
						<div id="box2">
								<div>
								   <div class="  left ">联系方式</div>  
								   <input  name="tel" class="right" id="tel"> 
								   <span id="telError" class="red"></span>
								</div>
								<div>
									<div class=" left ">收货地址</div>   
														<select id = "province" name="provice" class="right">
															<option>请选择省</option>
														</select>
														<select id="city" name="city">
															<option>请选择市</option>
														</select>
														<select id="area" name="area">
															<option>"请选择区"</option>
														</select>
													<input name="street" placeholder = "请输入具体街道"> 	
								</div>
								<div>
									<div class="left ">电子邮箱</div>  
									<input type="email" name="email" class="right" id="email"> 
									<span  id="emailError" class="red"></span>
								</div>
								<div>
									<div class=" left ">验证码</div>    
									<input id="vali" name="imageCode" class="right">
									 <img id="imageCode" title="看不清换一张" src="${pageContext.request.contextPath}/vali.do?method=imageValidation"
									 style="height: 30px;vertical-align: middle;cursor: pointer;" width="200" height="30" > <!--图片验证 -->
									
								</div>
								<div>
									
									 <button id = "btn" type="button" class="right but">注册</button>
								</div>
								
						</div>
					</div>
			</form>
		
	<!--底部-->
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

	<!--注册的前端验证 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript">
		/*点击验证码图片*/
    		$("#imageCode").click(function(){
   		 		$(this).attr("src","${pageContext.request.contextPath}/vali.do?method=imageValidation&t="+new Date());   		
   			});
			var nameRegs=/^.{3,16}$/;
			var passwordRegs=/^[a-zA-Z].{5,17}$/;
			var ageRegs=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
			var  telRegs = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/ ;
            var emailRegs=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			
			

			 //查看是否有重名
				var nameFlag = false ;
				 $(document).on("blur","#name",function(){
				 	var  name = $("#name").val() ;
				if(nameRegs.test(name) ){
					var reg =$("#reg option:selected").text();
	    			if(reg == "卖家注册"){ //如果选择卖家登陆
	    					$.post("${pageContext.request.contextPath}/seller.do",{"method":"findSellerByNa","name":name},function(result){
    				 		 if(result == "同名"){
    				 			$("#nameError").html("存在同名用户");
    				 		}else{
    				 			 nameFlag = true ;
    				 			
		                        $("#nameError").html("");
    				 		}
    				     });
	    			}else{
	    				$.post("${pageContext.request.contextPath}/custom.do",{"method":"findCustomByNa","name":name},function(result){
    				 		 if(result == "同名"){
    				 			$("#nameError").html("存在同名用户");
    				 		}else{
    				 			 nameFlag = true ;
    				 			 
		                        $("#nameError").html("");
    				 		}
    				  });
	    			 }
				   
    			 }else{
					  $("#nameError").html("用户名格式错误"); 
				}
		    });
			//密码正则验证
				var pwdFlag = false ;
				 $(document).on("blur","#password",function(){
						if(passwordRegs.test( $("#password").val() ) ){
						       pwdFlag = true ;
						     
						       $("#pwdError").html("");  
						}else{
							  $("#pwdError").html("密码格式错误"); 
						}
				});
				
				//年龄正则验证
				var ageFlag = false ;
				 $(document).on("blur","#age",function(){
					if(ageRegs.test( $("#age").val() ) ){
					       ageFlag = true ;
					       $("#ageError").html("");  
					}else{
						  $("#ageError").html("年龄不符合"); 
					}
				});
				
				//手机号码验证
				var telFlag = false ;
				 $(document).on("blur","#tel",function(){
					if(telRegs.test( $("#tel").val() ) ){
					       telFlag = true ;
					       $("#telError").html("");  
					}else{
						  $("#telError").html("手机号码格式有误"); 
					}
				});
				
				//邮箱验证
				var emailFlag = false ;
				 $(document).on("blur","#email",function(){
					if(emailRegs.test( $("#email").val() ) ){
					       emailFlag = true ;
					       
					       $("#emailError").html("");  
					}else{
						  $("#emailError").html("邮箱格式不正确"); 
					}
				});
				
    		/*点击注册*/
    		$("#btn").click(function(){
    		
    			var reg =$("#reg option:selected").text();
    			if(reg == "卖家注册"){ //如果选择卖家登陆
    					//修改form表单提交的地址和方法
    				$("#frm").attr("action" , "${pageContext.request.contextPath}/seller.do");
    				$("#method").attr("value" , "sellerReg");
    			}
    			
    			$.post()
    			//提交表单
    			if(nameFlag&&pwdFlag&&ageFlag&&telFlag&&emailFlag){
    				frm.submit();
    				$("#frm").ajaxForm(function(data){
    					alert(data);
    				})
    			}
    			
    			<% if(request.getAttribute("str")==null){}else{%>
    			alert("注册失败!")<%}%>
    		});
    		
    		
    		/*三级联动开始*/
    			$.post("xml/city.xml",function(data){
    				$("#province").empty();
    				$(data).find("province").each(function(){
    					var province = $(this).attr("name");
    					$("#province").append("<option>"+province+"</option>");
    				 });
    			},"xml");
    			
    			$("#province").change(function(){
    				$("#city").empty();
    				$.post("xml/city.xml",function(data){
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
    				$.post("xml/city.xml",function(data){
    					var province = $("#province").val();
    					var city = $("#city").val();
    					$(data).find("province[name="+province+"]").find("city[name="+city+"]").find("area").each(function(){
    						var area = $(this).attr("name");
    						$("#area").append("<option>"+area+"</option>");
    					
    					});
    				},"xml");
    			}
    			/*三级联动结束*/
    			
    		 
				
				//再次确认密码
				$("#password2").blur(function (){	
		    		var pspan2 = this.parentNode.getElementsByTagName("span")[0];
		    		if(this.value != $("#password").val()){
		    			pspan2.innerHTML = "两次输入密码必须一致";	    			
		    		}else{
		    			pspan2.innerHTML = "";		    			
		    		}
    			});
				
				
				
	</script>
</body>
</html>
