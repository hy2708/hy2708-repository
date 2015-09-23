package org.hy.commons.log.lf4j.log4j;
import org.apache.log4j.Logger;


public class MyLog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.err.println(MyLog.class.getName());
		 Logger logger = Logger.getLogger(MyLog.class);
//		 Logger logger = Logger.getLogger("arsresr");
		System.out.println("(MyLog32.java:11) 2011-09-03 14:31:26,873 [DEBUG] This is a 'DEBUG' test message");
		logger.debug("jjj");
		Throwable throwable = new Throwable();
		logger.info("jjj");
		logger.info("jjj");
		//
		//
		logger.warn("jjj");
		logger.error("dfadsf");
		logger.fatal("jjj");
		utilString("sdf",(new Throwable()));
		utilString("sdf");
		StackTraceElement[] stackTraceElements= throwable.getStackTrace();
		System.out.println("size :"+stackTraceElements.length);
		stackTraceElements[0].getLineNumber();
		//String str = "" + "(" + stackTraceElements[0].getFileName()+":" + stackTraceElements[0].getLineNumber()+")";
		//System.out.println(str);

	}
	
	public static String utilString(String string,Throwable throwable) {
		StackTraceElement[] stackTraceElements= throwable.getStackTrace();
		System.out.println("size :"+stackTraceElements.length);
		stackTraceElements[0].getLineNumber();
		String str = "" + "(" + stackTraceElements[0].getFileName()+":" + stackTraceElements[0].getLineNumber()+")";
		 Logger logger = Logger.getLogger(MyLog.class);
		 logger.warn(str + string);
		
		return string;
	}
	
	public static String utilString(String string) {
		return utilString(string, new Throwable());
	}

}
