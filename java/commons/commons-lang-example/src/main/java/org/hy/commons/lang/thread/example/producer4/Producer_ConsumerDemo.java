package org.hy.commons.lang.thread.example.producer4;

import java.util.LinkedList;
import java.util.List;


/*
 * 
 * 避免妖的问题,主要就是保证 设置名字和性别同步完成,
 * 
 * 
 * 可重入锁没有同步监听对象,咋办呢?
 * 
 * Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。 
 */
class Person {

	// 创建可重入锁对象
	private final ReentrantLock lock = new ReentrantLock();
	
	private  final  Condition con = lock.newCondition();
	private String name;

	private String sex;

	// 表示存储区域是否为空
	private Boolean isEmpty = Boolean.TRUE;

	/**
	 * 生产
	 * 
	 * @param name
	 * @param sex
	 */
	public void set(String name, String sex) {
		lock.lock();
		while(!isEmpty.equals(Boolean.TRUE)){
			//表示不空状态
			try {
				System.err.println("被阻塞了"+Thread.currentThread().getName());

				con.await();
				System.err.println("被唤醒了"+Thread.currentThread().getName());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			this.name = name;
			Thread.sleep(1);
			this.sex = sex;
			System.out.println("生产"+name + " --> " + sex);

			isEmpty = Boolean.FALSE;
			con.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			lock.unlock();
		}
		

	}

	/**
	 * 消费
	 */
	public void get() {
		lock.lock();
		while(!isEmpty.equals(Boolean.FALSE)){
			//存储区域为空,消费者应该等着
			try {
				System.err.println("被阻塞了"+Thread.currentThread().getName());
				con.await();
				System.err.println("被唤醒了"+Thread.currentThread().getName());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			String name = getName();
			String sex = getSex();
			System.out.println("取出"+name + " --> " + sex);
			//
			isEmpty = Boolean.TRUE;
			con.signal();
		} finally {
			lock.unlock();
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}



/**
 * 生产者
 */
class Producer implements Runnable {

	private List p;

	public Producer(List p) {
		this.p = p;
	}

	public void run() {
		while (true) {
			
		
		if (p.size()<5) {
			synchronized (p) {
				if (p.size()<5) {
					System.out.println("p");

					p.add(new Apple());
				}
			}	
		}		
		}
	}
}

class Consumer implements Runnable {
	private List p;

	public Consumer(List p) {
		this.p = p;
	}

	public void run() {
		while (true) {
			
		
		if (p.size()>=0) {
			synchronized (p) {
				if (p.size()>=0) {
					System.out.println("c");
					p.remove(0);
				}
			}	
		}
		}
	}

}

class Apple{

}
public class Producer_ConsumerDemo {
	public static void main(String[] args) {

		List<?> list= new LinkedList();
		
		new Thread(new Producer(list),"p").start();
		new Thread(new Consumer(list),"c").start();

	}
}