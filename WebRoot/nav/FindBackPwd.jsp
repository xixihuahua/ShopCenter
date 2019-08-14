<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>密码找回</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/FindBackPwd.css" />
	

</head>
<body>	
	<!-- 导航栏-->
		<nav class="navbar navbar-default" role="navigation">
	    	<div class="container-fluid col-sm-offset-2">			
				    <div>
				        <ul class="nav navbar-nav">
				        	<li><a href="${pageContext.request.contextPath }/nav/shopCentrt.jsp">首页</a></li>
				            <li><a href="${pageContext.request.contextPath }/nav/Login.jsp" >亲，请登录</a></li>
				            <li><a href="${pageContext.request.contextPath }/nav/Reg.jspp">免费注册</a></li>
				            <li><a href="#">我的主页</a></li>	           
				        </ul>
				    </div>
			</div>
		</nav>
			<div id="img" class="col-sm-offset-2">
				<br>
				<br>			
				<span> 找回密码</span>
			</div>

		<form class="form-horizontal col-sm-offset-4" action="${pageContext.request.contextPath}/custom.do" method="post" role="form"  id="frm">	
			 <input id = "method" name="method" value = "findBackPassword" type= "hidden">
			<div class="form-group">
			<div>
				<select id = "pwd" class="btn dropdown-toggle" >
	 				 <option>买家忘记密码</option>
	 				 <option>卖家忘记密码</option>
 				</select>
 			</div>	
				<label for="name" class="col-sm-2 col-md control-label">用户名</label>
				<div class="col-sm-3">
					<input  id="name" name="name" type="text" class="form-control"  
						   placeholder="请输入名字" ><span style="color:red">${nameError }</span><br>
				</div>
			
			</div>
			<div class="form-group">
			
				<label for="password" class="col-sm-2 col-md control-label">新密码</label>
				<div class="col-sm-3">
					<input  id="password" name="password" type="password"  class="form-control"  
						   placeholder="请输入密码" >
				</div>
			
			</div>
			<div class="form-group">
			
				<label for="password1" class="col-sm-2 col-md control-label">确认密码</label>
				<div class="col-sm-3">
					<input  id="password1" name="password1" type="password" class="form-control"  
						   placeholder="请确认密码" ><span style="color:red" id="pwdError">
				</div>
			
			</div>
			
			
			<form id="frm2" action="${pageContext.request.contextPath}/vali.do?method=mailValidation")>  
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">邮箱</label>
				<div class="col-sm-3">
					
					<input id="inbox" name="inbox" class="form-control" placeholder="请输入绑定的邮箱" ><span id="mailError">${mailError }</span>	   
					<span id="mailError" style="color:red">${mailError }</span>	   <br>
					<input type="button" id="btn" class="btn btn-primary" value="发送验证码">  
				</div>
			</div>
		
			<div class="form-group">
				<label for="vail" class="col-sm-2 control-label">验证码</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="emailCode" name="emailCode"
						   placeholder="请输入验证码">
						 
				</div>
				
			</div>
			
		
			
				</form>
			
		</form>
			<div align="center">
				<button  id="btn1" type="button" class="btn btn-primary" >更改密码</button>
			</div>
		<br><br><br><br><br><br><br>
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
		
			<script type="text/javascript">
			
			
				/*邮箱验证码*/
    	var t ;
    	var time=60;
    	 $("#btn").click(function(){
    	  var pwd =$("#pwd option:selected").text();
    	 	//买家忘记密码
    	    if(pwd == "买家忘记密码"){
    	   //先判断输入的邮箱与用户绑定的邮箱是否一致
    	    $.post("${pageContext.request.contextPath}/custom.do?method=customFindEmail",{"inbox":jQuery("#inbox").val(),"name":jQuery("#name").val()},function(result){
	    			  
	    			 alert(result);
	    			 //一致的话，才发送邮件
	    		if(result == "邮箱对应"){
   					 sendMail();
	    		} 
	    		
	    	 });
    	    
    	    //卖家忘记密码
    	    }else{
		        //先判断输入的邮箱与用户绑定的邮箱是否一致
	    	    $.post("${pageContext.request.contextPath}/seller.do?method=sellerFindEmail",{"inbox":jQuery("#inbox").val(),"name":jQuery("#name").val()},function(result){
		    			  alert(result);
		    	    //一致的话，才发送邮件
		    		if(result == "邮箱对应"){
	   					sendMail();
		    		}else{
		    			alert("邮箱错误");
		    		}
		    		
		    	 });
    	  }
  }); 
    	 /*邮箱验证码结束*/
			 //发送邮箱
		 //发送邮箱
    	 function sendMail(){
    	 	$("#btn").attr("disabled","disabled");
			    	t=window.setInterval(function(){
				    	$("#btn").val(--time+"秒可再次发送");
				    	if(time==0){
				    		window.clearInterval(t);
				    		time=60;
				    		$("#btn").removeAttr("disabled");
				    		$("#btn").val("发送验证码");
			    		 }
		    	    }, 1000); 
		    	
	    	$.post("${pageContext.request.contextPath}/vali.do?method=mailValidation",{"inbox":jQuery("#inbox").val()},function(send){
	    			alert(send);
	    	});
    	  }
			/*验证两次密码是否一致,以及密码格式是否正确*/
    	var pwdFlag = false ;
    	$(document).on("blur","#password1",function(){
  		    var pwdRegs =/^[a-zA-Z]\w{5,17}$/;
			var val = $("#password").val();
			if(val== $("#password1").val()){
				if(!pwdRegs.test(val)){
				  $("#pwdError").html("密码格式错误"+val+"----"+pwdRegs.test(val));
				}else{
					pwdFlag = true ;
					$("#pwdError").html("");
				}
			}else{
    			$("#pwdError").html("两次密码不一致");
    	    }	 
		 });
		 
		
    	$(document).on("click","#btn1",function(){  
    	 	//如果
	    	if(pwdFlag){
    			 var pwd1 =$("#pwd option:selected").text();
    			if(pwd1 == "卖家忘记密码"){ //如果选择卖家登陆
    					//修改form表单提交的地址和方法
    				$("#frm").attr("action" , "${pageContext.request.contextPath}/seller.do");
    				$("#method").attr("value" , "findBackPassword");
    			}
    		
					frm.submit();
				
					
				
    			//提交表单
    			
	    	}
    	
    	});
    	
    	
			</script>	
</body>
</html>
