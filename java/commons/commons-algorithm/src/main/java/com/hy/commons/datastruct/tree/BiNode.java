package com.hy.commons.datastruct.tree;

public class BiNode {

	private Object value =null;
	 BiNode leftNode =null;
	 BiNode rightNode =null;
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public BiNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BiNode leftNode) {
		this.leftNode = leftNode;
	}
	public BiNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(BiNode rightNode) {
		this.rightNode = rightNode;
	}

	public BiNode(Object data, BiNode left, BiNode right) {
		super();
		this.value = data;
		this.leftNode = left;
		this.rightNode = right;
	}

	public BiNode(Object data) {
		super();
		this.value = data;

	}
	public BiNode( ) {
		super();

	}
}

/*
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

}*/
