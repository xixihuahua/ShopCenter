package com.shop.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.shop.Service.IGoodsService;
import com.shop.Service.IOrderGoodsService;
import com.shop.Service.impl.GoodsServiceImpl;
import com.shop.Service.impl.OrderGoodsServiceImpl;
import com.shop.entity.Custominfo;
import com.shop.entity.Goodsinfo;
import com.shop.entity.OrderGoods;
import com.shop.entity.Sellerinfo;


public class OrderGoodsServlet extends CenterServlet {
	IOrderGoodsService orderGoodsService = new OrderGoodsServiceImpl();
	IGoodsService goodsService = new GoodsServiceImpl();
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
				List<OrderGoods> list =  orderGoodsService.findByCustomId(custom_id);
				System.out.println(list);
				JSONArray order = new JSONArray(list);
 
				System.out.println(order);
				response.getWriter().print(order);
				
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
	//	public List<OrderGoods> findBySerllerId(Long seller_id)
	public void orderBySellerId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Sellerinfo  seller = (Sellerinfo) request.getSession().getAttribute("seller");
		if(seller != null){
			Long seller_id = seller.getSeller_id();
			System.out.println("seller_id = " + seller_id);
			//调用service层查询该卖家的所有的订单
			List<OrderGoods> list =  orderGoodsService.findBySerllerId(seller_id);
			System.out.println(list);
			
			request.setAttribute("list", list);
			
			JSONArray order = new JSONArray(list);
			response.getWriter().print(order);
			
			 
		}else{
			response.getWriter().print("请登录");
		}
	} 
	
	
	/**
	 * 通过买家id，是否支付，查找
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
		public void orderByPayCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
			//获取买家id和买家支付信息
			 Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
			//判断是否登陆
			 if(customer != null){
			      Long custom_id = customer.getCustom_id();
				  Long  order_CheckPay = new Long(request.getParameter("order_CheckPay"));
				  System.out.println("order_CheckPay : " + order_CheckPay);
				
				/**
				 * 非空判断
				 */
				if(custom_id != null && order_CheckPay != null){
					//调用service层查询该买家已支付/未支付的订单
					List<OrderGoods> order =  orderGoodsService.findByPayCId(custom_id, order_CheckPay);
				 
					JSONArray list = new JSONArray(order);
					System.out.println(order);
					response.getWriter().print(list);
					 
				}
			}else{
				response.getWriter().print("请登录");
			}
		 }
		
		
		/**
		 * 通过买家id，卖家是否发货，查找订单详情
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
		public void findByShopSendCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
			//获取买家id和买家支付信息
			 Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
				//判断是否登陆
			 if(customer != null){
				  Long custom_id = customer.getCustom_id();
				 
					Long  order_shopSend = new Long(request.getParameter("order_shopSend"));
					
					System.out.println("order_shopSend : " + order_shopSend);
					
					// 非空判断
					if(custom_id != null && order_shopSend != null){
						//调用service层查询卖家发货/未发货的订单
						List<OrderGoods> order =  orderGoodsService.findByShopSendCId(custom_id, order_shopSend);
						 
						JSONArray list = new JSONArray(order);
						 
						System.out.println(list);
						response.getWriter().print(list); 
						 
					}
			 }else{
					response.getWriter().print("请登录");
				}
		 }
			
			
			/**
			 * 通过买家id，买家是否收货，查找
			 * @param request
			 * @param response
			 * @throws IOException 
			 */
		public void findByCustomGetCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
			//获取买家id和买家支付信息
			 Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
				//判断是否登陆
			 if(customer != null){
				 Long custom_id = customer.getCustom_id();
	
				 Long  order_customGet = new Long(request.getParameter("order_customGet"));
				 System.out.println("order_customGet : " + order_customGet);
				/**
				 * 非空判断
				 */
				if(custom_id != null && order_customGet != null){
					//调用service层查询该买家待收货的订单
					List<OrderGoods> order =  orderGoodsService.findByCustomGetCId(custom_id, order_customGet);
			 		JSONArray list = new JSONArray(order);
					 
					System.out.println(list);
					response.getWriter().print(list); 
					/*
					 * 显示买家订单
					 */
				}
			 }else{
					response.getWriter().print("请登录");
				}
		 }
				
		
		
	/**
	 * 通过买家id，买家是否退货，查找 买家点击退货
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void findByCustomBackCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		//获取买家id和买家支付信息
		 Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
		//判断是否登陆
		 if(customer != null){
			
				 Long custom_id = customer.getCustom_id();
		
				 Long  order_CustomBack = new Long(request.getParameter("order_CustomBack"));
				System.out.println("order_CustomBack : " + order_CustomBack);
				/**
				 * 非空判断
				 */
				if(custom_id != null && order_CustomBack != null){
					//调用service层查询该买家退货/为退货的订单
					List<OrderGoods> order =  orderGoodsService.findByCustomBackCId(custom_id, order_CustomBack);
				 	JSONArray list = new JSONArray(order);
					 
					System.out.println(list);
					response.getWriter().print(list); 
					/*
					 * 显示买家订单
					 */
				}
		 }else{
				response.getWriter().print("请登录");
		}
	 }
	
	/**
	 * 通过买家id，买家是否评论，查找
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void findByCustomComment(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		//获取买家和买家支付信息
		 Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
		 if(customer != null){
			 Long custom_id = customer.getCustom_id();
			 
				Long  Order_customcomment = new Long(request.getParameter("ordergoods_customcomment"));
				
				System.out.println("order_CustomBack : " + Order_customcomment);
				/**
				 * 非空判断
				 */
				if(custom_id != null && Order_customcomment != null){
					//调用service层查询该买家评论/未评论的订单
					List<OrderGoods> order =  orderGoodsService.findByCustomComment(custom_id, Order_customcomment);
				 	JSONArray list = new JSONArray(order);
					 
					System.out.println(list);
					response.getWriter().print(list); 
					 
				}
		 }else{
				response.getWriter().print("请登录");
		}
		 
		
	 }
	
					
/**
 * 通过买家id，卖家是否确认收货（退货），查找
 * @param request
 * @param response
 * @throws IOException 
 */
	public void findByShopGetCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		//获取买家id和买家支付信息
		 Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
		 if(customer != null){
			 Long custom_id = customer.getCustom_id();
			 
			Long  order_CheckPay = new Long(request.getParameter("order_CheckPay"));
			System.out.println("order_CheckPay : " + order_CheckPay);
			/**
			 * 非空判断
			 */
			if(custom_id != null && order_CheckPay != null){
				//调用service层查询该卖家是否确认收货（退货）的订单
				List<OrderGoods> order =  orderGoodsService.findByPayCId(custom_id, order_CheckPay);
				request.getSession().setAttribute("order", order);
				JSONArray list = new JSONArray(order);
				 
				System.out.println(list);
				response.getWriter().print(list); 
				 
			}
		 }else{
				response.getWriter().print("请登录");
		}
		 
	 }
	
	
	/**
	 * 买家点击退货退货
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
public void customBack(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	//获取买家id和买家支付信息
	 Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
	 if(customer != null){
		 Long custom_id = customer.getCustom_id();
		 Long  order_customGet = new Long(request.getParameter("order_customGet"));
		System.out.println("order_customGet : " + order_customGet);
		/**
		 * 非空判断
		 */
		if(custom_id != null && order_customGet != null){
			//调用service层查询该买家点击退货的订单
			List<OrderGoods> order =  orderGoodsService.findByCustomGetCId(custom_id, order_customGet);
	 		JSONArray list = new JSONArray(order);
			 
			System.out.println(list);
			response.getWriter().print(list); 
			/*
			 * 显示买家订单
			 */
		}
	 }else{
			response.getWriter().print("请登录");
	}
 }


/**
 * 通过卖家id，买家是否支付，查找
 * @param request
 * @param response
 * @throws IOException 
 */
	public void orderBySellerPayCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		//获取卖家id和买家支付信息
		Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller") ;
		if(seller != null){
			
		Long seller_id = seller.getSeller_id();
		
		Long  ordergoods_checkPay = new Long(request.getParameter("ordergoods_checkPay"));
		
		System.out.println("ordergoods_checkPay : " + ordergoods_checkPay);
		
		/**
		 * 非空判断
		 */
		if(seller_id != null && ordergoods_checkPay != null){
			//调用service层查询该买家已支付/未支付的订单
			List<OrderGoods> order =  orderGoodsService.findBySellerPayCId(seller_id, ordergoods_checkPay);
		 
			JSONArray list = new JSONArray(order);

			System.out.println(order);
			response.getWriter().print(list);
			 
		}
		 }else{
				response.getWriter().print("请登录");
		}
	 }
	
	
	/**
	 * 通过卖家id，卖家是否发货，查找
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void findBySellerShopSendCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
				//获取卖家id和发货信息
				Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller") ;
				if(seller != null){
						Long seller_id = seller.getSeller_id();
						
						Long  ordergoods_shopsend = new Long(request.getParameter("ordergoods_shopsend"));
						
						System.out.println("ordergoods_shopsend : " + ordergoods_shopsend);
						
						/* 非空判断 */
						if(seller_id != null && ordergoods_shopsend != null){
							//调用service层查询卖家发货/未发货的订单
							List<OrderGoods> order =  orderGoodsService.findBySellerShopSendCId(seller_id, ordergoods_shopsend);
						 
							JSONArray list = new JSONArray(order);
		
							System.out.println(order);
							response.getWriter().print(list);
							 
						}
				 }else{
						response.getWriter().print("请登录");
				}	
		
	 }
		
		
		/**
		 * 通过卖家id，买家是否收货，查找
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
	public void findBySellerCustomGetCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		//获取卖家id和是否收货信息
		Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller") ;
		if(seller != null){
		    Long seller_id = seller.getSeller_id();
		   Long  ordergoods_customget = new Long(request.getParameter("ordergoods_customget"));
		
			System.out.println("ordergoods_customget : " + ordergoods_customget);
			
			/**
			 * 非空判断
			 */
			if(seller_id != null && ordergoods_customget != null){
				//调用service层查询该买家已支付/未支付的订单
				List<OrderGoods> order =  orderGoodsService.findBySellerCustomGetCId(seller_id, ordergoods_customget);
			 
				JSONArray list = new JSONArray(order);
	
				System.out.println(order);
				response.getWriter().print(list);
				 
			}
		}else{
			response.getWriter().print("请登录");
		}
	 }
			
			
/**
 * 通过买家id，买家是否退货，查找
 * @param request
 * @param response
 * @throws IOException 
 */
public void findBySellerCustomBackCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
			//获取卖家id和是否退货信息
			Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller") ;
			
			if(seller != null){
				Long seller_id = seller.getSeller_id();
				
				Long  ordergoods_customback = new Long(request.getParameter("ordergoods_customback"));
				
				System.out.println("ordergoods_customback : " + ordergoods_customback);
				
				/**
				 * 非空判断
				 */
				if(seller_id != null && ordergoods_customback != null){
					//调用service层查询该买家已支付/未支付的订单
					List<OrderGoods> order =  orderGoodsService.findBySellerCustomBackCId(seller_id, ordergoods_customback);
				 
					JSONArray list = new JSONArray(order);

					System.out.println(order);
					response.getWriter().print(list);
					 
				}
			}else{
				System.out.println("请先登录");
				response.getWriter().print("请先登陆");
			}
			
			
	
 }

/**
 * 通过卖家id，买家是否评论，查找
 * @param request
 * @param response
 * @throws IOException 
 */
public void findBySellerCustomComment(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	//获取卖家id和是否退货信息
	Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller") ;
	
	if(seller != null){
		Long seller_id = seller.getSeller_id();
		
		Long  ordergoods_comment = new Long(request.getParameter("ordergoods_comment"));
		
		System.out.println("ordergoods_comment : " + ordergoods_comment);
		
		/**
		 * 非空判断
		 */
		if(seller_id != null && ordergoods_comment != null){
			//调用service层查询该买家已支付/未支付的订单
			List<OrderGoods> order =  orderGoodsService.findBySellerCustomComment(seller_id, ordergoods_comment);
		 
			JSONArray list = new JSONArray(order);

			System.out.println(order);
			response.getWriter().print(list);
			 
		}
	}else{
		
		System.out.println("请先登录");
		response.getWriter().print("请先登录");
	}
	
 }

				
/**
* 通过卖家id，卖家是否确认收货（退货），查找
* @param request
* @param response
* @throws IOException 
*/
public void findBySellerShopGetCId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	//获取卖家id和是否退货信息
		Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller") ;
		
		if(seller != null){
			Long seller_id = seller.getSeller_id();
			
			Long  ordergoods_shopget = new Long(request.getParameter("ordergoods_shopget"));
			
			System.out.println("ordergoods_shopget : " + ordergoods_shopget);
			
			/**
			 * 非空判断
			 */
			if(seller_id != null && ordergoods_shopget != null){
				//调用service层查询该订单
				List<OrderGoods> order =  orderGoodsService.findBySellerShopGetCId(seller_id, ordergoods_shopget);
			 
				JSONArray list = new JSONArray(order);
	
				System.out.println(order);
				response.getWriter().print(list);
				 
			}
		}else{
			
			System.out.println("请先登录");
			response.getWriter().print("请先登录");
		}
		
 }

/**
 * 卖家发货
 * @param request
 * @param response
 * @throws IOException
 */
public void ChangeShopSend(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	Long order_id = new Long(request.getParameter("order_id"));
	Long goods_id = new Long(request.getParameter("goods_id"));
	
	if(order_id != null && goods_id != null){
		if(orderGoodsService.ChangeShopSend(order_id, goods_id)>0){
			System.out.println("发货成功");
			response.getWriter().write("发货成功");
		}else if(orderGoodsService.ChangeShopSend(order_id, goods_id)==-1){
			System.out.println("发货失败");
			response.getWriter().write("卖家已经发货,不能发货");
		}else if(orderGoodsService.ChangeShopSend(order_id, goods_id)==-2){
			
			response.getWriter().write("买家已经退货,不能再发货");
			
		}else{
			response.getWriter().write("发货失败");
		}
		
	}else{
		System.out.println("信息缺失");
		response.getWriter().print("信息缺失");
	}
	
}
/**
 * 买家确认收货
 * @param request
 * @param response
 * @throws IOException
 */
public void ChangeCustomGet(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	Long order_id = new Long(request.getParameter("order_id"));
	Long goods_id = new Long(request.getParameter("goods_id"));
	
	if(order_id != null && goods_id != null){
		//调用service改变收货状态
		if(orderGoodsService.ChangeCustomGet(order_id, goods_id)>0){
			System.out.println("确认收货成功");
			response.getWriter().write("确认收货成功");
		}else if(orderGoodsService.ChangeCustomGet(order_id, goods_id)==-2) {
			System.out.println("确认收货失败");
			response.getWriter().write("已收货,请勿在点收货");
		}else if(orderGoodsService.ChangeCustomGet(order_id, goods_id)==-1){
			System.out.println("确认收货失败");
			response.getWriter().write("已经退货,不能再收货");
		}else if(orderGoodsService.ChangeCustomGet(order_id, goods_id)==-3){
			response.getWriter().write("卖家未发货,不能提前收货");
		}
		
	}else{
			
		System.out.println("信息缺失");
		response.getWriter().print("信息缺失");
		}
		
}
/**
 * 买家评论
 * @param request
 * @param response
 * @throws IOException
 * @throws ServletException 
 */

public void  ChangeCustomComment(HttpServletRequest request ,HttpServletResponse response) throws IOException, ServletException{
	Long order_id = new Long(request.getParameter("order_id"));
	Long goods_id = new Long(request.getParameter("goods_id"));
	
	if(order_id != null && goods_id != null){
		if(orderGoodsService.ChangeCustomComment(order_id, goods_id)>0){
			response.getWriter().write("可以评论");
			request.getRequestDispatcher("/custom/customCenter.jsp").forward(request, response);
		}else if(orderGoodsService.ChangeCustomComment(order_id, goods_id)==-1 ){
			response.getWriter().write("不能评论,买家已退货");
		}else if(orderGoodsService.ChangeCustomComment(order_id, goods_id)==-2 ){
			response.getWriter().write("未收货,不能评论");
		}else if(orderGoodsService.ChangeCustomComment(order_id, goods_id)==-3 ){
			response.getWriter().write("卖家未发货,不能评论");
		}else if(orderGoodsService.ChangeCustomComment(order_id, goods_id)==-4 ){
			response.getWriter().write("卖家已确认退货");
		}
	}
}
/**
 * 买家确认退货
 * @param request
 * @param response
 * @throws IOException
 */
public void ChangeCustomBack(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	Long order_id = new Long(request.getParameter("order_id"));
	Long goods_id = new Long(request.getParameter("goods_id"));
	Long ordergoods_customback =  new Long(request.getParameter("ordergoods_customback"));
	
	
	if(order_id != null && goods_id != null){
		if(ordergoods_customback==0){
			if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)>0){
				System.out.println("已确认改变退货状态");
				response.getWriter().write("已确认改变退货状态");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-1){
				System.out.println("改变退货状态失败");
				response.getWriter().write("已收货不能再退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-2){
				response.getWriter().write("已经退货,不能再次退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-3){
				response.getWriter().write("已经收货,不能再次取消退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-4){
				response.getWriter().write("未退货,不能取消退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-5){
				response.getWriter().write("卖家已经退货了,不能再点取消退货");
			}
		}else if(ordergoods_customback==1){
			if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)>0){
				System.out.println("已确认改变退货状态");
				response.getWriter().write("已退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-1){
				System.out.println("改变退货状态失败");
				response.getWriter().write("已收货不能再退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-2){
				response.getWriter().write("已经退货,不能再次退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-3){
				response.getWriter().write("已经收货,不能再次取消退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-4){
				response.getWriter().write("未退货,不能取消退货");
			}else if(orderGoodsService.ChangeCustomBack(order_id, goods_id, ordergoods_customback)==-5){
				response.getWriter().write("卖家已经退货了,不能再点取消退货");
			}
		}
	}else{
		
		System.out.println("信息缺失");
		response.getWriter().print("信息缺失");
	}
	
}
/**
 * 卖家确认退货 ，添加商品库存 ， 退还买家余额
 * @param request
 * @param response
 * @throws IOException
 */
public void SellerReturnBack(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		Long goods_id = new Long(request.getParameter("goods_id"));
		Long order_id = new Long(request.getParameter("order_id"));
		Long goods_number = new Long(request.getParameter("goods_number"));
		//非空判断
		if(goods_id != null && order_id != null && goods_number != null ){
			 //获取退货商品的信息
			 Goodsinfo goods = goodsService.findGoodsById(goods_id);
			 int num = orderGoodsService.SellerReturnBack(order_id, goods_id, goods_number);
			 System.out.println("num : " + num);
			 if(num == -1 ){
				 response.getWriter().write("退还余额失败");
			 }else if(num == -2){
				 response.getWriter().write("商品库存增长失败");
			 }else if(num == -3){
				 response.getWriter().write("商品退货状态改变失败");
			 }else if(num == 1){
				 response.getWriter().write("退款成功");
			 }else if (num == -4){
				 response.getWriter().write("买家未退货");
			 }else if (num == -5){
				 response.getWriter().write("已经退货了,不用再退货");
			 }
			 
			  
		}else{
			
			System.out.println("信息缺失");
			response.getWriter().print("信息缺失");
		}
	
	}

	/**
	 * 买家批量确认收货
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getGoods(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		if(request.getParameter("orders_id")==null || request.getParameter("goods_id")==null ){
			response.getWriter().write("你还没选择商品收货哦");
		}else{	
		String[] orders_id=request.getParameter("orders_id").split(",");
		String[] goods_id=request.getParameter("goods_id").split(",");
		List<OrderGoods> orders = new ArrayList<OrderGoods>();
		for(int i = 0;i<orders_id.length;i++){
			OrderGoods order = new OrderGoods();
			order.setOrder_id(new Long(orders_id[i]));
			order.setGoods_id(new Long(goods_id[i]));
			orders.add(order);
		}
		
		System.out.println(orders);
		
		int num =0;
		num=orderGoodsService.getGoods(orders);
		
		if(num>0){
			System.out.println("确认收货成功");
			response.getWriter().write("已经收货");
		}else if(num==-2) {
			System.out.println("收货失败");
			response.getWriter().write("已经收货了无需再退货");
		}else{
			response.getWriter().write("收货失败");
		}
	}	
	}
	
	/**
	 * 买家批量退货
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
public void backGoods(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		if(request.getParameter("orders_id")==null || request.getParameter("goods_id")==null ){
			response.getWriter().write("你还没选择商品退货哦");
		}else{	
		String[] orders_id=request.getParameter("orders_id").split(",");
		String[] goods_id=request.getParameter("goods_id").split(",");
		List<OrderGoods> orders = new ArrayList<OrderGoods>();
		for(int i = 0;i<orders_id.length;i++){
			OrderGoods order = new OrderGoods();
			order.setOrder_id(new Long(orders_id[i]));
			order.setGoods_id(new Long(goods_id[i]));
			orders.add(order);
		}
		
		System.out.println(orders);
		
		int num =0;
		num= orderGoodsService.backGoods(orders);
		
		if(num>0){
			System.out.println("提交退货成功");
			response.getWriter().write("提交退货");
		}else if(num==-2) {
			System.out.println("退货失败");
			response.getWriter().write("已经收货了哦,不能再退货了哦");
		}else{
			response.getWriter().write("退货失败");
		}
	}
   }
}
