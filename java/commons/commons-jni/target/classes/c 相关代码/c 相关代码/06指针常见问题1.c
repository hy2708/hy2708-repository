/*
  1、 不同类型的指针  不能够相互转换  一种类型的指针  指向对应的数据类型 

*/

#include <stdio.h>

main(){
       
       double d = 3.1415926;
       
       int* p;
       
       p = &d;
       
       printf("通过指针p 打印出double d的值 : %d\n" , *p);
       
       system("pause"); 
}  "V    ( fact       data    
