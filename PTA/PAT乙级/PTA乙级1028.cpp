#include <iostream>
#include <cstring>

using namespace std;

int main(void)
{
	int n;
	scanf("%d",&n);
	char youngest[105];
	char oldest[105];
	int count = 0;
	int min = 9999999;
	int max = -1;


	while(n--)
	{
		char name[105];
		char birth[105];
		scanf("%s %s\n",name,birth);
		int year;
		int month;
		int date;
		int tian = 0;
		year = (birth[0]-'0')*1000 + (birth[1]-'0')*100 + (birth[2]-'0')*10 + (birth[3]-'0');
		month = (birth[5]-'0')*10 + (birth[6]-'0');
		date = (birth[8]-'0')*10 + (birth[9]-'0');

		if(year>1814&&year<2014)
		{
			count ++;	
			//计算年龄
			tian = year*365+month*30+date;
			if(tian < min)
			{
				min = tian;
				strcpy(oldest,name); 
			}
			if(tian > max)
			{
				max = tian;
				strcpy(youngest,name);
			}
		}
		else if(year<1814)
		{
			continue;
		}
		else if(year>2014)
		{
			continue;
		}
		else if(year == 2014)
		{
			if(month<9)
			{
				count++;
				//计算年龄
				tian = year*365+month*30+date;
				if(tian < min)
				{
					min = tian;
					strcpy(oldest,name); 
				}
				if(tian > max)
				{
					max = tian;
					strcpy(youngest,name);
				}
			}
			if(month==9 && date <=6)
			{
				count++;
				//计算年龄
				tian = year*365+month*30+date;
				if(tian < min)
				{
					min = tian;
					strcpy(oldest,name); 
				}
				if(tian > max)
				{
					max = tian;
					strcpy(youngest,name);
				}
			}	
		}
		else if(year == 1814)
		{
			if(month>9)
			{
				count++;
				//计算年龄
				tian = year*365+month*30+date;
				if(tian < min)
				{
					min = tian;
					strcpy(oldest,name); 
				}
				if(tian > max)
				{
					max = tian;
					strcpy(youngest,name);
				}
			}
			if(month == 9 &&date>=6)
			{
				count++;
				//计算年龄
				tian = year*365+month*30+date;
				if(tian < min)
				{
					min = tian;
					strcpy(oldest,name); 
				}
				if(tian > max)
				{
					max = tian;
					strcpy(youngest,name);
				}
			}
		}
	}
	if(count != 0)
		printf("%d %s %s\n",count,oldest,youngest);
	else 
		printf("0\n");
}