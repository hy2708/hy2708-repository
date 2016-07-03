package org.hy.commons.web.example.listener.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletContextHandler implements ServletContextListener{

	Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		logger.info("ServletContext【{}】 被初始化了",sc);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		logger.info("ServletContext【{}】 被销毁了",sc);
		
		
	}

}
