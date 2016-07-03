package org.hy.commons.lang.thread.mutex;

import java.util.ArrayList;
import java.util.List;

class MutexResourcePool{
	List<MutexResource3> list = new ArrayList<MutexResource3>();
	int mutex =1;
	Object mutexLock =new Object();
	int size =2;
	Object sizeLock =new Object();
	
	public MutexResourcePool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MutexResourcePool(List<MutexResource3> list) {
		super();
		this.list = list;
	}
	
	public void getResource(String threadName) throws InterruptedException {
		synchronized (sizeLock) {
			
			size--;
			if (size < 0) {
				// condition.await();
				System.out.println(threadName + "我被size阻塞了");
				sizeLock.wait();
				System.out.println(threadName + "我被size唤醒了");
			}
		}
			
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
		
		
		synchronized (sizeLock) {
			size++;
			if (size <= 0) {
				// condition.signal();
				System.out.println(threadName + "我size唤醒了别人");
				/*
				 *写 this.notifyAll(); 是错误的 
				 */
				
				sizeLock.notify();
			}
			// lock.unlock();
		}

	}

	
}

class MutexResource3 {
	// ReentrantLock lock = new ReentrantLock();
	// Condition condition = lock.newCondition();
	// 临界资源
	Integer mutex = 1;
	

	public void getResource(String threadName) throws InterruptedException {
		synchronized (this) {

			// lock.lock();
			mutex--;
			if (mutex < 0) {
				// condition.await();
				System.out.println(threadName + "我被阻塞了");
				this.wait();
				System.out.println(threadName + "我被唤醒了");
			}
			// lock.unlock();
		}

		System.out.println(threadName + "资源正被我使用了 ，被阻塞的人数是" + mutex);
		Thread.sleep(2000);
		System.out.println(threadName + "资源被我使用完并且释放了 ，被阻塞的人数是" + mutex
				+" ，如果这一行输出和上一行输出之间，有其他的输出内容，那么这就是，写两个小同步代码块和一个大代码块的区别，这样并行性更好");

		// lock.lock();
		synchronized (this) {
			mutex++;
			if (mutex <= 0) {
				// condition.signal();
				System.out.println(threadName + "我唤醒了别人");
				/*
				 *写 this.notifyAll(); 是错误的 
				 */
				
				this.notify();
			}
			// lock.unlock();

		}

	}
}

class T3 implements Runnable {

	private MutexResourcePool resource = null;

	public T3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public T3(MutexResourcePool resource) {
		super();
		this.resource = resource;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {

			try {
				resource.getResource(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

public class MutexDemo_More_SynBlock {

	public static void main(String[] args) {
		MutexResource3 resource = new MutexResource3();
		MutexResource3 resource2 = new MutexResource3();
		List<MutexResource3> list = new ArrayList<MutexResource3>();
		list.add(resource);
		list.add(resource2);
		MutexResourcePool pool =new MutexResourcePool();
		T3 t = new T3(pool);
		
		Thread thread = new Thread(t, "1号");
		thread.start();
		Thread thread2 = new Thread(t, "2号");
		thread2.start();
		Thread thread3 = new Thread(t,"3号");
		thread3.start();
		Thread thread4 = new Thread(t,"4号");
		thread4.start();
	}
}
