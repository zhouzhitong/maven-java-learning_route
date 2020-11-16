package com.zzt.logarithm;

import java.util.Random;

/**
 * 描述：<br>对数器
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/24 18:03
 **/
public class Logarithm {
    private static int maxLen = 10;
    private static int maxValue = 100;

    public static int[] getArr(int maxLen) {
        Logarithm.maxLen = maxLen;
        return getArr();
    }

    public static int[] getArr(int maxLen, int maxValue) {
        Logarithm.maxLen = maxLen;
        Logarithm.maxValue = maxValue;
        return getArr();
    }


    public static int[] getArr() {
        Random random = new Random();
        int anInt = random.nextInt(maxLen);
        int[] arr = new int[anInt];
        if (maxValue == 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt();
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(maxValue);
            }
        }
        return arr;
    }
}
