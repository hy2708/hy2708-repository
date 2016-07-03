package org.hy.commons.lang.thread.example.producer2;

/**
 * 模拟区域
 * 
 */
/*
 * 
 * 避免妖的问题,主要就是保证 设置名字和性别同步完成,
 */
class Person {

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
		synchronized (this) {
			// if(isEmpty)
			while (!isEmpty.equals(Boolean.TRUE)) {
				// 区域不为空
				// 此时生产者应该停下来,等着消费者消费
				try {
					this.wait();// 等待 消费者消费
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.name = name;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.sex = sex;
			// 生产者生产之后,应该修改存储区域的状态
			isEmpty = Boolean.FALSE;// 不为空
			this.notifyAll();// 唤醒消费者,起来吃东西了
		}

	}

	/**
	 * 消费
	 */
	public void get() {
		synchronized (this) {
			// 存储区域为空
			while (!isEmpty.equals(Boolean.FALSE)) {
				try {
					this.wait();// 等着生产者去生产
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String name = getName();
			String sex = getSex();
			System.out.println(name + " --> " + sex);
			// 消费完成,应该修改存储区域的状态

			isEmpty = Boolean.TRUE;// 空了
			this.notifyAll();// 唤醒生产者,
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
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				p.set("春哥哥", "男");
			} else {
				p.set("著姐", "女");
			}
			System.err.println(p);
		}
	}
}

class Consumer implements Runnable {
	private Person p;

	public Consumer(Person p) {
		this.p = p;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			p.get();
			System.err.println(p);

		}
	}

}

public class Producer_ConsumerDemo {
	public static void main(String[] args) {
		Person p = new Person();

		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
		
		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
	}
}