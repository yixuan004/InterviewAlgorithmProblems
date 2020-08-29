#include <stdio.h>
#include <string.h>
int main(void)
{
	char s[1000];
	int n,p; //n是要循环几次 
	scanf("%d",&n);
	//scanf("%s",&s);
	//int lens = strlen(s);
	int t=0;int i=0;int a=0;int b=0;int c=0;int ret=0;int final=1;
	for(p=0;p<n;p++){
	int t=0;int i=0;int a=0;int b=0;int c=0;int ret=0;int final=1;
		scanf("%s",&s);
	int lens = strlen(s);
	while(t<lens){
		if(s[t]=='P'||s[t]=='A'||s[t]=='T'){	//判断是不是只有PAT三个字符 
			ret++;
		}
		t++;
	}
	//printf("ret = %d",ret);
	//printf("t = %d",t);
	
	if(ret!=t){
		final = 0;
	}
	else if(ret == t){
		while(s[i]=='A'){
			a++;
			i++;
		}
		//printf("a = %d\n",a);
		//printf("ia = %d",i);
		if(s[i]!='P'){
			final = 0;
		}
		i++;
		while (s[i]=='A'){
			b++;
			i++;
		}
	//	printf("b = %d\n",b);
		//printf("ib = %d",i);
		
		if(s[i]!='T'){
			final = 0;
		}
		i++;
		while(s[i]=='A'){
				c++;
				i++;
			}
			//printf("c = %d\n",c);
			//printf("ic = %d",i);
		
		
	}
	if(final !=0)
	{
		if(a*b==c&&b!=0){
			printf("YES\n");
		}else printf("NO\n");
	}else printf("NO\n");
	
}
	return 0;
}