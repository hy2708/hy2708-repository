package com.hy.commons.datastruct.tree;

public class BiNode{
	Object data=null;
	BiNode left=null;
	BiNode right=null;
	public BiNode(Object data, BiNode left, BiNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public BiNode(Object data) {
		super();
		this.data = data;
		
	}

}