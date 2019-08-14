package com.shop.Service;

import java.math.BigDecimal;
import java.util.List;

import com.shop.entity.Carinfo;

public interface ICarService {
	/**
	 * 添加商品到购物车
	 * @param car
	 * @return
	 */
	public boolean addCar(Carinfo car);
	
	/**
	 * 删除指定用户购物车商品
	 * @param car
	 * @return
	 */
	public boolean deleteCar(Long goods_id,Long custom_id);
	
	/**
	 * 更改购物车
	 * @param car
	 * @return
	 */
	public boolean updateCar(Carinfo car);
	
	/**
	 * 根据用户展示购物车
	 * @param custom_id
	 * @return
	 */
	public List<Carinfo> showCar(Long custom_id);
	
	/**
	 * 分页查询用户购物车的所有商品
	 * @param custom_id
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	List<Carinfo>  showCar(Long custom_id,int startRow ,int endRow);
	
	/**
	 * 立即购买
	 * @param car
	 * @param custom_id
	 * @return
	 */
	public int BuyNow(Carinfo car,Long custom_id);
	
	/**
	 * 购物车提交订单
	 * @param userinfo
	 * @return  注册成功的话 返回受影响行数应该为 1
	 */
	public int submitCart(List<Carinfo> list,Long custom_id);
	
}
