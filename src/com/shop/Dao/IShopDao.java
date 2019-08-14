package com.shop.Dao;

import java.util.List;

import com.shop.entity.Shopinfo;
 

/**
 * 店铺接口
 * 店铺的操作
 * @author 
 *
 */
public interface IShopDao {
	
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
	public List<Shopinfo> findShopBySellerId(Long Seller_id);
	
	
	/**
	 * 分页查询Seller_id的所有店铺
	 * @param sellerid
	 * @param startRow
	 * @param endRow
	 * @return 当前页可展示的信息
	 */
	List<Shopinfo>  shopSelect(Long seller_id,int startRow ,int endRow);
	/**
	 * 分页查询符合店铺名的所有店铺
	 * @param sellerid
	 * @param startRow
	 * @param endRow
	 * @return 当前页可展示的信息
	 */
	List<Shopinfo>  shopSelect(String shop_name,int startRow ,int endRow);
	
	/**
	 * 根据店铺名字查询店铺(模糊查询)
	 * @param Shopinfo_name
	 * @return
	 */
	public List<Shopinfo> findShopByShopName(String shop_name);
	
	/**
	 * Ajax根据店铺名字查询店铺,查看是否有同名店铺
	 * @param Shopinfo_name
	 * @return
	 */
	public Shopinfo findShopByShopNa(String shop_name);
	/**
	 * 根据店铺id查询店铺
	 * @param Shopinfo_id
	 * @return
	 */
	public Shopinfo findShopByShopId(Long shop_id);
	
	/**
	 * 创建店铺
	 * @param Shopinfo
	 * @return
	 */
	public int  addShop(Shopinfo shop);
	
	/**
	 * 删除店铺
	 * @param Shopinfo_id
	 * @return
	 */
	public int deleteShop(Long shop_id);
	
	/**
	 * 修改店铺店铺信息
	 * @param Shopinfo
	 * @return
	 */
	public int updateShopinfo(Shopinfo shop);
	
	/**
	 * 上传店铺头像
	 * @param shop
	 * @return
	 */
	public int uploadShopImg(Shopinfo shop);
	
}
