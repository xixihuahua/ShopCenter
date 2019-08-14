package com.shop.Service;

import java.util.List;

import com.shop.entity.Shopinfo;
 

public interface IShopService {

	/**
	 * 查询所有店铺
	 * @return
	 */
	public List<Shopinfo> findAllShop();
	
	/**
	 * 查询Seller_id的所有店铺
	 * @param Seller_id
	 * @return
	 */
	public List<Shopinfo> findShopBySellerId(Long seller_id);
	
	/**
	 * 分页查询
	 * @param seller_id
	 * @param i
	 * @param j
	 * @return 当前页可展示的信息
	 */
	List<Shopinfo>  shopSelect(Long seller_id,int i ,int j);
	/**
	 * 分页查询,符合搜索框中店铺名的店铺
	 * @param shop_name
	 * @param i
	 * @param j
	 * @return 当前页可展示的信息
	 */
	List<Shopinfo>  shopSelect(String shop_name,int i ,int j);
	
	/**
	 * 根据店铺名字查询店铺(模糊查询)
	 * @param Shopinfo_name
	 * @return
	 */
	public List<Shopinfo> findShopByShopName(String shop_name);
	
	/**
	 * 根据店铺名字查询是否有同名店铺
	 * @param Shopinfo_name
	 * @return
	 */
	public boolean findShopByShopNa(String shop_name);
	/**
	 * 根据店铺id查询店铺
	 * @param Shopinfo_id
	 * @return
	 */
	public Shopinfo findShopByShopId(Long shop_id);
	
	/**
	 * 创建店铺是否成功
	 * @param Shopinfo
	 * @return
	 */
	public boolean  addShop(Shopinfo shop);
	
	/**
	 * 删除店铺是否成功
	 * @param Shopinfo_id
	 * @return
	 */
	public boolean deleteShop(Long shop_id);
	
	/**
	 * 修改店铺店铺信息是否成功
	 * @param Shopinfo
	 * @return
	 */
	public boolean updateShopinfo(Shopinfo shop);
	
	/**
	 * 上传店铺头像
	 * @param shop
	 * @return
	 */
	public boolean uploadShopImg(Shopinfo shop);
}
