class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        inIndex1 = -2
        inIndex2 = -2
        outIndex1 = -2
        outIndex2 = -2
        newlist = []
        for i in range(len(intervals)):
            #不需要区间合并的情况
            #位于区间中间,换句话说区间完全重叠，此时不必合并，无需进行任何操作
            if newInterval[0] >= intervals[i][0] and newInterval[1] <= intervals[i][1]:
                print(newInterval[0],newInterval[1])
                return intervals
            #完全间隙在两个区间中间
            if newInterval[0] > intervals[i][1]:
                if i+1 >= len(intervals):
                    intervals.append(newInterval)
                    return intervals
                else:
                    if newInterval[1] < intervals[i+1][0]:
                        intervals.insert(i+1,newInterval)
                        return intervals
            if newInterval[0] < intervals[0][0] and newInterval[1] < intervals[0][0]:
                newlist.append(newInterval)
                for item in intervals:
                    newlist.append(item)
                return newlist
            

            #或许需要进行区间合并的情况
            #两边都位于包含在其他区间中了
            if newInterval[0] >= intervals[i][0] and newInterval[0] <= intervals[i][1]:
                inIndex1 = i
                print("inIndex1:",i)
            if newInterval[1] >= intervals[i][0] and newInterval[1] <= intervals[i][1]:
                inIndex2 = i
                print("inIndex2:",i)

            #仅左边不包含在区间中
            if newInterval[0] > intervals[i][1] and newInterval[0] < intervals[i+1][0]:
                outIndex1 = i
                print("outIndex1:",i)
            if newInterval[0] < intervals[0][0]:
                outIndex1 = -1
                print("outIndex1:",-1)

            #仅右边不包含在区间中
            if newInterval[1] > intervals[i][1]:
                if i+1 >= len(intervals):
                    outIndex2 = i
                else:
                    if newInterval[1] < intervals[i+1][0]:
                        outIndex2 = i
                print("outIndex2:",i) # 间隙在原有的index2后边
            
        #把index1的左边，和index2右边合并成一个新的
        #去除index1-index2中间的所有节点
        print("inIndex1:%d, inIndex2:%d, outIndex1:%d, outIndex2:%d"%(inIndex1,inIndex2,outIndex1,outIndex2))
        #newlist = []

        if inIndex1 == -2 and inIndex2 == -2 and outIndex1 == -2 and outIndex2 == -2:
            newlist.append(newInterval)
            print("-1,-1,-1,-1",newlist)
            return newlist
 
        #左in右in
        if inIndex1 != -2 and inIndex2 != -2:
            for i in range(inIndex1):
                newlist.append(intervals[i])
            newlist.append([intervals[inIndex1][0],intervals[inIndex2][1]])
            for i in range(inIndex2+1,len(intervals)):
                newlist.append(intervals[i])
            print("左in右in",newlist)
        
        #左in右out：
        #左边不用处理了，右边根据outIndex2，把outIndex2的右边换成 newInterval[1]，删除掉
        if inIndex1 != -2 and outIndex2 != -2:
            for i in range(inIndex1):
                newlist.append(intervals[i])
            newlist.append([intervals[inIndex1][0],newInterval[1]])
            for i in range(outIndex2+1,len(intervals)):
                newlist.append(intervals[i])
            print("左in右out",newlist)

        #左out右in：
        if outIndex1 != -2 and inIndex2 != -2:
            for i in range(0,outIndex1+1):
                newlist.append(intervals[i])
            newlist.append([newInterval[0],intervals[inIndex2][1]])
            for i in range(inIndex2+1,len(intervals)):
                newlist.append(intervals[i])
            
        #左out 右out：
        if outIndex1 != -2 and outIndex2 != -2:
            for i in range(outIndex1+1):
                newlist.append(intervals[i])
            newlist.append([newInterval[0],newInterval[1]])
            for i in range(outIndex2+1,len(intervals)):
                newlist.append(intervals[i])

        return newlist
