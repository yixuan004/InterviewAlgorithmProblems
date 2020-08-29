//题目描述与给出的输入输出样例不同（2020.2）
#include <iostream>
#include <cstdlib>
#include <cstring>
using namespace std;

int main(void)
{

    int n,k;
    while(cin>>n>>k)
    {
        // int n;
        // int k;
        // scanf("%d%d",&n,&k);
        int s[15][15];
        int result[15][15];
        memset(s,0,sizeof(s));
        memset(result,0,sizeof(result));
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                scanf("%d",&s[i][j]);
                result[i][j] = s[i][j];
            }
        }
        k -= 1;
        
        
        
        
        while(k--)//k次幂
        {
            int temp[15][15];
            memset(temp,0,sizeof(temp));
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    //计算result的i行*s的第j列
                    for(int x=0;x<n;x++)
                    {
                        temp[i][j] += result[i][x] * s[x][j];
                    }
                }
            }
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    result[i][j] = temp[i][j];
                }
            }
            
        }
        int space = 0;
        for(int i=0;i<n;i++)
        {
            space = 0;
            for(int j=0;j<n;j++)
            {
                if(space != 0)
                {
                    printf(" ");
                }
                printf("%d",result[i][j]);
                space = 1;
            }
            if(i!=n-1)
                printf("\n");
        }
    }
}
