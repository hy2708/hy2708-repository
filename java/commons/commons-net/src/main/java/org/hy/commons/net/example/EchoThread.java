package org.hy.commons.net.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread implements Runnable{
	private Socket client = null ;
	public EchoThread(Socket client){
		this.client = client ;
	}
	public void run(){
		BufferedReader buf = null ;	
		PrintStream out = null ;		
		try{
			out = new PrintStream(client.getOutputStream()) ;
			buf = new BufferedReader(
				new InputStreamReader(client.getInputStream())) ;
			while(true){
				String str= buf.readLine() ;	
				if(str==null||"".equals(str)){						break ;	
				}else{
					if("bye".equals(str)){							break ;
					}else{
						out.println("ECHO : " + str) ;
					}
				}
			}
			client.close() ;
		}catch(Exception e){}
	}
}

