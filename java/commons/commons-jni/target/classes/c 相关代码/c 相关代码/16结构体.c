#include <stdio.h>
#include <stdlib.h>

int _getAge(int i){
		return i;
	}
	
struct Student
{
	int age;    //4
	float score;//4
	char sex;   //1 --> 4

	int (*getAge)(int i);	
	
};

////////////////////////////////////////////////////
typedef struct Student* OStudent;
//////////////////////////////////////////////////////////
main(){
       
       struct Student stu = {20, 95.0f, 'f'};
       
       stu.age = 21;
       stu.score = 88.0f;
       
       stu.getAge = _getAge;
       printf("stu.age = %d\n", stu.getAge(0));
       printf("stu.score = %f\n", stu.score);
       printf("stu.sex = %c\n", stu.sex);       
       
       printf("struct Student ³¤¶ÈÎª%d\n", sizeof(stu));
       
       
       OStudent ps = &stu;
       printf("Ostu.score = %f\n", (*ps).score);
	   printf("Ostu.score = %f\n", ps->score);
       
	   struct Student* p_stu = &stu;
	   printf("p_stu.score = %f\n", (*p_stu).score);
	   system("pause");       
}
