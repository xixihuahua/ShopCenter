package com.shop.Service;

 
import com.shop.entity.Sellerinfo;

/**
 * 卖家
 * @author 
 *
 */
public interface ISellerService {
	
	/**
	 * 通过卖家名查找是否有该用户
	 * 登陆
	 * @param seller_name seller_password
	 * @return
	 */
	public boolean findSellerByName(String seller_name,String seller_password); 
	
	/**
	 * 获取卖家名获取用户
	 * @param seller_name
	 * @param seller_password
	 * @return
	 */
	public Sellerinfo getSellerByName(String seller_name,
			String seller_password);
	
	/**
	 * 通过卖家id查找是否有该用户
	 * 登陆
	 * @param  seller_id seller_password
	 * @return
	 */
	public boolean findSellerById(Long seller_id ,String seller_password); 
	
	/**
	 * 获取卖家id获取用户
	 * @param seller_name
	 * @param seller_password
	 * @return
	 */
	public Sellerinfo getSellerById(Long seller_id,String seller_password);
	
	/**
	 * 根据卖家id找用户
	 * @param seller_id
	 * @return
	 */
	public boolean findById(Long seller_id);
	
	/**
	 * 根据卖家名找用户
	 * @param seller_name
	 * @return
	 */
	public boolean findByName(String seller_name);
	
	/**
	 * 根据卖家id找用户
	 * @param seller_id
	 * @return
	 */
	public Sellerinfo getById(Long seller_id);
	
	/**
	 * 根据卖家名找用户
	 * @param seller_name
	 * @return
	 */
	public Sellerinfo getByName(String seller_name);
	
	/**
	 * 卖家是否注册成功 （用户注册）
	 * @param seller
	 * @return
	 */
	public boolean addSeller(Sellerinfo seller);
	/**
	 * 更新卖家信息是否成功 (修改用户信息)
	 * @param seller
	 * @return
	 */
	public boolean updateSeller(Sellerinfo seller);	
	

	/**
	 * 更新卖家 绑定的手机
	 * @param seller_id seller_tel
	 * @return
	 */
	public boolean updateSellerTel(Long seller_id , String seller_tel);	
	
	/**
	 * 更新卖家 头像
	 * @param seller_id seller_img
	 * @return
	 */
	public boolean updateSellerImg(Long seller_id , String seller_img);	
	
	/**
	 * 删除卖家是否成功（注销账号）
	 * @param seller_id
	 * @return
	 */
	public boolean deleteSeller(Long seller_id);
	
	/**
	 * 根据账号id和邮箱修改密码
	 * @param custom_id
	 * @param custom_email
	 * @return
	 */
	public boolean updateSellerPwd(String seller_password,Long seller_id,String seller_email);
	/**
	 * 根据账号名和邮箱修改密码
	 * @param custom_name
	 * @param custom_email
	 * @return
	 */
	public boolean updateSellerPwd(String seller_name,String seller_password,String seller_email);
	
	/**
	 * 上传卖家头像
	 * @param seller
	 * @return
	 */
	public boolean uploadSellerImg(Sellerinfo seller);

}
