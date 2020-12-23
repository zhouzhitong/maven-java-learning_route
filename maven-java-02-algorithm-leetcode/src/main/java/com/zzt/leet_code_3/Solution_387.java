package com.zzt.leet_code_3;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>
 * </>
 *
 * @author zzt
 */
public class Solution_387 {

    @Test
    public void test01() {
        String s = "noclrnthqqganujpsabdjjrwfljribdbwoskcnmtxokkrlvcv";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    public int firstUniqChar(String s) {
        int count[] = new int[26];
        char[] chars = s.toCharArray();
        //先统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++)
            count[chars[i] - 'a']++;
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < s.length(); i++)
            if (count[chars[i] - 'a'] == 1)
                return i;
        return -1;
    }
}
