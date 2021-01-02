package com.zzt.struct.dynamic.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 描述：<br>
 题目：
 假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
 开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 如果机器人来到1位置，那么下一步只能往右来到2位置；
 如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 给定四个参数 N、M、K、P，返回方法数。
 </>
 @author 周志通
 @version 1.0.0
 @date 2021/1/2 14:58 **/
public class Recursion_Dynamic_Demo02 {

    @Test
    public void test01() {
        System.out.println(Robot01.ways(5, 2, 4, 6));
        System.out.println(Robot02.ways(5, 2, 4, 6));
        System.out.println(Robot03.ways(5, 2, 4, 6));
        System.out.println(Robot04.ways(5, 2, 4, 6));
    }

    /**
     暴力版本
     思路：暴力递归
     */
    private static class Robot01 {
        /**
         @param N     有哪些位置? 1-N
         @param start 机器人当前来到的位置 cur
         @param aim   最终的目标
         @param K     还需要走的步数
         @return 方法数量？
         */
        public static int ways(int N, int start, int aim, int K) {
            return process(start, K, aim, N);
        }

        /**
         @param cur  机器人当前来到的位置 cur
         @param rest 还需要走的步数
         @param aim  最终的目标
         @param N    有哪些位置? 1-N
         @return 方法数量？
         */
        public static int process(int cur, int rest, int aim, int N) {
            if (rest == 0) {
                return cur == aim ? 1 : 0;
            }
            if (cur == 1) {
                return process(2, rest - 1, aim, N);
            }
            if (cur == N) {
                return process(N - 1, rest - 1, aim, N);
            }
            return process(cur - 1, rest - 1, aim, N) +
                    process(cur + 1, rest - 1, aim, N);
        }

    }

    /**
     优化版本1：记忆化搜索（使用Map集合缓存）
     思路：自顶向下的动态规划...
     */
    private static class Robot02 {

        /**
         @param N     有哪些位置? 1-N
         @param start 机器人当前来到的位置 cur
         @param aim   最终的目标
         @param K     还需要走的步数
         @return 方法数量？
         */
        public static int ways(int N, int start, int aim, int K) {
            return process(start, K, aim, N, new HashMap<>());
        }

        /**
         @param cur  机器人当前来到的位置 cur
         @param rest 还需要走的步数
         @param aim  最终的目标
         @param N    有哪些位置? 1-N
         @param map  缓存
         @return 方法数量？
         */
        public static int process(int cur, int rest, int aim, int N, Map<Info, Integer> map) {
            if (cur < 1 || cur > N) return 0;// 边界考虑
            if (rest == 0) return cur == aim ? 1 : 0; // 终止条件

            Info info = new Info(cur, rest);
            if (map.get(info) != null) {
                return map.get(info);
            }
            int p1 = map.getOrDefault(new Info(cur - 1, rest - 1),
                    process(cur - 1, rest - 1, aim, N, map));
            int p2 = map.getOrDefault(new Info(cur + 1, rest - 1),
                    process(cur + 1, rest - 1, aim, N, map));
            map.put(info, p1 + p2);
            return p1 + p2;
        }

        private static class Info {
            int cur;
            int rest;

            public Info(int cur, int rest) {
                this.cur = cur;
                this.rest = rest;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Info info = (Info) o;

                if (cur != info.cur) return false;
                return rest == info.rest;
            }

            @Override
            public int hashCode() {
                int result = cur;
                result = 31 * result + rest;
                return result;
            }
        }

    }

    /**
     优化版本2：记忆化搜索（使用二维数组集合缓存）
     思路：自顶向下的动态规划...
     */
    private static class Robot03 {

        /**
         @param N     有哪些位置? 1-N
         @param start 机器人当前来到的位置 cur
         @param aim   最终的目标
         @param K     还需要走的步数
         @return 方法数量？
         */
        public static int ways(int N, int start, int aim, int K) {
            int[][] db = new int[N + 1][K + 1];
            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < K + 1; j++) {
                    db[i][j] = -1;
                }
            }
            return process(start, K, aim, N, db);
        }

        /**
         @param cur  机器人当前来到的位置 cur
         @param rest 还需要走的步数
         @param aim  最终的目标
         @param N    有哪些位置? 1-N
         @param db   缓存
         @return 方法数量？
         */
        public static int process(int cur, int rest, int aim, int N, int[][] db) {
            if (cur < 1 || cur > N) {   // 边界考虑
                return 0;
            }
            if (rest == 0) {
                return cur == aim ? 1 : 0;
            }
            if (db[cur][rest] != -1) {
                return db[cur][rest];
            }
            int p1 = process(cur - 1, rest - 1, aim, N, db);
            int p2 = process(cur + 1, rest - 1, aim, N, db);
            db[cur][rest] = p1 + p2;
            return db[cur][rest];
        }

    }

    /**
     最终版本：动态规划
     思路：状态转移
     */
    private static class Robot04 {

        /**
         @param N     有哪些位置? 1-N
         @param start 机器人当前来到的位置 cur
         @param aim   最终的目标
         @param K     还需要走的步数
         @return 方法数量？
         */
        public static int ways(int N, int start, int aim, int K) {
            /*int len = N + 2;
            int[] db = new int[len];
            db[aim] = 1;
            for (int i = 0; i < K; i++) {
                int[] newDb = new int[len];
                for (int j = 1; j <= N; j++) {
                    newDb[j] = db[j - 1] + db[j + 1];
                }
                db = newDb;
            }
            return db[start];*/

            int len = N + 1;
            int[] db = new int[len];
            db[aim] = 1;
            for (int i = 0; i < K; i++) {
                int[] newDb = new int[len];
                // newDb[1] = db[2];
                for (int j = 1; j < N; j++) {
                    newDb[j] = db[j - 1] + db[j + 1];
                }
                newDb[N] = db[N - 1];
                db = newDb;
            }
            return db[start];

        }

    }

}