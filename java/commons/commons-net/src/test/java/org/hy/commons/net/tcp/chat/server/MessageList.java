package org.hy.commons.net.tcp.chat.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;

public class MessageList extends LinkedList<ChatMessage>{

	List<Socket> list= null;

	
	public void setSocketList(List<Socket> list) {
		this.list = list;
	}


	@Override
	public boolean add(ChatMessage e) {
		boolean b= super.add(e);
		updateMessagesInClient(e);
		return b;
	}
	
	private void updateMessagesInClient(ChatMessage chatMessage) {
		System.out.println("socket size shi"+list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i+list.get(i));
			try {
				PrintWriter out = new PrintWriter(list.get(i).getOutputStream());
				out.println(chatMessage.getFrom()+"说 ："+chatMessage.message);
				out.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
