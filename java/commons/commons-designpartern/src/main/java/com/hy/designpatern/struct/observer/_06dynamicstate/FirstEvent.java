package com.hy.designpatern.struct.observer._06dynamicstate;

import java.util.LinkedList;
import java.util.List;

public class FirstEvent implements Event{
	public FirstEvent() {
		super();
	}

	
	public FirstEvent(EventSource eventSource) {
		super();
		this.eventSource = eventSource;
	}
	
	List<Handler> list = new LinkedList<Handler>();
	private EventSource eventSource =null;
	
	public void happen(Object source) {
		setSource(source);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).handle(this);
		}
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setSource(Object source) {
		this.eventSource=(EventSource)source;
		
	}

	@Override
	public Object getSource() {
		
		return eventSource;
	}

	@Override
	public void addHandler(Handler handler) {
		list.add(handler);
		
	}

	@Override
	public Integer getEventId() {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public void changeState(Object object) {
		System.err.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).handle(this);
		}
		
	}

}
