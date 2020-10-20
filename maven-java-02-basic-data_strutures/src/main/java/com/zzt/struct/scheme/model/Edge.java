package com.zzt.struct.scheme.model;

/**
 * 描述：<br>边属性
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 18:04
 */
public class Edge<T> {
    public T weight;
    public Node<?, T> from;
    public Node<?, T> to;

    public Edge(T weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
