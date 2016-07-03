/*
C的基本数据类型,

char, int, float, double, signed, unsigned, long, short and void


c中char 占用1个字节       java中char 占用2个字节

c中long 占用4个字节       java中long 占用8个字节

java中boolean 在c中 int flag = 0,1 

 
java中byte 在c中  char 表示

java中String  在c中  1、char[] 表示                     char[] arr = {'b','o','y'};     char[] arr = "boy";
                     2、 通过指针表示 String类型                                        char* arr = "boy";

*/

#include <stdio.h>

main(){
       //sql ？  
       
       //sizeof() 得到指定数据类型的长度（字节）
       // 参数： 指定的数据类型 
       
       printf("char 数据类型占用的字节数 ：%d \n", sizeof(char));
       printf("int 数据类型占用的字节数 ：%d \n", sizeof(int));
       printf("float 数据类型占用的字节数 ：%d \n", sizeof(float));
       printf("double 数据类型占用的字节数 ：%d \n", sizeof(double));
       printf("long 数据类型占用的字节数 ：%d \n", sizeof(long));
       printf("short 数据类型占用的字节数 ：%d \n", sizeof(short));
       
       
       //signed, unsigned 修饰类型  float double不可以修饰 
        printf("signed int 数据类型占用的字节数 ：%d \n", sizeof(signed int));
        printf("unsigned int 数据类型占用的字节数 ：%d \n", sizeof(unsigned int));
        
       
       
       system("pause");       
}
