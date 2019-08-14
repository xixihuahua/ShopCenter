package com.shop.Service;

import java.util.List;

import com.shop.entity.Goodsinfo;
import com.shop.entity.Shopinfo;
 
public interface IGoodsService {
	/**
	 * 查询所有商品
	 * @return
	 */
	  List<Goodsinfo> findAllGoods();
	
	/**
	 * 通过店铺id显示商品
	 * 在店铺内显示所有商品
	 * @param store_id
	 * @return
	 */
	  List<Goodsinfo> findGoodsByShopId(Long shop_id); 
	
	/**
	 * 分页查询
	 * @param shop_id
	 * @param i
	 * @param j
	 * @return 当前页可展示的信息
	 */
	List<Goodsinfo>  goodsSelect(Long shop_id,int startRow ,int j);
	/**
	 * 分页查询goods_desception的所有商品
	 * @param goods_desception
	 * @param startRow
	 * @param endRow
	 * @return 当前页可展示的信息
	 */
	  List<Goodsinfo> goodsSelect(String goods_desception, int startRow,
			int endRow);
	/**
	 * 根据商品描述查询到的商品
	 * 模糊查询
	 * @param goods_desception
	 * @return
	 */
	public List<Goodsinfo> findGoodsByName(String goods_desception);
	
	/**
	 * 根据商品描述查询商品(判断商品描述是否一样)
	 * @param goods_desception
	 * @return
	 */
	public boolean findGoodsByDe(String goods_desception);
	
	/**
	 * 通过商品id显示商品
	 * 在店铺内显示所有商品
	 * @param goods_id
	 * @return
	 */
	public  Goodsinfo findGoodsById(Long goods_id);
	
	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	public boolean addGoods(Goodsinfo goods);
	
	/**
	 * 删除商品
	 * @param goods_id
	 * @return
	 */
	public boolean deleteGoods(Long goods_id);
	
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	public boolean updateGoods(Goodsinfo goods);
	
	
	/**
	 * 上传商品图片
	 * @param goods
	 * @return
	 */
	public boolean uploadGoodsImg(Goodsinfo goods);
	
	
}
