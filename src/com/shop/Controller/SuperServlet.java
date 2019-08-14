package com.shop.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.shop.Service.ICustomService;
import com.shop.Service.impl.CustomServiceImpl;
import com.shop.entity.Custominfo;


public class SuperServlet extends CenterServlet {
	ICustomService customService = new CustomServiceImpl();
	/**
	 * 查找所有用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllCustom(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		List<Custominfo> list = customService.findAllCustom() ;
		JSONArray arr = new JSONArray(list);
		response.getWriter().print(arr);
	}
}
