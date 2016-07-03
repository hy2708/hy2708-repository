package org.hy.commons.log.slf4j.logback;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.AccessController;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

import sun.security.action.GetPropertyAction;

public class MyFormatter extends SimpleFormatter {
	
	Date dat = new Date();
	  private static final String format = "{0,date} {0,time}";
	  private MessageFormat formatter;
	  private Object[] args = new Object[1];
	  private String lineSeparator = (String)AccessController.doPrivileged(new GetPropertyAction("line.separator"));

	@Override
	public synchronized String format(LogRecord paramLogRecord) {
		StringBuffer localStringBuffer1 = new StringBuffer();
	    this.dat.setTime(paramLogRecord.getMillis());
	    this.args[0] = this.dat;
	    StringBuffer localStringBuffer2 = new StringBuffer();
	    if (this.formatter == null)
	      this.formatter = new MessageFormat("{0,date} {0,time}");
	    this.formatter.format(this.args, localStringBuffer2, null);
	    localStringBuffer1.append(localStringBuffer2);//时间，如：2011-9-4 11:02:53
	    localStringBuffer1.append(" ");
	    if (paramLogRecord.getLoggerName()!= null){
	    	localStringBuffer1.append("[");
	    	if ("".equals(paramLogRecord.getLoggerName())) {			
	    		localStringBuffer1.append("rootLogger");
			} else {
				localStringBuffer1.append(paramLogRecord.getLoggerName());
			}
	    	System.err.println("loggerName :"+paramLogRecord.getLoggerName());	    	
	    	localStringBuffer1.append("]");
	    	
	    }
	    else{
	    	localStringBuffer1.append("[");
	    	localStringBuffer1.append(paramLogRecord.getSourceClassName());
//	    	System.err.println("className :"+paramLogRecord.getSourceClassName());
//	    	System.err.println("loggerName :"+paramLogRecord.getLoggerName());
	    	localStringBuffer1.append("]");

	    	if (paramLogRecord.getSourceMethodName() != null)
	    	{
	    		localStringBuffer1.append(" ");
	    		localStringBuffer1.append(paramLogRecord.getSourceMethodName());
	    	}
	    }
	    localStringBuffer1.append(this.lineSeparator);
	    String str = formatMessage(paramLogRecord);
	    localStringBuffer1.append(paramLogRecord.getLevel().getLocalizedName());//Level如：信息、警告，错误
	    localStringBuffer1.append(": ");
	    localStringBuffer1.append(str);//格式化之后的message
	    localStringBuffer1.append(this.lineSeparator);
	    if (paramLogRecord.getThrown() != null)
	      try
	      {
	        StringWriter localStringWriter = new StringWriter();
	        PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
	        paramLogRecord.getThrown().printStackTrace(localPrintWriter);
	        localPrintWriter.close();
	        localStringBuffer1.append(localStringWriter.toString());
	      }
	      catch (Exception localException)
	      {
	      }
	    return localStringBuffer1.toString();
	  }
	

	public MyFormatter() {
		super();
		// TODO Auto-generated constructor stub
	}

}
