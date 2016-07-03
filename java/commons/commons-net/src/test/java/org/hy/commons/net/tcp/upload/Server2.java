package org.hy.commons.net.tcp.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.hy.commons.io.core.ProjectPathUtil;

public class Server2 implements Runnable{
	
	public void name() throws Exception {
		ServerSocket serverSocket = new ServerSocket(18888);
		while (true) {
			/*
			 * 
			Socket socket =serverSocket.accept();
			必须放到里面
			如果放到外面，造成死循环
			 */
			Socket socket =serverSocket.accept();
			System.err.println("ssssssssssss");
			InputStream in = socket.getInputStream();
			byte[] b= new byte[1024];
			int length=0;
			int offset=0;
			File file = new File(ProjectPathUtil.getProjectResourcesDirPath(), "3.jpg");
			FileOutputStream fout = new FileOutputStream(file );
			
			while ((length=in.read(b))>0) {
				fout.write(b, 0, length);
				//offset=offset+length;
			}
			System.err.println("read over");
			fout.close();
			socket.close();
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
		new Thread(new Server2()).start();
		new Thread(new Client()).start();
	}

}
