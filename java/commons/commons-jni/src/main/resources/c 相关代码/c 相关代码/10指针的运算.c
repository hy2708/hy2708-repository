#include <stdio.h>

main(){
       
      //int i = 5;// �廪���� ��1 3��  ��3ѧ�� 
      //int j = 3;// �˴��� ��2  13�� ����ѧ�� 
       
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
       
       printf("����֮��ľ����� %d\n", q-p);
       
       
       int intArr[] = {1,2,3,4,5};
       
       int* p1;
       int* q1;
       
       p1 = &intArr[2];
       q1 = &intArr[4];
       
       printf("����֮��ľ����� %d\n", q1-p1);

       
       system("pause"); 
}
