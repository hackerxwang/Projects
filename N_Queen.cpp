#include<iostream>
#include<cstring>
#include<cmath>
using namespace std;

//�������� 
void Try(int);
int Check(int a[],int n);

int a[100],n,i,count=0;//ȫ�ֱ���,����a�Ĵ�С���ݻʺ���������� 


int main() {
	cout<<"please input a number: ";
	memset(a,0,sizeof(a));
	cin>>n;
	Try(1);
	return 0;
}

int Check(int a[],int n) {    //��֦���������λ���Ƿ��ͻ
	for(int i=1; i<n; i++) {
		if(a[i]==a[n]||abs(i-n)==abs(a[i]-a[n]))
			return 0;
	}
	return 1;
}



//�ݹ�ʵ�������������,i��������a[i]������ 
void Try(int i) {
	for(int j=1; j<=n; j++) {
		a[i]=j;
		if(Check(a,i)) {
			if(i<n) {
				Try(i+1);
			} else {
				count++;
				int b[n+1][n+1];					
				memset(b,0,sizeof(b));
				cout<<endl<<"answer"<<" "<<count<<":"<<endl;
				for(int i=1; i<=n; i++) {
					b[i][a[i]]=1;
				}
				//��ӡ�˻ʺ� 
				for(int i=1; i<n+1; i++)
				{
					for(int j=1; j<n+1; j++)
					{
						cout<<b[i][j]<<" ";
					}
					cout<<endl;
				}
					

			}
		}

	}
}





