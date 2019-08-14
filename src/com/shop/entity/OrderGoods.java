package com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderGoods implements Serializable{
	//1订单id
	private Long order_id ;
	//2商品id
	private Long goods_id;
	//3商品描述
	private String goods_desception;
	//4商品图片
	private String goods_img;
	//5.商品数量
	private Long goods_number;
	//6.商品单价
	private Long goods_price ;
	//7商品折扣
	private Double goods_count;
	//8是否支付
	private Long ordergoods_checkPay;
	//9支付时间
	private Date ordergoods_payTime;
	@Override
	public String toString() {
		return "OrderGoods [order_id=" + order_id + ", goods_id=" + goods_id
				+ ", goods_desception=" + goods_desception + ", goods_img="
				+ goods_img + ", goods_number=" + goods_number
				+ ", goods_price=" + goods_price + ", goods_count="
				+ goods_count + ", ordergoods_checkPay=" + ordergoods_checkPay
				+ ", ordergoods_payTime=" + ordergoods_payTime
				+ ", ordergoods_comment=" + ordergoods_comment
				+ ", ordergoods_shopsend=" + ordergoods_shopsend
				+ ", ordergoods_customget=" + ordergoods_customget
				+ ", ordergoods_customback=" + ordergoods_customback
				+ ", ordergoods_shopget=" + ordergoods_shopget
				+ ", shop_address=" + shop_address + ", custom_address="
				+ custom_address + ", shop_name=" + shop_name
				+ ", custom_name=" + custom_name + ", goods_allprice="
				+ goods_allprice + "]";
	}
	//10买家是否评价
	private Long ordergoods_comment ;
	//11.是否发货
	private Long ordergoods_shopsend;
	//12买家是否收货/交易是否成功
	private Long ordergoods_customget;
	//13买家是否退货
	private Long ordergoods_customback;
	//14卖家是否确认退货/退货成功
	private Long ordergoods_shopget; 
	//15发货地址
	private String shop_address ;
	//16收货地址
	private String custom_address ;
	//17发货人名字
	private String shop_name ;
	//18收货人名字
	private String custom_name ;
	//商品总价
	private Double goods_allprice;
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_desception() {
		return goods_desception;
	}
	public void setGoods_desception(String goods_desception) {
		this.goods_desception = goods_desception;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public Long getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(Long goods_number) {
		this.goods_number = goods_number;
	}
	public Long getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Long goods_price) {
		this.goods_price = goods_price;
	}
	public Double getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(Double goods_count) {
		this.goods_count = goods_count;
	}
	public Long getOrdergoods_checkPay() {
		return ordergoods_checkPay;
	}
	public void setOrdergoods_checkPay(Long ordergoods_checkPay) {
		this.ordergoods_checkPay = ordergoods_checkPay;
	}
	public Date getOrdergoods_payTime() {
		return ordergoods_payTime;
	}
	public void setOrdergoods_payTime(Date ordergoods_payTime) {
		this.ordergoods_payTime = ordergoods_payTime;
	}
	public Long getOrdergoods_comment() {
		return ordergoods_comment;
	}
	public void setOrdergoods_comment(Long ordergoods_comment) {
		this.ordergoods_comment = ordergoods_comment;
	}
	public Long getOrdergoods_shopsend() {
		return ordergoods_shopsend;
	}
	public void setOrdergoods_shopsend(Long ordergoods_shopsend) {
		this.ordergoods_shopsend = ordergoods_shopsend;
	}
	public Long getOrdergoods_customget() {
		return ordergoods_customget;
	}
	public void setOrdergoods_customget(Long ordergoods_customget) {
		this.ordergoods_customget = ordergoods_customget;
	}
	public Long getOrdergoods_customback() {
		return ordergoods_customback;
	}
	public void setOrdergoods_customback(Long ordergoods_customback) {
		this.ordergoods_customback = ordergoods_customback;
	}
	public Long getOrdergoods_shopget() {
		return ordergoods_shopget;
	}
	public void setOrdergoods_shopget(Long ordergoods_shopget) {
		this.ordergoods_shopget = ordergoods_shopget;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getCustom_address() {
		return custom_address;
	}
	public void setCustom_address(String custom_address) {
		this.custom_address = custom_address;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getCustom_name() {
		return custom_name;
	}
	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}
	public Double getGoods_allprice() {
		return goods_allprice;
	}
	public void setGoods_allprice(Double goods_allprice) {
		this.goods_allprice = goods_allprice;
	}
	
	
	
}
