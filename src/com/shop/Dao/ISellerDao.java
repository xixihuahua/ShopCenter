package com.shop.Dao;

import java.util.List;

import com.shop.entity.Sellerinfo;

 

/**
 * 卖家接口
 * 实现登陆，注册，修改信息，注销等功能
 * @author 
 *
 */
public interface ISellerDao {
	
	/**
	 * 通过卖家名查找用户
	 * 登陆
	 * @param seller_name seller_password
	 * @return
	 */
	public Sellerinfo findSellerByName(String seller_name,String seller_password); 
	/**
	 * 通过卖家id查找用户
	 * 登陆
	 * @param  seller_id seller_password
	 * @return
	 */
	public Sellerinfo findSellerById(Long seller_id ,String seller_password); 
	
 
	/**
	 * 根据卖家id找用户
	 * @param seller_id
	 * @return
	 */
	public Sellerinfo findById(Long seller_id);
	
	/**
	 * 根据卖家名找用户
	 * @param seller_name
	 * @return
	 */
	public Sellerinfo findByName(String seller_name);
	
	/**
	 * 添加卖家 （用户注册）
	 * @param seller
	 * @return
	 */
	public int addSeller(Sellerinfo seller);
	/**
	 * 更新卖家信息 (修改用户信息)
	 * @param seller
	 * @return
	 */
	public int updateSeller(Sellerinfo seller);	
	/**
	 * 更新卖家 绑定的手机
	 * @param seller
	 * @return
	 */
	public int updateSellerTel(Long seller_id , String seller_tel);	
	
	/**
	 * 更新卖家 头像
	 * @param seller
	 * @return
	 */
	public int updateSellerImg(Long seller_id , String seller_img);	
	
	/**
	 * 删除用户（注销账号）
	 * @param seller_id
	 * @return
	 */
	public int deleteSeller(Long seller_id);
	
	/**
	 * 根据账号id和邮箱修改密码
	 * @param seller_id
	 * @param seller_email
	 * @return
	 */
	public int updateSellerPwd(String seller_password,Long seller_id,String seller_email);
	/**
	 * 根据账号名和邮箱修改密码
	 * @param seller_name
	 * @param seller_email
	 * @return
	 */
	public int updateSellerPwd(String seller_name,String seller_password,String seller_email);
	
	
	/**
	 * 上传卖家头像
	 * @param custom
	 * @return
	 */
	 public int uploadSellerImg(Sellerinfo seller);
	 
}
