/*
%d  -  int
%ld – long int
%c  - char
%f -  float
%lf – double
%x – 十六进制输出 int 或者long int 或者short int
%#x – 以0x开头  十六进制输出 int 或者long int 或者short int
%o -  八进制输出
%s – 字符串

Int len;
Scanf(“%d”,&len);
*/

#include <stdio.h>


main(){
       
       int i = 333;
       long l = 333333;
       char c = 'A';
       float f = 3.1415;
       double d = 3.1415926;
       
       printf("int i  = %d \n", i);
       printf("long l = %ld \n", l);
       printf("char c = %c \n", c);
       printf("float f = %f \n", f);
       printf("double d = %lf \n", d);
       
       
       printf("8进制 int i = %o \n", i);
       printf("16进制 int i = %#x \n", i);
       
       // 输入函数 
       
       //c语言输入一个字符串
        char cc[20] ;
        
        //scanf(); 输入函数
        // 参数1： 指定输入的数据类型 
        // 参数2： 存放的位置  
        scanf("%s",cc);
        printf("输入的是%s \n",cc);
        
        

       system("pause"); 
}
