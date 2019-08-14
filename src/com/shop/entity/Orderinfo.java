package com.shop.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 订单实体类
 *
 */
public class Orderinfo implements Serializable {
	//1订单编号
	private Long order_id;
	//2商品总价
	private Long order_allprice;
	//3买家用户编号
	private Long custom_id;
	 //4提交时间
	private Date order_Time;
	 //5商品数量
	private Long order_number;
	
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getOrder_allprice() {
		return order_allprice;
	}
	public void setOrder_allprice(Long order_allprice) {
		this.order_allprice = order_allprice;
	}
	public Long getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(Long custom_id) {
		this.custom_id = custom_id;
	}
	 
	public Long getOrder_number() {
		return order_number;
	}
	public void setOrder_number(Long order_number) {
		this.order_number = order_number;
	}
	public Date getOrder_Time() {
		return order_Time;
	}
	public void setOrder_Time(Date order_Time) {
		this.order_Time = order_Time;
	}
	@Override
	public String toString() {
		return "Orderinfo [order_id=" + order_id + ", order_allprice="
				+ order_allprice + ", custom_id=" + custom_id + ", order_Time="
				+ order_Time + ", order_number=" + order_number + "]";
	}
	 
	
 
	
	
	 
 
}
