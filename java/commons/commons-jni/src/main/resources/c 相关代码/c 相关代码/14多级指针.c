#include<stdio.h>

main(){
       int i = 5;
       int* p;
       int** p2;
       int*** p3;
       int**** p4;
       
       p = &i;
       p2 = &p;
       p3 = &p2;
       p4 = &p3;
       
       //ͨ��p4 ��ӡ��i ��ֵ 
       
       printf("ͨ��p4 ��ӡ��i ��ֵ  :  %d\n", ****p4); 
       
       
       
       system("pause");       
}

