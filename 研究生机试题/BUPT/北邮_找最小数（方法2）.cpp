#include <iostream>
using namespace std;

int main(void)
{
    int n;
    scanf("%d",&n);
    int minx,miny;
    scanf("%d%d",&minx,&miny);

    //注意替换是同时的替换
    for(int i=1;i<n;i++)
    {
        int x,y;
        scanf("%d%d",&x,&y);
        if(x<minx)
        {
            minx = x;
            miny = y;
        }
        else if(x == minx)
        {
            if(y<miny)
            {
                minx = x;
                miny = y;
            }
        }
    }

    printf("%d %d\n",minx,miny);
    return 0;    
}