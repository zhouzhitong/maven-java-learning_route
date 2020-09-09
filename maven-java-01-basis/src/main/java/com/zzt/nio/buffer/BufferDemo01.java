package com.zzt.nio.buffer;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 描述：<br>
 * 说明：https://blog.csdn.net/First_Bal/article/details/108463263
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/8 10:51
 */
public class BufferDemo01 {

    @Test
    public void test01() {
        // 1. 准备好Buffer -- Buffer的容量
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 2. 准备数据
        String str = "6212261001100235339\n" +
                "360425199809012818\n" +
                "1. 基于Java EE技术的学校的问卷调查系统的设计与实现\n" +
                "2. 基于B/S架构的工厂物料管理系统的设计与实现";
        byteBuffer.put(str.getBytes());
        // 理论：str.getBytes().length = position
        System.out.println("验证写入的数据大小和position的关系：" + (str.getBytes().length) + " -- " + (byteBuffer.position()));
        System.out.println(byteBuffer.limit());
        // 3. 测试：开始读模式1
        byteBuffer.flip();
        byte[] bytes = new byte[20];
        // 第一次读取
        byteBuffer.get(bytes);
        System.out.println("读取结果：" + new String(bytes));
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        // 第二次读取
        byteBuffer.get(bytes);
        System.out.println("读取结果：" + new String(bytes));
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        byteBuffer.clear();
    }

    @Test
    public void test() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String str = "6212261001100235339\n" +
                "360425199809012818\n" +
                "1. 基于Java EE技术的学校的问卷调查系统的设计与实现\n" +
                "2. 基于B/S架构的工厂物料管理系统的设计与实现";
        byteBuffer.put(str.getBytes());
        int capacity = byteBuffer.capacity();
        System.out.println(capacity);
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        byteBuffer.flip();
        // byteBuffer.clear();
        System.out.println(capacity);
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        byte[] array = byteBuffer.array();
        String string = new String(array);
        System.out.println(string);
    }


}
