#include <iostream>
using namespace std;
int main(void)
{
    int n;
    while(cin>>n)
    {
    	int a[105];
    	for(int i=0;i<n;i++)
    	{
    		scanf("%d",&a[i]);
    	}

    	int m;
    	cin>>m;
    	for(int i=0;i<m;i++)
    	{
    		int temp;	
    		cin>>temp;
    		int flag = 0;
    		for(int j=0;j<n;j++)
    		{
    			if(temp==a[j])
    			{
    				flag = 1;
    				break;
    			}
    		}
    		if(flag==1)
    		{
    			printf("YES\n");
    		}
    		else
    		{
    			printf("NO\n");
    		}
    	}
    }
}