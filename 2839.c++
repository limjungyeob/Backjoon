#include<iostream>
using namespace std;
int main()
{
    int rest,quotient1=0,N;
    cin>>N;
    quotient1 = N/5;
    rest= N%5;
    if(quotient1 != 0 || rest != 4)
    {
        if(rest == 2){
            if(quotient1>1) quotient1+=2;
            else quotient1=-1;
        }
        else if(rest==1 || rest ==3) quotient1++;
        else if(rest==4) quotient1+=2;

    }else{
        quotient1=-1;
    }
    cout<<quotient1;

    
}