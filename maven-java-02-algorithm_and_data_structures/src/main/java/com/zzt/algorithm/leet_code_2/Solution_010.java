package com.zzt.algorithm.leet_code_2;

/**
 * 描述：<br> 10. 正则表达式匹配
 * <p>题目网址：https://leetcode-cn.com/problems/regular-expression-matching/solution/
 * <p>解题思路：https://leetcode-cn.com/problems/regular-expression-matching/solution/javadi-gui-yi-bu-yi-bu-de-you-hua-dao-ji-bai-100yi/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/2 22:54
 **/
public class Solution_010 {

    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray(), ptr = p.toCharArray();
        boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= str.length; i++) {
            for (int j = 1; j <= ptr.length; j++) {
                if (ptr[j - 1] != '*') {
                    if (i > 0 && (str[i - 1] == ptr[j - 1] || ptr[j - 1] == '.')) dp[i][j] = dp[i - 1][j - 1];
                } else { //ptr[j - 1] == '*'
                    if (j > 1) dp[i][j] |= dp[i][j - 2];   //不看
                    if (i > 0 && j > 1 && (str[i - 1] == ptr[j - 2] || ptr[j - 2] == '.'))
                        dp[i][j] |= dp[i - 1][j];    //看
                }
            }
        }
        return dp[str.length][ptr.length];
    }

    public static void main(String[] args) {
//        String s = "mississippi";
//        String p = "mis*is*p*.";
        String s = "aab";
        String p = "c*a*b";
        System.out.println(new Solution_010().isMatch(s, p));
    }

}
