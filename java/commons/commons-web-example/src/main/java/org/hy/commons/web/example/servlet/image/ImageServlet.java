package org.hy.commons.web.example.servlet.image;

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

public class ImageServlet extends HttpServlet {
	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP,ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(ImageServlet.class, JettyUtil.HELLO);
//		JettyUtil.getServletContextHandler().addServlet(GZipHttpServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();

		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		
		Thread.sleep(1000);
		//JettyUtil.stopServer();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String webRoot = getServletContext().getResource("/").toString();
		System.err.println("88888"+webRoot);
		String path = getClass().getClassLoader().getResource("1.jpg").toString();
		System.err.println("999"+path);
		resp.setContentType(MimeTypes.getMimeType("jpg"));
		InputStream in = getServletContext().getResourceAsStream("/1.jpg");
		byte[] b=new byte[1024]; 
		int length = 0;
		OutputStream outputStream = resp.getOutputStream();
		while ((length = in.read(b))>0) {
			outputStream.write(b, 0, length);
		}
		outputStream.flush();
		outputStream.close();
	}

}
