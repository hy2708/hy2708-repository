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

public class SocketSender implements Runnable{

	Integer port=null;
	String targetAddress=null;
	
	public SocketSender() {
		super();
	}
	

	public SocketSender(Integer port,String targetAddress) {
		super();
		this.port = port;
		this.targetAddress=targetAddress;
	}


	@Test
	
	
	public void name() throws Exception {
		DatagramSocket socket = new DatagramSocket(port);
		//String string ="aaaaaaaaaa";
		while (true) {
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader reader= new BufferedReader(ir);
			StringBuilder sb= new StringBuilder();
			//sb.append(string);
			while (true) {
				String string2 =reader.readLine();
				if (string2.endsWith(";;")) {
					
					break;
				}else {
					sb.append(string2+"\n");
				}
			}
			InetAddress receiverInetAddress = InetAddress.getByName(targetAddress);//"127.0.0.255"
			//System.err.println(sb.toString());
			DatagramPacket p = new DatagramPacket(sb.toString().getBytes()	, sb.toString().length(),receiverInetAddress,8887);
			socket.send(p);
			if (new String(p.getData()).endsWith(";;;")) {
				break;
			}
		}
		socket.close();
	}

	@Override
	public void run() {
		try {
			name();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
