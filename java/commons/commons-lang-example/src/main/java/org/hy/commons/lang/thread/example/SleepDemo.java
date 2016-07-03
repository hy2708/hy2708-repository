package org.hy.commons.lang.thread.example;

public class SleepDemo {
	public static void main(String[] args) throws InterruptedException {
		
	/*	Thread.sleep(1000);
		System.out.println("Hello");*/
		
		for (int i = 10; i >= 0; i--) {
			
			Thread.sleep(1000);
			System.out.println(i);
		}
	}
}