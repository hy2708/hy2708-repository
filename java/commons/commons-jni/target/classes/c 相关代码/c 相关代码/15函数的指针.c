/*
1.定义int　(*pf)(int x,　int y);
2.赋值 pf = add;
3.引用 pf(3,5);

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
       
       pf = add; //相当于数组的名称 
       
       int result = pf(10,20);//此处可以看出使用指针调用函数和使用指针调用数组类似 
       
       printf("两个数相加的结果是 %d\n", result);
       //add(10,20);
       
       //int i = 5;
       //int* p ;
       //p = &i;

       system("pause");       
}
