package com.hy.designpatern.struct.observer._05liandongstates;

import java.util.LinkedList;
import java.util.List;

import com.hy.designpatern.struct.observer._04states.Event;
import com.hy.designpatern.struct.observer._04states.Handler;

public class GuojiaEvent implements Event{

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
	public Integer getEventId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHandler(Handler handler) {
		list.add(handler);
		
	}
	List<Handler> list = new LinkedList<Handler>();

	@Override
	public void changeState(Object object) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).handle(this);
		}
		
	}

}
