package com.hy.commons.algorithm.sort;
public class HeapSort {
		public static void main(String[] args) {
			int[] array = { 49, 38, 65, 97, 76, 13, 27, 50 };

			System.out.println("Before heap:");
			ArrayUtils.printArray(array);

			heapSort(array);

			System.out.println("After heap sort:");
			ArrayUtils.printArray(array);
		}

		public static void heapSort(int[] array) {
			if (array == null || array.length <= 1) {
				return;
			}

			buildMaxHeap(array);

			for (int i = array.length - 1; i >= 1; i--) {
				ArrayUtils.exchangeElements(array, 0, i);

				maxHeap(array, i, 0);
			}
		}

		private static void buildMaxHeap(int[] array) {
			

			int half = array.length / 2;
			for (int i = half; i >= 0; i--) {
				maxHeap(array, array.length, i);
			}
			System.out.println("构建的大根堆");
			ArrayUtils.printArray(array);

		}

		//时间复杂度 3*logN，即log
		private static void maxHeap(int[] array, int heapSize, int index) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;

			int largest = index;
			if (left < heapSize && array[left] > array[index]) {//在左右孩子中找最da的
				largest = left;
			}

			if (right < heapSize && array[right] > array[largest]) {//在左右孩子中找最da的
				largest = right;
			}

			if (index != largest) {
				ArrayUtils.exchangeElements(array, index, largest);

				maxHeap(array, heapSize, largest);//调整左字树或者右字树的堆
			}
		}
		
	//  从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
		void MinHeapFixdown(int a[], int i, int n)
		{
		    int j, temp;

			temp = a[i];
			j = 2 * i + 1;
			while (j < n)
			{
				if (j + 1 < n && a[j + 1] < a[j]) //在左右孩子中找最小的
					j++;

				if (a[j] >= temp)
					break;

				a[i] = a[j];     //把较小的子结点往上移动,替换它的父结点
				i = j;
				j = 2 * i + 1;
			}
			a[i] = temp;
		}
		//在最小堆中删除数
		/*void MinHeapDeleteNumber(int a[], int n)
		{
			Swap(a[0], a[n - 1]);
			MinHeapFixdown(a, 0, n - 1);
		}*/
	}