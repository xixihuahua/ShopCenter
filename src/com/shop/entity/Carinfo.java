package com.shop.entity;

import java.io.Serializable;

public class Carinfo implements Serializable{
	//1.购物车id
	private Long car_ID ;
	//2.商品id
	private Long goods_id ;
	//3.商品名称
	private String goods_name;
	//4.商品图片
	private String Goods_Img;
	//4.商品数量
	private Long carGoods_number;
	//5.店铺id
	private Long shop_id ;
	//6.商品描述
	private String goods_desception ;
	//7.用户id
	private Long custom_id;
	//8.商品单价
	private Double goods_OutputPrice;
	//9.商品折扣
	private Double goods_count;
	//10.店铺名字
	private String shop_name;
	public Long getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(Long custom_id) {
		this.custom_id = custom_id;
	}
	public Double getGoods_OutputPrice() {
		return goods_OutputPrice;
	}
	public void setGoods_OutputPrice(Double goods_OutputPrice) {
		this.goods_OutputPrice = goods_OutputPrice;
	}
	public Long getCar_ID() {
		return car_ID;
	}
	public void setCar_ID(Long car_ID) {
		this.car_ID = car_ID;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public Long getCarGoods_number() {
		return carGoods_number;
	}
	public void setCarGoods_number(Long carGoods_number) {
		this.carGoods_number = carGoods_number;
	}
	public Long getShop_id() {
		return shop_id;
	}
	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
	public String getGoods_desception() {
		return goods_desception;
	}
	public void setGoods_desception(String goods_desception) {
		this.goods_desception = goods_desception;
	}
	@Override
	public String toString() {
		return "Carinfo [car_ID=" + car_ID + ", goods_id=" + goods_id
				+ ", goods_name=" + goods_name + ", Goods_Img=" + Goods_Img
				+ ", carGoods_number=" + carGoods_number + ", shop_id="
				+ shop_id + ", goods_desception=" + goods_desception
				+ ", custom_id=" + custom_id + ", goods_OutputPrice="
				+ goods_OutputPrice + ", goods_count=" + goods_count
				+ ", shop_name=" + shop_name + "]";
	}
	/**
	 * @return the goods_name
	 */
	public String getGoods_name() {
		return goods_name;
	}
	/**
	 * @param goods_name the goods_name to set
	 */
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	/**
	 * @return the goods_Img
	 */
	public String getGoods_Img() {
		return Goods_Img;
	}
	/**
	 * @param goods_Img the goods_Img to set
	 */
	public void setGoods_Img(String goods_Img) {
		Goods_Img = goods_Img;
	}
	/**
	 * @return the goods_count
	 */
	public Double getGoods_count() {
		return goods_count;
	}
	/**
	 * @param goods_count the goods_count to set
	 */
	public void setGoods_count(Double goods_count) {
		this.goods_count = goods_count;
	}
	/**
	 * @return the shop_name
	 */
	public String getShop_name() {
		return shop_name;
	}
	/**
	 * @param shop_name the shop_name to set
	 */
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	
}
