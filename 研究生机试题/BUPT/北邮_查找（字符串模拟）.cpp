//注意是对一个字符串进行反复的操作，不是每次从头操作字符串
#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

int main(void)
{
    char s[105];
    memset(s,0,sizeof(s));
    while(cin>>s)
    {
        int n;
        scanf("%d",&n);
        while(n--)
        {
            char mingling[1005];
            cin>>mingling;//输入一个命令
            
            int i = mingling[1] - '0';
            int len = mingling[2] - '0';
            if(mingling[0] == '0')//翻转 从i - i+len-1进行翻转
            {
                char temps[1005];
                memset(temps,0,sizeof(temps));
                int count = 0;
                for(int j=i;j<=i+len-1;j++)
                {
                    temps[count++] = s[j];
                }
                count--;
                for(int j=i;j<=i+len-1;j++)
                {
                    s[j] = temps[count--];
                }
                printf("%s\n",s);
            }
            else if(mingling[0] == '1')//用命令第4位开始到最后替换原读入的字符串下标i - i+len-1的字符串
            {
                char tihuan[1005];
                int count = 0;
                for(int j=3;j<strlen(mingling);j++)
                {
                    tihuan[count++] =  mingling[j];
                }
                tihuan[count] = '\0';
                //printf("tihuan = %s\n",tihuan);
                char end[1005];
                count = 0;
                for(int j=i+len;j<strlen(s);j++)
                {
                    end[count++] = s[j];
                }
                end[count] = '\0';
                char qian[1005];
                count = 0;
                for(int j=0;j<i;j++)
                {
                    qian[count++] = s[j];
                }
                qian[count] = '\0';
                strcat(qian,tihuan);
                strcat(qian,end);
                strcpy(s,qian);
                printf("%s\n",qian);
            }
            
            
        }
    }
}
