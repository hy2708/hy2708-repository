package org.hy.commons.lang.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 线程之间，栈内存，独享
 * 堆内存，共享
 */
/*public class ThreadUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ThreadUtil.class);
	
	public static void p(Object mutexLock,java.util.concurrent.Semaphore mutex) throws InterruptedException {
		synchronized (mutexLock) {
			System.out.println("***********************");
			// lock.lock();
			mutex--;
			if (mutex < 0) {
				// condition.await();
				System.out.println(Thread.currentThread().getName() + "我被阻塞了");
				mutexLock.wait();
				System.out.println(Thread.currentThread().getName() + "我被唤醒了");
			}
			// lock.unlock();
		}
		
	}
	
	public static void v(Object mutexLock,Integer mutex) throws InterruptedException {
		synchronized (mutexLock) {
			mutex++;
			if (mutex <= 0) {
				// condition.signal();
				System.out.println(Thread.currentThread().getName() + "我唤醒了别人");
				
				 *写 this.notifyAll(); 是错误的 
				 
				
				mutexLock.notify();
			}
			// lock.unlock();

		}
		
	}
	public static void getcurrentThread(Class<?> target) {
		//System.out.println(this.getName() + i);
		
		 * static Thread currentThread() 
      			返回对当前正在执行的线程对象的引用。 
		 *
		// Thread.currentThread().setName("OOXX");
	}

}

class Semaphore{
	Integer mutex;
	
	public Integer getValue() {
		return mutex;
	}

	public Semaphore(Integer mutex) {
		super();
		this.mutex = mutex;
	}
	
}*/