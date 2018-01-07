package com.hy.commons.datastruct.tree;

import java.util.*;

public class BiTree {




	public int heignt(BiNode root) {
		if (root==null) {
			return 0;
		}
		if (root.getLeftNode()==null&&root.getRightNode()==null) {
			return 1;
		}
		int fh =heignt(root.getLeftNode());
		int rh =heignt(root.getRightNode());

		return Math.max(fh, rh)+1;
	}


	public static BiNode createBiTree(String[] arr,int index){
		if(index>arr.length-1){
			return null;
		}
		BiNode node= new BiNode();
		node.setValue(arr[index]);
		node.setRightNode(createBiTree(arr,2*index+2));
		node.setLeftNode(createBiTree(arr,2*index+1));
		return node;
	}

	public static void main(String[] args){
		String str="1,2,3,4,#,6,7,#,9";
		String[] arr= str.split(",");
		BiNode tree =createBiTree (arr,0);
		printTree(tree,0);

		feiDigui(tree);
		feiDigui2(tree);
		xianxuFeiDigui(tree);
		houxuFeiDigui(tree);
		zhongxuFeiDigui(tree);


	}
	public static void printTree(BiNode root,int level){
		//String str="1,2,3,4,#,6,7,#,9";
		if(root==null||root.getValue()==null){
			return ;
		}
		String s="---";
		String pre="";
		for (int i=0;i<level;i++){
			pre=pre+s;
		}
		System.out.println(pre+root.getValue());
		printTree(root.getLeftNode(),level+1);
		printTree(root.getRightNode(),level+1);


	}

	public static void feiDigui(BiNode root){
		Stack stack= new Stack();
		stack.push(root);
		while (!stack.isEmpty()){
			BiNode node = (BiNode) stack.pop();
			System.out.print(node.getValue());

			if(node.getRightNode()!=null){
				stack.push(node.getRightNode());
			}
			if(node.getLeftNode()!=null){
				stack.push(node.getLeftNode());
			}
		}
		System.out.println("");

	}


	public static void feiDigui2(BiNode root){
		Queue stack= new LinkedList();
		stack.add(root);
		while (!stack.isEmpty()){
			BiNode node = (BiNode) stack.poll();
			System.out.print(node.getValue());
			if(node.getRightNode()!=null){
				stack.add(node.getRightNode());
			}
			if(node.getLeftNode()!=null){
				stack.add(node.getLeftNode());
			}

		}
		System.out.println("");
	}


	public static void xianxuFeiDigui(BiNode root){
		Stack nodeStack= new Stack();
		Set<BiNode> visited= new HashSet<BiNode>();//

		nodeStack.push(root);
		visited.add(root);
		System.out.print(root.getValue());

		while (!nodeStack.isEmpty()){
			BiNode stackHead = (BiNode) nodeStack.peek();
			if(stackHead.getLeftNode()!=null&&!visited.contains(stackHead.getLeftNode())){
				stackHead =stackHead .getLeftNode();
				nodeStack.push(stackHead);
				visited.add(stackHead);
				System.out.print(stackHead.getValue());
				continue;

			}
			if(stackHead.getRightNode()!=null&&!visited.contains(stackHead.getRightNode())){
				stackHead =stackHead .getRightNode();
				nodeStack.push(stackHead);
				visited.add(stackHead);
				System.out.print(stackHead.getValue());
				continue;
			}
			nodeStack.pop();

		}
		System.out.println("");

	}

	public static void houxuFeiDigui(BiNode root){
		Stack nodeStack= new Stack();
		Set<BiNode> visited= new HashSet<BiNode>();//

		nodeStack.push(root);
		visited.add(root);

		while (!nodeStack.isEmpty()){
			BiNode stackHead = (BiNode) nodeStack.peek();
			if(stackHead.getLeftNode()!=null&&!visited.contains(stackHead.getLeftNode())){
				stackHead =stackHead .getLeftNode();
				nodeStack.push(stackHead);
				visited.add(stackHead);
				//System.out.print(stackHead.getValue());
				continue;

			}
			if(stackHead.getRightNode()!=null&&!visited.contains(stackHead.getRightNode())){
				stackHead =stackHead .getRightNode();
				nodeStack.push(stackHead);
				visited.add(stackHead);
				//System.out.print(stackHead.getValue());
				continue;
			}

			System.out.print(stackHead.getValue());
			nodeStack.pop();

		}
		System.out.println("");

	}

	public static void zhongxuFeiDigui(BiNode root){
		Stack nodeStack= new Stack();
		Set<BiNode> visited= new HashSet<BiNode>();//

		nodeStack.push(root);
		visited.add(root);

		while (!nodeStack.isEmpty()){
			BiNode stackHead = (BiNode) nodeStack.peek();
			if(stackHead.getLeftNode()!=null&&!visited.contains(stackHead.getLeftNode())){
				stackHead =stackHead .getLeftNode();
				nodeStack.push(stackHead);
				visited.add(stackHead);
				continue;

			}
			System.out.print(stackHead.getValue());
			nodeStack.pop();


			if(stackHead.getRightNode()!=null&&!visited.contains(stackHead.getRightNode())){
				stackHead =stackHead .getRightNode();
				nodeStack.push(stackHead);
				visited.add(stackHead);
				continue;
			}


		}
		System.out.println("");

	}

}
