package org.hy.commons.net.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.http.message.BufferedHeader;
import org.junit.Test;

public class ChatDemo {

	public static void main(String[] args) throws Exception {
	
		//InetAddress inetAddress = InetAddress.getLocalHost();
		//System.err.println(inetAddress.getHostAddress());
		//System.err.println(inetAddress.getHostName());
		new Thread(new SocketReceiver(8887)).start();
		String targetAddress="127.0.0.1";
		//targetAddress=args[0];
		new Thread(new SocketSender(8888,targetAddress)).start();

	}
	
	@Test
	public void name0() throws Exception {
		new Thread(new SocketReceiver(8887)).start();
		new Thread(new SocketSender(8888,"127.0.0.1")).start();
		
		//name();
	}
	
	public void name() throws Exception {
		DatagramSocket socket = new DatagramSocket(8888);
		String string ="aaaaaaaaaa";
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader reader= new BufferedReader(ir);
		StringBuilder sb= new StringBuilder();
		sb.append(string);
		while (true) {
			String string2 =reader.readLine();
			if (string2.equalsIgnoreCase(";;")) {
				
				break;
			}else {
				sb.append(string2+"\n");
			}
		}
		InetAddress receiverInetAddress = InetAddress.getByName("127.0.0.255");
		System.err.println(sb.toString());
		DatagramPacket p = new DatagramPacket(sb.toString().getBytes()	, sb.toString().length(),receiverInetAddress,8887);
		socket.send(p);
		socket.close();
	}
	
	
}
