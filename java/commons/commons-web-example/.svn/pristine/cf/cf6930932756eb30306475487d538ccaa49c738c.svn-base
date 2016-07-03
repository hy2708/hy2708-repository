package org.hy.commons.web.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.err.println("2:这是第二个过虑器");
		System.err.println("filterChain object is"+chain.hashCode());
		System.err.println("filterChain thread is"+Thread.currentThread());

		//放行，执行目标servlet
		chain.doFilter(request, response);
		System.err.println("4:第二个过虑器执行完成了");
	}

	public void destroy() {
	}
}
