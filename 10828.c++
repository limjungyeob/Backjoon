#include<iostream>
#include<stack>
#include<string>
using namespace std;
int main(void)
{
    int n;
    cin>>n;
    stack<int> st;  //int type의 stack 선언
    string str; //명령어를 받기위해 선언된 string형 변수
    for(int i=0;i<n;i++)
    {
        cin>>str;
        if(str == "push")
        {
            int num;
            cin>>num;
            st.push(num);
        }else if(str == "pop")
        {
            if(!st.empty())
            {
                cout << st.top()<<endl;
                st.pop();
            }else{
                cout<<-1<<endl;
            }
        }else if(str == "size")
        {
            cout<<st.size()<<endl;
        }else if(str == "empty")
        {
            if(st.empty())
            {
                cout<<1<<endl;
            }else{
                cout<<0<<endl;
            }
        }else if(str == "top")
        {
            if(!st.empty())
            {
                cout << st.top() << endl;
            }else{
                cout<<-1<<endl;
            }
        }
    }
    return 0;
}