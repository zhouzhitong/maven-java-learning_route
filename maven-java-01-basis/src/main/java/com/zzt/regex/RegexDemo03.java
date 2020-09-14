package com.zzt.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/12 21:28
 **/
public class RegexDemo03 {
    private static String content = "DemoDemo12 industry DemoDemo1233 industries";//43
    private static String regex;

    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
        matcherTest05();
//        matcherTest06();
    }

    private static void matcherTest06() {
//        regex = "(Demo){1,}(?:(([1-9]){3,5}))";//32
        regex = "(Demo){1,}(?:(([1-9]){1,5}))";//28
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            if (matcher.find()){
                System.out.println(matcher.start());
                System.out.println(matcher.end());
            }
        }
    }

    private static void matcherTest05() {
        regex = "(Demo){1,}(?:(([1-9]){1,}))";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            if (matcher.find(matcher.end())){
                System.out.println(matcher.end());
            }
        }
    }

    private static void test04() {
        regex = ".*(Demo){1,}\\x41 .*";
        boolean matches = Pattern.matches(regex, content);
        System.out.println(matches);
    }

    private static void test03() {
        regex = ".*DemoDemo(?!123123|\\b).*";
        boolean matches = Pattern.matches(regex, content);
        System.out.println(matches);
    }

    private static void test02() {
        regex = ".*(Demo)? .*";
//        regex = ".*(Demo)?(?=[1-9]{5}) .*";
        boolean matches = Pattern.matches(regex, content);
        System.out.println(matches);
    }

    private static void test01() {
        regex = ".*industr(?=ykaaa|ies).*";
        boolean matches = Pattern.matches(regex, content);
        System.out.println(matches);
    }

}
