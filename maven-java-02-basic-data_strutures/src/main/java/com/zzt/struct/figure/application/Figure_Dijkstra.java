package com.zzt.struct.figure.application;

import com.zzt.struct.figure.struct.Edge;
import com.zzt.struct.figure.struct.Node;
import org.w3c.dom.traversal.NodeIterator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 描述：<br>图的 Dijkstra 算法
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/28 22:01 **/
public class Figure_Dijkstra {

    public static Map<Node<?>, Integer> dijkstra1(Node<?> fromNode) {
        Map<Node<?>, Integer> distanceMap = new HashMap<>();
        Set<Node<?>> selectedNodes = new HashSet<>();
        distanceMap.put(fromNode, 0);
        Node<?> minNode = fromNode;
        while (minNode != null) {
            for (Edge edge : minNode.edges) {
                int weight = edge.weight;
                Node<?> toNode = edge.toNode;
                int val = Math.min(distanceMap.getOrDefault(toNode, Integer.MAX_VALUE), distanceMap.get(minNode) + weight);
                distanceMap.put(toNode, val);
            }
            selectedNodes.add(minNode);
            minNode = getMin(distanceMap, selectedNodes);
        }

        return distanceMap;
    }

    private static Node<?> getMin(Map<Node<?>, Integer> nodesMap,
                                  Set<Node<?>> selectedNodes) {
        Node<?> minNode = null;
        Integer minVal = Integer.MAX_VALUE;
        for (Map.Entry<Node<?>, Integer> entry : nodesMap.entrySet()) {
            Node<?> key = entry.getKey();
            Integer value = entry.getValue();
            if (!selectedNodes.contains(key) && value < minVal) {
                minNode = key;
                minVal = value;
            }
        }
        return minNode;
    }


}
