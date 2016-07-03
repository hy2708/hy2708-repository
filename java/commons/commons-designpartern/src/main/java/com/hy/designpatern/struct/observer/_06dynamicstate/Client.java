package com.hy.designpatern.struct.observer._06dynamicstate;


public class Client {
	
	
	/*
	 * 如何实现，动态绑定 事件源，和事件，和事件处理
	 */
	public void addEventHander(EventSource source,Event event,Handler handler) {
		Event curEvent =null;
		for (int i = 0; i < list.size(); i++) {
			if (event.getClass().equals(list.get(i).getClass())) {
				curEvent=list.get(i);
				break;
			}
		}
		if (null==curEvent) {
			curEvent =event;
			addEvent(curEvent);
		}
		curEvent.addHandler(handler);
	}

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
		Subject subject = new Subject();
		EventSource source = new EventSource();
		
		final FirstEvent firstEvent = new FirstEvent();
        Handler handler = new FirstEventHandler();
		firstEvent.addHandler(handler);
		source.addEvent(firstEvent);
		
		SecondEvent secondEvent = new SecondEvent();
		source.addEvent(secondEvent);
		
				
		firstEvent.changeState(null);
		
	}

}
