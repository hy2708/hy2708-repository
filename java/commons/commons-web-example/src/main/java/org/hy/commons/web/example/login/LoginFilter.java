package org.hy.commons.web.example.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.hy.commons.web.filter.FilterUtil;
import org.hy.commons.web.servlet.HttpServletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 除了，专门用于登录的，那个url路径不能拦截，理论上，其他url都可以拦截
 * 用于注销，也不拦截
 */
public class LoginFilter implements Filter{

	Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = FilterUtil.convertToHttpServletRequest(request);
		String path = req.getRequestURI();
		String excludeUrl="";
		boolean e= !(path.contains(excludeUrl));
		logger.debug("拦截器【" +
				getClass().getSimpleName()+
				"】，开始执行：拦截的请求路径是【" +
				HttpServletUtil.getRequestServletPath(req)+
				"】");
		//选择需要拦截的request请求
		if (true) {
			
			/*
			 * 根据Session或者Cookie判断，是否已经登录
			 */
			
			//记录是否已经登录的标记
			boolean flag=false;
			//如果Session已经登录
			if (req.getSession().getAttribute("user")!=null||
					req.getSession().getAttribute("username")!=null||
					req.getSession().getAttribute("name")!=null) {
				flag = true;
				chain.doFilter(request, response);
				
			}
			//如果Cookie已经登录
			else {
				Cookie[] cookies = req.getCookies();
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();
					String cookieValue = cookie.getValue();
					if (cookieName!=null&&(cookieName.equalsIgnoreCase("user")||
							cookieName.equalsIgnoreCase("name")||
							cookieName.equalsIgnoreCase("username"))) {
						flag = true;
						chain.doFilter(request, response);
						break;
					}
				}
			}
			
			
			/*
			 * 如果没有登录信息，则跳转到登录页面
			 */
			if (!flag) {
				req.getRequestDispatcher("/login/login.html").forward(request, response);
			}
			logger.debug("拦截器【" +
					getClass().getSimpleName()+
					"】，执行完毕：拦截的请求路径是【" +
				HttpServletUtil.getRequestServletPath(req)+
				"】");
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
