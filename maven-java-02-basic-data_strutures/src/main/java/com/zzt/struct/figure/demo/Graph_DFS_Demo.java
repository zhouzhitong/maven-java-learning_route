package com.zzt.struct.figure.demo;

import com.zzt.struct.figure.struct.Node;

import java.util.HashSet;
import java.util.Set;

/**
 描述：<br> 图结构的宽度优先遍历
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 9:36 **/
public class Graph_DFS_Demo {

    public static void dfs(Node<?> node) {
        doDfs(node, new HashSet<>());
    }

    private static void doDfs(Node<?> node, Set<Node<?>> exitNodes) {
        if (exitNodes.contains(node)) {
            return;
        }
        exitNodes.add(node);
        System.out.println(node.data);
        for (Node<?> next : node.nexts) {
            doDfs(next, exitNodes);
        }
    }

}
