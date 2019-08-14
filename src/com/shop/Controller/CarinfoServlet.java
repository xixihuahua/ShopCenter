package com.shop.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.json.JSONArray;

import com.shop.Service.ICarService;
import com.shop.Service.IGoodsService;
import com.shop.Service.impl.CarServiceImpl;
import com.shop.Service.impl.GoodsServiceImpl;
import com.shop.entity.Carinfo;
import com.shop.entity.Custominfo;
import com.shop.entity.Goodsinfo;
import com.shop.util.AjaxPageUtil;


public class CarinfoServlet extends CenterServlet {
	ICarService carService = new CarServiceImpl();
	IGoodsService goodsService = new GoodsServiceImpl();
	/**
	 * 添加购物车
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void addCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//添加之前先看看是否登录
		Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");
		System.out.println( "custom : " +  custom);
		
		//没有登陆
		if(custom==null){
			response.getWriter().write("请登录!");
			//request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			System.out.println("已登陆");
			
			//如果已经登陆就添加购物车
			Carinfo car = new Carinfo();
			//获取用户id
			Long custom_id =custom.getCustom_id();
			System.out.println("custom_id : " + custom_id);
			//获取商品id
			Long goods_id =request.getParameter("goods_id")==null?0l:new Long(request.getParameter("goods_id"));
			System.out.println("goods_id : " + goods_id);
			//获取数量(默认为1)
			Long carGoods_number = request.getParameter("carGoods_number") ==null ? 1l : new Long(request.getParameter("carGoods_number"));
			
			
			
			System.out.println("carGoods_number : " + carGoods_number);
			
			car.setCustom_id(custom_id);
			car.setCarGoods_number(carGoods_number);
			car.setGoods_id(goods_id);
			
			if(carService.addCar(car)){
				System.out.println("添加成功"); 
				response.getWriter().write("添加成功");
				//request.getRequestDispatcher("/custom/Car.jsp").forward(request, response);
			}else{
				response.getWriter().write("添加失败");
			}
			
		}
		
	}
	
	/**
	 * 删除指定用户购物车商品
	 *public boolean deleteCar(Long goods_id,Long custom_id)
	 */
	public void deleteCar(HttpServletRequest request, HttpServletResponse response)throws IOException{
		//添加之前先看看是否登录
				Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");
				if(custom==null){
					response.getWriter().print("请登录!");
				}else{
					Long custom_id = custom.getCustom_id();
					String goods_id = request.getParameter("goods_id");
					if(goods_id !=null){
						//如果不为空并且修改成功
						if(carService.deleteCar(new Long(goods_id), custom_id)){
							System.out.println("删除成功");
							response.getWriter().write("删除成功");
						}
					}else{
						System.out.println("商品不存在");
						response.getWriter().write("商品不存在");
					}
				}
	}

	/**
	 * 展示购物车
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
//	public void showCar(HttpServletRequest request, HttpServletResponse response)throws IOException{
//		Custominfo custom =  (Custominfo)request.getSession().getAttribute("custom") ;
//		if(custom == null){//先判断用户是否已经登陆
//			JSONObject obj = new JSONObject();
//			obj.put("msg", "请先登陆！");
//			response.getWriter().print(obj);
//		}else{
//			Long custom_id = custom.getCustom_id();
//			List<Carinfo> list =carService.showCar(custom_id);
//			if(list == null || list.size() == 0){
//				JSONObject obj = new JSONObject();
//				obj.put("msg", "购物车为空！");
//				response.getWriter().print(obj);
//			}else{
//				//将查询出来的list转为json对象
//				JSONArray arr = new JSONArray(list);
//				System.out.println(arr);
//				response.getWriter().print(arr);
//			}
//		}
//	}

	/**
	 * 计算总行数
	 */
	public void pageCount(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 //获取店铺id
		Custominfo custom =  (Custominfo) request.getSession().getAttribute("customer");
		System.out.println("custom : " + custom);
		Long custom_id =custom.getCustom_id();
		int count=0;
		if(carService.showCar(custom_id)!=null){
			 count = carService.showCar(custom_id).size();
		}
		response.getWriter().print(count);
		System.out.println("count : " + count);
		
	}
	
	
	
	/**
	 * 卖家： ajax的分页查询该用户购物车里的所有商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void carAjaxPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 //获取用户
		Custominfo custom =  (Custominfo)request.getSession().getAttribute("customer") ; 
		if(custom == null){//先判断用户是否已经登陆
			JSONObject obj = new JSONObject();
			obj.put("msg", "请先登陆！");
			response.getWriter().print(obj);
		}else{
			Long custom_id = custom.getCustom_id();
			Integer currentPage = new Integer(request.getParameter("currentPage"));
			Integer pageSize = new Integer(request.getParameter("pageSize"));
			
			AjaxPageUtil pageUtil = new AjaxPageUtil();
			pageUtil.setCurrentPage(currentPage);//因为我们写的插件是从1开始计算页面的，jQuery查询从0开始计算
			pageUtil.setPageRow(pageSize);
			System.out.println(pageUtil);
			
			List<Carinfo> list = carService.showCar(custom_id, pageUtil.getStartRow(), pageUtil.getEndRow());
			//查询数据库的总行数
			System.out.println("showCarajaxPage list " + list);
				//将集合转换为json格式
				JSONArray arr = new JSONArray(list);
				System.out.println(arr);
				response.getWriter().print(arr);
				
		}
		 
		 
	}
	
	/**
	 * 立即购买
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void buyNow(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");
		if(custom != null){
			 Long carGoods_number = request.getParameter("carGoods_number") ==null ? 1l : new Long(request.getParameter("carGoods_number"));
			Long custom_id  = custom.getCustom_id();
			System.out.println(custom);
			Goodsinfo goods = (Goodsinfo) request.getSession().getAttribute("goods");
			Long goods_ids = request.getParameter("goods_id") ==null ? 1l : new Long(request.getParameter("goods_id"));
			
			Carinfo car=new Carinfo();
			car.setCustom_id(custom_id);
			if(goods_ids == goods.getGoods_id()){
				car.setGoods_id(goods.getGoods_id());//商品id
			
			}else{
				car.setGoods_id(goods_ids);
			}
			car.setCarGoods_number(carGoods_number);//商品数量
			car.setGoods_count(goods.getGoods_Count());//商品折扣
			car.setShop_id(goods.getShop_id());//店铺id
			car.setGoods_OutputPrice(goods.getGoods_OutputPrice());//商品单价
			int num = carService.BuyNow(car, custom_id);
			System.out.println(num);
			if(num > 0 ){
				System.out.println("成功了  可以去查看订单了");
				response.getWriter().write("成功了  可以去查看订单了");
				
			}else if(num == -2){
				System.out.println("余额不足");
				response.getWriter().write("余额不足");
			}else{
				System.out.println("提交订单失败");
				response.getWriter().write("提交订单失败");
			}
		}else{
			System.out.println("请先登录");
			response.getWriter().write("请先登录");
		}
		
	}
	
	
	/**
	 * 提交购物车订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void submitCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");
		//获取商品id  以及 商品数量
		String[] goods_ids = request.getParameter("ordersgoods_id").split(",");
		String[] carGoods_numbers = request.getParameter("ordersgoods_number").split(",");
		 
		List<Carinfo> list = new ArrayList<Carinfo>();
		
		//遍历提交的商品
		for(int i= 0;i<goods_ids.length;i++){
			//通过商品id找到该商品
			Goodsinfo goods = goodsService.findGoodsById(new Long(goods_ids[i]));
			//将商品信息存到carinfo对象中去,
			Carinfo car = new Carinfo();
			car.setCustom_id(custom.getCustom_id());
			car.setCarGoods_number(new Long(carGoods_numbers[i]));
			car.setGoods_id(new Long(goods_ids[i]));
			car.setGoods_OutputPrice(goods.getGoods_OutputPrice());
			car.setGoods_count(goods.getGoods_Count());
			//将carinfo对象存到集合中去
			list.add(car);
		}
		System.out.println(list);
		
		System.out.println(goods_ids.length+"-------"+carGoods_numbers.length);
		
		Long custom_id  = custom.getCustom_id();
		
		int num = carService.submitCart(list, custom_id);
		
		System.out.println(num);
		if(num > 0 ){
			System.out.println("成功了  可以去查看订单了");
			response.getWriter().write("成功了  可以去查看订单了");
		}else if(num == -2){
			response.getWriter().write("余额不足");
		}else{
			response.getWriter().write("提交订单失败");
		}
		
	}
	
	/**
	 * 修改购物车
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void updateCar(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");
		if(custom == null){
			response.getWriter().print("请登录!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
		//获取商品id
		Long goods_id =request.getParameter("goods_id")==null?0l:new Long(request.getParameter("goods_id"));
		//获取数量
		Long CarGoods_number = request.getParameter("carGoods_number") ==null ? 1l : new Long(request.getParameter("CarGoods_number"));
		System.out.println(CarGoods_number);
		Carinfo car = new Carinfo();
		car.setCustom_id(custom.getCustom_id());
		car.setCarGoods_number(CarGoods_number);
		car.setGoods_id(goods_id);
		if(carService.updateCar(car)){
			System.out.println("修改成功");
			response.getWriter().print("修改成功");
			request.getRequestDispatcher("/custom/carShow.jsp").forward(request, response);
		}else{
			response.getWriter().print("修改失败");
		}
		}
	}
	
	
	/**
	 * 卖家： ajax的分页查询该用户购物车里的所有商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void goodsInCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 //获取用户
		Custominfo custom =  (Custominfo)request.getSession().getAttribute("customer") ; 
		if(custom == null){//先判断用户是否已经登陆
			JSONObject obj = new JSONObject();
			obj.put("msg", "请先登陆！");
			response.getWriter().print(obj);
		}else{
			Long custom_id = custom.getCustom_id();
		 
			List<Carinfo> list = carService.showCar(custom_id);
			//查询数据库的总行数
			System.out.println("showCarajaxPage list " + list);
				//将集合转换为json格式
				JSONArray arr = new JSONArray(list);
				System.out.println(arr);
				response.getWriter().print(arr);
		 }
		 
		 
	}
	
}
