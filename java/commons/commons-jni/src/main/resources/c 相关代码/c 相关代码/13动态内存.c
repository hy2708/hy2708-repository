/*
  1、创建数组
  2、赋值
  3、打印 

*/


#include <stdio.h>
#include <malloc.h>

//打印数组 
void printArr(int* arr, int len){
     printf("数组的元素值为：\n");
     
     int i = 0;
     for( ; i < len; i++){
          
          printf("arr[%d]= %d\n", i, *(arr+i));     
     }
}

main(){
       
       //提示用户 ，输入数组大小
       printf(" 请输入数组大小 :\n");
       int len;
       scanf("%d", &len);
       
       //根据用户输入的大小  动态创建数组
       int* arr = (int*) malloc(sizeof(int)  *  len);
       
       
       //提示用户 输入数据
        printf(" 请为数组每个元素赋值 :\n");
        
       //赋值
       int i = 0;
       for( ; i < len; i++){
            int temp;
            scanf("%d", &temp);
                 
            *(arr+i) = temp;  
       }
        
       //打印
       printArr(arr, len); 
       
       
       //---------------------------------
       
       
       printf("请输入新元素的个数：");
       int count;
       scanf("%d", &count);
       
       //调整数组的大小
       //参数1： 指定所要修改的数组
       //参数2： 修改后的大小 
       //返回值： 数组的首地址 
       arr = (int*) realloc(arr, len + count);
       
       printf("请为新增加的元素赋值:\n");
       
       int j = len;
       for( ; j< len+ count; j++){,
            int temp;
            scanf("%d", &temp);
                 
            *(arr+j) = temp;
       }
         
       //打印
       printArr(arr, len + count); 
        
       
       
       system("pause");       
}
