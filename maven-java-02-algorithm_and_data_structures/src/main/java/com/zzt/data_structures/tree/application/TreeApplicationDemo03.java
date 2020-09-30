package com.zzt.data_structures.tree.application;

/**
 * 描述：<br>二叉树的，中序遍历应用
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/30 10:56
 **/
public class TreeApplicationDemo03 {

    public static void print(int n) {
        printProcess(1, n, true);
    }

    /**
     * @param i    节点的层数
     * @param n    一共的层数
     * @param down true：凹; false: 凸
     */
    private static void printProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }

        printProcess(i + 1, n, true);
        System.out.print(down ? " 凹 " : " 凸 ");
        printProcess(i + 1, n, false);

    }

    public static void main(String[] args) {
        int n = 3;
        print(n);
    }

}
