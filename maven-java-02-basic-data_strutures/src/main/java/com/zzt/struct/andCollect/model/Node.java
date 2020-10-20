package com.zzt.struct.andCollect.model;

import java.util.Objects;

/**
 * 描述：<br>节点信息
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 21:52
 **/
public class Node<V> {

    public V v;

    public Node(V v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node<?> node = (Node<?>) o;
        return Objects.equals(v, node.v);
    }

    @Override
    public int hashCode() {
        return v != null ? v.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + v +
                '}';
    }
}
