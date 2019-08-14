package com.shop.entity;

import java.util.Date;

public class Commentinfo {
	private Long Comment_id ; 	//1评论编号id
	private Long Custom_id ;	//2买家id
	private Long Goods_id;	//3商品id
	private Date Comment_time ;//4	评论时间
	private Long Order_id	;//5订单id
	private String Comment_content	;//6评论内容
	public Long getComment_id() {
		return Comment_id;
	}
	public void setComment_id(Long comment_id) {
		Comment_id = comment_id;
	}
	 
	public Long getGoods_id() {
		return Goods_id;
	}
	public void setGoods_id(Long goods_id) {
		Goods_id = goods_id;
	}
	public Date getComment_time() {
		return Comment_time;
	}
	public void setComment_time(Date comment_time) {
		Comment_time = comment_time;
	}
	public Long getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(Long order_id) {
		Order_id = order_id;
	}
	public String getComment_content() {
		return Comment_content;
	}
	public void setComment_content(String comment_content) {
		Comment_content = comment_content;
	}
	public Long getCustom_id() {
		return Custom_id;
	}
	public void setCustom_id(Long custom_id) {
		Custom_id = custom_id;
	}
	@Override
	public String toString() {
		return "Commentinfo [Comment_id=" + Comment_id + ", Custom_id="
				+ Custom_id + ", Goods_id=" + Goods_id + ", Comment_time="
				+ Comment_time + ", Order_id=" + Order_id
				+ ", Comment_content=" + Comment_content + "]";
	}
  
	 

	 
}
