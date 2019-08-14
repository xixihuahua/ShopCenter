package com.shop.Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.shop.Dao.ISellerDao;
import com.shop.entity.Sellerinfo;
import com.shop.util.DBUtil;
 
/**
 * 用户登录操作
 *
 */
public class SellerDaoImpl implements ISellerDao {
	 
	/**
	 * 通过卖家名查找用户
	 * 登陆
	 * @param seller_name seller_password
	 * @return
	 */
	public Sellerinfo findSellerByName(String seller_name,String seller_password) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Sellerinfo seller = null ;
		String sql = "select * from sellerinfo where seller_name = ? and seller_password = ?" ;
		try {
			seller = qr.query(conn, sql, new BeanHandler<Sellerinfo>(Sellerinfo.class), seller_name,seller_password);
			//System.out.println("daoimpl seller : " + seller);
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
		return seller;
	} 
	
	/**
	 * 通过卖家id查找用户
	 */
	@Override
	public Sellerinfo findById(Long seller_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Sellerinfo seller = null ;
		String sql = "select * from sellerinfo where seller_id = ? " ;
		try {
			seller = qr.query(conn, sql, new BeanHandler<Sellerinfo>(Sellerinfo.class), seller_id);
			//System.out.println("daoimpl seller : " + seller);
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
		return seller;
	}
	
	@Override
	public Sellerinfo findByName(String seller_name) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Sellerinfo seller = null ;
		String sql = "select * from sellerinfo where seller_name = ? " ;
		try {
			seller = qr.query(conn, sql, new BeanHandler<Sellerinfo>(Sellerinfo.class), seller_name);
			//System.out.println("daoimpl seller : " + seller);
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
		return seller;
	}
	
	
	/**
	 * 通过卖家id查找用户
	 * 登陆
	 * @param  seller_id seller_password
	 * @return
	 */
	public Sellerinfo findSellerById(Long seller_id ,String seller_password) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Sellerinfo seller = null ;
		String sql = "select * from sellerinfo where seller_id = ? and seller_password = ?" ;
		try {
			seller = qr.query(conn, sql, new BeanHandler<Sellerinfo>(Sellerinfo.class), seller_id,seller_password);
			//System.out.println("daoimpl seller : " + seller);
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
		return seller;
	} 
	/**
	 * 添加卖家 （用户注册）
	 * @param seller
	 * @return
	 */
	public int addSeller(Sellerinfo seller) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "insert into sellerinfo(seller_id,seller_name,seller_password,"
				+ "seller_sex,seller_age,seller_tel,seller_address,seller_email) "
				+ "values(seller_id_seq.nextval,?,?,?,?,?,?,?)" ;
		try {
			num = qr.update(conn, sql, seller.getSeller_name(),seller.getSeller_password(),
				seller.getSeller_sex(),seller.getSeller_age(),seller.getSeller_tel(),
				seller.getSeller_address(),seller.getSeller_email());
			//System.out.println("daoimpl seller : " + seller);
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
	 * 更新卖家基本信息 (修改用户信息)
	 * @param seller
	 * @return
	 */
	public int updateSeller(Sellerinfo seller) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update sellerinfo set seller_name = ?  ,"
				+ "seller_sex = ?,seller_age = ? ,seller_address = ?,"
				+ "seller_email = ? where seller_id = ?  " ;
		try {
			num = qr.update(conn, sql, seller.getSeller_name(),
				seller.getSeller_sex(),seller.getSeller_age(),
				seller.getSeller_address(),seller.getSeller_email(),
				   seller.getSeller_id());
		 
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
	 * 更新卖家 绑定的手机
	 * @param seller
	 * @return
	 */
	public int updateSellerTel(Long seller_id , String seller_tel) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update sellerinfo set seller_tel = ? where seller_id = ?  " ;
		try {
			num = qr.update(conn, sql, seller_tel , seller_id);
		 
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
	 * 更新卖家 头像
	 * @param seller
	 * @return
	 */
	public int updateSellerImg(Long seller_id , String seller_img) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update sellerinfo set seller_img = ? where seller_id = ?  " ;
		try {
			num = qr.update(conn, sql, seller_img , seller_id);
		 
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
	 * 删除用户（注销账号）
	 * @param seller_id
	 * @return
	 */
	public int deleteSeller(Long seller_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "delete from sellerinfo  where seller_id = ?  " ;
		try {
			num = qr.update(conn, sql,seller_id );
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
	 * 根据账号id和邮箱修改密码
	 * @param seller_id
	 * @param seller_email
	 * @return
	 * @throws SQLException 
	 */
	public int updateSellerPwd(String seller_password,Long seller_id, String seller_email){
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		String sql = "update sellerinfo set seller_password= ? where seller_id=? and seller_email=?";
		int num = 0;
		try {
			num=qr.update(conn, sql,seller_password,seller_id,seller_email);
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
		return num;
	}
	
	/**
	 * 根据账号名和邮箱修改密码
	 * @param seller_name
	 * @param seller_email
	 * @return
	 */
	public int updateSellerPwd(String seller_password,String seller_name, String seller_email) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		
		int num = 0;
		try {
			System.out.println("seller_password:"+seller_password+"---seller_name:"+seller_name+"==="+seller_email);
			num=qr.update(conn, "update sellerinfo set seller_password = ? where seller_name= ? and seller_email=?",seller_password,seller_name,seller_email);
			
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
		return num;
	}

	@Override
	public int uploadSellerImg(Sellerinfo seller) {
		QueryRunner qr=new QueryRunner();
		Connection conn=DBUtil.getConn();
		int num=0;
		String sql="update sellerinfo set seller_img = ? where seller_id = ?";
		try {
			num=qr.update(conn, sql, seller.getSeller_img(),seller.getSeller_id());
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
