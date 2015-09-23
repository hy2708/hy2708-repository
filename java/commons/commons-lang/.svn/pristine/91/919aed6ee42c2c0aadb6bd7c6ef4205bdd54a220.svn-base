package org.hy.commons.lang.thread.example;




class Ticket1 extends Thread{
	
	
	
	int num = 50;
	
	public Ticket1(String name){
		super(name);
	}
	public void run() {
		
		for (int i = 0; i < 200; i++) {
			if(num >0) {
				System.out.println(getName()+"卖出第" +num-- +"张");
			}
		}
	}
}
public class TicketDemo {
	public static void main(String[] args) {
		//3个窗口买
		new Ticket1("A").start();
		new Ticket1("B").start();
		new Ticket1("C").start();
	}
}
