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

public class CacheFilter2 implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//转换
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//计算2天以后的毫秒值
		//日历
		Calendar cl = Calendar.getInstance();
		//日历上加2天
		cl.add(Calendar.DATE, 2);
		long time = cl.getTimeInMillis();
		resp.setDateHeader("expires", time);
		//resp.setHeader("expires",""+time);
//  		resp.setHeader("pragma","no-cache");
//  		resp.setHeader("cache-control","no-cache");
		//都放行
		chain.doFilter(request,resp);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
