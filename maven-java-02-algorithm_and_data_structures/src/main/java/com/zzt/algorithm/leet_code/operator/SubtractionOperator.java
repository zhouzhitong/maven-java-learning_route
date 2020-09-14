package com.zzt.algorithm.leet_code.operator;

/**
 * 描述：<br> —— 减法运算
 * </>
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/14 22:41
 **/
public class SubtractionOperator {

    /**
     * 加法
     * @param num1
     * @param num2
     * @return
     */
    private static int addWithBitOperator(int num1, int num2) {
        int sum = 0;
        int carryBit = 0;   //进位

        do {
            sum = num1 ^ num2;
            carryBit = (num1 & num2) << 1;
            num1 = sum;
            num2 = carryBit;
        } while (carryBit != 0);

        return sum;
    }

    /**
     * 减法
     * @param num1
     * @param num2
     * @return
     */
    public static int subWithBitOperator(int num1, int num2) {
        num2 = ~num2 + 1;	//num2补码
        return addWithBitOperator(num1, num2);
    }

    public static void main(String[] args) {
        int sum = addWithBitOperator(20, 15);
        int sub = subWithBitOperator(20, 15);
        System.out.println(sum);
        System.out.println(sub);
    }

}
