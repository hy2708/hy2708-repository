package com.hy.designpatern.struct.observer._06dynamicstate;

import java.util.LinkedList;
import java.util.List;

public class Subject implements Event{
	
	List<Handler> list = new LinkedList<Handler>();
	
	Object source = null;
	public void setSource(Object source) {
		this.source = source;
	}

	public Object getSource() {
		
		return null;
	}
	
	public void addHandler(Handler handler ) {
		list.add(handler);

	}
	
	

	public void happen(Object source) {
		setSource(source);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).handle(this);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getEventId() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void changeState(Object object) {
		// TODO Auto-generated method stub
		
	}
}
