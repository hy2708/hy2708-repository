#include <stdio.h>

main(){
       
       struct date { 
              int year;
              int month;
              int day; 
       }today; 
       
       
       
       //�ص㣺  ���еı��� ����ͬһ���ڴ�ռ䣨ͬһ����ַ��    
                 //���ȣ�  ��Ա������ ռ���ֽ������� Ϊ ��ǰ������ĳ���     
       union { 
             double i; //8
             int k;  //8
             char ii;//8 
       } mix;
       
       
       
       mix.k = 1000;
       mix.i = 33;
       mix.ii = 'A';
       
       /*
       ����������ֵ�󣬾�ֵ����ȥ���˴�����Ϊ��
       ��1000--> k
       ��33-->i����ȥ1000��i=33�� 
        ��A-->ii����ȥ33�� 
       */
       
       printf("int k = %d \n", mix.k);//100
       printf("long i = %lf \n", mix.i);//33333
       printf("char ii = %c \n", mix.ii);//A   
       
       
       printf("������ĳ���Ϊ : %d\n", sizeof(mix));
                 
       system("pause");
}
