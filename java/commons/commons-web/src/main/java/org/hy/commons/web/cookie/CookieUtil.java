package org.hy.commons.web.cookie;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	
	public Cookie findCookie(HttpServletRequest request,String cookieName) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookieName.equalsIgnoreCase(cookie.getName())) {
				
				return cookie;
			}
		}
		return null;

	}
	
	public List<Cookie> findCookies(HttpServletRequest request,String cookieName) {
		Cookie[] cookies = request.getCookies();
		List<Cookie> list = new LinkedList<Cookie>();
		for (Cookie cookie : cookies) {
			if (cookieName.equalsIgnoreCase(cookie.getName())) {
				list.add(cookie);
			}
		}
		return list;//.toArray(new Cookie[list.size()]);

	}
	
	public static void printCookieInfo(Cookie cookie) {
		printCookieInfo(new Cookie[]{cookie});
	}
	public static void printCookieInfo(Cookie[] cookies) {
		logger.debug("cookies 的数量是"+cookies.length+"===================================================");
		if(cookies != null && cookies.length>0){
			for(Cookie c : cookies){
				logger.debug("cookie domain :" + c.getDomain()+",为了保证cookie的安全，永远只显示为null");
				logger.debug("cookie path :" + c.getPath()+",为了保证cookie的安全，永远只显示为null");
				logger.debug("cookie comment :" + c.getComment());
				
				logger.debug("cookie maxAge :" + c.getMaxAge()+",为了保证cookie的安全，永远只显示为-1");
				logger.debug("cookie version :" + c.getVersion());
				logger.debug("cookie name :" + c.getName());
				logger.debug("cookie value:" + c.getValue());
								
				logger.debug("=====================================================================");
			}

		}else{
			logger.warn("不存在cookie");
		}
	}

}