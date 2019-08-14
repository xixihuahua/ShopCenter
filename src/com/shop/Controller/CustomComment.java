package com.shop.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.shop.Service.ICommentService;
import com.shop.Service.IOrderGoodsService;
import com.shop.Service.impl.CommentServiceImpl;
import com.shop.Service.impl.OrderGoodsServiceImpl;
import com.shop.entity.Commentinfo;
import com.shop.entity.Custominfo;


public class CustomComment extends CenterServlet {
	ICommentService commentService = new CommentServiceImpl();
	IOrderGoodsService ordergoodsService = new OrderGoodsServiceImpl();
	
	//买家写评论
	public void addComment(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		Long order_id = new Long(request.getParameter("order_id"));
		Long goods_id = new Long(request.getParameter("goods_id"));
		String comment_content = request.getParameter("comment_content");
		
		Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
		Long custom_id = customer.getCustom_id();
		
		if(comment_content == null ){
			comment_content = "用户默认好评";
		}
		//非空判断
		if(order_id != null && goods_id != null){
			if (commentService.addComment(custom_id, order_id, goods_id, comment_content)) {
				System.out.println("评论成功");
				//评论成功后，修改订单状态/
				 if(ordergoodsService.ChangeCustomComment(order_id, goods_id)>0){
					 System.out.println("订单评论状态修改成功");
				 }else{
					 System.out.println("评论状态修改失败");
				 }
				request.getRequestDispatcher("custom/customCenter.jsp").forward(request, response);
			}else{
				System.out.println("评论失败");
				request.getRequestDispatcher("custom/customCenter.jsp").forward(request, response);
			}
		 }
	 }
	
	 
	/**
	 * 通过商品显示评论
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCommentByGoods_id(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		Long goods_id = new Long(request.getParameter("goods_id"));
		
		if(goods_id != null ){
			
			List<Commentinfo> list = commentService.findCommentByGoods_id(goods_id) ;
			System.out.println(list);
			  //将集合转换为json格式
			JSONArray arr = new JSONArray(list);
			response.getWriter().print(arr);
		}else{
			System.out.println("商品id为空");
		}
	 }
	
	
	/**
	 * 根据用户id查找该用户的所有评论
	 */
	public void findCommentByCustom_id(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
		System.out.println("customer : " + customer);
		
		if(customer != null){
			Long custom_id = customer.getCustom_id();
			List<Commentinfo> list = commentService.findCommentByCustom_id(custom_id);
			//集合转换为json格式
			JSONArray arr = new JSONArray(list);
			response.getWriter().print(arr);
		}else{
			System.out.println("请先登陆");
			response.getWriter().print("请先登录");
		}
	}
	

}
