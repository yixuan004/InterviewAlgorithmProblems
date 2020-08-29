#include <iostream>
#include <cstring>
using namespace std;

int main(int argc,char** argv)
{
	char s[10005];
	scanf("%s",s);
	int slen = strlen(s);
	int sum = 0;
	for(int i=0;i<slen;i++)
	{
		sum += s[i] - '0';
	}

	int a[10005];
	int count = 0;
	while(sum>0)
	{
		a[count++] = sum%10;
		sum /= 10;
	}

	for(int i=count-1;i>=0;i--)
	{
		if(i!=count-1)
		{
			printf(" ");
		}
		if(a[i]==0)
			printf("ling");
		if(a[i]==1)
			printf("yi");
		if(a[i]==2)
			printf("er");
		if(a[i]==3)
			printf("san");
		if(a[i]==4)
			printf("si");
		if(a[i]==5)
			printf("wu");
		if(a[i]==6)
			printf("liu");
		if(a[i]==7)
			printf("qi");
		if(a[i]==8)
			printf("ba");
		if(a[i]==9)
			printf("jiu");
	}
	return 0;
}