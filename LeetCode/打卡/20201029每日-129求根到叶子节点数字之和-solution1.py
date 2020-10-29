# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    total = 0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        #怎么保证只加上一次的内容
        def pre(root,strNum): 
            if root == None:
                return           
            strNum += str(root.val)
            if root.left == None and root.right==None:
                self.total += int(strNum)
                print(strNum)

            if root.left != None:
                pre(root.left,strNum)
            if root.right != None:
                pre(root.right,strNum)


        strNum = ''
        pre(root,strNum)
        return self.total