package com.zzt.struct.scheme.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 描述：<br>节点信息
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 18:05
 */
public class Node<T,E> {
    // 节点值
    public T val;
    /**
     * 入度数
     */
    public Integer in;
    /**
     * 出度数
     */
    public Integer out;
    /**
     * 下一个节点
     */
    public List<Node<T,E>> nexts;
    /**
     * 边界属性（出度的）
     */
    public List<Edge<Integer>> edges;

    public Node(T val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node<?, ?> node = (Node<?, ?>) o;

        return Objects.equals(val, node.val);
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", in=" + in +
                ", out=" + out +
                '}';
    }

    @Override
    public int hashCode() {
        return val != null ? val.hashCode() : 0;
    }
}
