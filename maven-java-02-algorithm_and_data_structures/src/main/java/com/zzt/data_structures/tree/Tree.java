package com.zzt.data_structures.tree;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/25 14:28
 */
public class Tree {
    public int val;
    public Tree left;
    public Tree right;

    public Tree(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "val=" + val +
                '}';
    }
}
