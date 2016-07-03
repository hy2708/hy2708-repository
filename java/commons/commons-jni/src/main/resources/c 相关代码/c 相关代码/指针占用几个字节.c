#include <stdio.h>

main(){
       
       int* p;    //4
       char* p2;  //1 4
       double* p3;//4
       float* p4;//4
       
       printf("int 数据类型的指针占用的字节数 %d\n", sizeof(p));
       printf("char 数据类型的指针占用的字节数 %d\n", sizeof(p2));
       printf("double 数据类型的指针占用的字节数 %d\n", sizeof(p3));
       printf("float 数据类型的指针占用的字节数 %d\n", sizeof(p4));
       
       
       
       
       system("pause");       
}
