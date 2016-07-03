package com.hy.commons.algorithm.zuochengyun;

//如何实现顺时针旋转矩阵？
public class Lession1_JuZhenShunShiZhenXuanZhuan {

	public static void main(String[] args) {
		int[][] arr =new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int hang=arr.length;
		int lie=arr[0].length;
		int i=0;
		int j=lie-1;
		while (i<=j) {
			xuanZhuanYiQuan(arr, i, i, j, j);
			i++;
			j--;
		}
	}
	
	public static void xuanZhuanYiQuan(int[][] arr,int leftTopHangIndex,int leftTopLieIndex,int rightButtonHangIndex,int rightButtonLieIndex) {
		int _2hang=leftTopHangIndex;
				int _2lie=rightButtonLieIndex;
				int _4hang=rightButtonHangIndex;
				int _4lie=leftTopLieIndex;
				
				int _2Value =arr[_2hang][_2lie];
				arr[_2hang][_2lie]=arr[leftTopHangIndex][leftTopLieIndex];
				

				int _3Value =arr[rightButtonHangIndex][rightButtonLieIndex];
				arr[rightButtonHangIndex][rightButtonLieIndex]=_2Value;
				
				int _4Value =arr[_4hang][_4lie];
				arr[_4hang][_4lie]=_3Value;
				
				arr[leftTopHangIndex][leftTopLieIndex]=_4Value;

	}
}
