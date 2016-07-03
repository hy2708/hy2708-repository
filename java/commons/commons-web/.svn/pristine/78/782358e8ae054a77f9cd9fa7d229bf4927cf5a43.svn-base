package org.hy.commons.web.servlet;



import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import jodd.servlet.ServletUtil;
import jodd.util.StringPool;
import jodd.util.URLCoder;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.date.DateUtil;
import org.hy.commons.lang.string.StringUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * HttpServlet
 */
public class HttpServletUtil extends ServletUtil{
	private static final Logger logger = LoggerFactory.getLogger(HttpServletUtil.class);

	
	public static void main(String[] args) {
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
	}
	
	public static Object getAttributeFromContext(HttpServlet servlet,
			String attributeName) {
		// 在servletContext中获取属性值
		// * 获得sc
		ServletContext sc = servlet.getServletContext();
		// * 获得bs属性值
		Object obj = sc.getAttribute(attributeName);
		return obj;
	}
	
	// ---------------------------------------------------------------- cookie

	/**
	 * Finds and returns cookie from client by its name.
	 * Only the first cookie is returned.
	 * @see #getAllCookies(javax.servlet.http.HttpServletRequest, String)
	 * @return cookie value or <code>null</code> if cookie with specified name doesn't exist.
	 */
	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		return ServletUtil.getCookie(request, cookieName);
	}

	/**
	 * Returns all cookies from client that matches provided name.
	 * @see #getCookie(javax.servlet.http.HttpServletRequest, String) 
	 */
	public static Cookie[] getAllCookies(HttpServletRequest request, String cookieName) {
		return ServletUtil.getAllCookies(request, cookieName);
		
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：返回协议名称，如：http, https, or ftp</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-22；时间：上午10:44:46</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 * @return
	 */
	public static String getRequestProtocolName(HttpServletRequest request) {
		return request.getScheme();
	//	
	}
	
	public static String getRequestHeader(HttpServletRequest request,String name) {
		return request.getHeader(name);
	//	
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：从request请求中，获得域名</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-13；时间：下午7:06:18</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 * @return
	 */
	public static String getRequestDoamin(HttpServletRequest request) {
		return getRequestHostName(request);
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：从request请求中，获得域名</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-13；时间：下午7:07:30</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 * @return
	 */
	public static String getRequestHostName(HttpServletRequest request) {
		return request.getServerName();
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：从request请求中，获得端口</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-13；时间：下午7:07:56</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 */
	public static int getRequestPort(HttpServletRequest request) {
		return request.getServerPort();
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：
	 * 例如:请求的是,localhost:8080/myApp/hello
	 * <br/>实际返回的是/myApp
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-13；时间：下午7:09:37</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 * @return
	 */
	public static String getRequestContextPath(HttpServletRequest request) {
		return getContextPath(request);
	}
	

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：
	 * 	 例如:请求的是,localhost:8080/myApp/hello
	 * <br/>实际返回的是/hello
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-15；时间：下午3:26:15</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 * @return
	 */
	public static String getRequestServletPath(HttpServletRequest request) {
		return request.getServletPath();
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：
	 * 	 例如:请求的是,localhost:8080/myApp/hello?a=111
	 * <br/>实际返回的是/myApp/hello
	 * <br/>没有?a=111
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-16；时间：上午11:03:13</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 */
	public static String getRequestURI(HttpServletRequest request) {
		String contextPath = request.getRequestURI();				
		logger.debug("【req.getRequestURI()】的返回值是【" +contextPath+"】");
		return request.getRequestURI();
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：
	 * 方法返回客户端发出请求时的完整URL。
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-18；时间：下午7:09:25</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 */
	public static String getRequestURL(HttpServletRequest request) {
		StringBuffer contextPath = request.getRequestURL();				
		logger.debug("【req.getRequestURL()】的返回值是【" +contextPath+"】");
		return contextPath.toString();
	}
	
	/*
	 * 为经过充分测试
	 */
	@Deprecated
	public static String getRequestURIInContext(HttpServletRequest request) {
		throw new RuntimeException();
		//return getRequestURI(request).replaceFirst(getContextPath(), "");
	}
	
	public static String getResponseHeader(HttpServletResponse response,String name) {
		return response.getHeader(name);
	//	
	}
	
	public static void setResponseHeader(HttpServletResponse response,String name,String value) {
		response.setHeader(name,value);
	//	
	}
	
	/**
	 * @see HttpServletUtil#setResponseCharset(HttpServletResponse, String) 
	 */
	public static void setResponseCharset(HttpServletResponse response) {
		setResponseCharset(response, "utf-8");
	}


	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-19；时间：下午7:12:55</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param response
	 * @param charset
	 */
	public static void setResponseCharset(HttpServletResponse response,String charset) {
		/*
		 * 在服务器端，设置编码，用什么编码向浏览器写入数据，
		 * 把把字符数据，按制定的编码，把字符编码成字节流
		 * 默认的字符编码是ISO-8859-1(因为中文，无法用ISO-8859-1，编码 成字节，所以会有乱码)
		 * 
		 */
		response.setCharacterEncoding(charset);
		/*
		 * 告诉浏览器，用什么编码把，字节流，转换成字符流
		 */
		response.setContentType("text/html;charset=" + charset);

	//	
	}
	public static void setResponseCharset(HttpServletRequest request,String charset) {
		
	}

	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：例如:请求的是,http://localhost:8080/myApp/hello</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-15；时间：下午1:32:55</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param req
	 * @return
	 * @return
	 */
	public static String getWholeUrl(HttpServletRequest req) {
		
		//String path = request.getContextPath();
		String basePath = null;
		//basePaht = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		basePath = getRequestProtocolName(req)+"://"+getRequestDoamin(req)+":"+getRequestPort(req)+getRequestContextPath(req);
		return basePath+"/"+getRequestServletPath(req);
		
	}

	public static String getInitParameterFromContext(HttpServlet servlet,String parameterName) {
		// 在任意servlet中获取context的配置信息

		// * 获得ServletContext
		ServletContext sc = servlet.getServletContext();
		// * 获得所有的配置信息的名称 <context-param><param-name>
		Enumeration<String> names = sc.getInitParameterNames();
		// * 遍历
		while (names.hasMoreElements()) {
			
			// * 获得每一个名称
			String name = names.nextElement();
			if (name.equals(parameterName)) {
				
				return sc.getInitParameter(name);
			}
			// * 获得指定名称的内容 <context-param><param-value>
			//System.out.println("context -->  " + name + " : " + value);
		}
		return null;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：<br/>
	 * 例如:请求的是,localhost:8080/myApp/hello
	 * <br/>实际返回的是/myApp
	 * Returns correct context path, as by Servlet definition. Different
	 * application servers return all variants: "", null, "/".
	 * <p>
	 * The context path always comes first in a request URI. The path
	 * starts with a "/" character but does not end with a "/" character.
	 * For servlets in the default (root) context, this method returns "".
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-18；时间：下午5:44:40</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param req
	 * @return
	 */
	public static String getContextPath(HttpServletRequest req){
		//System.out.println("get");
		String contextPath = req.getContextPath();				
		logger.debug("【req.getContextPath()】的返回值是【" +contextPath+"】");
		
	
	// ---------------------------------------------------------------- context path

		if (contextPath == null || contextPath.equals(StringPool.SLASH)) {
			contextPath = StringPool.EMPTY;
		}
		return contextPath;
	}
	
	/**
	 * Returns correct context path, as by Servlet definition. Different
	 * application servers return all variants: "", null, "/".
	 * <p>
	 * The context path always comes first in a request URI. The path
	 * starts with a "/" character but does not end with a "/" character.
	 * For servlets in the default (root) context, this method returns "".
	 */
	public static String getContextPath(ServletContext servletContext) {
		String contextPath = servletContext.getContextPath();
		if (contextPath == null || contextPath.equals(StringPool.SLASH)) {
			contextPath = StringPool.EMPTY;
		}
		return contextPath;
	}

	/**
	 * @see #getContextPath(javax.servlet.ServletContext)
	 */
	public static String getContextPath(PageContext pageContext) {
		return getContextPath(pageContext.getServletContext());
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：获取项目所在的实际屋里路径</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-9-3；时间：下午6:28:55</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param req
	 * @return
	 * @return
	 */
	public static String getContextResourceBase(HttpServletRequest req){
		//System.out.println("get");
		String contextPath = req.getServletContext().getRealPath("");				
		logger.debug("获取【当前web应用的实际物理路径】是【" +contextPath+"】");
		return contextPath;
		
		
	}
	
	@Deprecated
	public static String getServletContext(HttpServletRequest req,String relativePath){
		
		
//		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc = req.getServletContext();
				
		//获得实际路径,要求/开头
		String path = sc.getRealPath(relativePath);
//		String path = sc.getRealPath("/");
//		String path2 = sc.getRealPath("");
//		String path = req.getRequestDispatcher("/").toString();  // context root
//		String path = sc.getResource("/").toString(); 
		//C:\java\tomcat\apache-tomcat-6.0.35\webapps\day06
		logger.info("【ServletContext.getRealPath('/')】的返回值是【" +path+"】");
//		logger.info("【ServletContext.getRealPath('')】的返回值是【" +path2+"】");
		
		return path;
	}
	
	public static String getServletPath(HttpServletRequest req){
		//System.out.println("get");
		String servletPath = getRequestServletPath(req);//req.getContextPath();				
		logger.debug("【req.getServletPath()】的返回值是【" +servletPath+"】");
		return servletPath;
		
		
	}
	
	
	public static URL getResource(HttpServletRequest request,String relativePath) throws MalformedURLException {
		//获得资源文件
		ServletContext sc = request.getServletContext();
		System.out.println(sc);
				
		URL url = sc.getResource(relativePath);  //http://localhost:8080/day06/1.html
		System.out.println(url.getPath());
		
		return url;
		
	}
	
	public static InputStream getResourceAsStream(HttpServletRequest request,String relativePath) throws MalformedURLException {
		//获得资源文件
		ServletContext sc = request.getServletContext();
		System.out.println(sc);
						
		InputStream is = sc.getResourceAsStream(relativePath);
		System.out.println(is);
		return is;
		
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：Returns <code>true</code> if a request is multi-part request.</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-16；时间：下午12:20:26</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param request
	 * @return
	 * @return
	 */
	public static boolean isMultipartRequest(HttpServletRequest request) {
		return ServletUtil.isMultipartRequest(request);
	}
	
	/**
	 * Returns <code>true</code> if client supports gzip encoding.
	 */
	public static boolean isGzipSupported(HttpServletRequest request) {
		return ServletUtil.isGzipSupported(request);
	}

	// ---------------------------------------------------------------- authorization
	
	

	

	







	/**
	 * Stores context path in server context and request scope.
	 */
	public static void storeContextPath(PageContext pageContext, String contextPathVariableName) {
		String ctxPath = getContextPath(pageContext);

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		request.setAttribute(contextPathVariableName, ctxPath);

		ServletContext servletContext = pageContext.getServletContext();
		servletContext.setAttribute(contextPathVariableName, ctxPath);
	}

	/**
	 * Stores context path in page context and request scope.
	 */
	public static void storeContextPath(ServletContext servletContext, String contextPathVariableName) {
		String ctxPath = getContextPath(servletContext);

		servletContext.setAttribute(contextPathVariableName, ctxPath);
	}

	// ---------------------------------------------------------------- attributes and values


	

	// ---------------------------------------------------------------- resolve URL

	/**
	 * Valid characters in a scheme, as specified by RFC 1738.
	 */
	public static final String VALID_SCHEME_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-";

	/**
     * Returns <code>true</code> if current URL is absolute, <code>false</code> otherwise.
     */
    public static boolean isAbsoluteUrl(String url) {
	    if (url == null) {      	    // a null URL is not absolute
		    return false;
	    }
	    int colonPos;                   // fast simple check first
	    if ((colonPos = url.indexOf(':')) == -1) {
		    return false;
	    }

	    // if we DO have a colon, make sure that every character
	    // leading up to it is a valid scheme character
	    for (int i = 0; i < colonPos; i++) {
		    if (VALID_SCHEME_CHARS.indexOf(url.charAt(i)) == -1) {
			    return false;
		    }
	    }
	    return true;
    }

	/**
	 * Strips a servlet session ID from <code>url</code>.  The session ID
	 * is encoded as a URL "path parameter" beginning with "jsessionid=".
	 * We thus remove anything we find between ";jsessionid=" (inclusive)
	 * and either EOS or a subsequent ';' (exclusive).
	 */
	public static String stripSessionId(String url) {
		StringBuilder u = new StringBuilder(url);
		int sessionStart;
		while ((sessionStart = u.toString().indexOf(";jsessionid=")) != -1) {
			int sessionEnd = u.toString().indexOf(';', sessionStart + 1);
			if (sessionEnd == -1) {
				sessionEnd = u.toString().indexOf('?', sessionStart + 1);
			}
			if (sessionEnd == -1) {
				sessionEnd = u.length();
			}
			u.delete(sessionStart, sessionEnd);
		}
		return u.toString();
	}

	public static String resolveUrl(String url, PageContext pageContext) {
		return resolveUrl(url, (HttpServletRequest) pageContext.getRequest());
	}

	public static String resolveUrl(String url, HttpServletRequest request) {
		if (isAbsoluteUrl(url)) {
			return url;
		}
		if (url.startsWith(StringPool.SLASH)) {
			return getContextPath(request) + url;
		} else {
			return url;
		}
	}

	public static String resolveUrl(String url, String context) {
		if (isAbsoluteUrl(url)) {
			return url;
		}
		if (!context.startsWith(StringPool.SLASH) || !url.startsWith(StringPool.SLASH)) {
			throw new IllegalArgumentException("Values of both 'context' and 'url' must start with '/'.");
		}
		if (context.equals(StringPool.SLASH)) {
			return url;
		} else {
			return (context + url);
		}
	}

	// ---------------------------------------------------------------- params

	/**
	 * Returns HTTP request parameter as String or String[].
	 */
	public static Object getRequestParameter(ServletRequest request, String name) {
		String[] values = request.getParameterValues(name);
		if (values == null) {
			return null;
		}
		if (values.length == 1) {
			return values[0];
		}
		return values;
	}

	/**
	 * Checks if some parameter is in GET parameters.
	 */
	public boolean isGetParameter(HttpServletRequest request, String name) {
		name = URLCoder.encodeQueryParam(name) + '=';
		String query = request.getQueryString();
		String[] nameValuePairs = StringUtil.splitc(query, '&');
		for (String nameValuePair : nameValuePairs) {
			if (nameValuePair.startsWith(name)) {
				return true;
			}
		}
		return false;
	}





	
	// ---------------------------------------------------------------- cache

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：禁止缓存
	 * Prevents HTTP cache.
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-18；时间：下午3:32:43</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param response
	 */
	public static void preventCaching(HttpServletResponse response) {
		response.setHeader("Cache-Control", "max-age=0, must-revalidate, no-cache, no-store, private, post-check=0, pre-check=0");  // HTTP 1.1
		response.setHeader("Pragma","no-cache");        // HTTP 1.0
		response.setDateHeader ("Expires", 0);          // prevents caching at the proxy server
	}
	
	public static void settCacheTime(HttpServletResponse resp,
			Integer day,Integer hour,Integer minute,Integer second) {
		//日历
		Calendar cl = Calendar.getInstance();
		Date date=cl.getTime();
		//日历上加7天
		DateUtil.addTime(cl, day, hour, minute, second);
		long time = cl.getTimeInMillis();
		//计算2天以后的*毫秒*值
		resp.setDateHeader("expires",time);//IE
  		//resp.setHeader("pragma","no-cache");//   HTTP/1.1 
  		/*
  		 * max-age=xxx (xxx is numeric) 	
  		 * 缓存的内容将在 xxx *秒* 后失效, 这个选项只在HTTP 1.1可用, 
  		 * 并如果和Last-Modified一起使用时, 优先级较高
  		 */
  		//long t2 = 60*60*24*7;
  		resp.setHeader("cache-control","max-age="
  		+(DateUtil.getSeconds(cl)-DateUtil.getSeconds(date))); //   HTTP/1.0 
	}
	
	// ---------------------------------------------------------------- request body

	/**
	 * Reads HTTP request body. Useful only with POST requests. Once body is read,
	 * it cannot be read again!
	 */
	public static String readRequestBody(HttpServletRequest request) throws IOException {
		return ServletUtil.readRequestBody(request);
	}

	
	public static void removeAttributeFromContext(HttpServlet servlet,
			String attributeName) {
		// 在servletContext中获取属性值
		// * 获得sc
		ServletContext sc = servlet.getServletContext();
		// * 获得bs属性值
		//Object obj = sc.getAttribute(attributeName);
		sc.removeAttribute(attributeName);
		//return obj;
	}
	public static void setAttributeFromContext(HttpServlet servlet,
			String attributeName,String value) {
		// 在servletContext中获取属性值
		// * 获得sc
		ServletContext sc = servlet.getServletContext();
		// * 获得bs属性值
		//Object obj = sc.getAttribute(attributeName);
		sc.setAttribute(attributeName, value);
		//return obj;
	}
	
	
	
	
	
}
