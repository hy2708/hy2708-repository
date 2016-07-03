package org.hy.commons.web.example.servlet.thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.filter.thread.ThreadFilter;
import org.hy.commons.web.example.servlet.io.IoServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadServlet extends HttpServlet{

	Logger logger = LoggerFactory.getLogger(getClass());
	/*
	 * ThreadLocal 是线程安全的
	 */
	ThreadLocal<Object> tl = new ThreadLocal<Object>();
	static ThreadLocal<Object> tl2 = new ThreadLocal<Object>();
	long f = 0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		logger.info("访问了servlet"+
			Thread.currentThread().getId()
			);
		//tl.set(Thread.currentThread().getId());
		logger.info("threadLocal"+tl.get());
		if (f==0) {
			//f=Thread.currentThread().getId();			
		}
		System.err.println("访问了servlet"+
				Thread.currentThread().getId()
				+"  tl is"
				+tl.get());
		tl.set(Thread.currentThread().getId());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("访问了servlet"+
				Thread.currentThread().getId()
				+"  tl is"
				+tl.get());
		
	}
	@Override
	public void destroy() {
		
		super.destroy();		
		logger.info("在销毁  destroy.......");
		logger.info(Thread.currentThread().getId()+"");
	}

	@Override
	public void init() throws ServletException {
		
		super.init();
		logger.info("在启动  init.......");
		logger.info(Thread.currentThread().getId()+"");
	}

	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP,ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addFilter(ThreadFilter.class, "/*", JettyUtil.getDispatcherTypes());
		JettyUtil.getWebAppContext().addServlet(ThreadServlet.class, JettyUtil.HELLO);
//		JettyUtil.getServletContextHandler().addServlet(GZipHttpServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();

		/*
		 * 内部拥有线程池
		 */
		for (int i = 0; i < 3; i++) {
			
			new Thread(new VistUrl()).start();
		}
		//new Thread(new VistUrl()).start();
		//new Thread(new VistUrl()).start();
		//new Thread(new VistUrl()).start();
		//Thread.sleep(1000);
		//JettyUtil.stopServer();
	}
}

class VistUrl implements Runnable{

	@Override
	public void run() {
		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);

	}
	
}
