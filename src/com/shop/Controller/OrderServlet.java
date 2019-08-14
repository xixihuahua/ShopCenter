package com.shop.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.shop.Service.impl.OrderServiceImpl;
import com.shop.entity.Custominfo;
import com.shop.entity.OrderGoods;
import com.shop.entity.Orderinfo;
import com.shop.entity.Sellerinfo;

public class OrderServlet extends CenterServlet {
		OrderServiceImpl orderService = new OrderServiceImpl();
		
		 /**
		 * 通过买家id，查找该买家的所有订单
		 * @param request
		 * @param response
		 * @throws IOException 
		 * @throws ServletException 
		 */
			public void orderByCustomId(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
				//获取买家id和买家支付信息
				Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");

				
				 /**
				 * 非空判断
				 */
				if(custom != null){
					Long custom_id = custom.getCustom_id();
					System.out.println("custom_id=" + custom_id);
					//调用service层查询该买家已支付/未支付的订单
					List<Orderinfo> list =  orderService.findByCustomId(custom_id);
					System.out.println(list);
					JSONArray order = new JSONArray(list);
//					request.setAttribute("order", order);
					System.out.println(order);
					response.getWriter().print(order);
					//request.setAttribute("order", list);
					//request.getRequestDispatcher("custom/customOrder.jsp").forward(request, response);
				}else{
					response.getWriter().print("请登录");
				}
				
			 }
			 
			
			/**
			 * 根据商家id查询所有订单
			 * @param seller_id
			 * @return
			 * @throws IOException 
			 * @throws ServletException 
			 */
		//	public List<Orderinfo> findBySerllerId(Long seller_id)
		public void orderBySellerId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			Sellerinfo  seller = (Sellerinfo) request.getSession().getAttribute("seller");
			if(seller != null){
				Long seller_id = seller.getSeller_id();
				System.out.println("seller_id=" + seller_id);
				//调用service层查询该买家已支付/未支付的订单
				List<Orderinfo> list =  orderService.findBySerllerId(seller_id);
				System.out.println(list);
				request.setAttribute("list", list);
				JSONArray order = new JSONArray(list);
				response.getWriter().print(order);
				request.getRequestDispatcher("seller/sellerOrder.jsp").forward(request, response);
			}else{
				response.getWriter().print("请登录");
			}
		}

						
	/**
	 * 通过订单id，查找
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
		public void findByOrderId(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
			//获取orderid
			Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");
			Sellerinfo seller= (Sellerinfo) request.getSession().getAttribute("seller");
			String order_id = request.getParameter("order_id");
			System.out.println("--------"+order_id);
			System.out.println(seller);
			System.out.println(custom);
			/**
			 * 非空判断
			 */
			if(custom!=null&&order_id != null && seller ==null){
				//调用service层查询订单详情
				List<OrderGoods> order=  orderService.findByOrderId(new Long(order_id));
				 
				if(order !=null){
				System.out.println(order);
				 request.getSession().setAttribute("order", order);
				 request.getRequestDispatcher("/custom/customShowOrder.jsp").forward(request, response);
				}else{
					System.out.println("没用订单");
				}
				/*
				 * 显示卖家订单
				 */
			}else if( custom==null&&order_id != null&& seller!=null){
				List<OrderGoods> order = orderService.findByOrderId(new Long(order_id), seller.getSeller_id());
				if(order !=null){
					 System.out.println(order);
					 request.setAttribute("order", order);
					 request.getRequestDispatcher("/seller/sellerShowOrder.jsp").forward(request, response);
					
				}else{
						System.out.println("没用订单");
					}
			}
			
		 }
		
		
		
	

}
