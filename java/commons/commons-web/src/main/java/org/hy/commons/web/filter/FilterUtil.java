package org.hy.commons.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterUtil {

		public static HttpServletRequest convertToHttpServletRequest(ServletRequest request) {
			return (HttpServletRequest)request;
		}
		
		public static HttpServletResponse convertToHttpServletResponse(ServletResponse response) {
			return (HttpServletResponse)response;
		}
		
}
