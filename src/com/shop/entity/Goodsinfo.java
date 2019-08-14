package com.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品实体类
 *
 */
public class Goodsinfo implements Serializable {
	//1商品编号
	private Long goods_id;
	//2店铺id
	private Long shop_id;
	//3店铺商品类型编号
	private Long goodsType_id;
	private String goodsType_name;
	//4商品描述
	private	String goods_Desception ;
	//5商品库存
	private Long goods_Repertory;
	//6商品售量
	private Long goods_SellCount;
	//7商品图片 
	private String goods_Img;
	//8.商品进价
	private Double goods_InputPrice;
	//9.商品售价
	private Double goods_OutputPrice;
	//10商品折扣
	private Double goods_Count;
	//11.商品状态
	private String goods_Status;
	//12.商品上架时间
	private Date goods_time;
	//13.商品仓库地址
	private String shop_address;

	//14.店铺家名
	private String shop_name;
	//15卖家名
	private String seller_name;
	//16联系卖家  卖家电话
	private Long seller_tel;
	
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public Long getShop_id() {
		return shop_id;
	}
	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}
	public Long getGoodsType_id() {
		return goodsType_id;
	}
	public void setGoodsType_id(Long goodsType_id) {
		this.goodsType_id = goodsType_id;
	}
	public String getGoods_Desception() {
		return goods_Desception;
	}
	public void setGoods_Desception(String goods_Desception) {
		this.goods_Desception = goods_Desception;
	}
	public Long getGoods_Repertory() {
		return goods_Repertory;
	}
	public void setGoods_Repertory(Long goods_Repertory) {
		this.goods_Repertory = goods_Repertory;
	}
	public Long getGoods_SellCount() {
		return goods_SellCount;
	}
	public void setGoods_SellCount(Long goods_SellCount) {
		this.goods_SellCount = goods_SellCount;
	}
	public String getGoods_Img() {
		return goods_Img;
	}
	public void setGoods_Img(String goods_Img) {
		this.goods_Img = goods_Img;
	}
	public Double getGoods_InputPrice() {
		return goods_InputPrice;
	}
	public void setGoods_InputPrice(Double goods_InputPrice) {
		this.goods_InputPrice = goods_InputPrice;
	}
	public Double getGoods_OutputPrice() {
		return goods_OutputPrice;
	}
	public void setGoods_OutputPrice(Double goods_OutputPrice) {
		this.goods_OutputPrice = goods_OutputPrice;
	}
	public Double getGoods_Count() {
		return goods_Count;
	}
	public void setGoods_Count(Double goods_Count) {
		this.goods_Count = goods_Count;
	}
	public String getGoods_Status() {
		return goods_Status;
	}
	public void setGoods_Status(String goods_Status) {
		this.goods_Status = goods_Status;
	}
	public Date getGoods_time() {
		return goods_time;
	}
	public void setGoods_time(Date goods_time) {
		this.goods_time = goods_time;
	}
	@Override
	public String toString() {
		return "Goodsinfo [goods_id=" + goods_id + ", shop_id=" + shop_id
				+ ", goodsType_id=" + goodsType_id + ", goodsType_name="
				+ goodsType_name + ", goods_Desception=" + goods_Desception
				+ ", goods_Repertory=" + goods_Repertory + ", goods_SellCount="
				+ goods_SellCount + ", goods_Img=" + goods_Img
				+ ", goods_InputPrice=" + goods_InputPrice
				+ ", goods_OutputPrice=" + goods_OutputPrice + ", goods_Count="
				+ goods_Count + ", goods_Status=" + goods_Status
				+ ", goods_time=" + goods_time + ", shop_address="
				+ shop_address + ", shop_name=" + shop_name + ", seller_name="
				+ seller_name + ", seller_tel=" + seller_tel + "]";
	}
	/**
	 * @return the shop_address
	 */
	public String getShop_address() {
		return shop_address;
	}
	/**
	 * @param shop_address the shop_address to set
	 */
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
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
	 * @return the seller_tel
	 */
	public Long getSeller_tel() {
		return seller_tel;
	}
	/**
	 * @param seller_tel the seller_tel to set
	 */
	public void setSeller_tel(Long seller_tel) {
		this.seller_tel = seller_tel;
	}
	/**
	 * @return the goodsType_name
	 */
	public String getGoodsType_name() {
		return goodsType_name;
	}
	/**
	 * @param goodsType_name the goodsType_name to set
	 */
	public void setGoodsType_name(String goodsType_name) {
		this.goodsType_name = goodsType_name;
	}
	 
	 
	 
 
	
}
