#include <iostream>
using namespace std;

int main(void)
{
    int year;
    int month;
    int day;
    
    int is[30] = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    int no[30] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    
    while(cin>>year>>month>>day)
    {
        int isLeap = 0;;
        if((year%400 == 0) || year%4==0 && year%100!=0 )
        {
            isLeap = 1;
        }
        
        int jishu = 0;
        if(isLeap)
        {
            for(int i=1;i<month;i++)
            {
                jishu += is[i];
            }
            jishu += day;
        }
        else
        {
            for(int i=1;i<month;i++)
            {
                jishu += no[i];
            }
            jishu += day;
        }
        printf("%d\n",jishu);
    }
}
