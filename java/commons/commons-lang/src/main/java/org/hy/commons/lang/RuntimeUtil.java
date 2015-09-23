package org.hy.commons.lang;

import java.io.File;
import java.io.IOException;

import jodd.io.FileUtil;



public class RuntimeUtil extends jodd.util.RuntimeUtil{

	public static void execute(String command) {
		try {
			FileUtil.writeString(new File("d:/xx.txt"), "aaa");
			RUNTIME.exec("cmd.exe  /c  start  notepad  d:/xx.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void executeCmd(String cmdCommand) {
		try {
			RUNTIME.exec("cmd.exe  /c  start  "+cmdCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Process p = RUNTIME.exec("mspaint.exe");
		Thread.currentThread().sleep(2000);
		p.destroy();
		Thread.currentThread().sleep(2000);
		RUNTIME.exec("mspaint.exe d:\\client1.jpg");
		//execute("");
	}
	
}
