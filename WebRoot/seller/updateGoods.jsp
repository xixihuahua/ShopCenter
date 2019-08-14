<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${goods.goods_Desception }商品修改</title>
    
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
  			
  		<!-- 待完成 -->
  		<form>
  			  商品图片<input name="Goods_Img" value="${goods.goods_Img }">
  			 <button id="btn_img">上传商品图片</button>
  		</form>
  		${shop_id}
     <form id = "frm" action="${pageContext.request.contextPath}/goods.do" method="post" >
    		  <input  name="method" value = "updateGoods" type= "hidden">
    		 
    		   <input  name="shop_id" value ="${param.shop_id}"  type= "hidden">
    		  
			     商品类型<select id = "first" name="first"></select>
						    	<select id = "second" name="second">
						    		<option>请选择二级类型</option>
						    	</select>
						    	<select id = "third" name="third">
						    		<option>"请选择三级类型"</option>
						    	</select> <br>
			     //   商品库存 <input name= "goods_Repertory" type="number" value="${goods.goods_Repertory }"><br>
			     //   商品描述  <input name="goods_Desception" value="${goods.goods_Desception }"><br>
				//商品进价 <input name="goods_InputPrice" type="number" value="${goods.goods_InputPrice}"><br>
			//	商品售价<input name="goods_OutputPrice" type="number" value="${goods.goods_OutputPrice}"><br>
				// 商品折扣<input name="goods_count" type = "number" value="${goods.goods_Count }"><br>
				 商品状态<select id = "status" name="goods_status">
						 <option>上架</option>
						 <option>下架</option>
					   </select>				 
		  </form>
		   <button id = "btn">提交</button>
		   <button id = "shop_id">shop_id</button>
		   
		   
		     <script type="text/javascript" src="js/jquery.min.js"></script>
    		<script type="text/javascript">
    				 
    						  
    				 
    				$("#btn").click(function(){
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
    					
    					if(third == null){
    						if(second == null){
    							if(first == null){
    								$("#third").attr("third", "其他");
    							}else{
    							 $("#third").attr("third", first);
    							}
    					
    						}else{
    							$("#third").attr("third", second);
    						}
    					}else{
    						$("#third").attr("third", third);
    					}
    				
    					 frm.submit();
    					 
    				});
    		  /*商品三级联动开始*/
    			$.post("xml/goodsType.xml",function(data){
    				$("#first").empty();
    				$(data).find("first").each(function(){
    					var first = $(this).attr("name");
    					$("#first").append("<option>"+first+"</option>");
    				 });
    			},"xml");
    			
    			$("#first").change(function(){
    				$("#second").empty();
    				$.post("xml/goodsType.xml",function(data){
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
    				$.post("xml/goodsType.xml",function(data){
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
