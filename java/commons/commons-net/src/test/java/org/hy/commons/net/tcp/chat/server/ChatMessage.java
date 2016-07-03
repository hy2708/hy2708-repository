package org.hy.commons.net.tcp.chat.server;

public class ChatMessage {

	String from=null;
	String to = null;
	String message=null;
	
	public ChatMessage(String from, String to, String message) {
		super();
		this.from = from;
		this.to = to;
		this.message = message;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
