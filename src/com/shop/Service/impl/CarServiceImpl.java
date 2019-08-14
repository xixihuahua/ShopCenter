package com.shop.Service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.shop.Dao.ICarDao;
import com.shop.Dao.ICustomDao;
import com.shop.Dao.impl.CarDaoImpl;
import com.shop.Dao.impl.CustomDaoImpl;
import com.shop.Service.ICarService;
import com.shop.entity.Carinfo;
import com.shop.entity.Custominfo;

public class CarServiceImpl implements ICarService {
	ICarDao carDao = new CarDaoImpl();
	ICustomDao customDao = new CustomDaoImpl();
	/**
	 * 添加商品到购物车
	 * @param car
	 * @return
	 */
	public boolean addCar(Carinfo car){
		return carDao.addCar(car)>0;
		}
	
	/**
	 * 删除指定用户购物车商品
	 * @param car
	 * @return
	 */
	public boolean deleteCar(Long goods_id,Long custom_id){
		return carDao.deleteCar(goods_id, custom_id)>0;
		
	}
	
	/**
	 * 更改购物车
	 * @param car
	 * @return
	 */
	public boolean updateCar(Carinfo car){
		return carDao.updateCar(car)>0;
		
	}
	
	/**
	 * 分页查询根据用户展示购物车
	 * @param custom_id
	 * @return
	 */
	public List<Carinfo> showCar(Long custom_id){
		
		return carDao.showCar(custom_id);
		
	}
	
	
	public static void main(String args[]){
		CarServiceImpl car = new CarServiceImpl();
		Custominfo custom = car.customDao.findCustomById(100003l);
		System.out.println("------car:"+car);
		System.out.print(custom);
		
	}
	/**
	 * 立即购买
	 */
	public int BuyNow(Carinfo car,Long custom_id){
		Custominfo custom =customDao.findCustomById(custom_id);
		System.out.println("----------"+custom);
		System.out.println("------"+car);
		double sum = 0;
		sum = car.getGoods_OutputPrice()*car.getGoods_count()*car.getCarGoods_number();
		System.out.println(sum);
		if( custom.getCustom_money() > sum){
			return carDao.BuyNow(car,custom_id);
		}else{
			//如果钱不够
			return -2;
		}
	
	}
	
	
	/**
	 * 购物车提交订单
	 * @param userinfo
	 * @return  注册成功的话 返回受影响行数应该为 1
	 */
	public int submitCart(List<Carinfo> list,Long custom_id){
		Custominfo custom =customDao.findCustomById(custom_id);
		System.out.println("----------"+custom);
		double sum = 0;
		System.out.println("------list:"+list);
		System.out.println("------"+custom);
		for(Carinfo car:list){
						//单价    *  折扣  * 数量
			sum +=car.getGoods_OutputPrice()*car.getGoods_count()*car.getCarGoods_number();
		}
		System.out.println(sum);
		/*
		 * Carinfo [car_ID=3, goods_id=3, goods_name=null, Goods_Img=null, carGoods_number=4, shop_id=5, goods_desception=想要的面膜, custom_id=10020, goods_OutputPrice=100, goods_count=0]
		 * ]
[{"shop_id":5,"goods_id":3,"carGoods_number":4,"car_ID":3,"goods_OutputPrice":100,"goods_desception":"想要的面膜","goods_count":0,"custom_id":10020}
		 */
		if( custom.getCustom_money() > sum){
			return carDao.submitCart(list, custom_id);
		}else{
			//如果钱不够
			return -2;
		}
		
		
	}
	/**
	 * 分页查询用户购物车的所有商品
	 * @param custom_id
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public List<Carinfo> showCar(Long custom_id, int startRow, int endRow) {
		
		return carDao.showCar(custom_id, startRow, endRow);
	}
	

}
