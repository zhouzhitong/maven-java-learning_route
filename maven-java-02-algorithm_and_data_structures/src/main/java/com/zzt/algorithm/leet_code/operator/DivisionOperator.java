package com.zzt.algorithm.leet_code.operator;

/**
 * 描述：<br> ➗ 除法运算
 * 参考网址：https://leetcode-cn.com/problems/divide-two-integers/solution/san-ceng-lei-jia-bao-li-po-jie-fa-zhi-xing-yong-sh/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/14 22:33
 **/
public class DivisionOperator {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sum = 0, t = 0;//第一层累加数
        int sums = 0, ts = 0;//第二层累加数
        int sumss = 0, tss = 0;//第三层累加数
        int res = 0;//结果
        int flat = (dividend ^ divisor);//结果正负标志位
        dividend = (dividend < 0) ? dividend : -dividend;//被除数取负值
        divisor = (divisor < 0) ? divisor : -divisor;//除数取负值
        while (dividend <= divisor) {//暴力累加法
            sum += divisor;
            t--;
            sums += sum;
            ts += t;
            sumss += sums;
            tss += ts;
            if (dividend - sumss < 0 && sumss < 0) {//判断三层累加是否超出
                res += tss;
                dividend -= sumss;
            } else {//超出则普通累加
                res--;
                dividend -= divisor;
                sum = 0;
                t = 0;
                sums = 0;
                ts = 0;
                sumss = 0;
                tss = 0;
            }
        }
        return (flat < 0) ? res : -res;
    }

    public static void main(String[] args) {
        int dividend = 8, divisor = 3;
        System.out.println(new DivisionOperator().divide(dividend, divisor));
    }

}
