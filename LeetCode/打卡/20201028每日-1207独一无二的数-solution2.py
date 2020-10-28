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
        indexList.sort(reverse=True)
        #print(indexList)
        for i in range(len(indexList)-1):
            if indexList[i]==0:
                break
            if indexList[i] == indexList[i+1]:
                print(indexList[i])
                return False

        return True