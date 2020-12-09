package com.zzt.struct.tree.struct;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/10 6:30 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
