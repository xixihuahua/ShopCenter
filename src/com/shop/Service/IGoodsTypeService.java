package com.shop.Service;

import java.util.List;

import com.shop.entity.GoodsType;
import com.shop.entity.Goodsinfo;

public interface IGoodsTypeService {
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
	public boolean addGoodsType(GoodsType goodstype);
	
	/**
	 * 删除商品类型
	 * @param goodsType_id
	 * @return
	 */
	public boolean deleteGoodsType(Long goodsType_id);
	/**
	 * 修改商品类型
	 * @param goodsType_id
	 * @return
	 */
	public boolean updateGoodsType(Long goodsType_id);
	
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
	
	/**
	 * 分页查询 
	 * 通过商品类型名字  查找所有商品
	 * @param goodsType_name
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public List<Goodsinfo> SelectfindGoodsByType(String goodsType_name, int startRow,
			int endRow);
}
