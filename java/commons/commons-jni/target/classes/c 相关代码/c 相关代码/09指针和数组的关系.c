#include <stdio.h>

//��ӡ���� 
void printArr(char* arr, int len){
     int i;
     // c99 ģʽ�� forѭ���� ������ʵ�ֱ���������  
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
       
       //��������� ��������ĵ�һ��Ԫ�صĵ�ַ ��������׵�ַ�� 
       printf("��ӡarr��������� %#x\n", arr);
       
       //��ӡ���� 
       printArr(arr, 5);
       
       //c���� ��ȥ��� ����Ǳ��Ƿ�Խ��   
       //printf("arr[5] = %c\n", arr[5]);
       
       system("pause"); 
}
