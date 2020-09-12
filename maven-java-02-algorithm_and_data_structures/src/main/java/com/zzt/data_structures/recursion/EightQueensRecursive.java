package com.zzt.data_structures.recursion;

/**
 * 描述：<br>递归：八皇后问题
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/12 14:28
 */
public class EightQueensRecursive {
    private int max;
    private int[] arr;
    private int count = 0;

    public EightQueensRecursive(int max) {
        this.max = max;
        arr = new int[max];
    }

    public void check(int n) {
        if (n == max) {
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {//判断是否产生冲突
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(arr[i] - arr[n]) == Math.abs(i - n)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        EightQueensRecursive queen = new EightQueensRecursive(8);
        queen.check(0);
        System.out.println(queen.count);
    }
}
