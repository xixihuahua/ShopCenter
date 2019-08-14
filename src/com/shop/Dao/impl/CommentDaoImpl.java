package com.shop.Dao.impl;

 

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.Dao.ICommentDao;
import com.shop.entity.Commentinfo;
import com.shop.util.DBUtil;

public class CommentDaoImpl implements ICommentDao{
	/**
	 * 买家评论
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	public int addComment(Long custom_id , Long order_id , Long goods_id , String comment_content) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn() ;
		 String sql = " insert into   commentinfo (comment_id , custom_id , order_id,goods_id , comment_content) "
				+ "values(comment_ID_seq.nextval ,? , ? , ? ,  ?) " ;
		
		 int num = 0 ; 
		 
		 try {
			num = qr.update(conn, sql, custom_id,order_id , goods_id , comment_content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn != null ){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			
		}
		 return num ; 
		 
	}
	/**
	 * 删除评价
	 * @param custom_id
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	public int deleteComment(Long comment_id ) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn() ;
		 String sql = "delete from commentinfo where comment_id = ?" ;
		
		 int num = 0 ; 
		 
			try {
				num = qr.update(conn, sql, comment_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		 
		 return num ; 
	}
	
	/**
	 * 更改评价
	 * @param custom_id
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	public int updateComment(Long comment_id , String comment_content) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn() ;
		 String sql = " update commentinfo set comment_content = ?   where comment_id = ? " ;
		
		 int num = 0 ; 
		 
			try {
				num = qr.update(conn, sql, comment_content ,comment_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		 
		 return num ; 
	 }
	/*
	 * 根据商品id查找评论
	 */
	public List<Commentinfo> findCommentByGoods_id(Long goods_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn() ;
		 String sql = " select * from  commentinfo     where goods_id = ? " ;
		
		 List<Commentinfo> list = null ; 
		 
			try {
				list = qr.query(conn, sql, new BeanListHandler<Commentinfo>(Commentinfo.class) ,goods_id );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		 
		 return list ; 
	}
	
	/*
	 * 根据买家id查找评论
	 */
	public List<Commentinfo> findCommentByCustom_id(Long custom_id) {
		QueryRunner qr = new QueryRunner();
		Connection conn = DBUtil.getConn() ;
		 String sql = " select * from  commentinfo  where custom_id = ? " ;
		
		 List<Commentinfo> list = null ; 
		 
			try {
				list = qr.query(conn, sql, new BeanListHandler<Commentinfo>(Commentinfo.class) ,custom_id );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		 
		 return list ;
	}
	
}
