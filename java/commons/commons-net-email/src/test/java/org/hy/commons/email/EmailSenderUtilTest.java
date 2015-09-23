package org.hy.commons.email;

import static org.junit.Assert.*;

import java.io.IOException;

import jodd.mail.Email;

import org.hy.commons.io.core.FileUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailSenderUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSendMails() throws IOException {
		
    	String fromUser ="hy2708@gmail.com";
    	String toUser ="1290034861@qq.com";
    	String subject ="ab";
    	String content= FileUtil.readString("D:\\Program Files\\Everything\\新建文件夹\\ab.txt","gbk");
    	System.err.println(content.substring(0, 10));
    	String content2 ="啊啊啊啊";
		EmailSenderUtil emailSenderUtil =EmailSenderUtil.getInstance();
		//emailSenderUtil.createSendMailSession(stmpServerHost, username, password);
		emailSenderUtil.createSendMailSession(null, fromUser, "hhy8611hhy./");
		
		Email email100 =emailSenderUtil.createMail(fromUser, toUser, "1000", content.substring(1000,2000));
		Email email200 =emailSenderUtil.createMail(fromUser, toUser, "2000", content.substring(2000,3000));
		Email email500 =emailSenderUtil.createMail(fromUser, toUser, "3000", content.substring(3000,4000));
		Email email1000 =emailSenderUtil.createMail(fromUser, toUser, "4000", content.substring(4000,6000));
		Email[] emails = new Email[4];
		emails[0]=email100;
		emails[1]=email200;
		emails[2]=email500;
		emails[3]=email1000;
		emailSenderUtil.sendMails(emails);
    }

}
