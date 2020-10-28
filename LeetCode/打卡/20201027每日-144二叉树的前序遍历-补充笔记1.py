class treeNode(object):
	def __init__(self,val=0,left=None,right=None):
		self.val = val
		self.left = left
		self.right = right


a = treeNode(1)
b = treeNode(2)
c = treeNode(3,a,b)

# print(c.left.val)
class Solution(object):
	def preTraversal(self,root):

		returnList = []
		def pre(root):
			if root == None:
				return

			print(root.val)
			returnList.append(root.val)
			if root.left != None:
				#returnList.append(root.left.val)
				pre(root.left)
			if root.right != None:
				#returnList.append(root.right.val)
				pre(root.right)

		pre(root)
		return returnList


so = Solution()
so.preTraversal(c)