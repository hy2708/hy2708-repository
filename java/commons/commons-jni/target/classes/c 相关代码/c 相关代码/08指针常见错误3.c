/*
  3�� �����ı��� ���ܹ��纯�����з���  

*/

#include <stdio.h>

void f(int** q){// ��������int*�������ͱ����ĵ�ַ  2��ָ�� 
     //q  �����  p�ĵ�ַ        
     //*q  = p        
     int i = 3;     
     
     printf("f() i �ĵ�ַ %#x\n", &i);
     
     *q  = &i;
     
}


main(){
       
       int* p; //����ָ��f()--> i�ĵ�ַ 
       
       
       f(&p);
       
       printf("main()---p �ĵ�ַ %#x\n", p);
       
       printf("ͨ��ָ��p�� f() �� i��ֵ ��ӡ : %d\n", *p);
       
       
       system("pause"); 
}
       
       
       
