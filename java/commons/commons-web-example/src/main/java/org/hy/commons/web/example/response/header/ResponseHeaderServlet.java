package org.hy.commons.web.example.response.header;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.request.dispatcher.DispatcherToServlet_Servlet;
import org.hy.commons.web.example.request.dispatcher.TestRequestServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.response.HttpServletResponseUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseHeaderServlet extends HttpServlet {

	Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP,
				ProjectPathUtil.getWebRootPath());
		
		JettyUtil.getWebAppContext().addServlet(ResponseHeaderServlet.class,
				JettyUtil.HELLO);
		
		JettyUtil.getWebAppContext().addServlet(TestRequestServlet.class,
				"/testRequestServlet");
		
		JettyUtil.startServer();

//		String content = HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
//		Thread.sleep(1000);
//
//		JettyUtil.stopServer();
//		System.err.println(content);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(req, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		HttpServletResponseUtil.setContentType(response, "utf8");
		logger.info("执行【" +
				ResponseHeaderServlet.class.getSimpleName()+
				"】的【doPost】方法");
		//resp.setHeader("location", "http://localhost:8080/day07/1.html");
		//response.setHeader("Refresh","3;url=" +ProjectPathUtil.getWebContextPath(req)+"/testRequestServlet");
		PrintWriter out = response.getWriter();
		String refreshURL = ProjectPathUtil.getWebContextPath(req)+"/testRequestServlet";
		out.print("3秒后自动跳转到查询页面 <a href='" + refreshURL + "'>手动跳转</a>");
		HttpServletResponseUtil.setRefresh(response,  refreshURL);
	}
}
