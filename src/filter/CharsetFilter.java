package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 为所有的请求处理编码乱码问题
 */
public class CharsetFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//get方式乱码
		//post方式乱码
		request.setCharacterEncoding("utf-8");
		//处理响应乱码
		response.setContentType("text/html;charset=utf-8");
		//调用自己的包装类
//		HttpServletRequest hreq = (HttpServletRequest)request;
//		MyServletRequestWrapper req = new MyServletRequestWrapper(hreq);
		//请求放行  放行时候的请求用包装类的请求
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}

class MyServletRequestWrapper extends HttpServletRequestWrapper{
	HttpServletRequest request;
	public MyServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		try {
			byte[] b = value.getBytes("iso-8859-1");
			value = new String(b,"utf-8");
			return value;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@Override
	public String[] getParameterValues(String name) {
		String[] values = request.getParameterValues(name);
		try {
			for(int i= 0 ;i < values.length; i++){
				values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
			}
			return values;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
