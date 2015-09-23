package com.hy.designpatern.struct.observer._06dynamicstate;


/*
 * 事件=状态= subject
 */
public interface Event {

	public void setSource(Object source);

	public Object getSource();

	//public void setEventId(Object source);

	public Integer getEventId();

	public void addHandler(Handler handler );
	public void changeState(Object object );
}
