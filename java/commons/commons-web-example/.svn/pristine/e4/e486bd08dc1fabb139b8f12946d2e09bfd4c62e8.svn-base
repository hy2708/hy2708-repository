package org.hy.commons.web.example.request.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.request.encoding.GetCNDataRequestServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.response.encoding.SendCNServlet;
import org.hy.server.jetty8.JettyUtil;

import junit.framework.TestCase;

public class GetCNDataRequestServletTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDoGetHttpServletRequestHttpServletResponse() throws InterruptedException, UnsupportedEncodingException {
		Server server =JettyUtil.getServer();
		JettyUtil.setAppContextPath(HttpClientUtil.MY_APP);
		JettyUtil.addServlet(GetCNDataRequestServlet.class, HttpClientUtil.HELLO);
		JettyUtil.startServer();
//		String encode = URLEncoder.encode("中文" ,IoUtil.DEFAULT_CHARSET);
		String encode = URLEncoder.encode("中文" ,IoUtil.DEFAULT_CHARSET);

		String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL+"?username='" +
				encode+"'");
		Thread.sleep(10000);
		JettyUtil.stopServer();
		System.err.println(content);
	}

	public void testDoPostHttpServletRequestHttpServletResponse() throws InterruptedException, UnsupportedEncodingException {
		Server server =JettyUtil.getServer();
		System.err.println(IoUtil.DEFAULT_CHARSET);
		String projectPath = ProjectPathUtil.getProjectPath();
		
		String webRootResource = projectPath + "/src/main/webapp";
		System.err.println(webRootResource);
		WebAppContext webAppContext = JettyUtil.setAppContextPath(HttpClientUtil.MY_APP,webRootResource);
		
//		JettyUtil.setAppContextPath(HttpClientUtil.MY_APP);
		JettyUtil.getWebAppContext().addServlet(GetCNDataRequestServlet.class, HttpClientUtil.HELLO);
		JettyUtil.startServer();
//		String encode = URLEncoder.encode("中文" ,IoUtil.DEFAULT_CHARSET);
		String encode = "中文";

		String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL+"?username='" +
				encode+"'");
		Thread.sleep(10000);
		JettyUtil.stopServer();
//		System.err.println(content);
	}

}
