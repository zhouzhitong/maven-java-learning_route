package com.zzt.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/2 21:53
 **/
public class RegexDemo04 {

    @Test
    public void test01() {
        String str = "aAAbbbb";
        String regex = "(a|A)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }

}
