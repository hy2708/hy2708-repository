package org.hy.commons.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SocketReceiver implements Runnable{

	Integer port =null;
	public SocketReceiver() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public SocketReceiver(Integer port) {
		super();
		this.port = port;
	}


	public void name2() throws Exception {
		DatagramSocket socket = new DatagramSocket(port);
		byte[] b= new byte[1024];
		while (true) {
			DatagramPacket p = new DatagramPacket(b	, b.length);
			socket.receive(p);
			//System.err.println(p.getAddress().getHostAddress());
			//System.err.println("receive "+p.getPort());
			if (new String(p.getData()).endsWith(";;;")) {
				break;
			}
			System.err.println(p.getAddress().getHostAddress()+":"+p.getPort()+" "+
					new String(p.getData()));
		}
		socket.close();
	}

	@Override
	public void run() {
		try {
			name2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
