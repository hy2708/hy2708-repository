/*
# include <malloc.h>  //����ʡ  malloc �� memory(�ڴ�) allocate(����)����д  malloc()
*/

#include <stdio.h>
#include <malloc.h>

main(){
       
       //int i = 5;//��̬�������  ��ջ�ռ��ﴴ����
       
       //malloc();// ��̬���������һ�������ռ䣩 �ڶѿռ��ﴴ����  
       //������ ָ������Ŀռ��С���ֽڣ�
       // ����ֵ �� ��������ռ���׵�ַ (Void*����)
       
       int* p = (int*) malloc(sizeof( int )); //malloc()�ķ���ֵΪVoid*���ͣ�����ݲ�ͬ��ָ�������ת�����ͣ�����Ҫǿ��ת�� 
       
       *p = 99;
       
       free(p);//�ͷſռ�   
       
       printf("��̬����ռ���������� %d\n", *p);
       

       
       
       system("pause");       
}
