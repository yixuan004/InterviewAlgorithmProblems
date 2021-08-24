# 一些题解的笔记记录

### 【day01栈与队列】剑指 Offer 09. 用两个栈实现队列
该题要求使用两个栈实现队列的尾部插入和头部pop，不偷鸡的方法比较简单。

主要思想是push的时候就全往一个栈push。

需要pop的时候如果另外一个栈是空的，就先把现有的栈倒进去。这时候直接取另外一个栈的栈顶就是那个需要的元素，如果另一个栈还为空，则返回-1。

之前Java经验不多，这里首次接触到Java中的栈，要用这种方式来定义（在类实例化的时候实例化的那种感觉），已经不推荐使用Stack，用这个有一种模拟的感觉

```java
class CQueue {
    Deque<Integer> stack;
    
    // 无参构造方法，推荐使用Deque + LinkedList作为栈的实现
    public CQueue() {
        stack = new LinkedList<>();
    }
}
```

### 【day01栈与队列】剑指 Offer 30. 包含min函数的栈
题目的要求难点主要在要求在O(1)的时间复杂度条件下，求解一个栈中的min元素。

如果使用单个int minValue记录的方法，由于现有栈的最小值存在被pop出去的可能，所以不行。

所以采用维护两个栈的方法，其中主栈就是正常的栈，副栈用来存主栈非严格单调递减的序列（存在相等的可能性），这里有个打字不太好描述那种感觉，就是这个副栈的"实际长度"和主栈实际是同步的，所以只要主栈每次pop的时候，判断和副栈栈顶是不是一样，如果一样就一起pop出去就行了（由于副栈非严格，所以同步）

在这种方法下，副栈的栈顶永远就是当前的min了。

```java
class test {
    Deque<Integer> stack;
    public test() { // 构造方法，创建时构造
        stack = new LinkedList<>();
    }
}
```

### 【day02链表】剑指 Offer 06. 从尾到头打印链表
主要思想是利用栈，正向链表遍历的时候不断入栈，在打印的时候pop即可，复习java栈的创建方法
```java
Deque<Integer> stack;
stack = new LinkedList<>();
```
还有一个要注意的地方是，在遍历stack的时候，因为涉及到pop操作，不能用stack.size()，要在pop前先把stack.size()给到一个变量

### 【day02链表】剑指 Offer 24. 反转链表
翻转链表实际上就是在遍历原链表的过程中，头插法的应用。在创建新链表的过程中，注意每个地方要用ListNode(xxx.val)创建一下
```java
if (qHead == null) {
    qHead = new ListNode(p.val); // 这里p是ListNode类型
}


// 头插法核心代码
ListNode p = head; // 指向原有链表的头结点，用于遍历原来的原有链表
ListNode qHead = null;
while (p != null) {
    // 主要是进行一个头插法，注意，不是在原来的链表上修改
    if (qHead == null) {
        qHead = new ListNode(p.val);
    } else {
        ListNode tempHead = new ListNode(p.val); // 定义一个新的
        tempHead.next = qHead;
        qHead = tempHead;
    }
    // System.out.println(p.val);
    p = p.next;
}
return qHead;
```

### 【day02链表】剑指 Offer 35. 复杂链表的复制
这个题麻烦的地方主要在于random的那个复制，如果随遍历随新建复制的话，那样random可能由于重复出现的问题，导致本来是一个节点的地方产生了多个。

所以思路在于，先把所有节点全都新建一个，然后再想办法把这些节点穿在一起。

这里也首次用到了HashMap的操作
```java
Map<Node, Node> hmap = new HashMap<>();
// 主要方法hmap.put，hmap.get
```
创造老节点，到新节点的mapping
```java
hmap.put(p, new Node(p.val));
```

### 【day03字符串】剑指 Offer 05. 替换空格
这个题基本没有什么难的，主要是熟悉下java的字符串相关操作。
```java
String a = "HelloWorld";
aCharArray = a.toCharArray();

// 然后一般来说一个charArray转化成String的方法是
String temp = new Stirng(aCharArray, 0, index);  // 代表把0到index-1位置处的转化为String，所以给这个index就行了
```

### 【day03字符串】剑指 Offer 58 - II. 左旋转字符串
没有什么太大难度，复习一下java String引用类型的方法，substring
```java
String s = new String();
s.substring(n, s.length()) + s.substring(0, n);
```

### 【day04查找算法（简单）】剑指 Offer 03. 数组中重复的数字
第一种方法：是 数组桶 的方法，桶的方法要注意数据范围，等于说要完全开辟一块新的内存空间，时空复杂度都是O(N)；

第二种方法：是HashSet的方法（因为涉及到set需要时长的复习一下），空间复杂度由于要开辟新的HashSet空间，肯定不是O(1)的；
```java
Set<Integer> set = new HashSet<>();
set.add(x);方法，如果插入成功返回true（也就是set之前不包含这个元素）；如果此 set 已包含该元素，则该调用不更改 set 并返回 false
```

第三种方法：这个题用到一个很巧妙的原地替换的思想，目标是使得所有nums[i] = i，这样不用开辟新的内存空间，但这种方法的要求是，数组内的最大元素值，不能超过数组的长度
从0开始，逐个i遍历数组，如果遇到nums[i] == i的情况，说明这个位置是符合要求的；如果遇到nums[i] != i的情况，现在遍历到的元素是nums[i]，需要把他换到nums[nums[i]]的位置，这时候如果nums[nums[i]]的位置已经是这个值了，则代表重复了，break

### 【day04查找算法（简单）】剑指 Offer 53 - I. 在排序数组中查找数字 I
题目要求在一个有序数组中查找一个数字出现了多少次，为了避免O(N)的情况，肯定是要用二分查找的

但是如果先用二分查找，再O(N)遍历，那么还是退化为O(N)了

所以最终的方法是通过二分查找找到边界，基本思想是，找到比目标数大的第一个数字角标，找到比目标数字小的第一个数字角标，right-left-1即可

二分查找类题目模板都可以使用下边的这个，注意要分三段写判断情况
```java

int left = 0;
int right = nums.length - 1;

while (left <= right) { // 二分查找的模板套路
    int mid = (left + right) / 2;
    //  这里分三段写更容易理解，自己不要把情况合并到一块了
    if (nums[mid] < binSearchTarget){
        left = mid + 1;
    } else if (nums[mid] > binSearchTarget){
        right = mid - 1;
    } else {
        left = mid + 1; // 如果正好有target，这里的目标是找到刚刚比target大一点的那个角标
    }
}
return left; // 这个地方的数字，是第一个大于目标数字的角标
```

### 【day04查找算法（简单）】剑指 Offer 53 - II. 0～n-1中缺失的数字
也是用二分查找的条件来判断，如果mid的那个地方，出现了mid != nums[mid]的情况，那么就说明一定在左边，最理想的条件是缺的就是前边一个

换句话来说，找的right，是最后一个mid = nums[mid]的位置，由于使用的是left <= right，找到的left会是第一个不相等的位置

标准二分查找中，如果循环条件写成left < right，那就会漏掉所要查找的元素恰好就位于left或者right上的这两种边界情况

[0(left) (mid)，1(right)]，target=1，因为nums[mid] != 1，所以left = mid +1 (=right)，而此时left=right，不会再走下一轮，就漏掉了

（关于day05 11题，为什么循环条件写成<就够了，当left == right == 0时，因为此时nums[mid]和nums[right]一样，会执行right--），这样最后会越界（特殊处理一下也可以，见第五天笔记了）

### 【day05查找算法（中等）】剑指 Offer 04. 二维数组中的查找
这个题有一种模板想法的感觉了，要从一个矩阵的右上角开始。一个自己的想法是如果从左上角开始的话，那么往下（i++）,往右（j++），所对应到的数都是更大的

而如果从右上角开始的话，往下（i++）对应的数字是增的，往左（j--）对应的数字是减的，就可以解题了

### 【day05查找算法（中等）】剑指 Offer 11. 旋转数组的最小数字
首先看到这种有序数组的题肯定是想二分，然后就想二分落在的中间位置和左右的关系，来进一步判断要在哪个区间进一步查找

这个题里，二分落在的中间位置不能和left进行判断关系，因为用左边判断无法锁定区间，而用右边判断大小是一定可以判断那个最小的数是在左边还是右边的

注意要考虑一个数字连续出现的情况，在那种极端情况下要列一些case，发现不能抛弃左边，也不能让任何一边等于中间，只能让右边right--了

### 【day05查找算法（中等）】剑指 Offer 50. 第一个只出现一次的字符
主要考察的是Java实现有序词典，加词典的遍历

第一种方法是：两次遍历整个字符串，用普通的HashMap来做

而第二中方法是：第一次遍历整个字符串，按照出现的顺序放入有序的LinkedHashMap中，而在之后只需要遍历LinkedHashMap（按照顺序）即可，因为LinkedHashMap最大长度就是26个字母，远远小于s

操作上：
```java
// 基础操作
Map<Character, Integer> orderDict = new LinkedHashMap<>();
orderDict.put("a", 1);
orderDict.get("a");

// 遍历
for(Map.Entry<Character, Integer> entry: orderDict.entrySet()) {
    entry.getKey();
    entry.getValue();
}
```

### 【搜索与回溯算法（简单）】Offer 32 - I/II/III. 从上到下打印二叉树
三个题基本属于逐级扩展，笔记就全部整理在一块了，二叉树的层序遍历就是用队列实现即可

如果要把每层分别输出，那么需要做类似下边代码的操作
```java
List<List<Integer>> list = new ArrayList<>();
List<Integer> tempList = new ArrayList<>();
list.add(tempList);
```

如果要对其中某一层反向打印的话，这种操作借助一个辅助栈实现即可，栈和队列都可借助Deque + LinkedList实现，区别就是各个方法的不同
```java
Deque<TreeNode> stack = new LinkedList<>();
```
deque是一个双端队列，栈和queue实际上只是用了其中的一部分

一般来说，stack会用到stack.push() - 压栈，stack.pop() - 弹出栈顶， stack.size() - 长度，stack.peek() - 栈顶

queue会用到queue.add() - 插入队尾，queue.push() - 插入队头（实际上双端队列才能这么干）；queue.poll() - 弹出队头；...
