<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>找回密码</title>
    
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
    <div>
    <select id = "pwd">
	 				 <option>买家忘记密码</option>
	 				 <option>卖家忘记密码</option>
 	</select>
 	    <form id="frm" action="${pageContext.request.contextPath}/custom.do" method="post">
    		 <input id = "method" name="method" value = "findBackPassword" type= "hidden">
    		<div>账号:<input id="name" name="name" placeholder="请输入账号或用户名" ><span>${nameError }</span><br></div>
    		<div>新密码:<input id="password" name="password" type="password"></div>
    		<div>确认密码:<input id="password1" name="password1" type="password"></div><span id="pwdError"></span>
    		<div>
	    	    <form id="frm2" action="${pageContext.request.contextPath}/vali.do?method=mailValidation")>  
	    		  邮箱 ： <input id="inbox" name="inbox"  placeholder="请输入绑定的邮箱" ><span id="mailError">${mailError }</span>
	    		<br>
	    		<input type="button" id="btn" value="发送验证码">
	    		  </form>
    			
    		
    		<div>请输入验证码:<input id="emailCode" name="emailCode">
    		<button id="btn1" type="button">找回密码</button></div>
    			
    		</div>
    		
    	</form>
    
    </div>
    
    <script type="text/javascript">
    //显示用户是买家还是卖家
   
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
		    		} 
		    		
		    	 });
    	  }
  }); 
    	 /*邮箱验证码结束*/
    	 
    	 //发送邮箱
    	 function sendMail(){
    	 	$("#btn").attr("disabled","disabled");
			    	t=window.setInterval(function(){
				    	$("#btn").val(--time+"可再次发送");
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
				
    	$("#btn1").click(function(){
    	   alert(pwdFlag);
    	 	//如果
	    	if(pwdFlag){
    			 var pwd1 =$("#pwd option:selected").text();
    			if(pwd1 == "卖家忘记密码"){ //如果选择卖家登陆
    					//修改form表单提交的地址和方法
    				$("#frm").attr("action" , "${pageContext.request.contextPath}/seller.do");
    				$("#method").attr("value" , "findBackPassword");
    			}
    			//提交表单
    			frm.submit();
	    	}
    	
    	
    	});
    </script>
  </body>
</html>
