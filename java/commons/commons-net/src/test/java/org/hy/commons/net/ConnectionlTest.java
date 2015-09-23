package org.hy.commons.net;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConnectionlTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	//public void sdf()
	public  void test01_UrlAndConnection() 
		throws Exception {	
		//http://cd.itcast.cn/class_info/java_jichu.html
		URL url = new URL(
					"http",
					"cd.itcast.cn",
					80,
					"/class_info/java_jichu.html");
		URLConnection uc = url.openConnection();
		System.out.println("内容长度= " 
				+ uc.getContentLength());
		System.out.println("内容类型= "
				+ uc.getContentType());
	}
	
	@Test
	public  void main3() throws Exception {
		//http://cd.itcast.cn/class_info/java_jichu.html
		URL url = new URL(
			"http",
			"cd.itcast.cn",
			80,
			"/class_info/java_jichu.html");
		InputStream is = url.openStream();
		Scanner sc = new Scanner(is);
		sc.useDelimiter("\r\n");
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

	@Test
	public  void test02_InternetAddress() throws Exception{
		InetAddress locAdd = InetAddress.getLocalHost();
		InetAddress remAdd = 	InetAddress.getByName("www.baidu.com");
		
		byte[] ip= {(byte) 211,100,52,39}; 
		InetAddress remAdd2 = InetAddress.getByAddress(ip);
		System.out.println("本机IP= " + locAdd.getHostAddress());
		System.out.println("目标地址IP= " + 		remAdd.getHostAddress());
		System.out.println("是否可以送达：" + 	remAdd2.isReachable(3000));
	}


}
