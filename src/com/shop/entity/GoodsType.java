package com.shop.entity;

import java.io.Serializable;

/**
 * 商品类型实体类
 * @author 尹平
 *
 */
public class GoodsType implements Serializable{
	//1类型编号
	private Long goodsType_id;
	//2类型名称
	private String goodsType_name;
	//3类型上级编号
	private Long goodsType_Upid;
	
	public Long getGoodsType_id() {
		return goodsType_id;
	}
	public void setGoodsType_id(Long goodsType_id) {
		this.goodsType_id = goodsType_id;
	}
	public String getGoodsType_name() {
		return goodsType_name;
	}
	public void setGoodsType_name(String goodsType_name) {
		this.goodsType_name = goodsType_name;
	}
	public Long getGoodsType_Upid() {
		return goodsType_Upid;
	}
	public void setGoodsType_Upid(Long goodsType_Upid) {
		this.goodsType_Upid = goodsType_Upid;
	}
	@Override
	public String toString() {
		return "GoodsType [goodsType_id=" + goodsType_id + ", goodsType_name="
				+ goodsType_name + ", goodsType_Upid=" + goodsType_Upid + "]";
	}
	 
	
}
