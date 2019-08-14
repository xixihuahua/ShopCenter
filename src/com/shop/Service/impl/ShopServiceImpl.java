package com.shop.Service.impl;

import java.util.List;

import com.shop.Dao.impl.ShopDaoImpl;
import com.shop.Service.IShopService;
import com.shop.entity.Shopinfo;

public class ShopServiceImpl implements IShopService {
		ShopDaoImpl shopdao = new ShopDaoImpl();
	/**
	 * 查询所有店铺
	 * @return
	 */
	public List<Shopinfo> findAllShop() {
		return shopdao.findAllShop();
	}
	
	/**
	 * 查询Seller_id的所有店铺
	 * @param Seller_id
	 * @return
	 */
	public List<Shopinfo> findShopBySellerId(Long seller_id) {
		return shopdao.findShopBySellerId(seller_id);
	}
	
	/**
	 * 根据店铺名字查询店铺(模糊查询)
	 * @param Shopinfo_name
	 * @return
	 */
	public List<Shopinfo> findShopByShopName(String shop_name) {
		return shopdao.findShopByShopName(shop_name);
	}
	
	/**
	 * 根据店铺名字查询是否有同名店铺
	 * @param Shopinfo_name
	 * @return
	 */
	public boolean findShopByShopNa(String shop_name) {
		return shopdao.findShopByShopNa(shop_name) == null;
	}
	/**
	 * 根据店铺id查询店铺
	 * @param Shopinfo_id
	 * @return
	 */
	public Shopinfo findShopByShopId(Long shop_id) {
		return shopdao.findShopByShopId(shop_id);
	}
	
	/**
	 * 创建店铺
	 * @param Shopinfo
	 * @return
	 */
	public boolean  addShop(Shopinfo shop) {
		return shopdao.addShop(shop) > 0 ;
	}
	
	/**
	 * 删除店铺
	 * @param Shopinfo_id
	 * @return
	 */
	public boolean deleteShop(Long shop_id) {
		return shopdao.deleteShop(shop_id) > 0 ;
	}
	
	/**
	 * 修改店铺店铺信息
	 * @param Shopinfo
	 * @return
	 */
	public boolean updateShopinfo(Shopinfo shop) {
		return shopdao.updateShopinfo(shop) > 0 ;
	}
	/**
	 * 分页查询该seller_id下的所有店铺
	 */
	@Override
	public List<Shopinfo> shopSelect(Long seller_id, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return shopdao.shopSelect(seller_id, startRow, endRow);
	}
	
	/**
	 * 分页查询,符合搜索框中店铺名的店铺
	 * @param shop_name
	 * @param i
	 * @param j
	 * @return 当前页可展示的信息
	 */
	public List<Shopinfo>  shopSelect(String shop_name,int startRow ,int endRow) {
		return shopdao.shopSelect(shop_name, startRow, endRow);
	}
	
	@Override
	public boolean uploadShopImg(Shopinfo shop) {
		// TODO Auto-generated method stub
		return shopdao.uploadShopImg(shop)>0;
	}
	
}
