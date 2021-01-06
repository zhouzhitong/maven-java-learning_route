package com.zzt.struct.dynamic.demo02;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

/**
 * 描述：<br>
 * </>
 *
 * @author zzt
 */
public class Test {

    public static void main(String[] args) {
        double pow = Math.pow(2.0, 3.0);
        System.out.println(pow);
        System.out.println(Math.cbrt(8.0));
        /*double a = 8;
        System.out.println(sqrt(a));*/
    }

    public static double sqrt(double x) {
        if (x < 0) {
            return -1;
        }
        //格式化，保证输出位数
        DecimalFormat df = new DecimalFormat("#.00");

        double k = x;
        double precision = 0.000001;
        while (k * k * k - x > precision) {
            k = (1 / 3) * (k * k + x * x / k * k);
        }
        return Double.parseDouble(df.format(k));
    }

    private static double generate(double k, int n) {
        double t = k;
        for (int i = 2; i < n; i++) {
            t *= k;
        }
        return t;
    }

}
