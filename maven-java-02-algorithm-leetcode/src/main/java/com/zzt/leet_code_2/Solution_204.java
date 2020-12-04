package com.zzt.leet_code_2;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/12/3 18:20
 */
public class Solution_204 {

    @Test
    public void test01() {
        int i = countPrimes(10);
        System.out.println(i);
    }

    public int countPrimes(int n) {
        int count = n > 2 ? 1 : 0;
        for (int i = 3; i < n; i += 2) {
            if (checkPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
