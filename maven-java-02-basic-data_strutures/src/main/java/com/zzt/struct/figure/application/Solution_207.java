package com.zzt.struct.figure.application;

import netscape.security.UserTarget;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>207. 课程表（未通过测试）
 * https://leetcode-cn.com/problems/course-schedule/
 * </>
 *
 * @author zzt
 */
public class Solution_207 {

    @Test
    public void test01() {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {0, 2}, {0, 1}};
        boolean b = canFinish(numCourses, prerequisites);
        System.out.println(b);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Node node = nodeMap.getOrDefault(prerequisite[0], new Node(prerequisite[0]));
            node.nexts.add(prerequisite[1]);
            nodeMap.put(prerequisite[0], node);
        }
        Node node = nodeMap.get(0);
        Stack<Node> stack = new Stack<>();
        Set<Integer> exitsNode = new HashSet<>();
        stack.push(node);
        exitsNode.add(0);
        Set<Integer> check = new HashSet<>();
        check.add(0);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Integer next : cur.nexts) {
                node = nodeMap.get(next);
                if (check.contains(next)) {
                    return false;
                }
                if (!exitsNode.contains(node)) {
                    //
                    stack.push(cur);
                    stack.push(node);
                    exitsNode.add(next);
                    break;
                }

            }
        }

        return true;
    }

    private static class Node {
        int val;
        List<Integer> nexts;

        public Node(int val) {
            this.val = val;
            nexts = new ArrayList<>();
        }
    }

}
