package org.hy.commons.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream; //import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ChangeFile {
	public static void main(String[] argv) {
		try {
			BufferedReader bufReader = 
				new BufferedReader(
					new InputStreamReader(
						new FileInputStream(
							new File("D:/1.txt"))));

			StringBuffer strBuf = new StringBuffer();
			for (String tmp = null; (tmp = bufReader.readLine()) != null; tmp = null) {
				// 在这里做替换操作
				tmp = tmp.replaceAll("\\*", "#");
				tmp = tmp.replaceFirst("a", "A");
				
				strBuf.append(tmp);
				strBuf.append(System.getProperty("line.separator"));
			}
			bufReader.close();

			PrintWriter printWriter = new PrintWriter("D:/1.txt");
			printWriter.write(strBuf.toString().toCharArray());
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}