package com.shop.Dao;

import java.util.List;



import com.shop.entity.Goodsinfo;
import com.shop.entity.Shopinfo;

/**
 * 商品接口
 * 实现商品的增删改查 
 * 如查询商品,上传商品到数据库中
 *
 */
public interface IGoodsDao {
	
	/**
	 * 查询所有商品
	 * @return
	 */
	public List<Goodsinfo> findAllGoods();
	
	/**
	 * 通过店铺id显示商品
	 * 在店铺内显示所有商品
	 * @param store_id
	 * @return
	 */
	public List<Goodsinfo> findGoodsByShopId(Long shop_id); 
	
	/**
	 * 通过商品id显示商品
	 * @param goods_id
	 * @return
	 */
	public  Goodsinfo findGoodsById(Long goods_id);
	
	/**
	 * 根据商品描述查询商品
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
	public Goodsinfo findGoodsByDe(String goods_desception);
	
	
	/**
	 * 分页查询shop_id的所有商品
	 * @param shop_id
	 * @param startRow
	 * @param endRow
	 * @return 当前页可展示的信息
	 */
	List<Goodsinfo>  goodsSelect(Long shop_id,int startRow ,int endRow);
	
	/**
	 * 分页查询goods_desception的所有商品
	 * @param goods_desception
	 * @param startRow
	 * @param endRow
	 * @return 当前页可展示的信息
	 */
	List<Goodsinfo>  goodsSelect(String goods_desception,int startRow ,int endRow);
	
	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	public int addGoods(Goodsinfo goods);
	
	/**
	 * 删除商品
	 * @param goods_id
	 * @return
	 */
	public int deleteGoods(Long goods_id);
	
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	public int updateGoods(Goodsinfo goods);
	
	/**
	 * 上传商品图片
	 * @param goods
	 * @return
	 */
	public int uploadGoodsImg(Goodsinfo goods);
	
}
