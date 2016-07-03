package org.hy.commons.lang.thread.example.money3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 账号
 */
class Account2 {

	//创建可重入锁对象
	private final  ReentrantLock lock = new ReentrantLock();
	// 余额
	private double balance;

	public Account2(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void draw(double drawMoeny){
		//上锁
				lock.lock();//获取锁
				
				try{
					if (getBalance() >= drawMoeny) {// 余额>= 提款金额
						System.out.println(Thread.currentThread().getName() + "-->,吐出"
								+ drawMoeny);
						setBalance(getBalance() - drawMoeny);
						System.out.println(Thread.currentThread().getName() + "剩余"
								+ getBalance());
					} else {
						System.out.println(Thread.currentThread().getName() + "余额不足"
								+ getBalance());
					}
					
				}finally{
					//最后,开锁,走人
					lock.unlock();
				}

	}
}

class ATM2 implements Runnable{

	

	
	private double drawMoeny;
	private Account2 a;

	public ATM2(double drawMoeny, Account2 a) {
		this.drawMoeny = drawMoeny;
		this.a = a;
	}

	/**
	 * 第3种同步方式:
	 * 
	 * java.util.concurrent.locks.Lock接口
	 * java.util.concurrent.locks.ReentrantLock类
	 * 		ReentrantLock,可重入锁,没有同步监听对象
	 * 
	 *  
	 *  格式:
	 *  
	 *  	private final ReentrantLock lock= new ReentrantLock();//创建锁的一个对象
	 *  
	 *   	public void  m(){
	 *   		//进入方法第一件事,上锁
	 *   		lock.lock();//获取锁
	 *   
	 *   		try{
	 *   			//需要同步的代码
	 *   		}finally{
	 *   			lock.unlock();//解锁,走人
	 *   		}
	 *   	}
	 *  	
	 * 
	 */
	public void run() {
		a.draw(drawMoeny);
	}

}

public class DrawMoneyDemo2 {
	public static void main(String[] args) {
		Account2 a = new Account2(1000);
		ATM2 atm = new ATM2(800,a);
		new Thread(atm,"小2").start();
		new Thread(atm,"小3").start();
		
		//StringBuilder  /  StringBuffer
	}
}