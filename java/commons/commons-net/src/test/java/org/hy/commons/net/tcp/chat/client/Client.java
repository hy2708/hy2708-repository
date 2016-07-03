package org.hy.commons.net.tcp.chat.client;

import java.net.*;
import java.io.*;

public class Client {
	static Socket client;

	public static void main(String[] args) throws Exception {
		client = new Socket(InetAddress.getLocalHost(), 7788);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		BufferedReader selfReader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("我是客户端，我收到的信息是：");

		while (true) {
			/*
			 * 获取自己输入的的信息
			 * 并发送给Server
			 */
			//读取信息
			String selfStr = selfReader.readLine();
			//发送信息
			out.println("Client说 ："+selfStr);
			out.flush();
			
			if (selfStr.equals("end")) {
				break;
			}
			/*
			 * 接受，并显示，从Server发来的信息
			 */
			System.out.println(reader.readLine());
		}
		client.close();
	}
}