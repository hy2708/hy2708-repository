package org.hy.commons.lang.thread.example;

class MyRunnable implements Runnable{

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("子线程=  "+ i);
		}
	}
}
public class IsAliveDemo {
	public static void main(String[] args) {
		
		Thread t = new Thread(new MyRunnable()); 
		for (int i = 0; i < 200; i++) {
			System.out.println("main " +i );
			if(i == 50 ){
				t.start();
			}
		}
		//线程一旦挂了,就不能再使用 start方法启动了,
		//Exception in thread "main" java.lang.IllegalThreadStateException
		if(!t.isAlive()){
			t.start();
		}
	}
}