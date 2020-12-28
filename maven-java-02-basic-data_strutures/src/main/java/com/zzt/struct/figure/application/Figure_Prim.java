package com.zzt.struct.figure.application;

import com.zzt.struct.figure.struct.Edge;
import com.zzt.struct.figure.struct.Graph;
import com.zzt.struct.figure.struct.Node;

import java.util.*;

/**
 描述：<br>图：最小生成树 Prim 算法
 </>
 @author zzt */
public class Figure_Prim {

    public static Set<Edge> kruskalMST(Graph<?> graph) {
        Set<Edge> edges = new HashSet<>();
        Set<Node<?>> nodes = new HashSet<>();
        PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>(new MyEdgeComparator());
        for (Node<?> node : graph.nodeMap.values()) {
            if (!nodes.contains(node)) {
                node.edges.forEach(edgePriorityQueue::offer);
                nodes.add(node);
                while (!edgePriorityQueue.isEmpty()) {
                    Edge curEdge = edgePriorityQueue.poll();
                    Node<?> toNode = curEdge.toNode;
                    if (!nodes.contains(toNode)) {
                        nodes.add(toNode);
                        edges.add(curEdge);
                        toNode.edges.forEach(edgePriorityQueue::offer);
                    }
                }
            }
        }
        return edges;
    }

    private static class MyEdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

}
