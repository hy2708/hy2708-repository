package org.hy.commons.lang.thread.example;
class Yield implements Runnable{
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "--> " + i);
			if (i % 2 == 0) {
				//Thread.yield();// 礼让
			}
		}

	}
	
}

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Yield y = new Yield();
		new Thread(y, "A").start();
		new Thread(y, "C").start();



	}
}
