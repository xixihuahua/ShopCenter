package com.shop.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 买家实体类
 *
 */
public class Custominfo implements Serializable{
	private Long custom_id; //用户编号
	private String custom_name; //用户名
	private String custom_password; //用户密码
	private String custom_sex;//性别
	private Long custom_age;//年龄
	private String custom_tel;//电话
	private String  custom_address;//地址
	private String custom_img;//头像
	private Date custom_regtime;//注册时间
	private String custom_email;//用户邮箱
	private String custom_paypwd;//用户支付密码
	private Long custom_level = 1l ; //买家等级
	private Double custom_money ;
	public Long getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(Long custom_id) {
		this.custom_id = custom_id;
	}
	public String getCustom_name() {
		return custom_name;
	}
	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}
	public String getCustom_password() {
		return custom_password;
	}
	public void setCustom_password(String custom_password) {
		this.custom_password = custom_password;
	}
	public String getCustom_sex() {
		return custom_sex;
	}
	public void setCustom_sex(String custom_sex) {
		this.custom_sex = custom_sex;
	}
	public Long getCustom_age() {
		return custom_age;
	}
	public void setCustom_age(Long custom_age) {
		this.custom_age = custom_age;
	}
	public String getCustom_tel() {
		return custom_tel;
	}
	public void setCustom_tel(String custom_tel) {
		this.custom_tel = custom_tel;
	}
	public String getCustom_address() {
		return custom_address;
	}
	public void setCustom_address(String custom_address) {
		this.custom_address = custom_address;
	}
	public String getCustom_img() {
		return custom_img;
	}
	public void setCustom_img(String custom_img) {
		this.custom_img = custom_img;
	}
	public Date getCustom_regtime() {
		return custom_regtime;
	}
	public void setCustom_regtime(Date custom_regtime) {
		this.custom_regtime = custom_regtime;
	}
	public String getCustom_email() {
		return custom_email;
	}
	public void setCustom_email(String custom_email) {
		this.custom_email = custom_email;
	}
	public String getCustom_paypwd() {
		return custom_paypwd;
	}
	public void setCustom_paypwd(String custom_paypwd) {
		this.custom_paypwd = custom_paypwd;
	}
	public Long getCustom_level() {
		return custom_level;
	}
	public void setCustom_level(Long custom_level) {
		this.custom_level = custom_level;
	}
	public Double getCustom_money() {
		return custom_money;
	}
	public void setCustom_money(Double custom_money) {
		this.custom_money = custom_money;
	}
	@Override
	public String toString() {
		return "Custominfo [custom_id=" + custom_id + ", custom_name="
				+ custom_name + ", custom_password=" + custom_password
				+ ", custom_sex=" + custom_sex + ", custom_age=" + custom_age
				+ ", custom_tel=" + custom_tel + ", custom_address="
				+ custom_address + ", custom_img=" + custom_img
				+ ", custom_regtime=" + custom_regtime + ", custom_email="
				+ custom_email + ", custom_paypwd=" + custom_paypwd
				+ ", custom_level=" + custom_level + ", custom_money="
				+ custom_money + "]";
	}
	 
	 
	
}
