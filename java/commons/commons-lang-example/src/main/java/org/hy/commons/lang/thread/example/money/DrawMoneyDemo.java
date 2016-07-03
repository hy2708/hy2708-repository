package org.hy.commons.lang.thread.example.money;

/**
 * 账号
 */
class Account {

	// 余额
	private double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}

class ATM implements Runnable {

	private double drawMoeny;
	private Account a;

	public ATM(double drawMoeny, Account a) {
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

	Object o = new Object();

	// public synchronized void run() {

	public void run() {
		/**
		 * 若同步代码块使用this作为同步监听器对象,那么直有实现Runnable才可以使用
		 */

		synchronized (this) {// a也可以

			if (a.getBalance() >= drawMoeny) {// 余额>= 提款金额
				System.out.println(Thread.currentThread().getName() + "-->,吐出"
						+ drawMoeny);

				// 取钱后,余额的减
				// 修改账号余额
				a.setBalance(a.getBalance() - drawMoeny);
				System.out.println(Thread.currentThread().getName() + "剩余"
						+ a.getBalance());
			} else {
				System.out.println(Thread.currentThread().getName() + "余额不足"
						+ a.getBalance());
			}
		}
	}

}

public class DrawMoneyDemo {
	public static void main(String[] args) {
		Account a = new Account(1000);

		ATM atm = new ATM(800, a);
		new Thread(atm, "A").start();
		new Thread(atm, "B").start();
	}
}