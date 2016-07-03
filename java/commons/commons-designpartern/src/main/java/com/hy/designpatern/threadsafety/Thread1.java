package com.hy.designpatern.threadsafety;

public class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread1:"+SafetyThread.getinstance());
	}

}
