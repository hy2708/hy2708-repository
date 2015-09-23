package org.hy.commons.lang.thread.example;


class Daemon  implements Runnable{

	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Daemon -->" + i);
		}
	}
	
}
/**
 * 后台线程：处于后台运行，任务是为其他线程提供服务。也称为“守护线程�?或�?精灵线程”�?JVM的垃圾回收就是典型的后台线程�?特点：若�?��的前台线程都死亡，后台线程自动死亡�?
设置后台线程：Thread对象setDaemon(true);
setDaemon(true)必须在start()调用前�?否则出现IllegalThreadStateException异常�?前台线程创建的线程默认是前台线程;
判断是否是后台线程：使用Thread对象的isDaemon()方法�?并且当且仅当创建线程是后台线程时，新线程才是后台线程�? * @author will
 *
 */
public class DaemonDemo {
	public static void main(String[] args) {
	/*	Thread cThread = Thread.currentThread();
		System.out.println(cThread.isAlive());
		
		//cThread.setDaemon(true);
		System.out.println(cThread.isDaemon());*/
		
		Thread t = new Thread(new Daemon());
		
		System.out.println(t.isDaemon());
		for (int i = 0; i < 10; i++) {
			
			System.out.println("main--" + i);
			if(i == 5){
				t.setDaemon(true);
				t.start();
			}
		}
	}
}