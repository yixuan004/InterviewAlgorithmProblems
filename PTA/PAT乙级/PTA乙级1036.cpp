#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

int main(void)
{
	int n;
	char c;
	scanf("%d %c",&n,&c);
//	printf("num = %d, char = %c",n,c);
	
	int a[25][25];
	memset(a,0,sizeof(a));
	int hang = n;
	if(n%2!=0)
	{
		hang ++;
	}
	for(int i=0;i<hang/2;i++)
	{
		if(i==0||i==hang/2-1)
		{
			for(int j=0;j<n;j++)
			{
				printf("%c",c);
			}
			printf("\n");
		}
		else
		{
			for(int j=0;j<n;j++)
			{
				if(j==0||j==n-1)
				{
					printf("%c",c);
				}
				else
				{
					printf(" ");
				}
			}
			printf("\n");
		}

	}
	return 0;
}