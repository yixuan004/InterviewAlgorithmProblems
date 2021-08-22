# HashMap的一些用法

构造和主要方法
```java
// 构造方法，有一种key，value的关系，这个Map看起来也就是Python的dict类似的东西
Map<Node, Node> map = new HashMap<>();

// 主要方法是
map.put(A, B); // 向字典中赋值类似的操作
map.get(x); // 从字典中根据key取value的操作
```

如何遍历一个HashMap()
```java
System.out.println("通过Map.entrySet遍历key和value");
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
}
```

