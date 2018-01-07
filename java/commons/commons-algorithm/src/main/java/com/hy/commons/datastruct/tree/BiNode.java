package com.hy.commons.datastruct.tree;

public class BiNode {

	private Object value =null;
	private BiNode leftNode =null;
	private BiNode rightNode =null;
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


}
f