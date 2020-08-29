#include <stdio.h>
#include <string.h>
int main(void)
{
	char name[100][15];
	char number[100][15];
	int score;
	int n; 
	int max=0,min=100;
	scanf("%d",&n); 
	int i;
		int finalname,finalnumber;
			int finalname2,finalnumber2;
	for(i=0;i<n;i++)
	{
		scanf("%s",name[i]);
		scanf("%s",number[i]);
		scanf("%d",&score);
		if(score>max)
		{
			max = score;
			finalname = i;
			finalnumber = i;
		}
		if(score<min)
		{
			min = score;
			finalname2 = i;
			finalnumber2 = i;
		}
	   }   


		printf("%s ",name[finalname]);
		printf("%s",number[finalnumber]);
		printf("\n"); 
		printf("%s ",name[finalname2]);
		printf("%s",number[finalnumber2]);
		return 0;
 } 