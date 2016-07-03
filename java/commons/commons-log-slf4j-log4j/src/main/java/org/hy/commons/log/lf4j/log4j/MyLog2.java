package org.hy.commons.log.lf4j.log4j;
import java.util.logging.Level;

import org.apache.log4j.Logger;


public class MyLog2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 Logger logger = Logger.getLogger(MyLog.class);
		 Logger logger = Logger.getLogger("arsresr");
		
logger.error("dfadsf");
		logger.debug("jjj");
		
		  java.util.logging.Logger logger2 = java.util.logging.Logger.getLogger(MyLog2.class.toString());

  	  logger2.log(Level.SEVERE, "触发 AppEvents.DESKTOP_UER_LOGIN_VALIDATE 事件");


	}

}
