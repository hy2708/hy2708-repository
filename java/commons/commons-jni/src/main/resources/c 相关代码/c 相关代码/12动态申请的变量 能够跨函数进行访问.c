#include <stdio.h>
#include <malloc.h>

void f(int** q){// ��������int*�������ͱ����ĵ�ַ  2��ָ�� 
     //q  �����  p�ĵ�ַ        
     //*q  = p        
     //int i = 3;    
     
     int* point = (int*) malloc(sizeof(int) * 2);
     
     *point = 99;
     *(point+1) = 200;
      
     
     printf("f() point �ĵ�ַ %#x\n", point);
     
     *q  = point;
     
     
     free(point);
}


main(){
       
       int* p; //����ָ��f()--> i�ĵ�ַ 
       
       
       f(&p);
       
       printf("main()---point �ĵ�ַ %#x\n", p);
       
       printf("ͨ��ָ��p�� f() �� i��ֵ ��ӡ : %d\n", *p);
       
       //��������  �߼��Դ���  �ڴ�ӳ�� 
       printf("ͨ��ָ��p+1�� f() �� i��ֵ ��ӡ : %d\n", *(p+1));
       
       
       system("pause"); 
}
       
       
       
