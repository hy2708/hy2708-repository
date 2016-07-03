package org.hy.commons.net.tcp.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.RandomUtil;

public class Server3 implements Runnable{
	
	public void name() throws Exception {
		ServerSocket serverSocket = new ServerSocket(18888);
		while (true) {
			Socket socket =serverSocket.accept();
			
			new Thread(new HandleRequest(socket)).start();
		}

		//serverSocket.close();
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
	
	public static void main(String[] args) {
		new Thread(new Server3()).start();
		new Thread(new Client()).start();
		new Thread(new Client()).start();
	}

}
class HandleRequest implements Runnable{

	Socket socket = null;
	
	public HandleRequest(Socket socket) {
		super();
		this.socket = socket;
	}
	public void name() throws Exception {
		System.err.println("ssssssssssss");
		InputStream in = socket.getInputStream();
		byte[] b= new byte[1024];
		int length=0;
		File file = new File(ProjectPathUtil.getProjectResourcesDirPath(), RandomUtil.getRandomCharacter()+"3.jpg");
		FileOutputStream fout = new FileOutputStream(file );
		
		while ((length=in.read(b))>0) {
			fout.write(b, 0, length);
			//offset=offset+length;
		}
		System.err.println("read over");
		fout.close();
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