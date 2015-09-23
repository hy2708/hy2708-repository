package com.hy.designpatern.struct.observer._06dynamicstate;

import java.util.LinkedList;
import java.util.List;

public class SecondEvent implements Event{
	List<Handler> list = new LinkedList<Handler>();

	public void happen(Object source) {
		setSource(source);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).handle(this);
		}
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setSource(Object source) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHandler(Handler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getEventId() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void changeState(Object object) {
		// TODO Auto-generated method stub
		
	}

}
