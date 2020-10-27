class Solution(object):
    def smallerNumbersThanCurrent(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #给定一个数组nums，对于其中每个元素，请统计数组中比它小的所有数字的数目
        returnList = []
        for i in range(0,len(nums)):
            count = 0
            for j in range(0,len(nums)):
                if i==j:
                    continue
                else:
                    if nums[j] < nums[i]:
                        count += 1
            returnList.append(count)
        #print(returnList)
        return returnList