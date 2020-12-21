package com.zzt.struct.andCollect;

import com.zzt.struct.andCollect.model.Node;

import java.util.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 **/
public class UnionSet<V> {

    /**
     * 描述：存储节点信息
     * 节点值 ---> 节点对象
     */
    private Map<V, Node<V>> nodesMap;
    // 子节点 ---> 父节点
    private Map<Node<V>, Node<V>> parentMap;
    // 最终父节点 ---> 子节点数量
    private Map<Node<V>, Integer> sizeMap;

    public UnionSet() {
        this.nodesMap = new HashMap<>();
        this.parentMap = new HashMap<>();
        this.sizeMap = new HashMap<>();
    }

    /** 初始化 设置节点 信息 */
    public UnionSet(List<V> nodes) {
        this();
        for (V node : nodes) {
            setNode(node, new Node<>(node));
        }
    }

    private void setNode(V v, Node<V> node) {
        nodesMap.put(v, node);
        parentMap.put(node, node);
        sizeMap.put(node, 1);
    }

    /** 向上查找 最上层的 父节点 */
    public Node<V> findFather(Node<V> node) {
        Stack<Node<V>> stack = new Stack<>();   // 优化
        while (node != parentMap.get(node)) {
            stack.push(node);
            node = parentMap.get(node);
        }
        // 优化：将查询过的（非最上层的）上层父节点，与 最上层父节点 连接
        while (!stack.isEmpty()) {
            parentMap.put(stack.pop(), node);
        }
        return node;
    }

    /** 判断是否在同一个集合中（有共同的父节点） */
    public boolean isSameSet(V a, V b) {
        return findFather(new Node<>(a)).equals(findFather(new Node<>(b)));
    }

    /** 两个节点融合 */
    public void union(V a, V b) {
        if (!nodesMap.containsKey(a) || !nodesMap.containsKey(b)) {
            return;
        }
        /*Node<V> aNode = parentMap.get(new Node<>(a));
        Node<V> bNode = parentMap.get(new Node<>(b));*/
        Node<V> aNode = findFather(new Node<>(a));
        Node<V> bNode = findFather(new Node<>(b));
        if (!aNode.equals(bNode)) {
            int aSize = sizeMap.get(aNode);
            int bSize = sizeMap.get(bNode);

            /*if (aSize < bSize) {
                parentMap.put(aNode, bNode);
                sizeMap.put(bNode, aSize + bSize);
                sizeMap.remove(aNode);
            } else {
                parentMap.put(bNode, aNode);
                sizeMap.put(aNode, aSize + bSize);
                sizeMap.remove(bNode);
            }*/

            /*Node<V> big = aSize < bSize ? bNode : aNode;
            Node<V> small = big == aNode ? bNode : aNode;
            parentMap.put(small, big);
            sizeMap.put(big, aSize + bSize);
            sizeMap.remove(small);*/

            if (aSize < bSize) {
                union(bNode, aNode, aSize + bSize);
            } else {
                union(aNode, bNode, aSize + bSize);
            }

        }
    }

    private void union(Node<V> big, Node<V> small, int size) {
        parentMap.put(small, big);
        sizeMap.put(big, size);
        sizeMap.remove(small);
    }

}
