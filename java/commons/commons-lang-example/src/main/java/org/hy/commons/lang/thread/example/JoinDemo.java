package org.hy.commons.lang.thread.example;


class  Join implements Runnable{

	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("join --> " + i);
		}
		System.out.println("join --> " + Thread.currentThread().getName()+"结束了");
	}
	
}
public class JoinDemo {
	public static void main(String[] args) throws Exception {
		//testNoJoin();
		testJoin();
	}
	
	private static void testJoin() throws InterruptedException {
		Thread t =new Thread(new Join());
		for (int i = 0; i < 200; i++) {
			System.out.println("main----->" + i);
			if(i == 50){
				t.start();
			}
			if(i == 100){
				//主线程等待t执行完,才能执行
				//t强制运行,
				t.join();
				System.out.println("main --> " + "我等子线程结束了，再继续运行");
				System.out.println("main --> " + "我等子线程结束了，再从"+(i+1)+"重新开始运行");

			}
		}
		System.out.println("main --> " + Thread.currentThread().getName()+"结束了");

	}
	
	private static void testNoJoin() throws InterruptedException {
		Thread t =new Thread(new Join());
		for (int i = 0; i < 200; i++) {
			System.out.println("main----->" + i);
			if(i == 50){
				t.start();
			}
			if(i == 100){
				//主线程等待t执行完,才能执行
				//t强制运行,
				//t.join();
			}
		}
		System.out.println("main --> " + Thread.currentThread().getName()+"结束了");

	}
}