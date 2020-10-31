#注：完全调用函数的简单实现版
class RandomizedCollection(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.numList = []


    def insert(self, val):
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.numList:
            self.numList.append(val)
            return False
        else:
            self.numList.append(val)
            return True


    def remove(self, val):
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.numList:
            self.numList.remove(val)
            #print(self.numList)
            return True
        else:
            return False
        

    def getRandom(self):
        """
        Get a random element from the collection.
        :rtype: int
        """
        return random.choice(self.numList)




# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()