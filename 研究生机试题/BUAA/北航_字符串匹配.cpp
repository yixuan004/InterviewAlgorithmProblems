#include <iostream>
#include <cstring>
#include <cstdlib>

using namespace std;

int main(void)
{
    int n;
    while(cin>>n)
    {
        char s[1005][1005];
        memset(s,0,sizeof(s));
        for(int i=0;i<n;i++)
        {
            cin>>s[i];
        }
        
        char p[1005];
        cin>>p;
        
        int counts = 0;
        int countp = 0;
        int flag = 0;
        for(int i=0;i<n;i++)
        {
            counts = 0;
            countp = 0;
            flag = 1;
            int pipei = 0;
            int pp = 0;
            while(1)
            {
                if(counts==strlen(s[i])||countp == strlen(p))
                {
                    break;
                }
                if(s[i][counts]==p[countp]||s[i][counts] == p[countp]+'a'-'A'||s[i][counts] == p[countp]+'A'-'a')
                {
                    counts++;
                    countp++;
                    pp++;
                    continue;
                }
                if(p[countp] == '[')
                {
                    flag = 0;
                    while(p[countp]!=']')
                    {
                        countp++;
                        if(s[i][counts] == p[countp]||s[i][counts] == p[countp]+'a'-'A'||s[i][counts] == p[countp]+'A'-'a')
                        {
                            if(flag==0)
                            {
                                pipei++;
                            }
                            flag = 1;
                            //break;
                        }
                    }
                    if(flag==1)
                    {
                        counts++;
                        countp++;
                        continue;
                    }
                }
                else
                {
                    flag = 0;
                    break;
                }
            }
            if(countp!=strlen(p))
            {
                flag = 0;
            }
            if(flag)
            {
                //printf("counts = %d\tcountp = %d\n",counts,countp);
                //printf("pp1 = %d\tpp2 = %d\n",pp,pipei);
                printf("%d %s\n",i+1,s[i]);
            }
        }
        
        
    }
    
}
