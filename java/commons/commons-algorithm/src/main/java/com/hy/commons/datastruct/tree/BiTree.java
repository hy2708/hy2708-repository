package com.hy.commons.datastruct.tree;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class BiTree {

	
	
	public int heignt(BiNode root) {
		if (root==null) {
			return 0;
		}
		if (root.getLeftNode()==null&&root.getRightNode()==null) {
			return 1;
		}
		TreeSet<E>
		SortedSet<E>
		HashSet<E>
		Set<E>
		List<E>
		Collection<E>
		int fh =heignt(root.getLeftNode());
		int rh =heignt(root.getRightNode());
		
		return Math.max(fh, rh)+1;
	}
}
