package com.hy.designpatern.struct.observer._05liandongstates;

public class Client {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-1-5；时间：下午3:54:22</li>
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
		// TODO Auto-generated method stub
		GuojiaSource guojiaSource = new GuojiaSource();
		GuojiaEvent guojiaEvent = new GuojiaEvent();
		guojiaSource.addEvent(guojiaEvent);
		guojiaEvent.addHandler(new GuojiaHandler());
		guojiaEvent.changeState("zhongguo");
	}

}
