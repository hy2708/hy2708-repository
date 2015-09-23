package org.hy.commons.web.response;

import java.io.IOException;

import javax.activation.MimeType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.MimeTypes;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.string.StringUtil;

public class HttpServletResponseUtil {
	
	
	public static void getLocation(HttpServletResponse response) {
		response.getHeader("location");

	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：<b>见下</b></li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-6-30；时间：上午9:58:34</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @param response
	 * @param url 它，是contextPath下的url路径，例如：contextPath=“myApp” url="/hello"
	 * @return
	 */
	public static void sendRedirect(HttpServletRequest request,HttpServletResponse response,String url) {
		try {
			response.sendRedirect(ProjectPathUtil.getWebContextPath(request)+url);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void sendRedirect(HttpServletResponse response,String url) {
		
			response.setStatus(302);
			setLocation(response, url);

	}
	
	public static void setContentType(HttpServletResponse response) {
		setContentType(response, "UTF-8");
	}
	
	public static void setContentType(HttpServletResponse response,String charsetName) {
		response.setContentType("text/html;charset=" +
				charsetName +
				"");
	}
	public static void setLocation(HttpServletResponse response,String location) {
		response.setHeader("location", location);
		
	}

	public static void setRefresh(HttpServletResponse response,String url) {
		setRefresh(response, 3, url);
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：相当于，设置页面重定向</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-3；时间：上午9:40:01</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param response
	 * @param delay
	 * @param url
	 * @return
	 */
	public static void setRefresh(HttpServletResponse response, int delay,
			String url) {
		if (StringUtil.isNullOrEmptyString(url)) {
			response.setHeader("Refresh", "" + delay);

		} else {

			response.setHeader("Refresh", "" + delay + ";url=" + url);
		}
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：多次刷新</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-16；时间：下午4:10:03</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param response
	 * @param delay
	 * @return
	 */
	public static void setRefresh(HttpServletResponse response,int delay) {
		setRefresh(response, delay, null);
	}

}
