package com.shop.Service.impl;

import java.util.List;

import com.shop.Dao.impl.OrderDaoImpl;
import com.shop.Service.IOrderService;
import com.shop.entity.OrderGoods;
import com.shop.entity.Orderinfo;
/**
 * 订单操作
 * @author xixihuahua
 *
 */
public class OrderServiceImpl implements IOrderService {
		OrderDaoImpl orderDao = new OrderDaoImpl();
	/**
	 * 根据商家id查询所有订单
	 * @param seller_id
	 * @return
	 */
	public List<Orderinfo> findBySerllerId(Long seller_id) {
		return orderDao.findBySerllerId(seller_id);
	}
	
	/**
	 * 根据客户id查询所有订单
	 * @param custom_id
	 * @return
	 */
	public List<Orderinfo> findByCustomId(Long custom_id) {
		return orderDao.findByCustomId(custom_id);
	}
	 
	
	/**
	 * 根据订单编号查询订单
	 * @param order_id
	 * @return
	 */
	public List<OrderGoods> findByOrderId(Long order_id) {
		return orderDao.findByOrderId(order_id);
	}
	
	public List<OrderGoods> findByOrderId(Long order_id,Long seller_id){
		return orderDao.findByOrderId(order_id, seller_id);
	}
	/**
	 * 增加订单
	 * @param order
	 * @return
	 */
	public boolean addOrder(Orderinfo order) {
		return orderDao.addOrder(order) > 0;
	}
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	public boolean updateOrder(Orderinfo order) {
		return orderDao.updateOrder(order) > 0;
	}
	
	/**
	 * 删除订单
	 * @param order_id
	 * @return
	 */
	public boolean deleteOrder(Long order_id) {
		return orderDao.deleteOrder(order_id) > 0;
	}
}
