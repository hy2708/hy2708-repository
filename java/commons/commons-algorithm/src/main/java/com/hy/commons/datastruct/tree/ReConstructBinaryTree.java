package com.hy.commons.datastruct.tree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ReConstructBinaryTree {
	public BiNode reConstructBinaryTree(int[] pre, int[] in) {

		BiNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return root;
	}

	private BiNode reConstructBinaryTree(int[] pre, int startPre, int endPre, 
			int[] in, int startIn, int endIn) {

		if (startPre > endPre || startIn > endIn)
			return null;
		BiNode root = new BiNode(pre[startPre]);

		for (int i = startIn; i <= endIn; i++)
			if (in[i] == pre[startPre]) {
				root.leftNode = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn,
						in, startIn, i - 1);
				root.rightNode = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre,
						in, i + 1, endIn);
			}

		return root;
	}
}
