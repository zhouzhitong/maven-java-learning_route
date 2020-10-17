package com.zzt.algorithm.leet_code.operator;

/**
 * 描述：<br> ➕ 加法运算
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/14 22:40
 **/
public class AdditionOperator {

    public int addition(int x, int y) {
        int _x = x ^ y;
        int _y = (x & y) << 1;
        if (_y == 0) {
            return _x;
        }
        return addition(_x, _y);
    }

    public static void main(String[] args) {
        // 4  :  00000100
        // 7  :  00000111
        int x = 4, y = 7;
        System.out.println(new AdditionOperator().addition(x, y));
    }

}
