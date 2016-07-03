#include <stdio.h>

main(){
       
       int i = 3; //声明了int数据类型变量  变量名 i    值3
       int* p;    //声明了int* 数据类型的变量     变量名p
                  // int* 指针类型
                  // int*  它是一个存放int数据类型变量 地址的 数据类型   只能够指向int 数据类型的变量
                  // int* p      int * p     int *p     
                  
        
       //得到变量的地址
       // &  取地址符
       p = &i;
       
       
       //通过指针p打印出 i的值
       // * 指针运算符
        
       printf("通过指针p打印出 i的值 %d \n", *p); 
       printf("通过指针p打印出 i的地址值 %d \n", p);            
       printf("打印出 i的地址值 %d \n", &i); 
                   
       
       
       
       system("pause"); 
}
