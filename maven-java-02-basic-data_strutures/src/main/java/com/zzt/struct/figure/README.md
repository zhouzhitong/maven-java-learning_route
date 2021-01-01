
## 图结构

### 1. 自定义数据结构：

[数据结构：节点信息](struct/Node.java)
```java
/** 节点信息 */
public class Node<T> {

    public T data;
    public Integer in;     // 入度
    public Integer out;    // 出度
    public List<Node<T>> nexts; // 出度的节点集合
    public List<Edge> edges;    // 出度的边集合

    public Node() {
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public Node(T data) {
        this();
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", in=" + in +
                ", out=" + out +
                '}';
    }
}
```

[数据结构：边的信息节点](struct/Edge.java)
```java
/** 边的信息节点 */
public class Edge {

    public int weight;
    public Node<?> fromNode;
    public Node<?> toNode;

    public Edge() {
    }

    public Edge(int weight, Node<?> fromNode, Node<?> toNode) {
        this.weight = weight;
        this.fromNode = fromNode;
        this.toNode = toNode;
    }
}
```

[数据结构：图结构](struct/Graph.java)
```java
/** 图结构 */
public class Graph<T> {
    public Map<Integer, Node<T>> nodeMap;   // 编号 -> 节点信息
    public Set<Edge> edges; // 所有的边 集合
    public Graph() {
        nodeMap = new HashMap<>();
        edges = new HashSet<>();
    }
}
```



#### 1.1 自定义结构，转换成自定义图结构

[转换成自定义图结构](demo/GraphGenerator.java)

- **缺点：** 增加了常数项，因此会导致性能下降

### 2. 常见算法

#### 2.1 图的宽度优先遍历

[图的宽度优先遍历](demo/Graph_BFS_Demo.java)


#### 2.2 图的深度优先遍历
栈结构、递归实现

[图的深度优先遍历](demo/Graph_DFS_Demo.java)


##### 2.3 图的拓扑排序

[判断依据：入度为零先入图](application/Figure_TopSort_Demo01.java)
[判断依据：通过点次进行排序](application/Figure_TopSort_Demo02.java)
[判断依据：通过节点最大深度进行排序](application/Figure_TopSort_Demo03.java)

##### 2.4 图的最小生成树

[最小生成树 Kruskal 算法](application/Figure_Kruskal.java)
[最小生成树 Prim 算法](application/Figure_Prim.java)

##### 2.4 图的节点到任意节点的距离

[图的节点到任意节点的距离 Dijkstra 算法](application/Figure_Dijkstra.java)
[图的节点到任意节点的距离 Dijkstra 算法（优化）](application/Figure_Dijkstra_Demo02.java)

