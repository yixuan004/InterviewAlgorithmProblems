class Solution(object):
    def sortByBits(self, arr):
        """
        :type arr: List[int]
        :rtype: List[int]
        """
        binCount = []
        for item in arr:
            count = 0
            while item > 0:
                #print(item&1)
                if item&1:
                    count += 1
                item >>= 1
            binCount.append(count)
        print(binCount)

        #print([x for _,x in sorted(zip(binCount,arr))])
        returnList = [x for _,x in sorted(zip(binCount,arr))]
        
        return returnList