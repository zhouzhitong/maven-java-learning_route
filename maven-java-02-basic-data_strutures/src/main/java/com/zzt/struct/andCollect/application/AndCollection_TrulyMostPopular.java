package com.zzt.struct.andCollect.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>面试题 17.07. 婴儿名字
 * https://leetcode-cn.com/problems/baby-names-lcci/
 * </>
 *
 * @author zzt
 */
public class AndCollection_TrulyMostPopular {

    @Test
    public void test01() {
        String[] names = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        String[] popular = trulyMostPopular(names, synonyms);
        System.out.println(Arrays.toString(popular));
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        AndCollection collection = new AndCollection();
        for (String synonym : synonyms) {
            String[] str = turnSynonym(synonym);
            collection.addNode(str[0]);
            collection.addNode(str[1]);
            collection.union(str[0], str[1]);
        }

        List<Info> infos = new ArrayList<>();
        for (String name : names) {
            Info info = turnDate(name);

            infos.add(info);
        }
        return null;
    }

    private static class AndCollection {
        Map<String, String> parentMap;
        Set<String> set;

        public AndCollection() {
            parentMap = new HashMap<>();
            set = new HashSet<>();
        }

        public void addNode(String synonym) {
            if (set.add(synonym)) {
                parentMap.put(synonym, synonym);
            }
        }


        public void union(String a, String b) {
            String aInfo = findFather(a);
            String bInfo = findFather(b);
            if (!aInfo.equals(bInfo)) {
                parentMap.put(aInfo, bInfo);
            }
        }

        public String findFather(String name) {
            Stack<String> stack = new Stack<>();
            String help;
            while (!(help = parentMap.get(name)).equals(name)) {
                stack.push(help);
                name = help;
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), help);
            }
            return help;
        }

    }

    private Info turnDate(String name) {
        int last = name.length() - 1;
        int left = last;
        while (name.charAt(left) != '(') {
            left--;
        }
        String count = name.substring(left + 1, last);
        name = name.substring(0, left);
        return new Info(name, Integer.parseInt(count));
    }

    private String[] turnSynonym(String synonym) {
        String[] synonyms = new String[2];
        int i = synonym.indexOf(",");
        synonyms[0] = synonym.substring(1, i);
        synonyms[1] = synonym.substring(i + 1);
        return synonyms;
    }

    private static class Info {
        String name;
        int count;

        public Info() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return count == info.count &&
                    Objects.equals(name, info.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, count);
        }

        public Info(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
