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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 				 <select id = "reg">
	 				 <option>买家注册</option>
	 				 <option>卖家注册</option>
 				 </select>
 			 <form id = "frm" action="${pageContext.request.contextPath}/custom.do" method="post" >
    		  <input id = "method" name="method" value = "customReg" type= "hidden"> 
			     1. 用户名 :<input id="name" name = "name"><span id="nameError"></span><br>
			     2. 密码 : <input id="password" name = "password" placeholder="密码请以字母开头"><span id="pwdError" ></span><br>
			     3. 性别：  <label>
		    			<input type="radio" name="sex" value="0" checked required/> 男  
		    			</label>
		    			<label for="sex1"><input type="radio" id="sex1" name="sex" value="1" required/> 女</label> <br>
			      4.年龄 : <input  type="number" id="age" name="age" max="130" min="18"  ><span id="ageError"></span><br>
			      5.联系方式 : <input id="tel" name = "tel" > <span id="telError"></span><br>    
			      6.收货地址 : <select id = "province" name="provice"></select>
					    	<select id = "city" name="city">
					    		<option>请选择市</option>
					    	</select>
					    	<Select id = "area" name="area">
					    		<option>"请选择区"</option>
					    	</Select>   
					    	<input name="street" placeholder = "请输入具体街道">  <br> 
			       8.电子邮箱：<input id="email" type="email" name="email" ><span id="emailError"></span><br>
			    
			       验证码	<input id="vali" name = "imageCode" style = "height:30px;">
			       <img id="imageCode" title="看不清换一张" style="height: 30px;vertical-align: middle;cursor: pointer;" width="200" height="30" 
			       src="${pageContext.request.contextPath}/vali.do?method=imageValidation"><br>
    	<br>
			       
         </form>
          
         <button id = "btn">注册</button>
          
         
    		<script type="text/javascript" src="js/jquery.min.js"></script>
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
				if(nameRegs.test( name) ){
					var reg =$("#reg option:selected").text();
	    			if(reg == "卖家注册"){ //如果选择卖家登陆
	    					$.post("${pageContext.request.contextPath}/seller.do",{"method":"findSellerByNa","name":name},function(result){
    				 		 if(result == "同名"){
    				 			$("#nameError").html("存在同名用户");
    				 		}else{
    				 			 nameFlag = true ;
    				 			 alert(name);
		                        $("#nameError").html("");
    				 		}
    				     });
	    			}else{
	    				$.post("${pageContext.request.contextPath}/custom.do",{"method":"findCustomByNa","name":name},function(result){
    				 		 if(result == "同名"){
    				 			$("#nameError").html("存在同名用户");
    				 		}else{
    				 			 nameFlag = true ;
    				 			  alert(name);
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
						        alert(pwdFlag);
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
					        alert(emailFlag);
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
    			//提交表单
    			if(nameFlag&&pwdFlag&&ageFlag&&telFlag&&emailFlag){
    				frm.submit();
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
    			
    		 
    		</script>
      
  </body>
</html>
