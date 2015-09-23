package org.hy.commons.web.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.err.println("1:这是第一个Filter开始。。。");
		//放行
		System.err.println("filterChain object is"+chain.hashCode());
		System.err.println("filterChain thread is"+Thread.currentThread());
		chain.doFilter(request, response);
		//回来
		System.err.println("5:第一个过虑器执行完成。。");
	
	}
	public void destroy() {
	}
}
