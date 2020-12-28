package com.zzt.struct.figure.struct;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 **/
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
