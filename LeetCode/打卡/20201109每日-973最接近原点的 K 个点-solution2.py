class Solution(object):
    def kClosest(self, points, K):
        """
        :type points: List[List[int]]
        :type K: int
        :rtype: List[List[int]]
        """
        calResultList = []
        for item in points:
            calResult = self.cal(item)
            calResultList.append(calResult)

        points.sort(key=lambda x: self.cal(x)) # 匿名函数，多加了一维度？
        print(points) # 对原数组按照lambda排序
        return points[0:K]


    def cal(self, tempList):
        return tempList[0] * tempList[0] + tempList[1] * tempList[1]