package org.hy.commons.web.example.servlet.compression;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.session.DemoSessionServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.servlet.compression.GZipServletUtil;
import org.hy.server.jetty8.JettyUtil;


public class GZipHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP,ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(GZipHttpServlet.class, JettyUtil.HELLO);
//		JettyUtil.getServletContextHandler().addServlet(GZipHttpServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();

		//HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		
		//Thread.sleep(1000);
		//JettyUtil.stopServer();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		//将大数据压缩后，发送给浏览器
		//准备大数据
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < 800 ; i ++){
			builder.append("abcd");
		}
		String data = builder.toString();
		response.setContentType("text/html;charset=utf8");
		
		//不进行压缩
		response.getWriter().write(data);
		
		//进行压缩
		//gzipWrite(response, data,"utf8");
		//GZipServletUtil.gzipWrite(response, data, "utf8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private HttpServletResponse gzipWrite(HttpServletResponse response,StringBuffer content,String charsetName) throws IOException {
		return gzipWrite(response, content.toString(), charsetName);
	}
	
	
	private HttpServletResponse gzipWrite(HttpServletResponse response,String content,String charsetName) throws IOException {
		response.setContentType("text/html;charset=" +
				charsetName +
				"");
		byte[] bytes = content.getBytes(charsetName);
		return gzipWrite(response, bytes);
	}

		
	
	private HttpServletResponse gzipWrite(HttpServletResponse response,byte[] bytes) throws IOException {
		//通知浏览器，服务器发送的数据时压缩的，并且指定压缩的格式
		response.setHeader("content-encoding", "gzip");
						
		/*
		 * ByteArrayOutputStream不需要，输入File的地址或者filepath
		 */
		//确定压缩的位置
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//压缩  gzip
		GZIPOutputStream gzip = new GZIPOutputStream(baos);  //压缩的位置
		//压缩数据
		gzip.write(bytes);
		gzip.close();
		
		/**
		 * 获取，GZIPOutputStream压缩后的，输出流数据
		 */
		//获得压缩后的字节数组
		byte[] endData = baos.toByteArray();
		
		//将压缩的数据发送给浏览器  -- 
		response.getOutputStream().write(endData);
		
		return response;
	}

}
