class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1 = set(nums1)
        print(nums1)
        nums2 = set(nums2)
        print(nums2)
        nums3 = nums1.intersection(nums2)
        print(nums3)
        return list(nums3)

class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1 = set(nums1)
        print(nums1)
        nums2 = set(nums2)
        print(nums2)
        nums3 = nums1&nums2
        print(nums3)
        return list(nums3)