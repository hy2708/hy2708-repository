package org.hy.commons.lang.thread.example;


class House{
	
}

class Man extends Thread{
	
	House h;
	public Man(House h){
		this.h = h;
	}
	public void run() {
		synchronized (h) {
			System.out.println("给你买房子");
		}
	}
}

public class DeadLockDemo {
	public static void main(String[] args) {
		
		House  h = new House();
		Man m = new Man(h);
		m.start();
		
		synchronized (h) {
			try {
				m.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("嫁给你哦");
		}
	}
}