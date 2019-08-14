package com.shop.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.shop.Service.impl.GoodsTypeServiceImpl;
import com.shop.entity.GoodsType;
import com.shop.entity.Goodsinfo;
import com.shop.util.AjaxPageUtil;

public class GoodsTypeServlet extends CenterServlet {
	GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
	
	/**
	 * 计算总行数，符合商品类型的商品
	 */
	public void pageCountSelect(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//获取类型名
		String goodsType_name = request.getParameter("goodsType_name");
		System.out.println(goodsType_name);
		
		if(goodsType_name != null){
			 int count =  goodsTypeService.findGoodsByTypeName(goodsType_name).size();
			 response.getWriter().print(count);
			System.out.println("count : " + count);
		}
		
	 }
	/**
	 * 首页点击商品类型
	 * 通过商品类型名查找商品类型
	 * @param goodsType_name
	 * @return
	 * @throws IOException 
	 */
	public void findGoodsByTypeName(HttpServletRequest request , HttpServletResponse response) throws IOException{
		String goodsType_name = request.getParameter("goodsType_name");
		System.out.println(goodsType_name);
		
		if(goodsType_name !=null){
			List<Goodsinfo> list = goodsTypeService.findGoodsByTypeName(goodsType_name);
			//查询数据库的总行数
			System.out.println("ajaxPage list " + list);
			//将集合转换为json格式
			JSONArray arr = new JSONArray(list);
			response.getWriter().print(arr);
		}
		
		//http://localhost:8888/shopCenter/selectGoods.jsp?desception=a&selected=%E5%AE%9D%E8%B4%9D
		 
	}
	
	/**
	 * 搜索商品页
	 * ajax通过商品类型名查找商品类型
	 * @param goodsType_name
	 * @return
	 * @throws IOException 
	 */
	public void AjaxfindGoodsByTypeName(HttpServletRequest request , HttpServletResponse response) throws IOException{
		String goodsType_name = request.getParameter("goodsType_name");
		System.out.println(goodsType_name);
		 
		if(goodsType_name !=null){
			Integer currentPage = new Integer(request.getParameter("currentPage"));
			Integer pageSize = new Integer(request.getParameter("pageSize"));
			
			AjaxPageUtil pageUtil = new AjaxPageUtil();
			pageUtil.setCurrentPage(currentPage);//因为我们写的插件是从1开始计算页面的，jQuery查询从0开始计算
			pageUtil.setPageRow(pageSize);
			System.out.println(pageUtil);
			
			List<Goodsinfo> list = goodsTypeService.SelectfindGoodsByType(goodsType_name,  pageUtil.getStartRow(), pageUtil.getEndRow());
			//查询数据库的总行数
			System.out.println("ajaxPage list " + list);
			//将集合转换为json格式
			JSONArray arr = new JSONArray(list);
			response.getWriter().print(arr);
		}
		
		
	}
	/**
	 * 通过商品类型名/商品ID查找商品类型
	 * @param goodsType_name
	 * @return
	 */
	public void findGoodsTypeByType(HttpServletRequest request , HttpServletResponse response){
		String goodsType_name = request.getParameter("goodsType");
		System.out.println(goodsType_name);
		GoodsType goodsType = null;
		if(goodsType_name!=null){
			//调用Service层
			//如果能通过名字找到则说明是名称查询
			if(goodsTypeService.findGoodsTypeByTypeName(goodsType_name)!=null){
				goodsType=goodsTypeService.findGoodsTypeByTypeName(goodsType_name);
				request.getSession().setAttribute("goodsType", goodsType);
				try {
					
					request.getRequestDispatcher("#").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(goodsTypeService.findGoodsTypeByTypeId(new Long(goodsType_name))!=null){
				goodsType=goodsTypeService.findGoodsTypeByTypeId(new Long(goodsType_name));
				request.getSession().setAttribute("goodsType", goodsType);
				try {
					request.getRequestDispatcher("/seller/centerShop.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				System.out.println("找不到内容");
				 request.getSession().setAttribute("msg", "查无此物");
			}
		}
		

	}
	
	/**
	 * 添加商品类型
	 * @param goodsType
	 * @return 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addGoodsType(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String goodsType_name = request.getParameter("goodsType_name");
		String goodsType_Upid = request.getParameter("goodsType_Upid");
		
		if(goodsType_name!=null&&goodsType_Upid!=null){
			GoodsType goodstype = new GoodsType();
			goodstype.setGoodsType_name(goodsType_name);
			goodstype.setGoodsType_Upid(new Long(goodsType_Upid));
			
			if(goodsTypeService.addGoodsType(goodstype)){
				System.out.println("添加成功");
				try {
					//添加成功之后跳转页面
					response.sendRedirect("#");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				//添加失败返回原页面
				request.getRequestDispatcher("").forward(request, response);
				System.out.println("添加失败");
			}
		}	
		
	}
	

	/**
	 * 删除商品类型
	 * @param goodsType_id
	 * @return
	 */
	public void deleteGoodsType(HttpServletRequest request,HttpServletResponse response){
		String goodsType_id= request.getParameter("goodsType_id");
		if(goodsType_id!=null && goodsType_id.matches("\\d*")){
			if(goodsTypeService.deleteGoodsType(new Long(goodsType_id))){
				System.out.println("删除成功");
				//跳转回某个页面
				/*
				 * 方法类
				 */
			}else{
				System.out.println("删除失败");
				//跳转回某个页面
				/*
				 * 方法类
				 */
			}
		}
	}
	
	/**
	 * 通过商品类型查找
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findGoodsByType(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{ 
		String goodsType_id = request.getParameter("goodsType_id");
		List<Goodsinfo> goods = null;
		if(goodsType_id !=null){
	
			goods = goodsTypeService.findGoodsByType(new Long(goodsType_id));
			request.getSession().setAttribute("goods", goods);
			request.getRequestDispatcher("/nav/selectGoods.jsp").forward(request, response);
		}
	}
}
