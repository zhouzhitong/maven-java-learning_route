package com.zzt.struct.figure.struct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 9:15 **/
public class Graph<T> {

    public Map<Integer, Node<T>> nodeMap;   // 编号 -> 节点信息
    public Set<Edge> edges; // 所有的边 集合

    public Graph() {
        nodeMap = new HashMap<>();
        edges = new HashSet<>();
    }

}
