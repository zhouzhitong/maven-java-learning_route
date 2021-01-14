package com.zzt.struct.dynamic.demo02;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：<br> 691. 贴纸拼词
 * https://leetcode.com/problems/stickers-to-spell-word
 * </>
 *
 * @author zzt
 */
public class DynamicDemo_StickersToSpellWord {

    @Test
    public void test01() {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        System.out.println(StickersToSpellWord1.minStickers(stickers, target));
        System.out.println(StickersToSpellWord2.minStickers(stickers, target));
        System.out.println(StickersToSpellWord3.minStickers(stickers, target));
    }

    /** 暴露递归求解 */
    private static class StickersToSpellWord1 {

        public static int minStickers(String[] stickers, String target) {
            int process = process(stickers, target);
            return process == Integer.MAX_VALUE ? -1 : process;
        }

        private static int process(String[] stickers, String target) {
            if (target.length() == 0) {
                return 0;
            }
            int count = Integer.MAX_VALUE;
            for (String sticker : stickers) {
                String minus = minus(target, sticker);
                if (minus.length() != target.length()) {
                    count = Math.min(count, process(stickers, minus));
                }
            }
            return count + (count == Integer.MAX_VALUE ? 0 : 1);
        }

        private static String minus(String targetStr, String minus) {
            char[] cs1 = targetStr.toCharArray();
            char[] cs2 = minus.toCharArray();
            int[] count = new int[26];
            for (char c : cs1) {
                count[c - 'a']++;
            }
            for (char c : cs2) {
                count[c - 'a']--;
            }
            StringBuilder buffer = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    for (int j = 0; j < count[i]; j++) {
                        buffer.append((char) (i + 'a'));
                    }
                }
            }
            return buffer.toString();
        }

    }

    /** 暴露递归求解：优化版本 + 缓存 */
    private static class StickersToSpellWord2 {

        public static int minStickers(String[] stickers, String target) {
            int[][] counts = new int[stickers.length][26];
            int i = 0;
            for (String sticker : stickers) {
                char[] chars = sticker.toCharArray();
                for (char c : chars) {
                    counts[i][c - 'a']++;
                }
                i++;
            }
            int process = process(counts, target);
            return process == Integer.MAX_VALUE ? -1 : process;
        }

        private static int process(int[][] counts, String target) {
            if (target.length() == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for (int[] count : counts) {
                char c = target.charAt(0);
                if (count[c - 'a'] == 0) {
                    continue;
                }
                String minus = minus(target, count);
                if (target.length() != minus.length()) {
                    min = Math.min(min, process(counts, minus));
                }
            }
            return min + (min == Integer.MAX_VALUE ? 0 : 1);
        }

        private static String minus(String target, int[] counts) {
            char[] chars = target.toCharArray();
            int[] ts = new int[26];
            for (char c : chars) {
                ts[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                ts[i] -= counts[i];
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < ts.length; i++) {
                if (ts[i] > 0) {
                    for (int j = 0; j < ts[i]; j++) {
                        builder.append((char) (i + 'a'));
                    }
                }
            }
            return builder.toString();
        }

    }

    /** 动态规划求解 */
    private static class StickersToSpellWord3 {

        public static int minStickers(String[] stickers, String target) {
            int[][] counts = new int[stickers.length][26];
            int i = 0;
            for (String sticker : stickers) {
                char[] chars = sticker.toCharArray();
                for (char c : chars) {
                    counts[i][c - 'a']++;
                }
                i++;
            }
            Map<String, Integer> db = new HashMap<>(stickers.length);
            db.put("", 0);
            int process = process(counts, target, db);
            return process == Integer.MAX_VALUE ? -1 : process;
        }

        private static int process(int[][] counts, String target, Map<String, Integer> db) {
            if (db.containsKey(target)) {
                return db.get(target);
            }
            int min = Integer.MAX_VALUE;
            for (int[] count : counts) {
                char c = target.charAt(0);
                if (count[c - 'a'] == 0) {
                    continue;
                }
                String minus = minus(target, count);
                if (target.length() != minus.length()) {
                    min = Math.min(min, process(counts, minus, db));
                }
            }
            db.put(target, min + (min == Integer.MAX_VALUE ? 0 : 1));
            return db.get(target);
        }

        private static String minus(String target, int[] counts) {
            char[] chars = target.toCharArray();
            int[] ts = new int[26];
            for (char c : chars) {
                ts[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                ts[i] -= counts[i];
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < ts.length; i++) {
                if (ts[i] > 0) {
                    for (int j = 0; j < ts[i]; j++) {
                        builder.append((char) (i + 'a'));
                    }
                }
            }
            return builder.toString();
        }

    }

}
