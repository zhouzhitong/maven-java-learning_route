package com.zzt.algorithm_2.leetCode_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 10:16
 */
public class Solution_Ali_001 {

    public String[] getTime(Integer[] arr) {
        String[] str = new String[2];
        Arrays.sort(arr);
        if (arr[0] > 2) {
            return null;
        }
        int[] counts = new int[arr.length];
        str[0] = getMinTime(arr, counts);
        System.out.println(str[0]);
        return str;
    }

    private String getMinTime(Integer[] arr, int[] counts) {
        int h, m, s = 0;
        for (int i = 0; i < arr.length; i++) {
            h = arr[i];
            if (h > 2) {
                break;
            }
            counts[i] = 1;
            for (int j = 0; j < arr.length; j++) {
                if (counts[j] == 1) {
                    continue;
                }
                h = h * 10 + arr[j];
                if (h > 23) {
                    counts[i] = 0;
                    break;
                }
                counts[j] = 1;
                // 成功获取合法的 最小的小时
                // 开始获取合法的 最小分钟
                for (int k = 0; k < arr.length; k++) {
                    if (counts[k] == 1) {
                        continue;
                    }
                    if ((m = arr[k]) > 5) {
                        break;
                    }
                    counts[k] = 1;
                    for (int l = 0; l < arr.length; l++) {
                        if (counts[l] == 1) {
                            continue;
                        }
                        if ((m = m * 10 + arr[l]) > 59) {
                            break;
                        }
                        counts[l] = 1;
                        // 成功获取合法的 最小分钟
                        // 开始获取合法的 最小秒钟
                        for (int n = 0; n < counts.length; n++) {
                            if (counts[n] == 0) {
                                s = s * 10 + arr[n];
                            }
                        }
                        if (s > 60) {
                            counts[l] = 0;
                            s = 0;
                            continue;
                        }
                        /*for (int n = 0; n < arr.length; n++) {
                            if (counts[n] == 1) {
                                continue;
                            }
                            if ((s = arr[n]) > 5) {
                                break;
                            }
                            counts[n] = 1;
                            for (int o = 0; o < arr.length; o++) {

                            }
                        }*/
                        return h + ":" + m + ":" + s;
                    }
                    counts[k] = 0;
                }
                counts[j] = 0;
            }
            counts[i] = 0;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 6, 4, 5, 7};
        String[] time = new Solution_Ali_001().getTime(arr);
//        System.out.println(time[0]);
    }

}
