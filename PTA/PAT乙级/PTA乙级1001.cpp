#include<iostream>
using namespace std;

int main(void)
{
	int n;
	scanf("%d",&n);
	int count = 0;
	while(1)
	{
		if(n==1)
		{
			printf("%d\n",count);
			return 0;
		}
		else if(n%2 == 0)//偶数
		{
			n /= 2;
			count ++;
		}
		else//奇数
		{
			n = 3*n + 1;
			n /= 2;
			count ++;
		}
	}
	return 0;
}