package com.hy.designpatern.threadsafety;

public class SafetyThread {
	
	private static SafetyThread instance =null;

	private SafetyThread() {
		// TODO Auto-generated constructor stub
	}
	public static SafetyThread getinstance() {

	       if (instance == null) {
	    	   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance = new SafetyThread();

	       }

	       return instance;

	    }
	
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		
		thread1.start();
		thread2.start();
		
	}

}
