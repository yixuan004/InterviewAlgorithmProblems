class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1 = list(set(nums1))
        nums2 = list(set(nums2))

        #print(nums1)
        #print(nums2)
        nums3 = []
        for i in range(len(nums1)):
            if nums1[i] in nums2:
                nums3.append(nums1[i])
        print(nums3)
        return nums3