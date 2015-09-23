package org.hy.commons.lang.thiz;

public class Parent {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-6-30；时间：下午2:57:42</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 * @return 
	 */
	public static void main(String[] args) {
		new Parent().add();
		new Parent().add2();
	}
	
	/*
	 * this 分为编译时，和运行时，两种情况考虑。
	 * 在编译的时候， this指的是，当前类的实例对象
	 * 在运行的时候， this指的，不是，当前类的实例对象，
	 * 而是，当前类，或者子类的真正实例化对象
	 */
	public void add() {
		System.err.println("Parent this 对象是【" +
				this.toString()+
				"】");
	}
	
	public void add2() {
		this.add();
	}

}
