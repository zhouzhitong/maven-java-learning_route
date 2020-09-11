package com.zzt.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：<br> 正则表达式测试
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/11 14:47
 */
public class RegexDemo01 {



    public static void main(String[] args) {
        String str1 = "ABC@#@AASD34EGW2334";
        Pattern pattern = Pattern.compile("[0-9]");
//        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(str1);
        String s = matcher.replaceAll("*");
        System.out.println(s);
    }

}
