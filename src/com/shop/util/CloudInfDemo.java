package com.shop.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

public class CloudInfDemo {
	
	//接口生产地址(应用上线后正式环境必须使用该地址)
    //private static String url = "http://www.etuocloud.com/gateway.action";
        
    //接口测试地址（未上线前测试环境使用）
	private static String url = "http://www.etuocloud.com/gatetest.action";
	
	//应用 app_key
	private final static String APP_KEY = "2KYC24Q6s5vGOSXztmmwA6qr5FMvj2Yx";
	//应用 app_secret
	private final static String APP_SECRET = "1RzH37s9bZv7auVYdQgGMbR0xYnPEHBuCrmVP4hm9LSuNESePc4qQVs3DsEDfW4b";
	//接口响应格式 json或xml
	private final static String FORMAT = "json";

	public static void main(String[] args) throws Exception {
		sendSmsCode("13272330416","6666");
//		sendSmsTpl();
//		sendSmsCustom();
//		sendVoiceCode();
//		sendVoiceNotice();
//		getFlowProductList();
//		rechargeFlow();
	}
	/**
	 * 发生短信验证码
	 */
	public static String sendSmsCode(String telephone,String code) {
		System.out.println("telephone + code:  " + telephone +"  +  "+code);
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_key", APP_KEY);
		params.put("view", FORMAT);
		params.put("method", "cn.etuo.cloud.api.sms.simple");
		params.put("out_trade_no", "");
		params.put("to", telephone);
		params.put("template", "1");
		params.put("smscode", code);
		String result = null;
		try {
			params.put("sign", genSign(params));
			result = HttpClientUtils.httpPost(url, params);
		} catch (Exception e) {
			result = "签名或请求错误";
		}
		System.out.println(result);
		return result;
	}
		
	/**
	 * 发生模板短信
	 */
	private static void sendSmsTpl() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_key", APP_KEY);
		params.put("view", FORMAT);
		params.put("method", "cn.etuo.cloud.api.sms.template");
		params.put("out_trade_no", "1");
		params.put("to", "18692274424");
		params.put("template", "1");
		params.put("params", "1234");
		params.put("sign", genSign(params));
		String result = HttpClientUtils.httpPost(url, params);
		System.out.println(result);
	}

	/**
	 * 发送自定义短信
	 */
	private static void sendSmsCustom() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_key", APP_KEY);
		params.put("view", FORMAT);
		params.put("method", "cn.etuo.cloud.api.sms.advance");
		params.put("out_trade_no", "商户订单号，可空");
		params.put("to", "接收自定义短信的手机号");
		params.put("content", "自定义短信内容");
		params.put("sign", genSign(params));
		String result = HttpClientUtils.httpPost(url, params);
		System.out.println(result);
	}

	/**
	 * 发送语音验证码
	 */
	private static void sendVoiceCode() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_key", APP_KEY);
		params.put("method", "cn.etuo.cloud.api.voice.simple");
		params.put("out_trade_no", "商户订单号，可空");
		params.put("to", "接收验证码语音的手机号");
		params.put("template", "语音验证码模板ID");
		params.put("verifyCode", "验证码");
		params.put("sign", genSign(params));
		String result = HttpClientUtils.httpPost(url, params);
		System.out.println(result);
	}

	/**
	 * 发送语音通知
	 * 
	 * @throws IOException
	 */
	private static void sendVoiceNotice() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_key", APP_KEY);
		params.put("method", "cn.etuo.cloud.api.voice.message");
		params.put("out_trade_no", "商户订单号，可空");
		params.put("to", "接收语音通知的手机号");
		params.put("template", "语音通知模板ID");
		params.put("sign", genSign(params));
		String result = HttpClientUtils.httpPost(url, params);
		System.out.println(result);
	}
	
	/**
	 * 获取流量产品列表
	 */
	private static void getFlowProductList() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_key", APP_KEY);
		params.put("method", "cn.etuo.cloud.api.flow.list");
		params.put("sign", genSign(params));
		String result = HttpClientUtils.httpPost(url, params);
		System.out.println(result);
	}
	
	/**
	 * 充值流量
	 */
	private static void rechargeFlow() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_key", APP_KEY);
		params.put("method", "cn.etuo.cloud.api.flow.charge");
		params.put("out_trade_no", "商户订单号，可空");
		params.put("mobile", "被充值流量的手机号");
		params.put("flowcode", "流量产品编码");
		params.put("sign", genSign(params));
		String result = HttpClientUtils.httpPost(url, params);
		System.out.println(result);
	}

	/**
	 * 生成签名
	 * 
	 * 根据参数名称的ASCII码表的顺序排序。如：foo=1, bar=2, foo_bar=3,   foobar=4排序后的顺序是bar=2, foo=1, foo_bar=3, foobar=4
	 * 将排序好的参数名和参数值(以k1=v1&k2=v2...)方式拼装在一起，根据上面的示例得到的结果为：bar=2&foo=1&foo_bar=3&foobar=4
	 * 把拼装好的字符串采用utf-8编码，在拼装的字符串后面加上应用的app_secret后，再进行摘要，如：md5(bar=2&foo=1&foo_bar=3&foobar=4+app_secret)
	 * 将摘要得到的字节流结果使用十六进制表示，如：hex("helloworld".getBytes("utf-8")) = "68656c6c6f776f726c64"
	 */
	private static String genSign(Map<String, String> params)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//TreeMap 默认按key 升序
		Map<String,String> sortMap = new TreeMap<String,String>();
		sortMap.putAll(params);
		//以k1=v1&k2=v2...方式拼接参数
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, String> s : sortMap.entrySet()) {
			String k = s.getKey();
			String v = s.getValue();
			if(StringUtils.isBlank(v)){//过滤空值
				continue;
			}
			builder.append(k).append("=").append(v).append("&");
		}
		if (!sortMap.isEmpty()) {
			builder.deleteCharAt(builder.length() - 1);
		}
		//拼接应用的app_secret
		builder.append(APP_SECRET);
		//摘要
		MessageDigest instance = MessageDigest.getInstance("MD5");
		byte[] digest = instance.digest(builder.toString().getBytes("UTF-8"));
		//十六进制表示
		return new String(encodeHex(digest));
	}

	private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	private static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS_LOWER[0x0F & data[i]];
		}
		return out;
	}
}
