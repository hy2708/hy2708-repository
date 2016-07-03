package org.hy.commons.web.example.servlet.context;

import java.io.IOException;

import javax.servlet.ServletException;

import junit.framework.Assert;

import org.apache.cactus.ServletTestCase;
import org.apache.cactus.WebRequest;
import org.eclipse.jetty.server.Server;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.example.entity.User;
import org.hy.commons.web.example.login.LoginServlet;
import org.hy.commons.web.example.request.dispatcher.DispatcherToServlet_Servlet;
import org.hy.commons.web.example.request.dispatcher.TestRequestServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebResponse;

/**
 * 只要写了一个类继承于 ServletTestCase，就会拥有相应的request等方法
 * 需要注意的一点就是：此时junit4中的Annotation全部不起作用
 * 就得按照junit3的方法来:setUp和tearDown用来做初始化和结束释放资源
 * testXX用来做测试
 * @author Administrator
 *
 */
public class TestLoginServletByCactus extends ServletTestCase {
	
	
	private LoginServlet servlet;
	//begin是在客户端执行的
	public void beginNoSession(WebRequest request) {
		request.setAutomaticSession(false);
		request.addParameter("username", "kh");
	}
	
	//在服务器端执行
	public void setUp() {
		servlet = new LoginServlet();
	}
	public void testNoSession() {
		//服务器端执行
		Assert.assertFalse(servlet.isLogin(request));
		Assert.assertEquals(request.getParameter("username"),"kh");
		
	}
	
	public void testSessionNoUser() {
		Assert.assertFalse(servlet.isLogin(request));
	}
	
	public void testSessionHasUser() {
		session.setAttribute("loginUser", new User());
		Assert.assertTrue(servlet.isLogin(request));
	}
	
	public void testDoGet() throws ServletException, IOException {
		servlet.doGet(request, response);
	}
	
	//客户端执行
	public void endDoGet(WebResponse resp) {
		try {
			Assert.assertEquals(resp.getTables()[0].getCellAsText(0,0),"111");
			Assert.assertEquals(resp.getTables()[0].getCellAsText(0,1),"222");
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

}
