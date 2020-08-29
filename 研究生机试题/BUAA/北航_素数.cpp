#include <iostream>
using namespace std;
//输入一个整数n(2<=n<=10000)，要求输出所有从1到这个整数之间(不包括1和这个整数)个位为1的素数，如果没有则输出-1。

bool isPrime(int num)
{
	if(num == 1)
	{
		return false;
	}
	else if(num == 2)
	{
		return true;
	}
	else
	{
		for(int i=2;i<sqrt(num)+1;i++)
		{
			if(num%i == 0)
			{
				return false;
			}
		}
		return true;
	}
}



int main(void)
{
	int n;
	scanf("%d",&n);
	int flag = 0;
	int space = 0;
	for(int i=1;i<n;i++)
	{
		if(i%10 == 1 && isPrime(num))
		{
			if(space != 0)
			{
				printf(" ");
			}
			space = 1;
			printf("%d",i);
			flag = 1;
		}
	}
	if(flag==0)
	{
		printf("-1\n");
	}
	return 0;
}