package com.shop.Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.Dao.ICustomDao;
import com.shop.Dao.IGoodsDao;
import com.shop.Dao.IOrderDao;
import com.shop.Dao.IOrderGoodsDao;
import com.shop.entity.Custominfo;
import com.shop.entity.Goodsinfo;
import com.shop.entity.OrderGoods;
import com.shop.util.DBUtil;
 

 

public class OrderGoodsDaoImpl implements IOrderGoodsDao {
	IGoodsDao goodsDao = new GoodsDaoImpl() ;
	IOrderDao orderDao = new OrderDaoImpl() ;
	ICustomDao customDao = new CustomDaoImpl() ;
 
	/**
	 * 根据商家id查询所有订单商品
	 * @param seller_idfindByCustomId
	 * @return
	 */
	public List<OrderGoods> findBySerllerId(Long seller_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql = "select * from ordergoods where goods_id in"+
		"(select goods_id from goodsinfo where shop_id in"+
		"(select shop_id from shopinfo where seller_id = ?)) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),seller_id);
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
	 * 根据客户id查询所有订单内商品
	 * @param custom_id
	 * @return
	 */
	public List<OrderGoods> findByCustomId(Long custom_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql = " select * from ordergoods where order_id in "
				+ "(select order_id from orderinfo where custom_id = ? )" ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),custom_id);
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
	 * 根据客户id,买家是否支付，查询所有订单
	 * 0：未支付 1:已支付
	 * @param custom_id ,ordergoods_checkPay
	 * @return
	 */
	public List<OrderGoods> findByPayCId(Long custom_id , Long ordergoods_checkPay) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql = "select * from OrderGoods where"
				+ " ordergoods_checkPay = ? and  order_id in   "
				+ "(select order_id from orderinfo where custom_id = ?  )  " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_checkPay,custom_id);
		 
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
	 * 待发货
	 * 根据客户id,买家已支付，卖家是否发货，查询所有订单
	 * 0 :未支付  1 :已支付
	 * 0 :未发货  1 :已发货
	 * @param Long custom_id , String ordergoods_shopSend
	 * @return
	 */
	public List<OrderGoods> findByShopSendCId(Long custom_id , Long ordergoods_shopSend) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql = "select * from OrderGoods where  ordergoods_shopSend = ?  and ordergoods_shopget=0" + 
				  " and ordergoods_checkPay = 1 and ordergoods_customget=0 and ordergoods_customback=0 and  order_id in  " + 
				"(select order_id from orderinfo where custom_id = ?  ) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_shopSend,custom_id);
		 
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
	 * 待收货
	 * 根据客户id,买家已支付，卖家已发货 ，买家是否收货，查询所有订单
	 * @param Long custom_id , String ordergoods_customget
	 * @return
	 */
	public List<OrderGoods> findByCustomGetCId(Long custom_id , Long ordergoods_customget) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql = "select * from OrderGoods where  ordergoods_customget = ? and ordergoods_shopget=0 "
				+ "and ordergoods_checkPay = 1 and ordergoods_shopSend = 1 and ordergoods_customback=0 and  order_id in  " + 
				"(select order_id from orderinfo where custom_id = ?  )" ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_customget,custom_id);
		 
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
	 * 待退货
	 * 根据客户id,买家已支付，卖家已发货，买家未收货，买家是否退货，查询所有订单
	 * @param Long custom_id , String ordergoods_customback
	 * @return
	 */
	public List<OrderGoods> findByCustomBackCId(Long custom_id , Long ordergoods_customback) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql = "select * from OrderGoods where ordergoods_customback = ? "
				+ "and ordergoods_checkPay = 1 and ordergoods_customget = 0  " 
				+ "and  order_id in  " + 
				"(select order_id from orderinfo where custom_id = ?  )" ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_customback ,custom_id);
		 
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
	 * 待退货订单
	 * 根据客户id,买家已支付，买家未收货，买家已退货，卖家是否确认退货，查询所有订单
	 * @param Long custom_id , String ordergoods_shopget
	 * @return
	 */
	public List<OrderGoods> findByShopGetCId(Long custom_id , Long ordergoods_shopget) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql = "select * from OrderGoods where  ordergoods_shopget = ? and "
		+ "ordergoods_customback = 1 and ordergoods_checkPay = 1 and ordergoods_customget = 0 "
		+ "and  order_id in  " + 
		"(select order_id from orderinfo where custom_id = ?  )";
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_shopget,custom_id);
		 
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
	 * 待评论
	 * 根据客户id,买家已支付，卖家已发货，买家已收货，是否评论， 买家不能退货,卖家不能收货
	 * @param Long custom_id , String Order_customback
	 * @return
	 */
	public List<OrderGoods> findByCustomComment(Long custom_id , Long Order_comment) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql = "select * from ordergoods where  ordergoods_comment = ? and ordergoods_customback=0 and ordergoods_shopget=0"
				+ "and ordergoods_checkPay = 1 and ordergoods_shopSend = 1 and ordergoods_customget = 1 "
				+ "and  order_id in  " + 
				"(select order_id from orderinfo where custom_id = ?  )";
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),Order_comment ,custom_id);
		 
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
	 * 根据卖家id,买家是否支付，查询所有订单
	 * @param custom_id ,Order_checkPay
	 * @return
	 */
	public List<OrderGoods> findBySellerPayCId(Long seller_id , Long ordergoods_checkPay) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql =  " select * from ordergoods where  ordergoods_checkPay = ? and  goods_id in "+
						"(select goods_id  from goodsinfo where shop_id in "+
						   "(select shop_id from shopinfo where seller_id = ?)) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_checkPay,seller_id);
		 
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
	 * 根据卖家id,买家已支付，卖家是否发货，买家不退货,买家未收货,查询所有订单
	 * @param Long custom_id , String Order_shopSend
	 * @return
	 */
	public List<OrderGoods> findBySellerShopSendCId(Long seller_id , Long ordergoods_shopsend ) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql =  " select * from ordergoods where  ordergoods_shopsend = ? and ordergoods_customget=0 and ordergoods_customback=0 and ordergoods_checkPay = 1 and  goods_id in "+
						"(select goods_id  from goodsinfo where shop_id in "+
						   "(select shop_id from shopinfo where seller_id = ?)) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_shopsend,seller_id);
		 
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
	 * 根据卖家id,买家已支付，卖家已发货，买家是否收货，没有退货查询所有订单
	 * @param Long custom_id , String Order_customget
	 * @return
	 */
	public List<OrderGoods> findBySellerCustomGetCId(Long seller_id , Long ordergoods_customget) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql =  " select * from ordergoods where ordergoods_customget = ? and ordergoods_customback=0 and ordergoods_customget=0 and ordergoods_shopsend = 1 and ordergoods_checkPay = 1 and  goods_id in "+
						"(select goods_id  from goodsinfo where shop_id in "+
						   "(select shop_id from shopinfo where seller_id = ?)) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_customget,seller_id);
		 
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
	 * 根据卖家id,买家是否退货，查询所有订单  买家不能收货
	 * @param Long custom_id , String Order_customback
	 * @return
	 */
	public List<OrderGoods> findBySellerCustomBackCId(Long seller_id , Long ordergoods_customback) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql =  " select * from ordergoods where ordergoods_customback = ? and ordergoods_customget=0 and ordergoods_shopget = 0 and  ordergoods_shopsend = 1 and ordergoods_checkPay = 1 and  goods_id in "+
						"(select goods_id  from goodsinfo where shop_id in "+
						   "(select shop_id from shopinfo where seller_id = ?)) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_customback,seller_id);
		 
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
	 * 根据卖家id,卖家是否确认收货，查询所有订单 必须是买家已退货,卖家已发货
	 * @param Long custom_id , String Order_shopget
	 * @return
	 */
	public List<OrderGoods> findBySellerShopGetCId(Long seller_id , Long ordergoods_shopget) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql =  " select * from ordergoods where ordergoods_shopget = ? and ordergoods_customback = 1 and ordergoods_customget =0 and  ordergoods_shopsend = 1 and ordergoods_checkPay = 1 and  goods_id in "+
						"(select goods_id  from goodsinfo where shop_id in "+
						   "(select shop_id from shopinfo where seller_id = ?)) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_shopget,seller_id);
		 
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
	 * 根据卖家id,卖家是否评论，查询所有订单  必须是卖家已发货,买家收货
	 * @param Long custom_id , String Order_customcomment
	 * @return
	 */
	public List<OrderGoods> findBySellerCustomComment(Long seller_id , Long ordergoods_comment) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<OrderGoods> list = null ;
		String sql =  " select * from ordergoods where ordergoods_comment = ? and ordergoods_shopget = 0 and ordergoods_customback = 0 and ordergoods_customget = 1 and  ordergoods_shopsend = 1 and ordergoods_checkPay = 1 and  goods_id in "+
						"(select goods_id  from goodsinfo where shop_id in "+
						   "(select shop_id from shopinfo where seller_id = ?)) " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<OrderGoods>(OrderGoods.class),ordergoods_comment,seller_id);
		 
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
	 * 根据订单编号查询订单
	 * @param order_id
	 * @return
	 */
	public List<OrderGoods> findByOrderId(Long order_id) {
		return null;
	}
	/**
	 * 商家根据自己商家编号
	 * @param order_id
	 * @param seller_id
	 * @return
	 */
	public List<OrderGoods> findByOrderId(Long order_id,Long seller_id) {
		return null;
	}
	/**
	 * 增加订单
	 * @param order
	 * @return
	 */
	public int addOrder(OrderGoods order) {
		return 0;
	}
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	public int updateOrderGoods(OrderGoods order) {
		return 0;
	}
	
	/**
	 * 根据订单编号删除全部订单
	 * @param order_id
	 * @return
	 */
	public int deleteOrder(Long order_id) {
		return 0;
	}

 
	/**
	 * 卖家发货,买家不能是退货状态,
	 */
	public int ChangeShopSend(Long order_id , Long goods_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update ordergoods set ordergoods_shopsend = 1  where"
				
				+ " order_id = ?  and goods_id = ?" ;
		try {
			OrderGoods o = new OrderGoods();
			o = qr.query(conn,"select * from ordergoods where order_id = ? and goods_id=?",new BeanHandler<OrderGoods>(OrderGoods.class), order_id,goods_id);
			if(o.getOrdergoods_customback()==0 && o.getOrdergoods_shopsend()==0){
				num = qr.update(conn, sql,order_id,goods_id);
			}else if(o.getOrdergoods_shopsend()==1){
				return -1;//卖家已经发货,无需再发
			}else if(o.getOrdergoods_customback()==1) {
				return -2;//买家已经退货,不能发货
			}
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
		return num;
	}
	
	
	/**
	 * 买家确认收货
	 */
	public int ChangeCustomGet(Long order_id , Long goods_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update ordergoods set ordergoods_customget = 1   where order_id = ?  and goods_id = ?" ;
		try {
			OrderGoods o = new OrderGoods();
			o = qr.query(conn,"select * from ordergoods where order_id = ? and goods_id=?",new BeanHandler<OrderGoods>(OrderGoods.class), order_id,goods_id);
			if(o.getOrdergoods_customget()==0 && o.getOrdergoods_customback()==0 && o.getOrdergoods_shopsend()==1){
				num = qr.update(conn, sql,order_id,goods_id);
			}else if(o.getOrdergoods_customback()==1) {
				return -1; //买家退货,不能收货
			}else if(o.getOrdergoods_customget()==1){
				return -2; //买家已收货,不能再收货
			}else if(o.getOrdergoods_shopsend()==0){
				return -3; //卖家未发货,不能收货
			}
			
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
		return num;
	}
	
	/**
	 * 买家点击确认退货
	 */
	public int ChangeCustomBack(Long order_id , Long goods_id , Long ordergoods_customback) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update ordergoods set ordergoods_customback = ?   where order_id = ?  and goods_id = ?" ;
		try {
			OrderGoods o = new OrderGoods();
			o = qr.query(conn,"select * from ordergoods where order_id = ? and goods_id=?",new BeanHandler<OrderGoods>(OrderGoods.class), order_id,goods_id);
			if(ordergoods_customback==1){
				if(o.getOrdergoods_customget()==0 && o.getOrdergoods_customback()==0  ){
				num = qr.update(conn, sql,ordergoods_customback,order_id,goods_id);
				}else if(o.getOrdergoods_customget()==1){
					return -1;//买家已经收货,不能退货
				}else if(o.getOrdergoods_customback()==1){
					return -2;//已经退货不能再次退货
				}
			}else if(ordergoods_customback==0){
				if(o.getOrdergoods_customget()==0 && o.getOrdergoods_customback()==1 &&o.getOrdergoods_shopget()==0 ){
				num = qr.update(conn, sql,ordergoods_customback,order_id,goods_id);
				}else if(o.getOrdergoods_customget()==1){
					return -3; // 已经收货,不能再点取消确认退货
				}else if(o.getOrdergoods_customback()==0){
					return -4;//没有退货,不能点取消退货
				}else if(o.getOrdergoods_shopget()==1){
					return -5;//卖家已经确认退货了,不能更改退货状态
				}
			}
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
		return num;
	}
	
	/**
	 * 卖家改变退货状态
	 */
	public int ChangeShopGet(Long order_id ,Long goods_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update ordergoods set ordergoods_shopget = 1   where order_id = ?  and goods_id = ?" ;
		try {
			OrderGoods o = new OrderGoods();
			o = qr.query(conn,"select * from ordergoods where order_id = ? and goods_id=?",new BeanHandler<OrderGoods>(OrderGoods.class), order_id,goods_id);
			if(o.getOrdergoods_customback()==1 && o.getOrdergoods_customget()==0 ){
				//必须是买家退货才能退货,买家不能收货
			num = qr.update(conn, sql,order_id,goods_id);
			}else if(o.getOrdergoods_customback()==0){
				return -1; // 买家没有退货
			}else if(o.getOrdergoods_customget()==1){
				return -2; //买家已收货
				
			}
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
		return num;
	}
	
	/**
	 * 卖家确认接受退货
	 * 
	 */
	public int SellerReturnBack(Long order_id , Long goods_id , Long goods_number) {
			Connection	conn = DBUtil.getConn();
			QueryRunner qr = new QueryRunner(); 
			 
			  try {
				 
					conn.setAutoCommit(false);
				 
				//先设置退还钱
				double money = 0.0;
				 //获取商品信息
				Goodsinfo goods = goodsDao.findGoodsById(goods_id) ;
				System.out.println("goods : " + goods);
				//获取要退还的钱
				money = goods.getGoods_Count() * goods_number * goods.getGoods_OutputPrice();
				System.out.println("该退还的钱 : " + money);
				
				//根据订单id获取买家信息
				 
				 Custominfo customer=  customDao.findCustomByOrder_id(order_id);
				 Long custom_id = customer.getCustom_id() ;
				 
				 System.out.println("customer : " + customer );
				 
				 int um = customDao.updateCustomMoney(custom_id, money) ;
				  System.out.println("um : " + um);
					
					customer= customDao.findCustomById(custom_id);
					
					System.out.println("customer : " + customer ) ;
				 
				 if(um==0){
						//退还失败 ， 
						 conn.rollback();
						 return -1;
					}else{
						//改变增加商品库存
						 goods.setGoods_Repertory(goods.getGoods_Repertory()+goods_number );
						 int num = goodsDao.updateGoods(goods);
						 if(num == 0 ){
							 conn.rollback();
							 return -2 ;
						}else{
							//改变订单状态  -1 -2
							int nu = ChangeShopGet(order_id, goods_id) ;
							System.out.println(" nu : " + nu );
							if(nu == 0 ){
								 conn.rollback();
								  return -3 ;
							}else if(nu==-1){
								conn.rollback();
								 return -4;  //买家未退货
							}else if(nu==-2){
								conn.rollback();
								return -5; //卖家已经退货,无需在退
							}	
							
						}
					}	
			 } catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}finally{
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			 return -5 ; 
	  }
	
	/**
	 * 买家评论
	 */
	public int ChangeCustomComment(Long order_id , Long goods_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update ordergoods set ordergoods_comment = 1   where order_id = ?  and goods_id = ?" ;
		try {
			OrderGoods o = new OrderGoods();
			o = qr.query(conn,"select * from ordergoods where order_id = ? and goods_id=?",new BeanHandler<OrderGoods>(OrderGoods.class), order_id,goods_id);
			if(o.getOrdergoods_customback()==0 && o.getOrdergoods_customget()==1 && o.getOrdergoods_shopsend()==1 && o.getOrdergoods_shopget()==0 ){
			num = qr.update(conn, sql,order_id,goods_id);
			}else if(o.getOrdergoods_customback()==1){
				return -1;//不能评论,买家已退货
			}else if(o.getOrdergoods_customget()==0){
				return -2; //未收货,不能评论
			}else if(o.getOrdergoods_shopsend()==0){
				return -3;//卖家未发货,不能评论
			}else if( o.getOrdergoods_shopget()==1 ){
				return -4;//卖家已确认退货
			}
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
		return num;
	}

//	@Override
//	public List<OrderGoods> findOrderByOrderId(Long order_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	
	/**
	 * 批量买家确认收货
	 * @param order_id
	 * @param goods_id
	 * @param custom_id
	 * @return
	 */
	public int getGoods(List<OrderGoods> orders) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		String sql="update ordergoods set ordergoods_customget =1 "
				+ "where order_id=? and goods_id =? ";
		int num = 0;
		try {
		for(OrderGoods order:orders){
			OrderGoods o = new OrderGoods();
			o = qr.query(conn,"select * from ordergoods where order_id = ? and goods_id=?",new BeanHandler<OrderGoods>(OrderGoods.class), order.getOrder_id(),order.getGoods_id());
			if(o.getOrdergoods_customget()==0){
				num+=qr.update(conn,sql,order.getOrder_id(),order.getGoods_id());
			}else{
				return -2;
			}
			
		}
	
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return num;
	}
	
	/**
	 * 批量买家申请退货
	 * @param orders
	 * @return
	 */
	public int backGoods(List<OrderGoods> orders){
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		
		
		String sql="update ordergoods set ordergoods_customback =1 "
				+ "where order_id=? and goods_id =? ";
		int num = 0;
		
		try {
		for(OrderGoods order:orders){
				OrderGoods o = new OrderGoods();
				o = qr.query(conn,"select * from ordergoods where order_id = ? and goods_id=?",new BeanHandler<OrderGoods>(OrderGoods.class), order.getOrder_id(),order.getGoods_id());
				if(o.getOrdergoods_customget()==0){
				num+=qr.update(conn,sql,order.getOrder_id(),order.getGoods_id());
				}else{
					System.out.println("退货失败,已经收货");
					return -2;
				}
		}
	
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return num;
		
	}
	
	
}
