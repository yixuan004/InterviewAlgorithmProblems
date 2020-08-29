#include <iostream>
#include <cstdlib>
#include <cmath>
#include <cstring>
using namespace std;
int main(void)
{
	char s[1005];
	memset(s,0,sizeof(s));
	while(cin>>s)
	{
		for(int i=3;i>=0;i--)
		{
			printf("%c",s[i]);
		}
		printf("\n");
	}
}