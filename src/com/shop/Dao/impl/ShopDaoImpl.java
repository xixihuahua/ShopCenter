package com.shop.Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.Dao.IShopDao;
import com.shop.entity.Shopinfo;
import com.shop.util.DBUtil;
 



public class ShopDaoImpl implements IShopDao {
	
	/**
	 * 查询所有店铺
	 * @return
	 */
	@Override
	public List<Shopinfo> findAllShop() {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Shopinfo> list = null ;
		String sql = "select * from shopinfo " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Shopinfo>(Shopinfo.class));
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
	 * 查询seller_id的所有店铺
	 * @param Sller_id
	 * @return
	 */
	@Override
	public List<Shopinfo> findShopBySellerId(Long seller_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Shopinfo> list = null ;
		String sql = "select * from shopinfo where seller_id = ? " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Shopinfo>(Shopinfo.class),seller_id);
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
	 * 根据店铺名字查询店铺(模糊查询)
	 * @param Shopinfo_name
	 * @return
	 */
	@Override
	public List<Shopinfo> findShopByShopName(String shop_name) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Shopinfo> list = null ;
		String de = "%"+shop_name+"%";
		String sql = "select * from shopinfo where shop_name like ? " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Shopinfo>(Shopinfo.class),de);
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
	 * Ajax根据店铺名字查询店铺,查看是否有同名店铺
	 * @param Shopinfo_name
	 * @return
	 */
	public Shopinfo findShopByShopNa(String shop_name) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Shopinfo shop = null ;
		String sql = "select * from shopinfo where shop_name = ? " ;
		try {
			shop = qr.query(conn, sql, new BeanHandler<Shopinfo>(Shopinfo.class),shop_name);
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
		return shop;
	}
	
	
	/**
	 * 根据店铺id查询店铺
	 * @param Shopinfo_id
	 * @return
	 */
	@Override
	public Shopinfo findShopByShopId(Long shop_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Shopinfo shop = null ;
		String sql = "select * from shopinfo where shop_id = ? " ;
		try {
			shop = qr.query(conn, sql, new BeanHandler<Shopinfo>(Shopinfo.class),shop_id);
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
		return shop;
	}
	
	/**
	 * 创建店铺
	 * @param Shopinfo
	 * @return
	 */
	@Override
	public int addShop(Shopinfo shop) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "insert into shopinfo(shop_id,seller_id,shop_name,shop_img,shop_address) "
				+ "values(shop_id_seq.nextval,?,?,?,?)" ;
		try {
			num = qr.update(conn, sql,shop.getSeller_id(), shop.getShop_name(),
					shop.getShop_img(),shop.getShop_address());
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
	 * 删除店铺
	 */
	@Override
	public int deleteShop(Long shop_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "delete from shopinfo  where shop_id = ?  " ;
		try {
			num = qr.update(conn, sql,shop_id );
			//System.out.println("daoimpl custom : " + custom);
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
	 * 修改店铺基本信息
	 */
	@Override
	public int updateShopinfo(Shopinfo shop) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update shopinfo set shop_name = ? ,shop_address = ?  where shop_id = ? " ;
		try {
			num = qr.update(conn, sql, shop.getShop_name(),shop.getShop_address(),
				   shop.getShop_id());
		 
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
	 * 分页查询该商家id下的所有店铺
	 */
	@Override
	public List<Shopinfo> shopSelect(Long seller_id, int startRow, int endRow) {
		 QueryRunner qr = new QueryRunner();
		 Connection conn = DBUtil.getConn();
		 List<Shopinfo> list = null ;
		 String sql = "select tt.* from ( "
		 		+ "(select t.* , rownum rn from "
		 		+ "( select * from shopinfo where seller_id= ? order by shop_regtime desc) t ) tt )"
		 		+ "where tt.rn between ? and ? ";
		 try {
			list = qr.query(conn, sql, new BeanListHandler<Shopinfo>(Shopinfo.class), seller_id,startRow,endRow);
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
	 * 分页查询 符合搜索框内关键字的店铺
	 */
	@Override
	public List<Shopinfo> shopSelect(String shop_name, int startRow, int endRow) {
		 QueryRunner qr = new QueryRunner();
		 Connection conn = DBUtil.getConn();
		 List<Shopinfo> list = null ;
		 String de = "%"+shop_name+"%";
		 String sql = "select tt.* from ( "
		 		+ "(select t.* , rownum rn from "
		 		+ "( select s.*,se.seller_name from shopinfo s ,sellerinfo se where s.seller_id=se.seller_id and shop_name like ? order by shop_regtime desc) t ) tt )"
		 		+ "where tt.rn between ? and ? ";
		 try {
			list = qr.query(conn, sql, new BeanListHandler<Shopinfo>(Shopinfo.class), de,startRow,endRow);
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

	 //上传店铺图片
	@Override
	public int uploadShopImg(Shopinfo shop) {
		QueryRunner qr=new QueryRunner();
		Connection conn=DBUtil.getConn();
		int num=0;
		String sql="update shopinfo set shop_img = ? where shop_id = ?";
		try {
			num=qr.update(conn, sql, shop.getShop_img(),shop.getShop_id());
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
	 

}
