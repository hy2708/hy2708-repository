package org.hy.commons.lang.thread.example.money2;

class Singleton {
	private Singleton() {
	}

	private static Singleton instance;

	/**
	 * 此时同步监听对象是 Singleton.class
	 */
	/**
	 * public synchronized static Singleton getInstance(){ if(instance == null){
	 * instance = new Singleton(); } return instance; }
	 */
	
	/**
	 * 
	 * Spring   : <bean   scope = "singleton"/>
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	public  static Singleton getInstance2() {
		if (instance == null) {
				if (instance == null) {
					instance = new Singleton();
				}
		}
		return instance;
	}
	
	public synchronized static Singleton getInstance3() {
		if (instance == null) {
				if (instance == null) {
					instance = new Singleton();
				}
		}
		return instance;
	}
	
	public  static Singleton getInstance4() {
		synchronized (Singleton.class) {			
			if (instance == null) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	public  static Singleton getInstance5() {
		if (instance == null) {
			synchronized (Singleton.class) {			
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	public  static Singleton getInstance6() {
		if (instance == null) {
			synchronized (Singleton.class) {			
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
public class SingletonDemo {

}