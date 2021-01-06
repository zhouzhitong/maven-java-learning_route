package com.zzt.struct.dynamic.demo02;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 ������<br>399. ������ֵ
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
        double[] doubles = new CalcEquation().calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));
    }

    private static class CalcEquation {

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            HashMap<String, String> unionMap = new HashMap<>(); //���鼯
            HashMap<String, List<String>> map = new HashMap<>(); //�ڽӱ�
            HashMap<String, List<Double>> weight = new HashMap<>(); //���ڽӱ�һһ��Ӧ��Ȩ�ر�
            for (int i = 0; i < equations.size(); i++) {
                String s1 = equations.get(i).get(0);
                String s2 = equations.get(i).get(1);
                //�����ڽӱ����ӦȨ��
                if (!map.containsKey(s1)) {
                    map.put(s1, new ArrayList<>());
                    weight.put(s1, new ArrayList<>());
                }
                if (!map.containsKey(s2)) {
                    map.put(s2, new ArrayList<>());
                    weight.put(s2, new ArrayList<>());
                }
                map.get(s1).add(s2);
                weight.get(s1).add(values[i]);
                map.get(s2).add(s1);
                weight.get(s2).add(1.0 / values[i]);
                //�������鼯
                while (unionMap.containsKey(s1)) { //s1������
                    s1 = unionMap.get(s1);
                }
                while (unionMap.containsKey(s2)) { //s2������
                    s2 = unionMap.get(s2);
                }
                if (!s1.equals(s2)) { //���Ȳ�ͬ��ϲ�����
                    String ancester = s1.compareTo(s2) < 0 ? s1 : s2;
                    String descendant = s1.compareTo(s2) < 0 ? s2 : s1;
                    unionMap.put(descendant, ancester); //���ֵ����С����Ϊ���ȣ��ϴ����Ϊ���
                }
            }

            double[] res = new double[queries.size()]; //�����
            for (int i = 0; i < queries.size(); i++) {
                res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), unionMap, map, weight, new HashSet<>());
            }
            return res;
        }

        public Double dfs(String s1, String s2, HashMap<String, String> unionMap, HashMap<String, List<String>> map, HashMap<String, List<Double>> weight, HashSet<String> visited) {
            visited.add(s1);
            if (!map.containsKey(s1) || !map.containsKey(s2)) { //��������յ㲻������ͼ�У���ֹ
                return -1.0;
            }
            //���s1��s2�����Ȳ�ͬ�������߲���ͨ���������ҵ�ͨ·����ֹ
            String s1Father = s1, s2Father = s2;
            while (unionMap.containsKey(s1Father)) {
                s1Father = unionMap.get(s1Father);
            }
            while (unionMap.containsKey(s2Father)) {
                s2Father = unionMap.get(s2Father);
            }
            if (!s1Father.equals(s2Father)) {
                return -1.0;
            }

            if (s1.equals(s2)) { //�������յ���ͬ���ҵ���ͨ·����Ȩ��Ϊ1.0
                return 1.0;
            }
            //������s1���������нڵ�
            for (int i = 0; i < map.get(s1).size(); i++) {
                if (visited.contains(map.get(s1).get(i))) { //����Ѿ����ʹ���������
                    continue;
                }
                double res = dfs(map.get(s1).get(i), s2, unionMap, map, weight, visited);//
                double w = weight.get(s1).get(i); //s1��map.get(s1).get(i)��Ȩ��

                if (res != -1.0) {
                    return res * w;
                }
            }
            return -1.0;
        }
    }

    private static class CalcEquation1 {
        private Map<String, Integer> stoLoc = new HashMap<>();
        private int len = 0;

        /**
         ����equations��ÿ�ε���һ�����������飬����dp��ά������д���dp[i][j]��ʾ�ַ���a���ַ���b����Ľ��������i�����ַ���a��j�����ַ���b��

         @param equations
         @param values
         @param queries
         @return
         */
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int n = queries.size();
            double[] ans = new double[n];
            double[][] dp = new double[40][40];
            for (int i = 0; i < equations.size(); i++) {
                List<String> t = equations.get(i);
                //��ó����ͱ�����
                String a = t.get(0);
                String b = t.get(1);
                //�ҵ�Str��Ӧ��λ��loc
                int loc1 = getLoc(a);
                int loc2 = getLoc(b);
                //"a"/"a"=1.0
                dp[loc1][loc1] = 1;
                dp[loc2][loc2] = 1;
                //��ֵ
                dp[loc1][loc2] = values[i];
                dp[loc2][loc1] = 1 / values[i];
                //������ֵ
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

        //����Map���Str��Ӧ��λ��loc
        private int getLoc(String s) {
            if (stoLoc.containsKey(s)) {
                return stoLoc.get(s);
            } else {
                stoLoc.put(s, len);
                return len++;
            }
        }
    }


}
