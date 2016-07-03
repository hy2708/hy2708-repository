package org.hy.commons.net.tcp.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class MyChatServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7788);
		Socket fromClient = null;
		List<Socket> list= new LinkedList<Socket>();
		MessageList messageList= new MessageList();
		//Map<Socket> map= new HashMap<Socket>();
		System.out.println(Thread.currentThread().getName()+"  ");

		System.out.println("服务器启动，正在监听....");
		while (true) {
			
			fromClient = server.accept();
			list.add(fromClient);
			System.out.println("socket size shi"+list.size());

			new Thread(new ClientHandler(fromClient,list,messageList)).start();
			
		}
	}
}