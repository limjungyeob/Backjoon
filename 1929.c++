#include<iostream>
#include <cstring>
using namespace std;

bool arr[1000000];
int m,n;

void getEras()
{
	memset(arr,1,sizeof(arr));	//�Է¹��� ����ŭ �迭�� ��� �ʱ�ȭ �صд�
	arr[1] = 0;
	for(int i=2;i*i<=n;i++)	//������ ��: i
	{
		if(arr[i])
		for(int j=i*2;j<=n;j+=i)
		{
			arr[j] = 0;
		}
	 }
	for(int i=m;i<=n;i++)
	{
		if(arr[i])
		{
			cout<<i<<"\n";
		}
	 } 
}
int main()
{
	
	cin>>m>>n;
	getEras();
	
}