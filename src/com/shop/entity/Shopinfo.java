package com.shop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺实体类
 * @author 尹平
 *
 */
public class Shopinfo implements Serializable {
	//1店铺编号
	private Long shop_id;
	//2店铺名字
	private String shop_name;
	//3商家id
	private Long seller_id;
	//4商家名字
	private String seller_name;
	//5头像
	private String shop_img;
	//6仓库地址
	private String shop_address;
	//7店铺注册时间
	private Date shop_regtime;
	//8.店铺等级
	private Long shop_level ;
	//9.店铺商品数
	private Long shop_goods;
	//10.店铺总销量
	private Long shop_sellcount;
	
	public Long getShop_id() {
		return shop_id;
	}
	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public Long getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Long seller_id) {
		this.seller_id = seller_id;
	}
	public String getShop_img() {
		return shop_img;
	}
	public void setShop_img(String shop_img) {
		this.shop_img = shop_img;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public Date getShop_regtime() {
		return shop_regtime;
	}
	public void setShop_regtime(Date shop_regtime) {
		this.shop_regtime = shop_regtime;
	}
	public Long getShop_level() {
		return shop_level;
	}
	public void setShop_level(Long shop_level) {
		this.shop_level = shop_level;
	}
	@Override
	public String toString() {
		return "Shopinfo [shop_id=" + shop_id + ", shop_name=" + shop_name
				+ ", seller_id=" + seller_id + ", seller_name=" + seller_name
				+ ", shop_img=" + shop_img + ", shop_address=" + shop_address
				+ ", shop_regtime=" + shop_regtime + ", shop_level="
				+ shop_level + ", shop_goods=" + shop_goods
				+ ", shop_sellcount=" + shop_sellcount + "]";
	}
	/**
	 * @return the seller_name
	 */
	public String getSeller_name() {
		return seller_name;
	}
	/**
	 * @param seller_name the seller_name to set
	 */
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	/**
	 * @return the shop_goods
	 */
	public Long getShop_goods() {
		return shop_goods;
	}
	/**
	 * @param shop_goods the shop_goods to set
	 */
	public void setShop_goods(Long shop_goods) {
		this.shop_goods = shop_goods;
	}
	/**
	 * @return the shop_sellcount
	 */
	public Long getShop_sellcount() {
		return shop_sellcount;
	}
	/**
	 * @param shop_sellcount the shop_sellcount to set
	 */
	public void setShop_sellcount(Long shop_sellcount) {
		this.shop_sellcount = shop_sellcount;
	}
	 
}
