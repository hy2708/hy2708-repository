/*
%d  -  int
%ld �C long int
%c  - char
%f -  float
%lf �C double
%x �C ʮ��������� int ����long int ����short int
%#x �C ��0x��ͷ  ʮ��������� int ����long int ����short int
%o -  �˽������
%s �C �ַ���

Int len;
Scanf(��%d��,&len);
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
       
       
       printf("8���� int i = %o \n", i);
       printf("16���� int i = %#x \n", i);
       
       // ���뺯�� 
       
       //c��������һ���ַ���
        char cc[20] ;
        
        //scanf(); ���뺯��
        // ����1�� ָ��������������� 
        // ����2�� ��ŵ�λ��  
        scanf("%s",cc);
        printf("�������%s \n",cc);
        
        

       system("pause"); 
}
