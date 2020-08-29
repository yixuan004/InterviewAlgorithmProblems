//注意题目中所述，PI使用arccos(-1)，是个值得总结归纳的点
#include <iostream>
#include <cmath>

using namespace std;

int main(void)
{
    int x0,y0,z0,x1,y1,z1;
    while(cin>>x0>>y0>>z0>>x1>>y1>>z1)
    {
        double dis = 0;
        double v = 0;
        dis =  sqrt(pow((x0-x1),2) + pow((y0-y1),2) + pow((z0-z1),2));
        printf("%.3lf",dis);

        v = (4 * arccos(-1) * pow(dis,3) * 1.0)/3;
        printf(" %.3lf\n",v);

    }
}
