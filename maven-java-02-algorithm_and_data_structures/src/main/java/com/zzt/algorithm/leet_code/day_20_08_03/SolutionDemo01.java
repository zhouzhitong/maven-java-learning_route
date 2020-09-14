package com.zzt.algorithm.leet_code.day_20_08_03;

/**
 * 描述：<br> 题库 -- 算法 --【每日一题】 415. 字符串相加
 * <p>网页地址：https://leetcode-cn.com/problems/add-strings/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/3 19:55
 **/
public class SolutionDemo01 {
    /**
     * 个人的理解思路：
     * 步骤一：指定 point1 和 point2 分别为字符串 num1 和 num2 的尾指针!
     * 0<——(向左移动)<—— point1
     * |
     * V
     * num1： 1 2 3 4
     * <p>
     * 0<——(向左移动)<—— point2
     * |
     * V
     * num2：1 2 3
     * <p>
     * 步骤二：将两个指针上的数字相加，再加上 进位值【判断是否存在进位情况】，然后向 stringBuffer 变量的头部添加字符
     * 例如：最初，carry=0;temp=4+3=7，所以此时的 stringBuffer 往头部添加 7
     * 步骤三：两个指针左移，并判断是否有[ 指针<=0或 进位carry==0 ]
     *
     * @param num1 字符串1
     * @param num2 字符串2
     * @return 字符串1 和 字符串2 相加之和
     */
    public String addStrings(String num1, String num2) {
        int point1 = num1.length() - 1; // 字符串1的尾指针
        int point2 = num2.length() - 1; // 字符串2的尾指针
        StringBuilder stringBuilder = new StringBuilder();
        int temp;   // 计算和的结果
        int tempNum1;   // num1的数字
        int tempNum2;   // num2的数字
        int carry = 0;  // 当时的进位值
        while (point1 >= 0 || point2 >= 0 || carry != 0) {
            tempNum1 = point1 >= 0 ? num1.charAt(point1) - '0' : 0;
            tempNum2 = point2 >= 0 ? num2.charAt(point2) - '0' : 0;
            temp = tempNum1 + tempNum2 + carry;
            stringBuilder.insert(0, temp % 10);
            carry = temp / 10;
            point1--;
            point2--;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        String num1 = "1";
        String num2 = "9";
        System.out.println(new SolutionDemo01().addStrings(num1, num2));

    }

}
