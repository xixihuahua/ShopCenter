package com.shop.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CenterServlet extends HttpServlet {
 /**
  * 控制层工具类
  */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8"); 
		//获取请求的方法的参数
				String methodName = request.getParameter("method");
				System.out.println("methodName :  " +  methodName);
				System.out.println("访问CenterServlet.......");
				
				if(methodName != null){
					//获取被访问的servlet的字节码文件
					Class clazz = this.getClass();
					 System.out.println("clazz : " + clazz);
					try {
						//获取提交上来的参数中的方法名对应的方法
						Method m = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
						if(m!=null){
							//通过反射调用需要执行的对应的方法
							m.invoke(this, request,response);
						}
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
