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

import com.shop.Service.impl.ShopServiceImpl;
import com.shop.entity.Sellerinfo;
import com.shop.entity.Shopinfo;
import com.shop.util.AjaxPageUtil;
 

public class ShopServlet extends CenterServlet {
		ShopServiceImpl shopService = new ShopServiceImpl() ;
 
	/**
	 * 卖家操作　: 添加店铺
	 * @throws IOException 
	 * @throws ServletException 
	 */
		
		public void addShop(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
			//获取卖家信息
			Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller");
			System.out.println(seller);
			
			if(seller != null ){
				//获取店铺名
				String shop_name = request.getParameter("shop_name"); 
				//仓库地址
				String shop_address = request.getParameter("provice")+"-"+request.getParameter("city")+"-"
						  +request.getParameter("area")+"-"+request.getParameter("street");
				
				Shopinfo shop = new Shopinfo();
				shop.setShop_address(shop_address);
				shop.setShop_name(shop_name);
				shop.setSeller_id(seller.getSeller_id());
				
				if(shopService.addShop(shop)){
					System.out.println("店铺注册成功");
					request.getRequestDispatcher("/seller/sellerCenter.jsp").forward(request, response);
				}else{
					System.out.println("店铺注册失败");
					response.getWriter().write("注册失败");
				}
			}else{
				System.out.println("seller为空");
			}
			
		}
		
		
		/**
		 * 计算总行数
		 */
		public void pageCount(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			 //获取商家id
			Sellerinfo seller =  (Sellerinfo) request.getSession().getAttribute("seller");
			if(seller != null){
				Long seller_id = seller.getSeller_id();
				System.out.println("shoppageCount : " + seller_id);
				int count = shopService.findShopBySellerId(seller_id).size();
				response.getWriter().print(count);
				System.out.println("count : " + count);
			}else{
				System.out.println("seller为空");
			}
			
		}
		
		/**
		 * 卖家： ajax的分页查询该商家的所有店铺
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		public void ajaxPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			 //获取商家id
			Sellerinfo seller =  (Sellerinfo) request.getSession().getAttribute("seller");
			if(seller != null){
				Long seller_id = seller.getSeller_id();
				System.out.println("shop ajaxPage : " + seller_id);
				
				Integer currentPage = new Integer(request.getParameter("currentPage"));
				Integer pageSize = new Integer(request.getParameter("pageSize"));
				
				AjaxPageUtil pageUtil = new AjaxPageUtil();
				pageUtil.setCurrentPage(currentPage);//因为我们写的插件是从1开始计算页面的，jQuery查询从0开始计算
				pageUtil.setPageRow(pageSize);
				System.out.println(pageUtil);
				
				List<Shopinfo> list = shopService.shopSelect(seller_id, pageUtil.getStartRow(), pageUtil.getEndRow());
				//查询数据库的总行数
				 
					System.out.println(list);
					//将集合转换为json格式
					JSONArray arr = new JSONArray(list);
					
					response.getWriter().print(arr);
			}else{
				System.out.println("seller为空");
			}
		}
		
		
		/**
		 * 计算总行数，符合搜索框内容的店铺
		 */
		public void pageCountSelect(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			 //获取店铺id
			String shop_name = request.getParameter("desception");
			System.out.println("shop_name : " + shop_name);
			if(shop_name != null){
				int count = shopService.findShopByShopName(shop_name).size();
				response.getWriter().print(count);
				System.out.println("count : " + count);
			}
			
		}
		
		/**
		 * 卖家： ajax的分页查询符合搜索框的店铺
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		public void ajaxPageSelect(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			 //获取店铺id
			 
			String shop_name =request.getParameter("desception");
			 System.out.println("shop_name : " + shop_name);
			 
			if(shop_name !=null){
				Integer currentPage = new Integer(request.getParameter("currentPage"));
				Integer pageSize = new Integer(request.getParameter("pageSize"));
				
				AjaxPageUtil pageUtil = new AjaxPageUtil();
				pageUtil.setCurrentPage(currentPage);//因为我们写的插件是从1开始计算页面的，jQuery查询从0开始计算
				pageUtil.setPageRow(pageSize);
				System.out.println(pageUtil);
				
				List<Shopinfo> list = shopService.shopSelect(shop_name, pageUtil.getStartRow(), pageUtil.getEndRow());
				//查询数据库的总行数
				System.out.println("ajaxPage list " + list);
					//将集合转换为json格式
					JSONArray arr = new JSONArray(list);
					
					response.getWriter().print(arr);
			}
		 }
		
		
		
		
		
		/**
		 * 通过shop_id查询店铺
		 * @throws IOException 
		 * @throws ServletException 
		 */
		public void findShopById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			Long shop_id =  new Long(request.getParameter("shop_id"));
			 System.out.println("shop_id : " + shop_id);
			 
			if(shop_id != null ){//做非空判断
				//调用service层插入数据库
				 Shopinfo  shop = shopService.findShopByShopId(shop_id);
				request.getSession().setAttribute("shop", shop);
				
				System.out.println(request.getSession().getAttribute("seller"));
				System.out.println(request.getSession().getAttribute("customer"));
				 	//如果是卖家登陆，则跳转到卖家的店铺页面
				  //判断是买家登陆还是卖家登陆
					if(request.getSession().getAttribute("seller") != null  ){
						request.getRequestDispatcher("seller/centerShop.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("inShop.jsp").forward(request, response);
					 }
			}
			
		}
		
		
		/**
		 * 通过店铺名查询店铺
		 * @param request
		 * @param response
		 */
		public void findShopByName(HttpServletRequest request,HttpServletResponse response){
			String shop_name = request.getParameter("name");
			if(shop_name != null){
				List<Shopinfo> goods = shopService.findShopByShopName(shop_name);
				request.getSession().setAttribute("list", goods);
				try {
					request.getRequestDispatcher("/custom/customFind.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
		/**
		 * 修改店铺信息
		 * @param request
		 * @param response
		 * @throws IOException 
		 * @throws ServletException 
		 */
		public void updateShop(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			//获取卖家信息
			Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller");
			 System.out.println(seller);
			 if(seller != null){
				//获取店铺名
				 	String shop_id=request.getParameter("shop_id");
					String shop_name = request.getParameter("name"); 
					//仓库地址
					String shop_address = request.getParameter("shop_address");
					/*图片验证开始*/
					  String imageCode = request.getParameter("imageCode");
						String imageCode_session = (String)request.getSession().getAttribute("imageCode");
						if(imageCode_session!= null && imageCode != null && imageCode_session.equalsIgnoreCase(imageCode)){
							System.out.println("验证通过");
							
							Shopinfo shop = new Shopinfo();
							shop.setShop_address(shop_address);
							shop.setShop_name(shop_name);
							shop.setShop_id(new Long(shop_id));
							System.out.println(shop);
							if(shopService.updateShopinfo(shop)){
								System.out.println("店铺信息更改成功");
								request.getRequestDispatcher("seller/centerShop.jsp").forward(request, response);
							}else{
								System.out.println("店铺信息更改失败");
								response.getWriter().write("修改失败");
							}
						}else{
							 System.out.println("验证不通过");
							 request.getRequestDispatcher("seller/updateShop.jsp").forward(request, response);
						}
			 }
			
		 }
		
		/**
		 * ajax查询是否有与此名字相同的店铺
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
		public void findShopByNa(HttpServletRequest request,HttpServletResponse response) throws IOException{
			//获取店铺名
			String shop_name = request.getParameter("name"); 
			System.out.println("shop_name : " + shop_name);
			if(shop_name != null){
				if(shopService.findShopByShopNa(shop_name)){
					 try {
						response.getWriter().write("不同名");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.getWriter().write("同名");
				}
			}
			
		
		}
		
		/**
		 * 店铺上传头像
		 * @param request
		 * @param response
		 * @throws ServletException
		 */
		public void uploadShopImg(HttpServletRequest request , HttpServletResponse response) throws ServletException{
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
						
						Shopinfo shop=new Shopinfo();
						 
						HttpSession session =request.getSession();
						shop=(Shopinfo) session.getAttribute("shop");
						
						shop.setShop_img(relativePath);
					 
					  	if(shopService.uploadShopImg(shop)){
					  		System.out.println("店铺头像上传成功");
					  		response.getWriter().write("上传成功");
					  		request.getRequestDispatcher("shop.do?method=findShopById&shop_id="+shop.getShop_id()).forward(request, response);
					  	}else{
					  		
							System.out.println("商品图片上传失败");
							 
							request.getRequestDispatcher("seller/centerShop.jsp").forward(request, response);
						}
					  	
						}else{
							System.out.println("图片格式不正确");
							 
							request.getRequestDispatcher("seller/centerShop.jsp").forward(request, response);
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
		
		
		 
}
