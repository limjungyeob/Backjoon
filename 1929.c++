#include<iostream>
#include <cstring>
using namespace std;

bool arr[1000000];
int m,n;

void getEras()
{
	memset(arr,1,sizeof(arr));	//입력받은 수만큼 배열에 모두 초기화 해둔다
	arr[1] = 0;
	for(int i=2;i*i<=n;i++)	//나누는 값: i
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