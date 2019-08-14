package com.shop.Service.impl;

import java.util.List;

import com.shop.Dao.impl.GoodsDaoImpl;
import com.shop.Service.IGoodsService;
import com.shop.entity.Goodsinfo;

public class GoodsServiceImpl implements IGoodsService {
	GoodsDaoImpl goodsdao = new GoodsDaoImpl();
	/**
	 * 查询所有商品
	 * @return
	 */
	public List<Goodsinfo> findAllGoods() {
		return goodsdao.findAllGoods();
	}
	
	/**
	 * 通过店铺id显示商品
	 * 在店铺内显示所有商品
	 * @param store_id
	 * @return
	 */
	public List<Goodsinfo> findGoodsByShopId(Long shop_id) {
		return goodsdao.findGoodsByShopId(shop_id);
	} 
	
	/**
	 * 通过商品id显示商品
	 * 在店铺内显示所有商品
	 * @param goods_id
	 * @return
	 */
	public  Goodsinfo findGoodsById(Long goods_id) {
		return goodsdao.findGoodsById(goods_id);
	}
 
	
	/**
	 * 根据商品描述查询到的商品
	 * 模糊查询
	 * @param goods_desception
	 * @return
	 */
	public List<Goodsinfo> findGoodsByName(String goods_desception) {
		return goodsdao.findGoodsByName(goods_desception);
	}
	
	/**
	 * 根据商品描述查询商品(判断商品描述是否一样)
	 * @param goods_desception
	 * @return
	 */
	public boolean findGoodsByDe(String goods_desception) {
		return goodsdao.findGoodsByDe(goods_desception) != null;
	}
	
	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	public boolean addGoods(Goodsinfo goods) {
		return goodsdao.addGoods(goods) > 0;
	}
	
	/**
	 * 删除商品
	 * @param goods_id
	 * @return
	 */
	public boolean deleteGoods(Long goods_id) {
		return goodsdao.deleteGoods(goods_id) > 0;
	}
	
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	public boolean updateGoods(Goodsinfo goods) {
		return goodsdao.updateGoods(goods) > 0;
	}
	
	
	 
	
	/**
	 * 分页查询shop_id下的商品
	 */
	@Override
	public List<Goodsinfo> goodsSelect(Long shop_id, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return goodsdao.goodsSelect(shop_id, startRow, endRow);
	}
	

	/**
	 * 分页查询goods_desception的商品
	 */
	@Override
	public List<Goodsinfo> goodsSelect(String goods_desception, int startRow,
			int endRow) {
		// TODO Auto-generated method stub
		return goodsdao.goodsSelect(goods_desception, startRow, endRow);
	}

	/**
	 * 上传商品图片
	 */
	@Override
	public boolean uploadGoodsImg(Goodsinfo goods) {
		// TODO Auto-generated method stub
		return goodsdao.uploadGoodsImg(goods)>0;
	}

	 
}
