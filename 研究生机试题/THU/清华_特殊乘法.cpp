#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

int main(void)
{
	char s1[1005];
	char s2[1005];

	while(cin>>s1>>s2)
	{
		long long result = 0;
		for(int i=0;i<strlen(s1);i++)
		{
			for(int j=0;j<strlen(s2);j++)
			{
				result += (s1[i]-'0') * (s2[j]-'0');
			}
		}
		cout<<result<<endl;
	}
}