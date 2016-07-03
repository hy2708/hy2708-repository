package org.hy.commons.lang.thread.mutex.example.ticket.threadlocal;

class MyRunnable implements Runnable {

	private static ThreadLocal<Integer> num = new ThreadLocal<Integer>();

	public void run() {

		for (int i = 0; i < 200; i++) {
			sale();
		}
	}

	private Object o = new Object();

	public void sale() {
		// synchronized (this) {
		//synchronized (o) {
		//synchronized (MyRunnable.class) {
			if (num.get()==null) {
				num.set(50);
			}
			if (num.get() > 0) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "卖出第"
						+ (num.get()-1) + "张");
				num.set(num.get()-1);
			}
		//}
	}

}

public class TicketDemoSynchByblock {
	public static void main(String[] args) {

		Runnable target = new MyRunnable();
		new Thread(target, "A").start();
		new Thread(target, "B").start();
		new Thread(target, "C").start();
	}
}