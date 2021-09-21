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

### 【day06搜索与回溯算法（简单）】Offer 32 - I/II/III. 从上到下打印二叉树
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

### 【day07搜索与回溯算法（简单）】剑指 Offer 26. 树的子结构
给定二叉树A，B，判断B是不是A的一个子结构。

这个题首先的思路是要遍历二叉树A（一般这种遍历用递归前序遍历是最方便的），把A的每个节点都当做根节点，然后来和B进行比较

其次就是实现比较函数judge，也是使用一种递归的方式，注意二叉树需要很多判空的操作，如果当前节点上AB都是null就是true；A是nullB有就是false；特别注意如果A有B是null，由于只要求B是A的子结构即可，所以也是true；而当AB均不是null的时候，则递归return judge(A.left, B.left) && judge(A.right, B.left)；

注意在外层循环时的比较return方法，也要判断A B是不是null的情况，当A B都不是null的时候，return judeg(A, B) && isSubStructure(A.left, B) && isSubStructure(A.right, B); 代表几个递归下去中，只要有一组满足条件即可了；

### 【day07搜索与回溯算法（简单）】剑指 Offer 27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

有两种解法，第一种方法是递归的解法，TreeNode mirror(TreeNode root)这个函数递归调用
```java
TreeNode mirrorTree(TreeNode root) {
    if (root != null) {
        TreeNode tempNode = root.left;
        root.left = mirrorTree(root.right); // 调用镜像递归下去
        root.right = mirrorTree(root.left);
    }
    return root;
}
```

第二种方法是栈的解法，基本思想的描述是首先把root入栈，之后把root出栈，把root的左边 右边依次入栈，然后调转root的左边右边；之后再重复pop - 处理的操作，直到栈为空

有一种把每个节点的左右依次倒转的感觉

### 【day07搜索与回溯算法（简单）】剑指 Offer 28. 对称的二叉树
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

基本就是实现一个recurseJudge函数，针对两个节点判断A的左边是不是等于B的右边，A的右边是不是等于B的左边，注意要用TreeNode.val来判断
```java
boolean recurseJudge(TreeNode t1, TreeNode t2) {
    // 仅给出都不为null的情况
    if (t1 != null && t2 != null) {
        if (t1.val == t2.val) {
            return recurseJudge(t1.left, t2.right) && recurseJudge(t1.right, t2.left);
        } else {
        return false;
        }
    }
    ...
}
```

在主执行程序中把根的左右作为首次入口（注意判断null等情况）
```java
recurseJudege(root.left, root.right)
```

### 【day08动态规划（简单）】剑指 Offer 10- I. 斐波那契数列
这个题基本没有什么难点，如果没记错的话这种最好不要用数组存储，还要开辟新的内存空间？

### 【day08动态规划（简单）】Offer 10- II. 青蛙跳台阶问题
这个题也比较简单，只要想到通向递推即可，到达第n节台阶的方法，等于到达第n-2节台阶的方法+到达第n-1节台阶的方法（因为一次可以跳1下或者2下）

### 【day08动态规划（简单）】剑指 Offer 63. 股票的最大利润
这个题感觉可以算中等题里比较好想的，假设以一个比较小的值2开头，那么如果不出现比2小的值的情况下，只要不断顺序遍历找到那个最大的差就可以。而如果出现了比2小的值（例如1）的情况下，需要更新最小值为1，因为即使后边出现了更大的数，那么这个数-1也比这个数-2大；

### 【day09动态规划（中等）】剑指 Offer 42. 连续子数组的最大和
题目大意：输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

这个题感觉就是要对各个额情况进行一个分析，判断每次数组输入和0的比较状态，以及当前的最大值和0的状态，巧用0以上的数进行累加更新

另外注意对于小于0的数case -2 -1，要进行处理。这个题感觉还是那种比较巧妙的状态，后续可能需要多做几遍理解。

### 【day09动态规划（中等）】剑指 Offer 47. 礼物的最大价值
题目大意：在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

虽然标注是中等的题目，但实际上是一个比较容易看出来的二维dp题，先把第一行和第一列的初始化赋值好后很快就能解决。

### 【day10动态规划（中等）】剑指 Offer 46. 把数字翻译成字符串
题目大意：给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     
这个题可能需要记忆一下来理解动态规划的套路了，第0个位置作为初始化的位置，在这之后，到第i个位置所能翻译出来的次数，如果i位置和i-1位置能组合成一个10-25的数值的话那么可以翻译出dp[i-1]+dp[i-2]种情况，如果不能和前一个数字进行组合则还是翻译出dp[i-1]种情况、

这种题感觉解释了一些指数扩张的情况，对于一看需要指数扩张的题，很有可能就是dp？

另补充一种String对象的compareTo方法

```java
str.compareTo("25"); 如果str那个数字比25大，则会返回>0的数字；如果比25小，则会返回<0的数字；等于返回0
```

### 【day10动态规划（中等）】剑指 Offer 48. 最长不含重复字符的子字符串
题目大意：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

这个题主要是需要记住创建dp数组的含义，dp数组的含义是截止到当前这个角标位置处的最长不含重复字符的子字符串长度

之后要分情况讨论了，使用了Map<Character, Integer> orderDict = new LinkedHashMap<>();创建词典，如果不在就加入进来，如果在的话则还需要进一步判断，主要是以dp[i-1]位置处的长度，如果这个长度范围内包括了那个字母，则用那个字母到最后的距离，否则使用dp[i-1]+1作为长度；

### 【day11双指针（简单）】剑指 Offer 18. 删除链表的节点
题目大意：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。

这个题自己感觉比较需要注意的地方是链表的删除方法，删除的那个节点，要使得指针指向那个节点的前一个节点，然后做一个简单的删除操作就可以了。

### 【day11双指针（简单）】剑指 Offer 22. 链表中倒数第k个节点
题目大意：输入一个链表，输出该链表中倒数第k个节点。

这个题目双指针的方法很巧妙，需要记录下之后遇到就比较好处理了，让两个指针的间隔为k，之后当前边的指针达到链表结尾后，另外一个指针的位置就是倒数第k个了。

### 【day12双指针（简单）】剑指 Offer 25. 合并两个排序的链表
题目大意：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

这个题比较简单，不断遍历两个链表，把更小的值加入就可以（注意这里其中有一个逻辑条件要用&&）。最后哪个链表为空了跳出，把另外一个链表全拼到结尾就可以。

### 【day12双指针（简单）】剑指 Offer 52. 两个链表的第一个公共节点
题目大意：输入两个链表，找出它们的第一个公共节点。

其中一种比较广泛可以使用的做法是HashSet的做法，先把A链表遍历一遍，全部存进HashSet中，然后遍历B链表，如果某个节点已经在HashSet中了，那这个节点就是交集了。

也在这里复习一下HashSet和HashMap的使用方法，set感觉只支持在不在，而map的存储空间肯定是要更高一些的
```java
Set<ListNode> s = new HashSet<>();
s.add(); // 会返回bool值，代表是否成功加入了
s.remove(); // 会返回bool值，代表是否成功删除了

Map<Node, Node> mp = new HashMap<>();
hmap.put();
hmap.get();
```

### 【day13双指针（简单）】剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
题目大意：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

基本思想：一个从前往后，一个从后往前，不断用这两个"指针"进行替换就可以了

### 【day13双指针（简单）】剑指 Offer 57. 和为s的两个数字
题目大意：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     
基本思想：还是一个指针在最前边，另外一个指针在最后边。因为是有序的，这样如果两个指针位置处的数字相加太大了，就让后边的往期拿走，太小了就让前边的往后走

### 【day13双指针（简单）】剑指 Offer 58 - I. 翻转单词顺序
题目大意：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

基本思想：

java中有trim方法，类似于python中的strip方法可以过滤掉首尾的空格；

另外还有StringBuilder类，strBuild.toString()就可以转化为String引用类型！，sb.append()方法用来添加

另java中也有split方法，其中要求接收字符串格式的输入

```java
String strs[] = s.trim().split(" "); 

StringBuilder sb = new StringBuilder();
sb.append();
sb.toString();
```

### 【day14搜索与回溯算法（中等）】剑指 Offer 12. 矩阵中的路径
题目大意：给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

个人分析：由于只是找到存在不存在，需要首先想到用一种dfs的思想来做

主函数中很容易就能想到从矩阵当中的每个位置开启dfs，所以是一个双重循环

而在每个循环到的位置处执行dfs程序，每次都要传递这个board 和 单词word

dfs的编写思想如下所示：
首先给出口，如果是越界了的情况，或者board这个位置不等于word.charAt(jishu)，则return false; 
之后，写正确的退出条件，if (jishu == word.length - 1)，return true；
之后是四个方向的dfs，并且需要标记哪个位置被访问过了，首先board[i][j]='\0'代表这个位置访问，之后for 0-4来走四个方向（dx dy nx ny），最后回滚退回到上一个状态board[i][j]=word.chatAt(jishu)

```java
boolean result = dfs(board, word, nx, ny, jishu + 1);
if (result == true) {
    return true; // 这种方法应该能起到剪枝效果吧
}
```

### 【day14搜索与回溯算法（中等）】剑指 Offer 13. 机器人的运动范围
题目大意：地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

个人分析：因为有多条路线，广度优先和深度优先都可以，或者说多条的比较适合广度，存在性比较适合深度？或者说这种从固定位置开始的，就需要用广度优先？而counting lakes这种多个位置开始的，深度优先？

这个题想到广度优先后就很简单了，广度优先主要是使用队列的做法，初始化把开始那个位置加进去，并设置visited数组，visited和queue可以全局
```java
Deque<int[]> queue = new LinkedList<>(); // 这是类似C++的pair操作，要把x y同时加入queue中
```
这个题judge函数也比较好写，% /用一下就可以了

### 【day15搜索与回溯算法（中等）】剑指 Offer 34. 二叉树中和为某一值的路径
题目大意：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

个人分析：使用前序遍历dfs，dfs函数的内部是：1.为null的结束条件；2.加上这个路径值，并让target -= 这个路径值；3.条件判断，如果满足条件了，则把现有的tempList加到主list；4.遍历左右；5.回溯回来，remove掉最后一个，就像前序遍历一样

注意以下一些代码操作：
```java
// 这两个列表对于这种回溯的题，如果没有特殊要求的话可以写到全局里边
List<List<Integer>> resultList = new ArrayList<>();
List<Integer> tempList = new ArrayList<>();

// ArrayList的添加和删除方法
tempList.add(Integer);
tempList.remove(index);
```

### 【day15搜索与回溯算法（中等）】剑指 Offer 36. 二叉搜索树与双向链表
题目大意：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

个人分析：比较简单，二叉搜索树的特性中序遍历就可以了，把每个地方加入到一个tempList里，然后往左走一轮，往右走一轮

### 【day15搜索与回溯算法（中等）】剑指 Offer 54. 二叉搜索树的第k大节点
题目大意：剑指 Offer 54. 二叉搜索树的第k大节点

个人分析：二叉搜索树的中序遍历就可以，然后在递归的过程中通过计数（暂时使用的是全局count），找到第k大的就可以了

### 【day16排序（简单）】剑指 Offer 45. 把数组排成最小的数
题目大意：输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

个人分析：这个题看到答案说证明起来比较困难，但是也先使用这种方法记录一下了，大致思路就是先把nums转化为一个个String类型的str，形成strs数组，然后通过如下的排序方式
```java
Arrays.sort(strNums, (x, y) -> {
    return (x + y).compareTo(y + x);
});
```
最后用StringBuilder进行append操作，result.append(str),result.toString()即可

### 【day16排序（简单）】剑指 Offer 61. 扑克牌中的顺子

题目大意：从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     
个人分析：对于int[] 类型的排序如果要按照某些条件的话，按照目前的理解来说好像要转化成Integer[]才能使用带有条件的排序
```java
Integer[] numIntegers = new Integer[nums.length];
for (int i = 0; i < nums.length; i++) {
    numIntegers[i] = Integer.valueOf(nums[i]);
}

Arrays.sort(numIntegers, (x, y) -> {
    return x - y; // 这里可以写多级排序的条件
});

for (int i = 0; i < nums.length; i++) {
    System.out.println(numIntegers[i].intValue());
}
```
之后大概就是计数有多少0，然后用0来做一个间隔填空的感觉了

### 【day17排序（中等）】剑指 Offer 40. 最小的k个数

题目大意：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

个人分析：这个题本意不是想让人来用Arrays.sort()直接用的，是希望自己整个快排一类的，但是在首轮刷题就用比较简单的方法实现了；

### 【day18搜索与回溯算法（中等）】剑指 Offer 55 - I. 二叉树的深度

题目大意： 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

个人分析：这种二叉树的深度要搞成一种模板的操作，遇到二叉树的深度就这么写
```java
public int getDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
}
```

### 【day18搜索与回溯算法（中等）】剑指 Offer 55 - II. 平衡二叉树

题目大意：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

个人分析：首先需要实现一个返回值为二叉树深度的函数，使用55-I的public int getDepth(TreeNode root)即可

在之后，在主返回函数中递归这种操作还是需要时常操作+理解的，非常巧妙

```java
public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true;
    }
    return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
}
```

### 【day19搜索与回溯算法（中等）】剑指 Offer 64. 求1+2+…+n

题目大意：求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

个人分析：这类题非常需要技巧并且需要之前了解过。在看过答案后感觉很巧妙，需要使用判断条件&&中的熔断技巧。
```java
// 首先把result设置为全局变量，在递归的过程中方便进行累加
public int sumNums(int n) {
    // 在n大于1的条件下，前边不会熔断，所以会进入到后边的递归中；而当n = 1时是一个结束递归的条件，此时由于&&的熔断机制，不会执行后边的语句
    // 由于sumNums(n - 1)的返回值是int而不是boolean，所以需要加一个随意的永真判断条件
    boolean x = (n > 1) && sumsNums(n - 1) > 0; 
    
    // 递归出栈会从这里不断地累加，有时间的话需要自己手动模拟下这种情况
    result += n;
    return result;
}
```

### 【day19搜索与回溯算法（中等）】剑指 Offer 68 - I. 二叉搜索树的最近公共祖先

题目大意：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

个人分析：根据这种最近公共祖先的定义，只有几种情况：

p和q在其公共祖先的两边；p是q的祖先（p是root）；q是p的祖先（q是root）

而这些条件的反条件是，p和q完全处在root的一边，这样需要在完全的那一边开启递归，而因为题目给出了二叉搜索树的条件，可以通过val来判断

注意递归中，最后else的条件代表都满足了，return root即可

### 【day19搜索与回溯算法（中等）】剑指 Offer 68 - II. 二叉树的最近公共祖先

题目大意：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

个人分析：和上一个题相比少了搜索树这一条件难度就加大了有一些，没有办法通过val来判断了，套前序遍历框架逐个节点的看

如果root为空，或者root是p，或者root是q，就返回这个root。为空代表没找到，为p或者q代表在当前这个递归节中找到了

前序遍历，获取当前节点a的左边和右边是否有返回值，此时有4种情况应该分开讨论

左右都是null：这个节点的左右都找不到，那么这个节点不是最近公共祖先，return null

左null，右非null，代表出现p q连在一起的情况，return非null的右边

左非null，右null：带便出现p q连在一起的情况，return非null的左边

左右都非null：当前root就是最近公共祖先，return root

