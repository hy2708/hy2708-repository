/*
  3、 函数的变量 不能够跨函数进行访问  

*/

#include <stdio.h>

void f(int** q){// 用来接收int*数据类型变量的地址  2级指针 
     //q  代表的  p的地址        
     //*q  = p        
     int i = 3;     
     
     printf("f() i 的地址 %#x\n", &i);
     
     *q  = &i;
     
}


main(){
       
       int* p; //用来指向f()--> i的地址 
       
       
       f(&p);
       
       printf("main()---p 的地址 %#x\n", p);
       
       printf("通过指针p将 f() 中 i的值 打印 : %d\n", *p);
       
       
       system("pause"); 
}
       
       
       
