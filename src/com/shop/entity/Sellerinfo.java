package com.shop.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 卖家实体类
 *
 */
public class Sellerinfo implements Serializable{
	private Long seller_id; //1用户编号
	private String seller_name;//2用户名
	private String seller_password;//3用户密码
	private String seller_sex;//4性别
	private Long seller_age;//5年龄
	private String  seller_tel;//6电话
	private String seller_address;//7商家住址地址
	private String  seller_img ;//8用户头像地址
	private Date  seller_regtime;//9注册时间
	private String seller_email;//10商家绑定邮箱
	
	public Long getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Long seller_id) {
		this.seller_id = seller_id;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getSeller_password() {
		return seller_password;
	}
	public void setSeller_password(String seller_password) {
		this.seller_password = seller_password;
	}
	public String getSeller_sex() {
		return seller_sex;
	}
	public void setSeller_sex(String seller_sex) {
		this.seller_sex = seller_sex;
	}
	public Long getSeller_age() {
		return seller_age;
	}
	public void setSeller_age(Long seller_age) {
		this.seller_age = seller_age;
	}
	public String getSeller_tel() {
		return seller_tel;
	}
	public void setSeller_tel(String seller_tel) {
		this.seller_tel =  seller_tel;
	}
	public String getSeller_address() {
		return seller_address;
	}
	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}
	public String getSeller_img() {
		return seller_img;
	}
	public void setSeller_img(String seller_img) {
		this.seller_img = seller_img;
	}
	public Date getSeller_regtime() {
		return seller_regtime;
	}
	public void setSeller_regtime(Date seller_regtime) {
		this.seller_regtime = seller_regtime;
	}
	@Override
	public String toString() {
		return "Sellerinfo [seller_id=" + seller_id + ", seller_name="
				+ seller_name + ", seller_password=" + seller_password
				+ ", seller_sex=" + seller_sex + ", seller_age=" + seller_age
				+ ", seller_tel=" + seller_tel + ", seller_address="
				+ seller_address + ", seller_img=" + seller_img
				+ ", seller_regtime=" + seller_regtime + ", seller_email="
				+ seller_email + "]";
	}
	/**
	 * @return the seller_email
	 */
	public String getSeller_email() {
		return seller_email;
	}
	/**
	 * @param seller_email the seller_email to set
	 */
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	
	
}
