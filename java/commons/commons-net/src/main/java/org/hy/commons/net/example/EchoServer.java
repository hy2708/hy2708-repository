package org.hy.commons.net.example;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String args[]) throws Exception {
		ServerSocket server = null;
		Socket client = null;
		server = new ServerSocket(8888);
		boolean isReceive = true;
		while (isReceive) {
			System.out.println("等待客户端连接。");
			client = server.accept();
			new Thread(new EchoThread(client)).start(); // 每一个客户端表示一个线程
		}
		server.close();
	}

}
