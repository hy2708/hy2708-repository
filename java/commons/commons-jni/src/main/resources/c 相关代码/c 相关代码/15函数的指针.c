/*
1.����int��(*pf)(int x,��int y);
2.��ֵ pf = add;
3.���� pf(3,5);

*/

#include<stdio.h>

int add(int x , int y){
        
        return x + y;    
}

/*
int remove(int x , int y){
        
        return x + y;    
}
*/

main(){
       int (*pf) (int x , int y);
       
       pf = add; //�൱����������� 
       
       int result = pf(10,20);//�˴����Կ���ʹ��ָ����ú�����ʹ��ָ������������� 
       
       printf("��������ӵĽ���� %d\n", result);
       //add(10,20);
       
       //int i = 5;
       //int* p ;
       //p = &i;

       system("pause");       
}
