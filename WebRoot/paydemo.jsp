<%@ page language="java" import="java.util.*,com.shop.util.MD5Util" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>充值</title>
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
  	<%!
  		public String getOrderID(){
  			return "" + System.currentTimeMillis() + new Random().nextInt(900000000)+100000000;
  		}
  		
  		public String getKey(Map<String, String> remoteMap) {
  			//密钥
  			String TOKEN = "9e28b2e3a03aeb2d41806ceb580f3294";
  			String key = "";
  			//链接请求参数
			if (null != remoteMap.get("goodsname")) {
				key += remoteMap.get("goodsname");
			}
			if (null != remoteMap.get("istype")) {
				key += remoteMap.get("istype");
			}
			if (null != remoteMap.get("notify_url")) {
				key += remoteMap.get("notify_url");
			}
			if (null != remoteMap.get("orderid")) {
				key += remoteMap.get("orderid");
			}
			if (null != remoteMap.get("orderuid")) {
				key += remoteMap.get("orderuid");
			}
			if (null != remoteMap.get("price")) {
				key += remoteMap.get("price");
			}
			if (null != remoteMap.get("return_url")) {
				key += remoteMap.get("return_url");
			}
			key += TOKEN;
			if (null != remoteMap.get("uid")) {
				key += remoteMap.get("uid");
			}
			//对请求参数进行md5加密
			return MD5Util.encryption(key);
		}
  	 %>
  
    <%	
    	//创建请求参数
    	String uid = "b291833b638e482d40843b14";
    	/*存数据库  的待充值金额*/
    	String price = request.getParameter("paymoney");
    	String istype = request.getParameter("payWay");
    	String notify_url = "http://localhost:8088/shopCenter/Receive.jsp";
    	String return_url = "http://localhost:8088/shopCenter/Receive.jsp";
    	/*存数据库 对应的订单号*/
    	String orderid = getOrderID();
    	
    	
    	
    	HashMap<String,String> paymap = new HashMap<String,String>();
    	paymap.put(orderid, price);
    	session.setAttribute("payInfo", paymap);
    	
    	
    	//将请求参数设置到map中
    	HashMap<String,String> map = new HashMap<String,String>();
    	map.put("uid", uid);
    	map.put("price", price);
    	map.put("istype", istype);
    	map.put("notify_url", notify_url);
    	map.put("return_url", return_url);
    	map.put("orderid", orderid);
    	//获取key
    	String key = getKey(map);
     %>
     
     <form id="frm" name="frm" action="https://pay.bbbapi.com" method="post">
     	<input type="hidden" name="uid" value="<%=uid%>">
     	<input type="hidden" name="price" value="<%=price%>">
     	<input type="hidden" name="istype" value="<%=istype%>">
     	<input type="hidden" name="notify_url" value="<%=notify_url%>">
     	<input type="hidden" name="return_url" value="<%=return_url%>">
     	<input type="hidden" name="orderid" value="<%=orderid%>">
     	<input type="hidden" name="key" value="<%=key%>">
     </form>
     
     <script type="text/javascript" src="js/jquery.min.js"></script>
     <script type="text/javascript">
     	$("#frm").submit();
     </script>
  </body>
</html>
