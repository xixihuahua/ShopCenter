package com.shop.Service.impl;

import java.util.List;

import com.shop.Dao.ICommentDao;
import com.shop.Dao.impl.CommentDaoImpl;
import com.shop.Service.ICommentService;
import com.shop.entity.Commentinfo;

public class CommentServiceImpl implements ICommentService{
	ICommentDao commentdao = new CommentDaoImpl();
	/**
	 * 买家评论
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	public boolean addComment(Long custom_id , Long order_id , Long goods_id , String comment_content) {
		return commentdao.addComment(custom_id, order_id, goods_id, comment_content) > 0 ;
	}
	/**
	 * 删除评价
	 * @param custom_id
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	public boolean deleteComment(Long comment_id ) {
		return commentdao.deleteComment(comment_id) > 0;
	}
	
	/**
	 * 更改评价
	 * @param custom_id
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	public boolean updateComment(Long comment_id ,  String comment_content) {
		return commentdao.updateComment(comment_id, comment_content) > 0 ;
	}
	
	/*
	 * 根据商品id查找评论
	 */
	public List<Commentinfo> findCommentByGoods_id(Long goods_id) {
		return commentdao.findCommentByGoods_id(goods_id);
	}
	
	/*
	 * 根据买家id查找评论
	 */
	public	List<Commentinfo> findCommentByCustom_id(Long custom_id) {
		return commentdao.findCommentByCustom_id(custom_id);
	}
}
