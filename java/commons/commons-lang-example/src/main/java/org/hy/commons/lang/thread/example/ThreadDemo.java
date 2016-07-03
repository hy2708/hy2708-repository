package org.hy.commons.lang.thread.example;

class XX extends  Thread{
	public void run() {
		/**
		 *run方法里的异常,统统处理,不抛
		 */
		for (int i = 0; i < 100; i++) {
			System.out.println("-->" + i);
		}
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		
		XX x = new XX();
		x.start();
		x.start();
		x.start();
	}
}