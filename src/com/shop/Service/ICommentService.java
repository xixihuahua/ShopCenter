package com.shop.Service;

import java.util.List;

import com.shop.entity.Commentinfo;

public interface ICommentService {
	/**
	 * 买家评论
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	boolean addComment(Long custom_id , Long order_id , Long goods_id , String comment_content);
	/**
	 * 删除评价
	 * @param custom_id
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	boolean deleteComment(Long comment_id );
	
	/**
	 * 更改评价
	 * @param custom_id
	 * @param order_id
	 * @param goods_id
	 * @param comment_content
	 * @return
	 */
	boolean updateComment(Long comment_id ,  String comment_content);
	
	/*
	 * 根据商品id查找评论
	 */
	List<Commentinfo> findCommentByGoods_id(Long goods_id);
	
	/*
	 * 根据买家id查找评论
	 */
	List<Commentinfo> findCommentByCustom_id(Long custom_id);
}
