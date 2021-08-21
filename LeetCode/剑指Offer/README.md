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

