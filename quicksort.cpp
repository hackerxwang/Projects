#include<stdio.h>

int a[101],n;//ȫ�ֱ������Ӻ�����Ҫʹ��

void quicksort(int left,int right)//�������� 
{
	int i,j,t,temp;//temp�ǻ�׼�� 
	if(left>right)
		return;
	temp=a[left];
	i=left;
	j=right;
	while(i!=j)
	{
		while(a[j]>=temp&&i<j)//�ȴ��������� 
		{
			j--;
		}
		while(a[i]<=temp&&i<j)//���������� 
		{
			i++;
		}
		if(i<j)//�ڱ�i,jû����������������λ�� 
		{
			t=a[i];
			a[i]=a[j];
			a[j]=t;
			
		}
	}
	//��׼����λ 
	a[left]=a[i];
	a[i]=temp;
	quicksort(left,i-1);//������� 
	quicksort(i+1,right);//�����ұ� 
	return;	
}


int main()
{
	int i,j,n;
	printf("����������Ԫ�� :"); 
	for(i=0;i<5;i++)
	scanf("%d",&a[i]);
	quicksort(0,4);//����������� 
	printf("�����"); 
	for(i=0;i<5;i++)
	{
		printf("%3d",a[i]);
	}
	getchar();
	return 0;
}


