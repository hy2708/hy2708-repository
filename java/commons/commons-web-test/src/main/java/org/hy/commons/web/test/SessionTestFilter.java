package org.hy.commons.web.test;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hy.commons.lang.ObjectUtil;

import jodd.util.SystemUtil;

import com.meterware.pseudoserver.HttpRequest;

public class SessionTestFilter implements Filter{

	static final String INIT_SESSION="_initSession";
	static final String SESSION="_session";
	static final String REQUEST="_request";
	static ThreadLocal<HttpSession> tl = new ThreadLocal<HttpSession>();

	
	public HttpSession getSession() {
		return tl.get();
	}

	public void setSession(HttpSession session) {
		tl.set(session);
	}

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		//初始化session信息
		initSession(req);
//		((SessionHandler)req.getServletContext().getAttribute("_initSession")).initSession(session);
		
		
		//setSession(session);
		
		req.getServletContext().setAttribute(REQUEST, request);
		//ObjectUtil.clone(req);
		chain.doFilter(request, response);
		
		req.getServletContext().setAttribute(SESSION, session);
		
	}

	public void initSession(HttpServletRequest req) {
		Map<String, Object> map = (Map<String, Object>) req.getServletContext().getAttribute(INIT_SESSION);
		if (map!=null) {
			for (String name : map.keySet()) {			
				req.getSession().setAttribute(name, map.get(name));
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
interface SessionHandler{
	public void initSession(HttpSession session);
}
