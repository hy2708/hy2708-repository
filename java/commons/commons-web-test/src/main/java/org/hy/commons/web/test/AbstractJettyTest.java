package org.hy.commons.web.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.BeanUtil;
import org.hy.commons.lang.string.StringUtil;
//import org.hy.commons.web.exception.HttpException;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 只能测试单线程的
 */
public abstract class AbstractJettyTest {
	Logger logger = LoggerFactory.getLogger(AbstractJettyTest.class);

	boolean configureWebAppContext = false;

	public WebAppContext getWebAppContext()  {
		
		return JettyUtil.getWebAppContext();
	}
	public void startServer(ServletConfiguration servletConfiguration) throws Exception {
		
		startServer(null,servletConfiguration, new LinkedList<Class<? extends Servlet>>());
	}
	
	/**
	 *  @see AbstractJettyTest#startServer(String, String, List, List, List, ServletConfiguration, List)
	 */
	public void startServer(Class<? extends Servlet> servletClazz) throws Exception {
		
		startServer(new LinkedList<EventListener>(),null	, servletClazz);
	}
	
	/**
	 *  @see AbstractJettyTest#startServer(String, String, List, List, List, ServletConfiguration, List)
	 */
	public void startServer() throws Exception {
		
		//startServer(new LinkedList<EventListener>(), null, new LinkedList<Class<? extends Servlet>>());
		String contextPath=null;
		String resourceBase=null;
		setWebAppContext(contextPath, resourceBase);
		startServer(contextPath, resourceBase);
	}
	/**
	 *  @see AbstractJettyTest#startServer(String, String, List, List, List, ServletConfiguration, List)
	 */
	public void startServer(String contextPath,String resourceBase) throws Exception {
		
		startServer(contextPath,resourceBase,new LinkedList<Class<? extends Filter>> (),new LinkedList<FilterHolder> (), new LinkedList<EventListener>(), null, new LinkedList<Class<? extends Servlet>>());
	}
	
	
	public void startServer(EventListener listener) throws Exception {
		List<EventListener> listeners  = new LinkedList<EventListener>();
		listeners.add(listener);
		startServer(listeners,null	, GetDataRequestServlet.class);
	}
	
	ServletContext servletContext = null;
	HttpServletRequest request = null;
	
	public HttpServletRequest getRequest() {
		HttpServletRequest request = null;	
		request = (HttpServletRequest) getServletContext().getAttribute(SessionTestFilter.REQUEST);
		if (request==null) {
			throw new  RuntimeException("");
		}
		return request;
	}

//	public void setRequest(HttpServletRequest request) {
//		this.request = request;
//	}

	public HttpSession getSession() {
		HttpSession session = null;	
		session = (HttpSession) getServletContext().getAttribute(SessionTestFilter.SESSION);
		if (session==null) {
			throw new  RuntimeException("");
		}
		return session;
	}

//	public void setSession(HttpSession session) {
//		this.session = session;
//	}

	public ServletContext getServletContext() {
		return servletContext;
	}
	
	@Deprecated
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	
	private void _initSession(Map<String, Object> map) {
		initSession(map);
		if (map.size()>0) {
			ServletContext servletContext =getServletContext();
			servletContext.setAttribute(SessionTestFilter.INIT_SESSION, map);			
		}
	}
	
	private void _initServlet(HttpServlet servlet,Map<String, Object> map) {
		initServlet(map);
		if (map.size()>0) {
			for (String key : map.keySet()) {				
				BeanUtil.setDeclaredProperty(servlet, key, map.get(key));
			}
			
		}
	}
	
	@Deprecated
	protected void configureServer(WebAppContext context) {
		
	}
	
	
	@Deprecated
	protected void configureFilters(WebAppContext context,List<Class<? extends Filter>> filters,List<FilterHolder> filterHolders,Map<Class<Filter>, String> map) {
		
	}
	@Deprecated
	private void _configureFilters(WebAppContext context,List<Class<? extends Filter>> filters,List<FilterHolder> filterHolders,Map<Class<Filter>, String> map) {
		configureFilters(context, filters, filterHolders, map);
		if (filters!=null) {
			for (int i = 0; i < filters.size(); i++) {			
				context.addFilter(filters.get(i),  "/*", JettyUtil.getDispatcherTypes());
			}
		}
		
		if (filterHolders!=null) {
			for (int i = 0; i < filterHolders.size(); i++) {			
				context.addFilter(filterHolders.get(i),  "/*", JettyUtil.getDispatcherTypes());
			}
		}
		
		if (map!=null) {
			for (Class<Filter> filter : map.keySet()) {
				
				context.addFilter(filter, map.get(filter), JettyUtil.getDispatcherTypes());
			}
			
		}
	}
	
	/*
	 * 可以废弃
	 */
	@Deprecated
	protected void configureEventListeners(WebAppContext context,List<EventListener> listeners) {
		
	}
	
	@Deprecated
	private void _configureEventListeners(WebAppContext context,List<EventListener> listeners) {
		configureEventListeners(context, listeners);
		if (listeners!=null) {
			for (int i = 0; i < listeners.size(); i++) {			
				context.addEventListener(listeners.get(i));
			}
		}
	}
	
	protected abstract void initServlet(Map<String, Object> map) ;

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：为Session设置默认的初始信息</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-15；时间：下午3:01:59</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param map
	 * @return
	 */
	protected abstract void initSession(Map<String, Object> map) ;
	
	/**
	 *  @see AbstractJettyTest#startServer(List, List, List, ServletConfiguration, List) 
	 */
	private void startServer( ServletConfiguration servletConfiguration,Class<? extends Servlet> servletClazz) throws Exception {
		startServer(null, servletConfiguration, servletClazz);
	}
	
	/**
	 *  @see AbstractJettyTest#startServer(String, String, List, List, List, ServletConfiguration, List)
	 */
	protected void startServer(List<EventListener> listeners, ServletConfiguration servletConfiguration,Class<? extends Servlet>  servletClazz) throws Exception {
		ArrayList<Class<? extends Servlet>> list = new ArrayList<Class<? extends Servlet>>();
		list.add(servletClazz);
		startServer(listeners, servletConfiguration, list);
	}
	
	/**
	 *  @see AbstractJettyTest#startServer(String, String, List, List, List, ServletConfiguration, List)
	 */
	protected void startServer(List<EventListener> listeners, ServletConfiguration servletConfiguration,List<Class<? extends Servlet>>  servletClazzs) throws Exception {
		startServer(new LinkedList<Class<? extends Filter>> (),new LinkedList<FilterHolder> (), listeners, servletConfiguration, servletClazzs);
	}
	
	
	/**
	 *  @see AbstractJettyTest#startServer(String, String, List, List, List, ServletConfiguration, List)
	 */
	protected void startServer(List<Class<? extends Filter>> filters,List<FilterHolder> filterHolders,List<EventListener> listeners, ServletConfiguration servletConfiguration,List<Class<? extends Servlet>>  servletClazzs) throws Exception {
		startServer(
				null,//JettyUtil.MY_APP,
				null,//ProjectPathUtil.getWebRootPath(),
				filters, filterHolders, listeners, servletConfiguration, servletClazzs);
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-9-30；时间：下午1:34:27</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param contextPath 配置contextPath，例如：/myApp
	 * @param resourceBase 配置Webroot的根路径
	 * @param filters 配置filter
	 * @param filterHolders 配置filter
	 * @param listeners 配置listener
	 * @param servletConfiguration 配置servlet
	 * @param servletClazzs 配置servlet
	 * @throws Exception
	 * @return
	 */
	protected void startServer(String contextPath,String resourceBase,List<Class<? extends Filter>> filters,List<FilterHolder> filterHolders,List<EventListener> listeners, ServletConfiguration servletConfiguration,List<Class<? extends Servlet>>  servletClazzs) throws Exception {

		/*//配置web应用，做对应的物理路径
		Class<? extends Servlet> class1 = null;
		if (servletClazzs!=null&&servletClazzs.size()>0) {
			class1 = servletClazzs.get(0);
		}
		if (class1==null&&servletConfiguration!=null) {
			class1 = (Class<? extends Servlet>) servletConfiguration.getClass();
		}
		if (class1==null) {
			//new RuntimeException("请传入servletConfiguration或者servlet");
			JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		}else {
			
			JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath(class1));
		}*/
		
		if (!isConfigureWebAppContext()) {			
			setWebAppContext(contextPath, resourceBase);
		}

		WebAppContext context = JettyUtil.getWebAppContext();
		
		configureServer(context);
		

		/*
		 * 配置filter
		 */
		_configureFilters(context, filters, filterHolders, null);
		/*
		 * 配置listeners
		 */
		_configureEventListeners(context, listeners);

		/*
		 * 配置ServletContext
		 */
		setServletContext(context.getServletContext());
		//初始化session信息
		_initSession(new HashMap<String, Object>());
		//此filter初始化session信息
		SessionTestFilter filter = new SessionTestFilter();		
		FilterHolder filterHolder = new FilterHolder(filter);
		JettyUtil.getWebAppContext().addFilter(filterHolder, "/*", JettyUtil.getDispatcherTypes());
		//配置servlet
		if (servletConfiguration!=null) {			
			servletConfiguration.configureServlet(context);
		}
		//配置servlet
		if (servletClazzs!=null) {
			for (Class<? extends Servlet> servletClazz : servletClazzs) {			
				HttpServlet servlet = (HttpServlet) servletClazz.newInstance();
				_initServlet(servlet, new HashMap<String, Object>());
				JettyUtil.getWebAppContext().addServlet(new ServletHolder(servlet), JettyUtil.HELLO);
			}
		}
		;
		JettyUtil.startServer();
	}
	
	protected void setWebAppContext() {
		setWebAppContext(null, null);
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：设置contextPath和物理路径</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-3-15；时间：下午12:35:45</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param contextPath
	 * @param resourceBase
	 */
	protected void setWebAppContext(String contextPath, String resourceBase) {
		if (StringUtil.isNullOrEmptyString(contextPath)) {
			contextPath=JettyUtil.MY_APP;
		}
		if (StringUtil.isNullOrEmptyString(resourceBase)) {
			resourceBase=ProjectPathUtil.getWebRootPath();
		}
		
		if (FileUtil.existsFile(resourceBase)) {
			
			JettyUtil.setAppContextPath(contextPath, resourceBase);
		}else {
			logger.warn("resourceBase的指定路径【{}】，不存在", resourceBase);
			JettyUtil.setAppContextPath(contextPath);
			
		}
		configureWebAppContext=true;
	}
	
	
	
	public boolean isConfigureWebAppContext() {
		return configureWebAppContext;
	}
	public void setConfigureWebAppContext(boolean configureServer) {
		this.configureWebAppContext = configureServer;
	}
	
	public abstract void tearDown() throws Exception ;
	//public void tearDown() throws Exception {
	//	tearDown(1000);
	//}
	
	public void tearDown(int miniSecond) throws Exception {
		Thread.sleep(miniSecond);
		JettyUtil.stopServer();
	}
}


