/*
  1����������
  2����ֵ
  3����ӡ 

*/


#include <stdio.h>
#include <malloc.h>

//��ӡ���� 
void printArr(int* arr, int len){
     printf("�����Ԫ��ֵΪ��\n");
     
     int i = 0;
     for( ; i < len; i++){
          
          printf("arr[%d]= %d\n", i, *(arr+i));     
     }
}

main(){
       
       //��ʾ�û� �����������С
       printf(" �����������С :\n");
       int len;
       scanf("%d", &len);
       
       //�����û�����Ĵ�С  ��̬��������
       int* arr = (int*) malloc(sizeof(int)  *  len);
       
       
       //��ʾ�û� ��������
        printf(" ��Ϊ����ÿ��Ԫ�ظ�ֵ :\n");
        
       //��ֵ
       int i = 0;
       for( ; i < len; i++){
            int temp;
            scanf("%d", &temp);
                 
            *(arr+i) = temp;  
       }
        
       //��ӡ
       printArr(arr, len); 
       
       
       //---------------------------------
       
       
       printf("��������Ԫ�صĸ�����");
       int count;
       scanf("%d", &count);
       
       //��������Ĵ�С
       //����1�� ָ����Ҫ�޸ĵ�����
       //����2�� �޸ĺ�Ĵ�С 
       //����ֵ�� ������׵�ַ 
       arr = (int*) realloc(arr, len + count);
       
       printf("��Ϊ�����ӵ�Ԫ�ظ�ֵ:\n");
       
       int j = len;
       for( ; j< len+ count; j++){,
            int temp;
            scanf("%d", &temp);
                 
            *(arr+j) = temp;
       }
         
       //��ӡ
       printArr(arr, len + count); 
        
       
       
       system("pause");       
}
