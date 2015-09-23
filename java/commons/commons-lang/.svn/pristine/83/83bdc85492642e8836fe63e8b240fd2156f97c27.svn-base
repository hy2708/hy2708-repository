package org.hy.commons.lang.character.example;

import java.io.IOException;
import java.security.MessageDigest;

import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Demo {
	//对用户名和密码进行base64编码
	@Test
	public void base64() throws IOException{
		String name = "one";
		String pwd = "1234";
		BASE64Encoder en = new BASE64Encoder();
		name = en.encode(name.getBytes());
		pwd = en.encode(pwd.getBytes());
		System.err.println(name);
		System.err.println(pwd);
		BASE64Decoder decoder = new BASE64Decoder();
		System.err.println(new String(decoder.decodeBuffer(name)));
	}
	
	
	
	public static void main(String[] args) throws Exception {
		String pwd="1234";
		//通过一个类;
		MessageDigest md = MessageDigest.getInstance("MD5");
		//通过digest方法对原数据进行MD5算法
		//返回一个新的字节
		byte[] b = md.digest(pwd.getBytes());
		//通过base64对字节数组进行编码
		BASE64Encoder en = new BASE64Encoder();
		String ss = en.encode(b);
		System.err.println(ss);
	}
}
