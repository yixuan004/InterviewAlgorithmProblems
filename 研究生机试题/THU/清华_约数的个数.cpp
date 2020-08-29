#include <iostream>
#include <cmath>
using namespace std;
int main(void)
{
    int n;
    scanf("%d",&n);
    while(n--)
    {
        long long a;
        scanf("%lld",&a);
        int count = 0;
        for(int i=1;i<=floor(sqrt(a));i++)
        {
            if(a%i==0)
            {
                count += 2;
            }
        }
        if(floor(sqrt(a))==sqrt(a))
        {
            count--;
        }
        printf("%d\n",count);
        
    }
}

