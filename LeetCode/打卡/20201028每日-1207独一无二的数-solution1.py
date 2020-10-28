class Solution(object):
    def uniqueOccurrences(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        #最多出现1000次，每个数字的-1000到1000

        indexList = [0 for x in range(0,2005)]
        #print(len(indexList))
        for i in range(0,len(arr)):
            indexList[arr[i]+1000] += 1
        
        #print(indexList)
        #indexList.sort(reverse=True)
        #print(indexList)
        tempList = []
        for i in range(len(indexList)):
            if indexList[i] != 0:
                tempList.append(indexList[i])
        #print(tempList)
        
        ttempList = list(tempList)
        ttempList = list(set(ttempList))
        print(ttempList)

        if len(ttempList) == len(tempList):
            return True
        else:
            return False
