package com.zzt.struct.dynamic.demo02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ÃèÊö£º<br>399. ³ý·¨ÇóÖµ
 * https://leetcode-cn.com/problems/evaluate-division/
 * </>
 *
 * @author zzt
 */
public class Dynamic_CalcEquation {

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

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }

    private double sqrt(double value, int n) {
        return 0.0;
    }

}
