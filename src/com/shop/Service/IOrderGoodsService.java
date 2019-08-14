package com.shop.Service;

import java.util.List;

import com.shop.entity.OrderGoods;

public interface IOrderGoodsService {
	/**
	 * 根据商家id查询所有订单
	 * @param seller_id
	 * @return
	 */
	public List<OrderGoods> findBySerllerId(Long seller_id);
	
	/**
	 * 根据客户id查询所有订单
	 * @param custom_id
	 * @return
	 */
	public List<OrderGoods> findByCustomId(Long custom_id);
	
	/**
	 * 根据客户id,买家是否支付，查询所有订单
	 * @param custom_id ,Order_checkPay
	 * @return
	 */
	public List<OrderGoods> findByPayCId(Long custom_id , Long ordergoods_checkPay);
	
	/**
	 * 根据订单id查询 订单
	 * @param seller_id
	 * @return
	 */
	public  OrderGoods  findOrderByOrderId(Long order_id);
	/**
	 * 根据客户id,买家已支付，卖家是否发货，查询所有订单
	 * @param Long custom_id , String Order_shopSend
	 * @return
	 */
	public List<OrderGoods> findByShopSendCId(Long custom_id , Long ordergoods_shopsend );
	
	/**
	 * 根据客户id,买家已支付，卖家已发货，买家是否收货，查询所有订单
	 * @param Long custom_id , String Order_customget
	 * @return
	 */
	public List<OrderGoods> findByCustomGetCId(Long custom_id , Long ordergoods_customget);
	
	/**
	 * 根据客户id,买家是否退货，查询所有订单
	 * @param Long custom_id , String Order_customback
	 * @return
	 */
	public List<OrderGoods> findByCustomBackCId(Long custom_id , Long ordergoods_customback);
	
	/**
	 * 根据客户id,卖家是否确认收货，查询所有订单
	 * @param Long custom_id , String Order_shopget
	 * @return
	 */
	public List<OrderGoods> findByShopGetCId(Long custom_id , Long ordergoods_shopget);
	/**
	 * 根据客户id,卖家是否评论，查询所有订单
	 * @param Long custom_id , String Order_customcomment
	 * @return
	 */
	public List<OrderGoods> findByCustomComment(Long custom_id , Long ordergoods_comment);
	
	
	
	/**
	 * 根据卖家id,买家是否支付，查询所有订单
	 * @param custom_id ,Order_checkPay
	 * @return
	 */
	public List<OrderGoods> findBySellerPayCId(Long seller_id , Long ordergoods_checkPay);
	
	/**
	 * 根据卖家id,买家已支付，卖家是否发货，查询所有订单
	 * @param Long custom_id , String Order_shopSend
	 * @return
	 */
	public List<OrderGoods> findBySellerShopSendCId(Long seller_id , Long ordergoods_shopsend );
	
	/**
	 * 根据卖家id,买家已支付，卖家已发货，买家是否收货，查询所有订单
	 * @param Long custom_id , String Order_customget
	 * @return
	 */
	public List<OrderGoods> findBySellerCustomGetCId(Long seller_id , Long ordergoods_customget);
	
	/**
	 * 根据卖家id,买家是否退货，查询所有订单
	 * @param Long custom_id , String Order_customback
	 * @return
	 */
	public List<OrderGoods> findBySellerCustomBackCId(Long seller_id , Long ordergoods_customback);
	
	/**
	 * 根据卖家id,卖家是否确认收货，查询所有订单
	 * @param Long custom_id , String Order_shopget
	 * @return
	 */
	public List<OrderGoods> findBySellerShopGetCId(Long seller_id , Long ordergoods_shopget);
	/**
	 * 根据卖家id,卖家是否评论，查询所有订单
	 * @param Long custom_id , String Order_customcomment
	 * @return
	 */
	public List<OrderGoods> findBySellerCustomComment(Long seller_id , Long ordergoods_comment);
		
	
	
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
	public boolean addOrder(OrderGoods order);
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	public boolean updateOrderGoods(OrderGoods order);
	
	/**
	 * 根据订单编号删除全部订单
	 * @param order_id
	 * @return
	 */
	public boolean deleteOrder(Long order_id);
	
	/**
	 * 卖家发货
	 */
	public int ChangeShopSend(Long order_id , Long goods_id);
	

	/**
	 * 买家确认收货
	 */
	public int ChangeCustomGet(Long order_id , Long goods_id);
	
	/**
	 * 买家退货
	 */
	public int ChangeCustomBack(Long order_id , Long goods_id ,  Long ordergoods_customback);
	
	/**
	 * 卖家确认接受退货
	 */
	public int SellerReturnBack(Long order_id , Long goods_id , Long goods_number);
	/**
	 * 买家评论
	 * @param order_id
	 * @param goods_id
	 * @return
	 */
	public int  ChangeCustomComment(Long order_id , Long goods_id);
	
	/**
	 * 买家确认收货
	 * @param order_id
	 * @param goods_id
	 * @param custom_id
	 * @return
	 */
	public int getGoods(List<OrderGoods> orders);
	
	/**
	 * 买家申请退货
	 * @param orders
	 * @return
	 */
	public int backGoods(List<OrderGoods> orders);
}
