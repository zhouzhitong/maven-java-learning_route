package com.zzt.struct.figure.demo;

import com.zzt.struct.figure.struct.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 描述：<br> 图结构的 宽度优先遍历
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 9:32 **/
public class Graph_BFS_Demo {

    public static void bfs(Node<?> node) {
        Queue<Node<?>> queue = new LinkedList<>();
        Set<Node<?>> exitNode = new HashSet<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<?> poll = queue.poll();
            System.out.println(poll.data);
            for (Node<?> next : poll.nexts) {
                if (!exitNode.contains(next)) {
                    exitNode.add(next);
                    queue.offer(next);
                }
            }
        }

    }

}
