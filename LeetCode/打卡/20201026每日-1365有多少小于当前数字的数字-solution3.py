class Solution(object):
    def smallerNumbersThanCurrent(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #给定一个数组nums，对于其中每个元素，请统计数组中比它小的所有数字的数目
        returnList = []
        #计数排序方法，注意到nums[i] 不超过100个
        tempList = [0 for x in range(101)]

        for i in range(0,len(nums)):
            tempList[nums[i]] += 1
        #print(tempList)

        #比i小的数字有几个
        temppList = list(tempList)
        temppList[0] = 0 # 不可能有比0还小的
        for i in range(1,101):
           temppList[i] = tempList[i-1]
           tempList[i] += tempList[i-1] # refresh掉原有的
        #print(temppList)
        for i in range(0,len(nums)):
            returnList.append(temppList[nums[i]])

        print(returnList)
        return returnList

            
