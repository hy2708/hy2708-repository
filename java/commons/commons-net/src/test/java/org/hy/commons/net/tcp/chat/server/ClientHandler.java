package org.hy.commons.net.tcp.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ClientHandler implements Runnable{

	Socket fromClient = null;
	List<Socket> list= null;
	MessageList messageList= null;
	
	public ClientHandler(Socket fromClient, List<Socket> list, MessageList messageList) {
		super();
		this.fromClient = fromClient;
		this.list=list;
		this.messageList=messageList;
		messageList.setSocketList(list);
	}

	private void handleClient() throws IOException {
				//BufferedReader selfReader = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter out = new PrintWriter(fromClient.getOutputStream());
		
		System.out.println("收到客户端连接："+fromClient);
		//System.out.println("我是服务器，我收到的信息是：");
		while (true) {
			
			readFromClient();
			//writeToClient();
						/*
			 * 获取自己输入的的信息
			 * 并发送给Client
			 */
			//String mystr = selfReader.readLine();
			//out.println("MyServer说 ："+mystr);
			//out.flush();
			//if (str.equals("end"))
			//	break;
		}
		//fromClient.close();

	}

	private void writeToClient() {
		// TODO Auto-generated method stub
		
	}

	private void readFromClient() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				fromClient.getInputStream()));

		/*
		 * 接受，并显示，从Client发来的信息
		 */
		String str = reader.readLine();
		/*
		 * 阻塞在这里？
		 * 把读和写，分成两个线程
		 */
		messageList.add(new ChatMessage(fromClient.toString(),null,str));
		System.out.println(fromClient.toString()+"说："+str);
		
		/*InputStream in = client.getInputStream();
		byte[] buf = new byte[1024];

		in.read(buf);
		System.out.println(buf.toString());
		System.out.println(buf[0]+buf[0]);
		 */			

		
	}

	@Override
	public void run() {
		try {
			handleClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
