package org.hy.commons.net.sms.fetion;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

public class Test {
	
	private static String PHONE = "15830580554";
	private static String PWD = "hhy8611hhy.";
	private static String TO = "15732191348";
	private static String MSG = "笨蛋。这是我用程序发给你的。qinqinmomo";
	
	public static void main(String[] args) throws HttpException, IOException {
		String string ="";
		Fetion.sendMsg(PHONE, PWD, TO, MSG);
	}

}
