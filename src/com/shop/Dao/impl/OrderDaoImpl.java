package com.shop.Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.Dao.IOrderDao;
import com.shop.entity.OrderGoods;
import com.shop.entity.Orderinfo;
import com.shop.util.DBUtil;

/**
 * 订单表操作
 *
 */

public class OrderDaoImpl implements IOrderDao {
	/**
	 * 根据商家id查询所有订单
	 * @param seller_id
	 * @return
	 */
	public List<Orderinfo> findBySerllerId(Long seller_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Orderinfo> list = null ;
		String sql = "select * from orderinfo where order_id in(select order_id from ordergoods where goods_id in"+
		"(select goods_id from goodsinfo where shop_id in"+
		"(select shop_id from shopinfo where seller_id = ?))) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Orderinfo>(Orderinfo.class),seller_id);
			//System.out.println("daoimpl shop : " + shop);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	
	/**
	 * 根据客户id查询所有订单
	 * @param custom_id
	 * @return
	 */
 
	public List<Orderinfo> findByCustomId(Long custom_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Orderinfo> list = null ;
		String sql = "select * from orderinfo where custom_id = ? " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Orderinfo>(Orderinfo.class),custom_id);
			//System.out.println("daoimpl shop : " + shop);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	
	/**
	 * 根据订单id查询 订单
	 * @param seller_id
	 * @return
	 */
	public  Orderinfo  findOrderByOrderId(Long order_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		 Orderinfo  order = null ;
		String sql = "select * from orderinfo where order_id = ? " ;
		try {
			order = qr.query(conn, sql, new BeanHandler<Orderinfo>(Orderinfo.class),order_id);
			//System.out.println("daoimpl shop : " + shop);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return order;
	}
	
	
	
	
	/**
	 * 根据订单编号查询订单
	 * @param order_id
	 * @return
	 */
	public List<OrderGoods> findByOrderId(Long order_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		 List<OrderGoods> list=null;
		String sql = "select o.*,g.goods_Desception,g.goods_Img from OrderGoods o,goodsinfo g where g.goods_id=o.goods_id and order_id = ?  " ;
		try {
			list =  qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),order_id);
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	
	/**
	 * 根据订单编号查询编号商家查询商家自己商品的
	 */
	public List<OrderGoods> findByOrderId(Long order_id,Long seller_id){
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		 List<OrderGoods> list=null;
		String sql="select o.*,g.goods_Desception,g.goods_Img from OrderGoods o,"+
		"(select * from goodsinfo where shop_id in (select shop_id from shopinfo where seller_id=?)) g"+
		" where g.goods_id=o.goods_id and order_id = ?";
		try {
			list =  qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),seller_id,order_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
		
	}
	
	/**
	 * 根据客户id,买家已支付，卖家已发货，买家已收货，是否评论， 
	 * @param Long custom_id , String Order_customback
	 * @return
	 */
	public List<Orderinfo> findByCustomComment(Long custom_id , Long Order_comment) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Orderinfo> list = null ;
		String sql = "select * from orderinfo where custom_id = ? and Order_comment = ? "
				+ "and Order_checkPay = 1 and Order_shopSend = 1 and Order_customget = 1 " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Orderinfo>(Orderinfo.class),custom_id,Order_comment);
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	
	/**
	 * 增加订单
	 * @param order
	 * @return
	 */
	public int addOrder(Orderinfo order) {
		return 0;
	}
	/**
	 * 卖家操作 : 修改订单信息
	 * @param order
	 * @return
	 */
	public int updateOrder(Orderinfo order) {
		return 0;
	}
	
	/**
	 * 删除订单
	 * @param order_id
	 * @return
	 */
	public int deleteOrder(Long order_id) {
		return 0;
	}

 



}
