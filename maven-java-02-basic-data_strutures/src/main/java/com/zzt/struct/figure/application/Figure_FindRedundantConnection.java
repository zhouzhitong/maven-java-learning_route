package com.zzt.struct.figure.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 684. 冗余连接
 https://leetcode-cn.com/problems/redundant-connection/ */
public class Figure_FindRedundantConnection {

    @Test
    public void test01() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] redundantConnection = new Solution().findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection));
    }

    private static class Solution {

        Map<Integer, List<Integer>> graph;
        int[] redundant = new int[2];

        public int[] findRedundantConnection(int[][] edges) {
            graph = new HashMap<>();
            for (int[] edge : edges) {
                List<Integer> nexts = graph.getOrDefault(edge[0], new ArrayList<>());
                nexts.add(edge[1]);
                graph.put(edge[0], nexts);
            }
            doDfs(graph, edges[0][0], new HashSet<>());
            return redundant;
        }

        private boolean doDfs(Map<Integer, List<Integer>> graph, int node,
                              Set<Integer> exitNodes) {
            if (exitNodes.contains(node)) {
                return true;
            }
            List<Integer> nexts = graph.get(node);
            exitNodes.add(node);
            boolean flag = false;
            for (Integer next : nexts) {
                boolean b = doDfs(graph, next, exitNodes);
                if (b) {
                    redundant[0] = node;
                    redundant[1] = next;
                    flag = true;
                }
            }
            exitNodes.remove(node);
            return flag;
        }

    }

}
