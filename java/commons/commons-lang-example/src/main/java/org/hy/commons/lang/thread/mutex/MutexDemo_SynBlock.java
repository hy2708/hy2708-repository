package org.hy.commons.lang.thread.mutex;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MutexResource2 {
	// ReentrantLock lock = new ReentrantLock();
	// Condition condition = lock.newCondition();
	// 临界资源
	Integer mutex = 1;
	Object mutexLock =new Object();

	public void getResource(String threadName) throws InterruptedException {
		synchronized (mutexLock) {

			// lock.lock();
			mutex--;
			if (mutex < 0) {
				// condition.await();
				System.out.println(threadName + "我被阻塞了");
				mutexLock.wait();
				System.out.println(threadName + "我被唤醒了");
			}
			// lock.unlock();
		}

		System.out.println(threadName + "资源正被我使用了 ，被阻塞的人数是" + mutex);
		Thread.sleep(2000);
		System.out.println(threadName + "资源被我使用完并且释放了 ，被阻塞的人数是" + mutex
				+" ，如果这一行输出和上一行输出之间，有其他的输出内容，那么这就是，写两个小同步代码块和一个大代码块的区别，这样并行性更好");

		// lock.lock();
		synchronized (mutexLock) {
			mutex++;
			if (mutex <= 0) {
				// condition.signal();
				System.out.println(threadName + "我唤醒了别人");
				/*
				 *写 this.notifyAll(); 是错误的 
				 */
				
				mutexLock.notify();
			}
			// lock.unlock();

		}

	}
}

class T2 implements Runnable {

	private MutexResource2 resource = null;

	public T2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public T2(MutexResource2 resource) {
		super();
		this.resource = resource;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {

			try {
				resource.getResource(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

public class MutexDemo_SynBlock {

	public static void main(String[] args) {
		MutexResource2 resource = new MutexResource2();
		T2 t = new T2(resource);
		Thread thread = new Thread(t, "1号");
		thread.start();
		Thread thread2 = new Thread(t, "2号");
		thread2.start();
		Thread thread3 = new Thread(t,"3号");
		thread3.start();
	}
}
