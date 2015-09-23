#include <stdio.h>

void swap(int p, int q){ // p ==== i    q==== j 
     int temp;
     temp = p;
     p = q;
     q = temp;     
}

void swap2(int* p, int* q){  //p 存放i的地址   q存放j的地址 
     int temp;
     temp = *p;
     *p = *q;
     *q = temp;  
} 



main(){
       
       int i = 5;
       int j = 3;
       
       swap2(&i ,&j);
       
       printf("i = %d\n", i);
       printf("j = %d\n", j);
       
       
       system("pause"); 
}
