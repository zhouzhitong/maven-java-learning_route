package com.zzt.algorithm_2.greedy;

/**
 * 描述：<br>str = "X...X...X...XXX.X" ;
 * 'X' ：墙
 * '.' ：需要照亮的居民区
 * 要求：一个灯只能放在 '.' 上或旁边，且只能照亮旁边最近的房间'.'
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/5 23:40
 **/
public class GreedyDemo01_Light {

    public static int getMinLight(String str) {
        char[] chars = str.toCharArray();
        int sum = 0;
        int count = 0;
        boolean f = false;
        for (char c : chars) {
            if (c == '.') {
                count++;
                f = true;
            } else {
                if (f) {
                    sum += count / 3 + (count % 3 == 0 ? 0 : 1);
                    count = 0;
                    f = false;
                }
            }
        }
        if (f) {
            sum = count / 3 + count % 3 == 0 ? 0 : 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "X...XXX..XX.XX....X.......XXX.X.X";
//        String str = "X.......XXX...X";
        int minLight = getMinLight(str);
        System.out.println(minLight);
    }

}
