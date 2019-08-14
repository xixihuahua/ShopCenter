package com.shop.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.util.CloudInfDemo;
import com.shop.util.NumberUtil;
import com.shop.util.SendMailUtil;
import com.shop.util.VerifyCodeUtils;


public class ValidationServlet extends CenterServlet {
		
	/**
	 * 图片验证
	 * @param request
	 * @param response
	 */
	public void imageValidation(HttpServletRequest request ,HttpServletResponse response){
			
			//设置响应的内容格式
			response.setContentType("image/jpeg");
			//生成四位随机数
			String imageCode = VerifyCodeUtils.generateVerifyCode(4);
			//将生成的随机数设置到session域中
			request.getSession().setAttribute("imageCode", imageCode);
			//将图片输出到响应输出流
			try {
				VerifyCodeUtils.outputImage(200, 30, response.getOutputStream(), imageCode);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * 邮箱验证
		 * @param request
		 * @param response
		 */
		public void mailValidation(HttpServletRequest request ,HttpServletResponse response){
			String inbox = request.getParameter("inbox");
			if(inbox != null){
				String mailCode = NumberUtil.generateVerifyCode(6);
				HttpSession Session = request.getSession();
				request.getSession().setAttribute("mailCode", mailCode);
				SendMailUtil.send(inbox, "购物商城验证码", mailCode);
				try {
					response.getWriter().write("发送成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				try {
					response.getWriter().write("发送失败");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/**
		 * 手机验证
		 * @param request
		 * @param response
		 */
		public void messageValidation(HttpServletRequest request ,HttpServletResponse response){
			String tel = request.getParameter("tel");
			if(tel != null){
				String messageCode = NumberUtil.generateVerifyCode(6);
				request.getSession().setAttribute("messageCode", messageCode);
				CloudInfDemo.sendSmsCode(tel, messageCode);
				try {
					response.getWriter().print("发送成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					response.getWriter().print("发送失败");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		}
}
