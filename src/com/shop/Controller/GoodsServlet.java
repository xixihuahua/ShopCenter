package com.shop.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import com.shop.Service.impl.GoodsServiceImpl;
import com.shop.Service.impl.GoodsTypeServiceImpl;
import com.shop.entity.GoodsType;
import com.shop.entity.Goodsinfo;
import com.shop.entity.Sellerinfo;
import com.shop.entity.Shopinfo;
import com.shop.util.AjaxPageUtil;

public class GoodsServlet extends CenterServlet {
	GoodsServiceImpl goodsService = new GoodsServiceImpl() ;
	GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
		/**
		 * 卖家操作　: 为某店铺添加商品
		 * @throws IOException 
		 * @throws ServletException 
		 */
		 public void addGoods(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
			//获取店铺信息
			 Long shop_id = new Long(request.getParameter("shop_id")) ;
			
			//获取商品描述
			String  goods_Desception = request.getParameter("goods_Desception"); 
			//商品类型id
			//获取商品类型名
			String first = request.getParameter("first") ;
			String second = request.getParameter("second") ;
			String third = request.getParameter("third") ;
			String goodsType_name = third  ;
			
			System.out.println("first : " + first);
			System.out.println("second : " + second);
			System.out.println("third : " + third);
			if(third == null){
				if(second == null){
					goodsType_name = first ;
				}else {
					goodsType_name = second ;
				}
			}
			System.out.println("goodsType_name : " + goodsType_name);
			//service层查找该商品类型名对应的商品类型id
			GoodsType goodsType = goodsTypeService.findGoodsTypeByTypeName(goodsType_name);
			Long goodsType_id = goodsType.getGoodsType_id();
			
			
			//商品库存
			Long goods_Repertory =new Long(request.getParameter("goods_Repertory")) ;
			 
			 //商品进价
			Double goods_InputPrice  = new Double(request.getParameter("goods_InputPrice")) ;
			//商品售价
			Double goods_OutputPrice  = new Double(request.getParameter("goods_OutputPrice")) ;
			//商品折扣
			Double goods_Count  = new Double(request.getParameter("goods_count")) ;
			//商品状态
			String goods_Status  = request.getParameter("goods_status") ;
			
			
			Goodsinfo goods = new Goodsinfo();
			
			goods.setShop_id(shop_id);
			goods.setGoodsType_id(goodsType_id);
			goods.setGoods_Repertory(goods_Repertory);
			goods.setGoods_Desception(goods_Desception);
			goods.setGoods_Count(goods_Count);
			 
			goods.setGoods_InputPrice(goods_InputPrice);
			goods.setGoods_OutputPrice(goods_OutputPrice);
		    goods.setGoods_Status(goods_Status);
			
			
			if(goodsService.addGoods(goods)){
				System.out.println("商品添加成功");
				 request.getRequestDispatcher("shop.do?method=findShopById&shop_id="+shop_id).forward(request, response);
			}else{
				System.out.println("商品添加失败");
				request.getRequestDispatcher("seller/addGoods.jsp").forward(request, response);
			} 
		}
		
		
		/**
		 * 计算总行数店铺下商品
		 */
		public void pageCount(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			 //获取店铺id
			Shopinfo shop =  (Shopinfo) request.getSession().getAttribute("shop");
			if(shop != null ){
				System.out.println("shop : " + shop);
				Long shop_id =shop.getShop_id();
				
				int count = goodsService.findGoodsByShopId(shop_id).size();
				response.getWriter().print(count);
				System.out.println("count : " + count);
			}else{
				System.out.println("没有该店铺");
			}
			
		}
		
		
		/**
		 * 卖家： ajax的分页查询该店铺下的所有商品
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		public void ajaxPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			 //获取店铺id
			 
			Long shop_id =new Long( request.getParameter("shop_id"));
			 System.out.println("shop_id : " + shop_id);
			 
			if(shop_id !=null){
				Integer currentPage = new Integer(request.getParameter("currentPage"));
				Integer pageSize = new Integer(request.getParameter("pageSize"));
				
				AjaxPageUtil pageUtil = new AjaxPageUtil();
				pageUtil.setCurrentPage(currentPage);//因为我们写的插件是从1开始计算页面的，jQuery查询从0开始计算
				pageUtil.setPageRow(pageSize);
				System.out.println(pageUtil);
				
				List<Goodsinfo> list = goodsService.goodsSelect(shop_id, pageUtil.getStartRow(), pageUtil.getEndRow());
				//查询数据库的总行数
				System.out.println("ajaxPage list " + list);
					//将集合转换为json格式
					JSONArray arr = new JSONArray(list);
					
					response.getWriter().print(arr);
			}
			
			 
			 
		}
		
		
		/**
		 * 计算总行数，符合搜索框内容的商品
		 */
		public void pageCountSelect(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			 //获取店铺id
			 String goods_desception = request.getParameter("goods_Desception");
			System.out.println("goods_desception : " + goods_desception);
			if(goods_desception != null){
				 int count = goodsService.findGoodsByName(goods_desception).size();
				 response.getWriter().print(count);
				System.out.println("count : " + count);
			}
			
		 }
		
		/**
		 * 卖家： ajax的分页查询该店铺下的所有商品
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		public void ajaxPageSelect(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			 //获取店铺id
			 String goods_desception =request.getParameter("goods_Desception");
			 System.out.println("goods_desception : " + goods_desception);
			 
			if(goods_desception !=null){
				Integer currentPage = new Integer(request.getParameter("currentPage"));
				Integer pageSize = new Integer(request.getParameter("pageSize"));
				
				AjaxPageUtil pageUtil = new AjaxPageUtil();
				pageUtil.setCurrentPage(currentPage);//因为我们写的插件是从1开始计算页面的，jQuery查询从0开始计算
				pageUtil.setPageRow(pageSize);
				System.out.println(pageUtil);
				
				List<Goodsinfo> list = goodsService.goodsSelect(goods_desception, pageUtil.getStartRow(), pageUtil.getEndRow());
				//查询数据库的总行数
				System.out.println("ajaxPage list " + list);
					//将集合转换为json格式
					JSONArray arr = new JSONArray(list);
					
					response.getWriter().print(arr);
			}
			
			 
			 
		}
		
		
		/**
		 * 通过goods_id查询商品
		 * @throws IOException 
		 * @throws ServletException 
		 */
		public void findGoodsById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			Long goods_id = new Long(request.getParameter("goods_id"));
			System.out.println("goods_id : " + goods_id);
			
			 if(goods_id != null ){//做非空判断
				//调用service层
				Goodsinfo goods = goodsService.findGoodsById(goods_id);
				request.getSession().setAttribute("goods", goods);
				
				System.out.println(request.getSession().getAttribute("customer"));
				System.out.println(request.getSession().getAttribute("seller"));
				//判断买家登陆/卖家登陆
				 if(request.getSession().getAttribute("seller") !=null ){
					 //卖家登陆
					 request.getRequestDispatcher("seller/goodsUpdate.jsp").forward(request, response);
					
				}else{
					 //跳转到买家界面
					 request.getRequestDispatcher("custom/Goodsinfo.jsp").forward(request, response);
				 }
				
				 
			}
		}
		
		/**
		 * 模糊查询 ，通过商品名查询商品
		 * @param request
		 * @param response
		 * @throws IOException 
		 * @throws ServletException 
		 */
		public void findGoodsByName(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			String goods_desception = request.getParameter("name");
			System.out.println("goods_desception : " + goods_desception);
			
			if(goods_desception != null){
				List<Goodsinfo> goods = goodsService.findGoodsByName(goods_desception);
				System.out.println("goods : " + goods);
				request.getSession().setAttribute("list", goods);
				request.getRequestDispatcher("/custom/customFind.jsp").forward(request, response);
				 
			}
		
		}
		
		/**
		 * 删除商品 by 商品id
		 */
		public void deleteGoods(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			Long goods_id = new Long(request.getParameter("goods_id"));
			System.out.println("goods_id : " + goods_id);
			
			//获取店铺信息
			 Long shop_id = new Long(request.getParameter("shop_id")) ;
			if(goods_id != null){
				if(goodsService.deleteGoods(goods_id)){
					System.out.println("删除成功");
					request.getRequestDispatcher("shop.do?method=findShopById&shop_id="+shop_id).forward(request, response);
				}else{
					System.out.println("删除失败");
				}
			}
		
		}
		/**
		 * 判断根据商品描述能否查找商品
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		public void findGoodsByDe(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			String goods_desception = request.getParameter("desception");
			System.out.println("goods_desception : " + goods_desception);
			
			//如果找到了，说明有同名的，那么就不能通过
			if(goodsService.findGoodsByDe(goods_desception)){ 
				 response.getWriter().write("同名");
			}else{
				 response.getWriter().write("没有同名");
			}
		 }
		 /**
		 * 上传商品图片
		 * @param request
		 * @param response
		 * @throws ServletException
		 */
		public void uploadGoodsImg(HttpServletRequest request , HttpServletResponse response) throws ServletException{
			//1. 创建工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2. 获取解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			
			/*开始设置上传的文件路径*/
			Calendar c = Calendar.getInstance();//获取一个日历对象
			//获取系统的年月日用来做文件夹的分层
			String year = c.get(Calendar.YEAR) + "";//年
			int m = c.get(Calendar.MONTH) + 1;
			String month = m < 10 ? "0"+m  : ""+m;
			int d = c.get(Calendar.DAY_OF_MONTH);
			String day = d < 10 ? "0"+d : ""+d;
			
			//获取项目的绝对路径  /1024updown/
			String basePath = getServletContext().getRealPath(File.separator);
			System.out.println(basePath);
			
			//获取文件需要上传保存的路径
			String uploadPath = "/upload/"+year+"/"+month+"/"+day;
			File file = new File(basePath+uploadPath);
			if(!file.exists()){
				file.mkdirs();//如果文件不存在就创建文件
			}
			/*结束设置上传的文件路径*/
			InputStream input = null;
			OutputStream output = null;
			String relativePath  = null  ;
			try {
				//3. 获取上传表单中的内容
				List<FileItem> list = upload.parseRequest(request);
				//循环遍历集合
				for(FileItem item : list){
					 
						String fileName = item.getName();//获取文件的文件名
						if(fileName.endsWith("jpg") ||  fileName.endsWith("JPG") ||  fileName.endsWith("jpeg") || fileName.endsWith("JPEG") || fileName.endsWith("PNG") || fileName.endsWith("png") ){
							 //为了避免文件名带了盘符需要对文件名进行字符串截取
							fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
							//为了避免文件名重复需要加上随机数
							String myfileName = getNumber()+fileName;
							//计算文件的相对路径 用于保存数据库
							  relativePath = uploadPath + "/" + myfileName;
							//生成图片的绝对路径用于文件上传
							String realPath = basePath + relativePath;
							
							//获取请求输入流中的文件
							input = item.getInputStream();
							//通过绝对路径创建一个输出流
							output = new FileOutputStream(realPath);
							//复制文件
							int num = IOUtils.copy(input, output);
							System.out.println(num);
							
							System.out.println("需要上传的文件的大小："+item.getSize());
							
							Goodsinfo goods=new Goodsinfo();
							 
							HttpSession session =request.getSession();
							goods=(Goodsinfo) session.getAttribute("goods");
							goods.setGoods_Img(relativePath);
						 
						  	if(goodsService.uploadGoodsImg(goods)){
						  		System.out.println("商品图片上传成功");
						  		request.getRequestDispatcher("goods.do?method=findGoodsById&goods_id="+goods.getGoods_id()).forward(request, response);
						  	}else{
						  		
								System.out.println("商品图片上传失败");
								request.getRequestDispatcher("seller/uploadGoodsImg.jsp").forward(request, response);
							}
						}else{
							System.out.println("图片格式不正确");
							request.getRequestDispatcher("seller/uploadGoodsImg.jsp").forward(request, response);
							
						}
			 }
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(output!=null)
					try {
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(input!=null)
					try {
						input.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
			}
			
		}
		private String getNumber(){
			//获取当前时间戳
			String str = System.currentTimeMillis()+"";
			//再来几位随机数
			Random r = new Random();
			return str + (r.nextInt(90000000)+10000000);
		}
		
		
		/**
		 * 修改商品信息
		 * @param request
		 * @param response
		 * @throws IOException 
		 * @throws ServletException 
		 */
		public void updateGoods(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
			//获取卖家信息
			Sellerinfo seller =(Sellerinfo) request.getSession().getAttribute("seller");
			//获取店铺信息
			 Shopinfo shop = (Shopinfo) request.getSession().getAttribute("shop");
			//获取商品信息
			 Goodsinfo g = (Goodsinfo) request.getSession().getAttribute("goods");
			
			 if(seller != null && shop != null && g != null){
				 /*开始获取商品要改变的属性*/
				 //获取商品描述
				 Long shop_id = shop.getShop_id();
				
				 String  goods_Desception = request.getParameter("goods_Desception"); 
				 
				//获取商品类型名
				String goodsType_name = request.getParameter("third") ;
				//service层查找该商品类型名对应的商品类型
				GoodsType goodsType = goodsTypeService.findGoodsTypeByTypeName(goodsType_name);
				//获取商品类型id
				Long goodsType_id = goodsType.getGoodsType_id();
				Long goods_id=g.getGoods_id();
				//商品库存
				Long goods_Repertory =new Long(request.getParameter("goods_Repertory")) ;
				 //商品图片
			
				 //商品进价
				Double goods_InputPrice  = new Double(request.getParameter("goods_InputPrice")) ;
				//商品售价
				Double goods_OutputPrice  = new Double(request.getParameter("goods_OutputPrice")) ;
				//商品折扣
				Double goods_Count  = new Double(request.getParameter("goods_count")) ;
				//商品状态
				String goods_Status  = request.getParameter("goods_status") ;
				 /*结束获取商品要改变的属性*/
				
				/**进行正则判断，以及数据库 判断是否商品描述重名，进行错误回显 */
				Goodsinfo goods = new Goodsinfo();
				//设置商品信息
				goods.setGoods_id(goods_id);
				goods.setShop_id(shop_id);
				goods.setGoodsType_id(goodsType_id);
				goods.setGoods_Repertory(goods_Repertory);
				goods.setGoods_Desception(goods_Desception);
				goods.setGoods_Count(goods_Count);
			
				goods.setGoods_InputPrice(goods_InputPrice);
				goods.setGoods_OutputPrice(goods_OutputPrice);
			    goods.setGoods_Status(goods_Status);
			    
				if(seller != null && goods!=null && shop!=null){
					 
					if(goodsService.updateGoods(goods)){
						System.out.println("修改成功");
						response.getWriter().write("修改成功");
					}else{
						response.getWriter().write("修改失败");
						System.out.println("修改失败");
					}
				}
			}else{
				System.out.println("seller 或  shop , goods 为 null");
			}
			 
			
		}
		
}
