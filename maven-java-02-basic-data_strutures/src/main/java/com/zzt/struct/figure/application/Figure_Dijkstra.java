package com.zzt.struct.figure.application;

import com.zzt.struct.figure.struct.Edge;
import com.zzt.struct.figure.struct.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述：<br>图的 Dijkstra 算法
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 **/
public class Figure_Dijkstra {

    public static Map<Node<?>, Integer> dijkstra(Node<?> fromNode) {
        Map<Node<?>, Integer> distanceMap = new HashMap<>();
        Set<Node<?>> selectedNodes = new HashSet<>();
        distanceMap.put(fromNode, 0);
        Node<?> minNode = fromNode;
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node<?> toNode = edge.toNode;
                int curWeight = edge.weight + distance;
                if (distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), curWeight));
                } else {
                    distanceMap.put(toNode, curWeight);
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node<?> getMinDistanceAndUnselectedNode(Map<Node<?>, Integer> distanceMap,
                                                           Set<Node<?>> selectedNodes) {
        Node<?> minNode = null;
        int minWeight = Integer.MAX_VALUE;
        for (Map.Entry<Node<?>, Integer> entry : distanceMap.entrySet()) {
            Node<?> key = entry.getKey();
            Integer value = entry.getValue();
            if (!selectedNodes.contains(key) && minWeight > value) {
                minNode = key;
                minWeight = value;
            }
        }
        return minNode;
    }


}
