package org.hy.commons.lang.thiz;

public class Child01 extends Parent {
	@Override
	public void add() {
		System.err.println("Child01 的this 对象是【" +
				this.toString()+
				"】");
	}

	public static void main(String[] args) {
		/*
		 * add方法里面的，【this】指的是，child01
		 */
		new Child01().add();
		
		/*
		 * 模板方法模式
		 */
		new Child01().add2();
		
	}
	

}
