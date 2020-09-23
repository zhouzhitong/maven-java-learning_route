package com.zzt.algorithm.leet_code_2;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/23 19:00
 **/
public class Solution02 {

    public boolean check(char[][] cs, String word) {
        char[] target = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs[i].length; j++) {
                if (checkWay(cs, i, j, target, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWay(char[][] cs, int i, int j, char[] target, int k) {
        if (k == target.length) {
            return true;
        } else {
            char temp;
            if (cs[i][j] == target[k]) {
                temp = cs[i][j];
                cs[i][j] = '1';
                int a;
                k = k + 1;
                if ((a = i + 1) < cs.length && checkWay(cs, a, j, target, k)) {
                    return true;
                } else if ((a = j - 1) >= 0 && checkWay(cs, i, a, target, k)) {
                    return true;
                } else if ((a = i - 1) >= 0 && checkWay(cs, a, j, target, k)) {
                    return true;
                } else if ((a = j + 1) < cs[i].length && checkWay(cs, i, a, target, k)) {
                    return true;
                }
                cs[i][j] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        char[][] cs = {{'A', 'B', 'C', 'E'}
                , {'S', 'F', 'C', 'S'}
                , {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
        String word = "ABCB";
        boolean check = solution02.check(cs, word);
        System.out.println(check);

    }

}
