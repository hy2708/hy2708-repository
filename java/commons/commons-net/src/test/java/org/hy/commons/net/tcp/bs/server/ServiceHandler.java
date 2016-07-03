package org.hy.commons.net.tcp.bs.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceHandler implements Runnable{

	public ServiceHandler(Socket client) {
		super();
		this.fromClient = client;
	}

	Socket fromClient = null;
	
	public void doService() throws IOException {
		/*
		 * 发发出信息的那个socket相对应，但是不是那个socket
		 */
		//Socket client = server.accept();
		InetAddress address = fromClient.getInetAddress();
		byte[] b = new byte[1024];
		/*
		 * 收
		 */
		InputStream in = fromClient.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		//System.err.println("我是服务器："+in.available());
		int length = -1;
		//ByteArrayOutputStream bout = new ByteArrayOutputStream();
		StringBuffer sb = new StringBuffer();
		/*while ((length = in.read(b)) != -1) {
			//bout.write(b, 0, length);
			sb.append(new String(b,0,length));
		}*/
		System.err.println("444444444444444");
		System.err.println(reader.readLine());
		System.err.println("消息已经收到");

		
		//PrintWriter writer = new PrintWriter(bout, true);
		System.err.println(address.getHostAddress() + "aaaaaaaaaaaa");
		//writer.println(address.getHostAddress() + "i have received your messages");
		//bout.close();
		System.err.println(sb.toString());
		OutputStream out = fromClient.getOutputStream();
		out.write("99我是浏览器，这是我发送的消息".getBytes());
		out.flush();
		System.err.println("消息已经发送");

		fromClient.close();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			doService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
