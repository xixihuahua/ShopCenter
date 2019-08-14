<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <base href="<%=basePath%>">
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Login.css" />
</head>
<body>		
		<!-- 导航栏-->
		<nav class="navbar navbar-default" role="navigation" style="height: 30px">
	    	<div class="container-fluid col-sm-offset-2">
				    
				    <div>
				        <ul class="nav navbar-nav">
				        	<li><a href="${pageContext.request.contextPath }/nav/shopCenter.jsp">首页</a></li>
				           
				            <li><a href="${pageContext.request.contextPath }/nav/Reg.jsp">免费注册</a></li>
				            <li><a href="${pageContext.request.contextPath }/nav/Login.jsp">购物车</a></li>
							<li><a href="#">收藏夹</a></li>
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                    网站导航
				                    <b class="caret"></b>
				                </a>
				                <ul class="dropdown-menu">
				                    <li><a href="https://www.baidu.com/">百度</a></li>
				                    <li><a href="https://www.sina.com.cn/">新浪</a></li>
				                    <li><a href="https://jx.tmall.com/">天猫</a></li>
				                    <li class="divider"></li>
				                    <li><a href="https://www.jd.com/">京东</a></li>
				                    <li class="divider"></li>
				                    <li><a href="https://www.taobao.com/">谷歌</a></li>

				                </ul>
				            </li>
				        </ul>
				    </div>
			</div>
		</nav>

		<!-- 登录表 -->
		<div class="center" >
				<form id="frm" action="custom.do" method="post" class="box-top form-horizontal col-sm-4 " role="form">
					
					<br>
					<!-- 选择登录的用户 -->
					<div class="dropdown" align="center">
						 <select id = "login" class="btn dropdown-toggle">
	 				 <option>买家登陆</option>
	 				 <option>卖家登陆</option>
 						</select>
						
					</div>
					<!-- 输入账户密码 -->
					
					<div class="form-group">
						<label for="name" class="col-sm-2 col-md-3 control-label">账户</label>
						<div class="col-sm-7">
							<input id = "method" name="method" value="customLogin" type="hidden" >
							<input  id="name"  name="name" type="text" class="form-control" 
								   placeholder="请输入账户">	<span id="namemsg"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 col-md-3 control-label">密码</label>
						<div class="col-sm-7">
							<input  id="password" name = "password" type="password" class="form-control" 
								   placeholder="请输入密码">
							<span id="pwdmsg">
							<%if(request.getSession().getAttribute("pwdmsg")==null){
	    	 %><%="" %><%}else{ %><%=request.getSession().getAttribute("pwdmsg") %><%} %></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-10">
							<div class="checkbox">
								<label>
									<input type="checkbox"> 记住密码
								</label>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="but col-sm-offset-4 col-sm-10">
							<button id="btn" type="button" class="but1 btn btn-default col-sm-3">登录</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-10">
							<a href="${pageContext.request.contextPath }/nav/FindBackPwd.jsp">忘记密码</a>  &nbsp;&nbsp;&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath }/nav/Reg.jsp">免费注册</a>	
						</div>				
					</div>					
				</form>
		</div>
		<div class="clear"></div>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
	        <script type="text/javascript">
	    	   login =$("#login option:selected").text();
	    	 
	    		$(document).on("blur","#name",function(){
					var NameRegs =/^.{3,16}$/;
					var val = $(this).val();
					if(!NameRegs.test(val)){
					 $("#namemsg").html("账号格式错误");
					}else{
					$("#namemsg").html("");
					}
				});
				
				$(document).on("blur","#password",function(){
					var pwdRegs =/^[a-zA-Z]\w{5,17}$/;
					var val = $(this).val();
					if(!pwdRegs.test(val)){
					 $("#pwdmsg").html("密码格式错误");
					}else{
					$("#pwdmsg").html("");
					}
				});
		
		  		/*点击登陆*/
	    		$("#btn").click(function(){
	    			 <%
	    			   session.removeAttribute("customer");
					   session.removeAttribute("seller");
					  %>
	    			 login =$("#login option:selected").text();
	    			 
	    			  if(login == "卖家登陆"){ //如果选择卖家登陆
	    					//修改form表单提交的地址和方法
	    				$("#frm").attr("action" , "${pageContext.request.contextPath}/seller.do");
	    				$("#method").attr("value" , "sellerLogin");
	    				
	    				$.post("seller.do",{"method" : "sellerLogin" , "name" : $("#name").val() , "password" : $("#password").val()} , function(result){
	    			 		if(result == "账号格式错误!" || result== "密码格式错误!!" || result == "用户名或密码错误"){
	    			 			alert(result);
	    			 		}else{
	    			 			//提交表单
	    						frm.submit();
	    			 		}
	    			 	
	    			 	});
	    			 	
	    			 }else{
	    			 
	    			 	$.post("custom.do",{"method" : "customLogin" , "name" : $("#name").val() , "password" : $("#password").val()} , function(result){
	    			 		
	    			 		if(result == "账号格式错误!" || result== "密码格式错误!!" || result == "找不到用户名或密码错误"){
	    			 			alert(result);
	    			 		}else{
	    			 			//提交表单
	    						frm.submit();
	    			 		}
	    			 	
	    			 	});
	    			  }
	    			
	    		});
		
		</script> 
</body>
</html>
