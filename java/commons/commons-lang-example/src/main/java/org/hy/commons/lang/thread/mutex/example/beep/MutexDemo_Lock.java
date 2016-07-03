package org.hy.commons.lang.thread.mutex.example.beep;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MutexResource{
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	//临界资源
	int mutex=1;
	public void getResource(String threadName) throws InterruptedException {
		lock.lock();
		mutex--;
		if (mutex<0) {
			System.out.println(threadName+"我被阻塞了");
			condition.await();
		}
		lock.unlock();
		
		System.out.println(threadName+"资源被我使用了");
		Thread.sleep(2000);
		System.out.println(threadName+"资源被我释放了");
		
		lock.lock();
		mutex++;
		if (mutex<=0) {			
			condition.signal();
		}
		lock.unlock();
	}
}
class T implements Runnable{

	private MutexResource resource =null;
	
	public T() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public T(MutexResource resource) {
		super();
		this.resource =resource;
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
public class MutexDemo_Lock {

	public static void main(String[] args) {
		MutexResource resource = new MutexResource();
		T t = new T(resource);
		Thread thread = new Thread(t,"1号-");
		thread.start();
		Thread thread2 = new Thread(t,"2号--");
		thread2.start();
		Thread thread3 = new Thread(t,"3号---");
		thread3.start();
	}
}
