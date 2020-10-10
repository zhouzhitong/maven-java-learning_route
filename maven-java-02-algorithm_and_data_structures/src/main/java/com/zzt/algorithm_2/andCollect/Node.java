package com.zzt.algorithm_2.andCollect;

import java.util.Objects;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/10 9:22
 */
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
        return v.equals(node.v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}
