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
            #print(calResult)

        ttempList = [x for _,x in sorted(zip(calResultList,points))] # 按照calResultList给points排序
        print(ttempList)
        return ttempList[0:K]


    def cal(self, tempList):
        return math.sqrt(tempList[0] * tempList[0] + tempList[1] * tempList[1])