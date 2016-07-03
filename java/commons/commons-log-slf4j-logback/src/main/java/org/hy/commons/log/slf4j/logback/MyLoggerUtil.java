package org.hy.commons.log.slf4j.logback;


import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2013-3-8；时间：下午3:21:19</li>
 * <li>类型名称：MyLoggerUtil</li>
 * <li>设计目的：</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class MyLoggerUtil {

	private static void printDebug(String className,String message,Throwable throwable) {
		StackTraceElement[] stackTraceElements= throwable.getStackTrace();
		/*System.out.println("size :"+stackTraceElements.length);
		for (int s = 0; s < stackTraceElements.length; s++) {
		      System.out.println(s + " " + stackTraceElements[s].getClassName()
		          + stackTraceElements[s].getClassName() + stackTraceElements[s].getLineNumber());
		    }
		 System.err.println(str);*/
		String str = "" + "(" + stackTraceElements[1].getFileName()+":" + stackTraceElements[1].getLineNumber()+")";
		Logger logger = Logger.getLogger(className);		  
		// logger.log(Level.SEVERE,message+" " +str );
		 String formatMessage = message +" " +str;
		 printMessage(className, formatMessage, Level.FINE);
		
	}
	
	private static void printInfo(String className,String message,Throwable throwable) {
		StackTraceElement[] stackTraceElements= throwable.getStackTrace();
		/*System.out.println("size :"+stackTraceElements.length);
		for (int s = 0; s < stackTraceElements.length; s++) {
		      System.out.println(s + " " + stackTraceElements[s].getClassName()
		          + stackTraceElements[s].getClassName() + stackTraceElements[s].getLineNumber());
		    }
		 System.err.println(str);*/
		String str = "" + "(" + stackTraceElements[1].getFileName()+":" + stackTraceElements[1].getLineNumber()+")";
		Logger logger = Logger.getLogger(className);		  
		// logger.log(Level.SEVERE,message+" " +str );
		 String formatMessage = message +" " +str;
		 printMessage(className, formatMessage, Level.FINE);
		
	}
	public static void printDebug(String className,String message) {
		
		printMessage(className, formatMessage(message), Level.SEVERE);
	}
	
	private static void printMessage(String className,String message,Level level) {
		
		Logger logger = Logger.getLogger(className);	  
		 logger.log(level,message );
		
	}
	
	private static String formatMessage(String message) {
		Throwable throwable = new Throwable();
		StackTraceElement[] stackTraceElements= throwable.getStackTrace();
		/*System.out.println("size :"+stackTraceElements.length);
		for (int s = 0; s < stackTraceElements.length; s++) {
		      System.out.println(s + " " + stackTraceElements[s].getClassName()
		          + stackTraceElements[s].getClassName() + stackTraceElements[s].getLineNumber());
		    }
		 System.err.println(str);*/
		String str = "" + "(" + stackTraceElements[2].getFileName()+":" + stackTraceElements[2].getLineNumber()+")";
		return message +" " +str;
		
	}

}
