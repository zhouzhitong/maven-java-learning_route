package com.zzt.struct.figure.application;

import com.zzt.struct.figure.struct.Graph;
import com.zzt.struct.figure.struct.Node;

import java.util.*;

/**
 描述：<br> 图的 拓扑结构 排序
 入度为零先入图
 </>
 @author zzt */
public class Figure_TopSort_Demo01 {

    public static List<Node<?>> topSort(Graph<?> graph) {
        List<Node<?>> result = new ArrayList<>();
        // key：某一个node
        // value：剩余的入度
        HashMap<Node<?>, Integer> nodes = new HashMap<>();
        // 入度为零 的队列
        Queue<Node<?>> zeroInQueue = new LinkedList<>();

        for (Node<?> value : graph.nodeMap.values()) {
            nodes.put(value, value.in);
            if (value.in == 0) {
                zeroInQueue.offer(value);
            }
        }
        while (!zeroInQueue.isEmpty()) {
            Node<?> cur = zeroInQueue.poll();
            result.add(cur);
            for (Node<?> next : cur.nexts) {
                int in = nodes.get(next) - 1;
                nodes.put(next, in);
                if (in == 0) {
                    zeroInQueue.offer(next);
                }
            }
        }
        return result;
    }

}
