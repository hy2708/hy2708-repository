package com.hy.commons.algorithm.tu;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {

	// 存储节点信息
	private Object[] vertices;
	// 存储边的信息数组
	private int[][] arcs;
	// 边的条数
	private int vexnum;
	// 记录第i个节点是否被访问过
	private boolean[] visited;

	// 图的初始化
	public DFS(int n) {
		// TODO Auto-generated constructor stub
		vexnum = n;
		vertices = new Object[n];
		arcs = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < vexnum; i++) {
			for (int j = 0; j < vexnum; j++) {
				arcs[i][j] = 0;
			}
		}

	}

	/**
	 * @param args
	 * 
	 * @author TD_LSW
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 构建图
		DFS g = new DFS(8);
		Character[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		g.setVerteies(vertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		g.addEdge(2, 6);
		g.addEdge(2, 7);
		for (int i = 0; i < g.arcs.length; i++) {
			for (int j = 0; j < g.arcs[0].length; j++) {
				System.out.print(g.arcs[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("深度优先遍历的递归实现：");
		g.dfs();
		System.out.println();

		System.out.println("深度优先遍历的非递归实现：");
		g.redfs();
		System.out.println();

	}

	/**
	 * 深度优先遍历的非递归实现
	 */
	private void redfs() {
		// 初始化节点遍历的数组
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		// 定义存储遍历节点的栈
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				// 未访问的节点入栈
				s.add(i);
				visited[i] = true;
				while (!s.isEmpty()) {
					// 出栈
					int j = s.pop();
					System.out.print(vertices[j] + " ");
					for (int k = this.lastAdjVex(j); k >= 0; k = this.lastAdjVex(j, k)) {
						if (!visited[k])
							s.add(k);
						visited[k] = true;
					}
					
				}
			}
		}

	}

	private List<Integer> getAdjVertexes(int i) {
		List<Integer> integers=new LinkedList<Integer>();
		//for (int j = 0; j < arcs.length; j++) {
			for (int j2 = 0; j2 < arcs[0].length; j2++) {
				if (arcs[i][j2]!=0) {
					integers.add(j2);
				}
			}
		//}
		return integers;
	}

	// 往前查找为1的节点
	private int lastAdjVex(int i, int k) {
		// TODO Auto-generated method stub
		for (int j = k - 1; j >= 0; j--) {
			if (arcs[i][j] > 0)
				return j;
		}
		return -1;
	}

	// 最深的节点
	private int lastAdjVex(int i) {
		// TODO Auto-generated method stub
		for (int j = vexnum - 1; j >= 0; j--) {
			if (arcs[i][j] > 0)
				return j;
		}
		return -1;
	}

	/**
	 * 深度优先遍历的递归实现
	 */
	private void dfs() {
		// TODO Auto-generated method stub
		// 初始化
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		// 递归实现
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i])
				_dfs(i);
		}

	}

	// 遍历节点
	private void _dfs(int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		System.out.print(vertices[i]+"("+
				i+ ")" + " ");
//		for (int j = this.firstAdjVex(i); j >= 0; j = this.nextAdjVex(i, j)) {
//			if (!visited[j])
//				this._dfs(j);
//		}
		List<Integer> adjVertexesIndex=getAdjVertexes(i);
		for (Integer integer : adjVertexesIndex) {
			if (!visited[integer]) {
				_dfs(integer);
			}
		}
	}

	private int nextAdjVex(int i, int k) {
		// TODO Auto-generated method stub
		for (int j = k + 1; j < vexnum; j++) {
			if (arcs[i][j] > 0)
				return j;
		}
		return -1;
	}

	// 依次查找下一个
	private int firstAdjVex(int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < vexnum; j++) {
			if (arcs[i][j] > 0)
				return j;
		}
		return -1;
	}

	// 边初始化
	private void addEdge(int i, int j) {
		// TODO Auto-generated method stub
		if (i == j)
			return;
		arcs[i][j] = 1;
		arcs[j][i] = 1;
	}

	// 节点初始化
	private void setVerteies(Object[] obj) {
		// TODO Auto-generated method stub
		this.vertices = obj;
	}

}