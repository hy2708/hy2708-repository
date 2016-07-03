package org.hy.commons.log.slf4j.logback;


import java.util.logging.Level;
import java.util.logging.Logger;



public class GwtLogHelper {

	
	
	public static String printEventResponseByDebug(String className,String eventName) {
        

		return className+"类:响应 "+eventName+" 事件";

	}
	
	public static String printEventResponseByDebug(Class className,String eventName) {
        
	return className+"类:响应 "+eventName+" 事件";


	}

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
	
		  
		 logger.log(Level.SEVERE,message+" " +str );
		
	}
	
	public static void printDebug(String className,String message) {
		 printDebug(className,message, new Throwable());
	}

}
