package com.zzt.algorithm.leet_code.day_20_08_13;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】 43. 字符串相互乘</>
 * <p>网页地址：https://leetcode-cn.com/problems/multiply-strings/
 * 个人思路：小学算乘法的步骤思路 num1 num2
 * 1. 从 num2 最后一个数字开始取，依次与 num1 进行乘积
 * 2. 将上一个乘积的结果，和 结果 result 相加。
 *
 * @author 周志通
 * @date 2020/8/13
 */
public class Solution01 {

    public String multiply(String num1, String num2) {
        String result = "0";
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // 相乘
        int point1, point2 = num2.length() - 1;
        StringBuilder builder;
        int overflow, temp, i = 0;
        while (point2 >= 0) {
            // 相乘
            builder = new StringBuilder();
            point1 = num1.length() - 1;
            builder = new StringBuilder();
            for (int j = 0; j < i; j++) {
                builder.append(0);
            }
            overflow = 0;
            while (point1 >= 0) {
                temp = (num1.charAt(point1) - '0') * (num2.charAt(point2) - '0');
                builder.append((temp + overflow) % 10);
                overflow = (temp + overflow) / 10;
                point1--;
            }
            if (overflow != 0) {
                builder.append(overflow);
            }
            builder.reverse();
            point2--;
            i++;
            result = addStrings(result, builder.toString());
        }

        return result;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10); // 取末位
            carry /= 10; // 去末位
        }
        return sb.reverse().toString();
    }

    /**
     * 题解思路：实例说明[123*456]
     * 1.
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 63.29% 的用户
     *
     * 时间复杂度：m*n
     * 空间复杂度：m+n
     *
     * @param num1
     * @param num2
     * @return java.lang.String
     * @author Admin
     * @date 2020/8/13 12:09
     */
    public String multiply2(String num1, String num2) {
        // 判断特殊值
        if (num1.length() == 0 || num2.length() == 0)
            return "";
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        // 将两个字符串数值 转换成 char[] 类型..
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        // 因为两个数相乘,乘积必定小于 两个数值的长度之和[如 999*999<1000000]
        int[] ans = new int[n1.length + n2.length];
        int start = 0;
        // 将每个乘积放进数值中，位置相同的合并相加
        // 例如：123*456 --> 123*6 --> [18,12,6,0,0,0]
        //                   123*5 --> [18,27,16,5,0,0] --> ...
        // 最终结果：[18,27,28,13,4,0]
        for (int i = n1.length - 1; i >= 0; i--) {
            int d = n1[i] - '0', k = start;
            for (int j = n2.length - 1; j >= 0; j--) {
                ans[k++] += (n2[j] - '0') * d;
            }
            start++;
        }
        int rem = 0; // 相加后 溢出 的数值
        // 将数组中的数字，变成个位数
        // 例如[18,27,28,13,4,0] --> [8,8,0,6,5,0]
        for (int i = 0; i < ans.length; i++) {
            ans[i] += rem;
            rem = ans[i] / 10;
            ans[i] %= 10;
        }
        // 最后：将数组 --> 字符串【从末尾开始取】
        StringBuilder sb = new StringBuilder();
        int i = n1.length + n2.length - 1;
        // 排除掉末尾的 '0'
        while (ans[i] == 0)
            i--;
        // 开始转换成
        while (i >= 0) {
            sb.append(ans[i]);
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new Solution01().multiply(num1, num2));
        System.out.println(123*456);
    }

}
