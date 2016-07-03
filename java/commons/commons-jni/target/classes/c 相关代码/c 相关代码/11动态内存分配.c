/*
# include <malloc.h>  //不能省  malloc 是 memory(内存) allocate(分配)的缩写  malloc()
*/

#include <stdio.h>
#include <malloc.h>

main(){
       
       //int i = 5;//静态申请变量  在栈空间里创建的
       
       //malloc();// 动态申请变量（一块连续空间） 在堆空间里创建的  
       //参数： 指定申请的空间大小（字节）
       // 返回值 ： 返回申请空间的首地址 (Void*类型)
       
       int* p = (int*) malloc(sizeof( int )); //malloc()的返回值为Void*类型，会根据不同的指针变量而转换类型，不需要强制转换 
       
       *p = 99;
       
       free(p);//释放空间   
       
       printf("动态申请空间里的数据是 %d\n", *p);
       

       
       
       system("pause");       
}
