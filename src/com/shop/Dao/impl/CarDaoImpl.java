	package com.shop.Dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.shop.Dao.ICarDao;
import com.shop.entity.Carinfo;
import com.shop.entity.Custominfo;
import com.shop.entity.Goodsinfo;
import com.shop.entity.Orderinfo;
import com.shop.entity.Shopinfo;
import com.shop.util.DBUtil;
import com.shop.util.NumberUtil;

public class CarDaoImpl implements ICarDao {
	QueryRunner qr = null;
	Connection conn = null;
	/**
	 * 添加商品到购物车
	 * 首先看一下数据库有没有这个数据，有的话就更新数据库
	 * 没有的话才添加
	 * @param car
	 * @return
	 */
	public int addCar(Carinfo car){
		qr=new QueryRunner();
		conn = DBUtil.getConn();
		int num = 0;
		//添加到购物车的时候先判断有没有这个用户
		try {
			Carinfo cars = qr.query(conn,"select * from carinfo where custom_id=? and goods_id=? ",
					new BeanHandler<Carinfo>(Carinfo.class),car.getCustom_id(),car.getGoods_id());
			//如果数据库有这个数据就更新数据库
			if(cars!=null){
				num=qr.execute(conn,"update carinfo set CarGoods_number = CarGoods_number+? where custom_id =? and goods_id=?",
						car.getCarGoods_number(),car.getCustom_id(),car.getGoods_id());
			}else{//如果没有就插入一行数据
				
				String sql = "insert into carinfo(car_id,Goods_id,CarGoods_number,custom_id) values"
						+ "(car_id_seq.nextval,?,?,?)";
				num =qr.execute(conn, sql, car.getGoods_id(),car.getCarGoods_number(),car.getCustom_id());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return num;
		
	}
	
	/**
	 * 删除购物车商品
	 * @param car
	 * @return
	 */
	public int deleteCar(Long goods_id,Long custom_id){
		qr = new QueryRunner();
		conn= DBUtil.getConn();
		int num=0;
		String sql = "delete from carinfo where goods_id=? and custom_id=?";
		try {
			num = qr.update(conn, sql, goods_id,custom_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
		
	}
	
	/**
	 * 更改购物车
	 * @param car
	 * @return
	 */
	public int updateCar(Carinfo car){
		qr=new QueryRunner();
		conn = DBUtil.getConn();
		int num = 0;
		//添加到购物车的时候先判断有没有这个商品
		try {
			Carinfo cars = qr.query(conn,"select * from carinfo where custom_id=? and goods_id=? ",
					new BeanHandler<Carinfo>(Carinfo.class),car.getCustom_id(),car.getGoods_id());
			//如果数据库有这个数据就更新数据库
			if(cars!=null){
				//将原来的数量改为现在的数量,不能为0;
				num=qr.execute(conn,"update carinfo set CarGoods_number = ? where custom_id =? and goods_id=?",
						car.getCarGoods_number(),car.getCustom_id(),car.getGoods_id());
			}else{//如果没有就插入一行数据
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return num;
		
	}
	
	/**
	 * 根据用户展示购物车
	 * @param custom_id
	 * @return
	 */
	 
	public List<Carinfo> showCar(Long custom_id){
		qr= new QueryRunner();
		conn = DBUtil.getConn();
		List<Carinfo> car = null;
		String sql="select c.*,g.goods_Img,s.shop_name,g.goods_Count,g.goods_desception,g.shop_id,"+
			 		"g.goods_OutputPrice from carinfo c , goodsinfo g,shopinfo s where s.shop_id = g.shop_id and  c.goods_id = g.goods_id and custom_id=?";
		try {
			car=qr.query(conn,sql,new BeanListHandler<Carinfo>(Carinfo.class),custom_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally{
//			if(conn!=null){
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
		return car;
		
	}
	
	/**
	 * 分页查询用户购物车的所有商品
	 * @param custom_id
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public List<Carinfo> showCar(Long custom_id, int startRow, int endRow) {
		qr = new QueryRunner();
		conn = DBUtil.getConn();
		List<Carinfo> car = null;
		String sql = "select tt.* from ( "
			 		+ "(select t.* , rownum rn from "
			 		+ "( select c.*,g.goods_Img,g.goods_count,g.goods_desception,g.shop_id,"+
			 		"g.goods_OutputPrice from carinfo c , goodsinfo g where c.goods_id = g.goods_id and custom_id=?) t ) tt )"
			 		+ "where tt.rn between ? and ? ";
		try {
			car=qr.query(conn,sql,new BeanListHandler<Carinfo>(Carinfo.class),custom_id,startRow,endRow);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conn != null){
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		return car;
	}
	
	/**
	 * 立即购买
	 * @param car
	 * @param custom_id
	 * @return
	 */
	public int BuyNow(Carinfo car,Long custom_id){
		conn = DBUtil.getConn();
		try {
			conn.setAutoCommit(false);
			qr = new QueryRunner();
			double money = 0;
			//先扣钱
			//计算总价格
			money += car.getGoods_OutputPrice()*car.getGoods_count()*car.getCarGoods_number();
			int um = qr.execute(conn, "update custominfo set custom_money = custom_money-? where custom_id= ?", money,custom_id);
			if(um==0){
				//如果钱不够则回滚
				conn.rollback();
				return -1;
			}
			//1. 插入订单信息
			//订单号
			String ocode = NumberUtil.getOrderCode();
			//插入订单
			int i = qr.execute(conn,"insert into orderinfo(Order_ID,custom_id,order_number,order_allprice) values(?,?,?,?)",ocode,custom_id,car.getCarGoods_number(),money);
			if(i>0){
				//是否插入成功
				Orderinfo order = qr.query(conn,"select * from  orderinfo where Order_ID=?",new BeanHandler<Orderinfo>(Orderinfo.class),ocode);
				if(order==null || order.getOrder_id()==0l){
					//不成功则回滚
					conn.rollback();
					return -1;
				}
				Long ocode1 = order.getOrder_id();
				//成功后插入订单详情表
				//总价为此订单总价格
				//获取商品id ,以及各类信息，插入订单详情表
				Long goods_id = car.getGoods_id();
				Goodsinfo goods = qr.query(conn, "select * from goodsinfo where goods_id = ? ", new BeanHandler<Goodsinfo>(Goodsinfo.class), goods_id)  ;
				System.out.println("goods : " + goods);
				String GOODS_DESCEPTION = goods.getGoods_Desception() ;
				String GOODS_IMG = goods.getGoods_Img();
				Double goods_count = goods.getGoods_Count() ; 
				Long shop_id = goods.getShop_id();
				Shopinfo shop = qr.query(conn, "select * from shopinfo where shop_id =  ? ", new BeanHandler<Shopinfo>(Shopinfo.class), shop_id) ;
				String shop_address = shop.getShop_address();
				String shop_name = shop.getShop_name() ; 
				
				Custominfo custom = qr.query(conn, "select * from custominfo where custom_id =  ? ", new BeanHandler<Custominfo>(Custominfo.class), custom_id) ;
				String custom_address = custom.getCustom_address();
				String custom_name = custom.getCustom_name() ;
				
				String sql =  "insert into orderGoods(Order_ID,goods_id,goods_number,ORDERGOODS_CHECKPAY,"
						+ "goods_price,goods_allprice , GOODS_COUNT,GOODS_IMG,GOODS_DESCEPTION,SHOP_ADDRESS,"
						+ "custom_address ,shop_name,custom_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?) " ;
				
				int num=qr.execute(conn,sql,ocode1,goods_id,car.getCarGoods_number(),1,car.getGoods_OutputPrice(),
						money,goods_count,GOODS_IMG,GOODS_DESCEPTION,shop_address,custom_address,shop_name,custom_name);
				
				System.out.println("-----------num:"+num);
				if(num==0){
					conn.rollback();
					return -1;
				}
				
				
				
				//减少商品库存增加销量
				int nu = qr.update(conn, "update goodsinfo set goods_sellCount = goods_sellCount+?, GOODS_REPERTORY = GOODS_REPERTORY-? where goods_id = ? ",car.getCarGoods_number(), car.getCarGoods_number(),goods_id);
				if(nu == 0){
					conn.rollback();
					return -1;
				} else{
					conn.commit();
					conn.close();
					return 1;
				}
			}else{
				conn.rollback();
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
		
	}
	
	/**
	 * 购物车提交订单
	 * @param userinfo
	 * @return  注册成功的话 返回受影响行数应该为 1
	 */
	public int submitCart(List<Carinfo> list,Long custom_id){
		conn = DBUtil.getConn();
		//不自动提交
		try {
			conn.setAutoCommit(false);
			qr = new QueryRunner(); 
			
			//先扣钱
			double money = 0;
			int count=0;
			for(Carinfo car:list){
				money += car.getGoods_OutputPrice()*car.getGoods_count()*car.getCarGoods_number();
				count += car.getCarGoods_number();
			}
			int um = qr.execute(conn, "update custominfo set custom_money = custom_money-? where custom_id= ?", money,custom_id);
			if(um==0){
				conn.rollback();
				return -1;
			}
			//1. 插入订单信息
			//订单号
			String ocode = NumberUtil.getOrderCode();
			int i = qr.execute(conn,"insert into orderinfo(Order_ID,custom_id,order_number,order_allprice) values(?,?,?,?)",ocode,custom_id,count,money);
			//获取插入订单是否成功
			if(i>0){
				Orderinfo order = qr.query(conn,"select * from  orderinfo where Order_ID=?",new BeanHandler<Orderinfo>(Orderinfo.class),ocode);
				if(order==null || order.getOrder_id()==0l){
					conn.rollback();
					return -1;
				}
//				Object[][] params = new Object[list.size()][4];
//				for(int k = 0;k<list.size();k++){
//					Carinfo car = list.get(k);
//					params[k][0]=order.getOrder_ID();
//					params[k][1]=car.getGoods_id();
//					params[k][2]=car.getCarGoods_number();
//					params[k][3]=car.getGoods_OutputPrice();
//				}
//				//2. 插入订单详情
//				int[] num = qr.batch(conn, "insert into orderGoods(Order_ID,goods_id,goods_number,goods_price) values(?,?,?,?)", params);
				Long ocode1 = order.getOrder_id();
				int sum =0;
				//增加商品详情
				int num=0;
				//减少库存
				int nu=0;
				String sql =  "insert into orderGoods(Order_ID,goods_id,goods_number,ORDERGOODS_CHECKPAY,"
						+ "goods_price,goods_allprice , GOODS_COUNT,GOODS_IMG,GOODS_DESCEPTION,SHOP_ADDRESS,"
						+ "custom_address ,shop_name,custom_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?) " ;
				for(Carinfo car : list){
					//获取购物车里的商品id 和他的属性
					Long goods_id = car.getGoods_id();
					Goodsinfo goods = qr.query(conn, "select * from goodsinfo where goods_id = ? ", new BeanHandler<Goodsinfo>(Goodsinfo.class), goods_id)  ;
					System.out.println("goods : " + goods);
					String GOODS_DESCEPTION = goods.getGoods_Desception() ;
					String GOODS_IMG = goods.getGoods_Img();
					Double goods_count = goods.getGoods_Count() ; 
					Long shop_id = goods.getShop_id();
					Shopinfo shop = qr.query(conn, "select * from shopinfo where shop_id =  ? ", new BeanHandler<Shopinfo>(Shopinfo.class), shop_id) ;
					String shop_address = shop.getShop_address();
					String shop_name = shop.getShop_name() ; 
					
					Custominfo custom = qr.query(conn, "select * from custominfo where custom_id =  ? ", new BeanHandler<Custominfo>(Custominfo.class), custom_id) ;
					String custom_address = custom.getCustom_address();
					String custom_name = custom.getCustom_name() ;
					num+=qr.execute(conn,sql,ocode1,goods_id,car.getCarGoods_number(),1,car.getGoods_OutputPrice(),
							money,goods_count,GOODS_IMG,GOODS_DESCEPTION,shop_address,custom_address,shop_name,custom_name);
					sum++;
					//减少商品库存
					 nu += qr.update(conn, "update goodsinfo set goods_sellCount = goods_sellCount+?, GOODS_REPERTORY = GOODS_REPERTORY-? where goods_id = ? ", car.getCarGoods_number(),car.getCarGoods_number(),goods_id);
					
					
				}

				if(sum==num && nu==sum){
					//说明批处理执行成功，说明  订单表数据之前已经插好了   订单详情表的所有数据插好了，
					//把数据库中的购物车数据删除掉
					int p =0;
					for(Carinfo car : list){
						 p += qr.execute(conn,"delete from carinfo where custom_id=? and goods_id=?" ,custom_id,car.getGoods_id());
					}
					
					if(p==list.size()){
						//购物车的条数就是这个删除的受影响行数的话就说明删除成功
						//如果都成功的话  就提交数据库
						conn.commit();
						conn.close();
						return 1;
					}
				}else{
					conn.rollback();
					return -1;
				}
			}else{
				conn.rollback();//如果有异常先回滚
				return -1;//如果订单都没有插入成功的话   就说明失败了  返回-1
			}
			
		} catch (SQLException e) {
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
		return -1;
		
	}
	
	
	
}
