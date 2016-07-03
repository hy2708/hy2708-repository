package org.hy.commons.web.example.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class OneFilter implements Filter {
	private FilterConfig conf;
	//此方法只会在tomcat在启动时执行一次
	public void init(FilterConfig conf) throws ServletException {
		this.conf=conf;
		System.err.println("过虑器初始化了:"+this);
		//获取name的值：
		String name = conf.getInitParameter("name");
		System.err.println("name is:"+name);
		System.err.println("----------------------------");
	 	Enumeration<String> en= conf.getInitParameterNames();
		while(en.hasMoreElements()){
			String paramName = en.nextElement();
			String val = conf.getInitParameter(paramName);
			System.err.println(paramName+"="+val);
		}
	}
	//此方法执行过虑任务
	/**
	 * 第三个参数是指过虑器链:
	 */
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
						throws IOException, ServletException {
		System.err.println("1：正在执行过虑："+this+","+request);
		String name = conf.getInitParameter("name");
		System.err.println("doFilter :  name is:"+name);
		
		//执行下一个过虑器，如果没有下一个过虑器则执行目标的servlet
		chain.doFilter(request, response);
		
		System.err.println("3：目标组件，执行完成了...");
		
	}
	public void destroy() {
		System.err.println("过虑器dead.."+this);
	}
}
