package org.hy.commons.web.filter.refer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 防盗链
 */
public class ReferFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String refer = req.getHeader("refer");// 得到refer

		if (refer != null && !"".equals("")
				&& !refer.contains(req.getServerName())) {// 属于盗链行为
			System.err.println("盗链来自：" + req.getRemoteAddr());
			// 将请求转为另一个图片，此处的JsCssImage和WEB-INF处于同一个目录下
			request.getRequestDispatcher("/JsCssImage/btn2.jpg").forward(req,
					resp);// 注意用法
		} else {// 正常行为
			System.err.println("xxx盗链来自：" + refer);
			chain.doFilter(req, resp);// 放行请求
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}