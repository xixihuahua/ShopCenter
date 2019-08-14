package com.shop.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
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

import com.shop.Service.ICustomService;
import com.shop.Service.impl.CustomServiceImpl;
import com.shop.entity.Custominfo;
 


public class CustomServlet extends CenterServlet {
	CustomServiceImpl customService = new CustomServiceImpl();
	
	/*正则表达式*/
	public String nameRegs="^.{3,16}$";
	public String passwordRegs="^[a-zA-Z]\\w{5,17}$";
	public String ageRegs = "^(?:[1-9][0-9]?|1[01][0-9]|120)$";
	public String telRegs = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$" ;
	public String emailRegs = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
	 
	 
	/*正则结束*/
	
	/**
	 * 买家登陆
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void customLogin(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
			String custom =  request.getParameter("name");
			String custom_password = request.getParameter("password");
		
			 /*
			   正则验证
			 */
			boolean flag = false;
			//非空判断
			if(custom!=null&& custom_password!=null){
				if(custom.matches(nameRegs)){
					System.out.println("用户名验证成功");
					if(custom_password.matches(passwordRegs)){
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
			 /*正则验证结束*/
			
			//正则验证通过
			Custominfo customer = null ;
			 
			if(flag){
				String reg = "^\\d*$";
				
				//如果不匹配，说明一定是用户名
				if(!custom.matches(reg)){
					
					if(customService.findCustomByName(custom, custom_password)) {
						//通过用户名查找到用户
						customer = customService.getCustomByName(custom, custom_password);
						System.out.println(customer);
						System.out.println("登陆成功");
						request.getSession().setAttribute("customer", customer);
						 try {
							request.getRequestDispatcher("nav/shopCenter.jsp").forward(request, response);
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
					if(customService.findCustomById(new Long(custom), custom_password)){
						//通过用户id查找到用户
						
						customer = customService.getCustomById(new Long(custom), custom_password) ;
						System.out.println(customer);
						request.getSession().setAttribute("customer", customer);
						System.out.println("登陆成功");
						 try {
							request.getRequestDispatcher("nav/shopCenter.jsp").forward(request, response);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						 System.out.println("用户名或密码错误");
						 response.getWriter().write("找不到用户名或密码错误");
					}
					
				}
				
			}
		
	}
	
	/**
	 * 买家注册
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void customReg(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException  {
		 
		  String custom_name = request.getParameter("name"); //用户名
		  String custom_password = request.getParameter("password"); ; //用户密码
		  String custom_sex = request.getParameter("sex");;//性别
		  Long   custom_age = new Long(request.getParameter("age"));//年龄
		  String custom_tel = request.getParameter("tel");//电话
		  String custom_address = request.getParameter("provice")+"-"+request.getParameter("city")+"-"
				  +request.getParameter("area")+"-"+request.getParameter("street");//地址
		  String custom_email = request.getParameter("email");//用户邮箱
		  
		  /*定义，检测验证是否通过*/
		  boolean flag=false;   //正则验证
		  boolean code=false;  //图片验证
		  
		  
		  /*图片验证开始*/
		  String imageCode = request.getParameter("imageCode");
			String imageCode_session = (String)request.getSession().getAttribute("imageCode");
			if(imageCode_session!= null && imageCode != null && imageCode_session.equalsIgnoreCase(imageCode)){
				System.out.println("验证通过");
				 code=true;
			}else{
				System.out.println("不通过");
				 code = false ;
			}
		/*图片验证结束*/
			
			/* 正则验证 */
			if(code && custom_name !=null && custom_password!=null &&custom_tel!=null && custom_email!=null &&custom_sex!=null){
				//账户正则
				if(custom_name.matches(nameRegs)){
					flag=true;
					//密码正则
					if(custom_password.matches(passwordRegs)){
						flag=true;
						//邮箱
						if(custom_email.matches(emailRegs)){
							flag=true;
							//电话
							if(custom_tel.matches(telRegs)){
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
			/*正则验证结束*/
			
			 
				
				if(flag){
			 		  Custominfo custom = new Custominfo();
			 		 
					  custom.setCustom_name(custom_name);
					  custom.setCustom_password(custom_password);
					  custom.setCustom_age(custom_age);
					
					  if(custom_sex.equalsIgnoreCase("0")){
						  custom_sex="男";
					  }else if(custom_sex.equalsIgnoreCase("1")){
						  custom_sex="女";
					  }
					  custom.setCustom_sex(custom_sex);
					  custom.setCustom_tel(custom_tel);
					  custom.setCustom_address(custom_address);
					  custom.setCustom_email(custom_email);
					   
					
					  System.out.println(custom);
					  
					  
					  if(customService.addCustom(custom)){
						  System.out.println("注册成功");
						  
						  custom = customService.getCustomByName(custom_name, custom_password);
						  System.out.println("customid : " + custom.getCustom_id());
						  response.getWriter().write("请记好您的另外一个登陆账号"+custom.getCustom_id());
						  
						  try {
							
							response.sendRedirect("nav/shopCenter.jsp");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  }else{
						  request.setAttribute("str", false);
						  System.out.println("注册失败");
					  }
					}else{
						System.out.println("注册失败");
						request.setAttribute("str", false);
						request.getRequestDispatcher("reg.jsp").forward(request, response);
					}
				
				
			}
			
 	
	/**
	 * 用户更换头像  头像默认为 : \shopCenter\defaultImg\customimg
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException 
	 */
	public void uploadCustomImg(HttpServletRequest request , HttpServletResponse response) throws ServletException{
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
					
					//
					int pointIndex = fileName.lastIndexOf('.');
					//判断文件是否为图片格式
					String last = fileName.substring(pointIndex+1);
					
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
						
						//获取当前登陆的买家
						 Custominfo customer=(Custominfo) request.getSession().getAttribute("customer");
						 Long custom_id = customer.getCustom_id();
						 String custom_img = relativePath;
						
					  	if(customService.updateCustomImg(custom_id, custom_img)){
					  		System.out.println("头像上传成功");
					  		//头像上传成功，修改session中customer的信息
					  		
					  		Custominfo custom = customService.getById(custom_id);
					  		request.getSession().setAttribute("customer", custom);
					  		
					  		request.getRequestDispatcher("custom/customCenter.jsp").forward(request, response);
					  	}else{
					  		
							System.out.println("上传失败");
							request.getRequestDispatcher("custom/uploadCustomImg.jsp").forward(request, response);
						}
					}else{
						System.out.println("不是图片格式");
						request.getRequestDispatcher("custom/uploadCustomImg.jsp").forward(request, response);
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
	 * 通过邮箱验证找回密码
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findBackPassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 
		//获取填写的信息
		String emailCode = request.getParameter("emailCode");
		String emailCode_session = (String) request.getSession().getAttribute("mailCode");
		String customs = request.getParameter("name");
		
		//更改后的密码
		String custom_password=request.getParameter("password");
		String custom_email = request.getParameter("inbox");
		System.out.println(customs+"-------"+custom_email);
		if(emailCode != null && emailCode_session !=null && customs!= null && custom_password!=null && custom_email != null){
			boolean haveUse = false ;
			//查看是否能通过用户名查找用户
			if(customService.findByName(customs)){  
				Custominfo custom = customService.getByName(customs);
				//如果用户输入的等于输入的用户对应的邮箱
				if(custom_email.equals(custom.getCustom_email())){  
						haveUse = true ;
				}else{ //没有的话，说明邮箱不匹配，进行错误回显
					request.setAttribute("mailError", "邮箱输入错误");
					
					 
				}
			}else if(customService.findById( new Long(customs))){  //是否能通过id找到该用户
				Custominfo custom = customService.getById( new Long(customs));
				//如果用户输入的等于输入的用户对应的邮箱
				if(custom_email.equals(custom.getCustom_email())){  
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
			if(haveUse&&flag && customs!=null && custom_email!=null &&custom_password!=null){
				//如果是用户名
				System.out.println(customService.updateCustomPwd(customs, custom_password, custom_email));
				if(customService.updateCustomPwd(custom_password,customs,  custom_email)){
					System.out.println("修改成功!");
					request.setAttribute("msg", "修改成功");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				//如果是用户id
				else if(customService.updateCustomPwd(custom_password, new Long(customs), custom_email)){
					System.out.println("修改成功!");
					request.setAttribute("msg", "修改成功");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else{
					System.out.println("用户名不存在");
					request.setAttribute("msg", "修改成功");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
				
			}
			
		}else{
			System.out.println("信息不全");
		}
		 
		
		
	}
	
	/**
	 * 在通过邮箱验证的时候， 判断用户输入的邮箱是否与绑定的邮箱一致
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void customFindEmail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String custom_email = request.getParameter("inbox");
		String customs = request.getParameter("name");
		 System.out.println("email ---- " + custom_email );
		 System.out.println("customs-------" + customs);
		 if(custom_email != null && customs != null){
			//查看是否能通过用户名查找用户
				if(customService.findByName(customs)){  
					Custominfo custom = customService.getByName(customs);
					System.out.println("custom : " + custom);
					//如果用户输入的等于输入的用户对应的邮箱
					if(custom_email.equals(custom.getCustom_email())){  
						  response.getWriter().write("邮箱对应");
					 }else{ //没有的话，说明邮箱不匹配，进行错误回显
						  response.getWriter().write("邮箱输入错误");
					  }
				}else if(customService.findById(new Long(customs))  ){  //是否能通过id找到该用户
					Custominfo custom = customService.getById( new Long(customs));
					System.out.println("custom : " + custom);
					//如果用户输入的等于输入的用户对应的邮箱
					if(custom_email.equals(custom.getCustom_email())){  
						response.getWriter().write("邮箱对应");
					}else{ //没有的话，说明邮箱不匹配，进行错误回显
						 response.getWriter().write("邮箱输入错误");
					}
				}else{ 
					 response.getWriter().write("用户名或账号输入有误");
				 }
		 }else{
			 System.out.println("信息不全");
		 }
		 
		
		
		
		
	}
	
	/**
	 * 修改买家基本信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void customUpdate(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException  {
	 
		  String custom_name = request.getParameter("custom_name"); //用户名
		  String custom_sex = request.getParameter("sex");;//性别
		  Long   custom_age = new Long(request.getParameter("age"));//年龄
		  String custom_address = request.getParameter("custom_address");//地址
		  String custom_email = request.getParameter("email");//用户邮箱
		  
		  System.out.println("custom_address  : " + custom_address);
		  Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
		  
		  if(customer != null){
			  /*图片验证开始*/
			  String imageCode = request.getParameter("imageCode");
			  String imageCode_session = (String)request.getSession().getAttribute("imageCode");
				if(imageCode_session!= null && imageCode != null && imageCode_session.equalsIgnoreCase(imageCode)){
					 System.out.println("图片验证通过");
				        /* 正则验证 */
					 boolean flag = false ;
						if(custom_name !=null && custom_email!=null &&custom_sex!=null && custom_age !=null){
							//账户正则
							if(custom_name.matches(nameRegs)){
								  //邮箱
									if(custom_email.matches(emailRegs)){
										 if(custom_sex.equals("男") || custom_sex.equals("女")){
											 if(custom_age > 18 && custom_age < 130){
												 flag = true ;
											 }
										 }
									 } 
							} 
							 
						}	
						/*正则验证结束*/
						
						//通过正则验证
						if(flag = true){
							Custominfo custom = new Custominfo();
					 		 
							  custom.setCustom_name(custom_name);
							  custom.setCustom_age(custom_age);
							  custom.setCustom_sex(custom_sex);
							  custom.setCustom_address(custom_address);
							  custom.setCustom_email(custom_email);
							  custom.setCustom_id(customer.getCustom_id());
							   
							  
							  System.out.println(custom);
							  if(customService.updateCustom(custom)){
								  System.out.println("修改信息成功");
								   //号码跟新成功后，跟新Session中的customer信息
								  custom = customService.getCustomById(customer.getCustom_id(), customer.getCustom_password());
								  request.setAttribute("customer", custom);
								  //跳回用户界面
								  request.setAttribute("msg","修改成功");
								  response.getWriter().write("修改成功");
								  request.getRequestDispatcher("/custom/customCenter.jsp").forward(request, response);
							  }else{
								  System.out.println("修改信息失败");
								  request.getSession().setAttribute("msg", "修改失败");
								  response.getWriter().write("修改成功");
							  }
						}
			 		  
				}else{
					System.out.println("图片验证不通过");
					request.setAttribute("msg", "修改失败");
					response.getWriter().write("修改失败");
					request.getRequestDispatcher("/custom/customCenter.jsp").forward(request, response);
				}
			/*图片验证结束*/
		  }else{
			  System.out.println("请先登陆");
		  }
		
	 }
	
	
	/**
	 * 卖家更改绑定的电话
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void customUpdateTel(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException  {
		 
		String custom_tel = request.getParameter("tel");
		String oldTel = request.getParameter("oldTel");
		String validation = request.getParameter("validation");
		
		
		System.out.println("validation ： " + validation);
		System.out.println("mailCode : " + request.getSession().getAttribute("mailCode"));
		System.out.println("custom_tel : " + custom_tel);
		 //获取买家信息
		Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");
		 
		if(custom != null){
			//邮箱验证码相同,即邮箱验证通过
			if(validation!=null && validation.equals(request.getSession().getAttribute("mailCode"))){
				//如果改后的号码与原号码相同
				if(custom_tel.equals(oldTel)){
					//不需要进行验证，弹出与原号码相同
					System.out.println("更改后与原号码相同");
				 }else{
					 Long custom_id = custom.getCustom_id();
					 
					 //判断号码是否更改成功
					   if(customService.updateCustomTel(custom_id, custom_tel)){
						 System.out.println("更改号码成功");
						 //跟新成功，更改valiMsg中的消息
						 request.setAttribute("valiMsg", "");
						 //号码跟新成功后，跟新Session中的custom信息
						 String custom_password = custom.getCustom_password();
						 custom = customService.getCustomById(custom_id, custom_password);
						 request.getSession().setAttribute("customer", custom);
						//跳回用户界面
						  request.getRequestDispatcher("nav/customCenter.jsp").forward(request, response);
						 }else{
							 System.out.println("更改号码失败");
							//更改号码失败，跳转到更改界面
							 request.getRequestDispatcher("custom/customCenter.jsp").forward(request, response);
						 }
				 }
			 }else{
				 System.out.println("邮箱验证失败");
				 request.setAttribute("valiMsg", "验证码错误");
				 
				 //验证码错误，跳转到更改界面
				 request.getRequestDispatcher("custom/updateCustomTel.jsp").forward(request, response);
			 }
		}else{
			System.out.println("请先登录");
		}
		
	
	}
	
	
	
	
	
	/**
	 * ajax判断根据用户名能否找到用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCustomByNa(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String custom_name = request.getParameter("name");
		System.out.println("name : " + custom_name);
		
		//如果找到了，说明有同名的，那么就不能通过
		if(customService.findByName(custom_name)){ 
			response.getWriter().write("同名");
		}else{
			response.getWriter().write("没有同名");
		}
	
	}
	
	/**
	 * 判断根据用户名能否找到用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCustomByName(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String custom_name = request.getParameter("name");
		System.out.println("name : " + custom_name);
		
		//如果找到了，说明有同名的，那么就不能通过
		if(customService.findByName(custom_name)){ 
			response.getWriter().write("同名");
		}else{
			response.getWriter().write("没有同名");
		}
	
	}
	
	//买家注销用户
	public void delCustom(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			Custominfo customer = (Custominfo) request.getSession().getAttribute("customer");
			System.out.println(customer);
			
			response.getWriter().write("我不准你删啊!!!");
			//清除该用户的购物车
			
			//删除用户
			//customService.deleteCustom(customer.getCustom_id());
	 }
	
	
	/**
	 * 卖家更改绑定的支付密码
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void customUpdatePay(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException  {
		 
		String custom_paypwd = request.getParameter("pwd");
		String oldPwd = request.getParameter("oldPwd");
		String validation = request.getParameter("validation");
		
		
		System.out.println("validation ： " + validation);
		System.out.println("mailCode : " + request.getSession().getAttribute("mailCode"));
		System.out.println("custom_pwd : " + custom_paypwd);
		 //获取买家信息
		Custominfo custom = (Custominfo) request.getSession().getAttribute("customer");
		 if(custom !=null){
				//邮箱验证码相同,即邮箱验证通过
				if(validation!=null && validation.equals(request.getSession().getAttribute("mailCode"))){
					//如果改后的号码与原号码相同
					if(custom_paypwd.equals(oldPwd)){
						//不需要进行验证，弹出与原号码相同
						System.out.println("更改后与原支付密码相同");
					 }else{
						 Long custom_id = custom.getCustom_id();
						 
						 //判断号码是否更改成功
						   if(customService.updateCustomPayPwd(custom_id, custom_paypwd)){
							 System.out.println("更改支付密码成功");
							 //跟新成功，更改valiMsg中的消息
							 request.setAttribute("valiMsg", "");
							 //号码跟新成功后，跟新Session中的custom信息
							 String custom_password = custom.getCustom_password();
							 custom = customService.getCustomById(custom_id, custom_password);
							 request.getSession().setAttribute("customer", custom);
							//跳回用户界面
							  request.getRequestDispatcher("nav/shopCenter.jsp").forward(request, response);
							 }else{
								 System.out.println("更改支付密码失败");
								//更改号码失败，跳转到更改界面
								 request.getRequestDispatcher("custom/customCenter.jsp").forward(request, response);
							 }
					 }
				 }else{
					 System.out.println("邮箱验证失败");
					 request.setAttribute("valiMsg", "验证码错误");
					 
					 //验证码错误，跳转到更改界面
					 request.getRequestDispatcher("custom/customCenter.jsp").forward(request, response);
				 }
			
		 } else{
			 System.out.println("请先登录");
			 
		 }
	
	}
	
	
	
	
}
