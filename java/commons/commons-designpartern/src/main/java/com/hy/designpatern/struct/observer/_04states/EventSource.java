package com.hy.designpatern.struct.observer._04states;

import java.util.ArrayList;
import java.util.List;

public class EventSource {
	List<Event> list = new ArrayList<Event>();
	public void addEvent(Event event) {
		event.setSource(this);
		list.add(event);
	}

	public  List<Event>  getEventList() {
		return list;
	}
	
	public  Event  findEvent(Event event) {
		
		for (int i = 0; i < list.size(); i++) {
			if (event.getClass().equals(list.get(i).getClass())) {
				return list.get(i);
				
			}
		}
		return null;
	}
	public void addFirstEventHander(Handler handler) {
		FirstEvent event =null;
		for (int i = 0; i < list.size(); i++) {
			if (FirstEvent.class.equals(list.get(i).getClass())) {
				event=(FirstEvent)list.get(i);
				break;
			}
		}
		if (null==event) {
			event=new FirstEvent();
			addEvent(event);
		}
		event.addHandler(handler);
	}
	
	public void addEventHander(Event event,Handler handler) {
		Event curEvent =null;
		curEvent = findEvent(event);
		if (null==curEvent) {
			curEvent =event;
			addEvent(curEvent);
		}
		//curEvent.setSource(this);
		curEvent.addHandler(handler);
	}
	
	@Deprecated
	/*
	 * see firstEvent.changeState(null)
	 */
	public void triggerEvent(Event event) {
		Event curEvent =findEvent(event);
		if (curEvent!=null) {
			event.changeState(null);
		}
	}
}
