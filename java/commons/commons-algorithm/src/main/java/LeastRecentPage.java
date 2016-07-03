// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.*;
public class LeastRecentPage
{
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static int lruCountMiss(int max_cache_size, int[] pages)
  {
    //int[] caches=new int[max_cache_size];
    List<Integer> list= new ArrayList<Integer>();
    int count=0;
    
    for(int i=0;i<pages.length;i++){
        int val =pages[i];    
        if(list.size() < max_cache_size){
            list.add(val);
            count++;
        }else{
            Boolean exist=false;
            int existIndex=-1;
            for(int j=0;j<max_cache_size;j++){
                if(list.get(j)==val){
                exist=true;
                existIndex=j;
                
                }
                
            }
            if(exist){
                /*int temp =list.get(max_cache_size-1);
                list.set(max_cache_size-1, list.get(existIndex) );
                list.set(existIndex, temp );*/
            	int temp =list.remove(existIndex);
                list.add(temp);

            }else{
                list.remove(0);
                list.add(val);
                count++;
            }
            
        }
    }

    return count;
  }
  
  public static void main(String[] args) {
	//int t =lruCountMiss(2, new int[]{2,3,1,3,2,1,4,3,2});
	int t =lruCountMiss(3, new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0});
	System.out.println(t);
  }
  // METHOD SIGNATURE ENDS
}