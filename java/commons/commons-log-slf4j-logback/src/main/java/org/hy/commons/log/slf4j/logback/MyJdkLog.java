package org.hy.commons.log.slf4j.logback;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyJdkLog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 Logger logger = Logger.getLogger(MyJdkLog.class.toString());
		 Logger logger = Logger.getLogger("");
		 logger.setLevel(Level.FINE);
		 Logger sublogger = Logger.getLogger("a.b.c");
		 sublogger.setLevel(Level.FINEST);
		 sublogger.log(Level.FINE, "sfsdf");
		//System.out.println("(MyLog32.java:11) 2011-09-03 14:31:26,873 [DEBUG] This is a 'DEBUG' test message");
		Handler[] handlers = logger.getHandlers();
		System.out.println("handlers size :"+handlers.length);

		for (int i = 0; i < handlers.length; i++) {
			System.out.println(handlers[i].getClass());
			System.out.println(handlers[i].getFormatter().getClass());
		}
		handlers[0].setFormatter(new MyFormatter());
		//logger.info("MyJdkLog.............");
		//logger.log(Level.WARNING, "fsodjfoaf....");
		MyLoggerUtil.printDebug("com.logger.test.MyJdkLog", "11111message");
	
		
		//StackTraceElement[] stackTraceElements= throwable.getStackTrace();
		//System.out.println("size :"+stackTraceElements.length);
		//stackTraceElements[0].getLineNumber();
		//String str = "" + "(" + stackTraceElements[0].getFileName()+":" + stackTraceElements[0].getLineNumber()+")";
		//System.out.println(str);

	}
	
	
}
