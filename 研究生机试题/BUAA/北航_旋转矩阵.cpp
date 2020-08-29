#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;
int main(void)
{
    //用一个贪心算法的思路进行匹配
    int n;
    while(cin>>n)
    {
        int a[10][10];
        int b[10][10];
        memset(a,0,sizeof(a));
        memset(b,0,sizeof(b));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                scanf("%d",&a[i][j]);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                scanf("%d",&b[i][j]);
            }
        }
        
        //开始进行匹配
        int flag = 0;
        //0度匹配
        flag = 1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]!=b[i][j])
                {
                    flag = 0;
                    break;
                }
            }
            if(flag==0)
            {
                break;
            }
        }
        if(flag)
        {
            printf("0\n");
            continue;
        }
        
        //90度匹配
        flag = 1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]!=b[j][n-i-1])
                {
                    flag = 0;
                    //printf("a = %d\tb = %d\n",a[i][j],b[j][n-i-1]);
                    break;
                }
            }
            if(flag==0)
            {
                break;
            }
        }
        if(flag)
        {
            printf("90\n");
            continue;
        }
        
        //180度匹配
        flag = 1;
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<n;k++)
            {
                if(a[i][k]!=b[n-i-1][n-k-1])
                {
                    flag = 0;
                    break;
                }
            }
            if(flag==0)
            {
                break;
            }
        }
        if(flag)
        {
            printf("180\n");
            continue;
        }
        
        //270度匹配
        flag = 1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]!=b[n-j-1][i])
                {
                    flag = 0;
                    break;
                }
            }
            if(flag==0)
            {
                break;
            }
        }
        if(flag)
        {
            printf("270\n");
            continue;
        }
        else
        {
            printf("-1\n");
        }
        
    }
    
}
