<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 

<!DOCTYPE HTML>
<html>
  <head>
     
    
    <title>用户评价</title>
    
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
	
	
	<script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
	
    
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    
	
  </head>
  
  <body>
     	 
      <form id="frm" name="frm" action="${pageContext.request.contextPath}/comment.do" method="post">
		  	<!-- 如果是get方法可以直接在action后用?连接 -->
		  	<input type="hidden" name="method" value="addComment">
		  	 商品id :
		  	<input  name="goods_id"  value="${param.goods_id}" readonly ></input>
		  	 订单id :
		  	<input  name="order_id" value="${param.order_id}" readonly ></input><br>
		  	 
		  	<hr>
		  	评论内容：
		     <script id="myeditor" name="comment_content"   type="text/plain" style="width:100%;height:500px;">
			</script>
	  </form>
    	 <button id="btn">提交评论</button>
	 	 <script type="text/javascript">
				   //加载编辑器
		    var ue = UE.getEditor('myeditor');
		    document.getElementById("btn").onclick = function(){
		    	 document.getElementById("myeditor").value = ue.getContent();
		    	 frm.submit();
		    };
	  </script> 
  </body>
</html>
