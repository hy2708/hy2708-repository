package org.hy.commons.email;

import java.io.File;

import jodd.mail.Email;
import jodd.mail.EmailMessage;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpSslServer;
import jodd.util.MimeTypes;

public class EmailTest {
	public static void main(String[] args) {
		Email email = Email.create();
		email.addMessage(new EmailMessage("Hello, I am Vincen",MimeTypes.MIME_TEXT_PLAIN));
		email.addText("这里写的是Test");
		//email.embedFile(new File("E:\\我的文档\\My Pictures\\__唯美素材","psb65.jpg"));
		email.from("hy2708@gmail.com").to("hy2708@gmail.com");
		email.subject("我的主题我做主");
		
    	Email email2 = Email.create()
		         .from("hy2708@gmail.com")
		         .to("hy2708@gmail.com")
		         .subject("test6")
		         .addText("Hello!")
		       //  .addHtml(
		        //     "<html><META http-equiv=Content-Type content=\"text/html; charset=utf-8\">"+
		       //      "<body><h1>Hey!</h1><img src='cid:c.png'><h2>Hay!</h2></body></html>")
		         //.embed(attachment().bytes(new File("/c.png")))
		       // .attach(attachment().file("/b.jpg"))
		        ;
		
		SendMailSession mailSession = new SmtpSslServer("smtp.gmail.com","hy2708@gmail.com", "hhy8611hhy./").createSession();
		mailSession.open();
		mailSession.sendMail(email2);
		mailSession.close();
		System.out.println("发送成功!...");
	}
}
