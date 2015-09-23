package org.hy.commons.net.example;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("等到客户端连接");
		Socket s = ss.accept();//等待客户端连接，得到连接的客户端
		System.out.println("客户端IP= "+s.getLocalAddress());
		String msg = "亲，你好，cditcast";
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.print(msg);//从服务端把数据打印出去
		
		s.close();
		ss.close();
	}
}
