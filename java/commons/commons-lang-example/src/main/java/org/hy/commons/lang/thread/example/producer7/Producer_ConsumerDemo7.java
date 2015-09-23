package org.hy.commons.lang.thread.example.producer7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟区域
 * 
 */
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
	
	private  final  Condition emptyCon = lock.newCondition();
	private  final  Condition fullCon = lock.newCondition();
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
		while(isEmpty.equals(Boolean.FALSE)){
			//表示不空状态
			try {
				System.err.println("00被阻塞了"+Thread.currentThread().getName());

				fullCon.await();
				System.err.println("00被唤醒了"+Thread.currentThread().getName());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			this.name = name;
			Thread.sleep(1);
			this.sex = sex;
			System.out.println("生产"+name + " --> " + sex);

			isEmpty = Boolean.FALSE;
			emptyCon.signal();
			System.err.println("唤醒别人"+Thread.currentThread().getName());
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
		while(isEmpty.equals(Boolean.TRUE)){
			//存储区域为空,消费者应该等着
			try {
				System.err.println("被阻塞了"+Thread.currentThread().getName());
				emptyCon.await();
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
			fullCon.signal();
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

	private Person p;

	public Producer(Person p) {
		this.p = p;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				p.set("春哥哥", "男");
			} else {
				p.set("著姐", "女");
			}
		}
	}
}

class Consumer implements Runnable {
	private Person p;

	public Consumer(Person p) {
		this.p = p;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			p.get();
		}
	}

}

public class Producer_ConsumerDemo7 {
	public static void main(String[] args) {
		Person p = new Person();

		new Thread(new Consumer(p),"消费者").start();
		new Thread(new Producer(p),"生产者").start();

	}
}