package com.hy.designpatern.struct.observer._06dynamicstate;

import java.util.ArrayList;
import java.util.List;

public class EventSource {
	List<Event> list = new ArrayList<Event>();
	public void addEvent(Event event) {
		event.setSource(this);
		list.add(event);
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
}
