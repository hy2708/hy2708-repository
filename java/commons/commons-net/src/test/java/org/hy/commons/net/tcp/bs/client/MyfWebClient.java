package org.hy.commons.net.tcp.bs.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class MyfWebClient {

	public static void main(String[] args) throws Exception {
		//new Thread(new WebServer()).start();
		//Thread.currentThread().sleep(1000);
		Socket socket = new Socket("127.0.0.1",18888);
		/*
		 * 发
		 */
		OutputStream out = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(out);

		String message = "我是浏览器，这是我发送的消息";
		//out.write(message.getBytes());
		//out.flush();
		writer.println(message);
		//writer.write(s)
		writer.flush();
		System.err.println("消息已经发送");
		//socket.getOutputStream().close();
		
		/*
		 * 收
		 */
		InputStream in = socket.getInputStream();
		BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));

		byte[] b = new byte[1024];
		System.err.println("浏览器收到的信息");
		System.err.println(new String(b));
		//socket.getInputStream().read(b);
		StringBuffer sb = new StringBuffer();
		int l = 0;
				l = in.available();
		System.err.println("000333"+l);
		int length = 0;
		/*
		 
		while ((length = in.read(b)) != -1) {
			//bout.write(b, 0, length);
			sb.append(new String(b,0,length));
		}
		// */


		System.err.println("Server:"+is.readLine());
		System.err.println("消息已经收到");


//从Server读入一字符串，并打印到标准输出上
		socket.close();
		
		//Socket socket2 = new Socket("127.0.0.1",18888);

	}
	
	
}
