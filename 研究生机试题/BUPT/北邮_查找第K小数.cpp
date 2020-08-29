#include <iostream>
#include <algorithm>
using namespace std;
int main(void)
{
    int n;
    while(cin>>n)
    {
        int a[1005];
        for(int i=0;i<n;i++)
        {
            scanf("%d",&a[i]);
        }
        sort(a,a+n);
        
        int b[1005];
        int count = 0;
        b[count++] = a[0];
        int temp = a[0];
        for(int i=1;i<n;i++)
        {
            if(a[i]!=temp)
            {
                temp = a[i];
                b[count++] = a[i];
            }
        }
        int k;
        scanf("%d",&k);
        printf("%d\n",b[k-1]);
    }
}
