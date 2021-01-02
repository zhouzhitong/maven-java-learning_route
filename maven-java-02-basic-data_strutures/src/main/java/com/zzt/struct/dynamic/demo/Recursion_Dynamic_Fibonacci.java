package com.zzt.struct.dynamic.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 描述：<br>求 斐波那契数列 的 第 n 项
 </>
 @author 周志通
 @version 1.0.0
 @date 2021/1/2 14:41 **/
public class Recursion_Dynamic_Fibonacci {

    @Test
    public void test01() {
        int fibonacci = getFibonacci(6);
        System.out.println(fibonacci);
    }

    public int getFibonacci2(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return getFibonacci2(num - 1) + getFibonacci2(num - 2);
    }

    // 动态规划版本
    public int getFibonacci(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        return process(num, map);
    }

    private int process(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int n_1 = process(n - 1, map);
        int n_2 = process(n - 2, map);
        int fN = n_1 + n_2;
        map.put(n - 1, n_1);
        map.put(n - 2, n_2);
        map.put(n, fN);
        return fN;
    }

}
