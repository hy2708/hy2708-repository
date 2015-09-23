package org.hy.commons.net.tcp.bs.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



public class WebServer implements Runnable{

	public static void main(String[] args) throws IOException {
		new WebServer().startServer();
	}
	
	
	public void startServer() throws IOException {
		// 创建，并启动指定端口的服务器
		ServerSocket server = new ServerSocket(18888);
		while (true) {
			Socket fromClient = server.accept();
			new Thread(new ServiceHandler( fromClient)).start();
		}
	}

	map
	@Override
	public void run() {
		try {
			startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
