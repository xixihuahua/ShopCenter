package com.shop.Service;

import java.util.List;

import com.shop.entity.Custominfo;

public interface ICustomService {
	
	/**
	 * 根据用户id 查用户信息
	 * @param custom_id
	 * @return
	 */
	public Custominfo findCustomById(Long custom_id);
	
	/**
	 * 通过买家名查找是否有该用户
	 * 登陆
	 * @param Custom_name Custom_password
	 * @return
	 */
	public boolean findCustomByName(String custom_name,String custom_password); 
	
	/**
	 * 获取买家名获取用户
	 * @param custom_name
	 * @param custom_password
	 * @return
	 */
	public Custominfo getCustomByName(String custom_name,
			String custom_password);
	
    /**
	 * 根据买家id 
	 * @param custom_id
	 * @return
	 */
	public boolean findById(Long custom_id);
	
	/**
	 * 根据买家名字
	 * @param custom_name
	 * @return
	 */
	public boolean findByName(String custom_name);
	
	/**
	 * 根据买家id 
	 * @param custom_id
	 * @return
	 */
	public Custominfo getById(Long custom_id);
	
	/**
	 * 根据买家名字
	 * @param custom_name
	 * @return
	 */
	public Custominfo getByName(String custom_name);
		
	/**
	 * 通过买家id查找是否有该用户
	 * 登陆
	 * @param  Custom_id Custom_password
	 * @return
	 */
	public boolean findCustomById(Long custom_id ,String custom_password); 
	
	/**
	 * 获取买家id获取用户
	 * @param custom_name
	 * @param custom_password
	 * @return
	 */
	public Custominfo getCustomById(Long custom_id,String custom_password);
	
	/**
	 * 用户是否注册成功 （用户注册）
	 * @param Custom
	 * @return
	 */
	public boolean addCustom(Custominfo custom);
	/**
	 * 更新买家信息 (修改用户信息)
	 * @param Custom
	 * @return
	 */
	public boolean updateCustom(Custominfo custom);	
	
	/**
	 * 更新买家 绑定的手机
	 * @param custom
	 * @return
	 */
	public boolean updateCustomTel(Long custom_id , String custom_tel);	
	
	/**
	 * 更新买家 头像
	 * @param custom
	 * @return
	 */
	public boolean updateCustomImg(Long custom_id , String custom_img);
	
	/**
	 * 更新买家支付密码
	 * @param custom
	 * @return
	 */
	public boolean updateCustomPayPwd(Long custom_id , String custom_paypwd);	
	
	/**
	 * 删除用户（注销账号）
	 * @param custom_id
	 * @return
	 */
	public boolean deleteCustom(Long custom_id);
	
	
	/**
	 * 根据账号id和邮箱修改密码
	 * @param custom_id
	 * @param custom_email
	 * @return
	 */
	public boolean updateCustomPwd(String custom_password,Long custom_id,String custom_email);
	/**
	 * 根据账号名和邮箱修改密码
	 * @param custom_name
	 * @param custom_email
	 * @return
	 */
	public boolean updateCustomPwd(String custom_password,String custom_name,String custom_email);

	
	/**
	 * 超级管理员  ： 显示所有用户
	 * @return
	 */
	List<Custominfo> findAllCustom();
	


}
