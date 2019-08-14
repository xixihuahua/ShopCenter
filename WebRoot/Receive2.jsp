<%@page contentType="text/html; charset=utf-8" import="java.util.*" language="java"%>
<%@page import="java.util.*,java.sql.*,com.shop.util.DBUtil" %>
<%@page import="org.apache.commons.dbutils.QueryRunner" %>
<%@page import="com.shop.entity.*"  %>
<%
	request.setCharacterEncoding("utf-8");
	String orderid = request.getParameter("orderid");		// 订单号
	
	
	
%>

订单号：<%=orderid%> 成功充值