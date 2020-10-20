package com.zzt.struct.andCollect.model;

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
    public Node from;
    public Node to;

    public Edge(T weight) {
        this.weight = weight;
    }
}
