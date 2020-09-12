package com.zzt.data_structures.recursion;

/**
 * 描述：<br>递归的解决问题：
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/12 14:01
 */
public class RecursionMain {

    public static void main(String[] args) {
//        print(4);
        System.out.println(factorial(1));
    }

    private static void print(int n) {
        if (n > 1) {
            print(n - 1);
        }
        System.out.println("n = " + n);
    }

    private static Integer factorial(Integer n){
        if (n==1){
            return n;
        }else {
            return factorial(n-1)*n;
        }
    }


}
