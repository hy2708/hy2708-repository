package org.hy.commons.email;

import java.util.LinkedList;

import javax.mail.MessagingException;

import jodd.mail.EmailMessage;
import jodd.mail.Pop3Server;
import jodd.mail.ReceivedEmail;
import jodd.mail.SimpleAuthenticator;

import org.hy.commons.email.jodd.MyImapServer;
import org.hy.commons.email.jodd.MyPop3Server;
import org.hy.commons.email.jodd.MyReceiveMailSession;
import org.hy.commons.lang.RuntimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailReceiverUtil {
	static Logger logger = LoggerFactory.getLogger(EmailReceiverUtil.class);
	 //@Test
	  public void name() throws Exception {
	    	Pop3Server popServer = new MyPop3Server("pop.qq.com",
	    			             new SimpleAuthenticator("1254576352@qq.com", "abcdef."));
	   // 	Pop3Server popServer = new MyPop3Server("pop.ymail.com",
	   // 			             new SimpleAuthenticator("hy2708@ymail.com", "hhy8611hhyy"));
	 //   	Pop3Server popServer = new MyPop3SslServer(
	    //			"pop.gmail.com", "hy2708@gmail.com", "hhy8611hhy./");
//	    	"pop3.qq.com","532331851@qq.com", "hhy8611hhy.");
	  //  	"pop3.qq.com","1254576352@qq.com", "abcdef.");
	    	//"pop3.163.com","hy2708@163.com", "hhy8611hhyy");
	    //	"pop3.ymail.com","hy2708@ymail.com", "hhy8611hhyy");
	    	//		             new SimpleAuthenticator("532331851@qq.com", "hhy8611hhy."));
	    			     MyReceiveMailSession session = (MyReceiveMailSession)popServer.createSession();
	    			     session.open();
	    			     System.out.println("0000");
	    			     System.err.println("邮件个数："+session.getMessageCount());
	    			     System.err.println("文件夹个数："+session.getFolders()[0].getFolder("INBOX").toString());
	    			     System.err.println(session.getNewMessageCount());
	    			     //System.err.println(session..receiveEmail(false)[0]);
	 //   			     ReceivedEmail[] emails = session.receiveEmail2(false);
	 //  			     ReceivedEmail[] emails = session.receiveEmails(false, 200, 250);

	    			     ReceivedEmail[] emails = new ReceivedEmail[1]; emails[0]=session.receiveEmail(false, 257);
	 //  			     ReceivedEmail[] emails = new ReceivedEmail[1]; emails[0]=session.receiveLastedEmail(false);
	    			     if (emails != null) {
	 			            System.out.println("cccccccccccc"+ emails.length);

	    			         for (ReceivedEmail email : emails) {
	    			           //  System.out.println("\n\n===[" + email.getMessageNumber() + "]===");
	    			
	    			            // common info
	    			            System.err.println( email.getFlags());
	    			            System.err.println("------"+ email.getMessageNumber());
	    			            System.out.println("FROM:" + email.getFrom());
	    			            System.out.println("TO:" + email.getTo()[0]);
	    			            System.out.println("SUBJECT:" + email.getSubject());
	    			            System.out.println("PRIORITY:" + email.getPriority());
	    			            System.out.println("SENT DATE:" + email.getSentDate());
	    			            System.out.println("RECEIVED DATE: " + email.getReceiveDate());
	    			
	    			            // process messages
	    			            /*LinkedList<EmailMessage> messages = email.getAllMessages();
	    			            for (EmailMessage msg : messages) {
	    			                System.out.println("------");
	    			                System.out.println(msg.getEncoding());
	    			                System.out.println(msg.getMimeType());
	    			                System.out.println(msg.getContent());
	    			            }*/
	    			
	    			            // process attachments
	    			            /*List<EmailAttachment> attachments = email.getAttachments();
	    			            if (attachments != null) {
	    			                System.out.println("+++++");
	    			                for (EmailAttachment attachment : attachments) {
	    			                    System.out.println("name: " + attachment.getName());
	    			                    System.out.println("cid: " + attachment.getContentId());
	    			                    System.out.println("size: " + attachment.getSize());
	    			                    attachment.writeToFile(new File("d:\\", attachment.getName()));
	    			                }
	    			            }*/
	    			        }
	    			    }
	    			    session.close();
		}
	    

	public static void main(String[] args) throws MessagingException {
    	MyImapServer popServer = new MyImapServer();
   // 	Pop3Server popServer = new MyPop3Server("pop.ymail.com",
   // 			             new SimpleAuthenticator("hy2708@ymail.com", "hhy8611hhyy"));
 //   	Pop3Server popServer = new MyPop3SslServer(
    //			"pop.gmail.com", "hy2708@gmail.com", "hhy8611hhy./");
//    	"pop3.qq.com","532331851@qq.com", "hhy8611hhy.");
  //  	"pop3.qq.com","1254576352@qq.com", "abcdef.");
    	//"pop3.163.com","hy2708@163.com", "hhy8611hhyy");
    //	"pop3.ymail.com","hy2708@ymail.com", "hhy8611hhyy");
    	//		             new SimpleAuthenticator("532331851@qq.com", "hhy8611hhy."));
    			     MyReceiveMailSession session = (MyReceiveMailSession)popServer.createSession();
    			     session.open("imap.googlemail.com","hy5178@gmail.com", "hhy8611hhyy");
    			     System.out.println("0000");
    			     System.err.println("邮件个数："+session.getMessageCount());
    			     System.err.println("文件夹个数："+session.getFolders()[0].getFolder("INBOX").toString());
    			     System.err.println(session.getNewMessageCount());
    			     //System.err.println(session..receiveEmail(false)[0]);
 //   			     ReceivedEmail[] emails = session.receiveEmail2(false);
 //  			     ReceivedEmail[] emails = session.receiveEmails(false, 200, 250);

 //   			     ReceivedEmail[] emails = new ReceivedEmail[1]; emails[0]=session.receiveEmail(false, 151);
   			     ReceivedEmail[] emails = new ReceivedEmail[1]; emails[0]=session.receiveLastedEmail(false);
    			     if (emails != null) {
 			            System.out.println("cccccccccccc"+ emails.length);

    			         for (ReceivedEmail email : emails) {
    			           //  System.out.println("\n\n===[" + email.getMessageNumber() + "]===");
    			
    			            // common info
    			            System.err.println( email.getFlags());
    			            System.err.println("------"+ email.getMessageNumber());
    			            System.out.println("FROM:" + email.getFrom());
    			            System.out.println("TO:" + email.getTo()[0]);
    			            System.out.println("SUBJECT:" + email.getSubject());
    			            System.out.println("PRIORITY:" + email.getPriority());
    			            System.out.println("SENT DATE:" + email.getSentDate());
    			            System.out.println("RECEIVED DATE: " + email.getReceiveDate());
    			
    			            // process messages
    			            LinkedList<EmailMessage> messages = email.getAllMessages();
    			            String command = null;
    			            for (EmailMessage msg : messages) {
    			                System.out.println("------");
    			                System.out.println(msg.getEncoding());
    			                System.out.println(msg.getMimeType());
    			                System.out.println(msg.getContent());
    			                command = msg.getContent();;
    			            }
    			
    			            // process attachments
    			            /*List<EmailAttachment> attachments = email.getAttachments();
    			            if (attachments != null) {
    			                System.out.println("+++++");
    			                for (EmailAttachment attachment : attachments) {
    			                    System.out.println("name: " + attachment.getName());
    			                    System.out.println("cid: " + attachment.getContentId());
    			                    System.out.println("size: " + attachment.getSize());
    			                    attachment.writeToFile(new File("d:\\", attachment.getName()));
    			                }
    			            }*/
    			        }
    			    }
    			    session.close();
    			    
    			    RuntimeUtil.executeCmd("dir");
//    			    String className =null;
//					Object object =Class.forName(className).newInstance();
//					String methodName = null;
//					Object params=null;
//					ReflectionUtil.invoke(object, methodName , params);
    }
}
