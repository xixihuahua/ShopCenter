package com.shop.Service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.shop.Dao.impl.CustomDaoImpl;
import com.shop.Service.ICustomService;
import com.shop.entity.Custominfo;
import com.shop.util.DBUtil;

public class CustomServiceImpl implements ICustomService {
			CustomDaoImpl  customdao = new CustomDaoImpl();

	
	/**
	 * 根据用户id 查用户信息
	 * @param custom_id
	 * @return
	 */
	public Custominfo findCustomById(Long custom_id) {
		return customdao.findCustomById(custom_id);
	}
	
			
	/**
	 * 通过买家名查找是否有此用户
	 * 登陆
	 * @param Custom_name Custom_password
	 * @return boolean 
	 */
	@Override
	public boolean findCustomByName(String custom_name,
			String custom_password) {
		 
		return customdao.findCustomByName(custom_name, custom_password) != null ;
	 
	}
	/**
	 * 获取买家名查找用户
	 * @param custom_name
	 * @param custom_password
	 * @return
	 */
	@Override
	public Custominfo getCustomByName(String custom_name,
			String custom_password) {
		  return customdao.findCustomByName(custom_name, custom_password);
		 
		 
	}

	/**
	 * 通过买家id查找是否有该用户
	 * 登陆
	 * @param  Custom_id Custom_password
	 * @return
	 */
	@Override
	public boolean findCustomById(Long custom_id,
			String custom_password) {
		// TODO Auto-generated method stub
		return customdao.findCustomById(custom_id, custom_password) != null; 
	}
	/**
	 * 获取买家id获取用户
	 * @param custom_name
	 * @param custom_password
	 * @return
	 */
	@Override
	public Custominfo getCustomById(Long custom_id, String custom_password) {
		// TODO Auto-generated method stub
		return customdao.findCustomById(custom_id, custom_password);
	}
	
	
	 /**
		 * 根据买家id 
		 * @param custom_id
		 * @return
		 */
		public boolean findById(Long custom_id) {
		return customdao.findById(custom_id) != null;
	}
		
		/**
		 * 根据买家名字
		 * @param custom_name
		 * @return
		 */
		public boolean findByName(String custom_name) {
			return customdao.findByName(custom_name) != null;
		}
		
		/**
		 * 根据买家id 
		 * @param custom_id
		 * @return
		 */
		public Custominfo getById(Long custom_id) {
			return customdao.findById(custom_id);
		}
		
		/**
		 * 根据买家名字
		 * @param custom_name
		 * @return
		 */
		public Custominfo getByName(String custom_name) {
			return customdao.findByName(custom_name);
		}
		
	/**
	 * 添加买家（买家注册）
	 */
	@Override
	public boolean addCustom(Custominfo custom) {
		// TODO Auto-generated method stub
		return customdao.addCustom(custom) > 0 ;
	}
	/**
	 * 更新买家信息（用户修改信息）
	 */
	@Override
	public boolean updateCustom(Custominfo custom) {
		// TODO Auto-generated method stub
		return customdao.updateCustom(custom) > 0 ;
	}
	
	/**
	 * 更新买家 绑定的手机
	 * @param custom
	 * @return
	 */
	public boolean updateCustomTel(Long custom_id , String custom_tel) {
		return customdao.updateCustomTel(custom_id, custom_tel) > 0;
	}	
	
	
	
	
	/**
	 * 更新买家支付密码
	 * @param custom
	 * @return
	 */
	public boolean updateCustomPayPwd(Long custom_id , String custom_paypwd) {
		return customdao.updateCustomPayPwd(custom_id, custom_paypwd) > 0;
	}	
	
	/**
	 * 删除用户（用户注销）
	 */
	@Override
	public boolean deleteCustom(Long custom_id) {
		// TODO Auto-generated method stub
		return customdao.deleteCustom(custom_id) > 0 ;
	}
	
	
	/**
	 * 根据账号id和邮箱修改密码
	 * @param custom_id
	 * @param custom_email
	 * @return
	 */
	public boolean updateCustomPwd(String custom_password,Long custom_id, 
			String custom_email) {
		
		return customdao.updateCustomPwd(custom_password, custom_id, custom_email)>0;
	}
	
	/**
	 * 根据账号id和邮箱修改密码
	 * @param custom_id
	 * @param custom_email
	 * @return
	 */
	public boolean updateCustomPwd(String custom_password,String custom_name, 
			String custom_email) {
		// TODO Auto-generated method stub
		return customdao.updateCustomPwd(custom_password,custom_name,  custom_email)>0;
	}
	
	 
	/**
	 * 更新买家 头像
	 * @param custom
	 * @return
	 */
	public boolean updateCustomImg(Long custom_id , String custom_img) {
		return customdao.updateCustomImg(custom_id, custom_img) > 0;
	}	
	
	/**
	 * 超级管理员  ： 显示所有用户
	 * @return
	 */
	public List<Custominfo> findAllCustom() {
		return customdao.findAllCustom();
	}
	
}
