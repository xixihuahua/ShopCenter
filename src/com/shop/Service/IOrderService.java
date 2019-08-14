package com.shop.Service;

import java.util.List;

import com.shop.entity.OrderGoods;
import com.shop.entity.Orderinfo;

public interface IOrderService {
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
	 * 商家根据订单编号查看商品详情只属于自己商品的
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
	public boolean addOrder(Orderinfo order);
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	public boolean updateOrder(Orderinfo order);
	
	/**
	 * 删除订单
	 * @param order_id
	 * @return
	 */
	public boolean deleteOrder(Long order_id);
}
