package com.shop.Dao;

import java.util.List;

import com.shop.entity.Custominfo;

public interface ICustomDao {
	
	/**
	 * 根据用户id 查用户信息
	 * @param custom_id
	 * @return
	 */
	public Custominfo findCustomById(Long custom_id);
	

	/**
	 * 通过买家名查找用户
	 * 登陆
	 * @param Custom_name Custom_password
	 * @return
	 */
	public Custominfo findCustomByName(String custom_name,String custom_password); 
	/**
	 * 通过买家id查找用户
	 * 登陆
	 * @param  Custom_id Custom_password
	 * @return
	 */
	public Custominfo findCustomById(Long custom_id ,String custom_password); 
	
     /**
	 * 根据买家id 
	 * @param custom_id
	 * @return
	 */
	public Custominfo findById(Long custom_id);
	
	/**
	 * 根据买家名字
	 * @param custom_name
	 * @return
	 */
	public Custominfo findByName(String custom_name);
	
	
	/**
	 * 添加买家 （用户注册）
	 * @param Custom
	 * @return
	 */
	public int addCustom(Custominfo custom);
	/**
	 * 更新买家信息 (修改用户信息,除了用户头像，支付密码)
	 * @param Custom
	 * @return
	 */
	public int updateCustom(Custominfo custom);	
	 
	/**
	 * 更新买家 绑定的手机
	 * @param custom
	 * @return
	 */
	public int updateCustomTel(Long custom_id , String custom_tel);	
	
	/**
	 * 更新买家 头像
	 * @param custom
	 * @return
	 */
	public int updateCustomImg(Long custom_id , String custom_img);	
	
	
	/**
	 * 更新买家支付密码
	 * @param custom
	 * @return
	 */
	public int updateCustomPayPwd(Long custom_id , String custom_paypwd);	
	
	/**
	 * 删除用户（注销账号）
	 * @param custom_id
	 * @return
	 */
	public int deleteCustom(Long custom_id);
	
	
	/**
	 * 根据账号id和邮箱修改密码
	 * @param custom_id
	 * @param custom_email
	 * @return
	 */
	public int updateCustomPwd(String custom_password,Long custom_id,String custom_email);
	/**
	 * 根据账号名和邮箱修改密码
	 * @param custom_name
	 * @param custom_email
	 * @return
	 */
	public int updateCustomPwd(String custom_name,String custom_password,String custom_email);
	
	/**
	 * 通过订单编号查找用户
	 * 登陆
	 * @param order_id
	 * @return
	 */
	public Custominfo findCustomByOrder_id(Long order_id);
	
	//修改账户余额
	  int updateCustomMoney(Long custom_id , Double money);
	/**
	 * 超级管理员  ： 显示所有用户
	 * @return
	 */
	List<Custominfo> findAllCustom();
	
	 
	
}
