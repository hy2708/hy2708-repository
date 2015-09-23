#include <stdio.h>

main(){
       
       struct date { 
              int year;
              int month;
              int day; 
       }today; 
       
       
       
       //特点：  所有的变量 共用同一块内存空间（同一个地址）    
                 //长度：  成员变量中 占用字节数最大的 为 当前联合体的长度     
       union { 
             double i; //8
             int k;  //8
             char ii;//8 
       } mix;
       
       
       
       mix.k = 1000;
       mix.i = 33;
       mix.ii = 'A';
       
       /*
       给变量赋新值后，旧值被冲去，此处过程为：
       将1000--> k
       将33-->i，冲去1000，i=33； 
        将A-->ii，冲去33， 
       */
       
       printf("int k = %d \n", mix.k);//100
       printf("long i = %lf \n", mix.i);//33333
       printf("char ii = %c \n", mix.ii);//A   
       
       
       printf("联合体的长度为 : %d\n", sizeof(mix));
                 
       system("pause");
}
