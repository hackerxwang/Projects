#include<stdio.h>

#define N 6   //��������ĿΪ5
#define W 21   //����������Ϊ20 

int B[N][W]={0};//N����ɹ�ѡ����Ʒ����Ŀ��W������ʣ��Ŀռ� 
int w[6]={0,2,3,4,5,9};//ÿ����Ʒ�Ĵ�С 
int v[6]={0,3,4,5,8,10};//ÿ����Ʒ�ļ�ֵ 

//��ѡ��Ʒ 
void select(){
	int k,c;//c����capacity������ 
	//���ö���forѭ���������Ʊ� 
	for(k=1;k<N;k++){
		for(c=1;c<W;c++){
			if(w[k]>c){
				B[k][c]=B[k-1][c];
			}
			else{
				int value1 = B[k-1][c-w[k]]+v[k];
				int value2 = B[k-1][c];
				if(value1>value2){
					B[k][c]=value1;
				}
				else{
					B[k][c]=value2;
				}
			}
		}
	}
	
}

int main(){
	select();
	printf("%d\n",B[5][20]);
	int remainspace = W-1;
	int count = 0;
	//�����ѡ�����Ʒ�б�
    for(int i=N-1; i>=1; i--)
    {
        if (remainspace >= w[i])
        {
             if ((B[i][remainspace]-B[i-1][remainspace-w[i]]==v[i]))
             {
                 printf("item %d is selected\n",i);
                 remainspace = remainspace - w[i];//�����i����Ʒ��ѡ����ô����ʣ����������ȥ��i����Ʒ������ ;
             }
        }
    }
	return 0;
}

 
