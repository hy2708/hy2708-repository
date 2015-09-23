package org.hy.commons.web.example.filter.charset;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.filter.charset.CharFilter;
import org.hy.server.jetty8.JettyUtil;

public class CharsetFilterTest {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-8-1；时间：上午9:13:26</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 * @return 
	 */
	public static void main(String[] args) {
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addFilter(CharFilter.class, "/*", JettyUtil.getDispatcherTypes());
		JettyUtil.getWebAppContext().addServlet(MyServlet.class,"/login"+JettyUtil.HELLO );
		JettyUtil.startServer();
	}

}


