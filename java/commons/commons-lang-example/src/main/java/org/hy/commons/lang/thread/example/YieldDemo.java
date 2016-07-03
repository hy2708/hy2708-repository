package org.hy.commons.lang.thread.example;

import org.hy.commons.lang.thread.example.Yield;
/*
 * 让程序结束执行，回答“就绪状态”
 * 下一次哪一个线程进入“执行状态”，靠竞争
 */
class Yield implements Runnable{

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName()+"-->" + i);
			if(i % 2 == 0){
				//i为偶数的时候,礼让
				Thread.yield();
			}
		}
	}
	
}
public class YieldDemo {
	public static void main(String[] args) {
		Yield y = new Yield();
		new Thread(y,"     老大").start();
		new Thread(y,"小三").start();
		
		
	}
}