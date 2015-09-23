package org.hy.commons.lang.thread.example.money2;

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

class ATM extends Thread {

	private double drawMoeny;
	private Account a;

	public ATM(double drawMoeny, Account a,String name) {
		super(name);
		this.drawMoeny = drawMoeny;
		this.a = a;
	}

	/**
	 * 继承方式,同步监听对象不能使用this
	 */
	public synchronized void run() {
	
		//synchronized (this) {//ERROR
		//synchronized (a) {//TES
		
		//Class clz = ATM.class;ATM这一份字节码
		//synchronized (ATM.class) {//TES
			if (a.getBalance() >= drawMoeny) {// 余额>= 提款金额
				System.out.println(Thread.currentThread().getName() + "-->,吐出"
						+ drawMoeny);
				a.setBalance(a.getBalance() - drawMoeny);
				System.out.println(Thread.currentThread().getName() + "剩余"
						+ a.getBalance());
			} else {
				System.out.println(Thread.currentThread().getName() + "余额不足"
						+ a.getBalance());
			}
		//}
		
	}

}

public class DrawMoneyDemo {
	public static void main(String[] args) {
		Account a = new Account(1000);
		new ATM(800,a,"A").start();
		new ATM(800,a,"B").start();
	}
}