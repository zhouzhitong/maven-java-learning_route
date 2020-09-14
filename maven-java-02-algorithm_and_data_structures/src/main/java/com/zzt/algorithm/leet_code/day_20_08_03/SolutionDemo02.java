package com.zzt.algorithm.leet_code.day_20_08_03;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】 11. 盛最多水的容器
 * <p>网页地址：https://leetcode-cn.com/problems/container-with-most-water/
 * 参考思路：https://leetcode-cn.com/problems/container-with-most-water/solution/shuang-zhi-zhen-fa-you-hua-jian-dan-yi-dong-by-hjc/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/12 11:50
 **/
public class SolutionDemo02 {

    /**
     * 思路：双向指针[p1,p2]+优化
     *       1. p1指向开始，p2指向末尾，然后计算结果
     *       2. 判断 p1 和 p2 位置的 高度，低的一方向中间靠近
     *           【说明：桶的容量取决于最低的一边，只有增加低木板的高度，才可能增加桶的容量】
     *       3. 指针移动，循环判断，获取最大值。
     * 执行结果：
     *      执行用时： 3 ms , 在所有 Java 提交中击败了 92.60% 的用户
     *      内存消耗： 40.3 MB , 在所有 Java 提交中击败了 21.20% 的用户
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxResult = 0;
        while (low != high)  maxResult = Math.max(maxResult, (high - low) * (height[low] < height[high]?height[low++]:height[high--]));
        return maxResult;
    }

    /**
     * 思路：双向指针[p1,p2]+优化
     *      1. p1指向开始，p2指向末尾，然后计算结果
     *      2. 判断 p1 和 p2 位置的 高度，低的一方向中间靠近
     *          【说明：桶的容量取决于最低的一边，只有增加低木板的高度，才可能增加桶的容量】
     *      3. 指针移动，循环判断，获取最大值。
     *      3. 【优化】步骤二，高度 '低的一方'，循环判断，直到遇到比自己 '高' 的
     * 提交结果：
     *      执行时间：3ms 【击败了 92.60% 的用户】
     *      内存消耗：39.8M 【击败了96.31% 的用户】
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxResult = 0;
        int min;
        while (low != high) {
            if (height[low] < height[high]) {
                min = height[low];
                while (height[low] < height[low++]);
            } else {
                min = height[high];
                while (height[high] < height[high--]);
            }
            maxResult = Math.max(maxResult, (high - low+1) * min);
        }
        return maxResult;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = new SolutionDemo02().maxArea2(height);
        System.out.println(result);
    }

}
