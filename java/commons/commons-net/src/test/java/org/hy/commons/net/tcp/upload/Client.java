package org.hy.commons.net.tcp.upload;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable{

	public void name() throws Exception {
		System.err.println("ccccccccccccccc");
		Socket socket = new Socket("127.0.0.1",18888);
		OutputStream out = socket.getOutputStream();
		InputStream fin= getClass().getClassLoader().getResourceAsStream("2.jpg");
		byte[] b=new byte[1024];
		int length = 0;
		int offset = 0;
		while ((length = fin.read(b))>0) {
			//System.err.println(offset+" "+length);
			out.write(b, 0, length);
			//offset=offset+length;
		}
		fin.close();
		socket.shutdownOutput();
		System.err.println("client out close");
		socket.close();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			name();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
