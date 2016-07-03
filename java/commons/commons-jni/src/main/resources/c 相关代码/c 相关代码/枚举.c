#include <stdio.h>

main(){
       
       enum WeekDay
        {
            Monday = 1,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
        };
       
       enum WeekDay day = Sunday;
       
       printf("day = %d \n", day);
       
       
       system("pause");       
}
