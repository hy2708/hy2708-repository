package org.hy.commons.web.example.request.dispatcher.attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.cookie.CookieInfoServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//例如从Servlet，转发到jsp（也是Servlet）
public class AttributeToPage_DispatcherServlet extends HttpServlet {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(AttributeToPage_DispatcherServlet.class, JettyUtil.HELLO);
		//JettyUtil.getWebAppContext().addServlet(TestRequestServlet.class, "/testRequestServlet");
		JettyUtil.startServer();

		//String content = HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		/*
		 * 需要人工访问http://localhost:8080/myApp/hello
		 */
		Thread.sleep(15000);

		JettyUtil.stopServer();
		//System.err.println(content);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//转发  -- 当前请求未完成
		
		// * 获得请求调度器
		/*
		 * 参数:
		 * 当前页面：http://localhost:8080/day07/requestDispatcherServlet
		 * 目标页面：http://localhost:8080/day07/testRequestServlet
		 * / -- context root --> WebRoot  --> tomcat/webapps/day07
		 */
//		RequestDispatcher dispatcher = request.getRequestDispatcher("testRequestServlet");
		
		/*
		 * request.getRequestDispatcher("/testRequestServlet").forward(request, response)
		 * 执行之后，最好，加上    return;
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		
		//需要将数据发送的浏览器
		PrintWriter out = response.getWriter();
		
		logger.info("【" +
				getClass().getSimpleName()+
				"】转发给【" +
				"/index.jsp"+
				"】之前");
		/*
		 * //没有发送到浏览器
		 */
		out.println("【" +
				getClass().getSimpleName()+
				"】以下内容可以在浏览器中显示<br/>");
		out.print("【" +
				getClass().getSimpleName()+
				"】转发给【" +
				"/index.jsp"+
				"】页面转发前<br/>");  //没有发送到浏览器
		// * 转发操作  -- 调用服务器端的一个方法
		
		// 在转发之前，在request中设置值
		request.setAttribute("root", "123456");
		System.out.println(request);
		dispatcher.forward(request, response);  //显示最后一个输出的内容

//		dispatcher.include(request, response);  //合并当前所有的执行页面的输出内容
		
		out.print("【" +
				"】"); //没有发送到浏览器
		
		/*
		 * //没有发送到浏览器
		 */
		out.print("【" +
				getClass().getSimpleName()+
				"】转发给【" +
				"/index.jsp"+
				"后，从【" +
				"/index.jsp"+
				"】"+
				"返回到【" +
				getClass().getSimpleName()+
				"】，【" +
				getClass().getSimpleName()+
				"】继续调用<br/>"); //没有发送到浏览器
		logger.info("【" +
				getClass().getSimpleName()+
				"】转发给【" +
				"/index.jsp"+
				"后，从【" +
				"/index.jsp"+
				"】"+
				"返回到【" +
				getClass().getSimpleName()+
				"】，【" +
				getClass().getSimpleName()+
				"】继续调用");
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
