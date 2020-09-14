package com.zzt.algorithm.leet_code.day_20_08_27;

import java.util.*;

/**
 * 描述：<br> 332. 重新安排行程
 * 网址：https://leetcode-cn.com/problems/reconstruct-itinerary/
 * <p>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/27 17:52
 */
public class Solution01 {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        tickets.forEach(ticket -> {
            map.put(ticket.get(0), ticket.get(1));
        });
        System.out.println(tickets);
        String start = "JFK";
        String next;
        if (!map.containsKey(start)) {
            return null;
        }
        result.add(start);
        while (!map.isEmpty()) {

            next = map.get(start);
            if (next == null) {
                return null;
            }
            result.add(next);
            map.remove(start);
            start = next;
        }
        return result;
    }

    public static void main(String[] args) {
        // 测试数据1：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        // 输出结果：["JFK", "MUC", "LHR", "SFO", "SJC"]
        // 测试数据2：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        // 输出结果：["JFK","ATL","JFK","SFO","ATL","SFO"]
        List<List<String>> tickets = new ArrayList<>();
        // 准备测试数据1：
        /*List<String> ticket = new ArrayList<>(Arrays.asList("MUC", "LHR"));
        tickets.add(ticket);
        ticket = new ArrayList<>(Arrays.asList("JFK", "MUC"));
        tickets.add(ticket);
        ticket = new ArrayList<>(Arrays.asList("SFO", "SJC"));
        tickets.add(ticket);
        ticket = new ArrayList<>(Arrays.asList("LHR", "SFO"));
        tickets.add(ticket);*/

        // 准备测试数据2：
        List<String> ticket = new ArrayList<>(Arrays.asList("JFK", "SFO"));
        tickets.add(ticket);
        ticket = new ArrayList<>(Arrays.asList("JFK", "ATL"));
        tickets.add(ticket);
        ticket = new ArrayList<>(Arrays.asList("SFO", "ATL"));
        tickets.add(ticket);
        ticket = new ArrayList<>(Arrays.asList("ATL", "JFK"));
        tickets.add(ticket);
        ticket = new ArrayList<>(Arrays.asList("ATL", "SFO"));
        tickets.add(ticket);

        System.out.println(new Solution01().findItinerary(tickets));

    }

}
