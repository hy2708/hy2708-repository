/*
C�Ļ�����������,

char, int, float, double, signed, unsigned, long, short and void


c��char ռ��1���ֽ�       java��char ռ��2���ֽ�

c��long ռ��4���ֽ�       java��long ռ��8���ֽ�

java��boolean ��c�� int flag = 0,1 

 
java��byte ��c��  char ��ʾ

java��String  ��c��  1��char[] ��ʾ                     char[] arr = {'b','o','y'};     char[] arr = "boy";
                     2�� ͨ��ָ���ʾ String����                                        char* arr = "boy";

*/

#include <stdio.h>

main(){
       //sql ��  
       
       //sizeof() �õ�ָ���������͵ĳ��ȣ��ֽڣ�
       // ������ ָ������������ 
       
       printf("char ��������ռ�õ��ֽ��� ��%d \n", sizeof(char));
       printf("int ��������ռ�õ��ֽ��� ��%d \n", sizeof(int));
       printf("float ��������ռ�õ��ֽ��� ��%d \n", sizeof(float));
       printf("double ��������ռ�õ��ֽ��� ��%d \n", sizeof(double));
       printf("long ��������ռ�õ��ֽ��� ��%d \n", sizeof(long));
       printf("short ��������ռ�õ��ֽ��� ��%d \n", sizeof(short));
       
       
       //signed, unsigned ��������  float double���������� 
        printf("signed int ��������ռ�õ��ֽ��� ��%d \n", sizeof(signed int));
        printf("unsigned int ��������ռ�õ��ֽ��� ��%d \n", sizeof(unsigned int));
        
       
       
       system("pause");       
}
