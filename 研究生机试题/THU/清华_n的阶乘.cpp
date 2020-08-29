#include <iostream>
using namespace std;

long long f(long long a)
{
	if(a==0)
	{
		return 1;
	}
	return a * f(a-1);
}

int main(void)
{
	long long n;
	while(cin>>n)
	{
		long long temp;
		temp = f(n);
		printf("%lld\n",temp);
	}
}