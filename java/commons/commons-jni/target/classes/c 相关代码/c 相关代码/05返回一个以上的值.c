#include <stdio.h>

void f(int* p, int* q){
     *p = 99;
     *q = 200;     
}

main(){
       
       int i = 5;
       int j = 4;
       
       
       f(&i , &j);
       
       printf("i = %d\n", i);
       printf("j = %d\n", j);
       
       system("pause"); 
}
