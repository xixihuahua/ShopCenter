package com.shop.Dao;

import java.util.List;

import com.shop.entity.GoodsType;
import com.shop.entity.Goodsinfo;
 

/*
 * 商品类型操作
 */
public interface IGoodsTypeDao {
	
	/**
	 * 通过商品类型名查找商品类型
	 * @param goodsType_name
	 * @return
	 */
	 public GoodsType findGoodsTypeByTypeName(String goodsType_name);
	 
	 /**
	 * 通过商品类型id查找商品类型
	 * @param goodsType_id
	 * @return
	 */
	 public GoodsType findGoodsTypeByTypeId(Long goodsType_id);
	/**
	 * 添加商品类型
	 * @param goodsType
	 * @return 
	 */
	public int addGoodsType(GoodsType goodstype);
	
	/**
	 * 删除商品类型
	 * @param goodsType_id
	 * @return
	 */
	public int deleteGoodsType(Long goodsType_id);
	/**
	 * 修改商品类型
	 * @param goodsType_id
	 * @return
	 */
	public int updateGoodsType(Long goodsType_id);
	
	/**
	 * 通过商品类型查找所有商品
	 * @param goodsType_id
	 * @return
	 */
	public List<Goodsinfo> findGoodsByType(Long goodsType_id);
	
	/**
	 * 通过商品类型名字  查找所有商品
	 * @param goodsType_id
	 * @return
	 */
	public List<Goodsinfo> findGoodsByTypeName(String goodsType_name);
	
	public List<Goodsinfo> SelectfindGoodsByType(String goodsType_name, int startRow,
			int endRow);
	 
}
