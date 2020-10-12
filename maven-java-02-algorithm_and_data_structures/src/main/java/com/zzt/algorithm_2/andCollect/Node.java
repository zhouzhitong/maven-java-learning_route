package com.zzt.algorithm_2.andCollect;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>点结构描述： A  0
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/10 9:22
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}