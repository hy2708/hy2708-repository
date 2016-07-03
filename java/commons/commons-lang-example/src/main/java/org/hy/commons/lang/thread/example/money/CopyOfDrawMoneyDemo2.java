package org.hy.commons.lang.thread.example.money;

/**
 * 账号
 */
class Account2 {

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
	
	//同步方法
	//取钱
	/**
	 * 同步方法的同步监听器对象:   若该方法是非静态的那么就是this
	 * @param drawMoeny		若方法是静态那么就是同步方法所在类的  Class clz  =  Account2.class;(一份字节码)
	 */
	public synchronized  void draw(double drawMoeny){
		if (balance >= drawMoeny) {// 余额>= 提款金额
			System.out.println(Thread.currentThread().getName() + "-->,吐出"
					+ drawMoeny);

			// 取钱后,余额的减
			// 修改账号余额
			setBalance(balance - drawMoeny);
			System.out.println(Thread.currentThread().getName() + "剩余"
					+ balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "余额不足"
					+ getBalance());
		}
	}
}

class ATM2 implements Runnable {

	private double drawMoeny;
	private Account2 a;

	public ATM2(double drawMoeny, Account2 a) {
		this.drawMoeny = drawMoeny;
		this.a = a;
	}

	// 线程体写取钱的操作
	/**
	 * 
	 * 
	 * 此时造成原因是: 两个线程同时操作这个账号
	 * 
	 * 解决方案:保证取钱和修改余额同时完成, 1. 使用同步代码块,synchronized(obj){},还需要一个同步监听对象, 2.
	 * 使用同步方法,使用synchronized去修饰,需要同步的方法
	 */


	public void run() {
		a.draw(drawMoeny);
	}

}

public class CopyOfDrawMoneyDemo2 {
	public static void main(String[] args) {
		Account2 a = new Account2(1000);

		ATM2 atm = new ATM2(800, a);
		new Thread(atm, "A").start();
		new Thread(atm, "B").start();
	}
}