#include <stdio.h>
#include <malloc.h>

void f(int** q){// 用来接收int*数据类型变量的地址  2级指针 
     //q  代表的  p的地址        
     //*q  = p        
     //int i = 3;    
     
     int* point = (int*) malloc(sizeof(int) * 2);
     
     *point = 99;
     *(point+1) = 200;
      
     
     printf("f() point 的地址 %#x\n", point);
     
     *q  = point;
     
     
     free(point);
}


main(){
       
       int* p; //用来指向f()--> i的地址 
       
       
       f(&p);
       
       printf("main()---point 的地址 %#x\n", p);
       
       printf("通过指针p将 f() 中 i的值 打印 : %d\n", *p);
       
       //严重问题  逻辑性错误  内存映像 
       printf("通过指针p+1将 f() 中 i的值 打印 : %d\n", *(p+1));
       
       
       system("pause"); 
}
       
       
       
