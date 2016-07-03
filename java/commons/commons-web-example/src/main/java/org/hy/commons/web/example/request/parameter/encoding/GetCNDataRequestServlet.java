package org.hy.commons.web.example.request.parameter.encoding;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCNDataRequestServlet extends HttpServlet {

	private static Logger logger = LoggerFactory.getLogger(GetCNDataRequestServlet.class);
	
	
	public static void main(String[] args) {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP,System.getProperty("user.dir")+ "/src/main/webapp");
		JettyUtil.getWebAppContext().addServlet(GetCNDataRequestServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		
		String content = HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL+"?username=中文");

		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("操作系统默认字符集是【" +	IoUtil.DEFAULT_CHARSET+	"】");
		//确定请求编码
		/*
		 * 在【doGet】方法中，request.setCharacterEncoding("utf8")不起作用
		 */
		//request.setCharacterEncoding("utf8");
		logger.info("在【doGet】方法中，request.setCharacterEncoding('utf8')不起作用");
		
		logger.info("执行【" +getClass().getSimpleName()+	"】的【doGett】方法");
		
		logger.info("【request.getCharacterEncoding()" +
				 "】得到是值是【" +
				 request.getCharacterEncoding()+"】");
		
		logger.info("【request.getQueryString()】，Url路径后面的查询字符串是【{}】",request.getQueryString());
		
		//get请求处理提交数据中的 中文
		/*
		 * request.getParameter("username")，会自动，对%xx形式的字符，进行解码
		 */
		String username = request.getParameter("username");
		logger.info("request.getParameter('username')，会自动，对%xx形式的字符，进行解码");
		
		logger.info("【request.getParameter('username')】得到是值是【" +
				 request.getParameter("username")+"】");
		
		
	//===================================================================================================	
		//获得用户get请求提交的数据
		// 注意：前提是用URLDecoder.encode编码
		String query = request.getQueryString();
		
		//解码
		String q = URLDecoder.decode(query, "UTF-8");
		logger.info("Url路径后面的查询字符串是【" +
				query+
				 "】，进行解码，得到是【" +
				 q+"】");
		
		
		//提交后url中的内容：getCNDataRequestServlet?username=%E4%B8%AD%E6%96%87
		
		
		//解码操作
		//这样解码，得到的是乱码
		String u = URLDecoder.decode(username, "utf8");
		//String u = URLDecoder.decode(username, "GBK");
		logger.info("【URLDecoder.decode(username, ‘utf8’)】这样解码，得到的是乱码:"+u);
		//这样解码，得到的是正确的中文		
		String str = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		logger.info("【new String(username.getBytes(‘ISO-8859-1’),‘UTF-8’)】这样解码，得到的是正确的中文**** " + str);
		/*
		 * 因为HTTP的请求行
		 * request.getQueryString()获得的，才是原来浏览器上输入的参数值
		 * 
		 * request.getParameter("username");是把上一步的参数字符串，又重新按照ISO8859-1重新编码过的
		 * 需要用username.getBytes("ISO-8859-1")，把username再次解码，
		 * 再用new String(username.getBytes("ISO-8859-1"),"UTF-8")编码
		 * 
		 * 注意：前提是用URLDecoder.encode编码		
		 */
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("执行【" +
				getClass().getSimpleName()+
				"】的【doPost】方法");
		//需要通知tomcat，用户提交的数据的字符集UTF-8
		request.setCharacterEncoding("UTF-8");
		//request.setCharacterEncoding("GBK");
		//request.getPathInfo()
		logger.info("在【doPost】方法中，request.setCharacterEncoding('utf8')起作用" +
				",如设置成GBK，则会出现乱码");

		logger.info("因此只需要在【doPost】方法中，设置，request.setCharacterEncoding('utf8')");
												
		logger.info("【request.getCharacterEncoding()" +
						 "】得到是值是【" +
						 request.getCharacterEncoding()+"】");
				
		logger.info("【request.getQueryString()】，Url路径后面的查询字符串是【" +
						 request.getQueryString()+
						 "】");
				
				//get请求处理提交数据中的 中文
				/*
				 * request.getParameter("username")，会自动，对%xx形式的字符，进行解码
				 */
		String username = request.getParameter("username");
		logger.info("request.getParameter('username')，会自动，对%xx形式的字符，进行解码");
				
		logger.info("【request.getParameter('username')" +
						 "】得到是值是【" +
						 request.getParameter("username")+"】");
		System.err.println("00"+request.getRequestURI());
		System.err.println("00"+request.getPathInfo());
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<html><head>");
		response.getWriter().println("<meta http-equiv='Content-Type' content='text/html; charset=gbk'>");
		response.getWriter().println("</head><body>");
		response.getWriter().println("中文");
		response.getWriter().println(request.getParameter("username"));
		response.getWriter().println("</body></html>");

	}

}
