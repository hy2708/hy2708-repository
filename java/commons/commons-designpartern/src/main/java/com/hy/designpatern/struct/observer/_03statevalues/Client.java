package com.hy.designpatern.struct.observer._03statevalues;


public class Client {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-11-29；时间：上午12:26:07</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 依赖关系倒转：
		 * observer 依赖，subject
		 * 本来应该是，observer持有subject的引用
		 * 现在是，subject持有observer的引用
		 */
		
		/*
		 * 主题，只有一个状态，有多个响应者
		 * 但是，响应者的级别不同。只有达到要求的级别。响应者，才能响应。
		 */
		Subject subject = new Subject();
		
		Observer o = new Observer(0);
		subject.addObserver(o);
		o = new Observer(2);
		subject.addObserver(o);
		
		o = new Observer(4);
		subject.addObserver(o);
		
		o = new Observer(6);
		subject.addObserver(o);
		
		subject.changeState(3);
		
	}

}
