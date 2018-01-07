package com.hy.commons.algorithm.list;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

/*
 在第i个位置插入元素x
 方法：
 如果i=0，那么。。。
 如果i>0，找到第i-1个位置
 */
public class LisNodeOp {
	
	public static void main(String[] args) {
		
		List xx;
		StringBuffer xxx;
		xxx.insert
		ListNode node=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node5=new ListNode(5);
		ListNode node7=new ListNode(7);
		node.next=node2;
		node2.next=node3;
		node3.next=node5;
		node5.next=node7;
		
		ListNode mid =findMid(node);
		System.out.println("===============");
		System.out.println(mid.getData());
		
		ListNode nn0=insertListByIndex(node, 3, 7);
		ListNode nn1=insertListByIndex(node, 6, 7);
		ListNode nn=insertListByIndex(node, 0, 7);
		printList(nn);
		ListNode nodexx=daozheFind(nn, 5);
		System.out.println("===============");
		System.out.println(nodexx.getData());
		
		ListNode re =reverse(nn);
		printList(re);
		qiChong(nn);
		printList(nn);
		
	}
	
	public static void printList(ListNode nn) {
		System.out.println("================");
		while (nn!=null) {
			System.out.println(nn.getData());
			nn=nn.next;
		}
	}
		public static ListNode findMid(ListNode list) {
			ListNode kuai=list;
			ListNode man=list;
			while (kuai!=null&&kuai.next!=null&&kuai.next.next!=null) {
				kuai=kuai.next.next;
				man=man.next;
			}
			return man;
		}
			public static ListNode reverse(ListNode list) {
			ListNode head= new ListNode(null);
			head.next=null;
			ListNode cur = list;
			while (cur!=null) {
				ListNode cur_next=cur.next;
				
				/**
				 * 把cur头插入head链表
				 */
				cur.next=head.next;
				head.next=cur;
				
				
				cur=cur_next;
			}
			return head.next;
		}
			public static ListNode daozheFind(ListNode list,int xuhao) {
			if (xuhao<1) {
				return null;
			}
			ListNode hou=null;
			ListNode head = new ListNode(null);
			head.next=list;
			ListNode qian=list;
			for(int i=0;i<xuhao-1;i++){
				if (qian!=null) {
					qian=qian.next;
				}else {
					return null;
				}
			}
			hou=head;
			while (qian!=null) {
				hou=hou.next;
				qian=qian.next;
			}
			
			return hou;
		}
			public static void qiChong2(ListNode list) {
			ListNode cur = list;
			while (cur!=null) {
				ListNode temp =list;
				ListNode pretemp =null;
				while (temp!=null&&temp!=cur) {
					if (temp.getData()==cur.getData()) {
						temp=temp.next;
						pretemp.next=temp;
						break;
					}else {
						pretemp=temp;
						temp=temp.next;
					}
				}
				cur=cur.next;
			}
		}
	public static ListNode qiChong(ListNode list) {
		ListNode cur = list;
		ListNode pre = null;
		Set<Object> set =new HashSet<Object>();
		
		while (cur!=null) {
			if (set.contains(cur.getData())) {
			cur=cur.next;
			pre.next=cur;
			}else {
				set.add(cur.getData());
				pre=cur;
				cur=cur.next;
			}
		}
		return list;
	}
		public static ListNode insertListByIndex(ListNode list,int index,Object data) {
		LinkedList linkedList;
		
		if (index==0) {
			ListNode node=new ListNode(data);
			node.next=list;
			return node;
		}else {
			int pre=index-1;
			ListNode cur=null;
			ListNode head=new ListNode(null);
			head.next=list;
			cur=head;
			for (int i = 0; i <= pre; i++) {
				cur=cur.next;
			}
			
			//insert
			ListNode target=new ListNode(data);
			target.next=cur.next;
			cur.next=target;
			
			return list;
		}
	}

}
