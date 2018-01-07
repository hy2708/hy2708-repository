package com.hy.commons.datastruct.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BiTreeUtil {
	public static BiNode buildTreeByString(String tree,int index) {
		BiNode node=null;

		if (index >= tree.length()||tree.charAt(index)=='#') {
			return null;

		}
		node=new BiNode(tree.charAt(index));
		node.leftNode=buildTreeByString(tree,2*index+1);
		node.rightNode=buildTreeByString(tree,2*index+2);
		return node;
	}
	

	public static void buildTreeByArray() {
		int[] tree=new int[256];
		List<String> list=new LinkedList<String>();
		list.add("11,LL");
		list.add("7,LLL");
		list.add("8,R");
		list.add("5,");
		list.add("4,L");
		list.add("13,RL");
		list.add("2,LLR");
		list.add("1,RRR");
		list.add("4,RR");

		for (int i = 0; i < list.size(); i++) {
			String line =list.get(i);
			String[] two =line.split(",");
			int k=0;
			String treeIndex =null;
			if (two.length>=2) {
				treeIndex =two[1];

			}
			for (int j = 0; treeIndex!=null&&j <treeIndex.length() ; j++) {
				if (treeIndex.charAt(j)=='L') {
					k=2*k+1;
				}else if (treeIndex.charAt(j)=='R') {
					k=2*k+2;
				}
			}
			tree[k]=Integer.valueOf(two[0]);
		}
		for (int i = 0; i < tree.length; i++) {
			if (tree[i]!=0) {
				System.out.print(tree[i]+" ");
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		//String tree="abc##de";
		String tree="abc#xde##f";

		BiNode root = buildTreeByString(tree, 0);
		//xianxuTraverse(root);
//		xianxuTraverse_FeiDiGui2(root);
		xianxuTraverse_FeiDiGui22(root);
		//theFirstTraversal_Stack(root);
		//buildTreeByArray();
		int[] arr=new int[10];
		kuandu_xianxuTraverse(root, 1, arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void xianxuTraverse(BiNode root) {
		if (root==null) {
			return;
		}
		System.out.println(root.getValue());
		xianxuTraverse(root.leftNode);
		xianxuTraverse(root.rightNode);
	}
	
	public static void theFirstTraversal_Stack(BiNode root) {  //先序遍历
	    Stack<BiNode> stack = new Stack<BiNode>();
	    BiNode node = root;
	    while (node != null || stack.size() > 0) {  //将所有左孩子压栈
	      if (node != null) {   //压栈之前先访问
	        System.out.println(node.getValue());
	        stack.push(node);
	        node = node.leftNode;
	      } else {
	        node = stack.pop();
	        node = node.rightNode;
	      }
	    }
	  }
	
	public static void xianxuTraverse_FeiDiGui22(BiNode root) {
		if (root == null) {
			return;
		}
		Stack<BiNode> nodeStack = new Stack<BiNode>();
		Stack<Integer> flagStack = new Stack<Integer>();

		nodeStack.push(root);
		flagStack.push(0);
		/*
		 0代表第一次访问该节点
		 1代表已经访问过该节点，及其左子树
		 2代表已经访问过该节点，及其左子树与右子树
		 */

		while (nodeStack.size() > 0) {

			int flag = flagStack.peek();
			BiNode cur = nodeStack.peek();

			if (cur == null) {//栈顶元素为空,，则弹出栈顶元素，并更新flagStack的新栈顶元素的标记
				nodeStack.pop();
				flagStack.pop();

				int temp = flagStack.pop();
				flagStack.push(temp + 1);
			} else if (flag == 0) {//0代表第一次访问该节点，则访问左子树，并入栈，标记为0.
				//System.out.println(cur.data);

				nodeStack.push(cur.leftNode);
				flagStack.push(0);

			} else if (flag == 1) {//1代表已经访问过该节点，及其左子树,则访问右子树，并入栈，标记为0.
				System.out.println(cur.getValue());
				nodeStack.push(cur.rightNode);
				flagStack.push(0);

			} else if (flag == 2) {//2代表已经访问过该节点，及其左子树与右子树，则弹出栈顶元素，并更新flagStack的新栈顶元素的标记
				BiNode node =nodeStack.pop();
				flagStack.pop();
				//System.out.println(node.data);
				if (flagStack.size() > 0) {
					int temp = flagStack.pop();
					flagStack.push(temp + 1);
				}
			}

		}

	}
	
	public static void xianxuTraverse_FeiDiGui2(BiNode root) {
		if (root==null) {
			return;
		}
		Stack<BiNode> nodeStack=new Stack<BiNode>();
		Stack<Integer> flagStack=new Stack<Integer>();
		
		
		nodeStack.push(root);
		flagStack.push(0);
		//System.out.println(root.data);

		
		//BiNode cur=nodeStack.peek();
		while (nodeStack.size()>0) {
		
			int flag=flagStack.peek();
			BiNode cur= nodeStack.peek();
			
					if (flag==0) {
						if (cur==null) {
							nodeStack.pop();
							flagStack.pop();
							
							int temp=flagStack.pop();
							flagStack.push(temp+1);
							
							
						}else {
							System.out.println(cur.getValue());
							cur=cur.leftNode;

							nodeStack.push(cur);
							flagStack.push(0);
							
						}
					}else if (flag==1) {
											
						if (cur==null) {
							nodeStack.pop();
							flagStack.pop();
							
							int temp=flagStack.pop();
							flagStack.push(temp+1);
							
						}else {
							cur=cur.rightNode;
							nodeStack.push(cur);
							flagStack.push(0);
						}
						
					}else if (flag==2) {
						nodeStack.pop();
						flagStack.pop();
						if (flagStack.size()>0) {
							int temp=flagStack.pop();
							flagStack.push(temp+1);
						}
						
						
					}
					
			
		}
		
	}
	
	public static void xianxuTraverse_FeiDiGui(BiNode root) {
		if (root==null) {
			return;
		}
		Stack<BiNode> stack=new Stack<BiNode>();
		BiNode cur=root;
		
		while (cur!=null||stack.size()>0) {
		
			while (cur!=null) {
				System.out.println(cur.getValue());
				stack.push(cur);
				cur=cur.leftNode;
			}
			if (cur==null) {			
					cur=stack.pop();
					cur=cur.rightNode;
					stack.push(cur);
			}
		}
		
	}
	
	public static void cengciTraverse(BiNode root) {
		if (root==null) {
			return;
		}
		Queue<BiNode> queue=new LinkedList<BiNode>();
		BiNode cur=root;
		queue.offer(root);
		while (queue.size()>0) {
		
			BiNode head=queue.poll();
			System.out.println(head.getValue());
			if (head.leftNode!=null) {
				queue.offer(head.leftNode);
			}
			if (head.rightNode!=null) {
				queue.offer(head.rightNode);
			}
		}
		
	}
	
	//http://m.blog.csdn.net/article/details?id=51076268
	public static void kuandu_xianxuTraverse(BiNode root,int cengShu,int[] arr) {
		if (root==null) {
			return;
		}

		arr[cengShu]=arr[cengShu]+1;
		
		kuandu_xianxuTraverse(root.leftNode, cengShu+1, arr);

		kuandu_xianxuTraverse(root.rightNode, cengShu+1, arr);
		
	}

}
