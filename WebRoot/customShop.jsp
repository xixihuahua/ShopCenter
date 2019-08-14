<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    
    <title>${shop.shop_name}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pagination.css">
	<style>
	.img{
	width:50px;}
	</style>
  </head>
  
  <body>
       
     	<span>${customer.custom_name}  欢迎来到   ${shop.shop_name}</span> 
     	
     	<!-- 用户显示文字列表 -->
     	<table>
     	<thead>
     		<tr>
	     		 
	     		<th>商品id</th>
	     		<th>商品名</th>
	     		<th>商品图片</th>
	     		<th>商品售价</th>
	     		<th>商品折扣</th>
	     		<th>商品状态</th>
	     		<th>商品销量</th>
	     		 
     		</tr>
     	 </thead>
     	 <tbody id="main">
     	 
     	 </tbody>
     	</table>
	  	 <br><br>
	  	<!-- 用来显示上一页和下一页 -->
	  	<div id="Pagination"></div>
	  	
	  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
  	    
	  	<script type="text/javascript">
	  	 //定义一页显示多少个
   		var pageSize = 2;
   		var shop_id = ${shop.shop_id} ;
   		 
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
		         num_edge_entries: 2        //省略号两边的页数
		     }); 
    	});
    	
    	function PageCallback(pageIndex,jq){
	    	$.post("goods.do",{"method":"ajaxPage","currentPage":pageIndex,"pageSize":pageSize,"shop_id":shop_id},function(list){
	    		//获取到数据之后先清除之前的内容
	    		$("#main").empty();
	    		$(list).each(function(){
	    			$("#main").append("<tr>"+
	    			  "<td>"+this.goods_id+"</td>"+
	    			  "<td><a href='goods.do?method=findGoodsById&goods_id="+this.goods_id+"'>"+this.goods_Desception+"</a></td>"+
	    			  "<td><img class='img' alt='无' src='${pageContext.request.contextPath}/"+this.goods_Img+"'></td>" + 
	    			   "<td>"+this.goods_OutputPrice+"</td>"+
	    			   "<td>"+this.goods_Count+"</td>"+
	    			    "<td>"+this.goods_Status+"</td>"+
	    				"<td>"+this.goods_SellCount+"</td>"+
	    			 	 "<td><a id='car' href='${pageContext.request.contextPath}/car.do?method=addCar&goods_id="+this.goods_id+"'>添加购物车</a></td>"+
	    				//"<td><button id='car'>加入购物车</button></td>"+
	    			 "</tr>");
	    		});
	    	},"json");
    	}
    	//调用函数显示第一页的数据
    	PageCallback(0);
    	
    	 $("#car").click(function(){
    	 
    	 
    	 });
   	</script>
  </body>
</html>
