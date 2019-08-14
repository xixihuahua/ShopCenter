package com.shop.Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.Dao.IGoodsTypeDao;
import com.shop.entity.GoodsType;
import com.shop.entity.Goodsinfo;
import com.shop.util.DBUtil;

 

public class GoodsTypeDaoImpl implements IGoodsTypeDao {

	/**
	 * 通过商品类型名查找商品类型
	 * @param goodsType_name
	 * @return
	 */
	 public GoodsType findGoodsTypeByTypeName(String goodsType_name) {
		 QueryRunner qr = new QueryRunner();
			Connection conn = DBUtil.getConn();
			 GoodsType goodsType = null ;
			String sql = "select * from goodsType where goodsType_name = ? ";
			 		
			try {
				goodsType = qr.query(conn, sql, new BeanHandler<GoodsType>(GoodsType.class),goodsType_name);
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
			return goodsType;
	}
	 /**
	 * 通过商品类型id 查找商品类型
	 * @param goodsType_id
	 * @return
	 */
	 public GoodsType findGoodsTypeByTypeId(Long goodsType_id) {
		 QueryRunner qr = new QueryRunner();
			Connection conn = DBUtil.getConn();
			 GoodsType goodsType = null ;
			String sql = "select * from goodsType where goodsType_id = ? " ;
			try {
				goodsType = qr.query(conn, sql, new BeanHandler<GoodsType>(GoodsType.class),goodsType_id);
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
			return goodsType;
	}
	/**
	 * 添加商品类型
	 * @param goodsType
	 * @return 
	 */
	public int addGoodsType(GoodsType goodstype) {
		return 0;
	}
	
	/**
	 * 删除商品类型
	 * @param goodsType_id
	 * @return
	 */
	public int deleteGoodsType(Long goodsType_id) {
		return 0;
	}
	/**
	 * 修改商品类型
	 * @param goodsType_id
	 * @return
	 */
	public int updateGoodsType(Long goodsType_id) {
		return 0;
	}
	/**
	 * 通过商品类型查找所有商品
	 * @param goodsType_id
	 * @return
	 */
	public List<Goodsinfo> findGoodsByType(Long goodsType_id){
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Goodsinfo> goods = null;
		String sql = "select * from goodsinfo where  goodstype_id in ( "+
				" select distinct  g1.goodstype_id from goodstype g1 , goodstype g2  ,goodstype g3   " +
				"  where g1.goodstype_id = ?  " +
				 " or ( g1.goodstype_upid = g2.goodstype_id " +
				" and   g2.goodstype_id = ? ) " +
				" or (g1.goodstype_upid = g2.goodstype_id "+
				 "  and  g2.goodstype_upid = g3.goodstype_id "+
				 "   and  g3.goodstype_id = ? ) ) ";
		try {
			goods = qr.query(conn, sql,new BeanListHandler<Goodsinfo>(Goodsinfo.class),goodsType_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return goods;
	}

	
	
	/**
	 * 分页查询   goodsType_name的所有商品
	 * @param goodsType_name
	 * @param startRow
	 * @param endRow
	 * @return 当前页可展示的信息
	 */
	@Override
	public List<Goodsinfo> SelectfindGoodsByType(String goodsType_name, int startRow,
			int endRow) {
		QueryRunner qr = new QueryRunner();
		 Connection conn = DBUtil.getConn();
		 List<Goodsinfo> list = null ;
	 
		 String sql = "select tt.* from ( (select t.* , rownum rn from  ( select g.*,s.shop_address,s.shop_name,se.seller_name " +
       " from goodsinfo g,shopinfo s,sellerinfo se   where g.shop_id=s.shop_id and s.seller_id = se.seller_id " +
       " and  g.goodstype_id in (  select   g1.goodstype_id from goodstype g1 , goodstype g2  ,goodstype g3   " +
       " where g1.goodstype_name = ? or ( g1.goodstype_upid = g2.goodstype_id  and   g2.goodstype_name = ? )  or " +
       " (g1.goodstype_upid = g2.goodstype_id and  g2.goodstype_upid = g3.goodstype_id and  g3.goodstype_name = ? )  " +
       " ) ) t ) tt )  where tt.rn between ? and ? ";
		 try {
			list = qr.query(conn, sql, new BeanListHandler<Goodsinfo>(Goodsinfo.class),goodsType_name,goodsType_name,goodsType_name,startRow,endRow);
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
		return list;
	}
	
	
	/**
	 * 通过商品类型名字  查找所有商品
	 * @param goodsType_id
	 * @return
	 */
	public List<Goodsinfo> findGoodsByTypeName(String goodsType_name) {
		// TODO Auto-generated method stub
				QueryRunner qr = new QueryRunner();
				Connection conn = DBUtil.getConn();
				List<Goodsinfo> goods = null;
				String sql = "select * from goodsinfo where  goodstype_id in ( "+
						" select distinct  g1.goodstype_id from goodstype g1 , goodstype g2  ,goodstype g3   " +
						"  where g1.goodstype_name = ?  " +
						 " or ( g1.goodstype_upid = g2.goodstype_id " +
						" and   g2.goodstype_name = ? ) " +
						" or (g1.goodstype_upid = g2.goodstype_id "+
						 "  and  g2.goodstype_upid = g3.goodstype_id "+
						 "   and  g3.goodstype_name = ? ) ) ";
				try {
					goods = qr.query(conn, sql,new BeanListHandler<Goodsinfo>(Goodsinfo.class),goodsType_name,goodsType_name,goodsType_name);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(conn != null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				return goods;
	}
}
