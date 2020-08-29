#include <iostream> 
using namespace std;
int main(void)
{
	int n;
	scanf("%d",&n);
	int countjishu = 0;
	int countoushu = 0;
	for(int i=0;i<n;i++)
	{
		int temp;
		scanf("%d",&temp);
		if(temp%2 == 0)
		{
			countoushu ++;
		}
		else
		{
			countjishu ++;
		}
	}
	if(countoushu>countjishu)
	{
		printf("NO\n");
	}
	else
	{
		printf("YES\n");
	}
	return 0;

}