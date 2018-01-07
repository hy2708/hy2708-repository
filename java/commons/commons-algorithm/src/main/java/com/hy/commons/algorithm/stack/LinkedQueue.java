package com.hy.commons.algorithm.stack;

public class LinkedQueue {

	Node head=new Node(null);
	Node tail=head;
	
	public static void main(String[] args) {
		LinkedQueue stack = new LinkedQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
//		System.out.println(stack.pop().data);
	}
	
	public  void push(Object data) {
		Node node =new Node(data);
		tail.next=node;
		tail=node;
	}
	
	
	public  Node pop() {
		Node node =head.next;
		head.next=head.next.next;
		return node;
	}
}

class Node{
	
	public Node(Object data) {
		super();
		this.data = data;
	}
	Object data=null;
	Node next=null;;
}