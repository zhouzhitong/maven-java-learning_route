package com.zzt.algorithm.leet_code.operator;

/**
 * 描述：<br> × 乘法运算
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/14 22:37
 **/
public class MultiplicationOperator {

    private static int binaryAdd(int a, int b) {// 正负数都包含在里面，不用分开处理
        int s = a ^ b;// 不考虑进位的和
        int jw = a & b;// 进位
        // 下面是 s + (jw<<1) 的计算
        while (jw != 0) {
            int jw_temp = s & (jw << 1);// 保存s + (jw<<1)的进位
            s = s ^ (jw << 1);// 保存s + (jw<<1)的和，不包含进位
            jw = jw_temp;// 赋值之后，还是计算s+(jw<<1)，依旧是计算：进位以及不进位的和，当进位为0时，不进位的和就是最终的计算结果
        }
        return s;
    }

    public static int binaryMulti(int a, int b) {// 计算a*b
        if (a == 0 || b == 0) {
            return 0;
        }
        int res = 0;
        int base = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = binaryAdd(res, base);
            }
            b >>= 1;
            base <<= 1;
        }
        return res;
    }

    public static int binaryMulti2(int a, int b) {// 计算a*b
        if (a == 0 || b == 0) {
            return 0;
        }
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int res = 0;
        int shift = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res += (a << shift);
            }
            shift += 1;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(4&1);
        System.out.println(5&1);
        System.out.println(4^1);
        System.out.println(5^1);

    }

}
