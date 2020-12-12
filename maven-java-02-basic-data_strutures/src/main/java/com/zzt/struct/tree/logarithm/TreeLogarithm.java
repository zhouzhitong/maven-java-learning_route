package com.zzt.struct.tree.logarithm;

import com.zzt.struct.tree.struct.TreeNode;

/**
 描述：<br>二叉树的对数器
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/12 7:45 **/
public class TreeLogarithm {

    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode node = new TreeNode((int) (Math.random() * maxValue));
        node.left = generate(level + 1, maxLevel, maxValue);
        node.right = generate(level + 1, maxLevel, maxValue);
        return node;
    }

}
