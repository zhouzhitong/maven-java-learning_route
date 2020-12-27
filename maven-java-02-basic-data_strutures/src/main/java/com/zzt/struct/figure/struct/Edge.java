package com.zzt.struct.figure.struct;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 9:08 **/
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
