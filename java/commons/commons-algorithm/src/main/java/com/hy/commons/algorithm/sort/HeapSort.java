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
		}

		private static void maxHeap(int[] array, int heapSize, int index) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;

			int largest = index;
			if (left < heapSize && array[left] > array[index]) {
				largest = left;
			}

			if (right < heapSize && array[right] > array[largest]) {
				largest = right;
			}

			if (index != largest) {
				ArrayUtils.exchangeElements(array, index, largest);

				maxHeap(array, heapSize, largest);
			}
		}
	}