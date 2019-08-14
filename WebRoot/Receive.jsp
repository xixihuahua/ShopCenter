<%@page import="org.apache.commons.dbutils.handlers.BeanHandler"%>
<%@page contentType="text/html; charset=utf-8" import="java.util.*" language="java"%>
<%@page import="java.util.*,java.sql.*,com.shop.util.DBUtil" %>
<%@page import="org.apache.commons.dbutils.QueryRunner" %>
<%@page import="com.shop.entity.*"  %>
<%
	request.setCharacterEncoding("utf-8");
	String orderid = request.getParameter("orderid");		// 订单号
	
	String price = request.getParameter("realprice");		// 订单号
	
	System.out.println("成功充值金额:  "+ price);
	
	//在这个充值状态的返回页面  取到充值的订单号之后  把订单号的状态改为充值成功
	Custominfo custom = (Custominfo)session.getAttribute("customer");
	HashMap<String,String> payInfo = 
		(HashMap<String,String>)session.getAttribute("payInfo");
	Long payMoney = new Long(payInfo.get(orderid));
	
	QueryRunner qr =  new QueryRunner();
	Connection conn = DBUtil.getConn();
	
	String sql="update custominfo set custom_money = custom_money+? where custom_id = ?";
	
	int num = qr.update(conn,sql,payMoney,custom.getCustom_id());
	if(num>0){
		custom.setCustom_money(custom.getCustom_money()+payMoney);
		session.setAttribute("customer", custom);
		response.getWriter().write("充值成功");
	}else{
		response.getWriter().write("充值失败");
	}
	
	if(conn != null){
		conn.close();
	}
	
	
%>

订单号：<%=orderid%> 成功充值：