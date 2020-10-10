package com.zzt.data_structures.and_collect;

import java.util.HashMap;
import java.util.List;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/10 9:23
 */
public class UnionFindDemo {


    private static class UnionFind<V> {
        /**
         * V --> 节点（Node）
         */
        private HashMap<V, Node<V>> nodes;
        /**
         * 节点 --> 父节点
         */
        private HashMap<Node<V>, Node<V>> parent;
        /**
         * 该节点下的集合大小
         */
        private HashMap<Node<V>, Integer> sizeMap;

        public UnionFind(List<V> nodes) {
            // 初始化操作：刚加进来的值
            for (V v : nodes) {
                Node<V> node = new Node<>(v);
                this.nodes.put(v, node);
                this.parent.put(node, node);
                this.sizeMap.put(node, 1);
            }
        }

    }
}
