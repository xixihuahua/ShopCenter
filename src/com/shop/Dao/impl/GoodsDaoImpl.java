package com.shop.Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.Dao.IGoodsDao;
import com.shop.entity.Goodsinfo;
import com.shop.util.DBUtil;

public class GoodsDaoImpl implements IGoodsDao {
	/**
	 * 查询所有商品
	 * @return
	 */
	public List<Goodsinfo> findAllGoods() {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Goodsinfo> list = null ;
		String sql = "select g.*,s.shop_name,s.shop_address,se.seller_name,se.seller_tel from goodsinfo g, shopinfo s,sellerinfo se where g.shop_id=s.shop_id and s.seller_id = se.seller_id " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Goodsinfo>(Goodsinfo.class));
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
	 * 通过店铺id显示商品
	 * 在店铺内显示所有商品
	 * @param store_id
	 * @return
	 */
	public List<Goodsinfo> findGoodsByShopId(Long shop_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Goodsinfo> list = null ;
		String sql = "select * from goodsinfo where shop_id = ? " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Goodsinfo>(Goodsinfo.class),shop_id);
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
	 * 根据商品描述查询商品
	 * 模糊查询
	 * @param goods_desception
	 * @return
	 */
	public List<Goodsinfo> findGoodsByName(String goods_desception) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		List<Goodsinfo> list = null ;
		String de = "%"+goods_desception+"%";
		String sql = "select * from goodsinfo where goods_desception like  ? " ;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Goodsinfo>(Goodsinfo.class),de);
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
	 * 根据商品描述查询商品(判断商品描述是否一样)
	 * @param goods_desception
	 * @return
	 */
	public Goodsinfo findGoodsByDe(String goods_desception) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Goodsinfo goods = null ;
		 
		String sql = "select * from goodsinfo where goods_desception =  ? " ;
		try {
			goods = qr.query(conn, sql, new BeanHandler<Goodsinfo>(Goodsinfo.class),goods_desception);
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
		return goods;
	}
	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	public int addGoods(Goodsinfo goods) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "insert into goodsinfo(goods_id,shop_id,goodsType_id,Goods_Repertory,Goods_Img,"
				+ "Goods_Desception , Goods_InputPrice,Goods_OutputPrice,Goods_count,goods_status) "
				+ "values(goods_id_seq.nextval,?,?,?,?,?,?,?,?,?)" ;
		try {
			num = qr.update(conn, sql,goods.getShop_id(),goods.getGoodsType_id(),goods.getGoods_Repertory(),
					 goods.getGoods_Img(),goods.getGoods_Desception(),goods.getGoods_InputPrice(),goods.getGoods_OutputPrice(),
					 goods.getGoods_Count(),goods.getGoods_Status());
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
	 * 删除商品
	 * @param goods_id
	 * @return
	 */
	public int deleteGoods(Long goods_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "delete from goodsinfo  where goods_id = ?  " ;
		try {
			num = qr.update(conn, sql,goods_id );
			 
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
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	public int updateGoods(Goodsinfo goods) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update goodsinfo set goodsType_id = ? ,Goods_Repertory = ?,"
				+ "Goods_Desception = ? ,Goods_OutputPrice = ?,Goods_InputPrice=? ,Goods_count = ? ,goods_status = ? where goods_id=?" ;
				 
		try {
			num = qr.update(conn, sql,goods.getGoodsType_id(),goods.getGoods_Repertory(),
					 goods.getGoods_Desception(),goods.getGoods_OutputPrice(),goods.getGoods_InputPrice(),
					 goods.getGoods_Count(),goods.getGoods_Status(),goods.getGoods_id());
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
	 * 分页查询shop_id的所有商品
	 * @param shop_id
	 * @param startRow
	 * @param endRow
	 * @return 当前页可展示的信息
	 */
	@Override
	public List<Goodsinfo> goodsSelect(Long shop_id, int startRow, int endRow) {
		QueryRunner qr = new QueryRunner();
		 Connection conn = DBUtil.getConn();
		 List<Goodsinfo> list = null ;
		 String sql = "select tt.* from ( "
			 		+ "(select t.* , rownum rn from "
			 		+ "( select g.*,s.shop_address,s.shop_name,se.seller_name from goodsinfo g,shopinfo s,sellerinfo se "
			 		+ "where g.shop_id=s.shop_id and s.seller_id = se.seller_id and g.shop_id=?  order by goods_time desc) t ) tt ) "
			 		+ "where tt.rn between ? and ? ";
		 try {
			list = qr.query(conn, sql, new BeanListHandler<Goodsinfo>(Goodsinfo.class), shop_id,startRow,endRow);
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
	 * 通过商品id显示商品
	 * 在店铺内显示所有商品
	 * @param goods_id
	 * @return
	 */
	@Override
	public Goodsinfo findGoodsById(Long goods_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Goodsinfo goods = null ;
		String sql = "select g.*,gt.goodsType_name,s.shop_address,s.shop_name from goodsType gt, goodsinfo g ,shopinfo s where g.shop_id=s.shop_id and g.goodsType_id = gt.goodsType_id and goods_id = ? " ;
		try {
			goods = qr.query(conn, sql, new BeanHandler<Goodsinfo>(Goodsinfo.class),goods_id);
			 
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
		return goods;
	}
	
	
	/**
	 * 分页查询goods_desception的所有商品
	 * @param goods_desception
	 * @param startRow
	 * @param endRow
	 * @return 当前页可展示的信息
	 */
	@Override
	public List<Goodsinfo> goodsSelect(String goods_desception, int startRow,
			int endRow) {
		QueryRunner qr = new QueryRunner();
		 Connection conn = DBUtil.getConn();
		 List<Goodsinfo> list = null ;
		 String de = "%"+goods_desception+"%";
		 String sql = "select tt.* from ( "
		 		+ "(select t.* , rownum rn from "
		 		+ "( select g.*,s.shop_address,s.shop_name,se.seller_name from goodsinfo g,shopinfo s,sellerinfo se "
		 		+ "where g.shop_id=s.shop_id and s.seller_id = se.seller_id and goods_desception like ? order by goods_time desc) t ) tt ) "
		 		+ "where tt.rn between ? and ? ";
		 try {
			list = qr.query(conn, sql, new BeanListHandler<Goodsinfo>(Goodsinfo.class),de,startRow,endRow);
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
	 * 上传商品图片
	 */
	@Override
	public int uploadGoodsImg(Goodsinfo goods) {
		QueryRunner qr=new QueryRunner();
		Connection conn=DBUtil.getConn();
		int num=0;
		String sql="update goodsinfo set goods_img = ? where goods_id = ?";
		try {
			num=qr.update(conn, sql, goods.getGoods_Img(),goods.getGoods_id());
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
