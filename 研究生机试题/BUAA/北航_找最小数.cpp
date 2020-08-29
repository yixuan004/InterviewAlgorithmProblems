//复习使用cmp函数进行结构体排序
#include <iostream>
#include <cstdlib>
#include <algorithm>

using namespace std;


struct node
{
    int x;
    int y;
};

int cmp(struct node a,struct node b)
{
    if(a.x<b.x)
    {
       return a.x<b.x;
    }
    else if(a.x==b.x)
    {
        return a.y<b.y;
    }
    return 0;
}


int main(void)
{
    int n;
    scanf("%d",&n);
    
    struct node s[1005];
    
    for(int i=0;i<n;i++)
    {
        scanf("%d%d",&s[i].x,&s[i].y);
    }
    sort(s,s+n,cmp);

    printf("%d %d\n",s[0].x,s[0].y);
    
}
