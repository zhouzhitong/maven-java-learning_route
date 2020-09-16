package com.zzt.stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 描述：<br>Stream 相关操作
 * 1. 循环： forEach
 * 2. 计算：min、max、count、average
 * 3. 匹配： anyMatch、allMatch、noneMatch、findFirst、findAny
 * 4. 汇聚：reduce
 * 5. 收集器： toArray collect
 * </>
 * 一、 Stream的创建方式：
 * 1. 通过数组
 * 2. 集合
 * 3. Stream.generate方法来创建
 * 4. 通过 Stream.iterate方法创建
 * 5. 其他 API 创建：IntStream'
 *
 * 二、Stream特性：
 * 1. 不是数据结构，没有内部存储
 * 2. 不支持索引访问
 * 3. 延迟计算
 * 4. 支持并行操作
 * 5. 很容易生成数组或集合（List、Set）
 * 6. 支持过滤、查找、转换、汇总、聚合等操作。
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/16 9:30
 */
public class StreamDemo01 {
// 一、生成操作
    // 1. 通过数组
    @Test
    public void arrayGenerateTest01() {
        // 1. 通过数组
        String[] strs = {"A", "B", "D", "C"};
        Stream<String> stream = Stream.of(strs);
        stream.forEach(System.out::println);
    }

    // 2. 集合
    @Test
    public void collectionGenerateTest02() {
        // 2. 集合
        List<String> list = Arrays.asList("A", "B", "D", "C");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    // 3. Stream.generate方法来创建
    @Test
    public void streamGenerateTest03() {
        // 3. Stream.generate方法来创建
        Stream<Integer> generate = Stream.generate(() -> 1);
//        generate.forEach(System.out::println);
        generate.limit(4).forEach(System.out::println);
    }

    // 4. 通过 Stream.iterate方法创建
    @Test
    public void streamIterateTest04() {
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 1);
        iterate.forEach(System.out::println);
//        iterate.limit(5).forEach(System.out::println);
    }
    // 5. 其他 API 创建：IntStream'
    @Test
    public void streamOthersTest05() {
        String s = "ABCDEFG12";
        IntStream stream = s.chars();
        stream.forEach(a-> System.out.println((char) a));
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
