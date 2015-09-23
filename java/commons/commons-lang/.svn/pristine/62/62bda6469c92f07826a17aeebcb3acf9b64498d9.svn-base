package org.hy.commons.lang.thread.example;



/**
 *		比较两种方式的区别:
 *			
 *			使用继承方式,资源不能共享;
 *
 *			继承方式,继承了Thread类之后,就不能再继承其他类了;
 *
 *			
 *			从代码的简单性来性,来说继承方式简单些
 *
 *
 *		推荐使用 接口方法,  方便以后拓展;,资源共享
 *			
 * 			
 *
 */

class Ticket2 extends Object implements Runnable{

	
	int num = 50;
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			if(num >0) {
				try {
					Thread.currentThread().sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"卖出第" +num-- +"张");
			}
		}
	}
	
}
public class TicketDemo2 {
	public static void main(String[] args) {
		Runnable target = new Ticket2();
		new Thread(target,"A").start();
		new Thread(target,"B").start();
		new Thread(target,"C").start();
	}
}
