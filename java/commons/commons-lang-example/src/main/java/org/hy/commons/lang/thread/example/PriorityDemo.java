package org.hy.commons.lang.thread.example;

class Priority implements Runnable{

	public void run() {
		
		for (int i = 0; i < 200; i++) {
			System.out.println("Priority-- " + i);
		}
	}
	
}
/**
 * 每个线程都有优先级，优先级的高低只和线程获得执行机会的次数多少有关。
	并非线程优先级越高的就一定先执行，哪个线程的先运行取决于CPU的调度;
	默认情况下main线程具有普通的优先级，而它创建的线程也具有普通优先级。
	Thread对象的setPriority(int x)和getPriority()来设置和获得优先级。
	MAX_PRIORITY	:	值是10
	MIN_PRIORITY	:	值是1
	NORM_PRIORITY	:	值是5(主方法默认优先级)

 *
 */
public class PriorityDemo {
	public static void main(String[] args) {
		
		/**
		 * 线程的优先级在[1,10]之间
		 */
		Thread.currentThread().setPriority(3);
		System.out.println("main= " + Thread.currentThread().getPriority());
		/*
		 *  public final static int MIN_PRIORITY = 1;
		 *  public final static int NORM_PRIORITY = 5;
		 *  public final static int MAX_PRIORITY = 10;
		 * */
		System.out.println(Thread.MAX_PRIORITY);
		
		//===============================================
		
		Thread t = new Thread(new Priority());
		for (int i = 0; i < 200; i++) {
			System.out.println("main" + i);
			if(i == 50){
				t.start();
				t.setPriority(10);
			}
			System.out.println("-------------------------"+t.getPriority());
		}
	}
}