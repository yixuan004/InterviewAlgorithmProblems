#include <iostream>
#include <cstdlib>
#include <cstring>
#include <algorithm>


using namespace std;

int main(void)
{
	char a[105];
	char b[105];
	memset(a,0,sizeof(a));
	memset(b,0,sizeof(b));
	while(cin>>a>>b)
	{
		//理牌
		sort(a,a+strlen(a));
		sort(b,b+strlen(b));

		//printf("a = %s\n",a);
		int flag = 0;

		if(strlen(b)==1)//如果是一张的
		{
			for(int i=strlen(a)-1;i>=0;i--)
			{
				if(a[i]>b[0])
				{
					flag = 1;
					break;
				}
			}

		}
		else if(strlen(b)==2)
		{
			for(int i=0;i<strlen(a);i++)
			{
				if(a[i] == a[i+1] && a[i] > b[0])
				{
					flag = 1;
					break;
				}
			}

		}
		else if(strlen(b)==3)
		{
			for(int i=0;i<strlen(a);i++)
			{
				if(a[i] == a[i+1] && a[i+1] == a[i+2] && a[i] > b[0])
				{
					flag = 1;
					break;
				}
			}
		}
		else if(strlen(b)==4)
		{
			for(int i=0;i<strlen(a);i++)
			{
				if(a[i] == a[i+1] && a[i+1] == a[i+2] && a[i+2] == a[i+3] && a[i] > b[0])
				{
					flag = 1;
					break;
				}
			}
		}
		else if(strlen(b)==5)
		{
			int c[1005];
			memset(c,0,sizeof(c));
			
			int temps = a[0];
			c[0] = a[0];
			int count = 1;
			for(int i=1;i<strlen(a);i++)
			{
				if(a[i]!=temps)
				{
					temps = a[i];
					c[count++] = a[i];
				}
			}
			for(int i=0;i<count;i++)
            {
                if(c[i]+1 == c[i+1] && c[i+1]+1==c[i+2] && c[i+2]+1 == c[i+3] && c[i+3]+1==c[i+4] && c[i]>b[0])
                {
                    flag = 1;
                    break;
                }
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