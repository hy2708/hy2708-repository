package org.hy.commons.lang.thread.example.producer;

/**
 * 模拟区域
 *
 */
class Person{
	
	private String name;
	
	private String sex;

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
class Producer implements Runnable{
	
	private Person p;
	
	public Producer(Person p){
		this.p = p;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(i % 2== 0){
				p.setName("春哥");
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.setSex("男");
			}else{
				p.setName("著姐");
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.setSex("女");
			}
		}
	}
}

class Consumer implements  Runnable{
	private Person p;
	
	public Consumer(Person p){
		this.p = p;
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
			String name = p.getName();
			String sex = p.getSex();
			System.out.println(name+" --> " + sex);
		}
	}
	
}
public class Producer_ConsumerDemo {
	public static void main(String[] args) {
		Person p = new Person();
		
		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
	}
}