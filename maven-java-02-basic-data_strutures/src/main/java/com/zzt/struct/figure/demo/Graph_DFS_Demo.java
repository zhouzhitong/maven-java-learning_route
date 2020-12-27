package com.zzt.struct.figure.demo;

import com.zzt.struct.figure.struct.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 描述：<br> 图结构的深度优先遍历
 1. 递归实现
 @see #dfs(Node)
 2. 栈结构实现
 @see #dfsTraverse(Node)
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 9:36 **/
public class Graph_DFS_Demo {

    /**
     【栈结构实现】
     @param node
     */
    public static void dfsTraverse(Node<?> node) {
        if (node == null) {
            return;
        }
        Stack<Node<?>> stack = new Stack<>();
        Set<Node<?>> set = new HashSet<>();
        System.out.println(node);
        stack.push(node);
        set.add(node);
        while (!stack.isEmpty()) {
            Node<?> cur = stack.pop();
            for (Node<?> next : cur.nexts) {
                if (!set.contains(next)) {
                    System.out.println(next.data);
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    break;
                }
            }
        }
    }


    /**
     【递归实现】
     @param node
     */
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
