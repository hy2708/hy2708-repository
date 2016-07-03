package org.hy.commons.web.filter.login;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
public class BaseLoginFilter implements Filter{

	Logger logger = LoggerFactory.getLogger(getClass());
	static final List<String> excludeUrlList= new LinkedList<String>();
	static  List<String> loginKeys = new LinkedList<String>();
	String loginUrl = "/page/login.html";
	
	

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("拦截器【" +
				getClass()+"】，启动");
		
	}
	
	protected void setExcludeUrls(String... excludeUrls) {
		for (String excludeUrl : excludeUrls) {
			excludeUrlList.add(excludeUrl);
		}

	}
	
	protected List<String> getExcludeUrls(){
		return excludeUrlList;
	}
	
	public List<String> getLoginKeys() {
		if (loginKeys==null||loginKeys.size()==0) {
			BaseLoginFilter.loginKeys.add("user");
			BaseLoginFilter.loginKeys.add("name");
			BaseLoginFilter.loginKeys.add("username");
		}
		return loginKeys;
	}

	public void setLoginKeys(String... loginKeys) {
		
		for (String string : loginKeys) {			
			BaseLoginFilter.loginKeys.add(string);
		}
		
	}
	
	
	
	private boolean isFilterPath(HttpServletRequest request) {
		List<String> list = getExcludeUrls();
		for (String excludePath : list) {
			if (request.getRequestURI().contains(excludePath)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isLogin(HttpServletRequest req) {
		//记录是否已经登录的标记
		boolean flag=false;
		for (String loginKey : getLoginKeys()) {		
			//如果Session已经登录
			/*
			 * session通过url追加
			 * session通过cookie获取
			 */
			if (req.getSession().getAttribute(loginKey)!=null) {
				flag = true;
				return flag;				
			}			
		}
		
		for (String loginKey : getLoginKeys()) {
			// 如果Cookie已经登录
			Cookie[] cookies = req.getCookies();
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				String cookieValue = cookie.getValue();
				if ( (cookieName.equalsIgnoreCase(loginKey))) {
					flag = true;
					// break;
					return flag;
				}
			}
		}		
		return false;

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = FilterUtil.convertToHttpServletRequest(request);
		
		boolean e= isFilterPath(req);
		
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
			
			boolean flag = isLogin(req);
			if (flag) {				
				chain.doFilter(request, response);
			}
			
			/*
			 * 如果没有登录信息，则跳转到登录页面
			 */
			if (!flag) {
				req.getRequestDispatcher(loginUrl).forward(request, response);
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
