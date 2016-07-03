package org.hy.commons.net.tcp.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.hy.commons.net.tcp.server.WebServer;

public class WebClient {

	public static void main(String[] args) throws Exception {
		new Thread(new WebServer()).start();
		Thread.currentThread().sleep(1000);
		Socket socket = new Socket("127.0.0.1",18888);
		socket.getOutputStream().write("我是浏览器，这是我发送的消息".getBytes());
		socket.getOutputStream().flush();
		//socket.getOutputStream().close();
		byte[] b = new byte[1024];
		System.err.println("浏览器收到的信息");
		System.err.println(new String(b));
		//socket.getInputStream().read(b);
		StringBuffer sb = new StringBuffer();
		int l = 0;
				InputStream in = socket.getInputStream();
				l = in.available();
		System.err.println("000333"+l);
		int length = 0;
		/*
		 
		while ((length = in.read(b)) != -1) {
			//bout.write(b, 0, length);
			sb.append(new String(b,0,length));
		}
		 */
		socket.close();
	}
	
	
}
