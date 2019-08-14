package com.shop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientUtils {

	public static String httpPost(String url, Map<String, String> parameter) throws IOException {
		return httpPost(url, parameter, "UTF-8");
	}

	public static String httpPost(String url, Map<String, String> parameter, String charset) throws IOException {
		NameValuePair[] data = new NameValuePair[parameter.size()];
		Iterator<String> keys = parameter.keySet().iterator();
		for (int i = 0; keys.hasNext(); i++) {
			String key = (String) keys.next();
			String value = (String) parameter.get(key);
			data[i] = new NameValuePair(key, value);
		}
		PostMethod postMethod = new PostMethod(url);
		HttpMethodParams params = postMethod.getParams();
		params.setContentCharset(charset);
		postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
		if (data.length > 0) {
			postMethod.setRequestBody(data);
		}
		HttpClient httpClient = new HttpClient();
		String responseMsg = null;
		int statusCode = 0;
		try {
			statusCode = httpClient.executeMethod(postMethod);
			if (statusCode == 200) {
				responseMsg = getResponseBodyAsString(postMethod);
				return responseMsg;
			} else {
				throw new IOException("服务端内部错误: " + statusCode + " from " + postMethod.getURI());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getResponseBodyAsString(HttpMethod method) throws IOException {
		String charset = "utf-8";
		InputStream resStream = method.getResponseBodyAsStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(resStream, charset));
		StringBuffer resBuffer = new StringBuffer();
		String resTemp = null;
		while ((resTemp = br.readLine()) != null) {
			resBuffer.append(resTemp);
		}
		return resBuffer.toString();
	}

}
