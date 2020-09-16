package com.zzt.stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/16 10:30
 */
public class StreamDemo02 {
    // 2. 中间操作逻辑
    @Test
    public void streamOperateDemo01() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integers = Arrays.asList(a);
        Stream<Integer> stream = integers.stream();
        stream.filter(x -> x % 2 == 0).forEach(System.out::println);
    }

    @Test
    public void streamOperateDemo02() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integers = Arrays.asList(a);
        Stream<Integer> stream = integers.stream();
        int sum = stream.filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);
    }

    @Test
    public void streamOperateDemo03() { // 21-19 ms
        Integer[] count = new Integer[800000];
        for (int i = 0; i < count.length; i++) {
            count[i] = new Random().nextInt(100);
        }
        Stream<Integer> stream = Stream.of(count);
//        Optional<Integer> max = stream.max((a, b) -> a - b);
        Optional<Integer> max = stream.max(Comparator.comparingInt(a -> a));
        System.out.println(max.get());

        int a = count[0];
        for (Integer integer : count) {
            a = Math.max(integer, a);
        }
        System.out.println(a);

    }

    @Test
    public void streamOperateDemo04() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integers = Arrays.asList(a);
        Stream<Integer> stream = integers.stream().filter(i -> {
            System.out.println("运行代码");
            return i % 2 == 0;
        });
        stream.forEach(s -> {
            int i = s;
            System.out.println(i);
        });
//        System.out.println(stream.findFirst().get());
    }

    @Test
    public void streamOperateDemo05() {
        Stream.iterate(1, x -> x + 1)
                .limit(20).skip(5)
                .limit(5).forEach(System.out::println);
    }
    @Test
    public void streamOperateDemo06() {
        String s = "11,22,33,44,55,66";
        IntStream stream = Stream.of(s.split(",")).mapToInt(Integer::parseInt);
        System.out.println(stream.sum());

    }


    private static long start;

    @BeforeAll
    static void init() {
        start = System.currentTimeMillis();
    }

    @AfterAll
    static void destroy() {
        System.out.println("执行时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
