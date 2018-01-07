import java.util.List;

import com.hy.commons.algorithm.sort.AbstractSort;

public class DanDiaoDiZengZiXuLie_Me extends AbstractSort{

	public static void main(String[] args) {
		int[] arr=new int[]{2,1,5,3,6,4,8,9,7};
		int[] x=new DanDiaoDiZengZiXuLie_Me().lis1(arr);
		printSortReslut(x);
	}

	public int[] getZiXuLie(int[] arr) {
		int[] dp=getZiXuLieLength(arr);
		int[] ret =getLongestZiXuLie(dp);
		return ret;
	}

	private int[] getLongestZiXuLie(int[] dp) {
		int xuLieLength=0;
		int xuLieIndex=0;
		for (int i = 0; i < dp.length; i++) {
			if (xuLieLength< dp[i]) {
				
				xuLieLength=dp[i];
				xuLieIndex=i;
			}
		}
		int[] arr=new int[dp.length];
		List<Integer> ret;
		ret.ad
		for (int i = xuLieIndex; i >=0; i--) {
			if (arr[i]<arr[xuLieIndex]&&dp[i]+1==dp[xuLieIndex]) {
				xuLieIndex=i;
				ret[]=arr[i];
				
				
			}
		}
		

		return null;
	}

	private int[] getZiXuLieLength(int[] arr) {
		int[] dp=new int[arr.length];
		for (int i = 0; i <arr.length ; i++) {
			dp[i]=1;
			for (int j = 0; j < i; j++) {
				if (arr[j]<arr[i]) {
					dp[i]=Math.max(dp[j]+1, dp[i]);
					
				}
			}
			
		}
		return dp;
	}

	
}
