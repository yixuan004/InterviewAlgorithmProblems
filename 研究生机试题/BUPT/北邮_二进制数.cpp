//注：此题题目给出的输入输出有误
#include <iostream>
using namespace std;


void Printerjinzhi(long long n)
{
    int a[100005];
    int count = 0;
    while(n>0)
    {
        a[count++] = n%2;
        n/=2;
    }
    for(int i=count-1;i>=0;i--)
    {
        printf("%d",a[i]);
    }
    printf("\n");
}


int main(void)
{
    long long t;
    while(cin>>t)
    {
        Printerjinzhi(t);
    }
}
