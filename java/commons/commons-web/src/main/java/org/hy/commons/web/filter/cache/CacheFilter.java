package org.hy.commons.web.filter.cache;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.lang.string.StringUtil;


public class CacheFilter implements Filter {

	/*
	 * 默认，不设置缓存
	 */
	Boolean flag = false;
	public void init(FilterConfig filterConfig) throws ServletException {
		String hasCache =  filterConfig.getInitParameter("hasCache");
		
		if (StringUtil.isNotEmpty(hasCache)&&
				hasCache.equalsIgnoreCase("true")) {
			flag = true;
			//默认缓存时间是七天
		}
	}
	
	/**
	 * 默认情况下，不设置缓存
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//转换
		HttpServletResponse resp = (HttpServletResponse) response;
		if (flag) {
			//计算2天以后的*毫秒*值
			//日历
			Calendar cl = Calendar.getInstance();
			//日历上加7天
			cl.add(Calendar.DATE, 7);
			long time = cl.getTimeInMillis();
			resp.setDateHeader("expires",time);//IE
	  		//resp.setHeader("pragma","no-cache");//   HTTP/1.1 
	  		/*
	  		 * max-age=xxx (xxx is numeric) 	
	  		 * 缓存的内容将在 xxx *秒* 后失效, 这个选项只在HTTP 1.1可用, 
	  		 * 并如果和Last-Modified一起使用时, 优先级较高
	  		 */
	  		long t2 = 60*60*24*7;
	  		resp.setHeader("cache-control","max-age="+t2); //   HTTP/1.0 
		}else {
			resp.setHeader("expires","-1");//IE
	  		resp.setHeader("pragma","no-cache");//   HTTP/1.1 
	  		resp.setHeader("cache-control","no-cache"); //   HTTP/1.0 
		}
		//都放行
		chain.doFilter(request,resp);
	}

	public void destroy() {
		
	}
	
}
