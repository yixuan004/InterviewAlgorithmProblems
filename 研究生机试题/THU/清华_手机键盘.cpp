/*注意手机键盘中的字母分布，7和9两个键上都包含四个字母
2:abc
3:def
4:ghi
5:jkl
6:mno
7:pqrs
8:tuv
9:wxyz
*/
#include <iostream>
#include <cstring>
using namespace std;
int main(void)
{
    int sq[10] = {0,3,6,9,12,15,19,22,26};
    
    char input[1005];
    while(cin>>input)
    {
        int qujian = -1;
        int count = 0;
        
        for(int i=0;i<strlen(input);i++)
        {
            for(int j=0;j<10;j++)
            {
                if((input[i]-'a'+1) <= sq[j])
                {
                    if(j==qujian)
                    {
                        count+=2;
                    }
                    qujian = j;
                    count += (input[i]-'a'+1) - sq[j-1];
                    break;
                    
                }
            }
        }
        printf("%d\n",count);
    }
    
    
}
