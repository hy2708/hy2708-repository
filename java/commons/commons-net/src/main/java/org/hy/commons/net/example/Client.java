package org.hy.commons.net.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("127.0.0.1", 8888);
		BufferedReader br = 
			new BufferedReader(
				new  InputStreamReader(
					s.getInputStream()));
		String str  = br.readLine();
		System.out.println("server:" + str);
		s.close();
		br.close();
	}
}
