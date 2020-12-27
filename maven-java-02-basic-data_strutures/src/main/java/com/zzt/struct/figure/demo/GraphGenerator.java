package com.zzt.struct.figure.demo;

import com.zzt.struct.figure.struct.Edge;
import com.zzt.struct.figure.struct.Graph;
import com.zzt.struct.figure.struct.Node;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 9:18 **/
public class GraphGenerator {

    // matrix 所有的边
    // N*3 的矩阵
    // [weight, from节点上面的值，to节点上面的值]
    public static Graph<Integer> createGraph(Integer[][] matrix) {
        Graph<Integer> graph = new Graph<>();
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i][0];
            int fromData = matrix[i][0];
            int toData = matrix[i][0];

            if (graph.nodeMap.containsKey(fromData)) {
                graph.nodeMap.put(fromData, new Node<>(fromData));
            }
            if (graph.nodeMap.containsKey(toData)) {
                graph.nodeMap.put(toData, new Node<>(toData));
            }
            Node<Integer> fromNode = graph.nodeMap.get(fromData);
            Node<Integer> toNode = graph.nodeMap.get(toData);
            Edge edge = new Edge(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }

        return graph;
    }

}
