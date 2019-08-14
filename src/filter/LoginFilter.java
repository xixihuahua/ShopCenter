package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("开始过滤");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤中。。。。。。。。。。。");
		// TODO Auto-generated method stub
		//向下转型
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//进行过滤  如果session中有叫做username的attribute就可以访问页面
		//如果是登录或者注册页面   就直接可以进入这个页面
		 
		if(req.getRequestURI().equals(req.getContextPath()+"/login.jsp") || 
				req.getRequestURI().contains("reg.jsp")){
			//通过过滤器链对请求进行放行
			chain.doFilter(request, response);
		}else{//如果不是登录或者注册页面的话，就要判断session
			HttpSession session = req.getSession();
			if(session.getAttribute("username") == null){
				//如果用户名为空就直接跳到登录页面
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}else{
				//通过过滤器链对请求进行放行
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤完了");
	}

}
