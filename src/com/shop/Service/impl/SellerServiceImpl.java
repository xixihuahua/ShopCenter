package com.shop.Service.impl;

import com.shop.Dao.ISellerDao;
import com.shop.Dao.impl.SellerDaoImpl;
import com.shop.Service.ISellerService;
import com.shop.entity.Sellerinfo;

public class SellerServiceImpl implements ISellerService {
	ISellerDao sellerdao = new SellerDaoImpl();


	/**
	 * 通过买家名查找是否有此用户
	 * 登陆
	 * @param seller_name seller_password
	 * @return boolean 
	 */
	@Override
	public boolean findSellerByName(String seller_name,
			String seller_password) {
		 
		return sellerdao.findSellerByName(seller_name, seller_password) != null ;
	 
	}
	/**
	 * 获取买家名查找用户
	 * @param seller_name
	 * @param seller_password
	 * @return
	 */
	@Override
	public Sellerinfo getSellerByName(String seller_name,
			String seller_password) {
		  return sellerdao.findSellerByName(seller_name, seller_password);
		 
		 
	}

	/**
	 * 通过买家id查找是否有该用户
	 * 登陆
	 * @param  seller_id seller_password
	 * @return
	 */
	@Override
	public boolean findSellerById(Long seller_id,
			String seller_password) {
		// TODO Auto-generated method stub
		return sellerdao.findSellerById(seller_id, seller_password) != null; 
	}
	/**
	 * 获取买家id获取用户
	 * @param seller_name
	 * @param seller_password
	 * @return
	 */
	@Override
	public Sellerinfo getSellerById(Long seller_id, String seller_password) {
		// TODO Auto-generated method stub
		return sellerdao.findSellerById(seller_id, seller_password);
	}
	
	
	/**
	 * 根据卖家id找用户
	 * @param seller_id
	 * @return
	 */
	public boolean findById(Long seller_id) {
		return sellerdao.findById(seller_id) != null;
	}
	
	/**
	 * 根据卖家名找用户
	 * @param seller_name
	 * @return
	 */
	public boolean findByName(String seller_name) {
		return sellerdao.findByName(seller_name) != null;
	}
	
	/**
	 * 根据卖家id找用户
	 * @param seller_id
	 * @return
	 */
	public Sellerinfo getById(Long seller_id) {
		return sellerdao.findById(seller_id);
	}
	
	/**
	 * 根据卖家名找用户
	 * @param seller_name
	 * @return
	 */
	public Sellerinfo getByName(String seller_name) {
		return sellerdao.findByName(seller_name);
	}
	
	/**
	 * 卖家注册
	 */
	@Override
	public boolean addSeller(Sellerinfo seller) {
		// TODO Auto-generated method stub
		return sellerdao.addSeller(seller) > 0 ;
	}
	/**
	 * 修改卖家信息
	 */
	@Override
	public boolean updateSeller(Sellerinfo seller) {
		// TODO Auto-generated method stub
		return sellerdao.updateSeller(seller) > 0 ;
	}
	
	

	/**
	 * 更新卖家 绑定的手机
	 * @param seller_id seller_tel
	 * @return
	 */
	public boolean updateSellerTel(Long seller_id , String seller_tel) {
		return sellerdao.updateSellerTel(seller_id, seller_tel) > 0;
	}	
	
	/**
	 * 更新卖家 头像
	 * @param seller_id seller_img
	 * @return
	 */
	public boolean updateSellerImg(Long seller_id , String seller_img) {
		return sellerdao.updateSellerImg(seller_id, seller_img) > 0 ;
	}	
	
	
	/**
	 *注销卖家账号 
	 */
	@Override
	public boolean deleteSeller(Long seller_id) {
		// TODO Auto-generated method stub
		return sellerdao.deleteSeller(seller_id) > 0 ;
	}

	 
	/**
	 * 根据账号id和邮箱修改密码
	 * @param custom_id
	 * @param custom_email
	 * @return
	 */
	public boolean updateSellerPwd(String seller_password, Long seller_id,
			String seller_email) {
		// TODO Auto-generated method stub
		return sellerdao.updateSellerPwd(seller_password, seller_id, seller_email)>0;
	}
	
	/**
	 * 根据账号名和邮箱修改密码
	 * @param custom_name
	 * @param custom_email
	 * @return
	 */
	public boolean updateSellerPwd(String seller_name, String seller_password,
			String seller_email) {
		// TODO Auto-generated method stub
		return sellerdao.updateSellerPwd(seller_name, seller_password, seller_email)>0;
	}
	
	/**
	 * 上传卖家头像
	 */
	@Override
	public boolean uploadSellerImg(Sellerinfo seller) {
		// TODO Auto-generated method stub
		return sellerdao.uploadSellerImg(seller) > 0 ;
	}
	 

}
