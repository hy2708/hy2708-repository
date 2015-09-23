package org.hy.commons.net.tcp.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler implements Runnable{

	public void handle() throws Exception {
		ServerSocket serverSocket = new ServerSocket(9888);
		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream()  ;
		byte[] b = new byte[1024];
		in.read(b);
		System.err.println(new String(b));
		socket.getOutputStream().write("nnnnnnnnnn".getBytes());
		socket.close();
		serverSocket.close();
	}

	@Override
	public void run() {
		try {
			handle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
