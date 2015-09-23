package org.hy.commons.log.slf4j.log4j.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;

/**
 * Hello world!
 * 
 */
public class App {
	static Log logger = LogFactory.getLog(App.class);
	public static void main(String[] args) {
		logger.warn("slf4j + commons logging");
	}
}
