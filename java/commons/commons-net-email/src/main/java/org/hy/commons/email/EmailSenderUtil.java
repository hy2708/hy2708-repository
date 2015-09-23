package org.hy.commons.email;

import java.util.Date;
import java.util.LinkedList;

import jodd.mail.Email;
import jodd.mail.EmailMessage;
import jodd.mail.Pop3Server;
import jodd.mail.ReceivedEmail;
import jodd.mail.SendMailSession;
import jodd.mail.SimpleAuthenticator;
import jodd.mail.SmtpSslServer;
import jodd.util.ReflectUtil;

import org.hy.commons.email.jodd.MyImapServer;
import org.hy.commons.email.jodd.MyPop3Server;
import org.hy.commons.email.jodd.MyReceiveMailSession;
import org.hy.commons.lang.DateUtil;
import org.hy.commons.lang.ReflectionUtil;
import org.hy.commons.lang.RuntimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.mail.handlers.message_rfc822;

/**
 * Hello world!
 *EmailSenderUtil单例
 *SendMailSession单例
 *
 */
//http://blog.csdn.net/chjttony/article/details/6005594
//http://xiangzhengyan.iteye.com/blog/85961
//http://haolloyin.blog.51cto.com/1177454/355075
//http://blog.163.com/shexinyang@126/blog/static/1367393122012111994144665/
//http://blog.csdn.net/generalyy0/article/details/7577072
public class EmailSenderUtil 
{
	
    private EmailSenderUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
    private static EmailSenderUtil emailSenderUtil=null;
    private static Logger logger= LoggerFactory.getLogger(EmailSenderUtil.class);
    SendMailSession mailSession=null;
    String fromUser=null;
    
    public static EmailSenderUtil getInstance() {
    	if (emailSenderUtil==null) {			
    		emailSenderUtil = new EmailSenderUtil();
		}

    	return emailSenderUtil;
	}
    public void clearSendMailSession() {
    	mailSession=null;
    }
    private SendMailSession getSendMailSession() {
    	return mailSession;
    }
    public void createSendMailSession(String stmpServerHost,String username,String password) {
    	logger.debug("创建与STMP服务器的会话【stmpServerHost=" +
    			stmpServerHost+",username=" +
    					username+",password=" +
    							password+"】");
    	mailSession = new SmtpSslServer("smtp.gmail.com",username, password).createSession();
    }
    public void sendMails(Email... emails) {
    	// SendMailSession mailSession = smtpServer.createSession();
	    mailSession.open();
	    for (int i = 0; i < emails.length; i++) {
	    	logger.debug("发送Email【fromUser=" +
	    			emails[i].getFrom()+",toUser=" +
	    			emails[i].getTo()[0]+",subject=" +
	    			emails[i].getSubject()+"】");
	    	mailSession.sendMail(emails[i]);
		}
	    //session.sendMail(email2);
	    logger.debug("Email发送完毕，并关闭mailSession会话");
	    mailSession.close();
	    
    }
    
    public Email createMail(String fromUser,String toUser,String subject,String content) {
    	return createMail(fromUser, toUser, new Date(), subject, content);
    }
   	public Email createMail(String fromUser,String toUser,Date date,String subject,String content) {
    	Email email = Email.create()
		         .from(fromUser)
		         .to(toUser)
		         .subject(subject)
		         .addText(content)
		         
		         ;
    	email.setSentDate(date);
    	return email;
		       //  .addHtml(
		        //     "<html><META http-equiv=Content-Type content=\"text/html; charset=utf-8\">"+
		       //      "<body><h1>Hey!</h1><img src='cid:c.png'><h2>Hay!</h2></body></html>")
		         //.embed(attachment().bytes(new File("/c.png")))
		       // .attach(attachment().file("/b.jpg"))
    			//;
    }

   	
	
    
    public static void main( String[] args )
    {
    	
    	Email email = Email.create()
    			         .from("hy2708@gmail.com")
    			         .to("hy5178@gmail.com")
    			         .subject("Hy Remote Control"+DateUtil.getDisplayDateTime())
    			         .addText("commandType=java")
    			         .addText("className=org.hy.commons.io.FileUtil" +"\n"+
    			         "methodName=createFile"+"\n"+
    					 "params=f:/fffff.txt"+"\n");
    			       //  .addHtml(
    			        //     "<html><META http-equiv=Content-Type content=\"text/html; charset=utf-8\">"+
    			       //      "<body><h1>Hey!</h1><img src='cid:c.png'><h2>Hay!</h2></body></html>")
    			         //.embed(attachment().bytes(new File("/c.png")))
    			       // .attach(attachment().file("/b.jpg"))
    			        ;
    	
    //	SmtpServer smtpServer =
    	//		        new SmtpServer("smtp.gmail.com", new SimpleAuthenticator("hy2708@gmail.com", "hhy8611hhy./"));
    			   // ...
		SendMailSession mailSession = new SmtpSslServer("smtp.gmail.com","hy2708@gmail.com", "hhy8611hhy./").createSession();

    			   // SendMailSession mailSession = smtpServer.createSession();
    			    mailSession.open();
    			    mailSession.sendMail(email);
    			    //session.sendMail(email2);
    			    mailSession.close();
    }
    
    
    
    
}
