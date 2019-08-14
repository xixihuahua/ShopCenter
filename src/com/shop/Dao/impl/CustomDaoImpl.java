package com.shop.Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.Dao.ICustomDao;
import com.shop.entity.Custominfo;
import com.shop.util.DBUtil;

public class CustomDaoImpl implements ICustomDao{
	 
	
	/**
	 * 根据用户id 查询用户信息
	 */
	public Custominfo findCustomById(Long custom_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Custominfo custom = null ;
		try {
			custom = qr.query(conn,"select * from custominfo where custom_id = ?",new BeanHandler<Custominfo>(Custominfo.class),custom_id);
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
		
		return custom;
	}
	
	/**
	 * 通过订单编号查找用户
	 * 登陆
	 * @param Custom_name Custom_password
	 * @return
	 */
	public Custominfo findCustomByOrder_id(Long order_id){
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Custominfo custom = null ;
		try {
			custom = qr.query(conn,"select * from custominfo where custom_id = "
					+ "(select custom_id from orderinfo where order_id = ?)",new BeanHandler<Custominfo>(Custominfo.class),order_id);
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
		
		return custom;
	 }
	
		
	/**
	 * 通过买家名查找用户
	 * 登陆
	 * @param Custom_name Custom_password
	 * @return
	 */
	public Custominfo findCustomByName(String custom_name,String custom_password){
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Custominfo custom = null ;
		String sql = "select * from custominfo where custom_name = ? and custom_password = ?" ;
		try {
			custom = qr.query(conn, sql, new BeanHandler<Custominfo>(Custominfo.class), custom_name,custom_password);
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
		return custom;
		
		
	}
	/**
	 * 通过买家id查找用户
	 * 登陆
	 * @param  Custom_id Custom_password
	 * @return
	 */
	public Custominfo findCustomById(Long custom_id ,String custom_password){
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Custominfo custom = null ;
		String sql = "select * from custominfo where custom_id = ? and custom_password = ?" ;
		try {
			custom = qr.query(conn, sql, new BeanHandler<Custominfo>(Custominfo.class), custom_id,custom_password);
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
		return custom;
		
	} 
	
	
	     /**
		 * 根据买家id 
		 * @param custom_id
		 * @return
		 */
	public Custominfo findById(Long custom_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		Custominfo custom = null ;
		String sql = "select * from custominfo where custom_id = ?" ;
		try {
			custom = qr.query(conn, sql, new BeanHandler<Custominfo>(Custominfo.class), custom_id);
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
		return custom;
	}
		
		/**
		 * 根据买家名字
		 * @param custom_name
		 * @return
		 */
		public Custominfo findByName(String custom_name) {
			QueryRunner qr = new QueryRunner();
			Connection conn = DBUtil.getConn();
			Custominfo custom = null ;
			String sql = "select * from custominfo where custom_name = ? " ;
			try {
				custom = qr.query(conn, sql, new BeanHandler<Custominfo>(Custominfo.class), custom_name);
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
			return custom;
		}
 
	
	/**
	 * 添加买家 （用户注册）
	 * @param Custom
	 * @return
	 */
	public int addCustom(Custominfo custom){
		
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "insert into custominfo(custom_id,custom_name,custom_password,"
				+ "custom_sex,custom_age,custom_tel,custom_address,custom_email,"
				+ "custom_paypwd) values(customid_seq.nextval,?,?,?,?,?,?,?,?)" ;
		try {
			num = qr.update(conn, sql, custom.getCustom_name(),custom.getCustom_password(),
				custom.getCustom_sex(),custom.getCustom_age(),custom.getCustom_tel(),
				custom.getCustom_address(),custom.getCustom_email(),custom.getCustom_paypwd());
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
	 * 更新买家基本信息 (修改用户信息)
	 * @param Custom
	 * @return
	 */
	public int updateCustom(Custominfo custom) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update custominfo set custom_name = ? , custom_sex = ? , custom_age = ? , "
				+ "custom_address = ? ,custom_email = ?    where custom_id = ?  " ;
		try {
			num = qr.update(conn, sql, custom.getCustom_name(),
				custom.getCustom_sex(),custom.getCustom_age(),
				custom.getCustom_address(),custom.getCustom_email(),custom.getCustom_id());
		 
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
	 * 更新买家 绑定的手机
	 * @param custom
	 * @return
	 */
	public int updateCustomTel(Long custom_id , String custom_tel) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update custominfo set custom_tel = ? where custom_id = ?  " ;
		try {
			num = qr.update(conn, sql,custom_tel,custom_id);
		 
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
	 * 更新买家 头像
	 * @param custom 
	 * @return
	 */
	public int updateCustomImg(Long custom_id , String custom_img) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update custominfo set custom_img = ? where custom_id = ?  " ;
		try {
			num = qr.update(conn, sql,custom_img ,custom_id);
		 
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
	 * 更新买家支付密码
	 * @param custom
	 * @return
	 */
	public int updateCustomPayPwd(Long custom_id , String custom_paypwd) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "update custominfo set custom_paypwd = ? where custom_id = ?  " ;
		try {
			num = qr.update(conn, sql,custom_paypwd ,custom_id);
		 
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
	 * @param custom_id
	 * @return
	 */
	public int deleteCustom(Long custom_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		int num = 0 ;
		String sql = "delete from custominfo  where custom_id = ?  " ;
		try {
			num = qr.update(conn, sql,custom_id );
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
	 * @param custom_id
	 * @param custom_email
	 * @return
	 * @throws SQLException 
	 */
	public int updateCustomPwd(String custom_password,Long custom_id, String custom_email){
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		String sql = "update custominfo set custom_password= ? where custom_id=? and custom_email=?";
		int num = 0;
		try {
			num=qr.update(conn, sql,custom_password,custom_id,custom_email);
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
	 * @param custom_name
	 * @param custom_email
	 * @return
	 */
	public int updateCustomPwd(String custom_password,String custom_name, String custom_email) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		
		int num = 0;
		try {
			System.out.println("custom_password:"+custom_password+"---custom_name:"+custom_name+"==="+custom_email);
			num=qr.update(conn, "update custominfo set custom_password = ? where custom_name= ? and custom_email=?",custom_password,custom_name,custom_email);
			
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
	 * 超级管理员  ： 显示所有用户
	 * @return
	 */
	public List<Custominfo> findAllCustom(){
		
		// TODO Auto-generated method stub
				QueryRunner qr = new QueryRunner();
				Connection conn = DBUtil.getConn();
				
				List<Custominfo> list = null ;
				String sql = "select * from custominfo " ;
				try {
					 	list=qr.query(conn, sql, new BeanListHandler<Custominfo>(Custominfo.class));
					
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
				return list;
	 } 
	
	//修改账户余额
	public int updateCustomMoney(Long custom_id , Double money) {
		 
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn();
		
		int num = 0;
		try {
			 num=qr.update(conn, "update custominfo set custom_money = custom_money+?  where custom_id = ? ", money ,custom_id );
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
	 
	
}
