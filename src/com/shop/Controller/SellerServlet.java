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

import com.shop.Service.impl.SellerServiceImpl;
import com.shop.Service.impl.ShopServiceImpl;
import com.shop.entity.Sellerinfo;
 

public class SellerServlet extends CenterServlet {
	SellerServiceImpl sellerService = new SellerServiceImpl();
	ShopServiceImpl shopService = new ShopServiceImpl();
	
	/*正则表达式*/
	public String nameRegs="^.{3,16}$";
	public String passwordRegs="^[a-zA-Z]\\w{5,17}$";
	public String ageRegs="^(?:[1-9][0-9]?|1[01][0-9]|120)$";
	public String telRegs = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$" ;
	public String emailRegs = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
	 
	/**
	 * 卖家登陆
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void sellerLogin(HttpServletRequest request , HttpServletResponse response) throws IOException{
			String sell =  request.getParameter("name");
			String seller_password = request.getParameter("password");
			System.out.println(sell);
			System.out.println(seller_password);
			/* 正则验证 */
			boolean flag=false;
			if(sell!=null&& seller_password!=null){
				if(sell.matches(nameRegs)){
					System.out.println("名字验证成功");
						if(seller_password.matches(passwordRegs)){
							System.out.println("密码验证成功");
							flag=true;
						}else{
							 System.out.println("密码格式错误!!");
							 response.getWriter().write("密码格式错误!!");
						}
				 }else{
					 System.out.println("账号格式错误!");
					 response.getWriter().write("账号格式错误!");
				}
			 }
			
			//正则验证通过
			Sellerinfo seller = null ;
		    if(flag){
				//判断是通过用户名还是用户账号登陆
				 String reg = "^\\d*$";
				 //不匹配说明是用户名登陆
				 if(!sell.matches(reg)){
					//判断能否通过用户名查找到用户
					 if(sellerService.findSellerByName(sell, seller_password)) {
						//通过用户名查找到用户
						seller = sellerService.getSellerByName(sell, seller_password);
						System.out.println(seller);
						System.out.println("商家登陆成功");
						request.getSession().setAttribute("seller", seller);
						try {
							request.getRequestDispatcher("seller/sellerCenter.jsp").forward(request, response);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else{
						 System.out.println("用户名或密码错误");
						 response.getWriter().write("用户名或密码错误");
						 
					}
				 }else{
					//如果能通过用户id查找到用户
					 if(sellerService.findSellerById(new Long(sell), seller_password)){
							//通过用户id查找到用户
							seller= sellerService.getSellerById(new Long(sell), seller_password) ;
							System.out.println(seller);
							request.getSession().setAttribute("seller", seller);
							System.out.println("商家登陆成功");
							 try {
								request.getRequestDispatcher("seller/sellerCenter.jsp").forward(request, response);
							} catch (ServletException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							 System.out.println("用户名或密码错误");
							 response.getWriter().write("用户名或密码错误");
							  
						}
				  }
				 
			}
		
	}
	
	/**
	 * 卖家注册
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void sellerReg(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException  {
		 //获取注册信息
		  String seller_name = request.getParameter("name"); //用户名
		  String seller_password = request.getParameter("password"); ; //用户密码
		  String seller_sex = request.getParameter("sex");;//性别
		  Long   seller_age = new Long(request.getParameter("age"));//年龄
		  String seller_tel = request.getParameter("tel");//电话
		  String seller_address = request.getParameter("provice")+"-"+request.getParameter("city")+"-"
				  +request.getParameter("area")+"-"+request.getParameter("street");//地址
		  String seller_email = request.getParameter("email");//用户邮箱
		  
		  //设置标签，判断验证是否通过
		  boolean flag=false;  //正则验证
		  boolean code=false;  //图片验证
		  
		  /*图片验证开始*/
		  String imageCode = request.getParameter("imageCode");
		  String imageCode_session = (String)request.getSession().getAttribute("imageCode");
		  if(imageCode_session!= null && imageCode != null && imageCode_session.equalsIgnoreCase(imageCode)){
				System.out.println("验证通过");
				code=true;
			}else{
				System.out.println("不通过");
				request.getRequestDispatcher("reg.jsp").forward(request, response);
				code=false;
			}
		  
		  
		 /*正则验证 */
		if(code && seller_name !=null && seller_password!=null &&seller_tel!=null && seller_email!=null &&seller_sex!=null){
			//账户正则
			if(seller_name.matches(nameRegs)){
				flag=true;
				//密码正则
				if(seller_password.matches(passwordRegs)){
					flag=true;
					//邮箱
					if(seller_email.matches(emailRegs)){
						flag=true;
						//电话
						if(seller_tel.matches(telRegs)){
							flag=true;
						}else{
							flag=false;
						}
					}else{
						flag=false;
					}
				}else{
					flag=false;
				}
			}else{
				flag=false;
			}
		}	
		  
		 if(flag){
			  Sellerinfo seller = new Sellerinfo();
			 
			  seller.setSeller_name(seller_name);
			  seller.setSeller_password(seller_password);
			  seller.setSeller_age(seller_age);
			  if(seller_sex.equalsIgnoreCase("0")){
				  seller_sex="男";
			  }else if(seller_sex.equalsIgnoreCase("1")){
				  seller_sex="女";
			  }
			  seller.setSeller_sex(seller_sex);
			  seller.setSeller_tel(seller_tel);
			  seller.setSeller_address(seller_address);
			  seller.setSeller_email(seller_email);
			   
			
			  System.out.println(seller);
			  
			  if(sellerService.addSeller(seller)){
				  System.out.println("注册成功");
				  seller = sellerService.getSellerByName(seller_name, seller_password);
				  System.out.println("sellerid : " + seller.getSeller_id());
				  try {
					response.sendRedirect("login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }else{
				  System.out.println("注册失败");
			  }
			 }else{
				System.out.println("注册失败"); 
			 }
	}
	
	
	 /**
	 * 修改卖家基本信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void sellerUpdate(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException  {
	 
		  String seller_name = request.getParameter("seller_name"); //用户名
		  String seller_sex = request.getParameter("sex");;//性别
		  Long   seller_age = new Long(request.getParameter("age"));//年龄
		  String seller_address = request.getParameter("seller_address");//地址
		  String seller_email = request.getParameter("email");//用户邮箱
		  
		  //获取登陆的卖家的信息
		  Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller");
		 
		  if(seller != null){
			  Long seller_id = seller.getSeller_id();
			  String seller_password = seller.getSeller_password();
			  
			  /*图片验证开始*/
			  String imageCode = request.getParameter("imageCode");
			  String imageCode_session = (String)request.getSession().getAttribute("imageCode");
				if(imageCode_session!= null && imageCode != null && imageCode_session.equalsIgnoreCase(imageCode)){
					System.out.println("验证通过");

					 /* 正则验证 */
					 boolean flag = false ;
						if(seller_name !=null && seller_email!=null &&seller_sex!=null && seller_age !=null){
							//账户正则
							if(seller_name.matches(nameRegs)){
							  //邮箱
								if(seller_email.matches(emailRegs)){
									 if(seller_sex.equals("男") || seller_sex.equals("女")){
										 if(seller_age > 18 && seller_age < 130){
											 flag = true ;
										 }
									 }
								 } 
							} 
							 
						}	
						/*正则验证结束*/
						if(flag){
							Sellerinfo sellers = new Sellerinfo();
					 		 
							  sellers.setSeller_name(seller_name);
							  sellers.setSeller_age(seller_age);
							  sellers.setSeller_sex(seller_sex);
							  sellers.setSeller_address(seller_address);
							  sellers.setSeller_email(seller_email);
							  sellers.setSeller_id(seller_id);
							  
							  System.out.println(sellers);
							  if(sellerService.updateSeller(sellers)){
								  System.out.println("修改信息成功");
								  //号码跟新成功后，跟新Session中的seller信息
								   seller = sellerService.getSellerById(seller_id, seller_password);
								  request.getSession().setAttribute("seller", seller);
								  //跳回用户界面
								  request.getRequestDispatcher("seller/sellerCenter.jsp").forward(request, response);
							  }else{
								  System.out.println("修改信息失败");
							  }
						}
			 		  
				}else{
					System.out.println("不通过");
				}
			/*图片验证结束*/
		  }else{
			  System.out.println("请先登录");
		  }
		
	 }
	
	/**
	 * 卖家更改绑定的电话
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void sellerUpdateTel(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException  {
		String seller_email = request.getParameter("email");
		String seller_tel = request.getParameter("tel");
		String oldTel = request.getParameter("oldTel");
		String validation = request.getParameter("validation");
		
		
		System.out.println("validation ： " + validation);
		System.out.println("mailCode : " + request.getSession().getAttribute("mailCode"));
		System.out.println("seller_tel : " + seller_tel);
		 Sellerinfo seller = (Sellerinfo) request.getSession().getAttribute("seller");
		  if(seller != null){
				//邮箱验证码相同,即邮箱验证通过
				if(validation!=null && validation.equals(request.getSession().getAttribute("mailCode"))){
					//如果改后的号码与原号码相同
					if(seller_tel.equals(oldTel)){
						//不需要进行验证，弹出与原号码相同
					 }else{
						 Long seller_id = seller.getSeller_id();
						   if(sellerService.updateSellerTel(seller_id, seller_tel)){
							 System.out.println("更改号码成功");
							 //跟新成功，更改valiMsg中的消息
							 request.setAttribute("valiMsg", "");
							 //号码跟新成功后，跟新Session中的seller信息
							 String seller_password = seller.getSeller_password();
							 seller = sellerService.getSellerById(seller_id, seller_password);
							 request.getSession().setAttribute("seller", seller);
							//跳回用户界面
							  request.getRequestDispatcher("seller/sellerCenter.jsp").forward(request, response);
						 }else{
							 System.out.println("更改号码失败");
						 }
					 }
				 }else{
					 System.out.println("邮箱验证失败");
					 request.setAttribute("valiMsg", "验证码错误");
					 
					 //验证码错误，跳转到更改界面
					 request.getRequestDispatcher("seller/updateSellerTel.jsp").forward(request, response);
				 }
		  }else{
			  System.out.println("seller为空");
		  }
	
	
	}
	
	 /**
	 * 通过邮箱验证找回密码
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findBackPassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 
		//获取填写的信息
		String emailCode = request.getParameter("emailCode");
		String emailCode_session = (String) request.getSession().getAttribute("mailCode");
		String sellers = request.getParameter("name");
		
		//更改后的密码
		String seller_password=request.getParameter("password");
		String seller_email = request.getParameter("inbox");
		System.out.println(sellers+"-------"+seller_email);
		
		if(emailCode != null && emailCode_session != null && sellers!= null && seller_password != null && seller_email != null ){
			boolean haveUse = false ;
			//查看是否能通过用户名查找用户
			if(sellerService.findByName(sellers)){  
				Sellerinfo seller = sellerService.getByName(sellers);
				//如果用户输入的等于输入的用户对应的邮箱
				if(seller_email.equals(seller.getSeller_email())){  
						haveUse = true ;
				}else{ //没有的话，说明邮箱不匹配，进行错误回显
					request.setAttribute("mailError", "邮箱输入错误");
				}
			}else if(sellerService.findById( new Long(sellers))){  //是否能通过id找到该用户
				Sellerinfo seller = sellerService.getById( new Long(sellers));
				//如果用户输入的等于输入的用户对应的邮箱
				if(seller_email.equals(seller.getSeller_email())){  
						haveUse = true ;
				}else{ //没有的话，说明邮箱不匹配，进行错误回显
					request.setAttribute("mailError", "邮箱输入错误");
				}
			}else{
				request.setAttribute("nameError", "用户名或账号输入有误");
			}
			
			boolean flag = false;
			if(haveUse){  //如果有该用户， 且邮箱对应，则进行邮箱验证/
				if(emailCode!=null && emailCode_session!=null && emailCode.equalsIgnoreCase(emailCode_session)){
					System.out.println("验证通过 !  emailCode:"+ emailCode+"emailCode_session: "+emailCode_session);
					flag=true;
				}else{
					System.out.println("验证失败");
					flag=false;
				}
				
			}
			
			//如果能过验证并且不为空
			if(haveUse&&flag && sellers!=null && seller_email!=null &&seller_password!=null){
				//如果是用户名
				System.out.println(sellerService.updateSellerPwd(sellers, seller_password, seller_email));
				if(sellerService.updateSellerPwd(seller_password,sellers,  seller_email)){
					System.out.println("修改成功!");
					//如果修改成功，修改session中的seller信息
					Sellerinfo seller = sellerService.getSellerByName(sellers, seller_password);
					request.getSession().setAttribute("seller", seller);
					
					request.setAttribute("msg", "修改成功");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
//				如果是用户id
				else if(sellerService.updateSellerPwd(seller_password, new Long(sellers), seller_email)){
					System.out.println("修改成功!");
					request.setAttribute("msg", "修改成功");
					//如果修改成功，修改session中的seller信息
					Sellerinfo seller = sellerService.getSellerById(new Long(sellers), seller_password);
					request.getSession().setAttribute("seller", seller);
					
					request.getRequestDispatcher("/nav/Login.jsp").forward(request, response);
				}
				else{
					System.out.println("用户名不存在");
					request.setAttribute("msg", "修改成功");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
		 } else{
			System.out.println("信息有为空");
		}
	 }
	/**
	 * ajax查看用户输入的邮箱是否与绑定邮箱对应
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void sellerFindEmail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String seller_email = request.getParameter("inbox");
		String sellers = request.getParameter("name");
		 System.out.println("email ---- " + seller_email );
		 System.out.println("sellers-------" + sellers);
		 if(seller_email != null && sellers != null ){
			//查看是否能通过用户名查找用户
				if(sellerService.findByName(sellers)){  
					Sellerinfo seller = sellerService.getByName(sellers);
					System.out.println("seller : " + seller);
					//如果用户输入的等于输入的用户对应的邮箱
					if(seller_email.equals(seller.getSeller_email())){  
						  response.getWriter().write("邮箱对应");
					 }else{ //没有的话，说明邮箱不匹配，进行错误回显
						  response.getWriter().write("邮箱输入错误");
					  }
				}else if(sellerService.findById(new Long(sellers))  ){  //是否能通过id找到该用户
					Sellerinfo seller = sellerService.getById( new Long(sellers));
					System.out.println("seller : " + seller);
					//如果用户输入的等于输入的用户对应的邮箱
					if(seller_email.equals(seller.getSeller_email())){  
						response.getWriter().write("邮箱对应");
					}else{ //没有的话，说明邮箱不匹配，进行错误回显
						 response.getWriter().write("邮箱输入错误");
					}
				}else{ 
					 response.getWriter().write("用户名或账号输入有误");
				 }
		 }else{
			 System.out.println("信息有为空");
		 }
	}
	
	
	 
	
	/**
	 * ajax判断根据用户名能否找到用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findSellerByNa(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String seller_name = request.getParameter("name");
		System.out.println("name : " + seller_name);
		
		//如果找到了，说明有同名的，那么就不能通过
		if(sellerService.findByName(seller_name)){ 
			 response.getWriter().write("同名");
		}else{
			response.getWriter().write("没有同名");
		}
	
	}
	
	/**
	 * 用户更换头像  头像默认为 : \shopCenter\defaultImg\customimg
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException 
	 */
	public void uploadSellerImg(HttpServletRequest request , HttpServletResponse response) throws ServletException{
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
					
					Sellerinfo seller=new Sellerinfo();
					 
					//获取登陆的卖家的信息
					HttpSession session =request.getSession();
					seller=(Sellerinfo) session.getAttribute("seller");
					System.out.println(seller);
					
					//设置头像地址
					seller.setSeller_img(relativePath);
				  
					//判断是否上传成功
				  	if(sellerService.uploadSellerImg(seller)){
				  		System.out.println("头像上传成功");
				  		//上传成功后，修改session中seller的信息
				  		Long seller_id = seller.getSeller_id();
				  		Sellerinfo sellers = sellerService.getById(seller_id);
				  		request.getSession().setAttribute("seller", sellers);
				  		
				  		request.getRequestDispatcher("seller/sellerCenter.jsp").forward(request, response);
				  	}else{
				  		//上传失败，跳回上传界面
						System.out.println("上传失败");
						request.getRequestDispatcher("seller/uploadSellerImg.jsp").forward(request, response);
					}
				  	
					}else{
						System.out.println("图片格式不正确");
						request.getRequestDispatcher("seller/uploadSellerImg.jsp").forward(request, response);
			
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
