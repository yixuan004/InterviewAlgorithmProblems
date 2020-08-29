#include <iostream>
#include <algorithm>

using namespace std;

struct node
{
    char name[1005];
    int score;
    int paixu;
};

int cmp1(struct node a,struct node b)
{
    if(a.score != b.score)
    {
        return a.score<b.score;
    }
    else
    {
        return a.paixu<b.paixu;
    }
}

int cmp2(struct node a,struct node b)
{
    if(a.score != b.score)
    {
        return a.score > b.score;
    }
    else
    {
        return a.paixu < b.paixu;
    }
}


int main(void)
{
    int n;
    int func;
    while(cin>>n>>func)
    {      
	    struct node s[1005];
	    for(int i=0;i<n;i++)
	    {
	        scanf("%s %d",&s[i].name,&s[i].score);
	        s[i].paixu = i;
	    }
	    if(func==0)//降序排序
	    {
	        sort(s,s+n,cmp2);
	    }
	    else if(func==1)//升序排序
	    {
	        sort(s,s+n,cmp1);
	    }
	    
	    for(int i=0;i<n;i++)
	    {
	        printf("%s %d\n",s[i].name,s[i].score);
	    }
    }
}
