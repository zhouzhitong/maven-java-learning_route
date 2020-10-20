package com.zzt.struct.andCollect;

import com.zzt.struct.andCollect.model.Node;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 18:10
 */
public class UnionFindDemo01 {

    @Test
    public void test01() {

    }

    // Union-Find Set
    private static class UnionFind<N, E> {

        /**
         * 父节点信息
         */
        private Map<Node<N, E>, Node<N, E>> fatherMap;
        /**
         * 节点的大小信息
         */
        private Map<Node<N, E>, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        // 初始化
        public void makeSets(Collection<Node<N, E>> nodes) {

        }

        // 找父节点
        private Node<N, E> findFather(Node<N, E> n) {

            return n;
        }

        // 判断两个节点，是否是同一个父节点
        public boolean isSameSet(Node<N, E> a, Node<N, E> b) {
            return false;
        }

        // 结合节点a 、b ;
        public void union(Node<N, E> a, Node<N, E> b) {

        }

    }

}
