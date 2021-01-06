package com.zzt.struct.dynamic.demo02;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 描述：<br>399. 除法求值
 https://leetcode-cn.com/problems/evaluate-division/
 </>

 @author zzt */
public class Dynamic_CalcEquation {

    @Test
    public void test01() {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        double[] doubles = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));
    }

    private Map<String, Integer> stoLoc = new HashMap<>();
    private int len = 0;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] ans = new double[n];
        double[][] dp = new double[40][40];
        for (int i = 0; i < equations.size(); i++) {
            List<String> t = equations.get(i);
            //获得除数和被除数
            String a = t.get(0);
            String b = t.get(1);
            //找到Str对应的位置loc
            int loc1 = getLoc(a);
            int loc2 = getLoc(b);
            //"a"/"a"=1.0
            dp[loc1][loc1] = 1;
            dp[loc2][loc2] = 1;
            //赋值
            dp[loc1][loc2] = values[i];
            dp[loc2][loc1] = 1 / values[i];
            //遍历赋值
            for (int j = 0; j < len; j++) {
                if (dp[j][loc1] != 0) {
                    dp[j][loc2] = dp[j][loc1] * dp[loc1][loc2];
                }
                if (dp[j][loc2] != 0) {
                    dp[j][loc1] = dp[j][loc2] * dp[loc2][loc1];
                }
            }
            for (int j = 0; j < len; j++) {
                if (dp[loc2][j] != 0) {
                    dp[loc1][j] = dp[loc1][loc2] * dp[loc2][j];
                }
                if (dp[loc1][j] != 0) {
                    dp[loc2][j] = dp[loc2][loc1] * dp[loc1][j];
                }
            }
            for (int ii = 0; ii < len; ii++) {
                if (dp[ii][loc1] == 0 && dp[ii][loc2] == 0) {
                    continue;
                }
                for (int jj = 0; jj < len; jj++) {
                    if (dp[ii][jj] == 0) {
                        if (dp[ii][loc1] != 0) {
                            dp[ii][jj] = dp[ii][loc1] * dp[loc1][jj];
                        } else {
                            dp[ii][jj] = dp[ii][loc2] * dp[loc2][jj];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            List<String> t = queries.get(i);
            String a = t.get(0);
            String b = t.get(1);
            if (stoLoc.containsKey(a) && stoLoc.containsKey(b)) {
                int loc1 = stoLoc.get(a);
                int loc2 = stoLoc.get(b);
                ans[i] = dp[loc1][loc2] == 0 ? -1 : dp[loc1][loc2];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    //利用Map获得Str对应的位置loc
    private int getLoc(String s) {
        if (stoLoc.containsKey(s)) {
            return stoLoc.get(s);
        } else {
            stoLoc.put(s, len);
            return len++;
        }
    }

}
