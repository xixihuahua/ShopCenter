package com.shop.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class NumberUtil {
	 //使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符  
    public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";  
    private static Random random = new Random();  
  
  
    /** 
     * 使用系统默认字符源生成验证码 
     * @param verifySize    验证码长度 
     * @return 
     */  
    public static String generateVerifyCode(int verifySize){  
        return generateVerifyCode(verifySize, VERIFY_CODES);  
    }  
    /** 
     * 使用指定源生成验证码 
     * @param verifySize    验证码长度 
     * @param sources   验证码字符源 
     * @return 
     */  
    public static String generateVerifyCode(int verifySize, String sources){  
        if(sources == null || sources.length() == 0){  
            sources = VERIFY_CODES;  
        }  
        int codesLen = sources.length();  
        Random rand = new Random(System.currentTimeMillis());  
        StringBuilder verifyCode = new StringBuilder(verifySize);  
        for(int i = 0; i < verifySize; i++){  
            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));  
        }  
        return verifyCode.toString();  
    }  
    
    /**
	 * 获取年月日时分秒的当前时间
	 * @return
	 */
	public static String nowTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
	/**
	 * 生成订单编号
	 * @return
	 */
	public static String getOrderCode(){
		Calendar c = Calendar.getInstance();//获取一个日历对象
		//获取系统的年月日用来做文件夹的分层
		String year = c.get(Calendar.YEAR) + "";//年
		int m = c.get(Calendar.MONTH) + 1;
		String month = m < 10 ? "0"+m  : ""+m;
		int d = c.get(Calendar.DAY_OF_MONTH);
		String day = d < 10 ? "0"+d : ""+d;
		
		Random random = new Random();
		//生成一个0-8999的数字并加上1000 产生一个1000-9999的验证码
		Integer num = random.nextInt(1000);
		return "" +  year + month + day + num;
		
	}  
}
