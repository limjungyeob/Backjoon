#include<iostream>
#include<string>
using namespace std;
int main()
{
    string str;
    int count;
    getline(cin,str);

    if(str.empty())
    {
        cout<<"0";
        return 0;
    }
    count =1;

    int len = str.size();
    for(int i=0;i<len;i++)
    {
        if(str[i] == ' '){
            count++;
        }
    }
    if(str[0] == ' ')
    {
        count--;
    }
    if(str[str.length()-1]==' ')
    {
        count--;

    }
    cout<<count;
}