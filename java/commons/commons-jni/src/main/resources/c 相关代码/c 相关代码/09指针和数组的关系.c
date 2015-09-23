#include <stdio.h>

//打印数组 
void printArr(char* arr, int len){
     int i;
     // c99 模式下 for循环中 不可以实现变量的声明  
     for(i = 0; i < len; i++){
             printf("arr[ %d ]= %c \n", i, *(arr+i) );        
     }
}

main(){
       char arr[] = {'h','e','l','l','o'};
       //char* arr = "hello";
       
       printf("arr[0] = %#x\n", &arr[0]);
       printf("arr[1] = %#x\n", &arr[1]);
       printf("arr[2] = %#x\n", &arr[2]);
       
       //数组的名字 就是数组的第一个元素的地址 （数组的首地址） 
       printf("打印arr数组的名称 %#x\n", arr);
       
       //打印数组 
       printArr(arr, 5);
       
       //c语言 不去检查 数组角标是否越界   
       //printf("arr[5] = %c\n", arr[5]);
       
       system("pause"); 
}
