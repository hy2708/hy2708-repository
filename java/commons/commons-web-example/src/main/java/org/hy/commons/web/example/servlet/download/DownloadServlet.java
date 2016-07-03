package org.hy.commons.web.example.servlet.download;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.MimeTypes;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.servlet.compression.GZipHttpServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;

public class DownloadServlet extends HttpServlet {
	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP,ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(DownloadServlet.class, JettyUtil.HELLO);
//		JettyUtil.getServletContextHandler().addServlet(GZipHttpServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();

		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		
		Thread.sleep(1000);
		//JettyUtil.stopServer();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		//下载
		
				//思考：能不能加下载的文件名称写成中文？
				
				//通知浏览器进行下载
				resp.setHeader("content-disposition", "attachment;filename=1xx.jpg");
				
				//资源 1.jpg
				InputStream is = this.getServletContext().getResourceAsStream("/1.jpg");
				OutputStream out = resp.getOutputStream();
				byte[] buf = new byte[1024];
				int len = -1;
				while( (len = is.read(buf)) > -1 ){
					out.write(buf, 0, len);
				}
				out.close();
				is.close();
	}

}
