package com.hy.designpatern.threadsafety;

public class Thread2 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread2:"+SafetyThread.getinstance());
	}

}
