class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # 横向扫一遍，纵向扫一遍
        #注意python的-1不会报range的错误，所以在处理上即使有不期望的越界也不会报错！

        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if j==0 and grid[i][j] == 1:
                    count += 1 # 最左
                elif j!=0:
                    if grid[i][j] == 1 and grid[i][j-1] == 0:
                        count += 1 # 统计左边
                    if grid[i][j] == 0 and grid[i][j-1] == 1:
                        count += 1 # 统计右边
                if j==len(grid[i])-1 and grid[i][j] == 1:
                    count += 1 # 最右
        #print(count)

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if i==0 and grid[i][j] == 1:
                    count += 1 # 最上
                elif i!=0:
                    if grid[i][j] == 1 and grid[i-1][j] == 0:
                        count += 1 # 统计上边
                    if grid[i][j] == 0 and grid[i-1][j] == 1:
                        count += 1 # 统计下边
                if i==len(grid)-1 and grid[i][j] == 1:
                    count += 1 # 最下
        #print(count)

        return count