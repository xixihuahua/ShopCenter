package com.shop.Dao;

import java.util.List;

import com.shop.entity.OrderGoods;
import com.shop.entity.Orderinfo;

	/**
	 * 订单表操作
	 *
	 */
public interface IOrderDao {
	
	/**
	 * 根据商家id查询所有订单
	 * @param seller_id
	 * @return
	 */
	public List<Orderinfo> findBySerllerId(Long seller_id);
	
	/**
	 * 根据客户id查询所有订单
	 * @param custom_id
	 * @return
	 */
	public List<Orderinfo> findByCustomId(Long custom_id);
	
	 
	/**
	 * 根据订单编号查询订单
	 * @param order_id
	 * @return
	 */
	public List<OrderGoods> findByOrderId(Long order_id);
	/**
	 * 商家根据自己商家编号
	 * @param order_id
	 * @param seller_id
	 * @return
	 */
	public List<OrderGoods> findByOrderId(Long order_id,Long seller_id);
	/**
	 * 增加订单
	 * @param order
	 * @return
	 */
	public int addOrder(Orderinfo order);
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	public int updateOrder(Orderinfo order);
	
	/**
	 * 根据订单编号删除全部订单
	 * @param order_id
	 * @return
	 */
	public int deleteOrder(Long order_id);
	
	/**
	 * 根据订单编号 商品号删除具体订单
	 */
}
