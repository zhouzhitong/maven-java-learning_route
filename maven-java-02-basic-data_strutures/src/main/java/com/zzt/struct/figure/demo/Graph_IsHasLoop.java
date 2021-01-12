package com.zzt.struct.figure.demo;

import com.zzt.struct.figure.struct.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述：<br> 图的回路检测(通过深度优先遍历实现)
 * </>
 *
 * @author zzt
 */
public class Graph_IsHasLoop {

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        a.nexts.add(b);
        a.nexts.add(c);
        b.nexts.add(c);
        c.nexts.add(d);
//         产生回路
        d.nexts.add(b);
        System.out.println(hasGraphLoop(a));

    }

    public static boolean hasGraphLoop(Node<?> node) {
        return doDfs(node, new HashSet<>());
    }

    private static boolean doDfs(Node<?> node, Set<Node<?>> exitNodes) {
        if (exitNodes.contains(node)) {
            return exitNodes.contains(node);
        }
        exitNodes.add(node);
        for (Node<?> next : node.nexts) {
            boolean b = doDfs(next, exitNodes);
            if (b) {
                return true;
            }
        }
        exitNodes.remove(node);
        return false;
    }
}
