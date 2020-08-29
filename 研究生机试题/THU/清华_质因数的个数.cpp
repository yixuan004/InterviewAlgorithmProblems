#include <iostream>
#include <cmath>

using namespace std;


int main(void)
{
    int n;
    while(cin>>n)
    {
        int count = 0;
        for(int i=2;i<sqrt(n)+1;i++)
        {
        	while(n%i == 0)
        	{
        		n /= i;
        		count++;
        	}
        	if(n==1)
        	{
        		break;
        	}
        }
        if(n>1)//简单数论，只有一个大于sqrt n 的因子
        	count++;
        printf("%d\n",count);
    }
}
