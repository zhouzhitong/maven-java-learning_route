package com.zzt.regex;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：<br>
 * 参考网址：https://www.runoob.com/java/java-regular-expressions.html
 * https://blog.csdn.net/gdhck123/article/details/86703978
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/11 17:34
 */
public class RegexDemo02 {

    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    /**
     * 测试：.* ：用来匹配包含关系
     */
    private static void test01() {
        String content = "I am noob " +
                "from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    private static void test02() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0) + ".");
            System.out.println("Found value: " + m.group(1) + ".");
            System.out.println("Found value: " + m.group(2) + ".");
            System.out.println("Found value: " + m.group(3) + ".");
        } else {
            System.out.println("NO MATCH");
        }
    }

    private static void test03() {
        String content = "asdazozo";
//        String regex = ".*zo.*";
        String regex = "asda(zo)?";
        boolean matches = Pattern.matches(regex, content);
        System.out.println(matches);
    }

}
