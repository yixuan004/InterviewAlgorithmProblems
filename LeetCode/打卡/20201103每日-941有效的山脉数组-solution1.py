class Solution(object):
    def validMountainArray(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        if len(A)<3:
            return False
        
        upFlag = 1
        downFlag = 0
        judgeUpFlag = 0
        for i in range(1,len(A)):
            if A[i] > A[i-1]:
                judgeUpFlag = 1
            if upFlag == 1:
                if not A[i] > A[i-1]:
                    upFlag = 0
            if upFlag == 0:
                if not A[i] < A[i-1]:
                    return False
                else:
                    downFlag = 1
        if downFlag and judgeUpFlag:
            return True
        else:
            return False
