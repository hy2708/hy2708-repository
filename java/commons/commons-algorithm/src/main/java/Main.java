
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n;//个数
			int cardW;
			int cardH;
			n = sc.nextInt();
			cardW = sc.nextInt();
			cardH = sc.nextInt();
			int[] min=new int[n];//代表宽度
			int[] max=new int[n];//代表高度
			int[] addtion=new int[n];
			for (int i = 0; i < n; i++) {

				min[i]=sc.nextInt();;
				max[i]=sc.nextInt();;
				

			}
			//是否合格
			int minSum=0;
			int maxSum=0;
			Boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (cardW<min[i]&&cardW<max[i]) {
					flag=true;
				}
				//minSum=minSum+min[i];
				//maxSum=maxSum+max[i];
			}
			if (!flag) {
				System.out.println("0");
			}else {
				int currentW=cardW;
				int currentH=cardH;
				StringBuilder sb = new StringBuilder("");
				List<Integer> leftXinfengNo = new LinkedList<Integer>();
				List<String> set = new LinkedList<String>();

				for (int i = 0; i < max.length; i++) {
					/*if (cardW<min[i]&&cardW<max[i]) {
						currentW=min[i];
						currentH=max[i];
					}*/
					leftXinfengNo.add(i,i);
				}
				compute(currentW,currentH,min,max,leftXinfengNo,"",set);

				String s ="";
				for (int i = 0; i < set.size(); i++) {
					/*if (cardW<min[i]&&cardW<max[i]) {
						currentW=min[i];
						currentH=max[i];
					}*/
					if (set.get(i).length()>s.length()) {
						s=set.get(i);
					}
				}
				System.out.println(s);
			}			
		}


	}
	
	public static void compute(int currentW,int currentH, int[] min,int[] max,List<Integer> leftXinfengNo,String xuhao,List<String> set ) {
		if (leftXinfengNo.size()==0) {
			set.add(xuhao);
			return;
		}
		for (int i = 0; i < leftXinfengNo.size(); i++) {
			if (currentW<min[leftXinfengNo.get(i)]&&currentH<max[leftXinfengNo.get(i)]) {
				currentW=min[leftXinfengNo.get(i)];
				currentH=max[leftXinfengNo.get(i)];
				
				List<Integer> newList = new LinkedList<Integer>();
				//newList.addAll(leftXinfengNo);
				java.util.Collections.copy(newList, leftXinfengNo);
				newList.remove(i);
				compute(currentW,currentH,min,max,newList,xuhao+" "+(i+1),set);
			}
		}

	}
	

}
