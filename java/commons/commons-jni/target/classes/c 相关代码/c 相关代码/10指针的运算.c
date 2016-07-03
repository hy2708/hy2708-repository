#include <stdio.h>

main(){
       
      //int i = 5;// 清华附中 初1 3班  张3学号 
      //int j = 3;// 人大附中 初2  13班 李四学号 
       
       //int* p,q;
       
       //p = &i;
       //q = &j;
       
       //q-p
       
       
       char arr[] = {'1','2','3','4','5'};
       
       char* p;
       char* q;
       
       //p = arr+2;
       p = &arr[2];
       q = &arr[4];
       
       printf("两者之间的距离是 %d\n", q-p);
       
       
       int intArr[] = {1,2,3,4,5};
       
       int* p1;
       int* q1;
       
       p1 = &intArr[2];
       q1 = &intArr[4];
       
       printf("两者之间的距离是 %d\n", q1-p1);

       
       system("pause"); 
}
