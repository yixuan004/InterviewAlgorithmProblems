class Solution(object):
    def smallerNumbersThanCurrent(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #给定一个数组nums，对于其中每个元素，请统计数组中比它小的所有数字的数目
        returnList = []
        
        tempNums = list(nums) # 复制一份nums
        tempNums.sort() # 小到大排序
#        print(nums)
#        print(tempNums)

        for i in range(0,len(nums)):
            returnList.append(tempNums.index(nums[i]))

        print(returnList)
        return returnList
            
