#include <iostream>
#include <cstdlib>
#include <algorithm>
#include <cmath>

using namespace std;

int main(void)
{
    int a[30];
    int b[30];
    
    while(1)
    {
        memset(a,0,sizeof(a));
        memset(b,0,sizeof(b));

        for(int i=0;i<25;i++)
        {
            scanf("%d",&a[i]);//直接修改为线性存储了，也可以避免存储过程中由于换行造成的问题
        }
        int s,t,x,y;
        if(!(cin>>s>>t>>x>>y))
        {
            break;
        }
        for(int i=0;i<25;i++)
        {
        	b[i] = a[i];
        }
        
        //开始依据s,t,x,y的值开始处理，为方便理解不用自己跟着自己捯饬了
        int temp = 0;
        int pos = (x-1)*5 + (y-1); //偏移项


        if(s==1&&t==2)//90度顺时针翻转4个数
        {
        	temp = a[pos];
        	a[pos] = a[pos+5];
        	a[pos+5] = a[pos+6];
        	a[pos+6] = a[pos+1];
        	a[pos+1] = temp;
        }
        else if(s==1&&t==3)//90度顺时针翻转9个数
        {	
        	a[pos] = b[pos+10];
        	a[pos+1] = b[pos+5];
        	a[pos+2] = b[pos];
        	a[pos+5] = b[pos+11];
        	a[pos+7] = b[pos+1];
        	a[pos+10] = b[pos+12];
        	a[pos+11] = b[pos+7];
        	a[pos+12] = b[pos+2];
        }
        else if(s==2&&t==2)//90度逆时针翻转4个
        {
        	temp = a[pos];
        	a[pos] = a[pos+1];
        	a[pos+1] = a[pos+6];
        	a[pos+6] = a[pos+5];
        	a[pos+5] = temp;
        }
        else if(s==2&&t==3)//90度逆时针翻转9个
        {
        	a[pos] = b[pos+2];
        	a[pos+1] = b[pos+7];
        	a[pos+2] = b[pos+12];
        	a[pos+5] = b[pos+1];
        	a[pos+7] = b[pos+11];
        	a[pos+10] = b[pos];
        	a[pos+11] = b[pos+5];
        	a[pos+12] = b[pos+10];
        }
        for(int i=1;i<=25;i++)
        {
        	printf("%d",a[i-1]);
        	if(i%5 == 0)
        	{
        		printf("\n");
        	}
        	else
        	{
        		printf(" ");
        	}
        }

        
    }
    return 0;
    
}
